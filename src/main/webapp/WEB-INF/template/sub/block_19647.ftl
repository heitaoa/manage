var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='<ul class="article-list">';
str+='<li>';
str+='<div class="pic"><a href="${sub_data.link}"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>';
str+='<div class="body">';
str+='<h3 class="title"><a href="${sub_data.link}">${sub_data.title}</a></h3>';
str+='<p class="desc">${sub_data.content}<a class="more" href="${sub_data.link}">����ϸ��</a></p>';
str+='<div class="share"><div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="������QQ�ռ�"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="����������΢��"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="��������Ѷ΢��"></a><a href="#" class="bds_renren" data-cmd="renren" title="������������"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="������΢��"></a></div>';
str+='</div>';
str+='</li>';
str+='</ul>';
</#if>
</#list>
document.write(str);
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"��������","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];