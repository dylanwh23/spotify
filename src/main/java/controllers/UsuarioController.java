/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Artista;
import models.Cliente;
import models.Usuario;
import persistences.ArtistaJpaController;
import persistences.ClienteJpaController;
import persistences.UsuarioJpaController;
/*
import models.Artista;
import models.Cliente;
import models.Usuario;
*/

/**
 *
 * @author Machichu
 */
public class UsuarioController implements IUsuarioController{
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
    
    public void registroUsuario(String nickname, String nombre, String apellido, String mail, LocalDate FecNac, String imagen, String biografia, String link, String tipo){
        
        if(tipo == "Artista"){
            Artista nuevoUsuario = new Artista(nickname, nombre, apellido, mail, FecNac, imagen, biografia, link);
            ArtistaJpaController aux = new ArtistaJpaController(emf);
            try {               
                aux.create(nuevoUsuario);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            ClienteJpaController aux = new ClienteJpaController(emf);
            Cliente nuevoUsuario = new Cliente(nickname, nombre, apellido, mail, FecNac, imagen);
            try {
                aux.create(nuevoUsuario);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }  
     }
   /*Manejador m =  Manejador.getinstance();
       if(m.obtenerUsuario(nickname) == null){
           if(tipo == "Artista"){
               Usuario nuevoUsuario = new Artista(nickname, nombre, apellido, mail, FecNac, biografia, link);
               m.addUsuario(nuevoUsuario);
           }else{
               Usuario nuevoUsuario = new Cliente(nickname, nombre, apellido, mail, FecNac);
               m.addUsuario(nuevoUsuario);
           }         
       } */ 
       public List<String> obtenerNombresClientes() {
        EntityManager em = emf.createEntityManager();
        try {
            // Consulta para obtener solo los objetos de tipo Cliente
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            
            return clientes.stream()
                           .map(cliente -> cliente.getNick())
                           .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }
    
}

