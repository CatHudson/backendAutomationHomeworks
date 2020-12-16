package com.geekbrains.BackendAutomation.services;

import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.entities.Book;
import com.geekbrains.BackendAutomation.repositories.AuthorRepository;
import com.geekbrains.BackendAutomation.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById (Long id) {
        return bookRepository.findById(id);
    }

    public Book addNewBook (Book book) {
        book.setId(null);
        bookRepository.save(book);
        return book;
    }

    public Author getIds (String name) {
        return bookRepository.getIds(name);
    }
}
