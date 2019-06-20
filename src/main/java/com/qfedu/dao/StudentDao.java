package com.qfedu.dao;

import com.qfedu.pojo.Grade;
import com.qfedu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
public interface StudentDao {
	int deleteByPrimaryKey(String no);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(String no);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);


	//学生分页查询
	List<Student> selectStudentByPage(@Param(value="page") Integer page, @Param(value="limit") Integer limit);

	//学生数量
	int selecStudentNum();
	//批量插入
	void addBatchStudent(List<Student> list);
}
