<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>微信支付</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>

	</head>
	<body>
	<div class="form-action">
				</div>
	</body>
	<script type="text/javascript">
	 	
	function onBridgeReady(){
   		WeixinJSBridge.invoke(
      		'getBrandWCPayRequest', {
         	"appId":appid,     //公众号名称，由商户传入     
         	"timeStamp":timeStamp,         //时间戳，自1970年以来的秒数     
         	"nonceStr":nonceStr, //随机串     
        	"package":package,     
         	"signType":signType,         //微信签名方式：     
         	"paySign":paySign //微信签名 
      	},
      	function(res){
      	if(res.err_msg == "get_brand_wcpay_request:ok" ){
      	// 使用以上方式判断前端返回,微信团队郑重提示：
           window.location.href="${url!''}"; //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
      	} 
   	}); 
	}
	
		var appid = "${appId1!''}";
		var timeStamp = "${timeStamp!''}";
		var nonceStr = "${nonceStr!''}";
		var package = "${package!''}";
		var signType = "${signType!''}";
		var paySign = "${paySign!''}";
	
    	if (typeof WeixinJSBridge == "undefined"){
   			if( document.addEventListener ){
      			 document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
   			}else if (document.attachEvent){
       		document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
       		document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
   			}
		}else{
   			onBridgeReady();
		}

	</script>
</html>
