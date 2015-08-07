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
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>车型图片添加
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
								*当前车型</span>
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
				                  	<a href="./carImageEdit?editTitleId=${editTitleId}&imageId=${il.id}">[${x}]&nbsp;</a>
				                  	
				                  	</#if>
				                  </#list>
							</div>
						</div>
						<!--<div class="form-group">
							<label class="col-md-3 control-label">标题：</label>
							<div class="col-md-9">
								<input style="float:left;" class="form-control input-inline input-xlarge" type="text" name="imageEntity.title" size="53" value="${imgPageMap.title!imgTitleMap.title}">
								<span class="help-inline">
								*车型主题</span>
							</div>
						</div>-->
						<div class="form-group">
							<label class="col-md-3 control-label">关键词：</label>
							<div class="col-md-9">
								<input type="text" class="form-control input-inline input-xlarge" size="60" name="imageEntity.keywords" value="${imgPageMap.keywords!imgTitleMap.keywords}">
								<span class="help-inline">
								*车型关键词</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">图片：</label>
							<div class="col-md-9" >
								<div class="row" id="imgcontain">
									<div class="col-sm-2 text-center">
										<p><img width="150" src="<#if imgPageMap.path??>${imageFormat(imgPageMap.path,150,100)}</#if>"></p>
										<p><a value="0" class="btn btn-primary addimgtypeinfo" href="javascript:void(0);">图片方位</a></p>
										<p id="imgtext0">${imgPageMap.title!imgTitleMap.title}</p>
									</div>
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
									<a class="btn default" href="./changeCarImage?titleId=${editTitleId}&page=${page}">返回图片主题管理</a>
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
			      <input type="hidden" name="imageEntity.imageTypeInfo" id="imageTypeInfo">
				</form>
			</div>
		</div>
		
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>


<div id="imgTypeinfo" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片信息</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<#assign flg=false>
			<#list imgTypelist as it>
				<#list comparelist as cl>
					<#if it.name = cl><#assign flg=true><#break></#if>
				</#list>
				<div class="col-sm-2 text-center selectImgtype" style="line-height:2.4em"><a <#if flg == true>class="alert-danger"</#if>href="javascript:void(0);">${it.name}</a></div>
				<#assign flg=false>
			</#list>
		</div>
	</div>
	<div class="modal-footer">
		<input type="hidden" id="nowtext">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
	</div>
</div>

</@cc.html_body>
<@cc.html_js></@cc.html_js>


<script type="text/javascript">
$(".selectImgtype a").click(function(){
	var nowid = $("#nowtext").val();
	$("#imgtext"+nowid).html($(this).html());
	$('#imgTypeinfo').modal('hide');
});
function saveImage(key){
	var value=new Array;
	for(var i=0 ;i<$(".addimgtypeinfo").length;i++){
		value.push($("#imgtext"+i).html());
	}
	$("#imageTypeInfo").val(value);
	document.forms[0].action = "saveImage?clicktype="+key;
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

$(".addimgtypeinfo").click(function(){
	$('#imgTypeinfo').modal('show');
});

var dstr = "<#if imgTitleMap.type == 1>外观</#if><#if imgTitleMap.type == 2>车厢座椅</#if><#if imgTitleMap.type == 3>中控</#if><#if imgTitleMap.type == 4>其他</#if>";
function callbackSucc(data)
{	
	var names= data;
	var html = "";
	var path = new Array;
	for(var i = 0;i<names.length;i++){
		html = html + "<div class='col-sm-2 text-center'>";
		html = html + "<p><img width='150' src='"+names[i].FormatImgPath+"'/></p>"
		if(dstr == ""){
			dstr ="-";
		}
		html = html + "<p><a href='javascript:void(0);' class='btn btn-primary addimgtypeinfo' value='"+i+"'>图片方位</a></p><p id='imgtext"+i+"'>"+dstr+"</p>"
		html = html + "</div>";
		path.push(names[i].imgPath);
	}
	$("#imgcontain").html(html);
	$(".addimgtypeinfo").click(function(){
		$("#nowtext").val($(this).attr("value"));
		$('#imgTypeinfo').modal('show');
	});
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
