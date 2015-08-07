<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				分站管理
	</h3>
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="subject">分站管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);"><#if id == 0 >新增<#else>修改</#if>分站</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	
	<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>><#if id == 0 >新增<#else>修改</#if>分站
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="subsites/save" method="post" id="subjectForm">
						<input type="hidden" value="${tbSubSites.id!}" name="tbSubSites.id" id="id">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">分站名称：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="name" name="tbSubSites.name" value="${tbSubSites.name!}">
								</div>
							</div> 
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="javascript:checkForm();">提交</button>
									<button type="button" class="btn default" onclick="javascript:window.location.href='subsites/list'">返回</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
</@c.html_body>
<@c.html_js></@c.html_js>
	<script>
		var errorMsg = "${errorMsg}";
		if(errorMsg != ""){
			alert(errorMsg);
		}
	
		//表单提交验证
		function checkForm(){
			var name = $.trim($("#name").val());
		 

			if(name==""){
				alert("分站名称还未录入...");
				return;
			} 
			if(name.length>50) {
				alert("分站名称不能超过50字符");
				return;
			} 
			$("#subjectForm").submit();
		} 
	</script> 
</body>
</html>