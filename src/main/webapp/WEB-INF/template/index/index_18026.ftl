<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "【购车计算器】车价计算器_2014最新购车计算器-车团网"  "车团网购车工具提供2014最新购车计算器，车价计算器，车团网，汽车电商O2O服务第一品牌。" "购车计算器,车价计算器">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
  <script>
  var flagx = false;
  $(function() {

    //解释说明
    $("a.yiwenicon.z30").bind("click", function (e) {
        $(".yiwenicon.z30").removeAttr("style"); //处理连续点击问号的情况
        e.stopPropagation();
        $(this).css("zIndex", 100);
    });
    
    $("p").bind("click", function (e) {
        e.stopPropagation();
    });
    
    $(".close").click(function (e) {
        e = e || window.event;
        e.preventDefault();
        e.stopPropagation();
        $(this).closest(".yiwenicon.z30").removeAttr("style");
        $(this).closest(".tc.tc-jsq").hide();
    });
    
    $(document).click(function (e) {
        e = e || window.event;
        var target = e.srcElement || e.target;
        if ($(target).closest(".tc.tc-jsq").length <= 0)
            $(".yiwenicon.z30").removeAttr("style");
            $(".tc.tc-jsq").hide();
    });

  });

  var preText = null;
  function showjs(j) {
      if (preText)
          preText[0].style.display = 'none';
      preText = $("#" + j);
      $("#" + j)[0].style.display = '';

      var height = $("#" + j).children("div").height();
  }
  function closex(t) {
      event = event || window.event;
      event.preventDefault();
      $("#" + t)[0].style.display = 'none';
  }
  </script>
