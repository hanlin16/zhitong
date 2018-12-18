<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit"> 
  <title>易通运营管理系统</title>
   <#include "../common/common-css.ftl" parse=true encoding="utf-8">
   <style type="text/css">
   		/* 500 page option #1 */
	.page-404 {
	  text-align: center;
	}
	
	.page-404 .number {
	  display: inline-block;
	  letter-spacing: -10px;
	  line-height: 128px;
	  font-size: 128px;
	  font-weight: 300;
	  color: #7bbbd6;
	  text-align: right;
	}
	
	.page-404 .details {
	  margin-left: 40px;
	  display: inline-block;
	  text-align: left;
	  }
	 @media (max-width: 480px) {
	  .page-404 .number,
	  .page-404 .details {
	    text-align: center;
	    margin-left: 0px;
	  }
   </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

 <#include "../common/common-header.ftl" parse=true encoding="utf-8">

  <!-- =============================================== -->
	<#include "../common/common-menu.ftl" parse=true encoding="utf-8">

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       	系统出错
        <small>错误信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="active">错误提示</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
			<div class="col-md-12 page-404">
				<div class=" number">
					 404
				</div>
				<div class=" details">
					<h3><i class="fa fa-warning text-yellow"></i> 
						抱歉! 没有找到页面.</h3>
					<p>
						 请核对确认网络地址的正确<br>
						<a href="${request.contextPath }/">或者回到首页</a>.<br><br>
					</p>
				</div>
			</div>
		</div>    

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<#include "../common/common-js.ftl" parse=true encoding="utf-8">
<!-- AdminLTE for demo purposes -->
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
