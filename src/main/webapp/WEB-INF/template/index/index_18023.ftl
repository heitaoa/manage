<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "车型图片对比-车团网"  "车团网购车工具提供各种车型图片对比，车团网，汽车电商O2O服务第一品牌。" "图片对比">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<script src="${www_ct_url}js/position_pic_duibi.js" type="text/javascript"></script>
<script type="text/javascript" >

var carMain = "";

$(document).ready(function(){
		$(document).click(function(){
			$(".select-option").hide();
			$(".select").removeClass("btn-packup");
		})

		$.ajax({
    		url : '${www_ct_url}chetuan/getMainTree',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carMain = data[0];
    		}
		});
		
		
		
		$(".select").find(".select-selected").on("click", function(event) {
		
			if($(this).attr("name") == "mainTree"){
				if($(this).next().is(":hidden")) {
					var html = '<dl>';
					var map = carMain;
					for(var key1 in map){
							for (var i =0 ;i<map[key1].length;i++) {
								html = html + '<dd><b>'+key1+'</b>';
								html = html +  '<a value="'+map[key1][i].catalogid+'">'+map[key1][i].catalogname+'</a>';
								html = html + '</dd>';
							}
					}
					html = html + '</dl>';
					$(this).next().html(html);
					$(this).next().show();
					$(this).parent().addClass("btn-packup");
					$(".select .select-option a").on("click", function() {
						var txt = $(this).text();
						var value = $(this).attr("value");
						$(this).parentsUntil(".select").prev().find("span").text(txt);
						$(this).parentsUntil(".select").prev().find("span").attr("title",value);
						$(".select-option").hide().parent().removeClass("btn-packup");
						$(this).parents("li").next().find(".select").removeClass("select-disabled");
					});
					event.stopPropagation();
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
			
			
			if($(this).attr("name") == "lineTree"){
				if($(this).next().is(":hidden")) {
					var catalogid = ($(this).parents("li").prev().find("span")[0].title);
					if(catalogid==""){return;};
					var clickDiv = $(this);
					$.ajax({
				    		url : '${www_ct_url}chetuan/getChildTree',
				    		dataType : 'jsonp',
				    		data:{catalogid:catalogid},
				    		jsonp:'jsonpcallback',
				    		success : function(data){
					    		carline = data;
					    		var html = '<dl>';
								var data = carline;
								for(var i = 0;i<data.length;i++){
									html = html +  '<dd><a value="'+data[i].catalogid+'">'+data[i].catalogname+'</a>';
									html = html + '</dd>';
								}
								html = html + '</dl>';
								clickDiv.next().html(html);
								clickDiv.next().show();
								clickDiv.parent().addClass("btn-packup");
								$(".select .select-option a").on("click", function() {
									var txt = $(this).text();
									var value = $(this).attr("value");
									$(this).parentsUntil(".select").prev().find("span").text(txt);
									$(this).parentsUntil(".select").prev().find("span").attr("title",value);
									$(".select-option").hide().parent().removeClass("btn-packup");
									$(this).parents("li").next().find(".select").removeClass("select-disabled");
								});
								event.stopPropagation();
				    		}
					});
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
			
			if($(this).attr("name") == "typeTree"){
				if($(this).next().is(":hidden")) {
					var catalogid = ($(this).parents("li").prev().find("span")[0].title);
					if(catalogid==""){return;};
					var clickDiv = $(this);
					$.ajax({
				    		url : '${www_ct_url}chetuan/getChildTree',
				    		dataType : 'jsonp',
				    		data:{catalogid:catalogid},
				    		jsonp:'jsonpcallback',
				    		success : function(data){
					    		carline = data;
					    		var html = '<dl>';
								var data = carline;
								for(var i = 0;i<data.length;i++){
									html = html +  '<dd><a value="'+data[i].catalogid+'">'+data[i].catalogname+'</a>';
									html = html + '</dd>';
								}
								html = html + '</dl>';
								clickDiv.next().html(html);
								clickDiv.next().show();
								clickDiv.parent().addClass("btn-packup");
								$(".select .select-option a").on("click", function() {
									var txt = $(this).text();
									var value = $(this).attr("value");
									var id = $(this).parents(".select").find(".select-selected")[0].id;
									onGetClick(value,id);
									$(this).parentsUntil(".select").prev().find("span").text(txt);
									$(this).parentsUntil(".select").prev().find("span").attr("title",value);
									$(".select-option").hide().parent().removeClass("btn-packup");
								});
								event.stopPropagation();
				    		}
					});
				}else{
					$(this).next().hide();
					$(this).parent().removeClass("btn-packup");
				}
			}
		});
		
		$(".dele-btn").click(function(){
			var title = $(this).attr("title");
			$(this).parents("ul").find(".select")[1].className = "select select-tools select-disabled";
			$(this).parents("ul").find(".select")[2].className = "select select-tools select-disabled";
			$(this).parents("ul").find("span")[0].innerHTML = "请选择品牌";
			$(this).parents("ul").find("span")[1].innerHTML = "请选择系列";
			$(this).parents("ul").find("span")[2].innerHTML = "请选择车型";
			$(this).parents("ul").find("span")[0].title = "";
			$(this).parents("ul").find("span")[1].title = "";
			$(this).parents("ul").find("span")[2].title = "";
			for(var i = 0;i<9;i++){
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img")[0].src = "${www_ct_url}images/pic_no_big.png";
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("style");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("onclick");
			}
		})
		
		$(".right-btn").click(function(){
			var title  = $(this).prev().attr("title");
			var nextid = parseInt(title)+1;
			if($(this).parents("ul").find("span")[2].innerHTML == "请选择车型"){return;}
			var innerHTML0 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].innerHTML;
			var innerHTML1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].innerHTML;
			var innerHTML2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].innerHTML;
			var title0 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].title;
			var title1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].title;
			var title2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].title;
			var className1 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[1].className;
			var className2 = $(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[2].className;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].innerHTML = $(this).parents("ul").find("span")[0].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].innerHTML = $(this).parents("ul").find("span")[1].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].innerHTML = $(this).parents("ul").find("span")[2].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[0].title = $(this).parents("ul").find("span")[0].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[1].title = $(this).parents("ul").find("span")[1].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find("span")[2].title = $(this).parents("ul").find("span")[2].title;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[1].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents(".table-choice").find("ul:eq("+nextid+")").find(".select")[2].className = $(this).parents("ul").find(".select")[2].className;
			$(this).parents("ul").find(".select")[1].className = className1;
			$(this).parents("ul").find(".select")[2].className = className2;
			$(this).parents("ul").find("span")[0].innerHTML = innerHTML0;
			$(this).parents("ul").find("span")[1].innerHTML = innerHTML1;
			$(this).parents("ul").find("span")[2].innerHTML = innerHTML2;
			$(this).parents("ul").find("span")[0].title = title0;
			$(this).parents("ul").find("span")[1].title = title1;
			$(this).parents("ul").find("span")[2].title = title2;
			for(var i = 0;i<9;i++){
				var src =  $(".list-ul:eq("+parseInt(i)+") li:eq("+nextid+")").find("img")[0].src;
				var styleStr = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").attr("style");
				var onclickStr = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").attr("onclick");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+nextid+")").find("img").attr("style",styleStr);
				$(".list-ul:eq("+parseInt(i)+") li:eq("+nextid+")").find("img").attr("onclick",onclickStr);
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("style");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("onclick");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+nextid+")").find("img")[0].src = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img")[0].src;
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img")[0].src = src;
			}
		});
		
		$(".left-btn").click(function(){
			var title  = $(this).next().attr("title");
			var preid = parseInt(title)-1;
			if($(this).parents("ul").find("span")[2].innerHTML == "请选择车型"){return;}
			var innerHTML0 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].innerHTML;
			var innerHTML1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].innerHTML;
			var innerHTML2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].innerHTML;
			var title0 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].title;
			var title1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].title;
			var title2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].title;
			var className1 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[1].className;
			var className2 = $(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[2].className;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].innerHTML = $(this).parents("ul").find("span")[0].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].innerHTML = $(this).parents("ul").find("span")[1].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].innerHTML = $(this).parents("ul").find("span")[2].innerHTML;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[0].title = $(this).parents("ul").find("span")[0].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[1].title = $(this).parents("ul").find("span")[1].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find("span")[2].title = $(this).parents("ul").find("span")[2].title;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[1].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents(".table-choice").find("ul:eq("+preid+")").find(".select")[2].className = $(this).parents("ul").find(".select")[1].className;
			$(this).parents("ul").find(".select")[1].className = className1;
			$(this).parents("ul").find(".select")[2].className = className2;
			$(this).parents("ul").find("span")[0].innerHTML = innerHTML0;
			$(this).parents("ul").find("span")[1].innerHTML = innerHTML1;
			$(this).parents("ul").find("span")[2].innerHTML = innerHTML2;
			$(this).parents("ul").find("span")[0].title = title0;
			$(this).parents("ul").find("span")[1].title = title1;
			$(this).parents("ul").find("span")[2].title = title2;
			for(var i = 0;i<9;i++){
				var src = $(".list-ul:eq("+parseInt(i)+") li:eq("+preid+")").find("img")[0].src;
				var styleStr = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").attr("style");
				var onclickStr = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").attr("onclick");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+preid+")").find("img").attr("style",styleStr);
				$(".list-ul:eq("+parseInt(i)+") li:eq("+preid+")").find("img").attr("onclick",onclickStr);
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("style");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img").removeAttr("onclick");
				$(".list-ul:eq("+parseInt(i)+") li:eq("+preid+")").find("img")[0].src = $(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img")[0].src;
				$(".list-ul:eq("+parseInt(i)+") li:eq("+parseInt(title)+")").find("img")[0].src = src;
			}
		});
		
});
function onGetClick(catalogid,setid){
    $.ajax({
    		url : '${www_ct_url}chetuan/getCarTypeImage',
    		data:{catalogid:catalogid},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		var imageJsonStr = data[0];
	    		var waishi = imageJsonStr["1"];
	    		var neishi = imageJsonStr["2"];
	    		var zhongkong = imageJsonStr["3"];
	    		var index = 0;
	    		for(var i = 0;i<3;i++){
	    			if(waishi == undefined){
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = "${www_ct_url}images/pic_default_big.png";
	    				
	    			}else{
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = getImagePath(waishi[i].path,waishi[i].path222166);
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("onclick","openCarImageDetail("+waishi[i].catalogid+",1,"+i+")");
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("style","cursor:pointer;");
	    			}
	    			index = index+1;
	    		}
	    		for(var i = 0;i<3;i++){
	    			if(waishi == undefined){
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = "${www_ct_url}images/pic_default_big.png";
	    			}else{
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = getImagePath(neishi[i].path,neishi[i].path222166);
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("onclick","openCarImageDetail("+neishi[i].catalogid+",2,"+i+")");
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("style","cursor:pointer;");
	    			}
	    			index = index+1;
	    		}
	    		for(var i = 0;i<3;i++){
	    			if(waishi == undefined){
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = "${www_ct_url}images/pic_default_big.png";
	    			}else{
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img")[0].src = getImagePath(zhongkong[i].path,zhongkong[i].path222166);
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("onclick","openCarImageDetail("+zhongkong[i].catalogid+",3,"+i+")");
	    				$(".list-ul:eq("+parseInt(index)+") li:eq("+parseInt(setid)+")").find("img").attr("style","cursor:pointer;");
	    			}
	    			index = index+1;
	    		}
    		}
	});
}
function getImagePath(path1,path2){
		if(path2!=undefined){
			return path2;
		}
		return path1.replace(/ct1/,"${www_ct_url}").replace(/.jpg/,"_222x166.jpg");
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
	<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">购车工具</a>&gt;<a class="active" href="javascript:void(0);">图片对比</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 2/>
			</div>
			<div id="box" class="tools-body">
				<div class="choice-cont" style="height:120px;">
					<div id="fixTopPic" class="select-areas2">
					<table class="table-choice">
						<tr>
							<td>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">阿尔法罗密欧</a>
													</dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "0">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:346px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="dele-btn" title = "0" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">阿尔法罗密欧</a>
													</dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "1">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:346px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "1" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">阿尔法罗密欧</a>
													</dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "2">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:346px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "2" href="javascript:void(0);">删除</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td class="r-brd-no">
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>请选择品牌</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">阿尔法罗密欧</a>
													</dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
													<dd></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:50;" class="select select-tools select-disabled">
											<div class="select-selected" name = "lineTree">
												<span>请选择系列</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="display:none;" class="select-option">
												<dl>
													<dt>华晨宝马</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
													<dt>宝马（进口）</dt>
													<dd><a href="">宝马3系</a></dd>
													<dd><a href="">宝马5系</a></dd>
													<dd><a href="">宝马X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "3">
												<span>请选择车型</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:346px;display:none;" class="select-option">
												<dl>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dt>2014款</dt>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
													<dd><a href=""><span>32.98万</span>3210Li 手动型</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "3" href="javascript:void(0);">删除</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
					</div>
				</div>
				<div id="car_waiguan" class="content-title">
					<i class="icon"></i>
					<h3>外观</h3>
				</div>
				<div class="content-list">
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png"  alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>外观</p></div>
						</li>
					</ul>
				</div>
				<div id="car_neishi" class="content-title">
					<i class="icon"></i>
					<h3>内饰</h3>
				</div>
				<div class="content-list">
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>内饰</p></div>
						</li>
					</ul>
				</div>
				
				<div id="car_zhongkong" class="content-title">
					<i class="icon"></i>
					<h3>中控</h3>
				</div>
				<div class="content-list">
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
					</ul>
					<ul class="list-ul">
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li>
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
						<li class="r-brd-no">
							<div class="img"><img src="${www_ct_url}images/pic_no_big.png" alt=""></div>
							<div class="title"><p>中控</p></div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="left_nav" class="left-nav pos-set">
			<ul>
				<li class="adv_active"><a href="#car_waiguan" id="WaiGuan">外观</a></li>
				<li><a href="#car_neishi" id="NeiShi">内饰</a></li>
				<li><a href="#car_zhongkong" id="ZhongKong">中控</a></li>
			</ul>
		</div>
	</div>
</@cc.html>
