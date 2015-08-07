<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				专题管理<small></small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index">首页</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="subject">专题制作</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">专题数据列表</a>
					</li>
				</ul>
			</div>
			<!-- EDN PAGE HEADER-->

		<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>数据列表
					</div>&nbsp;&nbsp;&nbsp;
					<button class="btn default" type="button" style="margin-top:3px;" onclick="javascript:location.href='toAddSubjectData?contentid=${contentid!}'">添加数据</button>
				</div>
				<div class="portlet-body">
					<table class="table table-striped table-bordered table-hover" id="sample_3">
					<thead>
					<tr>
						<th style="width:15%">
							标题
						</th>
						<th style="width:40%">
							文本
						</th>
						<th style="width:30%">
							 图片
						</th>
						<th style="width:15%">
							 操作
						</th>
					</tr>
					</thead>
					<tbody id="showAdInfo">
						<#list subjectdataList as data>
							<tr>
								<td>
									<#if data.title?length==0>
										无标题
									<#else>
										${data.title!}
									</#if>
								</td>
								<td>
									<#if data.content?length==0>
										无文本
									<#else>
										${data.content!}
									</#if>
								</td>
								<td>
									<#if data.pic?length==0>
										无图片
									<#else>
										<img style="height:70px;width:500px" src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>"></img>
									</#if>
								</td>
								<td>
									 <a href="deleteSubjectData?dataId=${data.id!}&contentid=${data.sid!}">删除</a>&nbsp;
									 <a href="toUpdateSubjectData?dataId=${data.id!}">修改</a>
								</td>
							</tr>
						</#list>
					</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
			<!-- END MAIN CONTENTS -->
</@c.html_body>
<@c.html_js></@c.html_js>
</body>
</html>