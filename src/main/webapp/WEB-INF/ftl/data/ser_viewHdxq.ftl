<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;margin-top:10px;">
         	<div class="col-md-12">
				<div class="col-md-1 text-right">
					<h5>项目编号:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${project.get("pro_num")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>项目名称:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${project.get("acti_name")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>业务类型:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>
						<#if project.get("service_type")??>
                        	<#switch project.get("service_type") >
								<#case "0">
									看车团
									<#break>
								<#case "1">
									直销
									<#break>
								<#case "2">
									车展
									<#break>
								<#case "3">
									大客户
									<#break>
								<#case "4">
									经销商
									<#break>
							</#switch>
                      </#if>
					</label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 text-right">
					<h5>执行人:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_executor_name")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>辅助人员:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_assist_person")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>活动日期:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_acti_date")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>时段:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>
						<#if baseInfo.get("detail_time_interval")??>
                        	<#switch baseInfo.get("detail_time_interval") >
								<#case "0">
									上午
									<#break>
								<#case "1">
									下午
									<#break>
								<#case "2">
									全天
									<#break>
							</#switch>
                      </#if>
					</label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 text-right">
					<h5>大巴交通费:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_traffic_expense")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>活动人员补助:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_acti_sub")!}</label></h5>
				</div>
				<div class="col-md-1 text-right">
					<h5>公司地址:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label>${baseInfo.get("detail_acti_addr")!}</label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-1 text-right">
					<h5>活动总结:</h5>
				</div>
				<div class="col-md-8 text-left">
					<h5><label>${baseInfo.get("detail_acti_report")!}</label></h5>
				</div>
			</div>
</div>
<hr/>
<div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-6">
        		<div class="portlet box">
					<div class="portlet-title">
						<div class="caption" style="color:#3d3d3d;">
							礼品合计
						</div>
					</div>
            		<div class="portlet-body">
            			<table class="table table-condensed table-bordered table-hover">
                    		<thead>
                        		<tr role="row" class="heading">
                            		<th>序号</th>
                            		<th>礼品</th>
                            		<th>数量</th>
                            		<th>金额</th>
                        		</tr>
                    		</thead>
                    		<tbody id="gift_tbody">
                        		<#list gifts as g>
                        			<tr>
                        				<td>${g_index+1}</td>
                        				<td>${g.name}</td>
                        				<td>${g.num}</td>
                        				<td>${g.sum}</td>
                        			</tr>
                        		</#list>
                        			<tr>
                        				<td></td>
                        				<td colspan="2">总价：</td>
                        				<td>${totalPrice}</td>
                        			</tr>
                    		</tbody>
                		</table>
            		</div>
            	</div>
            	<div class="portlet box">
					<div class="portlet-title">
						<div class="caption" style="color:#3d3d3d;">
							客户数据转化
						</div>
					</div>
            		<div class="portlet-body">
            			<table class="table table-condensed table-bordered table-hover">
                    		<thead>
                        		<tr role="row" class="heading">
                            		<th></th>
                            		<th>数量</th>
                            		<th>转化率</th>
                        		</tr>
                    		</thead>
                    		<tbody>
                        		<tr>
                            		<td>邀约数</td>
                            		<td>${data.get("invite")}</td>
                            		<td>--</td>
                        		</tr>
                        		<tr>
                            		<td>到店数</td>
                            		<td>${data.get("reach")}</td>
                            		<td><#if data.get("invite")==0>--<#else>${(data.get("reach")/data.get("invite")*100)?string("#.##")}%</#if></td>
                        		</tr>
                        		<tr>
                            		<td>成交数</td>
                            		<td>${data.get("trans")}</td>
                            		<td><#if data.get("reach")==0>--<#else>${(data.get("trans")/data.get("reach")*100)?string("#.##")}%</#if></td>
                        		</tr>
                        		<tr>
                            		<td>非邀约成交数</td>
                            		<td>${data.get("notInvite")}</td>
                            		<td>--</td>
                        		</tr>
                    		</tbody>
                		</table>
            		</div>
            	</div>
            </div>
</div>
<div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-12">
				<div class="portlet box">
						<div class="portlet-title">
							<div class="caption" style="color:#3d3d3d;">
								签到详情
							</div>
						</div>
						<div class="portlet-body">
        					<table class="table table-condensed table-bordered table-hover">
            					<thead>
                					<tr role="row" class="heading">
                    					<th>姓名</th>
                    					<th>手机号</th>
                    					<th>是否到店</th>
                    					<th>是否成交</th>
                    					<th>成交车型</th>
                    					<th>成交日期</th>
                    					<th>签单销售</th>
                    					<th>审核状态</th>
                    					<th>礼品</th>
                    					<th>快递地址</th>
                    					<th>是否邀约</th>
                					</tr>
             					</thead>
             					<tbody id="tbody">
             						<#list list as bm>
             							<tr id="${bm.get("qiandao_id")!}">
                    						<td tag="name"><label>${bm.get("name")!}</label></td>
                    						<td tag="phone"><label>${bm.get("phone")!}</label></td>
                    						<td>
                    							<#if bm.get("is_reach")=="0">
                    								否
                    							<#else>
                    								是
                    							</#if>
                        					</td>
                        					<td>
                        						<#if bm.get("is_trans")=="0">
                    								否
                    							<#else>
                    								是
                    							</#if>
                        					</td>
                        					<td>
                        						<label>${bm.get("model_trans_name")!}</label>
                        					</td> 
                        					<td>
                        						<label>${bm.get("trans_date")!}</label>
                        					</td>           
                        					<td><label>${bm.get("sale_man")!}</label></td>
                        					<td>
                        						<#if bm.get("gift_examine_state")??>
													<#if bm.get("gift_examine_state")=="0">
														<label	style="color:blue">未审核</label>
													<#elseif bm.get("gift_examine_state")=="1">
														<label style="color:green">已通过</label>
													<#elseif bm.get("gift_examine_state")=="2">
														<label style="color:red">已驳回</label>
													</#if>
												</#if>
                        					</td>
                        					<td>
                        						<label><label name="giving_name">${bm.get("giving_name")!}</label><input type="hidden" name="giving_code" value="${bm.get("giving_code")!}"></label>
                        					</td>
                        					<td><label>${bm.get("addr")!}</label></td>
                        					<td>
                        						<#if bm.get("is_invite")=="0">
                    								否
                    							<#else>
                    								是
                    							</#if>
                       						</td>
                						</tr>
            						</#list>
        						</tbody>
							</table>
						</div>
					</div>
				</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script src="${admin_che_url}js/jPages.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("div.holder").jPages({
	containerID: "itemContainer",
	perPage: 10,
	delay : 0
});
});
</script>
</body>
</html>