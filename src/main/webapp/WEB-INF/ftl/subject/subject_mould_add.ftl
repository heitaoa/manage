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
				<a href="javascript:void(0);">添加专题模板</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>添加专题模板
			</div>
		</div>
		<div class="portlet-body">
		<form action="addSubjectMould" method="post" id="form">
			<input type="hidden" name="subjectId" value="${subjectId!}">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
				<thead>
					<tr>
						<th class="table-checkbox" style="width:3%;">
							<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"/>
						</th>
						<th style="width:10%">
							模板名称
						</th>
						<th style="width:40%">
							模板图片
						</th>
						<th style="width:27%">
							 模板html
						</th>
						<th style="width:10%">
							 模板ftl
						</th>
					</tr>
				</thead>
				<tbody id="showAdInfo">
					<#list mouldList as mould>
						<tr>
							<td>
								<input type="checkbox" class="checkboxes" name="mouldIdList" value="${mould.mouldid!}"/>
							</td>
							<td>
								${mould.mouldname!}
							</td>
							<td>
								<img src="${mould.mouldphoto!}"></img>
							</td>
							<td>
								 ${mould.mouldhtml!}
							</td>
							<td>
								${mould.mouldftl!}
							</td>
						</tr>
					</#list>
				</tbody>
			</table>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-offset-5 col-md-9">
						<button type="button" class="btn green" onclick="checkForm();">提交</button>
						<button type="button" class="btn default" onclick="javascript:history.go(-1);">返回</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
	//表单提交验证
	function checkForm(){
		var flag = true;
		$("#showAdInfo").find("input").each(function(){
			 if($(this).attr("checked")){
			     flag = false;
			     return false;
			 }
		});
		if(flag){
			alert("还未选中模板,请先选中模板");
			return;
		}
		alert("添加成功");
		$("#form").submit();
	}
	
</script>

</body>
</html>