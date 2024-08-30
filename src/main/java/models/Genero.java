/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package models;

import static com.mysql.cj.MysqlType.NULL;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 
@author dylan*/
@Entity
public class Genero implements Serializable {
    
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //private int id;
    @Id 
    private String Nombre;
    @ManyToOne
    private Genero Padre;

    public Genero() {
 
    }
   
    public Genero( String Nombre, Genero Padre) {
        this.Nombre = Nombre;
        this.Padre = Padre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Genero getPadre() {
        return Padre;
    }

    public void setPadre(Genero Padre) {
        this.Padre = Padre;
    }
    
    
    
}