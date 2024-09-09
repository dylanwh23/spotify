/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.AlbumController;
import controllers.CancionController;
import controllers.PlaylistController;
import controllers.UsuarioController;
import java.util.List;

/**
 *
 * @author Machichu
 */
public class GuardarTemaListaAlbum extends javax.swing.JInternalFrame {

    /**
     * Creates new form GuardarTemaListaAlbum
     */
    public GuardarTemaListaAlbum() {
        initComponents();
        UsuarioController usrController = new UsuarioController();
       
        List<String> nombresClientes = usrController.obtenerNombresClientes();
            for (String nombreC : nombresClientes) {
                UsuariosBox.addItem(nombreC);
            }

         
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UsuariosBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TipoBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SeleccionBox = new javax.swing.JComboBox<>();
        AgregarBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Guardar Tema/Lista/Album");

        jLabel1.setText("Usuario:");

        UsuariosBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo:");

        TipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cancion", "Album", "Playlist" }));
        TipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione:");

        SeleccionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionBoxActionPerformed(evt);
            }
        });

        AgregarBtn.setText("Guardar Favorito");
        AgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuariosBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeleccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarBtn)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UsuariosBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SeleccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarBtn))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuariosBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuariosBoxActionPerformed

    private void SeleccionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionBoxActionPerformed

    private void TipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBoxActionPerformed
        // TODO add your handling code here:
        AlbumController albmController = new AlbumController();
        CancionController canController = new CancionController();
        PlaylistController playController = new PlaylistController();
                    
              if(TipoBox.getSelectedItem().toString().equals("Cancion")){
            SeleccionBox.removeAllItems();
            List<String> nombresCanciones = canController.obtenerNombresCanciones();
            for (String nombreC : nombresCanciones) {
                SeleccionBox.addItem(nombreC);
            }
        }else if(TipoBox.getSelectedItem().toString().equals("Album")){
            SeleccionBox.removeAllItems();
            List<String> nombresAlbumes = albmController.obtenerNombresAlbums();
            for (String nombreC : nombresAlbumes) {
                SeleccionBox.addItem(nombreC);
            }
        }else if(TipoBox.getSelectedItem().toString().equals("Playlist")){
            SeleccionBox.removeAllItems();
            List<String> nombresPlaylist = playController.obtenerNombresPlaylists();
            for (String nombreC : nombresPlaylist) {
                SeleccionBox.addItem(nombreC);
            }
        }
        
    }//GEN-LAST:event_TipoBoxActionPerformed

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JComboBox<String> SeleccionBox;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JComboBox<String> UsuariosBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
