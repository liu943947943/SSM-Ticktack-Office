package com.qfedu.dao;

import com.qfedu.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lenovo on 2019/6/18.
 */
public interface StaffDao {

/*    int count(String info);*/

   /* List<Staff> findByIndexAndSize(@Param("index") int index, @Param("size") int size,  @Param("info") String info);*/

    List<Staff> selectStaffByPage(@Param("page")Integer page, @Param("limit")Integer limit);

    Integer selectStaffNum();
    int deleteByPrimaryKey(String no);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}
