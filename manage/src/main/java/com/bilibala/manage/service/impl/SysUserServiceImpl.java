package com.bilibala.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bilibala.common.util.MD5;
import com.bilibala.exception.PlatformException;
import com.bilibala.manage.dao.mapper.SysMenuMapper;
import com.bilibala.manage.dao.mapper.SysUserMapper;
import com.bilibala.manage.dao.model.SysMenu;
import com.bilibala.manage.dao.model.SysUser;
import com.bilibala.manage.service.ISysUserService;

@Service
public class SysUserServiceImpl extends BaseService implements ISysUserService {

	private SysUserMapper sysUserMapper;
	
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public SysUser login(String userid, String password)
			throws PlatformException {
		sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
		
		SysUser loginUser = sysUserMapper.login(userid,MD5.encodeByMd5AndSalt(password));
        if (loginUser == null) {
            //兼容不加盐的MD5密码
            loginUser = sysUserMapper.login(userid,MD5.EncoderByMd5(password));
            if (loginUser != null) {
            	loginUser.setPassword(MD5.encodeByMd5AndSalt(password));
            	sysUserMapper.updateUserPasswd(loginUser, MD5.EncoderByMd5(password));
            }
        }
		return loginUser;
	}

	@Override
	public List<SysMenu> getSysMenuTree(String userid) throws PlatformException {
		sysMenuMapper = sqlSession.getMapper(SysMenuMapper.class);
		
		List<SysMenu> parenMenuList = sysMenuMapper.getParentMenuList();
		
		Map<Integer,SysMenu> menuMap = new HashMap<Integer,SysMenu>();
		
		for(SysMenu sysmenu:parenMenuList){
			menuMap.put(sysmenu.getMenuid(), sysmenu);
		}

		List<SysMenu> menuList = sysMenuMapper.getMenuListByUserid(userid);
		
		for(SysMenu sysmenu:menuList){
			SysMenu menu = menuMap.get(sysmenu.getParentid());
			if(menu!=null){
				menu.addChiledMenu(menu);
			}
		}
		
		return parenMenuList;
	}
	
}
