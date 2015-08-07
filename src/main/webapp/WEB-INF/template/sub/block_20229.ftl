var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 8>
str+='<dd class="car-pic-bg pic-240170">';
str+='<a href="${sub_data.url!}"><img src="${sub_data.photo!}"><span></span><p>${sub_data.title!}</p></a>';
str+='</dd>';
</#if>
</#list>
document.write(str);

							
								
								
								
								
							
						