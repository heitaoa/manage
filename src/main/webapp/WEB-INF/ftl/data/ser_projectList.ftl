<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>


<div class="row">
	<div class="col-md-12">
		<form  id="form1" action="./ser_project_list" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">发起人：</label>
					<div class="col-md-3">
						<select name="ini_man" class="form-control input-inline input-medium" id="ini_man">
							<option></option>
							<#list inimanMap?keys as ini_man>
								<option value="${ini_man}">${inimanMap.get(ini_man)}</option>
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">发起日期：</label>
					<div class="col-md-3">
						<div class="input-group input-medium date date-picker " data-date-format="yyyy-mm-dd">
                            <input name="ini_date" type="text" class="form-control" id="ini_date">
                            <span class="input-group-btn">
                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            </span>
                        </div>
					</div>
					<label class="col-md-1 control-label">业务类型：</label>
					<div class="col-md-3">
						<select name="service_type" class="form-control input-inline input-medium" id="service_type">
							<option value=""></option>
							<option value="0">看车团</option>
							<option value="1">直销</option>
							<option value="2">车展</option>
							<option value="3">大客户</option>
							<option value="4">经销商</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">渠道：</label>
					<div class="col-md-3">
						<select name="iway" class="form-control input-inline input-medium" id="iway">
							<option></option>
							<#list iwayMap?keys as iway>
								<option value="${iway}">${iwayMap.get(iway)}</option>
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">推广区域: </label>
                    	<div class="col-md-3">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="promo_prov">
								<option  value="0" <#if 0==promo_prov>selected</#if>> </option>
								<option  value="-1" <#if -1==promo_prov>selected</#if>>全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="promo_city"> 
								<option  value="0" <#if 0==promo_city>selected</#if>> </option>
								<#if promo_prov!=0&&promo_prov!=-1>
									<option  value="-1" <#if -1==promo_city>selected</#if>>全省</option>
								</#if>
								<#list citys as c>
									<option  value="${c.catalogid}" <#if c.catalogid==promo_city>selected</#if>>${c.lname}&nbsp;${c.catalogname}</option>
								</#list>
							</select>
                    	</div>
                    <label class="col-md-1 control-label">状态：</label>
					<div class="col-md-3">
						<select name="pro_state" class="form-control input-inline input-medium" id="pro_state">
							<option></option>
							<#--<option value="0">待审核</option>-->
							<option value="1">审核通过</option>
							<option value="2">驳回</option>
							<option value="3">推广部通过</option>
							<option value="4">推广部驳回</option>
							<option value="5">已结束</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-9"></div>
					<div class="col-md-1">
						<button  type="reset" class="btn blue" style="width:100px;">重置</button>
					</div>
					<div class="col-md-1">
						<input id="page" name="page" type="hidden" value="1" />
						<button  type="submit" class="btn blue" style="width:100px;">查询</button>
					</div>
				</div>					
			</div>
		</form>
	</div>

	<div class="col-md-12">
		
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
		
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>推广项目列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
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
									<th class="text-center">目标线索量</th>
                                    <th class="text-center">实际线索量</th>
                                    <th class="text-center">有效线索量</th>
									<th class="text-center">状态</th>
									<th class="text-center"> 操作</th>
								</tr>
							</thead>
							<tbody>
								<#list projectList as project>
									<tr>
										<td>${project_index+1}</td>
										<td id="pro_num">${project.get("pro_num")!}<#if project.get("is_bl")=="1"><label style="color:red">(补量)</label></#if></td>
										<td id="acti_name">${project.get("acti_name")!}</td>
										<td id="ini_man">${project.get("ini_man")!}</td>
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
										<td>${project.get("iway")!}/${project.get("car_name")!}/${project.get("model_name")!}</td>
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
										<td>${project.get("tar_clue_num")!}</td>
                                    	<td>${project.get("baoming_count")!}</td>
                                    	<td>${project.get("visit_count")!}</td>
                                    	<#if project.get("pro_state")??>
										<#switch project.get("pro_state")>
											<#case "0">
												<td style="color:#F00">待审核</td>
												<#break>
											<#case "1">
												<td style="color:#06F">已通过</td>
												<#break>
											<#case "2">
												<td style="color:#333">已驳回</td>
												<#break>
											<#case "3">
												<td style="color:#06F">推广部通过</td>
												<#break>
											<#case "4">
												<td style="color:#333">推广部驳回</td>
												<#break>
											<#case "5">
												<td style="color:#06F">已结束</td>
												<#break>
										</#switch>
										</#if>
										<td>
											<a href="javascript:view('${project.get("pro_num")}');" class="btn btn-circle btn-xs blue">查看</a>
											<#if project.get("pro_state")=="3">
												<a href="javascript:viewHdsj('${project.get("pro_num")}')" class="btn btn-circle btn-xs blue">查看活动数据</a>
											<#elseif project.get("pro_state")=="5">
												<a href="javascript:viewHdxq('${project.get("pro_num")}');" class="btn btn-circle btn-xs blue">查看活动详情</a>
											</#if>
										</td>
									</tr>
								</#list>
								
							</tbody>
						</table>
				</div>
				<#if pages gt 0>
				<div class="row">
					<div class="col-md-5 col-sm-12">
						<div style="height:50px; line-height:50px; font-size:14px;">
							当前第${page}页，共${pages}页
						</div>
					</div>
					<!-- 分页start -->
					<div class="col-md-7 col-sm-12">
				        <ul class="pagination">
				            <#if page==1>
				            	<li class="active">
				                    <a href="#" style=" height:32px;"><i class="fa fa-angle-left"></i></a>
				                </li>
				            <#else>
				            	<li>
				                    <a href="javascript:toPage(${page-1})" style=" height:32px;"><i class="fa fa-angle-left"></i></a>
				                </li>
				            </#if>
				            
				            <#list pageList as p>
				            	<#if page==p?eval >
				                	<li class="active">
				                    	<a href="#">${p}</a>
				                    </li>
				                <#else>
				                	<li>
				                    	<a href="javascript:toPage(${p})">${p}</a>
				                    </li>
				                </#if>
				            	
				            </#list>
				            <#if page+pageList?size-1!=pages >
				            	<li>
				                    <a>...</a>
				                </li>
				            </#if>
				            <#if page==pages >
				            	<li class="active">
				                    <a href="#" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
				                </li>
				            <#else>
				            	<li>
				                    <a href="javascript:toPage(${page+1})" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
				                </li>
				            </#if>
				            
				        </ul>
				    </div>
				    <!-- 分页end -->
				</div>
				</#if>
			</div>
			
		</div>
		
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
                            <td>品牌/车系/车型</td>
                            <td id="examine_brand_car_model" colspan="2"></td>
                            <td>竞品</td>
                            <td id="examine_competing_name" colspan="2"></td>
                        </tr>
                        <tr id="examine_data_source_area">
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
	
	
	
	<div id="modal_lookPro" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">项目详情</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<table class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td>项目编号</td>
                            <td id="view_pro_num"></td>
                            <td>发起人</td>
                            <td id="view_ini_man_name"></td>
                            <td>发起日期</td>
                            <td id="view_ini_date"></td>
                        </tr>
                        <tr>
                        	<td>业务类型</td>
                            <td id="view_service_type"></td>
                            <td>关联合同号</td>
                            <td id="view_contact_num"></td>
                            <td>客户名称</td>
                            <td id="view_cust_name"></td>
                        </tr>
                        <tr>
                            <td>品牌/车系/车型</td>
                            <td id="view_brand_car_model" colspan="2"></td>
                            <td>竞品</td>
                            <td id="view_competing_name" colspan="2"></td>
                        </tr>
                        <tr id="view_data_source_area">
                            <td>数据源</td>
                            <td id="view_data_source_name" colspan="5"></td>
                        </tr>
                        <tr>
                        	<td>合同起止时间：</td>
                            <td id="view_contact_date"></td>
                            <td>推广起止时间：</td>
                            <td id="view_promo_date"></td>
                            <td>活动起止时间：</td>
                            <td id="view_acti_date"></td>
                        </tr>
                        <tr>
                        	<td>目标线索量:</td>
                            <td id="view_tar_clue_num"></td>
                            <td>目标到达量：</td>
                            <td id="view_tar_reach_num"></td>
                            <td>目标成交量:</td>
                            <td id="view_tar_trans_num"></td>
                        </tr>
                        <tr>
                        	<td>责任客服:</td>
                            <td id="view_custom_service_name"></td>
                            <td>推广地区</td>
                            <td id="view_promo_area"></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
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

