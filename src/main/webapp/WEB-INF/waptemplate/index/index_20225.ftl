<#import "../common_wapchetuan.ftl" as c />

<@c.html >
<script src="${wap_ct_url}js/CarCalculator.js"></script>
<div class="top-nav">
	<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
	<h2>��������</h2>
</div>
<div class="tools-nav">
	<div class="sort sort3 bar-btn">
		<ul>
			<li class="active"><a href="#">��������</a></li>
			<li><a href="${wap_ct_url}gongju/chedaijisuanqi.html">�����</a></li>
			<li><a href="${wap_ct_url}gongju/chexianjisuanqi.html">���ռ���</a></li>
		</ul>
	</div>
</div>
<div class="tools-con">
	<div class="tools-car-tt"><span>��ѡ���ͻ���ֱ�������㳵��</span></div>
	<div class="tools-car-con">
		<div class="tools-select" id="selectCarType">����</div>
		<div >�㳵�ۼۣ�Ԫ��<input id="show_money" type="number" maxlength="2" class="car-price-input" value="" onchange="calcAutoCashAll()" ></div>
	</div>
</div>

<ul class="m-calculator-list">
	<li class="list-head"><span>ȫ������軨�ѣ�</span><strong id="show_total">0Ԫ</strong></li>
	<li><span>����˰��</span> <b id="show_gouzhitax">0Ԫ</b> </li>
	<li><span>���Ʒ��ã�</span> <b id="show_chepai">0Ԫ</b> </li>
	<li><span>����ʹ��˰��</span> <b id="show_chechuantax">0Ԫ</b> <strong><a id="even_chechuantax" href="javascript:void(0
		);">����</a></strong></li>
	<li id="popup_chechuantax" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label>
					<input type="radio" name="r_checuantax" value="1">1.0L(��)����</label>
				<label>
					<input type="radio" name="r_checuantax" value="2">1.0-1.6L(��)</label>
				<label>
					<input type="radio" name="r_checuantax" value="3" checked>1.6-2.0L(��)</label>
				<label>
					<input type="radio" name="r_checuantax" value="4">2.0-2.5L(��)</label>
				<label>
					<input type="radio" name="r_checuantax" value="5">2.5-3.0L(��)</label>
				<label>
					<input type="radio" name="r_checuantax" value="6">3.0-4.0L(��)</label>
				<label>
					<input type="radio" name="r_checuantax" value="7">4.0L����</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>��ǿ�գ�</span> <b id="show_jiaoqiang">0Ԫ</b> <strong><a id="even_jiaoqiang" href="javascript:void(0
		);">����</a></strong></li>
	<li id="popup_jiaoqiang" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_jiaoqiang" value="" checked>����6������</label>
				<label><input type="radio" name="r_jiaoqiang" value="">����6������</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>��ҵ�գ�</span> <b id="show_shangye">0Ԫ</b> </li>
</ul>
<div class="m-popup-arrow-top"></div>
<ul class="m-calculator-sub-list">
	<li><span>���������գ�</span> <b id="show_zeren">0Ԫ</b> <strong><a id="even_zeren" href="javascript:javascript:void(0
		);">����</a></strong> </li>
	<li id="popup_zeren" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="thirdInsurance" value="" >��</label>
				<label><input type="radio" name="thirdInsurance" value="">5��</label>
				<label><input type="radio" name="thirdInsurance" value="" checked>10��</label>
				<label><input type="radio" name="thirdInsurance" value="">20��</label>
				<label><input type="radio" name="thirdInsurance" value="">50��</label>
				<label><input type="radio" name="thirdInsurance" value="">100��</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>������ʧ�գ�</span> <b id="show_sunshi">0Ԫ</b> <strong><em id="even_sunshi"><i></i><s></s></em></strong> </li>
	<li><span>ȫ�������գ�</span> <b id="show_daoqiang">0Ԫ</b> <strong><em id="even_daoqiang"><i></i><s></s></em></strong> </li>
	<li><span>�������������գ�</span> <b id="show_boliposui">0Ԫ</b> <strong><a id="even_boliposui" href="javascript:void(0
		);">����</a></strong> </li>
	<li id="popup_boliposui" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_boliposui" value="">��</label>
				<label><input type="radio" name="r_boliposui" value="">����</label>
				<label><input type="radio" name="r_boliposui" value="" checked>����</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
	<li><span>��Ȼ��ʧ�գ�</span> <b id="show_ziransunshi">0Ԫ</b> <strong><em id="even_ziransunshi"><i></i><s></s></em></strong> </li>
	<li><span>����������Լ�գ�</span> <b id="show_bujimianpei">0Ԫ</b> <strong><em id="even_bujimianpei"><i></i><s></s></em></strong> </li>
	<li><span>�޹������գ�</span> <b id="show_wuguozeren">0Ԫ</b> <strong><em id="even_wuguozeren"><i></i><s></s></em></strong> </li>
	<li><span>������Ա�����գ�</span> <b id="show_renyuanzeren">0Ԫ</b> <strong><em id="even_reyuanzeren"><i></i><s></s></em></strong> </li>
	<li><span>�������գ�</span> <b id="show_cheshenhuahen">0Ԫ</b> <strong><a id="even_cheshenhuahen" href="javascript:void(0
		);">����</a></strong> </li>
	<li id="popup_cheshenhuahen" class="m-popup-item m-popup-arrow m-popup-insurance">
		<b></b>
		<div class="m-popup-box">
			<div class="m-popup">
				<label><input type="radio" name="r_cheshenhuahen" value="" checked>��</label>
				<label><input type="radio" name="r_cheshenhuahen" value="">2ǧ</label>
				<label><input type="radio" name="r_cheshenhuahen" value="">5ǧ</label>
				<label><input type="radio" name="r_cheshenhuahen" value="">1��</label>
				<label><input type="radio" name="r_cheshenhuahen" value="">2��</label>
				<div class="clear"></div>
			</div>
		</div>
	</li>
