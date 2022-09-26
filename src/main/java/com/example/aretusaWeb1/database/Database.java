package com.example.aretusaWeb1.database;

import com.example.aretusaWeb1.model.Author;
import com.example.aretusaWeb1.model.Genre;
import com.example.aretusaWeb1.repository.AuthorRepository;
import com.example.aretusaWeb1.repository.GenreRepository;
import com.example.aretusaWeb1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class Database {

    private static final Logger log = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository, UserRepository userRepository, GenreRepository genreRepository) {

        return args -> {
            try {
                log.info("Preloading " + authorRepository.save(new Author("Sandra", "Puzz")));
                log.info("Preloading " + authorRepository.save(new Author("Mallo", "Callo")));
                final List<Author> all = authorRepository.findAll();
                log.info("Preloading " + genreRepository.save(new Genre("Giallo")));
                final List<Genre> allgenre = genreRepository.findAll();
            } catch (Exception e) {
                log.error("Chiave duplicata");
            }

        };
    }

}
