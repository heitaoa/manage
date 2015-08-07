<#import "../common_wapchetuan.ftl" as cc>
<@cc.html >
<script src="${wap_ct_url}js/idangerous.swiper.min.js"></script>
<script src="${wap_ct_url}js/url.js"></script>
<div class="top-nav">
	<a href="./wapimage---${cartype.catalogid}---${type}.html" class="iconfont goback">&#xe600;</a>
	<h2>${cartype.catalogname}</h2>
</div>
<div class="warp-gallery">
	<div class="tags-gallery">
		<ul>
			<li <#if type= "1">class="active" </#if>><a href="./imginside---${cartype.catalogid}---1.html">外观</a></li>
			<li <#if type= "2">class="active" </#if>><a href="./imginside---${cartype.catalogid}---2.html">内饰</a></li>
			<li <#if type= "3">class="active" </#if>><a href="./imginside---${cartype.catalogid}---3.html">中控</a></li>
			<li <#if type= "4">class="active" </#if>><a href="./imginside---${cartype.catalogid}---4.html">改装</a></li>
		</ul>
	</div>
	<div class="m-focus-box m-container-gallery">
		<a href="javascript:void(0);" class="arrow-prev"></a>
		<a href="javascript:void(0);" class="arrow-next"></a>
		<div class="m-container-gallery-box swiper-container" id="m-container-gallery">
			<ul class="swiper-wrapper">
			<#list list as ll>
				<li class="swiper-slide"><img src="<#if ll_index < 2 || (list?size-1 = ll_index)||(list?size-2 = ll_index) >${ll.newpath}</#if>" alt=""></li>
			</#list>
			</ul>
		</div>
	</div>
	
	<div class="pager-type">&lt; <span id="nowpage"><#if btnMap.get(type) = 0 >0<#else>1</#if></span>/<span id="allpage">${btnMap.get(type)}</span> &gt;</div>
	<div class="enquiry-btn"><a href="javascript:void(0);" class="btn-one btn-blue btn-arrow applyprice">询底价</a></div>
</div>
<form method="post">
	<input type="hidden" id="carid" name="applybean.carid" value="${cars.fatherid}">
	<input type="hidden" id="modelid" name="applybean.modelid" value="${cartype.catalogid}">
</form>

<script>
$(function(){
	$(".applyprice").click(function(){
		document.forms[1].action="${wap_ct_url}wapchetuan/applyinit";
		document.forms[1].submit();
	});
});
var imgjson = eval(${jsonlist});
window.onload = function(){
	init("start");	
}

function init(nowid){
	var gallerySwiperfocus = new Swiper('#m-container-gallery', {
		loop: true,
		grabCursor: true,
		paginationClickable: false,
		createPagination: true,
		calculateHeight: true
	});
	window.onorientationchange = function() {
		var activeindex = $("#nowpage").html()
		if(window.orientation == 90 || window.orientation == -90) {
			$('body').addClass('horizontal-gallery');
			$(".swiper-wrapper li:first-child").remove();
			$(".swiper-wrapper li:last-child").remove();
			init(activeindex);
		}else{
			$('body').removeClass('horizontal-gallery');
			$(".swiper-wrapper li:first-child").remove();
			$(".swiper-wrapper li:last-child").remove();
			init(activeindex);
		}
	}
	
	if($('.warp-gallery').length > 0) {
		$('.m-focus-box .arrow-prev').on('click', function(e) {
			e.preventDefault();
			gallerySwiperfocus.swipePrev();
		});
		$('.m-focus-box .arrow-next').on('click', function(e) {
			e.preventDefault();
			gallerySwiperfocus.swipeNext();
		});
	}
	gallerySwiperfocus.addCallback('SlidePrev', function(swiper){
		//alert(gallerySwiperfocus.activeIndex);
	  	prepage();
		nowpageshow();
	}) 
	
	gallerySwiperfocus.addCallback('SlideNext', function(swiper){
	  	nextpage();
		nowpageshow();
	})
	var id = window.url('?num', window.location.href);
	if(nowid != "start"){
		id = parseInt(nowid)-1;
	}
	if(id == null){
		return;
	}
	if(parseInt(id) > 0){
		$(".swiper-slide img:eq("+(parseInt(id)+1)+") ").attr("src",imgjson[(parseInt(id))].newpath);
		$(".swiper-slide img:eq("+(parseInt(id)+2)+") ").attr("src",imgjson[(parseInt(id)+1)].newpath);
		$(".swiper-slide img:eq("+(parseInt(id))+") ").attr("src",imgjson[(parseInt(id)-1)].newpath);
	}
	gallerySwiperfocus.swipeTo(parseInt(id),0);
	$("#nowpage").html(parseInt(id)+1);
	
	function prepage(){
		var allpage = $("#allpage").html();
		var index = gallerySwiperfocus.activeIndex;
		if(index == 0){
			index = parseInt(allpage);
		}
		var src = $(".swiper-slide img:eq("+(index-1)+") ").attr("src")
		if(src == ""){
			$(".swiper-slide img:eq("+(index-1)+") ").attr("src",imgjson[(index-2)].newpath)
		}
	}
	function nextpage(){
		var index = gallerySwiperfocus.activeIndex;
		var allpage = $("#allpage").html();
		if(index < parseInt(allpage)){
			var src = $(".swiper-slide img:eq("+(index+1)+") ").attr("src")
			if(src == ""){
				$(".swiper-slide img:eq("+(index+1)+") ").attr("src",imgjson[index].newpath)
			}
		}
	}
	function nowpageshow(){
		var allpage = $("#allpage").html();
		if(allpage == "0"){
			return;
		}
		if(gallerySwiperfocus.activeIndex == 0){
			$("#nowpage").html(allpage);
		}else if(gallerySwiperfocus.activeIndex == (parseInt(allpage)+1)){
			$("#nowpage").html(1);
		}else{
			$("#nowpage").html(gallerySwiperfocus.activeIndex);
		}
	}


}


</script>
</@cc.html>