package com.geekbrains.BackendAutomation.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
