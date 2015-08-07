var str='<ul class="group-focus-slider">';
<#list param[0] as sub_data>
str+='<li><img src="${sub_data.pic}" alt=""></li>';
</#list>
str+='</ul>';
document.write(str);