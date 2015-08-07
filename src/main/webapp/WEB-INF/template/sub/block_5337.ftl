var str='';
str+='	<div class="item">	';
str+='		<div class="title-bar">	';
str+='			<h2>社区公告 &rsaquo;&rsaquo;</h2>	';
str+='			<span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-8.aspx">更多 &rsaquo;&rsaquo;</a></span>	';
str+='		</div>	';
str+='		<div class="con">	';
str+='			<ul class="img-list">	';
<#list param[0] as sub_data>
str+='				<li>	';
str+='					<a target="_blank" href="${sub_data.link}">	';
str+='						<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt=""></div>	';
<#if (sub_data.title??&&(sub_data.title.length()>10))>
str+='						<p class="title">${sub_data.title[0..10]}</p>	';
<#else>
str+='						<p class="title">${(sub_data.title)!}</p>	';
</#if>
str+='					</a>	';
str+='				</li>	';
</#list>
str+='			</ul>	';
str+='		</div>	';
str+='	</div>	';
document.write(str);