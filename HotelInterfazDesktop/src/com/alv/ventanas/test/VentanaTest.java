package com.alv.ventanas.test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hotel.dto.TipoHabitacionFront;
import com.hotel.httphelper.HttpHelper;

public class VentanaTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTexto;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCargarTexto = new JButton("Cargar");
		btnCargarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String body = "{\r\n" + "  \"descripcion\": \"la desc\",\r\n" + "  \"id\": 3\r\n" + "}";
				try {
					List<TipoHabitacionFront> tiposHabitaciones = HttpHelper.obtenerTiposHabitaciones();
					for (TipoHabitacionFront element : tiposHabitaciones) {
						System.out.println(element.getId() + " - " + element.getDescripcion());
						txtTexto.setText(element.getId() + " - " + element.getDescripcion());
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					txtTexto.setText((new Date()).toString());
				}

			}
		});
		btnCargarTexto.setBounds(76, 80, 89, 23);
		contentPane.add(btnCargarTexto);

		txtTexto = new JTextField();
		txtTexto.setBounds(175, 81, 232, 20);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);
	}

}
