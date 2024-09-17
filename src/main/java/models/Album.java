 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *hoal
 * @author dylan
 */
@Entity
@Table(name="Album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="nombre")
     private String nombre;
    @Column(name="anioo")
    private int anioo;
    @JoinColumn(name="generos")
    @OneToMany
    List<Genero> generos;
    @ManyToOne
    @JoinColumn(name="artista")
    private Artista artista;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="canciones")
    List<Cancion> canciones;

    public Album(String nombre, int anioo, Artista artista, List<Genero> generos, List<Cancion> canciones) {
        this.nombre = nombre;
        this.anioo = anioo;
        this.artista = artista;
        this.generos = generos;
        this.canciones = canciones;
    }

    public Album() {
       
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String id) {
        this.nombre = id;
    }

    public int getAnioo() {
        return anioo;
    }

    public void setAnioo(int anioo) {
        this.anioo = anioo;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Albumm[ id=" + nombre + " ]";
    }
    
}
