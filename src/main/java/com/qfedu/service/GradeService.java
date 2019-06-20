package com.qfedu.service;

import com.qfedu.pojo.Grade;

import java.util.List;

public interface GradeService {
	//班级分页查询
    List<Grade> selectGradeByPage(Integer page, Integer limit);

    //班级数量
    int selectGradeNum();
    
    //班级修改
    int gradeEdit(Grade grade);
    
    //班级新增
    int gradeAdd(Grade grade);

    //查询所有的班级
    List<Grade> selectAllGrade();
}
