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
  	.form-group {
	    margin-right: 5px;
	    margin-left: 5px;
	}
  	th{
  		text-align:center;
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
       	 设备管理
        <small>设备列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">设备关联</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          	<form class="form-inline" id="queryDeviceForm">
          		<div class="col-md-12">
	      			<div class="form-group">
					    <label for="deviceCode" class="control-label">设备标识：</label>
					    <input type="text" class="form-control" id="deviceCode" name="deviceCode" placeholder="请输入设备标识">
				  	</div>
					  <div class="form-group" >
					    <label for="partyPhoneNo" class="control-label">当事人手机号：</label>
					    <input type="text" class="form-control" id="partyPhoneNo" name="partyPhoneNo" placeholder="请输入当事人手机号">
					  </div>
					  <div class="form-group" >
					    <label for="licenseNo" class="control-label">绑定车牌：</label>
					    <input type="text" class="form-control" id="licenseNo" name="licenseNo" placeholder="请输入车牌号">
					  </div>
				  </div>
				  <div class="col-md-12" style="margin-top:10px;">
					  <div class="form-group" >
						    <label for="providerCode" class="control-label" style="padding-left: 13px;">供应商：</label>
						    <select class="form-control" id="providerCode" style=" width:196px;" >
							  <option value="4">全部</option>
							  <option value="0">鼎然</option>
							  <option value="1">天罡</option>
							</select>
						</div>
					  <div class="form-group">
					    <label for="bindBeginTime" class="control-label" style="margin-left: 30px;">绑定时间：</label>
					   	<div class="input-group" >
					      <input type="text" class="form-control" id="bindBeginTime" name="bindBeginTime" id="bindBeginTime" readonly placeholder="开始日期" aria-describedby="input-group-addon">
					      <div class="input-group-addon">至</div>
					      <input type="text" class="form-control" id="bindEndTime" name="bindEndTime" id="bindEndTime" readonly placeholder="结束日期" aria-describedby="input-group-addon">
					    </div>
					  </div>
			  		<button id="queryDeviceBtn" type="button" class="btn btn-default pull-right" >查询</button>
			  	</div>
			</form>
        </div>
        <div class="box-body table-responsive">
          	<table class="table table-bordered" id="dataTables">
            </table>
            <div id="pagenation"></div>
        </div>
        <div class="overlay">
		  <i class="fa fa-refresh fa-spin"></i>
		</div>
        <!-- /.box-body -->
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
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js?ver=${version}"></script>
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js?ver=${version}"></script>
<script type="text/javascript" src="${ctx }/js/deviceManage/deviceManage.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree();
  })
</script>
</body>
</html>
