package com.qfedu.controller;/**
 * Created by HP on 2019/6/13.
 */

import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP liuchenglong
 * @create 2019-06-13 17:30
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonBean  loginin(String no, String password) {
        User user = userService.login(no, password);
        return new JsonBean(1,user);
    }
}