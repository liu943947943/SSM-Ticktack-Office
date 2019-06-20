package com.qfedu.service;


import com.qfedu.pojo.Authority;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.vo.VoMenu;

import java.util.List;
import java.util.Map;


/**
 * Created by HP on 2019/6/13.
 */
public interface UserService {
    //登录--通过user的工号查找对象

    User login(String no, String password);

    void update(User user);

    User selectUserById(Integer id);

    void updatepass(User user);

    User selectUserByLoginName(String name);

    User findByName(String name);

    Map<String, Object> findAll(Integer page, Integer limit, String no);

    List<Role> findAllRole();

    List<VoMenu> findPermsById(String id);

    Map<String, Object> findLogList(String id, Integer page, Integer limit);

    Map<String, Object> findAllAuthority(Integer page, Integer limit);

    void updateRole(Integer id, String[] ids);

    void delUser(Integer id);
    void updateAutho(Authority authority);

    List<VoMenu> findAllParentAutho();

    void authorityAdd(Authority authority);

   void findAuthorityById(String id);
    void delAuthorityById(String id);


}