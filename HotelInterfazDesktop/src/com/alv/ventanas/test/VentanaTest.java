package com.alv.ventanas.test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hotel.conn.HotelConn;
import com.hotel.dto.HabitacionFront;
import com.hotel.dto.TipoHabitacionFront;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaTest extends JFrame {

	/**
	 * 
	 */
	private int ULTIMO_TIPO_HABITACION_SELECCIONADO = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTexto;
	private JComboBox cbTipoHabitaciones;
	private JLabel lblNewLabel;
	private JComboBox cbHabitaciones;
	private JButton btnRefresh;
	private JTable tblHabitacionesLibres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTest frame = new VentanaTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCargarTexto = new JButton("Cargar");
		btnCargarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String body = "{\r\n" + "  \"descripcion\": \"la desc\",\r\n" + "  \"id\": 3\r\n" + "}";
				try {
					List<TipoHabitacionFront> tiposHabitaciones = HotelConn.obtenerTiposHabitaciones();
					DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
					for (TipoHabitacionFront element : tiposHabitaciones) {
						System.out.println(element.getId() + " - " + element.getDescripcion());
						txtTexto.setText(element.getId() + " - " + element.getDescripcion());
						System.out.println("ESTE ES EL ELEMENTO -> " + element);
						modeloCombo.addElement(element);
					}
					cbTipoHabitaciones.setModel(modeloCombo);

					recargarComboHabitaciones();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					txtTexto.setText((new Date()).toString());
				}

			}

		});
		btnCargarTexto.setBounds(47, 11, 89, 23);
		contentPane.add(btnCargarTexto);

		txtTexto = new JTextField();
		txtTexto.setBounds(146, 12, 232, 20);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);

		cbTipoHabitaciones = new JComboBox();
		cbTipoHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoHabitacionFront tipoSeleccionado = (TipoHabitacionFront) ((JComboBox) e.getSource())
						.getSelectedItem();
				System.out.println("INTEREACTUO CON EL ELEMENTO -> " + tipoSeleccionado);

				if (ULTIMO_TIPO_HABITACION_SELECCIONADO != tipoSeleccionado.getId()) {
					try {
						
						recargarComboHabitaciones();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ULTIMO_TIPO_HABITACION_SELECCIONADO = tipoSeleccionado.getId();
				}

			}
		});
		cbTipoHabitaciones.setBounds(47, 45, 290, 22);
		contentPane.add(cbTipoHabitaciones);

		JButton btnPruebaSeleccion = new JButton("Prueba Seleccion");
		btnPruebaSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoHabitacionFront tipoSeleccionado = (TipoHabitacionFront) cbTipoHabitaciones.getSelectedItem();
				lblNewLabel.setText(
						"El seleccionado es -> " + tipoSeleccionado.getId() + " " + tipoSeleccionado.getDescripcion());
				try {
					recargarComboHabitaciones();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPruebaSeleccion.setBounds(47, 78, 136, 23);
		contentPane.add(btnPruebaSeleccion);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(193, 82, 187, 14);
		contentPane.add(lblNewLabel);

		cbHabitaciones = new JComboBox();
		cbHabitaciones.setBounds(47, 110, 331, 22);
		contentPane.add(cbHabitaciones);

		btnRefresh = new JButton("☺");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cbHabitaciones.setSelectedIndex(-1);
					
					recargarComboHabitaciones();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(350, 44, 28, 25);
		contentPane.add(btnRefresh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 143, 331, 158);
		contentPane.add(scrollPane);

		tblHabitacionesLibres = new JTable();
		tblHabitacionesLibres.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblHabitacionesLibres);
	}

	private void recargarComboHabitaciones() throws Exception {
		TipoHabitacionFront tipoHab = (TipoHabitacionFront) cbTipoHabitaciones.getSelectedItem();
		List<HabitacionFront> libres = HotelConn.obtenerHabitacionesLibres(tipoHab.getId());

		DefaultTableModel modeloTabla = new DefaultTableModel();

		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Numero");
		modeloTabla.addColumn("Descripcion");

		for (HabitacionFront hab : libres) {
			modeloTabla.addRow(hab.getRowTableModel());
		}
		tblHabitacionesLibres.setModel(modeloTabla);

		DefaultComboBoxModel modeloHabitaciones = new DefaultComboBoxModel();
		modeloHabitaciones.addAll(libres);
		cbHabitaciones.setModel(modeloHabitaciones);
		cbHabitaciones.setSelectedIndex(0);
	}
}
