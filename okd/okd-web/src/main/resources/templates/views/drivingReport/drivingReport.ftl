<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>我的驾驶报告</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
	</head>
	<body>
	<div class="page">
		<div class="content">
			<ul class="driveReportList"> 
				<li class="item week">
					<a href="javascript:void(0)" onclick="showWeek()">
					<p class="timeSection">07-01 19:45:22 &nbsp;&nbsp; - &nbsp;&nbsp; 06-19 19:48:22</p>
					<p class="title">|&nbsp;&nbsp;7月周报&nbsp;&nbsp;|</p>
					<p><span class="year">2018</span></p>
					<p class="week">1<sup>st</sup> week of JULY</p>
					</a>
				</li>
				<li class="item week">
					<a href="javascript:void(0)" onclick="showWeek()">
					<p class="timeSection">07-01 19:45:22 &nbsp;&nbsp; - &nbsp;&nbsp; 06-19 19:48:22</p>
					<p class="title">|&nbsp;&nbsp;7月周报&nbsp;&nbsp;|</p>
					<p><span class="year">2018</span></p>
					<p class="week">2<sup>nd</sup> week of JULY</p>
				</a>
				</li>
				<li class="item week">
					<a href="javascript:void(0)" onclick="showWeek()">
					<p class="timeSection">07-01 19:45:22 &nbsp;&nbsp; - &nbsp;&nbsp; 06-19 19:48:22</p>
					<p class="title">|&nbsp;&nbsp;7月周报&nbsp;&nbsp;|</p>
					<p><span class="year">2018</span></p>
					<p class="week">3<sup>th</sup> week of JULY</p>
					</a>
				</li>
				<li class="item moonth">
					<a href="javascript:void(0)" onclick="showMonth()">
					<p class="timeSection">07-01 19:45:22 &nbsp;&nbsp; - &nbsp;&nbsp; 06-19 19:48:22</p>
					<p class="title">|&nbsp;&nbsp;6月月报&nbsp;&nbsp;|</p>
					<p><span class="year">2018</span></p>
					</a>
				</li>
			</ul>
		</div>
		
	</div>
	</body>
	<script type="text/javascript"> 
		function showMonth(){
			window.location.href="/views/moonthReport";
		}
		function showWeek(){
			window.location.href="/views/weekReport";
		}
	</script>
</html>
