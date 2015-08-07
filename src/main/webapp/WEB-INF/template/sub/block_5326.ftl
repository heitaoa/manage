var str='<h2 class="title">';
<#list param[0] as sub_data>
<#if sub_data_index = 0>
str+='<i></i>乐活社区<span class="ora-line"></span><span class="more"><a href="${sub_data.link!}">${sub_data.title!"更多"}&rsaquo;&rsaquo;</a></span>';
</#if>
</#list>
var str='</h2>';
var str='<div class="con">';
var str='<dl>';
var str='<dt>';
<#list param[0] as sub_data>
<#if sub_data_index = 1>
var str='<div class="pic"><img src="${sub_data.pic!}" alt=""></div>';
var str='<div class="article">';
var str='<h5>${sub_data.title!}</h5>';
var str='<p>${sub_data.content!}<a class="more" href="${sub_data.link!}">[详细]</a></p>';
</#if>
</#list>
var str='</div>';
var str='</dt>';
<#list param[0] as sub_data>
<#if sub_data_index = 1>
var str='<dd><a href="${sub_data.link!}"><img src="${sub_data.pic!}" alt="${sub_data.title!}"></a></dd>';
</#if>
</#list>
var str='</dl>';
var str='</div>';
document.write(str);
