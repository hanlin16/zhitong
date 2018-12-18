<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
		<title>驾驶记录详情</title>
		<link rel="stylesheet" href="../../css/bace.css" />
		<link rel="stylesheet" href="../../css/styleNew.css" />
		<script src="../../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../../js/commen.js"></script>
	</head>
	<body>
	<div class="page">
		<div class="content dravingRecord">
			<div class="big-header">
				<p class="clearfix tip"><span class="pull-left">评分更新时间：2018-07-03</span><span class="pull-right">评分规则</span></p>
				<div class="pie" id="pie">
					<p class="num">84</p>
					<p class="text">安全得分</p>
				</div>
			</div>
			<div class="panel">
				<h5 class="header">本周驾驶详情 <a href="/views/recordList">行车记录 <span class="right-icon small"></span></a></h5>
				<div class="content">
					<ul class="driving-counts clearfix" >
						<li>
							<p class="times">1</p>
							<p>急加速/次</p>
						</li>
						<li>
							<p class="times">2</p>
							<p>急减速/次</p>
						</li>
						<li>
							<p class="times">3</p>
							<p>急转弯/次</p>
						</li>
						<li>
							<p class="times">3</p>
							<p>行驶时长/h</p>
						</li>
						<li>
							<p class="times">433</p>
							<p>最高时速km/h</p>
						</li>
						<li>
							<p class="times">433</p>
							<p>行驶里程/km</p>
						</li>
					</ul>
				</div>
			</div>
			<div class="panel">
				<h5 class="header">评分趋势图</h5>
				<div class="content">
					<div id="lineChart"></div>
				</div>
			</div>
		</div>
		
	</div>
	</body>
	<script type="text/javascript" src="../../js/echarts.min.js"></script>
	<script type="text/javascript"> 
	$(function() {
		// body...
		 var pieOption = {
	            tooltip: {
	            	show:true
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'left',
			        data:['直接访问'],
			        show:false
			    },
			    series: [
			        {
			            name:'安全得分',
			            type:'pie',
			            radius: ['85%', '100%'],
			            avoidLabelOverlap: false,
			            center: ['50%', '50%'],
			            hoverAnimation:false,
			            
			            labelLine: {
			                normal: {
			                    show: false
			                }
			            },
			            data:[
			            	{name:"得分",value:84,
				            	itemStyle:{ 
						            	color:["#ff9d00"]
						        },
						        label:{ 
							    	position: "center",
							    	color:"#333",
						    		 formatter: [
									        '{a|84}',
									        '{b|本周安全得分}'
									 ].join('\n'),
								 	rich: {
								        a: {
								            fontSize: 40,
								            lineHeight:50,
								            color:"#333"
								        },
								        b: {
								            fontSize: 18,
								            color:"#999"

								        }
								    },
						    		show:true,
						    		color:"#333",

							    },
			            	},
			            	{name:"剩余",value:16,
			            		itemStyle:{ 
						            color:["#ffce77"]
						        },
						         label:{  
						         	show:false
						         }
			            	}
			           
						]
					}
				]
       		};

        // 使用刚指定的配置项和数据显示图表。
       
        
        var lineOpt={ 
    	  tooltip: {
            	show:true,
            	 formatter:'{c}'
		    },
        	xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['18/7', '19/7', '20/7', '21/7', '22/7', '23/7', '24/7']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    label:{ 
		    	position: [10, 10],
	    		formatter:'{c}',
	    		show:true,
	    		color:"#333"

		    },
		    symbol:"circle",
		    series: [{
		        data: [35, 45, 55, 87, 80, 40, 30],
		        type: 'line',
		        areaStyle: {},
		        itemStyle:{ 
			       color:["#ff9d00"]
			   	}
		    }]
        }
        setTimeout(function(){ 
        	var pieChart = echarts.init(document.getElementById('pie'));
        	var lineChart = echarts.init(document.getElementById('lineChart'));
        	pieChart.setOption(pieOption);
	        lineChart.setOption(lineOpt);
	    }) 
        
		$("#reminder").show();
	})
	</script>
</html>
