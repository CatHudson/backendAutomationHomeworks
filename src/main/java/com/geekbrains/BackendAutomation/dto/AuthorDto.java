package com.geekbrains.BackendAutomation.dto;

import com.geekbrains.BackendAutomation.entities.Author;
import com.geekbrains.BackendAutomation.entities.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel(description = "Author dto in the application")
@Data
@NoArgsConstructor
public class AuthorDto {
    @ApiModelProperty(notes = "Unique identifier.", required = true, example = "1")
    private Long id;

    @ApiModelProperty(notes = "Author's name.", required = true, example = "Lev Tolstoy.")
    private String name;

    @ApiModelProperty(notes = "Amount of books written by a specific author." , required = false, example = "2")
    private int booksAmount;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.booksAmount = author.getBooks().size();
    }

}
