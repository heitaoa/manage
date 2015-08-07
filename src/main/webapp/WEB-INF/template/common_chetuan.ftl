<#macro html nav=0 title="车团网 - 汽车电商O2O服务第一品牌" description="" keywords="">
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="gb2312">
	<title>${title}</title>
	<meta content="${description!}" name="description" />
	<meta content="${keywords!}" name="keywords" />
	<link rel="shortcut icon" href="${che_url}favicon.ico" type="image/x-icon" />
	<@html_css/>
	<@html_js/>
</head>
<body>
	<!-- 顶部菜单栏 start -->
	<div class="topbar">
		<div class="mini-bg">
			<@mini_bg/>
		</div>
		<div class="header-bg">
			<@header_bg/>
		</div>
		<div class="nav-bg">
			<div class="nav-main">
				<@nav_main nav/>
			</div>
		</div>
	</div>
	<!-- 顶部菜单栏 end -->
	<!-- 主内容 start -->
	<div id="content" class="content">
		<#nested>
	</div>
	<!-- 主内容 end -->
	<div class="footer">
		<@footer/>
	</div>
	
	<!-- 返回顶部开始 -->
	<div class="gotop">
		<a href="javascript:void(0);" target="_self" class="gotop-btn">
			<i class="icon-top"></i>
			<span>返回顶部</span>
		</a>
	</div>
	<!-- 返回顶部结束 -->
	
	<!-- 流量监控开始	看车团页面不要放 -->
	<#if nav != 2>
	<script src='http://w.cnzz.com/c.php?id=30073443&l=3' language='JavaScript'></script>
	<script>$(document).ready(function(){$('a[title="全景统计"]').hide();});</script>
	</#if>
	<!-- 流量监控结束 -->
	
	<!-- ad-->
	<script src='${che_url}js/ad.js'></script>
	<!-- ad -->
	
</body>
</html>
</#macro>

<!-- 图库专用-->
<#macro html2 nav=0 title="【汽车图片】汽车图片大全_汽车图片大全大图-车团网" description="车团网汽车图片大全，提供高清汽车图片大图，车团网，汽车电商O2O服务第一品牌。" keywords="汽车图片,汽车图片大全,汽车图片大全大图">
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="gb2312">
	<title>${title}</title>
	<meta content="${description!}" name="description" />
	<meta content="${keywords!}" name="keywords" />
	<@html_css/>
	<@html_js/>
</head>
<body>
	<!-- 顶部菜单栏 start -->
	<div class="topbar">
		<div class="mini-bg">
			<@mini_bg/>
		</div>
		<div class="header-bg">
			<@header_bg/>
		</div>
		<div class="nav-bg">
			<div class="nav-main">
				<@nav_main nav/>
			</div>
		</div>
	</div>
	<!-- 顶部菜单栏 end -->
	<!-- 主内容 start -->
	<div id="content" class="content">
		<#nested>
	</div>
	<!-- 主内容 end -->
	
	<!-- 返回顶部开始 -->
	<div class="gotop">
		<a href="javascript:void(0);" target="_self" class="gotop-btn">
			<i class="icon-top"></i>
			<span>返回顶部</span>
		</a>
	</div>
	<!-- 返回顶部结束 -->
	
	<!-- 流量监控开始	看车团页面不要放 -->
	<#if nav != 2>
	<script src='http://w.cnzz.com/c.php?id=30073443&l=3' language='JavaScript'></script>
	<script>$(document).ready(function(){$('a[title="全景统计"]').hide();});</script>
	</#if>
	<!-- 流量监控结束 -->
	
	<!-- ad-->
	<script src='${che_url}js/ad.js'></script>
	<!-- ad -->
	
</body>
</html>
</#macro>

<!-- footer -->
<#macro html_css>
<link rel="stylesheet" href="${che_url}css/style.css">
<link rel="stylesheet" href="${che_url}css/cardx.css">
</#macro>

<!-- footer -->
<#macro ctnews_css>
<link rel="stylesheet" href="${che_url}css/style.css">
<link rel="stylesheet" href="${che_url}css/carx.css">
</#macro>

