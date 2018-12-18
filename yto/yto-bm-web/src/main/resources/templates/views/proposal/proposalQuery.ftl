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
       	 保单查询
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">保单查询</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <form class="form-inline">
          	<div class="col-md-12">
			  <div class="form-group" style="width:33%;">
			    <label for="code" class="control-label">商保单号:</label>
		    	<input type="text" class="form-control" name="code" id="biPolicyNo" style="width:70%;margin-left:10px;"/>
			  </div>
			  <div class="form-group" style="width:33%;">
			    <label for="partnerCode" class="control-label">车牌号:</label>
		    	<input type="text" class="form-control" name="code" id="licenseNo" style="width:70%;"/>
			  </div>
			  <div class="form-group" style="width:33%;">
			    <label for="channelCode" class="control-label">投保人姓名:</label>
		    	<input type="text" class="form-control" name="code" id="applicantName" style="width:70%;"/>
			  </div>
			   </div>
			   <div class="col-md-12" style="margin-top:10px;">
			  <div class="form-group " >
			    <label for="startDate" class="control-label" >保险起期：</label>
			   	<div class="input-group" >
			      <input type="text" class="form-control" id="startTime" style="width: 100%;" name="startTime" readonly placeholder="开始日期" aria-describedby="input-group-addon">
			      <div class="input-group-addon">至</div>
			      <input type="text" class="form-control" style="width: 100%;" name="endTime" id="endTime" readonly placeholder="结束日期" aria-describedby="input-group-addon">
			    </div>
			  </div>
			  	<button id="queryProposalBtn" type="button" class="btn btn-default pull-right" >查询</button>
			  </div>
			</form>
        </div>
        <div class="overlay">
		  <i class="fa fa-refresh fa-spin"></i>
		</div>
        <div class="box-body table-responsive">
          <table class="table table-bordered" id="dataTables">
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
<script src="${ctx }/js/proposal/proposal.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
