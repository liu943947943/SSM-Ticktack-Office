package com.qfedu.service.impl;

import java.util.List;

import com.qfedu.dao.DepartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.DepartDao;
import com.qfedu.pojo.Depart;
import com.qfedu.service.DepartService;
import com.qfedu.utils.ResultUtil;
import com.qfedu.vo.ResultVo;

@Service
public class DepartServiceImpl implements DepartService{
	@Autowired
	private DepartDao departDao;


	@Override
	public List<Depart> selectAllDepartByPage(Integer page, Integer limit) {
		// TODO 自动生成的方法存根
		return departDao.selectAllDepartByPage((page-1)*limit, limit);
	}

	@Override
	public int selectDepartNum() {
		// TODO 自动生成的方法存根
		return departDao.selectDepartNum();
	}

	@Override
	public ResultVo updateByPrimaryKeySelective(Depart record) {
		// TODO 自动生成的方法存根
		return ResultUtil.execOk(departDao.updateByPrimaryKeySelective(record));
	}

	@Override
	public ResultVo insert(Depart record) {
		// TODO 自动生成的方法存根
		return ResultUtil.execOk(departDao.insert(record));
	}

	//查询所有的部门供员工新增时选择部门
	@Override
	public List<Depart> selectAllDepart() {
		// TODO 自动生成的方法存根
		return departDao.selectAllDepart();
	}

	//部门人数+1
	@Override
	public int departnumadd(Integer id) {
		// TODO 自动生成的方法存根
		return departDao.departnumadd(id);
	}

	//部门人数-1
	@Override
	public int departnumdel(String name) {
		// TODO 自动生成的方法存根
		return departDao.departnumdel(name);
	}
}
