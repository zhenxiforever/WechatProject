package com.bilibala.wechat;

import org.apache.log4j.PropertyConfigurator;

import com.bilibala.common.util.ServerSystemDetail;

public class WechatCoreLauncher {

	public static void main(String[] args) {
		 
		ServerSystemDetail.outputDetails();
		String rootPath=WechatCoreLauncher.class.getResource("/").getFile().toString(); 
		String relativelyPath=System.getProperty("user.dir"); 
		PropertyConfigurator.configure(rootPath+"config/log4j.properties"); 
		com.alibaba.dubbo.container.Main.main(args);
	}

}
