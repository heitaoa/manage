<#import "./common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<!-- END STYLE CUSTOMIZER -->
<!-- BEGIN PAGE HEADER-->

<@cc.html_body>
<h3 class="page-title">
	目录管理
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a >系统管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a >目录管理</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-4">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i><span id="treeName">新闻目录</span>
				</div>
			</div>
			<div class="portlet-body">
				<div class="zTreeBg" style="height:500px;overflow-x:hidden;overflow-y:auto;">
                  <ul id="treeMenu" class="ztree"></ul>
                </div>
			</div>
		</div>
	</div>
	<div class="col-md-8">
		<div class="portlet box purple">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>目录选择
				</div>
			</div>
			<div class="portlet-body">
				<div class="clearfix">
					
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-offset-3 col-md-9">
							<div class="btn-group btn-group-circle" data-toggle="buttons" id="treeRad">
								<label class="btn blue active">
								<input type="radio" class="toggle" value="新闻目录"> 新闻目录 </label>
								<label class="btn blue">
								<input type="radio" class="toggle" value="车型目录"> 车型目录 </label>
								<label class="btn blue">
								<input type="radio" class="toggle" value="非车型图库目录"> 非车型图库目录 </label>
								<label class="btn blue">
								<input type="radio" class="toggle" value="城市目录"> 城市目录 </label>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="form form-horizontal">
					<div class="form-body">
						<div class="form-group">
							<label class="col-md-3 control-label">目录名称:</label>
							<div class="col-md-9">
								<input type="text" name="addName" id="addName" placeholder="目录名称" class="form-control">
								<span class="help-block"> *增加新的目录 </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label"></label>
							<div class="col-md-9">
								<button class="btn btn-circle red-sunglo" type="button" onclick="addTreeNode(0)">新增主目录</button>&nbsp;
								<button class="btn btn-circle red-sunglo" type="button" onclick="addTreeNode(1)">新增子目录</button>&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label"></label>
							<div class="col-md-9">
								<button class="btn btn-circle red-sunglo" type="button" onclick="editTreeNode()">修改</button>&nbsp;
								<button class="btn btn-circle red-sunglo" type="button" onclick="removeTreeNode()">删除</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--<div class="col-md-8">
		<div class="portlet box purple">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>新闻分站
				</div>
			</div>
			<div class="portlet-body">
				<div class="form form-horizontal">
					<div class="form-group">
						<label class="col-md-3 control-label">新闻站点:</label>
						<div class="col-md-9">
							<select class="form-control">
								<option>--请选择--</option>
								<option>Option 2</option>
								<option>Option 3</option>
								<option>Option 4</option>
								<option>Option 5</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-9">
							<button class="btn btn-circle red-sunglo" type="button">选择站点</button>
						</div>
					</div>
				</div>
			</div>
		</div>-->
	</div>
</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
<script type="text/javascript">


$(document).ready(function() {


	createTree2("新闻目录",'treeMenu');
	$(".sitetr").attr("style","");
	
	$("#treeRad label").click(function(){
		var treeName = $(this).find("input").val();
		$("#treeName").html(treeName);
		createTree2(treeName,'treeMenu');
	});

});

function onClick(treeId, treeNode, clickFlag){
		var pId = 0;
		if(clickFlag.pId != null){
			pId = clickFlag.pId
		}
		if(treeName == "新闻目录"){
			$.getJSON("searchsite",{id:clickFlag.id},function(data){
				$("#newssite").find("option").removeAttr("selected");
				$("#newssite").find("option[value="+data+"]").prop("selected",true);
			});
		}
}

function OnRename(treeId, treeNode, clickFlag){
		$.getJSON("editTreeName", { treeName: encodeURI(treeName),id: clickFlag.id,updateName:encodeURIComponent(clickFlag.name)}, function(data){
		});
}

function addTreeNode(key){
	var addName = $("#addName").val();
	
	if(addName == "" || addName==null){
		alert("请输入目录名！");
		return;
	}
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	var fatherId = 0;
	if(key == 0){
		treeNode = null;
	}

	if(key == 1){
		if(nodes.length == 0){
			alert("请选择一个目录！");
			return;
		}
		fatherId = treeNode.id
	}
	
	$.getJSON("addTreeNodes", { treeName: encodeURI(treeName),fatherId: fatherId ,addName:encodeURI(addName)}, function(data){
			alert("添加成功！");
			treeNode = zTree.addNodes(treeNode, data);
			$("#addName").val("")
	});
}
function removeTreeNode(){
	var addName = $("#addName").val();
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	if(treeNode.isParent){
		alert("请先删除子目录！");
		return;
	}
	if(!confirm("确认删除目录 " + treeNode.name + " 吗？")){
		return;
	}
	$.getJSON("deleteTreeNodes", { treeName: encodeURI(treeName),id: treeNode.id}, function(data){
			alert("删除成功！");
			zTree.removeNode(treeNode);
	});
	
}
function editTreeNode(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	zTree.editName(treeNode);
}

function changeTree(treeStr,titleStr){
	if(treeStr == treeName){
		return;
	}else{
		treeName = treeStr;
	}
	if(titleStr == "newsTitle" ){
		$(".sitetr").attr("style","")
		$("#newsTitle").attr("style","background:#ff7e62;");
		$("#imgTitle").attr("style","background:#CCC;");
		$("#imgNewTitle").attr("style","background:#CCC;");
		$("#carTitle").attr("style","background:#CCC;");
		$("#cityTitle").attr("style","background:#CCC;");
	}else{
		$(".sitetr").attr("style","display:none")
	}
	
	if(titleStr == "imgTitle" ){
		$("#newsTitle").attr("style","background:#CCC;");
		$("#imgTitle").attr("style","background:#ff7e62;");
		$("#imgNewTitle").attr("style","background:#CCC;");
		$("#carTitle").attr("style","background:#CCC;");
		$("#cityTitle").attr("style","background:#CCC;");
	}
	
	if(titleStr == "imgNewTitle" ){
		$("#newsTitle").attr("style","background:#CCC;");
		$("#imgTitle").attr("style","background:#CCC;");
		$("#imgNewTitle").attr("style","background:#ff7e62;");
		$("#carTitle").attr("style","background:#CCC;");
		$("#cityTitle").attr("style","background:#CCC;");
	}
	
	if(titleStr == "carTitle" ){
		$("#newsTitle").attr("style","background:#CCC;");
		$("#imgTitle").attr("style","background:#CCC;");
		$("#imgNewTitle").attr("style","background:#CCC;");
		$("#carTitle").attr("style","background:#ff7e62;");
		$("#cityTitle").attr("style","background:#CCC;");
	}
	if(titleStr == "cityTitle" ){
		$("#newsTitle").attr("style","background:#CCC;");
		$("#imgTitle").attr("style","background:#CCC;");
		$("#imgNewTitle").attr("style","background:#CCC;");
		$("#carTitle").attr("style","background:#CCC;");
		$("#cityTitle").attr("style","background:#ff7e62;");
	}
	$("#treeTitle").html(treeStr+"管理");
	createTree2(treeName,'treeMenu');

}

function setStie(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	var newssite = $("#newssite").val();
	
	$.getJSON("setSite", { treeName: encodeURI(treeName),newssite: encodeURI(newssite),id: treeNode.id}, function(data){
			alert("站点添加成功！");
			//zTree.removeNode(treeNode);
	});

}
</script>
</body>
</html>