</ul>
<!-- ��ɫ�㱳�� -->
<div class="left-mask"></div>
<!-- ��൯���㣨Ʒ�ƣ� -->
<div id="m-filter-brand-popup" class="left-popup">
	<div class="swipe-left">
		<dl class="tt-list" id="maintree">
			<dt><span>A</span></dt>
			<dd>
				<a href="#" class="selectDemo1">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>B</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>C</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>D</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>E</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>F</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dt><span>G</span></dt>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/m_8_55.png" height="40">
					<span>����</span>
				</a>
			</dd>
		</dl>
	</div>
</div>
<!-- ��൯���㣨���ͣ� -->
<div id="m-filter-type-popup" class="left-popup">
	<div class="swipe-left">
		<dl class="tt-list" id="seriesTree">
			<dt><span>�Ϻ����� </span></dt>
			<dd>
				<a href="#" class="selectDemo2">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dt><span>һ������</span></dt>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
			<dd>
				<a href="#">
					<img src="img/polo.jpg" height="40">
					<h4>����POLO</h4>
					<p>���ۣ�<strong>5.99��-12.38��</strong></p>
				</a>
			</dd>
		</dl>
	</div>
</div>
<!-- ��൯���㣨���ã� -->
<div id="m-filter-config-popup" class="left-popup">
	<div class="swipe-left">
	<div class="m-tabs-warp">
		<ul class="m-tabs" id="CarYearTab">
			<li>
				<a class="current" rel="carYearA" href="javascript:void(0);">
					2015��
				</a>
			</li>
			<li>
				<a rel="carYearB" href="javascript:void(0);">
					2014��
				</a>
			</li>
			<li>
				<a rel="carYearC" href="javascript:void(0);">
					2013��
				</a>
			</li>
		</ul>
		</div>
		<div id="caryear">
		<dl class="tt-list" id="carYearA" style="display:block;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2015�� �µ�A4L 30 TFSI �ֶ� ������</p>
					<strong>20.09��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2015�� �µ�A4L 30 TFSI �Զ� ������</p>
					<strong>21.58��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
		</dl>
		<dl class="tt-list" id="carYearB" style="display:none;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2014�� �µ�A4L 30 TFSI �ֶ� ������</p>
					<strong>20.46��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2014�� �µ�A4L 30 TFSI �Զ� ������</p>
					<strong>21.82��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
		</dl>
		<dl class="tt-list" id="carYearC" style="display:none;">
			<dt><span>1.8L</span></dt>
			<dd>
				<a href="#">
					<p>2013�� �µ�A4L 30 TFSI �ֶ� ������</p>
					<strong>20.46��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>2013�� �µ�A4L 30 TFSI �Զ� ������</p>
					<strong>21.82��</strong>
				</a>
			</dd>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
			<dt><span>2.0L</span></dt>
			<dd>
				<a href="#">
					<p>�Զ� �콢��</p>
					<strong>14.16��</strong>
				</a>
			</dd>
		</dl>
		</div>
	</div>
