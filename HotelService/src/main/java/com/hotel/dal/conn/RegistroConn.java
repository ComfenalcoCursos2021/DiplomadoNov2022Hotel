package com.hotel.dal.conn;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.dal.daos.RegistroDao;

public interface RegistroConn extends JpaRepository<RegistroDao, Integer>{

	//@Query(value = "from RegistroDao t where fechaIngreso BETWEEN :startDate AND :endDate")
	//List<RegistroDao> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	List<RegistroDao> findByFechaIngresoBetween(Date to, Date from);
	
	@Query(value = "select REG.* from REGISTRO REG WHERE REG.ID_HABITACION IN (SELECT H.ID FROM HABITACION H WHERE H.ID = 5)", nativeQuery = true)
	List<RegistroDao> obtenerTodos(String param);
}
