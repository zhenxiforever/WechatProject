<!DOCTYPE html>
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
<link rel="stylesheet" type="text/css" href="common.css">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/base-config.js"></script>
<script type="text/javascript" src="locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
	body{
		min-width:1024px;
	}
	
	.topHeadr { 
		height:100px;
		position:relative;
	}
	
	div#luserpanel{	
		position:absolute;
		right:30px;
		top:50px;
		height:40px;
		line-height: 40px;
		vertical-align:middle;
		display: block;		
		color:black; 	
	}
	div#luserpanel *{
		font-size: 14px;
	}
	div#luserpanel .luseritem{
		float: left;
		display: inline-block;		
		height:30px;
		text-align:right;
		padding-right:120px;
		min-width:500px;
	}
	.backSysBtn{
		position:absolute;
		width:80px;
		height:30px;
		line-height:30px;
		bottom:6px;
		right:20px;
		color:black;
		font-size:16px;
		border:1px solid black;
		text-align: center;
	}
	.backSysBtn:hover {
		cursor:pointer;
		background-color: gray;
		font-weight: bold;
	}
	.west_header{
		/*background: #034566;*/
	}
	.west_header *{
		color:#5DBBE7;
		font-size:15px;
	}
	.panel-header, .panel-body{

	}
	.tabs li a.tabs-inner{
		background: #DFF3FF;
	}
	.globalMsg
	{
		position: absolute;
		color:Red;
		z-index:9999;
		text-align: center;
		line-height: 27px;
		font-size:15pt;
		font-weight: bold;
		padding:2px;
		display: none;
		width:100%;
		height:25px;
		left:0px;
		top:0px;
		background:#b7deed;
		opacity:0.8;
	}
	</style>
</head>
<body class="easyui-layout">
	<!-- 顶部 -->
	<div data-options="region:'north'" class="topHeadr" >
		<div id="luserpanel" >
			<div class="luseritem"><label>登录用户：</label><span id="loginUser"></span></div>
			&nbsp;&nbsp;
			<div id="logout" class="backSysBtn">退&nbsp;&nbsp;出</div>			
		</div>
	</div>
	<!-- 左侧菜单 -->
	<div id="leftTreeNote" data-options="region:'west',split:true,headerCls:'west_header',collapsible:false" title="功能菜单" style="width:215px;">
		<ul class=" mainmenu easyui-tree" data-options="fit:true,border:false">
		</ul>
	</div>
	<!-- 中间部分 -->
	<div data-options="region:'center'">
		<div id="mainregion" data-options="fit:true,border:false,plain:true">
			<div title="欢迎" data-options="href:'content.html'" style="padding:10px"></div>
		</div>
	</div>
	<div id='globalMsg' class='globalMsg panel-header'>
		<div id="textHolder" class="textHolder"></div>
	</div>
	<div id="popDetail" class="easyui-window"  style="text-align:center;"
		data-options="closed:true,modal:true,resizable:false,draggable:false,collapsible:false,minimizable:false">
		<div id="contentDiv"></div>
	</div>

</body>
<script type="text/html" id="tmplMenu">
	<div title="{name}" style="padding:2px;"></div>
</script>
<script type="text/html" id="tmplMenuItem">
	<div class="menu_item menu_platform" data-func="{key}" data-title="{name}">
		{name}
	</div>
