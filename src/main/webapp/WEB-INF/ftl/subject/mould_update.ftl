<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				专题管理<small></small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index">首页</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="toMould">专题模板</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">模板修改</a>
					</li>
				</ul>
			</div>
			<!-- EDN PAGE HEADER-->

		<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>模板修改
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="updateMould" method="post" id="mouldForm">
						<input type="hidden" name="mould.mouldid" value="${mould.mouldid}">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">模板名称：</label>
								<div class="col-md-3">
									<input type="text" name="mould.mouldname" id="mouldname" value="${mould.mouldname!}" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">模板ftl：</label>
								<div class="col-md-3">
									<input type="text" name="mould.mouldftl" id="mouldftl" value="${mould.mouldftl!}" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">模板html：</label>
								<div class="col-md-3">
									<textarea class="form-control" name="mould.mouldhtml" id="mouldhtml">${mould.mouldhtml!}</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 control-label">上传广告图片：</label>
								<div class="col-md-9">
									<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
									<input type="hidden" name="mould.mouldphoto" id="mouldphoto" value="${mould.mouldphoto!}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">图片显示：</label>
								<div class="col-md-9" id="showPhoto">
								<img style="height:100px;width="500"" src="${mould.mouldphoto!}"></img>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="checkForm();">提交</button>
									<button type="button" class="btn default" onclick="javascript:history.go(-1);">返回</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
			<!-- END MAIN CONTENTS -->
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
	//表单提交验证
	function checkForm(){
		var mouldphoto = $.trim($("#mouldphoto").val());
		var mouldname = $.trim($("#mouldname").val());
		var mouldhtml = $.trim($("#mouldhtml").val());
		var mouldftl = $.trim($("#mouldftl").val());
		
		if(mouldname==""){
			alert("模板名称还未输入...");
			return;
		}
		if(mouldhtml==""){
			alert("模板HTML还未上传...");
			return;
		}
		if(mouldftl==""){
			alert("模板FTL还未输入...");
			return;
		}
		if(mouldphoto==""){
			alert("模版图片还未输入...");
			return;
		}
		alert("修改成功");
		$("#mouldForm").submit();
	}
	
	function callbackSucc(data)
	{	
		var adimg= data[0];
		var uploadPath = adimg.uploadPath;
		html='';
		if(uploadPath.substring(uploadPath.length-3)=="swf"){
			html+='<a href="www.chetuan.com"><embed src="'+uploadPath+'" width="600" height="100" wmode="transparent" type="application/x-shockwave-flash"></embed></a>'
		}else{
			html+='<img style="height:100px;width="500"" src="'+uploadPath+'"></img>'
		}
		//$("#showPhoto").attr("src",uploadPath);
		$("#showPhoto").html(html);
		$("#mouldphoto").val(uploadPath);
	}
	
</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>