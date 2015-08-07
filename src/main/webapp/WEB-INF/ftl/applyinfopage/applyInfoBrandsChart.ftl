<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<form method="post" >
<table>
<tr>
<td><span>报名地区：</span></td>
<td>
<select class="form-control input-small input-sm　" name="prov" id="prov1">
	<option value="-1">选择地区</option>
	</select>
</td>
<td>
	<select class="form-control input-small input-sm　" name="city" id="city1">
	<option value="-1">选择城市</option>
</td>
<td><span>报名开始时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="startTime" value="${startTime!}" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td><span>报名结束时间：</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="endTime" value="${endTime!}" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
</td>
<td>&nbsp;&nbsp;&nbsp;<button class="btn blue" type="button" id="search" onclick="submitdata();">查询</button></td>
</tr>
</table>
</form>
</div>

<div class="row">
<div class="portlet box blue" style="margin-left:15px;margin-top:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>地区品牌统计
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
         	 &nbsp;&nbsp;&nbsp;报名人数:<font color="red" size=4>${count!}</font> 已回访:<font color="red" size=4>${hfcount!}</font> 回访率:<font color="red" size=4>${totalpersent!}</font>
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 渠道
									</th>
									<th>
										 报名人数
									</th>
									<th>
										 回访人数
									</th>
									<th>
										 回访率
									</th>
								</tr>
								</thead>
								<tbody>
								  <#list brandList as brand>
						          <tr>
						          <td>${brand.iway!}</td>
						          <td>${brand.bmcount!}</td>
						          <td>${brand.hfcount!}</td>
						          <td>${brand.hfpercent!}</td>
						          </tr>
						          </#list>
								</tbody>
								</table>
							</div>
						</div>
					</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function(){
var level="${userInfo.ulevel!}";
var cityflag = ${cityflag!};
if(level.indexOf("2")>-1||level.indexOf("3")>-1){
	$("#prov1").prop('disabled',true);
	if(cityflag==1)
		$("#city1").prop('disabled',true);
}
$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${prov!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov1").append(html);
				}
    		}
		});
$.ajax({
    		url : 'getCityInfo?city='+${prov!},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${city!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city1").append(html);
				}
    		}
		});
		$("#prov1").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city1").empty();
		$("#city1").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city1").append(html);
				}
    		}
		});
	
	});
});
function submitdata()
{
	document.forms[0].action = "searchBrandChart";
	document.forms[0].submit();
}
</script>
</body>
</html>