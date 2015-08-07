<#import "../common_chetuan.ftl" as cc>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="gb2312">
	<link rel="stylesheet" href="${www_ct_url}css/car_gallery.css">
	<script type="text/javascript" src="${www_ct_url}js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/carousel.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/album.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/url.js"></script>
	
	<!--[if lt IE 7]>
        <script type="text/javascript" src="${www_ct_url}js/unitpngfix.js"></script>
	<![endif]-->
	<title>������ - ��������O2O�����һƷ��</title>
</head>
<script type="text/javascript">
function getReady(imageJsonStr,type,imageIndex){
	var imageData = imageJsonStr;
  //var imageData = window.opener.imageJsonStr;
  
  var html = "";
  
  var title = "";
  
  if(type == "0"){
  	for(var data in imageData){
	  	var first = imageData[data];
	  	if(first != undefined){
	  		title = getTitle(data);
	  		html = createLi(first,title);
	  		$("#"+parseInt(data)).addClass("current")
	  		
	  		break;
	  	}
  	}
  }else{
  	var first = imageData[parseInt(type)];
  	title = getTitle(type);
  	html = createLi(first,title);
  	$("#"+parseInt(type)).addClass("current");
  }
  var em = $(".gallery-option-box ul li a em")
  var li = $(".gallery-option-box ul li")
  for(var i =0 ;i<6;i++){
  	if(imageData[String(i+1)]!=undefined){
  		em[i].innerHTML = imageData[String(i+1)].length+"��";
  	}else{
  		em[i].innerHTML = "0��";
  		li[i].className="none";
  	}
  }
  $("#album-carousel-list")[0].innerHTML = html;
  if(isNaN(parseInt(imageIndex))){
  	imageIndex = 0;
  }
  var Album = new jQuery.Album({curIndex:parseInt(imageIndex)});
  	var $homeTabNar = $(".gallery-option-box ul li");
	$homeTabNar.click(function() {
		$(this).addClass("current").siblings().removeClass("current");
		title = getTitle(this.id);
		$("#album-carousel-list").html(createLi(imageData[String(this.id)],title));
		Album = new jQuery.Album();
		
	});
}
$(document).ready(function(){
  var catalogid = window.url('1',window.location.href);
  var type = window.url('2',window.location.href);
  var imageIndex = window.url('3',window.location.href);
  $.ajax({
    		url : '${www_ct_url}chetuan/getCarTypeImageContain',
    		data:{catalogid:catalogid},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			var imageJsonStr = data[0].carimage;
    			var fatherid = data[0].fatherid;
    			var pathlevel = data[0].pathlevel;
    			var dealerpath = "";
    			if(pathlevel == 1){
    				dealerpath = "javascript:goindex('http://dealer.chetuan.com/b"+fatherid+"-2.html')";
    			}else{
    				dealerpath = "javascript:goindex('http://dealer.chetuan.com/s"+fatherid+"-1.html')";
    			}
    			$(".main-top").find("a:eq(0)").attr("href",dealerpath)
    			$(".main-top").find("a:eq(2)").attr("href","javascript:goindex('${www_ct_url}"+fatherid+"/canshu.html')")
    			var pricelist = data[0].pricelist;
    			var priceStr1 = pricelist[0];
    			var priceStr2 = pricelist[1];
    			var priceStr3 = pricelist[2];
    			if(priceStr1!="����"){
    				priceStr1 = priceStr1 + " ��"
    			}else if(parseInt(priceStr1) == 0){
    				priceStr1 = "����";
    			}
    			if(priceStr2!="����" && priceStr3!="����"){
    				priceStr2 = priceStr2+"~"+priceStr3 + " ��"
    			}else if(parseInt(priceStr2) == 0 && parseInt(priceStr3) == 0){
    				priceStr2 = "����";
    			}
    			//$(".price").find("span:eq(0)").html("����ָ����: "+priceStr1);
    			//$(".price").find("span:eq(1)").html("�����̱���: "+priceStr2);
    			getReady(imageJsonStr,type,imageIndex);
    		}
  });
  
});

function createLi(lidata,title){
	var html = "";
	for(var i = 0;i<lidata.length;i++){
  		if(i == 0){
  			$("h2.title").html(lidata[i].title)
  			$(".position a:eq(2)").html(lidata[i].title)
  			document.title = "��ͼ��"+lidata[i].title+title;
  			html = html + '<li ><a href="'+getImagePath(lidata[i].path,lidata[i].path900600)+'">';
  			html = html + '<img width="105" src="'+getImagePath2(lidata[i].path,lidata[i].path10573)+'" alt=""></a></li>';
  		}else{
  			html = html + '<li ><a href="'+getImagePath(lidata[i].path,lidata[i].path900600)+'">';
  			html = html + '<img width="105" src="'+getImagePath2(lidata[i].path,lidata[i].path10573)+'" alt=""></a></li>';
  		}
  	}
  	return html;
}

