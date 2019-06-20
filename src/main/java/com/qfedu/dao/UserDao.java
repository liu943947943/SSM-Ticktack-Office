package com.qfedu.dao;

import com.qfedu.pojo.*;
import com.qfedu.vo.UserAllVo;
import com.qfedu.vo.VoMenu;
import com.qfedu.vo.VoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2019/6/13.
 */
public interface UserDao {
    //权限管理》》》用户角色》》》查找所有的用户
   User findByUser(String no);
     void update(User user);
    User selectUserById(Integer id);
    void updatepass(User user);
    Integer insertSelective(UserPic userPic);

    User selectUserByLoginName(String name);
    List<String> findRolesByName(String name);

    List<VoMenu> findPermsByName(@Param("id") String id);

    User findByName(String name);

   List<Authority> findAllAuthority();
            List<Role> findAllRole();
           List<LoginInfo> findLogList(String id);
          List<VoUser> findAll( @Param("no") String no);
            void updateRole(@Param("params") Map<String,Integer> map);
            void delRole(Integer id);
             void delUser(Integer id);
            void updateAutho(Authority authority);

            List<VoMenu> findAllParentAutho();

            void authorityAdd(Authority authority);

            Authority chaAuthorityById(String id);

            void delAuthorityByParentId(String id);

                void delAuthorityById(String id);

        List<Integer> chaAuthorityByParentId(String id);

        void delRoleByAidList(@Param("list") List<Integer> list);

         void delRoleByAid(String id);

}
