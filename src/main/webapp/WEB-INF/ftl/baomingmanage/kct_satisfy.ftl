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
<input id="flag" name="flag" type="hidden" value="1" />
 <table class="data-table1">
  <tr>
  	<td>
  		<span>推广编号：</span>
  	</td>
  	<td  colspan=3>
  		<select class="form-control input-medium input-inline" name="pro_num" id="tuiguang">
 				<#list tuiguangList as tuiguang>
		     	 <option value="${tuiguang.pro_num}"  <#if pro_num == tuiguang.pro_num >selected=true</#if>>${tuiguang.pro_num}(${tuiguang.acti_name})</option>
		       </#list>
		     </select>
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
  	
  	
  	
  </tr>
  
  <tr>
  	<td>
  		<span>品牌：</span>
  	</td>
  	<td>
	     <select class="form-control input-small" name="iway" id="pinpai">
	     	<option value="">选择品牌</option>
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
  		<span>状态：</span>
  	</td>
  	<td>
  		<select class="form-control input-small" name="state" id="state">
		  	<option value="-1">选择状态</option>
		  	<option value="0" <#if state == 0 >selected=true</#if>>未调查</option>
		  	<option value="1" <#if state == 1 >selected=true</#if>>已调查</option>
		  </select>
  	</td>
  	
  	<td>
  	<button class="btn blue" type="button" id="search">查询</button>&nbsp;
  	
  	</td>
  </tr>
 </table>
</form>
</div>
<!--中部-->

<!--数据展示-->
<div class="row">
	<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;人数统计:<font color="red">${count!}</font></strong>
</div>
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>看车团满意度调查表
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
										序号
									</th>
									
									<th>
										 姓名
									</th>
									<th>
										手机号码
									</th>
									<th>
										报名地区
									</th>
									<th>
										 是否到店
									</th>
									<th>
										是否成交
									</th>
									<th>
										 成交车型
									</th>
									
									<th>
										 是否接受调查
									</th>
									
									<th>
										 未到店原因
									</th>
									
									<th>
										 失销原因
									</th>
									
									<th>
										 服务满意度
									</th>
									
									<th>
										 建议与意见
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
								<#if tousuList??>
								<#list tousuList as tousu>
		                          <tr>
		                          	<td style="text-align:left;">
		                          	${(page-1)*rows+tousu_index+1}
		                          	</td>
		                            <td style="text-align:left;">${tousu.name!}</td>
		                            <td style="text-align:left;">${tousu.phone!}</td>
		                            <td style="text-align:left;">${tousu.prov!}>>${tousu.city!}</td>
		                            <td style="text-align:left;"><#if tousu.is_reach == '0'>否<#else>是</#if></td>
		                            <td style="text-align:left;"><#if tousu.is_trans == '0'>否<#else>是</#if></td>
		                            <td style="text-align:left;">${tousu.catalogname!}</td>
		                            <td style="text-align:left;"><#if tousu.research == '0'></#if>
		                            <#if tousu.research == '1'>是</#if>
		                            <#if tousu.research == '2'>是</#if></td>
		                            <td style="text-align:left;">${tousu.not_store_reason!}</td>  
		                            <td style="text-align:left;"><#if tousu.lose_reason == '0'></#if>
		                            <#if tousu.lose_reason == '1'>价格不到位</#if>
		                            <#if tousu.lose_reason == '2'>4S店服务</#if>
		                            <#if tousu.lose_reason == '3'>没有现车</#if>
		                            <#if tousu.lose_reason == '4'>客户竞品比较中</#if>
		                            <#if tousu.lose_reason == '5'>4S店距离较远</#if>
		                            <#if tousu.lose_reason == '6'>驾照没到手</#if>
		                            <#if tousu.lose_reason == '7'>牌照没拍到</#if>
		                            <#if tousu.lose_reason == '8'>活动气氛不热烈</#if>
		                            <#if tousu.lose_reason == '9'>小胖服务不周到</#if>
		                            </td>  
		                            <td style="text-align:left;"><#if tousu.satisfy == '0'></#if>
		                            <#if tousu.satisfy == '1'>满意</#if>
		                            <#if tousu.satisfy == '2'>一般</#if>
		                            <#if tousu.satisfy == '3'>不满意</#if>
		                            </td>  
		                            <td style="text-align:left;">${tousu.advise!}</td> 
		                            <td style="text-align:left;"><#if tousu.satisfy_state == '0'>未调查</#if>
		                            <#if tousu.satisfy_state == '1'>已调查</#if></td>          
		                            <td style="text-align:left;">
		                           

		                            <a class="btn blue" data-toggle="modal" href="#showdiv" onclick="searchTousu(${tousu.record_id!})">修改</a>
		                            
		                            </td>
		                          </tr>
                          		</#list>
                          		</#if>
								<tr>
		                          <td colspan=14 style="text-align:center;">
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
		<h4 class="modal-title" ><i class="icon-settings"></i>满意度调查详情</h4>
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
							<td>地区：</td>
							<td id="tarea"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>是否到店：</td>
							<td id="tdaodian"></td>
							<td>是否成交：</td>
							<td id="tchengjiao"></td>
							<td>成交车型：</td>
							<td id="tmodel"></td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>是否接受调查：</td>
							<td>
								<select class="form-control input-small"  id="tdiaocha">
							      <option value="0">请选择</option>
							      <option value="1">是</option>
							      <option value="2">否</option>
							     </select>
							</td>
							<td>失销原因：</td>
							<td>
								<select class="form-control input-small"  id="tshixiao">
							      <option value="0">请选择</option>
							      <option value="1">价格不到位</option>
							      <option value="2">4S店服务</option>
							      <option value="3">没有现车</option>
							      <option value="4">客户竞品比较中</option>
							      <option value="5">4S店距离较远</option>
							      <option value="6">驾照没到手</option>
							      <option value="7">牌照没拍到</option>
							      <option value="8">活动气氛不热烈</option>
							      <option value="9">小胖服务不周到</option>
							     </select>
							</td>
							<td>服务满意度 ：</td>
							<td>
								<select class="form-control input-small"  id="tfuwu">
							      <option value="0">请选择</option>
							      <option value="1">满意</option>
							      <option value="2">一般</option>
							      <option value="3">不满意</option>
							     </select>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>未到店原因 ：</td>
							<td colspan=5 >
							<textarea id="tcontent"  class="form-control" rows="4"></textarea>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td>建议与意见 ：</td>
							<td colspan=5 >
							<textarea id="ttcontent"  class="form-control" rows="4"></textarea>
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




