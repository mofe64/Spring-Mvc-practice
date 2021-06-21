package com.example.bookapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ApiResponse {
    List<SearchResult> items = new ArrayList<>();
}
