package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
    private Integer id;
    private String image;
    private String description;
    private LocalDateTime dateTime;
    private String authorEmail;
}
