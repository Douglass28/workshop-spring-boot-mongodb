package com.dsevolution.workshopmongo.controllers;

import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.services.PostService;
import com.dsevolution.workshopmongo.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/posts")
public class PostControler {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findallPosts(){
        List<Post> list = postService.findAllPost();
       return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findPost(@PathVariable String id){
        Optional<Post> post = Optional.ofNullable(postService.findPost(id));
        return ResponseEntity.ok().body(post);
    }

    @GetMapping
    @RequestMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
