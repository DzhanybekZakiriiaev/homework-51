package com.example.homework51.controller;
import com.example.homework51.dto.PostDTO;
import com.example.homework51.entity.Comment;
import com.example.homework51.entity.Post;
import com.example.homework51.entity.User;
import com.example.homework51.service.DataService;
import com.example.homework51.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody PostDTO postData){
        return new ResponseEntity<>(dataService.post(postData), HttpStatus.OK);
    }
    @DeleteMapping ("/post/{postId}")
    public ResponseEntity<String> delete(@PathVariable Integer postId){
        return new ResponseEntity<>(dataService.delete(postId), HttpStatus.OK);
    }
    @DeleteMapping ("/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId){
        return new ResponseEntity<>(dataService.deleteComment(commentId), HttpStatus.OK);
    }
    @PostMapping ("/subscribe/{userId}")
    public ResponseEntity<String> subscribe(@PathVariable Integer userId){
        return new ResponseEntity<>(dataService.subscribe(userId), HttpStatus.OK);
    }
    @PostMapping ("/comment/{postId}")
    public ResponseEntity<String> comment(@PathVariable Integer postId, @RequestBody Comment comment){
        return new ResponseEntity<>(dataService.comment(postId, comment), HttpStatus.OK);
    }
    @PostMapping ("/comment/{postId}")
    public ResponseEntity<String> like(@PathVariable Integer postId){
        return new ResponseEntity<>(dataService.like(postId), HttpStatus.OK);
    }
}
