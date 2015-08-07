<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style>
.td_title{background-color:#EEE; font-weight:bold; font-size: 14px;}
</style>

<div class="row">
	<div class="col-md-12">
		<form id="form1" action="./promo_per_pro" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					<div class="col-md-11">
						<input id="page" name="page" type="hidden" value="1" />
						<input id="search_state" name="search_state" type="hidden" value="" />
						<!--
						<button id="btn_search_new" type="button" onclick="javascript:state_search('new')" class="btn green-meadow btn-circle">新项目【】</button>
						-->
						<button id="btn_search_old" type="button" onclick="javascript:state_search('old')" class="btn btn-primary btn-circle">推广中 【${old_num}】</button>
						<button id="btn_search_finish" type="button" onclick="javascript:state_search('finish')" class="btn grey-cascade btn-circle">已结束【${finish_num}】</button>
						<button id="btn_search_all" type="submit" class="btn blue btn-circle" style="margin-left:50px;">查看所有</button>
					</div>
				</div>					
			</div>
		</form>
	</div>
	
	<div class="col-md-12">
		
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
		
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>推广项目列表</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="table_1" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="text-center">序号</th>
								<th class="text-center">推广编号</th>
								<th class="text-center">部门</th>
								<th class="text-center">发起人</th>
								<th class="text-center">发起时间</th>
								<th class="text-center">业务类型</th>
								<th class="text-center">渠道车系</th>
								<th class="text-center">推广区域</th>
								<th class="text-center">推广起止时间</th>
								<th class="text-center">责任客服</th>
								<th class="text-center">状态</th>
								<th class="text-center">报名量</th>
								<th class="text-center">回访量</th>
								<th class="text-center">回访率</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list projectList as project>
								<tr>
									<!--序号-->
									<td>${project_index + 1}</td>
									<!--推广编号 -->
									<td tag="pro_num">${project.get("pro_num")!}</td>
									<!--部门 -->
									<td tag="dept_name">${project.get("dept_name")!}</td>
									<!--发起人 -->
									<td tag="ini_man">${project.get("ini_man")!}</td>
									<!--发起时间 -->
									<td tag="ini_date">${project.get("ini_date")?date}</td>
									<!--业务类型 -->
									<td tag="service_type">
										<#switch project.get("service_type")>
											<#case "0">
												看车团
												<#break>
											<#case "2">
												特卖惠
												<#break>
											<#case "3">
												车展
												<#break>
											<#case "4">
												大客户
												<#break>
										</#switch>
									</td>
									<!--渠道车系 -->
									<td>
										${project.get("iway")!}
										<#if project.get("car")!="-1" && project.get("car")!="0">--${project.get("car_name")!}</#if>
										<#if project.get("model")!="-1">--${project.get("model_name")!}</#if>
									</td>
									<!--推广区域 -->
									<td tag="promo_area">
										<#if project.get("promo_prov")=="-1">
											全国
										<#else>
											<#if project.get("prov_name")??>${project.get("prov_name")}</#if><#if project.get("city_name")??>--${project.get("city_name")}</#if>
										</#if>
									</td>
									<!--推广起止时间 -->
									<td tag="promo_date">${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
									<!--责任客服 -->
									<td tag="custom_service">${project.get("custom_service_name")!}</td>
									<!--状态 -->
									<td>
									<#switch project.get("pro_state")>
										<#case "3">
											<lable style="color:#06F">进行中</lable>
											<#break>
										<#case "5">
											<lable style="color:#7F9293">已结束</lable>
											<#break>
									</#switch>
									</td>
									<!--报名量 -->
									<td>${project.get("baoming_count")!}</td>
									<!--回访量 -->
									<td>${project.get("visit_count")!}</td>
									<!--回访率 -->
									<td>${project.get("visit_rate")!}</td>
									<!--操作-->
									<td>
										<a class="btn_pro_info" href="javascript:void(0)" goal="${project.get("pro_num")}">查看</a>
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
	
	<!-- 查看项目弹框 -->
	<div id="modal_ProInfo" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">项目详情</h4>
        </div>
        <div class="modal-body">
            <div class="row">
            	<h4 style="margin-left:20px;">推广需求</h4>
                <div class="col-md-12">
                	<table id="tb_proinfo" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title" width="12%">推广编号</td>
                            <td tag="pro_num" width="21%"></td>
                            <td class="td_title" width="12%">活动名称</td>
                            <td tag="acti_name" width="21%"></td>
                            <td class="td_title" width="12%">部门</td>
                            <td tag="dept_name" width="21%"></td>
                        </tr>
                        <tr>
                            <td class="td_title">发起日期</td>
                            <td tag="ini_date"></td>
                        	<td class="td_title">业务类型</td>
                            <td tag="service_type"></td>
                            <td class="td_title">关联合同号</td>
                            <td tag="contact_num"></td>
                            
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">推广地区</td>
                            <td tag="promo_area"></td>
                            <td class="td_title">渠道车系</td>
                            <td tag="brand"></td>
                            <td class="td_title">竞品车系</td>
                            <td tag="competing"></td>
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">合同起止时间：</td>
                            <td tag="contact_date"></td>
                            <td class="td_title">推广起止时间：</td>
                            <td tag="promo_date"></td>
                            <td class="td_title">活动执行时间：</td>
                            <td tag="active_date"></td>
                        </tr>
                        <tr>
                        	
                        	<td class="td_title">目标线索量:</td>
                            <td tag="clue_num"></td>
                            <td class="td_title">目标到达量：</td>
                            <td tag="reach_num"></td>
                            <td class="td_title">目标成交量:</td>
                            <td tag="trans_num"></td>
                        </tr>
                        <tr>
                        	
                            <td class="td_title">客户名称</td>
                            <td tag="cust_name"></td>
                        	<td class="td_title">责任客服:</td>
                            <td tag="custom_service"></td>
                            <td class="td_title"></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
            
            <div class="row">
            	<h4 style="margin-left:20px;">项目进展情况</h4>
                <div class="col-md-12">
                	<table id="tb_prodata" class="table table-bordered dataTable no-footer" role="grid" aria-describedby="sample_1_info">
                    	<tr>
                        	<td class="td_title" width="11%">报名量</td>
                            <td tag="baoming" width="22%"></td>
                            <td class="td_title" width="11%">回访量</td>
                            <td tag="huifang" width="22%"></td>
                            <td class="td_title" width="11%">回访率</td>
                            <td tag="huifang_rate" width="22%"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn blue" data-dismiss="modal" aria-hidden="true">关闭</button>
        </div>
    </div>

</div>


</@c.html_body>
<@c.html_js></@c.html_js>

<script>
	$(function(){
		$(".btn_pro_info").click(function(){
			var pro_num=$(this).attr("goal");
			$.post("./promo_per_pro_getProInfo",{pro_num:pro_num},function(result){
				var p = eval(result)[0];
				
				var obj_tb = $("#tb_proinfo");     
				obj_tb.find("td[tag='pro_num']").html(p.pro_num);
				obj_tb.find("td[tag='acti_name']").html(p.acti_name);
				obj_tb.find("td[tag='dept_name']").html(p.dept_name);
				obj_tb.find("td[tag='ini_date']").html(p.ini_date);
				obj_tb.find("td[tag='service_type']").html(p.service_type);
				obj_tb.find("td[tag='contact_num']").html(p.contact_num);
				obj_tb.find("td[tag='cust_name']").html(p.cust_name);
				
				var pro_area = ""
				if(p.promo_prov=="-1"){
					pro_area = "全国";
				}else {
					pro_area = p.prov_name;
					if(p.city_name!="-1"){
						pro_area = pro_area + p.city_name;
					}
				}
				obj_tb.find("td[tag='promo_area']").html(pro_area);
				
				if(p.car=="-1" || p.car=="0") p.car_name="";
				if(p.model=="-1" || p.model=="0") p.model_name="";
				
				obj_tb.find("td[tag='brand']").html(p.iway + " " + p.car_name+ " " + p.model_name);
				
				if(!!p.competing_name){
					obj_tb.find("td[tag='competing']").html((p.competing_name).replace(/[A-Z]\?/g, ""));
				}
				
				obj_tb.find("td[tag='contact_date']").html(p.contact_start_date + "至" + p.contact_end_date);
				obj_tb.find("td[tag='promo_date']").html(p.promo_start_date + "至" + p.promo_end_date);
				obj_tb.find("td[tag='active_date']").html(p.acti_start_date + "至" + p.acti_end_date);
				obj_tb.find("td[tag='clue_num']").html(p.tar_clue_num);
				obj_tb.find("td[tag='reach_num']").html(p.tar_reach_num);
				obj_tb.find("td[tag='trans_num']").html(p.tar_trans_num);
				
				if(!!p.custom_service_name){
					obj_tb.find("td[tag='custom_service']").html(p.custom_service_name);
				}
				
				var obj_tb2 = $("#tb_prodata");
				obj_tb2.find("td[tag='baoming']").html(p.baoming_count);
				obj_tb2.find("td[tag='huifang']").html(p.visit_count);
				
				var d1 = parseInt(p.baoming_count);
				var d2 = parseInt(p.visit_count);
				var d3 = 0;
				if(d1!=0){
					d3 = Math.round(d2/d1*10000)/100.00 + "%";
				}
				
				
				obj_tb2.find("td[tag='huifang_rate']").html(d3);
				$('#modal_ProInfo').modal();
			});
		});
	});
	
	function state_search(str_state){
		$("#search_state").attr("value",str_state);
		toPage(1);
	}
	
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