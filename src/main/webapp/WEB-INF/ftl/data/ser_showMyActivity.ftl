<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-top:10px;">
	 <div class="col-md-12">
	 	<a  class="btn blue pull-right" style=" float:right; position:relative; top:3px;" onclick="addProject();">+发起新推广需求</a>
    	<div>
            <ul class="nav nav-tabs">
            	<li class="active">
                    <a href="#tab_1_1" data-toggle="tab">正在进行</a>
                </li>
                <li>
                    <a href="#tab_1_2" data-toggle="tab">已结束 </a>
                </li>
            </ul>
            
            <div class="tab-content">
            	<div class="tab-pane active fontawesome-demo" id="tab_1_1">
                	<div class="row">
                        <div class="col-md-12">
                            <table class="table table-condensed table-bordered table-hover">
                                <thead>
                                <tr role="row" class="heading">
                                    <th>序号</th>
                                    <th>项目编号</th>
                                    <th>活动名称</th>
                                    <th>申请日期</th>
                                    <th>业务类型</th>
                                    <th>渠道/车系/车型</th>
                                    <th>推广区域</th>
                                    <th>推广起止时间</th>
									<th>活动起止时间</th>
                                    <th>责任客服</th>
                                    <th>目标线索量</th>
                                    <th>实际线索量</th>
                                    <th>有效线索量</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list onGoing as p>
                                			<tr>
                                    			<td>${p_index+1}</td>
                                    			<td class="pro_num">
                                    				<#if p.get("pro_num")??>
                                    					${p.get("pro_num")}
                                    				</#if>
                                    			</td>
                                    			<td class="pro_num">
                                    				<#if p.get("acti_name")??>
                                    					${p.get("acti_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("ini_date")??>
                                    					${p.get("ini_date")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("service_type")??>
                                    					<#switch p.get("service_type") >
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
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("brand_car_model")??&&p.get("brand_car_model")!="null">
                                    					${p.get("brand_car_model")}
                                    				<#else>
                                    					
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("promo_area")??>
                                    					${p.get("promo_area")}
                                    				</#if>
                                    			</td>
                                    			<td>${p.get("promo_start_date")}至 ${p.get("promo_end_date")}</td>
												<td>${p.get("acti_start_date")}至 ${p.get("acti_end_date")}</td>
                                    			<td>
                                    				<#if p.get("custom_service_name")??>
                                    					${p.get("custom_service_name")}
                                    				</#if>
                                    			</td>
                                    			<td>${p.get("tar_clue_num")!}</td>
                                    			<td>${p.get("baoming_count")!}</td>
                                    			<td>${p.get("visit_count")!}</td>
                                    			<td>
                                    				<a href="javascript:view('${p.get("pro_num")}');" class="btn btn-circle btn-xs blue">查看</a>
                                    				<a href="javascript:viewHdsj('${p.get("pro_num")}')" class="btn btn-circle btn-xs blue">查看数据</a>
                                    				</br>
                                    				<a href="javascript:editProject('${p.get("pro_num")}');" class="btn btn-circle btn-xs blue">补量</a>
                                    				<a href="javascript:hdxq(${p.get("service_type")},'${p.get("pro_num")}');" class="btn btn-circle btn-xs blue">填写详情</a>
                                    			</td>
                                			</tr>
                                		</#list>
                                </tbody>
                             </table>
                        </div>
                        
                    </div>
                </div>
                
                <div class="tab-pane" id="tab_1_2">
                	<div class="row">
                                <div class="col-md-12">
                                    <table class="table table-condensed table-bordered table-hover">
                                        <thead>
                                        <tr role="row" class="heading">
                                            <th>序号</th>
                                    		<th>项目编号</th>
                                    		<th>活动名称</th>
                                    		<th>申请日期</th>
                                    		<th>业务类型</th>
                                    		<th>渠道/车系/车型</th>
                                    		<th>推广区域</th>
                                    		<th>推广起止时间</th>
											<th>活动起止时间</th>
                                    		<th>责任客服</th>
                                    		<th>目标线索量</th>
                                    		<th>实际线索量</th>
                                   	 		<th>有效线索量</th>
                                   	 		<th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list end as p>
                                			<tr>
                                    			<td>${p_index+1}</td>
                                    			<td class="pro_num">
                                    				<#if p.get("pro_num")??>
                                    					${p.get("pro_num")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("acti_name")??>
                                    					${p.get("acti_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("ini_date")??>
                                    					${p.get("ini_date")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("service_type")??>
                                    					<#switch p.get("service_type") >
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
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("brand_car_model")??&&p.get("brand_car_model")!="null">
                                    					${p.get("brand_car_model")}
                                    				<#else>
                                    					
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("promo_area")??>
                                    					${p.get("promo_area")}
                                    				</#if>
                                    			</td>
                                    			<td>${p.get("promo_start_date")}至 ${p.get("promo_end_date")}</td>
												<td>${p.get("acti_start_date")}至 ${p.get("acti_end_date")}</td>
                                    			<td>
                                    				<#if p.get("custom_service_name")??>
                                    					${p.get("custom_service_name")}
                                    				</#if>
                                    			</td>
                                    			<td>${p.get("tar_clue_num")!}</td>
                                    			<td>${p.get("baoming_count")!}</td>
                                    			<td>${p.get("visit_count")!}</td>
                                    			<td>
                                    				<a href="javascript:view('${p.get("pro_num")}');" class="btn btn-circle btn-xs blue">查看</a>
                                    				<a href="javascript:viewHdxq('${p.get("pro_num")}');" class="btn btn-circle btn-xs blue">查看活动详情</a>
                                    			</td>
                                			</tr>
                                		</#list>
                                        </tbody>
                                    </table>
                                </div>
                                
                            </div>
                </div>
            </div>
            <!-- tab-content -->
        </div>
    </div>

</div>
<div id="view" class="modal fade" tabindex="-1" data-backdrop="static" data-width="80%">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">查看详情</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
         	<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>项目编号:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_pro_num"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>项目名称:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_acti_name"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>业务类型:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_service_type"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>发起日期:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_ini_date"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>状态:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_pro_state"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>关联合同号:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_contact_num"></label></h5>
				</div>
			</div>
		</div>
		<hr/>
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>客户名称:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_cust_name"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>推广地区:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_promo_area"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>渠道/车型/车系:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_brand_car_model"></label></h5>
				</div>
			</div>
			<div class="col-md-12" id="view_sjy_area">
				<div class="col-md-2 text-right">
					<h5>数据源:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_data_source_name"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>竞品:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_competing_name"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>合同起止时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_contact_start_date"></label>至<label id="view_contact_end_date"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>推广起止时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_promo_start_date"></label>至<label id="view_promo_end_date"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>活动起止时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_acti_start_date"></label>至<label id="view_acti_end_date"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>目标线索量:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_tar_clue_num"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>目标到达量:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_tar_reach_num"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>目标成交量:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_tar_trans_num"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>责任客服:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_custom_service_name"></label></h5>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="edit" class="modal fade" tabindex="-1" data-backdrop="static" data-width="90%">
	<input type="hidden" id="edit_type" value="">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">补量申请</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-12">
    		<form class="form-horizontal" action="ser_editProject"  role="form" id="editProject">
        		<div class="form-body">
        			<div class="form-group">
                		<label class="col-md-2 control-label">推广编号</label>
                		<input type="hidden" id="edit_pro_num_text" name="pro_num"/>
                		<input type="hidden" class="form-control input-medium" value="" id="edit_ini_date" name="ini_date"/>
                		<input type="hidden" class="form-control input-medium" value="" id="edit_ini_man" name="ini_man"/>
                		<input type="hidden" class="form-control input-medium" value="" id="edit_ini_dept" name="ini_dept"/>
                		<input type="hidden" class="form-control input-medium" value="" id="edit_ini_org" name="ini_org"/>
                    	<label class="col-md-4 control-label" style="text-align:left;" id="edit_pro_num"></label>
                    	<label class="col-md-2 control-label">活动名称</label>
                    	<div class="col-md-4">
                       		<input type="text" class="form-control input-medium" name="acti_name" id="edit_acti_name"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">业务类型</label>
                    	<div class="col-md-4">
                        	<select class="layout-option form-control input-medium" name="service_type" id="edit_service_type">
								<option value="0">看车团</option>
								<option value="1">直销</option>
                            	<option value="2">车展</option>
                            	<option value="3">大客户</option>
                            	<option value="4">经销商</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">关联合同号</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" value="" name="contact_num" id="edit_contact_num"/>
                    	</div>
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
                    	<label class="col-md-2 control-label">客户名称</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" name="cust_name" id="edit_cust_name"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">渠道/车系/车型</label>
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-medium" name="iway" id="edit_pinpai">
	     						<option value="-1">请选择渠道</option>
	  	 					</select>
	  	 					<select class="form-control input-inline input-medium" name="car" id="edit_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  						<select class="form-control input-inline input-medium" name="model" id="edit_chexing">
	  							<option value="-1">请选择车型</option>
	  						</select>
                    	</div>
                	</div>
                	<div class="form-group" id="sjy_fg" style="display:none">
                		<label class="col-md-1 control-label">指定数据源</label>
                		<input type="hidden" name="data_source" value="" id="edit_data_source">
                		<input type="hidden" name="data_source_name" value="" id="edit_data_source_name">
                    	<div class="col-md-7">
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
                		<label class="col-md-1 control-label"></label>
                		<div class="col-md-10">
                    		<div class="btn-group" id="sjy_group">
                    			
							</div>
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
	  	 					<select class="form-control input-inline input-medium" id="jp_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  						<div class="btn-group" id="jp_group">
                    			
							</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">合同开始时间</label>
                   		<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_start_date" id="edit_contact_start_date">
                            	<span class="input-group-btn">
                            	<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">合同结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_end_date" id="edit_contact_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广开始时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_start_date" id="edit_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">推广结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_end_date" id="edit_promo_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">活动开始时间</label>
                    	<div class="col-md-4">
                        	<div class="input-group input-medium date date-picker " data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="acti_start_date" id="edit_acti_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">活动结束时间</label>
                    	<div class="col-md-4">
                        	<div class="input-group input-medium date date-picker " data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="acti_end_date" id="edit_acti_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">目标线索量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-small" name="tar_clue_num" id="edit_tar_clue_num"/>
                    	</div>
                    	<label class="col-md-2 control-label">目标到达量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-small" name="tar_reach_num" id="edit_tar_reach_num"/>
                    	</div>
                    	<label class="col-md-2 control-label">目标成交量</label>
                    	<div class="col-md-2">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-small" name="tar_trans_num" id="edit_tar_trans_num"/>
                    	</div>
               	   </div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">责任客服</label>
                    	<input type="hidden" name="custom_service" id="edit_custom_service" value="">
                    	<input type="hidden" name="custom_service_name" id="edit_custom_service_name" value="">
                    	<div class="col-md-10">
                    		<select class="form-control input-inline input-small" id="edit_custom_org">
	  							<#list orglist as org>
	  								<option value="${org.code}" <#if org.code==info.orgCode>selected</#if> >${org.name}</option>
	  							</#list>
	  						</select>
	  						<select class="form-control input-inline input-small" id="edit_custom_name">
	  							<option value="-1">请选择客服</option>
	  							<#list customServices as cs>
	  								<option value="${cs.id}">${cs.name}</option>
	  							</#list>
	  						</select>
                    		<div class="btn-group" id="cs_group">
                    			
							</div>
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
					$("#sjy_pinpai").append(html);
				}
    		}

	});
	$("#edit_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#edit_chexi").empty();
		$("#edit_chexing").empty();
		$("#edit_chexi").append("<option value='-1'>请选择车系</option>");
		$("#edit_chexing").append("<option value='-1'>请选择车型</option>");
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
					$("#edit_chexi").append(html);
				}
    		}
		});
	
	});
	$("#jp_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

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
		 var jp = $("#edit_competing").val();
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
	
	$("#edit_chexi").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#edit_chexing").empty();
		$("#edit_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#edit_chexing").append(html);
				}
    		}
		});
	
	});
	
	$("#edit_service_type").change(function(){
		$("#edit_pinpai").val("-1");
		$("#edit_chexi").val("-1");
		$("#edit_chexing").val("-1");
		
		$("#edit_pinpai").removeAttr("disabled");
		$("#edit_chexi").removeAttr("disabled");
		$("#edit_chexing").removeAttr("disabled");
		$("#sjy_fg").hide();
		$("#sjy_g_fg").hide();
		var type = $(this).children('option:selected').val();
		if(type==0){
			$("#edit_chexing").attr("disabled","disabled");
			$("#edit_chexi").attr("disabled","disabled");
		}else if(type==2){
			$("#edit_pinpai").attr("disabled","disabled");
			$("#edit_chexi").attr("disabled","disabled");
			$("#edit_chexing").attr("disabled","disabled");
		}else if(type==4){
			$("#edit_chexi").attr("disabled","disabled");
			$("#edit_chexing").attr("disabled","disabled");
			$("#sjy_fg").show();
			$("#sjy_g_fg").show();
		}
		
	});
	$("#edit_service_type").change(function(){
		$("#edit_pinpai").val("-1");
		$("#edit_chexi").val("-1");
		$("#edit_chexing").val("-1");
		var type = $(this).children('option:selected').val();
		
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
					$("#sjy_prov").append(html);
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
	$("#edit_custom_org").change(function(){
			var org = $(this).children('option:selected').val();
			$("#edit_custom_name").empty();
			$("#edit_custom_name").append('<option value="-1">请选择客服</option>');
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
						$("#edit_custom_name").append(html);
					}
    			}
   			});	
	});
	$("#edit_custom_name").change(function(){
			var id = $(this).children('option:selected').val();
			var name = $(this).children('option:selected').html();
			if(id=="-1"){
				return;
			}
			$("#edit_custom_name").val("-1");
			var cs_value=$("#edit_custom_service").val();
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
			$("#edit_custom_service").val(cs_value);
			var html='<button type="button" class="btn btn-default d" id="kf'+id+'">'+name+'</button>';
			$("#cs_group").append(html);
			$("#kf"+id).dblclick(function(){
				var cs_value2=$("#edit_custom_service").val();
				var arr2 = cs_value2.split(",");
				arr2.splice($.inArray(id,arr2),1);
				cs_value2 = arr2.join(",");
				$("#edit_custom_service").val(cs_value2)
				$(this).remove();	
			});
	});	
});
function hdxq(type,pro_num){
	if(type=="0"){
		window.parent.openNew('看车团活动详情填写','./ser_enterKctEditQiandao?pro_num='+pro_num);
	}
}
function edit(){
	var edit_service_type = $("#edit_service_type").val();
	var edit_contact_num = $("#edit_contact_num").val();
	var	edit_acti_name = $("#edit_acti_name").val();
	var	edit_acti_start_date = $("#edit_acti_start_date").val();
	var	edit_acti_end_date = $("#edit_acti_end_date").val();
	var	edit_promo_prov = $("#edit_promo_prov").val();
	var	edit_promo_city = $("#edit_promo_city").val();
	var	edit_cust_name = $("#edit_cust_name").val();
	var	edit_pinpai = $("#edit_pinpai").val();
	var	edit_chexi = $("#edit_chexi").val();
	var	edit_chexing = $("#edit_chexing").val();
	var	edit_contact_start_date = $("#edit_contact_start_date").val();
	var	edit_contact_end_date = $("#edit_contact_end_date").val();
	var	edit_promo_start_date = $("#edit_promo_start_date").val();
	var	edit_promo_end_date = $("#edit_promo_end_date").val();
	var	edit_tar_clue_num = $("#edit_tar_clue_num").val();
	var	edit_tar_reach_num = $("#edit_tar_reach_num").val();
	var	edit_tar_trans_num = $("#edit_tar_trans_num").val();
	var	edit_custom_service = $("#edit_custom_service").val();
	var	edit_custom_service_name = $("#edit_custom_service_name").val();
	var edit_competing = $("#edit_competing").val();
	var custom_service_name_arr = new Array();
	$("#cs_group button").each(function(){
		var name = $(this).text();
		custom_service_name_arr.push(name);
	});
	var cs_names = custom_service_name_arr.join(",");
	$("#edit_custom_service_name").val(cs_names);
	var competing_name_arr = new Array();
	$("#jp_group button").each(function(){
		var name = $(this).text();
		competing_name_arr.push(name);
	});
	var jp_names = competing_name_arr.join(",");
	$("#edit_competing_name").val(jp_names);
	var data_source_name_arr = new Array();
	$("#sjy_group button").each(function(){
		var name = $(this).text();
		data_source_name_arr.push(name);
	});
	var sjy_names = data_source_name_arr.join(",");
	$("#edit_data_source_name").val(sjy_names);
	if("0"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
	}else if("1"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
		if(edit_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		if(edit_chexing=="-1"){
			alert("请选择车型");
			return;
		}
	}else if("3"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择渠道");
			return;
		}
		if(edit_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		
	}
	if(!is_exists(edit_contact_num)){
		alert("请输入关联合同号");
		return;
	}
	if(!is_exists(edit_acti_name)){
		alert("请输入活动名称");
		return;
	}
	if(!is_exists(edit_acti_start_date)){
		alert("请输入活动开始时间");
		return;
	}
	if(!is_exists(edit_acti_end_date)){
		alert("请输入活动结束时间");
		return;
	}
	if(!is_exists(edit_cust_name)){
		alert("请输入客户名称");
		return;
	}
	if(!is_exists(edit_contact_start_date)){
		alert("请输入合同开始日期");
		return;
	}
	if(!is_exists(edit_contact_end_date)){
		alert("请输入合同终止日期");
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
	if(!is_exists(edit_tar_clue_num)){
		alert("请输入目标线索量");
		return;
	}
	if(!is_exists(edit_tar_trans_num)){
		alert("请输入目标到达量");
		return;
	}
	if(!is_exists(edit_tar_reach_num)){
		alert("请输入目标成交量");
		return;
	}
	if(!is_exists(edit_custom_service)||!is_exists(cs_names)){
		alert("请选择责任客服");
		return;
	}
	var edit_type=$("#edit_type").val();
	$.ajax({
    		type: "POST",
    		url:"ser_saveBl",
    		data:$('#editProject').serialize(),
    		success: function(data) {
    			if(data==1){
					alert("补量添加成功！");
					window.location.reload();
				}else if(data==2){
					alert("当前已存在补量，不能重复补量，当前补量审核生效后才可以进一步补量！");
				}else{
					alert("error");
				}
    		}
  	});
	
}
function editProject(pro_num){
	$("#edit_type").val("normal");
	$("#edit_chexi").empty();
	$("#edit_chexing").empty();
	$("#edit_chexi").append("<option value='-1'>请选择车系</option>");
	$("#edit_chexing").append("<option value='-1'>请选择车型</option>");
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
			var edit_service_type = p[0].service_type;
			$("#edit_service_type").val(edit_service_type);
			var edit_contact_num = p[0].contact_num;
			$("#edit_contact_num").val(edit_contact_num);
			var edit_cust_name = p[0].cust_name;
			$("#edit_cust_name").val(edit_cust_name);
			var	edit_acti_name = p[0].acti_name;
			$("#edit_acti_name").val(edit_acti_name);
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
    				}
				});
			}
			$("#edit_promo_city").val(edit_promo_city);
			var edit_contact_start_date = p[0].contact_start_date;
			$("#edit_contact_start_date").val(edit_contact_start_date);
			var edit_contact_end_date = p[0].contact_end_date;
			$("#edit_contact_end_date").val(edit_contact_end_date);
			var edit_promo_start_date = p[0].promo_start_date;
			$("#edit_promo_start_date").val(edit_promo_start_date);
			var edit_promo_end_date = p[0].promo_end_date;
			$("#edit_promo_end_date").val(edit_promo_end_date);
			var edit_acti_start_date = p[0].acti_start_date;
			$("#edit_acti_start_date").val(edit_acti_start_date);
			var edit_acti_end_date = p[0].acti_end_date;
			$("#edit_acti_end_date").val(edit_acti_end_date);
			var edit_tar_clue_num = p[0].tar_clue_num;
			$("#edit_tar_clue_num").val(edit_tar_clue_num);
			var edit_tar_reach_num = p[0].tar_reach_num;
			$("#edit_tar_reach_num").val(edit_tar_reach_num);
			var edit_tar_trans_num = p[0].tar_trans_num;
			$("#edit_tar_trans_num").val(edit_tar_trans_num);
			var edit_custom_service = p[0].custom_service;
			$("#edit_custom_service").val(edit_custom_service);
			var edit_custom_service_name = p[0].custom_service_name;
			var edit_custom_service_arr = new Array();
			if(is_exists(edit_custom_service)){
				edit_custom_service_arr = edit_custom_service.split(",");
			}
			var edit_custom_service_name_arr = new Array();
			if(is_exists(edit_custom_service_name)){
				edit_custom_service_name_arr = edit_custom_service_name.split(",");
			}
			$("#cs_group").empty();
			for(var i=0;i<edit_custom_service_arr.length;i++){
				var id = edit_custom_service_arr[i];
				var name = edit_custom_service_name_arr[i];
				var html='<button type="button" class="btn btn-default" id="kf'+id+'">'+name+'</button>';
				$("#cs_group").append(html);
				$("#kf"+id).dblclick(function(){
					var id2 = $(this).attr("id").replace("kf","");
					var cs_value2=$("#edit_custom_service").val();
					var arr2 = cs_value2.split(",");
					arr2.splice($.inArray(id2,arr2),1);
					cs_value2 = arr2.join(",");
					$("#edit_custom_service").val(cs_value2)
					$(this).remove();	
				});
			}
			var edit_ini_date = p[0].ini_date;
			$("#edit_ini_date").val(edit_ini_date);
			var edit_ini_man = p[0].ini_man;
			$("#edit_ini_man").val(edit_ini_man);
			var edit_ini_dept = p[0].ini_dept;
			$("#edit_ini_dept").val(edit_ini_dept);
			var edit_ini_org = p[0].ini_org;
			$("#edit_ini_org").val(edit_ini_org);
			var edit_brand_name = p[0].iway;
			var edit_brand = p[0].iway;
			var edit_car_name = p[0].car_name;
			var edit_car = p[0].car;
			var edit_model_name = p[0].model_name;
			var edit_model = p[0].model;
			$("#edit_pinpai").val(edit_brand);
			if(edit_brand!=""&&edit_brand!="-1"){
				$.ajax({
    				url : 'getCarsx',
    				dataType : 'jsonp',
    				data :{brandNmae:encodeURI(edit_brand)},
    				jsonp:'jsonpcallback',
    				success : function(data){
	    				carBrand = data;
						for(var i =0 ;i<carBrand.length;i++)
						{
							var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
							$("#edit_chexi").append(html);
						}
						$("#edit_chexi").val(edit_car);
    				}
				});
			}
			$("#edit_chexi").val(edit_car);
			if(edit_car!=-1){
				$.ajax({
    				url : './queryCarInfo?fatherid='+edit_car,
    				dataType : 'jsonp',
    				jsonp:'jsonpcallback',
    				success : function(data){
	    				carBrand = data;
						for(var i =0 ;i<carBrand.length;i++)
						{
							var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
							$("#edit_chexing").append(html);
						}
    				}
				});
			}
			$("#edit_chexing").val(edit_model);
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
			var edit_data_source = p[0].data_source;
			$("#edit_data_source").val(edit_data_source);
			var edit_data_source_name = p[0].data_source_name;
			var edit_data_source_arr = new Array();
			if(is_exists(edit_data_source)){
				edit_data_source_arr = edit_data_source.split(",");
			}
			var edit_data_source_name_arr = new Array();
			if(is_exists(edit_data_source_name)){
				edit_data_source_name_arr = edit_data_source_name.split(",");
			}
			$("#sjy_group").empty();
			for(var i=0;i<edit_data_source_name_arr.length;i++){
				var id= edit_data_source_arr[i];
				var name = edit_data_source_name_arr[i];
				var html='<button type="button" class="btn btn-default" id="sjy'+id+'">'+name+'</button>';
				$("#sjy_group").append(html);
				$("#sjy"+id).dblclick(function(){
				    var id2 = $(this).attr("id").replace("sjy","");
					var sjy2=$("#edit_data_source").val();
					var arr2 = sjy2.split(",");
					arr2.splice($.inArray(id2,arr2),1);
					sjy2 = arr2.join(",");
					$("#edit_data_source").val(sjy2)
					$(this).remove();	
				});
			}
			
			$("#edit_pinpai").removeAttr("disabled");
			$("#edit_chexi").removeAttr("disabled");
			$("#edit_chexing").removeAttr("disabled");
			
			var type = edit_service_type;
			if(type==0){
				$("#edit_chexing").attr("disabled","disabled");
			}else if(type==2){
				$("#edit_pinpai").attr("disabled","disabled");
				$("#edit_chexi").attr("disabled","disabled");
				$("#edit_chexing").attr("disabled","disabled");
			}else if(type==4){
				$("#edit_chexi").attr("disabled","disabled");
				$("#edit_chexing").attr("disabled","disabled");
				$("#sjy_fg").show();
				$("#sjy_g_fg").show();
			}
			
			$("#edit .date-picker input").datepicker({
				format: 'yyyy-mm-dd',
				autoclose: true,
				todayBtn: 'linked',
				language: 'zh-CN'
			});
			
			$("#edit").modal();
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
			var view_pro_state = p[0].pro_state;
			var state = "";
			if(view_pro_state=="0"){
				state="待审核";
			}else if(view_pro_state=="1"){
				state="业务部通过";
			}else if(view_pro_state=="2"){
				state="业务部驳回";
			}else if(view_pro_state=="3"){
				state="推广部通过";
			}else if(view_pro_state=="4"){
				state="推广部驳回";
			}else if(view_pro_state=="5"){
				state="已结束";
			}
			$("#view_pro_state").text(state);
			var view_ini_man_name = p[0].ini_man_name;
			$("#view_ini_man_name").text(view_ini_man_name);
			var view_dept_name = p[0].org_name+p[0].dep_name;
			$("#view_dept_name").text(view_dept_name);
			var view_ini_date = p[0].ini_date;
			$("#view_ini_date").text(view_ini_date);
			var view_service_type = p[0].service_type;
			var view_service_type_name="";
			$("#view_sjy_area").hide();
			if(view_service_type==0){
				view_service_type_name="看车团";
			}else if(view_service_type==1){
				view_service_type_name="直销";
			}else if(view_service_type==2){
				view_service_type_name="车展";
			}else if(view_service_type==3){
				view_service_type_name="大客户";
			}else if(view_service_type==4){
				view_service_type_name="经销商";
				$("#view_sjy_area").show();
			}
			$("#view_service_type").text(view_service_type_name);
			var view_contact_num = p[0].contact_num;
			$("#view_contact_num").text(view_contact_num);
			var view_cust_name = p[0].cust_name;
			$("#view_cust_name").text(view_cust_name);
			var view_promo_area = p[0].promo_area;
			$("#view_promo_area").text(view_promo_area);
			var view_brand_car_model="";
			var view_brand_name = p[0].iway;
			view_brand_car_model = view_brand_name;
			var view_car_name = p[0].car_name;
			if(is_exists(view_car_name)){
				view_brand_car_model = view_brand_car_model+"/"+view_car_name;
			}
			var view_model_name = p[0].model_name;
			if(is_exists(view_model_name)){
				view_brand_car_model = view_brand_car_model+"/"+view_model_name;
			}
			$("#view_brand_car_model").text(view_brand_car_model);
			var view_contact_start_date = p[0].contact_start_date;
			$("#view_contact_start_date").text(view_contact_start_date);
			var view_contact_end_date = p[0].contact_end_date;
			$("#view_contact_end_date").text(view_contact_end_date);
			var view_promo_start_date = p[0].promo_start_date;
			$("#view_promo_start_date").text(view_promo_start_date);
			var view_promo_end_date = p[0].promo_end_date;
			$("#view_promo_end_date").text(view_promo_end_date);
			var view_acti_start_date = p[0].acti_start_date;
			$("#view_acti_start_date").text(view_acti_start_date);
			var view_acti_end_date = p[0].acti_end_date;
			$("#view_acti_end_date").text(view_acti_end_date);
			var view_tar_clue_num = p[0].tar_clue_num;
			$("#view_tar_clue_num").text(view_tar_clue_num);
			var view_tar_reach_num = p[0].tar_reach_num;
			$("#view_tar_reach_num").text(view_tar_reach_num);
			var view_tar_trans_num = p[0].tar_trans_num;
			$("#view_tar_trans_num").text(view_tar_trans_num);
			var view_custom_service_name = p[0].custom_service_name;
			$("#view_custom_service_name").text(view_custom_service_name);
			var view_promo_man_name = p[0].promo_man_name;
			$("#view_promo_man_name").text(view_promo_man_name);
			var view_competing_name = p[0].competing_name;
			$("#view_competing_name").text(view_competing_name);
			var view_data_source_name = p[0].data_source_name;
			$("#view_data_source_name").text(view_data_source_name);
			var view_acti_name = p[0].acti_name;
			$("#view_acti_name").text(view_acti_name);
			$("#view").modal();
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
function addProject(){
	window.parent.openNew('新项目','./newProject');
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