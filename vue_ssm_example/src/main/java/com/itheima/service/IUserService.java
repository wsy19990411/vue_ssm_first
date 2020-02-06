package com.itheima.service;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Integer id);
    void updateUser(User user);
}
