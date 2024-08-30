
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import views.VentanaPrincipal;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import persistences.HandlerGeneroPersistencia;

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
        
    }
}
