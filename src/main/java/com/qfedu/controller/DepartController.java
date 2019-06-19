package com.qfedu.controller;

import java.util.Date;
import java.util.List;

import com.qfedu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.fabric.xmlrpc.base.Data;
import com.qfedu.pojo.Depart;
import com.qfedu.service.DepartService;
import com.qfedu.utils.LayuiUtil;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.LayuiVo;
import com.qfedu.vo.ResultVo;

@RestController
@RequestMapping("/depart")
public class DepartController {
	@Autowired
	private DepartService departService;
	@Autowired
	private StaffService staffService;
	//部门查询分页
	@RequestMapping("/departpage.do")
	public LayuiVo findAllDepartByPage(Integer page,Integer limit){
		return LayuiUtil.execERROR(departService.selectDepartNum(), departService.selectAllDepartByPage(page, limit));
	}
	
	
	//部门删除
	@RequestMapping("/departdelete.do")
	ResultVo departdelete(Integer id) {
		Depart depart = new Depart();
		depart.setId(id);
		depart.setFlag(0);
		return ResultUtil.execOk(departService.updateByPrimaryKeySelective(depart));
	}
	
	//部门修改
	@RequestMapping("/departedit.do")
	ResultVo departedit(Integer id,String name,String createtime) {
		Depart depart = new Depart();
		depart.setId(id);
		depart.setName(name);
		return ResultUtil.execOk(departService.updateByPrimaryKeySelective(depart));
	}
	
	//部门新增
	@RequestMapping("/departadd.do")
	ResultVo departadd(@DateTimeFormat(pattern = "yyyy-MM-dd")Date createtime,String name) {
		Depart depart = new Depart();
		depart.setName(name);
		depart.setCreatetime(createtime);
		depart.setNum(0);
		depart.setFlag(1);
		return departService.insert(depart);
	}
	
	//部门新增
	@RequestMapping("/departall.do")
	List<Depart> departall() {
		return departService.selectAllDepart();
	}
	
	
}
