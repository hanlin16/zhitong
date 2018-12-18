<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>易通运营管理系统</title>
 <#include "../../common/common-css.ftl" parse=true encoding="utf-8">
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
       	 评分查询
        <small>评分列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">评分查询</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          	<h3> 建设中.. </h3>
        </div>
        
        <div class="box-body ">
          
        </div>
        <!-- /.box-body -->
        <div class="box-footer clearfix">
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> ${version}
    </div>
    <strong>Copyright &copy; 2018 易通.</strong> 版权所有
  </footer> -->
  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<#include "../../common/common-js.ftl" parse=true encoding="utf-8">
<!-- AdminLTE for demo purposes -->
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
