/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Album;
import models.Artista;
import models.Cancion;
import models.Cliente;
import models.Playlist;
import models.Usuario;
import persistences.AlbumJpaController;
import persistences.ArtistaJpaController;
import persistences.CancionJpaController;
import persistences.ClienteJpaController;
import persistences.PlaylistJpaController;
import persistences.UsuarioJpaController;
/*
import models.Artista;
import models.Cliente;
import models.Usuario;
*/

/**
 *
 * @author Machichu
 */
public class UsuarioController implements IUsuarioController{
    PlaylistJpaController auxPlay = new PlaylistJpaController();
    AlbumJpaController auxAlbum = new AlbumJpaController();
    CancionJpaController auxCan = new CancionJpaController();

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
     
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
    }
    


public Object[][] obtenerDatosCliente(String nick) {
    EntityManager em = emf.createEntityManager();
    try {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nick = :nick", Cliente.class).setParameter("nick", nick).getResultList();
        Object[][] data = new Object[clientes.size()][6];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);  // Obtener el cliente individual

            data[i][0] = cliente.getNick();     // Asignar valores al arreglo
            data[i][1] = cliente.getNombre();
            data[i][2] = cliente.getApellido();
            data[i][3] = cliente.getMail();
            data[i][4] = cliente.getFecNac();
            data[i][5] = cliente.getImagen();
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


public void registroUsuario(String nickname, String nombre, String apellido, String mail, LocalDate FecNac, String imagen, String biografia, String link, String tipo) throws Exception{
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        Usuario usr;
        if(tipo == "Artista"){
            usr = new Artista(nickname, nombre, apellido, mail, FecNac, imagen, biografia, link);
        }else{//si es cliente
            usr = new Cliente(nickname, nombre, apellido, mail, FecNac, imagen);
        }
        try{
            aux.create(usr);
        }catch(Exception ex){
            System.out.print(ex);
            throw ex;
        }
     }


public void registrarPlaylistFavorita(String nick, String nombrePlaylist) throws Exception{
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
    // Encuentra al cliente por su nick
    Cliente cliente = (Cliente) aux.findUsuario(clienteNick);

    // Obtén los IDs de las playlists favoritas del cliente
    List<Integer> idsPlaylistsFavoritas = cliente.getPlaylistFavoritos().stream()
            .map(Playlist::getId)
            .collect(Collectors.toList());

    // Encuentra todas las playlists que no están en los favoritos del cliente
    List<Playlist> playlistsNoFavoritas;
    if (idsPlaylistsFavoritas.isEmpty()) {
        playlistsNoFavoritas = auxPlay.findPlaylistEntities(); // Si no hay favoritas, devuelve todas las playlists
    } else {
        playlistsNoFavoritas = em.createQuery("SELECT p FROM Playlist p WHERE p.id NOT IN :ids", Playlist.class)
                .setParameter("ids", idsPlaylistsFavoritas)
                .getResultList();
    }

    // Retorna los nombres de las playlists no favoritas
    return playlistsNoFavoritas.stream()
            .map(playlist -> playlist.getId() + " - " + playlist.getNombre())
            .collect(Collectors.toList());
}


public Object[][] obtenerDatosArtista(String nick) {
    EntityManager em = emf.createEntityManager();
    try {
        List<Artista> artistas = em.createQuery("SELECT a FROM Artista a WHERE a.nick = :nick", Artista.class).setParameter("nick", nick).getResultList();
        Object[][] data = new Object[artistas.size()][8];

        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);  // Obtener el cliente individual

            data[i][0] = artista.getNick();     // Asignar valores al arreglo
            data[i][1] = artista.getNombre();
            data[i][2] = artista.getApellido();
            data[i][3] = artista.getMail();
            data[i][4] = artista.getFecNac();
            data[i][5] = artista.getImagen();
            data[i][6] = artista.getBiografia();
            data[i][7] = artista.getDireccionWeb();
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
            Artista artista = artistas.get(i);  // Obtener el cliente individual

                 // Asignar valores al arreglo
            data[i][0] = artista.getNombre();
            data[i][1] = artista.getNick();
        }
        return data;

    } finally {
        em.close();
    }
}


public void registrarAlbumFavorito(String nick, String nombreAlbum) throws Exception{
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

public void registrarCancionFavorita(String nick, String nombreCancion) throws Exception{
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

public void eliminarCancionFavorita(String nick, String nombreCancion)throws Exception{

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


public void eliminarAlbumFavorito(String nick, String nombreAlbum) throws Exception{
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

public List<String> obtenerNicknamesseguidos(String usuario) throws Exception{
    List<String> aux = null;
    ClienteJpaController jpa = new ClienteJpaController(emf);
    Query query = jpa.getEntityManager().createNativeQuery("Select usuario_id from cliente_usuariosseguidos where cliente_id ='"+usuario+"'");
    return query.getResultList();
}

public List<String> obtenerNicknamesDisponiblesASeguir(String usuario, List<String> usuariosSeguidos) throws Exception{
   
    ClienteJpaController jpa = new ClienteJpaController(emf);
    String jpql = "";
    TypedQuery<String> query = null;
    
    if(usuariosSeguidos.isEmpty()){
        jpql = "SELECT u.nick FROM Usuario u";
        query = jpa.getEntityManager().createQuery(jpql, String.class);
    }else{
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
            
            String sql = "INSERT INTO cliente_usuariosseguidos (cliente_id, usuario_id) VALUES (?, ?)";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, usuario);
            query.setParameter(2, usuarioASeguir);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
public void dejarSeguirUsuario(String usuario, String usuarioADejarDeSeguir) throws Exception {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {        
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            
            String sql = "Delete from cliente_usuariosseguidos where cliente_id ='"+usuario+"' and usuario_id = '"+usuarioADejarDeSeguir+"'";
            Query query = em.createNativeQuery(sql);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
public void eliminarPlaylistFavorita(String nick, String nombrePlaylist) throws Exception{
    UsuarioJpaController aux = new UsuarioJpaController(emf);
    String playlistid = nombrePlaylist.trim();
        int indicePlay = playlistid.indexOf('-');
        String idPlayString = playlistid.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString); 
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        Cliente cliente = (Cliente) aux.findUsuario(nick);
        cliente.getPlaylistFavoritos().remove(playlist);
        aux.edit(cliente);
}
}



