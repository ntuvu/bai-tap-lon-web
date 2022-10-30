package com.example.btl.book;

import com.example.btl.exception.CustomException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface BookService {

  List<BookDTO> getAllBooks()  throws CustomException;

  void createBook(BookDTO dto) throws CustomException;

  BookDTO getBook(Integer id) throws CustomException;

  void updateBook(BookDTO dto, Integer id) throws CustomException;

  void deleteBook(Integer id) throws CustomException;
}
