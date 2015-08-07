<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
	<div class="col-md-12 form">
		<form action="./giftExamineSearch" class="form-horizontal" method="post" role="form" id="searchForm">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">活动类型</label>
					<div class="col-md-2">
						<select name="service_type" class="form-control input-inline input-small" id="service_type">
							<option value="-1">活动类型</option>
							<option value="0" <#if service_type=="0">selected</#if>>看车团</option>
							<option value="1" <#if service_type=="1">selected</#if>>直销</option>
							<option value="2" <#if service_type=="2">selected</#if>>车展</option>
							<option value="3" <#if service_type=="3">selected</#if>>大客户</option>
						</select>
					</div>
					<label class="col-md-1 control-label">活动名称</label>
					<div class="col-md-3">
						<select name="pro_num" class="form-control input-inline input-large" id="pro_num">
							<option  value="-1">活动名称(项目编号)</option>
							<#if pro_numList??>
								<#list pro_numList as p>
									<option  value="${p.pro_num}" <#if p.pro_num==pro_num>selected</#if>>${p.acti_name}(${p.pro_num})</option>
								</#list>
							</#if>
						</select>
					</div>
					<label class="col-md-2 control-label">活动时间</label>
					<div class="col-md-2">
                        <div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            <input type="text" class="form-control" name="start" value="${start!}">
                            <span class="input-group-addon"> to </span>
                            <input type="text" class="form-control" name="end" value="${end!}">
                        </div>
                    </div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">审核状态</label>
					<div class="col-md-2">
						<select name="examine_state" class="form-control input-inline input-small">
							<option value="-1">全部</option>
							<option value="0" <#if examine_state=="0">selected</#if>>未审核</option>
							<option value="1" <#if examine_state=="1">selected</#if>>已通过</option>
							<option value="2" <#if examine_state=="2">selected</#if>>已驳回</option>
						</select>
					</div>
					<label class="col-md-1 control-label">发放状态</label>
					<div class="col-md-2">
						<select name="send_state" class="form-control input-inline input-small">
							<option value="-1">全部</option>
							<option  value="0" <#if send_state=="0">selected</#if>>未发放</option>
							<option  value="1" <#if send_state=="1">selected</#if>>已发放</option>
						</select>
					</div>
					<label class="col-md-1 control-label">成交车型</label>
					<div class="col-md-5">
                        <select name="iway" class="form-control input-inline input-small" id="iway">
							<option  value="">请选择渠道</option>
							<#if iways??>
								<#list iways as i>
									<option  value="${i.code}" <#if i.code==iway>selected</#if>>${i.name}</option>
								</#list>
							</#if>
						</select>
                        <select name="model" class="form-control input-inline input-medium" id="model"> 
							<option  value="-1">请选择车型</option>
							<#if models??>
								<#list models as m>
									<option  value="${m.code}" <#if m.code==model>selected</#if>>${m.name}</option>
								</#list>
							</#if>
						</select>
                    </div>
				</div>	
				<div class="form-group">
					<label class="col-md-1 control-label">姓名</label>
					<div class="col-md-2">
						<input type="text" class="form-control input-small" name="s_name" value="${s_name!}"/>
					</div>
					<label class="col-md-1 control-label">手机号</label>
					<div class="col-md-2">
						<input type="text" class="form-control input-small" name="s_phone" onkeyup="this.value=this.value.replace(/\D/g,'')" value="${s_phone!}"/>
					</div>
					<div class="col-md-3">
					</div>
					<div class="col-md-2">
                    	<input type="hidden" value="1" id="page" name="page">
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
				<div class="caption"><i class="fa fa-globe"></i>礼品审核</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row" class="heading">
								<th class="text-center">序号</th>
								<th class="text-center">姓名</th>
								<th class="text-center">手机号</th>
								<th class="text-center">活动名称</th>
								<th class="text-center">成交时间</th>
								<th class="text-center">活动团长</th>
								<th class="text-center">成交渠道</th>
								<th class="text-center">成交车型</th>
								<th class="text-center">礼品</th>
								<th class="text-center">审核状态</th>
								<th class="text-center">发送状态</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#if list??>
								<#list list as l>
									<tr tag="${l.get("trans_id")}">
										<td>${l_index+1}</td>
										<td>${l.get("name")!}</td>
										<td>${l.get("phone")!}</td>
										<td>${l.get("acti_name")!}</td>
										<td>${l.get("trans_date")!}</td>
										<td>${l.get("ini_man_name")!}</td>
										<td>${l.get("iway")!}</td>
										<td>${l.get("model")!}</td>
										<td>${l.get("giving_name")!}</td>
										<td class="examine_state">
											<#if l.get("gift_examine_state")??>
												<#if l.get("gift_examine_state")=="0">
													<span style="color:blue">未审核</span>
												<#elseif l.get("gift_examine_state")=="1">
													<span style="color:green">已通过</span>
												<#elseif l.get("gift_examine_state")=="2">
													<span style="color:red">已驳回</span>
												</#if>
											</#if>
										</td>
										<td>
											<#if l.get("send_state")??>
												<#if l.get("send_state")=="0">
													<span style="color:blue">未发放</span>
												<#elseif l.get("send_state")=="1">
													<span style="color:green">已发放</span>
												</#if>
											</#if>
										</td>
										<td class="do">
										<#if l.get("gift_examine_state")??>
											<#if l.get("gift_examine_state")=="0">
												
												<a href="javascript:examine(${l.get("trans_id")},1)">通过</a>
												<a href="javascript:examine(${l.get("trans_id")},2)">驳回</a>
											<#else>
												<span>通过</span>&nbsp;<span>驳回</span>
											</#if>
										</#if>
										</td>
									</tr>
								</#list>
							</#if>
							<tr>
								<td colspan=12 style="text-align:center;">
									<@c.calcPageByJs "toPage", page, pages/>
								</td>
							</tr>
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
<script type="text/javascript">
$(document).ready(function(){
	$("#service_type").change(function(){
		var service_type = $(this).val();
		$("#pro_num").empty();
		$("#pro_num").append("<option value='-1'>活动名称(项目编号)</option>");
		if(service_type!="-1"){
			$.ajax({
    			type: "POST",
    			url:"getProNums",
    			data:{
					"service_type":service_type
				},
    			success: function(data) {
    				var p = eval(data);
					for(var i=0;i<p.length;i++){
						var op = "<option value='"+p[i].pro_num+"'>"+p[i].acti_name+"("+p[i].pro_num+")</option>";
						$("#pro_num").append(op);
					}
    			}
  			});
		}
	});
	$("#iway").change(function(){
		var iway = $(this).val();
		$("#model").empty();
		$("#model").append("<option value='-1'>请选择车型</option>");
		if(iway!=""){
			$.ajax({
    			type: "POST",
    			url:"getModels",
    			data:{
					"iway":iway
				},
    			success: function(data) {
    				var p = eval(data);
					for(var i=0;i<p.length;i++){
						var op = "<option value='"+p[i].code+"'>"+p[i].name+"</option>";
						$("#model").append(op);
					}
    			}
  			});
		}
	});
});
function examine(trans_id,state){
	$.ajax({
    	type: "POST",
    	url:"examineGift",
    	data:{
			"trans_id":trans_id,
			"examine_state":state
		},
    	success: function(data) {
    		if(data=="1"){
				$("tr[tag='"+trans_id+"'] td.do").html("<span>通过</span>&nbsp;<span>驳回</span>");
				if(state==1){
					$("tr[tag='"+trans_id+"'] td.examine_state").html("<span style='color:green'>已通过</span>");
				}else if(state==2){
					$("tr[tag='"+trans_id+"'] td.examine_state").html("<span style='color:red'>已驳回</span>");
				}
			}
    	}
  	});
}
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].action = "./giftExamineSearch";
	document.forms[0].submit();
}
</script>
</body>
</html>