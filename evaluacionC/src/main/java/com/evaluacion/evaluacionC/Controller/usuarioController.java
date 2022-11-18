package com.evaluacion.evaluacionC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.evaluacionC.IService.ciudadService;
import com.evaluacion.evaluacionC.IService.ocupacionService;
import com.evaluacion.evaluacionC.IService.usuarioService;
import com.evaluacion.evaluacionC.Model.Ciudad;
import com.evaluacion.evaluacionC.Model.Ocupacion;
import com.evaluacion.evaluacionC.Model.Usuario;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
	
	@Autowired
	private usuarioService usuarioService;
	
	@Autowired
	private ciudadService ciudadService;
	
	@Autowired
	private ocupacionService ocupacionService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity<>(usuarioService.listarUsuario(), HttpStatus.OK);
	}
	
	
	@GetMapping("/ciudades")
	public ResponseEntity<List<Ciudad>> listarCiudades(){
		return new ResponseEntity<>(ciudadService.listarCiudad(), HttpStatus.OK);
	}
	
	@GetMapping("/ocupaciones")
	public ResponseEntity<List<Ocupacion>> listarOcupaciones(){
		return new ResponseEntity<>(ocupacionService.listarOcupacion(), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/crear")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){	
		return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping("/{numero_identidad}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long numero_identidad){
		return new ResponseEntity<>(usuarioService.usuarioPorId(numero_identidad), HttpStatus.OK);
	}
	
	
	@PutMapping("/actualizar/{numero_identidad}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long numero_identidad, @RequestBody Usuario usuario){
		Usuario usuarioEncontrado = usuarioService.usuarioPorId(numero_identidad);
		
		if(usuarioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			usuarioEncontrado.setNumero_identidad(usuario.getNumero_identidad());
			usuarioEncontrado.setNombre(usuario.getNombre());
			usuarioEncontrado.setApellido(usuario.getApellido());
			usuarioEncontrado.setFecha_nacimiento(usuario.getFecha_nacimiento());
			usuarioEncontrado.setId_ciudad_fk(usuario.getId_ciudad_fk());
			usuarioEncontrado.setCorreo_electronico(usuario.getCorreo_electronico());
			usuarioEncontrado.setTelefono(usuario.getTelefono());
			usuarioEncontrado.setId_ocupacion_fk(usuario.getId_ocupacion_fk());

			return new ResponseEntity<>(usuarioService.guardarUsuario(usuarioEncontrado), HttpStatus.CREATED);
		}catch(DataAccessException e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@DeleteMapping(value="/eliminar/{numero_identidad}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable Long numero_identidad){
		usuarioService.eliminarUsuario(numero_identidad);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
