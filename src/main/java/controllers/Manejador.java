/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Genero;
import models.Usuario;

/**
 *
 * @author dylan
 */
public class Manejador {
     private Map<String, Usuario> usuariosNickname;
     private List<Genero> generos = new ArrayList<>();
    private static Manejador instancia = null;

    private Manejador() {
        usuariosNickname = new HashMap<String, Usuario>();
    }

    public static Manejador getinstance() {
        if (instancia == null)
            instancia = new Manejador();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String ci = usu.getNickname();
        usuariosNickname.put(ci, usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        return ((Usuario) usuariosNickname.get(nickname));
    }

    public Usuario[] getUsuarios() {
        if (usuariosNickname.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosNickname.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }

            return usuarios;
        }
    }
    
    public void agregarGenero(String nombre){
      /*  Genero gen = new Genero();
        gen.setNombre(nombre);
        .add(gen);
*/
    }
    
    public boolean buscarGenero(String nombre) {
    for (Genero gen : generos) {
        String Gen = gen.getNombre();
        if (Gen.equals(nombre)) {  // Comparación de cadenas usando .equals()
            return true;  // Si encuentra el género, retorna true
        }
    }
    return false;  // Si no encuentra el género después de recorrer toda la lista, retorna false
}
    
}
