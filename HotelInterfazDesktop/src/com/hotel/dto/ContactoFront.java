package com.hotel.dto;

import java.util.Vector;

public class ContactoFront {
	private int id;	
	private String nombres;	
	private String contacto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Object[] getRowTableModel() {
		Object[] row = new Object[2];
		row[0] = this.nombres;
		row[1] = this.contacto;
		return row;
	}	
}
