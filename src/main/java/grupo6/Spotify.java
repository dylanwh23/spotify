package grupo6;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import views.VentanaPrincipal;
import com.formdev.flatlaf.FlatLightLaf;
import controllers.AlbumController;
import controllers.CancionController;
import controllers.GeneroController;
import controllers.PlaylistController;
import controllers.UsuarioController;
import java.util.LinkedList;
import javax.swing.UIManager;
import javax.xml.ws.Endpoint;
import models.Album;
import models.Artista;
import models.Cancion;
import models.Cliente;
import models.Genero;
import models.PlaylistParticular;
import models.PlaylistPorDefecto;
import models.Usuario;
import models.UsuarioDTO;

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
         
        //publico los webservices
        Endpoint.publish("http://localhost:8085/GeneroController", new GeneroController());
        Endpoint.publish("http://localhost:8085/AlbumController", new AlbumController());
        Endpoint.publish("http://localhost:8085/CancionController", new CancionController());
        Endpoint.publish("http://localhost:8085/PlaylistController", new PlaylistController());
        Endpoint.publish("http://localhost:8085/PlaylistParticular", new PlaylistParticular());
        Endpoint.publish("http://localhost:8085/PlaylistPorDefecto", new PlaylistPorDefecto());
        Endpoint.publish("http://localhost:8085/UsuarioController", new UsuarioController());
        Endpoint.publish("http://localhost:8085/Album", new Album());
        
   
        
        

    }
}
