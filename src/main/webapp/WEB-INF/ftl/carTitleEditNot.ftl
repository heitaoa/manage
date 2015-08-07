<#import "./common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<@cc.html_body>
<h3 class="page-title">
	非车型图库
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<span>新闻管理</span>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<span>图库管理</span>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<span>非车型图库</span>
		</li>
	</ul>
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>非车型图片主题添加
				</div>
			</div>
			<div class="portlet-body form">
				<form class="form-horizontal" role="form" method="post">
					<div class="form-body">
						<div class="form-group">
							<label class="col-md-3 control-label">图片目录：</label>
							<div class="col-md-9">
								<span class="form-control input-inline input-xlarge">${cartypeName}</span>
								<span class="help-inline">
								*当前目录</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">图片类别：</label>
							<div class="col-md-9">
								
								<span class="form-control input-inline input-xlarge">非车型图片</span>
                        		<input type="hidden" name="titleBean.type" value="0">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">图片主题：</label>
							<div class="col-md-9">
								<input type="text" class="form-control input-inline input-xlarge" name="titleBean.title" id="title" size="60" value="${titleBean.title!}">
								<span class="help-inline">
								*车型主题</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">关键词：</label>
							<div class="col-md-9">
								<input type="text" class="form-control input-inline input-xlarge" name="titleBean.keywords" id="keywords" size="60" value="${titleBean.keywords!}">
								<span class="help-inline">
								*车型关键词</span>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<a class="btn green" href="javascript:saveTitle()">保存</a>
								<a class="btn default" href="./carImageManageNot?carTypeArr=${cartype}&page=${page}">返回图片主题管理</a>
							</div>
						</div>
					</div>
				  <input type="hidden" name="titleBean.id" id = "tid" value="${titleBean.id!}">
			      <input type="hidden" name="titleBean.catalogid" value="${cartype}">
			      <input type="hidden" id="editOverType" value="${editOverType!}">
				</from>
			</div>
		</div>
		
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
<script type="text/javascript" >

function saveTitle(){
	if($("#tid").val()!= "0"){
		document.forms[0].action = "updateTitleNot";
	}else{
		document.forms[0].action = "saveTitleNot";
	}
	document.forms[0].submit();

}
$(document).ready(function(){
	var editOverType = $("#editOverType").val();
	if(editOverType == 1){
		alert("添加成功！");
	}
	
	if(editOverType == 2){
		alert("更新成功！");
	}
});

</script>
</body>
</html>