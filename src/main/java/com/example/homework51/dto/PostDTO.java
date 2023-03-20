package com.example.homework51.dto;

import com.example.homework51.entity.Comment;
import com.example.homework51.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PostDTO {
    public static PostDTO from(Post post) {
        return builder()
                .id(post.getId())
                .description(post.getDescription())
                .image(post.getImage())
                .comments(new ArrayList<>())
                .time(LocalDateTime.now())
                .build();
    }

    @Builder.Default
    private Integer id = null;
    private LocalDateTime time;
    private String image;
    private String description;
    private List<Comment> comments;


    // можно добавить сюда
    // например
    // краткую инфу по пользователю кто оставлял отзыв

    // но пока оставим минимум
}
