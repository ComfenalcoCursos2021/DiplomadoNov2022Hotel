package com.hotel.contratos;

import java.io.Serializable;
import java.util.Date;

public class TipoHabitacion  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String descripcion;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String toString() {
		return this.descripcion;
	}
	
}
