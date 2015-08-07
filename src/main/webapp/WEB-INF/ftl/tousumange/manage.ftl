<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style>
.data-table1 {border-collapse:collapse; margin-left:15px;}
.data-table1 td {padding:5px;}
</style>
<!--查询选项-->
<div class="row">
<form method="POST">
<input id="page" name="page" type="hidden" value="${page!"1"}" />
 <table class="data-table1">
  <tr>
  	<td>
  		<span>状态：</span>
  	</td>
  	<td>
  		<select class="form-control input-small" name="state" id="state">
	      <option value="-2" <#if state==-2>selected=true</#if>>全部</option>
	      <option value="0" <#if state==0>selected=true</#if>>待审核</option>
	      <option value="1" <#if state==1>selected=true</#if>>已审核</option>
	      <option value="2" <#if state==2>selected=true</#if>>处理结束</option>
	      <option value="-1" <#if state==-1>selected=true</#if>>已删除</option>
	     </select>
  	</td>
  	
  	<td>
  		<span>开始：</span>
  	</td>
  	<td>
  		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
  	</td>
  	
  	<td>
  		<span>结束：</span>
  	</td>
  	<td>
  		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
  	</td>
  	
  	<td>
  		<span>姓名：</span>
  	</td>
  	<td>
  		 <input type="text"  class="form-control input-inline input-small " name="name"  value="${name!}">
  	</td>
  	
  	<td>
  		<span>手机：</span>
  	</td>
  	<td>
  		 <input type="text"  class="form-control input-inline input-small " name="phone"  value="${phone!}">
  	</td>
  	
  	<td>
  		<span>关键字：</span>
  	</td>
  	<td>
  		 <input type="text"  class="form-control input-inline input-small " name="keyword"  value="${keyword!}">
  	</td>
  	
  </tr>
  
  <tr>
  	<td>
  		<span>品牌：</span>
  	</td>
  	<td>
	     <select class="form-control input-small" name="brandId" id="pinpai">
	     	<option value="-1">选择品牌</option>
	  	 </select>
  	</td>
  	
  	<td>
  		<span>车系：</span>
  	</td>
  	<td>
	    <select class="form-control  input-small" name="chexiId" id="chexi">
	  		<option value="-1">选择车系</option>
	  	</select>
  	</td>
  	
  	<td>
  		<span>省份：</span>
  	</td>
  	<td>
	     <select class="form-control input-small" name="prov" id="prov">
	  		<option value="-1">选择地区</option>
	  	</select>
  	</td>
  	
  	<td>
  		<span>城市：</span>
  	</td>
  	<td>
	     <select class="form-control input-small" name="city" id="city">
		  	<option value="-1">选择城市</option>
		  </select>
  	</td>
  	
  	<td>
  		<span></span>
  	</td>
  	
  	<td>
  	<button class="btn blue" type="button" id="search">查询</button>&nbsp;
  	<button class="btn blue" type="button" id="batchDownload">批量导出</button>
  	</td>
  </tr>
 </table>
</form>
</div>
<!--中部-->
<div class="row" >
<table class="data-table1">
<tr>
	<td>
		<select class="form-control input-small　" name="state2" id="state2">
	      <option value="0">待审核</option>
	      <option value="1">已审核</option>
	      <option value="2">处理结束</option>
	     </select>
	</td>
	<td>
		<button class="btn blue" type="button" id="batchSave">批量审核</button>
		
	</td>
</tr>
</table>
</div>
<!--数据展示-->
<div class="row">
	<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;人数统计:<font color="red">${count!}</font></strong>
</div>
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>投诉信息
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
										<input type="checkbox" id="selectAll" class="group-checkable" data-set=".checkboxes" />&nbsp;&nbsp;全选
									</th>
									
									<th>
										 姓名
									</th>
									<th>
										手机号码
									</th>
									<th>
										 地区
									</th>
									<th>
										投诉主题
									</th>
									<th>
										 投诉时间
									</th>
									
									<th>
										 状态
									</th>
									
									<th>
										操作
									</th>
								</tr>
								</thead>
								<tbody>
								
								<#list tousuList as tousu>
		                          <tr>
		                          	<td style="text-align:left;">
		                          	<input type="checkbox" name="checkL" class="checkboxes" idx="${tousu.id!}">
		                          	</td>
		                            <td style="text-align:left;">${tousu.name!}</td>
		                            <td style="text-align:left;">${tousu.phone!}</td>
		                            <td style="text-align:left;">${tousu.prov!}>>${tousu.city!}</td>
		                            <td style="text-align:left;">${tousu.title!}</td>
		                            <td style="text-align:left;">${tousu.addtime!}</td>
		                            <td style="text-align:left;">${tousu.state!}</td>          
		                            <td style="text-align:left;">
		                            <a href="http://tousu.315che.com/tousudetail/${tousu.id!}/" target="_blank">查看详细</a>
		                            <form method="POST" action="tousuDownload">
		                            <a class="btn blue" data-toggle="modal" href="#showdiv" onclick="searchTousu(${tousu.id!})">修改</a>
		                            <a class="btn red" data-toggle="modal" href="#showdiv2" onclick="queryTousuComment(${tousu.id!})">跟踪</a>
		                            <input type="hidden" name="tousuid" value="${tousu.id!}">
		                            <input type="submit" class="btn green" value="导出" />
		                            </form>
		                            </td>
		                          </tr>
                          		</#list>
								<tr>
		                          <td colspan=7 style="text-align:center;">
		                          <@c.calcPageByJs "toPage", page, pages/>
		                          </td>
		                         </tr>
								</tbody>
								</table>
							</div>
						</div>
					</div>
