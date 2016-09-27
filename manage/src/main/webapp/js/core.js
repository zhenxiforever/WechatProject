var app = {};
app.cfg = {};
app.cfg.base = "/wxqy_manage";

app.fillTemplate = function(tmpl,obj){
	var html = tmpl;
	for(var key in obj){
		var regexp = eval("/\{" + key + "\}/ig");			
		html = html.replace(regexp,obj[key]);
	}
	return html;
};

app.showMsgPnl = function(tmpl,msgObj,containerAppendTo){
	var html = app.fillTemplate(tmpl,msgObj);
	var $h = $(html);
	$h.appendTo(containerAppendTo);
 
	//window.scrollTo(0,$h.offset().top-50);
	//$(containerAppendTo).height($h.height()+40);
	var outer = $(containerAppendTo).parent();
	$(containerAppendTo).animate({"scrollTop":$(containerAppendTo).get(0).scrollHeight},600 ,function(e){
		//window.scrollTo(0,$h.offset().top-50);
//		$h.animate({backgroundColor:"rgb(255,255,255)"},1);
//		/*$h.animate({backgroundColor:"rgb(180,180,180)"},500);*/
//		$h.animate({backgroundColor:"rgb(207,45,31)"},500);
//		$h.animate({backgroundColor:"rgba(255,255,255,0)"},400);
//		$h.animate({backgroundColor:"rgb(207,45,31)"},500);
//		$h.animate({backgroundColor:"rgba(255,255,255,0)"},800);
	});
	
//	$("body").animate({"scrollTop":$h.offset().top-50},400,function(){
//		$h.animate({backgroundColor:"rgb(207,45,31)"},500);
//		$h.animate({backgroundColor:"rgba(255,255,255,0)"},400);
//		$h.animate({backgroundColor:"rgb(207,45,31)"},500);
//		$h.animate({backgroundColor:"rgba(255,255,255,0)"},800);
//	})
};

var currName = {
		"CNY":"人民币"
		};


app.commaFormatted = function(amount) {
    var delimiter = ","; // replace comma if desired
    amount = new String(amount);
    if(amount.indexOf(".")<0){
    	amount += ".";
    }
    var a = amount.split('.',2);
    var d = a[1];
    var i = parseInt(a[0]);
    if(isNaN(i)) { return ''; }
    var minus = '';
    if(i < 0) { minus = '-'; }
    i = Math.abs(i);
    var n = new String(i);
    var a = [];
    while(n.length > 3)
    {
        var nn = n.substr(n.length-3);
        a.unshift(nn);
        n = n.substr(0,n.length-3);
    }
    if(n.length > 0) { a.unshift(n); }
    n = a.join(delimiter);
    if(d.length < 1) { amount = n; }
    else { amount = n + '.' + d; }
    amount = minus + amount;
    return amount;
};