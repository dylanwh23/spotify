/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistences.AlbumJpaController;
import persistences.CancionJpaController;
import persistences.ClienteJpaController;
import persistences.GeneroJpaController;
import persistences.PlaylistJpaController;
import persistences.UsuarioJpaController;

/**
 *
 * @author dylan
 */
public class Fabrica {

    private static Fabrica instancia;
    private EntityManagerFactory emf;
    private Fabrica() {
        this.emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
    };
    
    

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IUsuarioController getIUsuarioController() {
        return new UsuarioController();
    }
    
    public IGeneroController getIGeneroController(){
        return new GeneroController();
    }
    
    public ICancionController getICancionController(){
        return new CancionController();
    }
     
    public IAlbumController getIAlbumController(){
        return new AlbumController();
    }
    
    public IPlaylistController getIPlaylistController(){
        return new PlaylistController();
    }

    CancionJpaController getCancionJpaController() {
        return new CancionJpaController();
    }

    AlbumJpaController getAlbumJpaController() {
        return new AlbumJpaController();
    }

    UsuarioJpaController getUsuarioJpaController() {
        return new UsuarioJpaController(emf);
    }

    GeneroJpaController getGeneroJpaController() {
        return new GeneroJpaController();
    }

    PlaylistJpaController getPlaylistJpaController() {
        return new PlaylistJpaController();
    }

    ClienteJpaController getClienteJpaController() {
        return new ClienteJpaController();
    }

    EntityManagerFactory getEntityManagerFactory() {
        return  this.emf;
    }
    
    
}
