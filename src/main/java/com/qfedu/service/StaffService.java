package com.qfedu.service;

import com.qfedu.pojo.Staff;
import com.qfedu.vo.ResultVo;


import java.util.List;


/**
 * Created by Lenovo on 2019/6/17.
 */
public interface StaffService {
    List<Staff> selectStaffByPage(Integer page, Integer limit);

    //员工列表数量
    Integer selectStaffNum();

    //员工新增
    ResultVo staffAdd(Staff staff);

    //员工修改
    ResultVo staffEdit(Staff staff);

    //根据员工主键no查询
    Staff selectByPrimaryKey(String no);


}
