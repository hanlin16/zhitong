<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <title>易通运营管理系统</title>
 <#include "../../common/common-css.ftl" parse=true encoding="utf-8">
   <style type="text/css">
   	th{
  		text-align:center;
  	}
  	label{
  		margin-left:20px;
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
       	 渠道管理
        <small>渠道列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">渠道管理</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <form class="form-inline">
			  <div class="form-group">
			    <label for="partnerCode">合作伙伴:</label>
		    	<select class="form-control" id="partnerCode" style="width:150px;">
		    		<option selected="selected" value="0">请选择</option>
		    	</select>
			  </div>
			  <div class="form-group">
			    <label for="code">渠道编码：</label>
			    <input type="text" class="form-control" id="code" placeholder="请输入渠道编码">
			  </div>
			  <div class="form-group">
			    <label for="status">状态:</label>
		    	<select class="form-control" id="status" style="width:150px;">
				  	<option value="2">全部</option>
				  	<option value="1">有效</option>
				  	<option value="0">无效</option>
				</select>
			  </div>
			  <button id="addSaleChannelBtn" type="button" class="btn btn-default pull-right">添加</button>
			  <button id="querySaleChannelBtn" type="button" class="btn btn-default pull-right" style="margin-right: 10px;">查询</button>
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
<script src="${ctx }/js/saleChannel/saleChannelManage.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
