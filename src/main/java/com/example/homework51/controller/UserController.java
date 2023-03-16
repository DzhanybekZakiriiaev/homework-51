package com.example.homework51.controller;
import com.example.homework51.entity.Post;
import com.example.homework51.entity.User;
import com.example.homework51.service.DataService;
import com.example.homework51.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final DataService dataService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/name/{name}")
    public ResponseEntity<List<User>> byName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }
    @GetMapping("/user/email/{email}")
    public ResponseEntity<List<User>> byEmail(@PathVariable String email) {
        return new ResponseEntity<>(service.getByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/user/account/{id}")
    public ResponseEntity<List<User>> byAccount(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
    @GetMapping("/user/present/{email}")
    public ResponseEntity<Boolean> isRegistred(@PathVariable String email) {
        return new ResponseEntity<>(service.isRegistred(email), HttpStatus.OK);
    }
    @GetMapping("/posts/{email}")
    public ResponseEntity<List<Post>> getPosts(@PathVariable String email) {
        return new ResponseEntity<>(service.getPosts(email), HttpStatus.OK);
    }
    @GetMapping("/fyp/{email}")
    public ResponseEntity<List<Post>> getFyp(@PathVariable String email) {
        return new ResponseEntity<>(service.getFyp(email), HttpStatus.OK);
    }
    @GetMapping("/liked/{email}/{postId}")
    public ResponseEntity<Boolean> isLiked(@PathVariable String email, Integer postId) {
        return new ResponseEntity<>(service.isLiked(email, postId), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(){
        return new ResponseEntity<>(dataService.shouldCreateTable(), HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<String> insert(){
        return new ResponseEntity<>(dataService.shouldInsertValues(), HttpStatus.OK);
    }
}
