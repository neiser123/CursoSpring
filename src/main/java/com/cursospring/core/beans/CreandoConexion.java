package com.cursospring.core.beans;

import org.springframework.context.annotation.Bean;

import com.cursospring.core.model.Conexion;
import com.cursospring.core.model.Usuario;

public class CreandoConexion {

	@Bean(name ="BeanUsuario")
	public Usuario getUsuario() {
		return new Usuario();
	}
	@Bean(name= "becom.cursospring.core.model.Conexion")
	public Conexion getConexion() {
		
		Conexion conexion = new Conexion();
		conexion.setDb(null);
		conexion.setUrl(null);
		return conexion;
		
	}
}
