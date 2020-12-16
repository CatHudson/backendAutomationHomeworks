package com.geekbrains.BackendAutomation.controllers;

import com.geekbrains.BackendAutomation.dto.AuthorDto;
import com.geekbrains.BackendAutomation.dto.BookDto;
import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.entities.Book;
import com.geekbrains.BackendAutomation.exceptions.BookStoreError;
import com.geekbrains.BackendAutomation.exceptions.ResourceNotFoundException;
import com.geekbrains.BackendAutomation.repositories.AuthorRepository;
import com.geekbrains.BackendAutomation.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vi/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors () {
        return authorService.getAllAuthors().stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific author by id. 404 if does not exist.")
    public AuthorDto getAuthorById (@ApiParam("Returns a specific author by id. 404 if not found.") @PathVariable Long id) {
        Author a = authorService.getAuthorById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find an author with id#" + id));
        return new AuthorDto(a);
    }

    @PostMapping
    @ApiOperation("Creates a new author. 400 if id is not null.")
    public ResponseEntity<?> addNewAuthor (@RequestBody Author author) {
        if (author.getId() != null) {
            return new ResponseEntity<>(new BookStoreError(HttpStatus.BAD_REQUEST.value(), "Id must be null for a new book."));
        }
        return new ResponseEntity<>(authorService.addNewAuthor(author), HttpStatus.CREATED);
    }

}
