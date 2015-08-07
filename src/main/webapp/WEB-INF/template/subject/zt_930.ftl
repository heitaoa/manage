<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>${title!}</title>
	<meta name="keywords" content="${keywords!}">
	<meta name="description" content="${descstr!}">
	<link rel="stylesheet" type="text/css" href="http://zt.315che.com/common/css/315che-base.css">
	<!--<link rel="stylesheet" href="http://zt.315che.com/shanghai/chezhan/150615/css/style.css">-->
	<link href="http://zt.315che.com/shanghai/chezhan/150615/css/jquery.bxslider.css" rel="stylesheet" />
	<style>
		body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td, hr, button, article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { margin: 0; padding: 0; list-style: none; border: 0; }

		body { font-family: "microsoft yahei"; color: #333333; }
		
		a, a:hover, a:link, a:visited { text-decoration: none; color: #fff; }
		
		.warpper_out { width: 100%; /* height: 5760px;  */ height: auto; }
		
		.warpper { width: 100%; height: 100%; position: relative; }
		
		/* .bg { background-repeat: no-repeat; background-position: top center; } */
		.banner { height: 641px; }
		
		.bg { background-repeat: no-repeat; background-position: top center; }
		
		.imgarea1 { height: 641px; }
		
		.bg1_1 { background-image: url(<#if dataMap.get("头图w1905h700")??>
											<#list dataMap.get("头图w1905h700") as data>
												<#if data_index lt 1>
													${data.pic!}
												</#if>
											</#list>
										</#if>); }
		
		.fl { float: left; }
		
		.fr { float: right; }
		
		.countdown-box { height: 800px; width: 100%; position: relative; margin-top: -10px; z-index: 99; }
		
		.bar { height: 89px; width: 100%; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/yellow_02.png) repeat-x; z-index: 99; margin-bottom: -29px; }
		.bar h3 { font-size: 40px; text-align: center; line-height: 90px; color: #fff; }
		
		.countdown-out { }
		
		.centerb { overflow: hidden; width: 1000px; margin: 30px auto; }
		
		.countdown { height: 554px; }
		.countdown p { font-size: 13px; padding-top: 5px; line-height: 1.2rem; }
		
		.countdown-count { width: 1000px; height: 63px; padding-top: 26px; margin: 0 auto; }
		.countdown-count img { float: left; padding: 0 30px 0 50px; }
		
		.count-time { float: left; color: #fff; font-size: 22px; }
		.count-time span { width: 42px; height: 46px; display: inline-block; text-align: center; line-height: 46px; border-radius: 5px; background: #50386d; margin: 0 5px; color: #fff100; }
		
		.count-left { float: left; width: 600px; height: 525px; padding-top: 25px; }
		.count-left .onsale { width: 206px; height: 352px; padding: 15px 18px 0 18px; background: #da393f; border-radius: 9px; padding-top: 15px; position: relative; float: left; }
		.count-left .onsale .round img { display: block; border-radius: 50%; }
		.count-left .onsale .round1 img { width: 200px; height: 200px; }
		.count-left .onsale .offpic { position: absolute; top: 160px; right: 8px; }
		.count-left .onsale .text h3 { font-size: 24px; color: #fef67a; }
		.count-left .onsale .text p { color: #f5d6d7; font-size: 12px; }
		.count-left .sign-buy { float: left; margin-left: 17px; _display: inline; }
		.count-left .text-pic { width: 310px; height: 170px; padding: 10px 15px 0 15px; background: #f79475; border-radius: 9px; }
		.count-left .text-pic .text { float: left; width: 140px; padding: 30px 10px 0 0; }
		.count-left .text-pic .text h3 { font-size: 24px; }
		.count-left .text-pic .text p { color: #fff; }
		.count-left .text-pic .round2 { float: left; }
		.count-left .text-pic .round2 img { width: 160px; height: 160px; border-radius: 50%; }
		.count-left .sign h3 { color: #d0542d; }
		.count-left .sign p { color: #fef2f0; }
		.count-left .buy { background: #f99b1c; margin-top: 6px; }
		.count-left .buy .text { padding-right: 0; padding-left: 10px; }
		.count-left .buy .text h3 { color: #a9661f; }
		.count-left .hour-gift { width: 585px; height: 138px; padding: 15px 0 0 15px; background: #c5ad95; border-radius: 9px; float: left; margin-top: 10px; }
		.count-left .hour-gift .round { float: left; width: 124px; margin-right: 10px; }
		.count-left .hour-gift .round3 img { width: 124px; height: 124px; border-radius: 50%; }
		.count-left .hour-gift .text { width: 150px; float: left; padding-left: 24px; }
		.count-left .hour-gift .text h3 { font-size: 24px; color: #897868; }
		.count-left .hour-gift .text p { color: #fbfaf9; }
		
		.count-right { float: right; width: 305px; height: 525px; background: #fff; padding: 0 30px 0 40px; margin-top: 25px; border: 2px solid #ff6666; border-radius: 9px; }
		.count-right h3 { font-size: 22px; color: #f66; text-align: center; padding: 45px 0; }
		.count-right ul { margin-bottom: 50px; }
		.count-right li { padding: 9px 0; }
		.count-right li label { width: 80px; line-height: 32px; float: left; }
		.count-right li input { width: 205px; height: 32px; border: 1px solid #cccccc; }
		.count-right li select { width: 205px; height: 32px; border: 1px solid #cccccc; }
		.count-right .info { text-align: center; font-size: 16px; color: #666666; margin-top: 40px; }
		.count-right .info span { color: #f66; font-weight: bold; font-size: 20px; }
		
		.btn a { width: 100%; line-height: 40px; background: #ff6666; display: block; text-align: center; color: #fff; font-size: 22px; border-radius: 5px; }
		
		.steps { width: 1000px; height: 105px; margin: 0 auto; }
		
		.brand-show { width: 100%; background: #f5ffff; position: relative; padding-top: 30px; }
		.brand-show .bar2 { background: url(http://zt.315che.com/shanghai/chezhan/150615/images/blue_02.png); }
		
		.hot-rec { width: 550px; height: 56px; border-radius: 28px; border: 2px solid #d2eaec; text-align: center; line-height: 56px; background: #fff; font-size: 30px; color: #ea5150; font-weight: bold; margin: 0 auto; margin-top: -30px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis; }
		
		.line { width: 100%; margin-top: 80px; background-image: none; border-top: 2px solid #d2eaec; }
		
		.brands-hot { width: 1000px; margin: 50px auto 0px; }
		.brands-hot ul { overflow: hidden; }
		.brands-hot li { margin: 0 9px 28px; _display: inline; width: 313px; height: 294px; border: 1px solid #ececec; background: #fff; float: left; }
		.brands-hot li .hot-brand-pic img { width: 313px; height: 209px; display: block; }
		.brands-hot li .hot-brand-tit { width: 313px; height: 85px; background: #fff; color: #333; }
		.brands-hot li .hot-brand-tit h4 { padding-top: 10px; text-align: center; font-size: 22px; }
		.brands-hot li .hot-brand-tit p { text-align: center; }
		.brands-hot li .hot-brand-tit p span { color: #f69006; }
		.brands-hot li.current { border: 1px solid #f69006; position: relative; }
		.brands-hot li.current .ensure1 { width: 59px; height: 46px; position: absolute; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/floor.png); top: 0px; left: 10px; }
		.brands-hot li.current .hot-brand-tit { background: #f69006; color: #fff; }
		.brands-hot li.current .hot-brand-tit p span { color: #fff; }
		
		.btn-more { height: 35px; width: 100%; padding-bottom: 40px; }
		.btn-more a { margin: 0 auto; width: 160px; height: 100%; line-height: 35px; display: block; background: #e1f9fd; border: 1px solid #d2eaec; color: #488d94; text-align: center; font-size: 16px; }
		
		.map-box { height: 630px; width: 100%; background: #f5ffff; position: relative; }
		.map-box .bar4 { background: url(http://zt.315che.com/shanghai/chezhan/150615/images/green_02.png); }
		.map-box .map { padding-top: 60px; }
		.map-box .map-left { float: left; width: 603px; height: 423px; background: #fff; border: 2px solid #d7e2c0; overflow: hidden; }
		.map-box .map-right { float: right; height: 393px; width: 360px; padding-left: 30px;}
		.map-box .map-right .xianlu { margin-bottom: 20px; overflow: hidden; }
		.map-box .map-right .xianlu dt { color: #8ec32b; font-size: 22px; line-height: 40px; }
		.map-box .map-right .xianlu dt .icon { width: 20px; height: 20px; float: left; margin: 9px 5px 0 0; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/diot.jpg); }
		.map-box .map-right .xianlu dd { font-size: 13px; padding-right: 10px; }
		.map-box .map-right .xianlu dd .text { width: 157px; height: 40px; line-height: 40px; border: 1px solid #cdcdcd; border-radius: 5px; padding-left: 3px; }
		.map-box .map-right .xianlu dd .w2 { width: 107px; }
		.map-box .map-right .xianlu .mapf2 { margin-top: 20px; }
		.map-box .map-right .xianlu .mapf3 { margin-top: 30px; }
		.map-box .map-right .xianlu dd .map-find { width: 114px; height: 45px; line-height: 45px; text-align: center; color: #fff; font-size: 22px; background: #80ac17; }
		
		.tour { height: 730px; width: 100%; background: #f5ffff; position: relative; }
		.tour .bar5 { background: url(http://zt.315che.com/shanghai/chezhan/150615/images/pink.png); }
		.tour .c1 { color: #f49172; }
		
		.hot-pic { top: 175px; }
		.hot-pic .hot-pic-left img { width: 362px; height: 488px; }
		.hot-pic .hot-pic-right { width: 634px; }
		.hot-pic .hot-pic-right li { float: left; margin-right: 4px; }
		.hot-pic .hot-pic-right li img { width: 313px; height: 241px; }
		
		.winning-person { height: 1300px; width: 100%; background: #f5ffff; position: relative; }
		.winning-person .bar5 { background: url(http://zt.315che.com/shanghai/chezhan/150615/images/red_02.png); }
		.winning-person .win-pic { padding-top: 70px; }
		.winning-person .win-pic img { width: 100%; height: 100%; }
		.winning-person .win-pic .wins { width: 1000px; margin-bottom: 10px; overflow: hidden; }
		.winning-person .win-pic .per1-left { width: 282px; height: 384px; background: red; margin-right: 10px; }
		.winning-person .win-pic .per1-left img { width: 100%; height: 100%; }
		.winning-person .win-pic .per1-center { width: 435px; height: 384px; }
		.winning-person .win-pic .per1-center .center-top { height: 194px; }
		.winning-person .win-pic .per1-center .center-bottom { margin-top: 12px; height: 178px; }
		.winning-person .win-pic .per1-center .center-bottom li { width: 214px; height: 178px; margin-right: 7px; float: left; }
		.winning-person .win-pic .per1-center .center-bottom li.last { margin-right: 0; }
		.winning-person .win-pic .per1-right { width: 263px; height: 384px; background: red; }
		.winning-person .win-pic .win-per2 { height: 435px; }
		.winning-person .win-pic .win-per2 li { width: 320px; height: 435px; float: left; margin-right: 20px; }
		.winning-person .win-pic .win-per2 li.last { margin-right: 0; }
		.winning-person .win-pic .win-per3 { height: 250px; }
		.winning-person .win-pic .win-per3 li { width: 320px; height: 250px; float: left; margin-right: 20px; }
		.winning-person .win-pic .win-per3 li.last { margin-right: 0; }
		
		.about-out { padding-bottom: 20px; width: 100%; background: #f5ffff; position: relative; height: 500px; overflow: hidden; }
		.about-out .bar6 { background: url(http://zt.315che.com/shanghai/chezhan/150615/images/indigo_02.png); }
		
		.about { padding-top: 70px; }
		.about .about-left img { width: 415px; height: 228px; }
		.about .about-right { width: 480px; height: 272px; padding: 0 30px; font-size: 14px; }
		.about .about-right p { text-indent: 2em; padding-bottom: 5px; }
		.about .about-right .tel { padding: 30px 0 10px 50px; font-size: 40px; color: #e43b3e; font-weight: bold; }
		.about .about-right .tel .icon { width: 59px; height: 59px; float: left; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/tel_11.jpg); margin-right: 10px; }
		.about .about-right .info { font-size: 20px; color: #cccccc; }
		
		.float_red { width: 100%; height: auto; background: #e11433; overflow: hidden; position: fixed; z-index: 999; bottom: -200px; }
		.float_red table { width: 1000px; height: 85px; margin: 0 auto; }
		.float_red table a { display: block; text-align: center; color: #FFFFFF; width: 85px; }
		.float_red table a.last { width: 120px; }
		.float_red .sp_top { width: 260px; }
		
		.srollpic { height: 630px; overflow: hidden; position: relative; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 15px; }
		.srollpic a.prev { position: absolute; top: 230px; left: 10px; width: 50px; height: 50px; overflow: hidden; display: inline-block; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/span-left.jpg) no-repeat; line-height: 1000px; }
		.srollpic a.next { position: absolute; top: 230px; right: 10px; width: 50px; height: 50px; overflow: hidden; display: inline-block; background: url(http://zt.315che.com/shanghai/chezhan/150615/images/span-right.jpg) no-repeat; line-height: 1000px; }
		.srollpic ul.bxslider { width: 980px; height: 480px; overflow: hidden; }
		.srollpic ul.bxslider li { width: 980px; height: 480px; float: left; }
		
		.box_container { width: 980px; height: 570px; overflow: hidden; }
		
		.bxslider img { width: 980px; height: 480px; }
		
		.focus_dot { float: left; display: inline; margin-top: 15px; }
		
		.focus_dot li { width: 15px; height: 15px; float: left; background: #e0e0e0; margin-right: 10px; overflow: hidden; line-height: 1000px; cursor: pointer; border-radius: 50%; }
		
		.focus_dot li.current { background: #ff4b4c; }
		
		.com-partner { background: #f5ffff; padding-bottom: 100px; }

		.partner { padding-top: 70px; clear: both; width: 1000px; margin: 0 auto; }
		
		.partner ul { overflow: hidden; clear: both; }
		
		.partner li { float: left; width: 240px; height: 260px; margin: 10px 8px 0 0; border: 1px solid #ccc; }
		.partner li div { background: #f5ffff; }
		.partner li img { width: 240px; height: 160px; display: block; }
		.partner li dl { padding: 5px; }
		.partner li dt { font-weight: bold; font-size: 16px; }
		.partner li dl span { font-weight: bold; }
	
	
	</style>

</head>
<body>
<!--头部-->	
	<div class="mihead-bg">
		<div id="goto-top" class="mihead">
			<div class="milogo">
				<a href="http://www.315che.com/" onfocus="this.blur();">中国汽车消费网</a>
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
<!--头部结束-->	


	<div class="warpper_out">
		<div class="warpper">
			<div class="banner">
	            <div class="imgarea1 bg bg1_1">
	            </div>
			</div>
			<div class="countdown-box">
				<div class="countdown-out bar">
					<div class="countdown-count">
						<img src="http://zt.315che.com/shanghai/chezhan/150615/images/yellowzi.png" alt="">
					    <div class="count">
						<#if dataMap.get("倒计时")??>
							<#list dataMap.get("倒计时") as data>
								<#if data_index lt 1>
									<p class="lxftime" endtime="${data.title!}"></p>
								</#if>
							</#list>
						</#if>					    
					        <div class="count-time">
					         距结束: <span id="day"></span> 天 <span id="hours"></span>时 <span id="minutes"></span>分 <span id="seconds"></span>秒
					        </div>
					    </div>
					</div>
				</div>
				<div class="countdown centerb">
					<div class="count-left">
						<div class="onsale">
							<div class="round round1">
									<#if dataMap.get("倒计时下面图一w200h200")??>
										<#list dataMap.get("倒计时下面图一w200h200") as data>
											<#if data_index lt 1>
											    <a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a>
											</#if>
										</#list>
									</#if>			
							</div>
							
								<#if dataMap.get("倒计时下面图二w78h78")??>
									<#list dataMap.get("倒计时下面图二w78h78") as data>
										<#if data_index lt 1>
											<div class="offpic">
												<a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a>
											</div>
											<div class="text">
												<h3>${data.title!}</h3>
												<p>${data.content!}</p>
											</div>
										</#if>
									</#list>
								</#if>		
						</div>
						<div class="sign-buy">
							<div class="text-pic sign">
								<#if dataMap.get("倒计时下面图三w160h160")??>
									<#list dataMap.get("倒计时下面图三w160h160") as data>
										<#if data_index lt 1>
											<div class="text">
												<h3>${data.title!}</h3>
												<p>${data.content!}</p>
											</div>
											<div class="round round2">
												<a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a>
											</div>
										</#if>
									</#list>
								</#if>	
								
							</div>
							<div class="text-pic buy">
								
								<#if dataMap.get("倒计时下面图四w160h160")??>
									<#list dataMap.get("倒计时下面图四w160h160") as data>
										<#if data_index lt 1>
											<div class="round round2">
												<a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a>
											</div>
											<div class="text">
												<h3>${data.title!}</h3>
												<p>${data.content!}</p>
											</div>
										</#if>
									</#list>
								</#if>	
							</div>
						</div>
						<div class="hour-gift">
							<#if dataMap.get("倒计时下面图五w124h124")??>
								<#list dataMap.get("倒计时下面图五w124h124") as data>
									<#if data_index lt 3>
										<div class="round round3">
											<a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a>
										</div>
									</#if>
									<#if data_index == 2>
										<div class="text">
											<h3>${data.title!}</h3>
											<p>${data.content!}</p>
										</div>
									</#if>
								</#list>
							</#if>
						</div>
					</div>
					<div class="count-right">
						<h3 id="77">
						   <#if dataMap.get("报名框标题")??>
							<#list dataMap.get("报名框标题") as data>
								<#if data_index lt 1>
								 	${data.title!}
								</#if>
							</#list>
						   </#if>
						</h3>
                         <ul>
							<li>
								<label for="">* 姓&nbsp;&nbsp;&nbsp;&nbsp;名 :</label><input type="text" id="name">
							</li>
							<li>
								<label for="">* 手&nbsp;&nbsp;&nbsp;&nbsp;机:</label><input type="text" id="phone">
							</li>
							<li>
								<label for="">意向品牌:</label>
								<select id="brand">
									<option value="">选择品牌</option>
									<#if dataMap.get("品牌推荐w315h210")??>
										<#list dataMap.get("品牌推荐w315h210") as data>
											<option value="${data.clink!}">${data.content!} ${data.title!}</option>
										</#list>
									</#if>
								</select>
							</li>
							<li>
								<label for="">意向车型:</label>
								<select id="series">
									<option value="">选择车型</option>							
								</select>
							</li>
						</ul>
						<div class="btn">
							<a href="javascript:void(0);" onclick="javascript:saveuserinfo();">免费报名</a>
						</div>
						<p class="info">已有
						<span>
							<#if dataMap.get("报名人数")??>
								<#list dataMap.get("报名人数") as data>
									<#if data_index lt 1>
									   ${data.ctitle!}
									</#if>
								</#list>
							</#if>	
						</span>人报名</p>	
					</div>
				</div>
				<div class="steps">
					<#if dataMap.get("购车攻略w1000h105")??>
						<#list dataMap.get("购车攻略w1000h105") as data>
							<#if data_index lt 1>
								<img src="${data.pic!}"/>
							</#if>
						</#list>
					</#if>
				</div>
			</div>
			<div class="brand-show">
				<div class="bar bar2"><h3>参 展 品 牌</h3></div>
				<div class="line"></div>
				<div class="hot-rec" id="22">热门品牌推荐</div>
				<div class="brands-hot">
					<ul id="brands-list">
						<#if dataMap.get("品牌推荐w315h210")??>
							<#list dataMap.get("品牌推荐w315h210") as data>
								<#if data_index lt 9>
									<li value="${data.clink!}">
										<div class="hot-brand-pic">
											<img src="${data.pic!}"/>
										</div>
										<div class="ensure1"></div>
										<div class="hot-brand-tit">
											<h4>${data.title!}</h4>
											<p>有<span>${data.ctitle!}</span>人已报名</p>
										</div>
									</li>
								</#if>
							</#list>
						</#if>
					</ul>
					<ul id="showMoreCar" style="display:none;">
						<#if dataMap.get("品牌推荐w315h210")??>
							<#list dataMap.get("品牌推荐w315h210") as data>
								<#if data_index gt 8>
									<li value="${data.clink!}">
										<div class="hot-brand-pic">
											<img src="${data.pic!}"/>
										</div>
										<div class="ensure1"></div>
										<div class="hot-brand-tit">
											<h4>${data.title!}</h4>
											<p>有<span>${data.ctitle!}</span>人已报名</p>
										</div>
									</li>
								</#if>
							</#list>
						</#if>
					</ul>
					<div class="btn-more">
						<a href="javascript:void(0);" onclick="javascript:getMoreCar();">更多车型</a>
					</div>
				</div>
			</div>
			<div class="map-box">
				<div class="bar bar4" id="33"><h3>小胖购车节交通地图</h3></div>
				<div class="map centerb">
					<div class="map-left">
					   <#if dataMap.get("交通地图w607h425")??>
							<#list dataMap.get("交通地图w607h425") as data>
								<#if data_index lt 1>
								   <img src="${data.pic!}" alt="">
								</#if>
							</#list>
					    </#if>
					</div>
					<div class="map-right">
						<dl class="xianlu">   
							 <#if dataMap.get("地铁路线")??>
								<#list dataMap.get("地铁路线") as data>
									<#if data_index lt 1>
										<dt><i class="icon"></i>${data.ctitle!"乘坐地铁线路"}</dt>
										<dd>
									  		${data.title!}
								 		</dd>
									</#if>
								</#list>
						     </#if>
						</dl>
						<dl class="xianlu">
							<dt><i class="icon"></i>乘坐公交线路</dt>
							<dd>	
							 <#if dataMap.get("公交路线")??>
								<#list dataMap.get("公交路线") as data>
									<#if data_index lt 1>
									   ${data.title!}
									</#if>
								</#list>
						     </#if>
						     </dd>
						</dl>
						<dl class="xianlu">
							<dt><i class="icon"></i>用百度地图查询交通线路</dt>
							<dd>
								<form action="">
									<p class="mapf1">
										从 <input type="text" placeholder="您出发的位置" class="text w1" id="from"> 到 <input type="text" placeholder="地点" class="w2 text" id="to">
									</p>
									<p class="mapf2">
										<input type="radio" value="2" name="type" checked="checked"><label for="rr">自驾车路线</label>　　　
										<input type="radio" value="1" name="type" >	<label for="rr1">公交路线</label>										
									</p>
									<p class="mapf3">
										<input type="button" value="查询路线" class="map-find" onclick="javascript:searchRoute();">
									</p>
								</form>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			
			<div class="tour">
				<div class="bar bar5" id="44"><h3>小胖购车节全国巡展回顾</h3></div>
				<div class="line"></div>
				<div class="hot-rec c1">
					<#if dataMap.get("小胖购车节全国巡展回顾w999h498")??>
						<#list dataMap.get("小胖购车节全国巡展回顾w999h498") as data>
							<#if data_index == 0>
								${data.title!}
							</#if>
						</#list>
				     </#if>
				</div>
				<div class="hot-pic centerb">
					<div class="srollpic">
						<ul class="bxslider" id="bxslider">
							<#if dataMap.get("小胖购车节全国巡展回顾w999h498")??>
								<#list dataMap.get("小胖购车节全国巡展回顾w999h498") as data>
									    <li><img src="${data.pic!}" alt="${data.title!}" />
								</#list>
						     </#if>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="winning-person">
				<div class="bar bar5" id="55"><h3>小胖购车节获奖车主</h3></div>
				<div class="win-pic centerb">
					<div class="wins win-per1">
						<div class="per1-left fl">
						    <#if dataMap.get("获奖车主图片一w282h382")??>
								<#list dataMap.get("获奖车主图片一w282h382") as data>
									<#if data_index lt 1>
									   <img src="${data.pic!}" alt="">
									</#if>
								</#list>
						    </#if>
						</div>
						<div class="per1-center fl">
							<div class="center-top">
								<#if dataMap.get("获奖车主图片二w436h194")??>
									<#list dataMap.get("获奖车主图片二w436h194") as data>
										<#if data_index lt 1>
										   <img src="${data.pic!}" alt="">
										</#if>
									</#list>
							     </#if>
							</div>
							<ul class="center-bottom">
								<#if dataMap.get("获奖车主三两张小图w214h178")??>
									<#list dataMap.get("获奖车主三两张小图w214h178") as data>
										<#if data_index lt 2>
										   <li <#if data_index == 1>class="last"</#if>>
										  	 	<img src="${data.pic!}" alt="">
										   </li>				
										</#if>	
									</#list>
								 </#if> 
							</ul>
						</div>
						<div class="per1-right fr">
							<#if dataMap.get("获奖车主图片四w282h382")??>
								<#list dataMap.get("获奖车主图片四w282h382") as data>
								  <#if data_index lt 1>
								    	<img src="${data.pic!}" alt="">
								  </#if>
								</#list>
							 </#if>
						 </div>
					</div>
					<div class="wins win-per2">
						<ul>
							<#if dataMap.get("获奖车主中间三张大图w320h436")??>
								<#list dataMap.get("获奖车主中间三张大图w320h436") as data>
								  <#if data_index lt 3>
								   <li <#if data_index == 2>class="last"</#if>>
								    	<img src="${data.pic!}" alt="">
								   </li>	
								  </#if>
								</#list>
							 </#if> 
						</ul>
					</div>
					<div class="wins win-per3">
						<ul>
							<#if dataMap.get("获奖车主底部三张图片w320h250")??>
								<#list dataMap.get("获奖车主底部三张图片w320h250") as data>
								  <#if data_index lt 3>
								   <li <#if data_index == 2>class="last"</#if>>
								    	<img src="${data.pic!}" alt="">
								   </li>	
								  </#if>
								</#list>
							 </#if> 
						</ul>
					</div>
				</div>
			</div>
			<#if dataMap.get("合作商家w240h160")??>
				<#if dataMap.get("合作商家w240h160")?size gt 0>
				<div class="com-partner">
					<div class="bar bar6"><h3>合作商家</h3></div>
					<div class="partner">
						<ul>
						<#list dataMap.get("合作商家w240h160") as data>
							<li>
								<div><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"></a></div>
								<dl>
									<dt>${data.title!}</dt>
									<dd><span>电话 : </span>${data.ctitle!}</dd>
									<dd><span>地址 : </span>${data.clink!}</dd>
								</dl>
							</li>
							
						</#list>
						</ul>
					</div>
				</div>
				</#if>
			</#if>
			<div class="about-out">
				<div class="bar bar6" id="66"><h3>关于小胖购车节</h3></div>
				<div class="about centerb">
					<#if dataMap.get("关于小胖购车节w415h226")??>
						<#list dataMap.get("关于小胖购车节w415h226") as data>
						  <#if data_index lt 1>
						   	<div class="about-left fl">		
								 <img src="${data.pic!}" alt="">
							</div>
							<div class="about-right fr">
								<p>${data.title!}</p>
								<p>${data.ctitle!}</p>
								<div class="tel"><i class="icon"></i>${data.content!}</div>
								<p class="info">免费拨打购车优惠热线（工作日：9:00-17:30）</p>
							</div>
						  </#if>
						</#list>
					</#if>
				</div>
			</div>
		</div>
	</div>

<!--底部开始-->	
	<div class="float_red" id="div1" style="display: block;">
		<table cellpadding="0" cellspacing="0" border="0">
			<tbody>
				<tr>
				<td valign="middle" align="left"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/word_15.jpg"></td>
				<td valign="middle"><a href="#22" target="_parent" title="参展品牌"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_32.jpg"><br>参展车型</a></td>
				<td valign="middle"><a href="#33" target="_parent" title="交通地图"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_15.jpg"><br>交通地图</a></td>
				<td valign="middle"><a href="#44" target="_parent" title="往期回顾"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_21.jpg"><br>往期回顾</a></td>
				<td valign="middle"><a href="#55" target="_parent" title="得奖车主"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_29.jpg"><br>得奖车主</a></td>
				<td valign="middle"><a href="#66" target="_parent" title="小胖购车节介绍" class="last"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_23.jpg"><br>小胖购车节介绍</a></td>
				<td valign="middle" align="right"><a id="sp_top" href="#77" target="_parent" class="sp_top"><img src="http://zt.315che.com/shanghai/chezhan/150615/images/pciss_18.jpg"></a></td>
			</tr>
		</tbody>
	</table>

	</div>

<!-- script codes-->
<script src="http://www.315che.com/js/jquery-1.11.2.min.js"></script>
<!--<script src="http://zt.315che.com/shanghai/chezhan/150615/js/jquery.bxslider.min.js"></script>-->
<script src="http://zt.315che.com/shanghai/chezhan/150615/js/common.js"></script>
<script src="http://zt.315che.com/common/js/car.js"></script>
<script src="http://zt.315che.com/common/js/brand.js"></script>

<script>
function searchRoute(){
	var from = $("#from").val().trim();
	var to = $("#to").val().trim();
	if(from==''){
		alert("请输入起始位置！！！");
		return;
	}
	
	if(to==''){
		alert("请输入目的地！！！");
		return;
	}
	
	var type = $("input[name='type']:checked").val();
	if(type==1){
		//window.location.href = "http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=transit&region=上海&output=html&src=315che";
			<#if dataMap.get("车展城市")?size gt 0>
				<#list dataMap.get("车展城市") as data>
					<#if data_index == 0>
						window.open("http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=transit&region=${data.title!}&output=html&src=315che");
					</#if>
				</#list>
				<#else>
				window.open("http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=transit&output=html&src=315che");
			</#if>
	}
	if(type==2){
		//window.location.href = "http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=driving&region=上海&output=html&src=315che";
		
		<#if dataMap.get("车展城市")?size gt 0>
			<#list dataMap.get("车展城市") as data>
				<#if data_index == 0>
					window.open("http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=transit&region=${data.title!}&output=html&src=315che");
				</#if>
			</#list>
			<#else>
			window.open("http://api.map.baidu.com/direction?origin="+from+"&destination="+to+"&mode=transit&output=html&src=315che");
		</#if>
	}
	

}
</script>

<script>
	/*$(function(){
		queryOption("brand",0);
	});*/
	
	/*$(function(){
		var brandMap = brandstr[0];
		var html = '<option value="">选择品牌</option>';
		for(var key in brandMap){
			html += '<option value="'+key+'">'+brandMap[key]+'</option>';
		}
		$("#brand").html(html);
	});
	*/

	$("#brand").change(function(){
		var brand = $(this).val();
		var carMap = carstr[0][brand];
		var html = '<option value="">选择车型</option>';
		for(var iwaykey in carMap){
			var carTypeMap = eval(carMap[iwaykey]);
			html += '<option style="font-size:18px;color:#F4A460" disabled="true">'+iwaykey+'</option>';
			for(var carkey in carTypeMap){
				html +='<option value="'+carkey+'">'+carTypeMap[carkey]+'</option>';
			}
		}
		$("#series").html(html);
	});


	/*function queryOption(hid,fatherid){
		var date = new Date(); 
		$.ajax({
			url:"http://www.315che.com/che/query?fatherid="+fatherid+"&target="+hid+"&random="+date.getTime(),
			dataType: "jsonp", // 跨域请求
			jsonp: "jsonpcallback",
			success:function(data){
				var carInfos=eval(data);
				$("#"+hid).empty();
				var html = '<option value="">请选择</option>';
				for(var i=0;i<carInfos.length;i++){
					if(carInfos[i].isKey=="Y"){
						html+='<option style="font-size:18px;color:#F4A460" disabled="true">'+carInfos[i].catalogname+'</option>';
					}else{
						if("brand"==hid){
							html+='<option value="'+carInfos[i].catalogid+'">'+carInfos[i].lname+' '+carInfos[i].catalogname+'</option>';
						}else{
							//html+='<option >'+carInfos[i].catalogname+'</a>';
							html+='<option value="'+carInfos[i].catalogid+'">'+carInfos[i].catalogname+'</option>';
						}
					}
				}
				$("#"+hid).html(html);
			}
		});
	}
	
	$("#brand").change(function(){
		var brand = $(this).val();
		queryOption("series",brand);
	});
	
	$("#series").change(function(){
		var model = $(this).val();
		queryOption("model",model);
	});*/
	
	$(function(){
		$(".brand-show .brands-hot").find("li").click(function(){
			var brand = $(this).attr("value");
			$("#brand").val(brand);
			var carMap = carstr[0][brand];
			var html = '<option value="">选择车型</option>';
			for(var iwaykey in carMap){
				var carTypeMap = eval(carMap[iwaykey]);
				html += '<option style="font-size:18px;color:#F4A460" disabled="true">'+iwaykey+'</option>';
				for(var carkey in carTypeMap){
					html +='<option value="'+carkey+'">'+carTypeMap[carkey]+'</option>';
				}
			}
			$("#series").html(html);
			document.documentElement.scrollTop = document.body.scrollTop = 250;
		});
	
	});
	
	
</script>

<script>
function getMoreCar(){
	$("#showMoreCar").css("display","block");
	//$("#showMoreCar").show();
}
</script>

<script>
function saveuserinfo(){
	var name = $("#name").val();
	var phone = $("#phone").val();
	var brand = $("#brand").val();
	var series = $("#series").val();
	//var model = $("#model").val();
	if(name==''){
		alert("请输入姓名！！！");
		return;
	}
	if(phone==''){
		alert("请输入电话！！！");
		return;
	}
	var regTel=l=/^1[3|5|7|8|][0-9]{9}$/;
	if(!regTel.test(phone)){
		alert("请正确输入手机号");
		return;
	}
	if(brand==''){
		alert("请选择品牌！！！");
		return;
	}
	if(series==''){
		alert("请选择车系！！！");
		return;
	}
	/*if(model==''){
		alert("请选择车型！！！");
		return;
	}*/
	var carinfo ='品牌：'+$("#brand").children("option:selected").text()+' 车系：'+$("#series").children("option:selected").text()+' 专题：${title!}';
	
	$.ajax({
		url:'http://182.254.147.194:8180/chetuan/saveApplyInf',
		dataType:'jsonp',
		data:{name:encodeURI(name),carid:brand,modelid:series,phone:phone,sex:1,city:'',prov:'',carinfo:encodeURI(carinfo),isSendSms:1},
		jsonp:'jsonpcallback',
		success:function(data){
			<#if dataMap.get("车展短信")?size gt 0>
				<#list dataMap.get("车展短信") as data>
						$.ajax({
							url:'http://182.254.147.194:8180/chetuan/saveMsg',
							dataType : 'jsonp',
							data :{msg:encodeURI('${data.content!}'),phone:phone},
							jsonp:'jsonpcallback',
							success : function(data){
								alert("报名成功！！！");
								$("#name").val("");
								$("#phone").val("");
								$("#brand").val("");
								$("#series").val("");
							}
						});
				</#list>
			<#else>
				alert("报名成功");
				$("#name").val("");
				$("#phone").val("");
				$("#brand").val("");
				$("#series").val("");
			</#if>
		}
	});
}
</script>

<div style="display:none;"><script src='http://w.cnzz.com/c.php?id=30051030&l=3' language='JavaScript'></script></div>
</body>
</html>