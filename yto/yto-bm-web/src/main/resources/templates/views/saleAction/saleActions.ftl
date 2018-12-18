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
  	.form-group {
	    margin-right: 5px;
	    margin-left: 5px;
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
       	 活动管理
        <small>活动列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">活动管理</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <form class="form-inline">
          	<div class="col-md-12">
			  <div class="form-group">
			    <label for="code" class="control-label" style="padding-left:15px;">活动码 :</label>
		    	<input type="text" class="form-control" style="width:240px;margin-left:5px;" name="code" id="code" />
			  </div>
			  <div class="form-group">
			    <label for="partnerCode" class="control-label">合作伙伴 :</label>
		    	<select class="form-control" id="partnerCode" name="partnerCode" style="width: 240px;margin-left:5px;">
					<option value="2">全部</option>
					<#list partnerList as companyPartner>
						<option value="${companyPartner.code}">${companyPartner.shortName}</option>
					</#list>
				</select>
			  </div>
			  <div class="form-group">
			    <label for="channelCode" class="control-label">渠道名称 : </label>
		    	<select class="form-control " id="channelCode" name="channelCode" style="width: 200px;">
				  	<option value="2">全部</option>
				  	<#list channelList as saleChannel>
						<option value="${saleChannel.code}">${saleChannel.name}</option>
					</#list>
				</select>
			  </div>
			   </div>
			   <div class="col-md-12" style="margin-top:10px;padding-right:0px;">
			  <div class="form-group " >
			    <label for="startDate" class="control-label" >生效时间：</label>
			   	<div class="input-group" >
			      <input type="text" class="form-control" id="startEffectTime" style="width: 100px;" name="startEffectTime" readonly placeholder="开始日期" aria-describedby="input-group-addon">
			      <div class="input-group-addon">至</div>
			      <input type="text" class="form-control" style="width: 100px;" name="endEffectTime" id="endEffectTime" readonly placeholder="结束日期" aria-describedby="input-group-addon">
			    </div>
			  </div>
			  <div class="form-group" >
			    <label for="startDate" class="control-label">失效时间：</label>
			   	<div class="input-group">
			      <input type="text" class="form-control" style="width: 100px;" id="startInvalidTime" name="startInvalidTime" readonly placeholder="开始日期" aria-describedby="input-group-addon">
			      <div class="input-group-addon">至</div>
			      <input type="text" class="form-control" style="width: 100px;" id="endInvalidTime" name="endInvalidTime" readonly placeholder="结束日期" aria-describedby="input-group-addon">
			    </div>
			  </div>
			  <div class="form-group" style="margin-left: 265px;margin-right: 0px;padding-left: 15px;">
			  	<button id="addSaleActionBtn" type="button" class="form-control btn btn-default pull-right">添加</button>
			  	<button id="querySaleActionBtn" type="button" class="form-control btn btn-default pull-right" style="margin-right: 10px;">查询</button>
			  </div>
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
<script type="text/javascript" src="${ctx }/plugins/clipboard/clipboard.min.js?ver=${version}"></script>
<script src="${ctx }/js/saleAction/saleActionManage.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
