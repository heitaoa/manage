var str='';
str+='			<ul class="article-list" id="ui_wqts">	';
<#list param[0] as sub_data>
<#if sub_data_index lt 3>
str+='				<li>	';
str+='					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	';
str+='					<div class="body">	';
str+='						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	';
<#if sub_data.content?length lt 100>
str+='						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>����������Ҫ��˸߶˵ĳ���֮���䡣</#if><a target="_blank" class="more" href="${sub_data.link}">����ϸ��</a></p>	';
<#else>
str+='						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>����������Ҫ��˸߶˵ĳ���֮���䡣</#if><a target="_blank" class="more" href="${sub_data.link}">����ϸ��</a></p>	';
</#if>
<!--str+='						<span class="keyword">�ؼ��ʣ�	';-->
<!--str+='							<a href="${sub_data.link}">Ӣ�׷�</a>	';-->
<!--str+='							<a href="${sub_data.link}">����750</a>	';-->
<!--str+='						</span>	';-->
str+='						<div class="share"><div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="����QQ�ռ�"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="��������΢��"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="������Ѷ΢��"></a><a href="#" class="bds_renren" data-cmd="renren" title="����������"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="����΢��"></a></div></div>	';
str+='					</div>	';
str+='				</li <#if sub_data_index == 2>class="last"</#if> >	';
</#if>
</#list>
str+='			</ul>	';
str+='		<div class="article-more"><a onclick="getWqhgAdd(5329)">�鿴�������� &rsaquo;&rsaquo;</a></div>	';
document.write(str);
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"������","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];