package com.example.bookapplication.service;

import com.example.bookapplication.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Book> search(String searchPhrase) {
        searchPhrase = searchPhrase.replaceAll(" ", "");
        final String URI = "https://www.googleapis.com/books/v1/volumes?q=" + searchPhrase;
        ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(URI, ApiResponse.class);
        ApiResponse response = responseEntity.getBody();
        assert response != null;
        return response.getItems().stream().map(
                searchResult -> {
                    Book book = new Book();
                    String bookId = searchResult.getId();
                    volumeInfo volumeInfo = searchResult.getVolumeInfo();
                    String bookTitle = volumeInfo.getTitle();
                    String bookPublisher = volumeInfo.getPublisher();
                    String previewLink = volumeInfo.getPreviewLink();
                    String description = volumeInfo.getDescription();
                    imageLinks images = volumeInfo.getImageLinks();
                    String smallImage = images.getSmallThumbnail();
                    String image = images.getThumbnail();
                    book.setTitle(bookTitle);
                    book.setPreviewLink(previewLink);
                    book.setSmallImage(smallImage);
                    book.setImage(image);
                    book.setPublisher(bookPublisher);
                    book.setId(bookId);
                    book.setDescription(description);
                    return book;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Book findBookById(String Id) {

        final String URI = "https://www.googleapis.com/books/v1/volumes/" + Id;
        ResponseEntity<SearchResult> responseEntity = restTemplate.getForEntity(URI, SearchResult.class);
        SearchResult searchResult = responseEntity.getBody();
        assert searchResult != null;
        Book book = new Book();
        String bookId = searchResult.getId();
        volumeInfo volumeInfo = searchResult.getVolumeInfo();
        String bookTitle = volumeInfo.getTitle();
        String bookPublisher = volumeInfo.getPublisher();
        String previewLink = volumeInfo.getPreviewLink();
        String description = volumeInfo.getDescription();
        imageLinks images = volumeInfo.getImageLinks();
        String smallImage = images.getSmallThumbnail();
        String image = images.getThumbnail();
        book.setTitle(bookTitle);
        book.setPreviewLink(previewLink);
        book.setSmallImage(smallImage);
        book.setImage(image);
        book.setPublisher(bookPublisher);
        book.setId(bookId);
        book.setDescription(description);
        return book;
    }
}
