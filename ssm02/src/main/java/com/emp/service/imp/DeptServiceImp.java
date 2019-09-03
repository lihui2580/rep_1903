package com.emp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.DeptDao;
import com.emp.entity.Dept;
import com.emp.service.DeptService;
@Service
public class DeptServiceImp implements DeptService {
	
	//ע�벿��dao
	@Resource
	private DeptDao deptDao;
	@Override
	public List<Dept> queryAllDept() {
		List<Dept> depts = deptDao.queryAll();
		return depts;
	}

}
