var str='';
str+='<div class="adcbox adcbox-main clearfix">';
<#list param[0] as sub_data>
<#if sub_data_index == 0>
str+='<span><a href="javascript:void(0);" class="ad-360x50 ad-c-teal">${sub_data.title}</a></span>';
</#if>
<#if sub_data_index == 1>
str+='<span><a href="javascript:void(0);" class="ad-172x50 ad-c-blue">${sub_data.title}</a></span>';
</#if>
<#if sub_data_index == 2>
str+='<span class="sp-r"><a href="javascript:void(0);" class="ad-180x50 ad-c-purple">${sub_data.title}</a></span>';
</#if>
<#if sub_data_index == 3>
str+='<span><a href="javascript:void(0);" class="ad-180x50 ad-c-blue">${sub_data.title}</a></span>';
</#if>
<#if sub_data_index == 4>
str+='<span><a href="javascript:void(0);" class="ad-172x50 ad-c-purple">${sub_data.title}</a></span>';
</#if>
<#if sub_data_index == 5>
str+='<span class="sp-r"><a href="javascript:void(0);" class="ad-360x50 ad-c-teal">${sub_data.title}</a></span>';
</#if>
</#list>
str+='</div>';
document.write(str); 
