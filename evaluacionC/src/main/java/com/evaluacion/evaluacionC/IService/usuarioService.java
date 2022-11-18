package com.evaluacion.evaluacionC.IService;

import java.util.List;

import com.evaluacion.evaluacionC.Model.Usuario;

public interface usuarioService {
	
	public List<Usuario> listarUsuario();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario usuarioPorId(Long numero_identidad);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long numero_identidad);

}
