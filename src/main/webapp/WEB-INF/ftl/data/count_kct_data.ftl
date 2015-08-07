<#import "../common.ftl" as c>
<#import "./count_kct_data_js.ftl" as jj>
<@c.html_head></@c.html_head>
<@c.html_body>



<div class="row">
	<div class="col-md-12 form">
		<form action="./count_kct_data" class="form-horizontal" method="post" role="form">
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
				<div class="caption"><i class="fa fa-globe"></i>看车团活动数据分析</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row" class="heading">
								<th class="text-center">序号</th>
								<th class="text-center">分站</th>
								<th class="text-center">活动名称</th>
								<th class="text-center">项目编号</th>
								<th class="text-center">品牌</th>
								<th class="text-center">执行人</th>
								<th class="text-center">执行日期</th>
								<th class="text-center">客服</th>
								<th class="text-center">专项推广数</th>
								<th class="text-center">库资源数</th>
								<th class="text-center">报名总数</th>
								<th class="text-center">邀约数</th>
								<th class="text-center">邀约率</th>
								<th class="text-center">到店数</th>
								<th class="text-center">到店率</th>
								<th class="text-center">成交数</th>
								<th class="text-center">成交率</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list countActiveDataList as list>
								<tr>
									<td>${list_index + 1}</td>
									<td>${list.get("org_name")!}</td>
									<td>${list.get("acti_name")!}</td>
									<td>${list.get("pro_num")!}</td>
									<td>${list.get("brand_name")!}</td>
									<td>${list.get("detail_executor")!}</td>
									<td>${list.get("detail_acti_date")?date}</td>
									<td>${list.get("service_name")!}</td>
									<td></td>
									<td></td>
									<td>${list.get("baoming_count")!}</td>
									<td>${list.get("invite_count")!}</td>
									<td>${list.get("ratio_invite")!}</td>
									<td>${list.get("reach_count")!}</td>
									<td>${list.get("ratio_reach")!}</td>
									<td>${list.get("trans_count")!}</td>
									<td>${list.get("ratio_trans")!}</td>
									<td>
										<a class="btn_sign" href="javascript:void(0)" goal="${list.get("pro_num")}">签到表</a>
									</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
	
	
	<div id="modal_sign" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">签到表</h4>
        </div>
        <div class="modal-body">
            <div class="row" style="height:500px; overflow:scroll;">
                <div class="col-md-12">
                	<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption"><i class="fa fa-globe"></i>签到表</div>
						</div>
						
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
									<thead>
										<tr role="row" class="heading">
											<th class="text-center">序号</th>
											<th class="text-center">姓名</th>
											<th class="text-center">电话</th>
											<th class="text-center">报名时间</th>
											<th class="text-center">地区省市</th>
											<th class="text-center">参加活动</th>
											<th class="text-center">是否成交</th>
											<th class="text-center">实效原因</th>
										</tr>
									</thead>
									<tbody id="tbody_sign">
										
									</tbody>
								</table>
							</div>
						</div>
						
					</div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn blue" id="bt_close">关闭</button>
        </div>
    </div>
	
</div>



</@c.html_body>
<@c.html_js></@c.html_js>

<@jj.jsfile></@jj.jsfile>

</body>
</html>