<script type="text/javascript">
$(document).ready(function(){
calcAutoCashAll();
$(document).click(function(){
		$(".select-option").hide();
		$(".select").removeClass("btn-packup");
	})
	
	$("a[pop='true']").on("click", function() {
      $(this).next().show().parent().addClass("fzindex");
      $(this).parents("tr").siblings().find(".btn-pop").hide().end().find(".buy-btn").removeClass("fzindex");
    });
    $(".pop-close").on("click", function() {
      $(this).parents(".btn-pop").hide();
    });

	$.ajax({
		url : '${www_ct_url}chetuan/getMainTree',
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
					$(this).parents(".selc").next().find(".select").removeClass("select-disabled");
				});
				event.stopPropagation();
			}else{
				$(this).next().hide();
				$(this).parent().removeClass("btn-packup");
			}
		}
		
		
		if($(this).attr("name") == "lineTree"){
			if($(this).next().is(":hidden")) {
				var catalogid = ($(this).parents(".selc").prev().find("span")[0].title);
				if(catalogid==""){return;};
				var clickDiv = $(this);
				$.ajax({
			    		url : '${www_ct_url}chetuan/getChildTree',
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
								$(this).parents(".selc").next().find(".select").removeClass("select-disabled");
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
				var catalogid = ($(this).parents(".selc").prev().find("span")[0].title);
				if(catalogid==""){return;};
				var clickDiv = $(this);
				$.ajax({
			    		url : '${www_ct_url}chetuan/getChildTree',
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
	
	$("#pinpai2x").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	});
});

function onGetClick(catalogid,setid){
	$.ajax({
		url : '${www_ct_url}chetuan/getPrice',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		data:{catalogid:catalogid},
		success : function(data){
    		$("#txtMoney").val(parseInt((data.p2)*10000));
    		setVehicleTaxSelect(data.p31)
    		$("#txtMoney").change();
    		//计算
    		flagx = false;
    		$("#txtChePai").val(500);
    		calcAutoCashAll();
		}
	});
	
}
//排量
function setVehicleTaxSelect(value){
	var pl = parseFloat(value);
	var plValue = 300;
	if(pl<=1.0)
		plValue = 300;
	if(1.0<pl&&pl<=1.6)
		plValue = 420;
	if(1.6<pl&&pl<=2.0)
		plValue = 480;
	if(2.0<pl&&pl<=2.5)
		plValue = 900;
	if(2.5<pl&&pl<=3.0)
		plValue = 1920;
	if(3.0<pl&&pl<=4.0)
		plValue = 3480;
	if(pl>4.0)
		plValue = 5280;
	var vehicleTaxSelect = document.getElementById("vehicleTaxSelect");
	for(var i=0;i<vehicleTaxSelect.options.length;i++) {  
            if(vehicleTaxSelect.options[i].value == plValue) {  
                vehicleTaxSelect.options[i].selected = true;  
                break;  
            }
    }
}
//初始化上牌费
function initChepai(){
	if(!flagx)
		$("#txtChePai").val(500)
}
function changeFlagx(){
	flagx=true;
}
function calcAutoCashAll()
{
	var totalMoeny = 0;//全款购车价
	var essentialCost = 0;//必要花费
	var businessCost = 0;//商业保险
	var money = $('#txtMoney').val();
	var gzs = 0;//购置税
	var spf = 0;//上牌费
	var ccs = 0;//车船税
	var jqx = 0;//交强险
	var tbl = 0;//第三方责任险
	var carDamage = 0;//车辆损失险
	var Abatement = 0;//不计免赔特约险
	var CarTheft = 0;//全车盗抢险
	var BreakageOfGlass = 0;//玻璃破碎险
	var Selfignite = 0;//自燃险
	var engineDamage = 0;//发动机特别损失险
	var CarDamageDW = 0;//车身划痕险
	var LimitOfDriver = 0;//司机坐位责任险
	var LimitOfPassenger = 0;//乘客坐位责任险
	 if ($('#txtMoney').val() == 0) 
	 {
                //document.getElementById('lblShouFu').innerHTML = 0; //首付
                //document.getElementById('lblYueGong').innerHTML = 0; //月供
                document.getElementById('lblAcquisitionTax').innerHTML = 0;//购置税
                $('#txtVehicleTax').val(0); //车船使用税
                document.getElementById('lblCompulsory').innerHTML = 0; //交强险
                document.getElementById('lblCommonTotal').innerHTML = 0; //必要花费
                document.getElementById('lblTPL').innerHTML = 0; //第三方责任险
                document.getElementById('lblCarDamage').innerHTML = 0; //车辆损失险
                document.getElementById('lblCarTheft').innerHTML = 0; //全车盗抢险
                document.getElementById('lblBreakageOfGlass').innerHTML = 0; //玻璃破碎险
                document.getElementById('lblSelfignite').innerHTML = 0; //自燃险
                document.getElementById('lblAbatement').innerHTML = 0; //不计免赔特约险
                document.getElementById('lblCarDamageDW').innerHTML = 0; //车身划痕险
                document.getElementById('lblLimitOfPassenger').innerHTML = 0; //乘客坐位责任险
                document.getElementById('lblLimitOfDriver').innerHTML = 0; //司机坐位责任险
                document.getElementById('engineDamage').innerHTML = 0; //发动机特别损失险
                $('#txtChePai').val(0); //上牌费用
                document.getElementById('essentialCost').innerHTML = 0; //必要花费
                $("#liDispaly1").show();
				$("#liDispaly2").hide();
                return;
     }
    
    gzs = calcAcquisitionTax();//购置税
	spf = caclChePaiTax();//上牌费
	ccs = caclVehicleTax();//车船税
	jqx = caclCompulsoryTax();//交强险
	tbl = calcTPL();//第三方责任险
	carDamage = calcCarDamage();//车辆损失险
	Abatement = calcAbatement();//不计免赔特约险
	CarTheft = calcCarTheft();//全车盗抢险
	BreakageOfGlass = calcBreakageOfGlass();//玻璃破碎险
	Selfignite = calcSelfignite(); //自燃险
	engineDamage =  calcCarEngineDamage();//发动机特别损失险
	CarDamageDW = calcCarDamageDW();//车身划痕险
	LimitOfDriver = calcLimitofDriver();//司机坐位责任险
	LimitOfPassenger = calcLimitofPassenger();//乘客坐位责任险
	essentialCost = parseInt(gzs) + parseInt(spf) + parseInt(ccs) +parseInt(jqx);
	businessCost = parseInt(tbl)+parseInt(carDamage)+parseInt(Abatement)+parseInt(CarTheft)+parseInt(BreakageOfGlass)+parseInt(Selfignite)+parseInt(engineDamage)+parseInt(CarDamageDW)+parseInt(LimitOfDriver)+parseInt(LimitOfPassenger);
	totalMoeny = essentialCost + businessCost + parseInt(money);
	SetSpanValueByBrowerType("essentialCost", formatCurrency(essentialCost));
	SetSpanValueByBrowerType("lblTopTotal", formatCurrency(totalMoeny));
	SetSpanValueByBrowerType("lblCommonTotal", formatCurrency(businessCost));
	//首付
    //calcShouFu(essentialCost,businessCost);
	//月供
    //calcYueGong();

	$("#liDispaly1").hide();
	$("#liDispaly2").show();
}

//必要花费类
//购置税：购置附加税＝购车款／（1＋17％）× 购置税率（税率：10%）
function calcAcquisitionTax() {
    var acquisitionTax = parseFloat($('#txtMoney').val()) / (1 + 0.17) * 0.1;
    var result = Math.round(acquisitionTax);
    SetSpanValueByBrowerType("lblAcquisitionTax", formatCurrency(result));
    return result;
}
//上牌费
function caclChePaiTax(){
	var money = parseInt($('#txtMoney').val());
	var result = 0;
	if(money>0)
		result = $("#txtChePai").val();
	//$("#txtChePai").val(result)
    return result;
}
//车船税
function caclVehicleTax(){
	var result = 0;
	result = $("#vehicleTaxSelect").children('option:selected').val();
	$("#txtVehicleTax").val(result)
    return result;
}
//交强险
function caclCompulsoryTax(){
	var result = 0;
	result = $("#selCompulsorySelect").children('option:selected').val();
	SetSpanValueByBrowerType("lblCompulsory", formatCurrency(result));
    return result;
}

//商业保险类
//第三者责任险
function calcTPL() {
    var selCompulsoryIndex = document.getElementById("selCompulsorySelect").selectedIndex;
    if ($('#chkTPL').prop("checked")) {
        var selTPLValue = document.getElementById("selTPL").selectedIndex;
        if (selCompulsoryIndex == 0) {
            if (selTPLValue == 0) {
                jQuery("#lblTPL").html("710");
                return 710;
            }
            if (selTPLValue == 1) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1026));
                return 1026;
            }
            if (selTPLValue == 2) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1270));
                return 1270;
            }
            if (selTPLValue == 3) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1721));
                return 1721;
            }
            if (selTPLValue == 4) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(2242));
                return 2242;
            }
        } else if (selCompulsoryIndex == 1) {
            if (selTPLValue == 0) {
                jQuery("#lblTPL").html("659");
                return 659;
            }
            if (selTPLValue == 1) {
                jQuery("#lblTPL").html("928");
                return 928;
            }
            if (selTPLValue == 2) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1131));
                return 1131;
            }
            if (selTPLValue == 3) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1507));
                return 1507;
            }
            if (selTPLValue == 4) {
                SetSpanValueByBrowerType('lblTPL', formatCurrency(1963));
                return 1963;
            }
        }
    }
    else {
        jQuery('#lblTPL').html("0");
    }
    return 0;
}
//车辆损失险
function calcCarDamage() {
	var result = 0;
    if ($('#chkCarDamage').prop("checked")) {
        var selCompulsoryIndex = document.getElementById("selCompulsorySelect").selectedIndex;
        var rate = 0.0095;
        var baseCost = 285;
        result = Math.round($('#txtMoney').val() * rate + baseCost);
        //jQuery('#lblCarDamage').html(result);
        SetSpanValueByBrowerType('lblCarDamage', formatCurrency(result));
    }
    else {
        jQuery('#lblCarDamage').html("0");
    }
    return result;
}
//不计免赔特约险
function calcAbatement() {
	var result = 0;
    if ($('#chkCarDamage').prop("checked") && $('#chkTPL').prop("checked") && $('#chkAbatement').prop("checked")) {
        var total = GetIntValue(jQuery("#lblCarDamage").html()) + GetIntValue($("#lblTPL").html());
        SetSpanValueByBrowerType('lblAbatement', formatCurrency(Math.round(total * 0.2)));
        result = Math.round(total * 0.2);
    }
    else {
        $('#chkAbatement').attr("checked", false);
        jQuery("#lblAbatement").html("0");
    }
    return result;
}
//全车盗抢险
function calcCarTheft() {
	var result = 0 ;
    if ($('#chkCarTheft').prop("checked") && $('#chkCarDamage').prop("checked")) {
        var selCompulsoryIndex = document.getElementById("selCompulsorySelect").selectedIndex;
        if (selCompulsoryIndex == 1){
            SetSpanValueByBrowerType('lblCarTheft', formatCurrency(Math.round($('#txtMoney').val() * 0.0044 + 140)));
            result = Math.round($('#txtMoney').val() * 0.0044 + 140);
        }
        else{
            SetSpanValueByBrowerType('lblCarTheft', formatCurrency(Math.round($('#txtMoney').val() * 0.0049 + 120)));
            result = Math.round($('#txtMoney').val() * 0.0049 + 120);
        }
    }
    else
    	jQuery("#lblCarTheft").html("0");
    return result;
}
//玻璃单独破碎险
function calcBreakageOfGlass() {
	var result = 0 ;
    if ($('#chkBreakageOfGlass').prop("checked")) {
        var breakageOfGlassValue = document.getElementById("selBreakageOfGlass").value;
        var selCompulsoryIndex = document.getElementById("selCompulsorySelect").selectedIndex;
        if (breakageOfGlassValue == 0)//进口
        	//6-10座客车
            if (selCompulsoryIndex == 1) { 
                SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.003)));
                result = Math.round($('#txtMoney').val() * 0.003);
            } else {
                SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.0031)));
                result = Math.round($('#txtMoney').val() * 0.0031);
            }
        //国产
        if (breakageOfGlassValue == 1){
            SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.0019)));
            result = Math.round($('#txtMoney').val() * 0.0019);
        }
    } else {
        jQuery("#lblBreakageOfGlass").html("0");
    }
    return result;
}
//自燃损失险
function calcSelfignite() {
	var result = 0 ;
    if ($('#chkSelfignite').prop("checked")) {
        SetSpanValueByBrowerType('lblSelfignite', formatCurrency(Math.round($('#txtMoney').val() * 0.0015)));
        result = Math.round($('#txtMoney').val() * 0.0015);
    }
    else {
        jQuery('#lblSelfignite').html("0");
    }
    return result;
}
//发动机特别损失险(车损险*5%)
function calcCarEngineDamage() {
	var result = 0 ;
    if ($("#chkEngine").prop("checked") && $("#chkCarDamage").prop("checked")) {
        var cDamage = GetIntValue(jQuery("#lblCarDamage").html()) * 0.05;
        SetSpanValueByBrowerType('engineDamage', formatCurrency(Math.round(cDamage)));
        result = Math.round(cDamage);
    } else {
        $('#chkEngine').attr("checked", false);
        jQuery("#engineDamage").html("0");
    }
    return result;
}
//车身划痕险
function calcCarDamageDW() {
	var result = 0;
    if ($('#chkCarDamage').prop("checked") && $('#chkCarDamageDW').prop("checked")) {
        var selCarDamageDWIndex = document.getElementById("selCarDamageDW").selectedIndex;
        if ($('#txtMoney').val() < 300000) {
            if (selCarDamageDWIndex == 0){
                jQuery('#lblCarDamageDW').html("400");result  = 400;}
            if (selCarDamageDWIndex == 1){
                jQuery('#lblCarDamageDW').html("570");result = 570;}
            if (selCarDamageDWIndex == 2){
                jQuery('#lblCarDamageDW').html("760");result = 760;}
            if (selCarDamageDWIndex == 3){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(1140));result = 1140;}
        } else if ($('#txtMoney').val() > 500000) {
            if (selCarDamageDWIndex == 0){
                jQuery('#lblCarDamageDW').html("850");result = 850;}
            if (selCarDamageDWIndex == 1){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(1100));result = 1100;}
            if (selCarDamageDWIndex == 2){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(1500));result = 1500;}
            if (selCarDamageDWIndex == 3){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(2250));result = 2250;}
        } else {
            if (selCarDamageDWIndex == 0){
                jQuery('#lblCarDamageDW').html("585");result = 585;}
            if (selCarDamageDWIndex == 1){
                jQuery('#lblCarDamageDW').html("900");result = 900;}
            if (selCarDamageDWIndex == 2){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(1170));result = 1170;}
            if (selCarDamageDWIndex == 3){
                SetSpanValueByBrowerType('lblCarDamageDW', formatCurrency(1780));result = 1780;}
        }
    }else {
        $('#chkCarDamageDW').attr("checked", false);
        jQuery("#lblCarDamageDW").html("0");
    }
    return result;
}
//乘客责任险（//所选金额*费率*（座位数-1）。如果没有座位数，则*4）
function calcLimitofPassenger() {
	var result = 0;
    if ($('#chkLimitofPassenger').prop("checked")) {
        if (jQuery('#selCompulsorySelect').prop('selectedIndex') == 0) { //6座以下
            var lvalue1 = Math.round(jQuery("#selLimitofPassenger option:selected").val() * 0.0027 * 4);
            jQuery("#lblLimitOfPassenger").html(lvalue1);
            result = lvalue1;
        } else {
            var lvalue2 = Math.round(jQuery("#selLimitofPassenger option:selected").val() * 0.0026 * 8);
            jQuery("#lblLimitOfPassenger").html(lvalue2);
            result = lvalue2;
        }
    } else {
        jQuery("#lblLimitOfPassenger").html("0");
    }
    return result;
}
//司机责任险
function calcLimitofDriver() {
	var result = 0;
    if ($('#chkLimitofDriver').prop("checked")) {
        if (jQuery('#selCompulsorySelect').prop('selectedIndex') == 0) {//6座以下
            //所选金额*费率*（座位数-1）。如果没有座位数，则*4
            var lvalue1 = Math.round(jQuery("#selLimitofDriver option:selected").val() * 0.0042);
            jQuery("#lblLimitOfDriver").html(lvalue1);
             result = lvalue1;
        } else {
            var lvalue2 = Math.round(jQuery("#selLimitofDriver option:selected").val() * 0.004);
            jQuery("#lblLimitOfDriver").html(lvalue2);
            result = lvalue2;
        }
    }
    else {
        jQuery("#lblLimitOfDriver").html("0");
    }
	 return result;
}
 //首付(必要花费+商业保险+裸车价*30%)
