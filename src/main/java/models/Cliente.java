/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import java.util.LinkedList;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



/**
 *
 * @author dylan
 */
@Entity
public class Cliente extends Usuario {

    @ManyToMany
    @JoinTable(
            name = "cliente_playlistFavoritas",
            joinColumns = @JoinColumn(name = "cliente_id"), 
            inverseJoinColumns = @JoinColumn(name = "playlist_particular_id") 
    )
    private List<PlaylistParticular> PlaylistFavoritos;
    
    @ManyToMany
    @JoinTable(
        name = "cliente_cancionesFavoritas", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "cancion_id") 
    )
    
    private List<Cancion> cancionesFavoritas;

    public Cliente() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
    
    public Cliente(String nick, String nombre, String apellido, String mail, LocalDate FecNac, String imagen){

        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        //this.Contraseña = contraseña;
        this.mail = mail;
        this.fecNac = FecNac;
        this.imagen = imagen;
    }
    
    
    
}

 
