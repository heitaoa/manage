var str='';
<#list param[0] as sub_data>
<#if sub_data_index lt 6>
str+='<tr>';
str+='<td class="car-name">${sub_data.title}</td>';
str+='<td><span class="price">${sub_data.ctitle}</span></td>';
str+='<td>${sub_data.color}</td>';
str+='<td>${sub_data.content}</td>';
str+='<td><a href="${sub_data.link}">¸ü¶à&rsaquo;&rsaquo;</a></td>';
str+='</tr>';
</#if>
</#list>
document.write(str);


								
								
								
								
								
						