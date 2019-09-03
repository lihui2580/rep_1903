package com.emp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.dao.EmpDao;
import com.emp.entity.Emp;
import com.emp.service.EmpService;
import com.emp.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmpServiceImp implements EmpService{
	
	//注入Dao
	@Resource
	private EmpDao empDao;
	
	@Override //分页查询 --配置分页助手
	public PageBean<Emp> queryByPage(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		//List<Company> List=companyDao.selectAll();
		List<Emp> list=empDao.queryALL();
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//创建一个PageBean对象
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public PageBean<Emp> queryByCondition(Integer pageNo, Integer pageSize, String ename) {
		PageHelper.startPage(pageNo,pageSize);
		List<Emp> list = empDao.queryLikeName(ename);
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
		//创建一个PageBean对象
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPageNo(pageNo);
		pageBean.setPageSize(pageSize);
		pageBean.setList(pageInfo.getList());
		pageBean.setTotalCount((int)pageInfo.getTotal());
		return pageBean;
	}

	@Override
	public Emp queryEmpById(String empno) {
		Emp emp = empDao.queryById(empno);
		return emp;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteEmp(String empno) {
		empDao.deleteEmp(empno);
		
	}

	@Override
	public List<Emp> queryMgr() {
		List<Emp> mgrs = empDao.queryMgrs();
		return mgrs;
	}

}
