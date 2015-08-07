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
					<i class="fa fa-globe"></i>车型
				</div>
			</div>
			<div class="portlet-body">
				<form method="post">
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-12 form-horizontal">
							<div style="margin: 10px 0;">
								<div class="form-group">
									<label class="col-md-1 control-label">来源信息</label>
									<div class="col-md-11">
										<input type="text" class="form-control input-inline input-medium" name ="comefrom" id ="comefrom"size="40">
										<input class="btn green" type="button" value="批量修改来源" onclick="setComefromBatch()">
							            <input class="btn green" type="button" value="批量删除" onclick="deleteImageContentBatch()">
							            <a class="btn green sortImageBatch" href="javascript:void(0)" value="${titleId}" data-toggle="modal" >批量排序</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-striped table-bordered table-hover" id="sample_1">
				<thead>
                <tr>
                  <th class="table-checkbox" width="5%" align="left"><input type="checkbox" name="getallCheck" ></th>
                  <th width="25%" align="center">标题</th>
                  <th width="20%" align="center">图片</th>
                  <th width="12%" align="center">来源</th>
                  <th width="12%" align="center">添加时间</th>
                  <th width="26%" align="center">操作</th>
                </tr>
              </thead>
				<tbody>
              <#list imgPageList as il>
                <tr>
                  <td><input type="checkbox" name="deleteArr" value="${il.id}"></td>
                  <td>${il.title}</td>
                  <td align="center"><img width="150" src="${imageFormat(il.path,150,100)}" alt=""></td>
                  <td align="center">${il.comefrom!}</td>
                  <td align="center">${il.adddate}</td>
                  <td>
                  	<div class="btn-group">
	                    <input class="btn green" type="button" value="&uarr;" onclick="changeSort(${il.presort},${il.id},${il.sortid},${il.preid})">
	                    <input class="btn green" type="button" value="&darr;" onclick="changeSort(${il.nextsort},${il.id},${il.sortid},${il.nextid})">
	                    <input class="btn green" type="button" value="修改" onclick="carImageEdit(${il.id},${titleId})">
	                    <input class="btn green" type="button" value="删除" onclick="deleteImageContent(${il.id})">
	                    <input class="btn green" type="button" value="设置来源" onclick="setComefrom(${il.id})">
	                    <input class="btn green addimgtypeinfo" type="button" value="设置标题" updateid="${il.id}">
                    </div>
                  </td>
                </tr>
                </#list>
              </tbody>
				</table>
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-4">
							<div style="margin: 10px 0;">
								<a class="btn green" href="./carImageEdit?editTitleId=${titleId}">添加新页</a>
                    			<a class="btn green" href="./carImageManage?carTypeArr=${carTypeArr}&page=${beforepage}">返回图片主题列表</a>
							</div>
						</div>
						<div class="col-md-8">
							<div class="pull-right">
								<@cc.pager1 url="changeCarImage?titleId=${titleId}&type=${type}&" currentPage=page totalPage=totalPage rows=rows/>
							</div>
						</div>
					</div>
				</div>
				<input type="hidden" name ="changeSortEntity.nowid" id="nowid" value="0">
			    <input type="hidden" name ="changeSortEntity.changeid" id ="changeid" value="0">
			    <input type="hidden" name ="changeSortEntity.nowsort" id = "nowsort" value="0">
			    <input type="hidden" name ="changeSortEntity.changesort" id="changesort" value="0">
      			</form>
			</div>
		</div>
		
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>
<!-- responsive -->
<div id="sortModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片排序</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="col-md-12">
				<section class='example'>
			        <div class='gridly'>
			          
			        </div>
			    </section>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "confirmSort" class="btn blue">保存排序</button>
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
<link href='${admin_che_url}css/jquery.gridly.css' rel='stylesheet' type='text/css'>
<link href='${admin_che_url}css/sample.css' rel='stylesheet' type='text/css'>
<script src='${admin_che_url}js/jquery-ui.js' type='text/javascript'></script>
<script src='${admin_che_url}js/jquery.gridly.js' type='text/javascript'></script>
<script src='${admin_che_url}js/rainbow.js' type='text/javascript'></script>
<script type="text/javascript">
$(".addimgtypeinfo").click(function(){
	$("#nowtext").val($(this).attr("updateid"));
	$('#imgTypeinfo').modal('show');
});

