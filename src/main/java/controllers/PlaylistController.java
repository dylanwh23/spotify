/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import models.Playlist;
import persistences.PlaylistJpaController;

/**
 *
 * @author Machichu
 */
public class PlaylistController {
     PlaylistJpaController aux = new PlaylistJpaController();
    public void crearPlaylist(Playlist playlist) {
            try {
             aux.create(playlist);
         } catch (Exception ex) {
             Logger.getLogger(PlaylistController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
 
}
