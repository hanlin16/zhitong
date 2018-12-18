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
	<body >
		<div class="page">
			<div class="topTip">请绑定持卡人本人的银行卡</div>
			
			<div class="content">
				<div class="form-content">
					<div class="form-group">
						<label class="form-label">持卡人</label>
						<input  type="text" class="form-input" id="cardOwner" placeholder="请输入持卡人姓名" >
					</div>
					<div class="form-group">
						<label class="form-label">银行</label>
						<input  type="text" class="form-input" id="bank" placeholder="请选择银行" readonly>
						<span class="right-icon" onclick="selectBank()"></span>
					</div>
					<div class="form-group">
						<label class="form-label">卡号</label>
						<input  type="text" class="form-input" id="cardID" placeholder="请输入银行卡号">
					</div>
				</div>
				<p class="error-ele"></p>
				<div class="form-action">
					<button type="button" class="btn orange" onclick="addBank()">
						确认添加
					</button>
				</div>
			</div>
		</div>
		<div class="modal" id="bankList">
			<div class="modal-dialog">
				<div class="modal-header">请选择银行<a class="close" data-action="close"><span>&times;</span></a></div>
				<div class="modal-body">
					<div class="modal-content">
						<div class="dropdown">
							<ul class="dropdown-menu">
								<li><a href="javascript:void(0)" data-val="">中国银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中国工商银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中国农业银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中国建设银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中国邮政银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">招商银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">光大银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">广发银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">浦发银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中信银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中信银行</a></li>
								<li><a href="javascript:void(0)"  data-val="">中信银行</a></li>
								<li><a href="javascript:void(0)" data-val="">中信银行</a></li>

							</ul>
						</div>
					</div>
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
			/**提交数据****
				.......
			***/
			window.location.href="/views/bankShow";
		}
		$("#bankList .dropdown-menu").on("click","a",function(){ 
			var val=$(this).data("val");
			var text=$(this).text();
			$("#bank").val(text).data("val",val);
			$("#bankList").hide();
		});

	</script>