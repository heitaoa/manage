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
				<a href="javascript:void(0);">专题模板</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>专题模块
			</div>&nbsp;&nbsp;&nbsp;
			<button class="btn default" type="button" style="margin-top:3px;" onclick="javascript:location.href='toAddSubjectContent?subjectId=${subjectId}'">添加模板</button>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:6%">
					模块ID
				</th>
				<th style="width:7%">
					专题名称
				</th>
				<th style="width:25%">
					模块名称
				</th>
				<th style="width:8%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
				<#list subjectContentList as map>
					<tr>
						<td>
							${map.id!}
						</td>
						<td>
							${map.pname!}
						</td>
						<td>
							${map.place!}
						</td>
						<td>
							 <!--<a href="deleteSubjectContent?contentid=${map.id!}&subjectId=${subjectId!}">删除</a>&nbsp;-->
							 <a href="javascript:void(0);" onclick="deleteSubjectContent(${map.id!})">删除</a>&nbsp;
							 <a href="subjectData?contentid=${map.id!}">编辑数据</a>
							 <a href="toUpdateSubjectContent?contentid=${map.id!}">修改模板</a>
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
	function deleteSubjectContent(id){
		var flag = false;
		if(confirm("请确认是否删除！" )) flag = true; 
		if(flag){
			window.location.href="deleteSubjectContent?contentid="+id+"&subjectId=${subjectId!}";
		}
	
	}
</script>
</body>	
</html>