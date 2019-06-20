package com.qfedu.service.impl;

import com.qfedu.dao.GradeDao;
import com.qfedu.pojo.Grade;
import com.qfedu.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeDao gradeDao;

	@Override
	public List<Grade> selectGradeByPage(Integer page, Integer limit) {
		// TODO 自动生成的方法存根
		return gradeDao.selectGradeByPage((page-1)*limit, limit);
	}

	@Override
	public int selectGradeNum() {
		// TODO 自动生成的方法存根
		return gradeDao.selectGradeNum();
	}

	@Override
	public int gradeEdit(Grade grade) {
		// TODO 自动生成的方法存根
		return gradeDao.updateByPrimaryKeySelective(grade);
	}

	@Override
	public int gradeAdd(Grade grade) {
		// TODO 自动生成的方法存根
		return gradeDao.insert(grade);
	}
	
	

}
