<#import "../common.ftl" as c>
<#import "./present_applylist_js1.ftl" as jj>
<@c.html_head></@c.html_head>
<link href="${admin_che_url}assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"/>
<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-editable/inputs-ext/address/address.css"/>

<style type="text/css">
.img_div_drive{ overflow:hide; display:none; background:#1BBC9B;}
.img_div_bottom{
				clear:both;
				position:fixed;  
				display:none;
				background:#1BBC9B;
			}
.img_div_bottom div{clear:both; 
				height:40px;
				line-height:40px;   
				background:#1BBC9B;
				color:#FFF;
				}
.img_div_bottom div span{float:left; hight:30px; line-height:30px; margin-top:5px;}
.img_div_bottom div .span1{ margin-left:5px; width:90px;}
.img_div_bottom div .span2{ margin-right:5px;}

td{word-break: break-all; word-wrap: break-word;}
</style>

<style>
	.tbox_div{width:450px; float:left; height:30px;  margin-bottom: 15px;}
	.tbox_div .span1{ width:100px; float:left;}
	.tbox_div label{ float:right; margin-right: 5px;}
	.tbox_div .span2{ float:left;}
</style>
<@c.html_body>

<div class="row">
	<div class="col-md-12">
		<form id="form1" action="./present_apply" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					
					<div class="tbox_div">
						<span class="span1">
							<label class="control-label">车主姓名：</label>
						</span>
						<span class="span2">
							<input name="owner_name" value="${owner_name!}" type="text" class="form-control input-medium" />
						</span>
					</div>
					
					<div class="tbox_div">
						<span class="span1">
							<label class="control-label">车牌号码：</label>
						</span>
						<span class="span2">
							<input name="owner_carcode" type="text" value="${owner_carcode!}" class="form-control input-medium" />
						</span>
					</div>
                    
                    <div class="tbox_div">
						<span class="span1">
							<label class="control-label">手机号码：</label>
						</span>
						<span class="span2">
							<input name="owner_phone" type="text" value="${owner_phone!}" class="form-control input-medium" />
						</span>
					</div>
                    
                    <div class="tbox_div">
						<span class="span1">
							<label class="control-label">礼品状态：</label>
						</span>
						<span class="span2">
							<select id="select_state" name="state" class="form-control input-inline input-medium">
								<option value="">全部</option>
								<option <#if state=="0">selected="selected"</#if> value="0">未审核</option>
								<option <#if state=="1">selected="selected"</#if> value="1">审核已通过</option>
								<option <#if state=="2">selected="selected"</#if> value="2">审核未通过</option>
								<option <#if state=="3">selected="selected"</#if> value="3">礼品已发放</option>
							</select>
						</span>
					</div>
					
                    <div class="tbox_div">
						<span class="span1">
							<label class="control-label">审核状态：</label>
						</span>
						<span class="span2">
							<select id="gift_examine_state" name="gift_examine_state" class="form-control input-inline input-medium">
								<option value="">全部</option>
								<option <#if gift_examine_state=="0">selected="selected"</#if> value="0">未审核</option>
								<option <#if gift_examine_state=="1">selected="selected"</#if> value="1">已通过</option>
								<option <#if gift_examine_state=="2">selected="selected"</#if> value="2">已驳回</option>
							</select>
						</span>
					</div>
					
					<div class="tbox_div">
						<span class="span1"></span>
						<span class="span2">
							<input id="page" name="page" type="hidden" value="1" />
							<button id="btn_search" type="submit" class="btn blue btn-circle" style="width:100px;">查询</button>
						</span>
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
									<th class="text-center" width="7%">礼品确认单</th>
									<th class="text-center" width="7%">购车发票</th>
									<th class="text-center" width="7%">行驶证</th>
									<th class="text-center" width="7%">身份证</th>
									<th class="text-center" width="7%">爱车图片</th>
									<th class="text-center" width="7%">车辆信息</th>
									<th class="text-center" width="5%">身份证号</th>
									<th class="text-center" width="5%">车主留言</th>
									<th class="text-center" width="6%">票据日期</th>
									<th class="text-center" width="4%">审核状态</th>
									<th class="text-center" width="5%">礼品</th>
									<th class="text-center" width="7%">操作</th>
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
					                        <div>申请日期：<#if list.get("apply_date")??>${list.get("apply_date")?date}</#if></div>
					                    </td>
					                    <!--礼品确认单 -->
					                    <td>
					                    	<a href="http://gift.chetuan.com/${list.get("giftverify_img")!}" class="fancybox-button carbill_img_a" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("giftverify_img")!}" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--购车发票  -->
					                    <td>
					                    	<a href="#carbill_img_${list_index}" class="fancybox-button carbill_img_a">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("carbill_img")!}" style="width:100%; height:auto;" alt="">
											</a>
											<div class="img_div_drive" id="carbill_img_${list_index}" style="position:relative;">
												<div class="img_div_bottom">
													<div>
														<span class="span1">发动机编号：</span>
														<span class="span2">
									                        <input id="img_engine_${list.get("apply_id")!}" type="text" value="${list.get("engine_num")!}" class="form-control input-medium" />
									                    </span>
								                    </div>
								                    <div>
									                    <span class="span1">VIN车架号：</span>
														<span class="span2">
									                        <input id="img_vin_${list.get("apply_id")!}" type="text" value="${list.get("vin_num")!}" class="form-control input-medium" />
									                    </span>
								                    </div>
								                    <div>
								                    	<button type="button" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="btn blue btn-circle btn_subCarMsg" style="width:150px; margin-left:50px;">提交</button>
								                    </div>
												</div>
												<div style="clear:both;"><img class="img-responsive" src="http://gift.chetuan.com/${list.get("carbill_img")!}" style="width:100%; height:auto;"></div>
											</div>
										</td>
					                    <!--行驶证http://gift.chetuan.com/${list.get("travelcard_img")!}-->
					                    <td>
					                    	<a href="http://gift.chetuan.com/${list.get("travelcard_img")!}" class="fancybox-button carbill_img_a" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("travelcard_img")!}" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--身份证http://gift.chetuan.com/${list.get("idcard_img")!}-->
					                    <td>
					                    	<a href="#idcard_img_${list_index}" class="fancybox-button carbill_img_a" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("idcard_img")!}" style="width:100%; height:auto;" alt="">
											</a>
											<div class="img_div_drive" id="idcard_img_${list_index}" style="position:relative;">
												<div class="img_div_bottom" style="height:90px;">
													<div>
														<span class="span1" style="width:100px;">车主身份证号：</span>
														<span class="span2">
									                        <input id="img_idcard_${list.get("apply_id")!}" type="text" value="${list.get("owner_idcode")!}" class="form-control input-medium" />
									                    </span>
								                    </div>
								                    <div>
								                    	<button type="button" targit_id="${list.get("apply_id")!}" class="btn blue btn-circle btn_subIdCode" style="width:150px; margin-left:50px;">提交</button>
								                    </div>
												</div>
												<div style="clear:both;"><img class="img-responsive" src="http://gift.chetuan.com/${list.get("idcard_img")!}" style="width:100%; height:auto;"></div>
											</div>
					                    </td>
					                    <!--爱车图片-->
					                    <td>
					                    	<a href="http://gift.chetuan.com/${list.get("car_img")!}" class="fancybox-button carbill_img_a" data-rel="fancybox-button">
												<img class="img-responsive" src="http://gift.chetuan.com/${list.get("car_img")!}" style="width:100%; height:auto;" alt="">
											</a>
					                    </td>
					                    <!--车辆信息-->
					                    <td tag="bianhao">
					                    	<div>发动机编号:</div>
						                    	<div>
					                    			<a href="#" id="engine_edit_${list.get("apply_id")!}" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="engine_edit">${list.get("engine_num")!}</a>
					                    			<a href="#" class="pencil"><i class="fa fa-pencil"></i>[编辑]</a>
					                    		</div>
					                    	<div>VIN车架号:</div>
					                    		<div>
						                    		<a href="#" id="vin_edit_${list.get("apply_id")!}" targit_id="${list.get("apply_id")!}" target_transid="${list.get("trans_id")!}" class="vin_edit">${list.get("vin_num")!}</a>
						                    		<a href="#" class="pencil"><i class="fa fa-pencil"></i>[编辑]</a>
					                    		</div>
					                    </td>
					                    <!--车主身份证号-->
					                    <td id="owner_idcode_${list.get("apply_id")!}">${list.get("owner_idcode")!}</td>
					                    <!--车主留言-->
										<td>${list.get("owner_remark")!}</td>
										<!--票据日期-->
										<td>
											<div>行驶证发放日期:</div>
											<div><#if list.get("travelcard_date")??>${list.get("travelcard_date")?date}</#if></div>
											<div>购车发票日期:</div>
											<div><#if list.get("carbill_date")??>${list.get("carbill_date")?date}</#if></div>
										</td>
										<!--审核状态-->
										<td>
											<#switch list.get("gift_examine_state")>
												<#case "-1">
													<label style="color:#F00; font-weight:bold;">未匹配</label>
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
												<p>备注：<a href="#" targit_id="${list.get("apply_id")!}" class="remark_edit">${list.get("remark")!}</a>
												<a href="#" class="pencil"><i class="fa fa-pencil"></i>[编辑]</a>
												</p>
											</div>
											<div>
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
											<a href="#" targit_id="${list.get("apply_id")!}" class="postbill_code_edit">${list.get("postbill_code")!}</a>
											<a href="#" class="pencil"><i class="fa fa-pencil"></i>[编辑]</a>
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

