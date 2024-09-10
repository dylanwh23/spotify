/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.List;
import java.util.stream.Collectors;
import models.Cancion;
import persistences.CancionJpaController;

/**
 *
 * @author Machichu
 */
public class CancionController implements ICancionController  {
     CancionJpaController cancionJpaController = new CancionJpaController();
  public boolean CrearCancion(String nombre, int duracion){

        Cancion nuevaCancion = new Cancion();
        nuevaCancion.setNombre(nombre);
        nuevaCancion.setDuracion(duracion);

        try {
            cancionJpaController.create(nuevaCancion);

            return true;
        } catch (Exception ex) {

            return false;
        }
    }

   public List<String> obtenerNombresCanciones() {
            List<Cancion> canciones = cancionJpaController.findCancionEntities();
            return canciones.stream()
                           .map(cancion -> cancion.getId()+" - "+cancion.getNombre())
                           .collect(Collectors.toList());
    }
}

