<#import "./common.ftl" as cc />
<@cc.html_head></@cc.html_head>


<body class="page-header-fixed page-quick-sidebar-over-content">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html">
			<img src="${admin_che_url}assets/admin/layout/img/logo.png" alt="logo" class="logo-default" />
			</a>
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown dropdown-user">
					<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img alt="" class="img-circle hide1" src="${admin_che_url}assets/admin/layout/img/avatar3_small.jpg"/>
					<span class="username username-hide-on-mobile">
					${userInfo.username!}&nbsp;&nbsp;</span>
					</a>
					
				</li>
				<!-- END USER LOGIN DROPDOWN -->
				<!-- BEGIN QUICK SIDEBAR TOGGLER -->
				<li class="dropdown dropdown-quick-sidebar-toggler">
					<a href="javascript:;" class="dropdown-toggle">
					<i class="icon-logout"></i>
					</a>
				</li>
				<!-- END QUICK SIDEBAR TOGGLER -->
			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">

	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
	    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
	    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	    <div class="page-sidebar navbar-collapse collapse">
	        <!-- BEGIN SIDEBAR MENU -->
	        <ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
	            <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
	            <li class="sidebar-toggler-wrapper">
	                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	                <div class="sidebar-toggler">
	                </div>
	                <!-- END SIDEBAR TOGGLER BUTTON -->
	            </li>
	            <!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
	            <#list keyNames as key>
	            <#if type=="dms">
	            <li class="active open">
	                <a href="javascript:;">
		                <i class="icon-settings"></i> 
		                <span class="title">${key!}</span>
		                <span class="selected"></span>
		                <span class="arrow open"></span>
	                </a>
	                <ul class="sub-menu">
	                	<#list map.get(key) as data>
	                	<#if data.flag == "1">
	                	<li>
	                		<a href="javascript:;"><i class="icon-home"></i>${data.name!}<span class="arrow"></span></a>
	                		<ul class="sub-menu">
	                		<#list data.get("data") as data2>
	                			 <li>
			                        <a href="javascript:void(0);" value="${data2.action!}"><i class="icon-settings"></i>${data2.name!}</a>
			                     </li>
	                		</#list>
	                		</ul>
	                	<li>
	                	<#else>
	                    <li>
	                        <a href="javascript:void(0);" value="${data.action!}"><i class="icon-settings"></i>${data.name!}</a>
	                    </li>
	                    </#if>
	                     </#list>
	                </ul>
	            </li>
	            <#else>
	            <li>
	                <a href="javascript:;">
		                <i class="icon-settings"></i> 
		                <span class="title">${key!}</span>
		                <span class="selected"></span>
		                <span class="arrow"></span>
	                </a>
	                <ul class="sub-menu">
	                	<#list map.get(key) as data>
	                	<#if data.flag == "1">
	                	<li>
	                		<a href="javascript:;"><i class="icon-home"></i>${data.name!}<span class="arrow"></span></a>
	                		<ul class="sub-menu">
	                		<#list data.get("data") as data2>
	                			 <li>
			                        <a href="javascript:void(0);" value="${data2.action!}"><i class="icon-settings"></i>${data2.name!}</a>
			                     </li>
	                		</#list>
	                		</ul>
	                	<li>
	                	<#else>
	                    <li>
	                        <a href="javascript:void(0);" value="${data.action!}"><i class="icon-settings"></i>${data.name!}</a>
	                    </li>
	                    </#if>
	                     </#list>
	                </ul>
	            </li>
	            </#if>
	            </#list>
	        </ul>
	        <!-- END SIDEBAR MENU -->
	    </div>
	</div>
	<!-- END SIDEBAR -->

	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
	
		<div class="page-content">
		

						<div class="portlet-body">
							<div class="tabbable-custom " id="myTableNav">
								<ul class="nav nav-tabs ">
								</ul>
								<div class="tab-content">
								
									<h3 class="page-title" id="title315">欢迎使用中国汽车消费网-后台系统</h3>
									
								</div>
							</div>
						</div>
		
		</div>
	</div>
	<!-- END CONTENT -->
	<div class="page-footer">
		<div class="page-footer-inner">
			 Copyright © 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号
		</div>
	</div>

</div>


<!-- END CONTAINER -->

<@cc.html_js></@cc.html_js>
<!-- END JAVASCRIPTS -->
<script>
var num = 1;
//window.onresize = resize;

//function resize(){  
 //   document.getElementById('frm'+"").style.height = document.body.clientHeight - 84+"px";  
//}
$(function(){
	$(".sub-menu li a").click(function(event){
		$("#title315").hide();
		if($(this).next().length == 0){
			//$("#myTableNav li").removeClass("active");
			var html1 = '<li><a data-toggle="tab" href="#tab_5_'+num+'">'+$(this).html()+'</a></li>';
			var html2 = '<div id="tab_5_'+num+'" class="tab-pane"><iframe id="frm'+num+'" width="100%" border="0" height="800px" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe></div>';
			$("#myTableNav ul").append(html1);
			$("#myTableNav .tab-content").append(html2);
			$("#myTableNav li a").dblclick(function(){
				$(this).parent().remove();
				var did = $(this)[0].hash;
				$(did).remove();
				$('#myTableNav a:last').tab('show');
			});
			$('#myTableNav a:last').tab('show');
			$("#frm"+num)[0].src = $(this).attr("value");
			num++;
		}
	});
});

function openNew(title,url){
	var html1 = '<li><a data-toggle="tab" href="#tab_5_'+num+'"><i class="icon-settings"></i>'+title+'</a></li>';
	var html2 = '<div id="tab_5_'+num+'" class="tab-pane"><iframe id="frm'+num+'" width="100%" border="0" height="800px" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe></div>';
	$("#myTableNav ul").append(html1);
	$("#myTableNav .tab-content").append(html2);
	$("#myTableNav li a").dblclick(function(){
		$(this).parent().remove();
		var did = $(this)[0].hash;
		$(did).remove();
		$('#myTableNav a:last').tab('show');
	});
	$('#myTableNav a:last').tab('show');
	$("#frm"+num)[0].src = url;
	num++;
}
function removeActiveAndOpenNew(title,url){
	var did = $("#myTableNav li.active a")[0].hash;
	$("#myTableNav li.active").remove();
	$(did).remove();
	openNew(title,url);
}
</script>
</body>
</html>