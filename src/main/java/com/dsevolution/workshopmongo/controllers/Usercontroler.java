package com.dsevolution.workshopmongo.controllers;

import com.dsevolution.workshopmongo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class Usercontroler {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User(1, "maria", "maria@gmail.com");
        User user2 = new User(2, "Bruno", "Bruno@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }

}
