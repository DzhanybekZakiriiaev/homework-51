package com.example.homework51.service;

import com.example.homework51.dao.UserDao;
import com.example.homework51.entity.Liked;
import com.example.homework51.entity.Post;
import com.example.homework51.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public List<User> getByName(String name){
        return userDao.userByName(name);
    }
    public List<User> getByEmail(String email){
        return userDao.userByEmail(email);
    }
    public List<User> getById(Integer id){
        return userDao.userById(id);
    }
    public Boolean isRegistred(String email){
        List<User> users = userDao.getAllUsers();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public List<Post> getPosts(String email){
        return userDao.getPosts(email);
    }
    public List<Post> getFyp(String email){
        List<Post> fyp = new ArrayList<>();
        User owner = null;
        List<User> users = userDao.getAllUsers();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                owner =  users.get(i);
            }
        }
        for (int i = 0; i < owner.getFollowed().size(); i++){
            fyp.addAll(getPosts(owner.getFollowed().get(i).getEmail()));
        }
        return fyp;
    }
    public Boolean isLiked(String email, Integer id){
        List<Liked> likes =  userDao.getAllLikes();
        for (int i = 0; i < likes.size(); i++){
            if (likes.get(i).getUser().getEmail().equals(email) && likes.get(i).getPost().getId() == id){
                return true;
            }
        }
        return false;
    }
}
