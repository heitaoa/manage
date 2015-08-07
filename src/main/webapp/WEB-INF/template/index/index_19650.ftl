<#import "../common_chetuan.ftl" as cc>
<@cc.html2 8 "车型报价-车团网"  "车团网购车工具提供各种车型报价，车团网，汽车电商服务第一品牌。" "车型报价">
<head>
	<link rel="stylesheet" href="${www_ct_url}css/tools.css">
	<link rel="stylesheet" href="${www_ct_url}css/style.css">
	<script type="text/javascript" src="${www_ct_url}js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/global.js"></script>
	<style type="text/css">
#tooltip{
	position:absolute;
	z-index: 1000;
	border:1px solid #333;
	background:#f7f5d1;
	padding:1px;
	color:#333;
	display:none;
}
</style>
</head>
<body>
	<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">购车工具</a>&gt;<a class="active" href="javascript:void(0);">车型报价</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 3/>
			</div>
		</div>	
		<div class="price-tools">
			<div class="brand-car-list">
				<div class="letter-list">
					<ul class="nav clearfix">
						<li><a href="javascript:void();" value="A">A</a></li>
						<li><a href="javascript:void();" value="B">B</a></li>
						<li><a href="javascript:void();" value="C">C</a></li>
						<li><a href="javascript:void();" value="D">D</a></li>
						<li class="none">E</li>
						<li><a href="javascript:void();" value="F">F</a></li>
						<li><a href="javascript:void();" value="G">G</a></li>
						<li><a href="javascript:void();" value="H">H</a></li>
						<li class="none">I</li>
						<li><a href="javascript:void();" value="J">J</a></li>
						<li><a href="javascript:void();" value="K">K</a></li>
						<li><a href="javascript:void();" value="L">L</a></li>
						<li><a href="javascript:void();" value="M">M</a></li>
						<li><a href="javascript:void();" value="N">N</a></li>
						<li><a href="javascript:void();" value="O">O</a></li>
						<li><a href="javascript:void();" value="P">P</a></li>
						<li><a href="javascript:void();" value="Q">Q</a></li>
						<li><a href="javascript:void();" value="R">R</a></li>
						<li><a href="javascript:void();" value="S">S</a></li>
						<li><a href="javascript:void();" value="T">T</a></li>
						<li class="none">U</li>
						<li class="none">V</li>
						<li><a href="javascript:void();" value="W">W</a></li>
						<li><a href="javascript:void();" value="X">X</a></li>
						<li><a href="javascript:void();" value="Y">Y</a></li>
						<li><a href="javascript:void();" value="Z">Z</a></li>
					</ul>
				</div>
				<div class="left-tree">
					<ul class="tree">
					</ul>
				</div>
			</div>
			<div class="right-body">
				<h2 class="title arr-title"><i></i>精选车辆<b class="ora-line"></b></h2>
					<div class="tool-selectbar">
						<dl class="aabbcc1">
						</dl>
						<dl>
							<dt>价格：</dt>
							<dd class="aabbcc2">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="5万以下">5万以下</a></li>
									<li><a href="javascript:void(0);" value="5-10万">5-10万</a></li>
									<li><a href="javascript:void(0);" value="10-15万">10-15万</a></li>
									<li><a href="javascript:void(0);" value="15-20万">15-20万</a></li>
									<li><a href="javascript:void(0);" value="20-30万">20-30万</a></li>
									<li><a href="javascript:void(0);" value="30-40万">30-40万</a></li>
									<li><a href="javascript:void(0);" value="40-50万">40-50万</a></li>
									<li><a href="javascript:void(0);" value="50-80万">50-80万</a></li>
									<li><a href="javascript:void(0);" value="80万以上">80万以上</a></li>
									<div class="right-btn pull-down">
										<button id="p_conf" href="javascript:void(0);" class="custom-btn">自定义</button>
										<div class="popup-price" style="display:none;">
											<div class="input-box">
												<input type="text" id="minPrice" maxlength="4"> 至
												<input id="maxPrice" type="text" maxlength="4"> 万
											</div>
											<div class="btn"><button style="cursor:pointer;" id="price_">确定</button></div>
										</div>
									</div>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>级别：</dt>
							<dd class="aabbcc3">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="1">微型车</a></li>
									<li><a href="javascript:void(0);" value="2">小型车</a></li>
									<li><a href="javascript:void(0);" value="3">紧凑型车</a></li>
									<li><a href="javascript:void(0);" value="4">轻型车</a></li>
									<li><a href="javascript:void(0);" value="5">中型车</a></li>
									<li><a href="javascript:void(0);" value="6">中大型车</a></li>
									<li><a href="javascript:void(0);" value="7">大型车</a></li>
									<li><a href="javascript:void(0);" value="8">豪华车</a></li>
									<li><a href="javascript:void(0);" value="9">超级豪华车</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>排量：</dt>
							<dd class="aabbcc4">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="1.3以下">1.3以下</a></li>
									<li><a href="javascript:void(0);" value="1.3-1.6L">1.3-1.6L</a></li>
									<li><a href="javascript:void(0);" value="1.7-2L">1.7-2L</a></li>
									<li><a href="javascript:void(0);" value="2.1-3L">2.1-3L</a></li>
									<li><a href="javascript:void(0);" value="3.1-5L">3.1-5L</a></li>
									<li><a href="javascript:void(0);" value="5L以上">5L以上</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>变速：</dt>
							<dd class="aabbcc5">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="1">手动</a></li>
									<li><a href="javascript:void(0);" value="2">自动</a></li>
									<li><a href="javascript:void(0);" value="3">双离合</a></li>
									<li><a href="javascript:void(0);" value="4">无级变速</a></li>
									<li><a href="javascript:void(0);" value="5">手自一体</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>类型：</dt>
							<dd class="aabbcc6">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="1">轿车</a></li>
									<li><a href="javascript:void(0);" value="2">跨界车</a></li>
									<li><a href="javascript:void(0);" value="3">SUV</a></li>
									<li><a href="javascript:void(0);" value="4">旅行车</a></li>
									<li><a href="javascript:void(0);" value="5">MPV</a></li>
									<li><a href="javascript:void(0);" value="6">跑车</a></li>
									<li><a href="javascript:void(0);" value="7">概念车</a></li>
									<li><a href="javascript:void(0);" value="8">皮卡</a></li>
									<li><a href="javascript:void(0);" value="9">客车</a></li>
									<li><a href="javascript:void(0);" value="10">卡车</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>燃料：</dt>
							<dd class="aabbcc7">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="1">汽油</a></li>
									<li><a href="javascript:void(0);" value="2">柴油</a></li>
									<li><a href="javascript:void(0);" value="3">混合动力</a></li>
									<li><a href="javascript:void(0);" value="4">纯电动</a></li>
									<li><a href="javascript:void(0);" value="5">天然气</a></li>
								</ul>
							</dd>
						</dl>
					</div>
					<div class="clear"></div>
				<div id="showCar">
				</div>
				<div class="hot-car">
					<h2 class="title arr-title"><i></i>热门车型<b class="ora-line"></b></h2>
					<div class="con">
						<script type="text/javascript" src="${www_ct_url}sub/block_19644.js?v=${ver}"></script>
					</div>
				</div>
				<div class="price-car">
					<h2 class="title arr-title"><i></i>汽车报价<b class="ora-line"></b></h2>
					<div class="table-con">
						<table id="dealTable">
						</table>
					</div>
				</div>
				<div class="news-car">
					<div class="title-nav">
						<div class="title-subcnt">
							<ul>
								<li class="selected"><span>商家活动</span></li>
								<li><span>上海优惠</span></li>
								<li><span>新车到店</span></li>
								<li class="last"><span>维权投诉</span></li>
							</ul>
						</div>
					</div>
					<div class="title-content">
						<div style="display:block;" class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19646.js?v=${ver}"></script>
							<div class="article-more"><a href="${www_ct_url}list/731/list_1.html">查看更多新闻&rsaquo;&rsaquo;</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19647.js?v=${ver}"></script>
							<div class="article-more"><a href="${www_ct_url}list/730/list_1.html">查看更多新闻&rsaquo;&rsaquo;</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19648.js?v=${ver}"></script>
							<div class="article-more"><a href="${www_ct_url}list/733/list_1.html">查看更多新闻&rsaquo;&rsaquo;</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19649.js?v=${ver}"></script>
							<div class="article-more"><a href="${www_ct_url}list/734/list_1.html">查看更多新闻&rsaquo;&rsaquo;</a></div>
						</div>
					</div>
				</div>
				<div class="footer">
					<@cc.footer/>
				</div>
		</div>
			<script>
			var carList;
			var page;
			var totalPage;		
			
			$(document).ready(function(){
				var $galleryFocusBar = $(".focus-article .focus-side li");
				$galleryFocusBar.on("mouseenter mouseleave", function() {
					$(this).addClass("active").siblings().removeClass("active");
					var index = $galleryFocusBar.index(this);
					$(".focus-pic > a").eq(index).show().siblings().hide();
				});
				$(".selected").click();
				
				$.ajax({
		    		url : 'http://www.chetuan.com//chetuan/getMainTree',
		    		dataType : 'jsonp',
		    		jsonp:'jsonpcallback',
		    		success : function(data){
			    		var map = data[0];
						var html = "";
						var addChild = 0
						for(var key1 in map){
							html = html + "<li class='root'>"
							html = html + "<a id='"+key1+"'><b>"+key1+"</b></a><ul class='tree-item-box'>";
							for (var i =0 ;i<map[key1].length;i++) {
								html = html +  "<li><a class='main-brand' href='javascript:void(0)' value='"+map[key1][i].catalogid+'-'+map[key1][i].catalogname+"'>";
								html = html + "<em>"+map[key1][i].catalogname+"</em>";
								html = html + "</a><ul class='tree-items'></ul></li>";
								addChild = addChild+1;
							}
							html = html + "</ul></li>";
						}
						$("ul.tree").html(html);
						$(".main-brand").click(function(){
							document.documentElement.scrollTop = document.body.scrollTop =0;
							$("#catalogid").attr("value",$(this).attr("value").split("-")[0]);
							$("#catalogname").attr("value",$(this).attr("value").split("-")[1]);
							//$(this).addClass("active").parents().siblings().find("a").removeClass("active");
							queryCarList(1);
							showCondition();
						});
		    		}
				});
				queryCarList(1);
				showDealer();
			})
			
			
			$(".nav a").click(function(){
				var value = $(this).attr("value");
				$(".left-tree").scrollTop($(".root #"+value)[0].offsetTop);
			});
			
			
			function showDealer(){
				$.ajax({
					url : '${www_ct_url}chetuan/getDealerList',
					dataType : 'jsonp',
					jsonp : 'jsonpcallback',
					success : function(data){
						var list = data;
						var html = '';
						html+='<tr>';
						html+='<th width="42%">车型名称</th>';
						html+='<th width="18%">报价</th>';
						html+='<th width="17%">经销商</th>';
						html+='<th width="13%">日期</th>';
						html+='<th width="10%">更多信息</th>';
						html+='</tr>';
						for(var i=0;i<list.length;i++){
							html+='<tr>';
							html+='<th class="car-name">'+list[i].name+'</th>';
							html+='<th><span class="price">'+getDealerPrice(list[i].price)+'</span></th>';
							html+='<th>'+list[i].shortename+'</th>';
							html+='<th>'+list[i].updatedate+'</th>';
							html+='<th><a href="${kan_ct_url}chetuan/'+list[i].fatherid+'/toGroupbuySeries.html">更多&rsaquo;&rsaquo;</a></th>';	
							html+='</tr>';
						}
						$("#dealTable").html(html);
					}
					
				});
			}
			
			function getDealerPrice(price){
				return parseFloat(price)/10000+"万";
			}
			
					
			$(".aabbcc2 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#price").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);	
				showCondition();
			});
			
			$(".aabbcc3 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#level").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc4 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#displm").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc5 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#transmission").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc6 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#structure").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc7 a").click(function(){
				if($pshow){
					$(".popup-price").hide();
					$pshow=false;
				}
				$("#fuel").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			function queryCarList(objPage){
				var catalogid = $("#catalogid").attr("value");
				var level = $("#level").attr("value");
				var price = $("#price").attr("value");
				var displm = $("#displm").attr("value");
				var transmission = $("#transmission").attr("value");
				var structure = $("#structure").attr("value");
				var fuel = $("#fuel").attr("value");
				
				$.ajax({
	    		url : '${www_ct_url}chetuan/carPayList',
	    		dataType : 'jsonp',
	    		data:{catalogid:catalogid,level:level,price:encodeURI(price),displm:encodeURI(displm),transmission:transmission,structure:structure,fuel:fuel,page:objPage},
	    		jsonp:'jsonpcallback',
	    		success : function(data){
	    			carList = data[0];
		    		page=data[1];
		    		totalPage=data[2];
		    		show();
	    		}});
	    			
			}	
	    		
	    		function show(){
					var html="";
					var list = carList;
					html=html
							+'<div class="hot-car">'
							+'<div class="con">'
							+'<ul>';
					if(list.length>0){
						for(var i =0 ;i<list.length;i++){
							html=html
							+ '<li>'
							+'<div class="pic"><a href="javascript:void(0);" onclick="toGroupbuySeries('+list[i].fatherid+');"><img src="'+changeUrl(list[i].photo)+'" alt=""></a></div>'
							+'<div class="info">'
							+'<p class="title"><a href="javascript:void(0);" onclick="toGroupbuySeries('+list[i].fatherid+');" class="tooltip" title = "'+list[i].catalogname+'">'+(list[i].catalogname).substr(0,15)+'</a></p>'
							+'<span class="price">厂商指导价：'+getPrice(list[i].dprice)+'</span>'
							+'</div>'
							+'</li>'
						}	
					}else{
						html=html
						+'<div style="margin-left:25px;">'
						+'<div><font size="3px" color="red">没有查询到相关车型...</font></div>'
						+'<br/>'
						+'</div>'
					}
					html=html
					+'</div>'
					+'</ul>';
					
					var pageHtml="";
					if(list.length>0)
					{
						pageHtml='<div class="pages">';
						pageHtml+='<a  style="cursor:pointer;" value="'+1+'">首页</a>';
						if(page>1){
							pageHtml+='<a  style="cursor:pointer;" value="'+(page-1)+'">上一页</a>';
						}else{
							pageHtml+='<a  style="cursor:pointer;" value="'+1+'">上一页</a>';
						}
						
						if(totalPage>1){
							if(page-3>1){
								pageHtml+='...'
							}
							for(var i=page-3;i<page+3;i++){
								if(i>0&&i<=totalPage){
									if(i==page){
										pageHtml+='<a class="current" style="cursor:pointer;" value="'+i+'">'+i+'</a>';
									}else{
										pageHtml+='<a style="cursor:pointer;" value="'+i+'">'+i+'</a>';
									}
								}
							}
							if(page+3<totalPage){
								pageHtml+='...';
							}
						}else{
							pageHtml+='<a class="current" style="cursor:pointer;">'+1+'</a>';
						}
						if(page<totalPage){
							pageHtml+='<a  style="cursor:pointer;" value="'+(page+1)+'">下一页</a>';
						}else{
							pageHtml+='<a  style="cursor:pointer;" value="'+(totalPage)+'">下一页</a>';
						}
						pageHtml+='<a  style="cursor:pointer;" value="'+(totalPage)+'">末页</a>';
						pageHtml+='</div>';
					}
					pageHtml+='</div>';
					
					html = html+pageHtml;
					var x = 10;  
					var y = 20;
					$("#showCar").html(html);				
					$("a.tooltip").mouseover(function(e){
		       			this.myTitle = this.title;
						this.title = "";	
			    		var tooltip = "<div id='tooltip'>"+ this.myTitle +"<\/div>"; //创建 div 元素
						$("body").append(tooltip);	//把它追加到文档中
						$("#tooltip")
						.css({
						"top": (e.pageY + y) + "px",
						"left": (e.pageX  + x) + "px"
						}).show("fast");	  //设置x坐标和y坐标，并且显示
		    		}).mouseout(function(){		
					this.title = this.myTitle;
					$("#tooltip").remove();   //移除 
		    		});
					$(".pages").find("a").click(function(){
						page=$(this).attr("value");
						queryCarList(page);
					});		
					
				}
				
				function showCondition(){
					var html="";
					var catalogname = $("#catalogname").attr("value");
					var catalogid = $("#catalogid").attr("value");
					var level = $("#level").attr("value");
					var price = $("#price").attr("value");
					var displm = $("#displm").attr("value");
					var transmission = $("#transmission").attr("value");
					var structure = $("#structure").attr("value");
					var fuel = $("#fuel").attr("value");
					var flag = false;
					
					var levels=new Array("微型车","小型车","紧凑型车","轻型车","中型车","中大型车","大型车","豪华车","超级豪华车");
					var transmissions=new Array("手动","自动","双离合","无级变速","手自一体");
					var structures=new Array("轿车","跨界车","SUV","旅行车","MPV","跑车","概念车","皮卡","客车","卡车");
					var fuels=new Array("汽油","柴油","混合动力","纯电动","天然气");
					
					if(catalogid!=null && catalogid != ""){
						html+='<li><a class="filter" style="cursor:pointer;" href="javascript:void(0);" value="catalogid"><span class="filter-text">'+catalogname+'</span><b></b></a></li>';
						flag = true;
					}
					if(price!=null && price != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="price"><span class="filter-text">'+price+'</span><b></b></a></li>';
						flag = true;
					}
					
					if(level!=null && level != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="level"><span class="filter-text">'+levels[level-1]+'</span><b></b></a></li>';
						flag = true;
					}
					
					if(displm!=null && displm != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="displm"><span class="filter-text">'+displm+'</span><b></b></a></li>';
						flag = true;
					}
					if(transmission!=null && transmission != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="transmission"><span class="filter-text">'+transmissions[transmission-1]+'</span><b></b></a></li>';
						flag = true;
					}
					if(structure!=null && structure != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="structure"><span class="filter-text">'+structures[structure-1]+'</span><b></b></a></li>';
						flag = true;
					}
					if(fuel!=null && fuel != ""){
						html+='<li><a class="filter" href="javascript:void(0);" value="fuel"><span class="filter-text">'+fuels[fuel-1]+'</span><b></b></a></li>';
						flag = true;
					}
					if(flag){
						html='<dt>条件：</dt><dd><ul class="car-filter">'+html;
						html+='<li><a href="javascript:void(0);" value="clearCondition">清除条件</a></li>';
						html+='</ul>';
						html+='</dd>';
					}
																		
					$(".aabbcc1").html(html);
					
					$(".aabbcc1 a").click(function(){
						var value = $(this).attr("value");
						if(value=="price"){
							$(".aabbcc2").find("a").removeClass("active");
							$(".aabbcc2 li:eq(0)").find("a").addClass("active");
						}else if(value=="level"){
							$(".aabbcc3").find("a").removeClass("active");
							$(".aabbcc3 li:eq(0)").find("a").addClass("active");
						}else if(value=="displm"){
							$(".aabbcc4").find("a").removeClass("active");
							$(".aabbcc4 li:eq(0)").find("a").addClass("active");
						}else if(value=="transmission"){
							$(".aabbcc5").find("a").removeClass("active");
							$(".aabbcc5 li:eq(0)").find("a").addClass("active");
						}else if(value=="structure"){
							$(".aabbcc6").find("a").removeClass("active");
							$(".aabbcc6 li:eq(0)").find("a").addClass("active");
						}else if(value=="fuel"){
							$(".aabbcc7").find("a").removeClass("active");
							$(".aabbcc7 li:eq(0)").find("a").addClass("active");
						}
						if(value=="clearCondition"){
							$("#catalogid").attr("value","");
							$("#price").attr("value","");
							$("#level").attr("value","");
							$("#displm").attr("value","");
							$("#transmission").attr("value","");
							$("#structure").attr("value","");
							$("#fuel").attr("value","");
							$(".aabbcc2").find("a").removeClass("active");
							$(".aabbcc2 li:eq(0)").find("a").addClass("active");
							$(".aabbcc3").find("a").removeClass("active");
							$(".aabbcc3 li:eq(0)").find("a").addClass("active");
							$(".aabbcc4").find("a").removeClass("active");
							$(".aabbcc4 li:eq(0)").find("a").addClass("active");
							$(".aabbcc5").find("a").removeClass("active");
							$(".aabbcc5 li:eq(0)").find("a").addClass("active");
							$(".aabbcc6").find("a").removeClass("active");
							$(".aabbcc6 li:eq(0)").find("a").addClass("active");
							$(".aabbcc7").find("a").removeClass("active");
							$(".aabbcc7 li:eq(0)").find("a").addClass("active");
						}else{
							$("#"+value).attr("value","");
						}
						if($pshow){
								$(".popup-price").hide();
								$pshow=false;
							}
						queryCarList(1);	
						showCondition();
					});				
				
				}
				
				function getImagePath(path1,path2){
					if(path2!=undefined){
						return path2;
					}
					return path1.replace(/ct1/,"${www_ct_url}");
				}
				
				function getPrice(price){
					if(price.substr(0,1)=='0'||price==""){
						return "暂无";
					}else if(price=="暂无"){
						return price;
					}else{
						return price+"万";
					}
				}
				
				function toGroupbuySeries(id){
					document.location.href="http://kan.chetuan.com/chetuan/"+id+"/toGroupbuySeries.html";
				}
				
				var $pshow=false;
				$(".popup-price").hide();
				$("#p_conf").click(function(){
					if(!$pshow){
						$(".popup-price").show();
						$pshow=true;
					}else{
						$(".popup-price").hide();
						$pshow=false;
					}
				});
				
				$("#price_close").click(function(){
					if(!$pshow){
						$(".popup-price").show();
						$pshow=true;
					}else{
						$(".popup-price").hide();
						$pshow=false;
					}
				});
				
				
				$("#price_").click(function(){
					$minp=$.trim($("#minPrice").val());
					$maxp=$.trim($("#maxPrice").val());
					
					
					if($minp!="" || $maxp!=""){
						if(parseFloat($maxp)<0){
							alert("请至少输入大于0的数字作为价格上限或下限");
							$("#maxPrice").val("");
							$("#minPrice").val("");
							return ;
						}else if(parseFloat($minp)<0){
							$minp=0;
						}
					}
					
					var min=parseFloat($minp);
					var max=parseFloat($maxp);
					
					if(min<max){
						$("#price").attr("value",min+"-"+max+"万");
						$(this).parents("ul").find("a").removeClass("active");
						queryCarList(1);
						showCondition();
					}else{
						if(min>0){
							
						}else{
							$("#minPrice").val("");
						}
						if(max>0){
							
						}else{
							$("#maxPrice").val("");
						}
						alert("请输入正确的价格范围");
						return;
					}
					
					if(!$pshow){
						$("#minPrice").val("");
						$("#maxPrice").val("");
						$(".popup-price").show();
						$pshow=true;
					}else{
						$("#minPrice").val("");
						$("#maxPrice").val("");
						$(".popup-price").hide();
						$pshow=false;
					}
				});	
				
				function changeUrl(path){
					if(path.substr(0,3) == "315"){
						return path.replace(/315/,"${img_315c_url}");
					}else{
						if(path=="NULL"){
							return "http://www.chetuan.com/images/pic_no_big.png";
						}
						return path;
					}
				}

		</script>
		<input type="hidden" id="catalogid" value="">
		<input type="hidden" id="catalogname" value="">
		<input type="hidden" id="price" value="">
		<input type="hidden" id="level" value="">
		<input type="hidden" id="displm" value="">
		<input type="hidden" id="transmission" value="">
		<input type="hidden" id="structure" value="">
		<input type="hidden" id="fuel" value="">
</body>
</@cc.html2>