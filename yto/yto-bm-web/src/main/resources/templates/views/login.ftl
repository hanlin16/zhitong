<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <title>易通运营管理系统</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<#include "../common/common-css.ftl" parse=true encoding="utf-8">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  
  <!-- /.login-logo -->
  <div class="login-box-body" style="background-color:#f3f3f3;">
  	<div class="login-logo">
	   <a href="javascript:void(0)"><b>易通</b>运营管理系统</a>
	</div>
	<p class="text-red" id="errorMsg" style="margin-left: 45px;">&nbsp;</p>
    <form action="" id="loginForm" method="post" class="form-horizontal">
      <div class="form-group" >
	    <div class="col-xs-8 col-sm-8 input-group">
	    	<div class="input-group-addon"><i class="fa fa-user"></i></div>
	      	<input type="text" name="loginName" class="form-control" id="inputUserName" placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group" >
	    <div class="col-xs-8 col-sm-8 input-group">
	    	<div class="input-group-addon"><i class="fa fa-lock"></i></div>
	      	<input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-xs-8 col-sm-8">
	      <input class="btn btn-primary btn-block" id="myButton" type="button" value="登录" />
	    </div>
	  </div>
    </form>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<#include "../common/common-js.ftl" parse=true encoding="utf-8">
<script>
$(function(){
	window.localStorage.setItem("baseUrl",'${ctx}');
	$('#myButton').on('click', function () {
		$("#errorMsg").html('&nbsp;');
		var userName = $("#inputUserName").val();
		var password = $("#inputPassword").val();
		if(userName==null || userName=='' || password==null || password==''){
			$("#errorMsg").text('用户名或者密码不能为空！');
			return;
		}
		$('#myButton').attr("disabled", "disabled");
		$('#myButton').val("正在登录...");
	    var loginData = $("#loginForm").serialize();
	    $.post("./login", loginData, function(data){
	        if(data.success){
	        	window.location.href="${ctx}/";
	        }else{
	            $("#errorMsg").text(data.errorMsg);
	           	$('#myButton').removeAttr("disabled");
	           	$('#myButton').val("登录");
	        }
	    });
	  })
	  
	  document.onkeyup = function (e) {//按键信息对象以函数参数的形式传递进来了，就是那个e  
		    var code = e.charCode || e.keyCode;  //取出按键信息中的按键代码(大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的却是charCode)  
		    if (code == 13) {
		    	//回车执行查询
		        $('#myButton').click();
		    }  
		}
});

</script>
</body>
</html>
