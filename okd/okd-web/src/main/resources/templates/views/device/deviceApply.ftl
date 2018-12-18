<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		<meta name="apple-mobile-web-app-status-bar-style" content="white" />
		<meta  http-equiv="X-UA-Compatible"  content="IE=edge,chrome=1" />
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleDevice.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
		<link rel="stylesheet" href="../../js/AreaSelect/css/lArea.css" />
		<title>设备申领</title>
	</head>
	<body>
		<div class="page">
			<img src="../../images/product.jpg"  class="img-responsive">
			<div class="explain"> 
				<ul> 
					<li class="clearfix">
						<div class="icon preferential">
							
						</div>
						<div  class="text">
							<h5>购保优惠</h5>
							<p>直接以折扣价格购买车险</p>
						</div>
					</li>
					<li class="clearfix">
						<div class="icon profit">
							
						</div>
						<div  class="text">
							<h5>驾驶收益</h5>
							<p>每周均可获得安全驾驶现金奖励</p>
						</div>
					</li>
					<li class="clearfix">
						<div class="icon driving">
							
						</div>
						<div  class="text">
							<h5>驾驶评分</h5>
							<p>改善驾驶习惯 让驾驶更安全</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="imgs-responsive img-wrpper">
				<img src="../../images/title1.png" >
				<img src="../../images/scan.jpg" >
				<img src="../../images/equipment.jpg" >
			</div>
			<div class="content">
				<div class="form-content">
					<div class="form-group">
						<label class="form-label">收件人</label>
						<input  type="text" class="form-input" placeholder="请输入收件人" id="person">
					</div>
					<div class="form-group">
						<label class="form-label">手机号码</label>
						<input  type="text" class="form-input" placeholder="请输入手机号码" id="phoneNo" oninput='this.value=this.value.replace(/\D/gi,"")' maxlength="11">
					</div>
					<div class="form-group">
					
						<label class="form-label">配送地址</label> 
						<input  type="text" class="form-input" placeholder="请输选择区域" id="areaInput" readonly>
						
						<input  type="text" class="form-input" placeholder="请输入街道地址" id="adressInput">
					</div>
				</div>
				<div class="tip-content">
					<h5>注意：</h5>

					<p>1.申领设备需要支付押金200元；</p>

					<p>2.支付成功后，3-5天即可收到设备，收到设备后请及时到好司机保微信公众号上进行设备绑定，未关联好司机保公众号的可通过本页面下方二维码进行关注；</p>

					<p>3.期间有任何疑问，请拨打电话010-99999999咨询；</p>
				</div>	
				<div class="form-action">
					<button type="button" class="btn orange" onclick="goPay()" >
						提交
					</button>
				</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript" src="../../js/AreaSelect/js/lArea.js"></script>
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.4.0.js"></script>

</html>
	<script type="text/javascript">
		
		function goPay(){
		 
		 	var msg = "${msg!''}";
		 	if(msg!="success"){
		 		alert(msg);
		 		return;
		 	}
		function isPoneAvailable(str) {
            var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if (!myreg.test(str)) {
                return false;
            } else {
                return true;
            }
        }
 
		 	var person = $("#person").val();
			var phoneNo = $("#phoneNo").val();
			var areaInput = $("#areaInput").val();
			var adressInput = $("#adressInput").val();
			var input  = /^[\s]*$/;
 			if (input.test(person)){
			  alert("接收人不能为空");
			  return;
			}
 			if (input.test(phoneNo)){
			  alert("接收人不能为空");
			  return;
			}
			if(!isPoneAvailable(phoneNo)){
			alert("手机号码不对");
			  return;
			}
 			if (input.test(areaInput)){
			  alert("地址不能为空");
			  return;
			}
 			if (input.test(adressInput)){
			  alert("地址不能为空");
			  return;
			}
			var params ={ 
  			 bizNo : "${bizNo!''}",
  			 actionCode : "${actionCode!''}",
  			 channelCode : "${channelCode!''}",
  			 applyType : "${applyType!''}",
			 receiver : $("#person").val(),
			 receiverPhoneNo : $("#phoneNo").val(),
			 address : $("#areaInput").val()+$("#adressInput").val()
			};
			$.ajax({
				type:"post",
				data:params,
				url:"../device/deviceApplyUpdate",
				 success : function (data) {
//            alert("成功！");
				window.document.write(data);
        	},
        	error : function (data){
            	alert(data.responseText);
        	}
				
			});
			
		}
		
		function get_province() {
		
			$.ajax({
				type: "post",
				url: "../device/queryCityMapping", //获取json数据
				dataType: "json",
				success: function(data) {
				 var area = new lArea();
		    	 area.init({
		    	'trigger': '#areaInput',
		    	'data':data
		    	
		    })
				},
				error: function() {
					alert("系统异常，请稍后再试！")
				}
			});
			
		}
	

	    var address=window.location.href;
        thisDLoc   =   document.location;  
        var hostport=window.location.host;
		var imgUrl = "http://"+hostport+"/img/wechatshare.png";
		var lineLink = window.location.href;
		console.log(imgUrl);
		 var appId='' ;
	     var timestamp='' ;
    	 var nonceStr='' ;
         var signature='' ;
         
		$(document).ready(function() {
		
			get_province();
			
			$.ajax({
		  		type: 'post',
		  		url: "../pay/signature",
//		  		url: "../pay/signature?address="+address,
		  		async : false, 
		  		data : {url : address},
		  		dataType: "json",
		  		success: function(response) {
		  		console.log(address);
		  		appId = response.appid;
	      		timestamp = response.timestamp;
    	  		nonceStr = response.nonceStr;
          		signature = response.signature;
	 		  wx.config({
	      		debug: false,
	      		appId: appId,
	      		timestamp: timestamp,
	     	    nonceStr: nonceStr,
	      		signature: signature,
	      		jsApiList: ['checkJsApi', 'onMenuShareTimeline', 'onMenuShareAppMessage']
	    	  });
    	  		}
    		});
	    });	
	    
    
    	  wx.ready(function() {
                  
            wx.onMenuShareAppMessage({  
                title: '好司机保',  
                desc: '最高可享50%的车险优惠，每周领取现金驾驶奖励，马上点击申请。',  
                link: lineLink,  
                imgUrl: imgUrl,  
                success: function (res) {  
                }
            });  
                  
            wx.onMenuShareTimeline({  
                title: '好司机保，最高可享50%的车险优惠，每周领取现金驾驶奖励，马上点击申请。',  
                link: lineLink,  
                imgUrl: imgUrl,  
                success: function (res) {  
                }
            });
            wx.error(function (res) {  
            alert("error: " + res.errMsg);  
            });
	});
			
	</script>
    