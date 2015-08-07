<#import "../common_wapchetuan.ftl" as c />

<@c.html >
	
	<div class="m-focus">
		<div class="m-focus-box">
			<a href="javascript:void(0);" class="arrow-prev"></a>
			<a href="javascript:void(0);" class="arrow-next"></a>
			<div class="m-focus-scroll-box swiper-container" id="m-focus-box">
				<ul class="swiper-wrapper">
					<#list dataMap['20214'] as data>
						<li class="swiper-slide">
							<a href="${(data.link)!}">
								<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
									<img src="${img_che_url}${data.pic?substring(4)}" alt="">
								<#else>
									<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
								</#if>
							</a>
						</li>
					</#list>
				</ul>
				<div class="focus-pages"></div>
			</div>
		</div>
	</div>
	<div class="tags-first" id="m-tabs-head">
		<ul>
			<li class="active"><a href="javascript:void(0);">按品牌</a></li>
			<li><a href="javascript:void(0);">按价格</a></li>
			<li><a href="javascript:void(0);">按级别</a></li>
		</ul>
	</div>
	<div class="swiper-container-head">
		<div class="swiper-wrapper">
			<div class="m-tags-con swiper-slide">
				<div class="m-hot-brands">
					<ul>
						<!-- 20215 dbo_sub_content 编辑id -->
						<#if (dataMap['20215'])??>
							<#list dataMap['20215'] as data>
								<li><div class="rim" onclick="document.location.href='${(data.link)!}';">
									<a href="${(data.link)!}">
										<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
											<img src="${img_che_url}${data.pic?substring(4)}" alt="">
										<#else>
											<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
										</#if>
									</a>
									<p style="cursor:pointer;">${data.title}</p></div>
								</li>
							</#list>
						</#if>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="wrap">
					<a href="${wap_ct_url}kanche/" class="btn-one btn-orange btn-arrow">更多筛选条件</a>
				</div>
			</div>
			<div class="m-tags-con swiper-slide">
				<div class="sort sort4 sort-price">
					<ul>
						<ul>
							<li><a href="${wap_ct_url}kanche/list-1--0--0--0--hot.html">5万以下</a></li>
							<li><a href="${wap_ct_url}kanche/list-2--0--0--0--hot.html">5-10万</a></li>
							<li><a href="${wap_ct_url}kanche/list-3--0--0--0--hot.html">10-20万</a></li>
							<li><a href="${wap_ct_url}kanche/list-4--0--0--0--hot.html">20-30万</a></li>
							<li><a href="${wap_ct_url}kanche/list-5--0--0--0--hot.html">30-40万</a></li>
							<li><a href="${wap_ct_url}kanche/list-6--0--0--0--hot.html">40-50万</a></li>
							<li><a href="${wap_ct_url}kanche/list-7--0--0--0--hot.html">50-80万</a></li>
							<li><a href="${wap_ct_url}kanche/list-8--0--0--0--hot.html">80万以上</a></li>
						</ul>
					</ul>
				</div>
				<div class="wrap">
					<a href="${wap_ct_url}kanche/" class="btn-one btn-orange btn-arrow">更多筛选条件</a>
				</div>
			</div>
			<div class="m-tags-con swiper-slide">
				<div class="sort sort3 sort-car">
					<ul>
						<li>
							<a href="${wap_ct_url}kanche/list-0--1--0--0--hot.html">
								<span class="car-xiaoxing"></span>
								<em>小型车</em>
							</a>
						</li>
						<li>
							<a href="${wap_ct_url}kanche/list-0--2--0--0--hot.html">
								<span class="car-jincouxing"></span>
								<em>紧凑型车</em>
							</a>
						</li>
						<li>
							<a href="${wap_ct_url}kanche/list-0--6--0--0--hot.html">
								<span class="car-zhongxing"></span>
								<em>中型车</em>
							</a>
						</li>
						<li>
							<a href="${wap_ct_url}kanche/list-0--7--0--0--hot.html">
								<span class="car-suv"></span>
								<em>SUV</em>
							</a>
						</li>
						<li>
							<a href="${wap_ct_url}kanche/list-0--5--0--0--hot.html">
							    <span class="car-mpv"></span>
								<em>MPV</em>
							</a>
						</li>
						<li>
							<a href="${wap_ct_url}kanche/list-0--2--0--0--hot.html">
								<span class="car-paoche"></span>
								<em>跑车</em>
							</a>
						</li>
					</ul>
				</div>
				<div class="wrap">
					<a href="${wap_ct_url}kanche/" class="btn-one btn-orange btn-arrow">更多筛选条件</a>
				</div>
			</div>
		</div>
	</div>
	<div class="title-bar"><h2>特卖惠</h2></div>
	<div class="m-salehui">
		<ul>
			<#if (dataMap['20216'])??>
				<#list dataMap['20216'] as data>
					<li>
					<!---<a href="javascript:void(0);">-->
						<div class="car-img">
							<span class="logo"><img src="${(data.clink)!}"></span>
							<a href="${(data.link)!}">
								<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
									<img src="${img_che_url}${data.pic?substring(4)}" alt="">
								<#else>
									<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
								</#if>
							</a>
						</div>
						<a href="${(data.link)!}"><h4 class="car-name">${(data.title)!}</h4></a>
						<div class="car-info">${(data.link_back)!}</div>
						<a href="javascript:void(0);"><div class="car-num">仅剩:<em>${(data.ctitle)!}</em>台</div></a>
						<a href="${wap_ct_url}kanche/baoming/bm_${(data.color)!}_tmh.html"><div class="btn">立即抢购</div></a>
					<!--</a>-->
				   </li>
					
				</#list>
			</#if>
		</ul>
		<div class="wrap">
				<a href="${wap_ct_url}temaihui/" class="btn-one btn-orange btn-arrow">查看更多</a>
		</div>
	</div>
	
	
	<script>
		var obj_hg=eval('${jsonMap['20217_json']}');
		var obj_yh=eval('${jsonMap['20218_json']}');
		var obj_xc=eval('${jsonMap['20219_json']}');
		
		$(function(){
			if(obj_hg.length<=3){
				$("#hg_more").css("display","none");
			}
			if(obj_yh.length<=3){
				$("#yh_more").css("display","none");
			}
			if(obj_xc.length<=3){
				$("#xc_more").css("display","none");
			}
		});
		
		function moreNews(pid,type,node){
			var parent=$("#"+pid);
			
			var target;
			if(type=="hg"){
				target=obj_hg;
			}else if(type=="yh"){
				target=obj_yh;
			}else if(type=="xc"){
				target=obj_xc;
			}
			if(target!=null){
				var len=parent.find("li").length;
				for(var i=len;i<(len+3)&&i<target.length;i++){
					var obj=target[i];
					
					
					var html_li='<li>'+
									'<a href="'+obj.link+'">';
										if(obj.pic!=null&&obj.pic.substring(0,4)=="ct1/"){
											html_li+='<img src="${img_che_url}'+obj.pic.substring(4)+'" alt="">';
										}else{
											html_li+='<img src="${www_ct_url}upload/pageblock/'+obj.pic+'" alt="">';
										}
										html_li+='<h4>'+obj.title+'</h4>'+
										'<span class="time">'+obj.ctitle+'</span>'+
									'</a>'+
								'</li>';
					
					parent.append(html_li);
				}
				
				if(target.length<=(len+3)){
					$(node).css("display","none");
				}
			}
		}
	</script>
	<div class="tags-first" id="m-tabs-newslist">
		<ul>
			<li class="active"><a href="javascript:void(0);">往期回顾</a></li>
			<li><a href="javascript:void(0);">最新优惠</a></li>
			<li><a href="javascript:void(0);">新车到店</a></li>
		</ul>
	</div>
	<div class="swiper-container-newslist">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<ul class="card-news" id="wqhg">
					<#if (dataMap['20217'])??>
						<#list dataMap['20217'] as data>
							<#if (data_index<3)>
								<li>
									<a href="${(data.link)!}">
										<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
											<img src="${img_che_url}${data.pic?substring(4)}" alt="">
										<#else>
											<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
										</#if>
										<h4>${(data.title)!}</h4>
										<span class="time">${(data.ctitle)!}</span>
									</a>
								</li>
							</#if>
						</#list>
					</#if>
				</ul>
				<div class="wrap">
					<a href="javascript:void(0);" onclick="moreNews('wqhg','hg',this)" class="btn-one btn-orange btn-arrow" id="hg_more">更多资讯</a>
				</div>
			</div>
			<div class="swiper-slide">
				<ul class="card-news" id="zxyh">
					<#if (dataMap['20218'])??>
						<#list dataMap['20218'] as data>
							<#if (data_index<3)>
							<li>
								<a href="${(data.link)!}">
									<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
										<img src="${img_che_url}${data.pic?substring(4)}" alt="">
									<#else>
										<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
									</#if>
									<h4>${(data.title)!}</h4>
									<span class="time">${(data.ctitle)!}</span>
								</a>
							</li>
							</#if>
						</#list>
					</#if>
				</ul>
				<div class="wrap">
					<a href="javascript:void(0);" onclick="moreNews('zxyh','yh',this)" class="btn-one btn-orange btn-arrow" id="yh_more">更多资讯</a>
				</div>
			</div>
			<div class="swiper-slide">
				<ul class="card-news" id="xcdd">
					<#if (dataMap['20219'])??>
						<#list dataMap['20219'] as data>
							<#if (data_index<3)>
							<li>
								<a href="${(data.link)!}">
									<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
										<img src="${img_che_url}${data.pic?substring(4)}" alt="">
									<#else>
										<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
									</#if>
									<h4>${(data.title)!}</h4>
									<span class="time">${(data.ctitle)!}</span>
								</a>
							</li>
							</#if>
						</#list>
					</#if>
				</ul>
				<div class="wrap">
					<a href="javascript:void(0);" onclick="moreNews('xcdd','xc',this)" class="btn-one btn-orange btn-arrow" id="xc_more">更多资讯</a>
				</div>
			</div>
		</div>
	</div>
	<div class="title-bar"><h2>图库</h2></div>
	<div class="m-gallery">
		<ul>
			<#if (dataMap['20220'])??>
				<#list dataMap['20220'] as data>
					<li>
						<a href="${(data.link)!}">
							<#if ((data.pic)??&&(data.pic?length>0)&&data.pic?substring(0,4)=="ct1/")>
								<img src="${img_che_url}${data.pic?substring(4)}" alt="">
							<#else>
								<img src="${www_ct_url}upload/pageblock/${(data.pic)!}" alt="">
							</#if>
							<h4>${(data.title)!}</h4>
						</a>
					</li>
				</#list>
			</#if>
		</ul>
		<div class="wrap" style="display:none;">
			<a href="javascript:void(0);" class="btn-one btn-orange btn-arrow">更多图片</a>
		</div>
	</div>
	<div class="title-bar"><h2>购车工具</h2></div>
	<div class="m-tools">
		<ul>
			<li><a href=" ${wap_ct_url}gongju/gouchejisuanqi.html"><img src="${wap_ct_url}img/m_tools_01.png" alt="购车计算"></a></li>
			<li><a href="${wap_ct_url}gongju/chedaijisuanqi.html"><img src="${wap_ct_url}img/m_tools_02.png" alt="货代购车"></a></li>
			<li><a href=" ${wap_ct_url}gongju/chexianjisuanqi.html"><img src="${wap_ct_url}img/m_tools_03.png" alt="保险计算"></a></li>
		</ul>
	</div>
</@c.html>