$(".selectImgtype a").click(function(){
	var nowid = $("#nowtext").val();
	var title = $(this).html();
	$.getJSON("updateContentTitle",{id:nowid,title:encodeURI(title)},function(data){
		$('#imgTypeinfo').modal('hide');
		window.location.reload();
	});
});
function deleteImageContent(deleteid){
if(!confirm("确认要删除吗？")){
	return;
}
	window.location.href="deleteImageContent?deleteid="+deleteid;
}
function deleteImageContentBatch(){
	var dinput = $('input[name="deleteArr"]');
	var flag = false;
	for(var i =0;i<dinput.length;i++){
		if(dinput[i].checked){
			flag = true;
		}
	}
	
	if(!flag){
		alert("请选择删除的图片！");
		return;
	}

	if(!confirm("确认要删除吗？")){
		return;
	}
	
	document.forms[0].action = "deleteImageContentBatch";
	document.forms[0].submit();
}

function setComefrom(deleteid){
	var comefrom = $("#comefrom").val();
	if(comefrom == ""){
		alert("请填写图片来源！");
		return;
	}
	if(!confirm("确认要设置吗？")){
		return;
	}
	document.forms[0].action = "setComefrom?deleteid="+parseInt(deleteid);
	document.forms[0].submit();
}

function setComefromBatch(){
	var comefrom = $("#comefrom").val()
	if(comefrom == ""){
		alert("请填写图片来源！");
		return;
	}
	var dinput = $('input[name="deleteArr"]');
	var flag = false;
	for(var i =0;i<dinput.length;i++){
		if(dinput[i].checked){
			flag = true;
		}
	}
	
	if(!flag){
		alert("请选择设置来源的图片！");
		return;
	}

	if(!confirm("确认要设置吗？")){
		return;
	}
	
	document.forms[0].action = "setComefromBatch";
	document.forms[0].submit();
}


function changeSort(csort,nid,nsort,cid){
	$("#changesort").val(csort);
	$("#nowid").val(nid);
	$("#nowsort").val(nsort);
	$("#changeid").val(cid);
	document.forms[0].action = "changeSort";
	document.forms[0].submit();
}

function carImageEdit(pid,tid){
	window.location.href = "carImageEdit?editTitleId="+tid+"&imageId="+pid;
}

$(function(){
	$("input[name='getallCheck']").click(function(){
    	$("input[name='deleteArr']").prop("checked", this.checked).uniform();
    });
    
    $(".sortImageBatch").click(function(){
    	var titleid = $(this).attr("value");
    	$.getJSON("sortBatchInit",{titleid:titleid},function(data){
	    	var html = "";
	    	for(var i=0;i<data.length;i++){
	    		html = html + "<div class='brick small' id='"+data[i].id+"'><img src='"+data[i].newPath+"' /></div>";
	    	}
	    	$(".gridly").html(html);
	    	(function() {
			  $(function() {
			    $('.gridly').gridly();
			    $('.gridly').gridly('draggable');
			  });
			}).call(this);
			$("#sortModal").modal("show");
	    });
	    $("#confirmSort").click(function(){
	    	var images = $(".ui-draggable");
	    	
	    	for(var i=0;i<images.length;i++){
	    		var left = parseInt(images[i].style.left.replace(/px/,""));
	    		var top = parseInt(images[i].style.top.replace(/px/,""));
	    		var sortid = left/160 + (top/90)*6 + 1;
	    		images[i].title = sortid;
	    	}
	    	var arr = new Array;
	    	for(var i=0;i<images.length;i++){
	    		for(var j=0;j<images.length;j++){
	    			if(images[j].title == (i+1)){
	    				arr.push(images[j].id);
	    			}
	    		}
	    	}
	    	$.getJSON("sortBatch",{sortArray:JSON.stringify(arr)},function(data){
	    		alert("排序成功！");
	    		//$(".pop-cav").attr("style","display:none;");
	    		//$(".overlayer-cav").hide();
	    		location.reload();
	    	});
	    });
    });
});
</script>
</body>
</html>