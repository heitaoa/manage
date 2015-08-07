<#import "../common_wapchetuan.ftl" as cc>
<@cc.html >

<div class="top-nav">
	<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
	<h2>科鲁兹三厢</h2>
</div>

<div class="tags-first">
	<ul>
		<li><a href="#">车系</a></li>
		<li><a href="#">参数</a></li>
		<li><a href="#">经销商</a></li>
		<li><a href="#">图片</a></li>
		<li class="active"><a href="#">资讯</a></li>
	</ul>
</div>

<div class="car-news-out">
	<ul class="card-news">
	
		<#list newslist as news>
		<li>
			<a href="${wap_ct_url}wapnews/${news.newscatalogid}/page_${news.id}_1.html">
				<img src="img/newslist_car_demo.jpg" alt="">
				<h4><span>[${newCatalog.catalogname}]</span>${news.newstitle}</h4>
				<span class="time">${news.adddate?string("yyyy-MM-dd")}</span>
			</a>
		</li>
		</#list>
		
		
	</ul>

	<div class="wrap">
		<a href="#" class="btn-one btn-orange btn-arrow">更多资讯</a>
	</div>
</div>

<script>

</script>
</@cc.html>