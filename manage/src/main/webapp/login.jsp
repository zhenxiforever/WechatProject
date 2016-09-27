<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>微信管理平台</title>
	<meta http-equiv="X-UA-Compatible" content="IE=8" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"> 
	<meta http-equiv="expires" content="Wed, 26 Feb 1970 08:21:57 GMT">
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/base-config.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
</head>
<style type="text/css">
    * {
		font-size:16pt;
	}
	body{
		position: relative;
	}
	.login_area{
		width:417px;
		margin:0px auto;
		margin-top:80px;
		border:1px solid black;
	}
	.inputText {
		width:300px;
		border: solid 1px gray;
	}
	.name{
		position:absolute;
		left:20px;
		top:45px;
		height:41px;
	}
	.password{
		position:absolute;
		left:20px;
		top:45px;	
		height:41px;
	}
	.rememberme{
		position:absolute;
		left:20px;
		top:15px;
	}
	.rememberme_word{
		position:absolute;
		left:45px;
		top:10px;	
	}
	.form_wrapper
	{	
		width:100%;
		min-height:330px;
		position: relative;
		border:solid 0px;
		margin-top:0px;
	}
	.btn{
		border:0px;
		width:110px;
		height:40px;
	}
	.loginbtn{
		position: absolute;
		left:20px;
		top:40px;
	}
	.resetbtn{
		position: absolute;
		left:180px;
		top:40px;
	}
	.form_name{
		position: relative;
		width:100%;
		height:100px;
		margin-top:20px;
	}
	.form_pwd{
		position: relative;
		width:100%;
		height:100px;
	}
	.form_bottom{
		position: relative;
		width:100%;
		height:100px;	
	}
</style>
<body >
	<div class="login_area">
		 <div class="form_wrapper">
		 	<form id="ff1" name="ff1" method="post">
		 	<div class="form_name">&nbsp;
				用户名：<input type="text" placeholder="请输入用户名" name="userid" id="userid"  class="inputText name" value="" />
		 	</div>
		 	<div class="form_pwd">&nbsp;
				密码：<input type="password" placeholder="请输入密码" name="password" id="password" class="inputText password" value=''/>
		 	</div>
		 	<div class="form_bottom">
		 		<input type="checkbox" id="rememberme" class="rememberme" value="1" /><label for="rememberme" class="rememberme_word">记住帐号</label><br/>
				<input type='button' name='t55' class="btn loginbtn" value='登陆' onclick="login();" />&nbsp;
				<input type='reset' name='t56' class="btn resetbtn" value='重置'  />
		 	</div>
			</form>
 		</div>
	</div>
</body>
<script>
	var appLogin = {
		urlLogin : top.window.WXYH.base + "/login.action"
	};
 	
	$(function(){
		checkNeedRestoreCookie();//获取cookie初始化账号
	})
	
	var needCode =false;
	
	function login() {
		if($.trim($("#userid").val())==""){
			document.getElementById("userid").focus();
			alert("请输入账号");
			return;
		}
		if($.trim($("#password").val())==""){
			document.getElementById("password").focus();	
			alert("请输入密码");
			return;
		}
		checkNeedSaveCookie();//记住账号
		$.ajax({
			url: appLogin.urlLogin,
			data:{
				userid:$("#userid").val(),
				password : hex_md5($("#password").val())
			},
			type : "post",
			async : true, 
			cache : false,
			success : function(data) {
				if(data.retcode=="0"){
					location.replace("index.jsp");
				}else{
					alert(data.retmsg);
					return;
				}
			},
			error : function(xhr,status,error){
			}
		});
	}
	
	//记住账号
	function checkNeedSaveCookie(){
		var chksaveme = document.getElementById("rememberme");
		if(chksaveme.checked){
			setCookie("pn",$("#userid").val(),30);
		}else{
			setCookie("pn","",0);
		}
	}
	
	//按下回车键
	$("#userid,#password").on("keypress",function(e){	
		if(e.keyCode==13){
			login();
		}
	})
	
	//获取cookie初始化账号
	function checkNeedRestoreCookie(){
		var cookieName = ""
		if(getCookie){
			cookieName = getCookie("pn")
			if(cookieName && cookieName!=""){
				$("#userid").val(cookieName);
				$("#rememberme").get(0).checked = true;
				$("#password").focus();
			}else{
				$("#userid").focus();
			}
		}
	}
</script>
</html>
