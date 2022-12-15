package com.hotel.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.hotel.bl.dtos.ContactoDto;
import com.hotel.bl.dtos.HabitacionDto;
import com.hotel.bl.dtos.RegistroDto;
import com.hotel.bl.dtos.TipoHabitacionDto;
import com.hotel.dal.daos.ContactoDao;
import com.hotel.dal.daos.HabitacionDao;
import com.hotel.dal.daos.RegistroDao;
import com.hotel.dal.daos.TipoHabitacionDao;

public class UtilsMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	public static TipoHabitacionDto mapper(TipoHabitacionDao dao) {		
		TipoHabitacionDto dto = modelMapper.map(dao, TipoHabitacionDto.class);		
		return dto;		
	}	
	public static List<TipoHabitacionDto> mapperTipoHabitacionList(List<TipoHabitacionDao> listaDao){				
		List<TipoHabitacionDto> listaDto = modelMapper.map(listaDao, new TypeToken<List<TipoHabitacionDto>>() {}.getType());		
		return listaDto;
	}
	
	public static HabitacionDto mapper(HabitacionDao dao) {		
		HabitacionDto dto = modelMapper.map(dao, HabitacionDto.class);		
		return dto;		
	}	
	public static List<HabitacionDto> mapperHabitacionList(List<HabitacionDao> listaDao){				
		List<HabitacionDto> listaDto = modelMapper.map(listaDao, new TypeToken<List<HabitacionDto>>() {}.getType());		
		return listaDto;
	}
	public static ContactoDto mapper(ContactoDao dao) {		
		ContactoDto dto = modelMapper.map(dao, ContactoDto.class);		
		return dto;		
	}	
	public static ContactoDao mapper(ContactoDto in) {		
		ContactoDao out = modelMapper.map(in, ContactoDao.class);		
		return out;		
	}	
	public static List<ContactoDto> mapperContactoList(List<ContactoDao> listaDao){				
		List<ContactoDto> listaDto = modelMapper.map(listaDao, new TypeToken<List<ContactoDto>>() {}.getType());		
		return listaDto;
	}
	public static RegistroDto mapper(RegistroDao dao) {		
		RegistroDto dto = modelMapper.map(dao, RegistroDto.class);		
		return dto;		
	}	
	public static List<RegistroDto> mapperRegistroList(List<RegistroDao> listaDao){				
		List<RegistroDto> listaDto = modelMapper.map(listaDao, new TypeToken<List<RegistroDto>>() {}.getType());		
		return listaDto;
	}
	
	public static RegistroDao mapper(RegistroDto dao) {		
		RegistroDao dto = modelMapper.map(dao, RegistroDao.class);		
		return dto;		
	}
}
