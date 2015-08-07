var str='';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='<li>';
str+='<p class="pic-top"><a href="${sub_data.link}" target="_blank" title=""><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="" /></a></p>';
str+='<p class="title-bottom"><a href="${sub_data.link}" target="_blank" title="">${sub_data.title}</a></p>';
str+='</li>';
</#if>
</#list>
str+='</ul>';
document.write(str);