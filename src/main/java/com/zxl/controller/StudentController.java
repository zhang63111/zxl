package com.zxl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.model.ProjectResult;
import com.zxl.model.Student;
import com.zxl.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/getAllStudent")
	public ProjectResult getStudent() {
		ProjectResult result=new ProjectResult();
		List<Student> stuList=studentService.getAllStudent();
		if(null!=stuList) {
			result.setObj(stuList);
			result.setCode("200");
			result.setMessage("success");
		}else {
			result.setCode("400");
			result.setMessage("no data");
		}
		return result;
	}

}
