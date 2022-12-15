package com.hotel.bl.dtos;

import java.util.Date;
import java.util.List;

public class RegistroDto {

	
	private int id;	
	private Date fechaIngreso;	
	private Date fechaSalida;	
	private int cantidadPersonas;	
	private HabitacionDto habitacion;
	private List<ContactoDto> contactos;
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
	public HabitacionDto getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(HabitacionDto habitacion) {
		this.habitacion = habitacion;
	}
	public List<ContactoDto> getContactos() {
		return contactos;
	}
	public void setContactos(List<ContactoDto> contactos) {
		this.contactos = contactos;
	}
	
}
