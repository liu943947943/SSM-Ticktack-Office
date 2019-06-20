package com.qfedu.controller;/**
 * Created by HP on 2019/6/13.
 */

import com.qfedu.pojo.Authority;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.UploadUtils;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.MyException;
import com.qfedu.vo.ResultVo;
import com.qfedu.vo.VoMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UploadUtils uploadUtils;

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
            System.out.println(user);
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
    @RequestMapping("/exitUser.do")
    public String esitUser(User userInfo, Model model, @Param("id") Integer id, String myid, @RequestParam("file")MultipartFile file){
        try {
            User user = userService.selectUserById(userInfo.getId());
            Integer picId=null;
            if (file!=null){

                picId= uploadUtils.savePic(file);
            }
            if(myid==null&&user!=null){
                model.addAttribute("msg","操作失败,该登入名已存在！");
            }else{
                if(myid!=null&&!"".equals(myid)){//myid存在表示编辑操作
                    userInfo.setId(Integer.parseInt(myid));
                    if(picId!=null){

                        userInfo.setHeadphoto(picId);
                    }
                    userService.update(user);

                }

                model.addAttribute("msg","操作成功！");
            }
        }catch (Exception e){
            model.addAttribute("msg","操作失败！");
            e.printStackTrace();
        }
        return "redirect:userinfo";
    }
    @RequestMapping("/userall.do")
    @ResponseBody
    public Map<String ,Object> userAll(Integer page, Integer limit, String no){

        Map<String ,Object> map = userService.findAll(page,limit,no);

        return map;
    }
    @RequestMapping("/roleall.do")
    @ResponseBody
    public List<Role> roleAll(){

        List<Role> list = userService.findAllRole();

        return list;
    }

    @RequestMapping("/loginloglist.do")
    @ResponseBody
    public Map<String ,Object> loginLogList(String id, Integer page, Integer limit){

        Map<String, Object> logList = userService.findLogList(id, page, limit);
        System.out.println(logList);

        return logList;
    }
    @RequestMapping("/findPerms.do")
    @ResponseBody
    public JsonBean listPerms(String id){

        List<VoMenu> list = userService.findPermsById(id);

        return new JsonBean(1,list);
    }


    @RequestMapping("/userroleedit.do")
    @ResponseBody
    public JsonBean userRoleEdit(Integer id,String[] rids){

        userService.updateRole(id,rids);

        return new JsonBean(1000,null);
    }
    @RequestMapping("/userdel.do")
    @ResponseBody
    public JsonBean userDel(Integer id){

        userService.delUser(id);

        return new JsonBean(1000,null);
    }

    @RequestMapping("/authoritylist.do")
    @ResponseBody
    public Map<String ,Object> authorityList(Integer page,Integer limit){

        Map<String ,Object> map = userService.findAllAuthority(page,limit);

        return map;
    }

    @RequestMapping("/authorityupdate.do")
    @ResponseBody
    public JsonBean authorityUpdate(Authority authority){

        try {
            userService.updateAutho(authority);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonBean(0,"修改失败");
        }

        return new JsonBean(1,"修改成功");
    }

    @RequestMapping("/authorityroot.do")
    @ResponseBody
    public List<VoMenu> authorityRoot(){

        List<VoMenu> list = userService.findAllParentAutho();

        return list;
    }

    @RequestMapping("/authorityadd.do")
    @ResponseBody
    public JsonBean authorityAdd(Authority authority,String pid){

        if(pid.equals("0")){
            authority.setParentId(0);
        }

        try {
            userService.authorityAdd(authority);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonBean(1,"操作失败");
        }

        return new JsonBean(1,"操作成功");
    }

    @RequestMapping("/coursedelete.do")
    @ResponseBody
    public JsonBean courseDelete(String id) {


        userService.delAuthorityById(id);
        return new JsonBean(1, "操作成功");

    }
}