<#macro html nav=0 title="车团网 - 汽车电商O2O服务第一品牌" description="" keywords="">
<!DOCTYPE html>
<html lang="zh-hans">
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta content="telephone=no" name="format-detection">
	
	<meta name="keywords" content="${(keywords)!}">
	<meta name="description" content="${(description)!}">
	
	<link rel="apple-touch-icon-precomposed" href="img/ios/57x57.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/ios/72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/ios/72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/ios/72x72.png">
	<link rel="stylesheet" href="${wap_ct_url}css/global.css">
	<link rel="stylesheet" href="${wap_ct_url}css/more.css">
	<link rel="stylesheet" href="${wap_ct_url}css/idangerous.swiper.css">
	<script src="${wap_ct_url}js/jquery-1.11.1.min.js"></script>
	<script src="${wap_ct_url}js/carTreeInfo.js" charset="gbk"></script>
	<script src="${wap_ct_url}js/url.js"></script>
</head>
<body>
	<section class="wrapper">
		<header class="header">
			<a href="${wap_ct_url}" class="logo">车团网</a>
			<div class="header-search">
				<div class="search-relative">
					<form id="search_form" method="post" accept-charset="utf-8" action="/wapchetuan/wap_kanche">
						<input type="search" id="brand" name="keywords" class="search-input search_brand" placeholder="请输入关键词" autocomplete="off">
						<input type="button" style="cursor:pointer;" class="search-btn">
						<input type="hidden" name="price" value="${price!'不限'}">
						<input type="hidden" name="displa" value="${displa!'不限'}">
						<input type="hidden" name="level" value="${level!'不限'}">
					</form>
					<script>
						function search_form_submit(){
							var brand=$.trim($("#brand").val());
							if(brand==""){
								$(".search_brand").val("不限");
							}
							$("#search_form").submit();
						}
						$(function(){
							$(".search_brand").keydown(function(event){
								if(event.keyCode==13){
									search_form_submit();
								}
							});
							
							
							$(".search-btn").click(function(){
								search_form_submit();
							});
						});
					</script>
				</div>
			</div>
		</header>
		
		<#nested>
		
		
		<div class="m-bottom-search">
			<form method="post" accept-charset="utf-8" action="/wapchetuan/wap_kanche" id="search_form_foot">
			<div class="m-search-box">
				<div class="m-search-box-in">
					<input type="search" name="brand" id="search_foot" size="10">
					<input type="hidden" name="price" value="${price!'不限'}">
					<input type="hidden" name="displa" value="${displa!'不限'}">
					<input type="hidden" name="level" value="${level!'不限'}">
				</div>
			</div>
			<div class="m-btn-box"><input type="submit" id="search_sub"></div>
			<script>
				$(function(){
					$("#search_foot").keydown(function(event){
						if(event.keyCode==13){
							var brand=$.trim($("#search_foot").val());
							if(brand==""){
								$("#search_foot").val("不限");
							}
							$("#search_form_foot").submit();
						}
					});
					
					$("#search_sub").click(function(){
						var brand=$.trim($("#search_foot").val());
						if(brand==""){
							$("#search_foot").val("不限");
						}
						$("#search_form_foot").submit();
					});
				});
			</script>
			</form>
		</div>
		
		
		<footer class="footer">
			Copyright &copy; 2005-2020 车团网<br>备案号：沪ICP 备 05053107 号
		</footer>
		<nav class="bar bar-tab">
			<a href="${wap_ct_url}" class="tab-item">
				<span class="icon icon-home"></span>
				<span class="tab-label">首页</span>
			</a>
			<a href="${wap_ct_url}kanche/" class="tab-item">
				<span class="icon icon-car"></span>
				<span class="tab-label">看车团</span>
			</a>
			<a href="${wap_ct_url}temaihui/" class="tab-item">
				<span class="icon icon-ticket"></span>
				<span class="tab-label">特卖惠</span>
			</a>
			<a href="${wap_ct_url}shangjia/" class="tab-item">
				<span class="icon icon-store"></span>
				<span class="tab-label">经销商</span>
			</a>
		</nav>
	</section>
	<script src="${wap_ct_url}js/idangerous.swiper.min.js"></script>
	<script src="${wap_ct_url}js/global.js"></script>
</body>
</html>
</#macro>

<#macro wapnav nav = 0 carsid="">
<ul>
	<li <#if nav = 0>class="active"</#if>><a href="${wap_ct_url}kanche/series/series_${carsid}.html">车系</a></li>
	<li <#if nav = 1>class="active"</#if>><a href="${wap_ct_url}${carsid}/canshu.html">参数</a></li>
	<li <#if nav = 2>class="active"</#if>><a href="${wap_ct_url}${carsid}/shangjia.html">经销商</a></li>
	<li <#if nav = 3>class="active"</#if>><a href="${wap_ct_url}tuku/${carsid}/index.html">图片</a></li>
	<li <#if nav = 4>class="active"</#if>><a href="http://www.chetuan.com/wapchetuan/news_bySerie?serieid=${carsid}&page=1">资讯</a></li>
</ul>
</#macro>