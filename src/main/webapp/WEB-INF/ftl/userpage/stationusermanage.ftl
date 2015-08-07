<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">

<@c.html_head></@c.html_head>
<@c.html_body>
<!--查询选项-->
<div class="row" style="margin-left:15px;">
<div style="float:left">
	<form action = "stationusermanage" method="POST">
	用户查询:<input type="text" class="form-control input-small input-inline" name="name" value="${name!}"/>&nbsp;<button class="btn blue" type="submit" ">查询</button>
	</form>
</div>
<div style="float:left;margin-left:300px;">
	<a href="addstationuser" class="btn blue input-inline">新增人员</a>
</div>
</div>
<div class="row" style="margin-left:15px;margin-top:10px;">
<div class="portlet box blue">
<div class="portlet-title">
	<div class="caption">
		<i class="fa fa-cogs"></i>分站用户管理
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
				 用户编号
			</th>
			<th>
				 用户姓名
			</th>
			<th>
				所属分站
			</th>
			<th>
				所属品牌
			</th>
			<th>
				 用户权限
			</th>
			<th>
				操作
			</th>
		</tr>
		</thead>
		<tbody id="itemContainer">
		<#list userList as user>
          <tr>
            <td style="text-align:left;">${user["userid"]!}</td>
            <td style="text-align:left;">${user["user_name"]!}</td>
            <td style="text-align:left;">${user["org_name"]!}</td>
            <td style="text-align:left;">${user["brands"]!}</td>
            <td style="text-align:left;">${user["ulevel"]!}</td>
            <td style="text-align:left;">
            <a href="gotoupdatestationUser?id=${user["id"]!}" class="btn blue">修改</a>
            <a href="javascript:deleteUser('${user["id"]!}')" class="btn red">删除</a>
            </td>
          </tr>
  		</#list>
          <tfoot>
            	<tr>
            		<td colspan="6" style="text-align:center;">
            			<!-- navigation holder -->
      					<div class="holder"></div>
            		</td>
            	</tr>
            </tfoot>
		</tbody>
		</table>
	</div>
</div>
</div>

</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script src="${admin_che_url}js/jPages.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("div.holder").jPages({
	containerID: "itemContainer",
	perPage: 10,
	delay : 0
});
});
function deleteUser(id){
	if(window.confirm("你确定要删除么?")){
		$.getJSON("deleteUser", { id:id}, function(data){
			if(data>0)
			{
				alert("删除成功!");
				window.location.href="stationusermanage";
			}
			else
				alert("删除失败!");
		});
	}
}
</script>
</body>
</html>