-- 下面的表为一个服务号对应一个数据库用户
-- 服务号菜单表
drop table IF EXISTS wechat.WX_MENU;
create table wechat.WX_MENU
(
  ID           INT(11) not null AUTO_INCREMENT comment '菜单id',
  PARENT_ID    VARCHAR(32) comment '父菜单id',
  NAME         VARCHAR(32) comment '菜单名称',
  TYPE         VARCHAR(32) comment '菜单类型',
  CONTENT      VARCHAR(1024) comment '菜单内容',
  POST_FLAG    INT(1) default 0 comment '是否与微信同步；1，已同步；0，未同步',
  DELETE_FLAG  INT(1) comment '是否删除',
  SORT         INT(5) comment '菜单排序',
  constraint PK_WX_MENU_ID  primary key(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1001 comment = '公众号菜单';

-- 服务号参数配置表
drop table IF EXISTS wechat.WX_CONF;
create table wechat.WX_CONF
(
  WX_KEY  VARCHAR(256) comment '参数配置key',
  WX_VALUE VARCHAR(1024) comment '参数配置值',
  WX_DESC  VARCHAR(256) comment '参数描述',
  WX_SORT  INT(5) comment '参数排序',
  WX_FLAG  INT(1) comment '参数标识',
  constraint PK_WX_CONF_ID  primary key(WX_KEY)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '各公众号 业务参数配置';

-- 服务号关注用户表
drop table IF EXISTS wechat.WX_USER;
create table wechat.WX_USER
(
  ID          INT(11) not null AUTO_INCREMENT comment '用户id',
  USERID      VARCHAR(256) comment '用户标识，可修改一次。唯一',
  OPENID      VARCHAR(28) comment '微信用户openid，对当前公众号唯一',
  unionid	  VARCHAR(32) comment '微信用户综合id，对当前同一开发平台不同应用唯一',
  NICKNAME    VARCHAR(256) comment '微信用户名称',
  GROUPID     INT comment '微信组别 ID',
  COUNTRY     VARCHAR(256) comment '用户所在国家',
  PROVINCE    VARCHAR(256) comment '用户所在省份',
  CITY        VARCHAR(256) comment '用户所在城市',
  SEX         INT(1) default 0 comment '用户性别 1:男；2:女；0:未知',
  IMAGEURL    VARCHAR(1024) comment '用户头像url地址；最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  LANGUAGE    VARCHAR(32) comment '用户的语言，简体中文为zh_CN',
  SUBSCRIBE   INT comment '用户是否关注 微信号 ；0:未关注；1:已关注',
  SUBSCRIBETIME  TIMESTAMP(6) comment '用户关注时间 如果用户曾多次关注，则取最后关注时间',
  SUBSCRIBETYPE  INT(1) comment '微信关注类型',
  REMARK         VARCHAR(256) comment '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  MOBILEPHONE    VARCHAR(32) comment '用户手机号',
  UPDATETIME     TIMESTAMP(6) comment '用户更新信息时间',
  constraint PK_WX_USER_ID  primary key(ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=10001 comment ='服务号微信关注用户';

-- 服务号二维码表
drop table IF EXISTS wechat.WX_QRCODE;
create table wechat.WX_QRCODE
(
  QRCODEID             VARCHAR(32) comment '二维码id',
  TICKET               VARCHAR(256) comment '二维码tiket，用于换取二维码',
  CHANNEL              VARCHAR(256) ,
  ACTIONTYPE           INT comment '二维码类型',
  EXPIRESECONDS        INT comment '有效时间',
  SCENEID              INT comment '场景值id', 
  SCENESTR             VARCHAR(64) comment '场景值id，字符串类型。仅用于永久二维码',
  ONLINESTATUS         INT comment '状态',
  CREATETIME           TIMESTAMP(6) comment '创建时间',
  constraint PK_WX_QRCODE_ID  primary key(QRCODEID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment = '公众号二维码管理';


/*-- 服务号菜单表排序序列
drop sequence wechat.wx_menu_sort_seq;
create sequence wechat.wx_menu_sort_seq
    increment by 1    --  每次加几个  
    start with 1      --  从1开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存

-- 服务号的关注用户表序列
drop sequence wechat.WX_USER_SEQ;
create sequence wechat.WX_USER_SEQ
    increment by 1    --  每次加几个  
    start with 0000001  --  从0000001开始计数
    nomaxvalue        --  不设置最大值
    NOCYCLE           --  一直累加，不循环
    CACHE 10;         --  缓存*/









