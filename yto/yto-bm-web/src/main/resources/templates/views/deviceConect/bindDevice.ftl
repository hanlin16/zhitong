<style>
em{
	margin-left:70px;
}
</style>
<div class="row">
	<div class="col-md-12">
		<div id="applyId" style="display:none;"> ${bindDetail.applyId}</div>
		<div class="col-md-4">收件人：${bindDetail.receiver}</div>
		<div class="col-md-4">手机号码:${bindDetail.receiverPhoneNo}</div>
		<div class="col-md-12">配送地址：${bindDetail.address}</div>
	</div>
	<div class="col-md-12">
		<form class="form-inline" id="bindDataForm" style="margin-left: 15px;margin-top: 20px;">
		 	<input type="hidden" class="form-control"  id="bizId" name="bizId" value="${bindDetail.bizId! }"/>
		 	<input type="hidden" class="form-control"  id="deviceId" name="deviceId" value="${bindDetail.deviceId! }"/>
		 	<input type="hidden" class="form-control"  id="licenseNo" name="licenseNo" value="${bindDetail.licenseNo! }"/>
		  <#if bindDetail.linkStatus==2 >
		  	<div class="form-group">
			    <label for="deviceNo" >设备号：</label>
			    <input type="text" class="form-control" maxlength="12" id="deviceCode" name="deviceCode" >
			    <em id="deviceCodeErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
			  <div class="form-group" style="margin:0 20px 0 20px;">
			    <label for="logisticsCompany">物流公司：</label>
			    <input type="text" class="form-control" id="logisticsCompany" name="logisticsCompany" >
			    <em id="logisticsCompanyErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
			  <div class="form-group ">
			    <label for="logisticsNo">物流单号：</label>
			    <input type="text" class="form-control" id="logisticsNo" name="logisticsNo" >
			    <em id="logisticsNoErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
		  </#if>
		  <#if bindDetail.linkStatus==3 >
		  	<div class="form-group">
			    <label for="deviceNo" >设备号：</label>
			    <input type="text" class="form-control" maxlength="12" disabled="disabled" id="deviceCode" name="deviceCode" value="${bindDetail.deviceCode! }">
			    <em id="deviceCodeErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
			  <div class="form-group" style="margin:0 20px 0 20px;">
			    <label for="logisticsCompany">物流公司：</label>
			    <input type="text" class="form-control" id="logisticsCompany" disabled="disabled" name="logisticsCompany" value="${bindDetail.companyName! }">
			    <em id="logisticsCompanyErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
			  <div class="form-group ">
			    <label for="logisticsNo">物流单号：</label>
			    <input type="text" class="form-control" id="logisticsNo" disabled="disabled" name="logisticsNo" value="${bindDetail.orderNo! }">
			    <em id="logisticsNoErrorMsg" class="error help-block" style="color:#a94442;">&nbsp;</em>
			  </div>
		  </#if>
		</form>
	</div>
	<div class="col-md-6 col-md-offset-4">
		  <div class="col-md-6 col-xs-4 ">
		 	<#if bindDetail.linkStatus==1>
		 		<button type="button" class="btn btn-primary" id="relationingBtn">关联中</button>
		 	<#elseif bindDetail.linkStatus==2>
		 	<button type="button" class="btn btn-primary" id="relationBtn">关联</button>
		 		<button type="button" class="btn btn-primary" id="unrelationBtn">拒关联</button>
		 	<#elseif bindDetail.linkStatus==3>
		 		<button type="button" class="btn btn-default disabled">已关联</button>
		 	<#else>
		 		<button type="button" class="btn btn-default disabled">拒关联</button>
		 	</#if>
		 	<button type="button" class="btn btn-default" id="closeDialogBtn" style="margin-left:20px;">返回</button>
		 </div>
		 
	</div>
</div>