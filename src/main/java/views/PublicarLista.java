package views;

import controllers.Fabrica;
import controllers.IPlaylistController;
import controllers.IUsuarioController;
import controllers.PlaylistController;
import controllers.UsuarioController;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout.Alignment.*;
import java.util.ArrayList;


public class PublicarLista extends javax.swing.JInternalFrame{
        Fabrica fabrica = Fabrica.getInstance();
	IUsuarioController usr_ctr = fabrica.getIUsuarioController();
	IPlaylistController pylt_ctr = fabrica.getIPlaylistController();

	int PREFERRED_SIZE = javax.swing.GroupLayout.PREFERRED_SIZE;
	int DEFAULT_SIZE = javax.swing.GroupLayout.DEFAULT_SIZE;
	int MAX_VALUE = Short.MAX_VALUE;

	javax.swing.GroupLayout.Alignment LEADING = javax.swing.GroupLayout.Alignment.LEADING;
	javax.swing.GroupLayout.Alignment TRAILING = javax.swing.GroupLayout.Alignment.TRAILING;
       	javax.swing.GroupLayout.Alignment CENTER = javax.swing.GroupLayout.Alignment.CENTER;
	javax.swing.GroupLayout.Alignment BASELINE = javax.swing.GroupLayout.Alignment.BASELINE;

	//Para no tener que buscar que id (PK) le corresponde a el nombre de la playlist seleccionada
	private List<Integer> los_ids_de_las_playlists = new ArrayList<Integer>();

	//para solo borrar los items de Play_List_Combo_Box cuando se necesite
	boolean borrar_items_pylt=false;
	String item_anterior_cliente_cb = "Seleccione el Cliente";

	public PublicarLista(){
		initComponents();
		//PanelWh
		el_panel.setVisible(true);
		List<String> nombres_clientes = usr_ctr.obtenerNombresClientes();
		for (String nombre_un_cliente : nombres_clientes){
			Cliente_Combo_Box.addItem(nombre_un_cliente);
		}
	
	}

