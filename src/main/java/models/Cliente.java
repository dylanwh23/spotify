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
public class Cliente extends Usuario {
    public Cliente(String nick, String nombre, String apellido, String mail, LocalDate FecNac){
        this.Nick = nick;
        this.Nombre = nombre;
        this.Apellido = apellido;
        //this.Contraseña = contraseña;
        this.Mail = mail;
        this.FecNac = FecNac;
    }
}
