<#macro html_top nav=1 ny="n" title="中国汽车消费网 - 中国汽车消费门户" description="" keywords="" searchtitle="" flag=0 mobileMeta="">
<!DOCTYPE html>
<html lang="zh-hans">
<head>
	<meta charset="UTF-8">
	<title>${title?replace("&nbsp"," ")}</title>
	<meta name="keywords" content="${keywords?replace("&nbsp"," ")}">
	<meta name="description" content="${description?replace("&nbsp"," ")}">
	<meta name="searchtitle" content="${searchtitle?replace("&nbsp"," ")}" />
	<meta name="renderer" content="webkit">
	${mobileMeta}
	<link rel="stylesheet" href="${che_url}css/styles.css">
	<link rel="stylesheet" href="${che_url}css/cars-more-one.css">
	<link rel="stylesheet" href="${che_url}css/jcalendar.css">
	<link rel="stylesheet" href="${che_url}css/photos-depot.css">
</head>
<body>
	<div class="topbar">
		<!--minitop导航开始-->
		<div class="minitop">
			<div class="mini-main">
				<div class="top-link">
					<a href="javascript:void(0);" id="AddFavorite">收藏</a>
					<a href="${che_url}original/">原创</a>
					<a href="${che_url}jiucuo.htm">纠错</a>
				</div>
				<ul class="top-login">
					<li><a href="javascript:void(0);" class="login-btn">登录</a></li>
					<li><a target="_blank" href="http://bbs.315che.com/forums/register.aspx">注册</a></li>
				</ul>
			</div>
		</div>
		<!--minitop导航结束-->
		<!--头部开始-->
		<div class="header">
			<div class="header-main">
				<div class="clearfix">
					<div class="logo"><a href="${che_url}"><img src="${che_url}images/logo.png" title="中国汽车消费网" alt="中国汽车消费网"></a></div>
					<div class="nav">
						<div class="nav-link">
							<ul>
								<li><a href="${inf_che_url}">资 讯</a></li>
								<li><a href="${che_url}pingce/">评 测</a></li>
								<li><a href="${price_che_url}">报 价</a></li>
								<li><a href="${pic_che_url}">图 库</a></li>
								<li><a href="${dea_che_url}">经销商</a></li>
								<li><a href="${sun_che_url}">团 购</a></li>
								<li><a href="${tousu_che_url}">汽车投诉</a></li>
								<li><a href="${bbs_che_url}" target="_blank">论 坛</a></li>
							</ul>
						</div>
						<div class="nav-city">
							<span class="current-city">当前城市：</span>
							<div class="change-city">
								<span></span><i></i>
								<div class="show-city" id="top-show-city">
									<dl>
										<dt>热门城市：</dt>
										<dd>
										<#list cityitems.hotArray as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
											
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[0]}：</dt>
										<dd>
										<#list cityitems.cityarray1 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
											
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[1]}：</dt>
										<dd>
										<#list cityitems.cityarray2 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[2]}：</dt>
										<dd>
										<#list cityitems.cityarray3 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[3]}：</dt>
										<dd>
										<#list cityitems.cityarray4 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[4]}：</dt>
										<dd>
										<#list cityitems.cityarray5 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[5]}：</dt>
										<dd>
										<#list cityitems.cityarray6 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									<dl>
										<dt>${cityitems.proArray[6]}：</dt>
										<dd>
										<#list cityitems.cityarray7 as cl>
											<#list sublist as ls>
											<#if ls.byname = cl>
												<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
												<#break>
											</#if>
											</#list>
										</#list>
										</dd>
									</dl>
									
								</div>
							</div>
							<ul class="hotcitys">
								<li>热门城市：</li>
								<#list hotlist as hl>
									<li><a href="${che_url}${hl.englingname}/">${hl.byname}</a></li>
								</#list>
								<li><a href="${che_url}arealist.htm">更多 &rsaquo;&rsaquo;</a></li>
							</ul>
						</div>
					</div>
				</div>
				<i class="logo-shadow1"></i>
				<i class="logo-shadow2"></i>
			</div>
			<div class="header-blue"></div>
		</div>
		<!--头部结束-->
		<div class="nav-car ma-b10">
			<ul class="clearfix">
				<li class="nav-car01"><a href="${che_url}a00/">微型车</a></li>
				<li class="nav-car02"><a href="${che_url}a0/">小型车</a></li>
				<li class="nav-car03"><a href="${che_url}a/">紧凑型车</a></li>
				<li class="nav-car04"><a href="${che_url}b/">中型车</a></li>
				<li class="nav-car05"><a href="${che_url}c/">中大型车</a></li>
				<li class="nav-car06"><a href="${che_url}d/">豪华车</a></li>
				<li class="nav-car07"><a href="${che_url}mpv/">MPV</a></li>
				<li class="nav-car08"><a href="${che_url}suv/">SUV</a></li>
				<li class="nav-car09"><a href="${che_url}s/">跑车</a></li>
				<li class="nav-car10"><a href="${che_url}dc/">电动车</a></li>
			</ul>
		</div>
	</div>
	<!--主内容开始-->
	<div class="content">
	<#nested>
	<!--阴影遮罩层-->
	<div class="overlay"></div>
	<!--登录框-->
	<div class="popup-box login-box">
		<div class="top">
			<b class="close"></b>
		</div>
		<div class="main">
			<dl>
				<dt>使用账号登录</dt>
				<dd>
					<form id="cheLogin">
						<ul class="form-register">
							<li>
								<div class="input-box">
									<i class="user-icon"></i><input name="UN" type="text">
								</div>
							</li>
							<li>
								<div class="input-box">
									<i class="password-icon"></i><input name="PW" type="password">
								</div>
							</li>
							<!--<li class="remember">
								<label><input type="checkbox" value="true">
								记住我?</label>
								<a target="_blank" href="http://bbs.315che.com/forums/getpassword.aspx" class="forget-password">忘记密码?</a>
							</li>-->
							<li class="button">
								<input type="button" class="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
							</li>
						</ul>
					</form>
				</dd>
			</dl>
			<dl>
				<dt>使用第三方账号登录</dt>
				<dd>
					<ul class="other-account">
						<li class="weibo-icon"><a href="https://api.weibo.com/oauth2/authorize?client_id=2019549328&redirect_uri=http%3A%2F%2Fbbs.315che.com%2Fforums%2Fweibocomplete2.htm&response_type=code&display=default">微博账号登录</a></li>
						<li class="qq-icon"><a href="${che_url}/che/qqLogin">QQ账号登录</a></li>
						<!--<li class="wx-icon"><a href="#">微信账号登录</a></li>--->
					</ul>
				</dd>
			</dl>
		</div>
	</div>
	</div>
	<div class="tool-right">
	<#if flag==1><a href="javascript:void(0);" id="carParamPkHref"><i class="icon icon1"></i><i class="icon num" id="carParamPk">1</i>对比</a></#if>
	<a href="#"><i class="icon icon2"></i>微信<div class="wx-qrcode"><img src="${che_url}images/wx_qrcode.jpg" alt=""></div></a>
	<a href="http://www.315che.com/jiucuo.htm"><i class="icon icon3"></i>反馈</a>
	<a href="#"><i class="top-triangle"></i>TOP</a>
	</div>
