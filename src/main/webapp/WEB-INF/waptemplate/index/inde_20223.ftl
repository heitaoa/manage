<#import "../common_wapchetuan.ftl" as c />

<@c.html >
<body>
	<section class="wrapper">
		<header class="header">
			<a href="#" class="logo">������</a>
			<div class="header-search">
				<div class="search-relative">
					<input type="search" class="search-input" placeholder="������ؼ���" autocomplete="off">
				</div>
			</div>
		</header>
		<div class="top-nav">
			<a href="javascript:void(0);" class="iconfont goback">&#xe600;</a>
			<h2>������</h2>
		</div>
		<div class="select-bar tml-sel-bar">
			<ul>
				<li>
					<div class="sel-row">
						<label>������</label>
						<div class="sel-box">�Ϻ���</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>����ͣ�</label>
						<div class="sel-box">�Ϻ���</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>Ʒ�ƣ�</label>
						<div class="sel-box">�Ϻ���</div>
					</div>
				</li>
				<li>
					<div class="sel-row">
						<label>�۸�ѡ����</label>
						<div class="sel-box">�Ϻ���</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-salehui">
			<ul>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">������</h4>
						<div class="car-info">1.4tsi GSG(���ٰ�)</div>
						<div class="car-num">��ʣ:<em>24</em>̨</div>
						<div class="btn">��������</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">������</h4>
						<div class="car-info">1.4tsi GSG(���ٰ�)</div>
						<div class="car-num">��ʣ:<em>24</em>̨</div>
						<div class="btn">��������</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="car-img"><img src="img/home_salsehui_car_demo.jpg" alt=""></div>
						<h4 class="car-name">������</h4>
						<div class="car-info">1.4tsi GSG(���ٰ�)</div>
						<div class="car-num">��ʣ:<em>24</em>̨</div>
						<div class="btn">��������</div>
					</a>
				</li>
			</ul>
			<div class="wrap">
				<a href="#" class="btn-one btn-orange btn-arrow btn-down-arrow">���ظ���</a>
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
		// select ��ȡ�ֶγ���
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