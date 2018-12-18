<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <title>易通运营管理系统</title>
 <#include "../../common/common-css.ftl" parse=true encoding="utf-8">
 <link rel="stylesheet" href="${ctx }/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css?ver=${version}">
   <style type="text/css">
   	th{
  		text-align:center;
  	}
  	td{
  		border-top-width: 0px !important;
  	}
   </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

 	<#include "../../common/common-header.ftl" parse=true encoding="utf-8">

  <!-- =============================================== -->
	<#include "../../common/common-menu.ftl" parse=true encoding="utf-8">

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       	积分查询
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">积分查询</li>
        <li class="active">积分汇总</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border" >
        <div class="row" >
        		<div class="text-center" ><h5><strong>积分汇总</strong></h5></div>
        		<hr style="margin-top: 0px;margin-bottom: 10px;"/>
        	</div>
        	<div class="row" style="margin-left: 10px; ">
	        	<table class="table " style="margin-bottom:0px;"> 
	        		
	        		<tbody>
	        			<tr>
	        				<td >
	        					<label style="width:120px;">当事人手机号：</label>
								<input type="text" name="partyPhoneNo" style="border:none;width:120px;"  readonly="readonly" class="input-xlarge uneditable-input" id="partyPhoneNo">
							</td>
	        				<td >
	        					<label style="width:120px;">当事人姓名：</label>
								<input type="text" class="input-xlarge uneditable-input" style="border:none;width:100px;" id="name"  readonly="readonly">
	        				</td>
	        				<td >
	        					<label style="width:120px;">当事人编码：</label>
								<input type="text" class="input-xlarge uneditable-input" style="border:none;width:120px;" id="partyCode"  readonly="readonly">
	        				</td>
	        			</tr>
	        			<tr>
	        				<td >
	        					<label  style="width:120px;">收入积分：</label>
				    			<input type="text" class="input-xlarge uneditable-input" style="border:none;width:100px;" id="integralIncome"  readonly="readonly">
	        				</td>
	        				<td >
	        					<label style="width:120px;">可用积分：</label>
				    			<input type="text" class="input-xlarge uneditable-input" style="border:none;width:120px;" id="integralUsable"  readonly="readonly">
				    		</td>
				    		<td >
				    			<label style="width:120px;">冻结积分：</label>
				    			<input type="text" class="input-xlarge uneditable-input" style="border:none;width:120px;" id="integralLock"  readonly="readonly">
				    		</td>
				    		<td >
				    			<label style="width:120px;">已提积分：</label>
				    			<input type="text" class="input-xlarge uneditable-input" style="border:none;width:120px;" id="integralPayout"  readonly="readonly">
				    		</td>
	        			</tr>
	        		</tbody>
	        	</table>
			</div>
			<div class="row">
        		<div class="text-center"><h5><strong>积分明细</strong></h5></div>
        		<hr style="margin-top: 0px;margin-bottom: 10px;"/>
        	</div>
			<div class="row" style="margin-right: 0px;">
				<form class="form-horizontal">
				  <div class="form-group col-md-4">
				    <label for="applicantName" class="control-label col-sm-4">交易科目：</label>
				    <div class="col-md-8">
				    	<select class="form-control" id="transactionItem">
						  	<option value="">选择...</option>
						  	<option value="1">按周奖励</option>
						  	<option value="2">按年奖励</option>
						  	<option value="3">提取冻结</option>
						  	<option value="4">支付执行</option>
						</select>
				  	</div>
				  </div>
				  <div class="form-group col-md-6" >
					    <label for="startDate" class="control-label col-sm-4" style="padding-right: 20px;">交易时间：</label>
					   	<div class="input-group col-md-6" style="padding-left: 10px;">
					      <input type="text" class="form-control" id="startDate" name="startDate" id="startDate" readonly placeholder="开始日期" aria-describedby="input-group-addon">
					      <div class="input-group-addon">TO</div>
					      <input type="text" class="form-control" id="endDate" name="endDate" id="endDate" readonly placeholder="结束日期" aria-describedby="input-group-addon">
					    </div>
				  </div>
				  <button onclick="javascript :history.back(-1)" type="button" class="btn btn-default pull-right" >返回</button>
				  <button id="queryIntegralDetailBtn" type="button" class="btn btn-primary pull-right" style="margin-right: 10px;">查询</button>
				</form>
			</div>
		</div>
        <div class="overlay">
		  <i class="fa fa-refresh fa-spin"></i>
		</div>
        <div class="box-body table-responsive">
          <table class="table table-bordered" id="dataTables-detail">
          </table>
          <div id="pagenation"></div>
        </div>
        
        <!-- /.box-body -->
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<#include "../../common/common-js.ftl" parse=true encoding="utf-8">
<!-- AdminLTE for demo purposes -->
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js?ver=${version}"></script>
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js?ver=${version}"></script>
<script src="${ctx }/js/integral/integralQueryDetail.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