<!-- 团购报名 -->
<#macro apply brand=0>
	<div class="group-signup-form">
		<h2 class="gp-sign-title"><strong>汽车团购</strong>报名</h2>
		<div class="con">
			<script>
				function queryModel(brand){
					$.ajax({
						url:"/chetuan/apply_forModel?cid="+brand,
						success:function(data){
							data=data.replace("{","");
							data=data.replace("}","");
							var kns=data.split(",");
							
							var $modelNode=$("select[name='model']");
							for(var i=0;i<kns.length;i++){
								var kn=kns[i].split("=");
								var k=kn[0];
								var n=kn[1];
								
								var $option=$("<option value='"+k+"'>"+n+"</option>");
								$modelNode.append($option);
							}
						},
					});
				}
				
				$(function(){
					$.ajax({
						url:"/chetuan/apply_forBrand",
						success:function(data){
							data=data.replace("{","");
							data=data.replace("}","");
							var kns=data.split(",");
							
							for(var i=0;i<kns.length;i++){
								var kn=kns[i].split("=");
								var k=kn[0];
								var n=kn[1];
								var $option;
								if(parseInt(k)==${brand}){
									$option=$("<option value='"+k+"' selected='true'>"+n+"</option>");
									queryModel(${brand});
								}else{
									$option=$("<option value='"+k+"'>"+n+"</option>");
								}
								$("select[name='brand']").append($option);
							}
						},
					});
					
					$("select[name='brand']").on("change",function(){
						var brand=$(this).val();
						
						var $modelNode=$("select[name='model']");
						$modelNode.empty();
						$modelNode.append($("<option value='0'> -- 请选择车型 -- </option>"));
						
						if(parseInt(brand)<=0){
							return ;
						}
						
						queryModel(brand);
					});
					
					
					$("#bm").on("click",function(){
						var name=$("input[name='name']").val();
						var phone=$("input[name='phone']").val();
						var brand=$("select[name='brand']").val();
						var model=$("select[name='model']").val();
						
						name=name.trim();
						if(name==null||name==""){
							alert("请输入姓名!");
							return ;
						}else{
							var name_pattern=/^[A-Za-z ·]{2,20}|([\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*)$/;
							if(!name_pattern.test(name)){
								alert("请输入正确的姓名!");
								return ;
							}
						}
						phone=phone.trim();
						if(phone==null||phone==""){
							alert("请输入手机号!");
							return ;
						}else{
							var phone_pattern=/^1[0-9]{10}$/;
							if(!phone_pattern.test(phone)){
								alert("请输入正确的手机号!");
								return ;
							}
						}
						
						if(brand<=0){
							alert("请选择品牌！");
							return ;
						}
						if(model<=0){
							alert("请选择车型！");
							return ;
						}
						
						$.post("/chetuan/apply_forApply",
						{"name":name,"phone":phone,"cid":brand,"mid":model},
						function(data){
							if(eval(data)){
								alert("报名成功！");
							}else{
								alert(data);
							}
						});
					})
				});
			</script>
			<form>
				<div class="inner-form">
					<div class="row">
						<span>姓名：</span>
						<input class="inp" name="name" type="text">
					</div>
					<div class="row">
						<span>手机：</span>
						<input class="inp" name="phone" type="text">
					</div>
					<div class="row">
						<span>品牌：</span>
						<select name="brand"  class="select">
							<option value="0"> -- 请选择品牌 -- </option>
						</select>
					</div>
					<div class="row">
						<span>车型：</span>
						<select name="model"  class="select">
							<option value="0"> -- 请选择车型 -- </option>
						</select>
					</div>
					<p class="signup-num">总报名：-- --人<br>本月报名：-- --人</p>
				</div>
				<input class="submit" type="button" id="bm" value="我要报名">
			</form>
			<div class="tips">凡报名参加本网站团购的车主均可获得价值500-5000元不等礼品</div>
		</div>
	</div>
</#macro>

<!-- footer -->
<#macro html_js>
<script type="text/javascript" src="${che_url}js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${che_url}js/jquery.bxslider.min.js"></script>
<!--<script type="text/javascript" src="${che_url}js/global.js"></script>-->
<script type="text/javascript" src="${che_url}js/global.js"></script>
<script type="text/javascript" src="${che_url}js/cityinfo.js"></script>
<!--[if lt IE 7]>
    <script type="text/javascript" src="${che_url}js/unitpngfix.js"></script>
<![endif]-->
</#macro>

<!-- footer -->
<#macro ctnews_js>
<script type="text/javascript" src="${che_url}js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${che_url}js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="${che_url}js/picnews_scroll.js"></script>
<script type="text/javascript" src="${che_url}js/cookie.js"></script>
<!--[if lt IE 7]>
    <script type="text/javascript" src="${che_url}js/unitpngfix.js"></script>
<![endif]-->
</#macro>

<!-- footer -->
<#macro header_bg>
<script type="text/javascript" > 
$(document).ready(function(){
	$.ajax({
    		url : '${chetuan_ct_url}chetuan/setInitCookie',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			$(".c-city em").html(data[0].byname);
    			getCityInit();
    		}
  	});
	
	$(".c-city-btn").on("click", function(event){
		showPop(event);
	});
});
function showPop(event){
if($(".citypop").length > 0) {
			if($(".citypop").is(":visible")) {
				$(".citypop").hide();
			}else{
				$(".citypop").show();
				event.stopPropagation();
				$(document).click(function() {
					$(".citypop").hide();
				});
			}
		}
}
function getCityInit(){

			var cityData1 = cityData[0];
			var hot = cityData1.hotArray;
			var pro = cityData1.proArray;
			var city1 = cityData1.cityarray1;
			var city2 = cityData1.cityarray2;
			var city3 = cityData1.cityarray3;
			var city4 = cityData1.cityarray4;
			var city5 = cityData1.cityarray5;
			var city6 = cityData1.cityarray6;
			var city7 = cityData1.cityarray7;
			for(var i = 0;i<pro.length;i++){
				$(".citypop dt:eq("+(i+1)+")").html(pro[i].byname.substr(0,2))
			}
			var html = "";
			for(var i = 0;i<hot.length;i++){
				html = html +  "<a href='javascript:void()' value='"+hot[i].catalogid+"' value1='"+hot[i].fatherid+"' value2='"+hot[i].ename+"' title='"+hot[i].englingname+"'>"+hot[i].byname+"</a>"
			}
			$(".citypop dd:eq(0)").html(html);
			html = "";
			for(var i = 0;i<city1.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city1[i].catalogid+"' value1='"+city1[i].fatherid+"' value2='"+city1[i].ename+"' title='"+city1[i].englingname+"'>"+city1[i].byname+"</a>"
			}
			$(".citypop dd:eq(1)").html(html);
			html = "";
			for(var i = 0;i<city2.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city2[i].catalogid+"' value1='"+city2[i].fatherid+"' value2='"+city2[i].ename+"' title='"+city2[i].englingname+"'>"+city2[i].byname+"</a>"
			}
			$(".citypop dd:eq(2)").html(html);
			html = "";
			for(var i = 0;i<city3.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city3[i].catalogid+"' value1='"+city3[i].fatherid+"' value2='"+city3[i].ename+"' title='"+city3[i].englingname+"'>"+city3[i].byname+"</a>"
			}
			$(".citypop dd:eq(3)").html(html);
			html = "";
			for(var i = 0;i<city4.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city4[i].catalogid+"' value1='"+city4[i].fatherid+"' value2='"+city4[i].ename+"' title='"+city4[i].englingname+"'>"+city4[i].byname+"</a>"
			}
			$(".citypop dd:eq(4)").html(html);
			html = "";
			for(var i = 0;i<city5.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city5[i].catalogid+"' value1='"+city5[i].fatherid+"' value2='"+city5[i].ename+"' title='"+city5[i].englingname+"'>"+city5[i].byname+"</a>"
			}
			$(".citypop dd:eq(5)").html(html);
			html = "";
			for(var i = 0;i<city6.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city6[i].catalogid+"' value1='"+city6[i].fatherid+"' title='"+city6[i].englingname+"'>"+city6[i].byname+"</a>"
			}
			$(".citypop dd:eq(6)").html(html);
			html = "";
			for(var i = 0;i<city7.length;i++){
				html = html +  "<a href='javascript:void()' value='"+city7[i].catalogid+"' value1='"+city7[i].fatherid+"' title='"+city7[i].englingname+"'>"+city7[i].byname+"</a>"
			}
			$(".citypop dd:eq(7)").html(html);
			$(".citypop").find("a").click(function(){
				var title = $(this)[0].title;
				var value = ($(this).attr("value"));
				var value1 = ($(this).attr("value1"));
				var value2 = ($(this).attr("value2"));
				var tmh = $("#tmh").attr("value");
				$.ajax({
		    		url : '${chetuan_ct_url}chetuan/setNextCookie',
		    		data: {title:title,value:value,value1:value1},
		    		dataType : 'jsonp',
		    		jsonp:'jsonpcallback',
		    		success : function(data){
		    			if(tmh=="tmh")
		    				window.location.href="${che_url}chetuan/salefavoredsearch";
		    			else
		    				if(value2 == "shanghai"){
		    					window.location.href= "${che_url}";
		    				}else{
		    					window.location.href= "http://"+value2+".chetuan.com";
		    				}
		    		}
			  	});
			})
}

