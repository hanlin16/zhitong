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
       	 规则内容
      </h1>
      <ol class="breadcrumb">
        <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">积分规则</li>
        <li class="active">规则内容</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
        	<div class="row">
        		<div class="text-center"><h5>积分汇总</h5></div>
        		<hr style="margin-top: 0px;"/>
        	</div>
        	<div class="row" style="margin-left: 0px; ">
	          	<label >规则编号：</label>
				<input type="text" name="code" style="border:none;"  readonly="readonly" class="input-xlarge uneditable-input" id="ruleCode">
	          	<label >规则起期：</label>
				<input type="text" style="border:none;"  readonly="readonly" class="input-xlarge uneditable-input" id="startDate">
	          	<label >规则止期：</label>
				<input type="text" style="border:none;"  readonly="readonly" class="input-xlarge uneditable-input" id="endDate">
	          	<label >版本号：</label>
				<input type="text" style="border:none;"  readonly="readonly" class="input-xlarge uneditable-input" id="versionNo">
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
        <div class="box-footer clearfix">
        	<button type="button" class="btn btn-primary pull-right" onclick="javascript :history.back(-1)" style="margin-right: 5px;">
            	<i class="fa fa-arrow-circle-left"></i> 返回
          </button>
        </div>
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
<script src="${ctx }/js/integral/integralDetail.js?ver=${version}"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
