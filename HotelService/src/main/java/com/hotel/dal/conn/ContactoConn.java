package com.hotel.dal.conn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.dal.daos.ContactoDao;

public interface ContactoConn extends JpaRepository<ContactoDao, Integer> {

	List<ContactoDao> findByIdRegistro(int idRegistro);
}
