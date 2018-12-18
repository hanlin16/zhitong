<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>我的设备</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
	</head>
	<body>
	<div class="page">
		<div class="content">
			<div class="form-content">
			<div class="form-group">
				<label class="form-label">车牌号</label>
				<input  type="text" class="form-input" readonly value="">
				<span class="equipmentState online" >设备在线</span>
			</div>
			<div class="form-group">
				<label class="form-label">设备ID</label>
				<input  type="text" class="form-input" readonly  value="">
				<span class="right-icon" onclick="changeEqm()" ></span>
			</div>
			</div>
			<div class="form-action">
				<button type="button" class="btn orange"  onclick="changeEqm()">
					更换设备
				</button>
			</div>
		</div>
	</div>

	</body>
	<script type="text/javascript">
	function changeEqm(){ 
		window.location.href="/views/change";
	}
	</script>
</html>
