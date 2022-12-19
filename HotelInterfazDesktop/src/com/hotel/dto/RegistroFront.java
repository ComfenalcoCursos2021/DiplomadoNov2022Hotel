package com.hotel.dto;

import java.util.Date;
import java.util.List;

public class RegistroFront {
	private int id;	
	private Date fechaIngreso;	
	private Date fechaSalida;	
	private int cantidadPersonas;	
	private HabitacionFront habitacion;
	private List<ContactoFront> contactos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}
	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	public HabitacionFront getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(HabitacionFront habitacion) {
		this.habitacion = habitacion;
	}
	public List<ContactoFront> getContactos() {
		return contactos;
	}
	public void setContactos(List<ContactoFront> contactos) {
		this.contactos = contactos;
	}
}
