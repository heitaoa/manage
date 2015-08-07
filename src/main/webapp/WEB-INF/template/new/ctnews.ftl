<#import "../common_315che.ftl" as cc>

<@cc.html_top title="${(news.newstitle)?replace('&nbsp',' ')}【图】_中国汽车消费网" 
	keywords="${(news.newskeywords)?replace('&nbsp',',')}" 
	description="${(news.description)?replace('&nbsp',' ')}" 
	mobileMeta="<meta http-equiv='mobile-agent' content='format=html5; url=http://i.315che.com/news/${news.adddate?string('yyyyMM')}/${news.id}_${contentPage-1}.htm' />">
	<!--主内容开始-->
	<!--通栏1开始-->
		<div class="adbox" id="showAd11"></div>
	<!--通栏1结束-->
	<div class="content">
		<div class="breadcrumb-nav ma-b10">
			<div class="related-search">
			<form action="http://so.315che.com/cse/search" target="_blank" method="get" id="search-form" >
					<div class="search-box">
						<!--<i class="icon"></i>
						<input type="text" autocomplete="off" class="input-search">
						<input type="submit" value="搜索" class="submit-btn">-->
					</div>
				</form>
			</div>
			<p>您现在的位置：<a href="${che_url}">首页</a> &#62; <a href="${che_url}news/${(newsCatalog.catalogid)!}/">${(newsCatalog.catalogname)!}</a>  &#62;  <a href="javascript:void(0);" class="current">正文</a></p>
		</div>
		<#if seriseMap?? && brandMap??>
		<div class="car-public-top">
			<div class="car-brand-info">
				<div class="brand-logo"><a href="${che_che_url}${brandMap.englishname}/"><img width = "50" height="50" src="${imageFormat(brandMap.photo,0,0)}" alt=""></a></div>
				<h1>${seriseMap.catalogname}</h1>
			</div>
			<@cc.chexiNav nav=7 serialid=seriseMap.catalogid englishname="${(seriseMap.englishname!)}" flagBoolean=flagBoolean />
		</div>
		</#if>
		
		<div class="ma-t20 clearfix">
		
			<div class="car-type-body">
				<div class="row row-border ma-b15">
								
					<#if news??>
					<div class="news-details-top clearfix">
						<h1>${news.newstitle}</h1>
						<p class="author-info">
							<!--<span>${dateFormatMethod(news.adddate)}</span>-->
							<span><a href="${che_url}history/${news.adddate?string('yyyy/MM/dd')}/1.htm" target="_blank">${dateFormatMethod(news.adddate)}</a></span>
							<#if newsSource??>
							<span>来源：<a href="${(newsSource.url)!}" target="_blank">${(newsSource.newseditor)!}</a></span>
							<#else>
							<span>来源：<#if news.newseditor?has_content && (news.newseditor).length() gt 0 && news.newseditor!="NULL">${news.newseditor}<#else><a href="${che_url}" target="_blank">中国汽车消费网</a></#if></span>
							</#if>
							
							<#if editor??>
							<span>责任编辑：<a href="${che_url}news/u/${editor.id + 50854}.htm">${editor.realname}</a></span>
							<#else>
								<!--
								<span>责任编辑：<#if news.addadmin?? && news.addadmin != "NULL"><a href="javascript:void(0);">${news.addadmin!}<#else>admin</#if></span>
								-->
							</#if>
						</p>
						<div class="ndt-tools">
							<a href="#commentTitle" id="til_commentsize"><i class="icon news-comment"></i>0</a> 
							<span>|</span>
							<a href="javascript:;"><i class="icon news-share"></i>分享</a>
							<ul class="bdshare">
								<li class="bds_qzone"><a id="sqzone" href="#" target="_blank">QQ空间</a></li>
								<li class="bds_tsina"><a id="ssina" href="#" target="_blank">新浪微博</a></li>
								<li class="bds_tqq"><a id="sqq" href="#" target="_blank">腾讯微博</a></li>
								<li class="bds_renren"><a id="srenren" href="#" target="_blank">人人网</a></li>
							</ul>
						</div>
					</div>
					</#if>
					
					<div class="news-details-con">
						${(contentbak.contentstr)!}
					</div>
					<#if contentPages gt 1>
					<div class="pages">
					
						<#if contentPage gt 1>
						<a href="${inf_che_url}n/${news.adddate?string("yyyy_MM")}/${news.id}/${contentPage-1}.htm" class="prev">prev</a>
						<#else>
						<a href="javascript:void();" class="prev page-disabled">prev</a>
						</#if>
						
						<#list 1..contentPages as page>
						<a href="${inf_che_url}n/${dateFormatMethod(news.adddate, "yyyy_MM")}/${news.id}/${page}.htm" <#if page == contentPage>class="current"</#if>>${page}</a>
						</#list>
						
						<#if contentPage lt contentPages>
						<a href="${inf_che_url}n/${news.adddate?string("yyyy_MM")}/${news.id}/${contentPage+1}.htm" class="next">next</a>
						<#else>
						<a href="javascript:void(0);" class="next page-disabled">next</a>
						</#if>
					</div>
					
					<p class="function-tips">提示：支持键盘“← →”键翻页</p>
					</#if>
					
					<#if news??>
					<div class="bott-shares">
						<div class="share-tools">
							<!--baidu share start-->
							<div class="bdsharebuttonbox" data-tag="share_1">
								<span class="share_tips">分享到：</span>
								<a class="bds_tqq" data-cmd="tqq"></a>
								<a class="bds_qzone" data-cmd="qzone" href="#"></a>
								<a class="bds_tsina" data-cmd="tsina"></a>
								<a class="bds_baidu" data-cmd="baidu"></a>
								<a class="bds_sqq" data-cmd="sqq"></a>
								<a class="bds_renren" data-cmd="renren"></a>
								<a class="bds_kaixin001" data-cmd="kaixin001"></a>
								<a class="bds_weixin" data-cmd="weixin"></a>
								<a class="bds_more" data-cmd="more">更多</a>
								<a class="bds_count" data-cmd="count"></a>
							</div>
							<script>
							window._bd_share_config = {
								common: {
									bgText: '${news.newstitle}',
									bdDesc : '<#if news.newstitle?length gt 16>${news.newstitle[0..15]}<#else>${news.newstitle}</#if>',
									bdUrl : '${inf_che_url}n/${news.adddate?string("yyyy_MM")}/${news.id}/${contentPage}.htm'
								},
								share : [{"bdSize" : 16}]
							}
							with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
							</script>
							<!--baidu share end-->
						</div>
					</div>
					</#if>
					
					<#if groupbuy?? && groupbuy.size() gt 0>
					<div class="adcbox adcbox-main clearfix">
						<@cc.groupbuy tgList 1 />
					</div>
					</#if>

					<#if seriseMap??>
					<div class="row row-border ma-t15">
						<div class="recom-cars-box">
							<div class="recom-car-pic">
								<a href="${pic_che_url}serial/${(seriseMap.catalogid)!}.htm"><img src="${imageFormat(seriseMap.photo,180,120)}" alt=""></a>
							</div>
							<ul class="car-info-list">
								<li>
									<h3><a href="${auto_che_url}${(seriseMap.englishname)!}/">${seriseMap.catalogname}</a></h3>
								</li>
								<li>
									<span>官方指导价：<a href="${price_che_url}series/${(seriseMap.catalogid)!}-0-0.htm"><b class="car-price-bold">${seriseMap.p2!"暂无"}</b>万元</a></span>
									<a href="${che_url}tools/xundijia/${seriseMap.catalogid}.htm" class="enquiry-btn">询底价</a>
								</li>
								<li>
									<span class="ma-r1">级  别：<#if seriseMap.jibie=="0">无<#elseif seriseMap.jibie=="1">微<#elseif seriseMap.jibie=="2">小<#elseif seriseMap.jibie=="3">紧凑<#elseif seriseMap.jibie=="4">轻<#elseif seriseMap.jibie=="5">中<#elseif seriseMap.jibie=="6">中大<#elseif seriseMap.jibie=="7">大<#elseif seriseMap.jibie=="8">豪华<#elseif seriseMap.jibie=="9">超级</#if>型车</span>
									<span class="ma-r1">车身结构：<#if seriseMap??>${seriseMap.csjg}</#if></span>
									<span>变速箱：<#if seriseMap??>${seriseMap.bsx}</#if></span>
								</li>
								<li class="mat0">
									<span class="ma-r1 mat2">发动机：${(seriseMap.pl!"暂无")!}</span>
									<div class="carcolors">
										<span class="car-color-title">车身颜色：</span>
										<div class="car-color">
											<#if ysList??>
											<#list ysList as ys>
												<a href="#" style="background-color:${ys};"></a>
											</#list>
											</#if>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					</#if>
					<#if dealerList ?? && dealerList?size gt 0>
					<div class="row ma-t15">
						<#if seriseMap?? >
						<div class="title-box title-box2">
							<h2><a href="http://4s.315che.com/${seriseMap.catalogid}/0_1_1.htm">${seriseMap.catalogname}经销商</a></h2>
							<span class="more more-list">
								<a href="javascript:void(0);"<#if cityId==1> class="current"</#if> onclick="getDealerListsByAreaid(1,'北京',this)" >北京</a>
								<a href="javascript:void(0);"<#if cityId==162> class="current"</#if> onclick="getDealerListsByAreaid(162,'南京',this)">南京</a>
								<a href="javascript:void(0);"<#if cityId==174> class="current"</#if> onclick="getDealerListsByAreaid(174,'苏州',this)">苏州</a>
								<a href="javascript:void(0);"<#if cityId==175> class="current"</#if> onclick="getDealerListsByAreaid(175,'杭州',this)">杭州</a>
								<a href="javascript:void(0);"<#if cityId==186> class="current"</#if> onclick="getDealerListsByAreaid(186,'合肥',this)">合肥</a>
								<a href="javascript:void(0);"<#if cityId==259> class="current"</#if> onclick="getDealerListsByAreaid(259,'武汉',this)">武汉</a>
								<a href="javascript:void(0);"<#if cityId==299> class="current"</#if> onclick="getDealerListsByAreaid(299,'广州',this)">广州</a>
								<a href="javascript:void(0);"<#if cityId==9> class="current"</#if> onclick="getDealerListsByAreaid(9,'上海',this)">上海</a>
								<a href="http://4s.315che.com/${seriseMap.catalogid}/0_1_1.htm">更多>></a>
							</span>
						</div>
						<input type="hidden" value="${seriseMap.catalogid}" id="seriseid">
						</#if>
						
						<#if dealerList?? >
						<ul class="cars-seller-list">
						<#list dealerList as dealer>
							<#if dealer_index < 4>
							<li>
								<h4><a href="${dea_che_url}${dealer.l_eid}/">${dealer.ename}</a></h4>
								<p>电话：<b><#if dealer.telephone?length gt 16>${dealer.telephone[0..15]}...<#else>${dealer.telephone}</#if></b></p>
								<p>地址：<span>[${dealer.areanme}]</span><#if dealer.address?length gt 15>${dealer.address[0..14]}...<#else>${dealer.address}</#if></p>
								<p>促销：<#if dealer.newsid == "0">无<#else><a href="${dea_che_url}${dealer.l_eid}/newsdetail-${dealer.newsid}.htm"><#if dealer.newstitle?length gt 20>${dealer.newstitle[0..19]}...<#else>${dealer.newstitle}</#if></a></#if></p>
							</li>
							</#if>
						</#list>
						</ul>
						</#if>
					</div>
					</#if>
					<#if newsRelatedList?? && newsRelatedList.size() gt 0>
					<div class="row ma-t15">
						<div class="title-box title-box2">
							<h2><a href="#">相关阅读</a></h2>
						</div>
						<div class="article-list article-tab-list">
							<ul>
								<#list newsRelatedList as related>
								<li>
									<a href="${related.url}">
										<div class="article-pic">
											<img src="${imageFormat(related.pic,200,130)}">
										</div>
										<h4>${related.title}</h4>
										<div class="time">${related.adddate}</div>
										<p>
											<#if related.desc?? && related.desc.length() gt 50>
											${related.desc[0..49]}...
											</#if>
										</p>
									</a>
								</li>
								</#list>
							</ul>
						</div>
					</div>
					</#if>
					
					<div class="row">
					<@cc.comment_html />
					</div>
					
					<#if hotDataMap??>
					<div class="row ma-t20">
						<div class="title-box">
							<h2><a href="#">热门车系</a></h2>
						</div>
						<div class="car-hot-line">
							<ul class="clearfix">
								<#list hotDataMap.get("hot_serials") as sub_data>
								<li><a href="${sub_data.link}">${sub_data.title}</a></li>
								</#list>
							</ul>
						</div>
					</div>
					</#if>

					
					
				</div>
			</div>
		
			<div class="side">
				<!--按钮广告1开始-->
				<div class="side-ad" id="showAd31"><a href="${che_che_url}${(brandMap.englishname)!}/"><img src="${che_url}images/sidebar_ad_demo2.jpg" alt=""></a></div>
				<!--按钮广告1结束-->
				<div class="side-list ma-b20">
					<div class="title-box">
						<h2><a href="#">精彩推荐</a></h2>
					</div>
					<ul class="car-side-list">
						<#if recommNewsList??>
						<@cc.recommNews  recommNewsList/>
						</#if>
					</ul>
				</div>
				
				<#if dealerActNewsList??>
				<div class="side-list ma-b20">
					<div class="title-box">
						<h2><a href="#">商家活动</a></h2>
					</div>
					<ul id="ul_move_news" class="car-side-list">
						<@cc.dealerNewss dealerActNewsList/>
					</ul>
				</div>
				</#if>
				
				<!--还看过-->
				<#if seeSeriesLists?? >
				<div class="side-list ma-b20">
					<@cc.seeSeries seriseMap.catalogname seeSeriesLists />
				</div>
				</#if>
				<!--按钮广告2开始-->
				<div class="side-ad  ma-b20" id="showAd32"><a href="#"><img src="${che_url}images/sidebar_ad_demo2.jpg" alt=""></a></div>
				<!--按钮广告2结束-->
			</div>
		
		</div>
			
		<@cc.html_footer/>
		
	</div>
	<!--主内容结束-->
