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
				<a href="index.html">首页</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="#">广告管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="advertisement">广告编辑</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="#">
					<#if city==1>
						北京站广告位
					<#elseif city==9>
						上海站广告位
					<#elseif city==162>
						南京站广告位
					<#elseif city==259>
						武汉站广告位
					<#elseif city==174>
						苏州站广告位
					<#elseif city==175>
						杭州站广告位
					<#elseif city==163>
						徐州站广告位
					<#elseif city==107>
						大连站广告位
					<#elseif city==384>
						成都站广告位
					<#elseif city==186>
						合肥站广告位
					<#elseif city==259>
						武汉站广告位
					<#elseif city==299>
						广州站广告位
					<#elseif city==308>
						东莞站广告位
					<#elseif city==300>
						深圳站广告位
					<#elseif city==311>
						佛山站广告位
					<#elseif city==106>
						沈阳站广告位
					<#elseif city==240>
						郑州站广告位
					<#elseif city==285>
						长沙站广告位
					<#else>
						全国站广告位
					</#if>
				</a>
			</li>
		</ul>
	</div>
	<!-- EDN PAGE HEADER-->
	<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>新增广告
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="addAdvertisement" method="post" id="ADForm">
						<input type="hidden" value="${city}" name="ad.city">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">广告位页面：</label>
								<div class="col-md-3">
									<input type="text" name="ad.html" id="html" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告位类型：</label>
								<div class="col-md-3">
									<select class="form-control" id="adtype" name="ad.adtype">
										<option value="">选择类型</option>
										<option value="1">通栏</option>
										<option value="2">左半通栏</option>
										<option value="5">右半通栏</option>
										<option value="3">按钮广告</option>
										<option value="4">压屏广告</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告位宽度：</label>
								<div class="col-md-3">
									<input type="text" name="ad.adwidth" id="adwidth" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告位高度：</label>
								<div class="col-md-3">
									<input type="text" name="ad.adheight" id="adheight" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告位位置：</label>
								<div class="col-md-3">
									<select class="form-control" id="adplace" name="ad.adplace">
										<option value="">选择位置</option>
										<option value="1">位置1</option>
										<option value="2">位置2</option>
										<option value="3">位置3</option>
										<option value="4">位置4</option>
										<option value="5">位置5</option>
										<option value="6">位置6</option>
										<option value="7">位置7</option>
										<option value="8">位置8</option>
										<option value="9">位置9</option>
										<option value="10">位置10</option>
										<option value="11">位置11</option>
										<option value="12">位置12</option>
										<option value="13">位置13</option>
										<option value="14">位置14</option>
										<option value="15">位置15</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告位价格：</label>
								<div class="col-md-3">
									<input type="text" name="ad.adprice" id="adprice" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">预估点击：</label>
								<div class="col-md-3">
									<input type="text" name="ad.predictclick" id="predictclick" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">预估曝光：</label>
								<div class="col-md-3">
									<input type="text" name="ad.predictexposure" id="predictexposure" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">预估CPC：</label>
								<div class="col-md-3">
									<input type="text" name="ad.predictcpc" id="predictcpc" value="" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">预估CPL：</label>
								<div class="col-md-3">
									<input type="text" name="ad.predictcpl" id="predictcpl" value="" class="form-control">
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
	//表单提交验证
	function checkForm(){
		var predictclick = $.trim($("#predictclick").val());
		var predictcpc = $.trim($("#predictcpc").val());
		var predictcpl = $.trim($("#predictcpl").val());
		var predictexposure = $.trim($("#predictexposure").val());
		var adplace = $.trim($("#adplace").val());
		var adwidth = $.trim($("#adwidth").val());
		var adheight = $.trim($("#adheight").val());
		var adtype = $.trim($("#adtype").val());
		var html = $.trim($("#html").val());
		
		if(html==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adtype==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adheight==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adwidth==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adplace==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(predictexposure==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(predictclick==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(predictcpc==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(predictcpl==""){
			alert("广告链接地址还未输入...");
			return;
		}
		$.ajax({
			url:"${admin_che_url!}adminche/judgeAdHasOrNot",
			data:{city:'${city!}',adplace:adplace,adtype:adtype,html:html},
			dataType:"json",
			success:function(data){
				if(data){
					alert("广告位已存在，请重新录入！！！");
					return;
				}else{
					$("#ADForm").submit();
				}
			}
		});
	}
	
</script>
</body>
</html>