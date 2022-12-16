package com.hotel.ventanas;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotel.dto.ContactoFront;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox cbTipoHabitacion;
	private JTextField txtNombres;
	private JTextField txtContacto;
	private JTable tblContactos;
	private JComboBox cbHabitacionesLibres;
	private JButton btnAgregarContacto;
	private List<ContactoFront> contactosRegistro;
	

	/**
	 * Create the dialog.
	 */
	public Registro() {
		contactosRegistro = new ArrayList<ContactoFront>();
		setTitle("REGISTRO");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		setBounds(100, 100, 482, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblFechaIngreso = new JLabel("Fecha Ingreso  YYYY/MM/DD");
			lblFechaIngreso.setBounds(10, 40, 146, 14);
			contentPanel.add(lblFechaIngreso);
		}
		
		textField = new JTextField();
		textField.setBounds(296, 34, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 62, 86, 20);
		contentPanel.add(textField_1);
		
		JLabel lblFechaSalidaYyyymmdd = new JLabel("Fecha Salida  YYYY/MM/DD");
		lblFechaSalidaYyyymmdd.setBounds(10, 68, 146, 14);
		contentPanel.add(lblFechaSalidaYyyymmdd);
		
		JLabel lblTipoHabitacion = new JLabel("Tipo Habitacion");
		lblTipoHabitacion.setBounds(10, 100, 95, 14);
		contentPanel.add(lblTipoHabitacion);
		
		cbTipoHabitacion = new JComboBox();
		cbTipoHabitacion.setBounds(115, 96, 95, 22);
		contentPanel.add(cbTipoHabitacion);
		
		JLabel lblTipoCant = new JLabel("Cant Personas");
		lblTipoCant.setBounds(244, 100, 86, 14);
		contentPanel.add(lblTipoCant);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(340, 97, 45, 20);
		contentPanel.add(spinner);
		
		JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones Disponibles");
		lblHabitacionesDisponibles.setBounds(10, 136, 214, 14);
		contentPanel.add(lblHabitacionesDisponibles);
		
		cbHabitacionesLibres = new JComboBox();
		cbHabitacionesLibres.setBounds(10, 161, 440, 22);
		contentPanel.add(cbHabitacionesLibres);
		
		JLabel lblHabitacionesDisponibles_1 = new JLabel("---------------------------------------------------");
		lblHabitacionesDisponibles_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesDisponibles_1.setBounds(10, 194, 394, 14);
		contentPanel.add(lblHabitacionesDisponibles_1);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(10, 228, 60, 14);
		contentPanel.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(66, 225, 108, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(178, 228, 60, 14);
		contentPanel.add(lblContacto);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(240, 225, 144, 20);
		contentPanel.add(txtContacto);
		
		btnAgregarContacto = new JButton("+");
		btnAgregarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombres.getText();
				String contacto = txtContacto.getText();
				
				StringBuilder errores = new StringBuilder();
				if(nombre == null || nombre.trim().length() == 0 ) {
					errores.append("Nombre invalido\r\n");
				}
				if(contacto == null || contacto.trim().length() == 0 ) {
					errores.append("Contacto invalido");					
				}
				
				if(errores.toString().length()> 0) {
					javax.swing.JOptionPane.showMessageDialog(null, errores.toString());
					return;
				}
				
				ContactoFront nuevo = new ContactoFront();
				nuevo.setContacto(contacto);
				nuevo.setNombres(nombre);
				
				contactosRegistro.add(nuevo);
				
				refrescarContactos();
				txtNombres.setText("");
				txtContacto.setText("");
			}
		});
		btnAgregarContacto.setMargin(new Insets(0, 0, 0, 0));
		btnAgregarContacto.setBounds(382, 224, 30, 23);
		contentPanel.add(btnAgregarContacto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 253, 416, 221);
		contentPanel.add(scrollPane);
		
		tblContactos = new JTable();
		tblContactos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			
			},
			new String[] {
				"Nombres", "Contacto"
			}
		));
		scrollPane.setViewportView(tblContactos);
		
		JButton btnTomarHabitacion = new JButton("Tomar Habitacion");
		btnTomarHabitacion.setBounds(165, 485, 165, 23);
		contentPanel.add(btnTomarHabitacion);
		
		JButton btnEliminarContacto = new JButton("-");
		btnEliminarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contactosRegistro.size() > 0) {
					contactosRegistro.remove(contactosRegistro.size()-1);
					refrescarContactos();
				}
			}
		});
		btnEliminarContacto.setMargin(new Insets(0, 0, 0, 0));
		btnEliminarContacto.setBounds(410, 224, 30, 23);
		contentPanel.add(btnEliminarContacto);
	}
	
	public void refrescarContactos() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombres");
		modelo.addColumn("Contacto");
		for (ContactoFront contactoFront : contactosRegistro) {
			modelo.addRow(contactoFront.getRowTableModel());
		}
		tblContactos.setModel(modelo);
	}
}
