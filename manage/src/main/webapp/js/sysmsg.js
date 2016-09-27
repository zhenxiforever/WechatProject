
window.msgs = {};
(function(m){
	if(m==undefined){
		m = {};		
	}
	m.no_query_right = "抱歉，您没有查看权限";
	m.newwin = "新建";
	m.savesuccess = "保存成功！";
	m.deletesuccess = "删除成功！";
	m.sendsuccess = "发送成功！";
	m.sendfailed = "发送失败!";
	m.create_time = '创建时间';
	m.islastpage = "已到末页！";
	m.isfirstpage = "已到首页!";
	m.msgtitle_alert = "提示";
	m.msgError_Tips_Title = "错误";
	m.loadingmsg = "加载中...";
	m.communication_error = "通讯失败！";
	m.return_json_error = "返回结果有误！";
	m.pagenumber_overflow = "页码超出范围！";
	m.pagenumber_error = "输入页码有误!";
	m.sessionended = "服务超时！";
	m.pleaseselect = "请选择...";
	m.logintimeout = "登录超时,请重新登录";
	m.warning = "警告";
	m.green = "#009900";
	m.red = "#990000";
	m.list_all = "全部";
	m.common_search = "查询";
	m.acct_switch_fail = "微信公众帐户切换失败";
	m.delete_tag_title = "删除";
	m.oper_failed = "操作失败:";
	m.oper_canceled = "操作已取消";
	m.common_title = "标题";
	m.common_commu_error = "与服务器通讯出错，请重新登录后继续操作";
	
	m.downloadAcctFailed = "加载公众帐号列表失败";

	m.login_field_namelabel = "用户名：";
	m.login_field_pwdlabel = "密码:";
	m.login_input_namepwd = "请输入用户名和密码!";
	
	m.users_infonoinit = "用户资料列表未初始化！";
	m.users_cannotfinddetail = "找不到[id = {id}]的用户资料！";
	m.users_group_del_comfirm = "删除分组操作会将该组下成员移动至未分组。是否确认删除操作！";
	m.users_before_op = "请选择用户!";
	m.users_new_group_success = "新分组已经创建成功！";
	m.users_group_modified = "分组保存成功!";
	m.users_not_bound="用户未绑定银行卡！";
	m.users_unbinding_failed = "解绑失败！";

	m.sysuser_form_notvalid = "表单验证失败，请检查用户名及密码！";
	m.sysuser_please_check_form_detail = "请重新检查表单内容！";
	m.sysuser_panel_createuser = "新增用户";
	m.sysuser_panel_edituser = "编辑用户";
	m.sysuser_panel_user_role_rel = "用户角色关系";
	m.sysuser_userlisttitle = "用户管理列表";
	m.sysuser_username = '用户名';
	m.sysuser_userrealname= '姓名';
	m.sysuser_emailaddr = '电邮地址';
	m.sysuser_telphone = '电话';
	m.sysuser_sexy = '性别';
	m.sysuser_sexy_1 = "男";
	m.sysuser_sexy_2 = "女";
	m.sysuser_bankname = '所属支行/分行';
	m.sysuser_before_op = "请选择一个用户！";
	m.sysuser_change_to_default_pwd = "密码成功重置为:【123456】。(不含【】)";
	m.sysuser_roles = "系统角色";
	m.sysuser_userstat = "禁用状态";
	m.sysuser_userstate_disabled = "禁用";
	m.sysuser_userstate_actived = "已启用";
	m.sysuser_filter_srvacct_label="服务号：";
	m.sysuser_filter_roles_label = "角色：";
	m.sysuser_keyword_PH = "登录名/姓名/机构名";
	
	m.sysuser_role_list_title = "角色管理列表";
	m.sysuser_role_please_type_role_name = "请输入角色名称！";
	m.sysuser_role_before_op = "请选择一个角色!";
	m.sysuser_role_params_error = "参数出错，请检查角色和用户关系!";
	m.sysuser_role_name = '角色名称';
	m.sysuser_role_status="禁用状态";
	m.sysuser_role_del_confirm = "是否禁用此角色!";
	m.sysuser_role_delete_success = "删除成功 , 准备刷新页面！";
	
	m.sysuser_sysconf_listtitle = "系统参数管理";
	m.sysuser_sysconf_key = '键';
	m.sysuser_sysconf_value = '内容';
	m.sysuser_sysconf_desc = '描述';
	m.sysuser_sysconf_before_op = "请先选择一项配置内容，再操作!";
	m.sysuser_sysconf_form_notvalid = "表单验证失败，请检查!";
	m.sysuser_sysconf_panel_edittitle = "编辑参数";

	m.appmsg="";
	m.appmsg_delete_confirm = "是否确认删除此条图文消息！";
	m.appmsg_delete_success = "删除成功，准备刷新！";
	m.appmsg_preivew_wxid = "请输入要发送预览的微信号！";

	m.appmsg_notfindappmsg = "找不到图文消息，可能已经从服务器删除!";
	m.appmsg_cannotempty = "消息不能为空！";
	m.appmsg_before_op = "图文消息不能为空，请先选择一份图文消息!";
	m.appmsg_msg_sending = "发送中，请耐心等待!";
	m.appmsg_communication_error = "与服务器通讯失败，请退出后重新登录！";
	m.appmsg_pagenumber_overflow = m.pagenumber_overflow;
	m.appmsg_pagenumber_error = m.pagenumber_error;
	m.appmsg_edit_title_toolong = "标题长度不能大于64字符";
	m.appmsg_preivew_title = "标题";
	m.appmsg_digest_toolong = "摘要长度不能大于120字符";
	m.appmsg_sourceurl_notwellformated ="【原文链接】格式不合法！";
	m.appmsg_fileid_notprovided = "请先上传封面图片！";
	m.appmsg_content_notempty = "请输入正文内容再保存！";
	m.appmsg_content_toolong="正文内容不能超过20000字符";
	
	m.sysloglist="系统用户操作日志";
	m.sysloglist_model="访问模块";
	m.sysloglist_action_name="操作内容";
    m.sysloglist_param="操作参数";
	m.sysloglist_create_date="创建时间";
	m.sysloglist_sysuser="操作者";
	m.sysloglist_isSuccess="操作成功与否";
	
	m.syslog_username="用户姓名";
	m.syslog_opername="操作类型";
	m.syslog_params="参数";
	m.syslog_success="操作状态";
	m.syslog_remark="描述";
	m.create_date="创建日期";
	m.syslog_userid="用户账号";
	
	m.sys_chgpwd_mail_pnl_title= "用户密码修改";
	m.sys_chgpwd_org_pwd_label = "原密码";
	m.sys_chgpwd_new_pwd_label = "新密码";
	m.sys_chgpwd_newpwdcfm_label = "新密码确认";
	m.sys_chgpwd_updateChange_val = "确定";
	m.sys_chgpwd_resetForm_val = "重置";	
	
	m.agent_listtitle="应用列表";
	m.agent_agentid="应用ID";
	m.agent_name="应用名称";
	m.agent_authdomain="应用域名";
	m.agent_url="回调URL";
	m.agent_token="令牌";
	m.agent_aeskey="密钥";
	m.agent_picurl="应用图片URL";
	m.agent_status="状态";
	m.agent_status_enable="启用";
	m.agent_status_disable="禁用";
	m.agent_creator="创建者";
	m.agent_createtime="创建时间";
	m.agent_before_op = "请选择一个应用！";
	m.agent_panel_create ="新增应用";
	m.agent_panel_edit ="编辑应用";
	m.agent_setmenu = "配置菜单";

	
	m.wx_menu_new_wxmenu = "新建菜单";
	m.wx_menu_lv2_menu_cannot_have_subbutton = "二级菜单不能再建子菜单";
	m.wx_menu_lv1_to_lv2_alertmsg = "若添加二级菜单，此菜单绑定功能将会自动解除，请问是否继续？";
	m.wx_menu_lv1_released_alertmsg = "功能解除成功，请继续添加二级菜单";
	m.wx_menu_remove_menu = "移除菜单";
	m.wx_menu_delete_cfmmsg = "您确定要删除此菜单吗?";
	m.wx_menu_getknowloedgbase_error = "获取已绑定知识库明细失败";
	m.wx_menu_alert_tips_name_cannot_be_empty = "[名称]不能为空";
	m.wx_menu_lv1_menu_only_with_three_subbutton = "一级菜单最多只能建立3项";
	m.wx_menu_lv2_menu_only_with_five_subbutton = "二级菜单最多只能建立5项";
	m.wx_menu_submit_success_tips = "发送成功，微信客户端显示稍有延迟，请耐心等待";
	

	
	window.msgs = m;
})(window.msgs);