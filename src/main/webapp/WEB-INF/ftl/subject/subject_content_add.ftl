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
						<a href="toMould">专题管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题模块</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">添加模块</a>
					</li>
				</ul>
			</div>
			<!-- EDN PAGE HEADER-->

		<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>新增模块
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="addSubjectContent" method="post" id="mouldForm">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">模块名称：</label>
								<div class="col-md-3">
									<input type="text" name="content.place" id="place" value="" class="form-control">
								</div>
							</div>
							<input type="hidden" value="zt_${subjectId}" name="content.pname">
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
		var place = $.trim($("#place").val());
		
		if(place==""){
			alert("模快名称还未输入...");
			return;
		}
		alert("添加成功");
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