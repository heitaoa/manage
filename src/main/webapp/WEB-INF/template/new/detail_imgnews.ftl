<#import "../common.ftl" as cc>

<@cc.html_top title="${(news.newstitle)?replace('&nbsp',' ')}【图】_中国汽车消费网" keywords="${(news.newskeywords)?replace('&nbsp',',')}" description="${(news.description)?replace('&nbsp',' ')}" 
	mobileMeta="<meta http-equiv='mobile-agent' content='format=html5; url=http://i.315che.com/news/${dateFormatMethod(news.adddate,'yyyyMM')}/${news.id}_${contentPage-1}.htm' />">
<!--主内容开始-->
	<div class="content">
		
		<div class="breadcrumb-nav ma-b10">
			<p>您现在的位置：<a href="${che_url}">首页</a> &#62; <a href="${che_url}imgnews/">以图识文</a>  &#62;  <a href="javascript:void(0);" class="current">正文</a></p>
		</div>
		<div class="row">
			<div class="pic-news-content">
				<div class="large-bg">
					<div class="pic"><img src="${imageFormat(newsContent.titleimgpath,860, 417)}"></div>
					<#if contentPages gt 1>
					<div class="control">
						<#if contentPage gt 1>
						<a href="${inf_che_url}n/${dateFormatMethod(news.adddate, "yyyy_MM")}/${news.id}/${contentPage-1}.htm" class="prev"></a>
						</#if>
						<#if contentPage lt contentPages>
						<a href="${inf_che_url}n/${dateFormatMethod(news.adddate, "yyyy_MM")}/${news.id}/${contentPage+1}.htm" class="next"></a>
						</#if>
					</div>
					</#if>
				</div>
				<div class="share-bar">分享到：</div>
				<h3>${newsContent.newstitle}</h3>
				<p><#if newsContent.newscontent?? && newsContent.newscontent != "null">${newsContent.newscontent}</#if></p>
				
				<#if editor??>
				<div class="author">by
					<a href="${che_url}news/u/${editor.id + 50854}.htm">${editor.realname}</a>
				</div>
				</#if> 
				
				<div class="thumb-wrap">
					<div class="thumb-bg">
						<div class="thumb-pic clearfix">
							<ul>
								<#list contentList as con>
								<#if con.titleimgpath?? && con.titleimgpath.length() gt 3>
								<li <#if newsContent.id == con.id>class="active"</#if> >
								<a href="${inf_che_url}n/${dateFormatMethod(news.adddate, "yyyy_MM")}/${news.id}/${con_index+1}.htm"><img src="${imageFormat(con.titleimgpath,162, 98)}" alt=""></a>
								</li>
								</#if>
								</#list>
							</ul>
						</div>
					</div>
					<div class="control">
						<a href="javascript:void(0);" class="prev"></a>
						<a href="javascript:void(0);" class="next"></a>
					</div>
				</div>
			</div>
		</div>
		<div class="row ma-t20 clearfix">
			<div class="car-article">
				<!-- 评论 -->
				<@cc.comment_html />
			</div>
			
			<#if newsRelatedList?? && newsRelatedList.size() gt 0>
			<div class="side">
				<div class="side-list">
					<div class="title-box">
						<h2><a href="#">猜你喜欢</a></h2>
					</div>
					<ul class="side-article-list">
						<#list newsRelatedList as related>
						<li>
							<a href="${related.url}">
								<div class="article-pic"><img src="${che_url}images/article_pic_demo.jpg"></div>
								<h4>${related.title}</h4>
								<div class="time">2014-11-03 </div>
								<p>近日，我们从哈弗官方获悉，哈弗H1车型正式上市。新车共推出了六款车型，售价区间为6.89万-8.29万元。目前，哈弗H1实车已到店并接受预定。 哈弗H1官方指导价 ...</p>
							</a>
						</li>
						</#list>
					</ul>
				</div>
				<div class="side-ad"><a href="#"><img src="${che_url}images/sidebar_ad_demo.jpg" alt=""></a></div>
			</div>
			</#if>
			
		</div>
		
		<@cc.html_footer/>
	</div>
	<!--主内容结束-->
</@cc.html_top>
<@cc.html_bottom>
	<@cc.comment_js type = 1 catalogid = "${news.id}" posturl="${inf_che_url}"/>
	
</@cc.html_bottom>