<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>



<div class="row">
	<div class="col-md-12 form">
		<form action="./count_kct_notsale" class="form-horizontal" method="post" role="form">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">活动编号</label>
					<div class="col-md-2">
						<select name="pro_num" class="form-control input-inline input-medium">
							<option></option>
							<#list tuiguangList as tuiguang>
								
									<option <#if tuiguang.pro_num == pro_num! >selected=true</#if> value="${tuiguang.pro_num}">${tuiguang.pro_num}</option>
								
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">分站</label>
					<div class="col-md-2">
						<select name="fenzhan" class="form-control input-inline input-medium">
							<option></option>
							<#list fenzhanList as fzhan>
								
								<option <#if fzhan.org_id?c == fenzhan!	 >selected=true</#if> value="${fzhan.org_id}">${fzhan.org_name}</option>
								
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">活动分类</label>
					<div class="col-md-2">
						<select name="fenlei" class="form-control input-inline input-medium">
							<option></option>
							<#if fenlei??>
							<option <#if fenlei=='0'>selected=true</#if> value="0"  >看车团</option>
							<option <#if fenlei=='1'>selected=true</#if> value="1" >特卖惠</option>
							<option <#if fenlei=='2'>selected=true</#if> value="2" >车展</option>
							<option <#if fenlei=='3'>selected=true</#if> value="3" >大客户</option>
							<#else>
							<option value="0"  >看车团</option>
							<option  value="1" >特卖惠</option>
							<option  value="2" >车展</option>
							<option  value="3" >大客户</option>
							</#if>
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
				<div class="caption"><i class="fa fa-globe"></i>失销客户分析表</div>
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
								<th class="text-center">失销原因</th>
							</tr>
						</thead>
						<tbody>
							<#if shixiaoList?size gt 0>
								<#list shixiaoList as sx>
									<tr>
										<td>${sx_index+1}</td>
										<td>${sx.name}</td>
										<td>${sx.phone}</td>
										<td>${sx.baoming_date }</td>
										<td>${sx.provname }&nbsp;${sx.cityname }</td>
										<td>${sx.acti_name }</td>
										<td>${sx.is_trans}</td>
										<td>${sx.return_visit_content }</td>
									</tr>
								</#list>
							</#if>
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