package com.bilibala.wechat.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bilibala.wechat.model.message.request.RequestMessage;
import com.bilibala.wechat.model.message.request.impl.TextRequestMessage;
import com.bilibala.wechat.service.wechat.IRequestDispatchService;


public class SpringBeanTest {

	private IRequestDispatchService requestDispatchService;
	
//	@Before
    public void init(){
		ClassPathXmlApplicationContext testContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
		testContext.start();
        requestDispatchService = (IRequestDispatchService) testContext.getBean("requestDispatchService");
    }
	
//	@Test
	public void beanTest(){
		RequestMessage requestMessage = new TextRequestMessage("",null );
		try {
			requestDispatchService.dispatch(null, requestMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
