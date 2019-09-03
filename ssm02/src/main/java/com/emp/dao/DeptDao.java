package com.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emp.entity.Dept;

public interface DeptDao {
	//查询所有员工
	@Select("select * from t_dept")
	List<Dept> queryAll();
	//依据编号查询
	@Select("select * from t_dept where deptno=#{deptno}")
	Dept queryDeptno(@Param("deptno")String deptno);
	//添加数据
	@Insert("insert into t_dept values(#{deptno},#{dname},#{location})")
	void addDept(Dept dept);
	//删除数据
	@Delete("delete from t_dept where deptno=#{deptno}")
	void deleteDept(@Param("deptno")String deptno);
	//修改数据
	@Update("update t_dept set dname=#{dname},location=#{location} where deptno=#{deptno}")
	void updateDept(Dept dept);
}
