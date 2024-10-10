/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;


import controllers.AlbumController;
import controllers.IAlbumController;
import models.Album;
import controllers.AlbumController;
import controllers.Fabrica;
import controllers.GeneroController;
import controllers.IGeneroController;
import controllers.IUsuarioController;
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

/**
 *
 * @author Machichu
 */
public class AltaAlbum extends javax.swing.JInternalFrame {
        Fabrica fabrica = Fabrica.getInstance();
        IGeneroController controladorGenero = fabrica.getIGeneroController();
        IUsuarioController UController = fabrica.getIUsuarioController();
        IAlbumController AController = fabrica.getIAlbumController();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Orden","Nombre", "Duración", "Ruta MP3","Genero", "Eliminar"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Hacer la columna de "Eliminar" editable (para que el botón funcione) y el resto no
            return column == 5;
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
                
                ((DefaultTableModel) table.getModel()).removeRow(row);
            }

            fireEditingStopped();
        }
    }
    public AltaAlbum() {
        System.out.println("views.AltaAlbum.<init>()");
        initComponents();
        agregarCancionPanel.setVisible(false);
        PanelAlbum.setVisible(false);
        List<String> nombresGenero = controladorGenero.obtenerNombresGeneros();
        String[] columnNames = {"Seleccionar", "Género"};
        Object[][] data = new Object[nombresGenero.size()][2]; // 2 columnas
       
        for (int i = 0; i < nombresGenero.size(); i++) {
            data[i][0] = false; 
            data[i][1] = nombresGenero.get(i); 
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
              
                return column == 0 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
            
                return column == 0;
            }
        };
        TablaGeneros.setModel(tableModel);
        
        List<String> nombresArtistas = UController.obtenerNombresArtistas();
        for (String nombreA : nombresArtistas) {
            comboBoxArtista.addItem(nombreA);
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
        fileMP3 = new javax.swing.JTextField();
        btnMP3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        DatosGenero = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCanciones = new javax.swing.JTable();
        AceptarCancion = new javax.swing.JButton();
        Finalizar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        PanelAlbum = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        anioAlbum = new javax.swing.JTextField();
        NombreAlbum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AceptarAlbum = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaGeneros = new javax.swing.JTable();
        fileImg = new javax.swing.JTextField();
        btnImg = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        AceptarArtista = new javax.swing.JButton();
        comboBoxArtista = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alta de Album");
        setMinimumSize(new java.awt.Dimension(350, 300));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel1.setText("Artista:");

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

        jLabel16.setText("Ruta MP3");

        DatosGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Genero" }));
        DatosGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatosGeneroActionPerformed(evt);
            }
        });

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

        jLabel17.setText("Genero Cancion");

        javax.swing.GroupLayout agregarCancionPanelLayout = new javax.swing.GroupLayout(agregarCancionPanel);
        agregarCancionPanel.setLayout(agregarCancionPanelLayout);
        agregarCancionPanelLayout.setHorizontalGroup(
            agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarCancionPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                .addComponent(AceptarCancion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Finalizar))
                            .addComponent(jLabel8)
                            .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                        .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel16))
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarCancionPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)))
                                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DatosGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(agregarCancionPanelLayout.createSequentialGroup()
                                        .addComponent(fileMP3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnMP3)))))
                        .addGap(0, 26, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileMP3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMP3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarCancionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(DatosGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
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

        jLabel15.setText("Ruta Img");

        javax.swing.GroupLayout PanelAlbumLayout = new javax.swing.GroupLayout(PanelAlbum);
        PanelAlbum.setLayout(PanelAlbumLayout);
        PanelAlbumLayout.setHorizontalGroup(
            PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAlbumLayout.createSequentialGroup()
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
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlbumLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(79, 79, 79))
                    .addGroup(PanelAlbumLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(51, 51, 51)
                        .addComponent(fileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImg)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAlbumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AceptarAlbum)
                .addGap(91, 91, 91))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImg)
                    .addComponent(jLabel15))
                .addGap(8, 8, 8)
                .addGroup(PanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AceptarAlbum)
                .addGap(155, 155, 155))
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AceptarArtista)
                        .addGap(196, 196, 196))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(agregarCancionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1212, 1212, 1212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboBoxArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(AceptarArtista)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agregarCancionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(379, Short.MAX_VALUE))
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
  
    private void cargarGeneros(){
        List<String> generos = ObtenerGenerosSeleccionados();
        
        for (String nombreG : generos) {
            
            DatosGenero.addItem(nombreG);
            
        }
    }
  
  
    private void nombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCActionPerformed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

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

    private void posActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posActionPerformed

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
        JFileChooser fc1= new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP3", "mp3");
        fc1.setFileFilter(filter);

        fc1.showOpenDialog(fc1);
        File imgfile = fc1.getSelectedFile();
        String filepath2=imgfile.getAbsolutePath();
        fileMP3.setText(filepath2);
    }//GEN-LAST:event_btnMP3ActionPerformed

    private void AceptarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarCancionActionPerformed

        if (!(nombreC.getText().isEmpty() || duracion.getText().isEmpty() || fileMP3.getText().isEmpty() ||DatosGenero.getSelectedItem().toString().equals("Seleccione Genero"))) {
            jScrollPane2.setVisible(true);
            int duracionnum = Integer.parseInt(duracion.getText());

            model.addRow(new Object[]{pos.getText(),nombreC.getText(), duracionnum, fileMP3.getText(),DatosGenero.getSelectedItem().toString(), "Eliminar"});
            TablaCanciones.setModel(model);
            

            ButtonColumn buttonColumn = new ButtonColumn(TablaCanciones, 6); // 4 es el índice de la columna "Eliminar"
            TablaCanciones.getColumnModel().getColumn(5).setCellRenderer(buttonColumn);
            TablaCanciones.getColumnModel().getColumn(5).setCellEditor(buttonColumn);

            JOptionPane.showMessageDialog(this, "Tema añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Se ingresaron campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_AceptarCancionActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed

        DefaultTableModel model = (DefaultTableModel) TablaCanciones.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        Object[][] datosCancion = new Object[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                datosCancion[row][column] = model.getValueAt(row, column);  // Copiar cada valor de la celda al array
            }
        }

        List<String> generosSeleccionados = ObtenerGenerosSeleccionados();
        if (NombreAlbum.getText().isEmpty() || anioAlbum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Campos vacios en Album", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!AController.buscarArtista(comboBoxArtista.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: El artista ingresado no existe o es vacío", "Error", JOptionPane.ERROR_MESSAGE);
            PanelAlbum.setVisible(false);
        } else if (datosCancion.length<1) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Ingrese alguna cancion", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ((generosSeleccionados.size() < 1)) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: Ingrese algun genero", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                AController.CrearAlbum(NombreAlbum.getText(), Integer.parseInt(anioAlbum.getText()), comboBoxArtista.getSelectedItem().toString(), fileImg.getText(),datosCancion, generosSeleccionados);
                JOptionPane.showMessageDialog(this, "Alta de Album creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_FinalizarActionPerformed

    private void anioAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioAlbumActionPerformed

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

    private void NombreAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAlbumActionPerformed

    private void AceptarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarAlbumActionPerformed
        List<String> generosSeleccionados = ObtenerGenerosSeleccionados();
        DatosGenero.removeAllItems();
        cargarGeneros();
        if(NombreAlbum.getText().isEmpty() || anioAlbum.getText().isEmpty()||generosSeleccionados.size()<1){
            JOptionPane.showMessageDialog(this,"Ocurrió un error: Se ingresaron campos vacios" ,"Error",JOptionPane.ERROR_MESSAGE);
        }else{
            agregarCancionPanel.setVisible(true);
        }
    }//GEN-LAST:event_AceptarAlbumActionPerformed

    private void AceptarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarArtistaActionPerformed
        String nomAr = comboBoxArtista.getSelectedItem().toString();
        agregarCancionPanel.setVisible(false);
        PanelAlbum.setVisible(true);
//        if (AController.buscarArtista(nomAr)) {
//            PanelAlbum.setVisible(true);
//
//        } else {
//            JOptionPane.showMessageDialog(this,"Ocurrió un error: El artista ingresado no existe o es vacío" ,"Error",JOptionPane.ERROR_MESSAGE);
//            PanelAlbum.setVisible(false);
//        }
    }//GEN-LAST:event_AceptarArtistaActionPerformed

    private void DatosGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosGeneroActionPerformed

    }//GEN-LAST:event_DatosGeneroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarAlbum;
    private javax.swing.JButton AceptarArtista;
    private javax.swing.JButton AceptarCancion;
    private javax.swing.JComboBox<String> DatosGenero;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextField NombreAlbum;
    private javax.swing.JPanel PanelAlbum;
    private javax.swing.JTable TablaCanciones;
    private javax.swing.JTable TablaGeneros;
    private javax.swing.JPanel agregarCancionPanel;
    private javax.swing.JTextField anioAlbum;
    private javax.swing.JButton btnImg;
    private javax.swing.JButton btnMP3;
    private javax.swing.JComboBox<String> comboBoxArtista;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField fileImg;
    private javax.swing.JTextField fileMP3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