</#macro>
<#macro html_footer>
<div class="footer">
	<p>
		<a href="${che_url}help/0.htm">关于我们</a> |
		<a href="${che_url}help/1.htm">联系我们</a> |
		<a href="${che_url}help/2.htm">广告服务</a> |
		<a href="${che_url}help/3.htm">友情链接</a> |
		<a href="${che_url}help/4.htm">网站地图</a> |
		<a href="${che_url}help/5.htm">招聘信息</a> |
		<a href="${che_url}help/6.htm">法律声明</a> |
		<a href="${che_url}help/7.htm">车友会</a> |
		<a href="#">加盟我们</a>
	</p>
	<p class="copyright">Copyright © 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号</p>
	<p>
		<a href="javascript:void(0);"><img src="${che_url}images/sh_gongshang.jpg" alt=""></a>
		<a href="javascript:void(0);"><img src="${che_url}images/zx110.jpg" alt=""></a>
		<a href="javascript:void(0);"><img src="${che_url}images/sh_110.jpg" alt=""></a>
		<a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1792781713"><img src="${che_url}images/itrust_315che.jpg" alt=""></a>
	</p>
</div>
	
</#macro>

<#macro chexiNav nav=1 serialid=0 englishname="shanghai" flagBoolean=true>
<div class="car-publicbar">
	<ul>
		<li <#if nav==1>class="current"</#if>><a href="${auto_che_url}${englishname}/">综述</a></li>
		<li <#if nav==2>class="current"</#if>><a href="${price_che_url}series/${serialid}-0-0.htm">报价</a></li>
		<li <#if nav==3>class="current"</#if>><a href="${pic_che_url}serial/${serialid}.htm">图片</a></li>
		<#if !flagBoolean>
			<li <#if nav==4>class="current"</#if> class="nolink"><a href="javascript:void(0);">参数配置</a></li>
		<#else>
			<li <#if nav==4>class="current"</#if>><a href="${auto_che_url}${englishname}/detail.htm">参数配置</a></li> 
		</#if>
		<li <#if nav==5>class="current"</#if>><a href="${dea_che_url}${serialid}/0_1_1.htm">经销商</a></li>
		<li <#if nav==6>class="current"</#if>><a href="${koubei_che_url}kblist/${serialid}.htm">口碑</a></li>
		<li <#if nav==7>class="current"</#if>><a href="${auto_che_url}${englishname}/articles.htm">文章</a></li>
		<li <#if nav==8>class="current"</#if>><a href="${sun_che_url}${englishname}/">团购</a></li>
	</ul>
</div>
</#macro>
<#macro chexiNav2 nav=1 serialid=0 englishname="shanghai">
<div class="car-publicbar">
	<ul>
		<li <#if nav==1>class="current"</#if>><a href="${auto_che_url}${englishname}/">综述</a></li>
		<li <#if nav==2>class="current"</#if>><a href="${price_che_url}series/${serialid}-0-0.htm">报价</a></li>
		<li <#if nav==3>class="current"</#if>><a href="${pic_che_url}serial/${serialid}.htm">图片</a></li>
		<li <#if nav==4>class="current"</#if>><a href="${dea_che_url}${serialid}/0_1_1.htm">经销商</a></li>
		<li <#if nav==5>class="current"</#if>><a href="${sun_che_url}${englishname}/">团购</a></li>
	</ul>
</div>
</#macro>
<!-- 看过的人还看过共通   serialname:车系名称   seeSeriesLists:数据list-->
<#macro seeSeries serialname seeSeriesLists="shanghai">
<#if seeSeriesLists?size  gt 0>
	<#assign str = "看过"+serialname+"还关注"/>
	<div class="title-box">
		<h2>
		<#if str?replace("&nbsp"," ")?length gt 11>${str?replace("&nbsp"," ")[0..11]}<#else>${str?replace("&nbsp"," ")}</#if>
		</h2>
	</div>
	<div class="side-pic-list">
		<ul>
			<#list seeSeriesLists as ser>
				<li>
					<a href="${auto_che_url}${ser.englishname!}/">
						<div class="pic"><img src="${imageFormat(ser.photo!,113,78)}" alt=""></div>
						<div class="car-name">${ser.catalogname!}</div>
						<div class="car-price"><a href="${price_che_url}series/${ser.catalogid!}-0-0.htm" target=_blank>${ser.p2!}万</a></div>
					</a>
				</li>
			</#list>
		</ul>
	</div>
</#if>
</#macro>

<!-- 团购共通   tgList:团购列表  type 1:中部位置  2 : 右侧位置 -->
<#macro groupbuy tgList  type>
<#if type==1>
	<span><a href="${sun_che_url}${tgList.get(0).englishname}/" class="ad-360x50 ad-c-teal" target=_blank>${tgList.get(0).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(1).englishname}/" class="ad-172x50 ad-c-blue" target=_blank>${tgList.get(1).catalogname}团购</a></span>
	<span class="sp-r"><a href="${sun_che_url}${tgList.get(2).englishname}/" class="ad-180x50 ad-c-purple" target=_blank>${tgList.get(2).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(3).englishname}/" class="ad-180x50 ad-c-blue" target=_blank>${tgList.get(3).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(4).englishname}/" class="ad-172x50 ad-c-purple" target=_blank>${tgList.get(4).catalogname}团购</a></span>
	<span class="sp-r"><a href="${sun_che_url}${tgList.get(5).englishname}/" class="ad-360x50 ad-c-teal" target=_blank>${tgList.get(5).catalogname}团购</a></span>