</div>
</@c.html>
<script>
function showcarprice(name,price){
	$("#selectCarType").html("����     "+name);
	if(price.length>0){
		$(".car-price-input").val(price);
	}else{
		$(".car-price-input").val("���ޱ���");
	}
	$(".left-mask").hide();
	$('.left-popup').hide();
	calcAutoCashAll();
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
		mhtml=mhtml+"<li><a class='current' rel='carYear"+a+"' href='javascript:void(0);' onclick='yearType("+a+")'>"+key+"��</a></li>";
		mhtml1=mhtml1+"<dl class='tt-list' id='carYear"+a+"'>";
	}else{
		mhtml=mhtml+"<li><a rel='carYear"+a+"' href='javascript:void(0);' onclick='yearType("+a+")'>"+key+"��</a></li>";
		mhtml1=mhtml1+"<dl class='tt-list' id='carYear"+a+"' style='display:none;'>";
	}
	
	for(var i in typeArray[key][0]){
		if(typeArray[key][0][i].length>0){
			mhtml1=mhtml1+"<dt><span>"+i+"L</span></dt>";
			for(var j=0 ;j<typeArray[key][0][i].length;j++){
				var name  = typeArray[key][0][i][j]['name'];
				var pri = typeArray[key][0][i][j]['p2']*10000;
				//mhtml1=mhtml1+"<dd><a href='#' onclick='showcarprice('"+name+"','"+pri+"')"><p>"+typeArray[key][0][i][j]["name"]+'</p><strong>'+typeArray[key][0][i][j]["p2"]+'��Ԫ</strong></a></dd>';
				mhtml1=mhtml1+'<dd><a href="#" onclick="showcarprice(\''+name+'\',\''+pri+'\')"><p>'+typeArray[key][0][i][j]["name"]+'</p><strong>'+typeArray[key][0][i][j]["p2"]+'��Ԫ</strong></a></dd>';
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
	//ͨ��CSS���ҳ���ǰ�б�
	var curList = $("#CarYearTab li a.current").attr("rel");
	//Ŀ¼�ƶ���
	var $newList = $(this);
	//ɾ����ǰѡ��,�����ʽ���ոյ���ı�ǩ
	$("#CarYearTab li a").removeClass("current");
	$newList.addClass("current");
	//�ҳ��µ��б�ID
	var listID = $newList.attr("rel");
	if (listID != curList) {
		$("#"+curList).hide();
		$("#"+listID).show();
	}
});
$('.left-popup').css({
	'display': 'none'
});
function calcAutoCashAll() {
	if(!checkMoneyValidation()) return;
	if ($('#show_money').val() == 0) {
		$("strong[id^='show_'],b[id^='show_']").html("0Ԫ");
		return;
	}
	if ($('#show_money').val() != "0") {
		$("#show_chepai").html("500Ԫ");
		$("#show_renyuanzeren").html("50Ԫ");
	}
	//����˰
	calcAcquisitionTax();
	//����ʹ��˰
	CalculateVehicleAndVesselTax();
	//��ǿ��
	calcCompulsory();
	//����������
	calcTPL();
	//������ʧ��
	calcCarDamage();
	//ȫ��������
	calcCarTheft();
	//��������������
	calcBreakageOfGlass();
	//��Ȼ��ʧ��
	calcSelfignite();
	//����������Լ��
	calcAbatement();
	//�޹�������
	calcBlameless();
	//����������
	calcLimitofPassenger();
	//��������
	calcCarDamageDW();
	//��ҵ��
	calcCommonTotal();
	//�����ܼ�
	calcTotal();
	//��ʽ������ǧλ��
	$("strong[id^='show_'],b[id^='show_']").html(function(index,html){return formatCurrency(parseInt(html))+"Ԫ";})
}

$("#btnSubmit").bind("click", function () { calcAutoCashAll(); });
$("#show_money").focus(function(){var money=parseInt($(this).val());if(money<=0)$(this).val(""); });
$("input[name='thirdInsurance'],input[name='r_boliposui'],input[name='r_cheshenhuahen'],input[name='r_jiaoqiang'],input[name='r_checuantax']").bind("click", calcAutoCashAll);

$("#even_sunshi,#even_daoqiang,#even_ziransunshi,#even_bujimianpei,#even_wuguozeren,#even_reyuanzeren").click(function () {
	calcAutoCashAll();
});

$('.left-mask').click(function() {
	$(this).hide();
	$('.left-popup').hide();
});
</script>