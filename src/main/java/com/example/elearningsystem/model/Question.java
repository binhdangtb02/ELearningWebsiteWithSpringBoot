package com.example.elearningsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String term;
    private String[] definitions;
    private String answer;

}
