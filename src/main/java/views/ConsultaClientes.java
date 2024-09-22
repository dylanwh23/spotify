/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.UsuarioController;
import javax.swing.table.DefaultTableModel;

public class ConsultaClientes extends javax.swing.JInternalFrame {
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
    public ConsultaClientes() {
        initComponents();
        
        Object[][] datos = usrController.obtenerDatosClientes();
        String[] columnNames = {"NOMBRE", "NICK"};
        NonEditableTableModel tableModel = new NonEditableTableModel(datos, columnNames);
        tablaClientes.setModel(tableModel);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        ClienteEspecifico = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        jFrame1.setMinimumSize(new java.awt.Dimension(800, 500));
        jFrame1.setPreferredSize(new java.awt.Dimension(800, 500));
        jFrame1.setLocationRelativeTo(null);

        ClienteEspecifico.setModel(new javax.swing.table.DefaultTableModel(
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
        ClienteEspecifico.setMinimumSize(new java.awt.Dimension(400, 300));
        ClienteEspecifico.setName(""); // NOI18N
        ClienteEspecifico.setPreferredSize(new java.awt.Dimension(400, 300));
        ClienteEspecifico.setRowHeight(40);
        jScrollPane2.setViewportView(ClienteEspecifico);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta clientes");
        setPreferredSize(new java.awt.Dimension(800, 600));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Clientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setColumnSelectionAllowed(true);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        tablaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
         if (evt.getClickCount() == 2) { // Detectar clic simple
            int row = tablaClientes.rowAtPoint(evt.getPoint());
            if (row >= 0) {
                // Obtener el valor de una columna específica, por ejemplo, la columna con índice 1
                String id = (String) tablaClientes.getValueAt(row, 1); // Cambia 1 al índice de la columna deseada
                jFrame1.setVisible(true);
                Object[][] datos = usrController.obtenerDatosCliente(id);
                String[] columnNames = {"NICK", "NOMBRE", "APELLIDO", "CORREO", "FECHA DE NACIMIENTO", "IMAGEN"};
                NonEditableTableModel tableModel = new NonEditableTableModel(datos, columnNames);
                ClienteEspecifico.setModel(tableModel);
                ClienteEspecifico.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
            }
        }
    }//GEN-LAST:event_tablaClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClienteEspecifico;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
