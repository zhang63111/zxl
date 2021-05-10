package com.zxl.model;

import lombok.Data;

@Data
public class Student {
	private String userId;
	private String userName;
	private String password;
	private String sex;
	private int age;
	public Student(String userId, String userName, String password, String sex, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}
	public Student() {
		super();
	}

}
