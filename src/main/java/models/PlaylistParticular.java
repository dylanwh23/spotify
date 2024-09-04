/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PlaylistParticular extends Playlist {

    private Boolean privada;
	@ManyToOne
    private Cliente Propietario;

    public PlaylistParticular() {
    }

    public PlaylistParticular(Boolean privada, String Nombre, String rutaImagen, LinkedList<Cancion> canciones, Cliente Propietario) {
        super(Nombre, rutaImagen, canciones);
        this.privada = privada;
	this.Propietario =Propietario;
	Propietario.Agregar_Lista_Particular(this);
    }
    public Cliente getPropietario(){
    	return this.Propietario;
    }

    public Boolean getPrivada() {
        return privada;
    }

    public void setPrivada(Boolean privada) {
        this.privada = privada;
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
