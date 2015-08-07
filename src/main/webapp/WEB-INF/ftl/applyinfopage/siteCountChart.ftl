<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
<form method="post">
<table  style="margin-left:15px;">
<tr>
<td>报名时间</td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}" id="beginDate">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>&nbsp;&nbsp;至&nbsp;&nbsp;
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}" id="endDate">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td><button class="btn blue" type="button" id="search">查询</button></td>
</tr>
</table>
</form>
</div>

<div class="row">
<div class="portlet box blue" style="margin-left:15px;margin-top:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>分站统计
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
										 站点	
									</th>
									<th>
										 报名总数
									</th>
									<th>
										 已回访
									</th>
									<th>
										 未回访
									</th>
									<th>
										 回访率
									</th>
								</tr>
								</thead>
								<tbody>
								<#list applyInfo as applyInfo>
		                          <tr>
		                            <td style="text-align:left;">${applyInfo["siteName"]!}</td>
		                            <td style="text-align:left;">${applyInfo["total"]!}</td>
		                            <td style="text-align:left;">${applyInfo["icount"]!}</td>
		                            <td style="text-align:left;">${applyInfo["ucount"]!}</td>
		                            <td style="text-align:left;">${applyInfo["persent"]!}</td>
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
$(document).ready(function(){
	$("#search").on("click", function() {
	var beginDate = $.trim($("#beginDate").val());
	var endDate = $.trim($("#endDate").val());
	if(beginDate==""||endDate==""){
	alert("请填写时间!");
	return;
	}
	document.forms[0].action = "getsitCountForAdm";
	document.forms[0].submit();
});
});
</script>
</body>
</html>