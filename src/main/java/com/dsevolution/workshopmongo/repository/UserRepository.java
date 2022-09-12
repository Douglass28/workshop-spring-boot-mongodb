package com.dsevolution.workshopmongo.repository;

import com.dsevolution.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
