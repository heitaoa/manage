<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
	<center><h4 class="page-title">
				广告曝光管理
	</h4></center>
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>曝光列表显示  &nbsp;&nbsp;<a href="toInsertExposure"><button type="button" class="btn green" >添加</button></a>
			</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:15%">
					广告标题
				</th>
				<th style="width:30%">
					曝光代码
				</th>
				<th style="width:15%">
					 开始时间
				</th>
				<th style="width:15%">
					 结束时间
				</th>
				<th style="width:5%">
					曝光次数
				</th>
				<th style="width:20%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
			<#list exposureList as data>
				<tr>
				    <td>
						${data.title!}
					</td>
					<td>
						${data.url!}
					</td>
					<td>
						${data.sdate!}
					</td>
					<td>
						${data.edate!}
					</td>
					<td>
						${data.count!}
					</td>
					<td>
						 <a href="deleteExposure?exposureid=${data.id!}">删除</a>&nbsp;&nbsp;
						 <a href="toUpdateExposure?exposureid=${data.id!}">修改</a>         
					</td>
				</tr>
			</#list>
			</tbody>
			</table>
			<@c.calcPage1 "getAllExposure" page pageCount></@c.calcPage1>
		</div>
		
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
</body>
</html>