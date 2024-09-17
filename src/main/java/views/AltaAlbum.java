/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import controllers.AlbumController;
import controllers.IAlbumController;
import models.Album;
import controllers.AlbumController;
import controllers.GeneroController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import models.Cancion;
import models.Genero;


public class AltaAlbum extends javax.swing.JInternalFrame {
  
/**
     * Creates new form ConsultaUsuario
     */
    AlbumController AController = new AlbumController();
    GeneroController controladorGenero = new GeneroController();
    List<Cancion> canciones = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel(new Object[]{"Nombre", "Duración", "Ruta MP3", "Imagen", "Eliminar"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Hacer la columna de "Eliminar" editable (para que el botón funcione) y el resto no
            return column == 4;
        }
    };

    public class ButtonColumn extends AbstractCellEditor
            implements TableCellRenderer, TableCellEditor, ActionListener {

        private JTable table;
        private JButton button;
        private int column;

        public ButtonColumn(JTable table, int column) {
            this.table = table;
            this.column = column;
            button = new JButton("Eliminar");
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            return button;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Eliminar";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();  // Asegura que no hay edición activa

            int row = table.getSelectedRow();
            row = table.convertRowIndexToModel(row);

            // Verifica si la tabla tiene filas y si el índice es válido
            if (table.getRowCount() > 0 && row >= 0 && row < ((DefaultTableModel) table.getModel()).getRowCount()) {
                // Elimina la fila del modelo
                ((DefaultTableModel) table.getModel()).removeRow(row);

                // Elimina el elemento de la lista si el índice es válido
                if (row >= 0 && row < canciones.size()) {
                    canciones.remove(row);
                } else {
                    System.out.println("Error: El índice de fila no se encuentra en la lista de canciones");
                }
            } else {
                System.out.println("Error: El índice de fila no es válido en el modelo");
            }

            fireEditingStopped();
        }
    }

    public AltaAlbum() {
        initComponents();
        canciones = new ArrayList<>();
        agregarCancionPanel.setVisible(false);
        //jScrollPane2.setVisible(false);
        PanelAlbum.setVisible(false);
        List<String> nombresGenero = controladorGenero.obtenerNombresGeneros();
        String[] columnNames = {"Seleccionar", "Género"};
        Object[][] data = new Object[nombresGenero.size()][2]; // 2 columnas

        for (int i = 0; i < nombresGenero.size(); i++) {
            data[i][0] = false; // Checkbox sin seleccionar
            data[i][1] = nombresGenero.get(i); // Nombre del género
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                // La primera columna es Boolean (para checkbox) y la segunda es String (para género)
                return column == 0 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Solo permitir la edición en la columna de checkboxes
                return column == 0;
            }
        };
        TablaGeneros.setModel(tableModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NombreArtista = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agregarCancionPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombreC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        duracion = new javax.swing.JTextField();
        pos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fileImg = new javax.swing.JTextField();
        btnImg = new javax.swing.JButton();
        fileMP3 = new javax.swing.JTextField();
        btnMP3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCanciones = new javax.swing.JTable();
        AceptarCancion = new javax.swing.JButton();
        Finalizar = new javax.swing.JButton();
        PanelAlbum = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        anioAlbum = new javax.swing.JTextField();
        NombreAlbum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AceptarAlbum = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaGeneros = new javax.swing.JTable();
        AceptarArtista = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta Album");
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(800, 800));

        NombreArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreArtistaActionPerformed(evt);
            }
        });
        NombreArtista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreArtistaKeyPressed(evt);
            }
        });

        jLabel1.setText("Nombre Artista");

        jLabel4.setText("Nombre");

        nombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCActionPerformed(evt);
            }
        });

        jLabel6.setText("Duracion(s)");

        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });
        duracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                duracionKeyTyped(evt);
            }
        });

        pos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posActionPerformed(evt);
            }
        });
        pos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                posKeyTyped(evt);
            }
        });

        jLabel7.setText("Posicion");

        jLabel8.setText("Agregar Cancion al Album");

        fileImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileImgActionPerformed(evt);
            }
        });

        btnImg.setText("Select");
        btnImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgActionPerformed(evt);
            }
        });

        fileMP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMP3ActionPerformed(evt);
            }
        });

        btnMP3.setText("Select");
        btnMP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMP3ActionPerformed(evt);
            }
        });

        jLabel15.setText("ruta Img");

        jLabel16.setText("ruta MP3");

        TablaCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Duracion", "Imagen", "Ruta mp3"
            }
        ));
        jScrollPane2.setViewportView(TablaCanciones);

        AceptarCancion.setText("añadir");
        AceptarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarCancionActionPerformed(evt);
            }
        });

        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout agregarCancionPanelLayout = new javax.swing.GroupLayout(agregarCancionPanel);
        agregarCancionPanel.setLayout(agregarCancionPanelLayout);
        agregarCancionPanelLayout.setHorizontalGroup(
            agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                        .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                .addComponent(fileMP3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnMP3))
                            .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                .addComponent(fileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnImg))))
                    .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                        .addComponent(AceptarCancion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Finalizar)
                        .addGap(56, 56, 56)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarCancionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        agregarCancionPanelLayout.setVerticalGroup(
            agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImg)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileMP3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMP3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarCancion)
                    .addComponent(Finalizar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel3.setText("Año");

        jLabel9.setText("Genero/s");

        anioAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioAlbumActionPerformed(evt);
            }
        });
        anioAlbum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anioAlbumKeyTyped(evt);
            }
        });

        NombreAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAlbumActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Album");

        AceptarAlbum.setText("Aceptar");
        AceptarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarAlbumActionPerformed(evt);
            }
        });

        TablaGeneros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaGeneros);

        javax.swing.GroupLayout PanelAlbumLayout = new javax.swing.GroupLayout(PanelAlbum);
        PanelAlbum.setLayout(PanelAlbumLayout);
        PanelAlbumLayout.setHorizontalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelAlbumLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(NombreAlbum))
                    .addGroup(PanelAlbumLayout.createSequentialGroup()
                        .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(PanelAlbumLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anioAlbum)
                            .addGroup(PanelAlbumLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlbumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AceptarAlbum)
                .addGap(93, 93, 93))
        );
        PanelAlbumLayout.setVerticalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlbumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anioAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AceptarAlbum)
                .addGap(167, 167, 167))
        );

        AceptarArtista.setText("Aceptar");
        AceptarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarArtistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(AceptarArtista))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(NombreArtista, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                        .addGap(196, 196, 196))
                    .addComponent(PanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(agregarCancionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1212, 1212, 1212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addComponent(AceptarArtista)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agregarCancionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private List<String> ObtenerGenerosSeleccionados() {
        List<String> generosSeleccionados = new ArrayList<>();
        for (int i = 0; i < TablaGeneros.getRowCount(); i++) {
            Boolean isSelected = (Boolean) TablaGeneros.getValueAt(i, 0); // Columna 0 (Checkbox)
            if (isSelected) {
                String genero = (String) TablaGeneros.getValueAt(i, 1); // Columna 1 (Nombre del género)
                generosSeleccionados.add(genero);
            }
        }
        return generosSeleccionados;
    }

   

    
    private void AceptarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarAlbumActionPerformed
        List<String> generosSeleccionados = ObtenerGenerosSeleccionados();
       if(NombreAlbum.getText().isEmpty() || anioAlbum.getText().isEmpty()||generosSeleccionados.size()<1){
           JOptionPane.showMessageDialog(this,"Ocurrió un error: Se ingresaron campos vacios" ,"Error",JOptionPane.ERROR_MESSAGE);
       }else{
           agregarCancionPanel.setVisible(true);
       }
    }//GEN-LAST:event_AceptarAlbumActionPerformed

    private void posActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posActionPerformed

    private void NombreArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreArtistaActionPerformed
      
    }//GEN-LAST:event_NombreArtistaActionPerformed

    private void NombreArtistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreArtistaKeyPressed

    }//GEN-LAST:event_NombreArtistaKeyPressed

    private void NombreAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAlbumActionPerformed

    private void anioAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioAlbumActionPerformed

    private void AceptarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarArtistaActionPerformed
       String nomAr = NombreArtista.getText();
       agregarCancionPanel.setVisible(false);
        if (AController.buscarArtista(nomAr)) {
             PanelAlbum.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(this,"Ocurrió un error: El artista ingresado no existe o es vacío" ,"Error",JOptionPane.ERROR_MESSAGE);
            PanelAlbum.setVisible(false);
        }
    }//GEN-LAST:event_AceptarArtistaActionPerformed

    private void nombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCActionPerformed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void AceptarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarCancionActionPerformed

        if (!(nombreC.getText().isEmpty() || duracion.getText().isEmpty() || fileMP3.getText().isEmpty() || fileImg.getText().isEmpty())) {
            jScrollPane2.setVisible(true);
            int duracionnum = Integer.parseInt(duracion.getText());
            Cancion cancionAux = new Cancion(nombreC.getText(), duracionnum, fileMP3.getText(), fileImg.getText());
            canciones.add(cancionAux);
            model.addRow(new Object[]{cancionAux.getNombre(), cancionAux.getDuracion(), cancionAux.getDireccion_archivo_de_audio(), cancionAux.getDireccion_imagen(), "Eliminar"});
            TablaCanciones.setModel(model);

            // Configurar el botón "Eliminar" en la columna
            ButtonColumn buttonColumn = new ButtonColumn(TablaCanciones, 4); // 4 es el índice de la columna "Eliminar"
            // Esto asegura que la columna "Eliminar" esté bien configurada
            TablaCanciones.getColumnModel().getColumn(4).setCellRenderer(buttonColumn);
            TablaCanciones.getColumnModel().getColumn(4).setCellEditor(buttonColumn);

            JOptionPane.showMessageDialog(this, "Tema añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Se ingresaron campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_AceptarCancionActionPerformed

    private void fileImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileImgActionPerformed

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed

        JFileChooser fc= new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen", "jpg", "png");
        fc.setFileFilter(filter);

        fc.showOpenDialog(fc);
        File imgfile = fc.getSelectedFile();
        String filepath=imgfile.getAbsolutePath();
        fileImg.setText(filepath);
    }//GEN-LAST:event_btnImgActionPerformed

    private void fileMP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMP3ActionPerformed
        
    }//GEN-LAST:event_fileMP3ActionPerformed

    private void btnMP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMP3ActionPerformed
        JFileChooser fc= new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3");
        fc.setFileFilter(filter);

        fc.showOpenDialog(fc);
        File imgfile = fc.getSelectedFile();
        String filepath=imgfile.getAbsolutePath();
        fileMP3.setText(filepath);
    }//GEN-LAST:event_btnMP3ActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        List<String> generosSeleccionados = ObtenerGenerosSeleccionados();
        if (NombreAlbum.getText().isEmpty() || anioAlbum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Campos vacios en Album", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!AController.buscarArtista(NombreArtista.getText())) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: El artista ingresado no existe o es vacío", "Error", JOptionPane.ERROR_MESSAGE);
            PanelAlbum.setVisible(false);
        }
        else if ((canciones.size() < 1)) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error: Ingrese alguna cancion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if ((generosSeleccionados.size() < 1)) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error: Ingrese algun genero", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            try {
                AController.CrearAlbum(NombreAlbum.getText(), Integer.parseInt(anioAlbum.getText()), NombreArtista.getText(), canciones, generosSeleccionados);
                JOptionPane.showMessageDialog(this, "Alta de Album creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

     dispose();
    }//GEN-LAST:event_FinalizarActionPerformed

    private void anioAlbumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anioAlbumKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (anioAlbum.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_anioAlbumKeyTyped

    private void duracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (duracion.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_duracionKeyTyped

    private void posKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_posKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (pos.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_posKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarAlbum;
    private javax.swing.JButton AceptarArtista;
    private javax.swing.JButton AceptarCancion;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextField NombreAlbum;
    private javax.swing.JTextField NombreArtista;
    private javax.swing.JPanel PanelAlbum;
    private javax.swing.JTable TablaCanciones;
    private javax.swing.JTable TablaGeneros;
    private javax.swing.JPanel agregarCancionPanel;
    private javax.swing.JTextField anioAlbum;
    private javax.swing.JButton btnImg;
    private javax.swing.JButton btnMP3;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField fileImg;
    private javax.swing.JTextField fileMP3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombreC;
    private javax.swing.JTextField pos;
    // End of variables declaration//GEN-END:variables

    
}

