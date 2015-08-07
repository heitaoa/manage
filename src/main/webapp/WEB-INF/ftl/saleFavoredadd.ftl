<#import "common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<style>
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

<div class="row" style="margin-left:15px;">

<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>新增团购/特卖惠信息(${stationName!})
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form class="form-horizontal" method="post">
							<table style="margin-left:15px;" class="xwbg1 customer_info_table">
							
							<tr>
							<td><span>活动种别:</span></td>
							<td colspan=3>
							<select class="form-control input-medium input-sm　" name="carGroupbuy.buy_type">
							<option value="0">团购大全</option>
                          <option value="1">特卖惠</option>
							</select>
							</td>
							</tr>
							
							<tr>
							<td><span>是否向前台展示:</span></td>
							<td colspan=3>
							<select class="form-control input-medium input-sm　" name="carGroupbuy.isdelete" id="isdelete">
								<option value="0">向前台展示</option>
                          <option value="1">不向前台展示</option>
							</select>
							</td>
							</tr>
							
							<tr>
							<td><span>车型和车系:</span></td>
							<td>
							<select class="form-control input-medium input-sm　" name="pinpai" id="pinpai">
								 <option value="-1">请选择品牌</option>
							</select>
							</td>
							<td>
								<select class="form-control input-medium input-sm　" name="carGroupbuy.fatherid" id="xilie">
  									<option value="-1">请选择车系</option>
                        		</select>
							</td>
							<td>
								<select class="form-control input-medium input-sm　" name="carGroupbuy.carid" id="kuanshi">
  									 <option value="-1">请选择车型</option>
                        		</select>
							</td>
							</tr>
							
							<tr>
							<td><span>车系信息描述:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.car_info" value="" id="car_info"> <em>有则直接显示</em>
							<input type="hidden" value="123" name = "carGroupbuy.deaid"  id="deaid">
          					<input type="hidden" value="${stationId!}" name = "carGroupbuy.sites_id"  id="stationId">  
							</td>
							</tr>
							
							<tr>
							<td><span>标题:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.title" id="title"> 
							</td>
							</tr>
							
							<tr>
							<td><span>开始时间:</span></td>
							<td colspan=3>
							<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
								<input type="text"  class="form-control input-medium input-inline" name="carGroupbuy.begdate" readOnly="true" id="begdate">
								<span class="input-group-btn input-inline">
								<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
								</span>
							</div>
							</td>
							</tr>
							
							<tr>
							<td><span>结束时间:</span></td>
							<td colspan=3>
							<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
								<input type="text"  class="form-control input-medium input-inline" name="carGroupbuy.enddate" readOnly="true" id="enddate">
								<span class="input-group-btn input-inline">
								<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
								</span>
							</div>
							</td>
							</tr>
							
							<tr>
							<td><span>时间描述信息:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.time_info" value="" id="time_info"> <em>有则直接显示</em>
							</td>
							</tr>
							
							<tr>
							<td><span>地址信息:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.address" id="address">
							</td>
							</tr>
							
							<tr>
							<td><span>附加信息:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.info" id="info">
							</td>
							</tr>
							
							<tr>
							<td><span>报名人数:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.register_num" id="num">
							</td>
							</tr>
							
							<tr>
							<td><span>剩余台数:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.surplus_num" id="surplus_num">
							</td>
							</tr>
							
							<tr>
							<td><span>售价:</span></td>
							<td colspan=3>
							<input type="text" class="form-control input-inline input-medium" name="carGroupbuy.price" id="price"><em>单位:万</em>
							</td>
							</tr>
							
							<tr>
							<td><span>活动类型:</span></td>
							<td colspan=3>
							<select class="form-control input-small input-sm　" name="carGroupbuy.active_type">
								<option value="1">降价</option>
                          		<option value="2">置换</option>
							</select>
							</td>
							</tr>
							
							<tr>
							<td><span>页面图片:</span></td>
							<td colspan=3>
							<img src="" id="img"><br>
							<input type="text" class="form-control input-inline input-medium"  name="carGroupbuy.pic"  readOnly="true" id="pic">
          					<a class="btn blue" href="#imgUploadModal" data-toggle="modal">上传图片</a>
							</td>
							</tr>
							
							<tr>
							<td colspan=4 style="text-align:center;">
							<button class="btn blue" type="button"  id="add"><i class="fa fa-check"></i>提交</button>
							
							</td>
							</tr>
							
							</table>
							</form>
						</div>
					</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function() {
$.ajax({
    		url : 'getCarBrand',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
				}
    		}
		});
