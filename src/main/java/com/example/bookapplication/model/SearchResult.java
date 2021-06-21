package com.example.bookapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    private String id;
    private volumeInfo volumeInfo;

}
