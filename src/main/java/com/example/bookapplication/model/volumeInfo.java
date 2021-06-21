package com.example.bookapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class volumeInfo {
    private String title;
    private List<String> authors = new ArrayList<>();
    private String publisher;
    private String previewLink;
    private imageLinks imageLinks;
    private String description;
}
