package com.example.homework51.dao;

import com.example.homework51.entity.Liked;
import com.example.homework51.entity.Post;
import com.example.homework51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers(){
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> userByName(String name){
        String sql = "select * from users where name = " + name;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> userById(Integer id){
        String sql = "select * from users where account = " + id;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> userByEmail(String email){
        String sql = "select * from users where email = " + email;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    public List<Post> getPosts(String email){
        String sql = "select * from posts where authorEmail = " + email;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }
    public List<Liked> getAllLikes(){
        String sql = "select * from likes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Liked.class));
    }
}
