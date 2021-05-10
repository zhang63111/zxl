package com.zxl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxl.mapper.StudentMapper;
import com.zxl.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentMapper stuMapper;

	public List<Student> getAllStudent() {
		return stuMapper.getAllStudent();
	}

}
