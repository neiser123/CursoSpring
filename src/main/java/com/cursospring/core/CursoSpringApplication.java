package com.cursospring.core;
import com.cursospring.core.component.PostComponent;
import com.cursospring.core.model.Conexion;
import com.cursospring.core.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
//@ComponentScan(basePackages={"com.cursospring.core.controllers"})
public class CursoSpringApplication implements CommandLineRunner {
	//AÑADIMOS EL BEAN QUE QUERMOS LLAMAR
//@Autowired
//@Qualifier("com.cursospring.core.model.Conexion")
//private Conexion conexion;
//	
@Autowired
@Qualifier("postComponent")

public PostComponent component;

@Autowired
@Qualifier("implementServicio")

public PostService postService;


	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		postService.validateid(component.getPost()).forEach(p ->{
			
			System.out.println(p.getTitulo());
			
		});
		
		
	}

}

