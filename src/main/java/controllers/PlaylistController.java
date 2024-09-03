/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Cancion;
import models.Genero;
import models.Playlist;
import models.PlaylistParticular;
import models.PlaylistPorDefecto;
import persistences.GeneroJpaController;
import persistences.PlaylistJpaController;

/**
 *
 * @author Machichu
 */
public class PlaylistController {
     PlaylistJpaController aux = new PlaylistJpaController();
     GeneroJpaController auxGen = new GeneroJpaController();
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
    public void crearPlaylistPorDefecto(String nombre ,String genero,String rutaImagen){
            PlaylistPorDefecto playlist = new PlaylistPorDefecto();
            playlist.setGenero(auxGen.findGenero(genero));
            playlist.setNombre(nombre);
            
            playlist.setRutaImagen(rutaImagen);
        try {
             aux.create(playlist);
            } 
            catch (Exception ex) {
             Logger.getLogger(PlaylistController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void crearPlaylistParticular(String text, String text0, String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object[][] obtenerPlaylistLista() {
        List<Playlist> playlists = aux.findPlaylistEntities();
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
    public Object[][] obtenerDatosPlaylistCliente(String cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Playlist> playlists = em.createQuery("SELECT p FROM PlaylistPorDefecto p ", Playlist.class).setParameter("generoNombre", cliente).getResultList();
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
        aux.create(playlist);
    }

    public Object[][] obtenerDatosPlaylist(int id) {
         // Obtener la playlist por ID
    Playlist playlist = aux.findPlaylist(id);
    
    if (playlist == null) {
        return new Object[0][0]; // Si no se encuentra la playlist, devolver una matriz vacía
    }
    LinkedList<Cancion> canciones = playlist.getCanciones(); 
    Object[][] datos = new Object[canciones.size()][5];

    for (int i = 0; i < canciones.size(); i++) {
        Cancion cancion = canciones.get(i);
        datos[i][0] = cancion.getId();        
        datos[i][1] = cancion.getNombre();    
        datos[i][2] = cancion.getDuracion(); 
    }
    return datos;
    }
}
