package com.qfedu.controller;

import com.qfedu.pojo.Course;
import com.qfedu.service.CourseService;
import com.qfedu.utils.LayuiUtil;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.LayuiVo;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	//查询分页
	@RequestMapping("/coursepage.do")
	LayuiVo findAllCourseByPage(Integer page, Integer limit) {
		return LayuiUtil.execERROR(courseService.selectCourseNum(),courseService.selectCourseByPage(page, limit));
	}

	//学科新增
	@RequestMapping("/courseadd.do")
	ResultVo courseAdd(Integer id, String name, Integer week, @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate, Integer type) {
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setWeek(week);
		course.setCreatedate(createdate);
		course.setType(type);
		course.setFlag(1);
		return ResultUtil.execOk(courseService.courseAdd(course));
	}

	//学科修改
	@RequestMapping("/courseupdate.do")
	ResultVo courseEdit(Integer id, String name, Integer week, @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdate, Integer type) {
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setWeek(week);
		course.setCreatedate(createdate);
		course.setType(type);
		System.out.println(course);
		return ResultUtil.execOk(courseService.courseEdit(course));
	}

	//学科删除
	@RequestMapping("/coursedelete.do")
	ResultVo courseDel(Integer id) {
		Course course = new Course();
		course.setId(id);
		course.setFlag(0);
		return ResultUtil.execOk(courseService.courseEdit(course));
	}

	//查询所有的学科供新增班级时选课
	@RequestMapping("/courseall.do")
	List<Course> courseAll() {
		return courseService.selectAllCourse();
	}
}
