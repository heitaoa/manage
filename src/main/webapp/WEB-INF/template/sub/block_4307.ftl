var str='';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='<li>';
str+='<p class="pic-top"><a target="_blank" href="${sub_data.link}" title="${sub_data.title}"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="${sub_data.title}" /></a></p>';
str+='<p class="title-bottom"><a target="_blank" href="${sub_data.link}" title="">${sub_data.title}</a></p>';
str+='</li>';
</#if>
</#list>
str+='</ul>';
document.write(str);


