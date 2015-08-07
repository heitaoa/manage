<#import "../common_wapchetuan.ftl" as c />

<@c.html >
<body>
	<section class="wrapper">
		<header class="header">
			<a href="#" class="logo">车团网</a>
			<div class="header-search">
				<div class="search-relative">
					<input type="search" class="search-input" placeholder="请输入关键词" autocomplete="off">
				</div>
			</div>
		</header>
		<div class="top-nav">
			<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
			<h2>特卖惠</h2>
		</div>
		<div class="select-bar tml-sel-bar">
			<ul>
				<li>
					<div class="sel-row">
						<label>地区：</label>
						<div class="sel-box">上海市</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>活动类型：</label>
						<div class="sel-box">上海市</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>品牌：</label>
						<div class="sel-box">上海市</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>价格选车：</label>
						<div class="sel-box">上海市</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-salehui">
			<ul>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">帕萨特</h4>
						<div class="car-info">1.4tsi GSG(尊荣版)</div>
						<div class="car-num">仅剩:<em>24</em>台</div>
						<div class="btn">立即抢购</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">帕萨特</h4>
						<div class="car-info">1.4tsi GSG(尊荣版)</div>
						<div class="car-num">仅剩:<em>24</em>台</div>
						<div class="btn">立即抢购</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">帕萨特</h4>
						<div class="car-info">1.4tsi GSG(尊荣版)</div>
						<div class="car-num">仅剩:<em>24</em>台</div>
						<div class="btn">立即抢购</div>
					</a>
				</li>
			</ul>
			<div class="wrap">
				<a href="#" class="btn-one btn-orange btn-arrow btn-down-arrow">加载更多</a>
			</div>
		</div>
		<div class="m-bottom-search">
			<div class="m-search-box">
				<div class="m-search-box-in"><input type="search" size="10"></div>
			</div>
			<div class="m-btn-box"><input type="submit"></div>
		</div>
	</section>
	<script>
	$(document).ready(function() {
		// select 截取字段长度
		//$('.tmh-select select').find('option')
		$('.tmh-select select').each(function(i) {

			//var selValLen = $(this)[0].options;
			//for (var i = 0; i < selValLen.length; i++) {
			//	if(selValLen[i].selected == true){
			//		selValLen[i].text = selValLen[i].value.substring(0, 2);
			//	}
			//};
			var value = $(this).val();
			$(this)[0].label = value.substring(0, 2);
			//console.log(selValLen);
			//if(selValLen > 3) {
				// $(this).val('111');
			//}
			// console.log($(this).val().length);
		});
	});
	</script>
</body>
</@c.html>