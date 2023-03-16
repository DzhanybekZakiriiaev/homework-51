package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Followed {
    private Integer id;
    private User user;
    private User follower;
    private LocalDateTime dateTime;
}
