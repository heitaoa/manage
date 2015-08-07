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
				<a href="javascript:void(0);">新闻点击统计</a>
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
					<strong>选择一个统计CSV文件，然后上传</strong>
				</div>
			</div>
			<div class="portlet-body">
				 <form id="csv_form" action="./cnzz_uploadCVS" enctype="multipart/form-data" method="post">
		         	文件:<input type="file" name="image"/>
		            <input id="csc_submit_btn" type="button" value="上传" />
		        </form>
		        
		        <div id="csv_res">
					请上传csv文件
				</div>
			</div>
		
			<br><br><br>
			
			<div class="portlet-title">
				<div class="caption">
					<strong>新闻点击量统计</strong>
				</div>
				<input type="button" class="btn default" value="生成报表" onclick="javascript:genExcel();">
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
							 Actions
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

<form id="cnzz_form" action="cnzz_search" method="post" >
	<input id="site" name="site" type="hidden" val="${site!""}">
	<input id="addadmin" name="addadmin" type="hidden" val="${addadmin!""}">
	<input id="publishBeginTm" name="publishBeginTm" type="hidden" val="<#if publishBeginTm??>${publishBeginTm?string("yyyy-MM-dd")}</#if>">
	<input id="publishEndTm"  name="publishEndTm" type="hidden" val="<#if publishEndTm??>${publishEndTm?string("yyyy-MM-dd")}</#if>">
	<input id="detailFlag" name="detailFlag" type="hidden" val="${detailFlag!}">
	<input id="page" name="page" type="hidden" val="${page!}">
	<input id="pageSize" name="pageSize" type="hidden" val="${pageSize!}">
	<input id="newsType" name="newsType" type="hidden" val="${newsType!}">
	<input id="csvPath" name="csvPath" type="hidden" val="${csvPath!}">
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
		var site =  $("#select_site").val();
		$("#site").val("");
		$("#page").val(1);
		//alert(editor);
		if(site)
			$("#site").val(site);
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
		//var editor =  $("#select_editor option:selected").val();
		var editor =  $("#select_editor").val();
		$("#addadmin").val("");
		$("#page").val(1);
		//alert(editor);
		if(editor)
			$("#addadmin").val(editor);
	})
	
	//选择类型
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
	
	
	//上传
	$("#csc_submit_btn").on("click",function(){
		//$("#detailFlag").val(0);
		csvSubmit();
	});
	
	
	//-----------------------------
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


function csvSubmit(){
	$("#csv_res").html("上传中...请稍等...");
	
	$("#csv_form").ajaxSubmit({ 
		success: succCSVFrom,	
		error: errCSVFrom
	});
}

function succCSVFrom(data){
	$("#csvPath").val(data);
	$("#csv_res").html(data);
}

function errCSVFrom(data){
	alert("errCSVFrom:"+data);
}

//------------------------------------------
function search(){
	$("#publish_result").html("正在拼了老命加载中...请稍等...");
	
	$("#cnzz_form").ajaxSubmit({ 
		success: succCnzzFrom,	
		error: errCnzzFrom
	});
}

function succCnzzFrom(data){
	$("#publish_result").html(data);
}

function errCnzzFrom(data){
	alert("errCSVFrom:"+data);
}

function toPage(p){
	$("#page").val(p);
	search();
}

function genExcel(){
	var addadmin = $("#addadmin").val();
	var publishBeginTm = $("#publishBeginTm").val();
	var publishEndTm = $("#publishEndTm").val();
	var newsType = $("#newsType").val();
	var csvPath = $("#csvPath").val();
	var detailFlag = $("#detailFlag").val();
	window.location.href = "${admin_che_url}adminche/cnzz_ExportUserToExcel?addadmin="+addadmin+"&publishBeginTm="+publishBeginTm+"&publishEndTm="+publishEndTm+"&csvPath="+encodeURI(encodeURI(csvPath))+"&newsType="+encodeURI(encodeURI(newsType))+"&detailFlag="+detailFlag;
}

</script>

</body>
</html>