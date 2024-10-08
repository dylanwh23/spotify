/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.Fabrica;
import controllers.IAlbumController;
import controllers.ICancionController;
import controllers.IPlaylistController;
import controllers.IUsuarioController;
import controllers.UsuarioController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Machichu
 */
public class GuardarTemaListaAlbum extends javax.swing.JInternalFrame {
    Fabrica fabrica = Fabrica.getInstance();
    IAlbumController albmController = fabrica.getIAlbumController();
    ICancionController canController = fabrica.getICancionController();
    IPlaylistController playController = fabrica.getIPlaylistController();
    IUsuarioController usrController = fabrica.getIUsuarioController();
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

        recargarPlaylists();
        RecargarBtns();
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
        EliminarFavBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AccionBox = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Guardar/Eliminar Tema/Lista/Album");

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

        EliminarFavBtn.setText("Eliminar Favorito");
        EliminarFavBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFavBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Accion:");

        AccionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guardar Favorito", "Eliminar Favorito" }));
        AccionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccionBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeleccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(UsuariosBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarFavBtn)
                    .addComponent(AgregarBtn))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuariosBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(AgregarBtn)
                    .addComponent(EliminarFavBtn))
                .addContainerGap(120, Short.MAX_VALUE))
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

    private void recargarPlaylists(){
        SeleccionBox.removeAllItems();

       if(AccionBox.getSelectedItem().toString().equals("Guardar Favorito")){
            try{
            String usuario = UsuariosBox.getSelectedItem().toString();
            
                  if(TipoBox.getSelectedItem().toString().equals("Cancion")){
            SeleccionBox.removeAllItems();
            List<String> nombresCanciones = canController.obtenerNombresCanciones();
            List<String> nombresCancionesFavoritas = canController.obtenerNombresCancionesFavoritas(usuario);
            for (String nombreC : nombresCanciones) {
                  if (!nombresCancionesFavoritas.contains(nombreC)) {
                  SeleccionBox.addItem(nombreC);
                }
             }
        }else if(TipoBox.getSelectedItem().toString().equals("Album")){
            SeleccionBox.removeAllItems();
            List<String> nombresAlbumes = albmController.obtenerNombresAlbums();
            List<String> nombresAlbumesFavoritos = albmController.obtenerNombresAlbumsFavoritos(usuario);
            for (String nombreC : nombresAlbumes) {
                 if (!nombresAlbumesFavoritos.contains(nombreC)) {
                 SeleccionBox.addItem(nombreC);
                }
             }
        }else if(TipoBox.getSelectedItem().toString().equals("Playlist")){            
                SeleccionBox.removeAllItems();

        // Obtener las playlists favoritas del cliente
        List<String> nombresPlaylistsFavoritas = playController.obtenerNombresDePlaylistsFavoritas(usuario);

        // Obtener y agregar playlists particulares (excluyendo favoritas)
        List<String> nombresPlaylistParticulares = playController.obtenerNombresPlaylistParticularCliente(usuario);
        for (String nombreC : nombresPlaylistParticulares) {
            if (!nombresPlaylistsFavoritas.contains(nombreC)) {
                SeleccionBox.addItem(nombreC);
            }
        }

        // Obtener y agregar playlists públicas (excluyendo favoritas)
        List<String> nombresPlaylistPublicas = playController.obtenerNombresPlaylistPublicas();
        for (String nombreC : nombresPlaylistPublicas) {
            if (!nombresPlaylistsFavoritas.contains(nombreC)) {
                SeleccionBox.addItem(nombreC);
            }
        }

        // Obtener y agregar playlists por defecto (excluyendo favoritas)
        List<String> nombresPlaylistPorDefecto = playController.obtenerNombresPlaylistPorDefecto();
        for (String nombreC : nombresPlaylistPorDefecto) {
            if (!nombresPlaylistsFavoritas.contains(nombreC)) {
                SeleccionBox.addItem(nombreC);
            }

        }
    }
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(this, "Ocurrió un error: No hay usuario ingresado", "Error", JOptionPane.ERROR_MESSAGE);
        }
       }else if(AccionBox.getSelectedItem().toString().equals("Eliminar Favorito")){
           SeleccionBox.removeAllItems();
           try {
        String usuario = UsuariosBox.getSelectedItem().toString();

        if (TipoBox.getSelectedItem().toString().equals("Cancion")) {
            SeleccionBox.removeAllItems();
            List<String> nombresCancionesFavoritas = canController.obtenerNombresCancionesFavoritas(usuario);
            for (String nombreC : nombresCancionesFavoritas) {
                SeleccionBox.addItem(nombreC);
            }
        } else if (TipoBox.getSelectedItem().toString().equals("Album")) {
            SeleccionBox.removeAllItems();
            List<String> nombresAlbumesFavoritos = albmController.obtenerNombresAlbumsFavoritos(usuario);
            for (String nombreA : nombresAlbumesFavoritos) {
                SeleccionBox.addItem(nombreA);
            }
        } else if (TipoBox.getSelectedItem().toString().equals("Playlist")) {
            SeleccionBox.removeAllItems();
            List<String> nombresPlaylistsFavoritas = playController.obtenerNombresDePlaylistsFavoritas(usuario);
            for (String nombreP : nombresPlaylistsFavoritas) {
                SeleccionBox.addItem(nombreP);
            }
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error: No hay usuario ingresado", "Error", JOptionPane.ERROR_MESSAGE);
    }
       }       
         
        
}
    
    private void UsuariosBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosBoxActionPerformed
        // TODO add your handling code here:
        recargarPlaylists();
        
    }//GEN-LAST:event_UsuariosBoxActionPerformed

    private void SeleccionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionBoxActionPerformed

    private void TipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBoxActionPerformed
        // TODO add your handling code here:
           recargarPlaylists();      
    }//GEN-LAST:event_TipoBoxActionPerformed

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        // TODO add your handling code here:
        recargarPlaylists();

          String tipo = TipoBox.getSelectedItem().toString();
          
          try{
              String usuario = UsuariosBox.getSelectedItem().toString();
              
            try{
             
             String nombre = SeleccionBox.getSelectedItem().toString();
             if (tipo.equals("Cancion")) {
                 try {
                     usrController.registrarCancionFavorita(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Cancion guardada en favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Cancion ya añadida", "Error", JOptionPane.ERROR_MESSAGE);
                     //Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 recargarPlaylists();
             } else if (tipo.equals("Album")) {
                  try {
                     usrController.registrarAlbumFavorito(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Album guardado en favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Album ya añadido", "Error", JOptionPane.ERROR_MESSAGE);
                     //Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                recargarPlaylists();
             } else if (tipo.equals("Playlist")) {
                 try {
                     usrController.registrarPlaylistFavorita(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Playlist guardada en favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Playlist ya añadida", "Error", JOptionPane.ERROR_MESSAGE);
                     //Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                recargarPlaylists();
             }
            }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "Ocurrió un error: Seleccion vacia" , "Error", JOptionPane.ERROR_MESSAGE);
         }
          }catch(Exception ex){
            //JOptionPane.showMessageDialog(this, "Ocurrió un error: No existe usuario" , "Error", JOptionPane.ERROR_MESSAGE);   
          }
          
    }//GEN-LAST:event_AgregarBtnActionPerformed

    private void RecargarBtns(){
         if(AccionBox.getSelectedItem().toString().equals("Guardar Favorito")){
            AgregarBtn.setVisible(true);
            EliminarFavBtn.setVisible(false);
            recargarPlaylists();
        }else if(AccionBox.getSelectedItem().toString().equals("Eliminar Favorito")){
            AgregarBtn.setVisible(false);
            EliminarFavBtn.setVisible(true);
            recargarPlaylists();
        }
    }
    
    
    
    
    
    
    private void AccionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccionBoxActionPerformed
        // TODO add your handling code here:
        if(AccionBox.getSelectedItem().toString().equals("Guardar Favorito")){
            AgregarBtn.setVisible(true);
            EliminarFavBtn.setVisible(false);
            recargarPlaylists();
        }else if(AccionBox.getSelectedItem().toString().equals("Eliminar Favorito")){
            AgregarBtn.setVisible(false);
            EliminarFavBtn.setVisible(true);
            recargarPlaylists();
        }
      
    }//GEN-LAST:event_AccionBoxActionPerformed

    private void EliminarFavBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFavBtnActionPerformed
        // TODO add your handling code here:
          recargarPlaylists();

          String tipo = TipoBox.getSelectedItem().toString();
          
          try{
              String usuario = UsuariosBox.getSelectedItem().toString();
              
            try{
             
             String nombre = SeleccionBox.getSelectedItem().toString();
             if (tipo.equals("Cancion")) {
                 try {
                     usrController.eliminarCancionFavorita(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Cancion eliminada de favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Cancion ya eliminada", "Error", JOptionPane.ERROR_MESSAGE);
                     //Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 recargarPlaylists();
             } else if (tipo.equals("Album")) {
                  try {
                     usrController.eliminarAlbumFavorito(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Album eliminado de favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Album ya eliminado", "Error", JOptionPane.ERROR_MESSAGE);
                     //Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                recargarPlaylists();
             } else if (tipo.equals("Playlist")) {
                 try {
                     usrController.eliminarPlaylistFavorita(usuario, nombre);
                     JOptionPane.showMessageDialog(this, "Playlist eliminada de favoritos .", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(this, "Ocurrió un error: Playlist ya eliminada", "Error", JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(GuardarTemaListaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                 }
                recargarPlaylists();
             }
            }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "Ocurrió un error: Seleccion vacia" , "Error", JOptionPane.ERROR_MESSAGE);
         }
          }catch(Exception ex){
            //JOptionPane.showMessageDialog(this, "Ocurrió un error: No existe usuario" , "Error", JOptionPane.ERROR_MESSAGE);   
          }
    }//GEN-LAST:event_EliminarFavBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AccionBox;
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JButton EliminarFavBtn;
    private javax.swing.JComboBox<String> SeleccionBox;
    private javax.swing.JComboBox<String> TipoBox;
    private javax.swing.JComboBox<String> UsuariosBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
