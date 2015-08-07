<#import "../common_wapchetuan.ftl" as cc>
<@cc.html >
<script>
var imgjson = eval(${jsonlist})
$(document).ready(function(){
	$(".imagemore").click(function(){
	
		var imgnum = $(".list-picinfo li").length;
		var imgall = imgjson.length;
		var num = imgall - imgnum;
		if(num > 9){
			num = 9;
		}
		var html = "";
		for(var i = imgnum;i<imgnum+num;i++){
			html = html+'<li><a href="./imginside---${cartype.catalogid}---${type}.html?num='+i+'"><img src="'+imgjson[i].newpath+'" alt=""></a></li>'
		}
		
		$(".list-picinfo ul").append(html)
		if((imgall - imgnum) <= 9 ){
			$(".wrap").hide();
		}
	})
	
	$(".pic-change-car").click(function(){
		$(".left-popup").show();
		$(".swipe-left").addClass("swipe-left-block");
		$(".left-mask").show();
	})
	
	$('.left-popup').css({
		'display': 'none'
	});
	
	$(".left-mask").click(function(){
		$(".left-popup").hide();
		$(".swipe-left").removeClass("swipe-left-block");
		$(".left-mask").hide();
	})
});

</script>
		<div class="top-nav">
			<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
			<h2>${cars.catalogname}</h2>
		</div>
		<div class="tags-first">
			<@cc.wapnav nav = 3 carsid = '${cars.catalogid}'></@cc.wapnav>
		</div>
		<a href="javascript:void(0);" class="pic-change-car">
			<span>按车款</span>
			<strong>${cartype.catalogname}</strong>
		</a>
		<div class="sort sort4 bar-btn gallery-btn">
			<ul>
				<li <#if type= "1">class="active" </#if>><a href="./wapimage---${cartype.catalogid}---1.html"><span>外 观</span><em>${btnMap.get('1')} 张</em></a></li>
				<li <#if type= "2">class="active" </#if>><a href="./wapimage---${cartype.catalogid}---2.html"><span>内 饰</span><em>${btnMap.get('2')} 张</em></a></li>
				<li <#if type= "3">class="active" </#if>><a href="./wapimage---${cartype.catalogid}---3.html"><span>中 控</span><em>${btnMap.get('3')} 张</em></a></li>
				<li <#if type= "4">class="active" </#if>><a href="./wapimage---${cartype.catalogid}---4.html"><span>改 装</span><em>${btnMap.get('4')} 张</em></a></li>
			</ul>
		</div>
		<div class="sort3 list-picinfo">
			<ul>
			<#list list as ll>
			<#if ll_index <9>
				<li><a href="./imginside---${cartype.catalogid}---${type}.html?num=${ll_index}"><img src="${ll.newpath}" alt=""></a></li>
			</#if>
			</#list>
			</ul>
			<#if list.size() gt 9>
			<div class="wrap">
				<a href="javascript:void(0);" class="btn-one btn-orange btn-arrow btn-down-arrow imagemore">加载更多</a>
			</div>
			</#if>
		</div>
		
		<!-- 灰色层背景 -->
		<div class="left-mask"></div>
		<!-- 左侧弹出层 -->
		<div class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					${existImageHtml}
				</dl>
			</div>
		</div>
</@cc.html>