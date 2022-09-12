package com.dsevolution.workshopmongo.controllers;

import com.dsevolution.workshopmongo.dto.UserDTO;
import com.dsevolution.workshopmongo.entities.User;
import com.dsevolution.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/users")
public class Usercontroler {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> userdto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(userdto);
    }

}
