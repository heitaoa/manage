<#import "./common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<@cc.html_body>
<h3 class="page-title">
	车型图库
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
			<span>车型图库</span>
		</li>
	</ul>
	
</div>
<div class="row">
	<div class="col-md-4">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i><span id="treeName">车型目录</span>
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
				<button class="btn btn-circle red-sunglo" type="button" onclick="carImageManage(1)">车型图库管理</button>&nbsp;
				<button class="btn btn-circle red-sunglo" type="button" onclick="carImageManage(2)">品牌车系图库管理</button>&nbsp;
				<button class="btn btn-circle red-sunglo" type="button" onclick="imagechouqu()">车系图片抽取</button>
			</div>
			
			<div >
			  <br />
			  <input type="text" id="PageName" class="form-control" placeholder="PageName">
			  <button class="btn btn-circle red-sunglo" type="button" id="refreshStaticPage" >刷新静态页</button>
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
	var seltree = window.url('?seltree', window.location.href)
	if(seltree == ""){
		createTree("车型目录",'treeMenu');
	}else{
		createTree("车型目录",'treeMenu',seltree);
	}
	
	$("#refreshStaticPage").click(function(){
		$.post("deleteHtml",{"delFile":$("#PageName").val()},function(data){alert(data)});
	});
	
});

function onClick(treeId, treeNode, clickFlag){
	var carTypeArr = getCarType(clickFlag)
	$("#catalogid").html("车型id: "+clickFlag.id)
	$("#clickIsParent").val(clickFlag.isParent);
	$("#carTypeArr").val(carTypeArr);
}

function getCarType(clickFlag){
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
	return carTypeArr;
}

function carImageManage(key){

	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	if(key == 2){
		$("#carTypeArr").val(nodes[0].id);
		$("#clickIsParent").val(false);
	}
	if(key == 1){
		var carTypeArr = getCarType(treeNode)
		$("#carTypeArr").val(carTypeArr);
	}
	$("#seltree").val(treeNode.tId);//当前选中的树节点
	document.forms[0].action = "carImageManage";
	document.forms[0].submit();

}
function imagechouqu(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	nodes = zTree.getSelectedNodes();
	var treeNode = nodes[0];
	if (nodes.length == 0){
		alert("请先选择一个目录！");
		return;
	}
	if(treeNode.level != 1){
		alert("请先选择一个车系目录！");
		return;
	}else{
		$.getJSON("imagechouqu",{carid:treeNode.id},function(data){
			if(data == true){
				alert("抽取成功！");
			}else{
				alert("抽取失败！");
			}
		});
	}
}
</script>

</body>
</html>