<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				广告管理
	</h3>
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="advertisement">广告管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="advertisement">广告编辑</a>
			</li>
		</ul>
	</div>
	
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>广告位显示
			</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:50%">
					开始时间
				</th>
				<th style="width:30%">
				             结束时间
				</th>
			    <th style="width:10%">
					删除标示
				</th>
				<th style="width:10%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
			<#list schedulelist as data>
				<tr>	
					<td>
						${data.sdate!}
					</td>
					<td>
						${data.edate!}
					</td>
					<td>
						${data.isdelete!}
					</td>
					<td>
						 <a href="deletePopad?popadid=${data.id!}">删除</a>&nbsp;&nbsp;
						 <a href="toUpdatePopad?popadid=${data.id!}">修改</a>   
					</td>
				</tr>
			</#list>
			</tbody>
			</table>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
</body>
</html>