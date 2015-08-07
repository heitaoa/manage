<#import "common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<button class="btn blue" type="button" id="add">新增</button>
</div>

<div class="row" style="margin-left:15px;margin-top:10px;">
<form method="post" action="SaleFavoredmanage">
<input id="page" name="page" type="hidden" value="${page!"1"}" />
<input name="state" type="hidden" value="1" />
<input name="stationId" id="stationIdx" type="hidden" value="${stationId!}" />
<table>
<tr>
<td><span>请输入标题:</span></td>
<td><input type="text"  class="form-control input-inline input-small" value="${keywords!}"  id="keywords" name="keywords"></td>
<td><span>&nbsp;&nbsp;&nbsp;分站:</span></td>
<td>
<select class="form-control input-small input-sm" id="stationId" >
			 <option value="-1">所有分站</option>
       		 <option value="1">上海站</option>
       		 <option value="2">北京站</option>
       		 <option value="3">广州站</option>
       		 <option value="4">南京站</option>
       		 <option value="5">武汉站</option>
       		 <option value="6">成都站</option>
       		 <option value="7">沈阳站</option>
       		 <option value="8">大连站</option>
       		 <option value="9">合肥站</option>
       		 <option value="10">杭州站</option>
       		 <option value="11">苏州站</option>
       		 <option value="12">徐州站</option>
</select>
</td>
<td><span>&nbsp;&nbsp;&nbsp;品牌:&nbsp;&nbsp;&nbsp;</span></td>
<td>
<select class="form-control input-small input-sm" name="pinpai" id="pinpai">

</select>
</td>
<td><span>&nbsp;&nbsp;&nbsp;类型:&nbsp;&nbsp;&nbsp;</span></td>
<td>
<select class="form-control input-small input-sm" name = "type" id="type" >
<option value="0">团购</option>
<option value="1">特卖惠</option>
</select>
</td>
<td><span>&nbsp;&nbsp;&nbsp;是否向前台展示:&nbsp;&nbsp;&nbsp;</span></td>
<td>
<select class="form-control input-small input-sm" name = "isdelete" id="isdelete">
			<option value="-1">全部</option>
       		 <option value="0">显示</option>
       		 <option value="1">隐藏</option>
</select>
</td>
<td>&nbsp;&nbsp;&nbsp;<button class="btn blue" type="button" id="search">查询</button></td>
</tr>
</table>
</form>
</div>

<div class="row" style="margin-left:0px;margin-top:10px;">
<div class="portlet box blue" style="margin-left:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>特卖惠/团购信息
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
										 选择
									</th>
									<th>
										 分站
									</th>
									<th>
										 标题
									</th>
									<th>
										 类型
									</th>
									<th>
										渠道
									</th>
									<th>
										 车系
									</th>
									<th>
										开始时间
									</th>
									<th>
										 结束时间
									</th>
									<th>
										 状态
									</th>
									<th>
										操作
									</th>
									<th>
										删除
									</th>
									<th>
										首页内容
									</th>
								</tr>
								</thead>
								<tbody>
								<#list carGroupbuyList as carGroup>
              
								  <tr>
								  	<td align="left">
								  	<input type="checkbox" name="checkL" class="checkboxes" idx="${carGroup.id!}">
								  	</td>  
								  	<td align="left">${carGroup["siteName"]!}</td>
					                <td align="left">${carGroup["title"]!}</td>
					                <td align="left"><#if carGroup.buy_type=0>团购<#else>特卖惠</#if></td>
					                <td align="left">${carGroup["iway"]!}</td>
					                <td align="left">${carGroup["catalogname"]!}</td>
					                <td align="left">${carGroup["begdate"]!}</td>
					                <td align="left">${carGroup["enddate"]!}</td>
					                 
					                 <td align="left"><#if carGroup.isdelete =="0" >显示<#else>隐藏</#if></td>
					                <td align="left">
					                <a href="javascript:updateDate(${carGroup['id']})" class="btn_orange-a">修改</a>&nbsp;&nbsp;
					                </td>
					                <td><a href="javascript:deleteGroup('${carGroup.id!}');"  class="btn_orange-a">删除</a></td>
					                 <td align="left"><a href="javascript:showPre('${carGroup.id!}');"  class="btn_orange-a">查看</a></td>
					                 
					              </tr>
					              </#list>
								<tr>
		                          <td colspan=12 style="text-align:center;"><@c.calcPageByJs "toPage", page, pages/></td>
		                         </tr>
								</tbody>
								</table>
							</div>
							<input type="checkbox" id="selectAll" class="group-checkable" data-set=".checkboxes" />&nbsp;&nbsp;全选
							<input type="button" class="btn blue" value="显示" onclick="showOrHide(0)"/>&nbsp;&nbsp;
							<input type="button" class="btn blue" value="隐藏" onclick="showOrHide(1)"/>
						</div>
						
	</div>
