<#include "./common-conf.ftl" parse=true encoding="utf-8">
<!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar" >
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">功 能 菜 单</li>
        	<#if showMenu??&&showMenu=='deviceConect'>
        		<li class="active">
		        	<a href="javascript:void(0)">
		            	<i class="fa fa-pie-chart"></i> <span>设备申领</span>
		          	</a>
		        </li>
        	<#else>
        		<li>
        			<a href="${ctx}/deviceConect/deviceConectPage">
		            	<i class="fa fa-pie-chart"></i> <span>设备申领</span>
		          	</a>
		        </li>
        	</#if>
        	<#if showMenu??&&showMenu=='deviceManage'>
        		<li class="active">
		        	<a href="javascript:void(0)">
		            	<i class="fa fa-sellsy"></i> <span>设备管理</span>
		          	</a>
		        </li>
        	<#else>
        		<li>
        			<a href="${ctx}/deviceManage/deviceManagePage">
		            	<i class="fa fa-sellsy"></i> <span>设备管理</span>
		          	</a>
		        </li>
        	</#if>
        	
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='companyPartner'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-users"></i> <span>合作伙伴</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/companyPartner/companyPartnerPage">
			            	<i class="fa fa-users"></i> <span>合作伙伴</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='saleChannel'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-exchange"></i> <span>渠道管理</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/saleChannel/saleChannelPage">
			            	<i class="fa fa-exchange"></i> <span>渠道管理</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='saleAction'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-gift"></i> <span>活动管理</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/saleAction/saleActionPage">
			            	<i class="fa fa-gift"></i> <span>活动管理</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='userManage'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-th"></i> <span>用户管理</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/user/userPage">
			            	<i class="fa fa-th"></i> <span>用户管理</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='integral'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-calculator"></i> <span>积分规则</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/integral/integralPage">
			            	<i class="fa fa-calculator"></i> <span>积分规则</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='integralQuery'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-database"></i> <span>积分查询</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/integral/integralQueryPage">
			            	<i class="fa fa-database"></i> <span>积分查询</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='scoreQuery'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-star"></i> <span>评分查询</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/score/scorePage">
			            	<i class="fa fa-star"></i> <span>评分查询</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
        	<#if currentUser.manager==1>
        		<#if showMenu??&&showMenu=='proposalQuery'>
	        		<li class="active">
			        	<a href="javascript:void(0)">
			            	<i class="fa fa-book"></i> <span>保单查询</span>
			          	</a>
			        </li>
	        	<#else>
	        		<li>
			        	<a href="${ctx}/proposal/proposalQueryPage">
			            	<i class="fa fa-book"></i> <span>保单查询</span>
			          	</a>
			        </li>
	        	</#if>
        	</#if>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>