package com.emp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.entity.User;

@Controller
public class UserController {
	//模拟两个内置的用户
	private List<User> users=new ArrayList<User>();
	
	public UserController(){
		users.add(new User("zs","123"));
		users.add(new User("ls","456"));
	}
	
	//跳转到登录页面Login.jsp
	@RequestMapping("/user/toLogin")
	public String toLogin(){
		return "Login";
	}
	
	
	//处理登录
	@RequestMapping("/user/login")
	public String login(User user,HttpSession session,Model model){
		if(users.contains(user)){
			//登录成功
			//将用户对象放到session
			session.setAttribute("user",user);
			//重定向到员工列表
			return "redirect:/emp/conditionList";
		}else{
			//登录失败
			//绑定错误信息
			model.addAttribute("msg","用户名或者密码错误");
			//转发回登录页面
			return "forward:/user/toLogin";
		}
	}
	
	
}
