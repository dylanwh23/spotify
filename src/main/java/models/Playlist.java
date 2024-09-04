/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author dylan
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Playlist implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected int id;
    
    protected String Nombre;
    protected String rutaImagen;
    @OneToMany 
    protected LinkedList<Cancion>canciones;

    public Playlist() {
    }

    public Playlist(String Nombre, String rutaImagen, LinkedList<Cancion> canciones) {
        this.Nombre = Nombre;
        this.rutaImagen = rutaImagen;
        this.canciones = canciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public LinkedList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(LinkedList<Cancion> canciones) {
        this.canciones = canciones;
    }
    
}
