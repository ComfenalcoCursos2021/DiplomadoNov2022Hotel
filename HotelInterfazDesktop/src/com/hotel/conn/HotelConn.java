package com.hotel.conn;

import java.util.List;

import com.hotel.dto.HabitacionFront;
import com.hotel.dto.TipoHabitacionFront;
import com.hotel.httphelper.HttpHelper;

public class HotelConn {

	public static List<TipoHabitacionFront> obtenerTiposHabitaciones() throws Exception {
		return HttpHelper.ejecutarGETList("http://localhost:8080/tipohab/listar", TipoHabitacionFront.class);
	}
	
	public static List<HabitacionFront> obtenerHabitacionesLibres(int idTipoHabitacion) throws Exception {
		return HttpHelper.ejecutarGETList("http://localhost:8080/habitacion/libres/"+idTipoHabitacion, HabitacionFront.class);
	}
}
