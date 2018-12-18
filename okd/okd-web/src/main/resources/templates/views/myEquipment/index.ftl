<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>我的设备</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleDevice.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>

	</head>
	<body>
	<div class="page">
		<div class="content">
			<div class="form-content">
			<div class="form-group">
				<label class="form-label"><font color="orange">* </font>车牌号</label>
				<input  type="text" id="licenseNo" class="form-input" placeholder="请输入车牌号">
			</div>
			<div class="form-group">
				<label class="form-label"><font color="orange">* </font>设备ID</label>
				<input  type="text" id="deviceCode" class="form-input" maxlength="12" placeholder="请输入12位设备号">
			</div>
			<div class="form-group">
				<label class="form-label"><font color="orange">* </font>姓名</label>
				<input  type="text" id="receiver" class="form-input" placeholder="请输入姓名">
			</div>
			<div class="form-group">
				<label class="form-label">邮箱</label>
				<input  type="text" id="email" class="form-input" placeholder="请输入邮箱">
			</div>
			<div class="form-group">
				<label class="form-label"><font color="orange">* </font>手机号</label>
				<input  type="text" id="phoneNo" class="form-input" maxlength="11" placeholder="请输入手机号">
				<input  type="text" id="phoneNoOrgin" hidden="hidden" value="">
			</div>
			<div class="form-group" id="sendCodeDiv">
				<label class="form-label"><font color="orange">* </font>验证码</label>
				<input  type="text" class="form-input" id="identifyCode" placeholder="请输入验证码" >
				<button type="button" id="sendCode" class="btn active" onclick="sendCode(this)">发送验证码</button>
			</div>
			</div>
			<div class="tip-content">
					<h5>说明：</h5>

					<p>1.星号信息项为必填项；</p>

					<p>2.手机号将作为用户的唯一标识，一旦绑定将无法修改，默认显示申领设备时提供的手机号，如果当时提供的手机号不是本人的，请修改成本人的；</p>
				</div>	
			<div class="form-action">
				<button type="button" class="btn orange" onclick="bindEqm()">
					绑定
				</button>
			</div>
		</div>
	</div>
	<div class="dialog-div">
		<span class="text"></span>
	    <span class="close">×</span>
	</div>
	</body>
	<script type="text/javascript"> 
		function sendCode(obj){
			var phoneNo = $("#phoneNo").val()+"";
			if(phoneNo=="" || phoneNo.length!=11){
    			tipAlert("手机号长度为11位！");
    			return;
    		}
    		var re=/^1[3|4|5|6|7|8|9]\d{9}$/;
			if(!re.test(phoneNo)){
				tipAlert("手机号格式不正确");
    			return;
			}
			var times="60";
			$(obj).text(times+"s后重新发送").prop("disabled",true).removeClass("active");
			var timer=setInterval(function(){ 
				if(times>0){
					times--;
					$(obj).text(times+"s后重新发送");
				}else{
					clearInterval(timer);
					$(obj).text("发送验证码").prop("disabled",false).addClass("active");
				}
			},1000);
			var phoneNo = $("#phoneNo").val();
			var param = "smsReceiver="+phoneNo;
			$.ajax({
				type: "POST",
				url:'/sendSms',
				data:param
			});
		} 
		function bindEqm () {
			var licenseNo = $("#licenseNo").val();
			var deviceCode = $("#deviceCode").val();
			var receiver = $("#receiver").val();
			var email = $("#email").val();
			var phoneNo = $("#phoneNo").val()+"";
			var identifyCode = $("#identifyCode").val()+"";
			var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; 
    		if(email!="" && email!=null){
    			if (!re.test(email)) {
	    			tipAlert("邮箱不正确！");
	    			return;
	    		}
    		}
    		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
    		if(!express.test(licenseNo)){
    			tipAlert("车牌号不正确！");
    			return;
    		}
    		if(deviceCode=="" || deviceCode.length!=12){
    			tipAlert("设备Id长度为12位！");
    			return;
    		}
    		if(phoneNo=="" || phoneNo.length!=11){
    			tipAlert("手机号长度为11位！");
    			return;
    		}  
    		var re=/^1[3|4|5|6|7|8|9]\d{9}$/;
			if(!re.test(phoneNo)){
				tipAlert("手机号格式不正确");
    			return;
			}  		
			var param = {};
			param.licenseNo = licenseNo;
			param.deviceCode = deviceCode;
			param.receiver = receiver;
			param.email = email;
			param.phoneNo = phoneNo;
			param.identifyCode = identifyCode;
			
			$.ajax({
				type: "POST",
				url:'/myEquipment/bindDeviceUser',
				data:param,
				success:function(xhr){
					if(xhr.success){
						tipAlert(xhr.errorMsg);
					}else{
					tipAlert(xhr.errorMsg);
					}
				}
			});
		}
		$(function(){
			$("#phoneNo").on("change", function(){
				var phoneNo = $("#phoneNo").val();
				var phoneNoOrgin = $("#phoneNoOrgin").val();
				var phoneNo = $("#phoneNo").val();
				if(phoneNoOrgin!=phoneNo && phoneNo.length==11){
					$("#sendCodeDiv").show();
				}else{
					$("#sendCodeDiv").hide();
				}
			});
			$("#deviceCode").on("blur", function(){
				var deviceCode = $("#deviceCode").val();
				if(deviceCode!=null && deviceCode!="" && deviceCode.length==12){
					var param = "deviceCode="+deviceCode;
					$.ajax({
						type: "POST",
						url:'/myEquipment/getUserInfoByDeviceCode',
						data:param,
						success:function(xhr){
							if(xhr.success){
								var data = xhr.data;
								$("#receiver").val(data.receiver);
								$("#phoneNo").val(data.receiverPhoneNo);
								$("#phoneNoOrgin").val(data.receiverPhoneNo);
								$("#sendCodeDiv").hide();
							}else{
								tipAlert("设备Id无法识别！");
							}
						}					
					});
				}
			});
		});
	</script>
</html>
