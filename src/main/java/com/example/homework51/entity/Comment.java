package com.example.homework51.entity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Integer id;
    private String text;
    private LocalDateTime dateTime;
    private Integer postId;
}
