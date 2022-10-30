package com.example.btl.book;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @Column(name = "category")
  private String category;

  @Column(name = "description")
  private String description;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "page_number")
  private Integer pageNumber;

  public Book(BookDTO dto) {
    this.title = dto.getTitle();
    this.author = dto.getAuthor();
    this.category = dto.getCategory();
    this.description = dto.getDescription();
    this.date = dto.getDate();
    this.pageNumber = dto.getPageNumber();
  }

  public void replace(BookDTO dto) {
    this.title = dto.getTitle();
    this.author = dto.getAuthor();
    this.category = dto.getCategory();
    this.description = dto.getDescription();
    this.date = dto.getDate();
    this.pageNumber = dto.getPageNumber();
  }
}
