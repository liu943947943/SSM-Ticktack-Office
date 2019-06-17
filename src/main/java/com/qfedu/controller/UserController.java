package com.qfedu.controller;/**
 * Created by HP on 2019/6/13.
 */

import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.MyException;
import com.qfedu.vo.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author HP liuchenglong
 * @create 2019-06-13 17:30
 **/
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public
    @ResponseBody
    JsonBean loginin(String no, String password, HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
//		if(count == 3){
//			return new JsonBean(0, "账户已冻结");
//		}
        try {
            User user = userService.login(no, password);
            session.removeAttribute("count");
            session.setAttribute("user", user);
            return new JsonBean(1, null);
        } catch (MyException e) {
            // 密码错误
            if (e.getErrorCode() == 2) {

                if (count == 3) {
                    return new JsonBean(0, "账户没权限");
                }

                count++;
                if (count == 3) {
                    // 冻结账户
                    User u = new User();
                    u.setName(no);
                    u.setFlag(0);
                    userService.update(u);
                }
                session.setAttribute("count", count);
            }
            return new JsonBean(0, e.getErrorMsg());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new JsonBean(0, e.getMessage());
        }
    }
    @RequestMapping("/logout.do")
    public JsonBean logout(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user != null){
            session.invalidate();
        }
        return new JsonBean(1, null);
    }
    @RequestMapping("/editpass.do")
    public JsonBean edit(String password,String newpass,@Param("id") Integer id){
        User user = userService.selectUserById(id);
        if(!password.equals(user.getPassword())){
            return new JsonBean(0,"旧密码输入错误");
        }else{
            user.setPassword(newpass);
            userService.updatepass(user);
            return new JsonBean(1,"修改成功,请重新登陆");
        }

    }

}