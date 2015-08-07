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
									<th class="text-center">项目名称</th>
									<th class="text-center">发起人</th>
									<th class="text-center">发起时间</th>
									<th class="text-center">业务类型</th>
									<th class="text-center">渠道/车系/车型</th>
									<th class="text-center">推广区域</th>
									<th class="text-center">推广起止时间</th>
									<th class="text-center">活动起止时间</th>
									<th class="text-center">责任客服</th>
									<th class="text-center"> 操作</th>
								</tr>
							</thead>
							<tbody>
								<#list projectList as project>
									<tr>
										<td>${project_index+1}</td>
										<td id="pro_num">${project.get("pro_num")}<#if project.get("is_bl")=="1"><label style="color:red">(补量)</label></#if></td>
										<td id="acti_name">${project.get("acti_name")}</td>
										<td id="ini_man">${project.get("ini_man")}</td>
										<td id="ini_date">${project.get("ini_date")?date}</td>
										<td id="service_type">
											<#switch project.get("service_type")>
												<#case "0">
													看车团
													<#break>
												<#case "1">
													直销
													<#break>
												<#case "2">
													车展
													<#break>
												<#case "3">
													大客户
													<#break>
												<#case "4">
													经销商
													<#break>
											</#switch>
										</td>
										<td>${project.get("brand_name")!}/${project.get("car_name")!}/${project.get("model_name")!}</td>
										<td id="promo_area">
											<#if project.get("promo_prov")=="-1">
												全国
											<#else>
												<#if project.get("promo_city")=="-1">
													${project.get("prov_name")!}
												<#else>
													${project.get("prov_name")!}${project.get("city_name")!}
												</#if>
											</#if>
										</td>
										<td id="promo_date">${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
										<td id="acti_date">${project.get("acti_start_date")?date}至 ${project.get("acti_end_date")?date}</td>
										<td id="custom_service">${project.get("custom_service")!}</td>
										<td>
											<#if project.get("is_bl")=="0">
												<a class="btn_examine" href="javascript:examine('${project.get("pro_num")}')">审核</a>
											<#else>
												<a class="btn_examine" href="javascript:examineBl('${project.get("pro_num")}')">审核</a>
											</#if>
										</td>
									</tr>
								</#list>
								
							</tbody>
						</table>
	</div>
	
	
	<div id="modal_examine" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
		<input type="hidden" id="examine_is_bl" value="">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title" id="examine_title">项目审核</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<table class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td>项目编号</td>
                            <td id="examine_pro_num"></td>
                            <td>发起人</td>
                            <td id="examine_ini_man_name"></td>
                            <td>发起日期</td>
                            <td id="examine_ini_date"></td>
                        </tr>
                        <tr>
                        	<td>业务类型</td>
                            <td id="examine_service_type"></td>
                            <td>关联合同号</td>
                            <td id="examine_contact_num"></td>
                            <td>客户名称</td>
                            <td id="examine_cust_name"></td>
                        </tr>
                        <tr>
                            <td>渠道/车系/车型</td>
                            <td id="examine_brand_car_model" colspan="2"></td>
                            <td>竞品</td>
                            <td id="examine_competing_name" colspan="2"></td>
                        </tr>
                        <tr id="data_source_area">
                            <td>数据源</td>
                            <td id="examine_data_source_name" colspan="5"></td>
                        </tr>
                        <tr>
                        	<td>合同起止时间：</td>
                            <td id="examine_contact_date"></td>
                            <td>推广起止时间：</td>
                            <td id="examine_promo_date"></td>
                            <td>活动起止时间：</td>
                            <td id="examine_acti_date"></td>
                        </tr>
                        <tr>
                        	<td>目标线索量:</td>
                            <td id="examine_tar_clue_num"></td>
                            <td>目标到达量：</td>
                            <td id="examine_tar_reach_num"></td>
                            <td>目标成交量:</td>
                            <td id="examine_tar_trans_num"></td>
                        </tr>
                        <tr>
                        	<td>责任客服:</td>
                            <td id="examine_custom_service_name"></td>
                            <td>推广地区</td>
                            <td id="examine_promo_area"></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button id="bt_pro_no" type="button" class="btn btn-default" style="width:80px;" onclick="examinePro('reject');">驳回</button>
            <button id="bt_pro_yes" type="button" class="btn blue" onclick="examinePro('pass');">审核通过</button>
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
function examine(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data);
			var examine_pro_num = p[0].pro_num;
			$("#examine_pro_num").text(examine_pro_num);
			var examine_service_type = p[0].service_type;
			var service_type = "";
			if(examine_service_type==0){
				service_type = "看车团";
				$("#data_source_area").hide();
			}else if(examine_service_type==1){
				service_type = "直销";
				$("#data_source_area").hide();
			}else if(examine_service_type==2){
				service_type = "车展";
				$("#data_source_area").hide();
			}else if(examine_service_type==3){
				service_type = "大客户";
				$("#data_source_area").hide();
			}else if(examine_service_type==4){
				service_type = "经销商";
			}
			$("#examine_service_type").text(service_type);
			var examine_contact_num = p[0].contact_num;
			$("#examine_contact_num").text(examine_contact_num);
			var examine_cust_name = p[0].cust_name;
			$("#examine_cust_name").text(examine_cust_name);
			var examine_promo_area = p[0].promo_area;
			$("#examine_promo_area").text(examine_promo_area);
			var examine_contact_start_date = p[0].contact_start_date;
			var examine_contact_end_date = p[0].contact_end_date;
			var examine_contact_date = examine_contact_start_date+"-"+examine_contact_end_date;
			$("#examine_contact_date").text(examine_contact_date);
			var examine_promo_start_date = p[0].promo_start_date;
			var examine_promo_end_date = p[0].promo_end_date;
			var examine_promo_date = examine_promo_start_date+"-"+examine_promo_end_date;
			$("#examine_promo_date").text(examine_promo_date);
			var examine_acti_start_date = p[0].acti_start_date;
			var examine_acti_end_date = p[0].acti_end_date;
			var examine_acti_date = examine_acti_start_date+"至"+examine_acti_end_date;
			$("#examine_acti_date").text(examine_acti_date);
			var examine_tar_clue_num = p[0].tar_clue_num;
			$("#examine_tar_clue_num").text(examine_tar_clue_num);
			var examine_tar_reach_num = p[0].tar_reach_num;
			$("#examine_tar_reach_num").text(examine_tar_reach_num);
			var examine_tar_trans_num = p[0].tar_trans_num;
			$("#examine_tar_trans_num").text(examine_tar_trans_num);
			var examine_custom_service_name = p[0].custom_service_name;
			$("#examine_custom_service_name").text(examine_custom_service_name);
			var examine_ini_date = p[0].ini_date;
			$("#examine_ini_date").text(examine_ini_date);
			var examine_ini_man_name = p[0].ini_man_name;
			$("#examine_ini_man_name").text(examine_ini_man_name);
			var examine_brand_car_model="";
			var examine_brand_name = p[0].iway;
			if(is_exists(examine_brand_name)){
				examine_brand_car_model=examine_brand_name;
			}
			var examine_car_name = p[0].car_name;
			if(is_exists(examine_car_name)){
				examine_brand_car_model=examine_brand_car_model+"/"+examine_car_name;
			}
			var examine_model_name = p[0].model_name;
			if(is_exists(examine_model_name)){
				examine_brand_car_model=examine_brand_car_model+"/"+examine_model_name;
			}
			$("#examine_brand_car_model").text(examine_brand_car_model);
			var examine_data_source_name = p[0].data_source_name;
			$("#examine_data_source_name").text(examine_data_source_name);
			var examine_competing_name = p[0].competing_name;
			$("#examine_competing_name").text(examine_competing_name);
			$("#examine_is_bl").val("0");
			$("#modal_examine").modal();
    }
  });
}
function examineBl(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getBlProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data);
			var examine_pro_num = p[0].pro_num;
			$("#examine_pro_num").text(examine_pro_num);
			var examine_service_type = p[0].service_type;
			var service_type = "";
			if(examine_service_type==0){
				service_type = "看车团";
				$("#data_source_area").hide();
			}else if(examine_service_type==1){
				service_type = "直销";
				$("#data_source_area").hide();
			}else if(examine_service_type==2){
				service_type = "车展";
				$("#data_source_area").hide();
			}else if(examine_service_type==3){
				service_type = "大客户";
				$("#data_source_area").hide();
			}else if(examine_service_type==4){
				service_type = "经销商";
			}
			$("#examine_service_type").text(service_type);
			var examine_contact_num = p[0].contact_num;
			$("#examine_contact_num").text(examine_contact_num);
			var examine_cust_name = p[0].cust_name;
			$("#examine_cust_name").text(examine_cust_name);
			var examine_promo_area = p[0].promo_area;
			$("#examine_promo_area").text(examine_promo_area);
			var examine_contact_start_date = p[0].contact_start_date;
			var examine_contact_end_date = p[0].contact_end_date;
			var examine_contact_date = examine_contact_start_date+"-"+examine_contact_end_date;
			$("#examine_contact_date").text(examine_contact_date);
			var examine_promo_start_date = p[0].promo_start_date;
			var examine_promo_end_date = p[0].promo_end_date;
			var examine_promo_date = examine_promo_start_date+"-"+examine_promo_end_date;
			$("#examine_promo_date").text(examine_promo_date);
			var examine_acti_start_date = p[0].acti_start_date;
			var examine_acti_end_date = p[0].acti_end_date;
			var examine_acti_date = examine_acti_start_date+"至"+examine_acti_end_date;
			$("#examine_acti_date").text(examine_acti_date);
			var examine_tar_clue_num = p[0].tar_clue_num;
			$("#examine_tar_clue_num").text(examine_tar_clue_num);
			var examine_tar_reach_num = p[0].tar_reach_num;
			$("#examine_tar_reach_num").text(examine_tar_reach_num);
			var examine_tar_trans_num = p[0].tar_trans_num;
			$("#examine_tar_trans_num").text(examine_tar_trans_num);
			var examine_custom_service_name = p[0].custom_service_name;
			$("#examine_custom_service_name").text(examine_custom_service_name);
			var examine_ini_date = p[0].ini_date;
			$("#examine_ini_date").text(examine_ini_date);
			var examine_ini_man_name = p[0].ini_man_name;
			$("#examine_ini_man_name").text(examine_ini_man_name);
			var examine_brand_car_model="";
			var examine_brand_name = p[0].iway;
			if(is_exists(examine_brand_name)){
				examine_brand_car_model=examine_brand_name;
			}
			var examine_car_name = p[0].car_name;
			if(is_exists(examine_car_name)){
				examine_brand_car_model=examine_brand_car_model+"/"+examine_car_name;
			}
			var examine_model_name = p[0].model_name;
			if(is_exists(examine_model_name)){
				examine_brand_car_model=examine_brand_car_model+"/"+examine_model_name;
			}
			$("#examine_brand_car_model").text(examine_brand_car_model);
			var examine_data_source_name = p[0].data_source_name;
			if(is_exists(examine_data_source_name)){
				examine_data_source_name="";
			}
			$("#examine_data_source_name").text(examine_data_source_name);
			var examine_competing_name = p[0].competing_name;
			if(is_exists(examine_competing_name)){
				examine_competing_name="";
			}
			$("#examine_competing_name").text(examine_competing_name);
			$("#examine_is_bl").val("1");
			$("#examine_title").text("补量审核");
			$("#modal_examine").modal();
    }
  });
}
function examinePro(state){
	var pro_num = $("#examine_pro_num").text();
	var is_bl=$("#examine_is_bl").val();
	if(is_bl=="0"){
		$.ajax({
    		type: "POST",
    		url:"ser_examineProject",
    		data:{
				"state":state,
				"pro_num":pro_num
			},
    		success: function(data) {
				if(data==1){
					window.location.reload() ;
				}else{
					alert("error");
				}
    		}
  		});
	}else if(is_bl=="1"){
		$.ajax({
    		type: "POST",
    		url:"ser_examineBlProject",
    		data:{
				"state":state,
				"pro_num":pro_num
			},
    		success: function(data) {
				if(data==1){
					window.location.reload() ;
				}else{
					alert("error");
				}
    		}
  		});
	}
	
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined||obj=="null"){
		return false;
	}else{
		return true;
	}
}
</script>


</body>
</html>