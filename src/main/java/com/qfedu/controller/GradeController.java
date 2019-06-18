package com.qfedu.controller;

import com.qfedu.pojo.Grade;
import com.qfedu.service.GradeService;
import com.qfedu.utils.LayuiUtil;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.LayuiVo;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	
	//班级列表分页查询
	@RequestMapping("/gradepage.do")
	LayuiVo findGradeBypage(Integer page, Integer limit) {
		return LayuiUtil.execERROR(gradeService.selectGradeNum(), gradeService.selectGradeByPage(page, limit));
	}
	
	
	//班级新增
	@RequestMapping("/gradeadd.do")
	ResultVo gradeAdd(String name, Integer week,
					  @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate,
					  String location, Integer cid) {
		Grade grade = new Grade();
		grade.setName(name);
		grade.setWeek(week);
		grade.setCreatedate(createdate);
		grade.setLocation(location);
		grade.setCid(cid);
		grade.setFlag(1);
		return ResultUtil.execOk(gradeService.gradeAdd(grade));
	}
	
	
	//班级修改
	@RequestMapping("/gradeedit.do")
	ResultVo gradeEdit(Integer id, String name, Integer week,
					   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createdate,
					   String location, Integer cid) {
		Grade grade = new Grade();
		grade.setId(id);
		grade.setName(name);
		grade.setWeek(week);
		grade.setCreatedate(createdate);
		grade.setLocation(location);
		grade.setCid(cid);
		grade.setFlag(1);
		return ResultUtil.execOk(gradeService.gradeEdit(grade));
	}
	
	
	//班级删除
	@RequestMapping("/gradedel.do")
	ResultVo gradeDel(Integer id) {
		Grade grade = new Grade();
		grade.setId(id);
		grade.setFlag(0);
		return ResultUtil.execOk(gradeService.gradeEdit(grade));
	}


	
	
	
	
}	
