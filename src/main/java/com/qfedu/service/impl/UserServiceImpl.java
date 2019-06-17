package com.qfedu.service.impl;/**
 * Created by HP on 2019/6/13.
 */

import com.qfedu.dao.UserDao;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.MyException;
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
        User user = userDao.findByUser(no);
        if(user == null){
            throw new MyException(1, "不能为空");
        }
        if(user.getFlag() == 0){
            throw new RuntimeException("账户没权限");
        }
        if(!user.getPassword().equals(password)){
            throw new MyException(2, "密码错误");
        }

        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public void updatepass(User user) {
        userDao.updatepass(user);
    }
}