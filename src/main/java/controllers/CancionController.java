/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Cancion;
import models.Cliente;
import models.Usuario;
import persistences.CancionJpaController;
import persistences.UsuarioJpaController;

/**
 *
 * @author Machichu
 */
public class CancionController implements ICancionController  {
     CancionJpaController cancionJpaController = new CancionJpaController();
     
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
     UsuarioJpaController auxCliente = new UsuarioJpaController(emf);
     
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

   public List<String> obtenerNombresCancionesFavoritas(String clienteNick) {
    // Busca al cliente por su nick
    
    Cliente cliente = (Cliente) auxCliente.findUsuario(clienteNick);

    // Si no se encuentra el cliente, retorna una lista vacía
    if (cliente == null) {
        return new ArrayList<>();
    }

    // Obtener las canciones favoritas del cliente
    List<Cancion> cancionesFavoritas = cliente.getCancionesFavoritas();

    // Mapear las canciones favoritas a una lista de nombres
    return cancionesFavoritas.stream()
            .map(cancion -> cancion.getId() + " - " + cancion.getNombre())
            .collect(Collectors.toList());
}

   
   
}

