<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
	<div class="col-md-12">
    		<form class="form-horizontal" action="addQtProject"  role="form" id="newQtProject">
        		<div class="form-body">
            		<div class="form-group">
                		<label class="col-md-1 control-label">发起人</label>
                    	<div class="col-md-3">
                    		<input type="hidden" name="ini_man" value="${info.get("id")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("name")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-1 control-label">日期</label>
                    	<div class="col-md-3">
                        	<input type="text" id="sysdate" class="form-control input-medium" value="" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">站点</label>
                    	<div class="col-md-3">
                    		<input type="hidden" name="ini_org" value="${info.get("orgCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("orgName")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-1 control-label">部门</label>
                    	<div class="col-md-3">
                    		<input type="hidden" name="ini_dept" value="${info.get("depCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("depName")}" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">区域</label>
                    	<div class="col-md-3">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="add_promo_prov">
								<option  value="-1">全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="add_promo_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">主要渠道</label>
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" name="iway" id="add_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">其他渠道</label>
                		<input type="hidden" name="competing" value="" id="add_competing">
                		<input type="hidden" name="competing_name" value="" id="add_competing_name">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" id="jp_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  						<div class="btn-group" id="jp_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">推广开始时间</label>
                    	<div class="col-md-3">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="add_promo_start_date_area">
                            	<input type="text" class="form-control" name="promo_start_date" id="add_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    </div>
                	<div class="form-group">
                    	<label class="col-md-1 control-label">推广结束时间</label>
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
                    	<label class="col-md-1 control-label">责任客服</label>
                    	<input type="hidden" name="custom_service_name" id="add_custom_service_name">
                    	<div class="col-md-10">
	  						<select class="form-control input-inline input-small" id="add_custom_service" name="custom_service">
	  							<option value="-1">请选择客服</option>
	  							<#list customServices as cs>
	  								<option value="${cs.id}">${cs.name}</option>
	  							</#list>
	  						</select>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<div class="col-md-3">
                       		
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
	var sysdate = new Date();
	var str = ""; 
	var y = sysdate.getFullYear();    //获取完整的年份(4位,1970-????)
	var m = sysdate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
	var d = sysdate.getDate(); 
	var str = y+"-"+m+"-"+d; 
	$("#sysdate").val(str);
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
				}
    		}
	});
	$("#jp_pinpai").change(function(){	
		var pinpai_id = $("#jp_pinpai").children('option:selected').val();
		var pinpai_name = $("#jp_pinpai").children('option:selected').html();
		var id = pinpai_id+'①'+'0';
		var name = pinpai_name;
		$("#jp_pinpai").val("-1");
			if(pinpai_id=="-1"){
			return;
		}
		var jp = $("#add_competing").val();
		var arr = jp.split(",");
		for(var i=0;i<arr.length;i++){
			if(arr[i]==id){
		 		alert("已选择该渠道！");
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
});
function add(){
	var cs_name = $("#add_custom_service option:selected").text();
	$("#add_custom_service_name").val(cs_name);
	var competing_name_arr = new Array();
	$("#jp_group button").each(function(){
		var name = $(this).text();
		competing_name_arr.push(name);
	});
	var jp_names = competing_name_arr.join(",");
	$("#add_competing_name").val(jp_names);
	var data_source_name_arr = new Array();
	
	var	add_promo_prov = $("#add_promo_prov").val();
	var	add_promo_city = $("#add_promo_city").val();
	var	add_pinpai = $("#add_pinpai").val();
	var	add_promo_start_date = $("#add_promo_start_date").val();
	var	add_promo_end_date = $("#add_promo_end_date").val();
	var	add_custom_service = $("#add_custom_service").val();
	var	add_competing = $("#add_competing").val();
	if(add_pinpai=="-1"){
		alert("请选择品牌");
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
	if((add_custom_service==-1||!is_exists(cs_name))){
		alert("请选择责任客服");
		return;
	}
	$.ajax({
    type: "POST",
    url:"./addQtProject",
    data:$('#newQtProject').serialize(),
    success: function(data) {
    		if(data==1){
				alert("添加成功！");
				window.parent.removeActiveAndOpenNew('常态品牌项目列表','./viewQtProjects');
			}else{
				alert("error");
			}
    }
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