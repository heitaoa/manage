<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>第十五届武汉国际汽车展览会</title>
	<link rel="stylesheet" href="http://zt.315che.com/wuhan/150420/css/styles.css">
	<link rel="stylesheet" href="http://zt.315che.com/cz/141031/css/main.css">
	<link rel="stylesheet" href="http://zt.315che.com/common/css/315che-base.css">
	<script src="http://zt.315che.com/common/js/jquery-1.11.1.min.js"></script>
    <script src="http://www.315che.com/js/jquery.bxslider.min.js"></script>
</head>
<body>
	 <!-- 头部 -->
    <div class="mihead-bg">
        <div id="goto-top" class="mihead">
            <div class="milogo">
                <a href="http://www.315che.com/" onfocus="this.blur();"><strong>中国汽车消费网</strong></a>
            </div>
            <div class="midaohang">
                <a href="http://www.315che.com/">首页</a>
                <a href="http://www.315che.com/newcar/">新车</a>
                <a href="http://inf.315che.com/">新闻</a>
                <a href="http://www.315che.com/buy/">导购</a>
                <a href="http://www.315che.com/pingce/">试驾评测</a>
                <a href="http://www.315che.com/pic/">图库</a>
                <a href="http://www.315che.com/hq/">行情</a>
                <a href="http://auto.315che.com/">报价</a>
                <a href="http://4s.315che.com/">经销商</a>
                <a href="http://www.315che.com/tools/">工具</a>
                <a href="http://bbs.315che.com/">论坛</a>
                <a href="http://tousu.315che.com/">汽车投诉</a>
                <a href="http://www.315che.com/kanche/" class="highlight">小胖看车团</a>
            </div>
            <div class="micity">
                <span style="font-weight:bold; color:#FFFFFF;">城市站：</span>
                <a title="上海站" href="http://www.315che.com/sh/">上海</a>
                <a title="北京站" href="http://www.315che.com/bj/">北京</a>
                <a title="广州站" href="http://www.315che.com/gz/">广州</a>
                <a title="成都站" href="http://www.315che.com/chengdu/">成都</a>
                <a title="武汉站" href="http://www.315che.com/wuhan/">武汉</a>
                <a title="南京站" href="http://www.315che.com/nanjing/">南京</a>
                <a title="合肥站" href="http://www.315che.com/hefei/">合肥</a>
                <a title="大连站" href="http://www.315che.com/dalian/">大连</a>
            </div>
        </div>
    </div>
	<div class="header">
		<div class="content">
			<div class="nav">
				<ul>
					<li class="nav_01"><a href="#">车展简介</a></li>
					<li class="nav_02"><a href="#">车展新闻</a></li>
					<li class="nav_03"><a href="#">参观攻略</a></li>
					<li class="nav_04"><a href="#">新车速递</a></li>
					<li class="nav_05"><a href="#">车模展台</a></li>
					<li class="nav_06"><a href="#">改装车展</a></li>
					<li class="nav_07"><a href="#">合作品牌</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="mainbody">
		<div class="content">
			<div class="row">
				<div class="focus-banner">
					<ul id="top-focus">
						<#if dataMap.get("焦点图")??>
							<#list dataMap.get("焦点图") as data>
								<#if data_index lt 4>
									<li><a href="${data.link!}" target="_blank"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" title="${data.title!}"></a></li>
								</#if>
							</#list>
						</#if>	
					</ul>
					<script>
					$(document).ready(function(){
					  $('#top-focus').bxSlider({
					    auto: true,
					  	captions: true,
					  	controls: false
					  });
					});
					</script>
				</div>
				<div class="side-01">
					<div class="title title-01"><img src="http://zt.315che.com/wuhan/150420/images/title_01.gif" alt=""></div>
					<div class="con">
						<h4>地址：汉阳区鹦鹉大道619号</h4>
						<p style="margin-top:10px;">公交：市内的观众可以乘580路、61路、648路、554路、704路、727路、728路至国际博览中心交通港<br>
							自驾、的士路线推荐（供观展车友参考）：<br>
							汉阳出发：从钟家村上鹦鹉大道后，沿着鹦鹉大道直通武汉国际博览中心；<br>
							武昌出发：白沙洲大桥，从武汉国际博览中心标识出口处下桥；<br>
							汉口出发：江城大道四新南、北路都可以到展馆。<br></p>
						<!-- <p>因观展人数众多，组委会强烈建议大家绿色出行<br>
						地铁：2号线、10号线元通站4号出口<br>
						有轨电车：会展中心站</p> -->
						<!-- <div class="wx"><img src="images/weixin.gif" alt=""></div> -->
					</div>
				</div>
			</div>
			<div class="row">
				<div class="news-list">
					<div class="title title-02"><img src="http://zt.315che.com/wuhan/150420/images/title_02.gif" alt=""></div>
					<div class="con">
						<ul>
							<#if dataMap.get("车展新闻w158_h120")??>
								<#list dataMap.get("车展新闻w158_h120") as data>
									<#if data_index lt 3>
										<li>
											<a href="${data.link!}" target="_blank">
												<div class="pic"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}"></div>
												<h3>${data.title!}</h3>
												<p><#if data.content??><#if data.content?length gt 100>${data.content.substring(0,100)}<#else>${data.content!}</#if></#if><em>【详细】</em></p>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</div>
				</div>
				<div class="side-02">
					<div class="title title-03"><img src="http://zt.315che.com/wuhan/150420/images/title_03.gif" alt=""></div>
					<div class="con" style="text-align:center;"><img src="http://zt.315che.com/wuhan/150420/images/cz_intro.gif" alt=""></div>
				</div>
			</div>
			<div class="row">
				<div class="title title-04"><img src="http://zt.315che.com/wuhan/150420/images/title_04.gif" alt=""></div>
				<div class="focus-box">
					<div class="focus-con">
						<#if dataMap.get("新车速递大图w308_h256")??>
							<#list dataMap.get("新车速递大图w308_h256") as data>
								<#if data_index lt 1>
									<div class="car-pic-left">
										<a href="${data.link!}" target="_blank">
											<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}">
											<span></span>
											<p>${data.title!}</p>
										</a>
									</div>
								</#if>
							</#list>
						</#if>
						<#if dataMap.get("新车速递小图w160_h124")??>
							<#list dataMap.get("新车速递小图w160_h124") as data>
								<#if data_index lt 8>
									<div class="car-pic-car_thumb">
										<a href="${data.link!}" target="_blank">
											<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}">
											<span></span>
											<p>${data.title!}</p>
										</a>
									</div>
								</#if>
							</#list>
						</#if>
					</div>
				</div>
				<ul class="focus-dot" style="display:none;">
					<li class="current"></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="row">
				<div class="title title-05"><img src="http://zt.315che.com/wuhan/150420/images/title_05.gif" alt=""></div>
				<div class="model-box">
					<div class="model-con">
						<ul>
							<#if dataMap.get("车模展台_w234_h351")??>
								<#list dataMap.get("车模展台_w234_h351") as data>
									<#if data_index lt 4>
										<li>
											<a href="${data.link!}" target="_blank">
												<div class="pic"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}"></div>
												<p class="txt">${data.title!}</p>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</div>
				</div>
				<ul class="focus-dot" style="display:none;">
					<li class="current"></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="row">
				<div class="title title-06"><img src="http://zt.315che.com/wuhan/150420/images/title_06.gif" alt=""></div>
				<div class="cartuning-box">
					<div class="cartuning-con">
						<ul>
							<#if dataMap.get("改装车展_w235_h180")??>
								<#list dataMap.get("改装车展_w235_h180") as data>
									<#if data_index lt 8>
										<li>
											<a href="${data.link!}" target="_blank">
												<div class="pic"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}"></div>
												<p class="txt">${data.title!}</p>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</div>
				</div>
				<ul class="focus-dot" style="display:none;">
					<li class="current"></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="row">
				<div class="title title-07"><img src="http://zt.315che.com/wuhan/150420/images/title_07.gif" alt=""></div>
				<div class="links_wrap" id="conBrand">
				<ul class="dl_com clearfix">
			         <li>
					   <a href="http://www.beijing-hyundai.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5181e973da.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.saicmg.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5162e9434d.jpg"></a>
					 </li>									 <li>
					   <a href="http://china.smart.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51782c2832.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-benteng.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d518626f0bc.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chana-mazda.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5190164303.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.wdhac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51966218ba.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.peugeot.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5197ae58e8.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dongfeng-citroen.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d519a04017b.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gacfiatauto.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51a7449b3a.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gac-toyota.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51b27354cd.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.jaguar.com/cn/zh/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51dc78df6b.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.landrover.com/cn/zh/lr/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e30c3d86.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.hyundai-motor.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e5860b34.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.cadillac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e864cccb.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.lexus.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f4368bd9.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.renault.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f5e9fce5.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.roewe.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d52047dafa6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.csvw.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5206fcddf6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.smotor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d520a90d717.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.subaru-china.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5210e5819e.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.skoda.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5213f50a35.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.volvocars.com/zh-cn/&lrm;" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5215b6833f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chevrolet.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5218395659.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-vw.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5219fcb228.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.ftms.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d521c40a10e.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-mazda.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d521dec6c34.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.acura.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d4dc8eb3d7d.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.china.bentleymotors.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5189a59b35.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.rolls-roycemotorcars.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51eee29c38.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.buick.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d515a4f1786.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.lamborghini.com/cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51ea79cf72.jpg"></a>
					 </li>									 <li>
					   <a href="www.astonmartin.com/zh&lrm;" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d517ad2b271.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.ford.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5150c26525.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mclaren.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d53f0e75d75.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.infiniti.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5100d735cb.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dyk.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5103f997fe.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gmc.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d515e9e2119.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.minichina.com.cn/mini/cn/zh/index.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d4dcb1caaf6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mercedes-benz.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5184c10191.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.nissan.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d510853c442.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.maybach-manufaktur.com/zh" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51fa0ab76f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.bmw.com.cn/cn/zh/index.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5116543ef3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.opel.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d514f0872b1.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.audi.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d517cc61436.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.vw.com.cn/zh.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51402020c1.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mitsubishi-motors.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5157e98d7a.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.jac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51d8adfc9c.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gwm.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5191a2b727.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chery.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5201c4c666.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.guangzhouhonda.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d514cd4999f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.haima.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51b41824b3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.changan.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d518e6d65b6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gleagleauto.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d510d951841.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.zoemo.net/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5222528060.jpg"></a>
					 </li>									 <li>
					   <a href="http://auto.lifan.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f7dd72a7.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dfpv.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51accda820.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.fxauto.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51af9c90e0.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.soueast-motor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d519f353f5d.jpg"></a>
					 </li>									 <li>
					   <a href="http://trumpchi.gacmotor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5193435364.jpg"></a>
					 </li>									 <li>
					   <a href="http://autobaojun.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51807070f2.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.changansuzuki.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5142559b5c.jpg"></a>
					 </li>									 <li>
					   <a href="http;//www.bydauto.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51882909e3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.emgrandauto.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5111bd8246.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.engloncar.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d511453dcae.jpg"></a>
					 </li>		          			  		 <li>
					   <a href="http://www.beijing-hyundai.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5181e973da.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.saicmg.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5162e9434d.jpg"></a>
					 </li>									 <li>
					   <a href="http://china.smart.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51782c2832.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-benteng.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d518626f0bc.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chana-mazda.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5190164303.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.wdhac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51966218ba.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.peugeot.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5197ae58e8.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dongfeng-citroen.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d519a04017b.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gacfiatauto.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51a7449b3a.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gac-toyota.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51b27354cd.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.jaguar.com/cn/zh/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51dc78df6b.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.landrover.com/cn/zh/lr/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e30c3d86.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.hyundai-motor.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e5860b34.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.cadillac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51e864cccb.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.lexus.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f4368bd9.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.renault.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f5e9fce5.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.roewe.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d52047dafa6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.csvw.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5206fcddf6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.smotor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d520a90d717.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.subaru-china.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5210e5819e.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.skoda.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5213f50a35.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.volvocars.com/zh-cn/&lrm;" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5215b6833f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chevrolet.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5218395659.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-vw.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5219fcb228.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.ftms.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d521c40a10e.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.faw-mazda.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d521dec6c34.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.acura.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d4dc8eb3d7d.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.china.bentleymotors.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5189a59b35.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.rolls-roycemotorcars.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51eee29c38.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.buick.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d515a4f1786.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.lamborghini.com/cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51ea79cf72.jpg"></a>
					 </li>									 <li>
					   <a href="www.astonmartin.com/zh&lrm;" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d517ad2b271.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.ford.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5150c26525.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mclaren.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d53f0e75d75.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.infiniti.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5100d735cb.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dyk.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5103f997fe.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gmc.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d515e9e2119.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.minichina.com.cn/mini/cn/zh/index.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d4dcb1caaf6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mercedes-benz.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5184c10191.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.nissan.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d510853c442.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.maybach-manufaktur.com/zh" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51fa0ab76f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.bmw.com.cn/cn/zh/index.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5116543ef3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.opel.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d514f0872b1.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.audi.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d517cc61436.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.vw.com.cn/zh.html" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51402020c1.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.mitsubishi-motors.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5157e98d7a.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.jac.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51d8adfc9c.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gwm.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5191a2b727.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.chery.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5201c4c666.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.guangzhouhonda.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d514cd4999f.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.haima.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51b41824b3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.changan.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d518e6d65b6.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.gleagleauto.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d510d951841.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.zoemo.net/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5222528060.jpg"></a>
					 </li>									 <li>
					   <a href="http://auto.lifan.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51f7dd72a7.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.dfpv.com.cn/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51accda820.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.fxauto.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51af9c90e0.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.soueast-motor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d519f353f5d.jpg"></a>
					 </li>									 <li>
					   <a href="http://trumpchi.gacmotor.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5193435364.jpg"></a>
					 </li>									 <li>
					   <a href="http://autobaojun.com" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51807070f2.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.changansuzuki.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5142559b5c.jpg"></a>
					 </li>									 <li>
					   <a href="http;//www.bydauto.com.cn" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d51882909e3.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.emgrandauto.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d5111bd8246.jpg"></a>
					 </li>									 <li>
					   <a href="http://www.engloncar.com/" target="_blank"><img src="http://www.njae.net/public/media/friendlink/51d511453dcae.jpg"></a>
					 </li>							
				</ul>
				</div>
				<script>
				window.onload = function() {
				(function($){
					$.fn.extend({
						RollTitle: function(opt,callback){

							if(!opt) var opt={};
							var _this = this;
							_this.timer = null;
							_this.lineW = _this.find("a:last").width();
							_this.speed=opt.speed?parseInt(opt.speed,10):3000, //卷动速度，数值越大，速度越慢（毫秒
							_this.timespan=opt.timespan?parseInt(opt.timespan,13):5000; //滚动的时间间隔（毫秒

							//console.log(_this.find("a:last").offset().left - _this.find("a:first").offset().left);

							_this.marginLeftValue = _this.find("a:last").offset().left - (_this.find("a:first").offset().left + 300);
							
							_this.scrollLeft=function(){
								_this.animate({
									marginLeft:-(_this.marginLeftValue)
									},_this.speed,function(){
									_this.css({marginLeft:0});	
								});
							}

							_this.hover(function(){
								clearInterval(_this.timer);
							},function(){
								_this.timer=setInterval(function(){_this.scrollLeft();},_this.timespan);
							}).mouseout();
						}
					})
				})(jQuery);
				var oCon = document.getElementById('conBrand');
				var oUl = oCon.getElementsByTagName('ul')[0];
				var aLi = oUl.getElementsByTagName('li');
				var iSpeed = -1;
				var timer;
			
				oUl.innerHTML += oUl.innerHTML;
				oUl.style.width = aLi.length*aLi[0].offsetWidth+'px';
			
				function goRoll() {
			
					timer = setInterval(function() {
					
						oUl.style.left = oUl.offsetLeft+iSpeed+'px';
						if(oUl.offsetLeft<-oUl.offsetWidth/2) {
							oUl.style.left = '0px';
						} else if(oUl.offsetLeft>=0) {
							oUl.style.left = -oUl.offsetWidth/2+'px';
						}
			
					}, 40);
			
				}

				oUl.onmouseover = function() {clearInterval(timer);};
				oUl.onmouseout = function() {goRoll();};

				goRoll();
				}
				</script>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>
			<a target="_blank" href="http://www.315che.com/help/0.htm">关于我们</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/1.htm">联系我们</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/2.htm">广告服务</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/3.htm">友情链接</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/4.htm">网站地图</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/5.htm">招聘信息</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/6.htm">法律声明</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/7.htm">车友会</a>
		</p>
		<p>
			Copyright ? 2005-2010
			<a href="mailto:admin@315che.com">中国汽车消费网</a>
			备案号:
			<a target="_blank" href="http://www.miibeian.gov.cn">沪ICP 备 05053107 号</a>
		</p>
	</div>
	<div style="display:none;"><script src="http://w.cnzz.com/c.php?id=30010794" language="JavaScript" charset="gb2312"></script></div>
</body>
</html>