<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.js"></script>


<script type="text/javascript">
jQuery(document).ready(function() {
	// initiate layout and plugins
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	
	$.fn.editable.defaults.inputclass = 'form-control';
	
	//编辑快递单号
	$('.postbill_code_edit').editable({
            url: './present_apply_updatePostBill',
            emptytext: ' ',
            type: 'text',
            params: function(params) {
            	params.apply_id=$(this).attr("targit_id");
            	params.postbill_code=$(this).next().find('.form-control').val();
            	return params;
            },
            placement: 'left',
            pk: 1,
            title: '快递单号',
			success: function(response, newValue) {
				
			},
			erro: function(){
				alert("提交失败，稍后请重试!");
			}
        });
        
    //编辑备注
	$('.remark_edit').editable({
            url: './present_apply_updateRemark',
            emptytext: ' ',
            type: 'text',
            params: function(params) {
            	params.apply_id=$(this).attr("targit_id");
            	params.remark=$(this).next().find('.form-control').val();
            	return params;
            },
            placement: 'left',
            pk: 1,
            title: '编辑备注',
			success: function(response, newValue) {
				
			},
			erro: function(){
				alert("提交失败，稍后请重试!");
			}
        });
    //编辑发动机编号
	$('.engine_edit').editable({
            url: './present_apply_updateCarMsg',
            emptytext: ' ',
            type: 'text',
            params: function(params) {
            	params.apply_id=$(this).attr("targit_id");
            	params.engine_num=$(this).next().find('.form-control').val();
            	params.carmsg_type='engine';
            	return params;
            },
            placement: 'right',
            pk: 1,
            title: '编辑发动机编号',
			success: function(response, newValue) {
				if(response==1){
					$("#img_engine_"+$(this).attr("targit_id")).val(newValue);
				}
			},
			erro: function(){
				alert("提交失败，稍后请重试!");
			}
        });
    //编辑vin车架号
	$('.vin_edit').editable({
            url: './present_apply_updateCarMsg',
            emptytext: ' ',
            type: 'text',
            params: function(params) {
            	params.apply_id=$(this).attr("targit_id");
            	params.vin_num=$(this).next().find('.form-control').val();
            	params.carmsg_type='vin';
            	return params;
            },
            placement: 'right',
            pk: 1,
            title: '编辑vin车架号',
			success: function(response, newValue) {
				if(response==1){
					$("#img_vin_"+$(this).attr("targit_id")).val(newValue);
				}
			},
			erro: function(){
				alert("提交失败，稍后请重试!");
			}
        });
    
    $(".img_div_drive").mouseenter(function(){
    	//$(this).find(".img_div_bottom").show("normal");
    	var obj = $(this).find(".img_div_bottom");
    	obj.animate({height: '140px', opacity: 'show'}, 'normal',function(){ obj.show();});
    });
    $(".img_div_drive").mouseleave(function(){
    	//$(this).find(".img_div_bottom").hide("normal");
    	var obj = $(this).find(".img_div_bottom");
    	obj.animate({height: '140px', opacity: 'hide'}, 'normal',function(){ obj.hide();});
    });
    
    $(".pencil").click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        
        $(this).prev().editable('toggle');
    });

});

</script>

<@jj.jsfile></@jj.jsfile>

</body>
</html>
