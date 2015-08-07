var str='';
str+='<div class="gallery-style01">';
str+='        <h2 class="title"><i></i>新车上市<span class="ora-line"></span></h2>    ';
str+='        <div class="con">    ';
str+='            <ul class="news-car-slider">    ';

<#list param[0] as sub_data>
<#if sub_data_index%5 = 0>
str+='                <li>';
</#if>
<#if sub_data_index%5 = 0>
str+='                    <dl class="head">';
str+='                        <dd><a href="javascript:openCarImageDetail('+${sub_data.content}+')"><img src="${FormatImgX(sub_data.pic,343, 247)}" alt=""></a></dd>';
str+='                        <dt><a href="javascript:openCarImageDetail('+${sub_data.content}+')">${sub_data.title}</a></dt>';
str+='                    </dl>';
<#else>
str+='                    <dl >';
str+='                        <dd><a href="javascript:openCarImageDetail('+${sub_data.content}+')"><img src="${FormatImgX(sub_data.pic,160, 106)}" alt=""></a></dd>';
str+='                        <dt><a href="javascript:openCarImageDetail('+${sub_data.content}+')">${sub_data.title}</a></dt>';
str+='                    </dl>';
</#if>
<#if (sub_data_index+1)%5 = 0>
str+='                </li>    ';
</#if>
</#list>
str+='            </ul>    ';
str+='        </div>    ';
str+='    </div>    ';
document.write(str);     