<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style>
.data-table1 {border-collapse:collapse; margin-left:15px;}
.data-table1 td {padding:5px;}
</style>
<!--查询选项-->
<div class="row">
<form method="POST">
 <table class="data-table1">
 <tr>
  	<td>
  		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
  	</td>
  	
  	<td>
  		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
  	</td>
  	
  	<td>
  		<select class="form-control input-small" name="brandId" id="pinpai">
	     	<option value="-1">选择品牌</option>
	  	 </select>
  	</td>
  	
  	<td>
  		<select class="form-control input-small" name="iway" id="iway">
	     	<option value="">选择渠道</option>
	  	 </select>
  	</td>
  	
  	<td>
  		<select class="form-control  input-small" name="chexiId" id="chexi">
	  		<option value="-1">选择车系</option>
	  	</select>
  	</td>
  	</tr>
  	
  	
  	
  	<tr>
  	
  	<td>
  		<select class="form-control input-small" name="prov" id="prov">
	  		<option value="-1">选择地区</option>
	  	</select>
  	</td>
  	
  	<td>
	     <select class="form-control input-small" name="city" id="city">
		  	<option value="-1">选择城市</option>
		  </select>
  	</td>
  	
  	<td>
  		 <label for="aaa" title="按渠道">
  		 <input id="aaa"  type="radio" value="0" <#if type == 0>checked="true"</#if>  name="type"/>按渠道
  		 </label>
  	</td>
  	
  	<td>
  		 <label for="bbb" title="按车系">
  		 <input id="bbb"  type="radio" value="1" <#if type == 1>checked="true"</#if>  name="type"/>按车系
  		 </label>
  	</td>
  	
  	<td>
  		 <label for="ccc" title="按车系">
  		 <input id="ccc"  type="radio" value="2" <#if type == 2>checked="true"</#if>  name="type"/>按品牌
  		 </label>
  	</td>
  	
  	<td>
  		 <label for="ddd" title="按投诉对象">
  		 <input id="ddd"  type="radio" value="3" <#if type == 3>checked="true"</#if>  name="type"/>按投诉对象
  		 </label>
  	</td>
  	
  	<td>
  		<button class="btn blue " type="button" id="search">查询</button>
  	</td>
  </tr>
 </table>
</form>
</div>
<!--数据展示-->
<div class="row">
	<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;总数统计:<font color="red">${totalCount!}</font></strong>
</div>
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-cogs"></i>投诉信息
		</div>
		<div class="tools">
			<a class="collapse" href="javascript:;">
			</a>
		</div>
	</div>
	<div class="portlet-body">
		<div class="table-scrollable">
			<table class="table table-hover">
			<thead>
			<#if type == 0>
			<tr>
				<th>
					 渠道
				</th>
				<th>
					投诉总数
				</th>
				<th>
					 车系信息
				</th>
			</tr>
			</#if>
			<#if type == 1 || type == 2>
			<tr>
				<th>
					 车系名称
				</th>
				<th>
					投诉总数
				</th>
				<th>
					 品牌投诉
				</th>
			</tr>
			</#if>
			<#if type == 3>
			<tr>
				<th>
					 投诉对象
				</th>
				<th>
					投诉数量
				</th>
			</tr>
			</#if>
			</thead>
			<tbody>
			<#if type == 0>
				<#list tongjiList as tongji>
	              <tr>
	                <td style="text-align:left;">${tongji.iway!}</td>
	                <td style="text-align:left;">${tongji.count!}</td>
	                <td style="text-align:left;">
	                	<#list tongji.info as info>
	                		<span style="text-decoration:underline">${info.chexiname!}(${info.count!})</span>&nbsp;
	                		
	                	</#list>
	                </td>
	                </td>
	              </tr>
	      		</#list>
	      	<#elseif type==1>
	      	<#list tongjiList as tongji>
	      		<tr>
                <td style="text-align:left;">${tongji.chexiname!}</td>
                <td style="text-align:left;">${tongji.count!}</td>
                <td style="text-align:left;"><span style="text-decoration:underline">${tongji.brandmap.brandname!}(${tongji.brandmap.count!})</span></td>
                </td>
              </tr>
	         </#list>  
	         <#elseif type==2>  
	         <#list tongjiList as tongji>
	         	<#list tongji.info as info>
            		<tr>
	                <td style="text-align:left;">${info.serialname!}</td>
	                <td style="text-align:left;">${info.count!}</td>
	                <td style="text-align:left;"><span style="text-decoration:underline">${tongji.brandname!}(${tongji.brandcount!})</span></td>
	                </td>
	              </tr>
            	</#list>	
	         </#list> 
	         <#elseif type==3>  
	         <#list tongjiList as tongji>
            		<tr>
	                <td style="text-align:left;">${tongji.problem!}</td>
	                <td style="text-align:left;">${tongji.count!}</td>
	                </td>
	              </tr>
	         </#list> 
	      	</#if>
			</tbody>
			</table>
		</div>
	</div>
