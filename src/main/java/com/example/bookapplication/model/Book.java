package com.example.bookapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String id;
    private String title;
    private String publisher;
    private String previewLink;
    private String image;
    private String smallImage;
    private String description;
}
