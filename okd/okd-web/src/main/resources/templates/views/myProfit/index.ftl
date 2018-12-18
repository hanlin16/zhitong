<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>我的收益</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
	</head>
	<body>
	<div class="page">
		<div class="content integral">
			<div class="big-header">
				<p class="money">328.65</p>
				<p class="text">余额（元）</p>
				<p><a href="javascript:void(0)" class="btn" onclick="wdeposit()">提现</a></p>
			</div>
			<ul class="nav-menu"> 
				<li><a href="javascript:void(0)" class="active">收益明细</a></li>
				<li><a href="javascript:void(0)">支出明细</a></li>
			</ul>
			<div class="tab-content">
				<dl class="dataList">
					<dt class="title">
						<p>5月</p>
						<p>该月累计收益 ￥162.00</p>
					</dt>
					<dd class="lists">
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
					</dd>
				</dl>
				<dl  class="dataList">
					<dt class="title">
						<p>4月</p>
						<p>该月累计收益 ￥162.00</p>
					</dt>
					<dd class="lists">
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
						<div class="item">
							<h5>绿色驾驶奖励</h5>
							<p>2018-06-09 28:99:00</p>
						</div>
					</dd>
				</dl>
			</div>
		</div>
		<div class="modal" id="reminder">
			<div class="modal-dialog">
				<div class="modal-header">提现规则<a class="close" data-action="close"><span>&times;</span></a></div>
				<div class="modal-body">
					<div class="modal-content">
						<p>1.收益满50元，可申请提现。</p>
						<p>2.提交提现后，提现金额将在3个工作日内发放，如遇到法定节假日顺延一日</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
	<script type="text/javascript"> 
		$("#reminder").show();
		function wdeposit(){ 
			window.location.href="/views/Wdeposit";
		}
	</script>
</html>
