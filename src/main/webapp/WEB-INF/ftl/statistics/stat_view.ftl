<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>

<link rel="stylesheet" type="text/css" href="assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>

<@c.html_body>

	<h3 class="page-title">新闻统计</h3>
	
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index.html">首页</a>
			<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻统计</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻发布统计</a>
			</li>
		</ul>
	</div>
	

<!-- BEGIN PAGE CONTENT-->
<div class="row">
	<div class="col-md-12">
		<!-- Begin: life time stats -->
		<div class="portlet">
			<div class="portlet-title">
				<div class="caption">
					<strong>新闻发布量统计</strong>
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-container">
					<table class="table table-striped table-bordered table-hover" id="datatable_orders">
					<thead>
					<tr role="row" class="heading">
						<th width="10%">
							
						</th>
						<th width="10%">
							 分站/总站
						</th>
						<th width="15%">
							 编辑
						</th>
						<th width="15%">
							 时间（区间选择）
						</th>
						<th width="10%">
							时段
						</th>
						<th width="10%">
							类型
						</th>
					</tr>
					
					<tr role="row" class="filter">
						<td>
						</td>
						
						<td>
							<select  id="select_site" class="table-group-action-input form-control input-inline input-small input-sm">
								<option value="">选择分站</option>
								<#list sites as site>
		                      	<option <#if addadmin?? && addadmin == adm.username>selected="selected"</#if> value="${site}">${site}</option>
		                      	</#list>
							</select>
						</td>
						<td>
							<select  id="select_editor" class="table-group-action-input form-control input-inline input-small input-sm">
								<option value="">选择编辑</option>
								<#list editors as adm>
								<#if adm.USER_NAME??>
		                      	<option <#if addadmin?? && addadmin == adm.USER_NAME>selected="selected"</#if> value="${adm.addadmin}">${adm.USER_NAME}</option>
		                      	</#if>
		                      	</#list>
							</select>
						</td>
						<td>
							<div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd">
								<input id="begin_tm_ipt" type="text" class="form-control form-filter input-sm" readonly name="order_date_from" placeholder="From">
								<span class="input-group-btn">
								<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
								</span>
							</div>
							<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
								<input id="end_tm_ipt" type="text" class="form-control form-filter input-sm" readonly name="order_date_to" placeholder="To">
								<span class="input-group-btn">
								<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
								</span>
							</div>
						</td>
						<td>
							<select id="time_select" name="order_status" class="form-control form-filter input-sm">
								<option value="">选择时段</option>
								<option value="day">当日</option>
								<option value="week">本周</option>
								<option value="month">本月</option>
							</select>
						</td>
						<td>
							<select id="selectType" name="order_status" class="form-control form-filter input-sm">
								<option value="">选择类型</option>
								<option value="软文">软文</option>
								<option value="行情">行情</option>
								<option value="原创新闻">原创新闻</option>
								<option value="新车">新车</option>
								<option value="新闻">新闻</option>
							</select>
						</td>
						<td>
							<div class="margin-bottom-5">
								<button id="publish_search_btn" class="btn btn-sm yellow filter-submit margin-bottom" ><i class="fa fa-search"></i> Search</button>
							</div>
							<button id="search_detail_btn" class="btn btn-sm red filter-cancel"><i class="fa fa-times"></i> 详情</button>
						</td>
					</tr>
					</thead>
					
					<tbody>
					
					<!--
					<tr role="row" class="filter">
						<td>
							<strong>行情</strong>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
					</tr>
					<tr role="row" class="filter">
						<td>
							<strong>软文</strong>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
					</tr>
					<tr role="row" class="filter">
						<td>
							<strong>原创</strong>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
					</tr>
					-->
					</tbody>
					</table>
			</div>
			
			
			<div id="publish_result">
			</div>
			
		</div>
		<!-- End: life time stats -->
	</div>
</div>
<!-- END PAGE CONTENT-->

