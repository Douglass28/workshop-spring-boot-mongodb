package com.dsevolution.workshopmongo.repository;

import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
