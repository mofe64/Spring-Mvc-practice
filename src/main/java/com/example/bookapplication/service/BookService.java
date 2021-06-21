package com.example.bookapplication.service;

import com.example.bookapplication.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> search(String searchPhrase);
    Book findBookById(String Id);
}