</div>

<div class="modal-scrollable" style="z-index: 10051; display:none" >
<div id="showdiv" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>投诉详情</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<input type="hidden" id="did" name="aid">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td>姓名：</td>
							<td id="tname"></td>
							<td>手机号：</td>
							<td id="tphone"></td>
							<td>邮箱：</td>
							<td id="temail"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>身份证：</td>
							<td id="tport"></td>
							<td>地区：</td>
							<td id="tdizhi"></td>
							<td>详细地址：</td>
							<td id="taddress"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>车型：</td>
							<td id="tcarinfo"></td>
							<td>车牌：</td>
							<td id="thao"></td>
							<td>里程：</td>
							<td id="tlc"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>发动机号：</td>
							<td id="tfdj"></td>
							<td>车架号：</td>
							<td id="tcj"></td>
							<td>购买时间：</td>
							<td id="tbuydate"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>4S店：</td>
							<td id="tssssname"></td>
							<td>4S店电话：</td>
							<td id="tsssstel"></td>
							<td>车辆状态：</td>
							<td id="tcarstate"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>投诉对象：</td>
							<td id="tproblem"></td>
							<td>投诉诉求：</td>
							<td id="tsuqiu"></td>
							<td>投诉时间：</td>
							<td id="taddtime"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>标题：</td>
							<td colspan=5 >
							<input type="text" id="ttitle"  class="form-control input-large input-inline" name="endDate">
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>投诉内容：</td>
							<td colspan=5 >
							<textarea id="tcontent"  class="form-control" rows="4"></textarea>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>图片：</td>
							<td colspan=5 id="timage"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>流程状态：</td>
							<td colspan=5 >
								<select class="form-control input-small"  id="tstate">
							      <option value="0">待审核</option>
							      <option value="1">已审核</option>
							      <option value="2">处理结束</option>
							       <option value="-1">删除</option>
							     </select>
							</td>
						</tr>
						<tr class="gradeX odd" role="row">
							<input type = "hidden" id="ttousuid" />
							<td colspan=6 style=" text-align: center;">
							<button type="button" class="btn green" onclick="save();">提交</button>
							<button type="button" data-dismiss="modal" class="btn red" id="close2">关闭</button>
							</td>
						</tr>				
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
	</div>
</div>

<div id="showdiv2" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>回复详情</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<input type="hidden" id="did" name="aid">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td colspan=2>
								<table id="tousucomment">
									
								</table>
							</td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td>请输入回复内容</td>
							<td><textarea id="comment"  class="form-control" rows="4"></textarea></td>
						</tr>
						<tr class="gradeX odd" role="row">
							<input type = "hidden" id="commentId" />
							<td colspan=6 style=" text-align: center;">
							<button type="button" class="btn green" onclick="saveTousuComment();">回复</button>
							<button type="button" data-dismiss="modal" class="btn red" id="close3">关闭</button>
							</td>
						</tr>				
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
	</div>
</div>



</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$.ajax({
		url : 'queryCarInfo?fatherid=0',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==${brandId!})
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#pinpai").append(html);
				
			}
		}
});

$.ajax({
		url : 'queryCarInfo?fatherid=${brandId!}',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==${chexiId!})
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#chexi").append(html);
				
			}
		}
});

$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${prov!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov").append(html);
					
				}
    		}
		});



		
$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${prov!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov").append(html);
					
				}
    		}
		});
