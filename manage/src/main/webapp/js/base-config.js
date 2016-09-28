window.WXYH = {};
window.WXYH.base =  "";

var winOpt = {resizeable:false,minimizable:false,maximizable:false,closable:false,draggable:false,collapsible:false};
function setupAjax(){
	$.ajaxSetup({cache:false
		,timeout:30000
		,beforeSend:function(xhr,opts){
			if(opts.url.indexOf("_=")>=0){
				return;
			}
			opts.url +="?_t="+(+(new Date()));				
		}
		,complete:function(xhr){				
			if(xhr.statusText!=undefined && xhr.status==0 && xhr.statusText=="timeout"){
				$.messager.alert("超时","操作超时！请返回重试！","info",function(){xhr.abort();});
			}		
		}			
	});	
}
setupAjax();
$(document).ajaxComplete(function(event, xhr, settings) {	
  	var data;	  	
  	if (settings.dataType=="script" || settings.dataType=="html"){
  		return;
  	}
  	if(   xhr.responseText){
  		data = $.parseJSON(xhr.responseText);
  		if(data && data.retcode==-1000){
  			top.location.reload();
  		}
  	}
});
function checkJsonData(data){
	if(typeof data === "string"){
		data = $.parseJSON(data);
	}
	return data;
}
function compareDateWithMs(ms1,ms2){	
	return (ms2>=ms1)
}

//设置cookie
function setCookie(c_name, value, expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}

//读取cookie
function getCookie(c_name){
	if(document.cookie.length>0){
		c_start=document.cookie.indexOf(c_name + "=");
		if(c_start!=-1){
			c_start=c_start + c_name.length+1;
			c_end=document.cookie.indexOf(";",c_start);
			if(c_end==-1){
				c_end=document.cookie.length;
			}
			return unescape(document.cookie.substring(c_start,c_end));
		} 
	}
	return "";
}

window.formatString = function(str, key,val){
	return str.replace(key,val);
};
window.queryString = (function(){
  		var m = window.location.search.replace(/.*\?/, "").split("&");
		var m2 = {};
		jQuery.map(m,function(v,idx){ var c = v.split("=");m2[c[0]] = c[1]; });
		return m2;
	})();

function loadbuttons(app){
	app.hasQuery = false;
	app.opers = [];
	//控制功能按钮
	$.ajax({
		url:window.WXYH.base+"/sys/menu/oper.do"
		,async:false
		,data:"menuid="+window.queryString["mid"]
		,success:function(data){
			var optbtnlist = $("*[data-oper]");
			optbtnlist.hide();
			app.oper_list = data.oper_list;
			$("a[class*=easyui-linkbutton][data-oper]").linkbutton("disable");
			$("input[type=button][data-oper],button[data-oper]").attr("disabled","disabled");
			if(data!=null&&data.oper_list!=null&&data.oper_list.length>0){
				$.each(data.oper_list,function(idx,val){
					var operkey = val.operkey;
					if(true){
						app.hasQuery = true;
					}
					app.opers[operkey] = 1;
					var $btn = $("*[data-oper="+operkey+"]");
					$btn.each(function(i){
						var btn=$(this);
						btn.show();
						if(btn.hasClass("easyui-linkbutton")){
							btn.linkbutton("enable");
						}else{
							btn.removeAttr("disabled");
						}
					});
					
				});
			}
		}
	});
}


var maskTemplate = "<div class='topMask' style=\"background:white;width: 100%; height: "+$("body").height()+"px;line-height:"+$(window).height()/2+"px;vertical-align:middle; text-align: center; background-color: white; position: absolute; top: 0px; left: 0px; z-index: 9999999;\">" + 
		   "<img style=\"width: 80px; height: 80px;\" src=\""+window.WXYH.base + "/images/waiting.gif\" />" +
		   "</div>";
function showPageMask(){
	var bodyFirst = $("body").find("*").first();
	bodyFirst.before(maskTemplate);
}
function removePageMask(){
	$(".topMask").remove();
}
/*blockUI*/
function unblockUI(){
	$.unblockUI();
}
function blockUI(){
	$.blockUI({
		message:"<div style='margin-left:0px;width:100%;font-size:20px;'><center>加载中...请稍候</center></div>"
		,css:{
			"background":"none",
			"border":"none",
			"color":"#FFFFFF",
			"font-size":"36px",
			"margin":"0 0 0 0",
			"left":"0px",
			"width":"100%"
		}
	});
	// $("body").animate({
	// 	backgroundColor:"rgb(120,120,120)"},
	// 	0, function() {
	// 	$(this).animate({
	// 		backgroundColor: "rgb(225,85,9)"},
	// 		2000);
	// });
}
/*blockUI end */

