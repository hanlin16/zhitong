<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <title>易通运营管理系统</title>
 <link href="${request.contextPath }/plugins/select2/css/select2.min.css" rel="stylesheet" />
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
       	合作伙伴
        <small>合作伙伴列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">合作伙伴</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <form class="form-inline">
			  <div class="form-group">
			    <label for="fullName">全称：</label>
			    <input type="text" class="form-control" id="fullName" placeholder="全称">
			  </div>
			  <div class="form-group">
			    <label for="shortName">简称:</label>
			    	<input type="text" class="form-control" id="shortName" placeholder="简称">
			  </div>
			  <div class="form-group">
			    <label for="code">编码:</label>
			    <input type="text" class="form-control" id="code" placeholder="">
			  </div>
			  	<button id="addPartnerBtn" type="button" class="btn btn-default pull-right">添加</button>
			  	<button id="queryPartnerBtn" type="button" class="btn btn-default pull-right" style="margin-right: 10px;">查询</button>
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

<script src="${ctx }/plugins/select2/js/select2.full.min.js"></script>
<script src="${ctx }/plugins/select2/js/i18n/zh-CN.js"></script>
<script src="${ctx }/js/companyPartner/companyPartnerManage.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree();
  });
</script>
</body>
</html>
