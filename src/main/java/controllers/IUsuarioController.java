/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author dylan
 */
public interface IUsuarioController {
    public abstract void registroUsuario(String nickname, String nombre, String apellido, String mail, LocalDate FecNac, String imagen, String biografia, String link, String tipo) throws Exception;
    public abstract List<String> obtenerNombresClientes();
    public abstract List<String> obtenerNicknamesseguidos(String usuario) throws Exception;
    public abstract List<String> obtenerNicknamesDisponiblesASeguir(String usuario, List<String> usuariosSeguidos) throws Exception;
    public abstract void seguirUsuario(String usuario, String usuarioASeguir) throws Exception;
    public abstract void dejarSeguirUsuario(String usuario, String usuarioASeguir) throws Exception;

}
