/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author dylan
 */
@Entity
public class Album {
    
    @Id private String nombre;
    private int anioo;
    List<Genero> generos;
    
}
