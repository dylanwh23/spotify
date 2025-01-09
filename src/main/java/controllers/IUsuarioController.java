/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import models.LocalDateAdapter;
import models.UsuarioDTO;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author dylan
 */
public interface IUsuarioController {
    public abstract void registroUsuario(String nickname, String nombre, String apellido, String mail,@XmlJavaTypeAdapter(LocalDateAdapter.class) LocalDate FecNac, String imagen, String biografia, String link, String tipo, String contraseña) throws Exception;
    public abstract List<String> obtenerNombresClientes();
    public abstract List<String> obtenerNicknamesseguidos(String usuario) throws Exception;
    public abstract List<String> obtenerNicknamesseguidores(String usuario) throws Exception;
    public abstract List<String> obtenerNicknamesDisponiblesASeguir(String usuario, List<String> usuariosSeguidos) throws Exception;
    public abstract void seguirUsuario(String usuario, String usuarioASeguir) throws Exception;
    public abstract void dejarSeguirUsuario(String usuario, String usuarioASeguir) throws Exception;
    public abstract Object[][] obtenerDatosCliente(String nick);
    public abstract Object[][] obtenerDatosClientes();
    public abstract void registrarPlaylistFavorita(String nick, String nombrePlaylist)throws Exception;
    public abstract List<String> obtenerNombresDePlaylistsNoFavoritas(String clienteNick);
    public abstract Object[][] obtenerDatosArtista(String nick);
    public abstract Object[][] obtenerDatosArtistas();
    public abstract void registrarAlbumFavorito(String nick, String nombreAlbum) throws Exception;
    public abstract void registrarCancionFavorita(String nick, String nombreCancion) throws Exception;
    public abstract void eliminarCancionFavorita(String nick, String nombreCancion)throws Exception;
    public abstract void eliminarAlbumFavorito(String nick, String nombreAlbum) throws Exception;
    public abstract void eliminarPlaylistFavorita(String nick, String nombrePlaylist) throws Exception;
    public abstract List<String> obtenerNombresArtistas();
    public abstract String tipoUsuario(String nick);
    public abstract void eliminarAlbumFavoritoWeb(String nick, int id) throws Exception;
    public abstract void registrarAlbumFavoritoWeb(String nick, int id) throws Exception;
    public abstract boolean esCliente(String nickname);

    
    public abstract Boolean inicioSesion(String nick, String password);
    public String hashPassword(String password);
    public boolean checkPassword(String password, String hashedPassword);
    public abstract String getNickPorMail(String mail);
    
    public abstract List<String> getDatosUsuario(String nick);
    public abstract String artistaNombre(String nick);    
    public abstract void CambiarEstadosubscripcion(String nick ,String estado,Integer tipo) throws Exception; 
    public abstract String usuarioNombre(String nick);
    public abstract void eliminarUsuario(String nick) throws NonexistentEntityException;
    public abstract boolean autenticarUsuario(String ip, String url, String navegador, String sistemaOperativo);
    public abstract Object[][] obtenerRegistrosAcceso();

}