$("#pinpai").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	if(fatherid!=-1)
	{
		$("#xilie").empty();
		$("#xilie").append("<option value='-1'>请选择系列</option>");
		$("#kuanshi").empty();
		$("#kuanshi").append("<option value='-1'>请选择系列</option>")
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
					$("#xilie").append(html);
				}
    		}
		});
	}
	});
	$("#xilie").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	if(fatherid>0)
	{
		$("#kuanshi").empty();
		$("#kuanshi").append("<option value='-1'>请选择系列</option>")
		$.ajax({
    		url : 'getCars2x?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#kuanshi").append(html);
				}
    		}
		});
	}
	})
	$("#add").click(function(){
	if($("#pinpai").val()=="-1")
	{
		alert("请选择品牌!");
		return;
	}
	if($("#xilie").val()=="-1")
	{
		alert("请选择系列!");
		return;
	}
	if($("#kuanshi").val()=="-1")
	{
		alert("请选择车型!");
		return;
	}
	if($.trim($("#title").val())=="")
	{
		alert("请输入标题!");
		return;
	}
	var time_info = $("#time_info").val();
	if($.trim($("#begdate").val())==""&&time_info=="")
	{
		alert("请输入开始时间!");
		return;
	}
	if($.trim($("#enddate").val())==""&&time_info=="")
	{
		alert("请输入结束时间!");
		return;
	}
	var startTime=$("#begdate").val();  
    var start=new Date(startTime.replace("-", "/").replace("-", "/"));  
    var endTime=$("#enddate").val();  
    var end=new Date(endTime.replace("-", "/").replace("-", "/"));  
    if(end<start&&time_info==""){  
        alert("结束时间不能小于开始时间!");
		return; 
    } 
	if($.trim($("#address").val())=="")
	{
		alert("请输入地址信息!");
		return;
	}
	if($.trim($("#info").val())=="")
	{
		alert("请输入附加信息!");
		return;
	}
	var regNum= /^[1-9]+[0-9]*]*$/;
	if(!regNum.test($("#num").val()))
	{
		if($("#num").val()!="0")
		{
		alert("请输入正确报名人数!");
		return;
		}
	}
	if(!regNum.test($("#surplus_num").val()))
	{
		if($("#surplus_num").val()!="0")
		{
		alert("请输入正确的剩余台数!");
		return;
		}
	}
	var regPrice= /^(?!0+(\.0+)?$)\d+(\.\d+)?$/;
     if (!regPrice.test($("#price").val()))
	 {  
       alert("请输入正确的售价!"); 
       return;
     }	
	
	if($.trim($("#pic").val())=="")
	{
		alert("请选择页面图片!");
		return;
	}
	document.forms[0].action = "saveSaleFavored";
	document.forms[0].submit();
	});
	$("#open").click(function(){
			$("#viewbg").css({display:"block",height:$(document).height()});
			var yscroll = document.documentElement.scrollTop;
			$("#login_container").css("top","150px");
			$("#login_container").css("display","block");
			document.documentElement.scrollTop = 0;
	});
	$(".close").click(function(){
			$("#viewbg").css("display","none");
			$("#login_container").css("display","none");
		});
		$("#search").click(function(){
			search(1);
		});
});

function callbackSucc(data)
{
	$("#img").attr("src",data[0].uploadPath);
	$("#pic").attr("value",data[0].imgPath);
}
</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>