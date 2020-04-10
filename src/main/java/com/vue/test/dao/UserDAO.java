package com.vue.test.dao;

import com.vue.test.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername (String username);
    User getByUsernameAndPassword(String username,String password);
}
