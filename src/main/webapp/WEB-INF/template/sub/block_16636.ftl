var str='';
str+='<div class="car-pic-list tab-content-item">';
str+='        <ul class="clearfix">';
<#list param[0] as sub_data>
<#if sub_data_index < 9>
str+='                    <li>';
str+='                        <a href="#">';
str+='                        <div class="pic"><img width="233" height="155" src="${imageFormat(sub_data.pic,300,200)}" alt=""></div>';
str+='                        <div class="name">${sub_data.title}</div>';
str+='                        </a>';
str+='                    </li>';
</#if>
</#list>
str+='            </ul>    ';
str+='        </div>    ';
document.write(str); 