<div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function(){
var level="${userInfo.ulevel!}";
if(level.indexOf("5")!=-1){
	$("#stationId").prop('disabled',true);
}
$.ajax({
    		url : 'getCarBrand',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
	    		$("#pinpai").append("<option value='-1'>所有品牌</option>");
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html;
					if(carBrand[i].iway=="${pinpai!}")
					html='<option value='+carBrand[i].iway+' selected="true">'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
					html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
				}
				
    		}
		});
var type = document.getElementById("type");
for(var i=0;i<type.options.length;i++) {  
            if(type.options[i].value == ${type!}) {  
                type.options[i].selected = true;  
                break;  
            } }
var stationId = document.getElementById("stationId");
//alert(${stationId!});
for(var i=0;i<stationId.options.length;i++) {  
            if(stationId.options[i].value == ${stationId!}) {  
                stationId.options[i].selected = true;  
                break;  
			}
}

var isdelete = document.getElementById("isdelete");
for(var i=0;i<isdelete.options.length;i++) {  
            if(isdelete.options[i].value == ${isdelete!}) {  
                isdelete.options[i].selected = true;  
                break;  
			}
}
$("#add").on("click", function() {
	document.forms[0].action = "SaleFavoredadd";
	document.forms[0].submit();
});

$("#search").on("click", function() {
	$("#page").val(1);
	document.forms[0].action = "SaleFavoredmanage";
	document.forms[0].submit();
});
/*
$("#type").change(function(){	
	var type = $(this).children('option:selected').val();
	$("#page").val(1);
	document.forms[0].action = "SaleFavoredmanage";
	document.forms[0].submit();
});
*/

$("#stationId").change(function(){	
	var type = $(this).children('option:selected').val();
	$("#stationIdx").val(type);
});

//全选
$("#selectAll").click(function(){
 	var checked = $(this).prop("checked");
 	var set = jQuery(this).attr("data-set");
            jQuery(set).each(function () {
                if (checked)
                    $(this).attr("checked", true);
                else
                    $(this).attr("checked", false);
            });
   jQuery.uniform.update(set);
              
});

});
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].submit();
}
function updateDate(id){
    	document.forms[0].action = "SaleFavoredupdate?id="+id;
		document.forms[0].submit();
}
function showOrHide(isDel){
var ids ='';
 $("[name = checkL]:checkbox").each(function () {
    if ($(this).is(":checked")) {
       ids += $(this).attr("idx")+"#";
       }
});
if(ids==""){
alert("请勾选数据!")
return;
}
$.ajax({
						url:"updateGroupState",
						type:'POST',
						dataType : 'jsonp',
						data :{"ids":ids,"state":isDel},
    					jsonp:'jsonpcallback',
						success:function(data){						
								alert("修改成功!")
						}
});
}
function showPre(id){
window.open('showpre?idx='+id)
}
function deleteGroup(id){
if(confirm("确定要删除该数据吗？"))
	window.location.href = "updateGroupState2?id="+id;
}
</script>
</body>
</html>