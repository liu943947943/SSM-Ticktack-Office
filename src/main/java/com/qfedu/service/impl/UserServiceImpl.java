package com.qfedu.service.impl;/**
 * Created by HP on 2019/6/13.
 */

import com.qfedu.dao.UserDao;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP liuchenglong
 * @create 2019-06-13 17:29
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String no,String password) {
        return userDao.findByUser(no,password);
    }
}