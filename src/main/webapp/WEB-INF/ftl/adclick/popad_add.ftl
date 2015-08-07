<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
	<h4 class="page-title">
		广告点击管理
	</h4>

	<!-- EDN PAGE HEADER-->
	<div class="col-md-12">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box blue-madison">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>新增点击
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" action="${admin_che_url!}adminche/insertPopad" method="post" id="applyForm">
                           <div class="form-group">
							<label class="col-md-3 control-label">广告标题：</label>
							 <div class="col-md-9">
								<div>
								   <label>
								      <input type="text" name="popad.adtitle" id="adtitle" value="" class="form-control">
								   </label>
								</div>	
							 </div>	
						  </div>
						  <div class="form-group">
								<label class="col-md-3 control-label">总点击：</label>
								<div class="col-md-9">
									<div>
									   <label>
									      <input type="text" name="popad.poptotaltimes" id="poptotaltimes" value="" class="form-control">
									   </label>
									</div>
								</div>
							</div>
					
							<div class="form-group">
								<label class="col-md-3 control-label">广告代码：</label>
								<div class="col-md-9">
									<div>
									   <label>
									      <input type="text" name="popad.adstr" id="adstr" value="" class="form-control">
									   </label>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label">广告页面：</label>
								<div class="col-md-9">
									<div>
									   <label>
									      <input type="text" name="popad.jsstr" id="jsstr" value="" class="form-control">
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
									      <input type="text" name="popad.totalclick" id="totalclick" value="" class="form-control">
									   </label>
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
									 </div>&nbsp;&nbsp;<button type="button" class="btn green" id="saveDate">添加</button>
								</div>
						</div>
							
						<div class="form-group">
							<label class="col-md-3 control-label">排期列表：</label>
							<div class="col-md-9">
								<div id="showDate">
								</div>
							</div>
						</div>
						</div>
							
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn green" onclick="checkForm();">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
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
			url:'addPopSchedule?sdate='+sdate+'&edate='+edate+'&html='+html,
			dataType:'json',
			success:function(data){
				var list = eval(data);
				var html = '';
				if(list.length>0){
					for(var i=0;i<list.length;i++){
						html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deletePopSchedule('+i+');">删除</button></p>';
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
	
	function deletePopSchedule(i){
		$.ajax({
			url:"deletePopSchedule?number="+i,
			dataType:"json",
			success:function(data){
				var list = eval(data);
				var html = '';
				for(var i=0;i<list.length;i++){
					html+='<p><label>'+list[i].sdate+'至'+list[i].edate+'</label>&nbsp;&nbsp;<button type="button" class="btn default" onclick="javascript:deletePopSchedule('+i+');">删除</button></p>';
				}
				$("#showDate").html(html);
			}
		});
	}



</script>

</body>
</html>