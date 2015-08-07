<#import "../common_wapchetuan.ftl" as c />

<@c.html >
<script src="${wap_ct_url}js/CarCalculator.js"></script>
<script>
	$('.left-popup').css({
		'display': 'none'
	});
</script>
<div class="top-nav">
	<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
	<h2>购车工具</h2>
</div>
<div class="tools-nav">
	<div class="sort sort3 bar-btn">
		<ul>
			<li><a href="${wap_ct_url}gongju/gouchejisuanqi.html">购车计算</a></li>
			<li><a href="${wap_ct_url}gongju/chedaijisuanqi.html">贷款购车</a></li>
			<li class="active"><a href="${wap_ct_url}gongju/chexianjisuanqi.html">保险计算</a></li>
		</ul>
	</div>
</div>
<div class="tools-con">
	<div class="tools-car-tt"><span>请选择车型或者直接输入裸车价</span></div>
	<div class="tools-car-con">
		<div class="tools-select" id="selectCarType">车型</div>
		<div>裸车售价（元）<input id="show_money" type="number" maxlength="2" type="text" class="car-price-input"  value=""   onchange="calcInsuranceAll();"></div>
	</div>
</div>


<ul class="m-calculator-list">
	<li class="list-head borderbn"><span class="w120">保险指导价：</span> <b id="show_company">0元</b> </li>
	<li class="list-head bordert1"><span class="w120">市场报价：</span> <b class="cRed" id="show_market">0元</b> </li>
	<li><span>交强险：</span> <b id="show_jiaoqiang">0元</b> <strong><a id="even_jiaoqiang" href="javascript:void(0);">设置</a></strong></li>
	<li id="popup_jiaoqiang" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_jiaoqiang" value="0" checked="checked" onclick="calcInsuranceAll();">家用6座以下</label>
				<label><input type="radio" name="r_jiaoqiang" value="5" onclick="calcInsuranceAll();">家用6座及以上</label>
				<div class="clear">
				</div>
			</div>
		</div>
	</li>
	<li><span>商业险：</span> <b id="show_shangye">0元</b> </li>
</ul>
<div class="m-popup-arrow-top"></div>
<ul class="m-calculator-sub-list">
	<li><span>第三责任险：</span> <b id="show_zeren">0元</b> <strong><a id="even_zeren" href="javascript:void(0);">设置</a></strong> </li>
	<li id="popup_zeren" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="thirdInsurance" value="0" onclick="calcInsuranceAll();">无</label>
				<label><input type="radio" name="thirdInsurance" value="5" onclick="calcInsuranceAll();">5万</label>
				<label><input type="radio" name="thirdInsurance" value="10" checked="checked" onclick="calcInsuranceAll();">10万</label>
				<label><input type="radio" name="thirdInsurance" value="20" onclick="calcInsuranceAll();">20万</label>
				<label><input type="radio" name="thirdInsurance" value="50" onclick="calcInsuranceAll();">50万</label>
				<label><input type="radio" name="thirdInsurance" value="100" onclick="calcInsuranceAll();">100万</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>车辆损失险：</span> <b id="show_sunshi">0元</b> <strong><em id="even_sunshi"><i></i><s></s></em></strong> </li>
	<li><span>全车盗抢险：</span> <b id="show_daoqiang">0元</b> <strong><em id="even_daoqiang"><i></i><s></s></em></strong> </li>
	<li><span>玻璃单独破碎险：</span> <b id="show_boliposui">0元</b> <strong><a id="even_boliposui" href="javascript:void(0);">设置</a></strong> </li>
	<li id="popup_boliposui" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_boliposui" value="0" onclick="calcInsuranceAll();">无</label>
				<label><input type="radio" name="r_boliposui" value="1" onclick="calcInsuranceAll();">进口</label>
				<label><input type="radio" name="r_boliposui" value="2" checked="checked" onclick="calcInsuranceAll();">国产</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>自然损失险：</span> <b id="show_ziransunshi">0元</b> <strong><em id="even_ziransunshi"><i></i><s></s></em></strong> </li>
	<li><span>不计免赔特约险：</span> <b id="show_bujimianpei">0元</b> <strong><em id="even_bujimianpei"><i></i><s></s></em></strong> </li>
	<li><span>无过责任险：</span> <b id="show_wuguozeren">0元</b> <strong><em id="even_wuguozeren"><i></i><s></s></em></strong> </li>
	<li><span>车上人员责任险：</span> <b id="show_renyuanzeren">0元</b> <strong><em id="even_reyuanzeren"><i></i><s></s></em></strong> </li>
	<li><span>车身划痕险：</span> <b id="show_cheshenhuahen">0元</b> <strong><a id="even_cheshenhuahen" href="javascript:void(0);">设置</a></strong> </li>
	<li id="popup_cheshenhuahen" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_cheshenhuahen" value="0" onclick="calcInsuranceAll();">无</label>
				<label><input type="radio" name="r_cheshenhuahen" value="2000" onclick="calcInsuranceAll();">2千</label>
				<label><input type="radio" name="r_cheshenhuahen" value="5000" checked="checked" onclick="calcInsuranceAll();">5千</label>
				<label><input type="radio" name="r_cheshenhuahen" value="10000" onclick="calcInsuranceAll();">1万</label>
				<label><input type="radio" name="r_cheshenhuahen" value="20000" onclick="calcInsuranceAll();">2万</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
