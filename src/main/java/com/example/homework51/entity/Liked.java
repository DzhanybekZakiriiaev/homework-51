package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Liked {
    private Integer id;
    private User user;
    private Post post;
    private LocalDateTime dateTime;
}
