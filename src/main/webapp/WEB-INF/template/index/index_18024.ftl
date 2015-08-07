<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "���Ͳ����Ա�-������" "���������������ṩ���ֳ��Ͳ����Աȣ�����������������O2O�����һƷ�ơ�" "�����Ա�">
<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<script src="${www_ct_url}js/position_div.js" type="text/javascript"></script>
<script type="text/javascript" >

var carMain = "";
$(document).ready(function(){
		$(document).click(function(){
			$(".select-option").hide();
			$(".select").removeClass("btn-packup");
		})
		
		$.ajax({
    		url : '${www_ct_url}chetuan/getParamMainTree',
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
				    		url : '${www_ct_url}chetuan/getParamChildTree',
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
				    		url : '${www_ct_url}chetuan/getParamChildTree',
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
			$(this).parents("ul").find("span")[0].innerHTML = "��ѡ��Ʒ��";
			$(this).parents("ul").find("span")[1].innerHTML = "��ѡ��ϵ��";
			$(this).parents("ul").find("span")[2].innerHTML = "��ѡ����";
			$(this).parents("ul").find("span")[0].title = "";
			$(this).parents("ul").find("span")[1].title = "";
			$(this).parents("ul").find("span")[2].title = "";
			$(this).parents("td").find("img").attr("src","http://www.chetuan.com/images/pic_no_big.png")
			$(this).parents("td").find("p").find("a").attr("href","javascript:void(0);")
			var tableinfo=$(".tableinfo");
			for(var i = 0;i<tableinfo.size();i++){
			var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html("");
				}
			}
		});
		
		$(".right-btn").click(function(){
			var title  = $(this).prev().attr("title");
			var nextid = parseInt(title)+1;
			if($(this).parents("ul").find("span")[2].innerHTML == "��ѡ����"){return;}
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
			var src1=$(this).parents(".table-choice").find("img:eq("+title+")").attr("src");
			var src2=$(this).parents(".table-choice").find("img:eq("+nextid+")").attr("src");
			$(this).parents(".table-choice").find("img:eq("+title+")").attr("src",src2);
			$(this).parents(".table-choice").find("img:eq("+nextid+")").attr("src",src1);
			var h1=$(this).parents(".table-choice").find("td:eq("+(title+1)+")").find("p").find("a").attr("href");
			var h2=$(this).parents(".table-choice").find("td:eq("+(nextid+1)+")").find("p").find("a").attr("href");
			$(this).parents(".table-choice").find("td:eq("+(title+1)+")").find("p").find("a").attr("href",h2);
			$(this).parents(".table-choice").find("td:eq("+(nextid+1)+")").find("p").find("a").attr("href",h1);
			var tableinfo=$(".tableinfo");
			for(var i=0;i<tableinfo.size();i++){
				var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					var t1=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html();
					var t2=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+nextid+")").html();
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html(t2);
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+nextid+")").html(t1);
	
				}
			}
			
		});
		
		$(".left-btn").click(function(){
			var title  = $(this).next().attr("title");
			var preid = parseInt(title)-1;
			if($(this).parents("ul").find("span")[2].innerHTML == "��ѡ����"){return;}
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
			var src1=$(this).parents(".table-choice").find("img:eq("+title+")").attr("src");
			var src2=$(this).parents(".table-choice").find("img:eq("+preid+")").attr("src");
			$(this).parents(".table-choice").find("img:eq("+title+")").attr("src",src2);
			$(this).parents(".table-choice").find("img:eq("+preid+")").attr("src",src1);
			var t1=parseInt(title)+1;
			var t2=parseInt(preid)+1;
			var h1=$(this).parents(".table-choice").find("td:eq("+t1+")").find("p").find("a").attr("href");
			var h2=$(this).parents(".table-choice").find("td:eq("+t2+")").find("p").find("a").attr("href");
			$(this).parents(".table-choice").find("td:eq("+t1+")").find("p").find("a").attr("href",h2);
			$(this).parents(".table-choice").find("td:eq("+t2+")").find("p").find("a").attr("href",h1);
			var tableinfo=$(".tableinfo");
			for(var i=0;i<tableinfo.size();i++){
				var trinfo=$(".tableinfo:eq("+i+") tr");
				for(var j=0;j<trinfo.size();j++){
					var t1=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html();
					var t2=$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+preid+")").html();
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+title+")").html(t2);
					$(".tableinfo:eq("+i+") tr:eq("+j+") td:eq("+preid+")").html(t1);
	
				}
			}
		});
		
		
});
function onGetClick(catalogid,setid){
$.ajax({
    		url : '${www_ct_url}chetuan/GetCarParameters',
    		dataType : 'jsonp',
    		data:{catalogid:catalogid},
    		jsonp:'jsonpcallback',
    		success : function(data){
    			var a=data.length;
    			
    			if(data[a-1]=="NULL"){
    			$(".dele-btn:eq("+parseInt(setid)+")").parent().parent().parent().find("img").attr("src","http://www.chetuan.com/images/pic_no_big.png");
    			}else{
    				$(".dele-btn:eq("+parseInt(setid)+")").parent().parent().parent().find("img").attr("src",data[a-1]);
    			}
    			$(".dele-btn:eq("+parseInt(setid)+")").parents("td").find("p").find("a").attr("href","http://tupian.chetuan.com/"+catalogid+"/0/moren.html")
	    		for(var i=0 ;i<data.length-1;i++){
   					if(i<14){
   						$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if( i>=14&&i<27){
   						var a=i-14; 
   						$(".tableinfo:eq(1) tr:eq("+a+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=27&&i<49){
   						var b=i-27;
   						$(".tableinfo:eq(2) tr:eq("+b+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=49&&i<52){
   						var c=i-49;
   						$(".tableinfo:eq(3) tr:eq("+c+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=52&&i<57){
   						var d=i-52;
   						$(".tableinfo:eq(4) tr:eq("+d+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=57&&i<63){
   						var e=i-57;
   						$(".tableinfo:eq(5) tr:eq("+e+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=63&&i<75){
   						var f=i-63;
   						$(".tableinfo:eq(6) tr:eq("+f+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=75&&i<85){
   						var g=i-75;
   						$(".tableinfo:eq(7) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=85&&i<91){
   						var g=i-85;
   						$(".tableinfo:eq(8) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=91&&i<100){
   						var g=i-91;
   						$(".tableinfo:eq(9) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=100&&i<116){
   						var g=i-100;
   						$(".tableinfo:eq(10) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=116&&i<125){
   						var g=i-116;
   						$(".tableinfo:eq(11) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=125&&i<134){
   						var g=i-125;
   						$(".tableinfo:eq(12) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=134&&i<147){
   						var g=i-134;
   						$(".tableinfo:eq(13) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=147&&i<153){
   						var g=i-147;
   						$(".tableinfo:eq(14) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}else if(i>=153&&i<161){
   						var g=i-153;
   						$(".tableinfo:eq(15) tr:eq("+g+") td:eq("+parseInt(setid)+")").html(data[i]);
   					}
   				} 
    		}
		});
}
</script>
<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">����</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">��������</a>&gt;<a class="active" href="javascript:void(0);">�����Ա�</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 1/>
			</div>
			<div class="tools-body" id="box">
				<div>
				<div style="height: 268px;">
					<div id="fixed_top" class="select-areas">
					<table class="table-choice">
						<tr>
							<td class="title">
								<div class="tit-con">
									<p class="title-name">�Աȳ���</p>
									<p>��ק����ͼƬ�ɵ�˳��</p>
									<p><label><input type="checkbox" name="" id="" onclick="makerA(this)">��ʶ������</label></p>
									<p><label><input type="checkbox" name="" id="" onclick="showA(this)">������ͬ��</label></p>
									<p><label><input type="checkbox" name="" id="" onclick="hideA(this)">������ͬ��</label></p>
								</div>
								<div class="tips">�����  ��ѡ��  -��</div>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>��ѡ��Ʒ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">����������ŷ</a>
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
												<span>��ѡ��ϵ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>��������</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
													<dt>�������ڣ�</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "0">
												<span>��ѡ����</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="dele-btn" title = "0" href="javascript:void(0);">ɾ��</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>��ѡ��Ʒ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">����������ŷ</a>
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
												<span>��ѡ��ϵ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>��������</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
													<dt>�������ڣ�</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "1">
												<span>��ѡ����</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "1" href="javascript:void(0);">ɾ��</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>��ѡ��Ʒ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">����������ŷ</a>
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
												<span>��ѡ��ϵ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:280px;display:none;" class="select-option">
												<dl>
													<dt>��������</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
													<dt>�������ڣ�</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "2">
												<span>��ѡ����</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "2" href="javascript:void(0);">ɾ��</a><a class="right-btn" href="javascript:void(0);">&gt;&gt;</a>
									</li>
								</ul>
							</td>
							
							<td>
								<p class="car-icon"><a href="javascript:void(0);"  target="_blank"><img src="${www_ct_url}images/pic_no_big.png"  width="130" height="105"></a></p>
								<ul>
									<li>
										<div style="z-index:60;" class="select select-tools">
											<div class="select-selected" name = "mainTree">
												<span>��ѡ��Ʒ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:146px;display:none;" class="select-option">
												<dl>
													<dd>
														<b>A</b>
														<a href="">����������ŷ</a>
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
												<span>��ѡ��ϵ��</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:246px;display:none;" class="select-option">
												<dl>
													<dt>��������</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
													<dt>�������ڣ�</dt>
													<dd><a href="">����3ϵ</a></dd>
													<dd><a href="">����5ϵ</a></dd>
													<dd><a href="">����X1</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li>
										<div style="z-index:40;" class="select select-tools select-disabled">
											<div class="select-selected" name = "typeTree" id = "4">
												<span>��ѡ����</span>
												<i class="icon-select-arrows"></i>
											</div>
											<div style="width:380px;display:none;" class="select-option">
												<dl>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dt>2014��</dt>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
													<dd><a href=""><span>32.98��</span>3210Li �ֶ���</a></dd>
												</dl>
											</div>
										</div>
									</li>
									<li class="btn">
										<a class="left-btn" href="javascript:void(0);">&lt;&lt;</a><a class="dele-btn" title = "3" href="javascript:void(0);">ɾ��</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
					</div>
					</div>
					<div class="genre-title" id="params-carinfo">
						<h3>������Ϣ</h3>
					</div>
					<table class="tableinfo" id="tableinfo1">
						<tr>
							<th class="title">����ָ����</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"> </td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">������</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">������</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">��*��*��(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����ṹ</th>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">��߳���(km/h)</th>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�ٷ�0-100km/h����(s)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ʵ��0-100km/h����(s)</th>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ʵ��100-0km/h�ƶ�(m)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ʵ���ͺ�(L/100km)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���Ų��ۺ��ͺ�(L/100km)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����ʱ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
					</table>
					<div class="genre-title" id="params-carbody">
						<h3>����</h3>
					</div>
					<table class="tableinfo" id="tableinfo2">
						<tr>
							<th class="title">����(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�߶�(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
						
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ǰ�־�(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
					
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���־�(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">��С��ؼ�϶(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">��������(kg)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����ṹ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">������(��)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">��λ��(��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�����ݻ�(L)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�������ݻ�(L)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						</table>
					<div class="genre-title" id="params-carengine">
						<h3>������</h3>
					</div>
					<table class="tableinfo" id="tableinfo3">
						<tr>
							<th class="title">�������ͺ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����(mL)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">������ʽ</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����������ʽ</th>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">������(��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ÿ��������(��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ѹ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�׾�(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�г�(mm)</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�������(Ps)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�����(W)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">�����ת��(rpm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���Ť��(N��m)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���Ť��ת��(rpm)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���������м���</th>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
							<td class="text"></td>
						</tr><tr>
							<th class="title">ȼ����ʽ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">ȼ�ͱ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">���ͷ�ʽ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�׸ǲ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">������׼</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-transmission">
						<h3>������</h3>
					</div>
					<table class="tableinfo" id="tableinfo4">
						<tr>
							<th class="title">���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��λ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-bottomzhuan">
						<h3>����ת��</h3>
					</div>
					<table class="tableinfo" id="tableinfo5">
						<tr>
							<th class="title">������ʽ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����ṹ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-carstop">
						<h3>�����ƶ�</h3>
					</div>
					<table class="tableinfo" id="tableinfo6">
						<tr>
							<th class="title">ǰ�ƶ�������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ƶ�������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">פ���ƶ�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ��̥���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����̥���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��̥���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-safeconfig">
						<h3>��ȫװ��</h3>
					</div>
					<table class="tableinfo" id="tableinfo7">
						<tr>
							<th class="title">��/����ʻ����ȫ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/���Ų�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/����ͷ������(����)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ϥ������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">̥ѹ���װ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��̥ѹ������ʻ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��ȫ��δϵ��ʾ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ISOFIX��ͯ���νӿ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���������ӷ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����п���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ң��Կ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��Կ������ϵͳ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-carcaokong">
						<h3>�ٿ�����</h3>
					</div>
					<table class="tableinfo" id="tableinfo8">
						<tr>
							<th class="title">ABS������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ƶ�������(EBD/CBC��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ɲ������(EBA/BAS/BA��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǣ��������(ASR/TCS/TRC��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����ȶ�����(ESC/ESP/DSC��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�Զ�פ��/���¸���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���»���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ɱ�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ɱ�ת���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-outerconfig">
						<h3>�ⲿ����</h3>
					</div>
					<table class="tableinfo" id="tableinfo9">
						<tr>
							<th class="title">�綯�촰</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ȫ���촰</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�˶�����׼�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ͻ���Ȧ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�綯������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�綯����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-innerconfig">
						<h3>�ڲ�����</h3>
					</div>
					<table class="tableinfo" id="tableinfo10">
						<tr>
							<th class="title">��Ƥ������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����̵���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����̵綯����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�๦�ܷ�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����̻���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����Ѳ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">������ƵӰ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�г�������ʾ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">HUḐͷ������ʾ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-chair">
						<h3>��������</h3>
					</div>
					<table class="tableinfo" id="tableinfo11">
						<tr>
							<th class="title">��Ƥ/��Ƥ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�˶��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���θߵ͵���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����֧�ŵ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�粿֧�ŵ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ڶ��ſ����Ƕȵ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ڶ��������ƶ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�������ε綯����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�綯���μ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/�����μ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/������ͨ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/�����ΰ�Ħ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�������ηŵ���ʽ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ/���������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ű���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
					</table>
					<div class="genre-title" id="params-pastime">
						<h3>��ý������</h3>
					</div>
					<table class="tableinfo" id="tableinfo12">
						<tr>
							<th class="title">GPS����ϵͳ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��λ��������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�п�̨��ɫ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����Ӳ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����/���ص绰</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ص���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����Һ����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����Դ�ӿ�(AUX/USB/iPod��)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">CD֧��MP3/WMA</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-lights">
						<h3>�ƹ�����</h3>
					</div>
					<table class="tableinfo" id="tableinfo13">
						<tr>
							<th class="title">������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">LED���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�ռ��г���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�Զ�ͷ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ת��ͷ��(������)</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ǰ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��Ƹ߶ȿɵ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����ϴװ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ڷ�Χ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-doorswindow">
						<h3>����/���Ӿ�</h3>
					</div>
					<table class="tableinfo" id="tableinfo14">
						<tr>
							<th class="title">ǰ/��綯����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���������ֹ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��������/���Ȳ���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ӿ��綯����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ӿ�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��/����Ӿ��Զ���ѣĿ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ӿ��綯�۵�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ӿ�����</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��絲������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ų�������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�����廯ױ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
							<td class="text"></td>
						</tr>
						<tr>
							<th class="title">����ˢ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��Ӧ��ˢ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-air">
						<h3>�յ�/����</h3>
					</div>
					<table class="tableinfo" id="tableinfo14">
						<tr>
							<th class="title">�յ����Ʒ�ʽ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���Ŷ����յ�</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�¶ȷ�������</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ڿ�������/���۹���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���ر���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						</table>
					<div class="genre-title" id="params-drivingassistance">
						<h3>�߿Ƽ�����</h3>
					</div>
					<table class="tableinfo" id="tableinfo15">
						<tr>
							<th class="title">�Զ�������λ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">���߸���</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����ɲ��/������ȫϵͳ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">��������ת��ϵͳ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ҹ��ϵͳ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">�п�Һ����������ʾ</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">����ӦѲ��</th>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							
						</tr>
						<tr>
							<th class="title">ȫ������ͷ</th>
							
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
							<td class="text"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="left_nav" class="left-nav">
			<ul>
				<li class="adv_active"><a href="#params-carinfo" id="carinfo">������Ϣ</a></li>
				<li><a href="#params-carbody" id="carbody">����</a></li>
				<li><a href="#params-carengine" id="carengine">������</a></li>
				<li><a href="#params-transmission" id="transmission">������</a></li>
				<li><a href="#params-bottomzhuan" id="bottomzhuan">����ת��</a></li>
				<li><a href="#params-carstop" id="carstop">�����ƶ�</a></li>
				<li><a href="#params-safeconfig" id="safeconfig">��ȫװ��</a></li>
				<li><a href="#params-carcaokong" id="carcaokong">�ٿ�����</a></li>
				<li><a href="#params-outerconfig" id="outerconfig">�ⲿ����</a></li>
				<li><a href="#params-innerconfig" id="innerconfig">�ڲ�����</a></li>
				<li><a href="#params-chair" id="chair">��������</a></li>
				<li><a href="#params-pastime" id="pastime">��ý������</a></li>
				<li><a href="#params-lights" id="lights">�ƹ�����</a></li>
				<li><a href="#params-doorswindow" id="doorswindow">����/���Ӿ�</a></li>
				<li><a href="#params-air" id="air">�յ�/����</a></li>
				<li><a href="#params-drivingassistance" id="drivingassistance">�߿Ƽ�����</a></li>
			</ul>
		</div>
	</div>
	
</@cc.html>
<script type="text/javascript" >
function hideA(e){
//	$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
	var list=$(".tableinfo tr");
	var titleA=$(".table-choice tr td");
	var tlist=new Array();
	var tid=0;
	for(var i=1;i<titleA.length;i++){
		var tit=$(".table-choice tr td:eq("+i+") ul li:eq(2)");
		var ti=tit.find("span")[0].title;
		if(ti.length!=0){
			tlist[tid]=i;
			tid++;
		}	
	}
		
		
	if(e.checked){
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			if(tlist.length>1){
				if(tlist.length==2){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==3){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==4){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[3].innerHTML){
						trStr.hide();
					}
				}
				if(tlist.length==5){
					if(trStr.find("td")[0].innerHTML==trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[3].innerHTML&&trStr.find("td")[0].innerHTML==trStr.find("td")[4].innerHTML){
						trStr.hide();
					}
				}
			}
		}
	}else{
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			trStr.show();
		}
	}
	
}

function showA(e){
//	$(".tableinfo:eq(0) tr:eq("+i+") td:eq("+parseInt(setid)+")").html(data[i]);
	var list=$(".tableinfo tr");
	var titleA=$(".table-choice tr td");
	var tlist=new Array();
	var tid=0;
	for(var i=1;i<titleA.length;i++){
		var tit=$(".table-choice tr td:eq("+i+") ul li:eq(2)");
		var ti=tit.find("span")[0].title;
		if(ti.length!=0){
			tlist[tid]=i;
			tid++;
		}	
	}
		
		
	if(e.checked){
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			if(tlist.length>1){
				if(tlist.length==2){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==3){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==4){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[3].innerHTML){
						trStr.addClass("highlight");
					}
				}
				if(tlist.length==5){
					if(trStr.find("td")[0].innerHTML!=trStr.find("td")[1].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[2].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[3].innerHTML&&trStr.find("td")[0].innerHTML!=trStr.find("td")[4].innerHTML){
						trStr.addClass("highlight");
					}
				}
			}
		}
	}else{
		for(var j=0;j<list.length;j++){
			var trStr=$(".tableinfo tr:eq("+j+")");
			trStr.removeClass("highlight");
			
		}
	}
	
}

function makerA(){
	alert("��δ���ţ�����");
}
</script>