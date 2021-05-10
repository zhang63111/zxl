package com.zxl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class FirstSpringbootApplicationTests {
	@Autowired
	ApplicationContext app;
	private Logger logger2;

	@Test
	void contextLoads() {
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("日志测试成功");
	}

}