///将menu_list的数组，递归构造成easyui tree控件可用的数据结构
/// [{id:1,text:"名称",state:"closed/open",children:[{子菜单集合},...{}] },...,{} ]
function parseToEasyUITreeNodeObject(data,menulevel){
// data : [{MENUID:,PARENTID:,MENUITEM:,URL:,childmenu:[{},...]},...]
	var arr = [];
	var item = null;
	for(var i = 0;i<data.length;i++){
		if(data[i]["menuid"]!=undefined && data[i].url!="" ){
			window.G.menu[data[i].menuid] = window.WXYH.base + "/" + data[i].url;
		}
		item = {id:data[i]["menuid"]==undefined?"0":data[i].menuid
			,text:data[i].menuitem
			,state:(menulevel==0&&i==0)?"open":"closed"
			,url:data[i]["url"]!=undefined?(window.WXYH.base + data[i].url):""
			,children:[]
			}
		if(data[i]["childMenu"]!=undefined&&data[i].childMenu.length>0){
			var c = parseToEasyUITreeNodeObject(data[i].childMenu,(menulevel+1));
			item.children=c;
		}else if(data[i]["parentid"]!=undefined&&data[i]["parentid"]!=0){
			item.state = "";
		}
		arr.push(item);
	}
	return arr;
}

try{
$("<div class='winPageWait' style='width:72px;height:72px;text-align:center;' ><img style='width:72px;height:72px;' src='"+window.WXYH.base + "/images/waiting.gif'/></div>").appendTo("body")
$(".winPageWait").window({modal:true,title:"加载中...",width:150,height:150,doSize:true	})
				.window(top.window.winOpt).window("close")
				.window("center")	;
}catch(ee){

}

window.showWait = function(){
	$(".winPageWait").window("open").window("center");
	$(".window-mask").height($(window).height());
};
window.hideWait = function(){
	$(".winPageWait").window("close");
};


if(window.G==undefined){
	var w = window;
	window.G = top.window.G||{};
	window.G.fillTemplate = function(tmpl,obj){
		var html = tmpl;
		for(var key in obj){
			var regexp = eval("/\{" + key + "\}/ig");			
			html = html.replace(regexp,obj[key]);
		}
		return html;
	};
	if(!window.G.alert){
		window.G.alert = function(msg){
			$.messager.alert(window.msgs.msgtitle_alert,msg);
		};
		

	}
	
}


function addTab(title, url,oldtitleprefix){  
	var tabs = $("#mainregion").tabs("tabs");
	var choosedIdx = -1 ;
	for(var ti = 0;ti<tabs.length;ti++){
		var pOpts = $($("#mainregion").tabs('getTab',ti)).panel('options');
		if(oldtitleprefix && pOpts.title!=undefined ){
			if(pOpts.title.indexOf( oldtitleprefix )>=0 && title.indexOf(oldtitleprefix)>=0){
				choosedIdx = ti;
				break;
			}
		}else{
			continue;
		}
	}
	$width = $('#mainregion').tabs('options').width;
	var content = "<iframe scrolling=\"auto\" frameborder=\"0\"  src=\""+url+"\" style=\"width:100%;height:99%;\"></iframe>"; 
    // if ($('#mainregion').tabs('exists', title)){
    // $('#mainregion').tabs('select', title);
    if(choosedIdx>-1){	   	
   		var tab = $("#mainregion").tabs('getTab',choosedIdx);   		
   		$('#mainregion').tabs('update', {
				tab: tab,
				options: {
					title: title,
					content: content
				}
			});
    	$('#mainregion').tabs('select', title);
    } else {  
    	if ($('#mainregion').tabs('exists', title)){ 
	   		$('#mainregion').tabs('select', title);  
	   	}else{       
	        $('#mainregion').tabs('add',{  
	            title:title,  
	            content:content, 
				closable:true ,
	            toolPosition:'left',
	            tools:[{  
				        iconCls:'icon-reloadsmall',  
				        handler:function(){  
				        			refreshTab("");
							    }  
					    }]  
	        });  
    	}
    }  
} 

function formatDateToYMD(t){
	var y=t.getFullYear();
	var m=t.getMonth()+1;
	if(m<10) m='0'+m;
	var d=t.getDate();
	if(d<10) d='0'+d;
	return y+"-"+m+"-"+d;
}
function formatDateToYMDHMS(t){
	var y=t.getFullYear();
	var m=t.getMonth()+1;
	if(m<10) m='0'+m;
	var d=t.getDate();
	if(d<10) d='0'+d;
	var h=t.getHours();
	if(h<10) h='0'+h;
	var mi=t.getMinutes();
	if(mi<10) mi='0'+mi;
	var s=t.getSeconds();
	if(s<10) s='0'+s;
	return y+"-"+m+"-"+d+" "+h+":"+mi+":"+s;
}


