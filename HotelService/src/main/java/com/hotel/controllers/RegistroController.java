package com.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bl.RegistroBl;
import com.hotel.contratos.MarcarSalida;
import com.hotel.contratos.Registro;
import com.hotel.contratos.TipoHabitacion;



@RestController
@RequestMapping(value="registro")
public class RegistroController {
	
	@Autowired
	private RegistroBl registroBl;
	
	//@PostMapping("/test")
	@PostMapping("testPost")
    public TipoHabitacion create(@RequestBody TipoHabitacion registro) {        
        return registro;
    }
	
	@GetMapping("consultar/{id}")
	public Registro consulta(@PathVariable int id) {
		return registroBl.getRegistroById(id);
	}	
	
	
	@PostMapping("/guardar")
	public Registro guardar(@RequestBody  Registro registro) {
		return registroBl.guardar(registro);	
	}
	
	@PostMapping("/marcarsalida")
	public Registro marcarSalida(@RequestBody  MarcarSalida marcarSalida) {
		return registroBl.marcarSalida(marcarSalida.getId());
	}
	
	
}