	private void initComponents(){
	
	el_panel = new javax.swing.JPanel();
	etiqueta_cliente = new javax.swing.JLabel();
	etiqueta_playlist = new javax.swing.JLabel();
	Cliente_Combo_Box = new javax.swing.JComboBox<>();
	Play_List_Combo_Box = new javax.swing.JComboBox<>();
	Boton_Publicar = new javax.swing.JButton();

	setClosable(true);
	setIconifiable(true);
	setMaximizable(true);
	setResizable(true);
	setTitle("Publicar Lista");
	setPreferredSize(new java.awt.Dimension(800, 600));


	etiqueta_cliente.setText("Cliente: ");
	etiqueta_playlist.setText("Lista de Reproducción: ");

	Cliente_Combo_Box.setModel( new javax.swing.DefaultComboBoxModel<>(new String[] 
				{"Seleccione el Cliente"}
	));
	Cliente_Combo_Box.addActionListener(new java.awt.event.ActionListener(){
		public void actionPerformed(java.awt.event.ActionEvent evt){
			Cliente_Combo_Box_ActionPerformed(evt);
		}
	});
	Cliente_Combo_Box.setEditable(true);

	//javax.swing.MutableComboBoxModel<String>();
	Play_List_Combo_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Seleccione una Lista de Reproducción"}));

	Play_List_Combo_Box.addActionListener(new java.awt.event.ActionListener(){
		public void actionPerformed(java.awt.event.ActionEvent evt){
			Play_List_Combo_Box_ActionPerformed(evt);
		}
	});

	Play_List_Combo_Box.setEditable(true);
	Boton_Publicar.setText("Publicar");

	Boton_Publicar.addActionListener( new java.awt.event.ActionListener(){
		public void actionPerformed(java.awt.event.ActionEvent evt){
			Boton_Publicar_ActionPerformed(evt);
		}
	}
	);
	
	
	//el_panel.setLayout(el_panel_layout);
	
	javax.swing.GroupLayout el_panel_layout = new javax.swing.GroupLayout(getContentPane());
	getContentPane().setLayout(el_panel_layout);
	
	el_panel_layout.setHorizontalGroup( 

		//Client: [combobox]
		el_panel_layout.createParallelGroup( LEADING )
		.addGroup(TRAILING, el_panel_layout.createSequentialGroup()
			//.addGap(28,28,28);
			.addComponent(etiqueta_cliente)
			//.addGap(32,32,32)
			.addComponent(Cliente_Combo_Box, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
			//.addContainerGap(130, MAX_VALUE)
		)

		//Lista de Reproducción: [combobox]
		.addGroup(TRAILING, el_panel_layout.createSequentialGroup()
			.addComponent(etiqueta_playlist)
			.addComponent(Play_List_Combo_Box, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
		)
		.addComponent(Boton_Publicar, CENTER)
		
	);

	el_panel_layout.setVerticalGroup(
	
		el_panel_layout.createSequentialGroup()
		.addGroup(el_panel_layout.createParallelGroup()
			.addComponent(etiqueta_cliente,LEADING, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
			.addComponent(Cliente_Combo_Box, TRAILING, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
		)
		.addGroup(el_panel_layout.createParallelGroup()
			.addComponent(etiqueta_playlist, LEADING, PREFERRED_SIZE, DEFAULT_SIZE,PREFERRED_SIZE)
			.addComponent(Play_List_Combo_Box, TRAILING, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
		)
		.addComponent(Boton_Publicar)
	);
	pack();
	}
	private void Cliente_Combo_Box_ActionPerformed(java.awt.event.ActionEvent evt){
		
		//System.out.println("------");
		//System.out.println(Play_List_Combo_Box.getItemCount());
		if (item_anterior_cliente_cb.equals(Cliente_Combo_Box.getSelectedItem().toString())){
			//System.out.println("mismo");
			
			return;
		}
		item_anterior_cliente_cb = Cliente_Combo_Box.getSelectedItem().toString();

		los_ids_de_las_playlists.clear();
		//Play_List_Combo_Box.addItem("Seleccione una Lista de Reproducción");

		//System.out.println(Cliente_Combo_Box.getSelectedItem().toString());
		
		try{
		List<String> nombres_listas_de_reproduccions = pylt_ctr.obtenerNombresPlaylistParticularCliente(Cliente_Combo_Box.getSelectedItem().toString());
		
		if (nombres_listas_de_reproduccions.size() == 0){
			return;
		}
			if(borrar_items_pylt){
			//System.out.println("Aqui");
				Play_List_Combo_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Seleccione una Lista de Reproducción"}));
				if ("Seleccione al Cliente".equals(Cliente_Combo_Box.getSelectedItem().toString())){
					return;
				}
			}
			//System.out.println(".......");
			
		int indice_guion;
		String id_de_playlist_String;
		int id_de_playlist_int;
		for (String nombre_un_lista_de_reproduccion : nombres_listas_de_reproduccions){
			// quitamos el "[id] - " de "[id] - [nombre]"
			id_de_playlist_String = nombre_un_lista_de_reproduccion;

			
			indice_guion = nombre_un_lista_de_reproduccion.indexOf("-");
			//para que string recortado no incluya el guion
			indice_guion++;
			nombre_un_lista_de_reproduccion=nombre_un_lista_de_reproduccion.substring(indice_guion).trim();
			id_de_playlist_String = id_de_playlist_String.substring(0,indice_guion-1).trim();
			id_de_playlist_int = Integer.parseInt(id_de_playlist_String);
			los_ids_de_las_playlists.add(id_de_playlist_int);
			//System.out.println(id_de_playlist_int + " - "+nombre_un_lista_de_reproduccion);
			
			Play_List_Combo_Box.addItem(nombre_un_lista_de_reproduccion);
			borrar_items_pylt= true;
		}
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		////System.out.println("Un item ingresado: "+Play_List_Combo_Box.getItemAt(2).toString());
		
		//System.out.println("------");
		
	}
	private void Play_List_Combo_Box_ActionPerformed(java.awt.event.ActionEvent evt){
		
		//System.out.println("------");
		//System.out.println(los_ids_de_las_playlists.get(Play_List_Combo_Box.getSelectedIndex()));
		//System.out.println(Play_List_Combo_Box.getSelectedIndex());
		//System.out.println("------");
	}
	private void Boton_Publicar_ActionPerformed(java.awt.event.ActionEvent evt){
		//System.out.println("------");
		if ("Seleccione una Lista de Reproducción".equals(Play_List_Combo_Box.getSelectedItem().toString())){
			return;
		}
		try {
			//Menos uno: por que la lista de items empieza con "Seleccione una Lista de Reproducción", nuestras 
			//los_ids_de_las_playlists empieza con el id de la primera lista
		pylt_ctr.Publicar_Lista(los_ids_de_las_playlists.get(Play_List_Combo_Box.getSelectedIndex()-1));
		//System.out.println(los_ids_de_las_playlists.get(Play_List_Combo_Box.getSelectedIndex()-1));
		//System.out.println(Play_List_Combo_Box.getSelectedIndex()-1);
		
		JOptionPane.showMessageDialog(this, "Lista publicada exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e){

			JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		//System.out.println("------");
		}
	}








	private javax.swing.JPanel el_panel;
	private javax.swing.JLabel etiqueta_cliente;
	private javax.swing.JLabel etiqueta_playlist;
	private javax.swing.JComboBox<String> Cliente_Combo_Box;
	private	javax.swing.JComboBox<String> Play_List_Combo_Box;
	private javax.swing.JButton Boton_Publicar;
}

