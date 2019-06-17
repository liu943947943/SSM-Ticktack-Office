package com.qfedu.dao;

import com.qfedu.pojo.User;
import com.qfedu.vo.UserAllVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HP on 2019/6/13.
 */
public interface UserDao {
    //权限管理》》》用户角色》》》查找所有的用户
   User findByUser(String no);
     void update(User user);
    User selectUserById(Integer id);
    void updatepass(User user);

}
