<#import "../common_wapchetuan.ftl" as c />
<@c.html >
		<div class="top-nav">
			<a href="${wap_ct_url}index.html" class="iconfont goback">&#xe600;</a>
			<h2>特卖惠</h2>
		</div>
		<div class="select-bar tml-sel-bar">
			<ul>
				<li>
					<div class="sel-row">
						<label>地区：</label>
						<div class="sel-box" id="selectCity">${cityName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>活动类型：</label>
						<div class="sel-box" id="selectEvent">${activeName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>品牌：</label>
						<div class="sel-box" id="selectBrand">${brandName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>价格选车：</label>
						<div class="sel-box" id="selectPrice">${priceName!}</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-salehui">
			
			<#if count==0>
			<div class="no-data">
				<p>非常抱歉，没有您要的数据...</p>
			</div>
			<#else>
			<ul id="listData">
			</ul>
			<div class="wrap" id="moredata">
				<a href="javascript:listMore();" class="btn-one btn-orange btn-arrow btn-down-arrow">加载更多</a>
			</div>
			</#if>
		</div>
		<!-- 灰色层背景 -->
		<div class="left-mask"></div>
		<!-- 左侧弹出层（地区） -->
		<div id="m-filter-city-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					<dd  <#if cityId == 0>class="current"</#if>><a href="javascript:void(0);" n='不限' d='0'>不限</a></dd>
					<dd  <#if cityId == 12>class='current'</#if>><a href='javascript:void(0);' n='安徽省' d='12'>A 安徽省</a></dd>
					<dd  <#if cityId == 283>class='current'</#if>><a href='javascript:void(0);' n='澳门' d='283'>A    澳门</a></dd>
					<dd  <#if cityId == 1>class='current'</#if>><a href='javascript:void(0);' n='北京市' d='1'>B    北京市</a></dd>
					<dd  <#if cityId == 22>class='current'</#if>><a href='javascript:void(0);' n='重庆市' d='22'>C    重庆市</a></dd>
					<dd  <#if cityId == 13>class='current'</#if>><a href='javascript:void(0);' n='福建省' d='13'>F    福建省</a></dd>
					<dd  <#if cityId == 19>class='current'</#if>><a href='javascript:void(0);' n='广东省' d='19'>G    广东省</a></dd>
					<dd  <#if cityId == 20>class='current'</#if>><a href='javascript:void(0);' n='广西' d='20'>G    广西</a></dd>
					<dd  <#if cityId == 24>class='current'</#if>><a href='javascript:void(0);' n='贵州省' d='24'>G    贵州省</a></dd>
					<dd  <#if cityId == 28>class='current'</#if>><a href='javascript:void(0);' n='甘肃省 ' d='28'>G    甘肃省 </a></dd>
					<dd  <#if cityId == 3>class='current'</#if>><a href='javascript:void(0);' n='河北省' d='3'>H    河北省</a></dd>
					<dd  <#if cityId == 8>class='current'</#if>><a href='javascript:void(0);' n='黑龙江省' d='8'>H    黑龙江省</a></dd>
					<dd  <#if cityId == 16>class='current'</#if>><a href='javascript:void(0);' n='河南省' d='16'>H    河南省</a></dd>
					<dd  <#if cityId == 17>class='current'</#if>><a href='javascript:void(0);' n='湖北省' d='17'>H    湖北省</a></dd>
					<dd  <#if cityId == 18>class='current'</#if>><a href='javascript:void(0);' n='湖南省' d='18'>H    湖南省</a></dd>
					<dd  <#if cityId == 21>class='current'</#if>><a href='javascript:void(0);' n='海南省 ' d='21'>H    海南省 </a></dd>
					<dd  <#if cityId == 7>class='current'</#if>><a href='javascript:void(0);' n='吉林省' d='7'>J    吉林省</a></dd>
					<dd  <#if cityId == 10>class='current'</#if>><a href='javascript:void(0);' n='江苏省' d='10'>J    江苏省</a></dd>
					<dd  <#if cityId == 14>class='current'</#if>><a href='javascript:void(0);' n='江西省' d='14'>J    江西省</a></dd>
					<dd  <#if cityId == 6>class='current'</#if>><a href='javascript:void(0);' n='辽宁省' d='6'>L    辽宁省</a></dd>
					<dd  <#if cityId == 5>class='current'</#if>><a href='javascript:void(0);' n='内蒙古' d='5'>N    内蒙古</a></dd>
					<dd  <#if cityId == 30>class='current'</#if>><a href='javascript:void(0);' n='宁夏' d='30'>N    宁夏</a></dd>
					<dd  <#if cityId == 29>class='current'</#if>><a href='javascript:void(0);' n='青海省' d='29'>Q    青海省</a></dd>
					<dd  <#if cityId == 4>class='current'</#if>><a href='javascript:void(0);' n='山西省' d='4'>S    山西省</a></dd>
					<dd  <#if cityId == 9>class='current'</#if>><a href='javascript:void(0);' n='上海市' d='9'>S    上海市</a></dd>
					<dd  <#if cityId == 15>class='current'</#if>><a href='javascript:void(0);' n='山东省' d='15'>S    山东省</a></dd>
					<dd  <#if cityId == 23>class='current'</#if>><a href='javascript:void(0);' n='四川省' d='23'>S    四川省</a></dd>
					<dd  <#if cityId == 27>class='current'</#if>><a href='javascript:void(0);' n='陕西省 ' d='27'>S    陕西省 </a></dd>
					<dd  <#if cityId == 2>class='current'</#if>><a href='javascript:void(0);' n='天津市' d='2'>T    天津市</a></dd>
					<dd  <#if cityId == 284>class='current'</#if>><a href='javascript:void(0);' n='台湾省' d='284'>T    台湾省</a></dd>
					<dd  <#if cityId == 26>class='current'</#if>><a href='javascript:void(0);' n='西藏' d='26'>X    西藏</a></dd>
					<dd  <#if cityId == 282>class='current'</#if>><a href='javascript:void(0);' n='香港' d='282'>X    香港</a></dd>
					<dd  <#if cityId == 31>class='current'</#if>><a href='javascript:void(0);' n='新疆' d='31'>X    新疆</a></dd>
					<dd  <#if cityId == 25>class='current'</#if>><a href='javascript:void(0);' n='云南省' d='25'>Y    云南省</a></dd>
					<dd  <#if cityId == 11>class='current'</#if>><a href='javascript:void(0);' n='浙江省' d='11'>Z    浙江省</a></dd>
					
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（活动类型） -->
		<div id="m-filter-event-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					<dd <#if activeId == 0>class="current"</#if>><a href="javascript:void(0);" n='不限' d='0'>不限</a></dd>
					<dd <#if activeId == 1>class="current"</#if>><a href="javascript:void(0);" n='降价' d='1'>降价</a></dd>
					<dd <#if activeId == 2>class="current"</#if>><a href="javascript:void(0);" n='置换' d='2'>置换</a></dd>
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（品牌） -->
		<div id="m-filter-brand-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list" id="maintree">
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（价格） -->
		<div id="m-filter-price-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					<dd <#if price_ == 0>class="current"</#if>><a href="javascript:void(0);" n='不限' d='0'>不限</a></dd>
					<dd <#if price_ == 1>class="current"</#if>><a href="javascript:void(0);" n='5万以下' d='1'>5万以下</a></dd>
					<dd <#if price_ == 2>class="current"</#if>><a href="javascript:void(0);" n='5-10万' d='2'>5-10万</a></dd>
					<dd <#if price_ == 3>class="current"</#if>><a href="javascript:void(0);" n='10-15万' d='3'>10-15万</a></dd>
					<dd <#if price_ == 4>class="current"</#if>><a href="javascript:void(0);" n='15-20万' d='4'>15-20万</a></dd>
					<dd <#if price_ == 5>class="current"</#if>><a href="javascript:void(0);" n='20-30万' d='5'>20-30万</a></dd>
					<dd <#if price_ == 6>class="current"</#if>><a href="javascript:void(0);" n='30-40万' d='6'>30-40万</a></dd>
					<dd <#if price_ == 7>class="current"</#if>><a href="javascript:void(0);" n='40-50万' d='7'>50-80万</a></dd>
					<dd <#if price_ == 8>class="current"</#if>><a href="javascript:void(0);" n='50-80万' d='8'>50-80</a></dd>
					<dd <#if price_ == 9>class="current"</#if>><a href="javascript:void(0);" n='80万以上' d='9'>80万以上</a></dd>
				</dl>
			</div>
		</div>
<script>
var cityId=${cityId!};
var	carId=${carId!};
var	activeId=${activeId!};
var	price=${price_!};
var jsData=eval('${jsonData}');
var page = -1;
var size = jsData.length;
var total = (size%3==0)? (size/3):(size/3+1)
listMore();
function resizeHeight(data){
	var docHeight = $(document).height();
	var swipeLeftHeight = $(data).height();

	if(docHeight > swipeLeftHeight) {
		$('.left-mask').height(docHeight);
		$('.left-popup').height(docHeight);
	}else{
		$('.left-mask').height(swipeLeftHeight);
		$('.left-popup').height(swipeLeftHeight);
	}
}
	$('.left-popup').css({
		'display': 'none'
	});
	$('#selectCity').on('click', function(e) {
		e.preventDefault();
		$('#m-filter-city-popup').show();
		$('#m-filter-city-popup .swipe-left').addClass('swipe-left-block');
		$('.left-mask').show();
		t1=".swipe-left";
		resizeHeight(t1);
	});
	$('#selectEvent').on('click', function(e) {
		e.preventDefault();
		$('#m-filter-event-popup').show();
		$('#m-filter-event-popup .swipe-left').addClass('swipe-left-block');
		$('.left-mask').show();
		t1=".swipe-left";
		resizeHeight(t1);
	});
	$('#selectBrand').on('click', function(e) {
		e.preventDefault();
		$('#m-filter-brand-popup').show();
		$('#m-filter-brand-popup .swipe-left').addClass('swipe-left-block');
		$('.left-mask').show();
		var carmain=carbrank[0];
		var mhtml='<dd class="current"><span><a href="javascript:setBrand(\'不限\',\'0\');" class="selectDemo1">不限品牌</a></span></dd>';
//		for(var key in carmain){
//		mhtml=mhtml+"<dt><span>"+key+"</span></dt>";
//		for(var j=0;j<carmain[key].length;j++){
//			var id = carmain[key][j]["id"];
//			var name = carmain[key][j]["name"];
//			mhtml=mhtml+'<dd><a href="javascript:setBrand(\''+name+'\',\''+id+'\');" class="selectDemo1" id="'+carmain[key][j]["id"]+'"'+"><img src='"+carmain[key][j]["icon"]+"' height='40'><span>"+carmain[key][j]["name"]+"</span></a></dd>";
//		}
//		}
	var alist=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
	for(var i=0;i<alist.length;i++){
		for(var key in carmain){
			if(alist[i]==key){
				mhtml=mhtml+"<dt><span>"+key+"</span></dt>";
				for(var j=0;j<carmain[key].length;j++){
					var id = carmain[key][j]["id"];
					var name = carmain[key][j]["name"];
					mhtml=mhtml+'<dd><a href="javascript:setBrand(\''+name+'\',\''+id+'\');" class="selectDemo1" id="'+carmain[key][j]["id"]+'"'+"><img src='"+carmain[key][j]["icon"]+"' height='40'><span>"+carmain[key][j]["name"]+"</span></a></dd>";
					//mhtml=mhtml+"<dd><a href='#' class='selectDemo1' id='"+carmain[key][j]["id"]+"' onclick='seriesTree("+carmain[key][j]["id"]+")'><img src='"+carmain[key][j]["icon"]+"' height='40'><span>"+carmain[key][j]["name"]+"</span></a></dd>";
				}
			}	
		}
	}
	$("#maintree").html(mhtml);
	var t1="#m-filter-brand-popup .swipe-left";
	resizeHeight(t1);
	});
	$('#selectPrice').on('click', function(e) {
		e.preventDefault();
		$('#m-filter-price-popup').show();
		$('#m-filter-price-popup .swipe-left').addClass('swipe-left-block');
		$('.left-mask').show();
		t1=".swipe-left";
		resizeHeight(t1);
	});
	// 关闭
	$('.left-mask').click(function() {
		$(this).hide();
		$('.left-popup').hide();
	});
	$('.close').click(function() {
		$('.left-mask').hide();
		$(this).parents('.left-popup').hide();
	})
	
	$('#m-filter-city-popup .swipe-left .tt-list dd a').click(function() {
		var value = $(this).attr("n");
		cityId = $(this).attr("d");
		$("#selectCity").html(value);
		colseRight();
		gotoUrl()
		
		  
	})
	$('#m-filter-event-popup .swipe-left .tt-list dd a').click(function() {
		var value = $(this).attr("n");
		activeId = $(this).attr("d");
		$("#selectEvent").html(value);
		colseRight();
		gotoUrl()
		 
	})
	$('#m-filter-price-popup .swipe-left .tt-list dd a').click(function() {
		var value = $(this).attr("n");
		price = $(this).attr("d");
		$("#selectPrice").html(value);
		//$(this).parents('dd').addClass('current');
		colseRight();
		  $("#listData").html("");
		gotoUrl()
		
		 
	})
    function setBrand(name,id){
    $("#selectBrand").html(name);
    colseRight();
    carId = id;
    gotoUrl()
    }
    function gotoUrl(){
	    var url = "temaihui/salelist_"+cityId+"_"+activeId+"_"+carId+"_"+price+".html";
	    window.location.href = '${wap_ct_url}'+url;
    }
   
    function listMore(){
    	page++;
    	if(page>total-1){
    		return;
    	}	
    	var index = page*3;
    	var lastIndex = index+3;
    	if(lastIndex>size-1)
    		lastIndex = size;
    	var html = '';
    	for(var i = index;i<lastIndex;i++){
    		var str = jsData[i]["car_info"];
    		html+='<li>';
    		
    		html+='<div class="car-img">';
    		html+='<span class="logo"><img src="'+jsData[i]["photo"]+'" alt="'+jsData[i]["chexi"]+'"></span>';
    		html+='<a href="${wap_ct_url}kanche/series/series_'+jsData[i]["fatherid"]+'.html">'
    		html+='<img src="'+jsData[i]["pic"]+'" alt="'+jsData[i]["chexi"]+'">';
    		html+='</a></div>'
    		html+='<a href="${wap_ct_url}kanche/series/series_'+jsData[i]["fatherid"]+'.html">'
    		html+='<h4 class="car-name">'+jsData[i]["chexi"]+'</h4>';
    		html+='</a>';
    		if(str=="")
    			html+='<div class="car-info">'+jsData[i]["chexing"]+'</div>';
    		else
    			html+='<div class="car-info">'+str+'</div>';
    		html+='<div class="car-num">仅剩:<em>'+jsData[i]["num"]+'</em>台</div>';
    		html+='<div class="btn" onclick= "toApply('+jsData[i]["carid"]+')">立即抢购</div>';
    		html+='</li>';
    	}
    	$("#listData").append(html); 
    	if((page+1)>total-1){
    		$("#moredata").addClass("nomore");
    		$("#moredata").html('<a href="javascript:void(0);" class="btn-one btn-orange btn-arrow btn-down-arrow">已经到底了</a>')
    	}
    }
    function toApply(cid){
    	window.location.href = '${wap_ct_url}kanche/baoming/bm_'+cid+'_tmh.html';
    }
	//关闭
	function colseRight(){
		$('.left-mask').hide();
		$('.left-popup').hide();
		document.body.scrollTop=0;
	}
	</script>
</@c.html>