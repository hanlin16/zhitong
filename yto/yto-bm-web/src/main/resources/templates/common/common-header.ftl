<#include "./common-conf.ftl" parse=true encoding="utf-8">
<header class="main-header">
    <!-- Logo -->
    <a href="javascript:void(0)" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>易通</b>运营</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>易通</b>运营管理系统</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <div style="float:left;color:#fff;padding:15px 10px;">欢迎 ${currentUser.userName !}</div>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav ">
        	<li><a href="javascript:void(0);" onclick="updatePassword('${ctx}')"><i class="fa fa-lock"></i> &nbsp;修改密码</a></li>
          	<li>
            	<a href="javascript:void(0);" onclick="logout('${ctx}')"><i class="fa fa-sign-out"></i>退出</a>
          	</li>
        </ul>
      </div>
    </nav>
  </header>