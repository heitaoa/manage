<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>


<div class="row">
	<div class="col-md-12">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" id="table_1" role="grid" aria-describedby="sample_1_info">
							<thead>
								<tr role="row">
									<th class="text-center">序号</th>
									<th class="text-center">推广编号</th>
									<th class="text-center">客服</th>
									<th class="text-center">主要渠道</th>
									<th class="text-center">其他渠道</th>
									<th class="text-center">区域</th>
									<th class="text-center">有效时间</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<#list list as project>
									<tr>
										<td>${project_index+1}</td>
										<td id="pro_num">${project.get("pro_num")}</td>
										<td id="custom_service">${project.get("custom_service_name")!}</td>
										<td id="iway">${project.get("iway")!}</td>
										<td id="competing">${project.get("competing_name")!}</td>
										<td id="promo_area">${project.get("promo_area")!}</td>
										<td>${project.get("promo_start_date")}至${project.get("promo_end_date")}</td>
										<td>
											<a href="javascript:editProject('${project.get("pro_num")}')">编辑</a>
										</td>
									</tr>
								</#list>
								
							</tbody>
						</table>
	</div>
</div>
<div id="edit" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
	<input type="hidden" id="edit_type" value="">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">编辑项目</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-12">
    		<form class="form-horizontal" action="ser_editProject"  role="form" id="editProject">
        		<div class="form-body">
        			<div class="form-group">
                		<label class="col-md-2 control-label">推广编号</label>
                		<input type="hidden" id="edit_pro_num_text" name="pro_num"/>
                		<input type="hidden" id="edit_service_type" name="service_type"/>
                    	<label class="col-md-4 control-label" style="text-align:left;" id="edit_pro_num"></label>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广区域</label>
                    	<div class="col-md-4">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="edit_promo_prov">
								<option  value="-1">全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="edit_promo_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">渠道</label>
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" name="iway" id="edit_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">竞品</label>
                		<input type="hidden" name="competing" value="" id="edit_competing">
                		<input type="hidden" name="competing_name" value="" id="edit_competing_name">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" id="jp_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  						<div class="btn-group" id="jp_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广开始时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="edit_promo_start_date_area">
                            	<input type="text" class="form-control" name="promo_start_date" id="edit_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    </div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">推广结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" id="edit_promo_end_date_area">
                            	<input type="text" class="form-control" name="promo_end_date" id="edit_promo_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">责任客服</label>
                    	<input type="hidden" name="custom_service_name" id="edit_custom_service_name" value="">
                    	<div class="col-md-10">
	  						<select class="form-control input-inline input-small" id="edit_custom_service" name="custom_service">
	  							<option value="-1">请选择客服</option>
	  							<#list customServices as cs>
	  								<option value="${cs.id}">${cs.name}</option>
	  							</#list>
	  						</select>
                    	</div>
                	</div>
        	</form>
    	</div>

	</div>           
    </div>
    <div class="modal-footer">
    	<button id="bt_pro_yes" type="button" class="btn blue" onclick="edit();">提交</button>
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
					$("#edit_pinpai").append(html);
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
					$("#edit_promo_prov").append(html);
				}
    		}
	});
	$("#edit_promo_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#edit_promo_city").empty();
		$("#edit_promo_city").append("<option value='-1'>请选择城市</option>");
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
						$("#edit_promo_city").append(html);
					}
    			}
			});
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
		var jp = $("#edit_competing").val();
		var arr = jp.split(",");
		for(var i=0;i<arr.length;i++){
			if(arr[i]==id){
		 		alert("已选择该品牌！");
		 		return;
			}
		}
		if(jp.length<=0){
		 	jp = jp+id;
		}else{
		 	jp = jp+","+id;
		}
		$("#edit_competing").val(jp);
		var html='<button type="button" class="btn btn-default" id="jp'+id+'">'+name+'</button>';
		$("#jp_group").append(html);
		$("#jp"+id).dblclick(function(){
			var jp2=$("#edit_competing").val();
			var arr2 = jp2.split(",");
			arr2.splice($.inArray(id,arr2),1);
			jp2 = arr2.join(",");
			$("#edit_competing").val(jp2)
			$(this).remove();	
		});
	});
	
});
	
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined||obj=="null"){
		return false;
	}else{
		return true;
	}
}
function editProject(pro_num){
	$.ajax({
    type: "POST",
		datatype:"json",
    url:"ser_getProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data);
			var edit_pro_num = p[0].pro_num;
			$("#edit_pro_num").text(edit_pro_num);
			$("#edit_pro_num_text").val(edit_pro_num);
			var edit_promo_prov = p[0].promo_prov;
			$("#edit_promo_prov").val(edit_promo_prov);
			var edit_promo_city = p[0].promo_city;
			if(edit_promo_prov!=-1){
				$.ajax({
    				url : 'getCityInfo?city='+edit_promo_prov,
    				dataType : 'jsonp',
    				jsonp:'jsonpcallback',
    				success : function(data){
	    				carBrand = data;
						for(var i =0 ;i<carBrand.length;i++)
						{
							var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
							$("#edit_promo_city").append(html);
						}
						$("#edit_promo_city").val(edit_promo_city);
    				}
				});
			}
			var edit_promo_start_date = p[0].promo_start_date;
			$("#edit_promo_start_date").val(edit_promo_start_date);
			var edit_promo_end_date = p[0].promo_end_date;
			$("#edit_promo_end_date").val(edit_promo_end_date);
			var edit_custom_service = p[0].custom_service;
			$("#edit_custom_service").val(edit_custom_service);
			var edit_service_type = p[0].service_type;
			$("#edit_service_type").val(edit_service_type);
			var edit_iway = p[0].iway;
			$("#edit_pinpai").val(edit_iway);
			var edit_competing = p[0].competing;
			$("#edit_competing").val(edit_competing);
			var edit_competing_name = p[0].competing_name;
			var edit_competing_arr = new Array();
			if(is_exists(edit_competing)){
				edit_competing_arr = edit_competing.split(",");
			}
			var edit_competing_name_arr = new Array();
			if(is_exists(edit_competing_name)){
				edit_competing_name_arr = edit_competing_name.split(",");
			}
			$("#jp_group").empty();
			for(var i=0;i<edit_competing_name_arr.length;i++){
				var id= edit_competing_arr[i];
				var name = edit_competing_name_arr[i];
				var html='<button type="button" class="btn btn-default" id="jp'+id+'">'+name+'</button>';
				 $("#jp_group").append(html);
				 $("#jp"+id).dblclick(function(){
				 var id2 = $(this).attr("id").replace("jp","");
				var jp2=$("#edit_competing").val();
				var arr2 = jp2.split(",");
				arr2.splice($.inArray(id2,arr2),1);
				jp2 = arr2.join(",");
				$("#edit_competing").val(jp2)
				$(this).remove();	
			}); 
			}
			$("#edit .date-picker").datepicker('update');
			var date = $("#edit_promo_start_date").val();
			var obj = $("#edit_promo_end_date_area");
			setDateLimit("start",date,obj);
			date = $("#edit_promo_end_date").val();
			obj = $("#edit_promo_start_date_area");
			setDateLimit("end",date,obj);
			$("#edit").modal();
    }
  });
}
function edit(){
	var	edit_promo_prov = $("#edit_promo_prov").val();
	var	edit_promo_city = $("#edit_promo_city").val();
	var	edit_pinpai = $("#edit_pinpai").val();
	var	edit_promo_start_date = $("#edit_promo_start_date").val();
	var	edit_promo_end_date = $("#edit_promo_end_date").val();
	var	edit_custom_service = $("#edit_custom_service").val();
	var edit_competing = $("#edit_competing").val();
	var cs_names = $("#edit_custom_service option:selected").text();
	$("#edit_custom_service_name").val(cs_names);
	var competing_name_arr = new Array();
	$("#jp_group button").each(function(){
		var name = $(this).text();
		competing_name_arr.push(name);
	});
	var jp_names = competing_name_arr.join(",");
	$("#edit_competing_name").val(jp_names);
	if(edit_pinpai=="-1"){
		alert("请选择渠道");
		return;
	}
	if(!is_exists(edit_promo_start_date)){
		alert("请输入推广开始日期");
		return;
	}
	if(!is_exists(edit_promo_end_date)){
		alert("请输入推广终止日期");
		return;
	}
	if(!is_exists(edit_custom_service)||!is_exists(cs_names)){
		alert("请选择责任客服");
		return;
	}
	var edit_type=$("#edit_type").val();
	$.ajax({
    	type: "POST",
    	url:"ser_editProject",
    	data:$('#editProject').serialize(),
    	success: function(data) {
    		if(data==1){
				alert("项目编辑成功！");
				window.location.reload();
			}else{
				alert("error");
			}
    	}
  	});
	
}
function setDateLimit(type,date,obj){
	if(date==null||date==""||date==undefined){
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