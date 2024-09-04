/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cancion;
import models.Playlist;
import models.PlaylistPorDefecto;
import models.PlaylistParticular;
import models.Cliente;

import persistences.GeneroJpaController;
import persistences.PlaylistJpaController;
import persistences.ClienteJpaController;

/**
 *
 * @author Machichu
 */
public class PlaylistController {
     PlaylistJpaController aux = new PlaylistJpaController();
     GeneroJpaController auxGen = new GeneroJpaController();
     ClienteJpaController usr_ctr = new ClienteJpaController();
	

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

    public void crearPlaylistParticular(String Nombre, String rutaImagen, String nick_usuario) {
	    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/
	Cliente el_usr = usr_ctr.findCliente(nick_usuario);
PlaylistParticular la_nueva_lista = new PlaylistParticular(true, Nombre, rutaImagen, new LinkedList<Cancion>(),el_usr);
	try{
	aux.create(la_nueva_lista);
	usr_ctr.edit(el_usr);
	} catch(Exception ex){
		Logger.getLogger(PlaylistController.class.getName()).log(Level.SEVERE,null,ex);
	}
    }
 
}
