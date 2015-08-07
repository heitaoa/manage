var str='';
<#list param[0] as sub_data>
<#if sub_data_index == (param[0])?size -1>
str+='<a href="${www_ct_url}chetuan/toGroupon?v=${ver}" class="more">${sub_data.title}&rsaquo;&rsaquo;</a>';
<#else>
str+='<a href="${sub_data.link}">${sub_data.title}</a>';
</#if>
</#list>
document.write(str);