function closeTab(title){
	var pp = $('#mainregion').tabs('getSelected');
	var index = $('#mainregion').tabs('getTabIndex',pp);
	var tab =  $("#mainregion").tabs("getTab",index);
	$('#mainregion').tabs('close', index);
}

function refreshTab(title){
	var pp = $('#mainregion').tabs('getSelected');
	var index = $('#mainregion').tabs('getTabIndex',pp);
	var tab =  $("#mainregion").tabs("getTab",index);
	var ifr = tab.find("iframe").get(0);
	var href = ifr.contentDocument.location.href;
	href = href.replace("#","");
	ifr.contentDocument.location.replace(href);
}

Array.prototype.pushAll=function(list){
	if($.isArray(list)){
		for(var i = 0 ;i<list.length;i++){
			this.push(list[i]);
		}
	}
}


function htmlEncode(e){return e.replace(/&/g,"&amp;").replace(/ /g,"&nbsp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\n/g,"<br />").replace(/"/g,"&quot;")}function htmlDecode(e){return e.replace(/&#39;/g,"'").replace(/<br\s*(\/)?\s*>/g,"\n").replace(/&nbsp;/g," ").replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&amp;/g,"&")}function parseParams(e){e==undefined&&(e=window.location.search);var t=e.replace(/^\?/,"").split("&"),n=0,r,i={},s,o,u;while((r=t[n++])!==undefined)s=r.match(/^([^=&]*)=(.*)$/),s&&(o=decodeURIComponent(s[1]),u=decodeURIComponent(s[2]),i[o]=u);return i}function parseUrl(e){var t=new RegExp("(http[s]{0,1}|ftp)://([a-zA-Z0-9\\.\\-]+\\.[a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&amp;*+:_/<>]*)?([\\?a-zA-Z0-9\\.\\-~!@$%^&amp;*+?:_/<>=]*)?(#\\w+)?"),n=e.match(t);return n!=null?{protocol:n[1],domain:n[2],port:n[3],path:n[4],query_str:n[5],sharp:n[6]}:null}function replaceEmoji(e){var t={url:"http://res.mail.qq.com/zh_CN/images/mo/DEFAULT2/",data:{0:"微笑",1:"撇嘴",2:"色",3:"发呆",4:"得意",5:"流泪",6:"害羞",7:"闭嘴",8:"睡",9:"大哭",10:"尴尬",11:"发怒",12:"调皮",13:"呲牙",14:"惊讶",15:"难过",16:"酷",17:"冷汗",18:"抓狂",19:"吐",20:"偷笑",21:"可爱",22:"白眼",23:"傲慢",24:"饥饿",25:"困",26:"惊恐",27:"流汗",28:"憨笑",29:"大兵",30:"奋斗",31:"咒骂",32:"疑问",33:"嘘",34:"晕",35:"折磨",36:"衰",37:"骷髅",38:"敲打",39:"再见",40:"擦汗",41:"抠鼻",42:"鼓掌",43:"糗大了",44:"坏笑",45:"左哼哼",46:"右哼哼",47:"哈欠",48:"鄙视",49:"委屈",50:"快哭了",51:"阴险",52:"亲亲",53:"吓",54:"可怜",55:"菜刀",56:"西瓜",57:"啤酒",58:"篮球",59:"乒乓",60:"咖啡",61:"饭",62:"猪头",63:"玫瑰",64:"凋谢",65:"示爱",66:"爱心",67:"心碎",68:"蛋糕",69:"闪电",70:"炸弹",71:"刀",72:"足球",73:"瓢虫",74:"便便",75:"月亮",76:"太阳",77:"礼物",78:"拥抱",79:"强",80:"弱",81:"握手",82:"胜利",83:"抱拳",84:"勾引",85:"拳头",86:"差劲",87:"爱你",88:"NO",89:"OK",90:"爱情",91:"飞吻",92:"跳跳",93:"发抖",94:"怄火",95:"转圈",96:"磕头",97:"回头",98:"跳绳",99:"挥手",100:"激动",101:"街舞",102:"献吻",103:"左太极",104:"右太极"},ext:".gif"},n,r,i=t.url,s=t.ext,o=t.data;for(n in o)r=new RegExp("/"+o[n],"g"),e=e.replace(r,'<img src="'+i+n+s+'" alt="mo-'+o[n]+'"/>');return e};