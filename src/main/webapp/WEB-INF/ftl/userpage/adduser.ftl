<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
<div class="portlet box blue"  style="margin-left:15px;">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>人员添加
		</div>
		<div class="tools">
			<a class="collapse" href="javascript:;">
			</a>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
		<form class="form-horizontal" action="#">
			<input type="hidden" id="userid">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-3 control-label">人员:</label>
					<div class="col-md-4">
						<input type="text" class="form-control input-medium input-inline" readOnly="true" id="userinfo"><a class="btn blue" data-toggle="modal" href="#show1">添加</a>
						<span class="help-block">
						密码同财务系统! </span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">权限:</label>
					<div class="col-md-4">
						<div class="input-group">
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="0" name="level">系统管理员</div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="1" name="level">大客户销售</div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="2" name="level">销售</div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="3" name="level">客服</div>
						<div class="chearfix"></div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="6" name="level">分站管理员</div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="4" name="level">总站编辑</div>
						<div style="width:100px; float:left;"><input type="checkbox"  class="checkboxes" value="5" name="level">分站编辑</div>
						</div>
					</div>
				</div>
				
				
				<div class="form-group" id="quanxian" >
					<label class="col-md-3 control-label">权限细分:</label>
					<div class="col-md-4">
						<div class="portlet-body">
							<div class="zTreeBg" style="height:300px;overflow-x:hidden;overflow-y:auto;">
			                  <ul id="treeMenu" class="ztree"></ul>
			                </div>
						</div>
					</div>
				</div>
				
				
				<div class="form-group" id="diyu" style="display:none;" >
					<label class="col-md-3 control-label">地域:</label>
					<div class="col-md-4">
						<div class="input-group">
						<select class="form-control input-small input-sm input-inline"  id="prov">
								<option value="-1">所有省份</option>
						</select>
						<select class="form-control input-small input-sm input-inline"  id="city">
								<option value="-1">所有城市</option>
						</select>
						</div>
					</div>
				</div>
				
				<div class="form-group" id="pingpai1" style="display:none;" >
					<label class="col-md-3 control-label">选择品牌:</label>
					<div class="col-md-4">
						<div class="input-group">
						<select class="form-control input-medium input-sm "  id="barndx">
								<option value="-1">所有品牌</option>
						</select>
						</div>
					</div>
				</div>
				
				<div class="form-group" id="pingpai2" style="display:none;" >
					<label class="col-md-3 control-label">拥有品牌:</label>
					<div class="col-md-4">
						<div class="input-group">
						<select id="barnds" class="form-control input-medium input-sm " style="width:180px;height:300px;" multiple =true ondblclick="deleteBrand()">
                 		</select>
						</div>
					</div>
				</div>
				
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn blue" type="button" onClick="saveUser();">添加</button>
					</div>
				</div>
			</div>
		</form>
		<!-- END FORM-->
	</div>
</div>
</div>
<div class="modal-scrollable" style="z-index: 10051; display:none" >
<!--用户选择-->
<div id="show1" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -148px;">
	<div>
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>用户选择</h4>
	</div>
	<div class="modal-body">
		<div class="row">
		姓名:<input type="text" class="form-control input-small input-inline" id="fname"/>
		分站:<select class="form-control input-small input-sm input-inline" id="fsite">
			<#list siteList as site>
			<option value="${site.id!}">${site.name!}</option>
			</#list>
			</select>
		<a href="javascript:search();" class="btn blue" >查询</a>
		</div>
		<div class="row">
			<div class="table-scrollable">

				<table id="sample_1" class="table" >
					<thead>
					<tr>
						<th>
							 用户名
						</th>
						<th>
							 姓名
						</th>
						<th>
							分站
						</th>
						<th>
							选择
						</th>
					</tr>
					</thead>
					<tbody id="itemContainer">

					</tbody>
					<tfoot>
            		<tr>
            		<td colspan="4" style="text-align:center;">
            		<a onclick="topre()" title="Prev" href="javascript:void(0);">上一页</a>
            		<a onclick="tonext()" title="Prev" href="javascript:void(0);">下一页</a>
            		</td>
            	</tr>
            </tfoot>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default" id="close2">关闭</button>
	</div>
