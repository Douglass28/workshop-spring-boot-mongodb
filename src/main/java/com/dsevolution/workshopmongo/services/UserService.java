package com.dsevolution.workshopmongo.services;

import com.dsevolution.workshopmongo.entities.User;
import com.dsevolution.workshopmongo.repository.UserRepository;
import com.dsevolution.workshopmongo.services.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not foud"));
    }
}
