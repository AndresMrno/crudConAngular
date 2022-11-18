package com.evaluacion.evaluacionC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.evaluacionC.IService.ciudadService;
import com.evaluacion.evaluacionC.Model.Ciudad;

@RestController
@RequestMapping("/ciudad")
public class ciudadController {

	@Autowired
	private ciudadService ciudadService;
	
	@GetMapping
	public ResponseEntity<List<Ciudad>> listarciudad(){
		return ResponseEntity.ok(ciudadService.listarCiudad());
	}
	
}