</ul>
<!-- 灰色层背景 -->
<div class="left-mask"></div>
<!-- 左侧弹出层（品牌） -->
<div id="m-filter-brand-popup" class="left-popup">
	<div class="swipe-left">
		<dl class="tt-list" id="maintree">
			<dt><span>A</span></dt>
			<dd>
				<a href="#" class="selectDemo1">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>B</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>C</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>D</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>E</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>F</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dt><span>G</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>大众</span>
				</a>
			</dd>
		</dl>
	</div>
</div>
<!-- 左侧弹出层（车型） -->
<div id="m-filter-type-popup" class="left-popup">
	<div class="swipe-left">
		<dl class="tt-list" id="seriesTree">
			<dt><span>上海大众 </span></dt>
			<dd>
				<a href="#" class="selectDemo2">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dt><span>一汽大众</span></dt>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>大众POLO</h4>
					<p>报价：<strong>5.99万-12.38万</strong></p>
				</a>
			</dd>
		</dl>
	</div>
</div>
<!-- 左侧弹出层（配置） -->
<div id="m-filter-config-popup" class="left-popup">
	<div class="swipe-left">
	<div class="m-tabs-warp">
		<ul class="m-tabs" id="CarYearTab">
			<li>
				<a class="current" rel="carYearA" href="javascript:void(0);">
					2015款
				</a>
			</li>
			<li>
				<a rel="carYearB" href="javascript:void(0);">
					2014款
				</a>
			</li>
			<li>
				<a rel="carYearC" href="javascript:void(0);">
					2013款
				</a>
			</li>
		</ul>
		</div>
		<div id="caryear">
		<dl class="tt-list" id="carYearA" style="display:block;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2015款 奥迪A4L 30 TFSI 手动 舒适型</p>
					<strong>20.09万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2015款 奥迪A4L 30 TFSI 自动 舒适型</p>
					<strong>21.58万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
		</dl>
		<dl class="tt-list" id="carYearB" style="display:none;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2014款 奥迪A4L 30 TFSI 手动 舒适型</p>
					<strong>20.46万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2014款 奥迪A4L 30 TFSI 自动 舒适型</p>
					<strong>21.82万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
		</dl>
		<dl class="tt-list" id="carYearC" style="display:none;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2013款 奥迪A4L 30 TFSI 手动 舒适型</p>
					<strong>20.46万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2013款 奥迪A4L 30 TFSI 自动 舒适型</p>
					<strong>21.82万</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>自动 旗舰型</p>
					<strong>14.16万</strong>
				</a>
			</dd>
		</dl>
		</div>
	</div>
</div>

