<#import "../common_chetuan.ftl" as cc>
<@cc.html2 9>
	<script src="${www_ct_url}js/jquery.js?v=${ver}" type="text/javascript"></script>
	<script type="text/javascript" src="${www_ct_url}js/jquery.bxslider.min.js?v=${ver}"></script>
	<script type="text/javascript" src="${www_ct_url}js/url.js"></script>
	<!--[if lt IE 7]>
        <script type="text/javascript" src="${www_ct_url}js/unitpngfix.js?v=${ver}"></script>
	<![endif]-->
	
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
	
	<script type="text/javascript" >
	var firstid = "";
	var secondid = "";
	var thirdid = "";
	var isGetSe = false;
	$(document).ready(function(){
		var $galleryFocusBar = $(".focus-article .focus-side li");
		$galleryFocusBar.on("mouseenter mouseleave", function() {
			$(this).addClass("active").siblings().removeClass("active");
			var index = $galleryFocusBar.index(this);
			$(".focus-pic > a").eq(index).show().siblings().hide();
		});
		
		firstid = window.url('1',window.location.href);
		if(firstid != ""){
			secondid = window.url('2',window.location.href);
  			thirdid = window.url('3',window.location.href);
			isGetSe = true;
		}
		
		$(".nav a").click(function(){
			var value = $(this).attr("value");
			var alltop = parseInt($(".left-tree")[0].scrollTopMax);
			if ((navigator.userAgent.indexOf('MSIE') >= 0) 
			    && (navigator.userAgent.indexOf('Opera') < 0)){
			    alltop = parseInt($(".left-tree")[0].scrollTopMax);
			}
			var nowtop = parseInt($(".root #"+value)[0].offsetTop);
			if(alltop < nowtop){
				$("ul.tree").append("<li id='tree-bottom' style='height:"+(nowtop-alltop)+"px;overflow:hidden;'></li>")
			}
			$(".left-tree").scrollTop($(".root #"+value)[0].offsetTop);
		});
  		
		
		$.ajax({
    		url : '${www_ct_url}chetuan/getMainTree',
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
						html = html +  "<li><a class='main-brand' href='javascript:getChild("+map[key1][i].catalogid+","+addChild+")' >";
						html = html + "<em id='"+map[key1][i].catalogid+"' key='"+addChild+"'>"+map[key1][i].catalogname+"</em>";
						html = html + "</a><ul class='tree-items'></ul></li>";
						addChild = addChild+1;
					}
					html = html + "</ul></li>";
				}
				//html = html + "<li id='tree-bottom' style='height:472px;overflow:hidden;'></li>";
				$("ul.tree").html(html)
				if(isGetSe){
					getChild(firstid,$("em#"+firstid).attr("key"));
				}
    		}
		});
	})
	
	
	
	function getChild(catalogid,addChild){
		var ul = $("ul.tree-items")
		if(ul[addChild].innerHTML != ""){
			ul[addChild].innerHTML = "";
			if(!isGetSe){
				getCarTypeImage(catalogid);
			}
			return;
		}
		for(var i = 0;i<ul.length;i++){
			ul[i].innerHTML = "";
		}
		if(!isGetSe){
			getCarTypeImage(catalogid);
		}
		$.ajax({
    		url : '${www_ct_url}chetuan/getChildTree',
    		data:{catalogid:catalogid},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		var html = "";
				var addSecondChild = 0;
				for(var i = 0;i<data.length;i++){
					html = html + "<li><a class='brand-type' href='javascript:getSecondChild("+data[i].catalogid+","+addSecondChild+")'>";
					html = html + "<em id='"+data[i].catalogid+"' key='"+addSecondChild+"'>"+data[i].catalogname+"</em></a><ul class='tp'></ul></li>";
					addSecondChild = addSecondChild+1
				}
				ul[addChild].innerHTML = html;
				if(isGetSe){
					$(".left-tree").scrollTop($("em#"+secondid)[0].offsetTop);
					getSecondChild(secondid,$("em#"+secondid).attr("key"));
				}
    		}
		});
	}
	
	
	function getSecondChild(catalogid,addChild){
		var ul = $("ul.tp")
		if(ul[addChild].innerHTML == ""){
			if(!isGetSe){
				getCarTypeImage(catalogid);
			}
			$.ajax({
	    		url : '${www_ct_url}chetuan/getChildTree',
	    		dataType : 'jsonp',
	    		data:{catalogid:catalogid,key:"sec"},
	    		jsonp:'jsonpcallback',
	    		success : function(data){
		    		var html = "";
					for(var i = 0;i<data.length;i++){
						html = html + "<li><a class='sub-brand' href='javascript:getCarTypeImage("+data[i].catalogid+")'>";
						
						html = html + "<em id='"+data[i].catalogid+"' class='tooltip'title='"+data[i].catalogname+"'>"+(data[i].catalogname).substr(0,14)+"</em></a></li>";
					}
					ul[addChild].innerHTML = html;
					if(isGetSe){
						if(thirdid==""){
							if(data.length>0){
								getCarTypeImage(data[0].catalogid);
							}
						}else{
							getCarTypeImage(thirdid);
						}
					}
					var x = 10;  
					var y = 20;
					$("em.tooltip").mouseover(function(e){
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
	    		}
			});
		}else{
			if(!isGetSe){
				getCarTypeImage(catalogid);
			}
		}
	}
	var imageJsonStr;
	function getCarTypeImage(catalogid){
		$(".tree a").removeClass("current");
		$("em#"+catalogid).parent().addClass("current");
		$.ajax({
    		url : '${www_ct_url}chetuan/getCarTypeImage',
    		data:{catalogid:catalogid},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			imageJsonStr = data;
    			html1 = ceateImageTypeDiv(data[0]["1"],1);
    			html2 = ceateImageTypeDiv(data[0]["2"],2);
    			html3 = ceateImageTypeDiv(data[0]["3"],3);
    			html4 = ceateImageTypeDiv(data[0]["4"],4);
    			html5 = ceateImageTypeDiv(data[0]["5"],5);
    			html6 = ceateImageTypeDiv(data[0]["6"],6);
    			var html = "";
    			if(html1 != undefined){
    				html = html+html1;
    			}
    			if(html2 != undefined){
    				html = html+html2;
    			}
    			if(html3 != undefined){
    				html = html+html3;
    			}
    			if(html4 != undefined){
    				html = html+html4;
    			}
    			if(html5 != undefined){
    				html = html+html5;
    			}
    			if(html6 != undefined){
    				html = html+html6;
    			}
    			$(".right-body").html(html);
				$(".Appearance").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
				$(".Seats").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
				$(".Control").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
				$(".Other").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
				$(".Tujie").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
				$(".Guantu").bxSlider({
					pager: false,
					controls: true,
					nextText: '>',
					prevText: '<'
				});
    		}
		});
	}
	
	function ceateImageTypeDiv(type,key){
		if(type == undefined){
			return;
		}
		var name = "";
		classname = "";
		if(key == 1){
			name = "车身外观";
			classname = "Appearance";
		}
		if(key == 2){
			name = "车厢座椅";
			classname = "Seats";
		}
		if(key == 3){
			name = "中控方向盘";
			classname = "Control";
		}
		if(key == 4){
			name = "其它与改装";
			classname = "Other";
		}
		if(key == 5){
			name = "车型图解";
			classname = "Tujie";
		}
		if(key == 6){
			name = "官方图";
			classname = "Guantu";
		}
		var str='';
		str+='<div class="gallery-style01">';
		str+='        <h2 class="title"><i></i>'+name+'<span class="ora-line"></span></h2>    ';
		str+='        <div class="con">    ';
		str+='            <ul class="'+classname+'">    ';
		for(var i = 0;i<type.length;i++){
			if(i%5 == 0){
				str+='                <li>';
			}
			if(i%5 == 0){
				str+='                    <dl class="head">';
				str+='                        <dd><a href="javascript:openCarImageDetail('+type[i].catalogid+','+key+','+i+')"><img src="'+getImagePath(type[i].path,type[i].path343247)+'" alt=""></a></dd>';
				str+='                        <dt><a href="">'+type[i].title+'</a></dt>';
				str+='                    </dl>';
			}else{
				str+='                    <dl >';
				str+='                        <dd><a href="javascript:openCarImageDetail('+type[i].catalogid+','+key+','+i+')"><img src="'+getImagePath(type[i].path,type[i].path160106)+'" alt=""></a></dd>';
				str+='                        <dt><a href=""></a></dt>';
				str+='                    </dl>';
			}
			if((i+1)%5 == 0 || i == type.length-1){
				str+='                </li>    ';
			}
			if(i == 14){
				break;
			}
		}
		str+='            </ul>    ';
		str+='        </div>    ';
		str+='    </div>    ';
		return str;
	}	
	
	function getImagePath(path1,path2){
		if(path2!=undefined){
			return path2;
		}
		return path1.replace(/ct1/,"${www_ct_url}");
	}
	
	function openCarImageDetail(catalogid,key,imageIndex){
		var htmlStr = "";
		if(key == 1){
			htmlStr = "waiguan.html"
		}
		if(key == 2){
			htmlStr = "neishi.html"
		}
		if(key == 3){
			htmlStr = "zhongkong.html"
		}
		if(key == 4){
			htmlStr = "gaizhuang.html"
		}
		if(key == 5){
			htmlStr = "tujie.html"
		}
		if(key == 6){
			htmlStr = "guantu.html"
		}
		if(key!=undefined){
			window.open("${pic_ct_url}"+catalogid+"/"+key+"/"+imageIndex+"/"+htmlStr);
		}else{
			window.open("${pic_ct_url}"+catalogid+"/0/moren.html");
		}
	}
	
	</script>
</head>

	<div class="content">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a class="active" href="${pic_ct_url}">图库</a>
		</ul>
		<div class="borer-top-01">
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
				<div class="focus-article clearfix">
					<script type="text/javascript" src="${www_ct_url}sub/block_30.js?v=${ver}"></script>
				</div>
				<script type="text/javascript" src="${www_ct_url}sub/block_16634.js?v=${ver}"></script>
				<script type="text/javascript" src="${www_ct_url}sub/block_276.js?v=${ver}"></script>
				<div class="gallery-style01">
					<h2 class="title"><i></i>各级别车型<span class="ora-line"></span></h2>
						<div class="con">
							<div class="level-bar">
								<ul>
									<li class="selected" ><a href="javascript:void(0);">微型车</a></li>
									<li><a href="javascript:void(0);">小型车</a></li>
									<li><a href="javascript:void(0);">紧凑型</a></li>
									<li><a href="javascript:void(0);">中型车</a></li>
									<li><a href="javascript:void(0);">中大型车</a></li>
									<li><a href="javascript:void(0);">豪华型</a></li>
									<li><a href="javascript:void(0);">SUV</a></li>
									<li><a href="javascript:void(0);">MPV</a></li>
									<li><a href="javascript:void(0);">跑车</a></li>
								</ul>
							</div>
							<div class="level-tab">
								<script type="text/javascript" src="${www_ct_url}sub/block_16635.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16636.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16637.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16638.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16639.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16640.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16641.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16642.js?v=${ver}"></script>
								<script type="text/javascript" src="${www_ct_url}sub/block_16643.js?v=${ver}"></script>
	
							</div>
						</div>
					</div>
				</div>
				<div class="footer">
					<@cc.footer/>
				</div>
			</div>
			
		</div>
		
	</div>
	<!-- 主内容 end -->
	
</@cc.html2>