</div>
</div>




</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$.ajax({
		url : 'queryCarInfo?fatherid=0',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==${brandId!})
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#pinpai").append(html);
				
			}
		}
});
$.ajax({
		url : 'queryCarInfo?fatherid=${brandId!}',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==${chexiId!})
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#chexi").append(html);
				
			}
		}
});

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
				$("#prov").append(html);
				
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
				$("#city").append(html);
			}
		}
	});
	
	



$("#prov").change(function(){	
var fatherid = $(this).children('option:selected').val();

	$("#city").empty();
	$("#city").append("<option value='-1'>请选择城市</option>");
	$.ajax({
		url : 'getCityInfo?city='+fatherid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		carBrand = data;
			for(var i =0 ;i<carBrand.length;i++)
			{
				var html ='<option  value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
				$("#city").append(html);
			}
		}
	});

});

$.ajax({
	url : 'queryCarInfoByBrand?brandid='+${brandId!},
	dataType : 'jsonp',
	jsonp:'jsonpcallback',
	success : function(data){
		carBrand = data;
		for(var i =0 ;i<carBrand.length;i++)
		{
			if(carBrand[i].iway == "${iway!}")
				var html ='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].iway+'</option>';
			else
				var html ='<option value='+carBrand[i].iway+'>'+carBrand[i].iway+'</option>';
			$("#iway").append(html);
		}
	}
});
$("#pinpai").change(function(){	
	 var fatherid = $(this).children('option:selected').val();
	$("#iway").empty();
	$("#iway").append("<option value=''>请选择渠道</option>");
	
	$("#chexi").empty();
	$("#chexi").append("<option value='-1'>请选择车系</option>");
	
	$.ajax({
		url : 'queryCarInfoByBrand?brandid='+fatherid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		carBrand = data;
			for(var i =0 ;i<carBrand.length;i++)
			{
				var html ='<option value='+carBrand[i].iway+'>'+carBrand[i].iway+'</option>';
				$("#iway").append(html);
			}
		}
	});

});

$("#iway").change(function(){	
	 var iwayx = $(this).children('option:selected').val();
	$("#chexi").empty();
	$("#chexi").append("<option value='-1'>请选择车系</option>");
	$.ajax({
		url : 'queryCarInfoByIway',
		data :{iway:encodeURI(iwayx)},
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		carBrand = data;
			for(var i =0 ;i<carBrand.length;i++)
			{
				var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
				$("#chexi").append(html);
			}
		}
	});

});

$.ajax({
	url : 'queryCarInfoByIway',
	data :{iway:encodeURI("${iway!}")},
	dataType : 'jsonp',
	jsonp:'jsonpcallback',
	success : function(data){
		carBrand = data;
		for(var i =0 ;i<carBrand.length;i++)
		{
			if(carBrand[i].catalogid == "${chexiId!}")
				var html ='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
			else
				var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
			$("#chexi").append(html);
		}
	}
});


$("#search").on("click", function() {
	$("#page").val(1);
	document.forms[0].action = "tousu_tongji";
	document.forms[0].submit();
});

</script>
</body>
</html>