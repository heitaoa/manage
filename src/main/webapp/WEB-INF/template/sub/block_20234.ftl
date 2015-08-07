var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='<dd class="car-pic-bg pic-middle pic-260154">';
str+='<a href="${sub_data.link}">';
str+='<img src="${sub_data.pic!}">';
str+='<span></span><p>${sub_data.title!}</p>';
str+='<span class="time">${sub_data.ctitle!}</span>';
str+='</a>';
str+='</dd>';
</#if>
</#list>															
document.write(str);

