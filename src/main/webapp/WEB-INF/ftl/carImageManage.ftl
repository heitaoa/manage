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
					<i class="fa fa-globe"></i>车型图片主题
				</div>
			</div>
			<div class="portlet-body">
				<form method="post">
				<table class="table table-striped table-bordered table-hover" id="sample_1">
				<thead>
				<tr>
					<th class="table-checkbox">
						<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"/>
					</th>
					<th width="18%" align="center">主题</th>
                  	<th width="9%" align="center">目录</th>
                  	<th width="7%" align="center">类型</th>
                  	<th width="6%" align="center">添加者</th>
                  	<th width="6%" align="center">添加时间</th>
                  	<th width="6%" align="center">颜色</th>
                  	<th width="26%" align="center">显示分页</th>
                  	<th width="18%" align="center">操作</th>
				</tr>
				</thead>
				<tbody>
				<tr class="odd gradeX">
					<#list imgTitleList as il>
	                <tr>
	                  <td ><input type="checkbox" name="imgTitle" value="${il.id}"></td>
	                  <td align="center">${il.title}</td>
	                  <td align="center"><a href="./carImageManage?carTypeArr=${il.catalogid}">${il.catalogname}</a></td>
	                  <td align="center">${il.typeName}</td>
	                  <td align="center">${il.addadmin}</td>
	                  <td align="center">${il.adddate}</td>
	                  <td align="center">${il.color!}</td>
	                  <td>
	                  <#assign x=0 />
	                  <#list imgPageList as tl>
	                  <#if tl.titleId = il.id && tl.type=il.type>
	                  <#assign x=x+1 />
	                  <a href="./carImageEdit?editTitleId=${il.id}&imageId=${tl.id}">[${x}]</a>
	                  </#if>
	                  </#list>
	                  </td>
	                  <td align="center">
	                  	<div class="btn-group">
		                    <a class="btn green" href="./carImageEdit?editTitleId=${il.id}">添加新页</a>
		                    <a class="btn green" href="./changeCarImage?titleId=${il.id}&type=${il.type}">修改内页</a>
		                    <a class="btn green" href="javascript:deleteTitle('${il.id}')">删除</a>
	                    </div>
	                  </td>
	                </tr>
	               </#list>
				</tr>
				</tbody>
				</table>
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-4">
							<div style="margin: 10px 0;">
								<a class="btn green" href="javascript:carTitleEdit()">添加图片主题</a>
								<a class="btn green" href="javascript:carTitleChange()">修改图片主题</a>
								<a class="btn green" href="javascript:deleteTitleBatch()">批量删除</a>
								<a class="btn green" href="./carTypeImage?seltree=${session.getAttribute("seltree")!}">返回车型图库</a>
							</div>
						</div>
						<div class="col-md-8">
							<div class="pull-right">
								<@cc.pager1 url="carImageManage?carTypeArr=${carTypeArr}&" currentPage=page totalPage=totalPage rows=rows/>
							</div>
						</div>
					</div>
				</div>
				<input name="clickIsParent" id="clickIsParent" type="hidden" value="${clickIsParent!}">
      			<input name="cartype" id="cartype" type="hidden" value="${carTypeArr!}">
      			</form>
			</div>
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
<script type="text/javascript">
function carTitleEdit(){
	var clickIsParent = $("#clickIsParent").val();
	var cartype = $("#cartype").val()
	if(clickIsParent == "true" || cartype.split(",").length > 1){
		alert("请选择一款车型目录添加主题");
		return;
	}
	document.forms[0].action = "carTitleEdit";
	document.forms[0].submit();
}

function carTitleChange(){
	var dinput = $('input[name="imgTitle"]');
	var flag = false;
	var titleid;
	for(var i =0;i<dinput.length;i++){
		if(dinput[i].checked){
			titleid = dinput[i].value;
			flag = true;
		}
	}
	
	if(!flag){
		alert("请选择修改的主题！");
		return;
	}
	document.forms[0].action = "carTitleChange?editTitleId="+titleid;
	document.forms[0].submit();
}

function deleteTitleBatch(){
	var dinput = $('input[name="imgTitle"]');
	var flag = false;
	for(var i =0;i<dinput.length;i++){
		if(dinput[i].checked){
			flag = true;
		}
	}
	
	if(!flag){
		alert("请选择要删除的主题！");
		return;
	}
	
	if(!confirm("确认要删除吗？")){
		return;
	}
	
	document.forms[0].action = "deleteTitle";
	document.forms[0].submit();
}

function deleteTitle(id){
	if(!confirm("确认要删除吗？")){
		return;
	}
	document.forms[0].action="deleteTitle?imgTitle="+id;
	document.forms[0].submit();
}

</script>
</body>
</html>