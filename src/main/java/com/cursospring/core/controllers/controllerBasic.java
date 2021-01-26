package com.cursospring.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
//@RestController
@RequestMapping("/home")
public class controllerBasic {
	
	
 public	List<Post> getPost(){
	
	 ArrayList<Post> post =new ArrayList<Post>();
	 
		post.add(new Post(1,
				"Desarrollo web es un término que define la creación de sitios web para Internet o una intranet",
				"http://localhost:8080/img/ash.jpg", new Date(),"DESARROLLO WEB 1")); 
		post.add(new Post(2,
				"Desarrollo web es un término que define la creación de sitios web para Internet o una intranet",
				"http://localhost:8080/img/3.jpg", new Date(),"DESARROLLO WEB 2")); 
		post.add(new Post(3,
				"Desarrollo web es un término que define la creación de sitios web para Internet o una intranet",
				"http://localhost:8080/img/ash.jpg", new Date(),"DESARROLLO WEB 3")); 
		post.add(new Post(4,
				"Desarrollo web es un término que define la creación de sitios web para Internet o una intranet",
				"http://localhost:8080/img/leluch.jpg", new Date(),"DESARROLLO WEB 4")); 
	return post;
}
	
	@GetMapping(path = {"/post","/"})
	public String saludar(Model model) {
		model.addAttribute("posts",this.getPost());
		
		return "index";
	}
}
