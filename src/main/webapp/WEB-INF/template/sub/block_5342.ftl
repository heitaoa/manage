var str='';
str+='	<div class="item">	';
str+='		<div class="title-bar">	';
str+='			<h2>自驾游 &rsaquo;&rsaquo;</h2>	';
str+='			<span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-6.aspx">更多 &rsaquo;&rsaquo;</a></span>	';
str+='		</div>	';
str+='		<div class="con">	';
str+='			<ul class="img-list">	';
<#list param[0] as sub_data>
str+='				<li>	';
str+='					<a target="_blank" href="${sub_data.link}">	';
str+='						<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt=""></div>	';
str+='						<p class="title">${sub_data.title}</p>	';
str+='					</a>	';
str+='				</li>	';
</#list>
str+='			</ul>	';
str+='		</div>	';
str+='	</div>	';
document.write(str);