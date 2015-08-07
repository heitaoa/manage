<#import "blockcommon.ftl" as bc>
var str='';
str+='<div class="row clearfix">';
str+='	<div class="focus-box">';
str+='		<dl class="focus-treebox-con">';
str+='          <dt class="car-pic-bg pic-left pic-450310">';
str+='          	<div id="tree-focus-bxslider">';
<#list param[0] as sub_data>
<#if sub_data_index < 3>
str+='          	<li><a href="${sub_data.link}" target="_blank"><img src="${imageFormat(sub_data.pic,450,310)}"></a></li>';
</#if>
</#list>
str+='          	</div>';
str+='          </dt>';
<#list param[0] as sub_data>
<#if 2 < sub_data_index && sub_data_index < 5 >
str+='<dt class="car-pic-bg pic-260150"><a href="${sub_data.link}" target="_blank"><img src="${imageFormat(sub_data.pic,260,150)}"></a></dt>';
</#if>
</#list>
str+='		</dl>';
str+='	</div>';
str+='</div>';
document.write(str);

