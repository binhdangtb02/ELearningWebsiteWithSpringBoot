package com.example.elearningsystem.controller;

import com.example.elearningsystem.model.Category;
import com.example.elearningsystem.model.ResponseObject;
import com.example.elearningsystem.service.ICategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;
    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertCategory(@RequestBody Category category){
    return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("OK", "Insert Or Update Successfully", categoryService.insertCategory(category))
    );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> upsertCategory(@PathVariable Long id, @RequestBody Category category){

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert or Update successfully", categoryService.updateCategory(id,category))
        );
    }
    @GetMapping("/register")
    public ResponseEntity<ResponseObject> registerCourse(@RequestParam String username, @RequestParam Long categoryId){
        try{
            return  ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponseObject("OK", "Register succesfully", categoryService.registerCategory(username, categoryId))
            );
        }catch(Exception exception){
            System.out.println(exception);
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("failed", "Register failed", "")
        );
    }
}
