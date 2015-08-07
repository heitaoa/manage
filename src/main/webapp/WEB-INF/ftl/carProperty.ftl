<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>

<h3 class="page-title">
	车型属性解释
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车型属性解释</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>车型属性解释维护
				</div>
			</div>
			<div class="portlet-body">
				<div id="sample_1_wrapper" class="dataTables_wrapper no-footer">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="btn-group">
								<a class="btn green" data-toggle="modal" href="#responsive2" >
									添加<i class="fa fa-plus"></i></a>
								
							</div>
						</div>
						<div class="col-md-6 col-sm-12">
							<div id="sample_1_filter" class="dataTables_filter">
								<form action="CarProperty" method="post">
									
									<label style="float:right;"><input type="text" name="page" value="${page!"1"}" id="page" style="display:none"><input name="titleName" id="titleName" type="search" class="form-control input-small input-inline" aria-controls="sample_1" value="${titleName?default("")}">
									<input type="submit" class="btn green" value="查询"></label>
								</from>
							</div>
						</div>
					</div>
					<div class="table-scrollable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="  属性名称: activate to sort column ascending" style="width: 270px;">
										 属性名称
									</th>
									<th class="sorting_disabled" rowspan="1" colspan="1" aria-label=" 属性解释" style="width: 445px;">
										 属性解释
									</th>
									<th class="sorting_disabled" rowspan="1" colspan="1" aria-label=" 操作" style="width: 193px;">
										 操作
									</th>
								</tr>
							</thead>
							<tbody>
							<#list propertyList as car>
							<tr class="gradeX odd" role="row">
								<td class="sorting_1">${car.title?default("")}</td>
								<td>${car.baikecontent?default("")}	</td>
								<td>
									<a class="btn default" data-toggle="modal" href="#responsive" onClick="SubSave(${car.id},'${car.title}');">
									修 改</a>
									
                  					<input name="" type="button" value="删 除" onClick="delProperty('${car.id}')" class="btn default">
								</td>
							</tr>
							</#list>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="fanye" style="text-align:center;">
							<@c.calcPageByJs "toPage", page, pages/>
						</div>
					</div>
			</div>
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>

</div>
<div class="modal-scrollable" style="z-index: 10051; display:none" ><div id="responsive" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>修改</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<input type="text" value="Test" id="carid" style="display:none">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性名称:</td>
							<td class="col-md-9 sorting_1"><input type="text" id="carname" class="form-control input-inline input-medium" placeholder="Enter text"></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性解释:</td>
							<td class="col-md-9 sorting_1"><textarea id="textarea"  class="form-control input-inline input-medium" rows="3"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" class="btn blue" onClick="SaveProperty()">保存</button>
	</div>
</div></div>
<div class="modal-scrollable"  style="z-index: 10051; display:none" ><div id="responsive2" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>添加</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性名称:</td>
							<td class="col-md-9 sorting_1"><input type="text" id="carname2" class="form-control input-inline input-medium" ></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性解释:</td>
							<td class="col-md-9 sorting_1"><textarea id="textarea2"  class="form-control input-inline input-medium" rows="3"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" class="btn blue" onClick="AddProperty()">保存</button>
	</div>
</div></div>
<div class="modal-backdrop fade in" style="z-index: 10050;display:none"></div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">

function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].submit();
}

 function SaveProperty(){
 	var id=document.getElementById("carid").value;
 	var titlename=document.getElementById("carname").value;
 	var property=document.getElementById("textarea").value;
 	$.post("SaveProperty",{id:id,
 		titlename:titlename,
 		property:property
 	},function(data){
 		if(data==1){
 		window.location.reload(true);
 		}
 	});
 }
 
  function AddProperty(){
 	var titlename=document.getElementById("carname2").value;
 	var property=document.getElementById("textarea2").value;
 	$.post("AddProperty",{titlename:titlename,
 		property:property
 	},function(data){
 		if(data==1){
 		window.location.reload(true);
 		}
 	});
 }
 
 
 function SubSave(id,title,baikecontent){
 	document.getElementById("carid").value=id;
 	document.getElementById("carname").value=title;
	
 }
 
 function delProperty(id){
 	rs=confirm("你确定删除吗？");
 	if(rs==true){
 		$.post("DelCarProperty",{id :id},function(data){
 			if(data==1){
 				window.location.reload(true);
 			}else{
 			}
 		});
 	}
 }
 
 $("#show2").click(function(){
		$("#viewbg2").css({display:"block",height:$(document).height()});
			var yscroll = document.documentElement.scrollTop;
			$("#login_container2").css("top","150px");
			$("#login_container2").css("display","block");
			document.documentElement.scrollTop = 0;
	});
</script>
</body>
</html>