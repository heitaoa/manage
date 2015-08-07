<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h3 class="page-title">
				分站管理<small></small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index">首页</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">新闻管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="subject">分站管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="javascript:void(0);">分站列表</a>
					</li>
				</ul>
			</div>
			<!-- EDN PAGE HEADER-->

		<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-madison">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-globe"></i>分站列表
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<button id="sample_editable_1_new" class="btn green" onclick="javascript:window.location.href='subsites/toSave';">
											添加分站<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover" id="sample_1">
							<thead>
							<tr>
								<th style="width:12%;">
									 分站id
								</th>
								<th style="width:25%;">
									 分站名称
								</th> 
								<th style="width:10%;">
									 操作
								</th> 
							</tr>
							</thead>
							<tbody>
								<#list list as item>
									<tr class="odd gradeX">
										<td>
											 ${item.id!}
										</td> 
										<td>
											 ${item.name!}
										</td> 
										<th>
											<#if item.id &lt;=20 >
												不能修改
											<#else>
												<a href="subsites/toSave?id=${item.id!}">修改</a>&nbsp; 
											</#if>
										</th>
									</tr>
								</#list>
							</tbody>
							</table>
							<@c.calcPage1 "/subsites/list" page pageCount></@c.calcPage1>
						</div>
					</div>
				</div>
			<!-- END MAIN CONTENTS -->
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
	//表单提交验证
	function checkForm(){
		var adurl = $.trim($("#adurl").val());
		var adimg = $("#adimg").val();
		var adSchedule = $.trim($("#showDate").html());
		
		if(adurl==""){
			alert("广告链接地址还未输入...");
			return;
		}
		if(adimg==""){
			alert("广告图片还未上传...");
			return;
		}
		if(adSchedule.length==""){
			alert("广告排期还未输入...");
			return;
		}
		alert("添加成功");
		$("#applyForm").submit();
	}
	
	$("#saveDate").click(function(){
		var sdate = $("#sdate").val();
		var edate = $("#edate").val();
		var adInfoId = "";
		var html = $("#showDate").html();
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
			url:'addAdSchedule?sdate='+sdate+'&edate='+edate+'&adInfoId='+adInfoId+'&adId='+adId+'&html='+html,
			dataType:'json',
			success:function(data){
				var list = eval(data);
				var html = '';
				if(list.length>0){
					for(var i=0;i<list.length;i++){
						html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deleteAdschedule('+i+');">删除</button></p>';
					}
					$("#showDate").html(html);
				}else{
					alert("选择的日期出在冲突，请检查后重新输入！！！");
					return;
				}
				
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
	
	function deleteAdschedule(i){
		var adInfoId = "";
		$.ajax({
			url:"deleteAdSchedule?&adInfoId="+adInfoId+"&number="+i,
			dataType:"json",
			success:function(data){
				var list = eval(data);
				var html = '';
				for(var i=0;i<list.length;i++){
					html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deleteAdschedule('+i+');">删除</button></p>';
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
</body>
</html>