</@cc.html_top>
<@cc.html_bottom 0>
	<@cc.comment_js type = 1 catalogid = "${(news.id)!}" posturl="${inf_che_url}"/>

	<@cc.comment_ad_js "${inf_che_url}n/${newsTypePinyin}/"/>
<script type="text/javascript" >
$(document).ready(function(){
		
	<!-- 键盘翻页	-->
	var page = ${contentPage};
	var pagesize = ${contentPages};
	 var ie;
	 var firefox;
	 
	 if (document.all) ie = true; else ie = false; //判断是否IE
	
	 document.onkeydown = KeyPress;
	
	function KeyPress(){
	  var key;
	   if (ie) key = event.keyCode;
	  else
	   key = KeyPress.arguments[0].keyCode;
	  
	  if(page < 1) page =1;
	  if(page > pagesize) page = pagesize;
	  	  
	  //上一页
	  if(key == 37 && page > 1)
	  	window.location.href="${inf_che_url}n/${dateFormatMethod((news.adddate)!, "yyyy_MM")}/${(news.id)!}/"+(--page)+".htm";
		//alert(--page);
	  
	  //下一页
	  if(key == 39 && page < pagesize)
	  	window.location.href="${inf_che_url}n/${dateFormatMethod((news.adddate)!, "yyyy_MM")}/${(news.id)!}/"+(++page)+".htm";
		//alert(++page);
	}

	$(".search-box").html(unescape('%3Cdiv id="bdcs"%3E%3C/div%3E%3Cscript charset="utf-8" src="http://znsv.baidu.com/customer_search/api/js?sid=17745892549744367899') + '&plate_url=' + (encodeURIComponent(window.location.href)) + '&t=' + (Math.ceil(new Date()/3600000)) + unescape('"%3E%3C/script%3E'));
});


