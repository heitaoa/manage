<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "【车险计算器】汽车保险计算器_2014最新车险计算器-车团网"  "车团网购车工具提供2014最新车险计算器，汽车保险计算器，车团网，汽车电商O2O服务第一品牌。" "车险计算器,汽车保险计算器">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
<script>
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
  	$(document).click(function(){
		$(".select-option").hide();
		$(".select").removeClass("btn-packup");
	})
	
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
  
  })
  
function onGetClick(catalogid,setid){

	$.ajax({
		url : '${www_ct_url}chetuan/getPrice',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		data:{catalogid:catalogid},
		success : function(data){
    		$("#txtMoney").val(parseInt((data.p2)*10000));
    		$("#txtMoney").change();
		}
	});
}
  
  
  </script>
  
  
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
        dataReload();
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
        dataReload();
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
        dataReload();
    }
    
    function dataReload(){
    
    	var value0 = 0;
		var value1 = 0;
		var value2 = 0;
		var value3 = 0;
		var value4 = 0;
		var value5 = 0;
		var value6 = 0;
		var value7 = 0;
		var value8 = 0;
		var value9 = 0;
		var value10 = 0;
		
    	var sel1 = $("#selCompulsory").val();
    	var sel2 = $("#selTPL").val();
    	var sel3 = $("#selBreakageOfGlass").val();
    	var sel4 = $("#selCarDamageDW").val();
    	var sel5 = $("#selLimitofDriver").val();
    	var sel6 = $("#selLimitofPassenger").val();
    	
    	var ck1 = $("#chkTPL")[0].checked;
		var ck2 = $("#chkCarDamage")[0].checked;
		var ck3 = $("#chkAbatement")[0].checked;
		var ck4 = $("#chkCarTheft")[0].checked;
		var ck5 = $("#chkBreakageOfGlass")[0].checked;
		var ck6 = $("#chkSelfignite")[0].checked;
		var ck7 = $("#chkEngine")[0].checked;
		var ck8 = $("#chkCarDamageDW")[0].checked;
		var ck9 = $("#chkLimitofDriver")[0].checked;
		var ck10 = $("#chkLimitofPassenger")[0].checked;
		
		var buyCarPrice = 0;
		if($("#txtMoney").val() != ""){
			buyCarPrice = parseInt($("#txtMoney").val());
		}
		
		if(buyCarPrice == 0){
			$("#lblCompulsory").html(parseInt(value0));
			$("#lblTPL").html(parseInt(value1));
			$("#lblCarDamage").html(parseInt(value2));
			$("#lblAbatement").html(parseInt(value3));
			$("#lblCarTheft").html(parseInt(value4));
			$("#lblBreakageOfGlass").html(parseInt(value5));
			$("#lblSelfignite").html(parseInt(value6));
			$("#engineDamage").html(parseInt(value7));
			$("#lblCarDamageDW").html(parseInt(value8));
			$("#lblLimitOfDriver").html(parseInt(value9));
			$("#lblLimitOfPassenger").html(parseInt(value10));
			$("#lblTotalCompulsory").html(0);
			$("#lblCommonTotal").html(parseInt(0));
			$("#lblMarket").html(parseInt(0));
			$("#liDispaly1").show();
			$("#liDispaly2").hide();
		
		}else{
			//交强险 
			if(sel1 == 950){
				value0 = 950;
			}else{
				value0 = 1100;
			}
		
			//第三者责任险
			if(ck1){
				if(sel1 == 950){
					switch (parseInt(sel2)) {
		                case 50000:
		                    value1 = 710;
		                    break;
		                case 100000:
		                    value1 = 1026;
		                    break;
		                case 200000:
		                    value1 = 1270;
		                    break;
		                case 500000:
		                    value1 = 1721;
		                    break;
		                case 1000000:
		                    value1 = 2242;
		                    break;
		                default:
		                    value1 = 746;
		            }
		            
				}else{
					switch (parseInt(sel2)) {
		                case 50000:
		                    value1 = 659;
		                    break;
		                case 100000:
		                    value1 = 928;
		                    break;
		                case 200000:
		                    value1 = 1131;
		                    break;
		                case 500000:
		                    value1 = 1507;
		                    break;
		                case 1000000:
		                    value1 = 1963;
		                    break;
		                default:
		                    value1 = 674;
		            }
		            
				}
			}
			
			//车辆损失险
			if(ck2){
			 	var rate = 0.0095;
				var base = 285;
		        if (sel1 == 1100) {
		        	rate = 0.009;
		            base = 342;
		        }
		        value2 = base + buyCarPrice * rate;
			}
			
			//不计免赔特约险
			if(ck3){
            	value3 = (value1 + value2) * 0.2;
        	}
        	
        	//全车盗抢险
        	if(ck4){
				if (sel1 == 1100) {
		            value4 = 140 + buyCarPrice * 0.0044;
		        } else {
		            value4 = 120 + buyCarPrice * 0.0049;
		        }  
			}
			
			//玻璃单独破碎险
			if(ck5){
			 	if (sel3 == 1) {
			 		value5 = buyCarPrice * 0.0019;
		        } else {
		        	if(sel1 == 950){
		        		value5 = buyCarPrice * 0.0031;
		        	}else{
		        		value5 = buyCarPrice * 0.003;
		        	}
		            
		        }	
			}
			
			//自燃损失险
			if(ck6){
				value6 = buyCarPrice * 0.0015;
			}
			
			
			//涉水险/发动机特别损失险
			if(ck7){
				value7 = parseInt(value2) * 0.05;
			}
			
			//车身划痕险
			if(ck2 && ck8){
		        var selCarDamageDWIndex = document.getElementById("selCarDamageDW").selectedIndex;
		        if (buyCarPrice < 300000) {
		            if (selCarDamageDWIndex == 0)
		                value8 = 400
		            if (selCarDamageDWIndex == 1)
		                value8 = 570
		            if (selCarDamageDWIndex == 2)
		                value8 = 760
		            if (selCarDamageDWIndex == 3)
		                value8 = 1140
		        } else if (buyCarPrice > 500000) {
		            if (selCarDamageDWIndex == 0)
		                value8 = 850
		            if (selCarDamageDWIndex == 1)
		                value8 = 1100
		            if (selCarDamageDWIndex == 2)
		                value8 = 1500
		            if (selCarDamageDWIndex == 3)
		                value8 = 2250
		        } else {
		            if (selCarDamageDWIndex == 0)
		                value8 = 585
		            if (selCarDamageDWIndex == 1)
		                value8 = 900
		            if (selCarDamageDWIndex == 2)
		                value8 = 1170
		            if (selCarDamageDWIndex == 3)
		                value8 = 1780
		        }
			}
			//司机座位责任险
			if(ck9){
				if(sel1 == 950){
					value9 = parseInt(sel5) * 0.0042;
				}else{
					value9 = parseInt(sel5) * 0.004;
				}
			}
			//乘客座位责任险
			if(ck10){
				if(sel1 == 950){
					value10 = parseInt(sel6) * 0.0027 * 4;
				}else{
					value10 = parseInt(sel6) * 0.0026 * 8;
				}
			}
			
			$("#lblCompulsory").html(formatCurrency(parseInt(value0)));
			$("#lblTPL").html(formatCurrency(parseInt(value1)));
			$("#lblCarDamage").html(formatCurrency(parseInt(value2)));
			$("#lblAbatement").html(formatCurrency(parseInt(value3)));
			$("#lblCarTheft").html(formatCurrency(parseInt(value4)));
			$("#lblBreakageOfGlass").html(formatCurrency(parseInt(value5)));
			$("#lblSelfignite").html(formatCurrency(parseInt(value6)));
			$("#engineDamage").html(formatCurrency(parseInt(value7)));
			$("#lblCarDamageDW").html(formatCurrency(parseInt(value8)));
			$("#lblLimitOfDriver").html(formatCurrency(parseInt(value9)));
			$("#lblLimitOfPassenger").html(formatCurrency(parseInt(value10)));
			
			
			var totleValue1 = parseInt(value0)+parseInt(value1)+parseInt(value2)+parseInt(value3)+parseInt(value4)+parseInt(value5)+parseInt(value6)+parseInt(value7)+parseInt(value8)+parseInt(value9)+parseInt(value10);
			var totleValue2 = parseInt(value0)+(parseInt(value1)+parseInt(value2)+parseInt(value3)+parseInt(value4)+parseInt(value5)+parseInt(value6)+parseInt(value7)+parseInt(value8)+parseInt(value9)+parseInt(value10))*0.9;
			var shangyeValue = parseInt(value1)+parseInt(value2)+parseInt(value3)+parseInt(value4)+parseInt(value5)+parseInt(value6)+parseInt(value7)+parseInt(value8)+parseInt(value9)+parseInt(value10)
			
			$("#lblTotalCompulsory").html(formatCurrency(parseInt(value0)));
			$("#lblCommonTotal").html(formatCurrency(parseInt(shangyeValue)));
			$("#lblMarket").html(formatCurrency(parseInt(totleValue1)));
			$("#liDispaly1").hide();
			$("#liDispaly2").show();
		}
    }
    
    $(document).ready(function(){
    	$("#txtMoney").on("change",function(){
			var flg = checkprice()
			if(flg){
				dataReload();
			}
		});
		$("#txtMoney").keyup(function(){
			var flg = checkprice()
			if(flg){
				dataReload();
			}
		});
		dataReload();
		$(".car-tools select").change(function(){
			dataReload();
		})
		$(".car-tools :checkbox").click(function(){
			dataReload();
		})
    })
    
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
    function checkprice(){
    	var txtMoney = $("#txtMoney").val();
    	var regTel=l=/^[0-9]*$/;
		if(!regTel.test(txtMoney)){
			$("#txtMoney").val(0);
			return false;
		}
		return true;
    }
