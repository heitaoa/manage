var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 1>
str+='<div class="side-ad">';
str+='<a href="${sub_data.link}">';
str+='<img src="${sub_data.pic!}">';
str+='</a>';
str+='</div>';
</#if>
</#list>
document.write(str);

