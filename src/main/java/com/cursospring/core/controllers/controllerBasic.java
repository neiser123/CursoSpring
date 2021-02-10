package com.cursospring.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cursospring.core.component.PostComponent;
import com.cursospring.core.model.Post;

import configuration.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
//@RestController
@RequestMapping("/home")
public class controllerBasic {
	
	
@Autowired
PostComponent _postcomponent;
	
	@GetMapping(path = {"/post","/"})
	public String saludar(Model model) { //maneja el model de la clase post
		model.addAttribute("posts",this._postcomponent.getPost());
		
		return "index";
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() { // maneja el modelo + la vista
		ModelAndView modelAndView = new ModelAndView(Pages.HOME);
		modelAndView.addObject("posts",this._postcomponent.getPost());
		return modelAndView;
	}
	
	
	@GetMapping(path = {"/privado"})//obtenemos por id de la clase post cada item cuado le den click en la vista index con el parametro ?id=indice
	public ModelAndView getPostID(
			@RequestParam(defaultValue = "1",name = "id",required = false) int id
			) {
		ModelAndView modelAndView = new ModelAndView(Pages.POST);
		List<Post> postFilter =this._postcomponent.getPost().stream().filter((post) ->{
			return post.getId() == id;
		}).collect(Collectors.toList());
		modelAndView.addObject("pos", postFilter.get(0));
		return modelAndView;
	}
	
	@GetMapping(path = {"/paginaPost/{id}"})//obtenemos por id de la clase post cada item cuado le den click en la vista index con el parametro /id
	public ModelAndView getPostID2(
			@PathVariable(required = true,name="id") int id
			) {
		ModelAndView modelAndView = new ModelAndView(Pages.POST);
		List<Post> postFilter =this._postcomponent.getPost().stream().filter((post) ->{
			return post.getId() == id;
		}).collect(Collectors.toList());
		modelAndView.addObject("pos", postFilter.get(0));
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm(){
		//dirrecionamos a form.html, le enviarmos un objeto con la variable post, instaciamos la clase Post que actualmente no tiene nada
		return new ModelAndView("form").addObject("post", new Post());
		
	}
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		//obtenemos los post que estan quemados
		List<Post> list = this._postcomponent.getPost();
		//agregamos el nuevo post q llega del formulario
		list.add(post);
		model.addAttribute("posts",list);
		return "index";
		
	}
	
}
