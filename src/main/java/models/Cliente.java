/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author dylan
 */
@Entity
public class Cliente extends Usuario {
    @OneToMany(mappedBy = "cliente")
    private List<PlaylistParticular> playlists;
    public Cliente() {
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

