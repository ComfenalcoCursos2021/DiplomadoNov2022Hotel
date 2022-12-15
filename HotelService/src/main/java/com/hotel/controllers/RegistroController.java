package com.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bl.RegistroBl;
import com.hotel.bl.dtos.MarcarSalidaDto;
import com.hotel.bl.dtos.RegistroDto;
import com.hotel.bl.dtos.TipoHabitacionDto;



@RestController
@RequestMapping(value="registro")
public class RegistroController {
	
	@Autowired
	private RegistroBl registroBl;
	
	//@PostMapping("/test")
	@PostMapping("testPost")
    public TipoHabitacionDto create(@RequestBody TipoHabitacionDto registro) {        
        return registro;
    }
	
	@GetMapping("consultar/{id}")
	public RegistroDto consulta(@PathVariable int id) {
		return registroBl.getRegistroById(id);
	}	
	
	
	@PostMapping("/guardar")
	public RegistroDto guardar(@RequestBody  RegistroDto registro) {
		return registroBl.guardar(registro);	
	}
	
	@PostMapping("/marcarsalida")
	public RegistroDto marcarSalida(@RequestBody  MarcarSalidaDto marcarSalida) {
		return registroBl.marcarSalida(marcarSalida.getId());
	}
	
	
}
