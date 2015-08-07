var str='';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 6>
str+='<li>';
str+='<div class="pic"><a href="${sub_data.link}" title=""><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>';
str+='<div class="info"><p class="title"><a href="${sub_data.link}">${sub_data.title}</a></p><p class="price">${sub_data.color}</p></div>';
str+='</li>';
</#if>
</#list>
str+='</ul>';
document.write(str);