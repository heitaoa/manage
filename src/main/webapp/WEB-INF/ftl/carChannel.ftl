<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<h3 class="page-title">
	渠道维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
			<a href="#">渠道维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>车型渠道维护 
				</div>
			</div>
			<div class="portlet-body">
				<div id="sample_1_wrapper" class="dataTables_wrapper no-footer">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="btn-group">
								<input name="" type="button" value=" 批量修改 " class="btn green" onClick="plSaveChannel();">
								
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div id="sample_1_filter" class="dataTables_filter">
								<form action="CarChannel" method="post">
									<input id="page" name="page" type="hidden" value="${page!"1"}" />
									<label style="float:right;"><input name="channelname" id="channelname" type="search" class="form-control input-small input-inline" placeholder="请输入渠道名" aria-controls="sample_1" value="${channelname?default("")}">
									<input type="submit" class="btn green" value="查询"></label>
								</from>
							</div>
						</div>
					</div>
				</div>
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
							<thead>
							<tr role="row"><th class="table-checkbox sorting_disabled" rowspan="1" colspan="1" aria-label="
									
								" style="width: 24px;text-align:center;">
									<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes">
								</th><th class="sorting_asc" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="车型名称: activate to sort column ascending" style="width: 170px;text-align:center;">
									 车型名称
								</th><th class="sorting_disabled" rowspan="1" colspan="1" aria-label=" 	渠道" style="width: 290px;text-align:center;">
									  	渠道
								</th><th class="sorting_disabled" rowspan="1" colspan="1" aria-label=" 	渠道修改" style="width: 123px;text-align:center;">
									  	渠道修改
								</th><th class="sorting" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="操作: activate to sort column ascending" style="width: 177px;text-align:center;">
									 操作
								</th></tr>
							</thead>
							<tbody>
							<#list channelList as car>
							<tr class="gradeX odd" role="row">
								<td style="text-align:center;"><input type="checkbox" name="category" id="category" class="checkboxes" value="${car.catalogid}"></td>
								<td class="sorting_1" style="text-align:center;">${car.catalogname?default("")}</td>
								<td style="text-align:center;">${car.iway?default("")}</td>
								<td style="text-align:center;"><select id="${car.catalogid}" class="form-control" name="sel_iway">
								<#list iwayList as iway>
								<option value="${iway.id}">${iway.iway}</option>
              					</#list>
								</select></td>
								<td class="center" style="text-align:center;"><a class="btn default" data-toggle="modal"  onClick="SaveChannel(${car.catalogid});">修 改</a></td>
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

function plSaveChannel(){
	var ids="";
	var inputs=document.getElementsByName("category");
	var sel_iway; 
	var id;
	var iway;
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="checkbox"&&inputs[i].checked&&inputs[i].id!="checkall")
		{
			id=document.getElementsByName("category")[i].value;
			sel_iway=document.getElementById(id);
			for(var j=0;j<sel_iway.length;j++){
				if(sel_iway.options[j].selected){
					iway=sel_iway.options[j].text;
					ids=ids+","+id+"_"+iway;
					break;
				}
			}
		}
	}
	
	$.post("PlSaveChannel",{ids:ids},function(data){
		if(data==1){
			window.location.reload(true);
		}else{
		};
	});
}

function SaveChannel(id){
	var iway;
	var sel_iway=document.getElementById(id);
	for(var i=0;i<sel_iway.options.length;i++){
		if(sel_iway.options[i].selected){
			iway=sel_iway.options[i].text;
			type=sel_iway.options[i].value;
			break;
		}
	}
	$.post("SaveChannel",{id:id,
		iwayname:iway,
		type:type
	},function(data){
		if(data==1){
			window.location.reload(true);
		}else{
		};
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