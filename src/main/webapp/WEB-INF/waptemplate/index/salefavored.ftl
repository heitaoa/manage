<#import "../common_wapchetuan.ftl" as c />
<@c.html >
		<div class="top-nav">
			<a href="${wap_ct_url}index.html" class="iconfont goback">&#xe600;</a>
			<h2>������</h2>
		</div>
		<div class="select-bar tml-sel-bar">
			<ul>
				<li>
					<div class="sel-row">
						<label>������</label>
						<div class="sel-box" id="selectCity">${cityName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>����ͣ�</label>
						<div class="sel-box" id="selectEvent">${activeName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>Ʒ�ƣ�</label>
						<div class="sel-box" id="selectBrand">${brandName!}</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>�۸�ѡ����</label>
						<div class="sel-box" id="selectPrice">${priceName!}</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-salehui">
			
			<#if count==0>
			<div class="no-data">
				<p>�ǳ���Ǹ��û����Ҫ������...</p>
			</div>
			<#else>
			<ul id="listData">
			</ul>
			<div class="wrap" id="moredata">
				<a href="javascript:listMore();" class="btn-one btn-orange btn-arrow btn-down-arrow">���ظ���</a>
			</div>
			</#if>
		</div>
		<!-- ��ɫ�㱳�� -->
		<div class="left-mask"></div>
		<!-- ��൯���㣨������ -->
		<div id="m-filter-city-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">�ر�</a></dt>
					<dd  <#if cityId == 0>class="current"</#if>><a href="javascript:void(0);" n='����' d='0'>����</a></dd>
					<dd  <#if cityId == 12>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='12'>A ����ʡ</a></dd>
					<dd  <#if cityId == 283>class='current'</#if>><a href='javascript:void(0);' n='����' d='283'>A    ����</a></dd>
					<dd  <#if cityId == 1>class='current'</#if>><a href='javascript:void(0);' n='������' d='1'>B    ������</a></dd>
					<dd  <#if cityId == 22>class='current'</#if>><a href='javascript:void(0);' n='������' d='22'>C    ������</a></dd>
					<dd  <#if cityId == 13>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='13'>F    ����ʡ</a></dd>
					<dd  <#if cityId == 19>class='current'</#if>><a href='javascript:void(0);' n='�㶫ʡ' d='19'>G    �㶫ʡ</a></dd>
					<dd  <#if cityId == 20>class='current'</#if>><a href='javascript:void(0);' n='����' d='20'>G    ����</a></dd>
					<dd  <#if cityId == 24>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='24'>G    ����ʡ</a></dd>
					<dd  <#if cityId == 28>class='current'</#if>><a href='javascript:void(0);' n='����ʡ ' d='28'>G    ����ʡ </a></dd>
					<dd  <#if cityId == 3>class='current'</#if>><a href='javascript:void(0);' n='�ӱ�ʡ' d='3'>H    �ӱ�ʡ</a></dd>
					<dd  <#if cityId == 8>class='current'</#if>><a href='javascript:void(0);' n='������ʡ' d='8'>H    ������ʡ</a></dd>
					<dd  <#if cityId == 16>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='16'>H    ����ʡ</a></dd>
					<dd  <#if cityId == 17>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='17'>H    ����ʡ</a></dd>
					<dd  <#if cityId == 18>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='18'>H    ����ʡ</a></dd>
					<dd  <#if cityId == 21>class='current'</#if>><a href='javascript:void(0);' n='����ʡ ' d='21'>H    ����ʡ </a></dd>
					<dd  <#if cityId == 7>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='7'>J    ����ʡ</a></dd>
					<dd  <#if cityId == 10>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='10'>J    ����ʡ</a></dd>
					<dd  <#if cityId == 14>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='14'>J    ����ʡ</a></dd>
					<dd  <#if cityId == 6>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='6'>L    ����ʡ</a></dd>
					<dd  <#if cityId == 5>class='current'</#if>><a href='javascript:void(0);' n='���ɹ�' d='5'>N    ���ɹ�</a></dd>
					<dd  <#if cityId == 30>class='current'</#if>><a href='javascript:void(0);' n='����' d='30'>N    ����</a></dd>
					<dd  <#if cityId == 29>class='current'</#if>><a href='javascript:void(0);' n='�ຣʡ' d='29'>Q    �ຣʡ</a></dd>
					<dd  <#if cityId == 4>class='current'</#if>><a href='javascript:void(0);' n='ɽ��ʡ' d='4'>S    ɽ��ʡ</a></dd>
					<dd  <#if cityId == 9>class='current'</#if>><a href='javascript:void(0);' n='�Ϻ���' d='9'>S    �Ϻ���</a></dd>
					<dd  <#if cityId == 15>class='current'</#if>><a href='javascript:void(0);' n='ɽ��ʡ' d='15'>S    ɽ��ʡ</a></dd>
					<dd  <#if cityId == 23>class='current'</#if>><a href='javascript:void(0);' n='�Ĵ�ʡ' d='23'>S    �Ĵ�ʡ</a></dd>
					<dd  <#if cityId == 27>class='current'</#if>><a href='javascript:void(0);' n='����ʡ ' d='27'>S    ����ʡ </a></dd>
					<dd  <#if cityId == 2>class='current'</#if>><a href='javascript:void(0);' n='�����' d='2'>T    �����</a></dd>
					<dd  <#if cityId == 284>class='current'</#if>><a href='javascript:void(0);' n='̨��ʡ' d='284'>T    ̨��ʡ</a></dd>
					<dd  <#if cityId == 26>class='current'</#if>><a href='javascript:void(0);' n='����' d='26'>X    ����</a></dd>
					<dd  <#if cityId == 282>class='current'</#if>><a href='javascript:void(0);' n='���' d='282'>X    ���</a></dd>
					<dd  <#if cityId == 31>class='current'</#if>><a href='javascript:void(0);' n='�½�' d='31'>X    �½�</a></dd>
					<dd  <#if cityId == 25>class='current'</#if>><a href='javascript:void(0);' n='����ʡ' d='25'>Y    ����ʡ</a></dd>
					<dd  <#if cityId == 11>class='current'</#if>><a href='javascript:void(0);' n='�㽭ʡ' d='11'>Z    �㽭ʡ</a></dd>
					
				</dl>
			</div>
		</div>
		<!-- ��൯���㣨����ͣ� -->
		<div id="m-filter-event-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">�ر�</a></dt>
					<dd <#if activeId == 0>class="current"</#if>><a href="javascript:void(0);" n='����' d='0'>����</a></dd>
					<dd <#if activeId == 1>class="current"</#if>><a href="javascript:void(0);" n='����' d='1'>����</a></dd>
					<dd <#if activeId == 2>class="current"</#if>><a href="javascript:void(0);" n='�û�' d='2'>�û�</a></dd>
				</dl>
			</div>
		</div>
		<!-- ��൯���㣨Ʒ�ƣ� -->
		<div id="m-filter-brand-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list" id="maintree">
				</dl>
			</div>
		</div>
		<!-- ��൯���㣨�۸� -->
		<div id="m-filter-price-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">�ر�</a></dt>
					<dd <#if price_ == 0>class="current"</#if>><a href="javascript:void(0);" n='����' d='0'>����</a></dd>
					<dd <#if price_ == 1>class="current"</#if>><a href="javascript:void(0);" n='5������' d='1'>5������</a></dd>
					<dd <#if price_ == 2>class="current"</#if>><a href="javascript:void(0);" n='5-10��' d='2'>5-10��</a></dd>
					<dd <#if price_ == 3>class="current"</#if>><a href="javascript:void(0);" n='10-15��' d='3'>10-15��</a></dd>
					<dd <#if price_ == 4>class="current"</#if>><a href="javascript:void(0);" n='15-20��' d='4'>15-20��</a></dd>
					<dd <#if price_ == 5>class="current"</#if>><a href="javascript:void(0);" n='20-30��' d='5'>20-30��</a></dd>
					<dd <#if price_ == 6>class="current"</#if>><a href="javascript:void(0);" n='30-40��' d='6'>30-40��</a></dd>
					<dd <#if price_ == 7>class="current"</#if>><a href="javascript:void(0);" n='40-50��' d='7'>50-80��</a></dd>
					<dd <#if price_ == 8>class="current"</#if>><a href="javascript:void(0);" n='50-80��' d='8'>50-80</a></dd>
					<dd <#if price_ == 9>class="current"</#if>><a href="javascript:void(0);" n='80������' d='9'>80������</a></dd>
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
		var mhtml='<dd class="current"><span><a href="javascript:setBrand(\'����\',\'0\');" class="selectDemo1">����Ʒ��</a></span></dd>';
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
	// �ر�
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
    		html+='<div class="car-num">��ʣ:<em>'+jsData[i]["num"]+'</em>̨</div>';
    		html+='<div class="btn" onclick= "toApply('+jsData[i]["carid"]+')">��������</div>';
    		html+='</li>';
    	}
    	$("#listData").append(html); 
    	if((page+1)>total-1){
    		$("#moredata").addClass("nomore");
    		$("#moredata").html('<a href="javascript:void(0);" class="btn-one btn-orange btn-arrow btn-down-arrow">�Ѿ�������</a>')
    	}
    }
    function toApply(cid){
    	window.location.href = '${wap_ct_url}kanche/baoming/bm_'+cid+'_tmh.html';
    }
	//�ر�
	function colseRight(){
		$('.left-mask').hide();
		$('.left-popup').hide();
		document.body.scrollTop=0;
	}
	</script>
</@c.html>