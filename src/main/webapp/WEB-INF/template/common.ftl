<#macro html_top nav=1 ny="n" title="中国汽车消费网 - 中国汽车消费门户" description="" keywords="">
<!DOCTYPE html>
<html lang="zh-hans">
<head>
	<meta charset="UTF-8">
	<title>中国汽车消费网 - 中国汽车消费门户</title>
	<link rel="stylesheet" href="${che_url}css/styles.css">
	<link rel="stylesheet" href="${che_url}css/cars-more-one.css">
</head>
<body>
	<div class="topbar">
		<!--minitop导航开始-->
		<div class="minitop">
			<div class="mini-main">
				<div class="top-link">
					<a href="#">收藏</a>
					<a href="#">原创</a>
					<a href="#">纠错</a>
				</div>
				<ul class="top-login">
					<li><a href="#" class="login-btn">登录</a></li>
					<li><a href="#">注册</a></li>
				</ul>
			</div>
		</div>
		<!--minitop导航结束-->
		<!--头部开始-->
		<div class="header">
			<div class="header-main">
				<div class="clearfix">
					<div class="logo"><a href="#"><img src="${che_url}images/logo.png" title="中国汽车消费网" alt="中国汽车消费网"></a></div>
					<div class="nav">
						<div class="nav-link">
							<ul>
								<li><a href="#">资 讯</a></li>
								<li><a href="#">测 评</a></li>
								<li><a href="#">报 价</a></li>
								<li><a href="#">图 库</a></li>
								<li><a href="#">经销商</a></li>
								<li><a href="#">团 购</a></li>
								<li><a href="#">汽车投诉</a></li>
								<li><a href="#">论 坛</a></li>
							</ul>
						</div>
						<div class="nav-city">
							<span class="current-city">当前城市：</span>
							<div class="change-city">
								<a href="#"><span>上海</span><i></i></a>
								<div class="show-city">11</div>
							</div>
							<ul>
								<li>热门城市：</li>
								<li><a href="#">北京</a></li>
								<li><a href="#">天津</a></li>
								<li><a href="#">广州</a></li>
								<li><a href="#">南京</a></li>
								<li><a href="#">杭州</a></li>
								<li><a href="#">合肥</a></li>
								<li><a href="#">苏州</a></li>
								<li><a href="#">成都</a></li>
								<li><a href="#">更多 &rsaquo;&rsaquo;</a></li>
							</ul>
						</div>
					</div>
				</div>
				<i class="logo-shadow1"></i>
				<i class="logo-shadow2"></i>
			</div>
			<div class="header-blue"></div>
		</div>
		<!--头部结束-->
		<div class="nav-car ma-b10">
			<ul class="clearfix">
				<li class="nav-car01"><a href="#">微型车</a></li>
				<li class="nav-car02"><a href="#">小型车</a></li>
				<li class="nav-car03"><a href="#">紧凑型车</a></li>
				<li class="nav-car04"><a href="#">中型车</a></li>
				<li class="nav-car05"><a href="#">中大型车</a></li>
				<li class="nav-car06"><a href="#">豪华车</a></li>
				<li class="nav-car07"><a href="#">MPV</a></li>
				<li class="nav-car08"><a href="#">SUV</a></li>
				<li class="nav-car09"><a href="#">跑车</a></li>
				<li class="nav-car10"><a href="#">电动车</a></li>
			</ul>
		</div>
	</div>
	
	<div class="content">
	<#nested>
	</div>
</#macro>
<#macro html_footer>
<div class="footer">
	<p>
		<a href="javascript:void(0);">关于我们</a> |
		<a href="javascript:void(0);">联系我们</a> |
		<a href="javascript:void(0);">广告服务</a> |
		<a href="javascript:void(0);">友情链接</a> |
		<a href="javascript:void(0);">网站地图</a> |
		<a href="javascript:void(0);">招聘信息</a> |
		<a href="javascript:void(0);">法律声明</a> |
		<a href="javascript:void(0);">车友会</a> |
		<a href="javascript:void(0);">加盟我们</a>
	</p>
	<p class="copyright">Copyright © 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号</p>
	<p>
		<a href="javascript:void(0);"><img src="${che_url}images/sh_gongshang.jpg" alt=""></a>
		<a href="javascript:void(0);"><img src="${che_url}images/zx110.jpg" alt=""></a>
		<a href="javascript:void(0);"><img src="${che_url}images/sh_110.jpg" alt=""></a>
	</p>
</div>
</#macro>
<#macro html_bottom>
<!--主内容结束-->
	<script src="${che_url}js/jquery-1.11.2.min.js"></script>
	<script src="${che_url}js/jquery.bxslider.min.js"></script>
	<script src="${che_url}js/global.js"></script>
	<#nested>
</body>
</html>
</#macro>