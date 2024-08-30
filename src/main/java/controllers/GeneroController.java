/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Genero;
import persistences.ControladoraPersistencia;

/**
 *
 * @author Machichu
 */
public class GeneroController implements IGeneroController {
    
    ControladoraPersistencia aux = new ControladoraPersistencia();
    public void registrarGenero(Genero genero) {
        aux.crearGenero(genero);
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

    @Override
    public void registrarGenero(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
        
    }
    
    
    
    

