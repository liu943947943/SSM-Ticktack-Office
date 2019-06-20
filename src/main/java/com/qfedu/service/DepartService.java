package com.qfedu.service;

import java.util.List;
import com.qfedu.pojo.Depart;
import com.qfedu.pojo.Depart;
import com.qfedu.vo.ResultVo;

public interface DepartService {
	 //查询所有的部门分页
    List<Depart> selectAllDepartByPage(Integer page, Integer limit);
    
    //部门数量
    int selectDepartNum();
    
    //部门修改
    ResultVo updateByPrimaryKeySelective(Depart record);
    
    //部门新增
    ResultVo insert(Depart record);
    
    //查询所有的部门供员工新增时选择部门 
    List<Depart> selectAllDepart();
    
    //新增员工时部门人数+1
    int departnumadd(Integer did);


    //新增员工时部门人数-1
    int departnumdel(String name);
}
