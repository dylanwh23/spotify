/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import models.Genero;

/**
 *
 * @author diego
 */
public class ControladoraPersistencia {
    GeneroJpaController aux = new GeneroJpaController();
    public void crearGenero(Genero genero){
        aux.create(genero);
    }
}
