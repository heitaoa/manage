<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<h3 class="page-title">
	车系参数介绍维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车系参数介绍维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-4">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>选择车型目录
				</div>
			</div>
			
			<div class="portlet-body">
	            	<!--<div class="scroller zTreeBg" style="height:650px;" data-always-visible="1" data-rail-visible="0">
	              		<ul id="treeMenu" class="ztree"></ul>
	            	</div> -->
	            	<div class="zTreeBg" style="height:650px; overflow-x:hidden; overflow-y:auto;">
                          <ul id="treeMenu" class="ztree"></ul>
                        </div> 
	    	</div>
	    </div>
	</div>
	<div class="col-md-8">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>参数链接
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
						<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-2" >车型外观：</td>
							<td class="col-md-10" ><input id="link1" class="form-control input-inline input-medium" type="text"><em><span class="help-inline">*请输入以html或asp结尾的网址</span></em></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-2" >内饰配件：</td>
							<td class="col-md-10" ><input id="link2" class="form-control input-inline input-medium" type="text"><em><span class="help-inline">*请输入以html或asp结尾的网址</span></em></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-2" >空间体验：</td>
							<td class="col-md-10" ><input id="link3" class="form-control input-inline input-medium" type="text"><em><span class="help-inline">*请输入以html或asp结尾的网址</span></em></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-2" >动力系统：</td>
							<td class="col-md-10" ><input id="link4" class="form-control input-inline input-medium" type="text"><em><span class="help-inline">*请输入以html或asp结尾的网址</span></em></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-2" >试乘感受：</td>
							<td class="col-md-10" ><input id="link5" class="form-control input-inline input-medium" type="text"><em><span class="help-inline">*请输入以html或asp结尾的网址</span></em></td>
						</tr>
						<tr class="gradeX odd" role="row"><td class="col-md-12" colspan="2" style="text-align:center;"><button type="button" class="btn green" onClick='SaveA()'>保存品牌信息</button></td></tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<input name="catalogId" id="catalogId" value="" style="display:none;">
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function() {
	createTree("车型目录",'treeMenu');
});

function onClick(treeId, treeNode, clickFlag){
		var pId = 0;
		if(clickFlag.pId != null){
			pId = clickFlag.pId
		}
		document.getElementById("catalogId").value=clickFlag.id;
		id=clickFlag.id;
		$.getJSON("CarSeriesParameterA",{id:id},function(data){
			document.getElementById("link1").value=data.link1;
			document.getElementById("link2").value=data.link2;
			document.getElementById("link3").value=data.link3;
			document.getElementById("link4").value=data.link4;
			document.getElementById("link5").value=data.link5;
		});
}

function SaveA(){
	var id=document.getElementById("catalogId").value;
	var link1=document.getElementById("link1").value;
	var link2=document.getElementById("link2").value;
	var link3=document.getElementById("link3").value;
	var link4=document.getElementById("link4").value;
	var link5=document.getElementById("link5").value;
	$.post("SaveCarSeriesParameter",{id:id,
	link1:link1,
	link2:link2,
	link3:link3,
	link4:link4,
	link5:link5},function(data){
		if(data==1){
			alert("更新成功");
		}else{
			alert("更新失败，请再次尝试");
		}
	});
}
</script>
</body>
</html>