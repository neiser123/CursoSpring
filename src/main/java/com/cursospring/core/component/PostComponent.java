package com.cursospring.core.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cursospring.core.model.Post;

@Component("postComponent")
public class PostComponent {

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
	
}
