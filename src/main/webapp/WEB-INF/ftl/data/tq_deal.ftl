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
				<div class="caption"><i class="fa fa-globe"></i>待处理项目列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="text-center">编号</th>
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
								<th class="text-center">审核状态</th>
								<th class="text-center">是否减扣执行金额</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list proList as list>
							<tr>
								<!-- 编号 -->
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
								<td>${list.get("data_count")!}</td>
								<!-- 数据周期 -->
								<td>${list.get("data_start_date")!}至${list.get("data_end_date")!}</td>
								<!-- 合同号 -->
								<td>${list.get("contact_num")!}</td>
								<!-- 合同金额 -->
								<td>${list.get("contact_money")!}</td>
								<!-- 申请理由 -->
								<td>${list.get("apply_cause")!}</td>
								<!-- 审核状态 -->
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
								<!-- 是否减扣执行金额 -->
								<td>
									<#if list.get("tiqu_state")=="0">否<#else>是</#if>
								</td>
								<!-- 操作 -->
								<td>
									<button type="button" class="btn_look btn green btn-circle btn-xs" goal="${list.get("tiqu_num")}" goal_count="${list.get("data_count")!}">查看数据</button>
									<button type="button" class="btn_queren btn blue btn-circle btn-xs" goal="${list.get("tiqu_num")}">确认已执行</button>
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
		<input type="hidden" id="select_all" value="" />
		<input type="hidden" id="select_tiqu_num" value="" />
		<input type="hidden" id="need_num" value="" />
		<div class="col-md-4">
			<label>共</label><label style="color:#00F; margin:0 5px;" id="baoming_count">0</label><label style="margin-right:20px;">条</label>
			<label>已选择</label><label style="color:#00F; margin:0 5px;" id="select_count">0</label><label>条</label>
		</div>
		<div class="col-md-4" style="text-align: right;">
			<button id="btn_export" type="button" class="btn blue btn-circle btn-xs" style="padding: 4px 20px;">导出</button>
		</div>
	</div>
	<div class="col-md-8" style="margin-top:5px;">
		<table class="table table-bordered" id="tabel_data">
		<thead>
		<tr>
			<th><input type='checkbox' id='bm_check_all'/></th>
			<th>序号</th>
			<th>姓名</th>
			<th>手机</th>
			<th>报名时间</th>
			<th>地区</th>
			<th>品牌</th>
			<th>是否回访</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
		</table>
	</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>

<script type="text/javascript">
	$(function(){
		//复选框单击按钮加载事件
		$(".bm_check").live('change', function() {
			if($(this).prop("checked")){
				//$(this).parents("tr").css({background:"#017ebc",color:"#FFF"});
				$(this).parents("tr").css({background:"#BBDBA1",color:"#000"});
			}else{
				$(this).parents("tr").css({background:"#FFF",color:"#000"});
			}
			var cc = $(".bm_check");
			var jj = 0;
			var str_selectid = "";
			var bm_id = "";
			for(var i=0; i<cc.length; i++){
				if($(cc[i]).prop("checked")){
					jj = jj + 1;
					bm_id = $(cc[i]).parents("tr").attr("tag");
					str_selectid = str_selectid + bm_id + "-";
				}
			}
			$("#select_count").html(jj);
			str_selectid = str_selectid.substring(0,str_selectid.length-1);
			$("#select_all").val(str_selectid);
		});
		
		//单击一行，改行被选中
		$(".td_mm").live('click', function() {
			$(this).parents("tr").find(".bm_check").trigger("click");
		});
		
		//查看数据
		$(".btn_look").click(function(){
			var goal_count = parseInt($(this).attr("goal_count")) + 50;
			$("#need_num").val(goal_count);
			$("#select_tiqu_num").val($(this).attr("goal"));
			var tbody = $("#tabel_data").find("tbody");
			tbody.empty();
			$("#baoming_count").html("0");
			$("#select_count").html("0");
			$.post("tiqu_deal_getBaomingData",{tiqu_num:$(this).attr("goal"), date_count:goal_count},function(data){
				var arr = eval(data);
				$("#baoming_count").html(arr.length);
				for(var i=0; i<arr.length; i++){
					if(i<goal_count){
						var p = arr[i];
						var str = "<tr class='bm_tr' tag='"+ p.baoming_id +"'>";
						str = str + "<td><input type='checkbox' class='bm_check' /></td>";
						str = str + "<td class='td_mm'>"+ (i+1) +"</td>";
						str = str + "<td class='td_mm'>"+ p.uname +"</td>";
						str = str + "<td class='td_mm'>"+ p.phone +"</td>";
						str = str + "<td class='td_mm'>"+ p.baoming_date +"</td>";
						str = str + "<td class='td_mm'>"+ p.prov_name + "--" + p.city_name +"</td>";
						str = str + "<td class='td_mm'>"+ p.brand_name + "--" + p.car_name +"</td>";
						str = str + "<td class='td_mm'>"+ p.return_visit_state +"</td>";
						str = str + "</tr>";
						tbody.append(str);
					}
				}
			})
		});
		
		//导出
		$("#btn_export").click(function(){
			if($("#select_count").html()=="0"){
				alert("选中信息数量为0，请选择相关数据！");
			}else{
				window.location="./tiqu_deal_exportData?tiqu_num=" + $("#select_tiqu_num").val() + "&select_ids=" + $("#select_all").val() + "&date_count=" + $("#need_num").val();
				
				
			}
		});
		
		//选择所有行
		$("#bm_check_all").change(function(){
			if($(this).prop("checked")){
				var jj = 0;
				var str_selectid = "";
				var bm_id = "";
				$(".bm_check").each(function () {
					$(this).attr("checked", true);
					$(this).parents("tr").css({background:"#BBDBA1",color:"#000"});
					bm_id = $(this).parents("tr").attr("tag");
					str_selectid = str_selectid + bm_id + "-";
					jj = jj + 1;
				})
				$("#select_count").html(jj);
				str_selectid = str_selectid.substring(0,str_selectid.length-1);
				$("#select_all").val(str_selectid);
				$("#select_count").html(jj);
			}else{
				$(".bm_check").each(function () {
					$(this).attr("checked", false);
					$(this).parents("tr").css({background:"#FFF",color:"#000"});
				})
				$("#select_all").val("");
				$("#select_count").html("0");
			}
			
		});
		
		//确认已执行
		$(".btn_queren").click(function(){
			$.post("tiqu_deal_executeYes",{tiqu_num:$(this).attr("goal")},function(data){
				if(data==1){
					window.location.reload();
				}else{
					alert(data);
				}
			});
		});
	})
</script>


</body>
</html>