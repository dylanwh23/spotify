/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Genero;
import persistences.ManejadorGeneroPersistencia;

/**
 *
 * @author Machichu
 */
public class GeneroController implements IGeneroController {
    ManejadorGeneroPersistencia aux = new ManejadorGeneroPersistencia();
    public void registrarGenero(String nombre) {
        Genero gen = new Genero();
        gen.setNombre(nombre);
        aux.crearGenero(gen);
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
    
    
    
    

