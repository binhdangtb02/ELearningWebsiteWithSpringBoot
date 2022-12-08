package com.example.elearningsystem.service;

import com.example.elearningsystem.model.Question;
import com.example.elearningsystem.model.Word;

import java.util.ArrayList;
import java.util.Collection;

public interface ILessionService {
    public ArrayList<Question> createTest(Long lessionid);
    public Collection<Word> viewWordsByLesson(Long lessonid);
}
