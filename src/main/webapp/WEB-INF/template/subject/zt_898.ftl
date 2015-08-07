<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>广州第12届国际汽车展览会专题</title>
	<meta name="keywords" content="${keywords!}">
	<meta name="description" content="${descstr!}">
	<link rel="stylesheet" href="http://zt.315che.com/cz/141031/css/main.css">
	<link rel="stylesheet" href="http://zt.315che.com/common/css/315che-base.css">
	<link rel="stylesheet" type="text/css" href="http://zt.315che.com/cz/141031/css/style.css">

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

<div class="wrapouter">
	<div class="wrap">
		<div class="nav">
			<ul>
				<li><a href="#carFocus">聚焦车展</a><i class="line"></i></li>
				<li><a href="#newCarList">新车解析</a><i class="line"></i></li>
				<li><a href="#chinaCarList">自主品牌</a><i class="line"></i></li>
				<li><a href="#heziCarList">合资品牌</a><i class="line"></i></li>
				<li><a href="#jinkouCarList">进口车型</a><i class="line"></i></li>
				<li><a href="#gailianCarList">概念车型</a><i class="line"></i></li>
				<li><a href="#mmCarGrils">美女车模</a><i class="line"></i></li>
				<li><a href="#guangzhouCarter">广州车市</a></li>
			</ul>
		</div>
		<div id="carFocus" class="focus-news-box">
			<div class="focus-left">
				<div class="focus-slider">
					<ul class="bxslider1">
						<#if dataMap.get("焦点图w536_h276")??>
							<#list dataMap.get("焦点图w536_h276") as data>
								<#if data_index lt 4>
									<li><a href="${data.link!}" target="_blank"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" title="${data.title!}"></a></li>
								</#if>
							</#list>
						</#if>				
					</ul>
				</div>
			</div>
			<div class="focus-right">
			<#if dataMap.get("焦点新闻大新闻")??>
				<#list dataMap.get("焦点新闻大新闻") as data1>
					<#if data1_index lt 5>
						<div class="hot-news-title">
							<h1><a href="${data1.link!}" target="_blank">${data1.title!}</a></h1>
							<p>
							<#if dataMap.get("焦点新闻小新闻")??>
								<#list dataMap.get("焦点新闻小新闻") as data2>
									<#if data2_index lt (data1_index+1)*3>
										<#if data2_index gt data1_index*3>
											<a href="${data2.link!}" target="_blank">${data2.title!}</a>&nbsp;&nbsp;|&nbsp;&nbsp;
										</#if>
									</#if>
								</#list>
							</#if>
							</p>
						</div>
					</#if>
				</#list>
			</#if>	
			</div>
		</div>
		<div class="row clearfix">
			<div class="left-live clearfix">
				<div class="column1">
					<h1 class="column-text">车展直击</h1>
				</div>
				<div class="live-list-wrap">
					<div class="jr-wrap clearfix">
					<#if dataMap.get("车展直击图片w237_h135")??>
						<#list dataMap.get("车展直击图片w237_h135") as data1>
							<#if data1_index lt 2>
							<div class="live-list">
								<div class="live-hot">
									<a href="${data1.link!}" target="_blank">
										<img src="<#if data1.pic.substring(0,7)=="http://">${data1.pic!}<#else>${img_che_url}${data1.pic!}</#if>" alt="${data1.title!}">
										<p>${data1.title!}</p>
									</a>
								</div>
								<ul>
								<#if dataMap.get("车展直击新闻")??>
									<#list dataMap.get("车展直击新闻") as data2>
										<#if data2_index lt (data1_index+1)*3+1>
										<#if data2_index gt data1_index*3>
											<li><a href="${data2.link!}" target="_blank">${data2.title!}</a></li>
										</#if>
										</#if>
									</#list>
								</#if>
								</ul>
							</div>
							</#if>
						</#list>
					</#if>
					</div>
				</div>
			</div>
			<div class="right-newcar clearfix">
				<div class="column1">
					<h1 class="column-text">新车上市</h1>
				</div>
				<ul class="newcar-list">
					<#if dataMap.get("新车上市")??>
						<#list dataMap.get("新车上市") as data>
							<#if data_index lt 10>
								<li><a href="${data.link!}" target="_blank"><span>[上市]</span>${data.title!}</a></li>
							</#if>
						</#list>
					</#if>
				</ul>
			</div>
		</div>
		<div id="newCarList" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column3.jpg" alt=""></div>
			<div class="newcar-jx-wrap">
				<ul class="bxslider2">
					<li>
						<ul>
							<#if dataMap.get("新车解析w225_h170")??>
								<#list dataMap.get("新车解析w225_h170") as data>
									<#if data_index lt 9>
										<li>
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<p>${data.title!}</p>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					<li>
						<ul>
							<#if dataMap.get("新车解析w225_h170")??>
								<#list dataMap.get("新车解析w225_h170") as data>
									<#if data_index gt 9>
										<#if data_index lt 18>
											<li>
												<a href="${data.link!}" target="_blank">
													<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
													<p>${data.title!}</p>
												</a>
											</li>
										</#if>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					<li>
						<ul>
							<#if dataMap.get("新车解析w225_h170")??>
								<#list dataMap.get("新车解析w225_h170") as data>
									<#if data_index gt 18>
										<#if data_index lt 27>
											<li>
												<a href="${data.link!}" target="_blank">
													<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
													<p>${data.title!}</p>
												</a>
											</li>
										</#if>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div id="chinaCarList" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column4.jpg" alt=""></div>
			<div class="pics-slider-wrap">
				<ul class="bxslider3">
					<#if dataMap.get("自主新车大图w400_h288")??>
						<#list dataMap.get("自主新车大图w400_h288") as data1>
							<#if data1_index lt 3>
							<li>
								<ul class="clearfix">
									<li class="big-pic">
										<a href="${data1.link!}" target="_blank">
											<img src="<#if data1.pic.substring(0,7)=="http://">${data1.pic!}<#else>${img_che_url}${data1.pic!}</#if>" alt="${data1.title!}">
											<span class="pic-title">${data1.title!}</span>
											<span class="pic-title-bg"></span>
										</a>
									</li>	
								<#if dataMap.get("自主新车小图w180_h140")??>
									<#list dataMap.get("自主新车小图w180_h140") as data2>
										<#if data2_index lt (data1_index+1)*6+1>
											<#if data2_index gt data1_index*6>
												<li class="small-pic">
													<a href="${data2.link!}" target="_blank">
														<img src="<#if data2.pic.substring(0,7)=="http://">${data2.pic!}<#else>${img_che_url}${data2.pic!}</#if>" alt="${data2.title!}">
														<span class="pic-title">${data2.title!}</span>
														<span class="pic-title-bg"></span>
													</a>
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
		<div id="heziCarList" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column5.jpg" alt=""></div>
			<div class="pics-slider-wrap">
				<ul class="bxslider3">
					<#if dataMap.get("合资新车大图w400_h288")??>
						<#list dataMap.get("合资新车大图w400_h288") as data1>
							<#if data1_index lt 3>
							<li>
								<ul class="clearfix">
									<li class="big-pic">
										<a href="${data1.link!}" target="_blank">
											<img src="<#if data1.pic.substring(0,7)=="http://">${data1.pic!}<#else>${img_che_url}${data1.pic!}</#if>" alt="${data1.title!}">
											<span class="pic-title">${data1.title!}</span>
											<span class="pic-title-bg"></span>
										</a>
									</li>	
								<#if dataMap.get("合资新车小图w180_h140")??>
									<#list dataMap.get("合资新车小图w180_h140") as data2>
										<#if data2_index lt (data1_index+1)*6+1>
											<#if data2_index gt data1_index*6>
												<li class="small-pic">
													<a href="${data2.link!}" target="_blank">
														<img src="<#if data2.pic.substring(0,7)=="http://">${data2.pic!}<#else>${img_che_url}${data2.pic!}</#if>" alt="${data2.title!}">
														<span class="pic-title">${data2.title!}</span>
														<span class="pic-title-bg"></span>
													</a>
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
		<div id="jinkouCarList" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column6.jpg" alt=""></div>
			<div class="pics-slider-wrap">
				<ul class="bxslider3">
					<#if dataMap.get("进口新车大图w400_h288")??>
						<#list dataMap.get("进口新车大图w400_h288") as data1>
							<#if data1_index lt 3>
							<li>
								<ul class="clearfix">
									<li class="big-pic">
										<a href="${data1.link!}" target="_blank">
											<img src="<#if data1.pic.substring(0,7)=="http://">${data1.pic!}<#else>${img_che_url}${data1.pic!}</#if>" alt="${data1.title!}">
											<span class="pic-title">${data1.title!}</span>
											<span class="pic-title-bg"></span>
										</a>
									</li>	
								<#if dataMap.get("进口新车小图w180_h140")??>
									<#list dataMap.get("进口新车小图w180_h140") as data2>
										<#if data2_index lt (data1_index+1)*6+1>
											<#if data2_index gt data1_index*6>
												<li class="small-pic">
													<a href="${data2.link!}" target="_blank">
														<img src="<#if data2.pic.substring(0,7)=="http://">${data2.pic!}<#else>${img_che_url}${data2.pic!}</#if>" alt="${data2.title!}">
														<span class="pic-title">${data2.title!}</span>
														<span class="pic-title-bg"></span>
													</a>
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
		<div id="gailianCarList" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column7.jpg" alt=""></div>
			<div class="pics-slider-wrap">
				<ul class="bxslider3">	
					
					<#if dataMap.get("概念新车大图w400_h288")??>
						<#list dataMap.get("概念新车大图w400_h288") as data1>
							<#if data1_index lt 3>
							<li>
								<ul class="clearfix">
									<li class="big-pic">
										<a href="${data1.link!}" target="_blank">
											<img src="<#if data1.pic.substring(0,7)=="http://">${data1.pic!}<#else>${img_che_url}${data1.pic!}</#if>" alt="${data1.title!}">
											<span class="pic-title">${data1.title!}</span>
											<span class="pic-title-bg"></span>
										</a>
									</li>	
								<#if dataMap.get("概念新车小图w180_h140")??>
									<#list dataMap.get("概念新车小图w180_h140") as data2>
										<#if data2_index lt (data1_index+1)*6+1>
											<#if data2_index gt data1_index*6>
												<li class="small-pic">
													<a href="${data2.link!}" target="_blank">
														<img src="<#if data2.pic.substring(0,7)=="http://">${data2.pic!}<#else>${img_che_url}${data2.pic!}</#if>" alt="${data2.title!}">
														<span class="pic-title">${data2.title!}</span>
														<span class="pic-title-bg"></span>
													</a>
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
		<div id="mmCarGrils" class="row clearfix">
			<div class="column2"><img src="http://zt.315che.com/cz/141031/images/column8.jpg" alt=""></div>
			<div class="mm-pics-slider-wrap">
				<ul class="bxslider3">
					<li>
						<ul class="clearfix">
							
							<#if dataMap.get("美女车模最大图w338_h462")??>
								<#list dataMap.get("美女车模最大图w338_h462") as data>
									<#if data_index lt 1>
										<li class="mm-big-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模小图w202_h200")??>
								<#list dataMap.get("美女车模小图w202_h200") as data>
									<#if data_index lt 3>
										<li class="mm-small-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						
							<#if dataMap.get("美女车模大图w366_h256")??>
								<#list dataMap.get("美女车模大图w366_h256") as data>
									<#if data_index lt 1>
										<li class="mm-big2-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模中图w242_h256")??>
								<#list dataMap.get("美女车模中图w242_h256") as data>
									<#if data_index lt 1>
										<li class="mm-big3-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					
					<li>
						<ul class="clearfix">
						
							<#if dataMap.get("美女车模最大图w338_h462")??>
								<#list dataMap.get("美女车模最大图w338_h462") as data>
									<#if data_index lt 2>
									<#if data_index gt 0>
										<li class="mm-big-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模小图w202_h200")??>
								<#list dataMap.get("美女车模小图w202_h200") as data>
									<#if data_index lt 6>
									<#if data_index gt 2>
										<li class="mm-small-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
						
							<#if dataMap.get("美女车模大图w366_h256")??>
								<#list dataMap.get("美女车模大图w366_h256") as data>
									<#if data_index lt 2>
									<#if data_index gt 0>
										<li class="mm-big2-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模中图w242_h256")??>
								<#list dataMap.get("美女车模中图w242_h256") as data>
									<#if data_index lt 2>
									<#if data_index gt 0>
										<li class="mm-big3-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
							
						</ul>
					</li>
					
					<li>
						<ul class="clearfix">
							<#if dataMap.get("美女车模最大图w338_h462")??>
								<#list dataMap.get("美女车模最大图w338_h462") as data>
									<#if data_index lt 3>
									<#if data_index gt 1>
										<li class="mm-big-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模小图w202_h200")??>
								<#list dataMap.get("美女车模小图w202_h200") as data>
									<#if data_index lt 9>
									<#if data_index gt 5>
										<li class="mm-small-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
						
							<#if dataMap.get("美女车模大图w366_h256")??>
								<#list dataMap.get("美女车模大图w366_h256") as data>
									<#if data_index lt 3>
									<#if data_index gt 1>
										<li class="mm-big2-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
							
							<#if dataMap.get("美女车模中图w242_h256")??>
								<#list dataMap.get("美女车模中图w242_h256") as data>
									<#if data_index lt 3>
									<#if data_index gt 1>
										<li class="mm-big3-pic">
											<a href="${data.link!}" target="_blank">
												<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
												<span class="pic-title">${data.title!}</span>
												<span class="pic-title-bg"></span>
											</a>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					
				</ul>
			</div>
		</div>
		<div id="guangzhouCarter" class="row clearfix">
			<div class="column1">
				<h1 class="column-text">广州车市</h1>
			</div>
			<div class="auto-4s-shopping">
				<ul class="car4s-slider">
					<li>
						<ul>
							
							<#if dataMap.get("广州车市LOGOw225_h170")??>
								<#list dataMap.get("广州车市LOGOw225_h170") as data>
									<#if data_index lt 7>
										<li>
											<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
											<p><b>[4s店]</b>${data.title!}</p>
											<p>${data.content!}</p>
										</li>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
					
					<li>
						<ul>
							<#if dataMap.get("广州车市LOGOw225_h170")??>
								<#list dataMap.get("广州车市LOGOw225_h170") as data>
									<#if data_index lt 14>
									<#if data_index gt 6>
										<li>
											<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
											<p><b>[4s店]</b>${data.title!}</p>
											<p>${data.content!}</p>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>

						</ul>
					</li>
					
					<li>
						<ul>
							<#if dataMap.get("广州车市LOGOw225_h170")??>
								<#list dataMap.get("广州车市LOGOw225_h170") as data>
									<#if data_index lt 21>
									<#if data_index gt 13>
										<li>
											<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}">
											<p><b>[4s店]</b>${data.title!}</p>
											<p>${data.content!}</p>
										</li>
									</#if>
									</#if>
								</#list>
							</#if>
						</ul>
					</li>
	
				</ul>
			</div>
			<div class="gzcs-news-wrap">
				<ul>
					
					<#if dataMap.get("广州车市下部新闻")??>
						<#list dataMap.get("广州车市下部新闻") as data>
							<#if data_index lt 12>
								<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
							</#if>
						</#list>
					</#if>	
					</nc>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="carnews-wrap">
				<div class="column1">
					<h1 class="column-text">最新车讯</h1>
				</div>
				<ul class="carnews-list">
					<#if dataMap.get("最新车讯")??>
						<#list dataMap.get("最新车讯") as data>
							<#if data_index lt 12>
								<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
							</#if>
						</#list>
					</#if>	
				</ul>
			</div>
			<div class="carnews-wrap">
				<div class="column1">
					<h1 class="column-text">广州资讯</h1>
				</div>
				<ul class="carnews-list">
					<#if dataMap.get("广州资讯")??>
						<#list dataMap.get("广州资讯") as data>
							<#if data_index lt 12>
								<li><a href="${data.link!}" target="_blank">${data.title!}</a></li>
							</#if>
						</#list>
					</#if>	
				</ul>
			</div>
			<div class="old-zt-wrap">
				<div class="column1">
					<h1 class="column-text">往期专题</h1>
				</div>
				<ul class="old-zt-list">
					<#if dataMap.get("往期专题w196_h64")??>
						<#list dataMap.get("往期专题w196_h64") as data>
							<#if data_index lt 4>
								<li><a href="${data.link!}" target="_blank"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}"></a></li>
							</#if>
						</#list>
					</#if>	
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="column1">
				<h1 class="column-text">合作伙伴</h1>
			</div>
			<div id="conBrand" class="partners-list-wrap clearfix">
				<ul class="partners-list">
					<#if dataMap.get("合作伙伴w196_h65")??>
						<#list dataMap.get("合作伙伴w196_h65") as data>
							<#if data_index lt 8>
								<li><a href="${data.link!}" target="_blank"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url}${data.pic!}</#if>" alt="${data.title!}"></a></li>
							</#if>
						</#list>
					</#if>	
				</ul>
			</div>
		</div>
	</div>
