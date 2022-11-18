package com.evaluacion.evaluacionC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.evaluacionC.IService.usuarioService;
import com.evaluacion.evaluacionC.Model.Usuario;
import com.evaluacion.evaluacionC.Repository.usuarioRepository;

@Service
public class usuarioServiceImpl implements usuarioService {
	
	@Autowired
	private usuarioRepository usuarioRepor;

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepor.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepor.save(usuario);
	}

	@Override
	public Usuario usuarioPorId(Long numero_identidad) {
		// TODO Auto-generated method stub
		return usuarioRepor.findById(numero_identidad).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepor.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long numero_identidad) {
		usuarioRepor.deleteById(numero_identidad);
		
	}
	
	
	
}
