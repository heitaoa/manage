var str='';
str+='	<div class="events">	';
str+='	<h2 class="title"><i></i>精彩活动<span class="ora-line"></span>';
str+='  <span class="more"><a target="_blank" href="${www_ct_url}list/728/list_1.html">更多 &rsaquo;&rsaquo;</a></span>';
str+='</h2>	';
str+='	<div class="con">	';
str+='	<ul class="clearfix">	';
<#list param[0] as sub_data>
<#if sub_data_index lt 4>
		str+='	<li>	';
		str+='		<a target="_blank" href="${sub_data.link}">	';
		str+='			<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="" href="${sub_data.link}" style="height: 117px; width: 190px;"></div>';
		str+='			<p href="${sub_data.link}">${sub_data.title}</p>	';
		str+='		</a>	';
		str+='	</li>	';
</#if>
</#list>
str+='	</ul>	';
str+='	</div>	';
str+='	</div>	';
document.write(str);