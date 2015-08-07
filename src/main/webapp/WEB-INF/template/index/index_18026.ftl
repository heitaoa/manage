<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "�����������������ۼ�����_2014���¹���������-������"  "���������������ṩ2014���¹��������������ۼ�����������������������O2O�����һƷ�ơ�" "����������,���ۼ�����">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
  <script>
  var flagx = false;
  $(function() {

    //����˵��
    $("a.yiwenicon.z30").bind("click", function (e) {
        $(".yiwenicon.z30").removeAttr("style"); //������������ʺŵ����
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
    		//����
    		flagx = false;
    		$("#txtChePai").val(500);
    		calcAutoCashAll();
		}
	});
	
}
//����
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
//��ʼ�����Ʒ�
function initChepai(){
	if(!flagx)
		$("#txtChePai").val(500)
}
function changeFlagx(){
	flagx=true;
}
function calcAutoCashAll()
{
	var totalMoeny = 0;//ȫ�����
	var essentialCost = 0;//��Ҫ����
	var businessCost = 0;//��ҵ����
	var money = $('#txtMoney').val();
	var gzs = 0;//����˰
	var spf = 0;//���Ʒ�
	var ccs = 0;//����˰
	var jqx = 0;//��ǿ��
	var tbl = 0;//������������
	var carDamage = 0;//������ʧ��
	var Abatement = 0;//����������Լ��
	var CarTheft = 0;//ȫ��������
	var BreakageOfGlass = 0;//����������
	var Selfignite = 0;//��ȼ��
	var engineDamage = 0;//�������ر���ʧ��
	var CarDamageDW = 0;//��������
	var LimitOfDriver = 0;//˾����λ������
	var LimitOfPassenger = 0;//�˿���λ������
	 if ($('#txtMoney').val() == 0) 
	 {
                //document.getElementById('lblShouFu').innerHTML = 0; //�׸�
                //document.getElementById('lblYueGong').innerHTML = 0; //�¹�
                document.getElementById('lblAcquisitionTax').innerHTML = 0;//����˰
                $('#txtVehicleTax').val(0); //����ʹ��˰
                document.getElementById('lblCompulsory').innerHTML = 0; //��ǿ��
                document.getElementById('lblCommonTotal').innerHTML = 0; //��Ҫ����
                document.getElementById('lblTPL').innerHTML = 0; //������������
                document.getElementById('lblCarDamage').innerHTML = 0; //������ʧ��
                document.getElementById('lblCarTheft').innerHTML = 0; //ȫ��������
                document.getElementById('lblBreakageOfGlass').innerHTML = 0; //����������
                document.getElementById('lblSelfignite').innerHTML = 0; //��ȼ��
                document.getElementById('lblAbatement').innerHTML = 0; //����������Լ��
                document.getElementById('lblCarDamageDW').innerHTML = 0; //��������
                document.getElementById('lblLimitOfPassenger').innerHTML = 0; //�˿���λ������
                document.getElementById('lblLimitOfDriver').innerHTML = 0; //˾����λ������
                document.getElementById('engineDamage').innerHTML = 0; //�������ر���ʧ��
                $('#txtChePai').val(0); //���Ʒ���
                document.getElementById('essentialCost').innerHTML = 0; //��Ҫ����
                $("#liDispaly1").show();
				$("#liDispaly2").hide();
                return;
     }
    
    gzs = calcAcquisitionTax();//����˰
	spf = caclChePaiTax();//���Ʒ�
	ccs = caclVehicleTax();//����˰
	jqx = caclCompulsoryTax();//��ǿ��
	tbl = calcTPL();//������������
	carDamage = calcCarDamage();//������ʧ��
	Abatement = calcAbatement();//����������Լ��
	CarTheft = calcCarTheft();//ȫ��������
	BreakageOfGlass = calcBreakageOfGlass();//����������
	Selfignite = calcSelfignite(); //��ȼ��
	engineDamage =  calcCarEngineDamage();//�������ر���ʧ��
	CarDamageDW = calcCarDamageDW();//��������
	LimitOfDriver = calcLimitofDriver();//˾����λ������
	LimitOfPassenger = calcLimitofPassenger();//�˿���λ������
	essentialCost = parseInt(gzs) + parseInt(spf) + parseInt(ccs) +parseInt(jqx);
	businessCost = parseInt(tbl)+parseInt(carDamage)+parseInt(Abatement)+parseInt(CarTheft)+parseInt(BreakageOfGlass)+parseInt(Selfignite)+parseInt(engineDamage)+parseInt(CarDamageDW)+parseInt(LimitOfDriver)+parseInt(LimitOfPassenger);
	totalMoeny = essentialCost + businessCost + parseInt(money);
	SetSpanValueByBrowerType("essentialCost", formatCurrency(essentialCost));
	SetSpanValueByBrowerType("lblTopTotal", formatCurrency(totalMoeny));
	SetSpanValueByBrowerType("lblCommonTotal", formatCurrency(businessCost));
	//�׸�
    //calcShouFu(essentialCost,businessCost);
	//�¹�
    //calcYueGong();

	$("#liDispaly1").hide();
	$("#liDispaly2").show();
}

