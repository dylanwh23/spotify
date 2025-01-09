/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static java.lang.System.out;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import models.Album;
import models.Artista;
import models.Cancion;
import models.Cliente;
import models.LocalDateAdapter;
import models.Playlist;
import models.Usuario;
import models.UsuarioDTO;
import org.mindrot.jbcrypt.BCrypt;
import persistence.AlbumJpaController;
import persistence.CancionJpaController;
import persistence.ClienteJpaController;
import persistence.PlaylistJpaController;
import persistence.UsuarioJpaController;
import persistence.exceptions.NonexistentEntityException;
import persistence.exceptions.PreexistingEntityException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import models.LogSesion;
import javax.servlet.http.HttpServletRequest;
import models.Genero;
import persistence.LogSesionJpaController;

/*
import models.Artista;
import models.Cliente;
import models.Usuario;
 */

/**
 *
 * @author Machichu
 */
@WebService
public class UsuarioController implements IUsuarioController {
    
    

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
    LogSesionJpaController logController = new LogSesionJpaController(emf);
    PlaylistJpaController auxPlay = new PlaylistJpaController(emf);
    AlbumJpaController auxAlbum = new AlbumJpaController(emf);
    CancionJpaController auxCan = new CancionJpaController(emf);
    UsuarioJpaController usrController = new UsuarioJpaController(emf);
    ClienteJpaController auxCliente = new ClienteJpaController(emf);

    //  private ClienteJpaController cliente_ctr = new ClienteJpaController(emf);
    public List<String> obtenerNombresClientes() {
        EntityManager em = emf.createEntityManager();
        try {
            // Consulta para obtener solo los objetos de tipo Cliente
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

            return clientes.stream()
                    .map(cliente -> cliente.getNick())
                    .collect(Collectors.toList());
        } finally {
            em.close();
        }
        //     cliente_ctr.
    }

    public String tipoUsuario(String nick) {
        EntityManager em = emf.createEntityManager();
        return (String) em.createNativeQuery("Select tipo_usuario from usuario where nick='" + nick + "'").getSingleResult();
    }

