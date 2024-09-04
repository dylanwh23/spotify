
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import views.VentanaPrincipal;
import com.formdev.flatlaf.FlatLightLaf;
import controllers.PlaylistController;
import controllers.UsuarioController;
import java.util.LinkedList;
import javax.swing.UIManager;
import models.Artista;
import models.Cancion;
import models.Cliente;
import models.Genero;
import models.PlaylistParticular;
import models.PlaylistPorDefecto;
import models.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author dylan
 */
public class Spotify {

    public static void main(String[] args) {
       
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        VentanaPrincipal v = new VentanaPrincipal();
         v.setVisible(true);
        
        /*
        UsuarioController auxUsu = new UsuarioController();
        Artista user = new Artista();
        user.setNick("artista323");
        user.setBiografia("puto");
        auxUsu.crearUser(user);
        Cliente user2 = new Cliente();
        user2.setNick("ecliente234");
        auxUsu.crearPlaylist(user);
        auxUsu.crearPlaylist(user2);
        
        
        //ProBAR PLAYLIST Y SUS HIJOS
        PlaylistController aux = new PlaylistController();
        Genero gen = new Genero();
        gen.setNombre("pop");
        LinkedList<Cancion> canciones = null;
        
        PlaylistPorDefecto playlist = new PlaylistPorDefecto();
        playlist.setNombre("oaPOrdefect");
        playlist.setGenero(gen);
        
        PlaylistParticular playlist2 = new PlaylistParticular();
        playlist2.setNombre("pordefecto1");
        playlist2.setPrivada(Boolean.TRUE);
        
         PlaylistParticular playlist3 = new PlaylistParticular();
        playlist3.setNombre("pordefecto2");
        playlist3.setPrivada(Boolean.TRUE);
        
        aux.crearPlaylist(playlist);
        aux.crearPlaylist(playlist2);
        aux.crearPlaylist(playlist3);*/
    }
}
