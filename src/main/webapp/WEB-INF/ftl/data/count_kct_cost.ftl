<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>



<div class="row">
	<div class="col-md-12 form">
		<form action="./count_kct_cost_first" class="form-horizontal" method="post" role="form">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">分站</label>
					<div class="col-md-2">
						<select name="orgid" class="form-control input-inline input-medium">
							<option></option>
							<#list orgMap?keys as key>
								<option value="${key}">${orgMap.get(key)}</option>
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">执行人</label>
					<div class="col-md-2">
						<select name="executor" class="form-control input-inline input-medium">
							<option></option>
							<#list executorMap?keys as key>
								<option value="${key}">${executorMap.get(key)}</option>
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">品牌</label>
					<div class="col-md-2">
						<select name="brand" class="form-control input-inline input-medium">
							<option></option>
							<#list brandMap?keys as brand>
								<option value="${brand}">${brandMap.get(brand)}</option>
							</#list>
						</select>
					</div>
					<div class="col-md-2">
						<button id="btn_search" type="submit" class="btn blue" style="width:100px;">查询</button>
					</div>
				</div>			
			</div>
		</form>
	</div>
</div>

<hr/>

<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
		
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>看车团活动成本核算表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row" class="heading">
								<th class="text-center">序号</th>
								<th class="text-center">分站</th>
								<th class="text-center">活动名称</th>
								<th class="text-center">合同号</th>
								<th class="text-center">项目编号</th>
								<th class="text-center">经销商名称</th>
								<th class="text-center">品牌</th>
								<th class="text-center">执行人</th>
								<th class="text-center">辅助人员</th>
								<th class="text-center">执行日期</th>
								<th class="text-center">成交台数</th>
								<th class="text-center">礼品金额</th>
								<th class="text-center">大巴/交通费</th>
								<th class="text-center">辅助参与人员补贴</th>
								<th class="text-center">费用总计</th>
							</tr>
						</thead>
						<tbody>
							<#list countActiveCostList as list>
								<tr>
									<td>${list_index + 1}</td>
									<td>${list.get("ORG_NAME")!}</td>
									<td>${list.get("acti_name")!}</td>
									<td>${list.get("contact_num")!}</td>
									<td>${list.get("pro_num")!}</td>
									<td>${list.get("cust_name")!}</td>
									<td>${list.get("brand_name")!}</td>
									<td>${list.get("executor_name")!}</td>
									<td>${list.get("detail_assist_person")!}</td>
									<td>${list.get("detail_acti_date")!}</td>
									<td>${list.get("trans_count")!}</td>
									<td>${list.get("giving_money")!}</td>
									<td>${list.get("detail_traffic_expense")!}</td>
									<td>${list.get("detail_acti_sub")!}</td>
									<td>${list.get("allmoney")!}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
</div>



</@c.html_body>
<@c.html_js></@c.html_js>

</body>
</html>