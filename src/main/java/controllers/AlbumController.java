/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.IAlbumController;
import java.util.ArrayList;
import models.Album;
import persistences.AlbumJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Persistence;
import models.Artista;
import models.Cancion;
import models.Genero;
import persistences.ArtistaJpaController;
import persistences.ClienteJpaController;
import persistences.GeneroJpaController;
/**
 *
 * @author Machichu
 */
public class AlbumController implements IAlbumController {
 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
 ArtistaJpaController usr_ctr = new ArtistaJpaController(emf);
 AlbumJpaController auxAL = new AlbumJpaController();
 GeneroJpaController auxG = new GeneroJpaController();
    public AlbumController() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    public boolean registrarAlbum(String nombre) {
//        Album A = new Album();
//        A.setNombre(nombre);
//        
//        try {
//            aux.create(A);
//            return true;
//        } catch (Exception ex) {
//            
//            return false;
//        }
//    }




    //private EntityManagerFactory emf;

    public AlbumController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Función que buscará al artista por su nombre, sin modificar el ArtistaJpaController
    public boolean buscarArtista(String nombreA) {
        EntityManager em = getEntityManager();
        try {
            
            TypedQuery<Artista> query = em.createQuery("SELECT a FROM Artista a WHERE a.nombre = :nombre", Artista.class);
            query.setParameter("nombre", nombreA);
            
            
            List<Artista> resultados = query.getResultList();
            
            
            return !resultados.isEmpty();
        } finally {
            em.close();
        }
    }


public boolean buscarAlbum(String nombreAl) {
    EntityManager em = getEntityManager();
    try {
       
        TypedQuery<Album> query = em.createQuery("SELECT a FROM Album a WHERE a.nombre = :nombre", Album.class);
        query.setParameter("nombre", nombreAl);
        
      
        List<Album> resultados = query.getResultList();
        return !resultados.isEmpty();  
    } catch (Exception e) {
        System.out.println("Error al buscar el álbum: " + e.getMessage());
        return false;  
    } finally {
        em.close();
    }
}


public boolean registrarAlbum(String nombre, int anio,List<Genero> generos) {
        Album al = new Album();
        al.setNombre(nombre);
        al.setAnioo(anio);
        al.setGeneros(generos);
    
        try {
            auxAL.create(al);
            return true;
        } catch (Exception ex) {
            //Logger.getLogger(GeneroController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

public List<String> obtenerNombresAlbums() {
    List<Album> albums = auxAL.findAlbumEntities();
    return albums.stream()
                 .map(album -> album.getNombre())
                 .collect(Collectors.toList());
}

    public void CrearAlbum(String text, int parseInt, String strArtista, List<Cancion> canciones, List<String> generos) {
        Artista artista = usr_ctr.findArtista(strArtista);
        List<Genero> generosSeleccionados = new ArrayList<>();
        for (String nombre : generos) {
            Genero genero = auxG.findGenero(nombre); // Método que busca el Genero por su nombre
            if (genero != null) {
                generosSeleccionados.add(genero); // Añadir a la lista si se encontró
            }
        }
        Album album = new Album(text, parseInt, artista, generosSeleccionados, canciones);
        auxAL.create(album);
    }

}
