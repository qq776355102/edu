package com.tedu.controller.simple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tedu.common.exception.MedicalDebugException;
import com.tedu.common.exception.MedicalException;
import com.tedu.domain.user.BaseUser;

public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ModelAttribute
    public void init(HttpServletRequest request, Model model)
        throws Exception
    {
//    	Object object = request.getAttribute("userId");
    	String userId = request.getParameter("userId");
    	if (userId != null) {
    		BaseUser baseUser = new BaseUser();
    		baseUser.setId(Integer.valueOf(userId));;
    		request.getSession().setAttribute("user", baseUser);
//    		UserCache.setUser(baseUser);
		}
    }
    
   
    public static String getUrl()
        throws MedicalDebugException, MedicalException
    {
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	//(例如)结果为：http://localhost:8080/
    	String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
       return url;
    }
    public static BaseUser getBaseUser()
    {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        if (request == null || request.getSession() == null)
        {
            return null;
        }
        return (BaseUser)request.getSession().getAttribute("user");
    }

    protected void writeToPage(String content, HttpServletResponse response)
    {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter pw = null;
        try
        {
            pw = response.getWriter();
            pw.write(content);
        }
        catch (IOException e)
        {
            logger.warn("write to page error: ", e);
        }
        finally
        {
            if (pw != null)
            {
                pw.flush();
                pw.close();
            }
        }
    }
}
