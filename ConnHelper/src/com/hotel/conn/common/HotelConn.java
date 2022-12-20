package com.hotel.conn.common;

import java.util.List;

import com.hotel.contratos.Habitacion;
import com.hotel.contratos.Registro;
import com.hotel.contratos.TipoHabitacion;
import com.hotel.httphelper.HttpHelper;

public class HotelConn {

	public static Registro guardarRegistro(Registro registro) throws Exception {
		
		return HttpHelper.ejecutarPOST("http://localhost:8080/registro/guardar", registro, Registro.class);
	}
	
	public static Registro obtenerRegistro(int idRegistro) throws Exception {
		return HttpHelper.ejecutarGET("http://localhost:8080/registro/consultar/"+idRegistro, Registro.class);
	}
	
	public static List<TipoHabitacion> obtenerTiposHabitaciones() throws Exception {
		return HttpHelper.ejecutarGETList("http://localhost:8080/tipohab/listar", TipoHabitacion.class);
	}
	
	public static List<Habitacion> obtenerHabitacionesLibres(int idTipoHabitacion) throws Exception {
		return HttpHelper.ejecutarGETList("http://localhost:8080/habitacion/libres/"+idTipoHabitacion, Habitacion.class);
	}
}