function getImagePath(path1,path2){
		if(path2!=undefined){
			return path2;
		}
		return path1.replace(/ct1/,"${www_ct_url}");
}

function getImagePath2(path1,path2){
		var path = "";
		if(path1.substr(0,3)=="315"){
			path = path2.replace(/.gif/,".jpg");
		}else{
			path = path1.replace(/ct1/,"${www_ct_url}").replace(/.jpg/,"_105x73.jpg");
		}
		return path;
}

function getTitle(data){
	switch (parseInt(data)) {
	    case 1:
	        title = " ���ͼƬ-����";
	        break;
	    case 2:
	        title = " ����ͼƬ-����";
	        break;
	    case 3:
	        title = " �п�ͼƬ-����";
	        break;
	    case 4:
	        title = " ��װͼƬ-����";
	        break;
	    case 5:
	        title = " ͼ��-����";
	        break;
	    case 6:
	    	title = " ��ͼ-����";
	    	break;
	    default:
	        title = " ���ͼƬ-����";
	}
	return title;
}

function goindex(url){
	window.open(url);
}

</script>
<body>
	<!-- �����˵��� start -->
	<div class="header">
		<div class="header-inner">
			<div class="position">
				��ǰλ�ã�<a href="javascript:goindex('${www_ct_url}')">����</a>&gt;<a href="javascript:goindex('${www_ct_url}index_18021.html')">ͼ��</a>&gt;<a ></a>
			</div>
		</div>
	</div>
	<!-- �����˵��� end -->
	<div class="gallery-main">
		<div class="gallery-main-body">
			<div class="main-top">
				<div class="left">
					<h2 class="title"></h2>
					<div class="price">
						<span></span>
						<span></span>
					</div>
				</div>
				<div class="right">
					<a href="" class="btn">ѯ��</a>
					<a href="javascript:goindex('${www_ct_url}')" class="btn">�</a>
					<a href="" class="btn">��������</a>
				</div>
			</div>
			<div id="album-image-md" class="main-pic-box">
				<div class="gallery-pic-box">
					<div class="prev-btn"></div>
					<div class="next-btn"></div>
					<div class="pic"><img id="album-image" src="" alt=""></div>
					<ul class="image-nav" id="album-image-nav">
						<li class="image-nav-left-block" id="album-image-nav-left-block"><a href="#prev-image" class="btn-prev" id="album-image-btn-prev">&lsaquo;</a></li>
						<li class="image-nav-right-block" id="album-image-nav-right-block"><a href="#next-image" class="btn-next" id="album-image-btn-next">&rsaquo;</a></li>
					</ul>
					<div class="loading-overlay hide" id="album-image-loading-overlay"><img src="${www_ct_url}images/loading.gif" alt="loading..." width="100" height="100" /></div>
				</div>
				<div class="gallery-option-box">
					<ul class="area-btn">
						<li id="1">
							<i></i>
							<a href="javascript:void()">
								<span>���</span>
								<em>0��</em>
							</a>
						</li>
						<li id="2">
							<i></i>
							<a href="javascript:void()">
								<span>����</span>
								<em>0��</em>
							</a>
						</li>
						<li id="3">
							<i></i>
							<a href="javascript:void()">
								<span>�п�</span>
								<em>0��</em>
							</a>
						</li>
						<li id="4">
							<i></i>
							<a href="javascript:void()">
								<span>��װ</span>
								<em>0��</em>
							</a>
						</li>
						<li id="5">
							<i></i>
							<a href="javascript:void()">
								<span>ͼ��</span>
								<em>0��</em>
							</a>
						</li>
						<li id="6">
							<i></i>
							<a href="javascript:void()">
								<span>�ٷ�ͼ</span>
								<em>0��</em>
							</a>
						</li>

					</ul>
				</div>
				<div class="clearfix"></div>
				<div id="album-carousel" class="gallery-pic-scoll">
					<a id="album-carousel-btn-prev" class="btn prev-btn" href="javascript:void(0);"></a>
					<div  class="pic-scoll-box">
						<ul id="album-carousel-list">
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
							<li><a href=""><img src="" alt=""></a></li>
						</ul>
					</div>
					<a id="album-carousel-btn-next" class="btn next-btn" href="javascript:void(0);"></a>
				</div>
			</div>
		</div>
	</div>
	<!-- ������ start -->
	
	<!-- ������ end -->
	<div class="footer">
		<@cc.footer/>
	</div>

	
</body>
</html>