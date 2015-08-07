<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				专题管理
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
				<a href="subject">专题制作</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">添加专题</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	
	<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>添加专题
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="addSubject" method="post" id="subjectForm">
						<input type="hidden" value="" name="mould" id="subjectmould">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">专题名称：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="subjectname" name="subject.name">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">专题关键字：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="keywords" name="subject.keywords">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">专题描述：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="descstr" name="subject.descstr">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">专题模板：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="content" name="subject.content">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">可选模板：</label>
								<div class="col-md-6">
									<select class="form-control" id="mould">
										<option value="">你可以选择展会模板</option>
										<#if subjectList??>
											<#list subjectList as list>
												<option value="${list.id!}*${list.content!}">${list.name!}</option>
											</#list>
										</#if>
									</select>
								</div>
								<button class="btn default" type="button" onclick="javascript:addMould();">添加模板</button>
							</div>
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 control-label">专题图片：</label>
								<div class="col-md-9">
									<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
									<input type="text" name="subject.titlephoto" id="subjectphoto" value="">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">图片显示：</label>
								<div class="col-md-9" id="showPhoto" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">类型：</label>
								<div class="col-md-9">
									<div class="radio-list col-md-2">
										<label>
										<input type="radio" name="subject.type" id="subjecttype" value="综合" onclick="javascript:searchType('综合');">综合</label>
										<label>
										<input type="radio" name="subject.type" id="optionsRadios23" value="活动" onclick="javascript:searchType('活动');">活动</label>
									</div>
									<div class="radio-list col-md-2">
										<label>
										<input type="radio" name="subject.type" id="optionsRadios22" value="新闻" onclick="javascript:searchType('新闻');">新闻</label>
										<label>
										<input type="radio" name="subject.type" id="optionsRadios23" value="行情" onclick="javascript:searchType('行情');">行情</label>
									</div>
									<div class="radio-list col-md-2">
										<label>
										<input type="radio" name="subject.type" id="optionsRadios22" value="新车" onclick="javascript:searchType('新车');">新车</label>
										<label>
										<input type="radio" name="subject.type" id="optionsRadios23" value="导购" onclick="javascript:searchType('导购');">导购</label>
									</div>
									<div class="radio-list col-md-2">
										<label>
										<input type="radio" name="subject.type" id="optionsRadios22" value="评测" onclick="javascript:searchType('评测');">评测</label>
										<label>
										<input type="radio" name="subject.type" id="optionsRadios23" value="展会" checked onclick="javascript:searchType('展会');">展会</label>
									</div>			
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="javascript:checkForm();">提交</button>
									<button type="button" class="btn default" onclick="javascript:history.go(-1);">返回</button>
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
		//表单提交验证
		function checkForm(){
			var subjectname = $.trim($("#subjectname").val());
			var subjecttype = $.trim($("#subjecttype").val());
			var content = $.trim($("#content").val());

			if(subjectname==""){
				alert("专题名称还未录入...");
				return;
			}
			if(content==""){
				alert("专题模板还未录入...");
				return;
			}
			alert("添加成功");
			$("#subjectForm").submit();
		}
		
		
		function callbackSucc(data)
			{	
				var adimg= data[0];
				var uploadPath = adimg.uploadPath;
				html='';
				if(uploadPath.substring(uploadPath.length-3)=="swf"){
					html+='<a href="http://www.chetuan.com"><embed src="'+uploadPath+'" width="600" height="100" wmode="transparent" type="application/x-shockwave-flash"></embed></a>'
				}else{
					html+='<img style="height:100px;width="500"" src="'+uploadPath+'"></img>'
				}
				//$("#showPhoto").attr("src",uploadPath);
				$("#showPhoto").html(html);
				$("#subjectphoto").val(uploadPath);
			}
		
		
		//选择模板
		function addMould(){
			var mould = $("#mould").val();
			if(mould==''){
				alert("请先选择一个模板！");
				return;
			}
			$("#content").val(mould.split("*")[1]);
			$("#subjectmould").val(mould.split("*")[0]);
		}
		
		function searchType(type){
			var type = type;
			$.ajax({
				url : './getMouldByType',
				dataType:'json',
				data:{type:encodeURI(type)},
				success:function(data){
					var data = eval(data);
					var html = '<option value="">你可以选择'+type+'模板</option>';
					for(var i=0;i<data.length;i++){
						var subject = data[i];
						html += '<option value="'+subject.id+'*'+subject.content+'">'+subject.name+'</option>';
					}
					$("#mould").html(html);
				}
			});
			
			
		}
	</script>
	
	
	
<@c.uploadimg></@c.uploadimg>
</body>
</html>