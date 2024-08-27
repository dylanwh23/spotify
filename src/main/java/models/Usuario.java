/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.*;
/**
 *
 * @author dylan
 */
public class Usuario {
    
    protected String Nombre;
    protected String Apellido;
    protected String Contraseña;
    protected String Nick;
    protected String Mail;
    protected LocalDate FecNac;
    
    
    public String getNickname(){
        return this.Nick;
    }
}
