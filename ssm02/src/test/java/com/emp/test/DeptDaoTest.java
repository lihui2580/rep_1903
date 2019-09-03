package com.emp.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.DeptDao;
import com.emp.dao.DeptLazyDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class DeptDaoTest {
	@Resource
	private DeptDao deptDao;
	@Test//查所有
	public void testQueryAll() {
		List<Dept> de = deptDao.queryAll();
		for(Dept d:de){
			System.out.println(d);
		}
	}
	
	
	@Test//依据编号查询
	public void testqueryDeptno() {
		Dept de = deptDao.queryDeptno("d001");
		System.out.println(de);
	}
	
	
	@Test//添加
	public void testAddDept() {
		Dept d=new Dept();
		d.setDeptno("d005");
		d.setDname("电影部");
		d.setLocation("常德");
		deptDao.addDept(d);
		System.out.println("ok");
	}
	
	@Test//删除
	public void testdeleteDept() {
		deptDao.deleteDept("d005");
		System.out.println("ok");
	}
	
	
	@Test//修改
	public void testupdateDept() {
		Dept d = deptDao.queryDeptno("d005");
		d.setDname("专业部");
		d.setLocation("岳阳");
		deptDao.updateDept(d);
		System.out.println("ok");
	}
	
	
	//使用懒加载
	
	@Resource
	private DeptLazyDao deptLazyDao;
	@Test//依据编号查询
	public void testqueryAll2() {
		List<Dept> depts = deptLazyDao.queryAll();
		for(Dept d:depts){
			System.out.println(d.getDname());
			System.out.println("~~~~~~~~~~~");
			List<Emp> es = d.getEmps();
			for(Emp e:es){
				System.out.println(e.getEname());
			}
		}
	}
	
	
	@Test
	public void testQueryById(){
		Dept dept = deptLazyDao.queryDeptno("d001");
		System.out.println(dept.getDname());
		System.out.println("~~~~~~~~~~~");
		
	}
	
	
	
}
