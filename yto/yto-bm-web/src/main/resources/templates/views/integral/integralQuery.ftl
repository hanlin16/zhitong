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
        <small>积分列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">积分查询</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <form class="form-horizontal">
			  <div class="form-group col-md-5">
			    <label for="applicantName" class="control-label col-sm-4">当事人编码：</label>
			    <div class="col-md-8">
			    	<input type="text" class="form-control" id="partyCode" placeholder="请输入当事人编码">
			  	</div>
			  </div>
			  <div class="form-group col-md-5">
			    <label for="applicantName" class="control-label col-sm-4">当事人手机号:</label>
			    <div class="col-md-8">
			    	<input type="text" class="form-control" id="partyPhoneNo" placeholder="请输入当事人手机号">
			  	</div>
			  </div>
			  <button id="queryIntegralBtn" type="button" class="btn btn-default pull-right" style="margin-right: 10px;">查询</button>
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
<script src="${ctx }/js/integral/integralQuery.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
