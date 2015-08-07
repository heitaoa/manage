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
						<a href="index.html">首页</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="subject">专题制作</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题数据编辑</a>
					</li>
				</ul>
			</div>
			<!-- EDN PAGE HEADER-->

		<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>编辑数据
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="addSubjectData" method="post" id="form">
						<input type="hidden" value="${contentid!}" name="subjectdata.sid">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">标题文字：</label>
								<div class="col-md-3">
									<input type="text" name="subjectdata.title" id="title" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">标题链接：</label>
								<div class="col-md-3">
									<input type="text" name="subjectdata.link" id="titleurl" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">目录名称：</label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="subjectdata.ctitle" id="titleclass">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">目录链接：</label>
								<div class="col-md-3">
									<input type="text" class="form-control" name="subjectdata.clink" id="textclass">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">文本数据：</label>
								<div class="col-md-3">
									<textarea name="subjectdata.content" id="text" value="" class="form-control"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">文本链接：</label>
								<div class="col-md-3">
									<input type="text" name="subjectdata.color" id="texturl" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 control-label">上传广告图片：</label>
								<div class="col-md-9">
									<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
									<input type="text" name="subjectdata.pic" id="photo" value="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">图片显示：</label>
								<div class="col-md-9" id="showPhoto">
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="submit" class="btn green" onclick="javascript:checkForm();">提交</button>
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
		$("#photo").val(uploadPath);
	}
	
</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>