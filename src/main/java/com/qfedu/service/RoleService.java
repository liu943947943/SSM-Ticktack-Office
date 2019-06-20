package com.qfedu.service;

import com.qfedu.pojo.Role;
import com.qfedu.vo.ResultVo;

public interface RoleService {
	//查询所有的角色
	ResultVo selectAllRole(Integer page, Integer limit, String name);
	
	//修改角色
    ResultVo updateByPrimaryKeySelective(Role record);
    
/*  //查询某个角色对应的具体权限
    ResultVo selctItsAuthority(Integer rid);*/
}
