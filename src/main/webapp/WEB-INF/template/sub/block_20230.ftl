var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 5>
str+='<li class="nth-child-first">';
str+='<a href="${sub_data.link}">';
str+='<img src="${sub_data.photo!}">';
str+='<div class="title">${sub_data.title!}</div>';
str+='<span class="time">${sub_data.ctitle!}</span>';
str+='</a>';
str+='</li>';
</#if>
</#list>
document.write(str);

