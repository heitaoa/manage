<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "车型参数对比-车团网" "车团网购车工具提供各种车型参数对比，车团网，汽车电商O2O服务第一品牌。" "参数对比">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<script src="${www_ct_url}js/position_div.js" type="text/javascript"></script>
<script type="text/javascript" >

var carMain = "";
$(document).ready(function(){
		$(document).click(function(){
			$(".select-option").hide();
			$(".select").removeClass("btn-packup");
		})
		
		$.ajax({
    		url : '${www_ct_url}chetuan/getParamMainTree',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carMain = data[0];
    		}
		});
		
		$(".select").find(".select-selected").on("click", function(event) {
		
			if($(this).attr("name") == "mainTree"){
				if($(this).next().is(":hidden")) {
					var html = '<dl>';
					var map = carMain;
					for(var key1 in map){
							for (var i =0 ;i<map[key1].length;i++) {
								html = html + '<dd><b>'+key1+'</b>';
								html = html +  '<a value="'+map[key1][i].catalogid+'">'+map[key1][i].catalogname+'</a>';
								html = html + '</dd>';
							}
					}
					html = html + '</dl>';
					$(this).next().html(html);
					$(this).next().show();
					$(this).parent().addClass("btn-packup");
					$(".select .select-option a").on("click", function() {
						var txt = $(this).text();
						var value = $(this).attr("value");
						$(this).parentsUntil(".select").prev().find("span").text(txt);
						$(this).parentsUntil(".select").prev().find("span").attr("title",value);
						$(".select-option").hide().parent().removeClass("btn-packup");
						$(this).parents("li").next().find(".select").removeClass("select-disabled");
					});
					event.stopPropagation();
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
			
			
			if($(this).attr("name") == "lineTree"){
				if($(this).next().is(":hidden")) {
					var catalogid = ($(this).parents("li").prev().find("span")[0].title);
					if(catalogid==""){return;};
					var clickDiv = $(this);
					$.ajax({
				    		url : '${www_ct_url}chetuan/getParamChildTree',
				    		dataType : 'jsonp',
				    		data:{catalogid:catalogid},
				    		jsonp:'jsonpcallback',
				    		success : function(data){
					    		carline = data;
					    		var html = '<dl>';
								var data = carline;
								for(var i = 0;i<data.length;i++){
									html = html +  '<dd><a value="'+data[i].catalogid+'">'+data[i].catalogname+'</a>';
									html = html + '</dd>';
								}
								html = html + '</dl>';
								clickDiv.next().html(html);
								clickDiv.next().show();
								clickDiv.parent().addClass("btn-packup");
								$(".select .select-option a").on("click", function() {
									var txt = $(this).text();
									var value = $(this).attr("value");
									$(this).parentsUntil(".select").prev().find("span").text(txt);
									$(this).parentsUntil(".select").prev().find("span").attr("title",value);
									$(".select-option").hide().parent().removeClass("btn-packup");
									$(this).parents("li").next().find(".select").removeClass("select-disabled");
								});
								event.stopPropagation();
				    		}
					});
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
			
			if($(this).attr("name") == "typeTree"){
				if($(this).next().is(":hidden")) {
					var catalogid = ($(this).parents("li").prev().find("span")[0].title);
					if(catalogid==""){return;}; 
					var clickDiv = $(this);
					$.ajax({
				    		url : '${www_ct_url}chetuan/getParamChildTree',
				    		dataType : 'jsonp',
				    		data:{catalogid:catalogid},
				    		jsonp:'jsonpcallback',
				    		success : function(data){
					    		carline = data;
					    		var html = '<dl>';
								var data = carline;
								for(var i = 0;i<data.length;i++){
									html = html +  '<dd><a value="'+data[i].catalogid+'">'+data[i].catalogname+'</a>';
									html = html + '</dd>';
								}
								html = html + '</dl>';
								clickDiv.next().html(html);
								clickDiv.next().show();
								clickDiv.parent().addClass("btn-packup");
								$(".select .select-option a").on("click", function() {
									var txt = $(this).text();
									var value = $(this).attr("value");
									var id = $(this).parents(".select").find(".select-selected")[0].id;
									onGetClick(value,id);
									$(this).parentsUntil(".select").prev().find("span").text(txt);
									$(this).parentsUntil(".select").prev().find("span").attr("title",value);
									$(".select-option").hide().parent().removeClass("btn-packup");
								});
								event.stopPropagation();
				    		}
					});
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
		});
		$(".dele-btn").click(function(){
			var title = $(this).attr("title");
			$(this).parents("ul").find(".select")[1].className = "select select-tools select-disabled";
			$(this).parents("ul").find(".select")[2].className = "select select-tools select-disabled";
			$(this).parents("ul").find("span")[0].innerHTML = "请选择品牌";
			$(this).parents("ul").find("span")[1].innerHTML = "请选择系列";
			$(this).parents("ul").find("span")[2].innerHTML = "请选择车型";
			$(this).parents("ul").find("span")[0].title = "";
			$(this).parents("ul").find("span")[1].title = "";
			$(this).parents("ul").find("span")[2].title = "";
			$(this).parents("td").find("img").attr("src","http://www.chetuan.com/images/pic_no_big.png")
			$(this).parents("td").find("p").find("a").attr("href","javascript:void(0);")
			var tableinfo=$(".tableinfo");
			for(var i = 0;i<tableinfo.size();i++){
			var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html("");
				}
			}
		});
		
		$(".right-btn").click(function(){
			var title  = $(this).prev().attr("title");
			var nextid = parseInt(title)+1;
			if($(this).parents("ul").find("span")[2].innerHTML == "请选择车型"){return;}
			var innerHTML0 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].innerHTML;
			var innerHTML1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].innerHTML;
			var innerHTML2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].innerHTML;
			var title0 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].title;
			var title1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].title;
			var title2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].title;
			var className1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[1].className;
			var className2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[2].className;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].innerHTML = $(this).parents("ul").find("span")[0].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].innerHTML = $(this).parents("ul").find("span")[1].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].innerHTML = $(this).parents("ul").find("span")[2].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].title = $(this).parents("ul").find("span")[0].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].title = $(this).parents("ul").find("span")[1].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].title = $(this).parents("ul").find("span")[2].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[1].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[2].className = $(this).parents("ul").find(".select")[2].className;
			$(this).parents("ul").find(".select")[1].className = className1;
			$(this).parents("ul").find(".select")[2].className = className2;
			$(this).parents("ul").find("span")[0].innerHTML = innerHTML0;
			$(this).parents("ul").find("span")[1].innerHTML = innerHTML1;
			$(this).parents("ul").find("span")[2].innerHTML = innerHTML2;
			$(this).parents("ul").find("span")[0].title = title0;
			$(this).parents("ul").find("span")[1].title = title1;
			$(this).parents("ul").find("span")[2].title = title2;
			var src1=$(this).parents(".table-choice").find("img:eq("+title+")").attr("src");
			var src2=$(this).parents(".table-choice").find("img:eq("+nextid+")").attr("src");
			$(this).parents(".table-choice").find("img:eq("+title+")").attr("src",src2);
			$(this).parents(".table-choice").find("img:eq("+nextid+")").attr("src",src1);
			var h1=$(this).parents(".table-choice").find("td:eq("+(title+1)+")").find("p").find("a").attr("href");
			var h2=$(this).parents(".table-choice").find("td:eq("+(nextid+1)+")").find("p").find("a").attr("href");
			$(this).parents(".table-choice").find("td:eq("+(title+1)+")").find("p").find("a").attr("href",h2);
			$(this).parents(".table-choice").find("td:eq("+(nextid+1)+")").find("p").find("a").attr("href",h1);
			var tableinfo=$(".tableinfo");
			for(var i=0;i<tableinfo.size();i++){
				var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					var t1=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html();
					var t2=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+nextid+")").html();
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html(t2);
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+nextid+")").html(t1);
	
				}
			}
			
		});
		
		$(".left-btn").click(function(){
			var title  = $(this).next().attr("title");
			var preid = parseInt(title)-1;
			if($(this).parents("ul").find("span")[2].innerHTML == "请选择车型"){return;}
			var innerHTML0 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].innerHTML;
			var innerHTML1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].innerHTML;
			var innerHTML2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].innerHTML;
			var title0 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].title;
			var title1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].title;
			var title2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].title;
			var className1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[1].className;
			var className2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[2].className;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].innerHTML = $(this).parents("ul").find("span")[0].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].innerHTML = $(this).parents("ul").find("span")[1].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].innerHTML = $(this).parents("ul").find("span")[2].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].title = $(this).parents("ul").find("span")[0].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].title = $(this).parents("ul").find("span")[1].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].title = $(this).parents("ul").find("span")[2].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[1].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[2].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents("ul").find(".select")[1].className = className1;
			$(this).parents("ul").find(".select")[2].className = className2;
			$(this).parents("ul").find("span")[0].innerHTML = innerHTML0;
			$(this).parents("ul").find("span")[1].innerHTML = innerHTML1;
			$(this).parents("ul").find("span")[2].innerHTML = innerHTML2;
			$(this).parents("ul").find("span")[0].title = title0;
			$(this).parents("ul").find("span")[1].title = title1;
			$(this).parents("ul").find("span")[2].title = title2;
			var src1=$(this).parents(".table-choice").find("img:eq("+title+")").attr("src");
			var src2=$(this).parents(".table-choice").find("img:eq("+preid+")").attr("src");
			$(this).parents(".table-choice").find("img:eq("+title+")").attr("src",src2);
			$(this).parents(".table-choice").find("img:eq("+preid+")").attr("src",src1);
			var t1=parseInt(title)+1;
			var t2=parseInt(preid)+1;
			var h1=$(this).parents(".table-choice").find("td:eq("+t1+")").find("p").find("a").attr("href");
			var h2=$(this).parents(".table-choice").find("td:eq("+t2+")").find("p").find("a").attr("href");
			$(this).parents(".table-choice").find("td:eq("+t1+")").find("p").find("a").attr("href",h2);
			$(this).parents(".table-choice").find("td:eq("+t2+")").find("p").find("a").attr("href",h1);
			var tableinfo=$(".tableinfo");
			for(var i=0;i<tableinfo.size();i++){
				var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					var t1=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html();
					var t2=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+preid+")").html();
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html(t2);
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+preid+")").html(t1);
	
				}
			}
		});
		
		
});
function onGetClick(catalogid,setid){
$.ajax({
    		url : '${www_ct_url}chetuan/GetCarParameters',
    		dataType : 'jsonp',
    		data:{catalogid:catalogid},
    		jsonp:'jsonpcallback',
    		success : function(data){
    			var a=data.length;
    			
    			if(data[a-1]=="NULL"){
    			$(".dele-btn:eq("+parseInt(setid)+")").parent().parent().parent().find("img").attr("src","http://www.chetuan.com/images/pic_no_big.png");
    			}else{
    				$(".dele-btn:eq("+parseInt(setid)+")").parent().parent().parent().find("img").attr("src",data[a-1]);
    			}
    			$(".dele-btn:eq("+parseInt(setid)+")").parents("td").find("p").find("a").attr("href","http://tupian.chetuan.com/"+catalogid+"/0/moren.html")
	    		for(var i=0 ;i<data.length-1;i++){
   					if(i<14){
   						$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if( i>=14&&i<27){
   						var a=i-14; 
   						$(".tableinfo:eq(1) tr:eq("+a+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=27&&i<49){
   						var b=i-27;
   						$(".tableinfo:eq(2) tr:eq("+b+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=49&&i<52){
   						var c=i-49;
   						$(".tableinfo:eq(3) tr:eq("+c+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=52&&i<57){
   						var d=i-52;
   						$(".tableinfo:eq(4) tr:eq("+d+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=57&&i<63){
   						var e=i-57;
   						$(".tableinfo:eq(5) tr:eq("+e+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=63&&i<75){
   						var f=i-63;
   						$(".tableinfo:eq(6) tr:eq("+f+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=75&&i<85){
   						var g=i-75;
   						$(".tableinfo:eq(7) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=85&&i<91){
   						var g=i-85;
   						$(".tableinfo:eq(8) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=91&&i<100){
   						var g=i-91;
   						$(".tableinfo:eq(9) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=100&&i<116){
   						var g=i-100;
   						$(".tableinfo:eq(10) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=116&&i<125){
   						var g=i-116;
   						$(".tableinfo:eq(11) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=125&&i<134){
   						var g=i-125;
   						$(".tableinfo:eq(12) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=134&&i<147){
   						var g=i-134;
   						$(".tableinfo:eq(13) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=147&&i<153){
   						var g=i-147;
   						$(".tableinfo:eq(14) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=153&&i<161){
   						var g=i-153;
   						$(".tableinfo:eq(15) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}
   				} 
    		}
		});
}
</script>
<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">购车工具</a>&gt;<a class="active" href="javascript:void(0);">参数对比</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 1/>
			</div>
			<div class="tools-body" id="box">
				<div>
				<div style="height: 268px;">
					<div id="fixed_top" class="select-areas">
					<table class="table-choice">
						<tr>
							<td class="title">
								<div class="tit-con">
									<p class="title-name">对比车型</p>
									<p>拖拽车款图片可调顺序</p>
									<p><label><input type="checkbox" name="" id="" onclick="makerA(this)">标识优势项</label></p>
									<p><label><input type="checkbox" name="" id="" onclick="showA(this)">高亮不同项</label></p>
									<p><label><input type="checkbox" name="" id="" onclick="hideA(this)">隐藏相同项</label></p>
								</div>
								<div class="tips">●标配  ○选配  -无</div>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
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
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "0">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="dele-btn" title = "0" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
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
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "1">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "1" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
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
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "2">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "2" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
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
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:246px;display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "4">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "3" href="javascript:void(0);">删除</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
					</div>
					</div>
					<div class="genre-title" id="params-carinfo">
						<h3>基本信息</h3>
					</div>
					<table class="tableinfo" id="tableinfo1">
						<tr>
							<th class="title">厂家指导价</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"> </td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">厂商</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">级别</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">发动机</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">变速箱</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">长*宽*高(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">车身结构</th>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最高车速(km/h)</th>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">官方0-100km/h加速(s)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">实测0-100km/h加速(s)</th>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">实测100-0km/h制动(m)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">实测油耗(L/100km)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">工信部综合油耗(L/100km)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">整车质保</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
					</table>
					<div class="genre-title" id="params-carbody">
						<h3>车身</h3>
					</div>
					<table class="tableinfo" id="tableinfo2">
						<tr>
							<th class="title">长度(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">宽度(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">高度(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">轴距(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">前轮距(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
					
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">后轮距(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最小离地间隙(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">整备质量(kg)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">车身结构</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">车门数(个)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">座位数(个)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">油箱容积(L)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">行李厢容积(L)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						</table>
					<div class="genre-title" id="params-carengine">
						<h3>发动机</h3>
					</div>
					<table class="tableinfo" id="tableinfo3">
						<tr>
							<th class="title">发动机型号</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">排量(mL)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">进气形式</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">气缸排列形式</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">气缸数(个)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">每缸气门数(个)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">压缩比</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">配气机构</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">缸径(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">行程(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最大马力(Ps)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最大功率(W)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最大功率转速(rpm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最大扭矩(N·m)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">最大扭矩转速(rpm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">发动机特有技术</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr><tr>
							<th class="title">燃料形式</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">燃油标号</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">供油方式</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">缸盖材料</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">缸体材料</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">环保标准</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-transmission">
						<h3>变速箱</h3>
					</div>
					<table class="tableinfo" id="tableinfo4">
						<tr>
							<th class="title">简称</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">挡位个数</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">变速箱类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-bottomzhuan">
						<h3>底盘转向</h3>
					</div>
					<table class="tableinfo" id="tableinfo5">
						<tr>
							<th class="title">驱动方式</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前悬架类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后悬架类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">助力类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车体结构</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-carstop">
						<h3>车轮制动</h3>
					</div>
					<table class="tableinfo" id="tableinfo6">
						<tr>
							<th class="title">前制动器类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后制动器类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">驻车制动类型</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前轮胎规格</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后轮胎规格</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">备胎规格</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-safeconfig">
						<h3>安全装备</h3>
					</div>
					<table class="tableinfo" id="tableinfo7">
						<tr>
							<th class="title">主/副驾驶座安全气囊</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后排侧气囊</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后排头部气囊(气帘)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">膝部气囊</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">胎压监测装置</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">零胎压继续行驶</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">安全带未系提示</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ISOFIX儿童座椅接口</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">发动机电子防盗</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车内中控锁</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">遥控钥匙</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">无钥匙启动系统</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-carcaokong">
						<h3>操控配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo8">
						<tr>
							<th class="title">ABS防抱死</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">制动力分配(EBD/CBC等)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">刹车辅助(EBA/BAS/BA等)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">牵引力控制(ASR/TCS/TRC等)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车身稳定控制(ESC/ESP/DSC等)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">自动驻车/上坡辅助</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">陡坡缓降</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">可变悬架</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">空气悬架</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">可变转向比</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-outerconfig">
						<h3>外部配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo9">
						<tr>
							<th class="title">电动天窗</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">全景天窗</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">运动外观套件</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">铝合金轮圈</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">电动吸合门</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">电动后备厢</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-innerconfig">
						<h3>内部配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo10">
						<tr>
							<th class="title">真皮方向盘</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">方向盘调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">方向盘电动调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">多功能方向盘</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">方向盘换挡</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">定速巡航</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">倒车视频影像</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">行车电脑显示屏</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">HUD抬头数字显示</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-chair">
						<h3>座椅配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo11">
						<tr>
							<th class="title">真皮/仿皮座椅</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">运动风格座椅</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">座椅高低调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">腰部支撑调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">肩部支撑调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">第二排靠背角度调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">第二排座椅移动</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排座椅电动调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">电动座椅记忆</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后座椅加热</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后座椅通风</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后座椅按摩</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排座椅放倒方式</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">第三排座椅</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前/后中央扶手</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排杯架</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-pastime">
						<h3>多媒体配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo12">
						<tr>
							<th class="title">GPS导航系统</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">定位互动服务</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">中控台彩色大屏</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">内置硬盘</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">蓝牙/车载电话</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车载电视</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排液晶屏</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">外接音源接口(AUX/USB/iPod等)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">CD支持MP3/WMA</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-lights">
						<h3>灯光配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo13">
						<tr>
							<th class="title">氙气大灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">LED大灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">日间行车灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">自动头灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">转向头灯(辅助灯)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">前雾灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">大灯高度可调</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">大灯清洗装置</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车内氛围灯</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-doorswindow">
						<h3>玻璃/后视镜</h3>
					</div>
					<table class="tableinfo" id="tableinfo14">
						<tr>
							<th class="title">前/后电动车窗</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车窗防夹手功能</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">防紫外线/隔热玻璃</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后视镜电动调节</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后视镜加热</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">内/外后视镜自动防眩目</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后视镜电动折叠</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后视镜记忆</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后风挡遮阳帘</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排侧遮阳帘</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">遮阳板化妆镜</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">后雨刷</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">感应雨刷</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-air">
						<h3>空调/冰箱</h3>
					</div>
					<table class="tableinfo" id="tableinfo14">
						<tr>
							<th class="title">空调控制方式</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后排独立空调</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">后座出风口</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">温度分区控制</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车内空气调节/花粉过滤</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">车载冰箱</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-drivingassistance">
						<h3>高科技配置</h3>
					</div>
					<table class="tableinfo" id="tableinfo15">
						<tr>
							<th class="title">自动泊车入位</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">并线辅助</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">主动刹车/主动安全系统</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">整体主动转向系统</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">夜视系统</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">中控液晶屏分屏显示</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">自适应巡航</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">全景摄像头</th>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="left_nav" class="left-nav">
			<ul>
				<li class="adv_active"><a href="#params-carinfo" id="carinfo">基本信息</a></li>
				<li><a href="#params-carbody" id="carbody">车身</a></li>
				<li><a href="#params-carengine" id="carengine">发动机</a></li>
				<li><a href="#params-transmission" id="transmission">变速箱</a></li>
				<li><a href="#params-bottomzhuan" id="bottomzhuan">底盘转向</a></li>
				<li><a href="#params-carstop" id="carstop">车轮制动</a></li>
				<li><a href="#params-safeconfig" id="safeconfig">安全装备</a></li>
				<li><a href="#params-carcaokong" id="carcaokong">操控配置</a></li>
				<li><a href="#params-outerconfig" id="outerconfig">外部配置</a></li>
				<li><a href="#params-innerconfig" id="innerconfig">内部配置</a></li>
				<li><a href="#params-chair" id="chair">座椅配置</a></li>
				<li><a href="#params-pastime" id="pastime">多媒体配置</a></li>
				<li><a href="#params-lights" id="lights">灯光配置</a></li>
				<li><a href="#params-doorswindow" id="doorswindow">玻璃/后视镜</a></li>
				<li><a href="#params-air" id="air">空调/冰箱</a></li>
				<li><a href="#params-drivingassistance" id="drivingassistance">高科技配置</a></li>
			</ul>
		</div>
	</div>
	
</@cc.html>
<script type="text/javascript" >
function hideA(e){
//	$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
	var list=$(".tableinfo tr");
	var titleA=$(".table-choice tr td");
	var tlist=new Array();
	var tid=0;
	for(var i=1;i<titleA.length;i++){
		var tit=$(".table-choice tr td:eq("+i+") ul li:eq(2)");
		var ti=tit.find("span")[0].title;
		if(ti.length!=0){
			tlist[tid]=i;
			tid++;
		}	
	}
		
		
	if(e.checked){
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			if(tlist.length>1){
				if(tlist.length==2){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==3){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==4){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[3].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==5){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[3].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[4].innerHTML){
						trStr.hide();
					}
				}
			}
		}
	}else{
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			trStr.show();
		}
	}
	
}

function showA(e){
//	$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
	var list=$(".tableinfo tr");
	var titleA=$(".table-choice tr td");
	var tlist=new Array();
	var tid=0;
	for(var i=1;i<titleA.length;i++){
		var tit=$(".table-choice tr td:eq("+i+") ul li:eq(2)");
		var ti=tit.find("span")[0].title;
		if(ti.length!=0){
			tlist[tid]=i;
			tid++;
		}	
	}
		
		
	if(e.checked){
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			if(tlist.length>1){
				if(tlist.length==2){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==3){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==4){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[3].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==5){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[3].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[4].innerHTML){
						trStr.addClass("highlight");
					}
				}
			}
		}
	}else{
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			trStr.removeClass("highlight");
			
		}
	}
	
}

function makerA(){
	alert("暂未开放！！！");
}
</script>