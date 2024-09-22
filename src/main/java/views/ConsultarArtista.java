/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.UsuarioController;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dylan
 */

public class ConsultarArtista extends javax.swing.JInternalFrame {
 UsuarioController usrController = new UsuarioController();
 class NonEditableTableModel extends DefaultTableModel {

        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }   
 /**
     * Creates new form ConsultaUsuario
     */
    public ConsultarArtista() {
        initComponents();
    
        Object[][] datos = usrController.obtenerDatosArtistas();
        String[] columnNames = {"NOMBRE", "NICK"};
        NonEditableTableModel tableModel = new NonEditableTableModel(datos, columnNames);
        tablaArtistas.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        ArtistaEspecifico = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArtistas = new javax.swing.JTable();

        jFrame1.setMinimumSize(new java.awt.Dimension(800, 500));
        jFrame1.setPreferredSize(new java.awt.Dimension(800, 500));

        ArtistaEspecifico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ArtistaEspecifico.setToolTipText("");
        ArtistaEspecifico.setColumnSelectionAllowed(false);
        ArtistaEspecifico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ArtistaEspecifico.setFillsViewportHeight(true);
        ArtistaEspecifico.setRowHeight(40);
        jScrollPane3.setViewportView(ArtistaEspecifico);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        tablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Artistas"
            }
        ));
        tablaArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaArtistas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaArtistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArtistasMouseClicked
        if (evt.getClickCount() == 2) { // Detectar clic doble
            int row = tablaArtistas.rowAtPoint(evt.getPoint());
            if (row >= 0) {
                // Obtener el valor de una columna específica
                String id = (String) tablaArtistas.getValueAt(row, 1);
                jFrame1.setVisible(true);
                Object[][] datos = usrController.obtenerDatosArtista(id);
                String[] columnNames = {"NICK", "NOMBRE", "APELLIDO", "CORREO", "FECHA DE NACIMIENTO", "IMAGEN", "BIOGRAFIA", "WEB"};
                NonEditableTableModel tableModel = new NonEditableTableModel(datos, columnNames);
                ArtistaEspecifico.setModel(tableModel);

                // Establecer el renderizador de imagen para la columna de imagen
                ArtistaEspecifico.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());

                // Establecer el renderizador de texto multilínea para la columna de biografía
                ArtistaEspecifico.getColumnModel().getColumn(6).setCellRenderer(new MultiLineCellRenderer());

                // Ajustar la altura de las filas
                ArtistaEspecifico.setRowHeight(200); // Ajusta según sea necesario
            }
        }
    }//GEN-LAST:event_tablaArtistasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ArtistaEspecifico;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaArtistas;
    // End of variables declaration//GEN-END:variables
}
