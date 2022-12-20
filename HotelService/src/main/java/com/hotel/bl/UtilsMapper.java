package com.hotel.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.hotel.contratos.Contacto;
import com.hotel.contratos.Habitacion;
import com.hotel.contratos.Registro;
import com.hotel.contratos.TipoHabitacion;
import com.hotel.dal.daos.ContactoDao;
import com.hotel.dal.daos.HabitacionDao;
import com.hotel.dal.daos.RegistroDao;
import com.hotel.dal.daos.TipoHabitacionDao;

public class UtilsMapper {

	private static ModelMapper modelMapper = new ModelMapper();
	public static TipoHabitacion mapper(TipoHabitacionDao dao) {		
		TipoHabitacion dto = modelMapper.map(dao, TipoHabitacion.class);		
		return dto;		
	}	
	public static List<TipoHabitacion> mapperTipoHabitacionList(List<TipoHabitacionDao> listaDao){				
		List<TipoHabitacion> lista = modelMapper.map(listaDao, new TypeToken<List<TipoHabitacion>>() {}.getType());		
		return lista;
	}
	
	public static Habitacion mapper(HabitacionDao dao) {		
		Habitacion dto = modelMapper.map(dao, Habitacion.class);		
		return dto;		
	}	
	public static List<Habitacion> mapperHabitacionList(List<HabitacionDao> listaDao){				
		List<Habitacion> lista = modelMapper.map(listaDao, new TypeToken<List<Habitacion>>() {}.getType());		
		return lista;
	}
	public static Contacto mapper(ContactoDao dao) {		
		Contacto dto = modelMapper.map(dao, Contacto.class);		
		return dto;		
	}	
	public static ContactoDao mapper(Contacto in) {		
		ContactoDao out = modelMapper.map(in, ContactoDao.class);		
		return out;		
	}	
	public static List<Contacto> mapperContactoList(List<ContactoDao> listaDao){				
		List<Contacto> lista = modelMapper.map(listaDao, new TypeToken<List<Contacto>>() {}.getType());		
		return lista;
	}
	public static Registro mapper(RegistroDao dao) {		
		Registro dto = modelMapper.map(dao, Registro.class);		
		return dto;		
	}	
	public static List<Registro> mapperRegistroList(List<RegistroDao> listaDao){				
		List<Registro> lista = modelMapper.map(listaDao, new TypeToken<List<Registro>>() {}.getType());		
		return lista;
	}
	
	public static RegistroDao mapper(Registro dao) {		
		RegistroDao dto = modelMapper.map(dao, RegistroDao.class);		
		return dto;		
	}
}
