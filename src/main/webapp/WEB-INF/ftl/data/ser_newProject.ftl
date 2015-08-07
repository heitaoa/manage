<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
	<div class="col-md-12">
    		<form class="form-horizontal" action="ser_addProject"  role="form" id="newProject">
        		<div class="form-body">
            		<div class="form-group">
                		<label class="col-md-2 control-label">发起人</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_man" value="${info.get("id")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("name")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">日期</label>
                    	<div class="col-md-4">
                        	<input type="text" id="sysdate" class="form-control input-medium" value="" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">站点</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_org" value="${info.get("orgCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("orgName")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">部门</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_dept" value="${info.get("depCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("depName")}" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">活动名称</label>
                    	<div class="col-md-4">
                       		<input type="text" class="form-control input-medium" name="acti_name" id="add_acti_name"/>
                    	</div>
                    	
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">业务类型</label>
                    	<div class="col-md-4">
                        	<select class="layout-option form-control input-medium" name="service_type" id="add_service_type">
								<option value="0" selected="selected">看车团</option>
								<option value="1">直销</option>
                            	<option value="2">车展</option>
                            	<option value="3">大客户</option>
                            	<option value="4">经销商</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">客户名称</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" name="cust_name" id="add_cust_name"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广区域</label>
                    	<div class="col-md-4">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="add_promo_prov">
								<option  value="-1">全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="add_promo_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">关联合同号</label>
                    	<div class="col-md-4">
                        <input type="text" class="form-control input-medium" value="" name="contact_num" id="add_contact_num"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">渠道/车系/车型</label>
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" name="iway" id="add_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  	 					<select class="form-control input-inline input-medium" name="car" id="add_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  						<select class="form-control input-inline input-medium" name="model" id="add_chexing">
	  							<option value="-1">请选择车型</option>
	  						</select>
                    	</div>
                	</div>
                	<div class="form-group" id="sjy_fg" style="display:none">
                		<label class="col-md-2 control-label">指定数据源</label>
                		<input type="hidden" name="data_source" value="" id="add_data_source">
                		<input type="hidden" name="data_source_name" value="" id="add_data_source_name">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-small" id="sjy_prov">
								<option  value="-1">请选择省份</option>
							</select>
                        	<select class="form-control input-inline input-small" id="sjy_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    		<select class="form-control input-inline input-medium" id="sjy_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  	 					<select class="form-control input-inline input-medium" id="sjy_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  						<a href="javascript:addSjy();" class="btn btn-circle btn-xs blue">添加<i class="fa fa-plus"></i></a>
                    	</div>
                	</div>
                	<div class="form-group" id="sjy_g_fg" style="display:none">
                		<label class="col-md-2 control-label"></label>
                		<div class="col-md-10">
                    		<div class="btn-group" id="sjy_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">竞品</label>
                		<input type="hidden" name="competing" value="" id="add_competing">
                		<input type="hidden" name="competing_name" value="" id="add_competing_name">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" id="jp_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  	 					<select class="form-control input-inline input-medium" id="jp_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  						<div class="btn-group" id="jp_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">合同开始时间</label>
                   		<div class="col-md-3">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_contact_start_date_area">
                            	<input type="text" class="form-control" name="contact_start_date" id="add_contact_start_date">
                            	<span class="input-group-btn">
                            	<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">合同结束时间</label>
                    	<div class="col-md-3">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_contact_end_date_area">
                            	<input type="text" class="form-control" name="contact_end_date" id="add_contact_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广开始时间</label>
                    	<div class="col-md-3">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_promo_start_date_area">
                            	<input type="text" class="form-control" name="promo_start_date" id="add_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">推广结束时间</label>
                    	<div class="col-md-3">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_promo_end_date_area">
                            	<input type="text" class="form-control" name="promo_end_date" id="add_promo_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div> 
                	<div class="form-group">
                		<label class="col-md-2 control-label">活动开始时间</label>
                    	<div class="col-md-3">
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_acti_start_date_area">
                            	<input type="text" class="form-control" name="acti_start_date" id="add_acti_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">活动结束时间</label>
                    	<div class="col-md-3">
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_acti_end_date_area"> 
                            	<input type="text" class="form-control" name="acti_end_date" id="add_acti_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div> 
                	<div class="form-group">
                    	<label class="col-md-2 control-label">目标线索量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')"  onpaste="return false;"  class="form-control input-small" name="tar_clue_num" id="add_tar_clue_num"/>
                    	</div>
                    	<label class="col-md-2 control-label">目标到达量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-small" name="tar_reach_num" id="add_tar_reach_num"/>
                    	</div>
                    	<label class="col-md-2 control-label">目标成交量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-small" name="tar_trans_num" id="add_tar_trans_num"/>
                    	</div>
               	   </div>
                	<div class="form-group" id="cs_group_area">
                    	<label class="col-md-2 control-label">责任客服</label>
                    	<input type="hidden" name="custom_service" id="add_custom_service" value="">
                    	<input type="hidden" name="custom_service_name" id="add_custom_service_name" value="">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-small" id="add_custom_org">
	  							<#list orglist as org>
	  								<option value="${org.code}" <#if org.code==info.orgCode>selected</#if> >${org.name}</option>
	  							</#list>
	  						</select>
	  						<select class="form-control input-inline input-small" id="add_custom_name">
	  							<option value="-1">请选择客服</option>
	  							<#list customServices as cs>
	  								<option value="${cs.id}">${cs.name}</option>
	  							</#list>
	  						</select>
                    		<div class="btn-group" id="cs_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<div class="col-md-6">
                       		
                    	</div>
                    	<div class="col-md-2">
                       		<button id="bt_pro_yes" type="button" class="btn blue" onclick="add();">提交</button>
                    	</div>
                	</div>
        	</form>
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
	$("#add_contact_start_date_area").on('changeDate',function(ev){
		var date = $("#add_contact_start_date").val();
		var obj = $("#add_contact_end_date_area");
		setDateLimit("start",date,obj);
	});
	$("#add_contact_end_date_area").on('changeDate',function(ev){
		var date = $("#add_contact_end_date").val();
		var obj = $("#add_contact_start_date_area");
		setDateLimit("end",date,obj);
	});
	$("#add_promo_start_date_area").on('changeDate',function(ev){
		var date = $("#add_promo_start_date").val();
		var obj = $("#add_promo_end_date_area");
		setDateLimit("start",date,obj);
	});
	$("#add_promo_end_date_area").on('changeDate',function(ev){
		var date = $("#add_promo_end_date").val();
		var obj = $("#add_promo_start_date_area");
		setDateLimit("end",date,obj);
	});
	$("#add_acti_start_date_area").on('changeDate',function(ev){
		var date = $("#add_acti_start_date").val();
		var obj = $("#add_acti_end_date_area");
		setDateLimit("start",date,obj);
	});
	$("#add_acti_end_date_area").on('changeDate',function(ev){
		var date = $("#add_acti_end_date").val();
		var obj = $("#add_acti_start_date_area");
		setDateLimit("end",date,obj);
	});
	var sysdate = new Date();
	var str = ""; 
	var y = sysdate.getFullYear();    //获取完整的年份(4位,1970-????)
	var m = sysdate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
	var d = sysdate.getDate(); 
	var str = y+"-"+m+"-"+d; 
	$("#sysdate").val(str);
	$("#add_chexing").attr("disabled","disabled");
	$.ajax({
			url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){	
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
					html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#add_pinpai").append(html);
					$("#jp_pinpai").append(html);
					$("#sjy_pinpai").append(html);
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
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#add_promo_prov").append(html);
					$("#sjy_prov").append(html);
				}
    		}
	});
	$("#add_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#add_chexi").empty();
		$("#add_chexing").empty();
		$("#add_chexi").append("<option value='-1'>请选择车系</option>");
		$("#add_chexing").append("<option value='-1'>请选择车型</option>");
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
					$("#add_chexi").append(html);
				}
    		}
		});
	
	});
	$("#jp_pinpai").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		var add_service_type = $("#add_service_type").val();
		$("#jp_chexi").empty();
		$("#jp_chexi").append("<option value='-1'>请选择车系</option>");
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
					$("#jp_chexi").append(html);
				}
    		}
		});
	
	});
	$("#sjy_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#sjy_chexi").empty();
		$("#sjy_chexi").append("<option value='-1'>请选择车系</option>");
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
					$("#sjy_chexi").append(html);
				}
    		}
		});
	
	});
	$("#jp_chexi").change(function(){	
		 var chexi_id = $(this).children('option:selected').val();
		 var chexi_name = $(this).children('option:selected').html();
		 var pinpai_id = $("#jp_pinpai").children('option:selected').val();
		 var pinpai_name = $("#jp_pinpai").children('option:selected').html();
		 var id = pinpai_id+'①'+chexi_id;
		 var name = pinpai_name+'/'+chexi_name;
		 $("#jp_pinpai").val("-1");
		 $("#jp_chexi").val("-1");
		 if(chexi_id=="-1"||pinpai_id=="-1"){
			return;
		 }
		 var jp = $("#add_competing").val();
		 var arr = jp.split(",");
		 for(var i=0;i<arr.length;i++){
		 	if(arr[i]==id){
		 		alert("已选择该车系！");
		 		return;
		 	}
		 }
		 if(jp.length<=0){
		 	jp = jp+id;
		 }else{
		 	jp = jp+","+id;
		 }
		 $("#add_competing").val(jp);
		 var html='<button type="button" class="btn btn-default" id="jp'+id+'">'+name+'</button>';
		 $("#jp_group").append(html);
			$("#jp"+id).dblclick(function(){
				var jp2=$("#add_competing").val();
				var arr2 = jp2.split(",");
				arr2.splice($.inArray(id,arr2),1);
				jp2 = arr2.join(",");
				$("#add_competing").val(jp2)
				$(this).remove();	
			}); 
	});
	$("#add_chexi").change(function(){	
		 var fatherid = $(this).children('option:selected').val();
		$("#add_chexing").empty();
		$("#add_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#add_chexing").append(html);
				}
    		}
		});
	
	});
	$("#add_service_type").change(function(){
		$("#add_pinpai").val("-1");
		$("#add_chexi").val("-1");
		$("#add_chexing").val("-1");
		$("#add_pinpai").removeAttr("disabled");
		$("#add_chexi").removeAttr("disabled");
		$("#add_chexing").removeAttr("disabled");
		$("#sjy_fg").hide();
		$("#sjy_g_fg").hide();
		$("#cs_group_area").show();
		$("#add_data_source").val("");
		$("#sjy_group").empty();
		var type = $(this).children('option:selected').val();
		if(type==0){
			$("#add_chexing").attr("disabled","disabled");
		}else if(type==2){
			$("#add_pinpai").attr("disabled","disabled");
			$("#add_chexi").attr("disabled","disabled");
			$("#add_chexing").attr("disabled","disabled");
		}else if(type==4){
			$("#add_chexi").attr("disabled","disabled");
			$("#add_chexing").attr("disabled","disabled");
			$("#add_custom_service").val("");
			$("#add_custom_service_name").val("");
			$("#cs_group").empty();
			$("#cs_group_area").hide();
			$("#sjy_fg").show();
			$("#sjy_g_fg").show();
		}
		
	});
	$("#add_promo_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#add_promo_city").empty();
		$("#add_promo_city").append("<option value='-1'>请选择城市</option>");
		if(fatherid!=-1){
			$.ajax({
    			url : 'getCityInfo?city='+fatherid,
    			dataType : 'jsonp',
    			jsonp:'jsonpcallback',
    			success : function(data){
	    			carBrand = data;
					for(var i =0 ;i<carBrand.length;i++)
					{
						var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
						$("#add_promo_city").append(html);
					}
    			}
			});
		}
	
	});
	$("#sjy_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#sjy_city").empty();
		$("#sjy_city").append("<option value='-1'>请选择城市</option>");
		if(fatherid!=-1){
			$.ajax({
    			url : 'getCityInfo?city='+fatherid,
    			dataType : 'jsonp',
    			jsonp:'jsonpcallback',
    			success : function(data){
	    			carBrand = data;
					for(var i =0 ;i<carBrand.length;i++)
					{
						var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
						$("#sjy_city").append(html);
					}
    			}
			});
		}
	
	});
	$("#add_custom_org").change(function(){
			var org = $(this).children('option:selected').val();
			$("#add_custom_name").empty();
			$("#add_custom_name").append('<option value="-1">请选择客服</option>');
			$.ajax({
    			type: "POST",
    			url:"./getCustomService",
    			data:{
					"org":org
				},
    			success:function(data) {
					var info = eval(data);
					for(var i=0;i<info.length;i++){
						var name = info[i].name;
						var id = info[i].id;
						html='<option value="'+id+'">'+name+'</option>';
						$("#add_custom_name").append(html);
					}
    			}
   			});	
	});
	$("#add_custom_name").change(function(){
			var id = $(this).children('option:selected').val();
			var name = $(this).children('option:selected').html();
			if(id=="-1"){
				return;
			}
			$("#add_custom_name").val("-1");
			var cs_value=$("#add_custom_service").val();
			var arr = cs_value.split(",");
			for(var i=0;i<arr.length;i++){
				if(arr[i]==id){
					alert("已选择该客服！");
					return;
				}
			}
			if(cs_value.length<=0){
				cs_value = cs_value+id;
			}else{
				cs_value = cs_value+","+id;
			}
			$("#add_custom_service").val(cs_value);
			var html='<button type="button" class="btn btn-default d" id="kf'+id+'">'+name+'</button>';
			$("#cs_group").append(html);
			$("#kf"+id).dblclick(function(){
				var cs_value2=$("#add_custom_service").val();
				var arr2 = cs_value2.split(",");
				arr2.splice($.inArray(id,arr2),1);
				cs_value2 = arr2.join(",");
				$("#add_custom_service").val(cs_value2)
				$(this).remove();	
			});
	});
});
function add(){
	var custom_service_name_arr = new Array();
	$("#cs_group button").each(function(){
		var name = $(this).text();
		custom_service_name_arr.push(name);
	});
	var cs_names = custom_service_name_arr.join(",");
	$("#add_custom_service_name").val(cs_names);
	var competing_name_arr = new Array();
	$("#jp_group button").each(function(){
		var name = $(this).text();
		competing_name_arr.push(name);
	});
	var jp_names = competing_name_arr.join(",");
	$("#add_competing_name").val(jp_names);
	var data_source_name_arr = new Array();
	$("#sjy_group button").each(function(){
		var name = $(this).text();
		data_source_name_arr.push(name);
	});
	var sjy_names = data_source_name_arr.join(",");
	$("#add_data_source_name").val(sjy_names);
	var add_service_type = $("#add_service_type").val();
	var add_contact_num = $("#add_contact_num").val();
	var	add_acti_name = $("#add_acti_name").val();
	var	add_acti_start_date = $("#add_acti_start_date").val();
	var	add_acti_end_date = $("#add_acti_end_date").val();
	var	add_promo_prov = $("#add_promo_prov").val();
	var	add_promo_city = $("#add_promo_city").val();
	var	add_cust_name = $("#add_cust_name").val();
	var	add_pinpai = $("#add_pinpai").val();
	var	add_chexi = $("#add_chexi").val();
	var	add_chexing = $("#add_chexing").val();
	var	add_contact_start_date = $("#add_contact_start_date").val();
	var	add_contact_end_date = $("#add_contact_end_date").val();
	var	add_promo_start_date = $("#add_promo_start_date").val();
	var	add_promo_end_date = $("#add_promo_end_date").val();
	var	add_tar_clue_num = $("#add_tar_clue_num").val();
	var	add_tar_reach_num = $("#add_tar_reach_num").val();
	var	add_tar_trans_num = $("#add_tar_trans_num").val();
	var	add_custom_service = $("#add_custom_service").val();
	var	add_competing = $("#add_competing").val();
	var	add_data_source = $("#add_data_source").val();
	if("0"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
	}else if("1"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
		if(add_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		if(add_chexing=="-1"){
			alert("请选择车型");
			return;
		}
	}else if("3"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
		if(add_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		
	}else if("4"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
	}else if("5"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
	}
	if(!is_exists(add_contact_num)){
		alert("请输入关联合同号");
		return;
	}
	if(!is_exists(add_acti_name)){
		alert("请输入活动名称");
		return;
	}
	if(!is_exists(add_acti_start_date)){
		alert("请输入活动开始时间");
		return;
	}
	if(!is_exists(add_acti_end_date)){
		alert("请输入活动结束时间");
		return;
	}
	if(!is_exists(add_cust_name)){
		alert("请输入客户名称");
		return;
	}
	if(!is_exists(add_contact_start_date)){
		alert("请输入合同开始日期");
		return;
	}
	if(!is_exists(add_contact_end_date)){
		alert("请输入合同终止日期");
		return;
	}
	if(!is_exists(add_promo_start_date)){
		alert("请输入推广开始日期");
		return;
	}
	if(!is_exists(add_promo_end_date)){
		alert("请输入推广终止日期");
		return;
	}
	if(!is_exists(add_tar_clue_num)){
		alert("请输入目标线索量");
		return;
	}
	if(!is_exists(add_tar_trans_num)){
		alert("请输入目标到达量");
		return;
	}
	if(!is_exists(add_tar_reach_num)){
		alert("请输入目标成交量");
		return;
	}
	if((!is_exists(add_custom_service)||!is_exists(cs_names))&&"4"!=add_service_type){
		alert("请选择责任客服");
		return;
	}
	$.ajax({
    type: "POST",
    url:"./ser_addProject",
    data:$('#newProject').serialize(),
    success: function(data) {
    		if(data==1){
				alert("添加成功！");
				window.parent.removeActiveAndOpenNew('审核中','./ser_pending');
			}else{
				alert("error");
			}
    }
  });
}
function addSjy(){
	var prov = $("#sjy_prov").children('option:selected').val();
	var prov_name = $("#sjy_prov").children('option:selected').html();
	var city = $("#sjy_city").children('option:selected').val();
	var city_name = $("#sjy_city").children('option:selected').html();
	var pinpai = $("#sjy_pinpai").children('option:selected').val();
	var pinpai_name = $("#sjy_pinpai").children('option:selected').html();
	var chexi = $("#sjy_chexi").children('option:selected').val();
	var chexi_name = $("#sjy_chexi").children('option:selected').html();
	$("#sjy_prov").val("-1");
	$("#sjy_city").val("-1");
	$("#sjy_pinpai").val("-1");
	$("#sjy_chexi").val("-1");
	if(prov=="-1"){
		alert("请选择省份！");
		return;
	}
	if(pinpai=="-1"){
		alert("请选择渠道！");
		return;
	}
	var name = prov_name;
	if(city!="-1"){
		name = name+"/"+city_name;
	}
	name = name+"/"+pinpai_name;
	if(chexi!="-1"){
		name = name+"/"+chexi_name;
	}
	var id = prov+"a"+city+"a"+pinpai+"a"+chexi;
	var sjy = $("#add_data_source").val();
	var arr = sjy.split(",");
	for(var i=0;i<arr.length;i++){
		if(arr[i]==id){
			alert("已选择该数据源！");
			return;
		}
	}
	if(sjy.length<=0){
		sjy = sjy+id;
	}else{
		sjy = sjy+","+id;
	}
	$("#add_data_source").val(sjy);
	var html = '<button type="button" class="btn btn-default" id="sjy'+id+'">'+name+'</button>';
	$("#sjy_group").append(html);
	$("#sjy"+id).dblclick(function(){
		var sjy2=$("#add_data_source").val();
		var arr2 = sjy2.split(",");
		arr2.splice($.inArray(id,arr2),1);
		sjy2 = arr2.join(",");
		$("#add_data_source").val(sjy2)
		$(this).remove();	
	});
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined){
		return false;
	}else{
		return true;
	}
}
function setDateLimit(type,date,obj){
	if(date==null||date==""||date==undefined){
		alert("null");
		return;
	}else{
		if(type=="start"){
			obj.datepicker('setStartDate', date);
		}else if(type=="end"){
			obj.datepicker('setEndDate', date);
		}
			
	}
}
</script>
</body>
</html>