</div>


</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
createTree('treeMenu');
function createTree(treeMenu){
	var setting = {
			view: {
				showIcon: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			check:{
				enable:true
			
			}
			
	};
	$.getJSON("initULevelTree",function(data){
		$.fn.zTree.init($("#"+treeMenu), setting, data);
	});

}

function getCheckedNodes(){
	var nodesList ='';
	var treeObj = $.fn.zTree.getZTreeObj("treeMenu");//树控件
	var nodes = treeObj.getCheckedNodes(true);//获取所有选择的节点
	for(var i = 0;i < nodes.length;i++){
		nodesList += nodes[i].id +',';
	}
	return nodesList;
}

var page = 1;
var fdate ;
function search(){
var fsite = $("#fsite").children('option:selected').val();
var fname = $("#fname").val();
$.ajax({
    		url : 'getFinanceUser',
    		dataType : 'jsonp',
    		data :{siteId:fsite,name:encodeURI(fname)},
    		jsonp:'jsonpcallback',
    		success : function(data){
    			fdate = data;
    			page=1;	
    			var max = 5;
    			var html = '';
    			if(data.length<6)
    				max = data.length;
				for(var i =0 ;i<max;i++)
				{
					html+='<tr>';
					html+='<td>'+data[i].USER_CODE+'</td>';
					html+='<td>'+data[i].USER_NAME+'</td>';
					html+='<td>'+data[i].ORG_NAME+'</td>';
					html+='<td><a class="btn blue input-sm" href="javascript:selectUser(&quot;'+fdate[i].USER_CODE+'&quot;,&quot;'+fdate[i].USER_NAME+'&quot;)">选择</a></td>';
					html+='</tr>';
				}
				$("#itemContainer").html(html);
    		}
		});
}
function topre(){
	page = page-1;
	if(page<1)
		page=1;
	var html = '';
	beginIndex = (page-1)*5;
	endIndex = beginIndex+5;
	if(fdate.length<endIndex)
		endIndex = fdate.length;
	for(var i =beginIndex ;i<endIndex;i++)
	{
		html+='<tr>';
		html+='<td>'+fdate[i].USER_CODE+'</td>';
		html+='<td>'+fdate[i].USER_NAME+'</td>';
		html+='<td>'+fdate[i].ORG_NAME+'</td>';
		html+='<td><a class="btn blue input-sm" href="javascript:selectUser(&quot;'+fdate[i].USER_CODE+'&quot;,&quot;'+fdate[i].USER_NAME+'&quot;)">选择</a></td>';
		html+='</tr>';
	}
	$("#itemContainer").html(html);
	
}
function tonext(){
	var max = parseInt(fdate.length/5);
	if(fdate.length%5!=0)
		max = max+1;
	page = page+1;
	if(page>max)
		page=max;
	var html = '';
	beginIndex = (page-1)*5;
	endIndex = beginIndex+5;
	if(fdate.length<endIndex)
		endIndex = fdate.length;
	for(var i =beginIndex ;i<endIndex;i++)
	{
		html+='<tr>';
		html+='<td>'+fdate[i].USER_CODE+'</td>';
		html+='<td>'+fdate[i].USER_NAME+'</td>';
		html+='<td>'+fdate[i].ORG_NAME+'</td>';
		html+='<td><a class="btn blue input-sm" href="javascript:selectUser(&quot;'+fdate[i].USER_CODE+'&quot;,&quot;'+fdate[i].USER_NAME+'&quot;)">选择</a></td>';
		html+='</tr>';
	}
	$("#itemContainer").html(html);
}
function selectUser(id,name){
	$.ajax({
    		url : 'checkUser?userid='+id,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
				if(data==0){
					$("#userinfo").val(id +"   "+name);
					$("#userid").val(id);
					$("#close2").trigger("click")
				}
				else{
					alert("该用户已存在!");
				}	    		
    		}
		});

}
function deleteBrand(){
var value = $("#barnds").children('option:selected').val();

var str = "barnds option[value='"+value+"']";
	//alert(str);
 $("#"+str).remove();
}
$(document).ready(function(){
$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov").append(html);
					
				}
    		}
		});
