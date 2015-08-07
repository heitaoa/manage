<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>

<style>
.td_title{background-color:#EEE; font-weight:bold; font-size: 14px;}
</style>

<div class="row">
	<div class="col-md-12">
		<form id="form1" action="./${formUrl}" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">部门：</label>
					<div class="col-md-2">
						<select name="dept_code" class="form-control input-inline input-medium">
							<option value=""></option>
							<#list deptMap?keys as deptId>
								<option <#if dept_code==deptId>selected="selected"</#if> value="${deptId}">${deptMap.get(deptId)}</option>
							</#list>
						</select>
					</div>
					<label class="col-md-1 control-label">申请时间：</label>
					<div class="col-md-2">
						<div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            <input id="apply_startdate" name="apply_startdate" type="text" value="${apply_startdate!}" class="form-control">
                            <span class="input-group-addon">至</span>
                            <input id="apply_enddate" name="apply_enddate" type="text" value="${apply_enddate!}" class="form-control">
                        </div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">审核结果：</label>
					<div class="col-md-2">
						<select name="examine_state" class="form-control input-inline input-medium">
							<option value=""></option>
							<option <#if examine_state=="2">selected="selected"</#if> value="2">经理驳回</option>
							<option <#if examine_state=="3">selected="selected"</#if> value="3">胡总通过</option>
							<option <#if examine_state=="4">selected="selected"</#if> value="4">胡总驳回</option>
						</select>
					</div>
					<label class="col-md-1 control-label">执行结果：</label>
					<div class="col-md-2">
						<select name="tiqu_state" class="form-control input-inline input-medium">
							<option value=""></option>
							<option <#if tiqu_state=="0">selected="selected"</#if> value="0">未执行</option>
							<option <#if tiqu_state=="1">selected="selected"</#if> value="1">已执行</option>
						</select>
					</div>
					<div class="col-md-1">
						<input id="page" name="page" type="hidden" value="1" />
						<button id="btn_search" type="submit" class="btn blue btn-circle" style="width:100px;">查询</button>
					</div>
				</div>				
			</div>
		</form>
	</div>
	
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
		
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>项目列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="text-center">序号</th>
								<th class="text-center">项目编号</th>
								<th class="text-center">申请人</th>
								<th class="text-center">部门</th>
								<th class="text-center">申请时间</th>
								<th class="text-center">品牌车系</th>
								<th class="text-center">客户名称</th>
								<th class="text-center">推广区域</th>
								<th class="text-center">数量</th>
								<th class="text-center">数据周期</th>
								<th class="text-center">合同号</th>
								<th class="text-center">合同金额</th>
								<th class="text-center">申请理由</th>
								<th class="text-center">是否同意扣除金额</th>
								<th class="text-center">审核结果</th>
								<th class="text-center">业务员是否愿意执行</th>
								<th class="text-center">执行结果</th>
							</tr>
						</thead>
						<tbody>
							<#list proList as list>
							<tr>
								<!-- 序号 -->
								<td>${list_index + 1}</td>
								<!-- 项目编号 -->
								<td>${list.get("tiqu_num")!}</td>
								<!-- 申请人 -->
								<td>${list.get("ini_man_name")!}</td>
								<!-- 部门 -->
								<td>${list.get("dept_name")!}</td>
								<!-- 申请时间 -->
								<td>${list.get("ini_date")?date}</td>
								<!-- 品牌车系 -->
								<td>${list.get("brand_name")!}<#if list.get("car")!="-1">--${list.get("car_name")!}</#if></td>
								<!-- 客户名称 -->
								<td>${list.get("contact_num")!}</td>
								<!-- 推广区域 -->
								<td>
									<#if list.get("prov")=="-1">
										全国
									<#else>
										${list.get("prov_name")!}<#if list.get("city")!="-1">--${list.get("city_name")!}</#if>
									</#if>
								</td>
								<!-- 数量 -->
								<td>${list.get("dept_name")!}</td>
								<!-- 数据周期 -->
								<td>${list.get("data_count")!}</td>
								<!-- 合同号 -->
								<td>${list.get("contact_num")!}</td>
								<!-- 合同金额 -->
								<td>${list.get("contact_money")!}</td>
								<!-- 申请理由 -->
								<td>${list.get("apply_cause")!}</td>
								<!-- 是否同意扣除金额 -->
								<td>
									<#if list.get("is_agree_deduct")=="0">否<#else>是</#if>
								</td>
								<!-- 审核结果 -->
								<#switch list.get("examine_state")>
									<#case "0">
										<td>未审核</td>
										<#break>
									<#case "1">
										<td>经理通过</td>
										<#break>
									<#case "2">
										<td>经理驳回</td>
										<#break>
									<#case "3">
										<td>胡总通过</td>
										<#break>
									<#case "4">
										<td>胡总驳回</td>
										<#break>
								</#switch>
								
								<!-- 业务员是否愿意执行 -->
								<td>
									<#switch list.get("tiqu_state")>
										<#case "0">
											未操作
											<#break>
										<#case "1">
											同意执行
											<#break>
										<#case "2">
											取消执行
											<#break>
										<#case "3">
											同意执行
											<#break>
									</#switch>
								<!-- 执行结果 -->
								<td><#if list.get("tiqu_state")=="3">已执行</#if></td>
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
</div>

</@c.html_body>
<@c.html_js></@c.html_js>

<script type="text/javascript">
	$(function(){
		
	})
	
	//分页功能
	function toPage(page){
		if(page==-1){
			page=$("#topage_num").val();
			var pattern=/^[0-9]*[1-9][0-9]*$/;
			var flag = pattern.test(page);
			page = parseInt(page);
			if(flag==false || page<0 || page>$("#pages").val()){
				alert("输入页码不正确，请重新输入！");
				$("#topage_num").val("");
				return;
			}
		}
		
		$("#page").val(page);
		$("#form1").submit();
	}
</script>


</body>
</html>