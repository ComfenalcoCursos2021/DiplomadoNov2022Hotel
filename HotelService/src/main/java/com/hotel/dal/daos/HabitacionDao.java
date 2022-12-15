package com.hotel.dal.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="HABITACION")
public class HabitacionDao {
	@Id
	private Integer id;
	@Column
	private String numero;
	@Column
	private String descripcion;
	@Column
	private int idTipoHabitacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public int getIdTipoHabitacion() {
		return idTipoHabitacion;
	}
	public void setIdTipoHabitacion(int idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}
	
}
