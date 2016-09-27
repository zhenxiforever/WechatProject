-- 新增用户
delete from wechatmanage.SYS_USER where userid = 'admin';
insert into wechatmanage.SYS_USER values('admin','超级管理员','e10adc3949ba59abbe56e057f20f883e','15876527144',0);
-- 新增公众号
delete from wechatmanage.wx_account where id = 'wj_test';
insert into wechatmanage.wx_account values('wj_test','开发测试号','wechat','wxfe5d5b9268398000','d82bf21da648a6645e674e6e17da90da',
'','','token','aeskey','picurl','1','admin',now());

-- 新增角色
delete from wechatmanage.SYS_ROLE where roleid = '101';
insert into wechatmanage.SYS_ROLE(roleid,rolename,disable) values('101','超级管理员',0);
-- 新增用户所属角色
delete from wechatmanage.SYS_USER_ROLE where userid = 'admin' and roleid = '101';
insert into wechatmanage.SYS_USER_ROLE(userid,roleid) values('admin',101);


-- 新增 请求url 
delete from wechatmanage.sys_url where id >299 and id < 343;
insert into wechatmanage.sys_url(id,url,name,log_flag) values(300,'/sys/user/login','登陆',1);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(301,'/sys/user/list','查看系统用户列表',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(302,'/sys/user/add','新增系统用户',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(303,'/sys/user/edit','编辑系统用户',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(304,'/sys/user/disable','禁用系统用户',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(305,'/sys/role/list','查看系统用户角色列表',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(306,'/sys/user/password/reset','重置系统用户密码',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(307,'/sys/user/disable','启用系统用户',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(308,'/sys/role/list','查看系统用户角色列表',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(309,'/sys/role/save','新增系统用户角色',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(310,'/sys/role/save','编辑系统用户角色',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(311,'/sys/role/save','禁用系统用户角色',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(312,'/sys/role/save','启用系统用户角色',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(313,'/sys/role/oper/list','角色权限清单',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(314,'/sys/role/oper/save','角色权限保存',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(316,'/operate/list','查看系统操作按钮',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(317,'/operate/add','新增系统操作按钮',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(318,'/operate/edit','编辑系统操作按钮',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(319,'/operate/delete','删除系统操作按钮',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(320,'/menu/list','查看系统菜单列表',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(321,'/menu/add','新增系统菜单',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(322,'/menu/edit','编辑系统菜单',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(323,'/menu/delete','删除系统菜单',0); 
insert into wechatmanage.sys_url(id,url,name,log_flag) values(324,'/menu/operate','获取系统操作按钮',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(325,'/menu/addOper','新增系统菜单功能',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(326,'/menu/editOper','编辑系统菜单功能',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(327,'/menu/deleteOper','删除系统菜单功能',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(328,'/sys/oper/log','查看系统操作日志',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(329,'/sys/conf/list','查看系统参数',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(330,'/sys/conf/update','编辑系统参数',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(331,'/weixin/menu/get','查看服务号菜单',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(332,'/weixin/menu/module','查看服务号菜单',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(333,'/weixin/menu/save','保存服务号菜单',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(334,'/weixin/menu/sort','排序服务号菜单',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(335,'/weixin/menu/delete','删除服务号菜单',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(336,'/weixin/menu/create','上传到腾讯服务器',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(337,'/weixin/user/list','查看关注用户列表',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(338,'/weixin/qrcode/list','查看二维码列表',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(339,'/weixin/qrcode/add','新增二维码',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(340,'/weixin/qrcode/online','上线二维码',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(341,'/weixin/qrcode/online','下撤二维码',0);
insert into wechatmanage.sys_url(id,url,name,log_flag) values(342,'/weixin/qrcode/show','查看二维码',0);

-- 新增 功能请求 
delete from wechatmanage.sys_func_url where funcid >200 and funcid <243;
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(201,301,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(202,302,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(203,303,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(204,304,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(205,305,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(206,306,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(207,307,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(208,308,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(209,309,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(210,310,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(211,311,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(212,312,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(213,313,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(214,314,0); 
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(216,316,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(217,317,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(218,318,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(219,319,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(220,320,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(221,321,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(222,322,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(223,323,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(224,324,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(225,325,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(226,326,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(227,327,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(228,328,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(229,329,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(230,330,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(231,331,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(232,332,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(233,333,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(234,334,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(235,335,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(236,336,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(237,337,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(238,338,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(239,339,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(240,340,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(241,341,0);
insert into wechatmanage.sys_func_url(funcid,urlid,disable) values(242,342,0);

-- 新增 角色与系统功能的关系表 roleid=101表示超级管理员 
delete from wechatmanage.sys_role_func where roleid = 101;
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 201); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 202); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 203); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 204); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 205); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 206); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 207); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 208); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 209); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 210); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 211); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 212); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 213); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 214); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 215); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 216); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 217); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 218); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 219); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 220); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 221); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 222); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 223); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 224); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 225); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 226); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 227); 
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 228);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 229);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 230);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 231);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 232);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 233);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 234);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 235);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 236);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 237);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 238);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 239);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 240);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 241);
insert into wechatmanage.sys_role_func (ROLEID, FUNCID) values (101, 242);

-- 新增功能按钮
delete from wechatmanage.sys_operate where operid >400 and operid <416;
insert into wechatmanage.sys_operate(operid,opername,operkey) values(401,'查看','query');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(402,'新增','add');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(403,'编辑','modify');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(404,'禁用','forbidden');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(405,'重置密码','resetpwd');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(406,'启用','sub');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(407,'详情','detail');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(408,'角色功能设置','rolefunc');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(409,'删除','delete');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(410,'保存微信菜单','add_wxmenu');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(411,'排序','sort');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(412,'上传到微信服务器','upload_wechat');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(413,'上线','online');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(414,'下撤','offline');
insert into wechatmanage.sys_operate(operid,opername,operkey) values(415,'查看二维码','checkQrcode');

-- 新增菜单 
delete from wechatmanage.sys_menu where menuid >= 499 and menuid <514;
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(500,0,'系统管理','',1); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(501,500,'系统用户列表','sys/sysUser.html',2); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(502,500,'系统用户角色','sys/sysRole.html',3); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(503,500,'系统功能按钮','sys/sysOperate.html',4); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(504,500,'系统菜单列表','sys/sysMenu.html',5); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(505,500,'系统操作日志','sys/sysLog.html',6); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(506,500,'系统参数配置','sys/sysConf.html',7);

insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(510,0,'服务号管理','',8); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(511,510,'服务号菜单管理','wxaccount/wx_menu.html',9); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(512,510,'关注用户列表','wxaccount/wx_user.html',10); 
insert into wechatmanage.sys_menu(menuid,parentid,menuitem,url,sort) values(513,510,'二维码列表','wxaccount/wx_qrcode.html',11); 


-- 新增 系统功能
delete from wechatmanage.sys_func where funcid >200 and funcid <243;
insert into wechatmanage.sys_func(funcid,menuid,operid) values(201,501,401);-- 查看系统用户列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(202,501,402);-- 新增系统用户
insert into wechatmanage.sys_func(funcid,menuid,operid) values(203,501,403);-- 编辑系统用户
insert into wechatmanage.sys_func(funcid,menuid,operid) values(204,501,404);-- 禁用系统用户
insert into wechatmanage.sys_func(funcid,menuid,operid) values(205,501,401);-- 查看系统用户角色列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(206,501,405);-- 重置系统用户密码
insert into wechatmanage.sys_func(funcid,menuid,operid) values(207,501,406);-- 启用系统用户
insert into wechatmanage.sys_func(funcid,menuid,operid) values(208,502,401);-- 查看系统用户角色列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(209,502,402);-- 新增系统用户角色
insert into wechatmanage.sys_func(funcid,menuid,operid) values(210,502,403);-- 编辑系统用户角色
insert into wechatmanage.sys_func(funcid,menuid,operid) values(211,502,404);-- 禁用系统用户角色
insert into wechatmanage.sys_func(funcid,menuid,operid) values(212,502,406);-- 启用系统用户角色
insert into wechatmanage.sys_func(funcid,menuid,operid) values(213,502,408);-- 角色权限清单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(214,502,408);-- 角色权限保存
insert into wechatmanage.sys_func(funcid,menuid,operid) values(215,502,407);-- 查看系统用户角色详情
insert into wechatmanage.sys_func(funcid,menuid,operid) values(216,503,401);-- 查看系统操作按钮
insert into wechatmanage.sys_func(funcid,menuid,operid) values(217,503,402);-- 新增系统操作按钮
insert into wechatmanage.sys_func(funcid,menuid,operid) values(218,503,403);-- 编辑系统操作按钮
insert into wechatmanage.sys_func(funcid,menuid,operid) values(219,503,409);-- 删除系统操作按钮
insert into wechatmanage.sys_func(funcid,menuid,operid) values(220,504,401);-- 查看系统菜单列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(221,504,402);-- 新增系统菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(222,504,403);-- 编辑系统菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(223,504,409);-- 删除系统菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(224,504,401);-- 获取系统操作按钮
insert into wechatmanage.sys_func(funcid,menuid,operid) values(225,504,402);-- 新增系统菜单功能
insert into wechatmanage.sys_func(funcid,menuid,operid) values(226,504,403);-- 编辑系统菜单功能
insert into wechatmanage.sys_func(funcid,menuid,operid) values(227,504,409);-- 删除系统菜单功能
insert into wechatmanage.sys_func(funcid,menuid,operid) values(228,505,401);-- 查看系统操作日志
insert into wechatmanage.sys_func(funcid,menuid,operid) values(229,506,401);-- 查看系统参数
insert into wechatmanage.sys_func(funcid,menuid,operid) values(230,506,403);-- 编辑系统参数
insert into wechatmanage.sys_func(funcid,menuid,operid) values(231,511,401);-- 查看服务号菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(232,511,401);-- 查看服务号菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(233,511,410);-- 保存服务号菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(234,511,411);-- 排序服务号菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(235,511,409);-- 删除服务号菜单
insert into wechatmanage.sys_func(funcid,menuid,operid) values(236,511,412);-- 上传到微信服务器
insert into wechatmanage.sys_func(funcid,menuid,operid) values(237,512,401);-- 查看关注用户列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(238,512,401);-- 查看二维码列表
insert into wechatmanage.sys_func(funcid,menuid,operid) values(239,512,402);-- 新增二维码
insert into wechatmanage.sys_func(funcid,menuid,operid) values(240,512,413);-- 上线二维码
insert into wechatmanage.sys_func(funcid,menuid,operid) values(241,512,414);-- 下撤二维码
insert into wechatmanage.sys_func(funcid,menuid,operid) values(242,512,415);-- 查看二维码

