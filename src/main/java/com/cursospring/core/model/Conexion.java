package com.cursospring.core.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class Conexion {

	
	
	@Autowired
	@Qualifier("BeanUsuario")
	
	private Usuario usuario;
	
//	@Bean(name ="beanConexion")
	
	String db;
	String url;

	public Conexion() {
	
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
