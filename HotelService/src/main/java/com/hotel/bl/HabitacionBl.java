package com.hotel.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.bl.dtos.HabitacionDto;
import com.hotel.dal.conn.HabitacionConn;
import com.hotel.dal.daos.HabitacionDao;

@Component
public class HabitacionBl {

	@Autowired
	private HabitacionConn habitacionConn;
	
	public List<HabitacionDto> getLibres(int tipoHabitacion){
		List<HabitacionDao> daos = habitacionConn.getLibres(tipoHabitacion);
		//List<HabitacionDao> daos = habitacionConn.findByIdTipoHabitacion(tipoHabitacion);
		//List<HabitacionDao> daos = habitacionConn.findByNumero(String.valueOf(tipoHabitacion));
		return UtilsMapper.mapperHabitacionList(daos);
		
	}
}