<#else>
	<span><a href="${sun_che_url}${tgList.get(0).englishname}/" class="ad-160x50 ad-c-teal" target=_blank>${tgList.get(0).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(1).englishname}/" class="ad-80x50 ad-c-blue" target=_blank>${tgList.get(1).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(2).englishname}/" class="ad-120x50 ad-c-blue" target=_blank>${tgList.get(2).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(3).englishname}/" class="ad-120x50 ad-c-purple" target=_blank>${tgList.get(3).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(4).englishname}/" class="ad-80x50 ad-c-purple" target=_blank>${tgList.get(4).catalogname}团购</a></span>
	<span><a href="${sun_che_url}${tgList.get(5).englishname}/" class="ad-160x50 ad-c-teal" target=_blank>${tgList.get(5).catalogname}团购</a></span>
</#if>
</#macro>

<!-- 对比评测共通   pkList:PK列表  serialname:车系名称   -->
<#macro serialPK pkList  serialname>

<div class="side-pk ma-b20">
<#if pkList?size gt 0>
	<div class="title-box">
		<h2>${serialname}对比测评</h2>
	</div>
	<div class="side-pk-list">
		<div class="side-pk-vs clearfix">
			<a target="_blank" href="${pk_che_url}${pkList.get(0).map1.englishname!}/${pkList.get(0).map2.englishname!}.htm">
				<div class="car-thumb-l">
					<img width="100" height="80" class="lazy"  data-original="${imageFormat(pkList.get(0).map1.photo!,100,80)}">
					<span>${pkList.get(0).map1.catalogname!}</span>
				</div>
				<div class="car-thumb-r">
					<img width="100" height="80" class="lazy"  data-original="${imageFormat(pkList.get(0).map2.photo!,100,80)}">
					<span>${pkList.get(0).map2.catalogname!}</span>
				</div>
				<div class="pk-img"><img src="${che_url}/images/side_pk_img.png" alt=""></div>
			</a>
		</div>
		<ul>
			<#list pkList as pk>
				<#if pk_index gt 0>
					<li><a href="${pk_che_url}${pk.map1.englishname!}/${pk.map2.englishname!}.htm" target=_blank>
					${(pk.map1.catalogname)!}   PK   ${(pk.map2.catalogname)!} 
					</a></li>
				</#if>
			</#list>
			
		</ul>
	</div>
</#if>
</div>

</#macro>


<!-- XXX其他车系共通   otherSerials:其他车系列表  iway : 车系渠道 -->
<#macro otherSerials otherSerials  iway>
<div class="title-box">
	<h2>${iway}其他车系</h2>
</div>
<ul class="text-list">
<#list otherSerials as other>
	<li>
		<a href="${auto_che_url}${other.englishname}/" target=_blank title="${other.catalogname}">${other.catalogname}</a>
		<a href="${price_che_url}series/${other.catalogid!}-0-0.htm" target=_blank title="${other.catalogname}"><span class="price">${other.priceStr!}</span></a>
	</li>
</#list>	
</ul>
</#macro>
<!-- 友情链接   linkList:友情链接列表 -->
<#macro links linkList>
		<div class="row ma-t10 celarfix">
			<div class="mylink">
				<div class="title">
					<h3>友情链接</h3>
					<a href="${che_url}help/3.htm" class="apply-btn" target=_blank>点击申请 &rsaquo;&rsaquo;</a>
				</div>
				<div class="links-con">
					<ul class="links">
					<#list linkList as link>
						<li><a href="${link.link}" target=_blank><#if link.title?length gt 6 >${link.title[0..6]}<#else>${link.title}</#if></a></li>
					</#list>
					</ul>
				</div>
			</div>
		</div>
</#macro>

<#macro recommNews seeSeriesLists="">
	<#if recommNewsList??>
		<#list recommNewsList as news>
		<li <#if news_index==0>class="nth-child-first"<#elseif news_index==(recommNewsList?size-1)>class="nth-child-last"<#else></#if>>
		<a href="${news.link}"  target="_blank">
			<img src="<#if news.pic??>${imageFormat(news.pic,90,68)}</#if>">
			<div class="title"><#if news.title?length gt 15>${news.title[0..14]}...<#else>${news.title}</#if></div>
			<span class="time">${news.adddate?string("yyyy-MM-dd")}</span>
		</a>
		</li>
		</#list>
	</#if>
</#macro>

<#macro dealerNewss dealerActNewsList>
<#if dealerActNewsList??>
<#list dealerActNewsList as news>
<li <#if news_index==0>class="nth-child-first"<#elseif news_index==(dealerActNewsList?size-1)>class="nth-child-last"<#else></#if>>
	<a href="${dea_che_url}${news.eid}/newsdetail-${news.newsid}.htm" target="_blank">
		<img src="<#if news.photo??&&news.photo!="NULL">${news.photo}<#else>${che_url}/images/complaint_demo.jpg</#if>">
		<div class="title">${news.title}</div>
		<span class="time">${news.adddate[0..10]}</span>
	</a>
</li>
</#list>
</#if>

</#macro>

<#macro aboutus id>
	<div class="company-news-nav clearfix">
		<ul>
			<li <#if id==1>class="current"</#if>>
				<a href="${che_url}help/0.htm"><i class="r-triangle"></i>关于我们</a>
			</li>
			<li <#if id==2>class="current"</#if>>
				<a href="${che_url}help/1.htm"><i class="r-triangle"></i>联系我们</a>
			</li>
			<li <#if id==3>class="current"</#if>>
				<a href="${che_url}help/2.htm"><i class="r-triangle"></i>广告服务</a>
			</li>
			<li <#if id==4>class="current"</#if>>
				<a href="${che_url}help/3.htm"><i class="r-triangle"></i>友情链接</a>
			</li>
			<li <#if id==5>class="current"</#if>>
				<a href="${che_url}help/4.htm"><i class="r-triangle"></i>网站地图</a>
			</li>
			<li <#if id==6>class="current"</#if>>
				<a href="${che_url}help/5.htm"><i class="r-triangle"></i>招聘信息</a>
			</li>
			<li <#if id==7>class="current"</#if>>
				<a href="${che_url}help/6.htm"><i class="r-triangle"></i>法律声明</a>
			</li>
			<li <#if id==8>class="current"</#if>>
				<a href="${che_url}help/7.htm"><i class="r-triangle"></i>车友会</a>
			</li>
			<li <#if id==9>class="current"</#if>>
				<a href="${che_url}jiucuo.htm"><i class="r-triangle"></i>问题反馈</a>
			</li>
		</ul>
	</div>
