package com.example.bookapplication.controller;

import com.example.bookapplication.model.Book;
import com.example.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/books")
    public String results(@RequestParam("title") String title, Model model) {
        List<Book> bookList = bookService.search(title);
        model.addAttribute("bookList", bookList);
        return "allBooks";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable String id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "Book";

    }
}