function getDealerListsByAreaid(id,name,e){
	var seriseid=$("#seriseid").val();
	$(e).addClass("current").siblings().removeClass();
	$.ajax({
			type : "POST",
			cache : false,
    		url : 'http://www.315che.com/che/newsdetail/GetDealerListInfoByAreaid',
    		dataType : 'jsonp',
    		data:{seriseid:seriseid,cityId:id},
    		jsonp:'jsonpcallback',
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		success : function(data){
    			var Str="";
    			if(data.size>0){
    				$(".cars-seller-list").html("");
    			}else{
    				
    				for(var i=0;i<data.length;i++){
    					if(i<3){
    					Str=Str+"<li><h4><a href='${dea_che_url}"+data[i].l_eid+"/'>"+data[i].ename+"</a></h4><p>电话：<b>"+data[i].telephone+"</b></p><p>地址：<span>["+name+"]</span>"+data[i].address+"</p><p>促销：<a href='${dea_che_url}"+data[i].l_eid+"/newsdetail-"+data[i].newsid+".htm'>"+data[i].newstitle+"</a></p>";	
    					}
    				}
    				$(".cars-seller-list").html(Str);
    			}
    		}
		});
}

$(function() {
	var surl = encodeURIComponent(location.href);
	var stitle = encodeURIComponent($('.news-details-top h1').text());
	var alltext = $('.news-details-con p').first().text();
	var stext = alltext.substr(0,100) + '...';
	var scontent = "【" + stitle + "】" + stext;
	var simg = $('.news-details-con img').first().attr('src');
	document.getElementById('sqzone').href = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?title=" + scontent + "&pics=" + simg + "&url=" + surl;
	document.getElementById('ssina').href = "http://v.t.sina.com.cn/share/share.php?appkey=2019549328&ralateUid=1673396891&pic=" + simg + "&title=" + scontent + "&url=" + surl + "&rcontent=";
	document.getElementById('sqq').href = "http://v.t.qq.com/share/share.php?title=" + scontent + "&pic=" + simg + "&url=" + surl;
	document.getElementById('srenren').href = "http://share.renren.com/share/buttonshare.do?title=" + scontent + "&link=" + surl + "&rcontent=";
});

</script>

</@cc.html_bottom>