package com.zxl.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class DownLoadService {
	Logger Log=LoggerFactory.getLogger(DownLoadService.class);
	
	
	public void getTxt(HttpServletResponse response, HttpServletRequest request)  {
		String separator =File.separator;
        String filePath = "downLoad"+separator+"保护工具2.zip";
        Resource resource = new ClassPathResource(filePath);//用来读取resources下的文件
        InputStream is = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            File file = resource.getFile();
            if (file.exists()) {
            	is = new FileInputStream(file);
 	            os = response.getOutputStream();
 	            bis = new BufferedInputStream(is);
 	            //设置响应头信息
 	            response.setCharacterEncoding("UTF-8");
 	            response.setContentType("application/octet-stream; charset=UTF-8");
 	            response.setContentType("application/octet-stream; charset=iso-8859-1");
 	            StringBuffer contentDisposition = new StringBuffer("attachment; filename=\"");
 	            String fileName = file.getName();
 	            contentDisposition.append(fileName).append("\"");
 	            //设置文件名编码
 	            String contentDispositionStr = new String(contentDisposition.toString().getBytes(), "iso-8859-1");
 	            response.setHeader("Content-disposition", contentDispositionStr);
 	            byte[] buffer = new byte[500];
 	            int i;
 	            while ((i = bis.read(buffer)) != -1) {
 	                os.write(buffer, 0, i);
 	            }
 	            os.flush();
            }
           
        } catch (FileNotFoundException e) {
        	Log.debug("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os != null) os.close();
                if(bis != null) bis.close();
                if(is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	    }
		
	}


