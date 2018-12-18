<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>活动码</title>
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
				<label class="form-label">活动码</label>
				<input  type="text" class="form-input" placeholder="请输入四位活动码" id="actionCode" oninput='this.value=this.value.replace(/\D/gi,"")' maxlength="4">
			</div>
			<div class="form-group">
				<label class="form-label">车牌号</label>
				<input  type="text" class="form-input" placeholder="请输入车牌号" id="licenceNo" oninput='this.value=this.value.toUpperCase()' maxlength="8">
			</div>
			
			</div>
			<p class="error-ele"></p>

		
			<div class="form-action">
				<button type="button" class="btn orange" onclick="bindEqm()">
					提交
				</button>
			</div>
		</div>
	</div>
	</body>
	<script type="text/javascript"> 
		function sendCode(obj){ 
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

			},1000)
		}
		
		function check_licensePlate(licenceNo) {
				console.info("进入到车牌校验");
				var re = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
				if(licenceNo.search(re) == -1) {
					return false;
				} else {
					return true;
				}
		}
		
		function bindEqm () {
			var actionCode = $("#actionCode").val().trim();
			var licenceNo = $("#licenceNo").val().trim();
			var input  = /^[\s]*$/;
 			if (input.test(actionCode)){
			  alert("活动码不能为空");
			  return;
			}
 			if (input.test(licenceNo)){
			  alert("车牌号不能为空");
			  return;
			}
 			if (!check_licensePlate(licenceNo)){
			  alert("车牌号录入不正确!");
			  return;
			}
			
			$.ajax({
				type:"get",
				url:"../preInfo/queryActionCode?actionCode="+actionCode+"&licenceNo="+licenceNo,
//				dataType: "html",
				success : function (data) {
				if(data=="error"){
				alert("活动码不存在!");
				} else
				if(data=="expired"){
				alert("活动码已过期!");
				} else
				{
				window.location.href=data;
				}
        	},
        		error : function (data){
            	alert("系统异常");
        	}
			})
			
		}
	</script>
</html>
