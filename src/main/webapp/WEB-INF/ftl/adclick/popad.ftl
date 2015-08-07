<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
	<center><h4 class="page-title">
				广告点击管理
	</h4></center>
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>点击列表显示&nbsp;&nbsp;<a href="toinsertPopad"><button type="button" class="btn green" >添加</button></a>
			</div>
		</div>
		
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:20%">
					标题
				</th>
				<th style="width:40%">
					 点击代码
				</th>
			    <th style="width:20%">
					广告页面
				</th>
				<th style="width:10%">
					点击倍数
				</th>
				<th style="width:10%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
			<#list podlist as data>
				<tr>	
					<td>
						${data.adtitle!}
					</td>
					<td>
						${data.adstr!}
					</td>
					<td>
						${data.jsstr!}
					</td>
					<td>
						${data.totalclick!}
					</td>				
					<td>
						 <a href="deletePopad?popadid=${data.id!}&page=${page!}">删除</a>&nbsp;&nbsp;
						 <a href="toUpdatePopad?popadid=${data.id!}">修改</a>   
					</td>
				</tr>
			</#list>
			</tbody>
			</table>
			<@c.calcPage1 "getAllpopad" page pageCount></@c.calcPage1>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
</body>
</html>