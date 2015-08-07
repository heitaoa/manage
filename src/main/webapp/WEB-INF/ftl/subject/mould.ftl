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
				<a href="toMould">专题模板</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">模板列表</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>模板列表
			</div>&nbsp;&nbsp;&nbsp;
			<button class="btn default" type="button" style="margin-top:3px;" onclick="javascript:location.href='toAddMould'">添加模板</button>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:10%">
					模板名称
				</th>
				<th style="width:40%">
					模板图片
				</th>
				<th style="width:30%">
					 模板html
				</th>
				<th style="width:10%">
					 模板ftl
				</th>
				<th style="width:10%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
				<#list mouldList as mould>
					<tr>
						<td>
							${mould.mouldname!}
						</td>
						<td>
							<img style="height:70px;width:500px" src="${mould.mouldphoto!}"></img>
						</td>
						<td>
							 ${mould.mouldhtml!}
						</td>
						<td>
							${mould.mouldftl!}
						</td>
						<td>
							 <a href="toUpdateMould?mouldId=${mould.mouldid!}">修改</a>&nbsp;&nbsp;
							 <a href="deleteMould?mouldId=${mould.mouldid!}">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
			</table>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
	//表单提交验证
	function checkForm(){
		var adurl = $.trim($("#adurl").val());
		var adimg = $("#adimg").val();
		var adSchedule = $.trim($("#showDate").html());
		
		if(adurl==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adimg==""){
			alert("广告图片还未上传...");
			return;
		}
		if(adSchedule.length==""){
			alert("广告排期还未输入...");
			return;
		}
		alert("添加成功");
		$("#applyForm").submit();
	}
	
</script>

</body>
</html>