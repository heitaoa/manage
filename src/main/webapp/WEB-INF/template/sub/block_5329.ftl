var str='';
str+='			<ul class="article-list" id="ui_wqts">	';
<#list param[0] as sub_data>
<#if sub_data_index lt 3>
str+='				<li>	';
str+='					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	';
str+='					<div class="body">	';
str+='						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	';
<#if sub_data.content?length lt 100>
str+='						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	';
<#else>
str+='						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	';
</#if>
<!--str+='						<span class="keyword">关键词：	';-->
<!--str+='							<a href="${sub_data.link}">英伦范</a>	';-->
<!--str+='							<a href="${sub_data.link}">荣威750</a>	';-->
<!--str+='						</span>	';-->
str+='						<div class="share"><div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div></div>	';
str+='					</div>	';
str+='				</li <#if sub_data_index == 2>class="last"</#if> >	';
</#if>
</#list>
str+='			</ul>	';
str+='		<div class="article-more"><a onclick="getWqhgAdd(5329)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	';
document.write(str);
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];