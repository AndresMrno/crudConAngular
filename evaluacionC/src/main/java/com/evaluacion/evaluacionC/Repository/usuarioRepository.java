package com.evaluacion.evaluacionC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluacion.evaluacionC.Model.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {

}
