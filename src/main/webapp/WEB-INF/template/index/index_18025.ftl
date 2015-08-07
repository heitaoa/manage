
<#import "../common_chetuan.ftl" as cc>
<@cc.html 2 >
<script src="${www_ct_url}js/url.js" type="text/javascript"></script>
<script type="text/javascript" >
var tdata;
window.onload=function showtable(){
var cid;
var id;
$.ajax({
    		url : 'http://www.chetuan.com//chetuan/setInitCookie',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			cid=data[0].catalogid;
    			id=window.url('1');
$.ajax({
    		url : '${www_ct_url}chetuan/ConfigurationCarParameters',
    		dataType : 'jsonp',
    		data:{fatherid:id},
    		jsonp:'jsonpcallback',
    		success : function(data){
    			tdata = data;
    			var path;
    			var lengA=data.length;
    			if(data[0][197].substr(0,3)=="315"){
					path = data[0][197].replace(/315/,"http://img.315che.com");
				}
				if(data[0][197].substr(0,3)=="ct1"){
					path = data[0][197].replace(/ct1/,'${www_ct_url}');
				}
    			var tbcs195="<ul class='position'><a href='${www_ct_url}'>车团</a>&gt;<a href='${www_ct_url}chetuan/toGroupon'>小胖看车团</a>&gt<a class='active' href=''>"+data[0][196]+"</a></ul>";
				tbcs195+="<div class='mod-con'><div class='brand'><div class='logo'><img src='"+path+"' alt='' width='50px'></div><h2>"+data[0][196]+"</h2></div><div class='nav'><ul>";
				tbcs195+="<li><a href='${kan_ct_url}chetuan/"+id+"/'>车系</a></li>";
				tbcs195+="<li class='active'><a href='#'>参数配置</a></li>";
				tbcs195+="<li><a href='${dealer_ct_url}'>经销商</a></li>";
				tbcs195+="<li><a target='_blank' class='empty-con'  href='${www_ct_url}list/738/list_1.html'>活动</a></li>";
				tbcs195+="<li><a target='_blank' href='${pic_ct_url}"+id+"/0/moren.html'>图片</a></li>";
				tbcs195+="<li><a target='_blank' class='empty-con' href='${www_ct_url}list/191/list_1.html'>资讯</a></li>";
				tbcs195+="</ul></div></div>";
				$(".mod-hd").html(tbcs195);
				var tbcs196="<i></i>"+lengA+"个车型";
				$(".title").html(tbcs196);
						
				var tbcs197="<form action=''>";
				var yearArray=[];
				var bsArray=[];
				var plArray=[];
				var plNum1=0;
				var bsNum1=0;
				var num=0;
				for(var i=0;i<data.length;i++){
					if(data[i][15]!="-"){
						var yearNum=BLArray(yearArray,data[i][15]);
						if(yearNum==0){
							yearArray[num]=data[i][15];
							num++;
						}
					}
					if(data[i][36]!="-"){
						var plNum=BLArray(plArray,data[i][36]);
						if(plNum==0){
							plArray[plNum1]=data[i][36];
							var a=0;
							plNum1++;
						}
					}
					if(data[i][57]!="-"){
						var bsNum=BLArray(bsArray,data[i][5].substring(2,data[i][5].length));
						if(bsNum==0){
							bsArray[bsNum1]=data[i][5].substring(2,data[i][5].length);
							bsNum1++;
						}
					}
				}
				if(yearArray.length>0){
					tbcs197+="<div class='filter-option'>年款：";
					for(var i=0;i<yearArray.length;i++){
						tbcs197=tbcs197+"<label for=''><input class='year' type='checkbox' name='year' id='year"+yearArray[i]+"' value='"+yearArray[i]+"'>"+yearArray[i]+"款</label>";
					}
					tbcs197+="</div>";
				}
				if(plArray.length>0){
					tbcs197+="<div class='filter-option'>排量：";
					for(var i=0;i<plArray.length;i++){
						tbcs197=tbcs197+"<label for=''><input class='pl' type='checkbox' name='pl' id='pl"+plArray[i]+"' value='"+plArray[i]+"'>"+plArray[i]+"L</label>";
					}
					tbcs197+="</div>";
				}
				if(bsArray.length>0){
					tbcs197+="<div class='filter-option'>变速箱：";
					for(var i=0;i<bsArray.length;i++){
						tbcs197=tbcs197+"<label for=''><input class='bs' type='checkbox' name='bs' id='bs"+bsArray[i]+"' value='"+bsArray[i]+"'>"+bsArray[i]+"</label>";
					}
					tbcs197+="</div>";
				}
				tbcs197+="</form>";
				$(".filter-form").html(tbcs197);
				$(".year")[0].checked="true";
				var bsData=ABs(tdata);
    			showTs(bsData,cid,id);
    			$(".del").click(function(){
					var title = $(this).attr("title");
					var trArray=$(".tbcs tr");
					$(".tbset tr td:eq("+title+")").hide();
					for(var i=0;i<trArray.length;i++){
						
							$(".tbcs tr:eq("+i+") td:eq("+title+")").hide();
						
					}
				});
				$(".year").click(function(){
					var data=ABs(tdata);
					showTs(data,cid,id);
				});
				
				$(".pl").click(function(){
					var data=ABs(tdata);
					showTs(data,cid,id);
				});
				$(".bs").click(function(){
					var data=ABs(tdata);
					showTs(data,cid,id);
				});
    			$(".left-btn").click(function(){
					var title  = $(this).next().attr("title");
					var preid=parseInt(title)-1;
					var tdStr1;
					tdStr1=$(this).parents(".tbset").find("td:eq("+preid+") div:eq(0)").find("div")[0].innerHTML;
					$(this).parents(".tbset").find("td:eq("+preid+") div:eq(0)").find("div")[0].innerHTML=$(this).parents(".tbset").find("td:eq("+title+") div:eq(0)").find("div")[0].innerHTML;
					$(this).parents(".tbset").find("td:eq("+title+") div:eq(0)").find("div")[0].innerHTML=tdStr1;
					var trArray=$(".tbcs tr");
					for(var i=0;i<trArray.length;i++){
						
							var tdStr2;
							tdStr2=$(".tbcs tr:eq("+i+")").find("td")[preid].innerHTML;
							$(".tbcs tr:eq("+i+")").find("td")[preid].innerHTML=$(".tbcs tr:eq("+i+")").find("td")[title].innerHTML;
							$(".tbcs tr:eq("+i+")").find("td")[title].innerHTML=tdStr2;
						
					}
				});
				$(".right-btn").click(function(){
					var title  = $(this).prev().attr("title");
					var preid = parseInt(title)+1;
					var tdStr1;
					tdStr1=$(this).parents(".tbset").find("td:eq("+preid+") div:eq(0)").find("div")[0].innerHTML;
					$(this).parents(".tbset").find("td:eq("+preid+") div:eq(0)").find("div")[0].innerHTML=$(this).parents(".tbset").find("td:eq("+title+") div:eq(0)").find("div")[0].innerHTML;
					$(this).parents(".tbset").find("td:eq("+title+") div:eq(0)").find("div")[0].innerHTML=tdStr1;
					var trArray=$(".tbcs tr");
					for(var i=0;i<trArray.length;i++){
						
							var tdStr2;
							tdStr2=$(".tbcs tr:eq("+i+")").find("td")[preid].innerHTML;
							$(".tbcs tr:eq("+i+")").find("td")[preid].innerHTML=$(".tbcs tr:eq("+i+")").find("td")[title].innerHTML;
							$(".tbcs tr:eq("+i+")").find("td")[title].innerHTML=tdStr2;
						
					}
				});
				var titleStr="";
				if(data[0][196].indexOf("&nbsp")!=-1){
					titleStr=data[0][196].substr(0,data[0][196].indexOf("&nbsp"))+" "+data[0][196].substr(data[0][196].indexOf("&nbsp")+5,data[0][196].length);
					document.title="【"+titleStr+"参数】"+titleStr+"配置-车团";
					document.getElementsByTagName("meta")[1].content="车团"+titleStr+"团购提供"+titleStr+"参数、"+titleStr+"配置详情，车团网，汽车电商服务第一品牌。";
					document.getElementsByTagName("meta")[2].content=titleStr+"参数,"+titleStr+"配置";
				}else{
				
				document.title="【"+data[0][196]+"参数】"+data[0][196]+"配置-车团";
				document.getElementsByTagName("meta")[1].content="车团"+data[0][196]+"团购提供"+data[0][196]+"参数、"+data[0][196]+"配置详情，车团网，汽车电商服务第一品牌。";
				document.getElementsByTagName("meta")[2].content=data[0][196]+"参数,"+data[0][196]+"配置";
    			}
    			
    		}
    		
		});		
    		}
    		
    		
  	})

	
}


</script>
<script>
	$(document).ready(function() {
		$(window).scroll(function() {
			var $docTop = $(document).scrollTop();
			var $pzBoxTop = $(".pzbox").offset().top;
			var $pzBoxLeft = $(".pzbox").offset().left;
			var $configNavTop = $(".config-nav").offset().top;
			var $configNavLeft = $(".config-nav").offset().left;
			if($docTop >= $configNavTop) {
				var scrollX = document["documentElement"].scrollLeft + document["body"].scrollLeft;
				var scrollY = document["documentElement"].scrollTop + document["body"].scrollTop;
				$(".config-nav").css({"position": "fixed", "left": $(".pzbox").offset().left - scrollX});
			}
			if($docTop < $pzBoxTop) {
				$(".config-nav").css({"position": "relative", "top": 0, "left": 0})
			}
		});

	});
