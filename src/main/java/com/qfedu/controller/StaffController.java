package com.qfedu.controller;

import com.qfedu.pojo.Staff;
import com.qfedu.service.DepartService;
import com.qfedu.service.StaffService;
import com.qfedu.utils.LayuiUtil;
import com.qfedu.utils.ResultUtil;

import com.qfedu.vo.LayuiVo;
import com.qfedu.vo.ResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Lenovo on 2019/6/17.
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartService departService;
    @RequestMapping("/stafflist.do")
    public LayuiVo findAll(Integer page,Integer limit){

        return LayuiUtil.execERROR(staffService.selectStaffNum(),staffService.selectStaffByPage(page, limit));
    }
    //员工删除
    @RequestMapping("/staffdelete.do")
    ResultVo staffdel(String no, String depart) {
        Staff staff = new Staff();
        staff.setNo(no);
        staff.setFlag(0);
        //删除员工
        staffService.staffEdit(staff);
        //部门人数-1
        departService.departnumdel(depart);
        return ResultUtil.execOk();
    }
    @RequestMapping("/staffadd.do")
    ResultVo staffadd(String no, String staffname, Integer did, String sex, String email, String phone, String qq,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate,MultipartFile file) {
        Staff staff = new Staff();
        staff.setNo(no);
        staff.setName(staffname);
        staff.setDid(did);
        staff.setSex(sex);
        staff.setEmail(email);
        staff.setPhone(phone);
        staff.setQq(qq);
        staff.setCreatedate(createdate);
        staff.setFlag(1);

        //增加员工
        staffService.staffAdd(staff);
        //对应部门人数+1
        departService.departnumadd(did);
        return ResultUtil.execOk();
    }
    //员工修改
    @RequestMapping("/staffedit.do")
    ResultVo staffedit(String no,String staffname,Integer did,String sex,String email,String phone,String qq,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate,MultipartFile file) {
        Staff staff = new Staff();
        staff.setNo(no);
        staff.setName(staffname);
        staff.setDid(did);
        staff.setSex(sex);
        staff.setEmail(email);
        staff.setPhone(phone);
        staff.setQq(qq);
        staff.setCreatedate(createdate);
        if (file != null) {
            //存储图片的物理路径
            String pic_path = "D:"+ File.separator +"upload"+ File.separator;
            //拿到图片原始名称
            String originalFilename = file.getOriginalFilename();
            String newFilename = UUID.randomUUID() + originalFilename;
            //新图片
            File newfile = new File(pic_path + newFilename);
            //将内存中的数据写入磁盘
            try {
                file.transferTo(newfile);
                staff.setPhoto(newFilename);

            } catch (IllegalStateException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

        }
        //增加员工
        staffService.staffEdit(staff);
        return ResultUtil.execOk();
    }
    @RequestMapping("/selectstaffbyid.do")
    Staff staffedit(String id) {
        return staffService.selectByPrimaryKey(id);
    }
}