</script>
<div class="header-main">
	<div class="logo"><a href="${che_url}"><img src="${che_url}images/logo.png" alt=""></a></div>
	<div class="c-city">
		<em></em>
		<a class="c-city-btn" href="javascript:void(0);">[切换城市]</a>
		<div  class="citypop">
			<dl class="hot">
				<dt>热门</dt>
				<dd>
					<a href="">北京</a>
					<a href="">上海</a>
					<a href="">广州</a>
					<a href="">成都</a>
					<a href="">杭州</a>
					<a href="">武汉</a>
				</dd>
			</dl>
			<dl>
				<dt>华北：</dt>
				<dd>
					<a href="">北京</a>
					<a href="">天津</a>
					<a href="">太原</a>
					<a href="">呼和浩特</a>
					<a href="">济南</a>
					<a href="">青岛</a>
					<a href="">烟台</a>
				</dd>
			</dl>
			<dl>
				<dt>东北：</dt>
				<dd>
					<a href="">哈尔滨</a>
					<a href="">大庆</a>
					<a href="">长春</a>
					<a href="">沈阳</a>
					<a href="">大连</a>
				</dd>
			</dl>
			<dl>
				<dt>华东：</dt>
				<dd>
					<a href="">上海</a>
					<a href="">杭州</a>
					<a href="">温州</a>
					<a href="">宁波</a>
					<a href="">金华</a>
					<a href="">台州</a>
					<a href="">绍兴</a>
					<a href="">嘉兴</a>
					<a href="">湖州</a>
					<a href="">衡州</a>
					<a href="">丽水</a>
					<a href="">舟山</a>
					<a href="">南京</a>
					<a href="">苏州</a>
					<a href="">徐州</a>
					<a href="">无锡</a>
					<a href="">合肥</a>
					<a href="">镇江</a>
					<a href="">淮安</a>
					<a href="">宿迁</a>
					<a href="">扬州</a>
					<a href="">泰州</a>
					<a href="">南通</a>
					<a href="">常州</a>
					<a href="">盐城</a>
					<a href="">铜陵</a>
					<a href="">芜湖</a>
					<a href="">阜阳</a>
					<a href="">安庆</a>
					<a href="">蚌埠</a>
					<a href="">六安</a>
					<a href="">连云港</a>
				</dd>
			</dl>
			<dl>
				<dt>华中：</dt>
				<dd>
					<a href="">郑州</a>
					<a href="">洛阳</a>
					<a href="">武汉</a>
					<a href="">宜昌</a>
					<a href="">长沙</a>
					<a href="">南昌</a>
				</dd>
			</dl>
			<dl>
				<dt>华南：</dt>
				<dd>
					<a href="">广州</a>
					<a href="">深圳</a>
					<a href="">东莞</a>
					<a href="">佛山</a>
					<a href="">南宁</a>
					<a href="">海口</a>
					<a href="">福州</a>
					<a href="">厦门</a>
					<a href="">泉州</a>
				</dd>
			</dl>
			<dl>
				<dt>西北：</dt>
				<dd>
					<a href="">兰州</a>
					<a href="">银川</a>
					<a href="">西安</a>
					<a href="">乌鲁木齐</a>
				</dd>
			</dl>
			<dl>
				<dt>西南：</dt>
				<dd>
					<a href="">重庆</a>
					<a href="">贵阳</a>
					<a href="">成都</a>
					<a href="">昆明</a>
					<a href="">绵阳</a>
					<a href="">泸州</a>
					<a href="">南充</a>
					<a href="">攀枝花</a>
				</dd>
			</dl>
		</div>
	</div>
	<div class="search">
		<script>
			$(function(){
				var $inpt=$(".search input[name='search_kw']");
				$inpt.keypress(function(e){
					if(e.keyCode==13){
						doSearhc();
					}
				});
				$(".search input[type='button']").click(function(){
					doSearhc();
				});
			});
			
			function doSearhc(){
				var inpt=$(".search input[name='search_kw']").val();
				if(inpt==null||$.trim(inpt)==""||$.trim(inpt)=="输入您要团购的汽车品牌或车型"){
					return ;
				}
				$(".search form").submit();
			}
		</script>
		<form action="${che_url}chetuan/toGroupon" method="post">
			<input type="text" class="search-text" name="search_kw" value="输入您要团购的汽车品牌或车型">
			<input type="text" style="display:none" name="xx" value="3">
			<input type="button" class="search-submit" value="搜索">
		</form>
	</div>
	<ul class="slogan">
		<li><i class="sq"></i>省钱</li>
		<li><i class="sl"></i>省力</li>
		<li><i class="sx"></i>省心</li>
		<li><i class="ss"></i>省时</li>
	</ul>