</script>
<div class="content car-model">
		<div class="car-model-ui car-model-o ar-model-para">
			<div class="mod-hd">
				
			</div>
			<div class="mod-config">
				<h2 class="title"></h2>
				<div class="config-filter-bar" >
					<h2>车款筛选</h2>
					<div class="filter-form" >
						
					</div>
				</div>
				<!-- 顶部操作区开始 -->
				<div class="pzbox">
					<div style="position:relative; left:0; top:0;" class="config-nav">
						<table cellspacing="0" cellpadding="0" class="tbset">
							<tr>
								<th>
									<div class="setbox">
										<label for=""><input type="checkbox" name="" id="">高亮显示不同项</label>
										<label for=""><input type="checkbox" name="" id="">隐藏相同项</label>
										<p>注：●标配  ○选配  -无</p>
									</div>
								</th>
								
							</tr>
						</table>
					</div>
				<!-- 顶部操作区结束 -->
					<div class="config-content">
						<table cellspacing="0" cellpadding="0" class="tbcs" >
							<tr style="width:1768px;">
								<th><div>厂商指导价(万元)</div></th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>基本参数</h3>
								</th>
							</tr>
							<tr id="tr_0">
								<th class="cs-th">
									<div><a href="">品牌</a></div>
								</th>
								
							</tr>
							<tr id="tr_1">
								<th class="cs-th">
									<div><a href="">级别</a></div>
								</th>
								
							</tr>
							<tr id="tr_2">
								<th class="cs-th">
									<div><a href="">发动机</a></div>
								</th>
								
							</tr>
							<tr id="tr_3">
								<th class="cs-th">
									<div><a href="">变速箱</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">长*宽*高(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">车体结构</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">最高车速(km/h)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">官方0-100km/h加速(s)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">官方100-0制动(m)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">官方综合路况油耗(L)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">实测0-100km/h加速(s)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">实测100-0km/h制动(m)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">实测油耗(L)</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">生产年份</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">添加日期</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">更新日期</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">厂商</a></div>
								</th>
								
							</tr>
							<tr id="tr_4">
								<th class="cs-th">
									<div><a href="">工信部综合油耗(L)</a></div>
								</th>
								
							</tr>
							<tr id="tr_5">
								<th class="cs-th">
									<div><a href="">整车质保</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>车身参数</h3>
								</th>
							</tr>
							<tr id="tr_6">
								<th class="cs-th">
									<div><a href="">长(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_7">
								<th class="cs-th">
									<div><a href="">宽(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_8">
								<th class="cs-th">
									<div><a href="">高(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_8">
								<th class="cs-th">
									<div><a href="">轴距(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_8">
								<th class="cs-th">
									<div><a href="">前轮距(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_8">
								<th class="cs-th">
									<div><a href="">后轮距(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_8">
								<th class="cs-th">
									<div><a href="">最小离地间隙(mm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_9">
								<th class="cs-th">
									<div><a href="">整备质量</a></div>
								</th>
								
							</tr>
							<tr id="tr_10">
								<th class="cs-th">
									<div><a href="">车身结构</a></div>
								</th>
								
							</tr>
							<tr id="tr_10">
								<th class="cs-th">
									<div><a href="">车门数(个)</a></div>
								</th>
								
							</tr>
							<tr id="tr_11">
								<th class="cs-th">
									<div><a href="">座位牌数</a></div>
								</th>
								
							</tr>
							<tr id="tr_12">
								<th class="cs-th">
									<div><a href="">油箱容积(L)</a></div>
								</th>
								
							</tr>
							<tr id="tr_13">
								<th class="cs-th">
									<div><a href="">行李箱容积(L)</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>发动机</h3>
								</th>
							</tr>
							<tr id="tr_14">
								<th class="cs-th">
									<div><a href="">发动机型号</a></div>
								</th>
								
							</tr>
							<tr id="tr_15">
								<th class="cs-th">
									<div><a href="">排量(mL)</a></div>
								</th>
								
							</tr>
							<tr id="tr_16">
								<th class="cs-th">
									<div><a href="">排量级别</a></div>
								</th>
								
							</tr>
							<tr id="tr_17">
								<th class="cs-th">
									<div><a href="">进气形式</a></div>
								</th>
								
							</tr>
							<tr id="tr_18">
								<th class="cs-th">
									<div><a href="">气缸排列形式</a></div>
								</th>
								
							</tr>
							<tr id="tr_19">
								<th class="cs-th">
									<div><a href="">气缸数(个)</a></div>
								</th>
								
							</tr>
							<tr id="tr_20">
								<th class="cs-th">
									<div><a href="">每缸气门数(个)</a></div>
								</th>
								
							</tr>
							<tr id="tr_21">
								<th class="cs-th">
									<div><a href="">压缩比</a></div>
								</th>
								
							</tr>
							<tr id="tr_21">
								<th class="cs-th">
									<div><a href="">配气机构</a></div>
								</th>
								
							</tr>
							<tr id="tr_22">
								<th class="cs-th">
									<div><a href="">缸径</a></div>
								</th>
								
							</tr>
							<tr id="tr_22">
								<th class="cs-th">
									<div><a href="">行程</a></div>
								</th>
								
							</tr>
							<tr id="tr_23">
								<th class="cs-th">
									<div><a href="">最大马力(Ps)</a></div>
								</th>
								
							</tr>
							<tr id="tr_24">
								<th class="cs-th">
									<div><a href="">最大功率(kW)</a></div>
								</th>
								
							</tr>
							<tr id="tr_25">
								<th class="cs-th">
									<div><a href="">最大功率转速(rpm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_26">
								<th class="cs-th">
									<div><a href="">最大扭矩(N·m)</a></div>
								</th>
								
							</tr>
							<tr id="tr_27">
								<th class="cs-th">
									<div><a href="">最大扭矩转速(rpm)</a></div>
								</th>
								
							</tr>
							<tr id="tr_28">
								<th class="cs-th">
									<div><a href="">发动机特有技术</a></div>
								</th>
								
							</tr>
							<tr id="tr_29">
								<th class="cs-th">
									<div><a href="">燃料形式</a></div>
								</th>
								
							</tr>
							<tr id="tr_30">
								<th class="cs-th">
									<div><a href="">燃油标号</a></div>
								</th>
								
							</tr>
							<tr id="tr_31">
								<th class="cs-th">
									<div><a href="">供油方式</a></div>
								</th>
								
							</tr>
							<tr id="tr_32">
								<th class="cs-th">
									<div><a href="">缸盖材料</a></div>
								</th>
								
							</tr>
							<tr id="tr_33">
								<th class="cs-th">
									<div><a href="">缸体材料</a></div>
								</th>
								
							</tr>
							<tr id="tr_33">
								<th class="cs-th">
									<div><a href="">环保标准</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>变速箱</h3>
								</th>
							</tr>
							<tr id="tr_34">
								<th class="cs-th">
									<div><a href="">简称</a></div>
								</th>
								
							</tr>
							<tr id="tr_35">
								<th class="cs-th">
									<div><a href="">挡位个数</a></div>
								</th>
								
							</tr>
							<tr id="tr_36">
								<th class="cs-th">
									<div><a href="">变速箱类型</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>底盘转向</h3>
								</th>
							</tr>
							<tr id="tr_37">
								<th class="cs-th">
									<div><a href="">驱动方式</a></div>
								</th>
								
							</tr>
							<tr id="tr_38">
								<th class="cs-th">
									<div><a href="">前悬架类型</a></div>
								</th>
								
							</tr>
							<tr id="tr_39">
								<th class="cs-th">
									<div><a href="">后悬架类型</a></div>
								</th>
								
							</tr>
							<tr id="tr_40">
								<th class="cs-th">
									<div><a href="">助力类型</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>车轮制动</h3>
								</th>
							</tr>
							<tr id="tr_41">
								<th class="cs-th">
									<div><a href="">前制动器类型</a></div>
								</th>
								
							</tr>
							<tr id="tr_42">
								<th class="cs-th">
									<div><a href="">后制动器类型</a></div>
								</th>
								
							</tr>
							<tr id="tr_43">
								<th class="cs-th">
									<div><a href="">驻车制动类型</a></div>
								</th>
								
							</tr>
							<tr id="tr_44">
								<th class="cs-th">
									<div><a href="">前轮胎规格</a></div>
								</th>
								
							</tr>
							<tr id="tr_45">
								<th class="cs-th">
									<div><a href="">后轮胎规格</a></div>
								</th>
								
							</tr>
							<tr id="tr_46">
								<th class="cs-th">
									<div><a href="">备胎规格</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>安全装备</h3>
								</th>
							</tr>
							<tr id="tr_47">
								<th class="cs-th">
									<div><a href="">驾驶座安全气囊</a></div>
								</th>
								
							</tr>
							<tr id="tr_47">
								<th class="cs-th">
									<div><a href="">副驾驶安全气囊</a></div>
								</th>
								
							</tr>
							<tr id="tr_48">
								<th class="cs-th">
									<div><a href="">前排侧气囊</a></div>
								</th>
								
							</tr>
							<tr id="tr_49">
								<th class="cs-th">
									<div><a href="">后排侧气囊</a></div>
								</th>
								
							</tr>
							<tr id="tr_50">
								<th class="cs-th">
									<div><a href="">前排头部气囊(气帘)</a></div>
								</th>
								
							</tr>
							<tr id="tr_51">
								<th class="cs-th">
									<div><a href="">后排头部气囊(气帘)</a></div>
								</th>
								
							</tr>
							<tr id="tr_52">
								<th class="cs-th">
									<div><a href="">膝部气囊</a></div>
								</th>
								
							</tr>
							<tr id="tr_53">
								<th class="cs-th">
									<div><a href="">安全带未系提示</a></div>
								</th>
								
							</tr>
							<tr id="tr_54">
								<th class="cs-th">
									<div><a href="">发动机电子防盗</a></div>
								</th>
								
							</tr>
							<tr id="tr_55">
								<th class="cs-th">
									<div><a href="">车内中控锁</a></div>
								</th>
								
							</tr>
							<tr id="tr_56">
								<th class="cs-th">
									<div><a href="">遥控钥匙</a></div>
								</th>
								
							</tr>
							<tr id="tr_57">
								<th class="cs-th">
									<div><a href="">无钥匙启动系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_58">
								<th class="cs-th">
									<div><a href="">ISO FIX儿童座椅接口</a></div>
								</th>
								
							</tr>
							<tr id="tr_59">
								<th class="cs-th">
									<div><a href="">LATCH儿童座椅接口</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>操控配置</h3>
								</th>
							</tr>
							<tr id="tr_60">
								<th class="cs-th">
									<div><a href="">ABS防抱死</a></div>
								</th>
								
							</tr>
							<tr id="tr_61">
								<th class="cs-th">
									<div><a href="">制动力分配(EBD/CBC等)</a></div>
								</th>
								
							</tr>
							<tr id="tr_62">
								<th class="cs-th">
									<div><a href="">刹车辅助(EBA/BAS/BA等)</a></div>
								</th>
								
							</tr>
							<tr id="tr_63">
								<th class="cs-th">
									<div><a href="">牵引力控制(ASR/TCS/TRC等)</a></div>
								</th>
								
							</tr>
							<tr id="tr_64">
								<th class="cs-th">
									<div><a href="">车身稳定控制(ESC/ESP/DSC等)</a></div>
								</th>
								
							</tr>
							<tr id="tr_65">
								<th class="cs-th">
									<div><a href="">自动驻车/上坡辅助</a></div>
								</th>
								
							</tr>
							<tr id="tr_66">
								<th class="cs-th">
									<div><a href="">陡坡缓降</a></div>
								</th>
								
							</tr>
							<tr id="tr_67">
								<th class="cs-th">
									<div><a href="">可变悬架</a></div>
								</th>
								
							</tr>
							<tr id="tr_68">
								<th class="cs-th">
									<div><a href="">空气悬架</a></div>
								</th>
								
							</tr>
							<tr id="tr_69">
								<th class="cs-th">
									<div><a href="">胎压监测装置</a></div>
								</th>
								
							</tr>
							<tr id="tr_70">
								<th class="cs-th">
									<div><a href="">零胎压继续行驶</a></div>
								</th>
								
							</tr>
							<tr id="tr_71">
								<th class="cs-th">
									<div><a href="">可变转向比</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>外部配置</h3>
								</th>
							</tr>
							<tr id="tr_72">
								<th class="cs-th">
									<div><a href="">电动天窗</a></div>
								</th>
								
							</tr>
							<tr id="tr_72">
								<th class="cs-th">
									<div><a href="">全景天窗</a></div>
								</th>
								
							</tr>
							<tr id="tr_73">
								<th class="cs-th">
									<div><a href="">同色后视镜</a></div>
								</th>
								
							</tr>
							<tr id="tr_74">
								<th class="cs-th">
									<div><a href="">同色防擦条</a></div>
								</th>
								
							</tr>
							<tr id="tr_75">
								<th class="cs-th">
									<div><a href="">运动外观套件</a></div>
								</th>
								
							</tr>
							<tr id="tr_76">
								<th class="cs-th">
									<div><a href="">铝合金轮毂</a></div>
								</th>
								
							</tr>
							<tr id="tr_77">
								<th class="cs-th">
									<div><a href="">电动吸合门</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>内部配置</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">真皮方向盘</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">方向盘上下调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">方向盘前后调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">方向盘电动调节</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">多功能方向盘</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">方向盘换挡</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">定速巡航</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">泊车辅助</a></div>
								</th>
								
							</tr>
							<tr id="tr_86">
								<th class="cs-th">
									<div><a href="">倒车视频影像</a></div>
								</th>
								
							</tr>
							<tr id="tr_87">
								<th class="cs-th">
									<div><a href="">行车电脑显示屏	</a></div>
								</th>
								
							</tr>
							<tr id="tr_89">
								<th class="cs-th">
									<div><a href="">HUD抬头数字显示</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">左脚休息踏板</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>座椅配置</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">真皮/仿皮座椅</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">运动风格座椅</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">腰部支撑调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">肩部支撑调节</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">前排座椅电动调节</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">第二排靠背角度调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">后排座椅手动调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">后排座椅电动调节</a></div>
								</th>
								
							</tr>
							<tr id="tr_86">
								<th class="cs-th">
									<div><a href="">电动座椅记忆</a></div>
								</th>
								
							</tr>
							<tr id="tr_87">
								<th class="cs-th">
									<div><a href="">前排座椅加热</a></div>
								</th>
								
							</tr>
							<tr id="tr_89">
								<th class="cs-th">
									<div><a href="">后排座椅加热</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">座椅通风</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">座椅按摩</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">后排座椅整体放倒</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">后排座椅比例放倒</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">第三排座椅</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">前座中央扶手</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">后座中央扶手</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">前排杯架</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">后排杯架</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">电动后备厢</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>多媒体配置</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">GPS导航系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">定位互动服务</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">中控台彩色大屏</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">人机交互系统</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">内置硬盘</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">蓝牙系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">蓝牙/车载电话</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">车载电视</a></div>
								</th>
								
							</tr>
							<tr id="tr_86">
								<th class="cs-th">
									<div><a href="">车载电话</a></div>
								</th>
								
							</tr>
							<tr id="tr_87">
								<th class="cs-th">
									<div><a href="">后排液晶屏</a></div>
								</th>
								
							</tr>
							<tr id="tr_89">
								<th class="cs-th">
									<div><a href="">外接音源接口(AUX/USB/iPod等)</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">CD支持MP3/WMA</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">单碟CD</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">虚拟多碟CD</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">多碟CD系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">单碟DVD</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">多碟DVD系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">2-3喇叭扬声器系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">4-5喇叭扬声器系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">6-7喇叭扬声器系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">≥8喇叭扬声器系统</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>灯光配置</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">氙气大灯</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">日间行车灯</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">自动头灯</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">转向头灯(辅助灯)</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">前雾灯</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">后雾灯</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">大灯高度可调</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">大灯清洗装置</a></div>
								</th>
								
							</tr>
							<tr id="tr_86">
								<th class="cs-th">
									<div><a href="">车内氛围灯</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>玻璃_后视镜</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">前电动车窗</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">后电动车窗</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">车窗防夹手功能</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">防紫外线/隔热玻璃</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">后视镜电动调节</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">后视镜加热</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">内/外后视镜自动防眩目</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">后视镜电动折叠</a></div>
								</th>
								
							</tr>
							<tr id="tr_86">
								<th class="cs-th">
									<div><a href="">后视镜记忆</a></div>
								</th>
								
							</tr>
							<tr id="tr_87">
								<th class="cs-th">
									<div><a href="">后风挡遮阳帘</a></div>
								</th>
								
							</tr>
							<tr id="tr_89">
								<th class="cs-th">
									<div><a href="">后排侧遮阳帘</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">遮阳板化妆镜</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">后雨刷</a></div>
								</th>
								
							</tr>
							<tr id="tr_90">
								<th class="cs-th">
									<div><a href="">感应雨刷</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>空调_冰箱</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">手动空调</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">自动空调</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">后排独立空调</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">后座出风口</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">温度分区控制</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">空气调节/花粉过滤</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">车载冰箱</a></div>
								</th>
								
							</tr>
						</table>
						<table id="tab_0" cellspacing="0" cellpadding="0" class="tbcs">
							<tr>
								<th class="cs-title" colspan="9">
									<h3>高科技配置</h3>
								</th>
							</tr>
							<tr id="tr_78">
								<th class="cs-th">
									<div><a href="">自动泊车入位</a></div>
								</th>
								
							</tr>
							<tr id="tr_79">
								<th class="cs-th">
									<div><a href="">并线辅助</a></div>
								</th>
								
							</tr>
							<tr id="tr_80">
								<th class="cs-th">
									<div><a href="">主动刹车/主动安全系统</a></div>
								</th>
								
							</tr>
							<tr id="tr_81">
								<th class="cs-th">
									<div><a href="">整体主动转向系统</a></div>
								</th>
							
							</tr>
							<tr id="tr_82">
								<th class="cs-th">
									<div><a href="">夜视系统</a></div>
								</th>
							
							</tr>
							<tr id="tr_83">
								<th class="cs-th">
									<div><a href="">中控液晶屏分屏显示</a></div>
								</th>
								
							</tr>
							<tr id="tr_84">
								<th class="cs-th">
									<div><a href="">自适应巡航</a></div>
								</th>
								
							</tr>
							<tr id="tr_85">
								<th class="cs-th">
									<div><a href="">全景摄像头</a></div>
								</th>
								
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	$(function() {
		$(".empty-con").on("click", function() {
			if($(".empty-con").length > 0) {
				$(".over-layer").css("display", "block").animate({"opacity": "0.6"});
				$(".tooltip-box").css({
					left: ($(window).width() - $(".tooltip-box").outerWidth())/2,
					top: ($(window).height() - $(".tooltip-box").outerHeight())/2
				}).show();
				$(".over-layer").click(function() {
					$(".tooltip-box").hide();
					$(this).css("display", "none").animate({"opacity": "0"});
				});
			}
			$(window).on("resize", function() {
				$(".tooltip-box").css({
					//left: ($(window).width() - $(".tooltip-box").outerWidth())/2,
					left:0,
					//top: ($(window).height() - $(".tooltip-box").outerHeight())/2
					top:0
				});
			});
			$(".close").on("click", function() {
				$(".tooltip-box").hide();
			});
		});
		
	});
	</script>
</@cc.html>

<script type="text/javascript" >

function BLArray(ArrayList1,a){
	var m=0;
	for(var i=0;i<ArrayList1.length;i++){
		if(ArrayList1[i]==a){
			 m=1;
		}
	}
	return m;
}

function ABs(tdata){
					var yearCheck=$(".year");
					var year=[];
					var ayear=0;
					for(var i=0;i<yearCheck.length;i++){
						if(yearCheck[i].checked){
							year[ayear]=yearCheck[i].value;
							ayear++;
						}
					}
					var plCheck=$(".pl");
					var pl=[];
					var apl=0;
					for(var i=0;i<plCheck.length;i++){
						if(plCheck[i].checked){
							pl[apl]=plCheck[i].value;
							apl++;
						}
					}
					var bsCheck=$(".bs");
					var bs=[];
					var abs=0;
					for(var i=0;i<bsCheck.length;i++){
						if(bsCheck[i].checked){
							bs[abs]=bsCheck[i].value;
							abs++;
						}
					}
					var tbData;
					if(year.length>0){
						if(pl.length>0){
							if(bs.length>0){
								var yearData=[];
								var yearB=0; 
								for(var i=0;i<year.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][15]==year[i]){
											yearData[yearB]=tdata[j];
											yearB++;
										}
									}
								}
								var plData=[];
								var plB=0;
								for(var i=0;i<pl.length;i++){
									for(var j=0;j<yearData.length;j++){
										if(yearData[j][36]==pl[i]){
											plData[plB]=yearData[j];
											plB++;
										}
									}
								}
								var bsData=[];
								var bsB=0;
								for(var i=0;i<bs.length;i++){
									for(var j=0;j<plData.length;j++){
										if(plData[j][5].substring(2,plData[j][5].length)==bs[i]){
											bsData[bsB]=plData[j];
											bsB++;
										}
									}
								}
								tbData=bsData;
							}else{
								var yearData=[];
								var yearB=0; 
								for(var i=0;i<year.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][15]==year[i]){
											yearData[yearB]=tdata[j];
											yearB++;
										}
									}
								}
								var plData=[];
								var plB=0;
								for(var i=0;i<pl.length;i++){
									for(var j=0;j<yearData.length;j++){
										if(yearData[j][36]==pl[i]){
											plData[plB]=yearData[j];
											plB++;
										}
									}
								}
								tbData=plData;
							}
						}else{
							if(bs.length>0){
								var yearData=[];
								var yearB=0; 
								for(var i=0;i<year.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][15]==year[i]){
											yearData[yearB]=tdata[j];
											yearB++;
										}
									}
								}
								var bsData=[];
								var bsB=0;
								for(var i=0;i<bs.length;i++){
									for(var j=0;j<yearData.length;j++){
										if(yearData[j][5].substring(2,yearData[j][5].length)==bs[i]){
											bsData[bsB]=yearData[j];
											bsB++;
										}
									}
								}
								tbData=bsData;
							}else{
								var yearData=[];
								var yearB=0; 
								for(var i=0;i<year.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][15]==year[i]){
											yearData[yearB]=tdata[j];
											yearB++;
										}
									}
								}
								tbData=yearData;
							}
						}	
					}else{
						if(pl.length>0){
							if(bs.length>0){
								var plData=[];
								var plB=0;
								for(var i=0;i<pl.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][36]==pl[i]){
											plData[plB]=tdata[j];
											plB++;
										}
									}
								}
								var bsData=[];
								var bsB=0;
								for(var i=0;i<bs.length;i++){
									for(var j=0;j<plData.length;j++){
										if(plData[j][5].substring(2,plData[j][5].length)==bs[i]){
											bsData[bsB]=plData[j];
											bsB++;
										}
									}
								}
								tbData=bsData;
							}else{
								var plData=[];
								var plB=0;
								for(var i=0;i<pl.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][36]==pl[i]){
											plData[plB]=tdata[j];
											plB++;
										}
									}
								}
								tbData=plData;
							}
						}else{
							if(bs.length>0){
								var bsData=[];
								var bsB=0;
								for(var i=0;i<bs.length;i++){
									for(var j=0;j<tdata.length;j++){
										if(tdata[j][5].substring(2,tdata[j][5].length)==bs[i]){
											bsData[bsB]=tdata[j];
											bsB++;
										}
									}
								}
								tbData=bsData;
							}else{
								tbData=tdata;
							}
						}
					}
					return tbData;
}