function calcShouFu(essentialCost,businessTotal) {
            var shouFu = essentialCost + businessTotal + Math.round($('#txtMoney').val() * 0.3);
            SetSpanValueByBrowerType("lblShouFu", formatCurrency(shouFu));
            return shouFu;
}
//月供(按3年 首付30%计算)  利率值可参考"计算器需求文档"
function calcYueGong() {
            var monthPercent = 0.00533333;
            var loanMonths = 36;
            var fenzi = parseFloat($('#txtMoney').val()) * 0.7 * monthPercent * Math.pow((1 + monthPercent), loanMonths);
            var fenmu = (Math.pow((1 + monthPercent), loanMonths) - 1);
            var result = Math.round(fenzi / fenmu);
            SetSpanValueByBrowerType("lblYueGong", formatCurrency(result));
            return result;
}


//------------------------common function---------------------------------------
function SetSpanValueByBrowerType(control, value) {
    $("#" + control).html(value);
}
function formatCurrency(num) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num)) num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    num = Math.floor(num / 100).toString();
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
    return (((sign) ? '' : '-') + num);
}
function formatCurrencyWToK(num) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num)) num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 10000 + 0.50000000001).toString();
    return (((sign) ? '' : '-') + num);
}

function GetIntValue(num) {
    num = num.toString().replace(/\,/g, '');
    return parseInt(num);
}
</script>
<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">购车工具</a>&gt;<a class="active" href="javascript:void(0);">购车计算</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 5/>
			</div>
			 <div class="line-box">
        <div class="title-con">
          <div class="title-box title-box2">
            <h4>选择车款</h4>
            <div class="tableHead_item">
              <div class="selc">
                <em class="seltiptxt">品牌</em>
               <div style="z-index:60;" class="select select-tools">
							<div class="select-selected" name = "mainTree">
								<span>请选择品牌</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="display:none;" class="select-option">
								<dl>
									<dd>
										<b>A</b>
										<a href="">阿尔法罗密欧</a>
									</dd>

								</dl>
							</div>
						</div>
                        </div>
              
              <div class="selc">
                    	<em class="seltiptxt">车系</em>
                    	<div style="z-index:50;" class="select select-tools select-disabled">
							<div class="select-selected" name = "lineTree">
								<span>请选择系列</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="display:none;" class="select-option">
								<dl>
									<dt>华晨宝马</dt>
									<dd><a href="">宝马3系</a></dd>
									<dd><a href="">宝马5系</a></dd>
									<dd><a href="">宝马X1</a></dd>
								</dl>
							</div>
						</div> 
                        </div>
              
               <div style="width:350px;" class="selc">
                    	<em class="seltiptxt">车型</em>
                    	<div style="width:300px;z-index:40;" class="select select-tools select-disabled">
							<div class="select-selected" name = "typeTree" id = "0">
								<span>请选择车型</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="width:346px;display:none;" class="select-option">
								<dl>
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
						</div>
              
              
            </div>
          </div>

          <div class="jisuanqi_box">
            <ul class="rela_ul">
              <li>
                  <div class="l-box">
                      <span class="fl">裸车价格</span> <span class="fonts1">
                          <input id="txtMoney" type="text" class="f-w100" maxlength="8" value="0" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';};initChepai();calcAutoCashAll();" onkeyup="value=value.replace(/(\D)/g,'');initChepai();calcAutoCashAll();" onchange="value=value.replace(/(\D)/g,'');initChepai();calcAutoCashAll();">
                          元</span>
                  </div>
                  <div class="r-box">
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly1" class="bg" style="display:none;">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          <em>请选择车款或输入裸车价格</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly2" style="background: rgb(247, 247, 247);" class="">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          全款购车价：<em class="red16"><label id="lblTopTotal">0</label>
                              元</em></p>
                      <p class="suomin">
                         </p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
            </ul>
            <p class="txt_right">此结果仅供参考，实际应缴费以当地为准</p>
          </div>

          <!-- 必要花费 开始 -->
          <div class="jsq_com_box">
              <div class="titbox">
                  <h4>必要花费</h4>
                  <div class="red_num">
                    <label id="essentialCost">0</label>元
                  </div>
              </div>
              <table id="calEssentialCost" width="100%" cellspacing="0" cellpadding="0" border="0">
                  <colgroup>
                      <col width="200px">
                      <col width="180px">
                      <col width="210px">
                      <col>
                  </colgroup>
                  <tbody>
                      <tr>
                          <th>
                              <label>购置税</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                <em><label id="lblAcquisitionTax">0</label></em>元
                              </div>
                          </td>
                          <td>
                              &nbsp;
                          </td>
                          <td>
                              <span class="fl yiwen_box">购置附加税=裸车价格÷（1＋17％）× 10% 
                                  <a class="yiwenicon z30" desvalue="购置税解释说明" href="javascript:showjs('AcquisitionTax');">?
                                      <div id="AcquisitionTax" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">关闭</em> <strong>购置税</strong>
                                              <p>
                                                  车辆购置税是对在我国境内购置规定车辆的单位和个人征收的一种税，它由车辆购置附加费演变而来。现行车辆购置税法的基本规范，是从2001年1月1日起实施的《中华人民共和国车辆购置税暂行条例》。车辆购置税的纳税人为购置（包括购买、进口、自产、受赠、获奖或以其他方式取得并自用）应税车辆的单位和个人，征税范围为汽车、摩托车、电车、挂车、农用运输车，税率为10%，应纳税额的计算公式为：应纳税额=计税价格×税率。（2009年1月20日至12月31日，对1.6升及以下排量乘用车减按5%征收车辆购置税。自2010年1月1日至12月31日，对1.6升及以下排量乘用车减按7.5%征收车辆购置税。）</p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                      <tr>
                          <th>
                              <label>上牌费用</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <input maxlength="4" id="txtChePai" class="f-w100 f-curr" type="text" value="500" onkeyup="value=value.replace(/(\D)/g,'');changeFlagx();calcAutoCashAll();" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';};changeFlagx();calcAutoCashAll();">
                                  元</div>
                          </td>
                          <td>
                              &nbsp;
                          </td>
                          <td>
                              <span class="fl yiwen_box">可手动修改，不同地区费用不同 
                                  <a class="yiwenicon z30" desvalue="上牌费用解释说明" href="javascript:showjs('shangPai');">?
                                      <div id="shangPai" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">关闭</em> <strong>上牌费用</strong>
                                              <p>
                                              通常商家提供的一条龙服务收费约500元，个人办理约373元，其中工商验证、出库150元、移动证30元、环保卡3元、拓号费40元、行驶证相片20元、托盘费130元</p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                      <tr>
                          <th>
                              <label>车船使用税</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <input id="txtVehicleTax" class="f-w100 f-curr" value="0" type="text" maxlength="4" onkeyup="value=value.replace(/(\D)/g,'');calcAutoCashAll();" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';}calcAutoCashAll();">
                                  元</div>
                          </td>
                          <td id="divCashVehicleAndVesselTaxMessage">
                            <select id="vehicleTaxSelect" class="f-w150 f-curr" onchange="calcAutoCashAll();">
                              <option value="300">1.0L(含)以下</option>
                              <option value="420" selected="selected">1.0-1.6L(含)</option>
                              <option value="480">1.6-2.0L(含)</option>
                              <option value="900">2.0-2.5L(含)</option>
                              <option value="1920">2.5-3.0L(含)</option>
                              <option value="3480">3.0-4.0L(含)</option>
                              <option value="5280">4.0L以上</option>
                            </select>
                          </td>
                          <td>
                              <span class="fl yiwen_box">按排量收取费用 
                                  <a class="yiwenicon z30" desvalue="车船使用税解释说明" href="javascript:showjs('cheChuanTax');">?
                                      <div id="cheChuanTax" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">关闭</em> <strong>车船使用税</strong>
                                              <p>
                                              各省不统一，以北京为例(单位/年)。1.0L(含)以下300元；1.0-1.6L(含)420元；1.6-2.0L(含)480元；2.0-2.5L(含)900元；2.5-3.0L(含)1920元；3.0-4.0L(含)3480元；4.0L以上5280元；不足一年按当年剩余月算。<br>
                                              车船使用税是对行驶于公共道路的车辆和航行于国内河流、湖泊或领海口岸的船舶,按照其种类(如机动车辆、非机动车辆、载人汽车、载货汽车等)、吨位和规定的税额计算征收的一种使用行为税。
                                          </p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                      <tr>
                          <th>
                              <label>
                                  交强险</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <em>
                                      <label id="lblCompulsory">950</label>
                                  </em>元</div>
                          </td>
                          <td>
                              <select id="selCompulsorySelect" class="f-w150 f-curr" onchange="calcAutoCashAll();">
                                  <option value="950">家用6座以下</option>
                                  <option value="1100">家用6座及以上</option>
                              </select>
                          </td>
                          <td>
                              <span class="fl yiwen_box">国家强制保险 
                                  <a class="yiwenicon z30" desvalue="交强险解释说明" href="javascript:showjs('jiaoQiagnX');">?
                                      <div id="jiaoQiagnX" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">关闭</em> <strong>交强险</strong>
                                              <p>
                                              家用6座以下950元/年，家用6座及以上1100元/年<br>
                                              机动车交通事故责任强制保险是我国首个由国家法律规定实行的强制保险制度。《机动车交通事故责任强制保险条例》规定：交强险是由保险公司对被保险机动车发生道路交通事故造成受害人(不包括本车人员和被保险人)的人身伤亡、财产损失，在责任限额内予以赔偿的强制性责任保险。<br>
                                              交强险有责限额分为死亡伤残赔偿限额110000元、医疗费用赔偿限额10000元、财产损失赔偿限额2000元以及被保险人在道路交通事故中无责任的赔偿限额。无责的赔偿限额死亡伤残赔偿限额11000元、医疗费用赔偿限额1000元、财产损失赔偿限额100元。<br>
                                              责任限额是指被保险机动车发生道路交通事故，保险公司对每次保险事故所有受害人的人身伤亡和财产损失所承担的最高赔偿金额。
                                          </p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                  </tbody>
              </table>
          </div>
          <!-- 必要花费 结束 -->

          <!--商业保险 开始-->