</#macro>

<#macro html_mquery>
	<div class="car-select">
		<div class="select" style="z-index:30;">
			<div class="select-selected" id="brand_selected"><span>选择品牌</span><i class="icon-arrows"></i></div>
			<div class="select-option">
				<dl id="brand">
					
				</dl>
			</div>
		</div>
		<div class="select" style="z-index:20;">
			<div class="select-selected" id="series_selected"><span>选择车系</span><i class="icon-arrows"></i></div>
			<div class="select-option">
				<dl id="series">
				</dl>
			</div>
		</div>
		<div class="select"  style="z-index:10;">
			<div class="select-selected" id="model_selected"><span>选择车型</span><i class="icon-arrows"></i></div>
			<div class="select-option">
				<dl id="model">
				</dl>
			</div>
		</div>
	</div>
	<div class="car-select-btn">
		<a href="javascript:void(0);" id="queryModel" class="current">查车型</a><a id="querysj" href="javascript:void(0);">查商家</a><a id="querybj" href="javascript:void(0);">查报价</a>
	</div>
</#macro>

<#macro html_bottom hasad=1>
<!--主内容结束-->
	<script src="${che_url}js/jquery-1.11.2.min.js"></script>
	<script src="${che_url}js/jquery.bxslider.min.js"></script>
	<script src="${che_url}js/global.js"></script>
	<script src="${che_url}js/jcalendar.min.js"></script>
	<script src="${che_url}js/jquery.lazyload.min.js"></script>
	<script src='${che_url}js/base64.js'></script>
	<script src='${che_url}addata/ad.js'></script>
	<script src='${che_url}js/jquery-cookie.js'></script>
	<#nested>
	 <script type="text/javascript">
    	$(function() {
		     setCarParamLength();
		});
    	
    	function setCarParamCookie(id){
    		var num11=getCookie("CarTypeParam");
    		num11=num11+id+",";
    		SetCookie("CarTypeParam",num11);
    		setCarParamLength();
    	}
    	
    	function setCarParamLength(){
    		var num11=getCookie("CarTypeParam");
    		if(num11!=null&&num11.length>0){
    			num11=num11.substring(0,num11.length-1);
    			var aa=num11.split(",");
    			var aalength=aa.length;
    			if(aalength>5){
    				aalength=5;
    				aa=aa.slice(aa.length-5,aa.length);
    			}
    			
    			$("#carParamPk").html(aalength);
    			$("#carParamPk").show();
    			var reg=new RegExp(",","g")
    			var hr=num11.replace(reg,"/");
    			var aaStr="";
    			for(var i=0;i<aa.length;i++){
    				aaStr=aaStr+aa[i]+"/";
    			}
    			aaStr=aaStr.substring(0,aaStr.length-1);
    			$("#carParamPkHref").attr("href","http://che.315che.com/"+aaStr+".htm");
    		}else{
    			$("#carParamPk").html(0);
    			$("#carParamPk").hide();
    			$("#carParamPkHref").attr("href","http://www.315che.com/tools/newcompare.htm");
    		}
    	}
    	
    	function getCookie(name)//取cookies函数        
		{
		    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
		     if(arr != null) return unescape(arr[2]); return null;
		
		}
		
		function getCookie2(name)//取中文cookies函数        
		{
		    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
		     if(arr != null) return decodeURI(arr[2]); return null;
		
		}
		
		function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
		{
		    var Days = 30; //此 cookie 将被保存 30 天
		    var exp  = new Date();    //new Date("December 31, 9998");
		    exp.setTime(exp.getTime() + Days*24*60*60*1000);
		    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
		}
    </script>
	<script type="text/javascript">
		function join_favorite(siteUrl, siteName){ 
			try{
				//window.external.addFavorite();   
			}catch(e){
				alert("加入收藏夹失败，请使用Ctrl+D快捷键进行添加操作!"+e);
			}
		}
		$(function(){
			$.ajax({
	    		url : '${city_che_url!}che/getNowCookie',
	    		dataType : 'jsonp',
	    		jsonp:'jsonpcallback',
	    		success : function(data){
	    			var html = '<a href="${che_url}'+data[0].englingname+'/">'+data[0].byname+'</a>';
	    			$(".change-city span").html(html);
	    			<#if hasad=0>showAdInfo(data[0].catalogid);</#if>
	    			var html = '<i class="city-pos-icon"></i>';
	    			$(".cur-city-pos").html(html+"[<a href='${che_url}"+data[0].englingname+"/'>"+data[0].byname+"</a>]");
	    		}
		  	});
		});
		
		$("#top-show-city a").click(function(){
			var englingname = $(this).attr("value");
			$.ajax({
	    		url : '${che_url}che/setCityCookie',
	    		dataType : 'jsonp',
	    		data:{englingname:englingname},
	    		jsonp:'jsonpcallback',
	    		success : function(data){
	    			window.location.href="${che_url}"+englingname+"/";
	    		}
		  	});
		});
		
		//$(".hotcitys a").click(function(){
		//	var englingname = $(this).attr("value");
		//	if(englingname == "arealist.htm"){
		//		window.location.href="${che_url}"+englingname;
		//		return;
		//	}
		//	$.ajax({
	    //		url : '${che_url}che/setCityCookie',
	    //		dataType : 'jsonp',
	    //		data:{englingname:englingname},
	    //		jsonp:'jsonpcallback',
	    //		success : function(data){
	    //			window.location.href="${che_url}"+englingname+"/";
	    //		}
		//  	});
		//});
	</script>
	
	<script>
		$(function() {
		if($("img.lazy").lazyload==undefined){
		
		}else{
			$("img.lazy").lazyload({
		    placeholder: "${che_url}/images/default_car_icon.png",
		  });
		}
		  
		});
		
		$(function(){
			queryOption("brand",0);
			
			$(".select-selected").click(function(){
				$(".select-option").hide();
				
				if($(this).attr("show")=="true"){
					$(this).attr("show","false");
					$(this).next().hide();
				}else{
					$(this).attr("show","true");
					$(this).next().show();
				}
				
				return false;
			});
			
			
			$("#queryModel").click(function(){
				var value=$.trim($("#model_selected").attr("value"));
				if(value==null||value==""){
					value=$.trim($("#series_selected").attr("ename"));
					if(value==null||value==""){
						value=$.trim($("#brand_selected").attr("ename"));
						if(value==null||value==""){
							alert("请选择品牌！");
							return ;
						}
						window.open("${che_che_url}"+value+"/","_blank");
						return ;
					}
					window.open("${auto_che_url}"+value+"/","_blank");
					return ;
				}
				window.open("${che_che_url}"+value+"/","_blank");
			});
			
			//查商家
			$("#querysj").click(function(){
				var value=$("#model_selected").attr("value");
				if(value==null||value==""){
					value=$("#series_selected").attr("value");
					if(value==null||value==""){
						value=$("#brand_selected").attr("value");
					}
				}
				
				if(value==null||value==""){
					alert("请选择品牌！");
					return ;
				}
				window.open("${dea_che_url}"+value+"/0_1_1.htm","_blank");
			});
			
			// 查报价
			$("#querybj").click(function(){
				var value=$("#series_selected").attr("value");
				if(value==null||value==""){
					value=$("#brand_selected").attr("value");
					if(value==null||value==""){
						alert("请选择品牌！");
					}else{
						window.open("${price_che_url}brand/0-"+value+".htm","_blank");
					}
				}else{
					window.open("${price_che_url}series/"+value+"-0-0.htm","_blank");
				}
			});
			
		});
		
		function clickToDea(eid){
			window.open("${dea_che_url}"+(eid+100000000)+"/","_blank");
		}
		
		function queryOption(hid,fatherid){
			$.ajax({
				url:"${che_url}che/query?fatherid="+fatherid+"&target="+hid,
				success:function(data){
					var carInfos=eval(data);
					
					$("#"+hid).empty();
					for(var i=0;i<carInfos.length;i++){
						var html;
						if(carInfos[i].isKey=="Y"){
							var html='<dd cid="'+carInfos[i].catalogid+'">'+
									//'<b>'+carInfos[i].lname+'</b>'+
									'<a style="padding-left:15px;font-size:16px;color:black;font-weight:bold;" target="_self" href="javascript:void(0);">'+carInfos[i].catalogname+'</a></dd>';
						}else{
							var html='<dd cid="'+carInfos[i].catalogid+'" onclick="optionClick(\''+hid+'\',\''+carInfos[i].catalogname+'\','+carInfos[i].catalogid+',\''+carInfos[i].lname+'\',\''+carInfos[i].englishname+'\')">';
								//'<b>'+carInfos[i].lname+'</b>';
								if("brand"==hid){
									html+='<a target="_self" href="javascript:void(0);">'+carInfos[i].lname+' '+carInfos[i].catalogname+'</a>';
								}else{
									html+='<a target="_self" href="javascript:void(0);">'+carInfos[i].catalogname+'</a>';
								}
							html+= '</dd>';
						}
						$("#"+hid).append($(html));
					}
				}
			});
		}
		
		function optionClick(hid,name,id,lname,ename){
			$("#"+hid).parent().prev().attr("show","false");
			$("#"+hid).parent().hide();
			if("brand"==hid){
				$("#"+hid).parent().prev().find("span").html(lname+" "+name);
			}else{
				$("#"+hid).parent().prev().find("span").html(name);
			}
			$("#"+hid).parent().prev().attr("value",id);
			$("#"+hid).parent().prev().find("span").css("color","#333");
			if(hid=="brand"){
				$("#brand_selected").attr("ename",ename);
				$("#brand_selected").attr("value",id);
				queryOption("series",id);
				
				$("#series").parent().prev().find("span").html("选择车系");
				$("#model").parent().prev().find("span").html("选择车型");
				$("#series").parent().prev().find("span").css("color","#b3bcc6");
				$("#model").parent().prev().find("span").css("color","#b3bcc6");
				$("#model_selected").attr("value","");
			}else if(hid=="series"){
				$("#series_selected").attr("ename",ename);
				$("#series_selected").attr("value",id);
				queryOption("model",id);
				
				$("#model").parent().prev().find("span").html("选择车型");
				$("#model").parent().prev().find("span").css("color","#b3bcc6");
				$("#model_selected").attr("value","");
			}
		}
		
		$(function(){
			$("#cheLogin input[type='button']").click(function(){
				var UN=$.trim($("#cheLogin input[name='UN']").val());
				var PW=$.trim($("#cheLogin input[name='PW']").val());
				if(UN==null||UN==""){
					alert("用户名不能为空！");
					return ;
				}
				if(PW==null||PW==""){
					alert("密码不能为空！");
					return ;
				}
				UN = encodeURI(UN);
				UN = UN.replace(/\$/g,"$$");
				UN = UN.replace(/\%/g,"$");
				//document.domain="315che.com";
				$.ajax({
		    		url : 'http://login.315che.com/simplelogin.ashx',
		    		dataType : 'jsonp',
	    			jsonp:'jsonpcallback',
		    		data:{UN:UN,PW:encodeURI(PW)},
		    		beforeSend:function(){
		    			//alert("df");
		    			//cheLogin();
		    		},
		    		success : function(data){
		    			//alert("sdf");
		    			cheLogin("login");
		    		},
		    		error:function(e){
		    			//alert(e.toString());
		    			
		    			cheLogin("login");
		    		}
			  	});
			});
			
			cheLogin();
		});
		
		String.prototype.replaceAll  = function(s1,s2){     
		    return this.replace(new RegExp(s1,"gm"),s2);     
		}
		
		function cheLogin(e){
			var uid = getCookie2("uname");
			
			var isvip = getCookie("isvip");
			if(uid != null){
				// 登录成功
				$(".popup-box").stop(true).animate({'margin-top': '-395px', 'opacity': '0'}, 800);
				$(".overlay").css({'display':'none'}).animate({'opacity':'0'});
				if(e!= undefined && isvip == 1){
					window.location.href = "http://4s.315che.com/vipdealer/admin/index.aspx?type=1";
				}
				$(".top-login").html("<li><a href='http://4s.315che.com/vipdealer/admin/index.aspx?type=1' class='username'>"+uid+"</a>,欢迎登录中国汽车消费网!<a href='javascript:void(0);' class='login-out'>注销</a></li>");
				
				$(".login-out").click(function(){
					DelCookie("dnt");
					DelCookie("isvip");
					DelCookie("lisum");
					DelCookie("litm");
					DelCookie("uid");
					DelCookie("uname");
					window.location.reload();
				});
			}else{
				if(e=="login"){
					alert("登录失败！");
				}
			}
		}
		
		function DelCookie(name)
		{
			var exp = new Date();
			exp.setTime (exp.getTime() - 1);
			var cval = getCookie(name);
			document.cookie = name + "=" + cval + "; expires="+ exp.toGMTString()+"; path=/;domain=.315che.com";
		}
	</script>
	<div style="display:none;"><script src="http://w.cnzz.com/c.php?id=30010794" language="JavaScript" charset="gb2312"></script></div>
