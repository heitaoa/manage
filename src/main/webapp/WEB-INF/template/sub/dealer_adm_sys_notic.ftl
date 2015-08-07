var str='';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 1>
str+='${sub_data.content}';
</#if>
</#list>
str+='</ul>';
document.write(str);