</@c.html>
<script>
function showcarprice(name,price){
	$("#selectCarType").html("车型     "+name);
	if(price.length>0){
		$(".car-price-input").val(price);
	}else{
		$(".car-price-input").val("暂无报价");
	}
	$(".left-mask").hide();
	$('.left-popup').hide();
	calcInsuranceAll();
}

function yearType(id){
	$("#CarYearTab li a").removeClass("current");
	$(".tt-list").hide();
	$("#carYear"+id).show();
	$("#CarYearTab li a:eq("+id+")").addClass("current");
}

function resizeHeight(data){
	var docHeight = $(document).height();
	var swipeLeftHeight = $("#"+data).height();

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
$('#selectCarType').on('click', function(e) {
	e.preventDefault();
	var carmain=carbrank[0];
	var mhtml="";
	var alist=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
	for(var i=0;i<alist.length;i++){
		for(var key in carmain){
			if(alist[i]==key){
				mhtml=mhtml+"<dt><span>"+key+"</span></dt>";
				for(var j=0;j<carmain[key].length;j++){
					mhtml=mhtml+"<dd><a href='#' class='selectDemo1' id='"+carmain[key][j]["id"]+"' onclick='seriesTree("+carmain[key][j]["id"]+")'><img src='"+carmain[key][j]["icon"]+"' height='40'><span>"+carmain[key][j]["name"]+"</span></a></dd>";
				}
			}	
		}
	}
	
	$("#maintree").html(mhtml);
	var t1="m-filter-brand-popup .swipe-left";
	$("#maintree").show();
	$('#m-filter-brand-popup').show();
	$('#m-filter-brand-popup .swipe-left').addClass('swipe-left-block');
	
	$('.left-mask').show();
	resizeHeight(t1);
	
});

function seriesTree(id){
var seriesArray=carseries[0][id];
var mhtml="";
for(var key in seriesArray){
	mhtml=mhtml+"<dt><span>"+key+"</span></dt>"
	for(var j=0;j<seriesArray[key].length;j++){
		mhtml=mhtml+"<dd><a href='#' class='selectDemo2' id='"+seriesArray[key][j]["id"]+"' onclick='typeTree("+seriesArray[key][j]["id"]+")'><img src='"+seriesArray[key][j]["icon"]+"' height='40'><h4>"+seriesArray[key][j]["name"]+"</h4></a></dd>";
	}
}
$("#seriesTree").html(mhtml);
$("#seriesTree").show();

$('#m-filter-type-popup').show();
$('#m-filter-type-popup .swipe-left').addClass('swipe-left-block');
$('.left-mask').show();
var t1="m-filter-type-popup .swipe-left";
resizeHeight(t1);
}

function typeTree(id){
var typeArray=cartype[0][id];
var mhtml="";
var mhtml1="";
var a=0;
for(var key in typeArray){
	if(a==0){
		mhtml=mhtml+"<li><a class='current' rel='carYear"+a+"' href='javascript:void(0);' onclick='yearType("+a+")'>"+key+"款</a></li>";
		mhtml1=mhtml1+"<dl class='tt-list' id='carYear"+a+"'>";
	}else{
		mhtml=mhtml+"<li><a rel='carYear"+a+"' href='javascript:void(0);' onclick='yearType("+a+")'>"+key+"款</a></li>";
		mhtml1=mhtml1+"<dl class='tt-list' id='carYear"+a+"' style='display:none;'>";
	}
	
	for(var i in typeArray[key][0]){
		if(typeArray[key][0][i].length>0){
			mhtml1=mhtml1+"<dt><span>"+i+"L</span></dt>";
			for(var j=0 ;j<typeArray[key][0][i].length;j++){
				var name  = typeArray[key][0][i][j]['name'];
				var pri = typeArray[key][0][i][j]['p2']*10000;
				//mhtml1=mhtml1+"<dd><a href='#' onclick='showcarprice('"+name+"','"+pri+"')"><p>"+typeArray[key][0][i][j]["name"]+'</p><strong>'+typeArray[key][0][i][j]["p2"]+'万元</strong></a></dd>';
				mhtml1=mhtml1+'<dd><a href="#" onclick="showcarprice(\''+name+'\',\''+pri+'\')"><p>'+typeArray[key][0][i][j]["name"]+'</p><strong>'+typeArray[key][0][i][j]["p2"]+'万元</strong></a></dd>';
			}
		}
		
	}					
	mhtml1=mhtml1+"</dl>";
	a++;
}

$("#CarYearTab").html(mhtml);
if($(".m-tabs-warp").length > 0) {
	var tbliWidth = $(".m-tabs-warp").find("li").outerWidth();
	var tblilen = $(".m-tabs-warp").find("li").length;
	$("#CarYearTab").width(tbliWidth*tblilen);
}
$("#caryear").html(mhtml1);

$('#m-filter-config-popup').show();
	$('#m-filter-config-popup .swipe-left').addClass('swipe-left-block');
	$('.left-mask').show();
	
}
$("#CarYearTab li a").on('click', function() {
	alert('aaaa');
});
$("#CarYearTab li a").click(function() {
	//通过CSS类找出当前列表
	var curList = $("#CarYearTab li a.current").attr("rel");
	//目录移动到
	var $newList = $(this);
	//删除当前选中,添加样式到刚刚点击的标签
	$("#CarYearTab li a").removeClass("current");
	$newList.addClass("current");
	//找出新的列表ID
	var listID = $newList.attr("rel");
	if (listID != curList) {
		$("#"+curList).hide();
		$("#"+listID).show();
	}
});
$('.selectDemo1').on('click', function(e) {
	e.preventDefault();
	$('#m-filter-type-popup').show();
	$('#m-filter-type-popup .swipe-left').addClass('swipe-left-block');
	$('.left-mask').show();
});
$('.selectDemo2').on('click', function(e) {
	e.preventDefault();
	$('#m-filter-config-popup').show();
	$('#m-filter-config-popup .swipe-left').addClass('swipe-left-block');
	$('.left-mask').show();
});
$('#downPayment').on('click', function(e) {
	e.preventDefault();
	$('#m-filter-pct-popup').show();
	$('#m-filter-pct-popup .swipe-left').addClass('swipe-left-block');
	$('.left-mask').show();

});
// 关闭
$('.left-mask').click(function() {
	$(this).hide();
	$('.left-popup').hide();
});

$('#s_shoufu a, #s_daikuan a').click(function() {
  $(this).addClass('current').siblings().removeClass('current');
});



function calcInsuranceAll() {
	if(!checkMoneyValidation()) return;
	if ($('#show_money').val() == 0) {
		$("strong[id^='show_'],b[id^='show_']").html("0元");
		return;
	}
	if ($('#show_money').val() != "0") {
		$("#show_renyuanzeren").html("50元");
	}

	//交强险
	calcCompulsory();
	//第三责任险
	calcTPL();
	//车辆损失险
	calcCarDamage();
	//全车盗抢险
	calcCarTheft();
	//玻璃单独破碎险
	calcBreakageOfGlass();
	//自然损失险
	calcSelfignite();
	//不计免赔特约险
	calcAbatement();
	//无过责任险
	calcBlameless();
	//车上责任险
	calcLimitofPassenger();
	//车身划痕险
	calcCarDamageDW();
	//商业险
	calcCommonTotal();
	//计算总价
	caclInsurance();
	//计算市场报价
	calcMarket();
	//格式化数字千位符
	$("strong[id^='show_'],b[id^='show_']").html(function(index,html){return formatCurrency(parseInt(html))+"元";})
}

//计算保险总额
function caclInsurance(){
	var moneyTotal = Math.round(parseFloat($('#show_jiaoqiang').html()) + parseFloat($('#show_shangye').html()));
	$("#show_company").html(moneyTotal + "元");
}

$("#even_sunshi,#even_daoqiang,#even_ziransunshi,#even_bujimianpei,#even_wuguozeren,#even_reyuanzeren").click(function () {
	calcInsuranceAll();
});

//计算市场报价
function calcMarket() {
	var MarketTotal = (parseInt(parseFloat($('#show_jiaoqiang').html()) + (parseFloat($('#show_shangye').html()) * 0.7)));
	$("#show_market").html(MarketTotal + "元");
}

</script>