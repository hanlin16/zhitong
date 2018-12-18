<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit"> 
  <title>设备详情</title>
  <#include "../../common/common-css.ftl" parse=true encoding="utf-8">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper" >
	
	<#include "../../common/common-header.ftl" parse=true encoding="utf-8">

  <!-- =============================================== -->
	<#include "../../common/common-menu.ftl" parse=true encoding="utf-8">
	<div class="content-wrapper">
	<section class="content-header">
      <h1>
        	设备详情
        <small>设备明细</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="${ctx }"><i class="fa fa-sellsy"></i> 设备管理</a></li>
        <li class="active">设备详情</li>
      </ol>
    </section>
	<section class="invoice">
   
      <div class="row" >
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-user"></i> 申领信息</h4>
      		</div>
       </div>
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table" >
		       	<tr>
		       		<td style="border: none;"><strong>收件人：${deviceDetail.deviceApply.receiver! }</strong></td>
		       		<td style="border: none;">收件人手机号: ${deviceDetail.deviceApply.receiverPhoneNo! }</td>
		       		<td style="border: none;">申领时间： ${deviceDetail.deviceApply.applyTime! }</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">申领类型: 
		       			<#if deviceDetail.deviceApply.applyType=='A'!>
		       				先出单后申领
		       			<#else>
		       				先申领后出单
		       			</#if>
		       		</td>
		       		<td style="border: none;" colspan="2">配送地址: ${deviceDetail.deviceApply.address! }</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">渠道名称: ${deviceDetail.deviceApply.channelName! }</td>
		       		<td style="border: none;">活动码: ${deviceDetail.deviceApply.actionCode! }</td>
		       	</tr>
		       </table>
		      </div>
		     </div>
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-mobile-phone fa-2x"></i> 设备信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table">
				<tr>
					<td style="border: none;">设备标识：${deviceDetail.deviceInfo.deviceCode! }</td>
					<td style="border: none;">设备名称:${deviceDetail.deviceInfo.name! }</td>
					<td style="border: none;">关联状态：
						<#if deviceDetail.deviceApply.linkStatus=='1'>
							待关联
						<#elseif deviceDetail.deviceApply.linkStatus=='2'>
							关联中
						<#elseif deviceDetail.deviceApply.linkStatus=='3'>
							已关联
						<#else>
							拒关联
						</#if>
					</td>
				</tr>
				<tr>
					<td style="border: none;">设备状态：
						<#if deviceDetail.deviceInfo.status=='1'>
							有效
						<#else>
							无效
						</#if>
						
					</td>
					<td style="border: none;">物流公司：${deviceDetail.deviceInfo.loCompany! }</td>
					<td style="border: none;">物流单号：${deviceDetail.deviceInfo.loOrderNo! }</td>
				</tr>
		       </table>
		   </div>
		      <!-- /.col -->
		</div>
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-credit-card-alt"></i> 绑定信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
	        <div class="col-xs-12 table-responsive">
	          	<table class="table table-bordered">
		            <thead>
			            <tr>
			              <th style=" font-weight:normal;" class="text-center">当事人编码</th>
			              <th style=" font-weight:normal;" class="text-center">当事人手机号</th>
			              <th style=" font-weight:normal;" class="text-center">车牌号</th>
			              <th style=" font-weight:normal;" class="text-center">绑定状态</th>
			              <th style=" font-weight:normal;" class="text-center">绑定时间</th>
			              <th style=" font-weight:normal;" class="text-center">解绑时间</th>
			            </tr>
		            </thead>
		            <tbody>
			            <#list deviceDetail.deviceBindList as deviceBind>
			            	<tr >
			            		<td style="border: none;" class="text-center">${deviceBind.partyCode! }</td>
				              	<td  style="border: none;" class="text-center">${deviceBind.partyPhoneNo! }</td>
				              	<td  style="border: none;" class="text-center">${deviceBind.licenseNo! }</td>
				            	<td class="text-center" style="border: none;">
					            	<#if deviceBind.bindStatus=='2'>
					            			已绑定
					            	<#elseif deviceBind.bindStatus=='3'>
					            			已解绑
					            	<#else>
					            			未绑定
					            	</#if>
				            	</td>
				              	<td class="text-center" style="border: none;">${deviceBind.bindTime?string('yyyy-MM-dd HH:mm:ss')! }</td>
				              	<td class="text-center" style="border: none;">${deviceBind.unbindTime! }</td>
			            	</tr>
		            	</#list>
		            </tbody>
	          	</table>
	        </div>
        	<!-- /.col -->
		</div>
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-car"></i> 保单信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
	        <div class="col-xs-12 table-responsive">
	          	<table class="table table-bordered">
		            <thead>
			            <tr>
			              <th style=" font-weight:normal;" class="text-center">商保单号</th>
			              <th style=" font-weight:normal;" class="text-center">车牌号</th>
			              <th style=" font-weight:normal;" class="text-center">保费</th>
			              <th style=" font-weight:normal;" class="text-center">保单起期</th>
			              <th style=" font-weight:normal;" class="text-center">保单止期</th>
			              <th style=" font-weight:normal;" class="text-center">投保人</th>
			              <th style=" font-weight:normal;" class="text-center">查看</th>
			            </tr>
		            </thead>
		            <tbody>
			            <#list deviceDetail.policyList as policyInfo>
			            	<tr >
			            		<td style="border: none;" class="text-center">${policyInfo.biPolicyNo! }</td>
				              	<td  style="border: none;" class="text-center">${policyInfo.licenseNo! }</td>
				              	<td  style="border: none;" class="text-right">${policyInfo.sumPremium! }</td>
				              	<td  style="border: none;" class="text-center">${policyInfo.biStartDate! }</td>
				              	<td  style="border: none;" class="text-center">${policyInfo.biEndDate ! }</td>
				              	<td  style="border: none;">${policyInfo.insuredName ! }</td>
				              	<td class="text-right" style="border: none;" class="text-center">
				              		<a href="/deviceConect/proposalInfo?bizId=${policyInfo.ztBizId }" target="_blank">查看</a>
				              	</td>
			            	</tr>
		            	</#list>
		            </tbody>
	          	</table>
	        </div>
        	<!-- /.col -->
		</div>
      <!-- this row will not appear when printing -->
      <div class="row no-print">
        <div class="col-xs-12">
          <button type="button" class="btn btn-primary pull-right" onclick="javascript :history.back(-1)" style="margin-right: 5px;">
            <i class="fa fa-arrow-circle-left"></i> 返回
          </button>
        </div>
      </div>
    </section>
    </div>
    <div class="scroll-to-top" >
      <i class="fa  fa-arrow-circle-o-up fa-3x"></i>
    </div>
</div>

<!-- ./wrapper -->
<#include "../../common/common-js.ftl" parse=true encoding="utf-8">
</body>
<script type="text/javascript">
	
	//scroll
	var offset = 300;
    var duration = 500;

    if (navigator.userAgent.match(/iPhone|iPad|iPod/i)) { // ios supported
        $(window).bind("touchend touchcancel touchleave", function(e) {
            if ($(this).scrollTop() > offset) {
                $('.scroll-to-top').fadeIn(duration);
            } else {
                $('.scroll-to-top').fadeOut(duration);
            }
        });
    } else { // general 
        $(window).scroll(function() {
            if ($(this).scrollTop() > offset) {
                $('.scroll-to-top').fadeIn(duration);
            } else {
                $('.scroll-to-top').fadeOut(duration);
            }
        });
    }

    $('.scroll-to-top').click(function(e) {
        e.preventDefault();
        $('html, body').animate({
            scrollTop: 0
        }, duration);
        return false;
    });
</script>
</html>
