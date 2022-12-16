package com.hotel.dto;

import java.util.Vector;

public class HabitacionFront {

	private int id;
	private String descripcion;
	private String numero;
	private TipoHabitacionFront tipoHabitacion;
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoHabitacionFront getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacionFront tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public String toString() {
		return this.numero + " - " + this.descripcion; 
	}
	public Object[] getRowTableModel() {
		Object[] row = new Object[3];
		row[0] = this.id;
		row[1] = this.numero;
		row[2] = this.descripcion;
		return row;
	}
	
}
