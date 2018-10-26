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
		//�������Ƿ�������bean
		boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}

	@Test
	public void testLog(){
		//��־�����ɵ͵���
		logger.trace("����trace��־...");
		logger.debug("����debug��־...");
		//SpringBootĬ��ʹ��info����
		logger.info("����info��־...");
		logger.warn("����warn��־...");
		logger.error("����error��־...");
	}

	@Test
	public void contextLoads() {}

}
