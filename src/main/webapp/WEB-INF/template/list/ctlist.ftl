<#import "../common_chetuan.ftl" as cc>
<@cc.ctnews_html 1, newCatalog.catalogname>
	<div class="car-model-ui car-model-o">
		<div class="mod-hd">
			<ul class="position">
				<a href="${www_ct_url}">����</a>&gt;<a class="active">��������</a>&gt;<a href="${www_ct_url}list/${newCatalog.catalogid}/list_1.html">${(newCatalog.catalogname)!}</a>&gt;<a class="active">����</a>
			</ul>
			<!---
			<div class="mod-con">
				<div class="brand">
					<div class="logo"><img src="${www_ct_url}images/auto_logo_pic-01.png" alt=""></div>
					<h2>����750</h2>
				</div>
				<div class="nav">
					<ul>
						<li><a href="javascript:void(0);">��ϵ</a></li>
						<li><a href="javascript:void(0);">��������</a></li>
						<li><a href="javascript:void(0);">������</a></li>
						<li><a href="javascript:void(0);">�</a></li>
						<li><a href="javascript:void(0);">ͼƬ</a></li>
						<li class="active"><a href="javascript:void(0);">��Ѷ</a></li>
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
				        <span class="date">${news.adddate?string("yyyy��MM��dd��")}</span>
				        <!--
				        <span class="source">��Դ��${news.newseditor!"δ֪"} </span>
				        -->
				    </li>
				  	</#list>
				</ul>
				<div class="pages">
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_1.html">��ҳ</a>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_<#if page gt 1>${page-1}<#else>1</#if>.html">��һҳ</a>
				    <#assign start=1, end=pages>
				    <#if page gt 3> <#assign start=page-3/> </#if>
				    <#if start+7 lt pages> <#assign end=start+7/> </#if>
				    <#list start..end as i>
				    <a <#if i == page>class="current"</#if> href="${www_ct_url}list/${newCatalog.catalogid}/list_${i}.html">${i}</a>
				    </#list>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_<#if page lt pages>${page+1}<#else>${pages}</#if>.html">��һҳ</a>
				    <a href="${www_ct_url}list/${newCatalog.catalogid}/list_${pages}.html">ĩҳ</a>
				</div>
			</div>
	    </div>
	    
	    
	    <div class="right">
	    	<div class="app-downloads">
	        	<a href="#" title=""><img src="${www_ct_url}images/download.jpg" alt="" /></a>
	        </div>
	        <div class="column">
	        	<h2>���ʻ</h2>
	            <a class="more" target="_blank" href="${www_ct_url}list/729/list_1.html" title="">����&gt;&gt;</a>
	        </div>
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4304.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_19367.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_4305.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>�ֻ�����</h2>
	            <a class="more" target="_blank" href="http://bbs.chetuan.com/showforum-4.aspx" title="">����&gt;&gt;</a>
	        </div>
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4306.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>άȨͶ��</h2>
	            <a class="more" target="_blank" href="http://tousu.315che.com/" title="">����&gt;&gt;</a>
	        </div> 
	        <div class="info-list clearfix">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4307.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_19366.js?v=${ver}"></script>
	            <script type="text/javascript" src="${www_ct_url}sub/block_4308.js?v=${ver}"></script>
	        </div>
	        <div class="column">
	        	<h2>���ų��Ƽ�</h2>
	            <a class="more" target="_blank" href="${www_ct_url}chetuan/toGroupon" title="">����&gt;&gt;</a>
	        </div>
	        <div class="hto-car-list">
	        	<script type="text/javascript" src="${www_ct_url}sub/block_4309.js?v=${ver}"></script>
	        </div>
	    </div>
	    
	    
	</div>
	<@cc.img_url_js/>
	
<#if pages gt 1>
	<script>
	<!-- ���̷�ҳ	-->
	$(document).ready(
		function(){
		
			var page = ${page};
			var pagesize = ${pages};
			 var ie;
			 var firefox;
			 
			 if (document.all) ie = true; else ie = false; //�ж��Ƿ�IE
			
			 document.onkeydown = KeyPress;
			//���ü����¼�����
			
			function KeyPress(){
			  var key;
			   if (ie) key = event.keyCode;
			//Ieʹ��event.keyCode��ȡ������
			  else
			   key = KeyPress.arguments[0].keyCode;
			//FireFoxʹ�����Ƕ���ļ��̺�����arguments[0].keyCode����ȡ������
			  //alert(key);
			  
			  if(page < 1) page =1;
			  if(page > pagesize) page = pagesize;
			  	  
			  //��һҳ
			  if(key == 37 && page > 1)
			  	window.location.href="${www_ct_url}list/${newCatalog.catalogid}/list_"+(--page)+".html";
				//alert(--page);
			  
			  //��һҳ
			  if(key == 39 && page < pagesize)
			  	window.location.href="${www_ct_url}list/${newCatalog.catalogid}/list_"+(++page)+".html";
				//alert(++page);
			 }
			 
		}
	);
	
	
	</script>
</#if>
</@cc.ctnews_html>
