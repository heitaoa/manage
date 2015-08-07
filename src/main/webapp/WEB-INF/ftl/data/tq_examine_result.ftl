<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>

<style>
.td_title{background-color:#EEE; font-weight:bold; font-size: 14px;}
</style>

<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>项目列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="text-center">项目编号</th>
								<th class="text-center">申请时间</th>
								<th class="text-center">品牌车系</th>
								<th class="text-center">客户名称</th>
								<th class="text-center">数量</th>
								<th class="text-center">数据周期</th>
								<th class="text-center">合同号</th>
								<th class="text-center">合同金额</th>
								<th class="text-center">申请理由</th>
								<th class="text-center">是否同意扣除金额</th>
								<th class="text-center">审核结果</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list proList as list>
							<tr>
								<!-- 项目编号 -->
								<td>${list.get("tiqu_num")!}</td>
								<!-- 申请时间 -->
								<td>${list.get("ini_date")?date}</td>
								<!-- 品牌车系 -->
								<td>${list.get("brand_name")!}<#if list.get("car")!="-1">--${list.get("car_name")!}</#if></td>
								<!-- 客户名称 -->
								<td>${list.get("contact_num")!}</td>
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
										<td>部门经理通过</td>
										<#break>
									<#case "2">
										<td>部门经理驳回，${list.get("deny_cause")!}</td>
										<#break>
									<#case "3">
										<#if list.get("is_deduct")=="0">
											<td>胡总通过</td>
										<#else>
											<td>胡总通过，扣执行金额</td>
										</#if>
										<#break>
									<#case "4">
										<td>胡总驳回，${list.get("deny_cause")!}</td>
										<#break>
								</#switch>
								<!-- 操作 -->
								<td>
									<#switch list.get("examine_state")>
										<#case "2">
											<button type="button" class="btn_no btn blue btn-circle btn-xs" goal="${list.get("tiqu_num")}">取消执行</button>
											<#break>
										<#case "3">
											<#if list.get("is_agree_deduct")=="0">
												<button type="button" class="btn_yes btn green btn-circle btn-xs" goal="${list.get("tiqu_num")}">同意执行</button>
											<#else>
												<button type="button" class="btn_yes btn green btn-circle btn-xs" goal="${list.get("tiqu_num")}">同意执行</button>
												<button type="button" class="btn_no btn blue btn-circle btn-xs" goal="${list.get("tiqu_num")}">取消执行</button>
											</#if>
											
											<#break>
										<#case "4">
											<button type="button" class="btn_no btn blue btn-circle btn-xs" goal="${list.get("tiqu_num")}">取消执行</button>
											<#break>
									</#switch>
								</td>
							</tr>
							</#list>
						</tbody>
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
		$(".btn_yes").click(function(){
			$.post("./tiqu_examine_result_executeYes",{tiqu_num:$(this).attr("goal")},function(data){
				if(data==1){
					alert("项目进入执行！");
					window.location.reload();
				}else{
					alert("提交不成功，请联系技术部！");
				}
			});
		});
		
		$(".btn_no").click(function(){
			$.post("./tiqu_examine_result_executeNo",{tiqu_num:$(this).attr("goal")},function(data){
				if(data==1){
					alert("项目已经取消执行！");
					window.location.reload();
				}else{
					alert("提交不成功，请联系技术部！");
				}
			});
		});
		
	})
</script>


</body>
</html>