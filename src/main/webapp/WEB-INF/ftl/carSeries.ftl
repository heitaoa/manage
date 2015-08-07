<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<h3 class="page-title">
	车系维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车系维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>车系维护 
				</div>
			</div>
			<div class="portlet-body">
				<div id="sample_1_wrapper" class="dataTables_wrapper no-footer">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="btn-group">
								<input name="" type="button" value=" 批量修改 " class="btn green" onClick="plSaveSeries();">
								
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div id="sample_1_filter" class="dataTables_filter">
								<form action="CarMainSeries" method="post">
									<input id="page" name="page" type="hidden" value="${page!"1"}" />
									<label style="float:right;"><input name="seriesname" id="seriesname" type="search" class="form-control input-small input-inline" placeholder="请输入车系名" aria-controls="sample_1" value="${seriesname?default("")}">
									<input type="submit" class="btn green" value="查询"></label>
								</from>
							</div>
						</div>
					</div>
				</div>
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="col-md-1 table-checkbox sorting_disabled" rowspan="1" colspan="1" aria-label="" style="text-align:center;">
									<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes">
								</th><th class="col-md-3 sorting_asc" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="车型名称: activate to sort column ascending" style="text-align:center;">
									 车型名称
								</th><th class="col-md-2 sorting_disabled" rowspan="1" colspan="1" aria-label=" 	渠道" style="text-align:center;">
									  	主车系
								</th><th class="col-md-4 sorting_disabled" rowspan="1" colspan="1" aria-label=" 	渠道修改" style="text-align:center;">
									  	主车系修改
								</th><th class="col-md-2 sorting" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="操作: activate to sort column ascending" style="text-align:center;">
									操作
								</th>
							</tr>
						</thead>
						<tbody>
							<#list catalogList as car>
							<tr class="gradeX odd" role="row">
							<td style="text-align:center;"><input type="checkbox" name="category" id="category" class="checkboxes" value="${car.catalogid}"></td>
							<td class="sorting_1" style="text-align:center;">${car.catalogname?default("")}</td>
							<td style="text-align:center;"><#if car.carSeries??>${car.carSeries.catalogname}</#if></td>
							<td style="text-align:center;">
									<div class="row">
										<div class="col-md-6">
											<select class="form-control form-filter input-sm" name="sel_make" onChange="getMake(${car.catalogid})" id="${car.catalogid}">
												<option value="0">请选择</option>
												<#list brank?keys as key>
								                <option value="${key}">${brank.get(key)}</option>
								                </#list>
											</select>
										</div>
										<div class="col-md-6">
											<select name="sel_maker" class="col-md-4 col-sm-6 form-control form-filter input-sm" id="sel_maker${car.catalogid}">
													<option value="0">请选择</option>
												</select>
										</div>
									</div>
							
							</td>
							<td class="center" style="text-align:center;"><a class="btn default" data-toggle="modal"  onClick="SaveSeries(${car.catalogid});">修 改</a></td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>			
			</div>
		</div>
		<div class="row">
				<div class="fanye" style="text-align:center;">
					<@c.calcPageByJs "toPage", page, pages/>
				</div>
			</div>
	</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].submit();
}

function plSaveSeries(){
 var ids="";
	var inputs=document.getElementsByName("category");
	var sel_iway; 
	var id;
	var iway;
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="checkbox"&&inputs[i].checked&&inputs[i].id!="checkall")
		{
			id=document.getElementsByName("category")[i].value;
			sel_iway=document.getElementById("sel_maker"+id);
			if(sel_iway.value==0){
					alert("请选择车系");
			}else{
			for(var j=0;j<sel_iway.length;j++){
				if(sel_iway.options[j].selected){
				
					iway=sel_iway.options[j].value;
					ids=ids+","+id+"@"+iway;
					break;
				}
			}
			}
		}
	}
	$.post("PlSaveSeries",{ids:ids},function(data){
		if(data==1){
			window.location.reload(true);
		}else{
		}
	});
	
}

function SaveSeries(id){
	var series=document.getElementById("sel_maker"+id).value;
	$.post("SaveSeries",{id:id,
		series:series},function(data){
		if(data==1){
			window.location.reload(true);
		}else{
		}
	});
	
}

function getMake(id){
	var Fname=document.getElementById(id).value;
	$.getJSON("GetMarker",{Fname:Fname},function(data){
		var Shtml="<option value='0'>请选择</option>";
		
		for(var i=0;i<data.length;i++){
			Shtml+="<option value='"+data[i].split("@")[0]+"'>"+data[i].split("@")[1]+"</option>";
		}
		document.getElementById("sel_maker"+id).innerHTML=Shtml;
	});
	
}

var table = $('#sample_1')

 table.find('.group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).attr("checked", true);
                    $(this).parents('tr').addClass("active");
                } else {
                    $(this).attr("checked", false);
                    $(this).parents('tr').removeClass("active");
                }
            });
            jQuery.uniform.update(set);
        });
</script>
</body>
</html>