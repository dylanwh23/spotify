/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author diego
 */
public class MultiLineCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(true);
        textArea.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        textArea.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
        textArea.setFont(table.getFont());
        textArea.setEditable(false); // Para evitar la edición si no lo deseas
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espaciado

        return textArea;
    }
}
