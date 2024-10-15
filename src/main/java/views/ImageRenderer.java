
package views;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;

import java.io.File;
import javax.imageio.ImageIO;

public class ImageRenderer extends DefaultTableCellRenderer {

    // Ruta de la imagen predeterminada
    private String imagenPredeterminadaPath = "src/main/java/includes/cruz.png";  // Especifica la ruta aquí

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        
        if (value != null) {
            String imagePath = (String) value;
            try {
                File imageFile = new File(imagePath);

                if (imageFile.exists()) {
                    // Cargar la imagen desde la ruta especificada
                    ImageIcon icon = new ImageIcon(ImageIO.read(imageFile));
                    Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Ajustar tamaño
                    label.setIcon(new ImageIcon(img));
                } else {
                    // Si la imagen no existe, mostrar la imagen predeterminada
                    mostrarImagenPredeterminada(label);
                }
            } catch (Exception e) {
                // Si ocurre un error al cargar la imagen, mostrar la imagen predeterminada
                mostrarImagenPredeterminada(label);
                e.printStackTrace();  // Mostrar detalle del error en consola
            }
        } else {
            // Si el valor es null, mostrar la imagen predeterminada
            mostrarImagenPredeterminada(label);
        }

        return label;
    }

    // Método para mostrar la imagen predeterminada
    private void mostrarImagenPredeterminada(JLabel label) {
        try {
            ImageIcon defaultIcon = new ImageIcon(ImageIO.read(new File(imagenPredeterminadaPath)));
            Image defaultImg = defaultIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);  // Ajustar tamaño
            label.setIcon(new ImageIcon(defaultImg));
        } catch (Exception e) {
            // Si hay un problema con la imagen predeterminada, manejar el error
            System.out.println("Error cargando la imagen predeterminada.");
            e.printStackTrace();
        }
    }
}