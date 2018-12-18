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
  	p > span{
  		margin-right: 20px;
  	}
  	p > span > span{
  		cursor:pointer;
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
       	 设备申领
        <small>申领列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">设备申领</li>
      </ol>
    </section>
    <section class="content">
      <div class="box">
        <div class="box-header with-border">
          	<form class="form-horizontal" id="queryDeviceForm">
      		  <div class="form-group col-md-4">
				    <label for="applicantName" class="control-label col-sm-4">收件人：</label>
				    <div class="col-md-8">
				    	<input type="text" class="form-control" id="receiver" name="receiver" placeholder="请输入收件人">
				  	</div>
			  </div>
			  <div class="form-group col-md-4" >
			    <label for="licenseNo" class="control-label col-sm-4">申领类型：</label>
			    <div class="col-md-8">
			    	<select class="form-control" id="applyType">
						  <option value="">全部</option>
						  <option value="A">先出单后申领</option>
						  <option value="B">先申领后出单</option>
					</select>
			  	</div>
			  </div>
			  <div class="form-group col-md-4">
				    <label for="applicantName" class="control-label col-sm-4">渠道：</label>
				    <div class="col-md-8">
				    	<input type="text" class="form-control" id="channelCode" name="channelCode" placeholder="请输入渠道">
				  	</div>
			  </div>
			  <div class="form-group col-md-4">
				    <label for="applicantName" class="control-label col-sm-4">业务号：</label>
				    <div class="col-md-8">
				    	<input type="text" class="form-control" id="bizNo" name="bizNo" placeholder="请输入业务号">
				  	</div>
			  </div>
			  <div class="form-group col-md-4" >
				    <label for="relationStatus" class="control-label col-sm-4">关联状态：</label>
				     <div class="col-md-8">
					    <select class="form-control" id="linkStatus">
						  <option value="">全部</option>
						  <option value="1">待关联</option>
						  <option value="2">关联中</option>
						  <option value="3">已关联</option>
						  <option value="4">拒关联</option>
						</select>
					</div>
		      </div>
			  <div class="form-group col-md-4">
				    <label for="applicantName" class="control-label col-sm-4">活动码：</label>
				    <div class="col-md-8">
				    	<input type="text" class="form-control" id="actionCode" name="actionCode" placeholder="请输入活动码">
				  	</div>
			  </div>
				
				  <div class="form-group col-md-8" >
				    <label for="startDate" class="control-label col-sm-2" style="padding-right: 20px;">申领时间：</label>
				   	<div class="input-group col-md-6" style="padding-left: 10px;">
				      <input type="text" class="form-control" id="startDate" name="startDate" id="startDate" readonly placeholder="开始日期" aria-describedby="input-group-addon">
				      <div class="input-group-addon">至</div>
				      <input type="text" class="form-control" id="endDate" name="endDate" id="endDate" readonly placeholder="结束日期" aria-describedby="input-group-addon">
				    </div>
				  </div>
			  	<button id="queryDeviceBtn" type="button" class="btn btn-default pull-right" >查询</button>
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
        
      </div>
    
    </section>

  </div>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<#include "../../common/common-js.ftl" parse=true encoding="utf-8">
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js?ver=${version}"></script>
<script type="text/javascript" src="${ctx }/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js?ver=${version}"></script>
<script type="text/javascript" src="${ctx }/js/deviceConect/deviceConect.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree();
  })
</script>
</body>
</html>
