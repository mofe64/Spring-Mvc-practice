package com.example.bookapplication.service;

import com.example.bookapplication.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class BookServiceImplTest {
    @Autowired
    BookService bookService;

    @BeforeEach
    void setUp() {
    }


    @Test
    void search() {
        List<Book> books = bookService.search("half of a yellow sun ");
        assertThat(books).isNotNull();
        assertThat(books).isNotEmpty();
        for (Book book : books) {
            log.info("book object --> {}", book);

        }
    }
}