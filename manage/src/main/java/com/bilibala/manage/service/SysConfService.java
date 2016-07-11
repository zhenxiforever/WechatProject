package com.bilibala.manage.service;

import java.util.Map;

import com.bilibala.manage.pojo.PojoDomain;
import com.bilibala.manage.pojo.SysConf;

public interface SysConfService {
	
	public PojoDomain<SysConf> querySysConfList(int page_number, int page_size);

	public SysConf updateSysConf(SysConf sysConf);

	public Map<String, String> findAll();

	public boolean subSysconf(String key, int flag);

	public boolean apprSysconf(String key, int flag);
}
