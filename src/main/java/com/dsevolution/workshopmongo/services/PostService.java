package com.dsevolution.workshopmongo.services;

import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List <Post> findPost(){
       List<Post> posts = repository.findAll();
       return posts;
    }
}
