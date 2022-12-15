package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bl.TipoHabitacionBl;
import com.hotel.bl.dtos.TipoHabitacionDto;

@RestController
@RequestMapping("tipohab")
public class TipoHabitacionController {

	@Autowired
	private TipoHabitacionBl bl;
	
	@GetMapping("listar")
	public List<TipoHabitacionDto> listar(){
		return bl.listar();
	}
}
