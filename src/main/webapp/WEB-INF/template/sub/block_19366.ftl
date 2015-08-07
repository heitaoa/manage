var str='';

<#list param[0] as sub_data>
<#if sub_data_index lt 1>
str+='<h2 class="xiaopangtg-title"><a href="${sub_data.link}">${sub_data.title}</a></h2>';
</#if>
</#list>
document.write(str);