$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#barndx").append(html);
				}
    		}
		});
$("#prov").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city").empty();
		$("#city").append("<option value='-1'>所有城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city").append(html);
				}
    		}
		});
	
	});
$("#barndx").change(function(){	
	var brandname = $(this).children('option:selected').val();
	var html ='';
	if(brandname!=-1)
	{
		html = '<option value='+brandname+'>'+brandname+'</option>'
		$("#barnds").append(html);
	}
	});
$("[name = level]").bind("click", function () {
	var value ="";
	 $('input:checkbox[name=level]:checked').each(function(i){
        value += $(this).attr("value")+"#";
      });
      /*
   	if(value.indexOf("0")!=-1&&(value.indexOf("1")!=-1||value.indexOf("1")!=-1||value.indexOf("2")!=-1||value.indexOf("3")!=-1||value.indexOf("4")!=-1||value.indexOf("5")!=-1||value.indexOf("6")!=-1)){
   		alert("系统管理员只能设置一个权限!");
   		return;
   	}
   	*/
   	if(value.indexOf("1")!=-1&&(value.indexOf("2")!=-1||value.indexOf("3")!=-1||value.indexOf("6")!=-1)){
   		alert("大客户销售不能拥有客服，销售，分站管理员权限!");
   		return;
   	}
   	if(value.indexOf("2")!=-1&&value.indexOf("3")!=-1){
   		alert("客服销售只能设置一个权限!");
   		return;
   	}
    if(value.indexOf("1")!=-1||value.indexOf("2")!=-1||value.indexOf("3")!=-1||value.indexOf("6")!=-1){
    	$("#diyu").css({display:"block"});
    	$("#pingpai1").css({display:"block"});
    	$("#pingpai2").css({display:"block"});
    }else{
    	$("#diyu").css({display:"none"});
    	$("#pingpai1").css({display:"none"});
    	$("#pingpai2").css({display:"none"});
    }
    	
});


});
function saveUser(){
	
	var userid = $("#userid").val();
   	if(userid==""){
   		alert("请选择用户!");
   		return;
   	}
	var value ="";
	 $('input:checkbox[name=level]:checked').each(function(i){
        value += $(this).attr("value")+",";
      });
     if(value==""){
     	alert("请指定权限!");
     	return;
     }
     /*
   	if(value.indexOf("0")!=-1&&(value.indexOf("1")!=-1||value.indexOf("1")!=-1||value.indexOf("2")!=-1||value.indexOf("3")!=-1||value.indexOf("4")!=-1||value.indexOf("5")!=-1||value.indexOf("6")!=-1)){
   		alert("系统管理员只能设置一个权限!");
   		return;
   	}
   	*/
   	if(value.indexOf("1")!=-1&&(value.indexOf("2")!=-1||value.indexOf("3")!=-1||value.indexOf("6")!=-1)){
   		alert("大客户销售不能拥有客服，销售，分站管理员权限!");
   		return;
   	}
   	if(value.indexOf("2")!=-1&&value.indexOf("3")!=-1){
   		alert("客服销售只能设置一个权限!");
   		return;
   	}
   	var array = "";
	  var brands = document.getElementById("barnds");
	  for(var i =0 ;i<brands.options.length;i++)
	  {
	  		if(i==brands.options.length-1)
	  			array +=brands.options[i].value;
	  		else
	  			array +=brands.options[i].value+",";
	  }
	if(array=="")
		array = "-1";
	
	var prov = $("#prov").val();
	var city = $("#city").val();
	
	var detail = getCheckedNodes();
	$.getJSON("saveUser", { userid:userid,level: encodeURI(value),prov: prov,city:city,brands:encodeURI(array),detail:detail}, function(data){
		alert("添加成功!");
		window.location.href="usermanage";
	});
	

}
</script>
</body>
</html>