</div>
</#macro>

<!-- footer -->
<#macro mini_bg>
<div class="mini-main">
	<div class="mini-left">免费咨询热线：400 88 16315（09:00~18:00）</div>
	<div class="mini-brand">汽车电商O2O服务第一品牌</div>
	<div class="mini-right">
		<span class="qq">QQ咨询：400 88 16315</span>
		<!--
		<span class="login"><a href="">登录</a>|<a href="">注册</a></span>
		-->
	</div>
</div>
</#macro>

<!-- footer -->
<#macro nav_main nav>
<ul class="nav-link">
	<li><a <#if nav==1>class="active"</#if> href="${che_url}">首页</a></li>
	<li><a <#if nav==2>class="active"</#if> href="${che_url}list/">小胖看车团</a></li>
	<li><a <#if nav==3>class="active"</#if> href="${che_url}chetuan/salefavoredsearch">特卖惠</a></li>
	<li><a <#if nav==4>class="active"</#if> href="${che_url}chetuan/carInsurance">车险团购</a></li>
	<li><a <#if nav==5>class="active"</#if> href="http://tousu.315che.com/" target="_blank">维权投诉</a></li>
	<li><a <#if nav==6>class="active"</#if> href="${dealer_ct_url}">经销商</a></li>
	<li><a <#if nav==7>class="active"</#if> href="${bbs_ct_url}">乐活社区</a></li>
	<!--
	<li><a <#if nav==8>class="active"</#if> href="http://tuan.315che.com/xp/homePage_ct">小胖看车团</a></li>
	-->
	<li><a <#if nav==8>class="active"</#if> href="${che_url}gongju/gouchejisuanqi.html">购车工具</a></li>
	<li class="last"><a <#if nav==9>class="active"</#if> href="${pic_ct_url}">图库</a></li>
