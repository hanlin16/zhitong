<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		<meta name="apple-mobile-web-app-status-bar-style" content="white" />
		<meta  http-equiv="X-UA-Compatible"  content="IE=edge,chrome=1" />
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
		<title>提现银行</title>
	</head>
	<body class="greyBg">
		<div class="page">
			<div class="content">
				<div class="form-content">
					<p class="topTitle">提现金额</p>
					<div class="form-group wDeposit">
						<label class="form-label">￥</label>
						<input type="text" class="form-input" >
					</div>
					<p class="tip">
						注：单次提现接不低于50元
					</p>
				</div>
				<ul class="bankList">
						<li class="bankCard">
							<h5><img src="../../images/bankLogo/GSYH.png"></h5>
							<p>储蓄卡</p>
							<p class="cardID"><span class="encrypt">**** **** **** ****</span> <span class="arrears">5433</span></p>
						</li>
					</ul>
				<div class="form-action">
					<button type="button" class="btn orange" onclick="addBank()">
						提交
					</button>
				</div>
			</div>
		</div>
		
	</body>
</html>
<script>
	$("#signOut").click(function(){
		$(".modal").show();
	})

</script>