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
								<th class="text-center">申请人</th>
								<th class="text-center">部门</th>
								<th class="text-center">申请时间</th>
								<th class="text-center">品牌车系</th>
								<th class="text-center">客户名称</th>
								<th class="text-center">数量</th>
								<th class="text-center">数据周期</th>
								<th class="text-center">合同号</th>
								<th class="text-center">合同金额</th>
								<th class="text-center">申请理由</th>
								<th class="text-center">是否同意扣除金额</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list proList as list>
							<tr>
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
								<!-- 操作 -->
								<td>
									<button type="button" class="btn_yes btn green btn-circle btn-xs" goal="${list.get("tiqu_num")}">通过</button>
									<button type="button" class="btn_no btn blue btn-circle btn-xs" goal="${list.get("tiqu_num")}">驳回</button>
								</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-12">
		<div id="modal_bohui" class="modal fade" tabindex="-1" data-backdrop="static" data-width="600">
	        <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	            <h4 class="modal-title">填写驳回原因</h4>
	        </div>
	        <div class="modal-body">
	        	<form id="form_bohui" class="form-horizontal" action="./promo_per_pro_function_sub" method="post"  role="form">
	            	<div class="form-body">
	            		<div class="row">
	            			<div class="col-md-12">
	            				<div class="form-group">
				                	<label class="col-md-3 control-label">项目编号：</label>
				                	<input type="hidden" name="tiqu_num" value="" />
				                    <label class="col-md-8 control-label" style="text-align: left;" id="modal_tiqu_num"></label>
				                </div>
				                <div class="form-group">
				                	<label class="col-md-3 control-label">驳回原因：</label>
				                    <div class="col-md-8">
				                        <textarea id="modal_deny_cause" name="deny_cause" class="form-control" style="width:100%;" rows="3"></textarea>
				                    </div>
				                </div>
	            			</div>
	            		</div>
	            	</div>
	            </form>
	        </div>
	        <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
	            <button id="bt_bohui_sub" type="button" tag="" class="btn blue">提交</button>
	        </div>
	    </div>
	</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>

<script type="text/javascript">
	$(function(){
		$(".btn_yes").click(function(){
			$.post("./tiqu_dir_examine_allow",{tiqu_num:$(this).attr("goal")},function(data){
				if(data==1){
					alert("审核已经通过！");
					window.location.reload();
				}else{
					alert("提交不成功，请联系技术部！");
				}
			});
		});
		
		$(".btn_no").click(function(){
			$("#modal_tiqu_num").html($(this).attr("goal")).prev().val($(this).attr("goal"));
			$("#modal_bohui").modal();
		});
		
		$("#bt_bohui_sub").click(function(){
			if($("#modal_deny_cause").val()==""){
				alert("请填写驳回原因！");
				return;
			}
			$.ajax({
			    type: "POST",
			    url: "./tiqu_dir_examine_deny",
			    data: $('#form_bohui').serialize(),
			    success: function(data) {
			    		if(data==1){
							alert("审核已经驳回！");
							window.location.reload();
						}else{
							alert("提交不成功，请联系技术部！");
						}
				}
		    });
		});
	})
</script>


</body>
</html>