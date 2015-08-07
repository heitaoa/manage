<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				广告管理
	</h3>
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="advertisement">广告管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="advertisement">广告编辑</a>
			</li>
		</ul>
	</div>
	<div class="portlet box blue-madison">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-globe"></i>广告位排期
			</div>&nbsp;&nbsp;&nbsp;
			<button class="btn default" type="button" style="margin-top:3px;" onclick="javascript:location.href='toAddAdInfo?adId=${ad.id!}'">添加</button>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:25%">
					排期
				</th>
				<th style="width:25%">
					广告显示
				</th>
				<th style="width:25%">
					 是否为默认广告
				</th>
				<th style="width:25%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
			<#list adInfoList as map>
				<tr>
					<td>
						${map.sdate!}至${map.edate!}
					</td>
					<td>
						<#if map.adimg?ends_with("swf")>
							<embed src="${map.adimg!}" width="600px" height="70px" wmode="transparent" type="application/x-shockwave-flash"></embed>
							<a href="${map.adurl!}" target="_blank"><div style="cursor:pointer;BACKGROUND-IMAGE: url('http://33.autoimg.cn/bg.gif');position:relative;width:600px;height:50px;z-index:10;left:0px;margin:-50px 0px 0px 0px;"></div></a>
						<#else>
							<a href="${map.adurl}" target=_blank><img style="height:70px;width:500px" src="${map.adimg!}"></img></a>
						</#if>
					</td>
					<td>
						 <#if map.isdefault=='0'>
						 	否
						 <#else>
						 	是
						 </#if>
					</td>
					<td>
						 <a href="toUpdateAdInfo?adInfoId=${map.adInfoId!}">修改</a>&nbsp;&nbsp;
						 <a href="deleteAdvertisement?adInfoId=${map.adInfoId!}&scheduleId=${map.sid!}&adId=${map.aid!}">删除</a>
					</td>
				</tr>
			</#list>
			</tbody>
			</table>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
</body>
</html>