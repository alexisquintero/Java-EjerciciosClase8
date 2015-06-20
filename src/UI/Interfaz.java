package UI;

import java.awt.EventQueue;

import controlador.*;
import entidades.*;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.miginfocom.swing.MigLayout;


public class Interfaz {
	
	CapaControlador cc = new CapaControlador();
	
	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtEmail;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JTextField Respuesta;
	private JButton btnActualizar;
	private JTable listado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5){
					btnActualizarClick();
				}
			}
		});
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNombre.setText(txtNombre.getText().equals("Nombre")?"":txtNombre.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtNombre.setText(txtNombre.getText().length() == 0?"Nombre":txtNombre.getText());
			}
		});
		frame.getContentPane().setLayout(new MigLayout("", "[89px][89px][10px][142.00px,grow][20px,grow][70px]", "[20px][20px][20px][23px][20px][232px,grow,fill][22px,bottom]"));
		txtNombre.setText("Nombre");
		frame.getContentPane().add(txtNombre, "cell 0 0 2 1,growx,aligny top");
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtApellido.setText(txtApellido.getText().equals("Apellido")?"":txtApellido.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtApellido.setText(txtApellido.getText().length() == 0?"Apellido":txtApellido.getText());
			}
		});
		txtApellido.setText("Apellido");
		frame.getContentPane().add(txtApellido, "cell 2 0 4 1,growx,aligny top");
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDni.setText(txtDni.getText().equals("DNI")?"":txtDni.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtDni.setText(txtDni.getText().length() == 0?"DNI":txtDni.getText());
			}
		});
		txtDni.setText("DNI");
		frame.getContentPane().add(txtDni, "cell 0 2 2 1,growx,aligny top");
		txtDni.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.setText(txtEmail.getText().equals("Email")?"":txtEmail.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtEmail.setText(txtEmail.getText().length() == 0?"Email":txtEmail.getText());
			}
		});
		txtEmail.setText("Email");
		frame.getContentPane().add(txtEmail, "cell 0 1 6 1,growx,aligny top");
		txtEmail.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnGuardarClick();
				}
				
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardarClick();
			}
		});
		frame.getContentPane().add(btnGuardar, "cell 0 3,grow");
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnBuscarClick();
				}
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarClick();
			}
		});
		frame.getContentPane().add(btnBuscar, "cell 1 3,grow");
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrarClick();
			}
		});
		frame.getContentPane().add(btnBorrar, "cell 5 3,alignx right,aligny top");
		
		Respuesta = new JTextField();
		Respuesta.setEditable(false);
		frame.getContentPane().add(Respuesta, "cell 0 4 6 1,growx,aligny top");
		Respuesta.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnActualizarClick();
				}
			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActualizarClick();
			}
		});
		frame.getContentPane().add(btnActualizar, "cell 4 6 2 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 0 5 6 1,grow");
		
		listado = new JTable();
		listado.setFillsViewportHeight(true);
		listado.setEnabled(false);
		listado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(listado);
		listado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Apellido", "Nombre", "DNI", "Email"
			}
		));
		
		JButton btnClear = new JButton("");
		btnClear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnClearClick();
				}													
			}});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearClick();
			}
		});
		frame.getContentPane().add(btnClear, "cell 2 3,alignx trailing,growy");
	}
	
	private void btnClearClick(){
		
		txtNombre.setText("Nombre");
		txtApellido.setText("Apellido");
		txtEmail.setText("Email");
		txtDni.setText("DNI");
		
	}
	
	private void btnActualizarClick(){
		
		ArrayList<Persona> al = new ArrayList<Persona>();
		al = cc.Listado();
		String[][] tabla = new String[al.size()][5];
		DefaultTableModel model = (DefaultTableModel) listado.getModel();

		model.setRowCount(0);
		
		for (int i = 0; i < al.size(); i++) {
			
			tabla[i][1] = al.get(i).getsApellido();
			tabla[i][2] = al.get(i).getsNombre();
			tabla[i][3] = String.valueOf(al.get(i).getiDni());
			tabla[i][4] = al.get(i).getsEmail();
			tabla[i][0] = String.valueOf(al.get(i).getiIdPersona());
			model.addRow(tabla[i]);
			
		}
		
	}
	
	private void btnBorrarClick(){
		
		String resp = "Valor inicial";
		
		if (txtDni.getText().equals("DNI")) {
			
			resp = "Ingrese un número de DNI";
			Respuesta.setText(resp);
			
		}else if(tryParseInt(txtDni.getText())){
			
			resp = cc.BajaPersona(Integer.parseInt(txtDni.getText()));
			Respuesta.setText(resp);
			
		} else {
			Respuesta.setText("DNI debe ser un número");
			txtDni.setText("DNI");
			return;
		}
		
		
	}
	
	private void btnBuscarClick(){
		
		Persona pUI = new Persona();
		String resp = "Valor inicial";
		int dni = -1;
		
		if (txtDni.getText().equals("DNI")) {
			
			resp = "Ingrese un número de DNI";
			Respuesta.setText(resp);
			return;
			
		} else if(tryParseInt(txtDni.getText())){
				
		    	dni = (Integer.parseInt(txtDni.getText()));	
					
		} else {
			Respuesta.setText("DNI debe ser un número");
			txtDni.setText("DNI");
			return;
		}
					
		pUI = cc.BuscaPersona(dni);
		
		if (pUI == null) {
			
			resp = "Persona no encontrada";
			Respuesta.setText(resp);
			
		} else {
			
			txtNombre.setText(pUI.getsNombre());
			txtApellido.setText(pUI.getsApellido());
			txtDni.setText(String.valueOf(pUI.getiDni()));
			txtEmail.setText(pUI.getsEmail());
			resp = "Persona encontrada";
			Respuesta.setText(resp);

		}
	}
	
	private void btnGuardarClick(){
		
		Persona pUI = new Persona();
		String resp = "Valor inicial";
		
		if (txtDni.getText().equals("DNI")) {
			
			resp = "Ingrese un número de DNI";
			Respuesta.setText(resp);
			return;
			
		} else if(tryParseInt(txtDni.getText())){
			
				int temp = Integer.parseInt(txtDni.getText());
				pUI.setiDni(temp); 						

		}else {
			Respuesta.setText("DNI debe ser un número");
			txtDni.setText("DNI");
			return;
		}
		
		if (txtNombre.getText().equals("Nombre")) {
			
			resp = "Ingrese un nombre";
			Respuesta.setText(resp);
			return;
			
		} else {
			
			pUI.setsNombre(txtNombre.getText());

		}
		
		if (txtApellido.getText().equals("Apellido")) {
			
			resp = "Ingrese un apellido";
			Respuesta.setText(resp);
			return;
			
		} else {
			
			pUI.setsApellido(txtApellido.getText());

		}
		
		if (txtEmail.getText().equals("Email")) {
			
			resp = "Ingrese un email";
			Respuesta.setText(resp);
			return;
			
		} else {
			
			pUI.setsEmail(txtEmail.getText());

		}
			
		resp = cc.CreaModificaPersona(pUI);
		txtApellido.setText("Apellido");
		txtNombre.setText("Nombre");
		txtEmail.setText("Email");
		txtDni.setText("DNI");
		Respuesta.setText(resp);
		btnActualizarClick();
	}
	
	boolean tryParseInt(String value)  
	{  
	     try  
	     {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch(NumberFormatException nfe)  
	      {  
	          return false;  
	      }  
	}
}