</ul>
</#macro>

<!-- footer -->
<#macro footer>
<div class="footer-bar">
	<a  target="_blank" href="${che_url}index_18696.html">关于我们</a>|<a target="_blank" href="${che_url}index_18696.html">联系我们</a>|<a target="_blank" href="${che_url}index_18697.html">广告服务</a>|<a target="_blank" href="${che_url}index_18698.html">友情链接</a>|<a target="_blank" href="${che_url}index_18699.html">网站地图</a>|<a target="_blank" href="${che_url}index_18700.html">招聘信息</a>|<a target="_blank" href="${che_url}index_18701.html">法律声明</a>|<a target="_blank" href="${che_url}index_18702.html">车友会</a>|<a target="_blank" href="${che_url}index_18700.html">加盟我们</a>
</div>
<p>Copyright &copy; 2005-2020 <a href="${che_url}">车团网</a> 备案号：沪ICP备14037683号-1</p>
<p>
	<a href=""><img src="${che_url}images/sh_icbc.jpg" alt=""></a>
	<a href=""><img src="${che_url}images/zx110.jpg" alt=""></a>
	<a href=""><img src="${che_url}images/sh_cyberpolice.jpg" alt=""></a>
</p>
</#macro>

<!-- 新闻内容页模板 -->
<#macro ctnews_html nav=0 title="车团网 - 汽车电商O2O服务第一品牌">
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="gb2312">
	<@ctnews_css/>
	<@ctnews_js/>
	<title>${title}</title>