$.ajax({
    		url : 'getCityInfo?city='+${prov!},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${city!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city").append(html);
				}
    		}
		});
		
		$("#pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#chexi").empty();
		$("#chexi").append("<option value='-1'>请选择系列</option>");
		$.ajax({
    		url : 'queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexi").append(html);
				}
    		}
		});
	
	});
	
	$("#prov").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city").empty();
		$("#city").append("<option value='-1'>请选择城市</option>");
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
$("#search").on("click", function() {
	$("#page").val(1);
	document.forms[0].action = "tousu_manage";
	document.forms[0].submit();
});
//批量導出
$("#batchDownload").on("click", function() {
	document.forms[0].action = "tousuBatchDownload";
	document.forms[0].submit();
});

	function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].action = "tousu_manage";
	document.forms[0].submit();
}

function searchTousu(tousuid){
	$.ajax({
		url : 'queryTousuDetail?tousuid='+tousuid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		var res = data[0];
    		$("#tname").html(res.name);
    		$("#tphone").html(res.phone);
    		$("#temail").html(res.email);
    		$("#tport").html(res.port);
    		$("#tdizhi").html(res.prov +" >> "+res.city);
    		$("#taddress").html(res.address);
    		$("#tcarinfo").html(res.pinpai+" >> "+res.chexi);
    		$("#thao").html(res.hao);
    		$("#tlc").html(res.lc);
    		$("#tfdj").html(res.fdj);
    		$("#tcj").html(res.cj);
    		$("#tbuydate").html(res.buydate);
    		$("#tssssname").html(res.ssssname);
    		$("#tsssstel").html(res.sssstel);
    		$("#tcarstate").html(res.carstate);
    		$("#tproblem").html(res.problem);
    		$("#tsuqiu").html(res.suqiu);
    		$("#taddtime").html(res.addtime);
    		$("#ttitle").attr("value",res.title);
    		$("#tcontent").attr("value",res.content);
    		$("#ttousuid").attr("value",res.id)
    		var imgList = res.images;
    		var html = '';
    		for(var i = 0;i < imgList.length;i++){
    			html += '<a href="'+imgList[i]+'" target="_blank"><img src="'+imgList[i]+'" width="60" height="60"></a>&nbsp;';
    		
    		}
    		$("#timage").html(html);
    		
    		var type = document.getElementById("tstate");
			for(var i=0;i<type.options.length;i++) {  
            if(type.options[i].value == res.state) {  
                type.options[i].selected = true;  
                break;  
            } }
		}
	});

}
//保存投诉更改
function save(){
	var title = $("#ttitle").val();
	if($.trim(title)==""){
		alert("标题不能为空!");
		return;
	}
	var content = $("#tcontent").val();
	if($.trim(content)==""){
		alert("内容不能为空!");
		return;
	}
	var tousuid = $("#ttousuid").val();
	var state = $("#tstate").val();
	$.post(
		"tousuUpdate",
		{tousuid:tousuid,title:title,content:content,state:state},
		function(data){
			if(data==1){
				alert("修改成功!");
				$("#close2").trigger("click");
			}
			else
				alert("修改失败");
		});

}
//查询投诉回复
function queryTousuComment(tousuid){
    $("#commentId").attr("value",tousuid);
    $("#tousucomment").html('');
    $("#tousucomment").append('<tr><th width="20%"><h2>时间</h2></th><th width="80%"><h2>回复内容</h2></th></tr>');
	$.ajax({
		url : 'queryTousuComment?tousuid='+tousuid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		//tousucomment
    		
    		for(var i=0;i<data.length;i++){
    			var html  = '<tr>';
    			var newTime = new Date(data[i].addtime.time); //就得到普通的时间了
    			 var time = newTime.getFullYear() + '-' +(newTime.getMonth()+1) + '-' +newTime.getDate() + ' ' +newTime.getHours()+':'+newTime.getMinutes()+':'+newTime.getSeconds();
    			 
    			 html += '<td>'+time+'</td>';
    			 html += '<td>'+data[i].content+'</td>';
    			 html += '</tr>';
    			$("#tousucomment").append(html);
    		
    		}
    		
		}
	});

}
//保存投诉回复
function saveTousuComment(){
	var tousuid = $("#commentId").attr("value");
	var comment = $("#comment").val(); 
	if($.trim(comment)==""){
		alert("请输入回复内容!");
		return;
	}
	$.post(
		"saveTousuComment",
		{tousuid:tousuid,comment:comment},
		function(data){
			if(data > 0){
				alert("操作成功!");
				//queryTousuComment(tousuid);
				$("#close3").trigger("click");
				$("#comment").val("");
			}
			else
				alert("操作失败");
	});
	

}
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
//批量审核
$("#batchSave").click(function(){
	var state = $("#state2").val();
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
	$.post(
		"batchUpdateTousu",
		{"ids":ids,"state":state},
		function(data){						
			alert("修改成功!");
			$("#search").trigger("click");
		}
	);          
});

</script>
</body>
</html>