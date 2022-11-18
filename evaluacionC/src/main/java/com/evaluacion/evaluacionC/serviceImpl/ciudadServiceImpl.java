package com.evaluacion.evaluacionC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.evaluacionC.IService.ciudadService;
import com.evaluacion.evaluacionC.Model.Ciudad;
import com.evaluacion.evaluacionC.Repository.ciudadRepository;

@Service
public class ciudadServiceImpl implements ciudadService  {

	@Autowired
	private ciudadRepository ciudadRepor;

	@Override
	public List<Ciudad> listarCiudad() {
		// TODO Auto-generated method stub
		return ciudadRepor.findAll();
	}

	@Override
	public Ciudad guardarCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadRepor.save(ciudad);
	}

	@Override
	public Ciudad ciudadPorId(Long id_ciudad) {
		// TODO Auto-generated method stub
		return ciudadRepor.findById(id_ciudad).get();
	}

	@Override
	public Ciudad actualizarCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadRepor.save(ciudad);
	}

	@Override
	public void eliminarCiudad(Long id_ciudad) {
		ciudadRepor.deleteById(id_ciudad);
		
	}
	
	
}
