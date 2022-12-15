package com.hotel.bl.dtos;

public class HabitacionDto {
	
	private int id;	
	private String numero;	
	private String descripcion;	
	private TipoHabitacionDto tipoHabitacion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoHabitacionDto getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacionDto tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
}
