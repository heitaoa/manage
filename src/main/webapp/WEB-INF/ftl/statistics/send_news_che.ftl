<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>

<link rel="stylesheet" type="text/css" href="assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>
<@c.html_body>

	<h3 class="page-title">新闻统计</h3>
	
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index.html">首页</a>
			<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻统计</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻推送</a>
			</li>
		</ul>
	</div>
	

<!-- BEGIN PAGE CONTENT-->
<div class="row">
	<div class="col-md-12">
		<div class="portlet">
			<div class="portlet-title">
				<div class="caption">
					<strong>选择一个统计CSV文件，然后上传</strong>
				</div>
			</div>
			<div class="portlet-body">
				 <form id="csv_form" action="./upload" enctype="multipart/form-data" method="post">
		         	文件:<input type="file" name="image"/><input id="csc_submit_btn" type="button" value="上传" />
		        </form>
		        <div id="csv_res">
					请上传csv文件
				</div>
			</div>
			<br><br><br>
			<input type="button" onclick="javascript:sendNewsToChe();" value="推送" class="btn">
			<input type="hidden" value="" id="filename">
		</div>
		<!-- End: life time stats -->
	</div>
</div>
<!-- END PAGE CONTENT-->
</@c.html_body>
<@c.html_js></@c.html_js>
<script src="${admin_che_url}js/jquery.form.js" type="text/javascript"></script>

<!-- 实例化编辑器 -->
<script type="text/javascript">
$(document).ready(function(){
	//上传
	$("#csc_submit_btn").on("click",function(){
		csvSubmit();
	});
})


function csvSubmit(){
	$("#csv_res").html("上传中...请稍等...");
	
	$("#csv_form").ajaxSubmit({ 
		success: succCSVFrom,	
		error: errCSVFrom
	});
}

function succCSVFrom(data){
	$("#filename").val(data);
	$("#csv_res").html(data);
}

function errCSVFrom(data){
	alert("errCSVFrom:"+data);
}

function sendNewsToChe(){
	var filename = $("#filename").val();
	if(filename==""){
		alert("请先上传文件！！！");
		return; 
	}
	$.ajax({
		url:"${admin_che_url!}adminche/sendNews",
		data:{fileName:filename},
		dataType:"json",
		success:function(data){
			var saveresult = data[0].saveresult;
			var updateresult = data[0].updateresult;
			if(saveresult=="true"){
				alert("推送成功！！！");
			}else{
				alert("推送失败，请联系技术！！！");
			}
			if(updateresult=="true"){
				alert("更新成功！！！");
			}else{
				alert("更新失败，请联系技术！！！");
			}
		}
	});
}

</script>

</body>
</html>