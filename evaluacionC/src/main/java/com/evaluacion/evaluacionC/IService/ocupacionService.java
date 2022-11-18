package com.evaluacion.evaluacionC.IService;

import java.util.List;

import com.evaluacion.evaluacionC.Model.Ocupacion;

public interface ocupacionService {
	
	public List<Ocupacion> listarOcupacion();
	
	public Ocupacion guardarOcupacion(Ocupacion ocupacion);
	
	public Ocupacion ocupacionPorId(Long id_ocupacion);
	
	public Ocupacion actualizarOcupacion(Ocupacion ocupacion);
	
	public void eliminarOcupacion(Long id_ocupacion);
	
}
