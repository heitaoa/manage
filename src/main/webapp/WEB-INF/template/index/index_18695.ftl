<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "�����ռ��������������ռ�����_2014���³��ռ�����-������"  "���������������ṩ2014���³��ռ��������������ռ�����������������������O2O�����һƷ�ơ�" "���ռ�����,�������ռ�����">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
<script>
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
        dataReload();
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
			//��ǿ�� 
			if(sel1 == 950){
				value0 = 950;
			}else{
				value0 = 1100;
			}
		
			//������������
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
			
			//������ʧ��
			if(ck2){
			 	var rate = 0.0095;
				var base = 285;
		        if (sel1 == 1100) {
		        	rate = 0.009;
		            base = 342;
		        }
		        value2 = base + buyCarPrice * rate;
			}
			
			//����������Լ��
			if(ck3){
            	value3 = (value1 + value2) * 0.2;
        	}
        	
        	//ȫ��������
        	if(ck4){
				if (sel1 == 1100) {
		            value4 = 140 + buyCarPrice * 0.0044;
		        } else {
		            value4 = 120 + buyCarPrice * 0.0049;
		        }  
			}
			
			//��������������
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
			
			//��ȼ��ʧ��
			if(ck6){
				value6 = buyCarPrice * 0.0015;
			}
			
			
			//��ˮ��/�������ر���ʧ��
			if(ck7){
				value7 = parseInt(value2) * 0.05;
			}
			
			//��������
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
			//˾����λ������
			if(ck9){
				if(sel1 == 950){
					value9 = parseInt(sel5) * 0.0042;
				}else{
					value9 = parseInt(sel5) * 0.004;
				}
			}
			//�˿���λ������
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
			<a href="">��ҳ</a>&gt;<a href="">��������</a>&gt;<a class="active" href="">���ռ���</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 6/>
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
									<dt>�������ڣ�</dt>
									<dd><a href="">����3ϵ</a></dd>
									<dd><a href="">����5ϵ</a></dd>
									<dd><a href="">����X1</a></dd>
								</dl>
							</div>
						</div> 
                        </div>
                        <div  style="width:350px;" class="selc">
                    	<em class="seltiptxt">����</em>
                    	<div style=width:300px;z-index:40;" class="select select-tools select-disabled">
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
									<dt>2014��</dt>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
									<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
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
                          <input id="txtMoney" type="text" class="f-w100" maxlength="8" value="0">
                          Ԫ</span>
                  </div>
                  <div class="r-box">
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly1" class="bg">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          <em>��ѡ�񳵿�������㳵�۸�</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
              <li id="liDispaly2" style="display: none; background: rgb(247, 247, 247);">
                  <div class="l-box padd_220">
                      <p class="fonts2">
                          �г��ۣ�<em class="red16"><label id="lblMarket">0</label>Ԫ</em></p>
                  </div>
                  <div class="clear">
                  </div>
              </li>
            </ul>
            <p class="txt_right">�˽�������ο���ʵ��Ӧ�ɷ��Ե���Ϊ׼</p>
          </div>

          <!-- ǿ�Ʊ��տ�ʼ -->
          <div class="jsq_com_box">
              <div class="titbox">
                  <h4>
                      ǿ�Ʊ���</h4>
                  <div class="red_num">
                      <label id="lblTotalCompulsory">0</label>Ԫ</div>
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
                              ��ǿ��
                          </th>
                          <td class="r_align">
                              <div class="jiage">
                                  <em>
                                      <label id="lblCompulsory">0</label></em>Ԫ</div>
                          </td>
                          <td>
                              <select id="selCompulsory" class="f-w150 f-curr" onchange="calcAll();">
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

          <!--��ҵ���տ�ʼ-->
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
                            <input id="chkTPL" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selTPL" class="f-w100 f-curr" onchange="calcAll();">
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
                            <input id="chkCarDamage" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkAbatement" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkCarTheft" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkBreakageOfGlass" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selBreakageOfGlass" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkSelfignite" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkEngine" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <input id="chkCarDamageDW" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selCarDamageDW" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkLimitofDriver" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selLimitofDriver" class="f-w100 f-curr" onchange="calcAll()">
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
                            <input id="chkLimitofPassenger" type="checkbox" checked="checked" onclick="calcAll();">
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
                            <select id="selLimitofPassenger" class="f-w100 f-curr" onchange="calcAll()">
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

        </div>
      </div>
      
		</div>
	</div>

</@cc.html>