$("#service_type").val("${service_type!}");
$("#ini_date").val("${ini_date!}");
$("#ini_man").val("${ini_man!}");
$("#iway").val("${iway!}");
$("#promo_area").val("${promo_area!}");
$("#pro_state").val("${pro_state!}");
	$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			var now = ${promo_prov};
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(now==city[i].catalogid){
						html ='<option value='+city[i].catalogid+' selected>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					}else{
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					}
					$("#promo_prov").append(html);
				}
    		}
	});
	$("#promo_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#promo_city").empty();
		$("#promo_city").append("<option value='0'> </option>");
		if(fatherid!=0&&fatherid!=-1){
			$("#promo_city").append("<option value='-1'>全省</option>");
		}
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
						$("#promo_city").append(html);
					}
    			}
			});
		}
	
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
				$("#examine_data_source").hide();
			}else if(examine_service_type==1){
				service_type = "直销";
				$("#examine_data_source").hide();
			}else if(examine_service_type==2){
				service_type = "车展";
				$("#examine_data_source").hide();
			}else if(examine_service_type==3){
				service_type = "大客户";
				$("#examine_data_source").hide();
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
			$("#examine_data_source_area").hide();
			if(examine_service_type==0){
				service_type = "看车团";
			}else if(examine_service_type==1){
				service_type = "直销";
			}else if(examine_service_type==2){
				service_type = "车展";
			}else if(examine_service_type==3){
				service_type = "大客户";
			}else if(examine_service_type==4){
				service_type = "经销商";
				$("#examine_data_source_area").show();
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
			$("#examine_is_bl").val("1");
			$("#examine_title").text("补量审核");
			$("#modal_examine").modal();
    }
  });
}
function view(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data)
			var view_pro_num = p[0].pro_num;
			$("#view_pro_num").text(view_pro_num);
			var view_service_type = p[0].service_type;
			var service_type = "";
			$("#view_data_source_area").hide();
			if(view_service_type==0){
				service_type = "看车团";
			}else if(view_service_type==1){
				service_type = "直销";
			}else if(view_service_type==2){
				service_type = "车展";
			}else if(view_service_type==3){
				service_type = "大客户";
			}else if(view_service_type==4){
				service_type = "经销商";
				$("#view_data_source_area").show();
			}
			$("#view_service_type").text(service_type);
			var view_contact_num = p[0].contact_num;
			$("#view_contact_num").text(view_contact_num);
			var view_cust_name = p[0].cust_name;
			$("#view_cust_name").text(view_cust_name);
			var view_promo_area = p[0].promo_area;
			$("#view_promo_area").text(view_promo_area);
			var view_contact_start_date = p[0].contact_start_date;
			var view_contact_end_date = p[0].contact_end_date;
			var view_contact_date = view_contact_start_date+"至"+view_contact_end_date;
			$("#view_contact_date").text(view_contact_date);
			var view_promo_start_date = p[0].promo_start_date;
			var view_promo_end_date = p[0].promo_end_date;
			var view_promo_date = view_promo_start_date+"至"+view_promo_end_date;
			$("#view_promo_date").text(view_promo_date);
			var view_acti_start_date = p[0].acti_start_date;
			var view_acti_end_date = p[0].acti_end_date;
			var view_acti_date = view_acti_start_date+"至"+view_acti_end_date;
			$("#view_acti_date").text(view_acti_date);
			var view_tar_clue_num = p[0].tar_clue_num;
			$("#view_tar_clue_num").text(view_tar_clue_num);
			var view_tar_reach_num = p[0].tar_reach_num;
			$("#view_tar_reach_num").text(view_tar_reach_num);
			var view_tar_trans_num = p[0].tar_trans_num;
			$("#view_tar_trans_num").text(view_tar_trans_num);
			var view_custom_service_name = p[0].custom_service_name;
			$("#view_custom_service_name").text(view_custom_service_name);
			var view_ini_date = p[0].ini_date;
			$("#view_ini_date").text(view_ini_date);
			var view_ini_man_name = p[0].ini_man_name;
			$("#view_ini_man_name").text(view_ini_man_name);
			var view_brand_car_model="";
			var view_brand_name = p[0].iway;
			if(is_exists(view_brand_name)){
				view_brand_car_model=view_brand_name;
			}
			var view_car_name = p[0].car_name;
			if(is_exists(view_car_name)){
				view_brand_car_model=view_brand_car_model+"/"+view_car_name;
			}
			var view_model_name = p[0].model_name;
			if(is_exists(view_model_name)){
				view_brand_car_model=view_brand_car_model+"/"+view_model_name;
			}
			$("#view_brand_car_model").text(view_brand_car_model);
			var view_data_source_name = p[0].data_source_name;
			$("#view_data_source_name").text(view_data_source_name);
			var view_competing_name = p[0].competing_name;
			$("#view_competing_name").text(view_competing_name);
			$("#modal_lookPro").modal();
    }
  });
}	
function viewBl(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getBlProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data)
			var view_pro_num = p[0].pro_num;
			$("#view_pro_num").text(view_pro_num);
			var view_service_type = p[0].service_type;
			var service_type = "";
			$("#view_data_source_area").hide();
			if(view_service_type==0){
				service_type = "看车团";
			}else if(view_service_type==1){
				service_type = "直销";
			}else if(view_service_type==2){
				service_type = "车展";
			}else if(view_service_type==3){
				service_type = "大客户";
			}else if(view_service_type==4){
				service_type = "经销商";
				$("#view_data_source_area").show();
			}
			$("#view_service_type").text(service_type);
			var view_contact_num = p[0].contact_num;
			$("#view_contact_num").text(view_contact_num);
			var view_cust_name = p[0].cust_name;
			$("#view_cust_name").text(view_cust_name);
			var view_promo_area = p[0].promo_area;
			$("#view_promo_area").text(view_promo_area);
			var view_contact_start_date = p[0].contact_start_date;
			var view_contact_end_date = p[0].contact_end_date;
			var view_contact_date = view_contact_start_date+"至"+view_contact_end_date;
			$("#view_contact_date").text(view_contact_date);
			var view_promo_start_date = p[0].promo_start_date;
			var view_promo_end_date = p[0].promo_end_date;
			var view_promo_date = view_promo_start_date+"至"+view_promo_end_date;
			$("#view_promo_date").text(view_promo_date);
			var view_acti_start_date = p[0].acti_start_date;
			var view_acti_end_date = p[0].acti_end_date;
			var view_acti_date = view_acti_start_date+"至"+view_acti_end_date;
			$("#view_acti_date").text(view_acti_date);
			var view_tar_clue_num = p[0].tar_clue_num;
			$("#view_tar_clue_num").text(view_tar_clue_num);
			var view_tar_reach_num = p[0].tar_reach_num;
			$("#view_tar_reach_num").text(view_tar_reach_num);
			var view_tar_trans_num = p[0].tar_trans_num;
			$("#view_tar_trans_num").text(view_tar_trans_num);
			var view_custom_service_name = p[0].custom_service_name;
			$("#view_custom_service_name").text(view_custom_service_name);
			var view_ini_date = p[0].ini_date;
			$("#view_ini_date").text(view_ini_date);
			var view_ini_man_name = p[0].ini_man_name;
			$("#view_ini_man_name").text(view_ini_man_name);
			var view_brand_car_model="";
			var view_brand_name = p[0].iway;
			if(is_exists(view_brand_name)){
				view_brand_car_model=view_brand_name;
			}
			var view_car_name = p[0].car_name;
			if(is_exists(view_car_name)){
				view_brand_car_model=view_brand_car_model+"/"+view_car_name;
			}
			var view_model_name = p[0].model_name;
			if(is_exists(view_model_name)){
				view_brand_car_model=view_brand_car_model+"/"+view_model_name;
			}
			$("#view_brand_car_model").text(view_brand_car_model);
			var view_data_source_name = p[0].data_source_name;
			$("#view_data_source_name").text(view_data_source_name);
			var view_competing_name = p[0].competing_name;
			$("#view_competing_name").text(view_competing_name);
			$("#modal_lookPro").modal();
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
function toPage(page){
		$("#page").val(page);
		$("#form1").submit();
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined||obj=="null"){
		return false;
	}else{
		return true;
	}
}
function viewHdxq(pro_num){
	window.parent.openNew('查看活动详情','./ser_viewHdxq?pro_num='+pro_num);
}
function viewHdsj(pro_num){
	window.parent.openNew('查看活动数据','./ser_viewQiandaoList?page=1&pro_num='+pro_num);
}
</script>


</body>
</html>