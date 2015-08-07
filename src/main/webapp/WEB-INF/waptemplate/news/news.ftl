<#import "../common_wapchetuan.ftl" as cc>
<@cc.html >

<div class="top-nav">
	<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
	<h2>新闻正文</h2>
	<a id="share" href="javascript:toogleShare();" class="news-share">
		<i class="iconfont share">&#xe606;</i>
	</a>
</div>

<article>
	<div class="news-detail-top">
		<h1>${news.newstitle!}</h1>
		<p class="news-post">车团 | <time>${news.adddate?string("yyyy-MM-dd日 HH:mm")}</time>  |   <span class="author">评论：<a href="#">车雄</a></span></p>
	</div>

	<div class="news-detail-con">
		 ${(contentStr)!}
		
		<div class="news-pagination">
			<a href="${wap_ct_url}wapnews/${news.newscatalogid}/page_${news.id}_<#if page lte 1>1<#else>${page-1}</#if>.html" class="iconfont prev">&#xe600;</a>
			<h2><span class="cur">${page}</span>/<span class="num">${pageSize}页</span></h2>
			<a href="${wap_ct_url}wapnews/${news.newscatalogid}/page_${news.id}_<#if page gte pageSize>${pageSize}<#else>${page+1}</#if>.html" class="iconfont next">&#xe604;</a>
		</div>
	</div>
</article>

<div class="rele-news-col">
	<h2>相关新闻</h2>
	<!--<a href="${wap_ct_url}waplist/729/list_1.html">更多>></a>-->
</div>
<div class="rele-news-list">
<#if relatedList??>
	<ul>
		<#list relatedList as related>
		<li><a href="${related.url}">${related.title} </a></li>
		</#list>
	</ul>
</#if>

<!--
	<div class="wrap">
		<a href="${wap_ct_url}waplist/729/list_1.html" class="btn-one btn-orange btn-arrow">更多资讯</a>
	</div>
-->

</div>

<script>

</script>
</@cc.html>