package com.geekbrains.BackendAutomation.repositories;

import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b where  b.author = ?1")
    List<Book> findByAuthorId(Long id);

    @Query(value = "select a from Author a where  a.name = ?1")
    Author getIds(String name);

}
