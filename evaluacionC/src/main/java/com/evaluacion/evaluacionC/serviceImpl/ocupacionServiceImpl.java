package com.evaluacion.evaluacionC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.evaluacionC.IService.ocupacionService;
import com.evaluacion.evaluacionC.Model.Ocupacion;
import com.evaluacion.evaluacionC.Repository.ocupacionRepository;

@Service
public class ocupacionServiceImpl implements ocupacionService {

	@Autowired
	private ocupacionRepository ocupacionRepor;

	@Override
	public List<Ocupacion> listarOcupacion() {
		// TODO Auto-generated method stub
		return ocupacionRepor.findAll();
	}

	@Override
	public Ocupacion guardarOcupacion(Ocupacion ocupacion) {
		// TODO Auto-generated method stub
		return ocupacionRepor.save(ocupacion);
	}

	@Override
	public Ocupacion ocupacionPorId(Long id_ocupacion) {
		// TODO Auto-generated method stub
		return ocupacionRepor.findById(id_ocupacion).get();
	}

	@Override
	public Ocupacion actualizarOcupacion(Ocupacion ocupacion) {
		// TODO Auto-generated method stub
		return ocupacionRepor.save(ocupacion);
	}

	@Override
	public void eliminarOcupacion(Long id_ocupacion) {
	ocupacionRepor.deleteById(id_ocupacion);
		
	}
	
}
