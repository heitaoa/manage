var str='';
str+='<div class="row">';
str+='	<div class="title-box">';
str+='		<h2><a href="javascript:void(0);">热门车系</a></h2>';
str+='	</div>';
str+='	<div class="car-hot-line">';
str+='		<ul class="clearfix">';
<#list param[0] as sub_data>
<#if sub_data_index < 24>
str+='			<li><a href="javascript:void(0);">${sub_data.title}</a></li>';
</#if>
</#list>
str+='		</ul>';
str+='	</div>';
str+='</div>';
document.write(str); 
