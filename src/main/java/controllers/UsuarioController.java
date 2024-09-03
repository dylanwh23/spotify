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
    


public Object[][] obtenerDatosCliente(String nick) {
    EntityManager em = emf.createEntityManager();
    try {
        System.out.print(nick);
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nick = :nick", Cliente.class).setParameter("nick", nick).getResultList();
        Object[][] data = new Object[clientes.size()][6];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);  // Obtener el cliente individual

            data[i][0] = cliente.getNick();     // Asignar valores al arreglo
            data[i][1] = cliente.getNombre();
            data[i][2] = cliente.getApellido();
            data[i][3] = cliente.getMail();
            data[i][4] = cliente.getFecNac();
            data[i][5] = cliente.getImagen();
        }
        return data;

    } finally {
        em.close();
    }
}

public Object[][] obtenerDatosClientes() {
    EntityManager em = emf.createEntityManager();
    try {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        Object[][] data = new Object[clientes.size()][6];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);  // Obtener el cliente individual

                 // Asignar valores al arreglo
            data[i][0] = cliente.getNombre();
            data[i][1] = cliente.getNick();
        }
        return data;

    } finally {
        em.close();
    }
}


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

}
