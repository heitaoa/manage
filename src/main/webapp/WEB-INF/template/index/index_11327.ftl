<#import "../common_chetuan.ftl" as cc>
<@cc.html 3>

<head>
	<meta charset="gb2312">
	<script type="text/javascript">
	
	var saleFavoredMap;
	var page;
	var totalPage;
	var rows;
	var count;
	var cityId;
	var carId;
	var activeId;
	var price;
	var sortType;
	var searchText;
	var flag=false;
	var area;
	$(document).ready(function() {
	$(document).click(function(){
		$(".select-option").hide();
		$(".select").removeClass("btn-packup");
	})
	$.ajax({
    		url : '${www_ct_url}chetuan/listCity',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		cityMap = data;
    		}
		});
	$.ajax({
    		url : '${chetuan_ct_url}chetuan/setInitCookie',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			area = data[0];
    			//alert(area.fatherid);
    			if(data[0].fatherid == 0)
    				cityId = data[0].catalogid;
    			else
    				cityId = data[0].fatherid;
    			
    			$("#cityId").attr("value",cityId);	
    			$.ajax({
    			url : '${www_ct_url}chetuan/listCity',
    			dataType : 'jsonp',
    			jsonp:'jsonpcallback',
    			success : function(data){
	    		cityMap = data;
	    		//alert(data.length);
	    		for(var i = 0;i<cityMap.length;i++)
    			{
    				//alert(cityMap[i].catalogid);
    				if(cityId==cityMap[i].catalogid)
    				{
    					//alert(cityMap[i].catalogname);
    					$("#area").html(cityMap[i].catalogname);
    					break;
    				}
    			}
    		}
			});
    			$.ajax({
    		url : '${www_ct_url}chetuan/listSaleFavored?page=1&&cityId='+cityId+'&&carId=0&&activeId=0&&price=-1&&sortType=0&&searchText=',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			saleFavoredMap = data[0];
	    		page=data[1];
	    		totalPage=data[2];
	    		rows=data[3];
	    		count=data[4];
	    		searchText="";
	    		show();
    		}});
    		}});
	
	
		
	$(".select-area").find(".select-selected").on("click", function(event) {
		
				if($(this).next().is(":hidden")) {
					var html = '<dl>';
					html = html+'<dd><b></b><a value="0">不限地区</a></dd>';
					var map = cityMap;
					for(var i =0 ;i<map.length;i++){
								html = html + '<dd><b>'+map[i].lname+'</b>';
								html = html +  '<a value="'+map[i].catalogid+'">'+map[i].catalogname+'</a>';
								html = html + '</dd>';
					}
					html = html + '</dl>';
					$(this).next().html(html);
					$(this).next().show();
					$(this).parent().addClass("btn-packup");
					$(".select .select-option a").on("click", function() {
						var txt = $(this).text();
						var value = $(this).attr("value");
						$("#cityId").attr("value",value);
						$(this).parentsUntil(".select-area").prev().find("span").text(txt);
						$(this).parentsUntil(".select-area").prev().find("span").attr("title",value);
						$(".select-option").hide().parent().removeClass("btn-packup");
						$(this).parents("li").next().find(".select-area").removeClass("select-disabled");
						search(1);
					});
					event.stopPropagation();
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
				
		});
		$.ajax({
    		url : '${www_ct_url}chetuan/listCar',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carMap = data;
    		}
		});
		$(".select-brand").find(".select-selected").on("click", function(event) {
		
				if($(this).next().is(":hidden")) {
					var html = '<dl>';
					html = html+'<dd><b></b><a value="0">不限品牌</a></dd>';
					var map = carMap;
					for(var i =0 ;i<map.length;i++){
								html = html + '<dd><b>'+map[i].lname+'</b>';
								html = html +  '<a value="'+map[i].catalogid+'">'+map[i].catalogname+'</a>';
								html = html + '</dd>';
					}
					html = html + '</dl>';
					$(this).next().html(html);
					$(this).next().show();
					$(this).parent().addClass("btn-packup");
					$(".select .select-option a").on("click", function() {
						var txt = $(this).text();
						var value = $(this).attr("value");
						$("#carId").attr("value",value);
						$(this).parentsUntil(".select-brand").prev().find("span").text(txt);
						$(this).parentsUntil(".select-brand").prev().find("span").attr("title",value);
						$(".select-option").hide().parent().removeClass("btn-packup");
						$(this).parents("li").next().find(".select-brand").removeClass("select-disabled");
						search(1);
					});
					event.stopPropagation();
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
				
		});
		$(".select-price").find(".select-selected").on("click", function(event) {
		
				if($(this).next().is(":hidden")) {
					var html = '<dl>';
								html = html + '<dd>';
								html = html +  '<a value="7">不限价格</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="0">5万以下</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="1">5万到10万</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="2">10万到15万</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="3">15万到20万</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="4">20万到25万</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="5">25万到30万</a>';
								html = html + '</dd>';
								
								html = html + '<dd>';
								html = html +  '<a value="6">30万以上</a>';
								html = html + '</dd>';
					html = html + '</dl>';
					$(this).next().html(html);
					$(this).next().show();
					$(this).parent().addClass("btn-packup");
					$(".select .select-option a").on("click", function() {
						var txt = $(this).text();
						var value = $(this).attr("value");
						$("#price").attr("value",value);
						$(this).parentsUntil(".select-price").prev().find("span").text(txt);
						$(this).parentsUntil(".select-price").prev().find("span").attr("title",value);
						$(".select-option").hide().parent().removeClass("btn-packup");
						$(this).parents("li").next().find(".select-price").removeClass("select-disabled");
						search(1);
					});
					event.stopPropagation();
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
				
		});
		
		$(".type-btn a").click(function(){
			$("#activeId").attr("value",$(this).attr("value"));
			$(this).addClass("active").siblings().removeClass("active");
			search(1);
		});
		
		$(".sort-btn a").click(function(){
			$("#sortType").attr("value",$(this).attr("value"));
			$(this).addClass("active").siblings().removeClass("active");
			 search(1);
		});
		$(".search-btn").click(function(){
		search(1);
		});
		$("#showCitys").on("click", function(event){
		showPop(event);
		});
	});
	function search(pages){
		cityId=$("#cityId").attr("value");
		carId=$("#carId").attr("value");
		activeId=$("#activeId").attr("value");
		price=$("#price").attr("value");
		sortType=$("#sortType").attr("value");
		searchText=$("#searchText").val();
					$.ajax({
    		url : '${www_ct_url}chetuan/listSaleFavored',
    		dataType : 'jsonp',
    		data:{page:pages,cityId:cityId,carId:carId,activeId:activeId,price:price,sortType:sortType,searchText:encodeURI(searchText)},
    		jsonp:'jsonpcallback',
    		success : function(data){
    			saleFavoredMap = data[0];
	    		page=data[1];
	    		totalPage=data[2];
	    		rows=data[3];
	    		count=data[4];
	    		show();
    		}});
		
	}
	function show(){
		var html="";
		var map = saleFavoredMap;
		if(map.length==0)
		{
			//html = '<h2><font color="red">没有查询到相关信息!</font></h2>';
			$(".left-sale").find("ul:eq(0)").html("");
			$(".pages").html(html);
			$("#hideDiv").show();
		}
		else
		{
		$("#hideDiv").hide();
		for(var i =0 ;i<map.length;i++){
			html=html
			+'<li class="item">'
			+'<div class="pic-wrapper">'
			+ '<a href="javascript:toGroupbuySeries('+map[i].fatherid+')">'
			+'<div class="pic-inner">'
			+'<img src="'+getImagePath(map[i].pic)+'" alt="'+map[i].title+'">'
			+'<span class="glass"></span>'
			+'<div class="logo"><img width="35px" alt="" src="'+getImagePath(map[i].photo)+'"></div>'
			+'<p class="title">【'+map[i].rootname+'】</p>'
			+'</div>'
			+'</a>'
			+'</div>'
			+'<div class="info">'
			+'<h3><a href="javascript:toGroupbuySeries('+map[i].fatherid+')"><strong>【'+map[i].fatherName+'】</strong>'+map[i].title+'</a></h3>'
			+'<ul>';
			if(map[i].time_info==undefined||map[i].time_info=="")
				html+='<li><span>时间：</span>'+map[i].begdate+'-'+map[i].enddate+'</li>';
			else
				html+='<li><span>时间：</span>'+map[i].time_info+'</li>';
			html+='<li><span>地点：</span>'+map[i].address+'</li>';
			if(map[i].car_info==undefined||map[i].car_info=="")
				html+='<li><span>车型：</span>'+map[i].catalogname+'</li>';
			else
				html+='<li><span>车型：</span>'+map[i].car_info+'</li>';
			html+='<li><span>优惠：</span>'+map[i].info+'</li>'
			+'</ul>'
			+'<div class="sign">'
			+'仅剩<b>'+map[i].surplus_num+'</b>台'
			+'<a onclick="groupbuyApply('+map[i].rootId+','+map[i].carid+','+map[i].surplus_num+')" class="go" href="javascript:void(0)">去抢购</a>'
			+'</div>'
			+'</div>'
			+'</li>';
		}
		var pageHtml="";
		var halfPage=rows/2;
		if(map.length!=0)
		{
		pageHtml='<a href="#" value="1">车团</a>';
		if(page!=1)
		{
			pageHtml+='<a href="#" value="'+(page-1)+'">上一页</a>';
		}
		else
		{
			pageHtml+='<a href="#" value="1">上一页</a>';
		}
		if(totalPage<rows)
		{
			
			for(var i=1;i<=totalPage;i++)
			{
				if(i==page)
					pageHtml+='<a class="current thisPage" href="#" value="'+i+'">'+i+'</a>';
				else
					pageHtml+='<a class="thisPage" href="#" value="'+i+'">'+i+'</a>';
			}
		}
		else
		{
			if(page<halfPage)
			{
				
				for(var i=1;i<=rows;i++)
				{
					if(i==page)
						pageHtml+='<a class="current thisPage" href="#" value="'+i+'">'+i+'</a>';
					else
						pageHtml+='<a class="thisPage" href="#" value="'+i+'">'+i+'</a>';
				}
			}
			else
			{
				
				var begin=page-2;
				var end=page+2;
				if(end<=totalPage)
				{
					
					for(var i=begin;i<=end;i++)
					{
						if(i==page)
							pageHtml+='<a class="current thisPage" href="#" value="'+i+'">'+i+'</a>';
						else
							pageHtml+='<a class="thisPage" href="#" value="'+i+'">'+i+'</a>';
					}
				}
				else
				{
					
					begin = totalPage-5<=1?1:totalPage-5;
					end = totalPage;
					for(var i=begin;i<=end;i++)
					{
						if(i==page)
							pageHtml+='<a class="current thisPage" href="#" value="'+i+'">'+i+'</a>';
						else
							pageHtml+='<a class="thisPage" href="#" value="'+i+'">'+i+'</a>';
					}
				}
			}
		}
		
		var next=(page+1)>totalPage?totalPage:(page+1);
		pageHtml+='<a href="# " value="'+next+'">下一页</a>';
		pageHtml+='<a  href="#" value="'+totalPage+'">末页</a>';
		}
		$(".pages").html(pageHtml);
		$(".left-sale").find("ul:eq(0)").html(html);
		
		
		
		$(".pages").find("a").click(function(){

		page=$(this).attr("value");
		search(page);
		});
		}
		
	}
	
			//
			function toGroupbuySeries(id){
				//document.location.href="${www_ct_url}chetuan/toGroupbuySeries?catalogid="+id;
				//document.location.href="${kan_ct_url}chetuan/"+id+"/toGroupbuySeries.html";
				window.open("${kan_ct_url}chetuan/"+id+"/toGroupbuySeries.html","_blank");
			}
			$(function(){
				
				var $provNode=$("select[name='prov']");
				$provNode.on("change",function(){
					var $cityNode=$("select[name='city']");
					
					var prov=$(this).val();
					
					if(eval(prov)<=0){
						$cityNode.empty();
						var $option=$("<option value='0'>请选择城市</option>");
						$cityNode.append($option);
						return ;
					}
					
					$.ajax({
						url:"${www_ct_url}chetuan/apply_forCity?cid="+prov,
						success:function(data){
							data=data.replace("{","");
							data=data.replace("}","");
							var kns=data.split(",");
							
							$cityNode.empty();
							var $option=$("<option value='0'>请选择城市</option>");
							$cityNode.append($option);
							
							for(var i=0;i<kns.length;i++){
								var kn=kns[i].split("=");
								var k=kn[0];
								var n=kn[1];
								
								var $option=$("<option value='"+k+"'>"+n+"</option>");
								$cityNode.append($option);
							}
						}
					});
				});
				
				$(".submit").click(function(){
					var $talbe=$(this).parent().parent().parent();
					var name=$.trim($talbe.find("input[name='name']").val());
					var phone=$.trim($talbe.find("input[name='phone']").val());
					var sex=$talbe.find("input[type='radio']:checked").val();
					var prov=$talbe.find("select[name='prov']").val();
					var city=$talbe.find("select[name='city']").val();
					var mid=$talbe.find("select[name='mid']").val();
					var cid=$.trim($("input[name='cid']").val());
					var left_num=$.trim($("input[name='left_num']").val());
					
					var ptn=/^请输入.*$/;
					if(ptn.test(name)){
						name="";
					}
					
					if(phone==null||phone==""){
						alert("请输入手机号!");
						return ;
					}else{
						var phone_pattern=/^1[0-9]{10}$/;
						if(!phone_pattern.test(phone)){
							alert("请输入正确的手机号!");
							return ;
						}
					}
					
					if(name==null||name==""){
						alert("请输入姓名!");
						return ;
					}else{
						var name_pattern=/^[A-Za-z ·]{2,20}|([\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*)$/;
						if(!name_pattern.test(name)){
							alert("请输入正确的姓名!");
							return ;
						}
					}
					
					
					if(prov<=0){
						alert("请选择省份！");
						return ;
					}
					
					if(city<=0){
						alert("请选择城市！");
						return ;
					}
					
					if(mid<=0){
						alert("请选择车型");
						return;
					}
					
					$.ajax({
						url:"${www_ct_url}chetuan/apply_forSaleFavored",
						type:'POST',
						dataType : 'jsonp',
						data :{"phone":phone,"name":encodeURI(name),"prov":prov,"city":city,"sex":sex,"cid":cid,"mid":mid,"left_num":left_num},
    					jsonp:'jsonpcallback',
						success:function(data){						
								alert("提交成功！");
								$(".popup-carmodel").hide();
								$(".over-layer").hide();
						}
					});
				});
			});
			function groupbuyApply(brand,model,num){
				$("input[name='cid']").val(brand);
				$("input[name='left_num']").val(num);
				if(($(".go").length > 0) && ($(".over-layer").is(":hidden")) ) {
					$(".over-layer").css("display", "block").animate({"opacity": "0.6"});
					$(".popup-lowprice").css({
						left: ($(window).width() - $(".popup-lowprice").outerWidth())/2,
						top: ($(window).height() - $(".popup-lowprice").outerHeight())/2
					}).show();
					$(".over-layer").click(function() {
						$(".popup-lowprice").hide();
						$(this).css("display", "none").animate({"opacity": "0"});
					});
				}
				var $provNode=$("select[name='prov']");
				$.ajax({
					url:"${www_ct_url}chetuan/apply_forProv",
					success:function(data){
						data=data.replace("{","");
						data=data.replace("}","");
						var kns=data.split(",");
						
						for(var i=0;i<kns.length;i++){
							var kn=kns[i].split("=");
							var k=kn[0];
							var n=kn[1];
							k = k.replace(/(^\s*)|(\s*$)/g, ""); 
							var $option=$("<option value='"+k+"'>"+n+"</option>");
							if(area.fatherid == 0)
							{
								if(k==area.catalogid)
								{
									$option.attr("selected","true");
								}
    						}
    						else
    						{
    							if(k==area.fatherid)
    							{
									$option.attr("selected","true");
								}
    						}
							$provNode.append($option);
						}
					}
				});
				var $cityNode=$("select[name='city']");
				var pro ;
							if(area.fatherid == 0)
							{
								pro = area.catalogid;
									
    						}
    						else
    						{
    							pro = area.fatherid;
    						}
				$.ajax({
						url:"${www_ct_url}chetuan/apply_forCity?cid="+pro,
						success:function(data){
							data=data.replace("{","");
							data=data.replace("}","");
							var kns=data.split(",");
							
							$cityNode.empty();
							var $option=$("<option value='0'>请选择城市</option>");
							$cityNode.append($option);
							
							for(var i=0;i<kns.length;i++){
								var kn=kns[i].split("=");
								var k=kn[0];
								var n=kn[1];
								
								var $option=$("<option value='"+k+"'>"+n+"</option>");
								if(k==area.catalogid)
									$option.attr("selected","true");
								$cityNode.append($option);
							}
						}
					});
				
				$("select[name='mid']").empty();
				$("select[name='mid']").append($("<option value='0'> -- 请选择车型 -- </option>"));
				$.ajax({
					url:"${www_ct_url}chetuan/apply_forSalModel?cid="+brand,
					success:function(data){
						data=data.replace("{","");
						data=data.replace("}","");
						var kns=data.split(",");
						
						var $modelNode=$("select[name='mid']");
						for(var i=0;i<kns.length;i++){
							var kn=kns[i].split("=");
							var k=kn[0];
							var n=kn[1];
							
							var $option=$("<option value='"+k+"'>"+n+"</option>");
							if(k==model){
								$option.attr("selected","true");
							}
							$modelNode.append($option);
						}
					}
				});
		}
		$(function(){
				$("input[name='name']").click(function(){
					var value=$.trim($(this).val());
					if(value=="请输入姓名"){
						$(this).val("");
					}
				});
				
				$("input[name='phone']").click(function(){
					var value=$.trim($(this).val());
					if(value=="请输入手机号"){
						$(this).val("");
					}
				});
				
				
				$("input[name='name']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("请输入姓名");
					}
				});
				
				$("input[name='phone']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("请输入手机号");
					}
				});
			})
	function getImagePath(path){
		if(path.substr(0,3)=="315"){
			path = path.replace(/315/,"http://img.315che.com");
		}
		if(path.substr(0,3)=="ct1"){
			path = path.replace(/ct1/,'${www_ct_url}');
		}
		return path;
	}

	</script>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/unitpngfix.js"></script>
