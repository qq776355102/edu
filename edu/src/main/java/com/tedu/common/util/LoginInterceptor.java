package com.tedu.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tedu.common.exception.MedicalException;
import com.tedu.domain.user.User;



public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 // 获取请求的URL  
        String url = request.getRequestURI();  

        if (url.indexOf("/static") >= 0 || url.indexOf("/sms") >= 0 || url.indexOf("/tedu") >= 0) {  
            return true;  
        }  
        // 获取Session，判断是否能拿到token，如果没有的话，就需要跳转到主界面  
        javax.servlet.http.HttpSession session = request.getSession();  
  
        User user = (User)session.getAttribute("user");  
        if (user == null) {
        		// 不符合条件的，跳转到登录界面  
        		throw new MedicalException("用户未登录!!!");
		}
        return true;  
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unused")
	private boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

}
