package com.hotel.dal.conn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.dal.daos.HabitacionDao;

public interface HabitacionConn extends JpaRepository<HabitacionDao, Integer> {

	@Query(value = "SELECT 	HAB.* FROM	HABITACION HAB WHERE HAB.ID_TIPO_HABITACION = ? AND HAB.ID NOT IN (SELECT REG.ID_HABITACION FROM REGISTRO REG WHERE REG.FECHA_SALIDA IS NULL)", nativeQuery =true)
	List<HabitacionDao> getLibres(int tipoHabitacion);
	
	List<HabitacionDao> findByIdTipoHabitacion(int tipoHabitacion);
	
	List<HabitacionDao> findByNumero(String numero);
}
