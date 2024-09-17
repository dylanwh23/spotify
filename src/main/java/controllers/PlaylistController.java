

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Cliente;	
import models.Cancion;
import models.Genero;
import models.Playlist;
import models.PlaylistParticular;
import models.PlaylistPorDefecto;
import persistences.CancionJpaController;
import persistences.GeneroJpaController;
import persistences.PlaylistJpaController;
import persistences.ClienteJpaController;

/**
 *
 * @author Machichu
 */
public class PlaylistController {
     PlaylistJpaController auxPlay = new PlaylistJpaController();
     GeneroJpaController auxGen = new GeneroJpaController();
     CancionJpaController auxCan = new CancionJpaController();
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
     ClienteJpaController usr_ctr = new ClienteJpaController(emf);
     
     
    public void crearPlaylistPorDefecto(String nombre ,String genero,String rutaImagen){
            PlaylistPorDefecto playlist = new PlaylistPorDefecto();
            playlist.setGenero(auxGen.findGenero(genero));
            playlist.setNombre(nombre);
            playlist.setRutaImagen(rutaImagen);
        try {
             auxPlay.create(playlist);
            } 
            catch (Exception ex) {
             Logger.getLogger(PlaylistController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void crearPlaylistParticular(String Nombre, String rutaImagen, String nick_usuario) {
        Cliente el_usr = usr_ctr.findCliente(nick_usuario);
        PlaylistParticular la_nueva_lista = new PlaylistParticular(true, Nombre, rutaImagen, new LinkedList<Cancion>(), el_usr);
        try {
            auxPlay.create(la_nueva_lista);
            //usr_ctr.edit(el_usr);
            //no se necesita
        } catch (Exception ex) {
            Logger.getLogger(PlaylistController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public Object[][] obtenerPlaylistLista() {
        List<Playlist> playlists = auxPlay.findPlaylistEntities();
        Object[][] data = new Object[playlists.size()][6]; 

        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);

            // Si Playlist tiene subclases, puedes hacer un check del tipo
            if (playlist instanceof PlaylistPorDefecto) {
                PlaylistPorDefecto PlaylistPorDefecto = (PlaylistPorDefecto) playlist;
                data[i][0] = PlaylistPorDefecto.getId();
                data[i][1] = PlaylistPorDefecto.getNombre();
                data[i][2] = PlaylistPorDefecto.getRutaImagen();
                data[i][3] = "Por Defecto";
                data[i][4] = "";
                data[i][5] = (PlaylistPorDefecto.getGenero().getNombre());
                
            } else if (playlist instanceof PlaylistParticular) {
                PlaylistParticular PlaylistParticular = (PlaylistParticular) playlist;     
                data[i][0] = PlaylistParticular.getId();
                data[i][1] = PlaylistParticular.getNombre();
                data[i][2] = PlaylistParticular.getRutaImagen();
                data[i][3] = "Particular";
                data[i][4] = PlaylistParticular.getPrivada();
            } else {
                
                data[i][0] = playlist.getId();
                data[i][1] = playlist.getNombre();
                data[i][2] = playlist.getRutaImagen();
                data[i][3] = "???";
                
            }
        }

        return data;
    }
    public Object[][] obtenerDatosPlaylistGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Playlist> playlists = em.createQuery("SELECT p FROM PlaylistPorDefecto p WHERE p.genero.nombre = :generoNombre", Playlist.class).setParameter("generoNombre", genero).getResultList();
            Object[][] data = new Object[playlists.size()][6];

            for (int i = 0; i < playlists.size(); i++) {
                Playlist playlist = playlists.get(i);

                // Si Playlist tiene subclases, puedes hacer un check del tipo
                if (playlist instanceof PlaylistPorDefecto) {
                    PlaylistPorDefecto PlaylistPorDefecto = (PlaylistPorDefecto) playlist;
                    data[i][0] = PlaylistPorDefecto.getId();
                    data[i][1] = PlaylistPorDefecto.getNombre();
                    data[i][2] = PlaylistPorDefecto.getRutaImagen();
                    data[i][3] = "Por Defecto";
                    data[i][4] = (PlaylistPorDefecto.getGenero().getNombre());
                }
            }
            return data;

        } finally {
            em.close();
        }
    }
    public Object[][] obtenerDatosPlaylistCliente(String nick) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Playlist> playlists = em.createQuery("SELECT p FROM PlaylistParticular p WHERE p.Propietario.nick = :nick", Playlist.class).setParameter("nick", nick).getResultList();
            Object[][] data = new Object[playlists.size()][6];
            for (int i = 0; i < playlists.size(); i++) {
                Playlist playlist = playlists.get(i);
                if (playlist instanceof PlaylistParticular) {
                    PlaylistParticular PlaylistParticular = (PlaylistParticular) playlist;
                    data[i][0] = PlaylistParticular.getId();
                    data[i][1] = PlaylistParticular.getNombre();
                    data[i][2] = PlaylistParticular.getRutaImagen();
                    data[i][3] = "Particular";
                    data[i][4] = PlaylistParticular.getPrivada();
                }
            }
            return data;

        } finally {
            em.close();
        }
    }
    
    public void crearPlaylist(Playlist playlist) {
        auxPlay.create(playlist);
    }

