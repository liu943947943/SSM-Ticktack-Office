package com.qfedu.service.impl;

import com.qfedu.dao.CourseDao;
import com.qfedu.pojo.Course;
import com.qfedu.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	@Override
	public List<Course> selectCourseByPage(@Param("page") Integer page, @Param("limit") Integer limit) {
		return courseDao.selectCourseByPage((page-1)*limit, limit);
	}

	@Override
	public int selectCourseNum() {
		return courseDao.selectCourseNum();
	}

	@Override
	public int courseAdd(Course course) {
		return courseDao.insert(course);
	}

	@Override
	public int courseEdit(Course course) {
		return courseDao.updateByPrimaryKeySelective(course);
	}

	@Override
	public List<Course> selectAllCourse() {
		return courseDao.selectAllCourse();
	}
}
