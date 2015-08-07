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
				<i class="fa fa-globe"></i>广告位显示
			</div>
		</div>
		<div class="portlet-body form">
			<form class="form-horizontal" role="form" action="toAddAdvertisement">
				<div class="form-body">
					<div class="form-group">
						<label class="col-md-4 control-label">定位城市站：</label>
						<div class="col-md-4">
							<select class="form-control" id="selectCity" name="city">
								<option value="0">定位全国站</option>
								<option value="9">定位上海站</option>
								<option value="162">定位南京站</option>
								<option value="259">定位武汉站</option>
								<option value="174">定位苏州站</option>
								<option value="175">定位杭州站</option>
								<option value="163">定位徐州站</option>
								<option value="107">定位大连站</option>
								<option value="384">定位成都站</option>
								<option value="186">定位合肥站</option>
								<option value="259">定位武汉站</option>
								<option value="299">定位广州站</option>
								<option value="308">定位东莞站</option>
								<option value="300">定位深圳站</option>
								<option value="311">定位佛山站</option>
								<option value="106">定位沈阳站</option>
								<option value="240">定位郑州站</option>
								<option value="1">定位北京站</option>
								<option value="285">定位长沙站</option>
							</select>
						</div>
						<button class="btn default" type="submit">添加广告位</button>
					</div>
				</div>
			</form>
			<form class="form-horizontal" role="form">
				<div class="form-body">
					<div class="form-group">
						<label class="col-md-4 control-label">页面URL：</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="adUrl" value="">
						</div>
						<button class="btn default" type="button" onclick="searchAdvertisement();">搜索广告位</button>
					</div>
				</div>
			</form>
		</div>
		<div class="portlet-body">
			<table class="table table-striped table-bordered table-hover" id="sample_3">
			<thead>
			<tr>
				<th style="width:5%">
					 广告ID
				</th>
				<th style="width:15%">
					 广告页面
				</th>
				<th style="width:15%">
					 广告类型
				</th>
				<th style="width:10%">
					 广告位置
				</th>
				<th style="width:20%">
					广告大小
				</th>
				<th style="width:15%">
					 点击率
				</th>
				<th style="width:20%">
					 操作
				</th>
			</tr>
			</thead>
			<tbody id="showAdInfo">
			<#list adMapList as map>
				<tr>
					<td>
						${map.id!}
					</td>
					<td>
						${map.html!}
					</td>
					<td>
						<#if map.adtype == "1">
							通栏(${map.adtype!})
						<#elseif map.adtype == "2">
							左半通栏(${map.adtype!})
						<#elseif map.adtype == "3">
							按钮广告(${map.adtype!})
						<#elseif map.adtype == "4">
							压屏广告(${map.adtype!})
						<#else>
							右半通栏(${map.adtype!})
						</#if>
					</td>
					<td>
						位置${map.adplace!}
					</td>
					<td>
						${map.adwidth!}*${map.adheight!}
					</td>
					<td>
						 获取
					</td>
					<td>
						 <a href="getAdvertisement?adId=${map.id!}">编辑</a>&nbsp;&nbsp;
						 <a href="toUpdateAdvertisement?adId=${map.id!}">修改</a>
					</td>
				</tr>
			</#list>
			</tbody>
			</table>
		</div>
	</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
		$("#goToAddAd").click(function(){
			var city = $("#selectCity").val();
			window.location.href = "toAddAdvertisement?city="+city;
		});
		
		$(document).ready(function(){
			
			var city = '${city}';
			$("#selectCity").val(city);
			
		});
		
		
		$("#selectCity").change(function(){
			searchAdvertisement();
		});
		
		function searchAdvertisement(){
			var city = $("#selectCity").val();
			var adUrl = $("#adUrl").val();
			$.ajax({
				url:'${admin_che_url}adminche/getAdInfoByCity?city='+city+'&adUrl='+adUrl,
				dateType:'json',
				success:function(data){
					var list = eval(data);
					var html = '';
					for(var i=0;i<list.length;i++){
						html+='<tr>';
						html+='<td>';
						html+=''+list[i].id+'';
						html+='</td>';
						html+='<td>';
						html+=''+list[i].html;
						html+='</td>';
						html+='<td>';
						if(list[i].adtype=="1"){
							html+='通栏('+list[i].adtype+")";
						}
						if(list[i].adtype=="2"){
							html+='左半通栏('+list[i].adtype+")";
						}
						if(list[i].adtype=="3"){
							html+='按钮广告('+list[i].adtype+")";
						}
						if(list[i].adtype=="4"){
							html+='压屏广告('+list[i].adtype+")";
						}
						if(list[i].adtype=="5"){
							html+='右半通栏('+list[i].adtype+")";
						}
						html+='</td>';
						html+='<td>';
						html+='位置'+list[i].adplace;
						html+='</td>';
						html+='<td>';
						html+=list[i].adwidth+'*'+list[i].adheight;
						html+='</td>';
						html+='<td>获取</td>';
						html+='<td><a href="getAdvertisement?adId='+list[i].id+'">编辑</a>&nbsp;&nbsp;';
						html+='<a href="toUpdateAdvertisement?adId='+list[i].id+'">修改</a></td>';
						html+='</tr>';
					}
					$("#showAdInfo").html(html);
				}
			});
		}
	
	</script>
</body>
</html>