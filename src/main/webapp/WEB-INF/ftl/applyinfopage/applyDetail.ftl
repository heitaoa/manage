<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<form method="post" >
<input id="page" name="page" type="hidden" value="${page!"1"}" />
<table>
<tr>
<td><span>操作人：</span></td>
<td><input type="text"  class="form-control input-inline input-medium " name="name"  value="${name!}"></td>
<td><span>开始时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}"" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td><span>结束时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}" >
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
								<i class="fa fa-cogs"></i>用户操作记录
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
										 客户姓名
									</th>
									<th>
										 客户电话
									</th>
									<th>
										 操作人
									</th>
									<th>
										操作类型
									</th>
									<th>
										 备注
									</th>
									<th>
										操作时间
									</th>
									<th>
										 恢复记录
									</th>
								</tr>
								</thead>
								<tbody>
								 <#list applyInfo as app>
						             <tr>
									<td>${app.name!}</td>
									<td>${app.phone!}</td>
						            <td>${app.nickname!}</td>
						            <td>${app.type!}</td>
						            <td>${app.remark!}</td>
						            <td>${app.addtime!}</td>
						            <td><a class="btn_orange-a" href="applyDetailUpdate?aid=${app.applyid!}">恢复记录</a></td> 
						             </tr>
					             </#list>
								<tr>
		                          <td colspan=7 style="text-align:center;"><@c.calcPageByJs "toPage", page, pages/></td>
		                         </tr>
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
	$("#page").val(1);
	document.forms[0].action = "applyDetail";
	document.forms[0].submit();
}
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].action='applyDetail';
	document.forms[0].submit();
}
</script>
</body>
</html>