package com.tedu.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.tedu.common.model.ErrorInfo;
import com.tedu.common.model.ResponseDTO;
import com.tedu.common.util.StringUtils;

import jnr.ffi.Struct.int16_t;
import net.sf.json.JSONObject;


@Component
public class MyExceptionHandler implements HandlerExceptionResolver
{

	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

//	@Autowired(required=false)
//	private ISystemLogService logService;

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
											Object handler, Exception e)
	{
		ModelAndView modelView = new ModelAndView();
		ResponseDTO responseDTO = new ResponseDTO();
		ErrorInfo errorinfo = responseDTO.getErrorinfo();

		if (e instanceof MedicalException)
		{
			responseDTO.setFlag(false);
			responseDTO.setStatus("0");
//			errorinfo.setCode(((MedicalException) e).getCode());
			errorinfo.setMessage(e.getMessage());
		}
		else
		{
			errorinfo.setMessage("系统异常，请联系管理员或稍后重试！");
			
		}

		StringBuilder sb = new StringBuilder(e.toString());
		
		for (StackTraceElement trace : e.getStackTrace())
		{
			sb.append("\\n\\tat ").append(trace);
		}

		  /*  使用response返回    */  
        response.setStatus(HttpStatus.OK.value()); //设置状态码  
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType  
        response.setCharacterEncoding("UTF-8"); //避免乱码  
        response.setHeader("Cache-Control", "no-cache, must-revalidate");  
        PrintWriter pw = null;
        try {  
        	pw = response.getWriter();
        	pw.write(JSONObject.fromObject(responseDTO).toString());  
        } catch (IOException ex) {  
        	logger.error("与客户端通讯异常:"+ e.getMessage(), e);  
        } finally {
        	if (pw != null)
            {
                pw.flush();
                pw.close();
            }
		} 
		logger.error("系统异常", e);

		return null;
	}

//	@Async
//	void insertLog(HttpServletRequest request, Exception ex)
//	{
//		// 操作日志记录
//		SystemLog sLog = new SystemLog();
//		// sLog.setAdminId(getAdmin(request).getId());
//		sLog.setActionUrl(request.getQueryString());
//		sLog.setAdminIp(getIP(request));
//		sLog.setLogTime(new Date());
//		sLog.setLogDesc(ex.getMessage());
//		try
//		{
//			logService.insert(sLog);
//		}
//		catch (Exception e)
//		{}
//	}

	public static String getIP(HttpServletRequest request)
	{
		String ip = request.getHeader("x-real-ip");

		if (StringUtils.isEmpty(ip))
		{
			ip = request.getHeader("x-forwarded-for");
		}
		if (StringUtils.isEmpty(ip))
		{
			ip = request.getRemoteAddr();
		}
		else if (StringUtils.isEmpty(ip))
		{
			ip = "0.0.0.0";
		}
		return ip;
	}

}