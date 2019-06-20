package com.qfedu.service;

import com.qfedu.pojo.Grade;
import com.qfedu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
public interface StudentService {

	//学生分页查询
	List<Student> selectStudentByPage(Integer page,Integer limit);


	//学生数量
	int selectStudentNum();

	//学生修改
	int studentEdit(Student student);

	//学生新增
	int studentAdd(Student student);

	//批量插入
	void addBatchStudent(List<Student> list);
}
