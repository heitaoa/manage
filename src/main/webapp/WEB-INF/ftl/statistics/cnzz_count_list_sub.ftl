
${err!""}
<div class="table-container">
	<#if countMap??>
	<table class="table table-striped table-bordered table-hover" id="datatable_orders">
		<thead>
		<tr role="row" class="heading">
			<th width="20%">
				 编辑
			</th>
			<th width="20%">
				浏览总次数
			</th>
			<th width="20%">
				独立总访客	
			</th>
			<th width="20%">
				IP总数
			</th>
			<th width="20%">
				输出总PV	
			</th>
		</tr>
		</thead>
		
		<#list countMap?keys as key>
			<tr role="row" class="filter">
				<td>
					${realnameMethod(key)!}
				</td>
				<td>
					${countMap.get(key).totalCount!}
				</td>
				<td>
					${countMap.get(key).totalPeopleCount!}
				</td>
				<td>	
					${countMap.get(key).totalIpCount!}
				</td>
				<td>	
					${countMap.get(key).totalPvCount!}
				</td>
			</tr>
		</#list>
		</table>
		
		<div class="row">
			<div class="col-md-5 col-sm-12">
				<div class="dataTables_info" id="sample_1_info" role="status" aria-live="polite">
					 第${page}页，共${totalPage}页，跳转到
					<input id="turn_Page" name="" type="text" style=" width:36px; height:26px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					<a href="javascript:void(0);" onclick="toPage($('#turn_Page').val());">GO</a>
				</div>
			</div>
			<#import "../news/common_news.ftl" as cp>
			<div class="col-md-7 col-sm-12">
				<div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">
					 <@cp.calcPageByJs "toPage", page, totalPage/>
				</div>
			</div>
		</div>
		
		</#if>	
</div>
