package com.vue.test.service;

import com.vue.test.dao.UserDAO;
import com.vue.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username){
        User user =getByName(username);
        return null !=user;
    }

    private User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String usernem,String password){
        return userDAO.getByUsernameAndPassword(usernem,password);
    }

    public void add(User user){
        userDAO.save(user);
    }

}