</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
	var iwa = "${iway!}";
	
$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){	
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].iway==iwa)
						html='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
				}
    		}
});

if(iwa != '' && iwa != null ){
$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(iwa)},
    		jsonp:'jsonpcallback',
    		success : function(data1){
    			//alert("success");
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==${chexiId!})
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexi").append(html);
				}
    		}
		});
		}

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
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
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
	document.forms[0].action = "kctsatisfy";
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
	document.forms[0].action = "kctsatisfy";
	document.forms[0].submit();
}

function searchTousu(tousuid){

	$.ajax({
		url : 'querySatisfyDetail?tousuid='+tousuid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		var res = data[0];
    		
    		$("#did").val(res.record_id);
    		
    		$("#tname").html(res.name);
    		$("#tphone").html(res.phone);
    		$("#tarea").html(res.prov +" >> "+res.city);
    		
    		
    		if(res.is_reach == 0 )
    		$("#tdaodian").html('否');
    		else
    		$("#tdaodian").html('是');
    		
    		if(res.is_trans == 0 )
    		$("#tchengjiao").html('否');
    		else
    		$("#tchengjiao").html('是');
    		
    		$("#tmodel").html(res.catalogname);
    		
    		$("#tdiaocha").val(res.research);
    		$("#tshixiao").val(res.lose_reason);
    		$("#tfuwu").val(res.satisfy);
    		
    		$("#tcontent").attr("value",res.not_store_reason);
    		$("#ttcontent").attr("value",res.advise);
    		
    	
		}
	});

}
//保存投诉更改
function save(){
	var did = $("#did").val();
	
	var diaocha = $("#tdiaocha").val();
    var shixiao = $("#tshixiao").val();
    var fuwu    = $("#tfuwu").val();
    
    var tcontent = $("#tcontent").val();
    
	var ttcontent = $("#ttcontent").val();
	
	$.post(
		"satisfyUpdate",
		{did:did,diaocha:diaocha,shixiao:shixiao,fuwu:fuwu,tcontent:tcontent,ttcontent:ttcontent},
		function(data){
			if(data==1){
				alert("修改成功!");
				$("#search").trigger("click");
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