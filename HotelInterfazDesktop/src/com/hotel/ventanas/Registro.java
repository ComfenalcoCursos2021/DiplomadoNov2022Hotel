package com.hotel.ventanas;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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

import com.hotel.conn.HotelConn;
import com.hotel.dto.ContactoFront;
import com.hotel.dto.HabitacionFront;
import com.hotel.dto.RegistroFront;
import com.hotel.dto.TipoHabitacionFront;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;

import test.Main;
import java.awt.Dimension;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaIngreso;
	private JTextField txtFechaSalida;
	private JComboBox cbTipoHabitacion;
	private JTextField txtNombres;
	private JTextField txtContacto;
	private JTable tblContactos;
	private JComboBox cbHabitacionesLibres;
	private JButton btnAgregarContacto;
	private List<ContactoFront> contactosRegistro;
	private JSpinner spinCantidadPersonas;
	private DateChooser dateChooserFechaIngreso;
	private DateChooser dateChooserFechaSalida;
	private JTextField txtIdRegistro;
	

	/**
	 * Create the dialog.
	 */
	public Registro() {
		
		contactosRegistro = new ArrayList<ContactoFront>();
		dateChooserFechaIngreso = new DateChooser();
		dateChooserFechaSalida = new DateChooser();
		dateChooserFechaIngreso.setDateFormat("yyyy/MM/dd");
		dateChooserFechaSalida.setDateFormat("yyyy/MM/dd");
		setTitle("REGISTRO");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		setBounds(100, 100, 482, 691);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblFechaIngreso = new JLabel("Fecha Ingreso  YYYY/MM/DD");
			lblFechaIngreso.setBounds(10, 108, 214, 14);
			contentPanel.add(lblFechaIngreso);
		}
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setBounds(267, 92, 86, 30);
		contentPanel.add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);
		dateChooserFechaIngreso.setTextRefernce(txtFechaIngreso);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setPreferredSize(new Dimension(100, 30));
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBounds(267, 128, 86, 30);
		contentPanel.add(txtFechaSalida);
		dateChooserFechaSalida.setTextRefernce(txtFechaSalida);
		
		JLabel lblFechaSalidaYyyymmdd = new JLabel("Fecha Salida  YYYY/MM/DD");
		lblFechaSalidaYyyymmdd.setBounds(10, 136, 214, 14);
		contentPanel.add(lblFechaSalidaYyyymmdd);
		
		JLabel lblTipoHabitacion = new JLabel("Tipo Habitacion");
		lblTipoHabitacion.setBounds(10, 168, 95, 14);
		contentPanel.add(lblTipoHabitacion);
		
		cbTipoHabitacion = new JComboBox();
		cbTipoHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recargarHabitacionesLibres();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cbTipoHabitacion.setBounds(115, 164, 95, 22);
		contentPanel.add(cbTipoHabitacion);
		
		JLabel lblTipoCant = new JLabel("Cant Personas");
		lblTipoCant.setBounds(263, 165, 86, 14);
		contentPanel.add(lblTipoCant);
		
		spinCantidadPersonas = new JSpinner();
		spinCantidadPersonas.setBounds(344, 162, 60, 24);
		contentPanel.add(spinCantidadPersonas);
		
		JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones Disponibles");
		lblHabitacionesDisponibles.setBounds(10, 204, 214, 14);
		contentPanel.add(lblHabitacionesDisponibles);
		
		cbHabitacionesLibres = new JComboBox();
		cbHabitacionesLibres.setBounds(10, 229, 440, 22);
		contentPanel.add(cbHabitacionesLibres);
		
		JLabel lblHabitacionesDisponibles_1 = new JLabel("---------------------------------------------------");
		lblHabitacionesDisponibles_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesDisponibles_1.setBounds(10, 262, 394, 14);
		contentPanel.add(lblHabitacionesDisponibles_1);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(10, 296, 60, 14);
		contentPanel.add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(66, 287, 108, 26);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(178, 296, 60, 14);
		contentPanel.add(lblContacto);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(240, 287, 144, 26);
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
		btnAgregarContacto.setBounds(382, 292, 30, 23);
		contentPanel.add(btnAgregarContacto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 321, 416, 221);
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
		btnTomarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TOMANDO HABITACION");
				System.out.println(dateChooserFechaIngreso.getObjetoFecha());
				System.out.println(dateChooserFechaSalida.getObjetoFecha());
				
				RegistroFront nuevoRegistro = new RegistroFront();
				nuevoRegistro.setFechaIngreso(dateChooserFechaIngreso.getObjetoFecha());
				//nuevoRegistro.getCantidadPersonas()
				nuevoRegistro.setCantidadPersonas((int)spinCantidadPersonas.getValue());
				nuevoRegistro.setContactos(contactosRegistro);
				
				HabitacionFront hab = (HabitacionFront)cbHabitacionesLibres.getSelectedItem();
				nuevoRegistro.setHabitacion(hab);
				try {
					HotelConn.guardarRegistro(nuevoRegistro);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTomarHabitacion.setBounds(165, 553, 165, 23);
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
		btnEliminarContacto.setBounds(410, 292, 30, 23);
		contentPanel.add(btnEliminarContacto);
		
		JButton btnAbrirPopUpFechaIngreso = new JButton("New button");
		btnAbrirPopUpFechaIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooserFechaIngreso.showPopup();
			}
		});
		btnAbrirPopUpFechaIngreso.setBounds(363, 99, 41, 23);
		contentPanel.add(btnAbrirPopUpFechaIngreso);
		
		JButton btnAbrirPopUpFechaSalida = new JButton("New button");
		btnAbrirPopUpFechaSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooserFechaSalida.showPopup();
			}
		});
		btnAbrirPopUpFechaSalida.setBounds(363, 129, 41, 23);
		contentPanel.add(btnAbrirPopUpFechaSalida);
		
		JButton btnRecargarHabitacionesLibres = new JButton("New button");
		btnRecargarHabitacionesLibres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					recargarHabitacionesLibres();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRecargarHabitacionesLibres.setBounds(212, 164, 41, 23);
		contentPanel.add(btnRecargarHabitacionesLibres);
		
		txtIdRegistro = new JTextField();
		txtIdRegistro.setColumns(10);
		txtIdRegistro.setBounds(186, 35, 86, 30);
		contentPanel.add(txtIdRegistro);
		
		JButton btnCargarRegistro = new JButton("New button");
		btnCargarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtIdRegistro.getText().trim().length() > 0) {
					try {
						RegistroFront registro = HotelConn.obtenerRegistro(Integer.valueOf(txtIdRegistro.getText()));
						contactosRegistro = registro.getContactos();
						
						cbTipoHabitacion.setSelectedItem(registro.getHabitacion().getTipoHabitacion());
						DefaultComboBoxModel nuevo = new DefaultComboBoxModel();
						nuevo.addElement(registro.getHabitacion());
						cbHabitacionesLibres.setModel(nuevo);
						dateChooserFechaIngreso.setSelectedDate(registro.getFechaIngreso());
						
						
						
						refrescarContactos();
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCargarRegistro.setBounds(289, 39, 41, 23);
		contentPanel.add(btnCargarRegistro);
		
		JLabel lblIdDeRegistro = new JLabel("Id de Registro");
		lblIdDeRegistro.setBounds(10, 43, 165, 14);
		contentPanel.add(lblIdDeRegistro);
		
		
		dateChooserFechaIngreso.addEventDateChooser(new EventDateChooser() {
			
			@Override
			public void dateSelected(SelectedAction action, SelectedDate date) {
				if (action.getAction() == SelectedAction.DAY_SELECTED) {
					dateChooserFechaIngreso.hidePopup();
                }
			}
		});
		dateChooserFechaSalida.addEventDateChooser(new EventDateChooser() {
			
			@Override
			public void dateSelected(SelectedAction action, SelectedDate date) {
				if (action.getAction() == SelectedAction.DAY_SELECTED) {
					dateChooserFechaSalida.hidePopup();
                }
			}
		});
		
		try {
			inicializarComtroles();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void inicializarComtroles() throws Exception {
		List<TipoHabitacionFront> tiposHabitaciones = HotelConn.obtenerTiposHabitaciones();
		DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
		modeloCombo.addAll(tiposHabitaciones);
		cbTipoHabitacion.setModel(modeloCombo);
		cbTipoHabitacion.setSelectedIndex(0);
		
		recargarHabitacionesLibres();		
	}
	private void recargarHabitacionesLibres() throws Exception {
		
		TipoHabitacionFront tipoSeleccionado = (TipoHabitacionFront) cbTipoHabitacion.getSelectedItem();
		
		List<HabitacionFront> libres = HotelConn.obtenerHabitacionesLibres(tipoSeleccionado.getId());
		DefaultComboBoxModel modeloComboLibres = new DefaultComboBoxModel();
		modeloComboLibres.addAll(libres);
		cbHabitacionesLibres.setModel(modeloComboLibres);
		if(libres != null && libres.size() > 0) {
			cbHabitacionesLibres.setSelectedIndex(0);
		}
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
