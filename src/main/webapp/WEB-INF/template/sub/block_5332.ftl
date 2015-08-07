var str='';
str+='	<ul class="group-focus-slider"> ';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
str+='		<li><a href="${sub_data.link}" target="_blank"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></li>	';
</#if>
</#list>
str+='	</ul>	';

document.write(str);