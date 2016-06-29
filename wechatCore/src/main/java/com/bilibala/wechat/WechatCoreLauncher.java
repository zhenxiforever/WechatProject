package com.bilibala.wechat;

import com.bilibala.common.util.ServerSystemDetail;

public class WechatCoreLauncher {

	public static void main(String[] args) {
		 ServerSystemDetail.outputDetails();
		com.alibaba.dubbo.container.Main.main(args);
	}

}
