package com.itheima;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test1 {
    @Autowired
    private IUserService userService;
    @Test
    public  void testfindAll(){
        List<User> all = userService.findAll();
        all.stream().forEach((x)-> System.out.println(x));
    }
    @Test
    public  void testfindById(){
        System.out.println(userService.findById(1));
    }
    @Test
    public  void testupdate(){
        User byId = userService.findById(1);
        byId.setAge(100);
        userService.updateUser(byId);
        System.out.println(userService.findById(1));
    }
}
