<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h4 class="page-title">
		广告管理
	</h4>

	<!-- EDN PAGE HEADER-->
	<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>修改广告点击
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="updateExposure" method="post" id="applyForm">
						<input type="hidden" value="${exposure.id!}" name="exposure.id">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">曝光链接：</label>
								<div class="col-md-3">
									<input type="text" name="exposure.url" id="url" class="form-control" value="${exposure.url!}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">开始时间：</label>
								<div class="col-md-9">
								    <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d" style="float:left;">
										<input type="text" class="form-control" readonly id="sdate" name="exposure.sdate" value="${exposure.sdate?string("yyyy-MM-dd")}">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>							
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">结束时间：</label>
								<div class="col-md-9">
						          <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d" style="float:left;">
										<input type="text" class="form-control" readonly id="edate" name="exposure.edate" value="${exposure.edate?string("yyyy-MM-dd")}">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
								</div>
							</div>					
							<div class="form-group">
								<label class="col-md-3 control-label">曝光次数：</label>
								<div class="col-md-9">
									<div id="showDate">
									   <label>
									      <input type="text" name="exposure.count" id="count" class="form-control" value="${exposure.count!}">
									   </label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">标题：</label>
								<div class="col-md-9">
									<div id="showDate">
									   <label>
									      <input type="text" name="exposure.title" id="title" class="form-control" value="${exposure.title!}">
									   </label>
									</div>	
								</div>	
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="checkForm();">提交</button>
									<button type="button" class="btn default" onclick="javascript:history.go(-1);">返回</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
function checkForm(){
     var url = $("#url").val();
     var sdate = $("#sdate").val();
     var edate = $("#edate").val();
     var count = $("#count").val();
     var title = $("#title").val();
     if(url==''){
       alert("请输入曝光链接  ! ! !");
       return;
     }
     if(sdate==''){
       alert("请选择开始时间  ! ! !");
       return;
     }
     if(edate==''){
       alert("请选择结束时间 ! ! !");
       return;
     }
     if(count==''){
       alert("请输入曝光次数 ! ! !");     
       return;
     }
     if(title==''){
       alert("请输入标题 ! ! !");
       return;
     }
     $("#applyForm").submit(); 
}
</script>

</body>
</html>