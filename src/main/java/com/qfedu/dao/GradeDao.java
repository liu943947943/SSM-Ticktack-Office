package com.qfedu.dao;

import com.qfedu.pojo.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/18.
 */
public interface GradeDao {
	int deleteByPrimaryKey(Integer id);

	int insert(Grade record);

	int insertSelective(Grade record);

	Grade selectByPrimaryKey(Integer id);



	int updateByPrimaryKeySelective(Grade record);

	int updateByPrimaryKey(Grade record);

	//班级分页查询
	List<Grade> selectGradeByPage(@Param(value="page") Integer page, @Param(value="limit") Integer limit);

	//班级数量
	int selectGradeNum();
}
