package com.example.bookapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class imageLinks {
    private String smallThumbnail;
    private String thumbnail;
}
