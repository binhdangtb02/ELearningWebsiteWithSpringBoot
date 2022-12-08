package com.example.elearningsystem.controller;

import com.example.elearningsystem.model.Lession;
import com.example.elearningsystem.model.ResponseObject;
import com.example.elearningsystem.model.User;
import com.example.elearningsystem.model.Word;
import com.example.elearningsystem.repository.UserRepository;
import com.example.elearningsystem.service.ICategoryService;
import com.example.elearningsystem.service.ILessionService;
import com.example.elearningsystem.service.IUserService;
import com.example.elearningsystem.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final ICategoryService categoryService;
    private final ILessionService lessionService;
    @PostMapping("/profile/view")
    public ResponseEntity<ResponseObject> getProfile(@RequestParam("username") String username){
        User user =  userService.findByUsername(username);
        user.setCategories(null);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query succesfully" , user)
        );
    }
    @PostMapping("profile/edit")
    public ResponseEntity<ResponseObject> editProfile(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update successfully" ,  user)
        );
    }

    @GetMapping("/view/category")
    public ResponseEntity<ResponseObject> viewAllCategory(@RequestParam String username){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query Sucessfully" , userService.findByUsername(username).getCategories())
        );
    }
    @GetMapping("/view/lession")
    public ResponseEntity<ResponseObject> viewLessionByCategory(@RequestParam Long categoryid){
        Collection<Lession> lessons =  categoryService.findCategoryById(categoryid).getLessions();
      return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query Sucessfully" , lessons)
        );
    }
    @GetMapping("/view/word")
    public ResponseEntity<ResponseObject> viewWordByLessonId(@RequestParam Long lessonid){

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query Sucessfully" , lessionService.viewWordsByLesson(lessonid))
        );
    }
}
