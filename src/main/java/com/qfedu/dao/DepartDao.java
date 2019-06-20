package com.qfedu.dao;

import com.qfedu.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lenovo on 2019/6/18.
 */
public interface DepartDao {
    int deleteByPrimaryKey(Integer id);

    //新增部门
    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(Integer id);

    //部门修改
    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);

    //查询所有的部门分页
    List<Depart> selectAllDepartByPage(@Param("page") Integer page, @Param("limit") Integer limit);

    //部门数量
    int selectDepartNum();

    //查询所有的部门供员工新增时选择部门
    List<Depart> selectAllDepart();

    //新增员工时部门人数+1
    int departnumadd(Integer id);

    //新增员工时部门人数-1
    int departnumdel(String name);

}
