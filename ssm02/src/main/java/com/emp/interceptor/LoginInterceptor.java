package com.emp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//��¼������
/**
 * 1.preHandle��ҵ��������������֮ǰ������;
 * 2.postHandle��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ��;
 * 3.afterCompletion��DispatcherServlet��ȫ����������󱻵���,������������Դ�� ��
 *   afterCompletion()ִ����ɺ�ʼ��Ⱦҳ��
 *   
 * preHandle-->/emp/conditionList-->postHandle-->����ListEmp.jsp(html)
 * -->afterCompletion-->��������ش�html
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * return true ������  ����  ����ҵ������  ����:/emp/conditionList
	 * return false ����,������ҵ�����
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		//ת����Login.jsp
		//�󶨴�����Ϣ
		request.setAttribute("msg", "���ȵ�¼");
		String appname = request.getServletContext().getContextPath();
		System.out.println(appname);
		//ת������������
		request.getRequestDispatcher("/user/toLogin").forward(request, response);
		return false;
	}

}