//��Ҫ������
//����˰�����ø���˰���������1��17������ ����˰�ʣ�˰�ʣ�10%��
function calcAcquisitionTax() {
    var acquisitionTax = parseFloat($('#txtMoney').val()) / (1 + 0.17) * 0.1;
    var result = Math.round(acquisitionTax);
    SetSpanValueByBrowerType("lblAcquisitionTax", formatCurrency(result));
    return result;
}
//���Ʒ�
function caclChePaiTax(){
	var money = parseInt($('#txtMoney').val());
	var result = 0;
	if(money>0)
		result = $("#txtChePai").val();
	//$("#txtChePai").val(result)
    return result;
}
//����˰
function caclVehicleTax(){
	var result = 0;
	result = $("#vehicleTaxSelect").children('option:selected').val();
	$("#txtVehicleTax").val(result)
    return result;
}
//��ǿ��
function caclCompulsoryTax(){
	var result = 0;
	result = $("#selCompulsorySelect").children('option:selected').val();
	SetSpanValueByBrowerType("lblCompulsory", formatCurrency(result));
    return result;
}

//��ҵ������
//������������
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
//������ʧ��
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
//����������Լ��
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
//ȫ��������
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
//��������������
function calcBreakageOfGlass() {
	var result = 0 ;
    if ($('#chkBreakageOfGlass').prop("checked")) {
        var breakageOfGlassValue = document.getElementById("selBreakageOfGlass").value;
        var selCompulsoryIndex = document.getElementById("selCompulsorySelect").selectedIndex;
        if (breakageOfGlassValue == 0)//����
        	//6-10���ͳ�
            if (selCompulsoryIndex == 1) { 
                SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.003)));
                result = Math.round($('#txtMoney').val() * 0.003);
            } else {
                SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.0031)));
                result = Math.round($('#txtMoney').val() * 0.0031);
            }
        //����
        if (breakageOfGlassValue == 1){
            SetSpanValueByBrowerType('lblBreakageOfGlass', formatCurrency(Math.round($('#txtMoney').val() * 0.0019)));
            result = Math.round($('#txtMoney').val() * 0.0019);
        }
    } else {
        jQuery("#lblBreakageOfGlass").html("0");
    }
    return result;
}
//��ȼ��ʧ��
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
//�������ر���ʧ��(������*5%)
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
//��������
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
//�˿������գ�//��ѡ���*����*����λ��-1�������û����λ������*4��
function calcLimitofPassenger() {
	var result = 0;
    if ($('#chkLimitofPassenger').prop("checked")) {
        if (jQuery('#selCompulsorySelect').prop('selectedIndex') == 0) { //6������
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
//˾��������
function calcLimitofDriver() {
	var result = 0;
    if ($('#chkLimitofDriver').prop("checked")) {
        if (jQuery('#selCompulsorySelect').prop('selectedIndex') == 0) {//6������
            //��ѡ���*����*����λ��-1�������û����λ������*4
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
 //�׸�(��Ҫ����+��ҵ����+�㳵��*30%)
function calcShouFu(essentialCost,businessTotal) {
            var shouFu = essentialCost + businessTotal + Math.round($('#txtMoney').val() * 0.3);
            SetSpanValueByBrowerType("lblShouFu", formatCurrency(shouFu));
            return shouFu;
}
//�¹�(��3�� �׸�30%����)  ����ֵ�ɲο�"�����������ĵ�"
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
			<a href="${www_ct_url}">����</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">��������</a>&gt;<a class="active" href="javascript:void(0);">��������</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 5/>
			</div>
			 <div class="line-box">
        <div class="title-con">
          <div class="title-box title-box2">
            <h4>ѡ�񳵿�</h4>
            <div class="tableHead_item">
              <div class="selc">
                <em class="seltiptxt">Ʒ��</em>
               <div style="z-index:60;" class="select select-tools">
							<div class="select-selected" name = "mainTree">
								<span>��ѡ��Ʒ��</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="display:none;" class="select-option">
								<dl>
									<dd>
										<b>A</b>
										<a href="">����������ŷ</a>
									</dd>

								</dl>
							</div>
						</div>
                        </div>
              
              <div class="selc">
                    	<em class="seltiptxt">��ϵ</em>
                    	<div style="z-index:50;" class="select select-tools select-disabled">
							<div class="select-selected" name = "lineTree">
								<span>��ѡ��ϵ��</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="display:none;" class="select-option">
								<dl>
									<dt>��������</dt>
									<dd><a href="">����3ϵ</a></dd>
									<dd><a href="">����5ϵ</a></dd>
									<dd><a href="">����X1</a></dd>
								</dl>
							</div>
						</div> 
                        </div>
              
               <div style="width:350px;" class="selc">
                    	<em class="seltiptxt">����</em>
                    	<div style="width:300px;z-index:40;" class="select select-tools select-disabled">
							<div class="select-selected" name = "typeTree" id = "0">
								<span>��ѡ����</span>
								<i class="icon-select-arrows"></i>
							</div>
							<div style="width:346px;display:none;" class="select-option">
								<dl>
									<dt>2014��</dt>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
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
                      <span class="fl">�㳵�۸�</span> <span class="fonts1">
                          <input id="txtMoney" type="text" class="f-w100" maxlength="8" value="0" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';};initChepai();calcAutoCashAll();" onkeyup="value=value.replace(/(\D)/g,'');initChepai();calcAutoCashAll();" onchange="value=value.replace(/(\D)/g,'');initChepai();calcAutoCashAll();">
                          Ԫ</span>
                  </div>
                  <div class="r-box">
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly1" class="bg" style="display:none;">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          <em>��ѡ�񳵿�������㳵�۸�</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly2" style="background: rgb(247, 247, 247);" class="">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          ȫ����ۣ�<em class="red16"><label id="lblTopTotal">0</label>
                              Ԫ</em></p>
                      <p class="suomin">
                         </p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
            </ul>
            <p class="txt_right">�˽�������ο���ʵ��Ӧ�ɷ��Ե���Ϊ׼</p>
          </div>

          <!-- ��Ҫ���� ��ʼ -->
          <div class="jsq_com_box">
              <div class="titbox">
                  <h4>��Ҫ����</h4>
                  <div class="red_num">
                    <label id="essentialCost">0</label>Ԫ
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
                              <label>����˰</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                <em><label id="lblAcquisitionTax">0</label></em>Ԫ
                              </div>
                          </td>
                          <td>
                              &nbsp;
                          </td>
                          <td>
                              <span class="fl yiwen_box">���ø���˰=�㳵�۸�£�1��17������ 10% 
                                  <a class="yiwenicon z30" desvalue="����˰����˵��" href="javascript:showjs('AcquisitionTax');">?
                                      <div id="AcquisitionTax" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">�ر�</em> <strong>����˰</strong>
                                              <p>
                                                  ��������˰�Ƕ����ҹ����ڹ��ù涨�����ĵ�λ�͸������յ�һ��˰�����ɳ������ø��ӷ��ݱ���������г�������˰���Ļ����淶���Ǵ�2001��1��1����ʵʩ�ġ��л����񹲺͹���������˰��������������������˰����˰��Ϊ���ã��������򡢽��ڡ��Բ����������񽱻���������ʽȡ�ò����ã�Ӧ˰�����ĵ�λ�͸��ˣ���˰��ΧΪ������Ħ�г����糵���ҳ���ũ�����䳵��˰��Ϊ10%��Ӧ��˰��ļ��㹫ʽΪ��Ӧ��˰��=��˰�۸��˰�ʡ���2009��1��20����12��31�գ���1.6���������������ó�����5%���ճ�������˰����2010��1��1����12��31�գ���1.6���������������ó�����7.5%���ճ�������˰����</p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                      <tr>
                          <th>
                              <label>���Ʒ���</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <input maxlength="4" id="txtChePai" class="f-w100 f-curr" type="text" value="500" onkeyup="value=value.replace(/(\D)/g,'');changeFlagx();calcAutoCashAll();" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';};changeFlagx();calcAutoCashAll();">
                                  Ԫ</div>
                          </td>
                          <td>
                              &nbsp;
                          </td>
                          <td>
                              <span class="fl yiwen_box">���ֶ��޸ģ���ͬ�������ò�ͬ 
                                  <a class="yiwenicon z30" desvalue="���Ʒ��ý���˵��" href="javascript:showjs('shangPai');">?
                                      <div id="shangPai" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">�ر�</em> <strong>���Ʒ���</strong>
                                              <p>
                                              ͨ���̼��ṩ��һ���������շ�Լ500Ԫ�����˰���Լ373Ԫ�����й�����֤������150Ԫ���ƶ�֤30Ԫ��������3Ԫ���غŷ�40Ԫ����ʻ֤��Ƭ20Ԫ�����̷�130Ԫ</p>
                                          </div>
                                      </div>
                                  </a>
                              </span>
                          </td>
                      </tr>
                      <tr>
                          <th>
                              <label>����ʹ��˰</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <input id="txtVehicleTax" class="f-w100 f-curr" value="0" type="text" maxlength="4" onkeyup="value=value.replace(/(\D)/g,'');calcAutoCashAll();" onfocus="if (value =='0'){value ='';}" onblur="if (value ==''){value='0';}calcAutoCashAll();">
                                  Ԫ</div>
                          </td>
                          <td id="divCashVehicleAndVesselTaxMessage">
                            <select id="vehicleTaxSelect" class="f-w150 f-curr" onchange="calcAutoCashAll();">
                              <option value="300">1.0L(��)����</option>
                              <option value="420" selected="selected">1.0-1.6L(��)</option>
                              <option value="480">1.6-2.0L(��)</option>
                              <option value="900">2.0-2.5L(��)</option>
                              <option value="1920">2.5-3.0L(��)</option>
                              <option value="3480">3.0-4.0L(��)</option>
                              <option value="5280">4.0L����</option>
                            </select>
                          </td>
                          <td>
                              <span class="fl yiwen_box">��������ȡ���� 
                                  <a class="yiwenicon z30" desvalue="����ʹ��˰����˵��" href="javascript:showjs('cheChuanTax');">?
                                      <div id="cheChuanTax" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">�ر�</em> <strong>����ʹ��˰</strong>
                                              <p>
                                              ��ʡ��ͳһ���Ա���Ϊ��(��λ/��)��1.0L(��)����300Ԫ��1.0-1.6L(��)420Ԫ��1.6-2.0L(��)480Ԫ��2.0-2.5L(��)900Ԫ��2.5-3.0L(��)1920Ԫ��3.0-4.0L(��)3480Ԫ��4.0L����5280Ԫ������һ�갴����ʣ�����㡣<br>
                                              ����ʹ��˰�Ƕ���ʻ�ڹ�����·�ĳ����ͺ����ڹ��ں������������캣�ڰ��Ĵ���,����������(������������ǻ��������������������ػ�������)����λ�͹涨��˰��������յ�һ��ʹ����Ϊ˰��
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
                                  ��ǿ��</label>
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <em>
                                      <label id="lblCompulsory">950</label>
                                  </em>Ԫ</div>
                          </td>
                          <td>
                              <select id="selCompulsorySelect" class="f-w150 f-curr" onchange="calcAutoCashAll();">
                                  <option value="950">����6������</option>
                                  <option value="1100">����6��������</option>
                              </select>
                          </td>
                          <td>
                              <span class="fl yiwen_box">����ǿ�Ʊ��� 
                                  <a class="yiwenicon z30" desvalue="��ǿ�ս���˵��" href="javascript:showjs('jiaoQiagnX');">?
                                      <div id="jiaoQiagnX" class="tc tc-jsq" style="display: none;">
                                          <div class="tc-box">
                                              <i></i><em class="close">�ر�</em> <strong>��ǿ��</strong>
                                              <p>
                                              ����6������950Ԫ/�꣬����6��������1100Ԫ/��<br>
                                              ��������ͨ�¹�����ǿ�Ʊ������ҹ��׸��ɹ��ҷ��ɹ涨ʵ�е�ǿ�Ʊ����ƶȡ�����������ͨ�¹�����ǿ�Ʊ����������涨����ǿ�����ɱ��չ�˾�Ա����ջ�����������·��ͨ�¹�����ܺ���(������������Ա�ͱ�������)�������������Ʋ���ʧ���������޶��������⳥��ǿ�������α��ա�<br>
                                              ��ǿ�������޶��Ϊ�����˲��⳥�޶�110000Ԫ��ҽ�Ʒ����⳥�޶�10000Ԫ���Ʋ���ʧ�⳥�޶�2000Ԫ�Լ����������ڵ�·��ͨ�¹��������ε��⳥�޶������⳥�޶������˲��⳥�޶�11000Ԫ��ҽ�Ʒ����⳥�޶�1000Ԫ���Ʋ���ʧ�⳥�޶�100Ԫ��<br>
                                              �����޶���ָ�����ջ�����������·��ͨ�¹ʣ����չ�˾��ÿ�α����¹������ܺ��˵����������ͲƲ���ʧ���е�������⳥��
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
          <!-- ��Ҫ���� ���� -->

          <!--��ҵ���� ��ʼ-->
<script type="text/javascript">
                        //������ʧ�� ������������ ��������
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
                        //������������ ������ʧ�� �������� �˿���λ������ ˾����λ������
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
              <h4>��ҵ����</h4>
              <div class="red_num">
                <label id="lblCommonTotal">0</label>Ԫ
              </div>
              <div class="tab">
                <a href="javascript:void(0);" onclick="JiBenBaoZ()">��������</a> | <a href="javascript:void(0);" onclick="GaoXingJ()">���Լ۱�</a> | <a href="javascript:void(0);" onclick="calcBusinessTotalIncludeState()">�³���ȫ�汣��</a>
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
                                ������������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblTPL">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            <select id="selTPL" class="f-w100 f-curr" onchange="calcAutoCashAll();">
                                <option value="50000">5��</option>
                                <option value="100000">10��</option>
                                <option value="200000" selected="selected">20��</option>
                                <option value="500000">50��</option>
                                <option value="1000000">100��</option>
                            </select>
                            �⸽���
                        </td>
                        <td>
                            <span class="fl yiwen_box">���������¹�ʱ���⳥�Ե�������ɵ������Ʋ���ʧ 
                                <a class="yiwenicon z30" desvalue="�����������ս���˵��" href="javascript:showjs('diSanFang');">?
                                    <div id="diSanFang" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>������������</strong>
                                            <p>
                                            ��������������ָ�������˻�������ļ�ʻ��Ա��ʹ�ñ��ճ��������з��������¹ʣ���ʹ��������������������Ʋ�ֱ����٣�����Ӧ���ɱ������˳е��ľ������Σ����չ�˾�����⳥��ͬʱ���������չ�˾����ͬ�⣬����������˷����ٲû����Ϸ��õģ����չ�˾�������޶������⳥������߲����������޶��30������Ϊ��ǿ���ڶԵ����ߵĲƲ���ʧ��ҽ�Ʒ��ò����⳥�ϵͣ��ɿ��ǹ����������������Ϊ��ǿ�յĲ��䡣</p>
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
                                ������ʧ��</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarDamage">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            <span class="fl yiwen_box">���ӷ�����ײ���⳥�Լ�������ʧ�ķ��� 
                                <a class="yiwenicon z30" desvalue="������ʧ�ս���˵��" href="javascript:showjs('sunshi');">?
                                    <div id="sunshi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>������ʧ��</strong>
                                            <p>
                                            ������ʧ��-�㳵�۸�*����+��������<br>
                                            ������ʧ���ǳ�����������;��㷺�����֣��������⳥������Ȼ�ֺ��������¹���ɵ��Լ���������ʧ��������С��С�䣬���������أ��������ɱ��չ�˾��֧��������á�<br>
                                            �������˻�������ĺϸ��ʻԱ��ʹ�ñ��ճ��������У�������ԭ����ɱ��ճ�������ʧ�����չ�˾�����⳥��1����ײ���㸲��2�����֡���ը��3��������嵹����������������׹�䡢���ճ�����ʻ��ƽ��׹�䣻4���׻������硢����硢���ꡢ��ˮ����Х�����ݡ����ݡ��±���ѩ�������֡���ʯ�������£�5.
                                            ���˱��ճ����Ķɴ�������Ȼ�ֺ���ֻ�����м�ʻԱ�泵�����ߣ���<br>
                                            ���������¹�ʱ���������˻�������ĺϸ��ʻԱ�Ա��ճ�����ȡʩ�ȡ�������ʩ��֧���ĺ�����ã����չ�˾�����⳥����������õ�����⳥����������޶�Ϊ�ޡ�
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
                                ����������Լ��</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblAbatement">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">��������Լ���¹ʷ����󱻱�����Ҫ�Լ��е�һ����������ʧ����������ⲿ����ʧ���ñ��չ�˾��ͬ�������⳥ 
                                <a class="yiwenicon z30" desvalue="����������Լ�ս���˵��" href="javascript:showjs('mianPei');">?
                                    <div id="mianPei" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>����������Լ��</strong>
                                            <p>
                                                (������ʧ��+������������)��20%<br>
                                                �����⳥�ڳ����պ͵�������������Ӧ�ɱ��������Լ��е����������100%�⸶��<br>
                                                ����������Լ��Ϊ�����գ�������Ͷ�������պ͵�����������֮�󷽿�Ͷ�������֡�</p>
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
                                ȫ��������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarTheft">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">�⳥ȫ�������ԡ����١�������ɵĳ�����ʧ 
                                <a class="yiwenicon z30" desvalue="ȫ�������ս���˵��" href="javascript:showjs('daoQiang');">?
                                    <div id="daoQiang" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>ȫ��������</strong>
                                            <p>
                                                ȫ��������=�㳵�۸�*����+��������<br>
                                                ָ���ճ���ȫ�������ԡ������١������ᣬ���ؼ����Ϲ������첿���������֤ʵ��һ��ʱ��û������ģ��ɱ��չ�˾�ڱ��ս���������⳥������ǳ�����ĳЩ�㲿��������������̥�����������ڲƲ��������������ڵ���Ʒ��ʧ�����չ�˾���������⳥��
                                                ���ǣ����ڳ����������ڼ��ڣ����ճ������㲿�����𻵡���ʧ�����չ�˾һ�㸺���⳥��<br>
                                                ȫ��������Ϊ�����գ�������Ͷ��������ʧ��֮�󷽿�Ͷ�������֡�
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
                                ��������������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblBreakageOfGlass">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            <select id="selBreakageOfGlass" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="1">����</option>
                                <option value="0">����</option>
                            </select>
                            �⸽���
                        </td>
                        <td>
                            <span class="fl yiwen_box">�⳥���ճ�����ʹ�ù����У��������������粣���ĵ���������ʧ 
                                <a class="yiwenicon z30" desvalue="�������������ս���˵��" href="javascript:showjs('boLi');">?
                                    <div id="boLi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>��������������</strong>
                                            <p>
                                                ��������������=�㳵�۸�*����<br>
                                                �����⳥���ճ�����ʹ�ù����У�������������������������ı��չ�˾���ձ��պ�ͬ�����⳥�����������������еĲ�����ָ�絵�����ͳ���������������ơ������������鼰����ά�޹�������ɵ����飬���չ�˾���е��⳥���Ρ�<br>
                                                ��������������Ϊ�����գ�������Ͷ��������ʧ��֮�󷽿�Ͷ�������֡�
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
                                ��ȼ��ʧ��</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblSelfignite">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">�⳥�������������·�����ػ��������ԭ������������ɵ���ʧ 
                                <a class="yiwenicon z30" desvalue="��ȼ��ʧ�ս���˵��" href="javascript:showjs('ziRan');">?
                                    <div id="ziRan" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>��ȼ��ʧ��</strong>
                                            <p>
                                                ��ȼ��ʧ��=�㳵�۸��0.15%<br>
                                                �����⳥�򱾳���������·������ϵͳ�������ϼ����ػ�������ԭ�������ɳ����������ʧ������������������ʧ������ʵ���޸������⳥����ѡ����������ȼ��������ջٻ��Ѿ�ʧȥ�����ֵ�����ճ���ʱ������ʵ�ʼ�ֵ�⳥���������������޶
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
                                ��ˮ��/�������ر���ʧ��</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="engineDamage">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                        </td>
                        <td>
                            <span class="fl yiwen_box">���𰮳���ˮ�͵��¸Ķ�����������ɵ���ʧ 
                                <a class="yiwenicon z30" desvalue="�������ر���ʧ�ս���˵��" href="javascript:showjs('faDongJi');">?
                                    <div id="faDongJi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>��ˮ��/�������ر���ʧ��</strong>
                                            <p>
                                                �������ر���ʧ��=������*5%<br>
                                                ��ˮ�ջ��������ʧ���ա��������ر���ʧ�գ��������չ�˾�з���һ��������һ�£�����һ�������������֣���ָ����Ϊ����������ĸ����ա�<br>
                                                ���������Ҫ��ָ����Ϊ����������ĸ����ա�����Ҫ�Ǳ��ϳ����ڻ�ˮ·����ˮ��ʻ��ˮ�ͺ���ʹ�������𻵿ɸ����⳥����ʹ��ˮ�ͺ�����ǿ��������������������𺦣����չ�˾��Ȼ�����⳥����Ȼ���չ�˾��һ��������Ͳ���һ����Ͷ��ʱ���Բ����¸������չ�˾�������ݡ�
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
                                ��������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblCarDamageDW">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            <select id="selCarDamageDW" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="2000">2ǧ</option>
                                <option value="5000" selected="selected">5ǧ</option>
                                <option value="10000">1��</option>
                                <option value="20000">2��</option>
                            </select>
                            �⸽���
                        </td>
                        <td>
                            <span class="fl yiwen_box">��������ײ�ۼ��ĳ���������ᵥ�����˵���ʧ 
                                <a class="yiwenicon z30" desvalue="�������ս���˵��" href="javascript:showjs('huaHen');">?
                                    <div id="huaHen" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>��������</strong>
                                            <p>
                                                ��������ײ�ۼ��ĳ�������ʧ�����չ�˾�����⳥��<br>
                                                ��������Ϊ�����գ�������Ͷ��������ʧ��֮�󷽿�Ͷ�������֡�
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
                                ˾����λ������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblLimitOfDriver">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            <select id="selLimitofDriver" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="10000">1��</option>
                                <option value="20000">2��</option>
                                <option value="30000">3��</option>
                                <option value="40000">4��</option>
                                <option value="50000">5��</option>
                            </select>
                            �⸽���
                        </td>
                        <td>
                            <span class="fl yiwen_box">���������¹�ʱ���⳥����˾����������ҽ���⳥���� 
                                <a class="yiwenicon z30" desvalue="˾����λ�����ս���˵��" href="javascript:showjs('siJi');">?
                                    <div id="siJi" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>˾����λ������</strong>
                                            <p>
                                                ˾��������=����*����<br>
                                                ͳ��Ϊ���������գ�����˾����λ�ͳ˿���λ����Ҫ��ָ�ڷ�����������£����չ�˾��˾����λ����Ա�ͳ˿͵�����ȫ�����⳥��<br>
                                                �ϸ���˵��˾�������ղ�����һ�����������֣�������ҵ�����г�����Ա�����յ�һ���֣�����֮�⣬����������Ϊ�˿���λͶ����һ��ѡ����⳥�޶�Ϊ1-5��Ԫ</p>
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
                                �˿���λ������</label>
                        </th>
                        <td class="r_align">
                            <div class="jiage">
                                <em>
                                    <label id="lblLimitOfPassenger">0</label>
                                </em>Ԫ</div>
                        </td>
                        <td>
                            <select id="selLimitofPassenger" class="f-w100 f-curr" onchange="calcAutoCashAll()">
                                <option value="10000">1��</option>
                                <option value="20000">2��</option>
                                <option value="30000">3��</option>
                                <option value="40000">4��</option>
                                <option value="50000">5��</option>
                            </select>
                            �⸽���
                        </td>
                        <td>
                            <span class="fl yiwen_box">���������¹�ʱ���⳥���ڳ˿͵�������ҽ���⳥���� 
                                <a class="yiwenicon z30" desvalue="�˿���λ�����ս���˵��" href="javascript:showjs('chengKe');">?
                                    <div id="chengKe" class="tc tc-jsq" style="display: none">
                                        <div class="tc-box">
                                            <i></i><em class="close">�ر�</em> <strong>�˿���λ������</strong>
                                            <p>
                                                �˿�������=����*����<br>
                                                ������������ĺϸ��ʻԱ��ʹ�ñ��ճ��������з��������¹ʣ���ʹ���ڳ˿���������������Ӧ�ɱ������˳е����⳥���Σ����������ձ��պ�ͬ��Լ�������⳥��</p>
                                        </div>
                                    </div>
                                </a>
                            </span>
                        </td>
                    </tr>
                </tbody>
            </table>
          </div>
          
          
          
          <!--��ҵ���� ����-->
          
        </div>
      </div>
		</div>
	</div>

</@cc.html>