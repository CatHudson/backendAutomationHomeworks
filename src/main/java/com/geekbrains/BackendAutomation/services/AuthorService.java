package com.geekbrains.BackendAutomation.services;

import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.repositories.AuthorRepository;
import com.geekbrains.BackendAutomation.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors () {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById (Long id) {
        return authorRepository.findById(id);
    }

    public Author addNewAuthor (Author author) {
        author.setId(null);
        authorRepository.save(author);
        return author;
    }

}