function showTs(data,cid,id){
	
    			var lengA=data.length;
	   			var tbsetHtml="<th>"
	   			tbsetHtml+="<div class='setbox'>";
				tbsetHtml+="<label for=''><input type='checkbox' name='' id='' onClick='showA(this)'>高亮显示不同项</label>";
				tbsetHtml+="<label for=''><input type='checkbox' name='' id='' onClick='hideA(this)'>隐藏相同项</label>";
				tbsetHtml+="<p>注：●标配  ○选配  -无</p>";
				tbsetHtml+="</div>";
				tbsetHtml+="</th>";
				for(var i=0;i<data.length;i++){
					tbsetHtml+="<td>";
					tbsetHtml+="<div class='carbox'>";
					tbsetHtml+="<div>"+data[i][0]+"</div>";
					tbsetHtml+="<p>";
					tbsetHtml+="<a class='del' title='"+i+"' onClick='javascript:void(0);'>删除</a>";
					if(i!=0){
						tbsetHtml+="<a class='left-btn' title='"+i+"' onClick='javascript:void(0);'><i></i></a>";
					}
					if(i!=data.length-1){
						tbsetHtml+="<a class='right-btn' title='"+i+"' onClick='javascript:void(0);'><i></i></a>";
					}
					tbsetHtml+="</p>";
					tbsetHtml+="</div>";
					tbsetHtml+="</td>";
				}
    			$(".tbset tr ").html(tbsetHtml);
    			var tbcs1="<th><div>厂商指导价(万元)</div></th>";
    			for(var j=0;j<data.length;j++){
    				tbcs1+="<td><div>"+data[j][1]+"</div></td>"
    			}
    			$($(".tbcs tr")[0]).html(tbcs1);
    			var tbcs2="<th class='cs-th'><div><a href=''>品牌</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs2+="<td><div>"+data[i][2]+"</div></td>";
    			}
    			$($(".tbcs tr")[2]).html(tbcs2);
    			var tbcs3="<th class='cs-th'><div><a href=''>级别</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs3+="<td><div>"+data[i][3]+"</div></td>";
    			}
    			$($(".tbcs tr")[3]).html(tbcs3);
    			var tbcs4="<th class='cs-th'><div><a href=''>发动机</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs4+="<td><div>"+data[i][4]+"</div></td>";
    			}
    			$($(".tbcs tr")[4]).html(tbcs4);
    			var tbcs5="<th class='cs-th'><div><a href=''>变速箱</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs5+="<td><div>"+data[i][5]+"</div></td>";
    			}
    			$($(".tbcs tr")[5]).html(tbcs5);
    			var tbcs6="<th class='cs-th'><div><a href=''>长*宽*高(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs6+="<td><div>"+data[i][6]+"</div></td>";
    			}
    			$($(".tbcs tr")[6]).html(tbcs6);
    			var tbcs7="<th class='cs-th'><div><a href=''>车体结构</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs7+="<td><div>"+data[i][7]+"</div></td>";
    			}
    			$($(".tbcs tr")[7]).html(tbcs7);
    			var tbcs8="<th class='cs-th'><div><a href=''>最高车速(km/h)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs8+="<td><div>"+data[i][8]+"</div></td>";
    			}
    			$($(".tbcs tr")[8]).html(tbcs8);
    			var tbcs9="<th class='cs-th'><div><a href=''>官方0-100km/h加速(s)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs9+="<td><div>"+data[i][9]+"</div></td>";
    			}
    			$($(".tbcs tr")[9]).html(tbcs9);
    			var tbcs10="<th class='cs-th'><div><a href=''>官方100-0制动(m)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs10+="<td><div>"+data[i][10]+"</div></td>";
    			}
    			$($(".tbcs tr")[10]).html(tbcs10);
    			var tbcs11="<th class='cs-th'><div><a href=''>官方综合路况油耗(L)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs11+="<td><div>"+data[i][11]+"</div></td>";
    			}
    			$($(".tbcs tr")[11]).html(tbcs11);
    			var tbcs12="<th class='cs-th'><div><a href=''>实测0-100km/h加速(s)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs12+="<td><div>"+data[i][12]+"</div></td>";
    			}
    			$($(".tbcs tr")[12]).html(tbcs12);
    			var tbcs13="<th class='cs-th'><div><a href=''>实测100-0km/h制动(m)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs13+="<td><div>"+data[i][13]+"</div></td>";
    			}
    			$($(".tbcs tr")[13]).html(tbcs13);
    			var tbcs14="<th class='cs-th'><div><a href=''>实测油耗(L)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs14+="<td><div>"+data[i][14]+"</div></td>";
    			}
    			$($(".tbcs tr")[14]).html(tbcs14);
    			var tbcs15="<th class='cs-th'><div><a href=''>生产年份</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs15+="<td><div>"+data[i][15]+"</div></td>";
    			}
    			$($(".tbcs tr")[15]).html(tbcs15);
    			var tbcs16="<th class='cs-th'><div><a href=''>添加日期</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs16+="<td><div>"+data[i][16]+"</div></td>";
    			}
    			$($(".tbcs tr")[16]).html(tbcs16);
    			var tbcs17="<th class='cs-th'><div><a href=''>更新日期</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs17+="<td><div>"+data[i][17]+"</div></td>";
    			}
    			$($(".tbcs tr")[17]).html(tbcs17);
    			var tbcs18="<th class='cs-th'><div><a href=''>厂商</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs18+="<td><div>"+data[i][18]+"</div></td>";
    			}
    			$($(".tbcs tr")[18]).html(tbcs18);
    			var tbcs19="<th class='cs-th'><div><a href=''>工信部综合油耗(L)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs19+="<td><div>"+data[i][19]+"</div></td>";
    			}
    			$($(".tbcs tr")[19]).html(tbcs19);
    			var tbcs20="<th class='cs-th'><div><a href=''>整车质保</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs20+="<td><div>"+data[i][20]+"</div></td>";
    			}
    			$($(".tbcs tr")[20]).html(tbcs20);
    			var tbcs21="<th class='cs-th'><div><a href=''>长(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs21+="<td><div>"+data[i][21]+"</div></td>";
    			}
    			$($(".tbcs tr")[22]).html(tbcs21);
    			var tbcs22="<th class='cs-th'><div><a href=''>宽(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs22+="<td><div>"+data[i][22]+"</div></td>";
    			}
    			$($(".tbcs tr")[23]).html(tbcs22);
    			var tbcs23="<th class='cs-th'><div><a href=''>高(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs23+="<td><div>"+data[i][23]+"</div></td>";
    			}
    			$($(".tbcs tr")[24]).html(tbcs23);
    			var tbcs24="<th class='cs-th'><div><a href=''>轴距(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs24+="<td><div>"+data[i][24]+"</div></td>";
    			}
    			$($(".tbcs tr")[25]).html(tbcs24);
    			var tbcs25="<th class='cs-th'><div><a href=''>前轮距(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs25+="<td><div>"+data[i][25]+"</div></td>";
    			}
    			$($(".tbcs tr")[26]).html(tbcs25);
    			var tbcs26="<th class='cs-th'><div><a href=''>后轮距(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs26+="<td><div>"+data[i][26]+"</div></td>";
    			}
    			$($(".tbcs tr")[27]).html(tbcs26);
    			var tbcs27="<th class='cs-th'><div><a href=''>最小离地间隙(mm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs27+="<td><div>"+data[i][27]+"</div></td>";
    			}
    			$($(".tbcs tr")[28]).html(tbcs27);
    			var tbcs28="<th class='cs-th'><div><a href=''>整备质量</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs28+="<td><div>"+data[i][28]+"</div></td>";
    			}
    			$($(".tbcs tr")[29]).html(tbcs28);
    			var tbcs29="<th class='cs-th'><div><a href=''>车身结构</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs29+="<td><div>"+data[i][29]+"</div></td>";
    			}
    			$($(".tbcs tr")[30]).html(tbcs29);
    			var tbcs30="<th class='cs-th'><div><a href=''>车门数(个)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs30+="<td><div>"+data[i][30]+"</div></td>";
    			}
    			$($(".tbcs tr")[31]).html(tbcs30);
    			var tbcs31="<th class='cs-th'><div><a href=''>座位牌数</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs31+="<td><div>"+data[i][31]+"</div></td>";
    			}
    			$($(".tbcs tr")[32]).html(tbcs31);
    			var tbcs32="<th class='cs-th'><div><a href=''>油箱容积(L)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs32+="<td><div>"+data[i][32]+"</div></td>";
    			}
    			$($(".tbcs tr")[33]).html(tbcs32);
    			var tbcs33="<th class='cs-th'><div><a href=''>行李箱容积(L)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs33+="<td><div>"+data[i][33]+"</div></td>";
    			}
    			$($(".tbcs tr")[34]).html(tbcs33);
    			var tbcs34="<th class='cs-th'><div><a href=''>发动机型号</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs34+="<td><div>"+data[i][34]+"</div></td>";
    			}
    			$($(".tbcs tr")[36]).html(tbcs34);
    			var tbcs35="<th class='cs-th'><div><a href=''>排量(mL)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs35+="<td><div>"+data[i][35]+"</div></td>";
    			}
    			$($(".tbcs tr")[37]).html(tbcs35);
    			var tbcs36="<th class='cs-th'><div><a href=''>排量级别</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs36+="<td><div>"+data[i][36]+"</div></td>";
    			}
    			$($(".tbcs tr")[38]).html(tbcs36);
    			var tbcs37="<th class='cs-th'><div><a href=''>进气形式</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs37+="<td><div>"+data[i][37]+"</div></td>";
    			}
    			$($(".tbcs tr")[39]).html(tbcs37);
    			var tbcs38="<th class='cs-th'><div><a href=''>气缸排列形式</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs38+="<td><div>"+data[i][38]+"</div></td>";
    			}
    			$($(".tbcs tr")[40]).html(tbcs38);
    			var tbcs39="<th class='cs-th'><div><a href=''>气缸数(个)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs39+="<td><div>"+data[i][39]+"</div></td>";
    			}
    			$($(".tbcs tr")[41]).html(tbcs39);
    			var tbcs40="<th class='cs-th'><div><a href=''>每缸气门数(个)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs40+="<td><div>"+data[i][40]+"</div></td>";
    			}
    			$($(".tbcs tr")[42]).html(tbcs40);
    			var tbcs41="<th class='cs-th'><div><a href=''>压缩比</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs41+="<td><div>"+data[i][41]+"</div></td>";
    			}
    			$($(".tbcs tr")[43]).html(tbcs41);
    			var tbcs42="<th class='cs-th'><div><a href=''>配气机构</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs42+="<td><div>"+data[i][42]+"</div></td>";
    			}
    			$($(".tbcs tr")[44]).html(tbcs42);
    			var tbcs43="<th class='cs-th'><div><a href=''>缸径</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs43+="<td><div>"+data[i][43]+"</div></td>";
    			}
    			$($(".tbcs tr")[45]).html(tbcs43);
    			var tbcs44="<th class='cs-th'><div><a href=''>行程</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs44+="<td><div>"+data[i][44]+"</div></td>";
    			}
    			$($(".tbcs tr")[46]).html(tbcs44);
    			var tbcs45="<th class='cs-th'><div><a href=''>最大马力(Ps)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs45+="<td><div>"+data[i][45]+"</div></td>";
    			}
    			$($(".tbcs tr")[47]).html(tbcs45);
    			var tbcs46="<th class='cs-th'><div><a href=''>最大功率(kW)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs46+="<td><div>"+data[i][46]+"</div></td>";
    			}
    			$($(".tbcs tr")[48]).html(tbcs46);
    			var tbcs47="<th class='cs-th'><div><a href=''>最大功率转速(rpm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs47+="<td><div>"+data[i][47]+"</div></td>";
    			}
    			$($(".tbcs tr")[49]).html(tbcs47);
    			var tbcs48="<th class='cs-th'><div><a href=''>最大扭矩(N·m)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs48+="<td><div>"+data[i][48]+"</div></td>";
    			}
    			$($(".tbcs tr")[50]).html(tbcs48);
    			var tbcs49="<th class='cs-th'><div><a href=''>最大扭矩转速(rpm)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs49+="<td><div>"+data[i][49]+"</div></td>";
    			}
    			$($(".tbcs tr")[51]).html(tbcs49);
    			var tbcs50="<th class='cs-th'><div><a href=''>发动机特有技术</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs50+="<td><div>"+data[i][50]+"</div></td>";
    			}
    			$($(".tbcs tr")[52]).html(tbcs50);
    			var tbcs51="<th class='cs-th'><div><a href=''>燃料形式</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs51+="<td><div>"+data[i][51]+"</div></td>";
    			}
    			$($(".tbcs tr")[53]).html(tbcs51);
    			var tbcs52="<th class='cs-th'><div><a href=''>燃油标号</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs52+="<td><div>"+data[i][52]+"</div></td>";
    			}
    			$($(".tbcs tr")[54]).html(tbcs52);
    			var tbcs53="<th class='cs-th'><div><a href=''>供油方式</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs53+="<td><div>"+data[i][53]+"</div></td>";
    			}
    			$($(".tbcs tr")[55]).html(tbcs53);
    			var tbcs54="<th class='cs-th'><div><a href=''>缸盖材料</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs54+="<td><div>"+data[i][54]+"</div></td>";
    			}
    			$($(".tbcs tr")[56]).html(tbcs54);
    			var tbcs55="<th class='cs-th'><div><a href=''>缸体材料</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs55+="<td><div>"+data[i][55]+"</div></td>";
    			}
    			$($(".tbcs tr")[57]).html(tbcs55);
    			var tbcs56="<th class='cs-th'><div><a href=''>环保标准</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs56+="<td><div>"+data[i][56]+"</div></td>";
    			}
    			$($(".tbcs tr")[58]).html(tbcs56);
    			var tbcs57="<th class='cs-th'><div><a href=''>简称</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs57+="<td><div>"+data[i][57]+"</div></td>";
    			}
    			$($(".tbcs tr")[60]).html(tbcs57);
    			var tbcs58="<th class='cs-th'><div><a href=''>挡位个数</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs58+="<td><div>"+data[i][58]+"</div></td>";
    			}
    			$($(".tbcs tr")[61]).html(tbcs58);
    			var tbcs59="<th class='cs-th'><div><a href=''>变速箱类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs59+="<td><div>"+data[i][59]+"</div></td>";
    			}
    			$($(".tbcs tr")[62]).html(tbcs59);
    			var tbcs60="<th class='cs-th'><div><a href=''>驱动方式</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs60+="<td><div>"+data[i][60]+"</div></td>";
    			}
    			$($(".tbcs tr")[64]).html(tbcs60);
    			var tbcs61="<th class='cs-th'><div><a href=''>前悬架类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs61+="<td><div>"+data[i][61]+"</div></td>";
    			}
    			$($(".tbcs tr")[65]).html(tbcs61);
    			var tbcs62="<th class='cs-th'><div><a href=''>后悬架类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs62+="<td><div>"+data[i][62]+"</div></td>";
    			}
    			$($(".tbcs tr")[66]).html(tbcs62);
    			var tbcs63="<th class='cs-th'><div><a href=''>助力类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs63+="<td><div>"+data[i][63]+"</div></td>";
    			}
    			$($(".tbcs tr")[67]).html(tbcs63);
    			var tbcs64="<th class='cs-th'><div><a href=''>前制动器类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs64+="<td><div>"+data[i][64]+"</div></td>";
    			}
    			$($(".tbcs tr")[69]).html(tbcs64);
    			var tbcs65="<th class='cs-th'><div><a href=''>后制动器类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs65+="<td><div>"+data[i][65]+"</div></td>";
    			}
    			$($(".tbcs tr")[70]).html(tbcs65);
    			var tbcs66="<th class='cs-th'><div><a href=''>驻车制动类型</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs66+="<td><div>"+data[i][66]+"</div></td>";
    			}
    			$($(".tbcs tr")[71]).html(tbcs66);
    			var tbcs67="<th class='cs-th'><div><a href=''>前轮胎规格</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs67+="<td><div>"+data[i][67]+"</div></td>";
    			}
    			$($(".tbcs tr")[72]).html(tbcs67);
    			var tbcs68="<th class='cs-th'><div><a href=''>后轮胎规格</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs68+="<td><div>"+data[i][68]+"</div></td>";
    			}
    			$($(".tbcs tr")[73]).html(tbcs68);
    			var tbcs69="<th class='cs-th'><div><a href=''>备胎规格</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs69+="<td><div>"+data[i][69]+"</div></td>";
    			}
    			$($(".tbcs tr")[74]).html(tbcs69);
    			var tbcs70="<th class='cs-th'><div><a href=''>驾驶座安全气囊</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs70+="<td><div>"+data[i][70]+"</div></td>";
    			}
    			$($(".tbcs tr")[76]).html(tbcs70);
    			var tbcs71="<th class='cs-th'><div><a href=''>副驾驶安全气囊</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs71+="<td><div>"+data[i][71]+"</div></td>";
    			}
    			$($(".tbcs tr")[77]).html(tbcs71);
    			var tbcs72="<th class='cs-th'><div><a href=''>前排侧气囊</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs72+="<td><div>"+data[i][72]+"</div></td>";
    			}
    			$($(".tbcs tr")[78]).html(tbcs72);
    			var tbcs73="<th class='cs-th'><div><a href=''>后排侧气囊</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs73+="<td><div>"+data[i][73]+"</div></td>";
    			}
    			$($(".tbcs tr")[79]).html(tbcs73);
    			var tbcs74="<th class='cs-th'><div><a href=''>前排头部气囊(气帘)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs74+="<td><div>"+data[i][74]+"</div></td>";
    			}
    			$($(".tbcs tr")[80]).html(tbcs74);
    			var tbcs75="<th class='cs-th'><div><a href=''>后排头部气囊(气帘)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs75+="<td><div>"+data[i][75]+"</div></td>";
    			}
    			$($(".tbcs tr")[81]).html(tbcs75);
    			var tbcs76="<th class='cs-th'><div><a href=''>膝部气囊</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs76+="<td><div>"+data[i][76]+"</div></td>";
    			}
    			$($(".tbcs tr")[82]).html(tbcs76);
    			var tbcs77="<th class='cs-th'><div><a href=''>安全带未系提示</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs77+="<td><div>"+data[i][77]+"</div></td>";
    			}
    			$($(".tbcs tr")[83]).html(tbcs77);
    			var tbcs78="<th class='cs-th'><div><a href=''>发动机电子防盗</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs78+="<td><div>"+data[i][78]+"</div></td>";
    			}
    			$($(".tbcs tr")[84]).html(tbcs78);
    			var tbcs79="<th class='cs-th'><div><a href=''>车内中控锁</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs79+="<td><div>"+data[i][79]+"</div></td>";
    			}
    			$($(".tbcs tr")[85]).html(tbcs79);
    			var tbcs80="<th class='cs-th'><div><a href=''>遥控钥匙</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs80+="<td><div>"+data[i][80]+"</div></td>";
    			}
    			$($(".tbcs tr")[86]).html(tbcs80);
    			var tbcs81="<th class='cs-th'><div><a href=''>无钥匙启动系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs81+="<td><div>"+data[i][81]+"</div></td>";
    			}
    			$($(".tbcs tr")[87]).html(tbcs81);
    			var tbcs82="<th class='cs-th'><div><a href=''>ISO FIX儿童座椅接口</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs82+="<td><div>"+data[i][82]+"</div></td>";
    			}
    			$($(".tbcs tr")[88]).html(tbcs82);
    			var tbcs83="<th class='cs-th'><div><a href=''>LATCH儿童座椅接口</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs83+="<td><div>"+data[i][83]+"</div></td>";
    			}
    			$($(".tbcs tr")[89]).html(tbcs83);
    			var tbcs84="<th class='cs-th'><div><a href=''>ABS防抱死</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs84+="<td><div>"+data[i][84]+"</div></td>";
    			}
    			$($(".tbcs tr")[91]).html(tbcs84);
    			var tbcs85="<th class='cs-th'><div><a href=''>制动力分配(EBD/CBC等)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs85+="<td><div>"+data[i][85]+"</div></td>";
    			}
    			$($(".tbcs tr")[92]).html(tbcs85);
    			var tbcs86="<th class='cs-th'><div><a href=''>刹车辅助(EBA/BAS/BA等)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs86+="<td><div>"+data[i][86]+"</div></td>";
    			}
    			$($(".tbcs tr")[93]).html(tbcs86);
    			var tbcs87="<th class='cs-th'><div><a href=''>牵引力控制(ASR/TCS/TRC等)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs87+="<td><div>"+data[i][87]+"</div></td>";
    			}
    			$($(".tbcs tr")[94]).html(tbcs87);
    			var tbcs88="<th class='cs-th'><div><a href=''>车身稳定控制(ESC/ESP/DSC等)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs88+="<td><div>"+data[i][88]+"</div></td>";
    			}
    			$($(".tbcs tr")[95]).html(tbcs88);
    			var tbcs89="<th class='cs-th'><div><a href=''>自动驻车/上坡辅助</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs89+="<td><div>"+data[i][89]+"</div></td>";
    			}
    			$($(".tbcs tr")[96]).html(tbcs89);
    			var tbcs90="<th class='cs-th'><div><a href=''>陡坡缓降</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs90+="<td><div>"+data[i][90]+"</div></td>";
    			}
    			$($(".tbcs tr")[97]).html(tbcs90);
    			var tbcs91="<th class='cs-th'><div><a href=''>可变悬架</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs91+="<td><div>"+data[i][91]+"</div></td>";
    			}
    			$($(".tbcs tr")[98]).html(tbcs91);
    			var tbcs92="<th class='cs-th'><div><a href=''>空气悬架</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs92+="<td><div>"+data[i][92]+"</div></td>";
    			}
    			$($(".tbcs tr")[99]).html(tbcs92);
    			var tbcs93="<th class='cs-th'><div><a href=''>胎压监测装置</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs93+="<td><div>"+data[i][93]+"</div></td>";
    			}
    			$($(".tbcs tr")[100]).html(tbcs93);
    			var tbcs94="<th class='cs-th'><div><a href=''>零胎压继续行驶</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs94+="<td><div>"+data[i][94]+"</div></td>";
    			}
    			$($(".tbcs tr")[101]).html(tbcs94);
    			var tbcs95="<th class='cs-th'><div><a href=''>可变转向比</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs95+="<td><div>"+data[i][95]+"</div></td>";
    			}
    			$($(".tbcs tr")[102]).html(tbcs95);
    			var tbcs96="<th class='cs-th'><div><a href=''>电动天窗</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs96+="<td><div>"+data[i][96]+"</div></td>";
    			}
    			$($(".tbcs tr")[104]).html(tbcs96);
    			var tbcs97="<th class='cs-th'><div><a href=''>全景天窗</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs97+="<td><div>"+data[i][97]+"</div></td>";
    			}
    			$($(".tbcs tr")[105]).html(tbcs97);
    			var tbcs98="<th class='cs-th'><div><a href=''>同色后视镜</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs98+="<td><div>"+data[i][98]+"</div></td>";
    			}
    			$($(".tbcs tr")[106]).html(tbcs98);
    			var tbcs99="<th class='cs-th'><div><a href=''>同色防擦条</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs99+="<td><div>"+data[i][99]+"</div></td>";
    			}
    			$($(".tbcs tr")[107]).html(tbcs99);
    			var tbcs100="<th class='cs-th'><div><a href=''>运动外观套件</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs100+="<td><div>"+data[i][100]+"</div></td>";
    			}
    			$($(".tbcs tr")[108]).html(tbcs100);
    			var tbcs101="<th class='cs-th'><div><a href=''>铝合金轮毂</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs101+="<td><div>"+data[i][101]+"</div></td>";
    			}
    			$($(".tbcs tr")[109]).html(tbcs101);
    			var tbcs102="<th class='cs-th'><div><a href=''>电动吸合门</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs102+="<td><div>"+data[i][102]+"</div></td>";
    			}
    			$($(".tbcs tr")[110]).html(tbcs102);
    			var tbcs103="<th class='cs-th'><div><a href=''>真皮方向盘</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs103+="<td><div>"+data[i][103]+"</div></td>";
    			}
    			$($(".tbcs tr")[112]).html(tbcs103);
    			var tbcs104="<th class='cs-th'><div><a href=''>方向盘上下调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs104+="<td><div>"+data[i][104]+"</div></td>";
    			}
    			$($(".tbcs tr")[113]).html(tbcs104);
    			var tbcs105="<th class='cs-th'><div><a href=''>方向盘前后调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs105+="<td><div>"+data[i][105]+"</div></td>";
    			}
    			$($(".tbcs tr")[114]).html(tbcs105);
    			var tbcs106="<th class='cs-th'><div><a href=''>方向盘电动调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs106+="<td><div>"+data[i][106]+"</div></td>";
    			}
    			$($(".tbcs tr")[115]).html(tbcs106);
    			var tbcs107="<th class='cs-th'><div><a href=''>多功能方向盘</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs107+="<td><div>"+data[i][107]+"</div></td>";
    			}
    			$($(".tbcs tr")[116]).html(tbcs107);
    			var tbcs108="<th class='cs-th'><div><a href=''>方向盘换挡</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs108+="<td><div>"+data[i][108]+"</div></td>";
    			}
    			$($(".tbcs tr")[117]).html(tbcs108);
    			var tbcs109="<th class='cs-th'><div><a href=''>定速巡航</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs109+="<td><div>"+data[i][109]+"</div></td>";
    			}
    			$($(".tbcs tr")[118]).html(tbcs109);
    			var tbcs110="<th class='cs-th'><div><a href=''>泊车辅助</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs110+="<td><div>"+data[i][110]+"</div></td>";
    			}
    			$($(".tbcs tr")[119]).html(tbcs110);
    			var tbcs111="<th class='cs-th'><div><a href=''>倒车视频影像</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs111+="<td><div>"+data[i][111]+"</div></td>";
    			}
    			$($(".tbcs tr")[120]).html(tbcs111);
    			var tbcs112="<th class='cs-th'><div><a href=''>行车电脑显示屏 </a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs112+="<td><div>"+data[i][112]+"</div></td>";
    			}
    			$($(".tbcs tr")[121]).html(tbcs112);
    			var tbcs113="<th class='cs-th'><div><a href=''>HUD抬头数字显示</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs113+="<td><div>"+data[i][113]+"</div></td>";
    			}
    			$($(".tbcs tr")[122]).html(tbcs113);
    			var tbcs114="<th class='cs-th'><div><a href=''>左脚休息踏板</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs114+="<td><div>"+data[i][114]+"</div></td>";
    			}
    			$($(".tbcs tr")[123]).html(tbcs114);
    			var tbcs115="<th class='cs-th'><div><a href=''>真皮/仿皮座椅</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs115+="<td><div>"+data[i][115]+"</div></td>";
    			}
    			$($(".tbcs tr")[125]).html(tbcs115);
    			var tbcs116="<th class='cs-th'><div><a href=''>运动风格座椅</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs116+="<td><div>"+data[i][116]+"</div></td>";
    			}
    			$($(".tbcs tr")[126]).html(tbcs116);
    			var tbcs117="<th class='cs-th'><div><a href=''>腰部支撑调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs117+="<td><div>"+data[i][117]+"</div></td>";
    			}
    			$($(".tbcs tr")[127]).html(tbcs117);
    			var tbcs118="<th class='cs-th'><div><a href=''>肩部支撑调节 </a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs118+="<td><div>"+data[i][118]+"</div></td>";
    			}
    			$($(".tbcs tr")[128]).html(tbcs118);
    			var tbcs119="<th class='cs-th'><div><a href=''>前排座椅电动调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs119+="<td><div>"+data[i][119]+"</div></td>";
    			}
    			$($(".tbcs tr")[129]).html(tbcs119);
    			var tbcs120="<th class='cs-th'><div><a href=''>第二排靠背角度调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs120+="<td><div>"+data[i][120]+"</div></td>";
    			}
    			$($(".tbcs tr")[130]).html(tbcs120);
    			var tbcs121="<th class='cs-th'><div><a href=''>后排座椅手动调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs121+="<td><div>"+data[i][121]+"</div></td>";
    			}
    			$($(".tbcs tr")[131]).html(tbcs121);
    			var tbcs122="<th class='cs-th'><div><a href=''>后排座椅电动调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs122+="<td><div>"+data[i][122]+"</div></td>";
    			}
    			$($(".tbcs tr")[132]).html(tbcs122);
    			var tbcs123="<th class='cs-th'><div><a href=''>电动座椅记忆</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs123+="<td><div>"+data[i][123]+"</div></td>";
    			}
    			$($(".tbcs tr")[133]).html(tbcs123);
    			var tbcs124="<th class='cs-th'><div><a href=''>前排座椅加热</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs124+="<td><div>"+data[i][124]+"</div></td>";
    			}
    			$($(".tbcs tr")[134]).html(tbcs124);
    			var tbcs125="<th class='cs-th'><div><a href=''>后排座椅加热</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs125+="<td><div>"+data[i][125]+"</div></td>";
    			}
    			$($(".tbcs tr")[135]).html(tbcs125);
    			var tbcs126="<th class='cs-th'><div><a href=''>座椅通风</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs126+="<td><div>"+data[i][126]+"</div></td>";
    			}
    			$($(".tbcs tr")[136]).html(tbcs126);
    			var tbcs127="<th class='cs-th'><div><a href=''>座椅按摩</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs127+="<td><div>"+data[i][127]+"</div></td>";
    			}
    			$($(".tbcs tr")[137]).html(tbcs127);
    			var tbcs128="<th class='cs-th'><div><a href=''>后排座椅整体放倒</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs128+="<td><div>"+data[i][128]+"</div></td>";
    			}
    			$($(".tbcs tr")[138]).html(tbcs128);
    			var tbcs129="<th class='cs-th'><div><a href=''>后排座椅比例放倒</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs129+="<td><div>"+data[i][129]+"</div></td>";
    			}
    			$($(".tbcs tr")[139]).html(tbcs129);
    			var tbcs130="<th class='cs-th'><div><a href=''>第三排座椅</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs130+="<td><div>"+data[i][130]+"</div></td>";
    			}
    			$($(".tbcs tr")[140]).html(tbcs130);
    			var tbcs131="<th class='cs-th'><div><a href=''>前座中央扶手</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs131+="<td><div>"+data[i][131]+"</div></td>";
    			}
    			$($(".tbcs tr")[141]).html(tbcs131);
    			var tbcs132="<th class='cs-th'><div><a href=''>后座中央扶手</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs132+="<td><div>"+data[i][132]+"</div></td>";
    			}
    			$($(".tbcs tr")[142]).html(tbcs132);
    			var tbcs133="<th class='cs-th'><div><a href=''>前排杯架</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs133+="<td><div>"+data[i][133]+"</div></td>";
    			}
    			$($(".tbcs tr")[143]).html(tbcs133);
    			var tbcs134="<th class='cs-th'><div><a href=''>后排杯架</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs134+="<td><div>"+data[i][134]+"</div></td>";
    			}
    			$($(".tbcs tr")[144]).html(tbcs134);
    			var tbcs135="<th class='cs-th'><div><a href=''>电动后备厢</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs135+="<td><div>"+data[i][135]+"</div></td>";
    			}
    			$($(".tbcs tr")[145]).html(tbcs135);
    			var tbcs136="<th class='cs-th'><div><a href=''>GPS导航系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs136+="<td><div>"+data[i][136]+"</div></td>";
    			}
    			$($(".tbcs tr")[147]).html(tbcs136);
    			var tbcs137="<th class='cs-th'><div><a href=''>定位互动服务</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs137+="<td><div>"+data[i][137]+"</div></td>";
    			}
    			$($(".tbcs tr")[148]).html(tbcs137);
    			var tbcs138="<th class='cs-th'><div><a href=''>中控台彩色大屏</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs138+="<td><div>"+data[i][138]+"</div></td>";
    			}
    			$($(".tbcs tr")[149]).html(tbcs138);
    			var tbcs139="<th class='cs-th'><div><a href=''>人机交互系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs139+="<td><div>"+data[i][139]+"</div></td>";
    			}
    			$($(".tbcs tr")[150]).html(tbcs139);
    			var tbcs140="<th class='cs-th'><div><a href=''>内置硬盘</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs140+="<td><div>"+data[i][140]+"</div></td>";
    			}
    			$($(".tbcs tr")[151]).html(tbcs140);
    			var tbcs141="<th class='cs-th'><div><a href=''>蓝牙系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs141+="<td><div>"+data[i][141]+"</div></td>";
    			}
    			$($(".tbcs tr")[152]).html(tbcs141);
    			var tbcs142="<th class='cs-th'><div><a href=''>蓝牙/车载电话</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs142+="<td><div>"+data[i][142]+"</div></td>";
    			}
    			$($(".tbcs tr")[153]).html(tbcs142);
    			var tbcs143="<th class='cs-th'><div><a href=''>车载电视</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs143+="<td><div>"+data[i][143]+"</div></td>";
    			}
    			$($(".tbcs tr")[154]).html(tbcs143);
    			var tbcs144="<th class='cs-th'><div><a href=''>车载电话</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs144+="<td><div>"+data[i][144]+"</div></td>";
    			}
    			$($(".tbcs tr")[155]).html(tbcs144);
    			var tbcs145="<th class='cs-th'><div><a href=''>后排液晶屏</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs145+="<td><div>"+data[i][145]+"</div></td>";
    			}
    			$($(".tbcs tr")[156]).html(tbcs145);
    			var tbcs146="<th class='cs-th'><div><a href=''>外接音源接口(AUX/USB/iPod等)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs146+="<td><div>"+data[i][146]+"</div></td>";
    			}
    			$($(".tbcs tr")[157]).html(tbcs146);
    			var tbcs147="<th class='cs-th'><div><a href=''>CD支持MP3/WMA</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs147+="<td><div>"+data[i][147]+"</div></td>";
    			}
    			$($(".tbcs tr")[158]).html(tbcs147);
    			var tbcs148="<th class='cs-th'><div><a href=''>单碟CD</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs148+="<td><div>"+data[i][148]+"</div></td>";
    			}
    			$($(".tbcs tr")[159]).html(tbcs148);
    			var tbcs149="<th class='cs-th'><div><a href=''>虚拟多碟CD</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs149+="<td><div>"+data[i][149]+"</div></td>";
    			}
    			$($(".tbcs tr")[160]).html(tbcs149);
    			var tbcs150="<th class='cs-th'><div><a href=''>多碟CD系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs150+="<td><div>"+data[i][150]+"</div></td>";
    			}
    			$($(".tbcs tr")[161]).html(tbcs150);
    			var tbcs151="<th class='cs-th'><div><a href=''>单碟DVD</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs151+="<td><div>"+data[i][151]+"</div></td>";
    			}
    			$($(".tbcs tr")[162]).html(tbcs151);
    			var tbcs152="<th class='cs-th'><div><a href=''>多碟DVD系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs152+="<td><div>"+data[i][152]+"</div></td>";
    			}
    			$($(".tbcs tr")[163]).html(tbcs152);
    			var tbcs153="<th class='cs-th'><div><a href=''>2-3喇叭扬声器系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs153+="<td><div>"+data[i][153]+"</div></td>";
    			}
    			$($(".tbcs tr")[164]).html(tbcs153);
    			var tbcs154="<th class='cs-th'><div><a href=''>4-5喇叭扬声器系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs154+="<td><div>"+data[i][154]+"</div></td>";
    			}
    			$($(".tbcs tr")[165]).html(tbcs154);
    			var tbcs155="<th class='cs-th'><div><a href=''>6-7喇叭扬声器系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs155+="<td><div>"+data[i][155]+"</div></td>";
    			}
    			$($(".tbcs tr")[166]).html(tbcs155);
    			var tbcs156="<th class='cs-th'><div><a href=''>≥8喇叭扬声器系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs156+="<td><div>"+data[i][156]+"</div></td>";
    			}
    			$($(".tbcs tr")[167]).html(tbcs156);
    			var tbcs157="<th class='cs-th'><div><a href=''>氙气大灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs157+="<td><div>"+data[i][157]+"</div></td>";
    			}
    			$($(".tbcs tr")[169]).html(tbcs157);
    			var tbcs158="<th class='cs-th'><div><a href=''>日间行车灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs158+="<td><div>"+data[i][158]+"</div></td>";
    			}
    			$($(".tbcs tr")[170]).html(tbcs158);
    			var tbcs159="<th class='cs-th'><div><a href=''>自动头灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs159+="<td><div>"+data[i][159]+"</div></td>";
    			}
    			$($(".tbcs tr")[171]).html(tbcs159);
    			var tbcs160="<th class='cs-th'><div><a href=''>转向头灯(辅助灯)</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs160+="<td><div>"+data[i][160]+"</div></td>";
    			}
    			$($(".tbcs tr")[172]).html(tbcs160);
    			var tbcs161="<th class='cs-th'><div><a href=''>前雾灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs161+="<td><div>"+data[i][161]+"</div></td>";
    			}
    			$($(".tbcs tr")[173]).html(tbcs161);
    			var tbcs162="<th class='cs-th'><div><a href=''>后雾灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs162+="<td><div>"+data[i][162]+"</div></td>";
    			}
    			$($(".tbcs tr")[174]).html(tbcs162);
    			var tbcs163="<th class='cs-th'><div><a href=''>大灯高度可调</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs163+="<td><div>"+data[i][163]+"</div></td>";
    			}
    			$($(".tbcs tr")[175]).html(tbcs163);
    			var tbcs164="<th class='cs-th'><div><a href=''>大灯清洗装置</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs164+="<td><div>"+data[i][164]+"</div></td>";
    			}
    			$($(".tbcs tr")[176]).html(tbcs164);
    			var tbcs165="<th class='cs-th'><div><a href=''>车内氛围灯</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs165+="<td><div>"+data[i][165]+"</div></td>";
    			}
    			$($(".tbcs tr")[177]).html(tbcs165);
    			var tbcs166="<th class='cs-th'><div><a href=''>前电动车窗</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs166+="<td><div>"+data[i][166]+"</div></td>";
    			}
    			$($(".tbcs tr")[179]).html(tbcs166);
    			var tbcs167="<th class='cs-th'><div><a href=''>后电动车窗</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs167+="<td><div>"+data[i][167]+"</div></td>";
    			}
    			$($(".tbcs tr")[180]).html(tbcs167);
    			var tbcs168="<th class='cs-th'><div><a href=''>车窗防夹手功能</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs168+="<td><div>"+data[i][168]+"</div></td>";
    			}
    			$($(".tbcs tr")[181]).html(tbcs168);
    			var tbcs169="<th class='cs-th'><div><a href=''>防紫外线/隔热玻璃</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs169+="<td><div>"+data[i][169]+"</div></td>";
    			}
    			$($(".tbcs tr")[182]).html(tbcs169);
    			var tbcs170="<th class='cs-th'><div><a href=''>后视镜电动调节</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs170+="<td><div>"+data[i][170]+"</div></td>";
    			}
    			$($(".tbcs tr")[183]).html(tbcs170);
    			var tbcs171="<th class='cs-th'><div><a href=''>后视镜加热</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs171+="<td><div>"+data[i][171]+"</div></td>";
    			}
    			$($(".tbcs tr")[184]).html(tbcs171);
    			var tbcs172="<th class='cs-th'><div><a href=''>内/外后视镜自动防眩目</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs172+="<td><div>"+data[i][172]+"</div></td>";
    			}
    			$($(".tbcs tr")[185]).html(tbcs172);
    			var tbcs173="<th class='cs-th'><div><a href=''>后视镜电动折叠</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs173+="<td><div>"+data[i][173]+"</div></td>";
    			}
    			$($(".tbcs tr")[186]).html(tbcs173);
    			var tbcs174="<th class='cs-th'><div><a href=''>后视镜记忆</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs174+="<td><div>"+data[i][174]+"</div></td>";
    			}
    			$($(".tbcs tr")[187]).html(tbcs174);
    			var tbcs175="<th class='cs-th'><div><a href=''>后风挡遮阳帘</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs175+="<td><div>"+data[i][175]+"</div></td>";
    			}
    			$($(".tbcs tr")[188]).html=(tbcs175);
    			var tbcs176="<th class='cs-th'><div><a href=''>后排侧遮阳帘</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs176+="<td><div>"+data[i][176]+"</div></td>";
    			}
    			$($(".tbcs tr")[189]).html(tbcs176);
    			var tbcs177="<th class='cs-th'><div><a href=''>遮阳板化妆镜</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs177+="<td><div>"+data[i][177]+"</div></td>";
    			}
    			$($(".tbcs tr")[190]).html(tbcs177);
    			var tbcs178="<th class='cs-th'><div><a href=''>后雨刷</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs178+="<td><div>"+data[i][178]+"</div></td>";
    			}
    			$($(".tbcs tr")[191]).html(tbcs178);
    			var tbcs179="<th class='cs-th'><div><a href=''>感应雨刷</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs179+="<td><div>"+data[i][179]+"</div></td>";
    			}
    			$($(".tbcs tr")[192]).html(tbcs179);
    			var tbcs180="<th class='cs-th'><div><a href=''>手动空调</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs180+="<td><div>"+data[i][180]+"</div></td>";
    			}
    			$($(".tbcs tr")[194]).html(tbcs180);
    			var tbcs181="<th class='cs-th'><div><a href=''>自动空调</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs181+="<td><div>"+data[i][181]+"</div></td>";
    			}
    			$($(".tbcs tr")[195]).html(tbcs181);
    			var tbcs182="<th class='cs-th'><div><a href=''>后排独立空调</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs182+="<td><div>"+data[i][182]+"</div></td>";
    			}
    			$($(".tbcs tr")[196]).html(tbcs182);
    			var tbcs183="<th class='cs-th'><div><a href=''>后座出风口</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs183+="<td><div>"+data[i][183]+"</div></td>";
    			}
    			$($(".tbcs tr")[197]).html(tbcs183);
    			var tbcs184="<th class='cs-th'><div><a href=''>温度分区控制</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs184+="<td><div>"+data[i][184]+"</div></td>";
    			}
    			$($(".tbcs tr")[198]).html(tbcs184);
    			var tbcs185="<th class='cs-th'><div><a href=''>空气调节/花粉过滤</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs185+="<td><div>"+data[i][185]+"</div></td>";
    			}
    			$($(".tbcs tr")[199]).html(tbcs185);
    			var tbcs186="<th class='cs-th'><div><a href=''>车载冰箱</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs186+="<td><div>"+data[i][186]+"</div></td>";
    			}
    			$($(".tbcs tr")[200]).html(tbcs186);
    			var tbcs187="<th class='cs-th'><div><a href=''>自动泊车入位</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs187+="<td><div>"+data[i][187]+"</div></td>";
    			}
    			$($(".tbcs tr")[202]).html(tbcs187);
    			var tbcs188="<th class='cs-th'><div><a href=''>并线辅助</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs188+="<td><div>"+data[i][188]+"</div></td>";
    			}
    			$($(".tbcs tr")[203]).html(tbcs188);
    			var tbcs189="<th class='cs-th'><div><a href=''>主动刹车/主动安全系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs189+="<td><div>"+data[i][189]+"</div></td>";
    			}
    			$($(".tbcs tr")[204]).html(tbcs189);
    			var tbcs190="<th class='cs-th'><div><a href=''>整体主动转向系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs190+="<td><div>"+data[i][190]+"</div></td>";
    			}
    			$($(".tbcs tr")[205]).html(tbcs190);
    			var tbcs191="<th class='cs-th'><div><a href=''>夜视系统</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs191+="<td><div>"+data[i][191]+"</div></td>";
    			}
    			$($(".tbcs tr")[206]).html(tbcs191);
    			var tbcs192="<th class='cs-th'><div><a href=''>中控液晶屏分屏显示</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs192+="<td><div>"+data[i][192]+"</div></td>";
    			}
    			$($(".tbcs tr")[207]).html(tbcs192);
    			var tbcs193="<th class='cs-th'><div><a href=''>自适应巡航</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs193+="<td><div>"+data[i][193]+"</div></td>";
    			}
    			$($(".tbcs tr")[208]).html(tbcs193);
    			var tbcs194="<th class='cs-th'><div><a href=''>全景摄像头</a></div></th>";
    			for(var i=0;i<data.length;i++){
    				tbcs194+="<td><div>"+data[i][194]+"</div></td>";
    			}
    			$($(".tbcs tr")[209]).html(tbcs194);
    			$(".cs-title").attr("colspan",lengA+1);
}