    public Object[][] obtenerDatosPlaylist(int id) {
        // Obtener la playlist por ID
        Playlist playlist = auxPlay.findPlaylist(id);

        if (playlist == null) {
            return new Object[0][0]; // Si no se encuentra la playlist, devolver una matriz vacía
        }
        List<Cancion> canciones = playlist.getCanciones();
        Object[][] datos = new Object[canciones.size()][5];

        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            datos[i][0] = cancion.getId();
            datos[i][1] = cancion.getNombre();
            datos[i][2] = cancion.getDuracion();
        }
        return datos;
    }
    public List<String> obtenerNombresPlaylistPorDefecto() {
        List<Playlist> playlists = auxPlay.findPlaylistEntities();
        return playlists.stream()
                .filter(playlist -> playlist instanceof PlaylistPorDefecto) // Filtrar por el tipo de playlist
                .map(playlist -> playlist.getId()+ " - " + playlist.getNombre()) // Obtener solo el nombre
                .collect(Collectors.toList());
    }

    public List<String> obtenerNombresPlaylistParticularCliente(String nick) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Playlist> playlists = em.createQuery("SELECT p FROM PlaylistParticular p WHERE p.Propietario.nick = :nick", Playlist.class).setParameter("nick", nick).getResultList();
            return playlists.stream()
                    .filter(playlist -> playlist instanceof PlaylistParticular) // Filtrar solo las playlists particulares
                    .map(playlist -> playlist.getId()+ " - " + playlist.getNombre())
                    .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    public void crearRelacionPlaylistCancion( String stringPlaylist, String stringCancion) throws Exception {
        stringPlaylist = stringPlaylist.trim();
        int indicePlay = stringPlaylist.indexOf('-');
        String idPlayString = stringPlaylist.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString); 
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        stringCancion = stringCancion.trim();
        int indiceCan = stringCancion.indexOf('-');
        String idCanString = stringCancion.substring(0, indiceCan).trim();
        int idCancion = Integer.parseInt(idCanString); 
        playlist.getCanciones().add(auxCan.findCancion(idCancion));
        auxPlay.edit(playlist);
    }

    public List<String> obtenerNombresPlaylistCanciones(String stringPlaylist) {
        stringPlaylist = stringPlaylist.trim();
        int indicePlay = stringPlaylist.indexOf('-');
        String idPlayString = stringPlaylist.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString); 
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        List<Cancion> canciones = playlist.getCanciones();
        return canciones.stream()
                           .map(cancion -> cancion.getId()+" - "+cancion.getNombre())
                           .collect(Collectors.toList());
    }

    public void borrarRelacionPlaylistCancion(String stringPlaylist, String stringCancion) throws Exception {
        stringPlaylist = stringPlaylist.trim();
        int indicePlay = stringPlaylist.indexOf('-');
        String idPlayString = stringPlaylist.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString); 
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        
        stringCancion = stringCancion.trim();
        int indiceCan = stringCancion.indexOf('-');
        String idCanString = stringCancion.substring(0, indiceCan).trim();
        int idCancion = Integer.parseInt(idCanString); 
        
        playlist.getCanciones().remove(auxCan.findCancion(idCancion));
        auxPlay.edit(playlist);
    }

    public List<String> obtenerNombresDeCancionesNoPresentesPlaylist(String stringPlaylist) {
        EntityManager em = emf.createEntityManager();
        stringPlaylist = stringPlaylist.trim();
        int indicePlay = stringPlaylist.indexOf('-');
        String idPlayString = stringPlaylist.substring(0, indicePlay).trim();
        int idPlaylist = Integer.parseInt(idPlayString);
        Playlist playlist = auxPlay.findPlaylist(idPlaylist);
        List<Integer> idsCancionesEnPlaylist = playlist.getCanciones().stream()
                .map(Cancion::getId)
                .collect(Collectors.toList());
        List<Cancion> canciones;
        if (idsCancionesEnPlaylist.isEmpty()) {
            canciones = auxCan.findCancionEntities();
        } else {
            canciones = em.createQuery("SELECT c FROM Cancion c WHERE c.id NOT IN :ids", Cancion.class).setParameter("ids", idsCancionesEnPlaylist).getResultList();;
        }
        return canciones.stream()
                .map(cancion -> cancion.getId() + " - " + cancion.getNombre())
                .collect(Collectors.toList());
    }
    
    
   public List<String> obtenerNombresPlaylists() {
    List<Playlist> playlists = auxPlay.findPlaylistEntities();
    return playlists.stream()
                    .map(playlist -> playlist.getNombre())
                    .collect(Collectors.toList());
}

    public List<String> obtenerNombresPlaylistPublicas() {
     EntityManager em = emf.createEntityManager();
        try {
           List<PlaylistParticular> playlists = em.createQuery("SELECT p FROM PlaylistParticular p WHERE p.privada = false", PlaylistParticular.class).getResultList();
            return playlists.stream()
                    .filter(playlist -> playlist instanceof PlaylistParticular) // Filtrar solo las playlists particulares
                    .map(playlist -> playlist.getId()+ " - " + playlist.getNombre())
                    .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

  
public List<String> obtenerNombresDePlaylistsFavoritas(String clienteNick) {
    // Busca al cliente por su nick
    Cliente cliente = usr_ctr.findCliente(clienteNick);

    // Si no se encuentra el cliente, retorna una lista vacía
    if (cliente == null) {
        return new ArrayList<>();
    }

    // Obtener las playlists favoritas del cliente
    List<Playlist> playlistsFavoritas = cliente.getPlaylistFavoritos();

    // Mapear las playlists favoritas a una lista de nombres
    return playlistsFavoritas.stream()
            .map(playlist -> playlist.getId() + " - " + playlist.getNombre())
            .collect(Collectors.toList());
}

  
   
    
}
