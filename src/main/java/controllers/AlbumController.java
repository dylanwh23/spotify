/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Album;
import persistences.AlbumJpaController;

/**
 *
 * @author Machichu
 */
public class AlbumController implements IAlbumController {

    AlbumJpaController aux = new AlbumJpaController();
    
    public boolean registrarAlbum(String nombre) {
        Album A = new Album();
        A.setNombre(nombre);
        
        try {
            aux.create(A);
            return true;
        } catch (Exception ex) {
            
            return false;
        }
    }
}