</div>

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
            <a href="mailto:admin@315che.com">中国汽车消费网</a>备案号:
            <a target="_blank" href="http://www.miibeian.gov.cn">沪ICP 备 05053107 号</a>
        </p>
    </div>

	<script src="http://zt.315che.com/common/js/jquery-1.11.1.min.js"></script>
    <script src="http://www.315che.com/js/jquery.bxslider.min.js"></script>
	<script type="text/javascript">
	$(function(){
		//focus news
		$('.bxslider1').bxSlider({
		  mode: 'horizontal',
		  auto: true,
		  captions: true,
		  controls: false
		});
		$(".focus-slider").find(".bx-viewport").css({'height':'312px'});
		
		//focus news
		$('.bxslider2').bxSlider({
		  mode: 'horizontal',
		  auto: false,
		  controls: false
		});
		
		//focus news
		$('.bxslider3').bxSlider({
		  mode: 'horizontal',
		  auto: false,
		  controls: false
		});
		
		//focus news
		$('.car4s-slider').bxSlider({
		  mode: 'horizontal',
		  auto: true,
		  controls: false
		});

		//sliding anchor links
		$(".nav li a").click(function(){
			var thisHref = $(this).attr("href");
			var animateHeight = $(thisHref).offset().top;
			$("html,body").stop().animate({scrollTop:animateHeight},1000);
		});
	});
	</script>
	
	<div style="display:none;"><script src="http://w.cnzz.com/c.php?id=30010794" language="JavaScript" charset="gb2312"></script></div>
	<div style="display:none;"><script language="javascript" src="http://182.254.135.44:7717/js/pv.js?appid=1" > </script></div>

</body>
</html>