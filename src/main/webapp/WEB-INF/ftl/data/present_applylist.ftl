<#import "../common.ftl" as c>
<#import "./present_applylist_js1.ftl" as jj>
<@c.html_head></@c.html_head>
<link href="${admin_che_url}assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"/>
<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-editable/inputs-ext/address/address.css"/>

<@c.html_body>

<style type="text/css">
	.editable-unsaved{font-weight:200;}
</style>
<div class="row">
	<div class="col-md-12">
		<form id="form1" action="./present_apply" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">车主姓名：</label>
					<div class="col-md-2">
                        <input name="owner_name" value="${owner_name!}" type="text" class="form-control input-medium" />
                    </div>
                    
                    <label class="col-md-1 control-label">车牌号码：</label>
					<div class="col-md-2">
                        <input name="owner_carcode" type="text" value="${owner_carcode!}" class="form-control input-medium" />
                    </div>
                    
                    <label class="col-md-1 control-label">手机号码：</label>
					<div class="col-md-2">
                        <input name="owner_phone" type="text" value="${owner_phone!}" class="form-control input-medium" />
                    </div>
				</div>
				<div class="form-group">
					
                    <!-- 显示省市，暂时删除该功能
					<label class="col-md-1 control-label">所在省：</label>
					<div class="col-md-2">
						<select id="prov" name="prov" class="form-control input-inline input-medium">
							<option></option>
							<#list provMap?keys as key>
								<option value="${key}">${provMap.get(key)}</option>
							</#list>
						</select>
					</div>
				
					<label class="col-md-1 control-label">所在市：</label>
					<div class="col-md-2">
						<select id="city" name="city" class="form-control input-inline input-medium">
							<option></option>
						</select>
					</div>
					-->
					
					<label class="col-md-1 control-label">礼品状态：</label>
					<div class="col-md-2">
						<select id="select_state" name="state" class="form-control input-inline input-medium">
							<option value="">全部</option>
							<option <#if state=="0">selected="selected"</#if> value="0">未审核</option>
							<option <#if state=="1">selected="selected"</#if> value="1">审核已通过</option>
							<option <#if state=="2">selected="selected"</#if> value="2">审核未通过</option>
							<option <#if state=="3">selected="selected"</#if> value="3">礼品已发放</option>
						</select>
					</div>
					
					<label class="col-md-1 control-label">审核状态：</label>
					<div class="col-md-2">
						<select id="gift_examine_state" name="gift_examine_state" class="form-control input-inline input-medium">
							<option value="">全部</option>
							<option <#if gift_examine_state=="0">selected="selected"</#if> value="0">未审核</option>
							<option <#if gift_examine_state=="1">selected="selected"</#if> value="1">已通过</option>
							<option <#if gift_examine_state=="2">selected="selected"</#if> value="2">已驳回</option>
						</select>
					</div>
					
					<div class="col-md-1"></div>
					<div class="col-md-2">
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
				<div class="caption"><i class="fa fa-globe"></i>礼品申领列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table id="table1" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
							<thead>
								<tr role="row">
									<th class="text-center" width="3%"></th>
									<th class="text-center" width="12%">车主信息</th>
									<th class="text-center" width="8%">礼品确认单</th>
									<th class="text-center" width="8%">购车发票</th>
									<th class="text-center" width="8%">行驶证</th>
									<th class="text-center" width="8%">身份证</th>
									<th class="text-center" width="6%">车辆信息</th>
									<th class="text-center" width="5%">车主留言</th>
									<th class="text-center" width="5%">申请日期</th>
									<th class="text-center" width="6%">票据日期</th>
									<th class="text-center" width="4%">审核状态</th>
									<th class="text-center" width="8%">礼品</th>
									<th class="text-center" width="8%">操作</th>
									<th class="text-center" width="4%">礼品状态</th>
									<th class="text-center" width="7%">快递单号</th>
								</tr>
							</thead>
							<tbody>
								<#list applyList as list>
									<tr targit_id="${list.get("apply_id")!}" tag="${list.get("trans_id")!}">
										<td><input type="checkbox"/></td>
					                    
					                    <!--车主信息-->
					                    <td>
					                        <div>姓名：${list.get("owner_name")!}</div>
					                        <div>手机号：${list.get("owner_phone")!}</div>
					                        <div>车牌号：${list.get("owner_carcode")!}</div>
					                        <div>快递地址：${list.get("owner_address")!}</div>
					                    </td>
					                    <!--礼品确认单 http://gift.chetuan.com/${list.get("giftverify_img")!}-->
					                    <td>
					                    	<a href="http://h.hiphotos.baidu.com/baike/g%3D0%3Bw%3D268/sign=4611680db53533fae5b69625dfeecf29/3c6d55fbb2fb431632eb9b7924a4462309f7d339.jpg" class="fancybox-button carbill_img_a" data-rel="fancybox-button">
												<img class="img-responsive" src="http://h.hiphotos.baidu.com/baike/g%3D0%3Bw%3D268/sign=4611680db53533fae5b69625dfeecf29/3c6d55fbb2fb431632eb9b7924a4462309f7d339.jpg" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--购车发票  http://gift.chetuan.com/${list.get("carbill_img")!}-->
					                    <td>
					                    	<a href="#carbill_img_${list_index}" class="fancybox-button">
												<img class="img-responsive" src="http://img.315che.com/s/A201/312S/1tuu/i6qg/nLU9/90U0.jpg" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <td style="display:none;">
											<div id="carbill_img_${list_index}">
												<div style="clear:both;"><img class="img-responsive" src="http://img.315che.com/s/A201/312S/1tuu/i6qg/nLU9/90U0.jpg" style="width:100%; height:auto;"></div>
												<div style="clear:both; hight:30px; line-height:30px; padding:5px 0;">
													<span style="float:left; hight:30px; line-height:30px;">发动机编号：</span>
													<span style="float:left; hight:30px; line-height:30px;">
								                        <input id="img_engine_${list.get("apply_id")!}" type="text" value="${list.get("engine_num")!}" class="form-control input-medium" />
								                    </span>
								                    
								                    <span style="float:left; margin-left:15px; hight:30px; line-height:30px;">VIN车架号：</span>
													<span style="float:left; hight:30px; line-height:30px;">
								                        <input id="img_vin_${list.get("apply_id")!}" type="text" value="${list.get("vin_num")!}" class="form-control input-medium" />
								                    </span>
								                    
								                    <span style="float:left; hight:30px; line-height:30px; margin-left:15px;">
								                    	<button type="button" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="btn blue btn-circle btn_subCarMsg">提交</button>
								                    </span>
												</div>
											</div>
										</td>
					                    <!--行驶证-->
					                    <td>
					                    	<a href="http://gift.chetuan.com/${list.get("travelcard_img")!}" class="fancybox-button" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("travelcard_img")!}" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--身份证-->
					                    <td>
					                    	<a href="http://gift.chetuan.com/${list.get("idcard_img")!}" class="fancybox-button" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("idcard_img")!}" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--车辆信息-->
					                    <td tag="bianhao">
					                    	<div>发动机编号:</div>
					                    	<#if list.get("trans_id")!="-1">
					                    		<div><a href="#" id="engine_edit_${list.get("apply_id")!}" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="engine_edit editable_a" data-placement="right" data-type="text" data-pk="1" data-url="" data-title="发送机编号">${list.get("engine_num")!}</a></div>
					                    	</#if>
					                    	<div>VIN车架号:</div>
					                    	<#if list.get("trans_id")!="-1">
					                    		<div><a href="#" id="vin_edit_${list.get("apply_id")!}" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="vin_edit editable_a" data-placement="right" data-type="text" data-pk="1" data-url="" data-title="发送机编号">${list.get("VIN_num")!}</a></div>
					                    	</#if>
					                    </td>
					                    <!--车主留言-->
										<td>${list.get("owner_remark")!}</td>
										<!--申请日期-->
										<td>${list.get("apply_date")?date}</td>
										<!--票据日期-->
										<td>
											<div>行驶证发放日期:</div>
											<div>${list.get("travelcard_date")?date}</div>
											<div>购车发票日期:</div>
											<div>${list.get("carbill_date")?date}</div>
										</td>
										<!--审核状态-->
										<td>
											<#switch list.get("gift_examine_state")>
												<#case "-1">
													<label style="color:#666; font-weight:bold;">无</label>
													<#break>
												<#case "0">
													<label style="color:#06F; font-weight:bold;">未审核</label>
													<#break>
												<#case "1">
													<label style="color:#090; font-weight:bold;">已通过</label>
													<#break>
												<#case "2">
													<label style="color:#F00; font-weight:bold;">已驳回</label>
													<#break>
											</#switch>
										</td>
										<!--礼品-->
										<td>
											<#if list.get("trans_id")=="-1">
					                    		<label style="color:#F00; font-weight:bold;">未匹配</label>
					                    	<#elseif list.get("trans_id")=="0">
					                    		<button type="button" class="btn_present btn blue" goal="${list.get("apply_id")}">选择</button>
					                    	<#else>
					                    		${list.get("giving_name")!}
					                    	</#if>
										</td>
										<!--操作（备注）-->
										<td tag="caozuo">
											<div>
												<p>备注：<a href="#" targit_id="${list.get("apply_id")!}" class="remark_edit editable_a" data-placement="left" data-type="text" data-pk="1" data-url="" data-title="添加备注">${list.get("remark")!}</a></p>
											</div>
											<div>
											<#if list.get("gift_examine_state")=='1' >
												<#switch list.get("apply_state")>
													<#case "0">
														<button type="button" class="btn_yes btn blue btn-circle btn-xs" goal="${list.get("apply_id")}">通过</button>
														<button type="button" class="btn_no btn purple btn-circle btn-xs" goal="${list.get("apply_id")}">拒绝</button>
														<button type="button" class="btn_send btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">已发放</button>
														<#break>
													<#case "1">
														<button type="button" class="btn_yes btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">通过</button>
														<button type="button" class="btn_no btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">拒绝</button>
														<button type="button" class="btn_send btn green btn-circle btn-xs" goal="${list.get("apply_id")}">已发放</button>
														<#break>
													<#case "2">
														<button type="button" class="btn_yes btn blue btn-circle btn-xs" goal="${list.get("apply_id")}">通过</button>
														<button type="button" class="btn_no btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">拒绝</button>
														<button type="button" class="btn_send btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">已发放</button>
														<#break>
													<#case "3">
														<button type="button" class="btn_yes btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">通过</button>
														<button type="button" class="btn_no btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">拒绝</button>
														<button type="button" class="btn_send btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">已发放</button>
														<#break>
												</#switch>
											<#else>
												<button type="button" class="btn_yes btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">通过</button>
												<button type="button" class="btn_no btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">拒绝</button>
												<button type="button" class="btn_send btn grey-cascade btn-circle btn-xs" disabled="disabled" goal="${list.get("apply_id")}">已发放</button>
											</#if>
											</div>
										</td>
										
										<!--礼品状态-->
										<td tag="state">
											<#switch list.get("apply_state")>
												<#case "0">
													<label style="color:#06F; font-weight:bold;">未审核</label>
													<#break>
												<#case "1">
													<label style="color:#090; font-weight:bold;">已通过</label>
													<#break>
												<#case "2">
													<label style="color:#F00; font-weight:bold;">已拒绝</label>
													<#break>
												<#case "3">
													<label style="color:#666; font-weight:bold;">已发放</label>
													<#break>
											</#switch>
										</td>
										
										<!--快递单号-->
										<td tag="postbill_code">
											<a href="#" targit_id="${list.get("apply_id")!}" class="postbill_code_edit editable_a" data-placement="left" data-type="text" data-pk="1" data-url="" data-title="快递单号">${list.get("postbill_code")!}</a>
										</td>
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
	
	
	<div id="modal_carMsg" class="modal fade" tabindex="-1" data-backdrop="static" data-width="300">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">修改车辆信息</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<input type="hidden" value="" id="modal_trans_id" />
                	<label class="col-md-12 control-label">发动机编号：</label>
					<div class="col-md-12">
                        <input id="modal_engine_num" name="owner_name" type="text" class="form-control input-medium" />
                    </div>
                    
					<label class="col-md-12 control-label">VIN车架号：</label>
					<div class="col-md-12">
                        <input id="modal_vin_num" name="owner_phone" type="text" class="form-control input-medium" />
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn default" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button type="button" class="btn blue" id="bt_sub_carMsg">提交</button>
        </div>
    </div>
    
    <div id="modal_remark" class="modal fade" tabindex="-1" data-backdrop="static" data-width="300">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">填写备注</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<input type="hidden" value="" id="modal_apply_id" />
                	<label class="col-md-12 control-label">备注：</label>
					<div class="col-md-12">
                        <textarea id="textarea_remark" class="form-control" style="width:100%;" rows="4"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn default" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button type="button" class="btn blue" id="bt_sub_remark">提交</button>
        </div>
    </div>
    
    <div id="modal_present" class="modal fade" tabindex="-1" data-backdrop="static" data-width="300">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">选择礼品</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	<label class="col-md-12 control-label">该手机号对应多个礼品，请选择礼品：</label>
                </div>
                <input type="hidden" value="" id="modal_present_id" />
                <div id="div_present" class="col-md-12">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn default" data-dismiss="modal" aria-hidden="true">关闭</button>
            <button type="button" class="btn blue" id="bt_sub_present">提交</button>
        </div>
    </div>
	
</div>





</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"></script>

<script type="text/javascript" src="${admin_che_url}assets/global/plugins/jquery.mockjax.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.js"></script>


<script type="text/javascript">
	
	$(function(){
		
//		var select_prov = "${prov!}";
//		if(select_prov != ""){
//			$("#city").empty();
//			$("#city").append("<option></option>");
//			
//			$.post("./present_apply_getcity",{prov:select_prov},function(data){
//				if(data!=""){
//					var arr = data.split("|");
//					for(var i=0; i<arr.length/2; i++){
//						$("#city").append("<option value='"+ arr[i*2] +"'>"+ arr[i*2+1] +"</option>");
//					}
//					
//					$("#city").find("option[value='${city!}']").attr("selected",true);
//				}
//			});
//		}
		
		$.mockjax({
		  url: '/abc',
		  responseText: 'haha!'
		});
		
		//初始化edit功能
		$('.postbill_code_edit').editable({
            url: '/abc',
            type: 'text',
            pk: 1,
            name: 'haha',
            title: '快递单号',
			success: function(dd) {
				alert(dd);
			}
        });
		
		
		
		
	})
</script>

<@jj.jsfile></@jj.jsfile>



</body>
</html>