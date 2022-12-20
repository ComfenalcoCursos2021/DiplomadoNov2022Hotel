package com.hotel.controllers.test;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hotel.conn.common.HotelConn;
import com.hotel.contratos.TipoHabitacion;

@ManagedBean
@SessionScoped
public class TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	private Object tipoHabitacionSeleccionado;
	
	private List<TipoHabitacion> tiposHabitaciones;
	
	public TestBean() {
		this.mensaje = "Mensaje desde el testBean";
		try {
			List<TipoHabitacion> tipoHabitaciones= HotelConn.obtenerTiposHabitaciones();
			this.mensaje = tipoHabitaciones.get(0).toString();
			this.tiposHabitaciones = tipoHabitaciones;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTipoHabitacionChange() {
        this.mensaje = "Cambio";
        System.out.println(tipoHabitacionSeleccionado.getClass());
        //TipoHabitacion aux = tiposHabitaciones.stream().filter(x-> x.getDescripcion().equals(tipoHabitacionSeleccionado.toString())).findFirst().get();
        //this.mensaje = aux.getId() + " - " + aux.getDescripcion();
        
    }
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	public Object getTipoHabitacionSeleccionado() {
		return tipoHabitacionSeleccionado;
	}
	public void setTipoHabitacionSeleccionado(Object tipoHabitacionSeleccionado) {
		this.tipoHabitacionSeleccionado = tipoHabitacionSeleccionado;
	}


	public List<TipoHabitacion> getTiposHabitaciones() {
		return tiposHabitaciones;
	}
	public void setTiposHabitaciones(List<TipoHabitacion> tiposHabitaciones) {
		this.tiposHabitaciones = tiposHabitaciones;
	}
	
	

}
