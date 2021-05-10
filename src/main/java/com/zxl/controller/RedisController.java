package com.zxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxl.model.Student;
import com.zxl.util.RedisUtils;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@RequestMapping(value="/redis")
@RestController
public class RedisController {
	@Autowired
	private RedisUtils redisUtils;
	
	@RequestMapping(value="set")
	private boolean setValue() {
		Student stu=new Student();
		stu.setUserId("zxl112233");
		stu.setUserName("zhangxiaolong");
		return redisUtils.set("zxl", stu);
	}
	@RequestMapping(value="get")
	private Object getValue(String key) {
		 key="zxl";
		Object obj=redisUtils.get(key);
		System.out.println(obj);
		return obj;
	}

}
