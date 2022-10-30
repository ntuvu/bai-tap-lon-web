package com.example.btl.book;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {

  private Integer id;
  private String title;
  private String author;
  private String category;
  private String description;
  private LocalDate date;
  private Integer pageNumber;

  public BookDTO(Book book) {
    this.id = book.getId();
    this.title = book.getTitle();
    this.author = book.getAuthor();
    this.category = book.getCategory();
    this.description = book.getDescription();
    this.pageNumber = book.getPageNumber();
    this.date = book.getDate();
  }
}
