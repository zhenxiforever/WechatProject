package com.bilibala.common.log.serialable;

import java.util.UUID;

/**
 * 
 * 
 * @project common-log
 * @author smile
 * @date 2016年6月18日
 */
public class GenSerialNo {

	public static String getUuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
