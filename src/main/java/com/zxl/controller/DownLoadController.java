package com.zxl.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zxl.service.DownLoadService;

@RequestMapping(value="/downLoad")
@Controller
public class DownLoadController {
	
	@Autowired
	DownLoadService  downLoadService;
	@RequestMapping(value="/getTxt",method=RequestMethod.GET)
	public void getGongju(HttpServletResponse response,HttpServletRequest request) throws FileNotFoundException {
		downLoadService.getTxt(response,request);
	}

}