<script type="text/javascript">
                        //车辆损失险 第三者责任险 不计免赔
                        function JiBenBaoZ() {
                            $('#chkTPL').prop("checked", true);
                            $('#chkCarDamage').prop("checked", true);
                            $('#chkAbatement').prop("checked", true);

                            $('#chkCarTheft').prop("checked", false);
                            $('#chkBreakageOfGlass').prop("checked", false);
                            $('#chkSelfignite').prop("checked", false);
                            $('#chkLimitofPassenger').prop("checked", false);
                            $('#chkLimitofDriver').prop("checked", false);
                            $('#chkCarDamageDW').prop("checked", false);
                            $('#chkEngine').prop("checked", false);

                            var commonTotal = 0;
                            if ($('#chkTPL').prop("checked")) {
                                commonTotal += parseFloat(jQuery('#lblTPL').html());
                            }
                            if ($('#chkCarDamage').prop("checked")) {
                                commonTotal += GetIntValue(jQuery('#lblCarDamage').html());
                            }
                            if ($('#chkAbatement').prop("checked")) {
                                commonTotal += GetIntValue(jQuery('#lblAbatement').html());
                            }
                            jQuery('#lblCommonTotal').html(Math.round(commonTotal));
                            calcAutoCashAll();
                        }
                        //第三者责任险 车辆损失险 不计免赔 乘客坐位责任险 司机坐位责任险
                        function GaoXingJ() {
                            $('#chkTPL').prop("checked", true);
                            $('#chkCarDamage').prop("checked", true);
                            $('#chkAbatement').prop("checked", true);
                            $('#chkLimitofPassenger').prop("checked", true);
                            $('#chkLimitofDriver').prop("checked", true);

                            $('#chkCarTheft').prop("checked", false);
                            $('#chkBreakageOfGlass').prop("checked", false);
                            $('#chkSelfignite').prop("checked", false);
                            $('#chkCarDamageDW').prop("checked", false);
                            $('#chkEngine').prop("checked", false);

                            var commonTotal = 0;
                            if ($('#chkTPL').prop("checked")) {
                                commonTotal += parseFloat(jQuery('#lblTPL').html());
                            }
                            if ($('#chkCarDamage').prop("checked")) {
                                commonTotal += GetIntValue(jQuery('#lblCarDamage').html());
                            }
                            if ($('#chkAbatement').prop("checked")) {
                                commonTotal += GetIntValue(jQuery('#lblAbatement').html());
                            }
                            if ($('#chkLimitofPassenger').prop("checked")) {
                                commonTotal += parseFloat(jQuery('#lblLimitOfPassenger').html());
                            }
                            if ($('#chkLimitofDriver').prop("checked")) {
                                commonTotal += parseFloat(jQuery('#lblLimitOfDriver').html());
                            }
                            jQuery('#lblCommonTotal').html(Math.round(commonTotal));
                            calcAutoCashAll();
                        }

                        function calcBusinessTotalIncludeState() {
                            $('#chkTPL').prop("checked", true);
                            $('#chkCarDamage').prop("checked", true);
                            $('#chkAbatement').prop("checked", true);
                            $('#chkLimitofPassenger').prop("checked", true);
                            $('#chkLimitofDriver').prop("checked", true);
                            $('#chkCarTheft').prop("checked", true);
                            $('#chkBreakageOfGlass').prop("checked", true);
                            $('#chkSelfignite').prop("checked", true);
                            $('#chkCarDamageDW').prop("checked", true);
                            $('#chkEngine').prop("checked", true);
                            //calcBusinessTotal();
                            calcAutoCashAll();
                        }
                    </script>

          <div class="jsq_com_box">
            <div class="titbox">
              <h4>商业保险</h4>
              <div class="red_num">
                <label id="lblCommonTotal">0</label>元
              </div>
              <div class="tab">
                <a href="javascript:void(0);" onclick="JiBenBaoZ()">基本保障</a> | <a href="javascript:void(0);" onclick="GaoXingJ()">高性价比</a> | <a href="javascript:void(0);" onclick="calcBusinessTotalIncludeState()">新车主全面保障</a>
              </div>
            </div>
            <table id="calBusiness" width="100%" cellspacing="0" cellpadding="0" border="0">
                <colgroup>
                    <col width="200px">
                    <col width="180px">
                    <col width="210px">
                    <col>
                </colgroup>
                <tbody>
                    <tr>
                        <th>
                            <input id="chkTPL" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkTPL">
                                第三者责任险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblTPL">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            <select id="selTPL" class="f-w100 f-curr" onchange="calcAutoCashAll();">
                                <option value="50000">5万</option>
                                <option value="100000">10万</option>
                                <option value="200000" selected="selected">20万</option>
                                <option value="500000">50万</option>
                                <option value="1000000">100万</option>
                            </select>
                            赔附额度
                        </td>
                        <td>
                            <span class="fl yiwen_box">发生车险事故时，赔偿对第三方造成的人身及财产损失 
                                <a class="yiwenicon z30" desvalue="第三者责任险解释说明" href="javascript:showjs('diSanFang');">?
                                    <div id="diSanFang" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>第三方责任险</strong>
                                            <p>
                                            第三者责任险是指被保险人或其允许的驾驶人员在使用保险车辆过程中发生意外事故，致使第三者遭受人身伤亡或财产直接损毁，依法应当由被保险人承担的经济责任，保险公司负责赔偿。同时，若经保险公司书面同意，被保险人因此发生仲裁或诉讼费用的，保险公司在责任限额以外赔偿，但最高不超过责任限额的30％。因为交强险在对第三者的财产损失和医疗费用部分赔偿较低，可考虑购买第三者责任险作为交强险的补充。</p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkCarDamage" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkCarDamage">
                                车辆损失险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarDamage">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            <span class="fl yiwen_box">车子发生碰撞，赔偿自己爱车损失的费用 
                                <a class="yiwenicon z30" desvalue="车辆损失险解释说明" href="javascript:showjs('sunshi');">?
                                    <div id="sunshi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>车辆损失险</strong>
                                            <p>
                                            车辆损失险-裸车价格*费率+基础保费<br>
                                            车辆损失险是车辆保险中用途最广泛的险种，它负责赔偿由于自然灾害和意外事故造成的自己车辆的损失。无论是小剐小蹭，还是损坏严重，都可以由保险公司来支付修理费用。<br>
                                            被保险人或其允许的合格驾驶员在使用保险车辆过程中，因下列原因造成保险车辆的损失，保险公司负责赔偿：1．碰撞、倾覆；2．火灾、爆炸；3．外界物体倒塌、空中运行物体坠落、保险车辆行驶中平行坠落；4．雷击、暴风、龙卷风、暴雨、洪水、海啸、地陷、冰陷、崖崩、雪崩、雹灾、泥石流、滑坡；5.
                                            载运保险车辆的渡船遭受自然灾害（只限于有驾驶员随车照料者）。<br>
                                            发生保险事故时，被保险人或其允许的合格驾驶员对保险车辆采取施救、保护措施所支出的合理费用，保险公司负责赔偿。但此项费用的最高赔偿金额以责任限额为限。
                                        </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkAbatement" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkAbatement">
                                不计免赔特约险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblAbatement">0</label>
                                </em>元</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">保险条款约定事故发生后被保险人要自己承担一定比例的损失金额，购买此险这部分损失费用保险公司将同样给予赔偿 
                                <a class="yiwenicon z30" desvalue="不计免赔特约险解释说明" href="javascript:showjs('mianPei');">?
                                    <div id="mianPei" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>不计免赔特约险</strong>
                                            <p>
                                                (车辆损失险+第三者责任险)×20%<br>
                                                负责赔偿在车损险和第三者责任险中应由被保险人自己承担的免赔金额，即100%赔付。<br>
                                                不计免赔特约险为附加险，必须在投保车损险和第三者责任险之后方可投保该险种。</p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkCarTheft" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkCarTheft">
                                全车盗抢险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarTheft">0</label>
                                </em>元</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">赔偿全车被盗窃、抢劫、抢夺造成的车辆损失 
                                <a class="yiwenicon z30" desvalue="全车盗抢险解释说明" href="javascript:showjs('daoQiang');">?
                                    <div id="daoQiang" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>全车盗抢险</strong>
                                            <p>
                                                全车盗抢险=裸车价格*费率+基础保费<br>
                                                指保险车辆全车被盗窃、被抢劫、被抢夺，经县级以上公安刑侦部门立案侦查证实满一定时间没有下落的，由保险公司在保险金额内予以赔偿。如果是车辆的某些零部件被盗抢，如轮胎被盗抢、车内财产被盗抢、后备箱内的物品丢失，保险公司均不负责赔偿。
                                                但是，对于车辆被盗抢期间内，保险车辆上零部件的损坏、丢失，保险公司一般负责赔偿。<br>
                                                全车盗抢险为附加险，必须在投保车辆损失险之后方可投保该险种。
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkBreakageOfGlass" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkBreakageOfGlass">
                                玻璃单独破碎险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblBreakageOfGlass">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            <select id="selBreakageOfGlass" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="1">国产</option>
                                <option value="0">进口</option>
                            </select>
                            赔附额度
                        </td>
                        <td>
                            <span class="fl yiwen_box">赔偿保险车辆在使用过程中，发生车窗、挡风玻璃的单独破碎损失 
                                <a class="yiwenicon z30" desvalue="玻璃单独破碎险解释说明" href="javascript:showjs('boLi');">?
                                    <div id="boLi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>玻璃单独破碎险</strong>
                                            <p>
                                                玻璃单独破碎险=裸车价格*费率<br>
                                                负责赔偿保险车辆在使用过程中，发生本车玻璃发生单独破碎的保险公司按照保险合同进行赔偿。玻璃单独破碎险中的玻璃是指风档玻璃和车窗玻璃，如果车灯、车镜玻璃破碎及车辆维修过程中造成的破碎，保险公司不承担赔偿责任。<br>
                                                玻璃单独破碎险为附加险，必须在投保车辆损失险之后方可投保该险种。
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkSelfignite" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkSelfignite">
                                自燃损失险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblSelfignite">0</label>
                                </em>元</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">赔偿车子因电器、线路、运载货物等自身原因引发火灾造成的损失 
                                <a class="yiwenicon z30" desvalue="自燃损失险解释说明" href="javascript:showjs('ziRan');">?
                                    <div id="ziRan" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>自燃损失险</strong>
                                            <p>
                                                自燃损失险=裸车价格×0.15%<br>
                                                负责赔偿因本车电器、线路、供油系统发生故障及运载货物自身原因起火造成车辆本身的损失。当车辆发生部分损失，按照实际修复费用赔偿修理费。如果车辆自燃造成整体烧毁或已经失去修理价值，则按照出险时车辆的实际价值赔偿，但不超过责任限额。
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkEngine" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkEngine">
                                涉水险/发动机特别损失险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="engineDamage">0</label>
                                </em>元</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">负责爱车被水淹导致改动机受损所造成的损失 
                                <a class="yiwenicon z30" desvalue="发动机特别损失险解释说明" href="javascript:showjs('faDongJi');">?
                                    <div id="faDongJi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>涉水险/发动机特别损失险</strong>
                                            <p>
                                                发动机特别损失险=车损险*5%<br>
                                                涉水险或称汽车损失保险、发动机特别损失险，各个保险公司叫法不一样但本质一致，这是一种新衍生的险种，均指车主为发动机购买的附加险。<br>
                                                这个险种主要是指车主为发动机购买的附加险。它主要是保障车辆在积水路面涉水行驶或被水淹后致使发动机损坏可给予赔偿。即使被水淹后车主还强行启动发动机而造成了损害，保险公司仍然给予赔偿。当然保险公司不一样，条款就不大一样，投保时可以查阅下各个保险公司条款内容。
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkCarDamageDW" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkCarDamageDW">
                                车身划痕险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarDamageDW">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            <select id="selCarDamageDW" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="2000">2千</option>
                                <option value="5000" selected="selected">5千</option>
                                <option value="10000">1万</option>
                                <option value="20000">2万</option>
                            </select>
                            赔附额度
                        </td>
                        <td>
                            <span class="fl yiwen_box">负责无碰撞痕迹的车身表面油漆单独划伤的损失 
                                <a class="yiwenicon z30" desvalue="车身划痕险解释说明" href="javascript:showjs('huaHen');">?
                                    <div id="huaHen" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>车身划痕险</strong>
                                            <p>
                                                无明显碰撞痕迹的车身划痕损失，保险公司负责赔偿。<br>
                                                车身划痕险为附加险，必须在投保车辆损失险之后方可投保该险种。
                                            </p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkLimitofDriver" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkLimitofDriver">
                                司机座位责任险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblLimitOfDriver">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            <select id="selLimitofDriver" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="10000">1万</option>
                                <option value="20000">2万</option>
                                <option value="30000">3万</option>
                                <option value="40000">4万</option>
                                <option value="50000">5万</option>
                            </select>
                            赔附额度
                        </td>
                        <td>
                            <span class="fl yiwen_box">发生车险事故时，赔偿车内司机的伤亡和医疗赔偿费用 
                                <a class="yiwenicon z30" desvalue="司机座位责任险解释说明" href="javascript:showjs('siJi');">?
                                    <div id="siJi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>司机坐位责任险</strong>
                                            <p>
                                                司机责任险=保额*费率<br>
                                                统称为车上责任险，包括司机座位和乘客座位，主要是指在发生意外情况下，保险公司对司机座位的人员和乘客的人身安全进行赔偿。<br>
                                                严格来说，司机责任险并不是一个独立的险种，而是商业车险中车上人员责任险的一部分，除此之外，车主还可以为乘客座位投保，一般选择的赔偿限额为1-5万元</p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <input id="chkLimitofPassenger" type="checkbox" checked="checked" onclick="calcAutoCashAll();">
                            <label for="chkLimitofPassenger">
                                乘客座位责任险</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblLimitOfPassenger">0</label>
                                </em>元</div>
                        </td>
                        <td>
                            <select id="selLimitofPassenger" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="10000">1万</option>
                                <option value="20000">2万</option>
                                <option value="30000">3万</option>
                                <option value="40000">4万</option>
                                <option value="50000">5万</option>
                            </select>
                            赔附额度
                        </td>
                        <td>
                            <span class="fl yiwen_box">发生车险事故时，赔偿车内乘客的伤亡和医疗赔偿费用 
                                <a class="yiwenicon z30" desvalue="乘客座位责任险解释说明" href="javascript:showjs('chengKe');">?
                                    <div id="chengKe" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">关闭</em> <strong>乘客坐位责任险</strong>
                                            <p>
                                                乘客责任险=保额*费率<br>
                                                被保险人允许的合格驾驶员在使用保险车辆过程中发生保险事故，致使车内乘客人身伤亡，依法应由被保险人承担的赔偿责任，保险人依照保险合同的约定给予赔偿。</p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                </tbody>
            </table>
          </div>
          
          
          
          <!--商业保险 结束-->
          
        </div>
      </div>
		</div>
	</div>

</@cc.html>