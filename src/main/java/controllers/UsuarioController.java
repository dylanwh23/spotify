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
import persistences.exceptions.PreexistingEntityException;
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
    
    public void registroUsuario(String nickname, String nombre, String apellido, String mail, LocalDate FecNac, String imagen, String biografia, String link, String tipo) throws Exception{
        UsuarioJpaController aux = new UsuarioJpaController(emf);
        Usuario usr;
        if(tipo == "Artista"){
            usr = new Artista(nickname, nombre, apellido, mail, FecNac, imagen, biografia, link);
        }else{//si es cliente
            usr = new Cliente(nickname, nombre, apellido, mail, FecNac, imagen);
        }
        try{
            aux.create(usr);
        }catch(Exception ex){
            System.out.print(ex);
            throw ex;
        }   
     }
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

