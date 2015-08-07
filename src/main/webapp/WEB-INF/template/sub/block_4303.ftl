var str='';
str+='<fieldset>';
str+='<legend><strong>[ÍÆ¼öĞÂÎÅ]</strong></legend>';
str+='<div id="pictures-news">';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 5>
str+='<li><div><a href="${sub_data.link}" title="1" target="_blank"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="" /></a></div></li>';
</#if>
</#list>
str+='</ul>';
str+='</div>';
str+=' <ul class="news-list">';
<#list param[0] as sub_data>
<#if sub_data_index gt 4 && sub_data_index lt 13>
str+='<li><em class="point"></em><em>[<a class="gray" href="${sub_data.clink}" title="" target="_blank">${sub_data.ctitle}</a>] </em><a class="title" href="${sub_data.link}" target="_blank" title="${sub_data.title}">${sub_data.title}</a></li>';
</#if>
</#list>
str+='</ul>';
str+='</fieldset>';
document.write(str);




