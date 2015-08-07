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
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>非车型图片添加
				</div>
			</div>
			<div class="portlet-body form">
				<form class="form-horizontal" role="form" method="post">
					<div class="form-body">
						<div class="form-group">
							<label class="col-md-3 control-label">图片目录：</label>
							<div class="col-md-9">
								<span class="form-control input-inline input-xlarge">${imgTitleMap.catalogname}</span>
								<span class="help-inline">
								*当前目录</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">选择编辑分页：</label>
							<div class="col-md-9">
								<#assign x=0 />
				                  <#list imgPageList as il>
				                  	<#assign x=x+1 />
				                  	<#if il.id= imageId>
				                  	 ${x} &nbsp;
				                  	<#else>
				                  	<a href="./carImageEditNot?editTitleId=${editTitleId}&imageId=${il.id}">[${x}]&nbsp;</a>
				                  	
				                  	</#if>
				                  </#list>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">标题：</label>
							<div class="col-md-9">
								<input style="float:left;" class="form-control input-inline input-xlarge" type="text" name="imageEntity.title" size="53" value="${imgPageMap.title!imgTitleMap.title}">
								<span class="help-inline">
								*非车型主题</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">关键词：</label>
							<div class="col-md-9">
								<input type="text" class="form-control input-inline input-xlarge" size="60" name="imageEntity.keywords" value="${imgPageMap.keywords!imgTitleMap.keywords}">
								<span class="help-inline">
								*非车型关键词</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">图片：</label>
							<div class="col-md-9" >
								<div class="row" id="imgcontain">
									<div class="col-sm-4"><img width="320" src="<@cc.img_url pic=imgPageMap.path/>" alt=""></div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">上传图片：</label>
							<div class="col-md-9">
								<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
							</div>
						</div>
						
						
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<a class="btn green" href="javascript:saveImage(1)">保存</a>
									<a class="btn green" href="javascript:saveImage(2)">保存并添加新页</a>
									<a class="btn default" href="./changeCarImageNot?titleId=${editTitleId}&page=${page}">返回图片主题管理</a>
								</div>
							</div>
						</div>
						
						
					</div>
					
				  <input type="hidden" name="imageEntity.oldpath" value="${imgPageMap.path!}">
			      <input type="hidden" name="imageEntity.imageId" value="${imageId}">
			      <input type="hidden" name="imageEntity.titleid" value="${imgTitleMap.id}">
			      <input type="hidden" name="imageEntity.type" value="${imgTitleMap.type}">
			      <input type="hidden" name="imageEntity.catalogid" value="${imgTitleMap.catalogid}">
			      
			      <input type="hidden" id="editOverType" value="${editOverType!}">
			      <input type="hidden" name="batchSave" id="batchSave" value="0">
			      <input type="hidden" name="imageEntity.imagePath" id="imagePath">
				<form>
			</div>
		</div>
		
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>

</@cc.html_body>
<@cc.html_js></@cc.html_js>


<script type="text/javascript">

function saveImage(key){
	document.forms[0].action = "saveImageNot?clicktype="+key;
	document.forms[0].submit();

}

$(document).ready(function(){
	var editOverType = $("#editOverType").val();
	if(editOverType == 1){
		alert("添加成功！");
	}
	
	if(editOverType == 2){
		alert("更新成功！");
	}
});
function callbackSucc(data)
{	
	var names= data;
	var html = "";
	var path = new Array;
	for(var i = 0;i<names.length;i++){
		html = html + "<div class='col-sm-4'>";
		html = html + "<img width='320' src='"+names[i].uploadPath+"'/>"
		html = html + "</div>";
		path.push(names[i].imgPath);
	}
	$("#imgcontain").html(html);
	$("#imagePath").val(path);
	if(data.length == 1){
		$("#batchSave").val(0);
	}else{
		$("#batchSave").val(1);
	}
}
function getPathBack(data){
	$("#imagePath").val(data.cturl+data.path);
	$(".pic").find("img")[0].src = (data.cturl+data.path);
}

</script>




<@cc.uploadimg></@cc.uploadimg>
</body>
</html>
