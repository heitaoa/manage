<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style type="text/css">
.div_gift{border:1px solid #999; float:left; height:25px; line-height:25px; padding:0 3px; margin:5px;}
.div_gift a{margin:0 3px;}
.div_gift a i{color:#1bbc9b;}
</style>
<div class="row">
	<div class="col-md-12">
		<div class="portlet-body">
			<ul class="nav nav-tabs">
				<li <#if tab==0>class="active"</#if>>
					<a href="#portlet_gift" data-toggle="tab">礼品</a>
				</li>
				<li <#if tab==1>class="active"</#if>>
					<a href="#portlet_package" data-toggle="tab">礼包</a>
				</li>
			</ul>  <!-- nav end -->
			
			<div class="tab-content">
				<div class=" tab-pane fade <#if tab==0>active in</#if>" id="portlet_gift">
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption"><i class="fa fa-globe"></i>礼品列表</div>
							<div class="actions">
								<a id="add_gift"; href="javascript:void();" class="btn btn-default btn-sm">
								<i class="fa fa-plus"></i>添加</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
									<thead>
										<tr role="row">
											<th class="text-center">序号</th>
											<th class="text-center">礼品名称</th>
											<th class="text-center">礼品价格</th>
											<th class="text-center">添加时间</th>
											<th class="text-center">操作</th>
										</tr>
									</thead>
									<tbody>
										<#list giftList as list>
										<tr>
											<!-- 序号 -->
											<td>${list_index + 1}</td>
											<!-- 礼品名称 -->
											<td>${list["gift_name"]!}</td>
											<!-- 价格 -->
											<td>${list["gift_price"]!}</td>
											<!-- 添加时间 -->
											<td>${list["gift_addtime"]}</td>
											<!-- 操作 -->
											<td>
												<button type="button" class="btn_del btn green btn-circle btn-xs" tar_name="${list["gift_name"]!}" goal="${list["gift_id"]}">删除</button>
											</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<div class="tab-pane fade <#if tab==1>active in</#if>" id="portlet_package">
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption"><i class="fa fa-globe"></i>礼包列表</div>
							<div class="actions">
								<a id="add_package"; href="javascript:void();" class="btn btn-default btn-sm">
								<i class="fa fa-plus"></i>添加</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
									<thead>
										<tr role="row">
											<th class="text-center">序号</th>
											<th class="text-center">礼包名称</th>
											<th class="text-center">礼包明细</th>
											<th class="text-center">礼包价值</th>
											<th class="text-center">添加时间</th>
											<th class="text-center">操作</th>
										</tr>
									</thead>
									<tbody>
										<#list packageList as list>
										<tr>
											<!-- 序号 -->
											<td>${list_index + 1}</td>
											<!-- 礼包名称 -->
											<td>${list["package_name"]!}</td>
											<!-- 礼包明细 -->
											<td>${list["package_detail"]!}</td>
											<!-- 礼包价值 -->
											<td>${list["package_price"]!}</td>
											<!-- 添加时间 -->
											<td>${list["addtime"]}</td>
											<!-- 操作 -->
											<td>
												<button type="button" class="btn_del_package btn green btn-circle btn-xs" tar_name="${list["package_name"]!}" goal="${list["package_id"]}">删除</button>
											</td>
										</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div> <!-- content end -->
		</div> <!-- tab end -->
	</div>
	
	<div class="col-md-12">
		<div id="modal_add_gift" class="modal fade" tabindex="-1" data-backdrop="static" data-width="600">
	        <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	            <h4 class="modal-title">添加礼品</h4>
	        </div>
	        <div class="modal-body">
	        	<form id="form_gift" class="form-horizontal" method="post" role="form">
	            	<input type="hidden" name="tab" value="0" />
	            	<div class="form-body">
	            		<div class="row">
	            			<div class="col-md-12">
				                <div class="form-group">
				                	<label class="col-md-3 control-label">礼品名称：</label>
				                    <div class="col-md-8">
				                        <input id="add_gift_name" name="gift_name" type="text" class="form-control" />
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-md-3 control-label">礼品价格(元)：</label>
				                    <div class="col-md-8">
				                        <input id="add_gift_price" name="gift_price" type="text" class="form-control input-medium" />
				                    </div>
				                </div>
	            			</div>
	            		</div>
	            	</div>
	            </form>
	        </div>
	        <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
	            <button id="bt_gift_sub" type="button" tag="" class="btn blue">提交</button>
	        </div>
	    </div>
	</div>
	
	<div class="col-md-12">
		<div id="modal_add_package" class="modal fade" tabindex="-1" data-backdrop="static" data-width="800">
	        <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	            <h4 class="modal-title">添加礼包</h4>
	        </div>
	        <div class="modal-body">
	        	<form id="form_package" class="form-horizontal" method="post" role="form">
	            	<input type="hidden" name="tab" value="1" />
	            	<div class="form-body">
	            		<div class="row">
	            			<div class="col-md-12">
				                <div class="form-group">
				                	<label class="col-md-3 control-label">礼包名称：</label>
				                    <div class="col-md-8">
				                        <input id="add_package_name" name="package_name" type="text" class="form-control" />
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-md-3 control-label">选择礼品：</label>
				                    <div class="col-md-8">
				                    	<table>
				                    		<tr>
				                    			<td>
				                    				<select id="gift_select" class="form-control input-medium" style="float:left;">
														<option value="">--选择礼品--</option>
														<#list giftList as list>
															<option value="${list["gift_id"]}_${list["gift_price"]}">${list["gift_name"]}</option>
														</#list>
													</select>
				                    			</td>
				                    			<td style="width:40px; text-align:center;">数量</td>
				                    			<td><input id="gift_num" type="text" value="1" class="form-control" style="width:50px;"></td>
				                    			<td style="width:100px; text-align:center;"><input id="bt_addgift" type="button" class="btn blue" value="添加" /></td>
				                    		</tr>
				                    	</table>
									</div>
				                </div>
				                <div class="form-group">
				                	<div class="col-md-3"></div>
				                    <div class="col-md-8" id="gift_selected">
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-md-3 control-label">礼包价值(元)：</label>
				                    <div class="col-md-8">
				                    	<input id="package_price_disabel" type="text" disabled="disabled" value="0" class="form-control input-small">
				                    	<input id="package_price" name="package_price" type="hidden" value="0">
				                    	<input id="package_detail" name="package_detail" type="hidden" value="">
				                    	<input id="packgiftStr" name="packgiftStr" type="hidden" value="">
				                	</div>
				                </div>
	            			</div>
	            		</div>
	            	</div>
	            </form>
	        </div>
	        <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
	            <button id="bt_package_sub" type="button" tag="" class="btn blue">提交</button>
	        </div>
	    </div>
	</div>
	
</div>

</@c.html_body>
<@c.html_js></@c.html_js>

<script type="text/javascript">
$(function(){
	//弹出添加礼品框
	$("#add_gift").click(function(){
		$("#add_gift_name").val("");
		$("#add_gift_price").val("");
		$("#modal_add_gift").modal();
	});
	
	//弹出添加礼包的框
	$("#add_package").click(function(){
		$("#add_package_name").val("");
		$("#gift_selected").empty();
		$.post("./present_gift_getGift",{},function(data){
			var arr = eval(data);
			$("#gift_select").empty();
			$("#gift_select").append('<option value="">--选择礼品--</option>');
			for(var i=0; i<arr.length; i++){
				var p = arr[i];
				$("#gift_select").append('<option value="'+ p.gift_id +'_'+ p.gift_price +'">'+ p.gift_name +'</option>');
			}
			
			$("#modal_add_package").modal();
		});
	});
	
	//添加礼品按钮
	$("#bt_gift_sub").click(function(){
		var json1 = {礼品名称:$("#add_gift_name"),
					礼品价格:$("#add_gift_price")};
		var result = checkEmpty(json1);
		if(result!="1"){
			alert("【" + result + "】不可为空！");
			return;
		}
		
		var json2 = {礼品价格:$("#add_gift_price")};
		var result = checkNum(json2);
		if(result!="1"){
			alert("【" + result + "】必须为数字！");
			return;
		}
		
		$.ajax({
		    type: "POST",
		    url: "./present_gift_add",
		    data: $('#form_gift').serialize(),
		    success: function(data) {
		    		if(data==1){
						alert("添加礼品成功！");
						window.location.href = './present_gift?tab=0';
					}else{
						alert(data);
					}
			},
			error: function() {
				alert("提交信息失败！");
			}
	    });
	});
	
	//删除礼品
	$(".btn_del").click(function(){
		if(confirm("真的要删除礼品【"+ $(this).attr("tar_name") +"】？") == true){
			var obj = $(this); 
			$.post("./present_gift_del",{gift_id:obj.attr("goal")},function(data){
				if(data==1){
					obj.parents("tr").remove();
				}else {
					alert("删除失败，稍后请重试！");
				}
			});
		}
	});
	
	//删除所选择的礼品
	$("#bt_addgift").click(function(){
		var gift_val = $("#gift_select").val();
		if(gift_val==""){
			alert("请选择礼品！");
			return;
		}
		var json1 = {礼品数量:$("#gift_num")};
		var result = checkNum(json1);
		if(result!="1"){
			alert("【" + result + "】必须为数字！");
			return;
		}
		
		var gift_text = $("#gift_select").find("option:selected").text();
		
		var str_gift_val = gift_val + "!" + $("#gift_num").val();
		var str_gift = gift_text + "×" + $("#gift_num").val();
		var str_add = '<div class="div_gift">'
					+ '<a href="javascript:void(0);" tag_gift_text="'+ str_gift +'" tag_gift_val="'+ str_gift_val +'" tag_val="'+ gift_val +'" tag_text="'+ gift_text +'" class="gift_select_del"><i class="fa fa-times"></i></a>'
					+ '<label>'+ str_gift +'</label>'
					+ '</div>';
		$("#gift_selected").append(str_add);
		
		$("#gift_select").val("").find("option[value='"+ gift_val +"']").remove();
		gift_sum();
	});
	
	//绑定已选择礼品的删除事件
	$(".gift_select_del").live("click", function(){
		var str = '<option value="'+ $(this).attr("tag_val") +'">'+ $(this).attr("tag_text") +'</option>';
		$("#gift_select").append(str);
		$(this).parent().remove();
		gift_sum();
	});
	
	//添加礼包
	$("#bt_package_sub").click(function(){
		if(checkEmpty({礼包名称:$("#add_package_name")})!="1"){
			alert("【礼包名称】不可为空！");
			return;
		}
		if($(".gift_select_del").length==0){
			alert("请选择礼品!");
			return;
		}
		
		$.ajax({
		    type: "POST",
		    url: "./present_gift_addPackage",
		    data: $('#form_package').serialize(),
		    success: function(data) {
		    		if(data==1){
						alert("添加礼包成功！");
						window.location.href = './present_gift?tab=1';
					}else{
						alert(data);
					}
			},
			error: function() {
				alert("提交信息失败！");
			}
	    });
	});
	
	$(".btn_del_package").click(function(){
		if(confirm("真的要删除礼包【"+ $(this).attr("tar_name") +"】？") == true){
			var obj = $(this); 
			$.post("./present_gift_delPackage",{package_id:obj.attr("goal")},function(data){
				if(data==1){
					obj.parents("tr").remove();
				}else {
					alert("删除失败，稍后请重试！");
				}
			});
		}
	});
});

//添加或删除礼品时进行汇总
function gift_sum(){
	var str_giftval = "";
	var str_gifttxt = "";
	var pack_price = 0;
	$(".gift_select_del").each(function(){
	   str_gifttxt = str_gifttxt + "【"+ $(this).attr("tag_gift_text") +"】";
	   var tt = $(this).attr("tag_gift_val");
	   str_giftval = str_giftval + tt + "-";
	   var arr = tt.split("!");
	   var pp = arr[0].split("_")[1];
	   pack_price = pack_price + parseInt(pp)*parseInt(arr[1]);
	});
	
	$("#package_price_disabel").val(pack_price);
	$("#package_price").val(pack_price);
	$("#package_detail").val(str_gifttxt);
	$("#packgiftStr").val(str_giftval);
}
	
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
</script>


</body>
</html>