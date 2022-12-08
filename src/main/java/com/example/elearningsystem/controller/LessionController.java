package com.example.elearningsystem.controller;

import com.example.elearningsystem.model.Question;
import com.example.elearningsystem.model.ResponseObject;
import com.example.elearningsystem.service.ILessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lession")
@RequiredArgsConstructor
public class LessionController {
    private final ILessionService lessionService;
    @GetMapping("/test")
    public ResponseEntity<ArrayList<Question>> getTest(@RequestParam Long lessionid){
        return ResponseEntity.status(HttpStatus.OK).body(
                lessionService.createTest(lessionid)
        );
    }
}
