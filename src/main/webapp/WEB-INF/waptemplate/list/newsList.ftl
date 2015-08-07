<#import "../common_wapchetuan.ftl" as cc>
<@cc.html >

<div class="top-nav">
	<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
	<h2>��³������</h2>
</div>

<div class="tags-first">
	<ul>
		<li><a href="#">��ϵ</a></li>
		<li><a href="#">����</a></li>
		<li><a href="#">������</a></li>
		<li><a href="#">ͼƬ</a></li>
		<li class="active"><a href="#">��Ѷ</a></li>
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
		<a href="#" class="btn-one btn-orange btn-arrow">������Ѷ</a>
	</div>
</div>

<script>

</script>
</@cc.html>