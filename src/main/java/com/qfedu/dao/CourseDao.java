package com.qfedu.dao;

import com.qfedu.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
public interface CourseDao {
	int deleteByPrimaryKey(Integer id);

	int insert(Course record);

	int insertSelective(Course record);

	Course selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Course record);

	int updateByPrimaryKey(Course record);

	//学科查询分页
	List<Course> selectCourseByPage(@Param("page") Integer page, @Param("limit") Integer limit);

	//学科数量
	int selectCourseNum();

	//查询所有的科目
	List<Course> selectAllCourse();
}
