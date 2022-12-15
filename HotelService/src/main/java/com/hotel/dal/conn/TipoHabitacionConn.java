package com.hotel.dal.conn;

import com.hotel.dal.daos.TipoHabitacionDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoHabitacionConn extends JpaRepository<TipoHabitacionDao,Integer> {

}
