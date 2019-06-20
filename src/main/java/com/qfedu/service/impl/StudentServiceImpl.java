package com.qfedu.service.impl;

import com.qfedu.dao.StudentDao;
import com.qfedu.pojo.Student;
import com.qfedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/19.
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> selectStudentByPage(Integer page, Integer limit) {
		return studentDao.selectStudentByPage((page-1)*limit, limit);
	}

	@Override
	public int selectStudentNum() {
		return studentDao.selecStudentNum();
	}

	@Override
	public int studentEdit(Student student) {
		return studentDao.updateByPrimaryKeySelective(student);
	}

	@Override
	public int studentAdd(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public void addBatchStudent(List<Student> list) {
		studentDao.addBatchStudent(list);
	}
}
