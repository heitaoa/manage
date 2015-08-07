<!DOCTYPE html>
<html lang="zh-hans">
<head>
	<meta charset="UTF-8">
	<title>${title!}</title>
	<!--<link rel="stylesheet" href="http://zt.315che.com/chezhan/917/css/style.css">-->
<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video { margin: 0; padding: 0; border: 0; }
body { font: 1em 'Microsoft Yahei',simsun, Verdana, sans-serif; background: #fafafa; color: #000; }
a { color: #333; text-decoration: none; -webkit-transition: all 0.5s ease-in; -moz-transition: all 0.5s ease-in; transition: all 0.5s ease-in; }
img { max-width: 100%; display: block; border: 0; }
ol, ul, li { list-style: none; }
input, select, textarea { margin: 0; padding: 0; outline: none; }
input[type="text"], input[type="button"], input[type="submit"], input[type="search"], input[type="number"], select { border-radius: 0; }
.clearfix:before, .clearfix:after { content: ""; display: table; }
.clearfix:after { clear: both; }
.clearfix { zoom: 1; }

body { background: url(<#if dataMap.get("车展头图w1574_h717")??>
							<#list dataMap.get("车展头图w1574_h717") as data>
								<#if data_index lt 1>
									${data.pic!}
								</#if>
							</#list>
						</#if>) no-repeat top center; }
.wrapper { width: 990px; margin: 302px auto 0; }

.head-nav { font-size: 16px; }
.head-nav li { float: left; height: 50px; line-height: 50px; }
.head-nav li.tit {width: 82px; margin-right: 40px; font-size: 18px; font-weight: bold; text-align: center;}
.head-nav li.message-icon {width: 36px; margin-right: 27px; background: url(http://zt.315che.com/chezhan/917/images/icon1.png) no-repeat 50% 50%;}
.head-nav li ul li {overflow: hidden; max-width: 230px; margin-right: 30px; *width: 230px;}
.head-nav a {color: #fff; -webkit-text-shadow: 0 0 2px #000; -moz-text-shadow: 0 0 2px #000; text-shadow: 0 0 2px #000;}
.head-nav a:hover {color: #ebb70c; -webkit-text-shadow: 1px 1px 1px #000; -moz-text-shadow: 1px 1px 1px #000; text-shadow: 1px 1px 1px #000;}
.head-nav li.tit a {color: #eb4b3d; -webkit-text-shadow: 0 0 1px #999; -moz-text-shadow: 0 0 1px #999; text-shadow: 0 0 1px #999;}

.top-container { width: 990px; margin: 15px 0 0; overflow: hidden; }
.focus-slider { position: relative; float: left; width: 576px; height: 384px; }
.focus-slider .bx-caption { position: absolute; left: 0; bottom: 0; width: 100%; height: 40px; line-height: 40px; color: #fff; background: #000;filter:alpha(opacity=60); background: rgba(0,0,0,.6); }
.focus-slider .bx-caption span { margin-left: 10px; }
.focus-slider .bx-pager { position: absolute; right: 15px; bottom: 12px; z-index: 10; }
.focus-slider .bx-pager-item { float: left; margin-left: 10px; }
.focus-slider .bx-pager-item a { display: block; width: 12px; height: 12px; overflow: hidden; border: 1px solid #fff; background: transparent; text-indent: -9999px; -webkit-border-radius: 10px; border-radius: 10px; }
.focus-slider .bx-pager-item a.active { background-color: #fff; }
.focus-article { float: right; width: 356px; height: 342px; padding: 20px; overflow: hidden; text-align: center; background-color: #fff; border: 1px solid #dcdcdc; white-space: nowrap; }
.focus-article a:hover { border-bottom: 1px dotted #ccc; }
.focus-article h4 { font-size: 20px; height: 26px; padding: 10px 0; }
.focus-article h4 a { color: #eb4b3d; }
.focus-article p { height: 20px; margin-bottom: 14px; }
.focus-article .bd-btm { margin-bottom: 15px; padding-bottom: 15px; border-bottom: 1px dashed #dcdcdc; }
.focus-news { position: relative; float: left; width: 564px; height: 226px; padding: 5px; margin: 15px 0 0; border: 1px solid #dcdcdc; border-top: 4px solid #0f8b81; clear: both; }
.focus-news h3 { background: url(http://zt.315che.com/chezhan/917/images/foucs_news_top_bg.gif) repeat-x center 10px; }
.focus-news h3 span { font-weight: normal; font-size: 16px; color: #034c83; background-color: #fff; padding-right: 11px; }
.focus-news ul { margin-top: 10px; overflow: hidden; }
.focus-news li { float: left; width: 282px; padding: 5px 0; }
.focus-news .line {position: absolute; top: -4px; left: -1px; display: block; overflow: hidden; width: 90px; height: 4px; background-color: #eb4b3d;}
.autoshow-info { float: right; width: 396px; height: 239px; margin-top: 15px; border: 1px solid #dcdcdc; }
.autoshow-info h3 { color: #fff; font-size: 16px; font-weight: normal; width: 100%; height: 30px; line-height: 30px; background: #5436c8 url(http://zt.315che.com/chezhan/917/images/arrows_icon.gif) no-repeat 10px center; }
.autoshow-info h3 span { margin-left: 30px; }
.autoshow-info .con { padding: 7px; }
.autoshow-info .pic { margin-bottom: 10px; }
.autoshow-info p { margin: 4px 0; }

.gall-style1 .items, .gall-style2 .items, .gall-style3 .items { float: left; width: 310px; margin: 10px 30px 0 0; text-align: center; }
.gall-style1 .bx-pager, .gall-style2 .bx-pager, .gall-style3 .bx-pager { position: absolute; top: 42px; right: 10px; }
.gall-style1 .bx-pager-item, .gall-style2 .bx-pager-item, .gall-style3 .bx-pager-item { float: left; margin-left: 10px; }
.gall-style1 .bx-pager-item a, .gall-style2 .bx-pager-item a, .gall-style3 .bx-pager-item a { display: block; width: 12px; height: 12px; overflow: hidden; border: 1px solid #fff; background: transparent; text-indent: -9999px; -webkit-border-radius: 10px; border-radius: 10px; }
.gall-style1 .bx-pager-item a.active, .gall-style2 .bx-pager-item a.active, .gall-style3 .bx-pager-item a.active { background-color: #fff; }

.mainbody {}
.gallery-box { position: relative; width: 990px; overflow: hidden; }
.g-title { margin: 20px 0 0; width: 100%; height: 56px; background: url(http://zt.315che.com/chezhan/917/images/gall_title_bg.jpg) no-repeat; }
.g-title h2 { width: 215px; font-size: 24px; text-align: center; line-height: 50px; color: #fff; }
.gall-style1 ul { width: 990px; }
.gall-style1 li { width: 1020px !important; overflow: hidden; }
.gall-style1 li p { margin: 8px 0; }
.gall-style2 li { width: 990px; overflow: hidden; }
.gall-style2 .b-pic { position: relative; float: left; width: 330px; height: 290px; margin: 10px 0 0 0; }
.gall-style2 .s-pic { position: relative; float: left; width: 210px; height: 140px; margin: 0 0 20px 10px; }
.gall-style2 .b-pic span, .gall-style2 .s-pic span { position: absolute; left: 0; bottom: 0; _bottom: -1px; width: 100%; height: 40px; background: #000; filter: alpha(opacity=80); -moz-opacity: .8; opacity: .8; cursor: pointer; -webkit-transition: all 0.5s ease-in; -moz-transition: all 0.5s ease-in; transition: all 0.5s ease-in; }
.gall-style2 .b-pic p,  .gall-style2 .s-pic p { position: absolute; left: 0; bottom: 0; _bottom: -1px; width: 100%; color: #fff; text-align: center; height: 40px; line-height: 40px; cursor: pointer; }
.gall-style2 a:hover span { background-color: #eb4b3d; }
.gall-style3 ul { width: 990px; overflow: hidden; }
.gall-style3 li { width: 1020px !important; }
.gall-style3 .items { float: left; text-align: left; margin: 15px 10px 0 0; font-size: 14px; width: 240px; }
.gall-style3 .items h4 { font-size: 15px; color: #034c83; }
.gall-style3 .items p { width: 100%; }
.gall-style3 .items strong { float: left; }
.gall-style3 .items span { display: block; padding-left: 46px; }
.gall-style3 .items .pic { position: relative; width: 240px; height: 160px; }
.gall-style3 .items .logo { position: absolute; top: 0; left: 0; width: 60px; height: 60px; background-color: #fff; }


.main-bottom { margin: 20px 0 0; }
.main-bottom .title {  }
.main-bottom .title h2 { position: relative; bottom: -5px; width: 190px; height: 53px; color: #fff; font-size: 24px; line-height: 53px; padding-left: 50px; background: url(http://zt.315che.com/chezhan/917/images/title_bg.png) no-repeat; }
.main-bottom .market { float: left; width: 720px; }
.main-bottom .market .title { border-bottom: 5px solid #6e50e1; }
.main-bottom .market ul {}
.main-bottom .market li { height: 130px; padding: 12px 0; border-bottom: 1px dashed #dcdcdc; }
.main-bottom .market li:last-child { border: 0; }
.main-bottom .market li img { float: left; margin-right: 10px; }
.main-bottom .market li h4 { height: 34px; line-height: 34px; overflow: hidden; font-size: 18px; color: #333; }
.main-bottom .market li .time { height: 20px; line-height: 20px; overflow: hidden; padding-bottom: 5px; }
.main-bottom .market li p { font-size: 15px; line-height: 24px; }
.main-bottom .review { float: right; width: 240px; }
.main-bottom .review p { margin-bottom: 15px; }
.main-bottom .review .con { padding-top: 20px; }

.mylink { border: 1px solid #dcdcdc; }
.mylink .title { padding: 0 10px; height: 37px; line-height: 37px; color: #333; border-bottom: 1px solid #dcdcdc; }
.mylink .con { padding: 10px 0 10px 10px; }
.mylink .links { width: 100%; display: block; overflow: hidden; clear: both; }
.mylink .links li { float: left; width: 108px; height: 22px; line-height: 22px; text-align: center; margin: 5px 0 5px -1px; border-left: 1px solid #ccc; }

.footer { width: 990px; margin: 30px auto 0; padding-bottom: 20px; font-size: 14px; text-align: center; border-top: 4px solid #ced8e4; }
.footer p { padding: 4px 0; }
.footer p a { display: inline-block; color: #333; margin: 0 6px; }
.footer .copyright { font-size: 12px; }
.treebox-main .footer { width: 720px; margin-top: 40px; }

.fixed-nav { position: absolute; left: 50%; top: 650px; z-index: 99; margin-left: 500px; width: 140px; padding: 72px 0 0; background: url(http://zt.315che.com/chezhan/917/images/fixed_top.png) no-repeat top center; }
.fixed-nav ul { width: 140px; overflow: hidden; }
.fixed-nav li { border-bottom: 1px dotted #fff; background-color: #5436c8; }
.fixed-nav li a { font-size: 18px; font-weight: bold; color: #fff; display: block; width: 100%; height: 66px; line-height: 66px; text-align: center; -webkit-text-shadow: 0 0 2px #000; -moz-text-shadow: 0 0 2px #000; text-shadow: 0 0 2px #000; padding: 0 2px; }
.fixed-nav li a:hover { color: #eb4b3d; -webkit-text-shadow: 1px 1px 1px #000; -moz-text-shadow: 1px 1px 1px #000; text-shadow: 1px 1px 1px #000; }
.fixed-nav .triangle_border_down { position: relative; width: 0; height: 0; border-width: 70px 70px 0; border-style: solid; border-color: #5436c8 #fff #fff; margin: 0; border-bottom: 0; }
.fixed-nav .triangle_border_down a { position: absolute; top: -70px; _top: -90px; left: -20px; width: 22px; height: 28px; padding: 10px; display: block; background: url(http://zt.315che.com/chezhan/917/images/top_arrows.gif) no-repeat center center; text-indent: -9999px; }
</style>
</head>
<body>
	<div class="wrapper">
		<div class="head-nav">
			<ul class="clearfix">
				<li class="tit"><a href="javascript:void(0);">新闻快讯</a></li>
				<li class="message-icon"></li>
				<li class="message-list">
					<ul>
						<#if dataMap.get("新闻快讯")??>
							<#list dataMap.get("新闻快讯") as data>
								<#if data_index lt 3>
									<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
								</#if>
							</#list>
						</#if>
					</ul>
				</li>
			</ul>
		</div>
		<div class="top-container">
			<div class="focus-slider">
				<ul id="focus-slider">
					<#if dataMap.get("焦点图w576_h384")??>
						<#list dataMap.get("焦点图w576_h384") as data>
							<#if data_index lt 4>
								<li><img src="${data.pic!}" title="${data.title!}"></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
			<div class="focus-article">
				<div class="bd-btm">
					<#if dataMap.get("焦点图右侧大标题")??>
						<#list dataMap.get("焦点图右侧大标题") as data>
							<#if data_index == 0>
								<h4><a href="${data.link!}" target="_blank">${data.title!}</a></h4>
							</#if>
						</#list>
					</#if>
					<p>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 0>
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 1>
								|
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					</p>
					<#if dataMap.get("焦点图右侧大标题")??>
						<#list dataMap.get("焦点图右侧大标题") as data>
							<#if data_index == 1>
								<h4><a href="${data.link!}" target="_blank">${data.title!}</a></h4>
							</#if>
						</#list>
					</#if>
					<p>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 2>
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 3>
								|
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					</p>
				</div>
				<div>
					<#if dataMap.get("焦点图右侧大标题")??>
						<#list dataMap.get("焦点图右侧大标题") as data>
							<#if data_index == 2>
								<h4><a href="${data.link!}" target="_blank">${data.title!}</a></h4>
							</#if>
						</#list>
					</#if>
					<p>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 4>
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 5>
								|
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					</p>
					<#if dataMap.get("焦点图右侧大标题")??>
						<#list dataMap.get("焦点图右侧大标题") as data>
							<#if data_index == 3>
								<h4><a href="${data.link!}" target="_blank">${data.title!}</a></h4>
							</#if>
						</#list>
					</#if>
					<p>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 6>
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					<#if dataMap.get("焦点图右侧小标题")??>
						<#list dataMap.get("焦点图右侧小标题") as data>
							<#if data_index == 7>
								|
								<a href="${data.link!}" target="_blank">${data.title!}</a>
							</#if>
						</#list>
					</#if>
					</p>
				</div>
			</div>
			<div class="focus-news">
				<i class="line"></i>
				<h3><span>焦点新闻</span></h3>
				<div class="con">
					<ul>
						<#if dataMap.get("焦点新闻")??>
							<#list dataMap.get("焦点新闻") as data>
								<#if data_index lt 12>
									<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
								</#if>
							</#list>
						</#if>
					</ul>
				</div>
			</div>
			<div class="autoshow-info">
				<h3><span>车展信息</span></h3>
				<div class="con">
					<#if dataMap.get("车展信息w381_h139")??>
						<#list dataMap.get("车展信息w381_h139") as data>
							<#if data_index lt 1>
								<div class="pic"><img src="${data.pic}"></div>
								<p><strong>时间：</strong>${data.title!}</p>
								<p><strong>地点：</strong>${data.content!}</p>
							</#if>
						</#list>
					</#if>
				</div>
			</div>
		</div>
		<div class="mainbody">
			<div class="gallery-box">
				<div class="g-title">
					<h2>	
						<#if dataMap.get("自主新车标题")??>
							<#list dataMap.get("自主新车标题") as data>
								<#if data_index == 0>
									${data.title!}
								</#if>
							</#list>
						</#if>
					</h2>
				</div>
				<div class="con gall-style2">
					<ul id="g-slider-01">
						<li>
							<#if dataMap.get("自主新车w330_h290")??>
								<#list dataMap.get("自主新车w330_h290") as data>
									<#if data_index == 0>
										<div class="b-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("自主新车w210_h140")??>
								<#list dataMap.get("自主新车w210_h140") as data>
									<#if data_index lt 6>
										<div class="s-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
						</li>
						<li>
							<#if dataMap.get("自主新车w330_h290")??>
								<#list dataMap.get("自主新车w330_h290") as data>
									<#if data_index == 1>
										<div class="b-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("自主新车w210_h140")??>
								<#list dataMap.get("自主新车w210_h140") as data>
									<#if data_index gt 5>
										<#if data_index lt 12>
											<div class="s-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
										</#if>
									</#if>
								</#list>
							</#if>
						</li>
						<li>
							<#if dataMap.get("自主新车w330_h290")??>
								<#list dataMap.get("自主新车w330_h290") as data>
									<#if data_index == 2>
										<div class="b-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("自主新车w210_h140")??>
								<#list dataMap.get("自主新车w210_h140") as data>
									<#if data_index gt 11>
										<#if data_index lt 18>
											<div class="s-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
										</#if>
									</#if>
								</#list>
							</#if>
						</li>
					</ul>
				</div>
			</div>
			<div class="gallery-box">
				<div class="g-title">
					<h2>
						<#if dataMap.get("美女图库标题")??>
							<#list dataMap.get("美女图库标题") as data>
								<#if data_index == 0>
									${data.title!}
								</#if>
							</#list>
						</#if>
					</h2>
				</div>
				<div class="con gall-style2">
					<ul id="g-slider-02">
						<li>
							<#if dataMap.get("美女图库w330_h290")??>
								<#list dataMap.get("美女图库w330_h290") as data>
									<#if data_index == 0>
										<div class="b-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("美女图库w210_h140")??>
								<#list dataMap.get("美女图库w210_h140") as data>
									<#if data_index lt 6>
										<div class="s-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
						</li>
						<li>
							<#if dataMap.get("美女图库w330_h290")??>
								<#list dataMap.get("美女图库w330_h290") as data>
									<#if data_index == 1>
										<div class="b-pic"><a href="${data.link!}"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("美女图库w210_h140")??>
								<#list dataMap.get("美女图库w210_h140") as data>
									<#if data_index gt 5>
										<#if data_index lt 12>
											<div class="s-pic"><a href="${data.link!}"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
										</#if>
									</#if>
								</#list>
							</#if>
						</li>
						<li>
							<#if dataMap.get("美女图库w330_h290")??>
								<#list dataMap.get("美女图库w330_h290") as data>
									<#if data_index == 2>
										<div class="b-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
									</#if>
								</#list>
							</#if>
							<#if dataMap.get("美女图库w210_h140")??>
								<#list dataMap.get("美女图库w210_h140") as data>
									<#if data_index gt 11>
										<#if data_index lt 18>
											<div class="s-pic"><a href="${data.link!}" target="_blank"><img src="${data.pic!}" alt="${data.title!}"><span></span><p>${data.title!}</p></a></div>
										</#if>
									</#if>
								</#list>
							</#if>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="mylink">
			<div class="title"><h3>合作媒体</h3></div>
			<div class="con">
				<ul class="links">
					<li><a href="http://www.pcauto.com.cn/" target="_blank">太平洋汽车网 </a></li>
					<li><a href="http://www.che168.com/" target="_blank">二手车之家</a></li>
					<li><a href="http://www.carxoo.com/" target="_blank">车讯网</a></li>
					<li><a href="http://www.52che.com/" target="_blank">我爱车网</a></li>
					<li><a href="http://www.16888.com/" target="_blank">车主之家</a></li>
					<li><a href="http://www.gocar.cn/" target="_blank">购车网</a></li>
					<li><a href="http://www.xincheping.com/" target="_blank">新车评网</a></li>
					<li><a href="http://www.cad.com.cn/" target="_blank">名车志中文网</a></li>
					<li><a href="http://www.chnsuv.com/" target="_blank">SUV联合越野</a></li>
					<li><a href="http://www.ijia360.com/" target="_blank">爱驾网</a></li>
					<li><a href="http://www.mycar168.com/" target="_blank">汽车大世界</a></li>
					<li><a href="http://www.jxedt.com/" target="_blank">驾校一点通</a></li>
					<li><a href="http://hao.360.cn/" target="_blank">360网址导航</a></li>
					<li><a href="http://www.114la.com/" target="_blank">114la网址</a></li>
					<li><a href="http://hao.rising.cn/" target="_blank">瑞星网址导航</a></li>
					<li><a href="http://www.1616.net/" target="_blank">1616导航</a></li>
					<li><a href="http://www.265.com/" target="_blank">265网址导航</a></li>
					<li><a href="http://www.huochepiao.com/" target="_blank">火车票网 </a></li>
					<li><a href="http://www.chunyun.cn/" target="_blank">春运网</a></li>
					<li><a href="http://www.kuhao360.com/" target="_blank">酷网址导航</a></li>
					<li><a href="http://123.duba.net/" target="_blank">金山网址导航</a></li>
					<li><a href="http://www.auto18.com/" target="_blank">汽车交易网</a></li>
					<li><a href="http://www.cn2che.com/" target="_blank">二手车城</a></li>
					<li><a href="http://car.bitauto.com/" target="_blank">汽车大全</a></li>
					<li><a href="http://www.cnnauto.com" target="_blank">CN汽车网</a></li>
					<li><a href="http://www.ddc.net.cn/" target="_blank">电动汽车</a></li>
					<li><a href="http://www.ieche.com/" target="_blank">爱意汽车</a></li>
					<li><a href="http://www.21rv.com" target="_blank">21世纪房车网</a></li>
					<li><a href="http://www.12365auto.com/" target="_blank">汽车质量网</a></li>
					<li><a href="http://www.jinti.com/" target="_blank">今题网</a></li>
					<li><a href="http://www.chetuan.com/" target="_blank">车团网</a></li>
					<li><a href="http://www.bokee.net/" target="_blank">企业博客网</a></li>
					<li><a href="http://www.200.net/" target="_blank">200网址大全</a></li>
					<li><a href="http://auto.poco.cn/ " target="_blank">poco汽车网</a></li>
					<li><a href="http://auto.jrj.com.cn/ " target="_blank">金融界汽车</a></li>
				</ul>
			</div>
		</div>
		<div class="footer">
			<p>
				<a href="http://www.315che.com/help/0.htm">关于我们</a> |
				<a href="http://www.315che.com/help/1.htm">联系我们</a> |
				<a href="http://www.315che.com/help/2.htm">广告服务</a> |
				<a href="http://www.315che.com/help/3.htm">友情链接</a> |
				<a href="http://www.315che.com/help/4.htm">网站地图</a> |
				<a href="http://www.315che.com/help/5.htm">招聘信息</a> |
				<a href="http://www.315che.com/help/6.htm">法律声明</a> |
				<a href="http://www.315che.com/help/7.htm">车友会</a> |
				<a href="#">加盟我们</a>
			</p>
			<p class="copyright">Copyright © 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号</p>
			<p>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/sh_gongshang.jpg" alt=""></a>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/zx110.jpg" alt=""></a>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/sh_110.jpg" alt=""></a>
				<a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1792781713"><img src="http://www.315che.com/images/itrust_315che.jpg" alt=""></a>
			</p>
		</div>
	</div>
	<script src="http://zt.315che.com/common/js/jquery-1.11.1.min.js"></script>
	<script src="http://zt.315che.com/common/js/jquery.bxslider.min.js"></script>

	<script>
	$(document).ready(function() {
		// 焦点图
		$('#focus-slider').bxSlider({
			mode: 'horizontal',
			controls: false,
			captions: true,
			auto: true
		});
		$('#g-slider-01, #g-slider-02').bxSlider({
			mode: 'horizontal',
			controls: false,
			captions: true
		});
	});
	</script>
</body>
</html>