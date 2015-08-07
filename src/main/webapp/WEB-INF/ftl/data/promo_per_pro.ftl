<#import "../common.ftl" as c>
<#import "./promo_per_pro_js.ftl" as jj>

<@c.html_head></@c.html_head>
<@c.html_body>

<div class="row">
	<div class="col-md-12">
		<form id="form1" action="./promo_per_pro" class="form-horizontal" role="form" method="post">
			<div class="form-body">
				<div class="form-group">
					<div class="col-md-11">
						<input id="page" name="page" type="hidden" value="1" />
						<input id="search_state" name="search_state" type="hidden" value="" />
						<button id="btn_search_new" type="button" onclick="javascript:state_search('new')" class="btn green-meadow btn-circle">新项目【${new_num}】</button>
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
								<th class="text-center">品牌车系</th>
								<th class="text-center">推广区域</th>
								<th class="text-center">推广起止时间</th>
								<th class="text-center">责任客服</th>
								<th class="text-center">推广方案数量</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<#list projectList as project>
								<tr>
									<td>${project_index + 1}</td>
									<td tag="pro_num">${project.get("pro_num")!}</td>
									<td tag="dept_name">${project.get("dept_name")!}</td>
									<td tag="ini_man">${project.get("ini_man")!}</td>
									<td tag="ini_date">${project.get("ini_date")?date}</td>
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
									<td>
										<#if project.get("brand")??>${project.get("brand")}</#if>
										<#if project.get("car")??>--${project.get("car")}</#if>
									</td>
									<td tag="promo_area">
										<#if project.get("promo_prov")=="-1">
											全国
										<#else>
											<#if project.get("prov_name")??>${project.get("prov_name")}</#if><#if project.get("city_name")??>--${project.get("city_name")}</#if>
										</#if>
									</td>
									<td tag="promo_date">${project.get("promo_start_date")?date}至 ${project.get("promo_end_date")?date}</td>
									<td tag="custom_service">${project.get("custom_service")!}</td>
									
									<#if project.get("method_count")=="0">
										<td style="color:#F00;">${project.get("method_count")}</td>
									<#else>
										<td>${project.get("method_count")}</td>
									</#if>
									
									<td>
										<a class="btn_pro_in" href="javascript:void(0)" goal="${project.get("pro_num")}">进入项目</a>
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
	

</div>


</@c.html_body>
<@c.html_js></@c.html_js>

<@jj.jsfile></@jj.jsfile>



</body>
</html>