package com.dsevolution.workshopmongo.controllers;

import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/posts")
public class PostControler {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findPosts(){
        List<Post> list = postService.findPost();
       return ResponseEntity.ok().body(list);
    }
}
