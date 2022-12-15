package com.hotel.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.bl.dtos.TipoHabitacionDto;
import com.hotel.dal.conn.TipoHabitacionConn;

@Component
public class TipoHabitacionBl {

	@Autowired
	private TipoHabitacionConn conn;

	public List<TipoHabitacionDto> listar() {
		return UtilsMapper.mapperTipoHabitacionList(conn.findAll());
	}

}
