package com.qfedu.service.impl;

import com.qfedu.dao.StaffDao;
import com.qfedu.pojo.Staff;
import com.qfedu.service.StaffService;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.ResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 2019/6/18.
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffDao staffDao;

   @Override
   public List<Staff> selectStaffByPage(Integer page, Integer limit) {
       // TODO 自动生成的方法存根
       return staffDao.selectStaffByPage((page-1)*limit, limit);
   }

    @Override
    public Integer selectStaffNum() {
        // TODO 自动生成的方法存根
        return staffDao.selectStaffNum();
    }
    @Override
    public ResultVo staffAdd(Staff staff) {
        // TODO 自动生成的方法存根
        return ResultUtil.execOk(staffDao.insert(staff));
    }

    @Override
    public ResultVo staffEdit(Staff staff) {
        // TODO 自动生成的方法存根
        return ResultUtil.execOk(staffDao.updateByPrimaryKeySelective(staff));
    }

    @Override
    public Staff selectByPrimaryKey(String no) {
        // TODO 自动生成的方法存根
        return staffDao.selectByPrimaryKey(no);
    };

    /*@Override
    public List<Staff> selectAllStaff() {
        // TODO 自动生成的方法存根
        return staffDao.selectAllStaff();
    }*/

}