    public Object[][] obtenerDatosCliente(String nick) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nick = :nick", Cliente.class).setParameter("nick", nick).getResultList();
            Object[][] data = new Object[clientes.size()][10];

            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);  // Obtener el cliente individual

                data[i][0] = cliente.getNick();     // Asignar valores al arreglo
                data[i][1] = cliente.getNombre();
                data[i][2] = cliente.getApellido();
                data[i][3] = cliente.getMail();
                data[i][4] = Fabrica.safeToString(cliente.getFecNac());
                data[i][5] = cliente.getImagen();
                data[i][6] = cliente.getEstado();
                data[i][7] = Fabrica.safeToString(cliente.getFechaSub());
                data[i][9] = cliente.getTipo();
                data[i][8] = cliente.getContraseñaHash();
                
            }
            return data;

        } finally {
            em.close();
        }
    }

    public Object[][] obtenerDatosClientes() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            Object[][] data = new Object[clientes.size()][6];

            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);  // Obtener el cliente individual

                // Asignar valores al arreglo
                data[i][0] = cliente.getNombre();
                data[i][1] = cliente.getNick();
            }
            return data;

        } finally {
            em.close();
        }
    }

    public void registroUsuario(String nickname, String nombre, String apellido, String mail, @XmlJavaTypeAdapter(LocalDateAdapter.class) LocalDate FecNac, String imagen, String biografia, String link, String tipo, String contraseña) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        Usuario usr;
        String contraseñaEncriptada;
        contraseñaEncriptada = hashPassword(contraseña);
        if (tipo.equals("artista")) {
            usr = new Artista(nickname, nombre, apellido, mail, FecNac, imagen, biografia, link, contraseñaEncriptada);
        } else {//si es cliente
            usr = new Cliente(nickname, nombre, apellido, mail, FecNac, imagen, contraseñaEncriptada);
        }
        try {
            aux.create(usr);
        } catch (PreexistingEntityException | RollbackException ex) {
            System.out.print(ex);
            throw ex;
        }
    }

    public void registrarPlaylistFavorita(String nick, String nombrePlaylist) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String playlistid = nombrePlaylist.trim();
        int indicePlay = playlistid.indexOf('-');
        String idPlayString = playlistid.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString);
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getPlaylistFavoritos().add(playlist);
        aux.edit(cliente);

    }

    public List<String> obtenerNombresDePlaylistsNoFavoritas(String clienteNick) {
        EntityManager em = emf.createEntityManager();
        UsuarioJpaController aux = new UsuarioJpaController(emf);

        Cliente cliente = (Cliente) aux.findUsuario(clienteNick);

        List<Integer> idsPlaylistsFavoritas = cliente.getPlaylistFavoritos().stream()
                .map(Playlist::getId)
                .collect(Collectors.toList());

        List<Playlist> playlistsNoFavoritas;
        if (idsPlaylistsFavoritas.isEmpty()) {
            playlistsNoFavoritas = auxPlay.findPlaylistEntities();
        } else {
            playlistsNoFavoritas = em.createQuery("SELECT p FROM Playlist p WHERE p.id NOT IN :ids", Playlist.class)
                    .setParameter("ids", idsPlaylistsFavoritas)
                    .getResultList();
        }

        return playlistsNoFavoritas.stream()
                .map(playlist -> playlist.getId() + " - " + playlist.getNombre())
                .collect(Collectors.toList());
    }

    public Object[][] obtenerDatosArtista(String nick) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Artista> artistas = em.createQuery("SELECT a FROM Artista a WHERE a.nick = :nick", Artista.class).setParameter("nick", nick).getResultList();
            Object[][] data = new Object[artistas.size()][9];

            for (int i = 0; i < artistas.size(); i++) {
                Artista artista = artistas.get(i);

                data[i][0] = artista.getNick();
                data[i][1] = artista.getNombre();
                data[i][2] = artista.getApellido();
                data[i][3] = artista.getMail();
                data[i][4] = Fabrica.safeToString(artista.getFecNac());
                data[i][5] = artista.getImagen();
                data[i][6] = artista.getBiografia();
                data[i][7] = artista.getDireccionWeb();
                data[i][8] = artista.getContraseñaHash();
            }
            return data;

        } finally {
            em.close();
        }
    }

    public Object[][] obtenerDatosArtistas() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Artista> artistas = em.createQuery("SELECT a FROM Artista a", Artista.class).getResultList();
            Object[][] data = new Object[artistas.size()][8];

            for (int i = 0; i < artistas.size(); i++) {
                Artista artista = artistas.get(i);

                data[i][0] = artista.getNombre();
                data[i][1] = artista.getNick();
            }
            return data;

        } finally {
            em.close();
        }
    }

    public String usuarioNombre(String nick) {
        Usuario art = usrController.findUsuario(nick);
        String nombre = art.getNombre();
        String apellido = art.getApellido();

        if (apellido == null || apellido.isEmpty()) {
            return nombre; // Retorna solo el nombre si no hay apellido
        } else {
            return nombre + " " + apellido; // Retorna nombre completo con un espacio
        }
    }

   public void eliminarUsuario(String nick) throws NonexistentEntityException {
    EntityManager em = emf.createEntityManager();
    // Obtener el Artista (Usuario en tu caso) a partir del nick
    Artista art = (Artista) usrController.findUsuario(nick);

    // Crear la consulta JPQL para obtener todos los álbumes del artista
    String jpql = "SELECT a FROM Album a WHERE a.artista.nick = :artistaId";

    // Ejecutar la consulta y obtener la lista de álbumes
    List<Album> albums = em.createQuery(jpql, Album.class)
                            .setParameter("artistaId", art.getNick())  // Usar el nick del artista
                            .getResultList();

    EntityTransaction transaction = em.getTransaction();
    try {
        transaction.begin();
        art = em.merge(art);  // Asegurarse de que el Artista esté gestionado

        for (Album album : albums) {
            album = em.merge(album);  // Asegurarse de que el Álbum esté gestionado

            // Eliminar las relaciones de la tabla intermedia entre álbum y canciones
            em.createNativeQuery(
                "DELETE FROM album_canciones WHERE album_id = ?"
            ).setParameter(1, album.getId()).executeUpdate();

            // Eliminar el álbum de los favoritos de los clientes
            em.createNativeQuery(
                "DELETE FROM cliente_albumesFavoritos WHERE album_id = ?"
            ).setParameter(1, album.getId()).executeUpdate();

            // Eliminar las canciones asociadas al álbum
            List<Cancion> canciones = album.getCanciones();
            for (Cancion cancion : canciones) {
                cancion = em.merge(cancion);  // Asegurarse de que la canción esté gestionada

                // Eliminar la canción de los favoritos de los clientes
                em.createNativeQuery(
                    "DELETE FROM cliente_cancionesFavoritas WHERE cancion_id = ?"
                ).setParameter(1, cancion.getId()).executeUpdate();  // Usar el índice de parámetro

                System.out.println("Eliminando canción: " + cancion.getNombre());
                em.remove(cancion);
            }

            System.out.println("Eliminando álbum: " + album.getNombre());
            em.remove(album);
        }

        // Eliminar las referencias al artista en las tablas de usuarios seguidos
        em.createNativeQuery(
                "DELETE FROM cliente_usuariosseguidos WHERE cliente_id = ?"
        ).setParameter(1, nick).executeUpdate();

        em.createNativeQuery(
                "DELETE FROM cliente_usuariosseguidos WHERE usuario_id = ?"
        ).setParameter(1, nick).executeUpdate();

        // Eliminar al Artista
        em.remove(art);

        // Commit de la transacción
        transaction.commit();
    } catch (RuntimeException e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        System.out.println("Error al eliminar: " + e.getMessage());
        e.printStackTrace();
    } finally {
        em.close();
    }
   }
    public void registrarAlbumFavorito(String nick, String nombreAlbum) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String albumid = nombreAlbum.trim();
        int indicePlay = albumid.indexOf('-');
        String idAlbumString = albumid.substring(0, indicePlay).trim();
        int idAlbum = Integer.parseInt(idAlbumString);
        Album album = auxAlbum.findAlbum(idAlbum);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getAlbumesFavoritos().add(album);
        aux.edit(cliente);

    }

    public void registrarAlbumFavoritoWeb(String nick, int id) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);

        int idAlbum = id;
        Album album = auxAlbum.findAlbum(idAlbum);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getAlbumesFavoritos().add(album);
        aux.edit(cliente);

    }

    public void registrarCancionFavorita(String nick, String nombreCancion) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String cancionid = nombreCancion.trim();
        int indicePlay = cancionid.indexOf('-');
        String idPlayString = cancionid.substring(0, indicePlay).trim();
        int idCancion = Integer.parseInt(idPlayString);
        Cancion cancion = auxCan.findCancion(idCancion);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getCancionesFavoritas().add(cancion);
        aux.edit(cliente);

    }

    public void eliminarCancionFavorita(String nick, String nombreCancion) throws Exception {

        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String cancionid = nombreCancion.trim();
        int indicePlay = cancionid.indexOf('-');
        String idPlayString = cancionid.substring(0, indicePlay).trim();
        int idCancion = Integer.parseInt(idPlayString);
        Cancion cancion = auxCan.findCancion(idCancion);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getCancionesFavoritas().remove(cancion);
        aux.edit(cliente);
    }

    public void eliminarAlbumFavorito(String nick, String nombreAlbum) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String albumid = nombreAlbum.trim();
        int indicePlay = albumid.indexOf('-');
        String idAlbumString = albumid.substring(0, indicePlay).trim();
        int idAlbum = Integer.parseInt(idAlbumString);
        Album album = auxAlbum.findAlbum(idAlbum);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getAlbumesFavoritos().remove(album);
        aux.edit(cliente);

    }

    public void eliminarAlbumFavoritoWeb(String nick, int id) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        int idAlbum = id;
        Album album = auxAlbum.findAlbum(idAlbum);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getAlbumesFavoritos().remove(album);
        aux.edit(cliente);

    }

    public List<String> obtenerNicknamesseguidos(String usuario) throws Exception {
        List<String> aux = null;
        ClienteJpaController jpa = new ClienteJpaController(emf);
        Query query = jpa.getEntityManager().createNativeQuery("Select usuario_id from cliente_usuariosSeguidos where cliente_id ='" + usuario + "'");
        return query.getResultList();
    }

    public List<String> obtenerNicknamesseguidores(String usuario) throws Exception {
        List<String> aux = null;
        ClienteJpaController jpa = new ClienteJpaController(emf);
        Query query = jpa.getEntityManager().createNativeQuery("Select cliente_id from cliente_usuariosSeguidos where usuario_id ='" + usuario + "'");
        return query.getResultList();
    }

    public List<String> obtenerNicknamesDisponiblesASeguir(String usuario, List<String> usuariosSeguidos) throws Exception {

        ClienteJpaController jpa = new ClienteJpaController(emf);
        String jpql = "";
        TypedQuery<String> query = null;

        if (usuariosSeguidos.isEmpty()) {
            jpql = "SELECT u.nick FROM Usuario u";
            query = jpa.getEntityManager().createQuery(jpql, String.class);
        } else {
            jpql = "SELECT u.nick FROM Usuario u WHERE u.nick NOT IN :nickExlcuidos";
            query = jpa.getEntityManager().createQuery(jpql, String.class).setParameter("nickExlcuidos", usuariosSeguidos);;
        }
        return query.getResultList();
    }

    public void seguirUsuario(String usuario, String usuarioASeguir) throws Exception {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            String sql = "INSERT INTO cliente_usuariosSeguidos (cliente_id, usuario_id) VALUES (?, ?)";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, usuario);
            query.setParameter(2, usuarioASeguir);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            out.println("No Anda");
        }
    }

    public void dejarSeguirUsuario(String usuario, String usuarioADejarDeSeguir) throws Exception {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            String sql = "Delete from cliente_usuariosSeguidos where cliente_id ='" + usuario + "' and usuario_id = '" + usuarioADejarDeSeguir + "'";
            Query query = em.createNativeQuery(sql);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            out.println("No Anda");
        }
    }

    public void eliminarPlaylistFavorita(String nick, String nombrePlaylist) throws Exception {
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        String playlistid = nombrePlaylist.trim();
        int indicePlay = playlistid.indexOf('-');
        String idPlayString = playlistid.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString);
        Cliente cliente = (Cliente) aux.findUsuario(nick);

        List<Playlist> playlistsFavoritas = cliente.getPlaylistFavoritos();

        Iterator<Playlist> iterator = playlistsFavoritas.iterator();

        while (iterator.hasNext()) {
            Playlist playlist = iterator.next();

            if (playlist.getId() == idPlaylist) {
                iterator.remove();
                break;
            }
        }

        aux.edit(cliente);
    }

    public List<String> obtenerNombresArtistas() {
        EntityManager em = emf.createEntityManager();
        try {

            List<Artista> artistas = em.createQuery("SELECT a FROM Artista a", Artista.class).getResultList();

            return artistas.stream()
                    .map(artista -> artista.getNick())
                    .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    public Boolean inicioSesion(String nick, String password) {
        EntityManager em = emf.createEntityManager();
        Usuario usr = null;
        usr = em.find(Usuario.class, nick); //si no busca por nick
        return usr != null && checkPassword(password, usr.getContraseña());
    }

    public String getNickPorMail(String mail) {
        EntityManager em = emf.createEntityManager();
        String nick;
        try {
            nick = em.createQuery("SELECT u.nick FROM Usuario u WHERE u.mail = :mail", String.class).
                    setParameter("mail", mail).
                    getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return nick;
    }

    public boolean esCliente(String nickname) {
        if (auxCliente.findCliente(nickname) instanceof Cliente) {
            return true;
        } else {
            return false;
        }
    }

//encriptar pw
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    //obtener datos del usuario almacenables en la sesion
    public List<String> getDatosUsuario(String nick) {
        EntityManager em = emf.createEntityManager();
        UsuarioDTO usuario = new UsuarioDTO();
        try {
            Usuario aux = new Usuario();
            aux = usrController.findUsuario(nick);
            List<String> datos = new ArrayList<>();
            datos.add(aux.getNick());
            datos.add(aux.getImagen());
            datos.add(aux.getMail());
            datos.add(aux.getApellido());
            datos.add(aux.getNombre());
            datos.add(Fabrica.safeToString(aux.getFechaNacimiento()));
            if (esCliente(datos.get(0))) {
                datos.add("Cliente");
            } else {
                datos.add("Artista");
            }
            return datos;

            /*
        usuario.setNick(Fabrica.safeToString(datosSql[0]));
        System.out.println(usuario.getNick());
        usuario.setApellido(Fabrica.safeToString(datosSql[1]));
        System.out.println(usuario.getFechaNacimiento());
        usuario.setFechaNacimiento(Fabrica.safeToString(datosSql[2]));
        System.out.println(usuario.getFechaNacimiento());
        usuario.setImagen(Fabrica.safeToString(datosSql[3]));
        System.out.println(usuario.getImagen());
        usuario.setMail(Fabrica.safeToString(datosSql[4]));
        System.out.println(usuario.getMail());
        usuario.setNombre(Fabrica.safeToString(datosSql[5]));
        System.out.println(usuario.getNombre());
        usuario.setTipoUsuario(Fabrica.safeToString(datosSql[6]));
        System.out.println(usuario.getTipoUsuario());
             */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    public String artistaNombre(String nick) {
        Artista art = (Artista) usrController.findUsuario(nick);
        String nombre = art.getNombre();
        String apellido = art.getApellido();

        if (apellido == null || apellido.isEmpty()) {
            return nombre; // Retorna solo el nombre si no hay apellido
        } else {
            return nombre + " " + apellido; // Retorna nombre completo con un espacio
        }

    }

    public void CambiarEstadosubscripcion(String nick, String estado, Integer tipo) throws Exception {
        // 1. Busca al cliente por su nick
        LocalDate fecha = LocalDate.now();
        String host = "smtp.gmail.com";
        final String user = "spotifycure2024@gmail.com"; // Tu correo de Gmail
        final String password = "qifzqwldaxbnqlmw"; // Contraseña de aplicación de Gmail

        Object[][] usr = obtenerDatosCliente(nick);

        String destinatario = (String) usr[0][3]; // Correo del usuario
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            String asunto = "Actualización de Suscripción en Spotify Cure";
            String mensaje = "Hola " + nick + ",\n\n"
                    + "Tu suscripción ha sido actualizada exitosamente.\n"
                    + "Estado: " + estado + "\n"
                    + "Fecha de actualización: " + fecha + "\n\n"
                    + "Gracias por usar Spotify Cure.";

            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);

        } catch (Exception ex) {
            System.out.print(ex);
        } finally {
            Cliente cliente = (Cliente) usrController.findUsuario(nick);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            System.out.println(fecha);
            if (cliente == null) {
                throw new Exception("Cliente no encontrado con nick: " + nick);
            }

            boolean cambios = false;

            // 2. Actualiza los campos solo si hay cambios
            if (estado != null && !estado.equals(cliente.getEstado())) {
                cliente.setEstado(estado);
                cambios = true;
            }
            if (tipo != null && !tipo.equals(cliente.getTipo())) {
                cliente.setTipo(tipo);
                cambios = true;
            }
            if (fecha != null && !fecha.equals(cliente.getFechaSub())) {
                cliente.setFecSub(fecha);
                cambios = true;
            }

            // 3. Solo persiste si hubo cambios
            if (cambios) {
                usrController.edit(cliente);  // Verifica que este método use merge() correctamente.
            }
        }

    }
    
      public boolean autenticarUsuario(String ip, String url, String navegador, String sistemaOperativo) {
        EntityManager em = emf.createEntityManager();
        LogSesion log = new LogSesion(ip, url, navegador, sistemaOperativo);
        
        
        logController.create(log);
        return true;
       
    }   

public Object[][] obtenerRegistrosAcceso() {
    EntityManager em = emf.createEntityManager();
    try {
        // Obtén todos los usuarios con sus registros de acceso
        List<LogSesion> logs = logController.findLogSesionEntities();
        // Contamos el total de accesos
        

        // Creamos la matriz para los datos
        Object[][] datos = new Object[logs.size()][6];

        // Rellenamos la matriz con los datos
        int index = 0;
        for (LogSesion log : logs) {
            
            List<String> ips = new ArrayList(); ips.add(log.getIpUsuario());
            List<String> urls = new ArrayList(); urls.add(log.getUrl());
            List<String> navegadores = new ArrayList(); navegadores.add(log.getNavegador());
            List<String> sistemasOperativos = new ArrayList(); sistemasOperativos.add(log.getSistemaOperativo());

            for (int i = 0; i < logs.size(); i++) {
               
                datos[index][0] = ips.get(i);                      // IP
                datos[index][1] = urls.get(i);                     // URL
                datos[index][2] = navegadores.get(i);              // Navegador
                datos[index][3] = sistemasOperativos.get(i);       // Sistema Operativo
                index++;
            }
        }

        return datos;
    } finally {
        em.close();
    }
}


}

    

