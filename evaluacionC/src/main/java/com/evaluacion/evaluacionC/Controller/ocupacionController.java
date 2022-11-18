package com.evaluacion.evaluacionC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.evaluacionC.IService.ocupacionService;
import com.evaluacion.evaluacionC.Model.Ocupacion;

@RestController
@RequestMapping("/ocupacion")
public class ocupacionController {

	@Autowired
	private ocupacionService ocupacionService;
	
	@GetMapping
	public ResponseEntity<List<Ocupacion>> listarOcupacion(){
		return ResponseEntity.ok(ocupacionService.listarOcupacion());
	}
}
