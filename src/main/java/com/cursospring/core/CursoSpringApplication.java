package com.cursospring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import model.Conexion;


@SpringBootApplication
//@ComponentScan(basePackages={"com.cursospring.core.controllers"})
public class CursoSpringApplication implements CommandLineRunner {
	//AÑADIMOS EL BEAN QUE QUERMOS LLAMAR
@Autowired
@Qualifier("beanConexion")
	
private Conexion conexion;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(conexion.getDb());
		
	}

}