</head>
<body>
	<!-- 顶部菜单栏 start -->
	<div class="topbar">
		<div class="mini-bg">
			<@mini_bg/>
		</div>
		<div class="header-bg">
			<@header_bg/>
		</div>
		<div class="nav-bg">
			<div class="nav-main">
				<@nav_main nav/>
			</div>
		</div>
	</div>
	<!-- 顶部菜单栏 end -->
	<!-- 主内容 start -->
	<div class="content car-model">
		<#nested>
	</div>
	<!-- 主内容 end -->
	<div class="footer">
		<@footer/>
	</div>
	
	<!-- 返回顶部开始 -->
	<div class="gotop">
		<a href="javascript:void(0);" target="_self" class="gotop-btn">
			<i class="icon-top"></i>
			<span>返回顶部</span>
		</a>
	</div>
	<!-- 返回顶部结束 -->
	
	<!-- ad-->
	<script src='${che_url}js/ad.js'></script>
	<!-- ad -->
	
</body>
</html>
</#macro>

<#macro buyCartools nav>
<ul class="clearfix">
	<li <#if nav==5>class="active"</#if>><a href="${che_url}gongju/gouchejisuanqi.html">购车计算</a></li>
	<li <#if nav==4>class="active"</#if>><a href="${che_url}gongju/chedaijisuanqi.html">贷款购车</a></li>
	<li <#if nav==6>class="active"</#if>><a href="${che_url}gongju/chexianjisuanqi.html">保险计算</a></li>
	<li <#if nav==1>class="active"</#if>><a href="${che_url}gongju/canshuduibi.html">参数对比</a></li>
	<li <#if nav==2>class="active"</#if>><a href="${che_url}gongju/tupianduibi.html">图片对比</a></li>
	<li <#if nav==7>class="active"</#if>><a href="${che_url}gongju/jiagepinggu.html">价值评估</a></li>
	<li <#if nav==3>class="active"</#if>><a href="${che_url}gongju/baojia.html">车型报价</a></li>
	<li <#if nav==8>class="active"</#if>><a href="${dealer_ct_url}a9-1.html">经销商查询</a></li>
</ul>
</#macro>
<!-- 不同图片服务器 -->
<#macro img_url pic ="">
<#if pic=="">
<#elseif pic?substring(0, 3) == "315">
${img_315c_url}${pic?substring(3)}?v=${ver}
<#elseif pic?substring(0, 3) == "ct1">
${che_url}${pic?substring(3)}?v=${ver}
<#else>
${pic!}?v=${ver}
</#if>
</#macro>
<!-- 不同图片服务器 -->
<#macro img_url_js>
<script>
window.getimg = (function() {

	return function (pic)
	{
		if(pic && pic.length>0)
		{
			if(pic.substr(0,3) == "315")
			{
				return "${img_315c_url}/"+pic.substr(3)+"?v="+${ver};
			}
			else if(pic.substr(0,3) == "ct1")
			{
				return "${ctadm_ct_url}"+"upload/"+pic.substr(3)+"?v2="+${ver};
			}
			else
			{
				return pic;
			}
		}
		return "";
	}
	
})();
</script>
</#macro>
