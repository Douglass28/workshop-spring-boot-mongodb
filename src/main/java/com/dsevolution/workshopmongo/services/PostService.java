package com.dsevolution.workshopmongo.services;

import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.repository.PostRepository;
import com.dsevolution.workshopmongo.services.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List <Post> findAllPost(){
       List<Post> posts = repository.findAll();
       return posts;
    }

    public Post findPost(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("post não existe!"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }
}
