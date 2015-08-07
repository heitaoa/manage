<#import "../common_chetuan.ftl" as cc>
<@cc.ctnews_html 1, newCatalog.catalogname>
	<div class="car-model-ui car-model-o">
		<div class="mod-hd">
			<ul class="position">
				<a href="${www_ct_url}">车团</a>&gt;<a class="active">新闻中心</a>&gt;<a href="${www_ct_url}list/${newCatalog.catalogid}/list_1.html">${(newCatalog.catalogname)!}</a>&gt;<a class="active">正文</a>
			</ul>
			<!---
			<div class="mod-con">
				<div class="brand">
					<div class="logo"><img src="${www_ct_url}images/auto_logo_pic-01.png" alt=""></div>
					<h2>荣威750</h2>
				</div>
				<div class="nav">
					<ul>
						<li><a href="javascript:void(0);">车系</a></li>
						<li><a href="javascript:void(0);">参数配置</a></li>
						<li><a href="javascript:void(0);">经销商</a></li>
						<li><a href="javascript:void(0);">活动</a></li>
						<li><a href="javascript:void(0);">图片</a></li>
						<li class="active"><a href="javascript:void(0);">资讯</a></li>
					</ul>
				</div>
			</div>
			-->
		</div>
	</div>
	<div class="news-wrapper clearfix">
		<div class="left">

			
			<div class="articlepage">
				<ul class="list">
					<#list newslist as news>
				    <li>
				        <span class="cat">[<a href="${www_ct_url}list/${newCatalog.catalogid}/list_1.html" target="_blank">${newCatalog.catalogname}</a>]</span>
				        <a class="link" href="${www_ct_url}new/${news.newscatalogid}/page_${news.id}_1.html" target="_blank">${news.newstitle}</a>
				        <span class="date">${news.adddate?string("yyyy年MM月dd日")}</span>
				        <!--
				        <span class="source">来源：${news.newseditor!"未知"} </span>
				        -->
				    </li>
				  	</#list>
				</ul>
				<div class="pages">
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_1.html">首页</a>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_<#if page gt 1>${page-1}<#else>1</#if>.html">上一页</a>
				    <#assign start=1, end=pages>
				    <#if page gt 3> <#assign start=page-3/> </#if>
				    <#if start+7 lt pages> <#assign end=start+7/> </#if>
				    <#list start..end as i>
				    <a <#if i == page>class="current"</#if> href="${www_ct_url}list/${newCatalog.catalogid}/list_${i}.html">${i}</a>
				    </#list>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_<#if page lt pages>${page+1}<#else>${pages}</#if>.html">下一页</a>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_${pages}.html">末页</a>
				</div>
			</div>
	    </div>
	    
	    
	    <div class="right">
	    	<div class="app-downloads">
	        	<a href="#" title=""><img src="${www_ct_url}images/download.jpg" alt="" /></a>
	        </div>
	        <div class="column">
	        	<h2>精彩活动</h2>
	            <a class="more" target="_blank" href="${www_ct_url}list/729/list_1.html" title="">更多&gt;&gt;</a>
	        </div>
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4304.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_19367.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_4305.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>乐活社区</h2>
	            <a class="more" target="_blank" href="http://bbs.chetuan.com/showforum-4.aspx" title="">更多&gt;&gt;</a>
	        </div>
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4306.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>维权投诉</h2>
	            <a class="more" target="_blank" href="http://tousu.315che.com/" title="">更多&gt;&gt;</a>
	        </div> 
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4307.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_19366.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_4308.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>热门车推荐</h2>
	            <a class="more" target="_blank" href="${www_ct_url}chetuan/toGroupon" title="">更多&gt;&gt;</a>
	        </div>
	        <div class="hto-car-list">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4309.js?v=${ver}"></script>
	        </div>
	    </div>
	    
	    
	</div>
	<@cc.img_url_js/>
	
<#if pages gt 1>
	<script>
	<!-- 键盘翻页	-->
	$(document).ready(
		function(){
		
			var page = ${page};
			var pagesize = ${pages};
			 var ie;
			 var firefox;
			 
			 if (document.all) ie = true; else ie = false; //判断是否IE
			
			 document.onkeydown = KeyPress;
			//设置键盘事件函数
			
			function KeyPress(){
			  var key;
			   if (ie) key = event.keyCode;
			//Ie使用event.keyCode获取键盘码
			  else
			   key = KeyPress.arguments[0].keyCode;
			//FireFox使用我们定义的键盘函数的arguments[0].keyCode来获取键盘码
			  //alert(key);
			  
			  if(page < 1) page =1;
			  if(page > pagesize) page = pagesize;
			  	  
			  //上一页
			  if(key == 37 && page > 1)
			  	window.location.href="${www_ct_url}list/${newCatalog.catalogid}/list_"+(--page)+".html";
				//alert(--page);
			  
			  //下一页
			  if(key == 39 && page < pagesize)
			  	window.location.href="${www_ct_url}list/${newCatalog.catalogid}/list_"+(++page)+".html";
				//alert(++page);
			 }
			 
		}
	);
	
	
	</script>
</#if>
</@cc.ctnews_html>
