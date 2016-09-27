--  创建后台管理超级管理员
DROP TABLE  IF EXISTS wechatmanage.SYS_USER;
CREATE TABLE  wechatmanage.SYS_USER
(
  USERID     VARCHAR(32) COMMENT '用户id',
  USERNAME   VARCHAR(32) COMMENT '用户名称',
  PASSWORD   VARCHAR(256) COMMENT '登陆密码',
  TEL  VARCHAR(16) COMMENT '用户联系方式',
  DISABLE int(1) not null default 0 COMMENT '是否禁用；1:禁用；0:启用',
  constraint PK_SYS_USER_ID  primary key(USERID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '系统用户表';

-- 后台管理系统角色表
DROP TABLE  IF EXISTS wechatmanage.SYS_ROLE;
CREATE TABLE  wechatmanage.SYS_ROLE
(
  ROLEID     int(5) AUTO_INCREMENT COMMENT '系统角色id',
  ROLENAME   VARCHAR(32) COMMENT '角色名称',
  DISABLE int(1) not null default 0 COMMENT '是否禁用；1:禁用；0:启用',
  constraint PK_SYS_ROLE_ID  primary key(ROLEID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1001  COMMENT = '系统角色表';

-- 后台管理 用户角色表
DROP TABLE  IF EXISTS wechatmanage.SYS_USER_ROLE;
CREATE TABLE  wechatmanage.SYS_USER_ROLE
(
  USERID  VARCHAR(32) COMMENT '用户id',
  ROLEID  int(5) COMMENT '角色id',
  constraint PK_SYS_USER_ROLE_ID  primary key(USERID,ROLEID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT = '用户角色表' ;

-- 后台管理 请求URL表
DROP TABLE  IF EXISTS wechatmanage.SYS_URL;
CREATE TABLE  wechatmanage.SYS_URL
(
  ID  int(5) AUTO_INCREMENT COMMENT '主键id',
  URL  VARCHAR(512) COMMENT '请求URL',
  NAME VARCHAR(64) COMMENT '请求名称', 
  LOG_FLAG int(1) default 0 COMMENT '暂未知',
  constraint PK_SYS_URL_ID  primary key(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3001  COMMENT = '请求URL表';

--  后台管理 功能请求表
DROP TABLE  IF EXISTS wechatmanage.SYS_FUNC_URL;
CREATE TABLE  wechatmanage.SYS_FUNC_URL
(
  FUNCID  int(5) AUTO_INCREMENT COMMENT '功能id',
  URLID  int(5) COMMENT '功能请求url',
  DISABLE int(1) not null default 0 COMMENT '是否禁用；1:禁用；0:启用',
  constraint PK_SYS_FUNC_URL_ID  primary key(FUNCID,URLID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=2001 COMMENT = '功能请求表';


-- 后台管理 角色功能表
DROP TABLE  IF EXISTS wechatmanage.SYS_ROLE_FUNC;
CREATE TABLE  wechatmanage.SYS_ROLE_FUNC
(
  ROLEID  int(5) COMMENT '角色id',
  FUNCID  int(5) COMMENT '系统功能id',
  constraint PK_SYS_ROLE_FUNC_ID  primary key(ROLEID,FUNCID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色功能表';


-- 后台管理 用户操作表
DROP TABLE  IF EXISTS wechatmanage.SYS_OPERATE;
CREATE TABLE  wechatmanage.SYS_OPERATE
(
  OPERID  int(5) AUTO_INCREMENT COMMENT '操作id',
  OPERNAME VARCHAR(50) COMMENT '操作名称',
  OPERKEY  VARCHAR(50) COMMENT '操作key',
  constraint PK_SYS_OPERATE_ID  primary key(OPERID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=4001 COMMENT = '系统用户操作表';

-- 后台管理 系统菜单表
DROP TABLE  IF EXISTS wechatmanage.SYS_MENU;
CREATE TABLE  wechatmanage.SYS_MENU
(
  MENUID  int(5) AUTO_INCREMENT COMMENT '系统菜单id' ,
  PARENTID int(5) COMMENT '父菜单id',
  MENUITEM  VARCHAR(50) COMMENT '菜单名称',
  SORT int(5) COMMENT '菜单排序',
  URL VARCHAR(200) COMMENT '菜单请求url',
  constraint PK_SYS_MENU_ID  primary key(MENUID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=5001 COMMENT = '系统菜单表';

--  后台管理 系统功能表
DROP TABLE  IF EXISTS wechatmanage.SYS_FUNC;
CREATE TABLE  wechatmanage.SYS_FUNC
(
  FUNCID  int(5) COMMENT '功能id' ,
  MENUID  int(5) COMMENT '功能菜单id',
  OPERID  int(5) COMMENT '操作id',
  constraint PK_SYS_FUNC_ID  primary key(FUNCID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '系统功能表';


-- 后台管理系统日志操作表
DROP TABLE  IF EXISTS wechatmanage.SYS_LOG_OPER;
CREATE TABLE  wechatmanage.SYS_LOG_OPER
(
  USERID  VARCHAR(50) COMMENT '用户id',
  USERNAME VARCHAR(50) COMMENT '用户名称',
  operid  int(5) COMMENT '用户操作id',
  OPERNAME  VARCHAR(64) COMMENT '用户操作名称',
  PARAMS  VARCHAR(1024) COMMENT '操作参数',
  SUCCESS int(1) COMMENT '操作结果',
  REMARK VARCHAR(256) COMMENT '备注',
  CREATE_TIME TIMESTAMP(6) COMMENT '操作时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台系统操作日志表';

-- 后台管理 系统参数配置表
DROP TABLE  IF EXISTS wechatmanage.SYS_CONF;
CREATE TABLE  wechatmanage.SYS_CONF
(
  SYS_KEY  VARCHAR(256) COMMENT '系统参数key',
  SYS_VALUE VARCHAR(1024) COMMENT '系统参数值',
  SYS_DESC  VARCHAR(256) COMMENT '系统参数描述',
  SYS_SORT  int(5) COMMENT '系统参数排序',
  SYS_FLAG  int(1) COMMENT '系统参数标识',
  constraint PK_SYS_CONF_ID  primary key(SYS_KEY)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台管理系统参数配置表';


-- 后台管理服务号表
DROP TABLE  IF EXISTS wechatmanage.WX_ACCOUNT;
CREATE TABLE  wechatmanage.WX_ACCOUNT
(
  ID          VARCHAR(50) COMMENT '公众号 账号 ACCOUNTID',
  NAME        VARCHAR(100) COMMENT '公众号 名称',
  ACCOUNTSCHEMA      VARCHAR(50) COMMENT '公众号 schema ，对应各自的公众号数据库schema',
  APPID       VARCHAR(100) COMMENT '公众号 APPID',
  APPSECRET   VARCHAR(100) COMMENT '公众号 APPSECRET',
  AUTHDOMAIN  VARCHAR(300) COMMENT '公众号 domain',
  URL         VARCHAR(400) COMMENT '公众号 回调URL',
  TOKEN       VARCHAR(32) COMMENT '公众号 设置token',
  AESKEY      VARCHAR(50) COMMENT '公众号消息加密 密钥',
  PICURL      VARCHAR(1024) COMMENT '公众号 头像url',
  ENABLE      int(1) not null default 0 COMMENT '是否禁用；1:禁用；0:启用',
  CREATOR     VARCHAR(50) COMMENT '公众号创建人',
  CREATETIME  TIMESTAMP(6) COMMENT '公众号创建时间',
  constraint PK_WX_ACCOUNT_ID  primary key(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '公众号信息表';


-- 后台管理 管理员对应服务号表
DROP TABLE  IF EXISTS wechatmanage.USER_ACCOUNT;
CREATE TABLE  wechatmanage.USER_ACCOUNT
(
  USERID      VARCHAR(32) COMMENT '用户id',
  ACCOUNTID   VARCHAR(50) COMMENT '公众号id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '公众号用户表';

-- 业务模块表
DROP TABLE  IF EXISTS wechatmanage.WX_MODULE;
CREATE TABLE  wechatmanage.WX_MODULE
(
  MODULEID      VARCHAR(50) COMMENT '模块id',
  MODULENAME    VARCHAR(50) COMMENT '模块名称',
  MODULEPATH    VARCHAR(200) COMMENT '模块对应处理类',
  MODULEFLAG    int COMMENT '模块标识 ，暂无',
  constraint PK_WX_MODULE_ID  primary key(MODULEID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '业务模块表';




/*
--  后台管理 系统角色序列
drop sequence wechatmanage.sys_role_seq;
create sequence wechatmanage.sys_role_seq
    increment by 1    --  每次自增1  
    start with 100  --  从100开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存

--  后台管理 用户操作按钮序列
drop sequence wechatmanage.sys_operate_seq;
create sequence wechatmanage.sys_operate_seq
    increment by 1    --  每次加几个  
    start with 100  --  从100开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存

-- 后台管理 系统菜单序列
drop sequence wechatmanage.sys_menu_seq;
create sequence wechatmanage.sys_menu_seq
    increment by 1    --  每次加几个  
    start with 100  --  从100开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存

-- 后台管理 系统功能序列
drop sequence wechatmanage.sys_func_seq;
create sequence wechatmanage.sys_func_seq
    increment by 1    --  每次加几个  
    start with 100  --  从100开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存

-- 后台管理系统请求url序列
drop sequence wechatmanage.sys_url_seq;
create sequence wechatmanage.sys_url_seq
    increment by 1    --  每次加几个  
    start with 100  --  从100开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;  
*/