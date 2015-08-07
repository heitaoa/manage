<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>



<div class="row">
	<div class="col-md-12 form">
		<form action="./count_kct_basedate" class="form-horizontal" method="post" role="form">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-1 control-label">品牌</label>
					<div class="col-md-2">
						<select name="brand" class="form-control input-inline input-medium">
							<option></option>
							
						</select>
					</div>
					
					<label class="col-md-1 control-label">时间</label>
					<div class="col-md-3">
                        <div class="input-group input-large date-picker input-daterange" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                            <input type="text" class="form-control" name="date_start">
                            <span class="input-group-addon"> to </span>
                            <input type="text" class="form-control" name="date_end">
                        </div>
                    </div>
					
					<div class="col-md-2">
						<button id="btn_search" type="submit" class="btn blue">查询</button>
					</div>
				</div>			
			</div>
		</form>
	</div>
</div>

<hr/>

<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
		
			<div class="portlet-title">
				<div class="caption"><i class="fa fa-globe"></i>库资源分析</div>
				<div class="actions">
					<a id="btn_add_function" href="javascript:void(0)" class="btn btn-default btn-sm">
					<i class="fa fa-sign-out"></i>导出</a>
				</div>
			</div>
			
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row" class="heading">
								<th class="text-center">序号</th>
								<th class="text-center">推广编号</th>
								<th class="text-center">品牌</th>
								<th class="text-center">推广区域</th>
								<th class="text-center">客户名称</th>
								<th class="text-center">关联合同号</th>
								<th class="text-center">推广起止时间</th>
								<th class="text-center">线索量</th>
								<th class="text-center">成交量</th>
								<th class="text-center">状态</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
	
	
	<!-- 库数据未确定 -->
	<div id="modal_notsure" class="modal" tabindex="-1" data-backdrop="static" data-width="400">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">重要提示</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12" style="font-size:16px; color:#35aa47;">
                	由于客服那边库数据对应的检索条件尚未确定，该模块暂时不能使用！
                </div>
            </div>
        </div>
    </div>

</div>



</@c.html_body>
<@c.html_js></@c.html_js>

<script>
$(function(){
	$("#modal_notsure").modal();
})
</script>

</body>
</html>