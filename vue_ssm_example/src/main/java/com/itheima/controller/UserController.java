package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;
  @RequestMapping("/findAll")
    public List<User> findAll(){
        return  userService.findAll();
    }
    @RequestMapping("/findById")
    public User findById(Integer id){
        return  userService.findById(id);
    }
    @RequestMapping("/updateUser")
    public void findById(@RequestBody User user){
     userService.updateUser(user);
    }
}
