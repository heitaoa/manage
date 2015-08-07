<#import "../common_chetuan.ftl" as cc>
<@cc.html 1>
<head>
	<link rel="stylesheet" href="${www_ct_url}css/tools.css">
	<link rel="stylesheet" href="${www_ct_url}css/style.css">
	<script type="text/javascript" src="${www_ct_url}js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/global.js"></script>
</head>
<body>
	<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="">购车工具</a>&gt;<a class="active" href="">车型报价</a>
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
						<li><a href="#A">A</a></li>
						<li><a href="#B">B</a></li>
						<li><a href="#C">C</a></li>
						<li><a href="#D">D</a></li>
						<li class="none">E</li>
						<li><a href="#F">F</a></li>
						<li><a href="#G">G</a></li>
						<li><a href="#H">H</a></li>
						<li class="none">I</li>
						<li><a href="#J">J</a></li>
						<li><a href="#K">K</a></li>
						<li><a href="#L">L</a></li>
						<li><a href="#M">M</a></li>
						<li><a href="#N">N</a></li>
						<li><a href="#O">O</a></li>
						<li><a href="#P">P</a></li>
						<li><a href="#Q">Q</a></li>
						<li><a href="#R">R</a></li>
						<li><a href="#S">S</a></li>
						<li><a href="#T">T</a></li>
						<li class="none">U</li>
						<li class="none">V</li>
						<li><a href="#W">W</a></li>
						<li><a href="#X">X</a></li>
						<li><a href="#Y">Y</a></li>
						<li><a href="#Z">Z</a></li>
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
									<li><a href="javascript:void(0);" value="40-60万">40-60万</a></li>
									<li><a href="javascript:void(0);" value="60-80万">60-80万</a></li>
									<li><a href="javascript:void(0);" value="80万以上">80万以上</a></li>
									<li><button id="p_conf" href="javascript:void(0);" value="">自定义</button></li>
									<div class="popup-price" style="display:none;">
										<div class="input-box">
											<input type="text" id="minPrice" maxlength="4"> 至 <input id="maxPrice" type="text" maxlength="4"> 万
										</div>
										<div class="btn"><a style="cursor:pointer;" id="price_">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="cursor:pointer;" id="price_close">收起</a></div>
									</div>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>级别：</dt>
							<dd class="aabbcc3">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="微型车">微型车</a></li>
									<li><a href="javascript:void(0);" value="小车型">小车型</a></li>
									<li><a href="javascript:void(0);" value="经凑型">经凑型</a></li>
									<li><a href="javascript:void(0);" value="中高级车">中高级车</a></li>
									<li><a href="javascript:void(0);" value="跑车">跑车</a></li>
									<li><a href="javascript:void(0);" value="豪华车">豪华车</a></li>
									<li><a href="javascript:void(0);" value="SUV">SUV</a></li>
									<li><a href="javascript:void(0);" value="MPV">MPV</a></li>
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
									<li><a href="javascript:void(0);" value="手动">手动</a></li>
									<li><a href="javascript:void(0);" value="自动">自动</a></li>
									<li><a href="javascript:void(0);" value="手自一体">手自一体</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>结构：</dt>
							<dd class="aabbcc6">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="两厢">两厢</a></li>
									<li><a href="javascript:void(0);" value="三厢">三厢</a></li>
									<li><a href="javascript:void(0);" value="掀背">掀背</a></li>
									<li><a href="javascript:void(0);" value="旅行版">旅行版</a></li>
									<li><a href="javascript:void(0);" value="硬顶敞篷车">硬顶敞篷车</a></li>
									<li><a href="javascript:void(0);" value="软顶敞篷车">软顶敞篷车</a></li>
									<li><a href="javascript:void(0);" value="硬顶跑车">硬顶跑车</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>燃料：</dt>
							<dd class="aabbcc7">
								<ul>
									<li><a class="active" href="javascript:void(0);" value="">不限</a></li>
									<li><a href="javascript:void(0);" value="汽油">汽油</a></li>
									<li><a href="javascript:void(0);" value="柴油">柴油</a></li>
									<li><a href="javascript:void(0);" value="电动">电动</a></li>
									<li><a href="javascript:void(0);" value="油电混合">油电混合</a></li>
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
						<table>
							<tr>
								<th width="50%">车型名称</th>
								<th width="12%">报价</th>
								<th width="12%">经销商</th>
								<th width="16%">日期</th>
								<th width="10%">更多信息</th>
							</tr>
							<script type="text/javascript" src="${www_ct_url}sub/block_19645.js?v=${ver}"></script>
						</table>
					</div>
				</div>
				
				<div class="news-car">
					<div class="title-nav">
						<div class="title-subcnt">
							<ul>
								<li class="selected"><span>上海活动</span></li>
								<li><span>商家优惠</span></li>
								<li><span>新车到店</span></li>
								<li class="last"><span>维权投诉</span></li>
							</ul>
						</div>
					</div>
					<div class="title-content">
						<div style="display:block;" class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19646.js?v=${ver}"></script>
							<div class="article-more"><a href="">查看更多新闻 ??</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19647.js?v=${ver}"></script>
							<div class="article-more"><a href="">查看更多新闻 ??</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19648.js?v=${ver}"></script>
							<div class="article-more"><a href="">查看更多新闻 ??</a></div>
						</div>
						<div class="content-item">
							<script type="text/javascript" src="${www_ct_url}sub/block_19649.js?v=${ver}"></script>
							<div class="article-more"><a href="">查看更多新闻 </a></div>
						</div>
					</div>
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
							html = html + "<a name='"+key1+"'><b>"+key1+"</b></a><ul class='tree-item-box'>";
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
							
							$("#catalogid").attr("value",$(this).attr("value").split("-")[0]);
							$("#catalogname").attr("value",$(this).attr("value").split("-")[1]);
							//$(this).addClass("active").parents().siblings().find("a").removeClass("active");
							queryCarList(1);
							showCondition();
						});
		    		}
				});
				queryCarList(1);
			})
					
			$(".aabbcc2 a").click(function(){
				$("#price").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);	
				showCondition();
			});
			
			$(".aabbcc3 a").click(function(){
				$("#level").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc4 a").click(function(){
				$("#displm").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc5 a").click(function(){
				$("#transmission").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc6 a").click(function(){
				$("#structure").attr("value",$(this).attr("value"));
				$(this).parents("ul").find("a").removeClass("active");
				$(this).addClass("active");
				queryCarList(1);
				showCondition();
			});
			
			$(".aabbcc7 a").click(function(){
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
	    		url : '${www_ct_url}/chetuan/carPayList',
	    		dataType : 'jsonp',
	    		data:{catalogid:encodeURI(catalogid),level:encodeURI(level),price:encodeURI(price),displm:encodeURI(displm),transmission:encodeURI(transmission),structure:encodeURI(structure),fuel:encodeURI(fuel),page:objPage},
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
							+'<div class="pic"><img src="'+getImagePath(list[i].photo,list[i].photo202135)+'" alt=""></div>'
							+'<div class="info">'
							+'<p class="title"><a href="">'+list[i].cname+'</a></p>'
							+'<span class="price">价格：'+list[i].dprice+'</span>'
							+'</div>'
							+'</li>'
						}	
					}else{
						html=html
						+'<div style="margin-left:25px;">'
						+'<div><font size="3px" color="red">没有查询到相关车型。</font></div>'
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
						pageHtml+='<a  style="cursor:pointer;" value="'+(page-1)+'">上一页</a>';
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
						
						pageHtml+='<a  style="cursor:pointer;" value="'+(page+1)+'">下一页</a>';
						pageHtml+='<a  style="cursor:pointer;" value="'+(totalPage)+'">末页</a>';
						pageHtml+='</div>';
					}
					pageHtml+='</div>';
					
					html = html+pageHtml;
					$("#showCar").html(html);				
					
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
					
					if(catalogid!=null && catalogid != ""){
						html+='<li><a href="javascript:void(0);" value="catalogid">'+catalogname+'</a></li>';
						flag = true;
					}
					if(price!=null && price != ""){
						html+='<li><a href="javascript:void(0);" value="price">'+price+'</a></li>';
						flag = true;
					}
					
					if(level!=null && level != ""){
						html+='<li><a href="javascript:void(0);" value="level">'+level+'</a></li>';
						flag = true;
					}
					
					if(displm!=null && displm != ""){
						html+='<li><a href="javascript:void(0);" value="displm">'+displm+'</a></li>';
						flag = true;
					}
					if(transmission!=null && transmission != ""){
						html+='<li><a href="javascript:void(0);" value="transmission">'+transmission+'</a></li>';
						flag = true;
					}
					if(structure!=null && structure != ""){
						html+='<li><a href="javascript:void(0);" value="structure">'+structure+'</a></li>';
						flag = true;
					}
					if(fuel!=null && fuel != ""){
						html+='<li><a href="javascript:void(0);" value="fuel">'+fuel+'</a></li>';
						flag = true;
					}
					if(flag){
						html='<dt>条件：</dt><dd><ul>'+html;
						html+='<li><a href="javascript:void(0);" value="clearCondition">清除条件</a></li>';
						html+='</ul>';
						html+='</dd>';
					}
																		
					$(".aabbcc1").html(html);
					
					$(".aabbcc1 a").click(function(){
						var value = $(this).attr("value");
						if(value=="price"){
							if($pshow){
								$(".popup-price").hide();
								$pshow=false;
							}
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
							if($pshow){
								$(".popup-price").hide();
								$pshow=false;
							}
						}else{
							$("#"+value).attr("value","");
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
					$minp=$("#minPrice").val().trim();
					$maxp=$("#maxPrice").val().trim();
					
					if($minp==""&&$maxp==""){
						$(".popup-price").hide();
						$pshow=false;
						return;
					}
					
					if($minp==""||$maxp==""){
						alert("请输入价格范围！");
						return;
					}
					var min=parseInt($minp);
					var max=parseInt($maxp);
					if(min<max){
						$("#price").attr("value",min+"-"+max);
						$(this).parents("ul").find("a").removeClass("active");
						queryCarList(1);
						showCondition();
					}else{
						alert("输入不正确！");
					}
				});	

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
</@cc.html>