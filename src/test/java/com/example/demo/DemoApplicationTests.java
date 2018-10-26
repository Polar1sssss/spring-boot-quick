package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	/*@Autowired
	Person person;*/

	@Autowired
	ApplicationContext ioc;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testHelloService(){
		//容器中是否包含这个bean
		boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}

	@Test
	public void testLog(){
		//日志级别，由低到高
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		//SpringBoot默认使用info级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
	}

	@Test
	public void contextLoads() {}

}
