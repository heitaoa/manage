<#import "./common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<@cc.html_body>
<h3 class="page-title">
	非车型图库
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<span>新闻管理</span>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<span>图库管理</span>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<span>非车型图库</span>
		</li>
	</ul>
	
</div>
<div class="row">
	<div class="col-md-4">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i><span id="treeName">非车型目录</span>
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
		<form method="post">
			<div class="clearfix">
				<button class="btn btn-circle red-sunglo" type="button" onclick="carImageManage()">图库管理</button>&nbsp;
			</div>
			<div class="clearfix">
				<input name="carTypeArr" id="carTypeArr" type="hidden" >
	            <input name="clickIsParent" id="clickIsParent" type="hidden" >
	            <input name="seltree" id="seltree" type="hidden" >
			</div>
			<div class="clearfix">
				<div id="catalogid" style="font-size:30px"></div>
			</div>
		</form>
	</div>
</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
<script type="text/javascript">

$(document).ready(function() {

	createTree("非车型图库目录",'treeMenu');

});

function onClick(treeId, treeNode, clickFlag){

	var carTypeArr = new Array;
	
	if(clickFlag.isParent){
		for(var i =0 ;i<clickFlag.children.length;i++){
			if(clickFlag.children[i].isParent){
				for(var j = 0 ;j<clickFlag.children[i].children.length;j++){
					if(clickFlag.children[i].children[j].isParent){
					
					}else{
						carTypeArr.push(clickFlag.children[i].children[j].id)
					}
				}
			}else{
				carTypeArr.push(clickFlag.children[i].id);
			}
		}
	}else{
		carTypeArr.push(clickFlag.id);
	}
	$("#clickIsParent").val(clickFlag.isParent);
	$("#carTypeArr").val(carTypeArr);
	
}

function carImageManage(){

	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	document.forms[0].action = "carImageManageNot";
	document.forms[0].submit();

}

</script>
</body>
</html>