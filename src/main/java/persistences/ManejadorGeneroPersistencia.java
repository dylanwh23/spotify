package persistences;

import models.Genero;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *sdasfsgfasfas
 * 
 * 
 * @author diego
 */
public class ManejadorGeneroPersistencia {
     GeneroJpaController aux = new GeneroJpaController();
     public void crearGenero(Genero genero){
         aux.create(genero);
     }
}
