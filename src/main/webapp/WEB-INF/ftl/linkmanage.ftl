<#import "common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<button class="btn blue" type="button" href="#linksadd" data-toggle="modal">新增</button>
&nbsp;&nbsp;&nbsp;
<a class="btn green" type="button" href="javascript:makeLinkJs();">生成友情链接</a>
</div>
<div class="row" style="margin-left:15px;margin-top:15px;">
<div class="portlet box blue" >
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>友情链接管理
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 链接名称
									</th>
									<th>
										 链接地址
									</th>
									<th>
										 链接位置
									</th>
									<th>
										 操作
									</th>
								</tr>
								</thead>
								<tbody>
								<#list linkList as link>
								<tr>
								<td>${link.title!}</td>
								<td>${link.link!}</td>
								<td>${link.place!}</td>
								<td><a class="btn blue" type="button" data-toggle="modal" href="#linksuppdate" onclick="setLink(${link.id!},'${link.title!}','${link.link!}','${link.place!}')">修改</a>&nbsp;<a class="btn red" type="button" href="javascript:deleteLink(${link.id!})">删除</a></td>
								</tr>
								</#list>
								</tbody>
								</table>
							</div>
						</div>
						
	</div>
</div>
<div class="modal-scrollable" style="z-index: 10051; display:none" >
<!--添加友情链接-->
	<div id="linksadd" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			<h4 class="modal-title" ><i class="icon-settings"></i>添加友情链接</h4>
		</div>
		<div class="modal-body">
			<div class="row">
				<div class="table-scrollable">
					<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
						<tbody>
							<tr>
							<td>链接名称:</td>
							<td><input type="text"  class="form-control input-inline input-medium " id="linkname1"></td>
							</tr>
							
							<tr>
							<td>链接地址:</td>
							<td><input type="text"  class="form-control input-inline input-medium " id="linkaddress1"></td>
							</tr>
							
							<tr>
							<td>链接位置:</td>
							<td>
							<select class="form-control input-medium input-sm" id="linkplace1">
							<option value="网站首页">网站首页</option>
							<option value="图库首页">图库首页</option>
							<option value="资讯首页">资讯首页</option>
							<option value="报价首页">报价首页</option>
							<option value="价格团购首页">价格团购首页</option>
							<option value="品牌团购首页">品牌团购首页</option>
							</select>
							</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-default" id="close2">关闭</button>
			<a type="button" class="btn blue" href="javascript:addlink();">添加</a>
		</div>
	</div>

<!--修改友情链接-->
<div id="linksuppdate" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			<h4 class="modal-title" ><i class="icon-settings"></i>添加友情链接</h4>
		</div>
		<div class="modal-body">
			<div class="row">
				<div class="table-scrollable">
					<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
						<tbody>
							<input type="hidden" id="linkid"/>
							<tr>
							<td>链接名称:</td>
							<td><input type="text"  class="form-control input-inline input-medium " id="linkname2"></td>
							</tr>
							
							<tr>
							<td>链接地址:</td>
							<td><input type="text"  class="form-control input-inline input-medium " id="linkaddress2"></td>
							</tr>
							
							<tr>
							<td>链接位置:</td>
							<td>
							<select class="form-control input-medium input-sm" id="linkplace2">
							<option value="首页">首页</option>
							<option value="资讯首页">资讯首页</option>
							<option value="新闻首页">新闻首页</option>
							<option value="测评首页">测评首页</option>
							</select>
							</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-default" id="close2">关闭</button>
			<a type="button" class="btn blue" href="javascript:updatelink();">修改</a>
		</div>
	</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
function addlink(){
var title = $("#linkname1").val();
var link = $("#linkaddress1").val();
var place = $("#linkplace1").children('option:selected').val();
if(title==""){
	alert("链接名称不能为空!");
	reutrn;
}
if(link==""){
	alert("链接地址不能为空!");
	reutrn;
}
$.getJSON("linksSave", { title:encodeURI(title),link: encodeURI(link),place: encodeURI(place)}, function(data){
		if(data==1){
			alert("添加成功!");
			window.location.href="linksManage";
		}
		else
			alert("添加失败!");
		
	});
}
function deleteLink(id){
	if(window.confirm("你确定要删除么?")){
		$.getJSON("linksDelete", { id:id}, function(data){
			if(data==1){
				alert("删除成功!");
				window.location.href="linksManage";
			}
			else
				alert("删除失败!");
		});
	}
	
}
function setLink(id,title,link,place){
	$("#linkid").attr("value",id);
	$("#linkname2").attr("value",title);
	$("#linkaddress2").attr("value",link);
	$("#linkplace2").attr("value",place);
}
function updatelink(){
var id = $("#linkid").val();
var title = $("#linkname2").val();
var link = $("#linkaddress2").val();
var place = $("#linkplace2").children('option:selected').val();
if(title==""){
	alert("链接名称不能为空!");
	reutrn;
}
if(link==""){
	alert("链接地址不能为空!");
	reutrn;
}
$.getJSON("linksUpdate", { id:id,title:encodeURI(title),link: encodeURI(link),place: encodeURI(place)}, function(data){
		if(data==1){
			alert("修改成功!");
			window.location.href="linksManage";
		}
		else
			alert("修改失败!");
		
	});
}
function makeLinkJs(){
	$.getJSON("makeLinkJs", function(data){
		if(data==1)
			alert("生成成功!");
		else
			alert("生成失败!");
		
	});
}
</script>
</body>
</html>