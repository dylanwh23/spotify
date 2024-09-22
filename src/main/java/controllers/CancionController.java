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
import models.Album;
import models.Cancion;
import models.Cliente;
import models.Usuario;
import persistences.AlbumJpaController;
import persistences.CancionJpaController;
import persistences.UsuarioJpaController;

/**
 *
 * @author Machichu
 */
public class CancionController implements ICancionController  {
     CancionJpaController cancionJpaController = new CancionJpaController();
     AlbumJpaController auxAl = new AlbumJpaController();
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

 public Object[][] obtenerDatosCancion(int id) {
   Album album = auxAl.findAlbum(id);
        if (album == null) {
            return new Object[0][0]; 
        }
        List<Cancion> canciones = album.getCanciones();
        Object[][] datos = new Object[canciones.size()][6];

        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            datos[i][0] = cancion.getId();
            datos[i][1] = cancion.getNombre();
            datos[i][2] = cancion.getDuracion();
            datos[i][3] = cancion.getDireccion_archivo_de_audio();
            datos[i][4] = cancion.getDireccion_imagen();



        }
        return datos;
    }
   
}

