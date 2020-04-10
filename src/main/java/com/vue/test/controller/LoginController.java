package com.vue.test.controller;

import com.vue.test.Result.Result;
import com.vue.test.pojo.User;
import com.vue.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody

    public Result login(@RequestBody User requestUser){
        String username=requestUser.getUsername();
        String password=requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        password = HtmlUtils.htmlEscape(password);


        //User user = userService.get(username,requestUser.getPassword());
        User user = userService.get(username,password);

        System.out.println("user:"+username+"pwd:"+password);
        if (null == user) {
            return new Result(400);
        }else {
            //session.setAttribute("user",user);
            return new Result(200);
        }
       /* if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassword())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else {
            return new Result(200);
        }*/

    }

}