</body>
</html>
</#macro>
<!--分页pages.htm-->
<#macro calcPage action page pages>
	<div class="pages">
		<a href="${action}1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${action}${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${action}${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${action}${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${action}${page+1}.htm"</#if> class="next">next<</a>
		<a href="${action}${pages}.htm" class="next page-disabled">prev</a>
	</div>
</#macro>

<!--分页带参数page__parameter.htm-->
<#macro calcPage1 action page pages parameter>
	<div class="pages">
		<a href="${action}1__${parameter}.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${action}${page-1}__${parameter}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${action}${p}__${parameter}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${action}${p}__${parameter}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${action}${page+1}__${parameter}.htm"</#if> class="next">next<</a>
		<a href="${action}${pages}__${parameter}.htm" class="next page-disabled">prev</a>
	</div>
</#macro>

<!--分页带参数page_parameter.htm-->
<#macro calcPage2 action page pages parameter>
	<div class="pages">
		<a href="${action}1_${parameter}.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${action}${page-1}_${parameter}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${action}${p}_${parameter}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${action}${p}_${parameter}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${action}${page+1}_${parameter}.htm"</#if> class="next">next<</a>
		<a href="${action}${pages}_${parameter}.htm" class="next page-disabled">prev</a>
	</div>
</#macro>

