var str='<ul>';
<#list param[0] as sub_data>
<#if (sub_data_index < 6) >
str+='<li class="item">                                                                           ';
str+='	<div class="pic-wrapper">                                                                 ';
str+='		<a href="${kan_ct_url}chetuan/${sub_data.color}/" target="_blank">                                                                             ';
str+='			<div class="pic-inner">                                                              ';
str+='				<img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="">                    ';
str+='				<span class="glass"></span>                                                                 ';
str+='					<div class="logo"><img width="35px" src="${sub_data.clink}" alt=""></div>          ';
str+='					<p class="title">¡¾${sub_data.link_back}¡¿</p>                                    ';
str+='			</div>                                                                               ';
str+='		</a>                                                                                    ';
str+='	</div>                                                                                    ';
str+='	<div class="info">                                                                        ';
str+='		<h3><a href="${kan_ct_url}chetuan/${sub_data.color}/" target="_blank">${sub_data.title}</a></h3>';
str+='${sub_data.content}';
str+='		<div class="sign">                                                                      ';
str+='			½öÊ£<b>${sub_data.ctitle}</b>Ì¨<a class="go" href="${sub_data.link}">È¥ÇÀ¹º</a>                                    ';
str+='		</div>                                                                                  ';
str+='	</div>                                                                                    ';
str+='</li>             																			';
</#if>
</#list>
str+='</ul>';
document.write(str);
