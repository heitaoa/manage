var str='';
str+='<ul>';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='<li>';
str+='<p class="pic-top"><a target="_blank" href="${sub_data.link}" title="${sub_data.title}"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="${sub_data.title}" /></a></p>';
str+='<p class="title"><a target="_blank" href="${sub_data.link}" title=""> ${sub_data.title}</a></p>';
str+='<p class="price F60 font12">${sub_data.content}</p>';
str+=' <p class="links">';
 
<#list sub_data.ctitle?split("$") as ctit> 
<#if sub_data.clink?split("$")[ctit_index]??>
str+='<a target="_blank" href=\"${sub_data.clink?split("$")[ctit_index]}\" title="">';
<#else>
str+='<a target="_blank" href="" title="">';
</#if>
str+='${ctit}</a>&#124;';
</#list>

str+='</p>';
str+='</li>';
</#if>
</#list>
str+='</ul>';
document.write(str);



                            
                            
                            