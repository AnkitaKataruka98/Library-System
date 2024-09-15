package com.project.com.project.library.Service;

import com.project.com.project.library.Repository.UserRepository;
import com.project.com.project.library.entity.User;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }
}
