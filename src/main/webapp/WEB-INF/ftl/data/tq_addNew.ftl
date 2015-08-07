<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-top:10px;">
	<div class="col-md-1"></div>
	<div class="col-md-11">
    		<form class="form-horizontal" action=""  role="form" id="newtiqu">
        		<div class="form-body">
            		<div class="form-group">
                		<label class="col-md-1 control-label">执行人</label>
                    	<div class="col-md-3">
                    		<input name="ini_man" type="hidden" value="${ini_man!}" />
                    		<input name="ini_man_name" type="text" value="${ini_man_name!}" class="form-control input-medium" disabled="disabled" />
                    	</div>
                    	<label class="col-md-1 control-label">日期</label>
                    	<div class="col-md-3">
                        	<input name="ini_date" type="text" value="${ini_date!}" class="form-control input-medium" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">站点</label>
                    	<div class="col-md-3">
                    		<input name="ini_org" type="hidden" value="${ini_org!}" />
                    		<input name="ini_org_name" type="text" value="${ini_org_name}" class="form-control input-medium" disabled="disabled" />
                    	</div>
                    	<label class="col-md-1 control-label">部门</label>
                    	<div class="col-md-3">
                    		<input name="ini_dept" type="hidden" value="${ini_dept!}" />
                        	<input name="ini_dept_name" type="text" value="${ini_dept_name!}" class="form-control input-medium" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<div class="col-md-8" style="clear:both; height:3px; border-bottom:2px solid #999;"></div>
                	</div>
                	
                	<div class="form-group">
                		<label class="col-md-1 control-label">业务类型</label>
                    	<div class="col-md-3">
                    		<input name="" type="text" value="数据提取" class="form-control input-medium" disabled="disabled" />
                    	</div>
                    	<label class="col-md-1 control-label">区域</label>
                    	<div class="col-md-3">
                        	<div class="input-group input-large">
	                            <select id="prov" name="prov" class="form-control input-inline input-small">
									<option value="-1">全国</option>
									<#list provList as list>
										<option value="${list.get("catalogid")!}">${list.get("lname")!} ${list.get("catalogname")!}</option>
									</#list>
								</select>
	                            <select id="city" name="city" class="form-control input-inline input-small">
									<option value="-1">-请选择市-</option>
								</select>
	                        </div>
                    	</div>
                	</div>
                	
                	<div class="form-group">
                		<label class="col-md-1 control-label">品牌</label>
                    	<div class="col-md-3">
                    		<select id="brand" name="brand" class="form-control input-inline input-medium">
								<option value="-1">--请选择品牌--</option>
								<#list carList as brand>
									<option value="${brand.get("catalogid")!}">${brand.get("lname")!} ${brand.get("catalogname")!}</option>
								</#list>
							</select>
                    	</div>
                    	<label class="col-md-1 control-label">车系</label>
                    	<div class="col-md-3">
                        	<select id="car" name="car" class="form-control input-inline input-medium">
								<option value="-1">--请选择车系--</option>
							</select>
							<label class="control-label">（非必选）</label>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">关联合同号</label>
                    	<div class="col-md-3">
                    		<input id="contact_num" name="contact_num" type="text" value="" class="form-control input-medium" />
                    	</div>
                    	<label class="col-md-1 control-label">客户名称</label>
                    	<div class="col-md-3">
                        	<input id="cust_name" name="cust_name" type="text" value="" class="form-control input-medium" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">合同金额(元)</label>
                    	<div class="col-md-3">
                    		<input id="contact_money" name="contact_money" type="text" value="" class="form-control input-medium" />
                    	</div>
                    	<label class="col-md-1 control-label">合同起止日期</label>
                    	<div class="col-md-3">
                        	<div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
	                            <input id="contact_start_date" name="contact_start_date" type="text" value="" class="form-control">
	                            <span class="input-group-addon">至</span>
	                            <input id="contact_end_date" name="contact_end_date" type="text" value="" class="form-control">
	                        </div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">数据需求量</label>
                    	<div class="col-md-3">
                    		<input id="data_count" name="data_count" type="text" value="" class="form-control input-medium" />
                    	</div>
                    	<label class="col-md-1 control-label">数据周期</label>
                    	<div class="col-md-3">
                        	<div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
	                            <input id="data_start_date" name="data_start_date" type="text" value="" class="form-control">
	                            <span class="input-group-addon">至</span>
	                            <input id="data_end_date" name="data_end_date" type="text" value="" class="form-control">
	                        </div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">如果扣除执行金额，是否同意：</label>
                    	<div class="col-md-2 radio-list">
							<label class="radio-inline">
							<input type="radio" name="is_agree_deduct" id="optionsRadios4" value="1" checked>是</label>
							<label class="radio-inline">
							<input type="radio" name="is_agree_deduct" id="optionsRadios5" value="0">否</label>
						</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-1 control-label">申请理由</label>
                    	<div class="col-md-3">
							<textarea id="apply_cause" name="apply_cause" class="form-control"></textarea>
						</div>
                	</div>
                	<div class="form-group" style="margin-top:30px;">
                		<div class="col-md-3">
                		</div>
                		<div class="col-md-3">
                			<button id="btn_sub" type="button" class="btn blue" style="width:150px;">提交</button>
                		</div>
                	</div>
                </div>
        	</form>
    	</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>

