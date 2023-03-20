package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Liked {
    private Integer id;
    private Integer user;
    private Integer post;
    private LocalDateTime dateTime;
}