<!--分页带参数-口碑.htm-->
<#macro calcPagekoubei serialid page pages hot>
<#if hot==0>
	<div class="pages">
		<a href="${koubei_che_url}kblist/${serialid!}-1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${koubei_che_url}kblist/${serialid!}-${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${koubei_che_url}kblist/${serialid!}-${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${koubei_che_url}kblist/${serialid!}-${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${koubei_che_url}kblist/${serialid!}-${page+1}.htm"</#if> class="next">next<</a>
		<a href="${koubei_che_url}kblist/${serialid!}-${pages}.htm" class="next page-disabled">prev</a>
	</div>
<#else>
	<div class="pages">
		<a href="${koubei_che_url}kblist/${serialid!}hot-1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${koubei_che_url}kblist/${serialid!}hot-${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${koubei_che_url}kblist/${serialid!}hot-${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${koubei_che_url}kblist/${serialid!}hot-${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${koubei_che_url}kblist/${serialid!}hot-${page+1}.htm"</#if> class="next">next<</a>
		<a href="${koubei_che_url}kblist/${serialid!}hot-${pages}.htm" class="next page-disabled">prev</a>
	</div>
</#if>
</#macro>

<!--分页带参数-口碑.htm-->
<#macro calcPageAns  page pages msgtype serialid englishname questionid type sort>
<#if type==0>
	<#if sort == "asc">
		<div class="pages">
			<a href="${auto_che_url}${englishname!}/qa${questionid!}-1.htm" class="prev page-disabled">prev</a>
			<a <#if page-1 gt 0>href="${auto_che_url}${englishname!}/qa${questionid!}-${page-1}.htm"</#if> class="prev">prev</a>
			<#list page-2..page-1 as p>
				<#if p gt 0>
					<a href="${auto_che_url}${englishname!}/qa${questionid!}-${p}.htm">${p}</a>
				</#if>
			</#list>
			<a href="javascript:void(0);" class="current">${page}</a>
			<#list page+1..page+2 as p>
				<#if p lte pages ><a href="${auto_che_url}${englishname!}/qa${questionid!}-${p}.htm">${p}</a></#if>
			</#list>
			<a <#if page+1 lte pages>href="${auto_che_url}${englishname!}/qa${questionid!}-${page+1}.htm"</#if> class="next">next<</a>
			<a href="${auto_che_url}${englishname!}/qa${questionid!}-${pages}.htm" class="next page-disabled">prev</a>
		</div>
	<#else>
		<div class="pages">
		<a href="${auto_che_url}${englishname!}/qa${questionid!}-r1-1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${auto_che_url}${englishname!}/qa${questionid!}-r1-${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${auto_che_url}${englishname!}/qa${questionid!}-r1-${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${auto_che_url}${englishname!}/qa${questionid!}-r1-${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${auto_che_url}${englishname!}/qa${questionid!}-r1-${page+1}.htm"</#if> class="next">next<</a>
		<a href="${auto_che_url}${englishname!}/qa${questionid!}-r1-${pages}.htm" class="next page-disabled">prev</a>
	</div>
	</#if>
<#else>
	<#if sort == "desc">
	<div class="pages">
		<a href="${koubei_che_url}s${msgtype}/${serialid!}-r-1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${koubei_che_url}s${msgtype}/${serialid!}-r-${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${koubei_che_url}s${msgtype}/${serialid!}-r-${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${koubei_che_url}s${msgtype}/${serialid!}-r-${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${koubei_che_url}s${msgtype}/${serialid!}-r-${page+1}.htm"</#if> class="next">next<</a>
		<a href="${koubei_che_url}s${msgtype}/${serialid!}-r-${pages}.htm" class="next page-disabled">prev</a>
	</div>		
	<#else>
	<div class="pages">
		<a href="${koubei_che_url}s${msgtype}/${serialid!}-1.htm" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${koubei_che_url}s${msgtype}/${serialid!}-${page-1}.htm"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${koubei_che_url}s${msgtype}/${serialid!}-${p}.htm">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${koubei_che_url}s${msgtype}/${serialid!}-${p}.htm">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${koubei_che_url}s${msgtype}/${serialid!}-${page+1}.htm"</#if> class="next">next<</a>
		<a href="${koubei_che_url}s${msgtype}/${serialid!}-${pages}.htm" class="next page-disabled">prev</a>
	</div>	
	</#if>

