<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h4 class="page-title">
		点击管理
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
					<form class="form-horizontal" role="form" action="${admin_che_url!}adminche/updatePopad" method="post" id="applyForm">
						<input type="hidden" name="popad.id" id="id" value="${popad.id!}" class="form-control">
						<div class="form-group">
							<label class="col-md-3 control-label">广告标题：</label>
							<div class="col-md-9">
								<div>
								   <label>
								      <input type="text" name="popad.adtitle" id="adtitle" value="${popad.adtitle}" class="form-control">
								   </label>
								</div>	
							</div>	
						</div>
						<div class="form-group">
								<label class="col-md-3 control-label">总点击：</label>
								<div class="col-md-9">
								<div>
								   <label>
								      <input type="text" name="popad.poptotaltimes" id="poptotaltimes" value="${popad.poptotaltimes}" class="form-control">
								   </label>
								</div>
							</div>
						</div>
							<div class="form-group">
								<label class="col-md-3 control-label">广告代码：</label>
								<div class="col-md-9">
									<div>
									   <label>
									      <input type="text" name="popad.adstr" id="adstr" value="${popad.adstr}" class="form-control">
									   </label>
									</div>
								</div>
							</div>		
							<div class="form-group">
								<label class="col-md-3 control-label">广告页面：</label>
								<div class="col-md-9">
									<div>
									   <label>
									      <input type="text" name="popad.jsstr" id="jsstr" value="${popad.jsstr}" class="form-control">
									   </label>
									</div>	
								</div>	
							</div>
							<!-- <div class="form-group">
								<label class="col-md-3 control-label">时间：</label>
								<div class="col-md-9">
						          <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d" style="float:left;">
										<input type="text" class="form-control" readonly id="scheduledday" name="popad.scheduledday">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-3 control-label">点击倍数：</label>
								<div class="col-md-9">
								    <div>
									   <label>
									      <input type="text" name="popad.totalclick" id="totalclick" value="${popad.totalclick}" class="form-control">
									   </label>
									</div>	
								</div>	
							</div>
							
						   <div class="form-group">
								<label class="col-md-3 control-label">广告排期时间：</label>
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
										<#list schedulelist as data>
											<p><label>${data.sdate?string("yyyy-MM-dd")}至${data.edate?string("yyyy-MM-dd")}</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deletePopScheduleById(${data.id!});">删除</button></p>
										</#list>
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
     var poptotaltimes = $("#poptotaltimes").val();
     var adstr = $("#adstr").val();
     var jsstr = $("#jsstr").val();
     var totalclick = $("#totalclick").val();
     var adtitle = $("#adtitle").val();
     if(poptotaltimes==''){
       alert("请输入总曝光 ! ! !");
       return;
     }
     if(adstr==''){
       alert("请输入广告链接 ! ! !");
       return;
     }
     if(jsstr==''){
       alert("请输入广告页面 ! ! !");     
       return;
     }
     if(totalclick==''){
       alert("请输入点击 ! ! !");
       return;
     }
     if(adtitle==''){
       alert("请输入标题 ! ! !");
       return;
     }
     $("#applyForm").submit(); 
}

$("#saveDate").click(function(){
		var sdate = $("#sdate").val();
		var edate = $("#edate").val();
		var html = $("#showDate").html();
		var popadid = ${popad.id!};
		
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
			url:'addPopScheduleById?sdate='+sdate+'&edate='+edate+'&popadid='+popadid,
			dataType:'json',
			success:function(data){
				var list = data;
				var html = '';
				if(list.length>0){
					for(var i=0;i<list.length;i++){
						html+='<p><label>'+formatDate(list[i].sdate)+'至'+formatDate(list[i].edate)+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deletePopScheduleById('+list[i].id+');">删除</button></p>';
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
	
	function deletePopScheduleById(scheduleid){
		var popadid = ${popad.id!};
		$.ajax({
			url:"deletePopScheduleById?scheduleid="+scheduleid+"&popadid="+popadid,
			dataType:"json",
			success:function(data){
				var list = eval(data);
				var html = '';
				for(var i=0;i<list.length;i++){
					html+='<p><label>'+formatDate(list[i].sdate)+'至'+formatDate(list[i].edate)+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deletePopScheduleById('+list[i].id+');">删除</button></p>';
				}
				$("#showDate").html(html);
			}
		});
	}
	
	function formatDate(date){
		var month = '';
		var day = '';
		if(date.month<9){
			month+="0"+(date.month+1);
		}else{
			month = date.month;
		}
		if(date.date<10){
			day = "0"+date.date;
		}else{
			day = date.date;
		}
		var dataStr = (date.year+1900)+"-"+month+"-"+day;
		return dataStr;
	}

</script>

</body>
</html>