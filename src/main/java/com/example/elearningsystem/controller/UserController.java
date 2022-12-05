package com.example.elearningsystem.controller;

import com.example.elearningsystem.model.ResponseObject;
import com.example.elearningsystem.model.User;
import com.example.elearningsystem.service.IUserService;
import com.example.elearningsystem.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @GetMapping("/view")
    public ResponseEntity<ResponseObject> getProfile(@RequestParam("username") String username){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query succesfully" , userService.findByUsername(username))
        );
    }
    @PostMapping("/edit")
    public ResponseEntity<ResponseObject> editProfile(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update sucessfully" ,  user)
        );
    }
}
