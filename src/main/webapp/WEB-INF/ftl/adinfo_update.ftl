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
				<a href="#"></a>
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
					<form class="form-horizontal" role="form" action="addAdInfo" method="post" id="applyForm">
						<input type="hidden" name="adInfo.adid" id="adId" value="${adInfo.adid!}"/>
						<input type="hidden" name="adInfo.adinfoid" id="adInfoId" value="${adInfo.adinfoid!}">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">广告链接链接：</label>
								<div class="col-md-3">
									<input type="text" name="adInfo.adurl" id="adurl" value="${adInfo.adurl!}" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">是否显示广告：</label>
								<div class="col-md-9">
									<div class="radio-list">
										<label>
										<input type="radio" name="adInfo.isshow" id="isshow" value="0" <#if adInfo.isshow==0>checked</#if>>显示广告</label>
										<label>
										<input type="radio" name="adInfo.isshow" id="isshow" value="1" <#if adInfo.isshow==1>checked</#if>>不显示广告</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">是否为默认广告：</label>
								<div class="col-md-9">
									<div class="radio-list">
										<label>
										<input type="radio" name="adInfo.isdefault" id="isdefault" value="0" <#if adInfo.isdefault==0>checked</#if>>非默认广告</label>
										<label>
										<input type="radio" name="adInfo.isdefault" id="isdefault" value="1" <#if adInfo.isdefault==1>checked</#if>>默认广告</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告时间：</label>
								<div class="col-md-9">
									<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d" style="float:left;">
										<input type="text" class="form-control" readonly id="sdate">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
									<div style="float:left; margin: 0 5px; height:40px; line-height:35px;"> 至 </div>
									<div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d" style="float:left;">
										<input type="text" class="form-control" readonly id="edate">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
									&nbsp;&nbsp;<button type="button" class="btn green" id="saveDate">添加</button>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label">排期列表：</label>
								<div class="col-md-9">
									<div id="showDate">
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 control-label">上传广告图片：</label>
								<div class="col-md-9">
									<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
									<input type="text" name="adInfo.adimg" id="adimg" value="${adInfo.adimg!}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">图片显示：</label>
								<div class="col-md-9" id="showPhoto">
									<#if adInfo.adimg?exists>
										<#if adInfo.adimg?ends_with("swf")>
											<embed src="${adInfo.adimg!}" width="600" height="100" wmode="transparent" type="application/x-shockwave-flash"></embed>
										<#else>
											<img style="height:100px;width="500"" src="${adInfo.adimg!}"></img>
										</#if>
									</#if>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">压屏广告小图：</label>
								<div class="col-md-9">
									<input type="text" name="adInfo.adftl" id="adftl" value="${adInfo.adftl!}">
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="checkForm();">修改</button>
									<button type="button" class="btn default" onclick="javascript:history.go(-1);">返回</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
	//初始换排期列表
	$(document).ready(function(){
		var adInfoId = $("#adInfoId").val();
		if(adInfoId!=""){
			$.ajax({
				url:"getAdSchedule?adInfoId="+adInfoId,
				dataType:"json",
				success:function(data){
					var list = eval(data);
					var html = '';
					for(var i=0;i<list.length;i++){
						html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deleteAdschedule('+list[i].sid+','+i+');">删除</button></p>';
					}
					$("#showDate").html(html);
				}
			});
		}
		
	});
	
	function checkForm(){
		var adurl = $.trim($("#adurl").val());
		var adimg = $("#adimg").val();
		var adSchedule = $.trim($("#showDate").html());
		
		if(adurl==''){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adimg==''){
			alert("广告图片还未上传...");
			return;
		}
		if(adSchedule.length==""){
			alert("广告排期还未输入...");
			return;
		}
		alert("修改成功");
		$("#applyForm").submit();
	}
	
	$("#saveDate").click(function(){
		var sdate = $("#sdate").val();
		var edate = $("#edate").val();
		var adInfoId = $("#adInfoId").val();
		var adId = $("#adId").val();
		if(sdate==""||edate==""){
			alert("还有未选择的日期。。");
			return;
		}
		if(!test(sdate,edate)){
			alert("开始日期晚于结束日期，，请重新输入。。");
			return;
		}
		
		var flag = false;
		$("#showDate").find("label").each(function(){
			var dataStr = $(this).html();
			if(dataStr!=""){
				var array = dataStr.split("至");
				if(!(!test(sdate,array[1])||!test(array[0],edate))){
					alert("选择的日期存在冲突，如想继续请先删除已有排期！！！");
					 flag = true;
					 return false;
				}
			}
		});
		
		if(flag){
			return;
		}
		
		$.ajax({
			url:'addAdSchedule?sdate='+sdate+'&edate='+edate+'&adInfoId='+adInfoId+'&adId='+adId,
			dataType:'json',
			success:function(data){
				var list = eval(data);
				var html = '';
				for(var i=0;i<list.length;i++){
					html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deleteAdschedule('+list[i].id+','+i+');">删除</button></p>';
				}
				$("#showDate").html(html);
			}
		});
	
	});
	
	
	function test(str1,str2){   
		var d1 = new Date(str1);   
		var d2 = new Date(str2);     
		if(Date.parse(d1) - Date.parse(d2)>0){   
			return false;
		}else{
			return true;
		}
	}   
	
	function deleteAdschedule(sid,i){
		var adInfoId = $("#adInfoId").val();
		$.ajax({
			url:"deleteAdSchedule?scheduleId="+sid+"&adInfoId="+adInfoId+"&number="+i,
			dataType:"json",
			success:function(data){
				var list = eval(data);
				var html = '';
				for(var i=0;i<list.length;i++){
					html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deleteAdschedule('+list[i].id+','+i+');">删除</button></p>';
				}
				$("#showDate").html(html);
			}
		});
	}
	
	function callbackSucc(data)
	{	
		var adimg= data[0];
		var uploadPath = adimg.uploadPath;
		html='';
		if(uploadPath.substring(uploadPath.length-3)=="swf"){
			html+='<a href="www.chetuan.com"><embed src="'+uploadPath+'" width="600" height="100" wmode="transparent" type="application/x-shockwave-flash"></embed></a>'
		}else{
			html+='<img style="height:100px;width="500"" src="'+uploadPath+'"></img>'
		}
		//$("#showPhoto").attr("src",uploadPath);
		$("#showPhoto").html(html);
		$("#adimg").val(uploadPath);
	}
	
</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>