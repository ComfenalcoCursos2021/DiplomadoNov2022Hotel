package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bl.HabitacionBl;
import com.hotel.bl.dtos.HabitacionDto;

@RestController
@RequestMapping(value="habitacion")
public class HabitacionController {

	@Autowired
	private HabitacionBl bl;
	
	
	@GetMapping("libres/{tipohabitacion}")
	public List<HabitacionDto> consulta(@PathVariable String tipohabitacion) {
		return bl.getLibres(Integer.parseInt(tipohabitacion));
	}	
	
}
