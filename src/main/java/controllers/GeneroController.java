/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import models.Genero;
import persistences.GeneroJpaController;
/**
 *
 * @author Machichu
 */
public class GeneroController implements IGeneroController {
    GeneroJpaController aux = new GeneroJpaController();
    public void registrarGenero(String nombre) {
        Genero gen = new Genero();
        gen.setNombre(nombre);
        try {
            aux.create(gen);
        } catch (Exception ex) {
            Logger.getLogger(GeneroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        
        
        
        
        
        /* Manejador m =  Manejador.getinstance();
        Genero gen = new Genero();
        gen.setNombre(nombre);
        
        if(m.buscarGenero(nombre) == false){
            m.agregarGenero(nombre);
            System.out.println(nombre);
        }else{
            System.out.println("Genero ya ingresado");
        }
 */
    
        
        
    }
    
    
    
    

