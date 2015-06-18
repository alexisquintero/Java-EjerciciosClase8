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
		frame.getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
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
		txtNombre.setText("Nombre");
		txtNombre.setBounds(10, 11, 188, 20);
		frame.getContentPane().add(txtNombre);
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
		txtApellido.setBounds(208, 11, 216, 20);
		frame.getContentPane().add(txtApellido);
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
		txtDni.setBounds(10, 73, 146, 20);
		frame.getContentPane().add(txtDni);
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
		txtEmail.setBounds(10, 42, 414, 20);
		frame.getContentPane().add(txtEmail);
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
		btnGuardar.setBounds(10, 104, 89, 23);
		frame.getContentPane().add(btnGuardar);
		
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
		btnBuscar.setBounds(109, 104, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrarClick();
			}
		});
		btnBorrar.setBounds(335, 104, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		Respuesta = new JTextField();
		Respuesta.setEditable(false);
		Respuesta.setBounds(10, 138, 414, 20);
		frame.getContentPane().add(Respuesta);
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
		btnActualizar.setBounds(247, 412, 104, 22);
		frame.getContentPane().add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 414, 232);
		frame.getContentPane().add(scrollPane);
		
		listado = new JTable();
		listado.setFillsViewportHeight(true);
		listado.setEnabled(false);
		listado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(listado);
		listado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Apellido", "Nombre", "DNI", "Email"
			}
		));
		
		JButton btnClear = new JButton("");
		btnClear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnClearClick();
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearClick();
			}
		});
		btnClear.setBounds(208, 104, 23, 23);
		frame.getContentPane().add(btnClear);
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
		String[][] tabla = new String[al.size()][4];
		DefaultTableModel model = (DefaultTableModel) listado.getModel();

		model.setRowCount(0);
		
		for (int i = 0; i < al.size(); i++) {
			
			tabla[i][0] = al.get(i).getsApellido();
			tabla[i][1] = al.get(i).getsNombre();
			tabla[i][2] = String.valueOf(al.get(i).getiDni());
			tabla[i][3] = al.get(i).getsEmail();
			model.addRow(tabla[i]);
			
		}
		
	}
	
	private void btnBorrarClick(){
		
		String resp = "Valor inicial";
		
		if (txtDni.getText().equals("DNI")) {
			
			resp = "Ingrese un número de DNI";
			Respuesta.setText(resp);
			
		}else {
			
			resp = cc.BajaPersona(Integer.parseInt(txtDni.getText()));
			Respuesta.setText(resp);
			
		}
		
		
	}
	
	private void btnBuscarClick(){
		
		Persona pUI = new Persona();
		String resp = "Valor inicial";
		int dni = -1;
		
		if (txtDni.getText().equals("DNI")) {
			
			resp = "Ingrese un número de DNI";
			Respuesta.setText(resp);
			
		} else {
				
		    	dni = (Integer.parseInt(txtDni.getText()));	
					
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
			
		} else {
			
				int temp = Integer.parseInt(txtDni.getText());
				pUI.setiDni(temp); 						

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
	
	
/*	public boolean isInteger(String string) {
	    try {
	        Integer.valueOf(string);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}
*/
}
