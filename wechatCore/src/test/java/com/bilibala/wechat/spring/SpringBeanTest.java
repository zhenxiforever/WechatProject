package com.bilibala.wechat.spring;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.request.impl.TextRequestMessage;
import com.bilibala.wechat.service.wechat.IRequestDispatchService;


public class SpringBeanTest {

	private ApplicationContext context;
	private IRequestDispatchService requestDispatchService;
	
	@Before
    public void init(){
		String rootPath=SpringBeanTest.class.getResource("/").getFile().toString(); 
//		PropertyConfigurator.configure(rootPath+"config/log4j.properties"); 
		context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		testContext.start();
        requestDispatchService = (IRequestDispatchService) context.getBean("requestDispatchService");
    }
	
	@Test
	public void beanTest(){
		try {
			RequestMessage requestMessage = new TextRequestMessage("",null );
			requestDispatchService.dispatch(null, requestMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