function showA(e){
	var trArray=$(".tbcs tr");
	if(e.checked){
		for(var i=0;i<trArray.length;i++){
			if(i!=1&&i!=21&&i!=35&&i!=59&&i!=63&&i!=68&&i!=75&&i!=90&&i!=103&&i!=111&&i!=124&&i!=146&&i!=168&&i!=178&&i!=193&&i!=201){
				var tdArray=$(".tbcs tr:eq("+i+")").find("td");
				var td1=$(".tbcs tr:eq("+i+") td:eq(0)").html();
				var j=0;
				for(var m=1;m<tdArray.length;m++){
					if(td1==tdArray[m].innerHTML){
						j++;
					}
				}
				if(j==tdArray.length-1){
					
				}else{
					$(".tbcs tr:eq("+i+")").addClass("highlight");
				}
			}
		}
	}else{
		for(var i=0;i<trArray.length;i++){
			var trStr=$(".tbcs tr:eq("+i+")");
			trStr.removeClass("highlight");
		}	
	}
}


function hideA(e){
	var trArray=$(".tbcs tr");
	if(e.checked){
		for(var i=0;i<trArray.length;i++){
			if(i!=1&&i!=21&&i!=35&&i!=59&&i!=63&&i!=68&&i!=75&&i!=90&&i!=103&&i!=111&&i!=124&&i!=146&&i!=168&&i!=178&&i!=193&&i!=201){
				var tdArray=$(".tbcs tr:eq("+i+")").find("td");
				var td1=$(".tbcs tr:eq("+i+") td:eq(0)").html();
				var j=0;
				for(var m=1;m<tdArray.length;m++){
					if(td1==tdArray[m].innerHTML){
						j++;
					}
				}
				if(j==tdArray.length-1){
					$(".tbcs tr:eq("+i+")").hide();
				}
			}
		}
	}else{
		for(var i=0;i<trArray.length;i++){
			var trStr=$(".tbcs tr:eq("+i+")");
			trStr.show();
		}	
	}
}


</script>



