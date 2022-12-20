package com.hotel.utils;

import com.hotel.contratos.Contacto;
import com.hotel.contratos.Habitacion;

public class UtilContratos {

	public static Object[] getContactoRowTableModel(Contacto dto) {
		Object[] row = new Object[2];
		row[0] = dto.getNombres();
		row[1] = dto.getContacto();
		return row;
	}
	
	public static Object[] getHabitacionRowTableModel(Habitacion dto) {
		Object[] row = new Object[3];
		row[0] = dto.getId();
		row[1] = dto.getNumero();
		row[2] = dto.getDescripcion();
		return row;
	}
	
	
	
}
