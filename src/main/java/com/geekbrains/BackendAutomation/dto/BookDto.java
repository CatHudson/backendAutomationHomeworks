package com.geekbrains.BackendAutomation.dto;

import com.geekbrains.BackendAutomation.entities.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Book dto in the application")
@Data
@NoArgsConstructor
public class BookDto {
    @ApiModelProperty(notes = "Unique identifier", required = true, example = "1", position = 0)
    private Long id;

    @ApiModelProperty(notes = "Name of the book.", required = true, example = "Rowling", position = 1)
    private String title;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }
}