<script>
$(function(){
	//实现 省--市 联动
	$("#prov").change(function(){
		$("#city").empty();
		if($(this).val()!=-1){
			$("#city").append("<option value='-1'>全省</option>");
			if($(this).val()!="-1"){
				$.post("./tiqu_new_getCityList",{prov:$(this).val()},function(data){
					var arr = eval(data);
					for(var i=0; i<arr.length; i++){
						var p = arr[i];
						$("#city").append("<option value='"+ p.catalogid +"'>"+ p.lname + " " + p.catalogname +"</option>");
					}
				});
			}
		}else {
			$("#city").append("<option value='-1'>-请选择市-</option>");
		}	
	});
	
	//实现 品牌--车系 联动
	$("#brand").change(function(){
		$("#car").empty();
		$("#car").append("<option value='-1'>--请选择车系--</option>");
		if($(this).val()!="-1"){
			$.post("./tiqu_new_getCarCatalog",{fatherid:$(this).val()},function(data){
				if(data!=""){
					var arr = eval(data);
					for(var i=0; i<arr.length; i++){
						var p = arr[i];
						$("#car").append("<option value='"+ p.catalogid +"'>"+ p.lname + " " + p.catalogname +"</option>");
					}
				}
			});
		}
	});
	
	//提交
	$("#btn_sub").click(function(){
		if($("#brand").val()=="-1"){
			alert("请选择【品牌】");
			return;
		}
		
		var json1 = {关联合同号:$("#contact_num"),
					客户名称:$("#cust_name"),
					合同金额:$("#contact_money"),
					合同开始日期:$("#contact_start_date"),
					合同结束日期:$("#contact_end_date"),
					数据需求量:$("#data_count"),
					数据周期开始日期:$("#data_start_date"),
					数据周期结束日期:$("#data_end_date"),
					申请理由:$("#apply_cause")};
		var result = checkEmpty(json1);
		if(result!="1"){
			alert("【" + result + "】不可为空！");
			return;
		}
		
		var json2 = {合同金额:$("#contact_money"),
					数据需求量:$("#data_count")};
		result = checkNum(json2);
		if(result!="1"){
			alert("【" + result + "】必须为数字！");
			return;
		}
		
		var json3 = {合同日期:"#contact_start_date|#contact_end_date",
					数据周期:"#data_start_date|#data_end_date"}
		result = checkDateGroup(json3);
		if(result!="1"){
			alert("【" + result + "】结束日期  大于  起始日期，请重新填写！");
			return;
		}
		
		$.ajax({
		    type: "POST",
		    url: "./tiqu_new_sub",
		    data: $('#newtiqu').serialize(),
		    success: function(data) {
		    		if(data==1){
						alert("添加项目成功！");
						window.parent.removeActiveAndOpenNew('审核结果','./tiqu_examine_result');
					}else{
						alert("提交不成功，请稍后重试！");
					}
			}
	    });
	});
});
//批量检验是否为空值
function checkEmpty(json){
	for(var key in json){
		var tt = json[key].val();
		tt.replace(" ","");
		if(tt.length==0 || tt==""){
			return key;
		}
	}
	return "1";
}
//批量检验是否为数字
function checkNum(json){
	var reg = /^[1-9]+[0-9]*]*$/;
	for(var key in json){
		var tt = json[key].val();
		if(!tt.match(reg)){
			return key;
		}
	}
	return "1";
}
//批量检验日期区间是否合理
function checkDateGroup(json){
	for(var key in json){
		var tt = json[key];
		var arr = tt.split("|");
		var d1 = Date.parse($(arr[0]).val());
		var d2 = Date.parse($(arr[1]).val());
		if(d1>d2){
			return key;
		}
	}
	return "1";
}
</script>
</body>
</html>