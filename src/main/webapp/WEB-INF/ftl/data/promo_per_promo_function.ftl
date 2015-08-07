<#import "../common.ftl" as c>
<#import "./promo_per_promo_function_js.ftl" as jj>

<@c.html_head></@c.html_head>
<@c.html_body>

<style>
.td_title{background-color:#EEE; font-weight:bold; font-size: 14px;}
</style>

<div class="row">

	<div class="col-md-12">
		
		<table class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
        	<#list projectList as project>
	        	<tr>
	            	<td class="td_title">推广编号</td>
	                <td id="td_pro_num">${project.get("pro_num")!}</td>
	                <td class="td_title">发起人</td>
	                <td>${project.get("ini_man")!}</td>
	                <td class="td_title">部门</td>
	                <td>${project.get("dept_name")!}</td>
	            </tr>
	            <tr>
	                <td class="td_title">发起日期</td>
	                <td>${project.get("ini_date")?date}</td>
	            	<td class="td_title">业务类型</td>
	                <td>
	                	<#switch project.get("service_type")>
							<#case "0">
								看车团
								<#break>
							<#case "2">
								直销
								<#break>
							<#case "3">
								车展
								<#break>
							<#case "4">
								大客户
								<#break>
						</#switch>
	                </td>
	                <td class="td_title">关联合同号</td>
	                <td>${project.get("contact_num")!}</td>
	            </tr>
	            <tr>
	                <td class="td_title">客户名称</td>
	                <td>${project.get("cust_name")!}</td>
	            	<td class="td_title">推广地区</td>
	                <td>
	                	<#if project.get("promo_prov")=="-1">
							全国
						<#else>
							<#if project.get("prov_name")??>${project.get("prov_name")}</#if><#if project.get("city_name")??>--${project.get("city_name")}</#if>
						</#if>
	                </td>
	                <td class="td_title">品牌-车系</td>
	                <td>${project.get("brand")!}<#if project.get("car")??>-${project.get("car")!}</#if></td>
	            </tr>
	            <tr>
	                <td class="td_title">竞品车系</td>
	                <td>${project.get("competing_name")!}</td>
	            	<td class="td_title">合同起止时间：</td>
	                <td>${project.get("contact_start_date")?date}至 ${project.get("contact_end_date")?date}</td>
	                <td class="td_title">推广起止时间：</td>
	                <td>${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
	            </tr>
	            <tr>
	                <td class="td_title">活动执行时间：</td>
	                <td>${project.get("acti_start_date")?date}--${project.get("acti_end_date")?date}</td>
	            	<td class="td_title">目标线索量:</td>
	                <td>${project.get("tar_clue_num")!}</td>
	                <td class="td_title">目标到达量：</td>
	                <td>${project.get("tar_reach_num")!}</td>
	            </tr>
	            <tr>
	                <td class="td_title">目标成交量:</td>
	                <td>${project.get("tar_trans_num")!}</td>
	            	<td class="td_title">责任客服:</td>
	                <td>${project.get("custom_service")!}</td>
	                <td class="td_title"></td>
	                <td></td>
	            </tr>
            </#list>
        </table>
		
	</div>
	
	<div class="col-md-12">
		<div class="col-md-12 col-sm-12">
			<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						推广计划
					</div>
					<div class="actions">
						<a id="btn_add_function" href="javascript:void(0)" class="btn btn-default btn-sm">
						<i class="fa fa-plus"></i> 添加一行 </a>
					</div>
				</div>
				<div class="portlet-body">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
					<thead>
						<tr role="row">
							<th class="text-center">序号</th>
							<th class="text-center">渠道</th>
							<th class="text-center">URL</th>
							<th class="text-center">页面标识</th>
							<th class="text-center">推广日期</th>
							<th class="text-center">备注</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody id="tbody_func">
						<#list promoList as promo>
							<tr tag='${promo.promo_id}'>
								<td tag='id'>${promo_index + 1}</td>
								<td tag='channel'>${promo.promo_channel!}</td>
								<td tag='url'>${promo.promo_url!}</td>
								<td tag='pageid'>${promo.promo_pageid!}</td>
								<td tag='promodate'>${promo.promo_date?date}</td>
								<td tag='remark'>${promo.promo_remarks!}</td>
								<td tag='operation'>
									<a class='func_edit' href='javascript:editFunc(${promo_index + 1})' style='margin-right:20px;'>编辑</a>
									<a class='func_delete' href='javascript:deletefunc(${promo_index + 1})'>删除</a>
								</td>
							</tr>
						</#list>
					</tbody>
					</table>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
	
	
	<div id="modal_edit" class="modal fade" tabindex="-1" data-backdrop="static" data-width="800">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">编辑推广方案</h4>
        </div>
        <div class="modal-body">
        	<form id="form_function" class="form-horizontal" action="./promo_per_pro_function_sub" method="post"  role="form">
        		<input type="hidden" id="hid_pro_num" name="pro_num" value="" />
        		<input type="hidden" id="hid_promo_id" name="promo_id" value="" />
        		
            	<div class="form-body">
            		<div class="row">
            			<div class="col-md-12">
            				<div class="form-group">
			                	<label class="col-md-3 control-label">渠道：</label>
			                    <div class="col-md-8">
			                        <input id="promo_channel" name="promo_channel" type="text" class="form-control input-medium" />
			                    </div>
			                </div>
			                <div class="form-group">
			                	<label class="col-md-3 control-label">URL：</label>
			                    <div class="col-md-8">
			                        <input id="promo_url" name="promo_url" type="text" class="form-control input-medium" style="width:300px;" />
			                    </div>
			                </div>
			                <div class="form-group">
			                	<label class="col-md-3 control-label">页面标识：</label>
			                    <div class="col-md-8">
			                        <input id="promo_pageid" name="promo_pageid" type="text" class="form-control input-medium" />
			                    </div>
			                </div>
			                <div class="form-group">
			                	<label class="col-md-3 control-label">推广日期：</label>
			                	<div class="col-md-8">
			                        <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
			                            <input id="promo_date" name="promo_date" type="text" class="form-control">
			                            <span class="input-group-btn">
			                            	<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
			                            </span>
			                        </div>
			                    </div>
		                        
			                </div>
			                <div class="form-group">
			                	<label class="col-md-3 control-label">备注：</label>
			                    <div class="col-md-8">
			                        <textarea id="promo_remarks" name="promo_remarks" class="form-control" style="width:100%;" rows="3"></textarea>
			                    </div>
			                </div>
            			</div>
            		</div>
            	</div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
            <button id="bt_promo_sub" type="button" tag="" class="btn blue">提交</button>
        </div>
    </div>
	
	
	
	<div class="col-md-12">
		<div class="col-md-12 col-sm-12">
			<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						目标线索量统计
					</div>
					<div class="actions">
						<a id="func_reload" href="javascript:void(0)" class="btn btn-default btn-sm">
						<i class="icon-refresh"></i> 刷新 </a>
					</div>
				</div>
				<div class="portlet-body">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="text-center" style="background-color:#DDD;">推广时间</th>
								<#list promoList as promo>
									<th class="text-center" style="background-color:#D0E9C6;">${promo.promo_channel!}</th>
								</#list>
								<th class="text-center" style="background-color:#D0E9C6;">其他</th>
								<th class="text-center" style="background-color:#DDD;">日合计</th>
								<th class="text-center" style="background-color:#DDD;">已回访</th>
								<th class="text-center" style="background-color:#DDD;">回访率</th>
							</tr>
						</thead>
						<tbody>
							<#list promoList as promo>
							<tr>
								<!--推广时间-->
								<td></td>
								<!--渠道列-->
								<#list promoList as promo>
									<td></td>
								</#list>
								<!--其他-->
								<td></td>
								<!--日合计-->
								<td></td>
								<!--已回访-->
								<td></td>
								<!--回访率-->
								<td></td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
	

</div>


</@c.html_body>
<@c.html_js></@c.html_js>

<@jj.jsfile></@jj.jsfile>



</body>
</html>