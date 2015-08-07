<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title!}</title>
<meta name="keywords" content="${keywords!}">
<meta name="description" content="${descstr!}">
<link rel="stylesheet" href="http://zt.315che.com/common/css/315che-base.css" />
<!--<link href="${zt_che_url}wuhan/150427/style/style.css" rel="stylesheet" type="text/css" />-->
<style>
@charset "utf-8";
/****
全局样式
****/
*{margin:0; padding:0}
html{overflow-y:scroll;}
body{  color:#333; background:url(${zt_che_url}wuhan/150427/imgs/body_bg.jpg) no-repeat 50% 446px; font:14px/24px Tahoma }
ul,ol,dl{ list-style:none;}
ul,li {margin: 0; padding: 0;}
h1, h2, h3, h4, h5, h6, p{ margin:0; padding:0; }
form{margin:0px; padding:0}
a{ color:#4b4b4b; text-decoration:none}
a:hover{ text-decoration:none}
img{ border:0 none; }

.floatleft{ float:left }
.floatright{ float:right }

.slide01{ position:fixed; top:50%; margin-top:-104px; left:20px}
.slide02{ position:fixed; top:50%; margin-top:-104px; right:20px}

.banner {height: 406px; background: url(<#if dataMap.get("顶部背景图片w1600_h406")??><#list dataMap.get("顶部背景图片w1600_h406") as data><#if data_index lt 1>${data.pic!}</#if></#list></#if>) no-repeat top center;}

#box{ width:990px; height:3150px; /*padding-top:402px; _padding-top:139px;*/ margin:-4px auto 0; }



	.cont1-wrap{ width:990px; height:442px }

		.cont1-w-news{ width:700px; height:440px; padding-right:25px; float:left}
		/*.cont1-w-news .txt-info{ height:38px; padding-left:10px; font:bold 16px/38px "微软雅黑"; color:#e73640; border:1px solid #f5c01d; background:#fff; margin-bottom:15px; }*/
		.txt-slider-box { width:698px; float: left; border: 1px solid #f5c01d; margin: 0 0 10px 0; height: 38px; line-height:38px; background: #fff; }
			.txt-info { float: left; padding: 0 5px; text-align: left; }
			.txt-info li {height: 38px; float: left; padding-left:10px; }
			.txt-info li a{ font:bold 16px/38px "微软雅黑"; color:#e73640;}
			.txt-slider-num { width: 60px; height: 35px; float: right; padding: 13px 0 0 10px;  }
			.txt-slider-num span {  display: block; float: left; margin-right: 8px; overflow: hidden; width: 10px; height: 10px; background-color: #ffd20d; border-radius: 10px; text-indent: -999em; cursor: pointer;}
			.txt-slider-num span.current { background-color: #E73541; }
		/**.cont1-w-news .txt-info span{ float:right; display:block; width: 60px; height: 20px; padding: 15px 0 0 10px; }
		.cont1-w-news .txt-info span em { display: block; float: left; margin-right: 8px; overflow: hidden; width: 10px; height: 10px; background-color: #ffd20d; border-radius: 10px; text-indent: -999em; cursor: pointer;}
		.cont1-w-news .txt-info span em.cur {background-color: #E73541;}**/
		
			.cont1-w-news-L{ width:325px; padding-right:15px; float:left}			
				/*焦点图css*/
				#divSmallBox{overflow:hidden;*display:inline;*zoom:1;width:10px;height:10px; border-radius:10px;background:#ffffff;}
				#playBox{ width:324px; height:216px; margin:0 auto; position:relative; overflow:hidden;}
				/*#playBox .oUlplay { width:99999px; position:absolute; left:0; top:0;}
				#playBox li {float: left;}
				#playBox .oUlplay li{ float:left;}
				#playBox .smalltitle {width:600px; height:10px; position:absolute; bottom:7px; z-index:10}
				#playBox .smalltitle ul{ width:120px; margin:0 auto;}
				#playBox .smalltitle ul li{ width:10px; height:10px; margin:0 3px; border-radius:10px; background:#ffffff; float:left; overflow:hidden;*display:inline;*zoom:1; cursor:pointer }
				#playBox .smalltitle .thistitle{ background:#e73640;}*/
				#playBox .bx-pager {position: absolute; bottom: 10px; *bottom: 10px; right: -20px; width:120px; height: 10px;}
				#playBox .bx-pager .bx-pager-item {float: left; width: 10px; height: 10px; margin-right: 8px; overflow: hidden;}
				#playBox .bx-pager .bx-pager-item {*display: inline;}
				#playBox .bx-pager .bx-pager-item a.bx-pager-link {display: block; overflow: hidden; width:10px; height:10px; border-radius:10px; background:#ffffff; cursor:pointer; text-indent: -999em;}
				#playBox .bx-pager .bx-pager-item a.active {background:#e73640;}

			.cont1-w-news-R{ width:328px; height:351px; padding:15px; border:1px solid #f5c01d; background:#fff; float:left}
			.cont1-w-news-R dl{ padding-bottom:15px; border-bottom:1px dashed #f5c01e }
			.cont1-w-news-R dt{ text-align:center; font:bold 18px/30px "微软雅黑"; margin-bottom: 15px; border:2px solid #e73640; color:#e73640}
			.cont1-w-news-R dd{ padding-top:5px; text-indent:25px; font:14px/25px Tahoma }
			.cont1-w-news-R ul{ padding-top:10px }
			.cont1-w-news-R ul h3{ text-align:center; font:bold 18px/30px "微软雅黑"; color:#e73640}
			.cont1-w-news-R li{ list-style:disc; margin-left:15px; padding-top:5px; font:14px/24px Tahoma }
		
		.cont1-w-form{ width:265px; float:left; background:#ffeacf }
		.cont1-w-form ul{ height:183px;}
		.cont1-w-form li{ width:265px; height:35px;}
		.cont1-w-form li span{ width:80px; float:left; font:14px/30px Tahoma; color:#e73640; text-align:right}
		.cont1-w-form li input,select{ height:28px; width:160px; font:12px/25px Tahoma; padding-left:5px; border:1px solid #ccc }
		.cont1-w-form li .submit{ height:35px; background:#e73640; font:bold 14px/30px "微软雅黑"; text-align:center; color:#fff; border:0 none; }
		.cont1-w-form dl{ height:199px; padding-top:3px; text-align:center; background:#ffa401 }
		.cont1-w-form dd p{ padding-left:10px; text-align:left; font:bold 16px/24px "微软雅黑";}
		
	.cont2-wrap{ width:990px; height:362px }
	.cont2-wrap li{ float:left; padding-right:10px}
	
	.cont3-wrap{ width:990px; height:690px; position:relative }
		
		/*.label{ position:absolute; width:38px; left:-38px; top:127px; text-align:center; }
		.label a{ display:block; height:133px; padding-top:22px; font:bold 22px/25px "微软雅黑"; color:#fff; background:#fd848b }
		.label a.default{
			background: #fd848b;                         
			color:#fff;
		}*/
		/* Label Clicked background */
		/*.label a.clicked{
			background: #e73640;
			color:#fff;
		}*/

		.cont3-wrap h4{ height:127px; background:url(${zt_che_url!}wuhan/150427/imgs/nav_bg02.gif) }

		.cont3-wrap .tab-nav1 {position: absolute; top: 127px; left: -38px; width: 38px; height: 480px; overflow: hidden;}
		.cont3-wrap .tab-nav1 a {float: left; display:block; width: 38px; height:133px; padding-top:22px; margin-bottom: 10px; font:bold 22px/25px "微软雅黑"; color:#fff; text-align: center; background:#fd848b;}
		.cont3-wrap .tab-nav1 a.current {background-color: #e73640;}
		.cont3-wrap .tab-con1 {float: left; width: 990px; height: 530px; background: #fff;}
			
		.cont3-wrap .content { position:relative; width: 990px; height: 530px; /*overflow: hidden;*/ }
		.content ul {width: 990px; height: 530px;}
		.content ul li.bxslider-li {float: left; width: 990px!important; width: 990px; height: 530px;}
		.content ul li ul {margin: 15px 0 15px 15px;}
		.content ul li ul li {overflow: hidden; float: left; width:170px; height:235px; margin: 0 15px 15px 0; border: 5px solid #FFA401; text-align: center; background-color: #FFA401;}
		.content ul li ul li .brand-img-box {
			/*非IE的主流浏览器识别的垂直居中的方法*/
			display: table-cell;
			vertical-align: middle;
			/*设置水平居中*/
			text-align: center;
			/* 针对IE的Hack */
			*display: block;
			*font-size: 113px;/*约为高度的0.873，200*0.873 约为175*/
			*font-family: Arial;/*防止非utf-8引起的hack失效问题，如gbk编码*/
			width: 172px; height: 130px; overflow: hidden; background-color: #fff;
		}
		.content ul li ul li .brand-img-box img {
			/*设置图片垂直居中*/
			vertical-align: middle;
		}
		.content ul li ul li h3{ font:bold 22px/25px "微软雅黑"; padding-top:5px; color:#fff }
		.content ul li ul li p{ font:16px/28px "微软雅黑"; color:#864f00 }
		.content ul li ul li p em{ font-style:normal; font:26px/35px Tahoma; color:#e73640; }
		.content ul li ul li label{ width:170px; display:block; margin:0 auto; height:35px; background:#e73640;text-align:center; border:0 none; }
		.content ul li ul li label a{ font:bold 18px/35px "微软雅黑"; color:#fff; }
		.content .bx-controls-direction {display: none;}
		.content .bx-pager {position: absolute; top: -30px; right:0px; width: 60px; height: 20px; padding: 10px 0 0 10px; background: #e73640;}
		.content .bx-pager .bx-pager-item {float: left; height: 10px; margin-right: 8px;}
		.content .bx-pager .bx-pager-item a {display: block; overflow: hidden; width: 10px; height: 10px; background-color: #F0F2F3; border-radius: 10px; text-indent: -999em; cursor: pointer;}
		.content .bx-pager .bx-pager-item a.active {background-color: #ffd20d;}

			/*.content h1{ display:block; width:60px; height:22px; padding:8px 0 0 10px; background:#e73640; position:absolute; right:-20px; top:-30px;}
			.content h1 span em{ width:10px; height:10px; background:#F0F2F3; border:1px solid #E6E9EA; border-radius:10px; margin:0 3px; display:inline-block; cursor:pointer;}
			.content h1 span em.emon{ width:12px; height:12px; background:#ffd20d; border:none;}
			.list1{ width:990px; height:305px;  overflow:hidden; display:none;}*/
				
		
		/*.cont3-wrap ul{ height:500px; padding:15px 10px; background:#fff }
		.cont3-wrap li{ width:180px; height:235px; margin:5px 7px; display:inline; text-align:center; padding-top:5px; float:left; background:#ffa401 }
		.cont3-wrap li h3{ font:bold 22px/25px "微软雅黑"; padding-top:5px; color:#fff }
		.cont3-wrap li p{ font:16px/28px "微软雅黑"; color:#864f00 }
		.cont3-wrap li p em{ font-style:normal; font:26px/35px Tahoma; color:#e73640; }
		.cont3-wrap li label{ width:170px; display:block; margin:0 auto; height:35px; background:#e73640;text-align:center; border:0 none; }
		.cont3-wrap li label a{ font:bold 18px/35px "微软雅黑"; color:#fff; }*/
		
	.cont4-wrap{ width:990px; height:513px; border-bottom:10px solid #9e5e04; background:#ffd20d }
		.cont4-wrap .tabList{ display:block; width:990px; height:100px; padding-top:20px; }
		.cont4-wrap .tabList ul li{
			display:block;
			width:477px; height:70px; margin:0 9px; display:inline; float:left; font:bold italic 30px/65px "微软雅黑"; text-align:center;
			color:#9e5f05;
			float:left;
			text-align:center;
			position:relative;
			cursor:pointer;
			background:#ffea87;
		}
		.cont4-wrap .tabList li.cur{
			background:#ffdf5b;
			color:#e73640;
		}
		.cont4-wrap .tabCon{
			width:990px;
			height:270px;
		}
		.cont4-wrap .tabCon div{
			width: 100%;
			height: 100%;
		}		
		.tabCon li{ width:327px; float:left; text-align:center } 
		.tabCon li p{ padding-top: 10px; font:bold 28px "微软雅黑"; color:#9e5f05 }
		
	.cont5-wrap{ width:990px; height:620px }
		.cont5-wrap h4{ height:30px; padding-top:51px; background:url(${zt_che_url!}wuhan/150427/imgs/nav_bg05.gif) no-repeat }
		.cont5-wrap h4 span{ float:right; display:block; width: 60px; height: 20px; padding: 10px 0 0 10px; background: #fcbc04;}
		.cont5-wrap h4 span em {display: block; float: left; margin-right: 8px; overflow: hidden; width: 10px; height: 10px; background-color: #F0F2F3; border-radius: 10px; text-indent: -999em; cursor: pointer;}
		.cont5-wrap h4 span em.cur {background-color: #E73541;}

		.content .bx-pager {position: absolute; top: -30px; right:0px; width: 60px; height: 20px; padding: 10px 0 0 10px; background: #e73640;}
		.content .bx-pager .bx-pager-item {float: left; height: 10px; margin-right: 8px; overflow: hidden; width: 10px; height: 10px; background-color: #F0F2F3; border-radius: 10px; text-indent: -999em; cursor: pointer;}
		.content .bx-pager .bx-pager-item a {display: block; overflow: hidden; width: 10px; height: 10px; background-color: #F0F2F3; border-radius: 10px; text-indent: -999em; cursor: pointer;}
		.content .bx-pager .bx-pager-item a.active {background-color: #ffd20d;}

		.cont5-wrap .go-over-box{ height:500px; padding:10px; background:#fff }
			.cont5-wrap .go-over-box .won_List{ width:475px; float:left; padding-right:10px; height:480px; }
			.cont5-wrap .go-over-box .won_List ul{ height:480px; padding:0 }
			.cont5-wrap .go-over-box .won_List ul li{ width:232px; height:158px; float:left; position:relative; background:#ffd20d }
				.cont5-wrap .go-over-box .won_List ul li.w1{ width:475px; height:326px; margin-bottom:10px }
				.cont5-wrap .go-over-box .won_List ul li.w2{ width:475px; height:158px; margin-top:10px; }
				.cont5-wrap .go-over-box .won_List ul li.m1{ margin-right:11px}
				.cont5-wrap .go-over-box .won_List ul li.m2{ margin-bottom:10px}
			.cont5-wrap .go-over-box .won_List ul li p{ position:absolute; display:block; width:100%; height:30px; font:14px/30px Tahoma; color:#fff; text-indent:10px; bottom:0; left:0; background:url(${zt_che_url!}wuhan/150427/imgs/alpha_bg.png) }
		
		
	.cont6-wrap{ width:990px; height:215px; background:#ffd20d }
	.cont6-wrap ul{ }
	.cont6-wrap li{ float:left }
	.cont6-wrap li span{ float:left }
	.cont6-wrap li p{ display:block; width:300px; padding:10px 0 0 20px; font:12px/20px Tahoma; float:left }
		
		
/* 弹出层 */
.shade{display: none; position: absolute; top: 0; left: 0; z-index: 100; width: 100%; background: #000; filter:alpha(opacity=50); -moz-opacity:0.5; -khtml-opacity: 0.5; opacity: 0.5;}
.popup-box {display: none; width: 604px; height: 318px; padding: 10px; border-radius: 8px; font-size: 14px; color: #000; background: #fff;}
.popup-box .pop-column {position: relative; height: 35px; border-bottom: 1px dotted #EEEEEE;}
.pop-column h1 {line-height: 26px; font-size: 20px; font-weight: bold; }
.pop-column a {position: absolute; top: -5px; right: -5px; display: block; font-size: 18px; line-height: 18px; padding: 2px 5px; color: #999; text-decoration: none;}
.pop-column a:hover {color: red; background: #eee;}
.popup-box .popup-con {height: 264px;}
.popup-con ul li {height: 28px; line-height: 28px; margin-bottom: 15px;}
.popup-con ul li.tips {margin-top: 13px; margin-bottom: 15px; text-align: center; font-size: 16px;}
.popup-con ul li span.red {color: red;}
.popup-con ul li label {display: block; width: 146px; height: 28px; float: left; overflow: hidden; line-height: 28px; text-align: right;}
.popup-con ul li .text1 {display: block; width: 190px; height: 26px; border: 1px solid #c7c7c7; margin-right: 10px; float: left; line-height: 26px; text-indent: 4px;}
.popup-con ul li select {height: 26px; border: 1px solid #c7c7c7; margin-right: 10px; float: left;}
.popup-con ul li .btn3 {width: 190px; height: 36px; border: 1px solid #D26E02; border-radius: 4px; font-size: 18px; cursor: pointer; text-align: center; color: #fff; line-height: 16px; background: #FF9A2B;}

/* 合作商家 */
.hz-wrap {height: auto!important; min-height: 88px; height: 88px; background: url(${zt_che_url!}wuhan/150427/imgs/body_bg2.gif) repeat-y top center; font-family: "Microsoft YaHei";}
.hz-con {width: 990px; margin: 0 auto;}
.hz-tit {position: relative; height: 69px; padding: 20px 0;}
.hz-tit .tit-img-fix {position: absolute; top: 20px; left: -40px;}
.hz-list {width: 990px; overflow: hidden;}
.hz-list ul {width: 1020px;}
.hz-list li {float: left; width: 240px; height: 252px; padding-right: 10px; margin-bottom: 20px; background: #ffd20d;}
.hz-list .hz-pic {overflow: hidden; margin-bottom: 10px;}
.hz-pic img {width: 240px; height: 160px;}
.hz-list h4 {padding: 0 5px 8px; font-size: 15px; line-height: 1.2; color: #333; font-weight: 700;}
.hz-list p {padding: 0 5px 5px; font-size: 14px; line-height: 1.2; color: #333;}

</style>
</head>
<body>
<!-- 头部 -->
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

<#if dataMap.get("左侧二维码")??>
	<#list dataMap.get("左侧二维码") as data>
		<#if data_index lt 1>
			<div class="slide01"><img src="${data.pic!}" /></div>
		</#if>
	</#list>
</#if>

<#if dataMap.get("右侧点击报名")??>
	<#list dataMap.get("右侧点击报名") as data>
		<#if data_index lt 1>
			<div class="slide02"><a href="#form"><img src="${data.pic!}"/></a></div>
		</#if>
	</#list>
</#if>

<!--  主页模块  -->
<div class="banner">
	
</div>

<!--  主页模块  -->
<div id="box">
	<!-- content1 here-->
	<div class="cont1-wrap">
			
		<div class="cont1-w-news">
			<div class="txt-slider-box">
				<div class="txt-slider-num">
					<span class="current"></span>
					<span class=""></span>
					<span class=""></span>
				</div>
				<div class="txt-info">
					<ul>
						<#if dataMap.get("焦点图上方文字链")??>
							<#list dataMap.get("焦点图上方文字链") as data>
								<#if data_index lt 3>
									<li style="<#if data_index == 0>display: list-item;<#else>display: none;</#if>"><a href="${data.link!}" target="_blank">${data.title!}</a></li>
								</#if>
							</#list>
						</#if>
					</ul>
				</div>
			</div>
			<div class="cont1-w-news-L">
				<div id="playBox">
					<ul class="bxslider1">
						<#if dataMap.get("焦点图w314_h216")??>
							<#list dataMap.get("焦点图w314_h216") as data>
								<#if data_index lt 5>
									<li><a href="${data.link!}" target="_blank"><img src="${data.pic!}" width="324" height="216" /></a></li>
								</#if>
							</#list>
						</#if>
					</ul>
				</div>
				<ul>
					<#if dataMap.get("焦点图下方图片w324_h158")??>
						<#list dataMap.get("焦点图下方图片w324_h158") as data>
							<#if data_index lt 1>
								<li style="padding-top:10px;"><img src="${data.pic!}" /></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="cont1-w-news-R">
				<dl>
					<#if dataMap.get("焦点图右侧红框新闻")??>
						<#list dataMap.get("焦点图右侧红框新闻") as data>
							<#if data_index lt 3>
								<dt><a href="${data.link!}" target="_blank">${data.title!}</a></dt>
							</#if>
						</#list>
					</#if>
				</dl>
				<ul>
					
					<#if dataMap.get("中间新闻大标题")??>
						<#list dataMap.get("中间新闻大标题") as data>
							<#if data_index lt 1>
								<h3><a href="${data.link}" target="_blank">${data.title}</a></h3>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("中间新闻小标题")??>
						<#list dataMap.get("中间新闻小标题") as data>
							<#if data_index lt 5>
								<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>	
		<form name="form1" method="post" action="" id="form">
		<div class="cont1-w-form">
			<img src="${zt_che_url}wuhan/150427/imgs/pic_bmNav.gif"/>
			<ul>
				<li><span>*姓名：</span><input value="" name="name" id="username" type="text" placeholder="请正确填写（必填）"></li>
				<li><span>*手机：</span><input value="" name="name" id="userphone" type="text" placeholder="请正确填写（必填）"></li>
				<li>
				<span>意向品牌：</span>
				<select id="brand" type="text" lock="true" class="input">
					<option value="">——请选择品牌——</option>
					<#if dataMap.get("自主品牌")??>
						<#list dataMap.get("自主品牌") as data>
							<option value="${data.content!}">${data.title!}</option>
						</#list>
					</#if>
					<#if dataMap.get("合资品牌")??>
						<#list dataMap.get("合资品牌") as data>
							<option value="${data.content!}">${data.title!}</option>
						</#list>
					</#if>
					<#if dataMap.get("豪华品牌")??>
						<#list dataMap.get("豪华品牌") as data>
							<option value="${data.content!}">${data.title!}</option>
						</#list>
					</#if>
				</select>
				</li>
				<li>
				<span>意向车型：</span>
				<select id="cartype" type="text" lock="true" class="input">
					<option value="">——请选择车型——</option>
				</select>
				</li>
				<li style="text-align:center"><label><input type="button" name="Submit" class="submit" value="立即报名" onclick="javascript:saveuserinfo();"/></label></li>
			</ul>
			<dl>
			<#if dataMap.get("报名框下方二维码w267_h195")??>
				<#list dataMap.get("报名框下方二维码w267_h195") as data>
					<#if data_index lt 1>
						<dd><img src="${data.pic!}"/></dd>
					</#if>
				</#list>
			</#if>
			</dl>
		</div>
		</form>
	
	</div>
	<!-- content1 end-->	
	<div class="cont2-wrap">
		<h4><img src="${zt_che_url}wuhan/150427/imgs/nav_bg01.gif" /></h4>
		<ul>
			<#if dataMap.get("礼品免费送w240_h276")??>
				<#list dataMap.get("礼品免费送w240_h276") as data>
					<#if data_index lt 4>
						<li <#if data_index == 3>style="padding:0"</#if>><a href="${data.link!}" target="_blank"><img src="${data.pic!}"/></a></li>
					</#if>
				</#list>
			</#if>
		</ul>
	</div>
	<div class="cont3-wrap">
		<h4></h4>
		<div style="position:absolute; left:-38px; top:115px"><img src="${zt_che_url}wuhan/150427/imgs/btn01_d.jpg" /></div>
		<div class="tab-nav1">
			<a href="javascript:void(0);" class="current">合资品牌</a>
			<a href="javascript:void(0);">自主品牌</a>
			<a href="javascript:void(0);">豪华品牌</a>
		</div>
		<div class="tab-con1">
			<div class="content" style="display:block;">
				<ul class="brand_bxSlider1">
					<li class="bxslider-li">
						<ul>
							<#if dataMap.get("合资品牌")??>
								<#list dataMap.get("合资品牌") as data>
									<#if data_index lt 10>
										<li>
											<div class="brand-img-box">
												<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
											</div>
											<h3>${data.title!}</h3>
											<p>已有<em>${data.ctitle!}</em>人报名</p>
											<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					<#if dataMap.get("合资品牌")??>
						<#list dataMap.get("合资品牌") as data>
							<#if data_index == 10>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("合资品牌")??>
											<#list dataMap.get("合资品牌") as data>
												<#if data_index gt 9>
													<#if data_index lt 20>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("合资品牌")??>
						<#list dataMap.get("合资品牌") as data>
							<#if data_index == 20>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("合资品牌")??>
											<#list dataMap.get("合资品牌") as data>
												<#if data_index gt 19>
													<#if data_index lt 30>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="content" style="display:none;">
				<ul class="brand_bxSlider2">
					<li class="bxslider-li">
						<ul>
							<#if dataMap.get("自主品牌")??>
								<#list dataMap.get("自主品牌") as data>
									<#if data_index lt 10>
										<li>
											<div class="brand-img-box">
												<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
											</div>
											<h3>${data.title!}</h3>
											<p>已有<em>${data.ctitle!}</em>人报名</p>
											<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					<#if dataMap.get("自主品牌")??>
						<#list dataMap.get("自主品牌") as data>
							<#if data_index == 10>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("自主品牌")??>
											<#list dataMap.get("自主品牌") as data>
												<#if data_index gt 9>
													<#if data_index lt 20>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("自主品牌")??>
						<#list dataMap.get("自主品牌") as data>
							<#if data_index == 20>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("自主品牌")??>
											<#list dataMap.get("自主品牌") as data>
												<#if data_index gt 19>
													<#if data_index lt 30>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="content" style="display:none;">
				<ul class="brand_bxSlider3">
					<li class="bxslider-li">
						<ul>
							<#if dataMap.get("豪华品牌")??>
								<#list dataMap.get("豪华品牌") as data>
									<#if data_index lt 10>
										<li>
											<div class="brand-img-box">
												<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
											</div>
											<h3>${data.title!}</h3>
											<p>已有<em>${data.ctitle!}</em>人报名</p>
											<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					<#if dataMap.get("豪华品牌")??>
						<#list dataMap.get("豪华品牌") as data>
							<#if data_index == 10>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("豪华品牌")??>
											<#list dataMap.get("豪华品牌") as data>
												<#if data_index gt 9>
													<#if data_index lt 20>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("豪华品牌")??>
						<#list dataMap.get("豪华品牌") as data>
							<#if data_index == 20>
								<li class="bxslider-li">
									<ul>
										<#if dataMap.get("豪华品牌")??>
											<#list dataMap.get("豪华品牌") as data>
												<#if data_index gt 19>
													<#if data_index lt 30>
														<li>
															<div class="brand-img-box">
																<img src="http://img.315che.com/hd/ssss/logo/logo${data.content!}.png" alt="${data.title!}">
															</div>
															<h3>${data.title!}</h3>
															<p>已有<em>${data.ctitle!}</em>人报名</p>
															<label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.content!});">团购报名</a></label>
														</li>
													</#if>
												</#if>
											</#list>
										</#if>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="cont4-wrap" id="tab2">
		<h4><img src="${zt_che_url!}wuhan/150427/imgs/nav_bg03.gif" /></h4>
		<div class="tabList">
			<ul>
				<li class="cur">特价区</li>
				<li>试驾区</li>
			</ul>
		</div>
		<div class="tabCon">
			<div style="display:block;">
				<ul>
					<#if dataMap.get("特价区w314_h210")??>
						<#list dataMap.get("特价区w314_h210") as data>
							<#if data_index lt 3>
								<li><img src="${data.pic!}" /><p>${data.title!}<br/>${data.ctitle!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div style="display:none;">
				<ul>
					<#if dataMap.get("试驾区w314_h210")??>
						<#list dataMap.get("试驾区w314_h210") as data>
							<#if data_index lt 3>
								<li><img src="${data.pic!}" /><p>${data.title!}<br/>${data.ctitle!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
	</div>
	<#if dataMap.get("购车攻略w990_h280")??>
		<#list dataMap.get("购车攻略w990_h280") as data>
			<#if data_index lt 1>
				<div><img src="${data.pic!}"/></div>
			</#if>
		</#list>
	</#if>
	
	<div class="cont5-wrap">
		<h4><span class="go-over-tab"><em class="cur">1</em>
		<#if dataMap.get("精彩回顾大图片w658_h638")??>
			<#list dataMap.get("精彩回顾大图片w658_h638") as data>
				<#if data_index == 1>
					<em>2</em>
				</#if>
			</#list>
		</#if>
		<#if dataMap.get("精彩回顾大图片w658_h638")??>
			<#list dataMap.get("精彩回顾大图片w658_h638") as data>
				<#if data_index == 2>
					<em>3</em>
				</#if>
			</#list>
		</#if>
		</span></h4>
		
		<div class="go-over-box" style="display:block;">
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾大图片w658_h638")??>
						<#list dataMap.get("精彩回顾大图片w658_h638") as data>
							<#if data_index == 0>
								<li class="w1"><img src="${data.pic!}"/><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 0>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 1>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 2>
								<li class="m1 m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 3>
								<li class="m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 4>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 5>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾长图片w475_h158")??>
						<#list dataMap.get("精彩回顾长图片w475_h158") as data>
							<#if data_index == 0>
								<li class="w2"><img src="${data.pic!}" width="475" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
		<#if dataMap.get("精彩回顾大图片w658_h638")??>
			<#list dataMap.get("精彩回顾大图片w658_h638") as data>
				<#if data_index == 1>
		<div class="go-over-box" style="display:none;">
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾大图片w658_h638")??>
						<#list dataMap.get("精彩回顾大图片w658_h638") as data>
							<#if data_index == 1>
								<li class="w1"><img src="${data.pic!}"/><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 6>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 7>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 8>
								<li class="m1 m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap("精彩回顾小图片w232_h158")??>
						<#list dataMap("精彩回顾小图片w232_h158") as data>
							<#if data_index == 9>
								<li class="m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 10>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 11>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾长图片w475_h158")??>
						<#list dataMap.get("精彩回顾长图片w475_h158") as data>
							<#if data_index == 1>
								<li class="w2"><img src="${data.pic!}" width="475" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
		</#if>
			</#list>
		</#if>
		<#if dataMap.get("精彩回顾大图片w658_h638")??>
			<#list dataMap.get("精彩回顾大图片w658_h638") as data>
				<#if data_index == 2>
		<div class="go-over-box" style="display:none;">
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾大图片w658_h638")??>
						<#list dataMap.get("精彩回顾大图片w658_h638") as data>
							<#if data_index == 2>
								<li class="w1"><img src="${data.pic!}"/><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 12>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 13>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="won_List">
				<ul>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 14>
								<li class="m1 m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 15>
								<li class="m2"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 16>
								<li class="m1"><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾小图片w232_h158")??>
						<#list dataMap.get("精彩回顾小图片w232_h158") as data>
							<#if data_index == 17>
								<li><img src="${data.pic!}" width="232" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("精彩回顾长图片w475_h158")??>
						<#list dataMap.get("精彩回顾长图片w475_h158") as data>
							<#if data_index == 2>
								<li class="w2"><img src="${data.pic!}" width="475" height="158" /><p>${data.title!}</p></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
		</#if>
		</#list>
	</#if>
	</div>
	
	<div class="cont6-wrap">
		<ul>
			<li>
				<#if dataMap.get("底部左侧图片w265_h216")??>
					<#list dataMap.get("底部左侧图片w265_h216") as data>
						<#if data_index lt 1>
							<img src="${data.pic!}" />
						</#if>
					</#list>
				</#if>
				<#if dataMap.get("底部右侧图片w631_h216")??>
					<#list dataMap.get("底部右侧图片w631_h216") as data>
						<#if data_index lt 1>
							<img src="${data.pic!}"/>
						</#if>
					</#list>
				</#if>
			</li>
		</ul>
	</div>
</div>
<#if dataMap.get("底部合作商家头图w316_h69")??>
<div class="hz-wrap">
	<div class="hz-con">
		<div class="hz-tit">
			<#if dataMap.get("底部合作商家头图w316_h69")??>
				<#list dataMap.get("底部合作商家头图w316_h69") as data>
					<#if data_index lt 1>
						<img class="tit-img-fix" src="${data.pic!}"/>
					</#if>
				</#list>
			</#if>
		</div>
		<div class="hz-list">
			<ul>
				<#if dataMap.get("底部合作商家w240_h160")??>
					<#list dataMap.get("底部合作商家w240_h160") as data>
						<li>
							<a href="${data.link!}" target="_blank">
								<div class="hz-pic">
									<img src="${data.pic!}" alt="${data.title!}">
								</div>
								<h4>${data.title!}</h4>
								<p><strong>电话：</strong><span>${data.ctitle!}</span></p>
								<p><strong>地址：</strong><span>${data.content!}</span></p>
							</a>
						</li>
					</#list>
				</#if>
			</ul>
		</div>
	</div>
</div>
	
	
	
</#if>


<!-- 底部 -->
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
		Copyright © 2005-2010
		<a href="mailto:admin@315che.com">中国汽车消费网</a>
		备案号:
		<a target="_blank" href="http://www.miibeian.gov.cn">沪ICP 备 05053107 号</a>
	</p>
</div>

    <!-- 弹出层 开始 -->
    <div id="mask" class="shade"></div>
    <div id="popupLayerOne" class="popup-box">
        <div class="pop-column">
            <h1>报名申请</h1><a id="colse-popup" href="javascript:void(0);">×</a>
        </div>
        <div class="popup-con">
            <form action="#">
            <ul>
                <li class="tips">您好，请输入手机号，立即<span class="red">参团</span>，赢取好礼</li>
                <li>
                    <label><span class="red">*</span>您的姓名：</label>
                    <input type="text" class="text1" id="name">
                </li>
                <li>
                    <label><span class="red">*</span>您的手机：</label>
                    <input type="text" class="text1" id="phone">
                    <input type="radio" name="sex" value="1" /> 先生
                    <input type="radio" name="sex" value="2" /> 女士
                </li>
                <li>
                    <label><span class="red">*</span>所在地区：</label>
                    <select id="pro">
                    </select>
                    <select id="city">
                    </select>
                </li>
                <li>
                    <label>意向车型：</label>
                    <select name="" id="modelid">
                        <option value="">选择车型</option>
                    </select>
                </li>
                <li>
                    <label>&nbsp;</label>
                    <input type="button" class="btn3" value="提交报名" id="bottom_submit" onclick="javascript:savebottomuserinfo();"/>
                </li>
                <input type="hidden" id="carid" value=""/>
            </ul>
            </form>
        </div>
    </div>
    <!-- 弹出层 结束 -->

<!-- script codes -->
<script src="http://zt.315che.com/common/js/jquery-1.11.1.min.js"></script>
<script src="http://zt.315che.com/common/js/jquery.bxslider.min.js"></script>
<script src="http://zt.315che.com/common/js/brand.js"></script>
<script src="http://zt.315che.com/common/js/cartype.js"></script>

<script>
	$(function(){
		var pro = '${dataMap.get("车展城市")[0].title!}';
		var html = '<option value="'+pro+'">${dataMap.get("车展城市")[0].content!}</option>';
		$("#pro").html(html);
		$.ajax({
			url:'http://www.315che.com/che/getTousuCity',
			data:{prov:pro},
			dataType:'jsonp',
			jsonp:'jsonpcallback',
			success:function(data){
				var data = eval(data)
				var html = '<option value="">请选择区域</option>';
				for(var i =0 ;i<data.length;i++)
				{
					html+='<option value='+data[i].catalogid+'>'+data[i].catalogname+'</option>';
				}
				$("#city").html(html);
			}
		});
	});


		/*$(function(){
			var brandMap = brandstr[0];
			var html = '<option value="">选择品牌</option>';
			for(var key in brandMap){
				html +='<option value="'+key+'">'+brandMap[key]+'</option>';  
			}  				
			$("#brand").html(html);
		});
		*/
		
		$("#brand").change(function(){
			var carid = $(this).val();
			var carMap = carjson[0];
			for(var key in carMap){
				if(carid==key){
					var carTypeMap = carMap[key];
					var html = '<option value="">选择车型</option>';
					for(var key1 in carTypeMap){
						html +='<option value="'+key1+'">'+carTypeMap[key1]+'</option>';  
					}
					$("#cartype").html(html);
					break;
				}
				
			}
		
		});
		
		
		//报名提交
		function saveuserinfo(){
			var pro = '${dataMap.get("车展城市")[0].title!}';
			var city =  '${dataMap.get("车展城市")[0].ctitle!}';
			var modelid= $("#cartype").val();
			var name=$("#username").val();
			var phone=$("#userphone").val();
			var carid=$("#brand").val();
			if(modelid==""){
				alert("请选择车型！");
				return;
			}
			if(name == "" || name=="请输入您的姓名"){
				alert("请输入姓名！");
				return;
			}
			if(phone == "" || name=="请输入您的手机号"){
				alert("请输入手机号！");
				return;
			}
			if(name.length>15){
				alert("输入的名称太长");
				return;
			}
			var regTel=l=/^1[3|5|7|8|][0-9]{9}$/;
			if(!regTel.test(phone)){
				alert("请正确输入手机号");
				return;
			}
			
			var carinfo="品牌："+$("#brand").children("option:selected").text()+"车系："+$("#cartype").children("option:selected").text();
			$.ajax({
				url : 'http://182.254.147.194:8180/chetuan/saveApplyInf',
				dataType : 'jsonp',
				data :{name:encodeURI(name),carid:carid,modelid:modelid,phone:phone,sex:1,city:city,prov:pro,carinfo:encodeURI(carinfo),isSendSms:1},
				jsonp:'jsonpcallback',
				success : function(data){
					<#if dataMap.get("车展短信")?size gt 0>
						<#list dataMap.get("车展短信") as data>
								$.ajax({
									url:'http://182.254.147.194:8180/chetuan/saveMsg',
									dataType : 'jsonp',
									data :{msg:encodeURI('${data.content!}'),phone:phone},
									jsonp:'jsonpcallback',
									success : function(data){
										alert("报名成功！！！");
									}
								});
						</#list>
					<#else>
						alert("报名成功");
					</#if>
				}
			});
		}	
		
		//报名提交
		function savebottomuserinfo(){
			var pro = '${dataMap.get("车展城市")[0].title!}';
			var modelid= $("#modelid").val();
			var name=$("#name").val();
			var phone=$("#phone").val();
			var carid=$("#carid").val();
			var city = $("#city").val();
			
			if(modelid==""){
				alert("请选择车型！");
				return;
			}
			if(name == "" || name=="请输入您的姓名"){
				alert("请输入姓名！");
				return;
			}
			if(phone == "" || name=="请输入您的手机号"){
				alert("请输入手机号！");
				return;
			}
			if(name.length>15){
				alert("输入的名称太长");
				return;
			}
			var regTel=l=/^1[3|5|7|8|][0-9]{9}$/;
			if(!regTel.test(phone)){
				alert("请正确输入手机号");
				return;
			}
			var brandname = "暂无";
			var brandMap = brandstr[0];
			for(var key in brandMap){
				if(key==carid){
					brandname = brandMap[key];
					break;
				}
			} 
			
			var carinfo="品牌："+brandname+" 车系："+$("#modelid").children("option:selected").text();
			$.ajax({
				url : 'http://182.254.147.194:8180/chetuan/saveApplyInf',
				dataType : 'jsonp',
				data :{name:encodeURI(name),carid:carid,modelid:modelid,phone:phone,sex:1,city:city,prov:pro,carinfo:encodeURI(carinfo),isSendSms:1},
				jsonp:'jsonpcallback',
				success : function(data){
					<#if dataMap.get("车展短信")?size gt 0>
						<#list dataMap.get("车展短信") as data>
								$.ajax({
									url:'http://182.254.147.194:8180/chetuan/saveMsg',
									dataType : 'jsonp',
									data :{msg:encodeURI('${data.content!}'),phone:phone},
									jsonp:'jsonpcallback',
									success : function(data){
										alert("报名成功！！！");
									}
								});
						</#list>
					<#else>
						alert("报名成功");
					</#if>
					$('#mask').hide();
					$('#popupLayerOne').hide();
				}
			});
		}	
		
		
		function showCarList(carid){
			$("#carid").val(carid);
			var carMap = carjson[0];
			for(var key in carMap){
				if(carid==key){
					var carTypeMap = carMap[key];
					var html = '<option value="">选择车型</option>';
					for(var key1 in carTypeMap){
						html +='<option value="'+key1+'">'+carTypeMap[key1]+'</option>';  
					}
					$("#modelid").html(html);
					break;
				}
			}
			
		
		}
		
	
	</script>

<script>
	$(function(){
		//焦点图片新闻
		$('.bxslider1').bxSlider({
			mode: 'horizontal',
			auto: true,
			controls: false
		});
		//文字新闻，点击小按钮切换
		$('.txt-slider-num span').click(function() {
			$('.txt-slider-num span').removeClass('current');
			$(this).addClass('current');
			var index = $(this).index();
			$('.txt-info ul li').eq(index).show().siblings('.txt-info ul li').hide();
		});
		
		//文字新闻，自动切换
		setInterval(function() {
			var index = $('.txt-slider-num span[class=current]').index();
			index = index+1;
			if(index>=3) {index=0}
			$('.txt-slider-num span').removeClass('current').eq(index).addClass('current');
			$('.txt-info ul li').eq(index).show().siblings('.txt-info ul li').hide();
		},5000);
		//合资品牌切换
		$('.brand_bxSlider1').bxSlider({
			options: 'horizontal',
			auto: false,
			controls: false,
			infiniteLoop: false,
			hideControlOnEnd: true
		});
		$('.brand_bxSlider2').bxSlider({
			options: 'horizontal',
			auto: false,
			controls: true,
			infiniteLoop: false,
			hideControlOnEnd: true
		});
		$('.brand_bxSlider3').bxSlider({
			options: 'horizontal',
			auto: false,
			controls: true,
			infiniteLoop: false,
			hideControlOnEnd: true
		});
		//品牌大类切换
		$(".tab-nav1 a").click(function() {
			$(this).siblings().removeClass("current");
			$(this).addClass("current");
			var index = $(this).index();
			$(".tab-con1 .content").hide();
			$(".tab-con1 .content").eq(index).fadeIn(1000);
		});
		//试车体验区切换
		$(".tabList li").click(function() {
			$(this).siblings().removeClass("cur");
			$(this).addClass("cur");
			var index = $(this).index();
			$(".tabCon div").hide();
			$(".tabCon div").eq(index).fadeIn("slow");
		});
		//精彩回顾切换
		$(".go-over-tab em").click(function() {
			$(this).siblings().removeClass("cur");
			$(this).addClass("cur");
			var index = $(this).index();
			$(".cont5-wrap .go-over-box").hide();
			$(".cont5-wrap .go-over-box").eq(index).fadeIn("slow");
		});
        // popup layer 团购报名弹出层
        var _pupupLayer = function () {
            var _scrollHeight = $(document).scrollTop(),//获取当前窗口距离页面顶部高度
            _windowHeight = $(window).height(),//获取当前窗口高度
            _windowWidth = $(window).width(),//获取当前窗口宽度
            _popupHeight = $('.popup-box').height(),//获取弹出层高度
            _popupWeight = $('.popup-box').width();//获取弹出层宽度
            var _posiTop = (_windowHeight - _popupHeight)/2 + _scrollHeight;
            var _posiLeft = (_windowWidth - _popupWeight)/2;
            var iMax = Math.max(document.body.scrollHeight,document.body.offsetHeight,document.documentElement.clientHeight);
            $('#mask').css('height',iMax).show();
            $('#popupLayerOne').css({
                'position':'absolute',
                'top':_posiTop+'px',
                'left':_posiLeft+'px',
                'z-index':'9999'
            }).show();
            $('#mask').click(function(){
                $(this).hide();
                $('#popupLayerOne').hide();
            });
            $('#colse-popup').click(function(){
                $('#mask').hide();
                $('#popupLayerOne').hide();
            });
        }
        $(".baoming-btn").click(function(){
            _pupupLayer();
        }); 
	});
</script>
<div style="display:none;"><script src='http://w.cnzz.com/c.php?id=30051030&l=3' language='JavaScript'></script></div>
</body>
</html>