<![endif]-->
</head>
<body>
<input type="hidden" id="cityId" value="0"/>
<input type="hidden" id="carId" value="0"/>
<input type="hidden" id="activeId" value="0"/>
<input type="hidden" id="price" value="-1"/>
<input type="hidden" id="sortType" value="0"/>
<input type="hidden" id="tmh" value="tmh"/>
	<!-- 主内容 start -->
	<div class="content">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a class="active" href="javascript:void(0)">特卖惠</a>
		</ul>
		<div class="borer-top-01">
			<div class="salse-hui">
				<div class="title-bar"><span>特卖惠</span></div>
				<div class="tool-select">
					<div class="line clearfix">
						<div class="select-area">
							<label>当前地区：</label>
							<div style="z-index:60;" class="select select-tools">
								<div class="select-selected" name="mainTree">
									<span id="area">请选择地区</span>
									<i class="icon-select-arrows"></i>
								</div>
								<div style="display:none;" class="select-option">
									<dl>
										<dd>上海</dd>
										<dd>上海</dd>
										<dd>上海</dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
									</dl>
								</div>
							</div>
						</div>
						<div class="activicy-type">
							<label>活动类型：</label>
							<span class="type-btn">
								<a class="active" href="javascript:void(0);" value="0">全部</a>
								<a href="javascript:void(0);" value="1">降价</a>
								<a href="javascript:void(0);" value="2">置换</a>
							</span>
						</div>
						<div class="quick-search">
							<label>快速搜车：</label>
							<span class="search-box"><i class="icon"></i><input id="searchText" class="search-text" type="text" ></span>
							<button class="search-btn">搜索</button>
						</div>
					</div>
					<div class="line clearfix">
						<div class="select-brand">
							<label>当前品牌：</label>
							<div style="z-index:50;" class="select select-tools">
								<div class="select-selected">
									<span>请选择品牌</span>
									<i class="icon-select-arrows"></i>
								</div>
								<div style="display:none;" class="select-option">
									<dl>
										<dd>
											<b>A</b>
											<a href="">阿尔法罗密欧</a>
										</dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
									</dl>
								</div>
							</div>
						</div>
						<div class="select-price">
							<label>价格选车：</label>
							<div style="z-index:50;" class="select select-tools">
								<div class="select-selected">
									<span>请选择价格</span>
									<i class="icon-select-arrows"></i>
								</div>
								<div style="display:none;" class="select-option">
									<dl>
										<dd>5万以下</dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
										<dd></dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="rank-bar clearfix"><h5>排序：</h5>
				<span class="sort-btn">
				<a href="javascript:void(0);" class="active" value="0">按时间</a>
				<a href="javascript:void(0);" value="1">按降序</a>
				</span>
				</div>
				<div class="on-sale clearfix">
					<div class="left-sale">
						<ul>
							
						</ul>
						<div class="pages">
							
						</div>
						
						<div style="text-align: center;display: none;" id ="hideDiv">	
						<h2><font color="red">没有查询到相关信息!</font></h2>
						<font color="red">您可以点击切换城市!</font><a class="" id="showCitys" href="#" >[切换城市]</a>	
						<br>&nbsp;
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="over-layer"></div>
	<div class="popup-carmodel popup-lowprice">
		<h2>报名申请
		<span style="float:right;margin-right:20px;cursor:pointer;">
				<font class="x" color='red'>x</font>
			</span>
			
			<script>
				$(function(){
					$(".x").click(function(){
						$(".popup-lowprice").hide();
						$(".over-layer").css("display", "none").animate({"opacity": "0"});
					});
				});
			</script>
		
		</h2>
		<p class="desc">您好！请输入手机号，立即 <em>参团</em>,赢取好礼</p>
		<form id="price">
		<input type="hidden" name="left_num" value="0">
			<table class="form-table">
				<tr>
					<th><b>*</b>您的手机：</th>
					<td><div><input class="text" name="phone" type="text" value="请输入手机号"></div></td>
				</tr>
				<tr>
					<th><b>*</b>您的姓名：</th>
					<td>
						<input class="text" name="name" type="text" value="请输入姓名">
						<label><input name="sex" type="radio" value="1" checked>先生</label>
						<label><input name="sex" type="radio" value="2">女士</label>
					</td>
				</tr>
				<tr>
					<th><b>*</b>所在地区：</th>
					<td>
						<select name="prov" id="">
							<option value="0">选择省份</option>
						</select>
						<select name="city" id="">
							<option value="0">选择城市</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>意向车型：</th>
					<td>
						<input type="hidden" name="cid"/>
						<select name="mid" id="">
							<option value="0"> -- 请选择车型 -- </option>
						</select>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input class="submit" type="button" value="提交报名"><span>说明：凡参团订车的用户均可获得价值500-5000元不等的礼品。</span></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 主内容 end -->
</body>
</@cc.html>