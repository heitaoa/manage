<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>

<div class="row">
	<div class="col-md-12 form">
		<form id="form1" action="./count_kct_transtable" class="form-horizontal" method="post" role="form">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">成交日期</label>
					<div class="col-md-3">
                        <div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                            <input type="text" value="${date_start!}" class="form-control" name="date_start">
                            <span class="input-group-addon"> to </span>
                            <input type="text" value="${date_end!}" class="form-control" name="date_end">
                        </div>
                    </div>
                    <label class="col-md-1 control-label">推广区域</label>
					<div class="col-md-3">
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
                    </div>
                </div>
                <div class="form-group">
					<label class="col-md-1 control-label">活动类型</label>
					<div class="col-md-4">
						<select name="service_type" class="form-control input-inline input-small">
							<option></option>
							<option <#if service_type=="0">selected="selected"</#if> value="0">看车团</option>
							<option <#if service_type=="1">selected="selected"</#if> value="1">特卖惠</option>
							<option <#if service_type=="2">selected="selected"</#if> value="2">车展</option>
							<option <#if service_type=="3">selected="selected"</#if> value="3">大客户</option>
						</select>
					</div>
					<div class="col-md-2">
						<input id="page" name="page" type="hidden" value="1"/>
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
				<div class="caption"><i class="fa fa-globe"></i>成交客户表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row" class="heading">
								<th class="text-center">序号</th>
								<th class="text-center">姓名</th>
								<th class="text-center">电话</th>
								<th class="text-center">牌照</th>
								<th class="text-center">地址</th>
								<th class="text-center">成交类型</th>
								<th class="text-center">成交日期</th>
								<th class="text-center">成交活动</th>
								<th class="text-center">礼品</th>
								<th class="text-center">成交价格</th>
								<th class="text-center">发动机号</th>
								<th class="text-center">VIN车架号</th>
							</tr>
						</thead>
						<tbody>
							<#list transList as list>
								<tr>
									<td>${list_index + 1}</td>
									<td>${list.get("name")!}</td>
									<td>${list.get("phone")!}</td>
									<td>${list.get("plate")!}</td>
									<td>${list.get("addr")!}</td>
									<td>${list.get("model_name")!}</td>
									<td><#if list.get("trans_date")!="">${list.get("trans_date")?date}</#if></td>
									<td>${list.get("acti_name")!}</td>
									<td>${list.get("giving_name")!}</td>
									<td>${list.get("trans_price")!}</td>
									<td>${list.get("engine_num")!}</td>
									<td>${list.get("VIN_num")!}</td>
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
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
	
</div>



</@c.html_body>
<@c.html_js></@c.html_js>

<script>
	//实现 省--市 联动
	$("#promo_prov").change(function(){
		$("#promo_city").empty();
		$("#promo_city").append("<option></option>");
		
		if($(this).val()!=""){
			$.post("./present_apply_getcity",{prov:$(this).val()},function(data){
				if(data!=""){
					var arr = data.split("|");
					for(var i=0; i<arr.length/2; i++){
						$("#promo_city").append("<option value='"+ arr[i*2] +"'>"+ arr[i*2+1] +"</option>");
					}
				}
			});
		}
	});
	
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