<form id="publish_form" action="stat_search" method="post" >
	<input id="addadmin" name="addadmin" type="hidden" val="${addadmin!""}">
	<input id="publishBeginTm" name="publishBeginTm" type="hidden" val="<#if publishBeginTm??>${publishBeginTm?string("yyyy-MM-dd")}</#if>">
	<input id="publishEndTm"  name="publishEndTm" type="hidden" val="<#if publishEndTm??>${publishEndTm?string("yyyy-MM-dd")}</#if>">
	<input id="detailFlag" name="detailFlag" type="hidden" val="${detailFlag!}">
	<input id="page" name="page" type="hidden" val="${page!}">
	<input id="pageSize" name="pageSize" type="hidden" val="${pageSize!}">
	<input id="newsType" name="newsType" type="hidden" val="${newsType!}">
	<input id="city" name="city" type="hidden" val="${city!}">
</form>

</@c.html_body>
<@c.html_js></@c.html_js>

<script src="${admin_che_url}js/tqutil.js" type="text/javascript"></script>
<script src="${admin_che_url}js/jquery.form.js" type="text/javascript"></script>
<script src="${admin_che_url}js/dateUtil.js" type="text/javascript"></script>

<!-- 实例化编辑器 -->
<script type="text/javascript">
$(document).ready(function(){
	
	var editors=[];
	<#list editors as editor>
	editors.push({"USER_NAME":"${editor.USER_NAME}","ORG_NAME":"${editor.ORG_NAME}","addadmin":"${editor.addadmin}"});
	</#list>
		
	//分站/总站 编辑选择 联动效果
	$("#select_site").on("change",function(){
		var city = $(this).val();
		$("#city").val(city);
		refreshEditorSel();
	})
	
	//
	function refreshEditorSel(){
		
		var site = $("#select_site option:selected").val();
		//$("#select_editor").html("");
		var html_str='<option value="">选择编辑</option>';
		for(var i=0; i<editors.length; i++ ){
			var editor = editors[i];
			if(site=="" || site == editor.ORG_NAME)
				html_str+="<option value='"+editor.addadmin+"'>"+editor.USER_NAME+"</option>";
		}
		$("#select_editor").html(html_str);
		
	}
	
	//
	$("#select_editor").on("change",function(){
		var editor =  $("#select_editor option:selected").val();
		$("#addadmin").val("");
		//alert(editor);
		if(editor)
			$("#addadmin").val(editor);
	})
	
	$("#selectType").on("change",function(){
		var newsType = $("#selectType").val();
		$("#newsType").val(newsType);
	});
	
	//开始日期
	$("#begin_tm_ipt").on("change",function(){
		var str = $("#begin_tm_ipt").val();
		$("#publishBeginTm").val(str);
	});
	//结束日期
	$("#end_tm_ipt").on("change",function(){
		var str = $("#end_tm_ipt").val();
		$("#publishEndTm").val(str);
	});
	
	//时段
	$("#time_select").on("change",function(){
	
		var tm_value = $("#time_select option:selected").val();
	
		var beginTm = "From";
		var endTm = "To";
		
		//置空
		$("#publishBeginTm").val("");
		$("#publishEndTm").val("");
		
		if(tm_value == "day")
		{
			beginTm = getTodayDate();
			endTm = getTodayDate();
		}
		else if(tm_value == "week")
		{
			beginTm = getWeekStartDate();
			endTm = getWeekEndDate();
		}
		else if(tm_value == "month")
		{
			beginTm = getMonthStartDate();
			endTm = getMonthEndDate();
		}
	
		$("#begin_tm_ipt").attr("placeholder",beginTm);
		$("#end_tm_ipt").attr("placeholder",endTm);
		
		if(beginTm != "From" && endTm != "To")
		{
			$("#publishBeginTm").val(beginTm);
			$("#publishEndTm").val(endTm);
		}
		
	});
	
	
	//新闻发布量search btn
	$("#publish_search_btn").on("click",function(){
		$("#detailFlag").val(0);
		search();
	});
	
	//详细
	$("#search_detail_btn").on("click",function(){
		$("#detailFlag").val(1);
		search();
	});
	
	
})


function search(){
	$("#publish_result").html("正在拼了老命加载中...请稍等...");
	
	$("#publish_form").ajaxSubmit({ 
		success: succPublishSearchFrom,	
		error: errPublishSearchFrom
	});
}

function succPublishSearchFrom(data){
	$("#publish_result").html(data);
}

function errPublishSearchFrom(data){
	alert("errPublishSearchFrom:"+data);
}

function toPage(p){
	$("#page").val(p);
	search();
}

</script>

</body>
</html>