package com.tedu.controller.simple;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/appservice/v1/file/api")
public class FileDownloadController {

	@RequestMapping("dowloadMp3Audio")
	public Object dowloadMp3Audio(HttpServletRequest request,@RequestParam("albumId")String albumId,String
			courseId) {
			
		
		
		return null;
	}
}
