<#import "blockcommon.ftl" as bc>
var str='';
str+='<div class="m-focus m0">';
str+='	 <div class="m-focus-box">';
str+='		 <div id="m-focus-box" class="m-focus-scroll-box swiper-container">';
str+='          <ul class="swiper-wrapper">';
<#list param[0] as sub_data>
<#if sub_data_index < 3>
str+='              <li class="swiper-slide">';
str+='                 <a href="${sub_data.link?replace('pic','pic.m')}">';
str+='                    <img src="${imageFormat(sub_data.pic,640,340)}" alt="">';
str+='                    <div class="mask"></div>';
str+='                    </a>';
str+='                    </li>';
</#if>
</#list>
str+='          </ul>';
str+='          <div class="pagination-focus"></div>';
str+='		</div>';
str+='	</div>';
str+='</div>';
document.write(str);

