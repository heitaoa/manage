<#import "../common.ftl" as c>
<#import "./promo_director_pro_js.ftl" as jj>

<@c.html_head></@c.html_head>
<@c.html_body>

<style>
.td_title{background-color:#EEE; font-weight:bold; font-size: 14px;}
</style>

<style>
	.tbox_div{width:450px; float:left; height:30px;  margin-bottom: 15px;}
	.tbox_div .span1{ width:100px; float:left;}
	.tbox_div label{ float:right; margin-right: 5px;}
	.tbox_div .span2{ float:left;}
</style>

<div class="row">
	<div class="col-md-12">
		<div class="portlet-body">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#tab_pro_original" data-toggle="tab">原始项目<span class="label label-sm label-danger circle">${pro_num_will}</span></a>
				</li>
				<li>
					<a href="#tab_pro_edit" data-toggle="tab">增补项目<span class="label label-sm label-danger circle">${projectList_bl_count}</span></a>
				</li>
			</ul>  <!-- nav end -->
			<div class="tab-content">
				<div class="tab-pane fade active in" id="tab_pro_original">
					<div class="col-md-12">
						<form id="form1" action="./promo_director_prosearch" class="form-horizontal" role="form" method="post">
							<div class="form-body">
								<div class="form-group">
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">部门：</label>
										</span>
										<span class="span2">
											<select name="ini_dept" class="form-control input-inline input-medium">
												<option value=""></option>
												<#list deptMap?keys as deptId>
													<option <#if ini_dept==deptId>selected="selected"</#if> value="${deptId}">${deptMap.get(deptId)}</option>
												</#list>
											</select>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">发起人：</label>
										</span>
										<span class="span2">
											<select name="ini_man" class="form-control input-inline input-medium">
												<option value=""></option>
												<#list inimanMap?keys as ini_mankey>
													<option <#if ini_man==ini_mankey>selected="selected"</#if> value="${ini_mankey}">${inimanMap.get(ini_mankey)}</option>
												</#list>
											</select>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">业务类型：</label>
										</span>
										<span class="span2">
											<select name="service_type" class="form-control input-inline input-medium">
												<option value=""></option>
												<option <#if service_type=="0">selected="selected"</#if> value="0">看车团</option>
												<option <#if service_type=="1">selected="selected"</#if> value="1">特卖惠</option>
												<option <#if service_type=="2">selected="selected"</#if> value="2">车展</option>
												<option <#if service_type=="3">selected="selected"</#if> value="3">大客户</option>
											</select>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">渠道：</label>
										</span>
										<span class="span2">
											<select name="brand" class="form-control input-inline input-medium">
												<option value=""></option>
												<#list brandMap?keys as brandkey>
													<option <#if brand==brandkey>selected="selected"</#if> value="${brandkey}">${brandMap.get(brandkey)}</option>
												</#list>
											</select>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">发起日期：</label>
										</span>
										<span class="span2">
											<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
					                            <input value="${ini_date}" name="ini_date" type="text" class="form-control">
					                            <span class="input-group-btn">
					                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
					                            </span>
					                        </div>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">推广区域：</label>
										</span>
										<span class="span2">
											<div class="input-group input-large">
					                            <span class="input-group-addon">省</span>
					                            <select id="promo_prov" name="promo_prov" class="form-control input-inline input-small">
													<option value=""></option>
													<#list provMap?keys as key>
														<option <#if promo_prov==key>selected="selected"</#if> value="${key}">${provMap.get(key)}</option>
													</#list>
												</select>
					                            <span class="input-group-addon">市</span>
					                            <select  id="promo_city" name="promo_city" class="form-control input-inline input-small">
													<option value=""></option>
												</select>
					                        </div>
										</span>
									</div>
									
									<div class="tbox_div">
										<span class="span1">
											<label class="control-label">状态：</label>
										</span>
										<span class="span2">
											<select name="pro_state" class="form-control input-inline input-medium">
												<option value=""></option>
												<option <#if pro_state=="1">selected="selected"</#if> value="1">待审核</option>
												<option <#if pro_state=="3">selected="selected"</#if> value="3">审核通过</option>
												<option <#if pro_state=="4">selected="selected"</#if> value="4">已驳回</option>
											</select>
										</span>
									</div>
									
									<div class="tbox_div" style="width:500px;">
										<input id="pro_searchType" name="pro_searchType" type="hidden" value="${pro_searchType}" />
										<button id="btn_search_will" type="button" onclick="javascript:searchTypeClick(1)" class="btn green-meadow btn-circle">待审查 【${pro_num_will}】</button>
										<button id="btn_search_yes" type="button" onclick="javascript:searchTypeClick(3)" class="btn btn-primary btn-circle">进行中【${pro_num_yes}】</button>
										<button id="btn_search_no" type="button" onclick="javascript:searchTypeClick(4)" class="btn btn-warning btn-circle">已驳回 【${pro_num_no}】</button>
										<button id="btn_search_out" type="button" onclick="javascript:searchTypeClick(5)" class="btn grey-cascade btn-circle">已结束 【${pro_num_out}】</button>
									</div>
									
									<div class="tbox_div" style="width:200px;">
										<input id="page" name="page" type="hidden" value="1" />
										<button id="btn_search" type="button" class="btn blue btn-circle" style="width:100px;">查询</button>
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
									<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
										<thead>
											<tr role="row">
												<th class="text-center">序号</th>
												<th class="text-center">推广编号</th>
												<th class="text-center">部门</th>
												<th class="text-center">发起人</th>
												<th class="text-center">发起时间</th>
												<th class="text-center">业务类型</th>
												<th class="text-center">渠道车系</th>
												<th class="text-center">推广区域</th>
												<th class="text-center">活动起止时间</th>
												<th class="text-center">责任客服</th>
												<th class="text-center">责任推广</th>
												<th class="text-center">状态</th>
												<th class="text-center"> 操作</th>
											</tr>
										</thead>
										<tbody>
											<#list projectList as project>
												<tr>
													<td>${project_index + 1}</td>
													<td tag="pro_num">${project.get("pro_num")!}</td>
													<td tag="dept_name">${project.get("dept_name")!}</td>
													<td tag="ini_man">${project.get("ini_man")!}</td>
													<td tag="ini_date">${project.get("ini_date")?date}</td>
													<td tag="service_type">
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
														</#switch>
													</td>
													<td>
														${project.get("iway")!}
														<#if project.get("car")!="-1">--${project.get("car_name")!}</#if>
														<#if project.get("model")!="-1">--${project.get("model_name")!}</#if>
													</td>
													<td tag="promo_area">
														<#if project.get("promo_prov")=="-1">
															全国
														<#else>
															<#if project.get("prov_name")??>${project.get("prov_name")}</#if><#if project.get("city_name")??>--${project.get("city_name")}</#if>
														</#if>
													</td>
													<td tag="promo_date">${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
													<td tag="custom_service">
														${project.get("custom_service_name")!}
													</td>
													<td tag="promo_man">${project.get("promo_man")}</td>
													<#switch project.get("pro_state")>
														<#case "1">
															<td style="color:#F00">待审核</td>
															<#break>
														<#case "3">
															<td style="color:#06F">已通过</td>
															<#break>
														<#case "4">
															<td style="color:#FF8000">已驳回</td>
															<#break>
														<#case "5">
															<td style="color:#7F9293">已结束</td>
															<#break>
													</#switch>
													<td>
														<#if project.get("pro_state")=="1" >
															<a class="btn_examine" href="javascript:void(0)" goal="${project.get("pro_num")}">审查</a>
														<#else>
															<a class="btn_lookPro" href="javascript:void(0)" goal="${project.get("pro_num")}">查看</a>
														</#if>
													</td>
												</tr>
											</#list>
											
										</tbody>
									</table>
								</div>
								<!-- 分页start -->
								<#if pages gt 1 >
									<div class="row">
										<div class="col-md-5 col-sm-12">
											<input id="pages" name="pages" type="hidden" value="${pages}" />
											<div style="height:50px; line-height:50px; font-size:14px;">
												当前第${page}页，共${pages}页
											</div>
										</div>
										<!-- 页码start -->
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
									                <#if p_index + 1==pageList?size >
									            		<#if p?eval!=pages >
											            	<li>
											                    <a>...</a>
											                </li>
											            </#if>
									            	</#if>
									            </#list>
											       
									            <#if page==pages >
									            	<li class="active">
									                    <a href="#" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
									                </li>
									            <#else>
									            	<li>
									                    <a href="javascript:toPage(${page+1})" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
									                </li>
									            </#if>
									            
									            <div style="float:left; font-size:14px; margin-left:30px;">
													<label style="margin:0 5px;">到第</label>
													<input type="text" id="topage_num" style="border:1px solid #CCC; width:40px; height:30px; text-align:center;" />
													<label style="margin:0 5px;">页</label>
													<input type="button" onclick="javascript:toPage(-1)" style="border:1px solid #CCC; width:40px; height:30px;" value="确定" />
												</div>
									        </ul>
									    </div>
								    	<!-- 页码end -->
								    	
									</div>
								</#if>
								<!-- 分页end -->
							</div>
							
						</div>
					</div>
					
				</div>  <!-- tab_pro_original  end -->
				
				
				<div class="tab-pane fade" id="tab_pro_edit">
					<div class="col-md-12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box grey-cascade">
						
							<div class="portlet-title">
								<div class="caption"><i class="fa fa-globe"></i>推广项目列表</div>
							</div>
							
							<div class="portlet-body">
								<div class="table-scrollable">
									<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
										<thead>
											<tr role="row">
												<th class="text-center">序号</th>
												<th class="text-center">推广编号</th>
												<th class="text-center">部门</th>
												<th class="text-center">发起人</th>
												<th class="text-center">发起时间</th>
												<th class="text-center">业务类型</th>
												<th class="text-center">品牌车系</th>
												<th class="text-center">推广区域</th>
												<th class="text-center">活动起止时间</th>
												<th class="text-center">责任客服</th>
												<th class="text-center">责任推广</th>
												<th class="text-center">状态</th>
												<th class="text-center"> 操作</th>
											</tr>
										</thead>
										<tbody>
											<#list projectList_bl as project>
												<tr>
													<td>${project_index + 1}</td>
													<td tag="pro_num">${project.get("pro_num")}</td>
													<td tag="dept_name">${project.get("dept_name")}</td>
													<td tag="ini_man">${project.get("ini_man")}</td>
													<td tag="ini_date">${project.get("ini_date")?date}</td>
													<td tag="service_type">
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
														</#switch>
													</td>
													<td>
														<#if project.get("brand")??>${project.get("brand")}</#if>
														<#if project.get("car")??>--${project.get("car")}</#if>
													</td>
													<td tag="promo_area">
														<#if project.get("promo_prov")=="-1">
															全国
														<#else>
															<#if project.get("prov_name")??>${project.get("prov_name")}</#if><#if project.get("city_name")??>--${project.get("city_name")}</#if>
														</#if>
													</td>
													<td tag="promo_date">${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
													<td tag="custom_service">
														<#if project.get("custom_service")??>
															${project.get("custom_service_name")!}
														</#if>
													</td>
													<td tag="promo_man">${project.get("promo_man")}</td>
													<#switch project.get("pro_state")>
														<#case "1">
															<td style="color:#F00">待审查</td>
															<#break>
														<#case "4">
															<td style="color:#FF8000">已驳回</td>
															<#break>
													</#switch>
													<td>
														<#if project.get("pro_state")=="1" >
															<a class="btn_bl_examine" href="javascript:void(0)" goal="${project.get("pro_num")}">审查</a>
														<#else>
															<a class="btn_bl_lookPro" href="javascript:void(0)" goal="${project.get("pro_num")}">查看</a>
														</#if>
													</td>
												</tr>
											</#list>
											
										</tbody>
									</table>
								</div>
							</div>
						</div> <!-- portlet end -->
					</div>
				</div>
			</div>  <!-- tab-content end -->
		</div> <!-- portlet-body end -->	
	</div>
	
	<!-- 审查项目弹框 -->
	<div id="modal_examine" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">项目审核</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<table class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title">推广编号</td>
                            <td id="modal_pro_num"></td>
                            <td class="td_title">部门</td>
                            <td id="modal_dept_name"></td>
                            <td class="td_title">发起日期</td>
                            <td id="modal_ini_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">业务类型</td>
                            <td id="modal_service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td id="modal_contact_num"></td>
                            <td class="td_title">客户名称</td>
                            <td id="modal_cust_name"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">推广地区</td>
                            <td id="modal_promo_area"></td>
                            <td class="td_title">品牌-车型</td>
                            <td id="modal_brand"></td>
                            <td class="td_title">竞品车系</td>
                            <td id="modal_competing"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">合同起止时间：</td>
                            <td id="modal_contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td id="modal_promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td id="modal_active_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">目标线索量:</td>
                            <td id="modal_clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td id="modal_reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td id="modal_trans_num"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">责任客服:</td>
                            <td id="modal_custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                            <td class="td_title"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="col-md-12">
                	<label class="col-md-2 control-label">推广责任人：</label>
                    <select id="select_promo_man" class="layout-option form-control input-medium">
                        <option value=""></option>
                        <#list promoPerMap?keys as perId>
							<option value="${perId}">${promoPerMap.get(perId)}</option>
						</#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button id="bt_pro_no" type="button" class="btn btn-default" style="width:80px;">驳回</button>
            <button id="bt_pro_yes" type="button" class="btn blue">审查通过</button>
        </div>
    </div>
	
	
	<!-- 查看项目弹框 -->
	<div id="modal_lookPro" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">项目详情</h4>
        </div>
        <div class="modal-body">
            <div class="row">
            	<h4 style="margin-left:20px;">推广需求</h4>
                <div class="col-md-12">
                	<table class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title">推广编号</td>
                            <td id="look_pro_num"></td>
                            <td class="td_title">部门</td>
                            <td id="look_dept_name"></td>
                            <td class="td_title">发起日期</td>
                            <td id="look_ini_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">业务类型</td>
                            <td id="look_service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td id="look_contact_num"></td>
                            <td class="td_title">客户名称</td>
                            <td id="look_cust_name"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">推广地区</td>
                            <td id="look_promo_area"></td>
                            <td class="td_title">品牌</td>
                            <td id="look_brand"></td>
                            <td class="td_title">车型</td>
                            <td id="look_car"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">合同起止时间：</td>
                            <td id="look_contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td id="look_promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td id="look_active_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">目标线索量:</td>
                            <td id="look_clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td id="look_reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td id="look_trans_num"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">责任客服:</td>
                            <td id="look_custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                            <td class="td_title"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>		
			
        </div>
        <div class="modal-footer">
            <button type="button" class="btn blue" data-dismiss="modal" aria-hidden="true">关闭</button>
        </div>
    </div>
    
    <!-- 查看项目弹框 -->
	<div id="modal_ProInfo" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">项目详情</h4>
        </div>
        <div class="modal-body">
            <div class="row">
            	<h4 style="margin-left:20px;">推广需求</h4>
                <div class="col-md-12">
                	<table id="tb_proinfo" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title" width="12%">推广编号</td>
                            <td tag="pro_num" width="21%"></td>
                            <td class="td_title" width="12%">活动名称</td>
                            <td tag="acti_name" width="21%"></td>
                            <td class="td_title" width="12%">部门</td>
                            <td tag="dept_name" width="21%"></td>
                        </tr>
                        <tr>
                            <td class="td_title">发起日期</td>
                            <td tag="ini_date"></td>
                        	<td class="td_title">业务类型</td>
                            <td tag="service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td tag="contact_num"></td>
                            
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">推广地区</td>
                            <td tag="promo_area"></td>
                            <td class="td_title">品牌车系</td>
                            <td tag="brand"></td>
                            <td class="td_title">竞品车系</td>
                            <td tag="competing"></td>
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">合同起止时间：</td>
                            <td tag="contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td tag="promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td tag="active_date"></td>
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">目标线索量:</td>
                            <td tag="clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td tag="reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td tag="trans_num"></td>
                        </tr>
                        <tr>
                        	
                            <td class="td_title">客户名称</td>
                            <td tag="cust_name"></td>
                        	<td class="td_title">责任客服:</td>
                            <td tag="custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
            
            <div class="row" id="modal_ProInfo_jinzhan">
            	<h4 style="margin-left:20px;">项目进展情况</h4>
                <div class="col-md-12">
                	<table id="tb_prodata" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title" width="11%">报名量</td>
                            <td tag="baoming" width="22%"></td>
                            <td class="td_title" width="11%">回访量</td>
                            <td tag="huifang" width="22%"></td>
                            <td class="td_title" width="11%">回访率</td>
                            <td tag="huifang_rate" width="22%"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn blue" data-dismiss="modal" aria-hidden="true">关闭</button>
        </div>
    </div>
	
	<!-- 补量审查弹框 -->
	<div id="modal_bl_examine" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">增补项目审核</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<table id="bl_examine_table" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title">推广编号</td>
                            <td tag="pro_num"></td>
                            <td class="td_title">部门</td>
                            <td tag="dept_name"></td>
                            <td class="td_title">发起日期</td>
                            <td tag="ini_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">业务类型</td>
                            <td tag="service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td tag="contact_num"></td>
                            <td class="td_title">客户名称</td>
                            <td tag="cust_name"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">推广地区</td>
                            <td tag="promo_area"></td>
                            <td class="td_title">品牌-车型</td>
                            <td tag="brand"></td>
                            <td class="td_title">竞品车系</td>
                            <td tag="competing"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">合同起止时间：</td>
                            <td tag="contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td tag="promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td tag="active_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">目标线索量:</td>
                            <td tag="clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td tag="reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td tag="trans_num"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">责任客服:</td>
                            <td tag="custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                            <td class="td_title"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button id="bl_pro_no" type="button" class="btn btn-default" style="width:80px;">驳回</button>
            <button id="bl_pro_yes" type="button" class="btn blue">审查通过</button>
        </div>
    </div>
    
    <!-- 补量审查弹框 -->
	<div id="modal_bl_look" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">驳回增补项目查看</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<table id="bl_look_table" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title">推广编号</td>
                            <td tag="pro_num"></td>
                            <td class="td_title">部门</td>
                            <td tag="dept_name"></td>
                            <td class="td_title">发起日期</td>
                            <td tag="ini_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">业务类型</td>
                            <td tag="service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td tag="contact_num"></td>
                            <td class="td_title">客户名称</td>
                            <td tag="cust_name"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">推广地区</td>
                            <td tag="promo_area"></td>
                            <td class="td_title">品牌-车型</td>
                            <td tag="brand"></td>
                            <td class="td_title">竞品车系</td>
                            <td tag="competing"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">合同起止时间：</td>
                            <td tag="contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td tag="promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td tag="active_date"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">目标线索量:</td>
                            <td tag="clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td tag="reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td tag="trans_num"></td>
                        </tr>
                        <tr>
                        	<td class="td_title">责任客服:</td>
                            <td tag="custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                            <td class="td_title"></td>
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

<script type="text/javascript">
	$(function(){
		$("#promo_prov").find("option[value='${promo_prov!}']").attr("selected",true);
		var select_prov = "${promo_prov!}";
		if(select_prov != ""){
			$("#promo_city").empty();
			$("#promo_city").append("<option></option>");
			
			$.post("./present_apply_getcity",{prov:select_prov},function(data){
				if(data!=""){
					var arr = data.split("|");
					for(var i=0; i<arr.length/2; i++){
						$("#promo_city").append("<option value='"+ arr[i*2] +"'>"+ arr[i*2+1] +"</option>");
					}
					
					$("#promo_city").find("option[value='${promo_city!}']").attr("selected",true);
				}
			});
		}
		
	})
</script>

<@jj.jsfile></@jj.jsfile>



</body>
</html>