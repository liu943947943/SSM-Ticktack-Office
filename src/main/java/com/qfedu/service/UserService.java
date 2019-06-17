package com.qfedu.service;

import com.qfedu.pojo.User;


/**
 * Created by HP on 2019/6/13.
 */
public interface UserService {
    //登录--通过user的工号查找对象

    User login(String no,String password);
    void update(User user);
    User selectUserById(Integer id);
    void updatepass(User user);
}
