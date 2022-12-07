package com.hotel.controllers.test;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

	@GetMapping("saludo")
	public String getSaludo() {
		return "El Saludo " + (new Date()).toString();
	}
}
