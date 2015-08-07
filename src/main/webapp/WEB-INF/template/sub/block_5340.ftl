var str='';
<#list param[0] as sub_data>
str+='<a href="${sub_data.link}">${sub_data.title}</a>';
</#list>
document.write(str);
