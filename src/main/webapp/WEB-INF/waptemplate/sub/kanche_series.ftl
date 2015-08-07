<#import "../common_wapchetuan.ftl" as c />
<@c.html>
	<div class="top-nav">
		<a href="javascript:void(0);" id="goback" class="iconfont goback">&#xe600;</a>
		<h2>${series['catalogname']}</h2>
		
		<script>
			//$(function(){
			//	var referrer=document.referrer;
			//	//http://m.chetuan.com/kanche/list-0--0--0--85--hot.html
			//	if(referrer!=null&&referrer.length>=20){
			//		if(referrer.substring(0,20)=="http://m.chetuan.com"){
			//			$("#goback").attr("href",referrer);
			//		}
			//	}
			//});
		</script>
	</div>

	<div class="tags-first">
		<@c.wapnav carsid="${series['catalogid']}">
		</@c.wapnav>
	</div>

	<div class="sum-car-img">
		<a href="${wap_ct_url}tuku/${series['catalogid']}/imginside---${(img_mid)!}---1.html?num=1" class="left-area">
			<img src="${(img_wg)!}" alt="">
			<em>外观</em>
		</a>
		<div class="right-area">
			<a href="${wap_ct_url}tuku/${series['catalogid']}/imginside---${(img_mid)!}---1.html?num=1" class="img-box">
				<img src="${(img_ns)!}">
				<em>内饰</em>
			</a>
			<a href="${wap_ct_url}tuku/${series['catalogid']}/imginside---${(img_mid)!}---1.html?num=1" class="img-box">
				<img src="${(img_zk)!}">
				<em>中控</em>
			</a>
		</div>
	</div>
	
	<div class="wrap-out">
		<h1 class="car-name">${series['catalogname']}</h1>
		<div class="wrap">
			<ul class="car-info-list clearfix">
				<li>
					<label>厂商指导价：</label>
					<span><#if (price_low==price_height)><#if (price_low==0)> -- <#else>${price_low}万元</#if><#else>${price_low}-${price_height}万元</#if></span>
				</li>
				<li>
					<label>变速箱：</label>
					<span>
						<#list gearboxes as gearbox>
							<#if ((gearboxes?size-1)==gearbox_index)>
							${gearbox}
							<#else>
							${gearbox}|
							</#if>
						</#list>
					</span>
				</li>
				<li>
					<label>类型级别：</label>
					<span>
						<#list levels as level>
							${level}
						</#list>
					</span>
				</li>
				<li>
					<label>颜色：</label>
					<span>
						<#list colors as color>
							<i class="colorlump" style="background:${color};border:1px solid #666;"></i>
						</#list>
					</span>
				</li>
			</ul>
			<p class="car-more">
				<a href="javascript:void(0);" id="enquiry_bnt" class="btn-one btn-orange btn-arrow">询底价</a>
			</p>
		</div>
		
		<#list displas as displa>
			<div class="m-info-warp">
				<div class="m-info-tit">
					<div class="padds">
						<div class="wrap">
							<h1 class="t-left"><#if displa??>${displa}<#else> -- </#if>L 排量</h1>
							<h1 class="t-right"><span>厂商指导价</span></h1>
						</div>
					</div>
				</div>
				<div class="m-info-list">
					<ul>
						<#list models as model>	
							<#if (model['displa']??&&displa??&&model['displa']==displa)>
								<li>
									<span class="left"><a href="###">${model['catalogname']}</a></span>
									<span class="right"><em><#if model['price']??>${(model['price'])!}万<#else> -- </#if></em></span>
								</li>
							<#else>
								<#if (!(displa??)&&!(model['displa']??))>
									<li>
										<span class="left"><a href="###">${model['catalogname']}</a></span>
										<span class="right"><em><#if model['price']??>${(model['price'])!}万<#else> -- </#if></em></span>
									</li>
								</#if>
							</#if>
						</#list>
					</ul>
				</div>
			</div>
		</#list>
		
		<div class="enquiry-bar" style="display:none;"><a href="javascript:void(0);">询底价</a></div>
		
		<form method="post" id="enquiry_form" action="${wap_ct_url}wapchetuan/applyinit">
			<input type="hidden" id="carid" name="applybean.carid" value="${series['brand_id']}">
			<input type="hidden" id="modelid" name="applybean.modelid" value="${(model.catalogid)!}">
			<input type="hidden" id="seriesid" name="applybean.seriesid" value="${series['catalogid']}">
		</form>
		<script>
			$(function(){
				$("#enquiry_bnt").click(function(){
					$("#enquiry_form").submit();
				});
			});
		</script>
	</div>
</@c.html>