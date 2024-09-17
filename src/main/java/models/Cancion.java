/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 *
 * @author dylan
 */
@Entity
@Table(name="Cancion")
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="nombre")
	private String nombre;
    @Column(name="duracion")
	private int duracion;
    @Column(name="direccion_archivo_de_audio")
	private String direccion_archivo_de_audio;
    @Column(name="direccion_imagen")
	private String direccion_imagen;


    public Cancion(String nombre, int duracion, String direccion_archivo_de_audio, String direccion_imagen) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.direccion_archivo_de_audio = direccion_archivo_de_audio;
        this.direccion_imagen = direccion_imagen;
    }

    public Cancion() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDireccion_archivo_de_audio() {
        return direccion_archivo_de_audio;
    }

    public void setDireccion_archivo_de_audio(String direccion_archivo_de_audio) {
        this.direccion_archivo_de_audio = direccion_archivo_de_audio;
    }

    public String getDireccion_imagen() {
        return direccion_imagen;
    }

    public void setDireccion_imagen(String direccion_imagen) {
        this.direccion_imagen = direccion_imagen;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cancionn[ id=" + id + " ]";
    }
    
//>>>>>>> 7a2084fa622101ddd7415abaaf7ae1550f9afdf9
}
