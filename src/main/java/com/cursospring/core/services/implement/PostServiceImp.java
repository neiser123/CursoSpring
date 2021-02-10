package com.cursospring.core.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursospring.core.model.Post;
import com.cursospring.core.services.PostService;

@Service("implementServicio")
public class PostServiceImp implements PostService {

	@Override
	public List<Post> validateid(List<Post> post) {
		for(Post post2: post) {
			
			if(post2.getTitulo() == null) {
				throw new NullPointerException("el titulo esta vacio");
			}
			
		}
		return post;
	}

}
