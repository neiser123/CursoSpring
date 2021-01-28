package com.cursospring.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import configuration.Pages;
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
	public String saludar(Model model) { //maneja el model de la clase post
		model.addAttribute("posts",this.getPost());
		
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() { // maneja el modelo + la vista
		ModelAndView modelAndView = new ModelAndView(Pages.HOME);
		modelAndView.addObject("posts",this.getPost());
		return modelAndView;
	}
	
	
	@GetMapping(path = {"/privado"})//obtenemos por id de la clase post cada item cuado le den click en la vista index
	public ModelAndView getPostID(
			@RequestParam(defaultValue = "1",name = "id",required = false) int id
			) {
		ModelAndView modelAndView = new ModelAndView(Pages.POST);
		List<Post> postFilter =this.getPost().stream().filter((post) ->{
			return post.getId() == id;
		}).collect(Collectors.toList());
		modelAndView.addObject("pos", postFilter.get(0));
		return modelAndView;
	}
	
}
