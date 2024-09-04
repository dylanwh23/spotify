/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.LinkedList;

/**
 *
 * @author dylan
 */
@Entity
public class Cliente extends Usuario {

    public Cliente() {
    }
    @OneToMany(mappedBy="Propietario")
    private LinkedList<PlaylistParticular> sus_listas;
    public Cliente(String nick, String nombre, String apellido, String mail, LocalDate FecNac){
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        //this.Contraseña = contraseña;
        this.mail = mail;
        this.fecNac = FecNac;
    }
    
    public void Agregar_Lista_Particular(PlaylistParticular la_nueva_lista){
    	this.sus_listas.add(la_nueva_lista);
    }
}

