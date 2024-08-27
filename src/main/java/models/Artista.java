/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author dylan
 */
public class Artista extends Usuario {
    private String biografia;
    private String DireccionWeb;
    
    
    public Artista(String nick, String nombre, String apellido, String mail, LocalDate FecNac, String biografia, String link){
        this.Nick = nick;
        this.Nombre = nombre;
        this.Apellido = apellido;
        //this.Contraseña = contraseña;
        this.Mail = mail;
        this.FecNac = FecNac;
        this.biografia = biografia;
        this.DireccionWeb = link;
    }
    
}