</#if>
</#macro>

<#macro calctousu1 brandid page pages>
	<div class="pages">
		<a href="${tousu_che_url}tousulist/${brandid}/" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${tousu_che_url}tousulist/${brandid}/${page-1}/"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${tousu_che_url}tousulist/${brandid}/${p}/">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${tousu_che_url}tousulist/${brandid}/${p}/">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${tousu_che_url}tousulist/${brandid}/${page+1}/"</#if> class="next">next<</a>
		<a href="${tousu_che_url}tousulist/${brandid}/${pages}/" class="next page-disabled">prev</a>
	</div>
</#macro>

<#macro calctousu2 serialid page pages>
	<div class="pages">
		<a href="${tousu_che_url}tousulist/serial/${serialid}/" class="prev page-disabled">prev</a>
		<a <#if page-1 gt 0>href="${tousu_che_url}tousulist/serial/${serialid}/${page-1}/"</#if> class="prev">prev</a>
		<#list page-2..page-1 as p>
			<#if p gt 0>
				<a href="${tousu_che_url}tousulist/serial/${serialid}/${p}/">${p}</a>
			</#if>
		</#list>
		<a href="javascript:void(0);" class="current">${page}</a>
		<#list page+1..page+2 as p>
			<#if p lte pages ><a href="${tousu_che_url}tousulist/serial/${serialid}/${p}/">${p}</a></#if>
		</#list>
		<a <#if page+1 lte pages>href="${tousu_che_url}tousulist/serial/${serialid}/${page+1}/"</#if> class="next">next<</a>
		<a href="${tousu_che_url}tousulist/serial/${serialid}/${pages}/" class="next page-disabled">prev</a>
	</div>
</#macro>

<#macro tools id >
	<div class="tools-wrap">
		<div class="title-nav">
			<h3 class="title">购车工具</h3>
			<div class="tab-nav tab-nav-col6">
				<ul class="clearfix">
					<li <#if id==1>class="current"<#else>class=""</#if>><a href="${che_url}tools/">购车费用</a></li>
					<li <#if id==2>class="current"<#else>class=""</#if>><a href="${che_url}tools/daikuan.htm">贷款计算</a></li>
					<li <#if id==3>class="current"<#else>class=""</#if>><a href="${che_url}tools/feiyong.htm">保险计算</a></li>
					<li <#if id==4>class="current"<#else>class=""</#if>><a href="${pk_che_url}">车型对比</a></li>
					<li <#if id==5>class="current"<#else>class=""</#if>><a href="${che_url}tools/newcompare.htm">参数对比</a></li>
					<li <#if id==6>class="current"<#else>class=""</#if>><a href="${che_url}tools/tupianduibi.htm">图片对比</a></li>
				</ul>
			</div>
		</div>
	</div>
</#macro>




<#macro comment_html>
<div class="title-box title-box2">
	<h2><a href="javascript:void(0);" id="commentTitle">网友评论</a></h2>
	<span class="more" id="commentsize"><strong>0</strong>条评论</span>
</div>
<div class="post-comment">
	<div class="textareabox">
		<textarea id="commentcontent" cols="30" rows="10" class="form-textarea">文明上网，理性发言</textarea>
		<div class="textareabox-submitbar">
			<div class="fn-right"><a href="javascript:void(0);" class="comment-btn">发表评论</a></div>
		</div>
	</div>
</div>
<div class="user-comment">
	<div class="title">最新评论</div>
	<dl class="comment-list">
	</dl>
</div>
</#macro>
<#macro comment_js type=1 catalogid=1 posturl= "${che_url}" countTag = "0">
<script>
$(".comment-btn").click(function(){
	var content = $("#commentcontent").val();
	if($.trim(content) == "" || $.trim(content) == "文明上网，理性发言"){
		alert("内容不能为空");
		return;
	}
	$.ajax({
        url: "${posturl}che/addComment",
        async: false,//改为同步方式
        type: "POST",
        data: { type:${type},catalogid:${catalogid},content:content },
        success: function (data) {
            if(data == "1"){
			var nowhtml = $(".comment-list").html();
			var html = '<dd>'+content+'</dd><dt><span class="fn-left"><a href="javascript:void(0);" class="user">315车友</a><span class="date"> 发表于：刚刚</span></span>';
			html = html + '<span class="fn-right"></span></dt>';
			$(".comment-list").html(html+nowhtml);
			$("#commentcontent").val("");
			$(".user-comment").show();
		}
        }
    });
})
$(document).ready(function(){
	$.ajax({
		url : '${posturl}che/commentInit',
		dataType : 'json',
		data:{type:${type},catalogid:${catalogid}},
		success : function(data){
    		if(data.length != 0){
    			var html = "";
    			$("#commentsize strong").html(data.length);
    			var tag = "${countTag}";
    			if(tag != "0")
    				$("#${countTag}").html(data.length);
    			//alert("data.length 0-->"+data.length);
    			if($("#til_commentsize"))
	    			$("#til_commentsize").html('<i class="icon news-comment"></i>'+data.length);
	    		//alert("data.length 1-->"+data.length);
    			$("#commentsize strong").html(data.length);
    			for(var i = 0;i<data.length;i++){
    				var jsDate = new Date(data[i].adddate.time);
    				
    				var date = jsDate.getFullYear()+"年"+(Number(jsDate.getMonth())+1)+"月"+jsDate.getDate()+"日";
				    if(jsDate.getHours()<10){
				        date = date+"0"+jsDate.getHours()+":";
				    }else{
				        date = date+jsDate.getHours()+":";
				    }
				    if(jsDate.getMinutes()<10){
				        date = date+"0"+jsDate.getMinutes()+":";
				    }else{
				        date = date+jsDate.getMinutes()+":";
				    }
				    if(jsDate.getSeconds()<10){
				        date = date+"0"+jsDate.getSeconds()+"";
				    }else{
				        date = date+jsDate.getSeconds()+"";
				    }
    				html = html + '<dd>'+data[i].content+'</dd><dt><span class="fn-left"><a href="javascript:void(0);" class="user">'+data[i].username+'</a><span class="date"> 发表于 '+date+'</span></span>';
    				html = html + '<span class="fn-right"></span></dt>';
    			}
    			$(".comment-list").html(html);
    			$(".user-comment").show();
    		}
		}
	});
});



