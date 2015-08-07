var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 1>
str+='<dt class="car-pic-bg pic-left pic-450318">';
str+='<a href="${sub_data.link}">';
str+='<img src="${sub_data.pic!}">';
str+='<span></span><p>${sub_data.title!}</p>';
str+='<span class="time">${sub_data.ctitle!}</span>';
str+='</a>';
str+='</dt>';
</#if>
</#list>
document.write(str);



