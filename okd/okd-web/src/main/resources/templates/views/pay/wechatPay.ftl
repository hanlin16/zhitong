<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		<meta name="apple-mobile-web-app-status-bar-style" content="white" />
		<meta  http-equiv="X-UA-Compatible"  content="IE=edge,chrome=1" />
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/stylePay.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
		<title>在线支付</title>
	</head>
	<body>
		<div class="page">
			
			<div class="content">
				<div class="payInfo">
				<p>订单编号 ： ${orderNo}</p>
				<p>商品名称 ： 驾驶行为信息采集设备</p>
				<p>商品数量 ： 1</p>
				<p>支付金额 ： ￥200.00</p>
				<p>支付方式 ： </p>
				<ul class="payLists">
					<li>
						<input type="radio" value="weixin" class="radio" name="payType" checked="checked">
						<span  class="imgWrp"><img src="../../images/weixin.png" /></span>
						<h4>微信支付</h4>
					</li>
				</div>
				<div class="form-action">
					<button type="button" class="btn orange" onclick="goPay()">
						支付
					</button>
				</div>
			</div>
		</div>
		
	</body>
</html>
	<script type="text/javascript">
	
function goPay() {
			window.location.href="${url}";
		}
	
	</script>