</script>
</#macro>
<#macro comment_ad_js url="">
	<script>
		//获取广告位信息
		function showAdInfo(catalogid){
			getAdInfo("${url}",catalogid);
		}
		
		//function getAdInfo(url,catalogid){
			//var list = paiqijson;
			//for(var i=0;i<list.length;i++){
			//	if(list[i].city==catalogid&&list[i].html==url){
				//	showAd(list[i]);
			//	}else if(list[i].city=="0"&&list[i].html==url){
				//	showAd(list[i]);
				//}
			//}
		//}
		
		function getAdInfo(url,catalogid){
			var map = paiqijson[0];
			for(var key in map){
				if(url==key){
					var list = map[key];
					for(var i=0;i<list.length;i++){
						if(list[i].city==catalogid){
							showAd(list[i]);
						}else if(list[i].city=="0"){
							var flag = true;
							for(var j=0;j<list.length;j++){
								if(list[i].adtype==list[j].adtype&&list[i].adplace==list[j].adplace&&list[i].city==catalogid){
									flag = false;
									break;
								}
							}
							if(flag){
								showAd(list[i]);
							}
						}
					}
					break;
				}
			}
		}
		
		function showAd(list){
			var html = '';
			if(list.adimg.substring(list.adimg.length-3)=="swf"){
				html +='<embed height="'+list.adheight+'" width="'+list.adwidth+'" src="'+list.adimg+'" wmode="transparent" type="application/x-shockwave-flash"></embed>';
				html +='<a target="_blank" href="'+list.adurl+'"><div style="position:relative; left:0; z-index:10; width:'+list.adwidth+'px; height:'+list.adheight+'px; margin-top:-'+list.adheight+'px; cursor:pointer;"></div></a>';
			}else{
				html +='<a href="'+list.adurl+'">';
				html +='<img height="'+list.adheight+'" width="'+list.adwidth+'" src="'+list.adimg+'">';
				html +='</img>';
				html +='</a>';
			}
			$("#showAd"+list.adtype+list.adplace).html(html);
		}
	
	</script>
</#macro>
<!--图片上传-->
<#macro upload_pic>
<div id="viewbg" style="background:#666;width: 100%;height: 100%;display:none;left:0;top:0;/*FF IE7*/filter:alpha(opacity=50);opacity:0.9;z-index:10002;position:fixed!important;/*FF IE7*/position:absolute;/*IE6*/_top:expression(eval(document.compatMode && document.compatMode=='CSS1Compat') ? documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/"></div>
<div id="login_container" style=" overflow:hidden;width:620px;height:530px;float:none;padding:3px;display:none;background:#FFF;z-index:1;top:25%;left:50%;margin-left:-326px;position:absolute;z-index:10003;position:fixed;_position:absolute;_top:expression(eval(document.compatMode && document.compatMode=='CSS1Compat') ? documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/">
    <div class="modal-header">
		<h1 class="modal-title">图片上传</h1>
	</div>
	<div class="modal-body">
		<iframe name="uploadfrm" id="uploadfrm" width="100%" border="0" height="400px" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>
	</div>
	<div class="modal-footer">
		<button type="button"  class="default-btn" onclick="closeUpload();">关闭</button>
		<button type="button"  class="blue-btn" onclick="uoloadSuccess();">确定</button>
	</div>
</div>
<script type="text/javascript">
function showUpload(){
			$("#viewbg").css({display:"block",height:$(document).height()});
			var yscroll = document.documentElement.scrollTop;
			$("#login_container").css("top","150px");
			$("#login_container").css("display","block");
			document.documentElement.scrollTop = 0;
			
			document.domain="315che.com";
			$("#uploadfrm")[0].src = "${img_che_url}imgupload/indexche"
}
function uoloadSuccess(){
		var imgarr = window.frames["uploadfrm"].imgarr;
		if(imgarr.length != 0){
			resultArr = new Array;
			var sort = $("#files span",window.frames["uploadfrm"].document);
			for(var i = 0;i<sort.length;i++){
				if(sort[i].className==""){
					var oname = sort[i].innerHTML;
					for(var j=0;j<imgarr.length;j++){
						if(imgarr[j].oldImageName == oname ){
							resultArr.push(imgarr[j]);
						}
					}
				}
			}
			callbackSucc(resultArr);
			closeUpload();
		}
}
function closeUpload(){
	$("#viewbg").css("display","none");
	$("#login_container").css("display","none");
}
</script>
</#macro>


<#macro html_city id="page-show-city">
	<div class="change-city" id="${id}">
		<span></span><a href="javascript:void(0);">[切换城市]</a><i></i>
		<div class="show-city">
			<dl>
				<dt>热门城市：</dt>
				<dd>
				<#list cityitems.hotArray as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
					
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[0]}：</dt>
				<dd>
				<#list cityitems.cityarray1 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[1]}：</dt>
				<dd>
				<#list cityitems.cityarray2 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[2]}：</dt>
				<dd>
				<#list cityitems.cityarray3 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[3]}：</dt>
				<dd>
				<#list cityitems.cityarray4 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[4]}：</dt>
				<dd>
				<#list cityitems.cityarray5 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[5]}：</dt>
				<dd>
				<#list cityitems.cityarray6 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
			<dl>
				<dt>${cityitems.proArray[6]}：</dt>
				<dd>
				<#list cityitems.cityarray7 as cl>
					<#list sublist as ls>
					<#if ls.byname = cl>
						<a href="javascript:void(0);" value="${ls.englingname}">${cl}</a>
						<#break>
					</#if>
					</#list>
				</#list>
				</dd>
			</dl>
		</div>
	</div>
</#macro>