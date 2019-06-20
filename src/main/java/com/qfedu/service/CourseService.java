package com.qfedu.service;

import com.qfedu.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
public interface CourseService {
	//学科查询分页
	List<Course> selectCourseByPage(@Param("page") Integer page, @Param("limit") Integer limit);

	//学科数量
	int selectCourseNum();

	//学科新增
	int courseAdd(Course course);

	//学科修改
	int courseEdit(Course course);

	//查询所有的科目
	List<Course> selectAllCourse();
}
