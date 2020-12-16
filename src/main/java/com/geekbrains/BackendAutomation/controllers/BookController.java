package com.geekbrains.BackendAutomation.controllers;

import com.geekbrains.BackendAutomation.dto.BookDto;
import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.entities.Book;
import com.geekbrains.BackendAutomation.exceptions.BookStoreError;
import com.geekbrains.BackendAutomation.exceptions.ResourceNotFoundException;
import com.geekbrains.BackendAutomation.services.AuthorService;
import com.geekbrains.BackendAutomation.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@Api("Set of endpoints for books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation("Returns all books")
    public List<BookDto> getAllBooks () {
        return bookService.getAllBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific book by id. 404 if does not exist.")
    public BookDto getBookById (@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find a book with id#" + id));
        return new BookDto(book);
    }

    @PostMapping
    @ApiOperation("Creates a new book. If id != null then throw bad request response.")
    public ResponseEntity<?> addNewBook (@RequestBody Book book) {
       if (book.getId() != null) {
           return new ResponseEntity<>(new BookStoreError(HttpStatus.BAD_REQUEST.value(), "Id must be null for a new book."));
       }
       return new ResponseEntity<>(bookService.addNewBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("Returns books written by specific author")
    public List<BookDto> getBookByAuthor (@RequestParam String author_name) {
        return bookService.getIds(author_name).getBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }

}
