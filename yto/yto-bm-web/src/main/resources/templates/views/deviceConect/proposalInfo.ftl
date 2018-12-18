<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit"> 
  <title>保单详情</title>
  <#include "../../common/common-css.ftl" parse=true encoding="utf-8">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper" >
	<section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header" style="text-align: center">
            	 易通出单详情
            <small class="pull-right">出单日期: 
            <#assign flag=proposalDetail.payTime??>
		       		<#if (flag)>${proposalDetail.payTime?string('yyyy-MM-dd') !}
		       		<#else>${proposalDetail.payTime! }
		       		</#if>
            </small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <!-- /.row -->
      <div class="row" >
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-user"></i> 人员信息</h4>
      		</div>
       </div>
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table" >
		       	<tr>
		       		<td style="border: none;"><strong>投保人：${proposalDetail.personInfo.applicantName !}</strong></td>
		       		<td style="border: none; border-right-style: solid">手机号码:${proposalDetail.personInfo.applicantMobile}</td>
		       		<td style="border: none;">被保人：${proposalDetail.personInfo.insuredName !}</td>
				    <td style="border: none;">手机号码:${proposalDetail.personInfo.insuredMobile !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">身份证号: ${proposalDetail.personInfo.applicantIdNo !}</td>
		       		<td style="border: none; border-right-style: solid">邮箱: ${proposalDetail.personInfo.policyEmail !}</td>
		       		<td style="border: none;">身份证号: ${proposalDetail.personInfo.insuredIdNo !}</td>
		       	</tr>
		       </table>
		      </div>
		</div>
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-truck"></i> 物流信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table">
				<tr>
					<td style="border: none;">物流公司：</td>
					<td style="border: none;">快递单号:</td>
					<td style="border: none;">收件人：${proposalDetail.personInfo.addresseeName !}</td>
				</tr>
				<tr>
					<td style="border: none;">收件人手机号：${proposalDetail.personInfo.addresseeMobile !}</td>
					<td style="border: none;">收件人地址：${proposalDetail.personInfo.addresseeDetails !}</td>
				</tr>
		       </table>
		   </div>
		      <!-- /.col -->
		</div>
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-credit-card-alt"></i> 投保信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table" style="margin-bottom: 0px;">
		       	<tr>
		       		<td style="border: none;">保险公司：${proposalDetail.insurerName !}</td>
		       		<td style="border: none;">智通业务号 : ${proposalDetail.bizId !}</td>
		       		<td style="border: none;">支付金额: ${proposalDetail.payMoney !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">投保城市 : ${proposalDetail.provinceName !}-${proposalDetail.cityName !}</td>
		       		<td style="border: none;">总保费 : ${proposalDetail.sumPremium !}</td>
		       		<td style="border: none;">交强保费：${proposalDetail.ciPremium !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">商业保费：${proposalDetail.biPremium !}</td>
		       		<td style="border: none;">车船税: ${proposalDetail.vehicleTaxPremium !}</td>
		       		<td style="border: none;">积分合计 : ${proposalDetail.totalCredits !}</td>
		       	</tr>
		       	<tr>
		       		<td colspan="2" style="font-size: 15px; font-weight: bold">交强险:</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">交强投保单:${proposalDetail.ciProposalNo !}</td>
		       		<td style="border: none;">交强保单号 : ${proposalDetail.ciPolicyNo !}</td>
		       		<td style="border: none;">交强费率(%) : ${proposalDetail.balanceCiCost !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">交强险积分: ${proposalDetail.balanceCiIntegral !}</td>
		       		<#assign ciFlag=proposalDetail.ciStartDate??> 
		       		<#if (ciFlag)><td style="border: none;">交强险起保日期：${proposalDetail.ciStartDate?string('yyyy-MM-dd') }</td>
		       		<#else><td style="border: none;">交强险起保日期：${proposalDetail.ciStartDate! }</td>
					</#if>
		       		
		       		<td style="border: none;">交强险终保日期：
		       		<#assign endFlag=proposalDetail.ciEndDate??>
		       		<#if (endFlag)>${proposalDetail.ciEndDate?string('yyyy-MM-dd') }
		       		<#else>${proposalDetail.ciEndDate! }
		       		</#if>
		       		</td>
		       	</tr>
		       	<tr>
		       		<td colspan="2" style="font-size: 15px; font-weight: bold">商业险:</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">商业投保单 : ${proposalDetail.biProposalNo !}</td>
		       		<td style="border: none;">商业保单号 : ${proposalDetail.biProposalNo !}</td>
		       		<td style="border: none;">商业险费率(%) : ${proposalDetail.balanceBiCost !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">商业险积分: ${proposalDetail.balanceBiIntegral !}</td>
		       		<td style="border: none;">商业险起保日期：
		       		<#assign startFlag=proposalDetail.biStartDate??>
		       		<#if (startFlag)>${proposalDetail.biStartDate?string('yyyy-MM-dd') !}
		       		<#else>${proposalDetail.biStartDate! }
		       		</#if>
		       		</td>
		       		<td style="border: none;">商业险终保日期：
		       		<#assign endFlag=proposalDetail.biEndDate??>
		       		<#if (endFlag)>${proposalDetail.biEndDate?string('yyyy-MM-dd') !}
		       		<#else>${proposalDetail.biEndDate! }
		       		</#if>
		       		</td>
		       	</tr>
		       </table>
		   </div>
	        <div class="col-xs-12 table-responsive">
	          	<table class="table table-bordered">
	            <thead>
		            <tr>
		              <th style=" font-weight:normal;" class="text-center">商业险别</th>
		              <th style=" font-weight:normal;" class="text-center">保险金额</th>
		              <th style=" font-weight:normal;" class="text-center">实收保费</th>
		              <th style=" font-weight:normal;" class="text-center">备注</th>
		            </tr>
	            </thead>
	            <tbody>
		            <#list proposalDetail.kinds as kind>
		            	<tr >
			              	<td  style="border: none;">${kind.kindName !}</td>
			            	<td class="text-right" style="border: none;">
				            	<#if kind.amount=='1'>
				            			投保
				            	<#else>
				            			${kind.amount !}
				            	</#if>
			            	</td>
			              	<td class="text-right" style="border: none;">${kind.premium  !}</td>
			              	<td class="text-center" style="border: none;">--</td>
		            	</tr>
		            </#list>
	            </tbody>
	          </table>
	        </div>
        	<!-- /.col -->
		</div>
     
		<div class="row">
      		<div class="col-sm-12">
       			<h4 class="box-title"><i class="fa fa-car"></i> 车辆信息</h4>
      		</div>
       </div>  
       <div class="row" style="border-bottom: 1px solid #f4f4f4;">
          	<div class="col-sm-12 table-responsive" >
		       <table class="table">
		       	<tr>
		       		<td style="border: none;">车牌号:${proposalDetail.vehicleInfo.licenseNo !}</td>
		       		<td style="border: none;">车架号: ${proposalDetail.vehicleInfo.frameNo !}</td>
		       		<td style="border: none;">品牌型号：${proposalDetail.vehicleInfo.vehicleModelName !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">注册日期：${proposalDetail.vehicleInfo.registerDate?date('yyyy-MM-dd') !}</td>
		       		<td style="border: none;">发动机号: ${proposalDetail.vehicleInfo.engineNo !}</td>
		       		<td style="border: none;">座位数:${proposalDetail.vehicleInfo.seatCount !}</td>
		       	</tr>
		       	<tr>
		       		<td style="border: none;">新车购置价:${proposalDetail.vehicleInfo.newCarPrice !}</td>
		       	</tr>
		       	
		       </table>
		   </div>
		      <!-- /.col -->
		</div>
      <!-- this row will not appear when printing -->
      <div class="row no-print">
        <div class="col-xs-12">
         <!--  <a href="invoice-print.html" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> </a> -->
          <!-- <button type="button" class="btn btn-success pull-right" onclick="printPage()"><i class="fa fa-print"></i>打印
          </button> -->
          <button type="button" class="btn btn-primary pull-right" onclick="closeWindow()" style="margin-right: 5px;">
            <i class="fa fa-close"></i> 关闭
          </button>
        </div>
      </div>
    </section>
    <div class="scroll-to-top" >
      <i class="fa  fa-arrow-circle-o-up fa-3x"></i>
    </div>
</div>
<!-- ./wrapper -->
<#include "../../common/common-js.ftl" parse=true encoding="utf-8">
</body>
<script type="text/javascript" src="${ctx }/plugins/printThis/printThis.js"></script>
<script type="text/javascript">
	function printPage(){
		$(".invoice").printThis({
			base: "${ctx}/deviceConect/proposalInfo"
		});
	}
	function closeWindow(){
		var sUserAgent = navigator.userAgent.toLowerCase();
	    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
	    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
	    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
	    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
	    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
	    var bIsAndroid = sUserAgent.match(/android/i) == "android";
	    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
	    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
	    if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) ){
	    	window.opener=null;
			window.open('','_self');
			window.close();
	    } else {
	    	window.history.back();
	    }
	}
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
