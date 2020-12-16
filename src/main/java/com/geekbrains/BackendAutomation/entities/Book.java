package com.geekbrains.BackendAutomation.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