</script>
<div class="content car-tools">
		<ul class="position">
			<a href="">首页</a>&gt;<a href="">购车工具</a>&gt;<a class="active" href="">保险计算</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 6/>
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
									<dt>宝马（进口）</dt>
									<dd><a href="">宝马3系</a></dd>
									<dd><a href="">宝马5系</a></dd>
									<dd><a href="">宝马X1</a></dd>
								</dl>
							</div>
						</div> 
                        </div>
                        <div  style="width:350px;" class="selc">
                    	<em class="seltiptxt">车型</em>
                    	<div style=width:300px;z-index:40;" class="select select-tools select-disabled">
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
						</div>
            </div>
          </div>

          <div class="jisuanqi_box">
            <ul class="rela_ul">
              <li>
                  <div class="l-box">
                      <span class="fl">裸车价格</span> <span class="fonts1">
                          <input id="txtMoney" type="text" class="f-w100" maxlength="8" value="0">
                          元</span>
                  </div>
                  <div class="r-box">
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly1" class="bg">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          <em>请选择车款或输入裸车价格</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly2" style="display: none; background: rgb(247, 247, 247);">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          市场价：<em class="red16"><label id="lblMarket">0</label>元</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
            </ul>
            <p class="txt_right">此结果仅供参考，实际应缴费以当地为准</p>
          </div>

          <!-- 强制保险开始 -->
          <div class="jsq_com_box">
              <div class="titbox">
                  <h4>
                      强制保险</h4>
                  <div class="red_num">
                      <label id="lblTotalCompulsory">0</label>元</div>
              </div>
              <table width="100%" id="datalist" cellspacing="0" cellpadding="0" border="0">
                  <colgroup>
                      <col width="200px">
                      <col width="180px">
                      <col width="210px">
                      <col>
                  </colgroup>
                  <tbody>
                      <tr>
                          <th>
                              交强险
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <em>
                                      <label id="lblCompulsory">0</label></em>元</div>
                          </td>
                          <td>
                              <select id="selCompulsory" class="f-w150 f-curr" onchange="calcAll();">
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

          <!--商业保险开始-->
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
                            <input id="chkTPL" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selTPL" class="f-w100 f-curr" onchange="calcAll();">
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
                            <input id="chkCarDamage" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkAbatement" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkCarTheft" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkBreakageOfGlass" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selBreakageOfGlass" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkSelfignite" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkEngine" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkCarDamageDW" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selCarDamageDW" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkLimitofDriver" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selLimitofDriver" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkLimitofPassenger" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selLimitofPassenger" class="f-w100 f-curr" onchange="calcAll()">
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

        </div>
      </div>
      
		</div>
	</div>

</@cc.html>