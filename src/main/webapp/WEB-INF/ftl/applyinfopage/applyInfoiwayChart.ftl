<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<form method="post" >

<table>
<tr>
<td><span>报名开始时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="startTime" value="${startTime!}" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td><span>报名结束时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="endTime" value="${endTime!}" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td>&nbsp;&nbsp;&nbsp;<button class="btn blue" type="button" id="search" onclick="submitdata();">查询</button></td>
</tr>
</table>
</form>
</div>

<div class="row">
<div class="portlet box blue" style="margin-left:15px;margin-top:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>渠道统计
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 渠道
									</th>
									<th>
										 报名人数
									</th>
									<th>
										 占比
									</th>
								</tr>
								</thead>
								<tbody>
								  <#list typeList as type>
						          <tr>
						          <td>${type.type}</td>
						          <td>${type.count}</td>
						          <td>${type.persent}</td>
						          </tr>
						          </#list>
								</tbody>
								</table>
							</div>
						</div>
					</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
function submitdata()
{
	document.forms[0].action = "searchTypeChart";
	document.forms[0].submit();
}
</script>
</body>
</html>