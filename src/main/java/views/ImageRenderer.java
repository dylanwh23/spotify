
package views;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

  public class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            if (value != null) {
                try {
                    // Cargar la imagen desde la ruta especificada
                    String imagePath = (String) value;
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File(imagePath)));

                    // Redimensionar la imagen (opcional)
                    Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Ajustar tamaño
                    label.setIcon(new ImageIcon(img));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return label;
        }
    }
