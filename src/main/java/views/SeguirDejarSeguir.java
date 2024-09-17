/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.IUsuarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import views.ConsultarPlaylist.NonEditableTableModel;

/**
 *
 * @author dylan
 */
public class SeguirDejarSeguir extends javax.swing.JInternalFrame {
    private IUsuarioController controladorUsr;
    
    //variables que uso en los mouse events
    String usuarioSeleccionado;
    String usuarioSeleccionadoASeguir;
    String usuarioSeleccionadoSeguido;
    
    private void actualizarTablas(){
        

    }
    /**
     * Creates new form SeguirDejarSeguir
     */
    public SeguirDejarSeguir(IUsuarioController icu) {
        initComponents();
        controladorUsr = icu;
        class NonEditableTableModel extends DefaultTableModel {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
        
        
        
        NonEditableTableModel tablaSeleccionarUsuarios = new NonEditableTableModel();
        tablaSeleccionarUsuarios.addColumn("Nickname");
        NonEditableTableModel  tablaSeleccionarUsuariosASeguir = new NonEditableTableModel ();
        tablaSeleccionarUsuariosASeguir.addColumn("Nickname");
        NonEditableTableModel  tablaSeleccionarUsuariosSeguidos = new NonEditableTableModel ();
        tablaSeleccionarUsuariosSeguidos.addColumn("Nickname");
        List<String> totalUsuarios = controladorUsr.obtenerNombresClientes();
        //recorro lista para agregar los usuarios a la lista
        for(String nick : totalUsuarios){
            tablaSeleccionarUsuarios.addRow(new Object[]{nick});
        }  
        
        //obtener nick del usuario clickeado
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //recupero usuario seleccionado
                int filaSeleccionada = jTable1.rowAtPoint(e.getPoint());
                int columnaSeleccionada = jTable1.columnAtPoint(e.getPoint());
                if (filaSeleccionada != -1) {              
                    Object nick = tablaSeleccionarUsuarios.getValueAt(filaSeleccionada, 0);
                    usuarioSeleccionado =  nick.toString();
                }
                
                //declaro listas
                List<String> totalUsuariosASeguir = null;
                List<String> totalUsuariosSeguidos = null;
                
                //reinicio tablas
                tablaSeleccionarUsuariosSeguidos.setRowCount(0);
                tablaSeleccionarUsuariosASeguir.setRowCount(0);
                
                //recupero datos de la bdd a las lista
                try{
                    totalUsuariosSeguidos = controladorUsr.obtenerNicknamesseguidos(usuarioSeleccionado);
                    totalUsuariosASeguir = controladorUsr.obtenerNicknamesDisponiblesASeguir(usuarioSeleccionado, totalUsuariosSeguidos);
                }catch(Exception e1){
                    System.out.println(e1);
                } 
                
                for(String nickUsuarioSeguido : totalUsuariosSeguidos){
                    tablaSeleccionarUsuariosSeguidos.addRow(new Object[]{nickUsuarioSeguido});
                }
                for(String nickUsuarioSeguido : totalUsuariosASeguir){
                    tablaSeleccionarUsuariosASeguir.addRow(new Object[]{nickUsuarioSeguido});
                }

            }    
        });
        
        jTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //recupero usuario seleccionado
                int filaSeleccionada = jTable2.rowAtPoint(e.getPoint());
                int columnaSeleccionada = jTable2.columnAtPoint(e.getPoint());
                if (filaSeleccionada != -1) {              
                    Object nick = tablaSeleccionarUsuariosASeguir.getValueAt(filaSeleccionada, 0);
                    usuarioSeleccionadoASeguir =  nick.toString();
                    try{
                       controladorUsr.seguirUsuario(usuarioSeleccionado, usuarioSeleccionadoASeguir);
                    }catch(Exception e1){
                        System.out.println(e1);
                    }
                    
                }
                
                //declaro listas
                List<String> totalUsuariosASeguir = null;
                List<String> totalUsuariosSeguidos = null;
                
                //reinicio tablas
                tablaSeleccionarUsuariosSeguidos.setRowCount(0);
                tablaSeleccionarUsuariosASeguir.setRowCount(0);
                
                //recupero datos de la bdd a las lista
                try{
                    totalUsuariosSeguidos = controladorUsr.obtenerNicknamesseguidos(usuarioSeleccionado);
                    totalUsuariosASeguir = controladorUsr.obtenerNicknamesDisponiblesASeguir(usuarioSeleccionado, totalUsuariosSeguidos);
                }catch(Exception e1){
                    System.out.println(e1);
                } 
                
                for(String nickUsuarioSeguido : totalUsuariosSeguidos){
                    tablaSeleccionarUsuariosSeguidos.addRow(new Object[]{nickUsuarioSeguido});
                }
                for(String nickUsuarioSeguido : totalUsuariosASeguir){
                    tablaSeleccionarUsuariosASeguir.addRow(new Object[]{nickUsuarioSeguido});
                }
            }    
        });
        
        
        jTable3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //recupero usuario seleccionado
                int filaSeleccionada = jTable3.rowAtPoint(e.getPoint());
                int columnaSeleccionada = jTable3.columnAtPoint(e.getPoint());
                if (filaSeleccionada != -1) {              
                    Object nick = tablaSeleccionarUsuariosSeguidos.getValueAt(filaSeleccionada, 0);
                    usuarioSeleccionadoSeguido =  nick.toString();
                    try{
                       controladorUsr.dejarSeguirUsuario(usuarioSeleccionado, usuarioSeleccionadoSeguido);
                    }catch(Exception e1){
                        System.out.println(e1);
                    }
                    
                }
                
                //declaro listas
                List<String> totalUsuariosASeguir = null;
                List<String> totalUsuariosSeguidos = null;
                
                //reinicio tablas
                tablaSeleccionarUsuariosSeguidos.setRowCount(0);
                tablaSeleccionarUsuariosASeguir.setRowCount(0);
                
                //recupero datos de la bdd a las lista
                try{
                    totalUsuariosSeguidos = controladorUsr.obtenerNicknamesseguidos(usuarioSeleccionado);
                    totalUsuariosASeguir = controladorUsr.obtenerNicknamesDisponiblesASeguir(usuarioSeleccionado, totalUsuariosSeguidos);
                }catch(Exception e1){
                    System.out.println(e1);
                } 
                
                for(String nickUsuarioSeguido : totalUsuariosSeguidos){
                    tablaSeleccionarUsuariosSeguidos.addRow(new Object[]{nickUsuarioSeguido});
                }
                for(String nickUsuarioSeguido : totalUsuariosASeguir){
                    tablaSeleccionarUsuariosASeguir.addRow(new Object[]{nickUsuarioSeguido});
                }
            }    
        });
        
        
        
        jTable1.setModel(tablaSeleccionarUsuarios);
        jTable2.setModel(tablaSeleccionarUsuariosASeguir);
        jTable3.setModel(tablaSeleccionarUsuariosSeguidos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buscarUsuarioField = new javax.swing.JTextField();
        usuarioASeguirField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usuariosSeguidosField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable3);

        jLabel3.setText("Buscar usuario:");

        buscarUsuarioField.setText("jTextField1");

        usuarioASeguirField.setText("jTextField1");
        usuarioASeguirField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioASeguirFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar usuario a seguir:");

        usuariosSeguidosField.setText("jTextField1");

        jLabel5.setText("Buscar usuario seguido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarUsuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioASeguirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuariosSeguidosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(buscarUsuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(usuarioASeguirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(usuariosSeguidosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioASeguirFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioASeguirFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioASeguirFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarUsuarioField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField usuarioASeguirField;
    private javax.swing.JTextField usuariosSeguidosField;
    // End of variables declaration//GEN-END:variables
}
