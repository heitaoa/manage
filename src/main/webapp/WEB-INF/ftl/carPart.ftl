<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>

<h3 class="page-title">
	新汽车属性维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">新汽车属性维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="portlet box grey-cascade">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>新汽车属性维护
			</div>
		</div>
		<div class="portlet-body">
			<div id="sample_1_wrapper" class="dataTables_wrapper no-footer">
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="btn-group">
							<a class="btn green" data-toggle="modal" href="#responsive2" >
								添加<i class="fa fa-plus"></i></a>
							
						</div>
					</div>
				</div>
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-sort="ascending" aria-label=" 属性名称: activate to sort column ascending" style="width: 170px;">
									 属性名称
								</th><th class="sorting_disabled" rowspan="1" colspan="1" aria-label="属性类别" style="width: 290px;">
									 属性类别
								</th><th class="sorting_disabled" rowspan="1" colspan="1" aria-label="重要程度" style="width: 123px;">
									 重要程度
								</th><th class="sorting" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="操作: activate to sort column ascending" style="width: 177px;">
									 操作
								</th></tr>
						</thead>
						<tbody>
							<#list partList as car>
							<tr class="gradeX odd" role="row">
								
								<td class="sorting_1">${car.name}</td>
								<td>${car.type}</td>
								<td><#if car.level==0>一般<#else>重要</#if></td>
								<td class="center">
									<a class="btn default" data-toggle="modal" href="#responsive" onClick="SubPart(${car.id},'${car.name}','${car.type}',${car.level},'${car.explain}')">修 改</a>
									<input name="" type="button" value="删 除" onClick="delPart(${car.id})" class="btn default">
                					
								</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="fanye" style="text-align:center;">
						<@c.calcPage "CarPart", page, pages/>
					</div>
				</div>
			</div>
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
				<input type="text" value="Test" id="carid2" style="display:none">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性类别：</td>
							<td class="col-md-9 sorting_1"><select id="selType" class="form-control" name="selType">
								<option value="1">车身外部</option>
								<option value="2">内部舒适</option>
								<option value="3">行车功能</option>
								<option value="4">驾驶安全</option>
								</select></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性名称：</td>
							<td class="col-md-9 sorting_1"><input type="text" id="partname" class="form-control input-inline input-medium" ></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">重要程度：</td>
							<td class="col-md-9 sorting_1"><select id="selLevel" class="form-control" name="selLevel">
								<option value="1">重要</option>
								<option value="0">一般</option>
								</select></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性解释:</td>
							<td class="col-md-9 sorting_1"><textarea id="explain"  class="form-control input-inline input-medium" rows="5"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" class="btn blue" onClick="SavePart()">保存</button>
	</div>
</div></div>
<div class="modal-scrollable"  style="z-index: 10051; display:none" ><div id="responsive2" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>新增</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性类别：</td>
							<td class="col-md-9 sorting_1"><select id="selType2" class="form-control" name="selType">
								<option value="1">车身外部</option>
								<option value="2">内部舒适</option>
								<option value="3">行车功能</option>
								<option value="4">驾驶安全</option>
								</select></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性名称：</td>
							<td class="col-md-9 sorting_1"><input type="text" id="partname2" class="form-control input-inline input-medium" ></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">重要程度：</td>
							<td class="col-md-9 sorting_1"><select id="selLevel2" class="form-control" name="selLevel">
								<option value="1">重要</option>
								<option value="0">一般</option>
								</select></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">属性解释:</td>
							<td class="col-md-9 sorting_1"><textarea id="explain2"  class="form-control input-inline input-medium" rows="5"></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" class="btn blue" onClick="AddPart()">保存</button>
	</div>
</div></div>
<div class="modal-backdrop fade in" style="z-index: 10050;display:none"></div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
function SubPart(id ,name,type,level,explain){
	
	document.getElementById("partname").value=name;
	document.getElementById("carid2").value=id;
	document.getElementById("explain").value=explain;
	var a;
	switch(type){
		case "车身外部":
			a=1;
			break;
		case "内部舒适":
			a=2;
			break;
		case "行车功能":
			a=3;
			break;
		case "驾驶安全":
			a=4;
			break;
	}
	
	var sel_type=document.getElementById("selType");
	for(var i=0;i<sel_type.options.length;i++){
		if(sel_type.options[i].value==a){
			sel_type.options[i].selected=true;
		}
	}
	var sel_level=document.getElementById("selLevel");
	for(var j=0;j<sel_level.options.length;j++){
		if(sel_level.options[j].value==level){
			sel_level.options[j].selected=true;
		}
	}
	
}

function delPart(id){
	rs=confirm("你确定删除吗？");
	if(rs==true){
		$.post("DelPart",{partid:id},function(data){
			if(data==1){
			window.location.reload(true);
			}else{
			}
		});
	}
}



function AddPart(){
	var type=document.getElementById("selType2").value;
	var name=document.getElementById("partname2").value;
	var level=document.getElementById("selLevel2").value;
	var explain=document.getElementById("explain2").value;
	
	$.post("AddPart",{type:type,
		name:name,
		level:level,
		explain:explain
	},function(data){
		if(data==1){
		window.location.reload(true);
		}else{
		}
	});
}

function SavePart(){
	var id=document.getElementById("carid2").value;
	var name=document.getElementById("partname").value;
	var explain=document.getElementById("explain").value;
	var type;
	var level;
	var sel_type=document.getElementById("selType");
	for(var i=0;i<sel_type.options.length;i++){
		if(sel_type.options[i].selected){
			type=sel_type.options[i].value;
			break;
		}
	}
	var sel_level=document.getElementById("selLevel");
	for(var j=0;j<sel_level.options.length;j++){
		if(sel_level.options[j].selected){
			level=sel_level.options[j].value;
			break;
		}
	}
	$.post("SavePart",{partid:id,
		type:type,
		level:level,
		name:name,
		explain:explain
	},function(data){
		if(data==1){
		window.location.reload(true);
		}else{
			alert("修改失败");
		}
	});
}

</script>
</body>
</html>