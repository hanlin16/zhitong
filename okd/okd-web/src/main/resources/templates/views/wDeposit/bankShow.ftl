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
		<title>添加银行卡</title>
	</head>
	<body class="greyBg">
		<div class="page">
			
			<div class="content">
				<ul class="bankList">
						<li class="bankCard">
							<h5><img src="../../images/bankLogo/GSYH.png"></h5>
							<p>储蓄卡</p>
							<p class="cardID"><span class="encrypt">**** **** **** ****</span> <span class="arrears">5433</span></p>
						</li>
					</ul>
				<div class="form-action">

					<button type="button" class="btn orange" onclick="addBank()">
						替换银行卡
					</button>
				</div>
			</div>
		</div>
		
	</body>
</html>
	<script type="text/javascript">
		function selectBank(){ 
			$("#bankList").show();
		}
		function addBank(){ 
			var  cardOwner=$("#cardOwner").val();
			var  bank=$("#bank").data("val");//银行编码  $("#bank").val()//获取银行名称
			var cardID=$("#cardID").val();
		}
		$("#bankList").on("click","a",function(){ 
			var val=$(this).data("val");
			var text=$(this).text();
			$("#bank").val(text).data("val",val);
		});

	</script>