<#import "../common_wapchetuan.ftl" as c />

<@c.html >
	<div class="top-nav">
		<a href="javascript:void(0);" id="goback" class="iconfont goback">&#xe600;</a>
		<h2>看车团</h2>
	</div>
	<div class="sort sort2 filter-btn">
		<ul>
			<li><a href="javascript:void(0);" id="selectPrice"><#if (price_index==0)>价格<#else>${price}</#if></a></li>
			<li><a href="javascript:void(0);" id="selectLevel"><#if (level_index==0)>级别<#else>${level}</#if></a></li>
			<li><a href="javascript:void(0);" id="selectCC"><#if (displa_index==0)>排量<#else>${displa}</#if></a></li>
			<li><a href="javascript:void(0);" id="selectBrand"><#if (brand_index==0)>品牌<#else>${brand}</#if></a></li>
		</ul>
	</div>
	<div class="tags-first" id="m-tabs-kanche">
		<ul>
			<li <#if (sort=="hot")>class="active"</#if>><a href="<#if (price_index==0&&level_index==0&&displa_index==0&&brand_index==0)>index.html<#else>list-${price_index}--${level_index}--${displa_index}--${brand_index}--hot.html</#if>">热度</a></li>
			<li <#if (sort=="price")>class="active"</#if>><a href="list-${price_index}--${level_index}--${displa_index}--${brand_index}--price.html">价格</a></li>
			<li <#if (sort=="new")>class="active"</#if>><a href="list-${price_index}--${level_index}--${displa_index}--${brand_index}--new.html">最新</a></li>
		</ul>
	</div>
	<div class="swiper-container-kanche">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<div class="m-kanche">
					<ul id="data_content">
						
					</ul>
					<div class="wrap">
						<a href="javascript:void(0);" class="btn-one btn-orange btn-arrow btn-down-arrow">加载更多</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 灰色层背景 -->
		<div class="left-mask"></div>
		<!-- 左侧弹出层（价格） -->
		<div id="m-filter-price-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					<#list prices as pri>
						<dd <#if (price==pri)>class="current"</#if> ><a href="<#if (price_mapping[pri]==0&&level_index==0&&displa_index==0&&brand_index==0&&sort=="hot")>index.html<#else>list-${price_mapping[pri]}--${level_index}--${displa_index}--${brand_index}--${sort}.html</#if>">${pri}</a></dd>
					</#list>
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（品牌） -->
		<div id="m-filter-brand-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dl class="tt-list">
						<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
						<dd><a href="<#if (price_index==0&&level_index==0&&displa_index==0&&sort=="hot")>index.html<#else>list-${price_index}--${level_index}--${displa_index}--0--${sort}.html</#if>">不限</a></dd>
					</dl>
					
					<#list brand_letters as letter>
						<dt><span>${letter}</span></dt>
						<#list brandData as data>
							<#if (data['lname']==letter)>
								<dd>
									<a href="list-${price_index}--${level_index}--${displa_index}--${data['id']}--${sort}.html">
									<#if (data['photo'])??>
										<#if (data['photo']?substring(0,4)=="315/")>
											<img src="${imgUrl}${data['photo']?substring(4)}" height="40">
										<#else>
											<img src="${www_ct_url}${data['photo']?substring(4)}" height="40">
										</#if>
									</#if>
										<span>${data['catalogname']}</span>
									</a>
								</dd>
							</#if>
						</#list>
					</#list>
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（级别） -->
		<div id="m-filter-level-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					
					<#list levels as lev>
						<dd <#if (level==lev)>class="current"</#if> ><a href="<#if (price_index==0&&level_mapping[lev]==0&&displa_index==0&&brand_index==0&&sort=="hot")>index.html<#else>list-${price_index}--${level_mapping[lev]}--${displa_index}--${brand_index}--${sort}.html</#if>">${lev}</a></dd>
					</#list>
				</dl>
			</div>
		</div>
		<!-- 左侧弹出层（级别） -->
		<div id="m-filter-CC-popup" class="left-popup">
			<div class="swipe-left">
				<dl class="tt-list">
					<dt class="close"><a href="javascript:void(0);">关闭</a></dt>
					<#list displas as dis>
					<dd <#if (displa==dis)>class="current"</#if> ><a href="<#if (price_index==0&&level_index==0&&displa_mapping[dis]==0&&brand_index==0&&sort=="hot")>index.html<#else>list-${price_index}--${level_index}--${displa_mapping[dis]}--${brand_index}--hot.html</#if>">${dis}</a></dd>
					</#list>
				</dl>
			</div>
		</div>
	</section>
	<script>
		var maxSize=20;
		function listView(index){
			//alert(index);
		
			var jsonObj=eval('${(listData)!}');
			
			if(jsonObj==null||jsonObj.length<=0){
				$(".btn-down-arrow").html("没有更多");
				return ;
			}else if(index>jsonObj.length){
				$(".btn-down-arrow").html("没有更多");
				return ;
			}
			
			var number=0;
			for(var i=index;i<(index+maxSize)&&i<jsonObj.length;i++){
				var obj=jsonObj[i];
				//alert(obj.brand);
				var data_content=$("#data_content");
				
				var brand_photo=obj.brand_photo;
				if(brand_photo!=null){
					if(brand_photo.substring(0,4)=="315/"){
						brand_photo='${imgUrl}'+brand_photo.substring(4);
					}else{
						brand_photo='${www_ct_url}'+brand_photo.substring(4);
					}
				}else{
					brand_photo="";
				}
				
				var series_photo=obj.pic;
				if(series_photo!=null){
					if(series_photo.substring(0,4)=="315/"){
						series_photo='${imgUrl}'+series_photo.substring(4);
					}else{
						series_photo='${www_ct_url}'+series_photo.substring(4);
					}
				}else{
					series_photo="";
				}
				var model_name=obj.model_name;
				if(model_name==null){
					model_name=obj.series;
				}else{
					model_name=model_name.split(" ")[0];
				}
				
				data_content.append('<li>'+
								'<div class="car-img"><span class="logo"><img src="'+brand_photo+'" alt=""></span>'+
								'<a href="/kanche/series/series_'+obj.fatherid+'.html"><img src="'+series_photo+'" alt=""></a></div>'+
								'<h4 class="car-name"><a href="/kanche/series/series_'+obj.fatherid+'.html">'+obj.series+'</a></h4>'+
								'<div class="car-num"><em>'+obj.register_num+'</em>人已报名</div>'+
								'<div class="btn"><a href="/kanche/baoming/bm_'+obj.carid+'.html">立即抢购</a></div>'+
						'</li>');
				number++;
			}
			
			if((index+number)>=jsonObj.length){
				$(".btn-down-arrow").html("没有更多");
			}
		}
		$(function(){
			var index=0;
			listView(index);
			
			$(".btn-down-arrow").click(function(){
				index+=maxSize;
				listView(index);
			});
		});
		
		function resizeHeight(data){
			var docHeight = $(document).height();
			var swipeLeftHeight = $("#"+data+" .swipe-left").height();
		
			if(docHeight > swipeLeftHeight) {
				$('.left-mask').height(docHeight);
				$('.left-popup').height(docHeight);
			}else{
				$('.left-mask').height(swipeLeftHeight);
				$('.left-popup').height(swipeLeftHeight);
			}
		}
		
		$('.left-popup').css({
			'display': 'none'
		});
		$('#selectPrice').on('click', function(e) {
			e.preventDefault();
			$('#m-filter-price-popup').show();
			$('#m-filter-price-popup .swipe-left').addClass('swipe-left-block');
			$('.left-mask').show();
		});
		$('#selectLevel').on('click', function(e) {
			e.preventDefault();
			$('#m-filter-level-popup').show();
			$('#m-filter-level-popup .swipe-left').addClass('swipe-left-block');
			$('.left-mask').show();
		});
		$('#selectCC').on('click', function(e) {
			e.preventDefault();
			$('#m-filter-CC-popup').show();
			$('#m-filter-CC-popup .swipe-left').addClass('swipe-left-block');
			$('.left-mask').show();
		});
		$('#selectBrand').on('click', function(e) {
			e.preventDefault();
			$('#m-filter-brand-popup').show();
			$('#m-filter-brand-popup .swipe-left').addClass('swipe-left-block');
			$('.left-mask').show();
			
			resizeHeight("m-filter-brand-popup");
		});
		// 关闭
		$('.left-mask').click(function() {
			$(this).hide();
			$('.left-popup').hide();
		});
		$('.close').click(function() {
			$('.left-mask').hide();
			$(this).parents('.left-popup').hide();
		})
	</script>
		
</@c.html>
