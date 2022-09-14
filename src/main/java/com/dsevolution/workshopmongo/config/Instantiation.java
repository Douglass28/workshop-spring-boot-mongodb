package com.dsevolution.workshopmongo.config;

import com.dsevolution.workshopmongo.dto.AuthorDTO;
import com.dsevolution.workshopmongo.dto.CommentDTO;
import com.dsevolution.workshopmongo.entities.Post;
import com.dsevolution.workshopmongo.entities.User;
import com.dsevolution.workshopmongo.repository.PostRepository;
import com.dsevolution.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("13/09/2022"), "partiu viajem", "vou viajar para são paulo",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("15/09/2022"), "bom dia", "acordei feliz", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("15/09/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO(" Aproveite!", sdf.parse("15/09/2018"), new AuthorDTO(bob));

        post1.getComments().add(c1);
        post2.getComments().add(c2);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().add(post1);
        maria.getPosts().add(post2);

        userRepository.save(maria);

    }
}
