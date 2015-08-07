
${err!""}
<div>
总浏览次数${allCount!}，总独立访客${allPeopleCount!}
</div>
<div class="table-container">
	<#if newslist??>
	<table class="table table-striped table-bordered table-hover" id="datatable_orders">
		<thead>
		<tr role="row" class="heading">
			<th width="20%">
				标题
			</th>
			<th width="8%">
				 编辑
			</th>
			<th width="8%">
				 类型
			</th>
			<th width="10%">
				日期
			</th>
			<th width="8%">
				浏览次数
			</th>
			<th width="8%">
				独立访客	
			</th>
			<th width="8%">
				IP
			</th>
			<th width="10%">
				人均浏览页数	
			</th>
			<th width="10%">
				输出PV	
			</th>
			<th width="10%">
				平均页面停留时间	
			</th>
		</tr>
		</thead>
		
		<#list newslist as news>
		<tr role="row" class="filter">
			<td>
				<a href="${news.url!}" target="_blank">${news.newstitle!}</a>
			</td>
			<td>
				${realnameMethod(news.addadmin!)}
			</td>
			<td>
				${news.newsType!}
			</td>
			<td>
				${news.adddate!}
			</td>	
			<td>
				${news.count!}
			</td>
			<td>
				${news.peopleCount!}
			</td>
			<td>	
				${news.ipCount!}
			</td>
			<td>	
				${news.perCount!}
			</td>
			<td>	
				${news.pvCount!}
			</td>
			<td>	
				${news.time!}
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
