<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style>
ul,li {margin:0; padding:0;}
ul,li {list-style:none;}
.data-table1 {border-collapse:collapse; margin-left:15px;}
.data-table1 td {padding:5px;}
.xwbg1 th {
	color:#fcf1dd;
	font-size:16px;
	height:32px;
	line-height:32px;
	background:#303d4d;
}
.xwbg1 td {
	/*height:40px;*/
	color:#303d4d;
	font-size:14px;
	line-height:40px;
}
.customer_info_table th { background-color: #4b8df8; }
.customer_info_table .list li { border: 1px solid #ccc; border-top: 0; padding: 0; border-bottom: 1px solid #ccc; line-height: 2.2em; }
.customer_info_table .list li.current { background: #A1BBDB; }
.customer_info_table .list .color-odd { background: #d6e2f1; }
.callback_num { width: 100%; border-top: 2px solid #ff7f66; }
.callback_num strong { color: red; }
.customer_info_table .list li a {padding-left:5px;}
.customer_info_table .list li a:hover {text-decoration:none;}
</style>
<!--查询选项-->
<div class="row">
<form method="post">
<input id="page" name="page" type="hidden" value="${page!"1"}" />
<table class="data-table1">
<tr>
<td><span>报名渠道：</span></td>
<td>
	   <select class="form-control input-medium input-sm　" name="typex" id="typex">
	      <option value="-1">所有报名</option>
		  <option value="0">车团-团购</option>
		  <option value="3">车团-特卖惠</option>
		  <option value="1">车团-询最低价</option>
		  <option value="2">车团-预约试驾</option>
		  <option value="9">合作媒体</option>
		  <option value="11">专题页报名</option>
		  <option value="4">tuan.315che.com-PC(百度)</option>
		  <option value="5">tuan.315che.com-手机(百度)</option>
		  <option value="6">315che-PC</option>
		  <option value="8">315che-手机</option>
		  <option value="7">suncars-PC</option>
		  <option value="10">suncars-手机</option>
		  <option value="12">优数</option>
		  <option value="13">合作网站</option>
		  <option value="14">合作媒体测试</option>
		  <option value="15">车团-特卖惠-手机</option>
		  <option value="16">车团-团购-手机</option>
		  <option value="17">车团-询最低价-手机</option>
		</select>
	   </td>
	   <td><span><font color="red">同步时间:</font></span></td>
	   <td><font color="red">${last_update_time!}</font></td>
	   <td></td>
	   <td></td>
</tr>
<tr>
	<td><span>报名时间：</span></td>
	<td colspan=5>
	<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>&nbsp;&nbsp;至&nbsp;&nbsp;
		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
	</td>
</tr>
<tr>
	<td><span>回访时间：</span></td>
	<td colspan=5>
	<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginOrderDate" value="${beginOrderDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>&nbsp;&nbsp;至&nbsp;&nbsp;
		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endOrderDate" value="${endOrderDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
	</td>
	<td></td>
	<td>
	</td>
</tr>
<tr>
<td><span>是否回访：</span></td>
<td>
	   <select class="form-control input-medium input-sm　" name="visit_type" id="visit_type">
	       <option value="-1">全部</option>
           <option value="0">未回访</option>
           <option value="1">已回访</option>
		</select>
	   </td>
	   <td><span>回访人：</span></td>
	<td>
	<select class="form-control input-medium input-sm　" value="${rvman!}" id="revman" name="rvman">
	       <option value="-1">所有(含未回访)</option>
		</select>
	</td>
	 <td><span>是否购车：</span></td>
	  <td>
	  <select class="form-control input-medium input-sm　" name="type" id="type">
	       <option value="-1">全部</option>
          <option value="0">未购车</option>
          <option value="1">已购车</option>
		</select>
	  </td>
</tr>


<tr>
	<td><span>品牌：</span></td>
	<td>
	<select class="form-control input-medium input-sm　" name="barndName" id="pinpai">
	</select>
	<select class="form-control input-medium input-sm　" name="chexiId" id="chexi">
	<option value="-1">选择车系</option>
	</select>
	</td>
	<td><span>地区：</span></td>
	<td>
	<select class="form-control input-medium input-sm　" name="prov" id="prov1">
	<option value="-1">选择地区</option>
	</select>
	<select class="form-control input-medium input-sm　" name="city" id="city1">
	<option value="-1">选择城市</option>
	</select>
	</td>
	<td><span>购车紧急度：</span></td>
	<td>
	<select class="form-control input-medium input-sm　" id="cus_intentionx" name = "cus_intention">
		<option value="-1">全部</option>
	    <option value="1">非常紧急，越快越好</option>
	    <option value="2">本周有时间参加</option>
	    <option value="3">下周有时间参加</option>
	    <option value="4">要买，但不太确定时间</option>
	    <option value="5">不需要购买了</option>
	    <option value="6">未接通，需再次电话</option>
	    <option value="7">其他情况</option>
	</select>
	</td>
</tr>
<tr>
	<td><span>客户姓名：</span></td>
	<td>
	<input type="text"  class="form-control input-inline input-medium " name="name"  value="${name!}">
	</td>
	<td><span>手机号码：</span></td>
	<td>
	<input type="text"  class="form-control input-inline input-medium" name="phone" value="${phone!}">
	</td>
	<td><span>客户类型：</span></td>
	<td>
	<select class="form-control input-medium input-sm　" name="is_key_cus" id="key_cus">
	        <option value="-1">全部</option>
            <option value="0">普通客户</option>
            <option value="1">重点客户</option>
		</select>
	</td>
</tr>

<tr>
<td colspan=6 style="text-align:center;">
<button class="btn blue" type="button" id="search">查询</button>&nbsp;
<button class="btn blue" type="button" id="down">导出</button>
</td>
</tr>
</table>
</form>
</div>
<div class="row">
	<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;人数统计:<font color="red">${count!}</font></strong>
</div>
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>报名信息
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
								<tr>
									<th>
										 姓名
									</th>
									<th>
										 报名时间
									</th>
									<th>
										 手机
									</th>
									<th>
										品牌
									</th>
									<th>
										 车系
									</th>
									<th>
										回访记录
									</th>
									<th>
										 来源
									</th>
								</tr>
								</thead>
								<tbody>
								<#list applyInfo as applyInfo>
		                          <tr>
		                            <td style="text-align:left;">${applyInfo["name"]!}</td>
		                            <td style="text-align:left;">${applyInfo["appdate"]!}</td>
		                            <td style="text-align:left;">${applyInfo["phone"]!}</td>
		                            <td style="text-align:left;">${applyInfo["pingpai"]!}</td>
		                            <td style="text-align:left;">${applyInfo["chexi"]!}</td>
		                            <td style="text-align:left;">${applyInfo["remarks"]!}</td>
		                            <td style="text-align:left;">${applyInfo["type"]!}</td>
		                          </tr>
                          		</#list>
								<tr>
		                          <td colspan=7 style="text-align:center;"><@c.calcPageByJs "toPage", page, pages/></td>
		                         </tr>
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
var typex = document.getElementById("typex");
for(var i=0;i<typex.options.length;i++) {  
            if(typex.options[i].value == ${typex!}) {  
                typex.options[i].selected = true;  
                break;  
            } }

var type = document.getElementById("type");
for(var i=0;i<type.options.length;i++) {  
            if(type.options[i].value == ${type!}) {  
                type.options[i].selected = true;  
                break;  
            } }
var visit_type = document.getElementById("visit_type");
for(var i=0;i<visit_type.options.length;i++) {  
            if(visit_type.options[i].value == ${visit_type!}) {  
                visit_type.options[i].selected = true;  
                break;  
            } }
var key_cus = document.getElementById("key_cus");
for(var i=0;i<key_cus.options.length;i++) {  
            if(key_cus.options[i].value == ${is_key_cus!}) {  
                key_cus.options[i].selected = true;  
                break;  
            } }    
var cus_intentionx = document.getElementById("cus_intentionx");
for(var i=0;i<cus_intentionx.options.length;i++) {  
            if(cus_intentionx.options[i].value == ${cus_intention!}) {  
                cus_intentionx.options[i].selected = true;  
                break;  
            } }

var brandFlag = "${brandFlag!}"
if(brandFlag=="0")
{
	$("#pinpai").append(' <option value="-1">选择品牌</option>');
}
else
{
	$("#pinpai").append(' <option value="-2">选择品牌</option>');
}

$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
    			
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
					if(carBrand[i].iway=="${barndName!}")
						html='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
					//$("#pinpai3").append(html);
				}
    		}
		});
$.ajax({
    		url : 'getRevman',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
    			//alert(data);
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					var rv = '${rvman!}';
					if(carBrand[i].return_visit_man==rv)
						html='<option selected="true" value="'+carBrand[i].return_visit_man+'">'+carBrand[i].return_visit_man+'</option>';
					else
						html='<option  value="'+carBrand[i].return_visit_man+'">'+carBrand[i].return_visit_man+'</option>';
					$("#revman").append(html);
				}
    		}
});

$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI("${barndName!}")},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==${chexiId!})
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexi").append(html);
				}
    		}
		});
$("#pinpai").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#chexi").empty();
		$("#chexi").append("<option value='-1'>请选择系列</option>");
		$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
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
$("#search").on("click", function() {
	$("#page").val(1);
	document.forms[0].action = "groupBuyApply";
	document.forms[0].submit();
});
$("#down").on("click", function() {
	//$("#page").val(1);
	document.forms[0].action = "downBaoming";
	document.forms[0].submit();
});
});
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms[0].action = "groupBuyApply";
	document.forms[0].submit();
}
</script>
</body>
</html>