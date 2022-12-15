package com.hotel.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.bl.dtos.ContactoDto;
import com.hotel.bl.dtos.HabitacionDto;
import com.hotel.bl.dtos.RegistroDto;
import com.hotel.dal.conn.ContactoConn;
import com.hotel.dal.conn.HabitacionConn;
import com.hotel.dal.conn.RegistroConn;
import com.hotel.dal.conn.TipoHabitacionConn;
import com.hotel.dal.daos.ContactoDao;
import com.hotel.dal.daos.HabitacionDao;
import com.hotel.dal.daos.RegistroDao;
import com.hotel.dal.daos.TipoHabitacionDao;

@Component
public class RegistroBl {

	
	@Autowired
	private RegistroConn registroConn;
	@Autowired
	private HabitacionConn habitacionConn;
	@Autowired
	private TipoHabitacionConn tipoHabitacionConn;
	@Autowired
	private ContactoConn contactoConn;
	
	public RegistroDto marcarSalida(int id) {
		
		RegistroDao dao = registroConn.findById(id).get();
		dao.setFechaSalida(new Date());
		registroConn.save(dao);
		
		
		return getRegistroDtoById(id);
	}
	
	public RegistroDto getRegistroById(int id) {		
		return getRegistroDtoById(id);
		
	}

	private RegistroDto getRegistroDtoById(int id) {
		RegistroDao dao = registroConn.findById(id).get();
		HabitacionDao hDao = habitacionConn.findById(dao.getIdHabitacion()).get();
		TipoHabitacionDao thDao = tipoHabitacionConn.findById(hDao.getIdTipoHabitacion()).get();
		List<ContactoDao> lContactoDao = contactoConn.findByIdRegistro(dao.getId());
				
		RegistroDto registroDto = UtilsMapper.mapper(dao);
		HabitacionDto habitacionDto = UtilsMapper.mapper(hDao);
		habitacionDto.setTipoHabitacion(UtilsMapper.mapper(thDao));
		
		registroDto.setHabitacion(habitacionDto);
		registroDto.setContactos(UtilsMapper.mapperContactoList(lContactoDao));
		
		return registroDto;
	}
	
	public RegistroDto guardar(RegistroDto dto) {
		RegistroDao dao = UtilsMapper.mapper(dto);
		dao.setFechaIngreso(new Date());
		dao.setFechaSalida(null);
		dao = registroConn.saveAndFlush(dao);
		
		List<ContactoDao> daosSave = new ArrayList<ContactoDao>();
		for (ContactoDto contactoDto : dto.getContactos()) {
			ContactoDao contactoDao = UtilsMapper.mapper(contactoDto);
			contactoDao.setIdRegistro(dao.getId());
			//contactoConn.saveAndFlush(contactoDao);
			daosSave.add(contactoDao);
		}	
		contactoConn.saveAll(daosSave);
		
		return getRegistroDtoById(dao.getId());
	}
}
