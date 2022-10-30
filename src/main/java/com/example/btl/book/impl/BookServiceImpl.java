package com.example.btl.book.impl;

import com.example.btl.book.Book;
import com.example.btl.book.BookDTO;
import com.example.btl.book.BookRepository;
import com.example.btl.book.BookService;
import com.example.btl.exception.CustomException;
import com.example.btl.exception.ExceptionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  @Override
  public List<BookDTO> getAllBooks()  throws CustomException {
    List<Book> books = bookRepository.findAll();
    List<BookDTO> dtos = new ArrayList<>();
    for (Book b : books) {
      dtos.add(new BookDTO(b));
    }
    return dtos;
  }

  @Override
  public void createBook(BookDTO dto) throws CustomException {
    validateBook(dto);
    bookRepository.save(new Book(dto));
  }

  @Override
  public BookDTO getBook(Integer id) throws CustomException {
    Optional<Book> bookOptional = bookRepository.findBookById(id);
    if (bookOptional.isEmpty()) {
      throw new CustomException(
          ExceptionUtils.BOOK_ID_NOT_EXIST,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_ID_NOT_EXIST));
    }
    return new BookDTO(bookOptional.get());
  }

  @Override
  public void updateBook(BookDTO dto, Integer id) throws CustomException {
    Optional<Book> bookOptional = bookRepository.findBookById(id);
    if (bookOptional.isEmpty()) {
      throw new CustomException(
          ExceptionUtils.BOOK_ID_NOT_EXIST,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_ID_NOT_EXIST));
    }
    validateBook(dto);
    bookOptional.get().replace(dto);
    bookRepository.save(bookOptional.get());
  }

  @Override
  public void deleteBook(Integer id) throws CustomException {
    Optional<Book> bookOptional = bookRepository.findBookById(id);
    if (bookOptional.isEmpty()) {
      throw new CustomException(
          ExceptionUtils.BOOK_ID_NOT_EXIST,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_ID_NOT_EXIST));
    }
    bookRepository.deleteById(id);
  }

  private void validateBook(BookDTO dto) throws CustomException {
    if (StringUtils.isBlank(dto.getTitle())) {
      throw new CustomException(
          ExceptionUtils.BOOK_TITLE_REQUIRED,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_TITLE_REQUIRED));
    }
    if (StringUtils.isBlank(dto.getCategory())) {
      throw new CustomException(
          ExceptionUtils.BOOK_CATEGORY_REQUIRED,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_CATEGORY_REQUIRED));
    }
    if (StringUtils.isBlank(dto.getAuthor())) {
      throw new CustomException(
          ExceptionUtils.BOOK_AUTHOR_REQUIRED,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_AUTHOR_REQUIRED));
    }
    if (dto.getPageNumber() < 0 || dto.getPageNumber() == null) {
      throw new CustomException(
          ExceptionUtils.BOOK_PAGE_NUMBER_NOT_VALID,
          ExceptionUtils.messages.get(ExceptionUtils.BOOK_PAGE_NUMBER_NOT_VALID));
    }
  }
}
