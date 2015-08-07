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
  		<span>业务类型：</span>
  	</td>
  	<td>
	     <select class="form-control input-small" name="ywtype" id="ywtype">
	     	<option value="-1">选择类型</option>
	     	<option  <#if ywtype==0>selected=true</#if> value="0">看车团</option>
	     	<option  <#if ywtype==1>selected=true</#if> value="1">直销</option>
	     	<option  <#if ywtype==2>selected=true</#if> value="2">车展</option>
	     	<option  <#if ywtype==3>selected=true</#if> value="3">大客户</option>
	     	<option  <#if ywtype==4>selected=true</#if> value="4">经销商</option>
	     	<option  <#if ywtype==5>selected=true</#if> value="5">其他</option>
	  	 </select>
  	</td>
  
  <td><span>发起人:</span></td>
 		<td> <input type="text"  class="form-control input-inline input-small " name="name"  value="${name!}"> </td>
 		
 		<td><span>推广开始时间:</span></td>
 		<td>
 			<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
				<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
				<span class="input-group-btn input-inline">
				<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
				</span>
			</div>
			至
			<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
				<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
				<span class="input-group-btn input-inline">
				<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
				</span>
			</div>
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
  	<button class="btn blue" type="button" id="search">查询</button>&nbsp;
  	
  	</td>
  </tr>
 </table>
</form>
</div>
<!--中部-->

<!--数据展示-->
<div class="row">
	<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;项目统计:<font color="red">${count!}</font></strong>
</div>
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>我的项目
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
										 推广编号
									</th>
									<th>
										部门
									</th>
									<th>
										发起人
									</th>
									<th>
										业务类型
									</th>
									<th>
										品牌车系
									</th>
									<th>
										 竞品车型
									</th>
									
									<th>
										 推广起止时间
									</th>
									
									<th>
										 活动起止时间
									</th>
								
									<th>
										 目标线索量
									</th>
									
									<th>
										 实际线索量
									</th>
									
									<th>
										 已回访数量
									</th>
								
								
									<th>
										操作
									</th>
								</tr>
								</thead>
								<tbody>
								<#if tuiguangList??>
								<#list tuiguangList as tousu>
		                          <tr>
		                          	<td style="text-align:left;">
		                          	${(page-1)*rows+tousu_index+1}
		                          	</td>
		                            <td style="text-align:left;">${tousu.pro_num!}</td>
		                            <td style="text-align:left;">${tousu.ini_dept!}</td>
		                            <td style="text-align:left;">${tousu.ini_man!}</td>
		                            <td style="text-align:left;"><#if tousu.service_type == '0'>看车团</#if>
		                            <#if tousu.service_type == '1'>直销</#if>
		                            <#if tousu.service_type == '2'>车展</#if>
		                            <#if tousu.service_type == '3'>大客户</#if>
		                            <#if tousu.service_type == '4'>经销商</#if>
		                            <#if tousu.service_type == '5'>其他</#if>
		                            </td>
		                            <td style="text-align:left;">${tousu.iway }>>${tousu.chexiName }</td>
		                            <td style="text-align:left;">${tousu.competing_name!}</td>
		                            <td style="text-align:left;">${tousu.promo_start_date}至${tousu.promo_end_date!}</td>
		                            <td style="text-align:left;">${tousu.acti_start_date!}至${tousu.acti_end_date!}</td>  
		                           
		                            <td style="text-align:left;">${tousu.tar_clue_num!}</td>  
		                            <td style="text-align:left;">${tousu.baoming_count}</td>  
		                            <td style="text-align:left;">${tousu.huifang_count}</td> 
		                           
		                            <td style="text-align:left;">
		                           
		                           
		                            <a class="btn blue" style="padding:7px" data-toggle="modal" <#if tousu.pro_state == '5' > disabled = "true" </#if>  onclick="searchOpenNew('${tousu.pro_num!}')">回访界面</a>
		                            
		                             <a class="btn blue" style="padding:7px" data-toggle="modal" <#if tousu.pro_state == '3' || tousu.pro_state == '100' > disabled = "true" </#if> onclick="searchOpen('${tousu.pro_num!}')">满意度调查</a>
		                          
		                            </td>
		                          </tr>
                          		</#list>
                          		</#if>
								<tr>
		                          <td colspan=13 style="text-align:center;">
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

function searchOpenNew(pro_n){
	window.parent.openNew('看车团管理系统','kctmanage?pro_numid='+pro_n);

}

function searchOpen(pro_n){
	window.parent.openNew('看车团满意度调查表','kctsatisfy?pro_numid='+pro_n);

}



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
	document.forms[0].action = "kctmyProject";
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
	document.forms[0].action = "kctmyProject";
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