</script>
<script type="text/javascript"> 
	var appIndex = {
		urlGetFunctions : top.window.WXYH.base + "/sys/user/menu.do",//菜单url
		urlLogout : top.window.WXYH.base + "/sys/user/logout.do" //注销url
	}
	var G = {
		config:{},
		menu:{}
	};
	
	$(function(){
	});
	
	$('#mainregion').tabs({
		headerWidth:200,
		toolPosition:"left"		
	});

	(function(w,g){
		w.W = {};
		W.upload = {};
		W.upload.suc = function(msg, type, formId, fileid){
			var pp = $('#mainregion').tabs('getSelected');
			var index = $('#mainregion').tabs('getTabIndex',pp);
			var tab =  $("#mainregion").tabs("getTab",index);
			var ifr = tab.find("iframe").get(0);
			var href = ifr.contentDocument.location.href;		
			if(fileid!=undefined){
				ifr.contentWindow.W.upload.suc("",type,formId,fileid);
				top.G.alert("上传成功！");	
			}else{
			}
		}
		W.upload.err = function(msg,type,formId){
			var pp = $('#mainregion').tabs('getSelected');
			var index = $('#mainregion').tabs('getTabIndex',pp);
			var tab =  $("#mainregion").tabs("getTab",index);
			var ifr = tab.find("iframe").get(0);
			ifr.contentWindow.W.upload.err();
			top.G.alert("上传失败！");
		}
		if(w.G){
			w.G = g;
			w.G.loginuserid = "admin";		
			w.G.addTab = addTab;
			w.G.newSendTab = function(nickname,openid){
				var url = w.G.menu.singlemsgpage + "?openid=" + openid +"&t="+(new Date().getTime());
				w.G.addTab("与 " + nickname + " 聊天中",url);				
			}
			w.G.msgDiv = null;
			w.G.offset = {left:(top.window.$("body").width()*1.0/2.0-170) , top:0};
			w.G.makeCommError = function(){
				w.G.alert("通讯失败，请退出重新登录！")
			}
			w.G.fillTemplate = function(tmpl,obj){
				var html = tmpl;
				for(var key in obj){
					var regexp = eval("/\{" + key + "\}/ig");
					html = html.replace(regexp,obj[key]);
				}
				return html;
			}
			w.G.showProcess = function(isShow, title, msg) {
				if (!isShow) {
					$.messager.progress('close');
					return;
				}
				var win = $.messager.progress({
					title: title,
					msg: msg,
					content:"正在处理...请稍候"
				});
			}
			w.G.jAlert = function(title,message){
				$.messager.alert(title,message);
			}
			w.G.showWaiting = function(){
				$(".winBFS").window("open").window("center");
			}
			w.G.hideWaiting = function(){
				$(".winBFS").window("close");
			}
			w.G.isAlerting = false;
			w.G.alert = function(msg){
				if(w.G.msgDiv==null){
					var jDiv = $("#globalMsg");
					w.G.msgDiv = jDiv;
				}		
				w.G.isAlerting = true;
				w.G.msgDiv.find(".textHolder").empty();
				w.G.msgDiv.find(".textHolder").html( msg );		
				w.G.msgDiv.fadeIn(400,function(){
					setTimeout(function(){
						w.G.msgDiv.hide();w.G.isAlerting=false;
					},1500);
				});
			}
		}
	})(window,G);

	$.getScript(appIndex.urlGetFunctions).done(function(script, textStatus) {
		G.config = config;
		G.sysuser = config.sysuser;
		var sysuser = G.sysuser;
		$("#loginUser").html(sysuser.username+"("+G.sysuser.userid+")");//登陆用户		
		if(sysuser.role_list!=undefined){
			var roleslist = $.map(sysuser.role_list,function(v,i){
				return v.rolename;
			}).join("|");
			//$("#roles").html(roleslist);//角色权限
		}		
 		$("#luserpanel").data("oldWidth",$("#luserpanel").width());
		if($("#luserpanel").data("totalWidth")==undefined){
			var totalWidth = 0;
			var l = $(".luseritem");		
			$.map(l,function(itm,idx){ 
				return totalWidth += $(itm).width()*1+10;
			})
			$("#luserpanel").data("totalWidth",totalWidth);
		} 
		var m = window.G.config.menu_list; 
		delete G.menu;
		G.menu = {};
		var html = "";
		$(".mainmenu").html("");
		//重构树控件需要的数据结构，并将菜单ID与链接保存到 window.G.menu 对象中
		//格式：{"menuid":"url","menuid","url"}
		var menuArr = parseToEasyUITreeNodeObject(m,0);
		$(".mainmenu").tree({
			data:menuArr,
			onClick:function(node){
				//点击菜单后，判断节点数据的id是否为0，
				//只有大于0才是子叶菜单，有相关链接数据，然后调用addTab方法添加
				//一个Tab页在index.html的主区域中。
				var data = $(this).tree("getData",node.target);
				if(data.id>0){
					if(G.menu[data.id]!=undefined){
						addTab(data.text,G.menu[data.id]+"?mid="+data.id +"&t="+(new Date().getTime())	);
					}else{
						$(this).tree("toggle",node.target);
					}
				}
			}	
		});
		//单独保存客服消息聊天的链接。
		G.menu.singlemsgpage="user/chat.html";
	}).complete(function(xhr,errorMsg){
		if(xhr.responseText.indexOf("{")==0){
			var body = xhr.responseText; 
			var respObj = eval("("+body+")");
			if(respObj.retcode==-1000){
				alert("用户已经超时或未登录，请重新登录");
				top.location.replace("login.html");
				return;
			}else if(respObj.retcode==-2000){
				alert("用户没有权限，请联系管理设置");
				return;
			}
		}
	});
	
	//点击退出，注销登陆
	$("#logout").on("click",function(e){
		top.location.replace(appIndex.urlLogout);
	})

	$("<div class='winBFS' style='width:72px;height:72px;text-align:center;' ><img style='width:72px;height:72px;' src='"+window.WXYH.base+"/images/waiting.gif'/></div>").appendTo("body");
	$(".winBFS").window({modal:true,title:"加载中...",width:150,height:150,doSize:true	})
				.window(top.window.winOpt).window("close")
				.window("center");
</script>
</html>