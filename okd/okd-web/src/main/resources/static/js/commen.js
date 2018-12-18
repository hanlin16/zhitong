/***************基础js**************/
/*******屏幕适配*******/
 (function (doc, win) {
  var docEl = doc.documentElement,
    resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
    recalc = function () {
      var clientWidth = docEl.clientWidth;
      clientWidth=parseInt(clientWidth);
      if (!clientWidth) return;
      if(clientWidth<1024){
    	  window.fontScale=10 * (clientWidth / 320);
      	   docEl.style.fontSize = fontScale + 'px';
      	   

      }else{
    	  window.fontScale=20;
      		docEl.style.fontSize=window.fontScale+"px";
      }
    };

  if (!doc.addEventListener) return;
  win.addEventListener(resizeEvt, recalc, false);
  doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);
//公共
$(function(){
	$("[data-action=close]").click(function(){
		$(this).parents(".modal").hide();
	})

	/*****日期控件*******/
	;(function(){
		var currYear = (new Date()).getFullYear();	
			var opt={};
			opt.date = {preset : 'date'};
			opt.defaults = {
				theme: 'android-ics', //皮肤样式
		        display: 'modal', //显示方式 
		        mode: 'scroller', //日期选择模式
				dateFormat: 'yyyy-mm-dd',
				lang: 'zh',
				showNow: true,
				nowText: "今天",
		        startYear: 2016, //开始年份
		        endYear: currYear //结束年份
			};

		  	//$(".dataPicker").mobiscroll($.extend(opt['date'], opt['defaults']));
	})()

});
/**** 弹出框 ****/
var tipAlert=function(msg){
	$(".dialog-div .text").text(msg);
	$(".dialog-div:eq(0)").show();
	var _this=this;
	setTimeout(function(){
		_this.close();
	},3000)
	$(".dialog-div .close").click(function(){
		_this.close();
	})
	this.close=function(){
		$(".dialog-div:eq(0)").hide();
	}
};

