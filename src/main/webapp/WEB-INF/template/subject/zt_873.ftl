<!DOCTYPE html>
<html lang="zh-hans">
<head>
	<meta charset="UTF-8">
	<title>2014 成都国际车展</title>
	<meta name="keywords" content="${keywords!}">
	<meta name="description" content="${descstr!}">
</head>
<body>
	
<script type="text/javascript">
window.onload=function(){

	var oUl4=document.getElementById('ul4');
	var oUl5=document.getElementById('ul5');
	var aLi4=oUl4.getElementsByTagName('li');
	var aLi5=oUl5.getElementsByTagName('li');
	
	for(i=0;i<aLi4.length;i++){
		aLi4[i].index=i;
		aLi4[i].onclick=function(){
			for(i=0;i<aLi4.length;i++){
				aLi4[i].className='';
				aLi5[i].style.display='none'
			}
			aLi4[this.index].className='active';
			aLi5[this.index].style.display='block';
		}
		
	}	

	
}
</script>
<style>
* {
	margin:0;
	padding:0;
}
a{color:#000; text-decoration:none;}
a:hover {
	text-decoration:underline;
}
body {
	font-family:"微软雅黑";
	font-size:14px;
	background:url(http://img.315che.com/hd/2014/czimg/03.jpg) top center no-repeat;
}
ul {
	list-style:none;
}
img {
	border:0;
}
.fl {
	float: left;
}
.fr {
	float: right;
}
.fl, .fr {
	display: inline;
}
/*--清浮动--*/
.clearfix:before, .clearfix:after {
	content: '';
	display: table;
}
.clearfix:after {
	clear: both;
}
.clearfix {
*zoom:1;
}

.container {
	width:960px;
	height:auto;
	margin:0 auto;
}
.topBan {
	width:960px;
	height:436px;
}
.footBan {
	width:960px;
	height:180px;
	padding-bottom:10px;
}
.footBan ul li{ margin-bottom:10px;}
.footBan ul li a{ display:block; width:200px; height:80px; float:left; margin-right:8px;}
.topInfo {
	overflow:hidden;
	padding-bottom:10px;
}
.focust {
	width:630px;
	float:left;
	overflow:visible;
}
#f_imgDiv div a {
	float:left;
	display:inline;
	width:530px;
}
.f_jiao {
	height: 270px;
	position:relative;
	overflow:visible;
	top:0px;
	left:0px;
}
.carmSlides_Img {
	height: 270px;
	background:url(http://img.315che.com/hd/2014/czimg/04.jpg) no-repeat left;
	overflow: visible;
}
.carmSlides_Img ul {
	height: 270px;
	overflow: hidden;
	position: relative;
	width:516px;
	z-index: 5;
	left:114px;
}
.carmSlides_Img ul li {
	display: none;
	position: absolute;
	width:516px;
}
.carmSlides_Img ul li img {
	display: block;
	height: 270px;
	margin-bottom: 10px;
	width: 516px;
}
.carmSlides_Img .num {
	height: 270px;
	overflow: hidden;
	position: absolute;
	left: 80px;
	top: 38px;
	z-index: 10;
}
.carmSlides_Img .num span {
	background: url("http://img.315che.com/hd/2013imgs/images/cz01png.png") no-repeat scroll 0 -20px transparent;
	cursor: pointer;
	display: block;
	height: 17px;
	width: 17px;
	margin-top:6px;
}
.carmSlides_Img .num span.cur {
	background: url("http://img.315che.com/hd/2013imgs/images/cz01png.png") no-repeat scroll 0 -1px transparent;
}

.newcarbox{width:940px; height:200px; overflow:hidden; position:relative; padding-top:50px; padding-left:20px;}
.newcars ul{width:940px;}
.newcars ul li{width:224px; height:auto; overflow:hidden; margin-right:10px; float:left;}
.cartitle{width:224px; height:24px; line-height:24px; overflow:hidden; text-align:center; font-size:12px;}
.iconbox{position:relative; left:0; top:0;}
.icon{width:50px; height:50px; display:block; position:absolute; left:0; top:0; background-position:0 -246px; z-index:2;}

.cartab{width:auto; height:8px; text-align:right; position:absolute; right:0; top:12px; font-size:0;}
.cartab a{width:70px; height:8px; background:#999; display:inline-block; margin-right:5px;}
.cartab a.active{background:#E67275}

.btmtilte{width:100%; height:35px;}
.titleHead{width:960px; height:33px;}
.pos1{background: url(http://img.315che.com/hd/2014/czimg/05.jpg) no-repeat top;}
.pos2{background: url(http://img.315che.com/hd/2014/czimg/06.jpg) no-repeat top;}
.pos3{background: url(http://img.315che.com/hd/2014/czimg/07.jpg) no-repeat top;}
.pos4{background: url(http://img.315che.com/hd/2014/czimg/08.jpg) no-repeat top;}
.pos5{background: url(http://img.315che.com/hd/2014/czimg/09.jpg) no-repeat top;}
.pos6{background: url(http://img.315che.com/hd/2014/czimg/11.jpg) no-repeat top;}
.pos7{background: url(http://img.315che.com/hd/2014/czimg/12.jpg) no-repeat top; padding:50px 0px 0px 0px;}

.womenbox{width:925px; height:465px; padding:20px 15px 40px 15px; _padding-bottom:20px;}
.nvleft{width:326px; height:461px; overflow:hidden; position:relative;}
.nvright{width:590px; height:464px; overflow:hidden;}
.nvright ul{width:600px;}
.nvright ul li{float:left; margin-right:10px; margin-bottom:9px;}
.smallnv{position:relative; width:189px; height:199px;}
.nvtxt{position:absolute; bottom:0px; left:0; filter:alpha(opacity=80); background:#333; background:rgba(51,51,51,0.8);color:#fff; width:100%; height:25px; line-height:23px; overflow:hidden;}
.nvtxt a{color:#fff; font-size:12px; padding:0 8px;}
.bignv{position:relative; width:361px; height:253px; overflow:hidden;}
.middlenv{position:relative; width:217px; height:253px; overflow:hidden;}

.nvtab{width:auto; height:8px; text-align:right; text-align:center; font-size:0;}
.nvtab a{width:60px; height:8px; background:#999; display:inline-block; margin-right:5px;}
.nvtab a.active{background:#E67275}

.contain{padding:0 4px; width:957px;}
.picbox{width:940px;height:280px; padding-left:20px; padding-top:8px;}
.bigimg{width:397px; height:255px; overflow:hidden; position:relative;}
.txt{position:absolute; bottom:0px; _bottom:-1px; left:0; width:100%; height:26px; line-height:26px; overflow:hidden; background:#333; background:rgba(51,51,51,0.5); filter:alpha(opacity=60); text-align:center}
.txt a{color:#fff; font-size:12px;}

.smallimg{width:520px; height:258px; padding-left:5px;}
.imglist{width:168px; height:125px; position:relative; overflow:hidden; float:left; margin-right:5px; margin-bottom:5px;  _display:inline;}
.listbtn{height:10px; text-align:center; overflow:hidden; font-size:0}
.listbtn a{width:70px; height:8px; background:#999; display:inline-block; margin-right:5px;}
.listbtn a.active{background:#E67275}

.tet{width:330px; float:right; text-align:center;}
.tet dl{ border-bottom: 1px dashed  #ccc; width:330px; height:64px; float:left; overflow:hidden;}
.tet dl dt{height:36px; line-height:36px; width:330px; overflow:hidden; display:block; float:left;}
.tet dl dt a{font-size:18px; font-weight:bold; color:#136400;}
.tet dl dd{height:28px; line-height:28px; color:#9b9b9b; width:330px; overflow:hidden; display:block; float:left;}
.tet dl dd a {padding: 0 10px; font-size:14px;}

.main7 li{float:left;display:inline;width:200px;margin-right:50px;}
.main7 li.mr0{margin-right:0;}
.main7 li img{width:200px;height:80px;display:block;}

.vedor {
	width:960px;
	border-top:2px #136400 solid;
	height:auto;
}
#ul4 {
	width:960px;
	height:30px;
	margin-top:0px;
}
#ul4 li {
	width:100px;
	height:30px;
	line-height:30px;
	float:left;
	background:#fff;
	text-align:center;
	cursor:pointer;
	color:#000;
	font-size:18px;
	font-weight:bold;
	border-top:4px #136400 solid;
}
#ul4 li:hover, #ul4 li.active {
	border-top:4px #a2ff00 solid;
}
.vedorbox {
	width:950px;}
.vedorbox ul li {
	width:940px;
	height:auto;
	padding:10px;
	padding-left:0;
	background:none
}
.vedorbox ul li:hover {
	background:none;
}
.dllist{width:960px;}
.dllist dl{  border-bottom:1px dashed #ccc; height:120px; padding:6px 0; width:960px;}
.dllist dl dt{ float:left; display:inline; width:203px; margin-right:10px;}
.dllist dl  dd{ width:735px; float:right;}
.dllist dl  dd h4{  height:28px; line-height:28px;}
.dllist dl  dd h4 a{font-size:16px; font-weight:bold; color:#136400;}
.dllist dl  dd span{ color:#2aa7f5; font-size:12px;}
.dllist dl  dd  p{ line-height:24px; color:#5e5e5e; font-size:14px;}
.dllist dl  dd  p a{color:#136400; font-weight:bold; font-size:12px; }

#footer { color: #494949; float: none; height:162px; line-height: 31px; margin: 0 auto;  padding-top: 4px; text-align: center; width: 960px; position:relative; }
#footer ul { background:#136400; color: #FFFFFF; letter-spacing: 1px; margin-bottom: 8px; }
#footer p { line-height: 24px; }
#footer a { color: #494949; }
#footer a:hover { color: #FF0000; }
#footer ul a { color: #FFFFFF; font-size:12px; }
</style>
<script>
$(document).ready(function(e) {
		
	//切换部分
	$('.listbtn a').mouseover(function(){
		$(this).parent().parent().find('.box').hide();
		$(this).parent().parent().find('.box').eq($(this).index()).show();
		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active')
	})
	
	$('.cartab a').mouseover(function(){
		$('.cartab a').removeClass('active');
		$(this).addClass('active');
		$('.newcars').hide();
		$('.newcars').eq($(this).index()).show()	
	})
	
	$('.videotabs a').mouseover(function(){
		$('.videotabs a').removeClass('active');
		$(this).addClass('active');
		$('.videolist').hide();
		$('.videolist').eq($(this).index()).show()	
	})
	$('.nvtab a').mouseover(function(){
		$('.nvtab a').removeClass('active');
		$(this).addClass('active');
		$('.meinv').hide();
		$('.meinv').eq($(this).index()).show()	
	})
	$('.newstab a').mouseover(function(){
		$('.newstab a').removeClass('active');
		$(this).addClass('active');
		$('.newtop').hide();
		$('.newtop').eq($(this).index()).show()	
	})
});
</script>
<div class="container">
<div class="topBan"> <img src="http://img.315che.com/hd/2014/czimg/02.jpg" width="960" height="436" border="0" usemap="#Map"></div>
<div class="topInfo">
  <div class="focust">
    <div class="f_jiao">
      <div class="carmSlides_Img">
        <div class="num">
        	<#if dataMap.get("切换图片")??>
        		<#list dataMap.get("切换图片") as data>
        			<#if data_index lt 8>
        				<span class="" id="imga_${data_index}"></span>
        			</#if>
        		</#list>
        	</#if>
        </div>
        <ul>
    	<#if dataMap.get("切换图片")??>
    		<#list dataMap.get("切换图片") as data>
    			<#if data_index lt 8>
    				 <li style="display:none;" id="img_${data_index}"> <a href="${data.link!}" target="_blank" title="${data.title!}"><img width="516" height="270" src="<#if data.pic.substring(0,7) == "http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>"></a></li>
    			</#if>
    		</#list>
    	</#if>
        </ul>
      </div>
    </div>
  </div>
  <div class="tet">
    <dl>
      <dt>
    	<#if dataMap.get("焦点新闻大标题1")??>
    		<#list dataMap.get("焦点新闻大标题1") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dt>
      <dd>
      	<#if dataMap.get("焦点新闻小标题1_1")??>
    		<#list dataMap.get("焦点新闻小标题1_1") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
       <#if dataMap.get("焦点新闻小标题1_2")??>
    		<#list dataMap.get("焦点新闻小标题1_2") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
        <#if dataMap.get("焦点新闻小标题1_3")??>
    		<#list dataMap.get("焦点新闻小标题1_3") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dd>
    </dl>
    <dl>
      <dt>
        <#if dataMap.get("焦点新闻大标题2")??>
    		<#list dataMap.get("焦点新闻大标题2") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dt>
      <dd>
         <#if dataMap.get("焦点新闻小标题2_1")??>
    		<#list dataMap.get("焦点新闻小标题2_1") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
         <#if dataMap.get("焦点新闻小标题2_2")??>
    		<#list dataMap.get("焦点新闻小标题2_2") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
         <#if dataMap.get("焦点新闻小标题2_3")??>
    		<#list dataMap.get("焦点新闻小标题2_3") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dd>
    </dl>
    <dl>
      <dt>
        <#if dataMap.get("焦点新闻大标题3")??>
    		<#list dataMap.get("焦点新闻大标题3") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dt>
      <dd>
        <#if dataMap.get("焦点新闻小标题3_1")??>
    		<#list dataMap.get("焦点新闻小标题3_1") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
        <#if dataMap.get("焦点新闻小标题3_2")??>
    		<#list dataMap.get("焦点新闻小标题3_2") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
       <#if dataMap.get("焦点新闻小标题3_3")??>
    		<#list dataMap.get("焦点新闻小标题3_3") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dd>
    </dl>
    <dl>
      <dt>
        <#if dataMap.get("焦点新闻大标题4")??>
    		<#list dataMap.get("焦点新闻大标题4") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dt>
      <dd>
        <#if dataMap.get("焦点新闻小标题4_1")??>
    		<#list dataMap.get("焦点新闻小标题4_1") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
        <#if dataMap.get("焦点新闻小标题4_2")??>
    		<#list dataMap.get("焦点新闻小标题4_2") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
        |
        <#if dataMap.get("焦点新闻小标题4_3")??>
    		<#list dataMap.get("焦点新闻小标题4_3") as data>
    			<#if data_index lt 1>
    				 <a target="_blank" href="${data.link!}">
    					${data.title!}
    				</a>
    			</#if>
    		</#list>
    	</#if>
      </dd>
    </dl>
  </div>
</div>
<a name="xcjx"></a>
<div class="newcarbox pos1" id="newcarbox">
  <script>
				var newchebigpicount=0;
				var newimgArray1=new Array();
				var newlinkArray1=new Array();
				var newtitleArray1=new Array();
				<#if dataMap.get("新车解析")??>
		    		<#list dataMap.get("新车解析") as data>
		    			<#if data_index lt 16>
		    				newimgArray1[${data_index}]="${data.pic!}";
							newlinkArray1[${data_index}]="${data.link!}";
							newtitleArray1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				newchebigpicount=parseInt((newimgArray1.length)/4);
				var newpiccount=newchebigpicount;
				newpiccount=((newimgArray1.length)%4==0)?newpiccount:(newpiccount+1);
				
				var newcarhtml='';
				var carInnerHtml='';
				var newcarpage='<div class="cartab" id="cartab">';
				
				for(var ti=0;ti<newpiccount;ti++)
				{
					newcarhtml+='<div class="newcars"'+(ti==0?'':'style="display:none;"')+'><ul class="clearfix">'
					for(j=4*ti;j<4*(ti+1);j++){
						carInnerHtml+='<li><div class="iconbox"><a href="'+newlinkArray1[j] +'" target="_blank" title="'+newtitleArray1[j]+'"><img src="${img_che_url!}'+newimgArray1[j]+'" alt="'+newtitleArray1[j]+'" width="224" height="172"></a><i class="icon"></i></div><div class="cartitle"><a href="'+newlinkArray1[j]+'" target="_blank" title="'+newtitleArray1[j]+'">'+newtitleArray1[j]+'</a></div></li>'
					}
					newcarhtml+=carInnerHtml+'</ul></div>'
					carInnerHtml='';
				}
				for(var ti=0;ti<newpiccount;ti++){
					newcarpage+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				newcarhtml+=newcarpage+'</div>'
				document.getElementById('newcarbox').innerHTML=newcarhtml;
		</script>
</div>
<div class="btmtilte mt10"><a name="m4"></a>
  <h1 class="titleHead pos2"></h1>
</div>
<a name="mnmt"></a>
<div class="womenbox" id="womenbox">
  <SCRIPT LANGUAGE="JavaScript">
				var mvcmpagecount=0;
				var bigimgArraymv=new Array();
				var bigLinkArraymv=new Array();
				var bigTitleArraymv=new Array();
				<#if dataMap.get("美女车模大图")??>
		    		<#list dataMap.get("美女车模大图") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv[${data_index}]="${data.pic!}";
							bigLinkArraymv[${data_index}]="${data.link!}";
							bigTitleArraymv[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount=bigimgArraymv.length;
				
				var mvcmpagecount1=0;
				var bigimgArraymv1=new Array();
				var bigLinkArraymv1=new Array();
				var bigTitleArraymv1=new Array();
				
				<#if dataMap.get("美女车模小图1")??>
		    		<#list dataMap.get("美女车模小图1") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv1[${data_index}]="${data.pic!}";
							bigLinkArraymv1[${data_index}]="${data.link!}";
							bigTitleArraymv1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount1=bigimgArraymv1.length;
				
				var mvcmpagecount2=0;
				var bigimgArraymv2=new Array();
				var bigLinkArraymv2=new Array();
				var bigTitleArraymv2=new Array();
				<#if dataMap.get("美女车模小图2")??>
		    		<#list dataMap.get("美女车模小图2") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv2[${data_index}]="${data.pic!}";
							bigLinkArraymv2[${data_index}]="${data.link!}";
							bigTitleArraymv2[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount2=bigimgArraymv2.length;
				
				var mvcmpagecount3=0;
				var bigimgArraymv3=new Array();
				var bigLinkArraymv3=new Array();
				var bigTitleArraymv3=new Array();
				<#if dataMap.get("美女车模小图3")??>
		    		<#list dataMap.get("美女车模小图3") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv3[${data_index}]="${data.pic!}";
							bigLinkArraymv3[${data_index}]="${data.link!}";
							bigTitleArraymv3[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount3=bigimgArraymv3.length;
				
				
				var mvcmpagecount4=0;
				var bigimgArraymv4=new Array();
				var bigLinkArraymv4=new Array();
				var bigTitleArraymv4=new Array();
				<#if dataMap.get("美女车模小图4")??>
		    		<#list dataMap.get("美女车模小图4") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv4[${data_index}]="${data.pic!}";
							bigLinkArraymv4[${data_index}]="${data.link!}";
							bigTitleArraymv4[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount4=bigimgArraymv4.length;
				
				var mvcmpagecount5=0;
				var bigimgArraymv5=new Array();
				var bigLinkArraymv5=new Array();
				var bigTitleArraymv5=new Array();
				<#if dataMap.get("美女车模小图5")??>
		    		<#list dataMap.get("美女车模小图5") as data>
		    			<#if data_index lt 5>
		    				bigimgArraymv5[${data_index}]="${data.pic!}";
							bigLinkArraymv5[${data_index}]="${data.link!}";
							bigTitleArraymv5[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				mvcmpagecount5=bigimgArraymv5.length;
				
				var piccountmv=mvcmpagecount;
				piccountmv=piccountmv>mvcmpagecount1?mvcmpagecount1:piccountmv;
				piccountmv=piccountmv>mvcmpagecount2?mvcmpagecount2:piccountmv;
				piccountmv=piccountmv>mvcmpagecount3?mvcmpagecount3:piccountmv;
				piccountmv=piccountmv>mvcmpagecount4?mvcmpagecount4:piccountmv;
				piccountmv=piccountmv>mvcmpagecount5?mvcmpagecount5:piccountmv;
				
				
				var carhtmlmv="";
				var carpagemv='<div class="nvtab mt10" id="nvtab">';
				for(var ti=0;ti<piccountmv;ti++)
				{
					carhtmlmv+='<div class="meinv clearfix" '+(ti==0?'':'style="display:none;"')+'><div class="nvleft fl"><div><a href="'+bigLinkArraymv[ti]+'" target="_blank" title="'+bigTitleArraymv1[ti]+'"><img  width="326" height="461" src="${img_che_url!}'+bigimgArraymv[ti]+'" alt="'+bigTitleArraymv1[ti]+'"/></a></div><div class="nvtxt"><a href="'+bigLinkArraymv[ti]+'" target="_blank" title="'+bigTitleArraymv1[ti]+'">'+bigTitleArraymv[ti]+'</a></div></div><div class="nvright fr"><ul><li><div class="smallnv"><div><a  href="'+bigLinkArraymv1[ti]+'" target="_blank" title="'+bigTitleArraymv1[ti]+'"><img width="189" height="199" src="${img_che_url!}'+bigimgArraymv1[ti]+'" alt="'+bigTitleArraymv1[ti]+'"/></a></div><div class="nvtxt"><a  href="'+bigLinkArraymv1[ti]+'" target="_blank" title="'+bigTitleArraymv1[ti]+'">'+bigTitleArraymv1[ti]+'</a></div></div></li><li><div class="smallnv"><div><a  href="'+bigLinkArraymv2[ti]+'" target="_blank" title="'+bigTitleArraymv2[ti]+'"><img width="189" height="199" src="${img_che_url!}'+bigimgArraymv2[ti]+'" alt="'+bigTitleArraymv2[ti]+'"/></a></div><div class="nvtxt"><a  href="'+bigLinkArraymv2[ti]+'" target="_blank" title="'+bigTitleArraymv2[ti]+'">'+bigTitleArraymv2[ti]+'</a></div></div></li><li><div class="smallnv"><div><a  href="'+bigLinkArraymv3[ti]+'" target="_blank" title="'+bigTitleArraymv3[ti]+'"><img width="189" height="199" src="${img_che_url!}'+bigimgArraymv3[ti]+'" alt="'+bigTitleArraymv3[ti]+'"/></a></div><div class="nvtxt"><a  href="'+bigLinkArraymv3[ti]+'" target="_blank" title="'+bigTitleArraymv3[ti]+'">'+bigTitleArraymv3[ti]+'</a></div></div></li><li><div class="bignv"><div><a  href="'+bigLinkArraymv4[ti]+'" target="_blank" title="'+bigTitleArraymv4[ti]+'"><img width="361" height="253" src="${img_che_url!}'+bigimgArraymv4[ti]+'" alt="'+bigTitleArraymv4[ti]+'"/></a></div><div class="nvtxt"><a  href="'+bigLinkArraymv4[ti]+'" target="_blank" title="'+bigTitleArraymv4[ti]+'">'+bigTitleArraymv4[ti]+'</a></div></div></li><li><div class="middlenv"><div><a  href="'+bigLinkArraymv5[ti]+'" target="_blank" title="'+bigTitleArraymv5[ti]+'"><img width="217" height="253" src="${img_che_url!}'+bigimgArraymv5[ti]+'" alt="'+bigTitleArraymv5[ti]+'"/></a></div><div class="nvtxt"><a  href="'+bigLinkArraymv5[ti]+'" target="_blank" title="'+bigTitleArraymv5[ti]+'">'+bigTitleArraymv5[ti]+'</a></div></div></li></ul></div></div>'
				}
				for(var ti=0;ti<piccountmv;ti++){
					carpagemv+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				carhtmlmv+=carpagemv+'</div>';
				document.getElementById('womenbox').innerHTML=carhtmlmv;
		  </SCRIPT>
</div>
<div class="btmtilte"><a name="m1"></a>
  <h1 class="titleHead pos3"></h1>
</div>
<a name="zzxc"></a>
<div class="picbox" id='carbbgz1'>
  <SCRIPT LANGUAGE="JavaScript">
				var bigpicount=0;
				var bigimgArray=new Array();
				var bigLinkArray=new Array();
				var bigTitleArray=new Array();
				<#if dataMap.get("自主新车大图")??>
		    		<#list dataMap.get("自主新车大图") as data>
		    			<#if data_index lt 5>
		    				bigimgArray[${data_index}]="${data.pic!}";
							bigLinkArray[${data_index}]="${data.link!}";
							bigTitleArray[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				bigpicount=bigimgArray.length;
				
				var piccount1=0;
				var imgArray1=new Array();
				var linkArray1=new Array();
				var titleArray1=new Array();
				<#if dataMap.get("自主新车小图")??>
		    		<#list dataMap.get("自主新车小图") as data>
		    			<#if data_index lt 24>
		    				imgArray1[${data_index}]="${data.pic!}";
							linkArray1[${data_index}]="${data.link!}";
							titleArray1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				piccount1=parseInt(imgArray1.length/6);
				
				var piccount=0;
				piccount=bigpicount>piccount1?piccount1:bigpicount;
				
				
				var hzcarhtml='';
				var innerhtml=''
				var hzcarpage='<div class="listbtn mt10 clearfix" id="carbbgzpage1">';
				for(var ti=0;ti<piccount;ti++)
				{
					hzcarhtml+='<div class="box clearfix" '+(ti==0?'':'style="display:none;"')+'><div class="fl bigimg clearfix"><div><a href="'+bigLinkArray[ti]+'" target="_blank" title="'+bigTitleArray[ti]+'"><img src="${img_che_url!}'+bigimgArray[ti]+'" alt="'+bigTitleArray[ti]+'" width="397" height="258"/></a></div> <div class="txt"><a href="'+bigLinkArray[ti]+'" target="_blank" title="'+bigTitleArray[ti]+'">'+bigTitleArray[ti]+'</a></div></div><div class="fl smallimg clearfix">'
					for(j=6*ti;j<6*(ti+1);j++){
						innerhtml+='<div class="imglist"><div><a href="'+linkArray1[j]+'" target="_blank" title="'+titleArray1[j]+'"><img src="${img_che_url!}'+imgArray1[j]+'" alt="'+titleArray1[j]+'" width="168" height="125"></a></div><div class="txt"><a href="'+linkArray1[j]+'" target="_blank" title="'+titleArray1[j]+'">'+titleArray1[j]+'</a></div></div>'
					}
					hzcarhtml=hzcarhtml+innerhtml+'</div></div>';
					innerhtml='';
				}
				for(var ti=0;ti<piccount;ti++){
					hzcarpage+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				hzcarhtml+=hzcarpage+'</div>';
				document.getElementById('carbbgz1').innerHTML=hzcarhtml;
		</script>
</div>
<div class="btmtilte"><a name="m2"></a>
  <h1 class="titleHead pos4"></h1>
</div>
<a name="hzxc"></a>
<div class="picbox" id='carbbgz2'>
  <SCRIPT LANGUAGE="JavaScript">
				var hzbigpicount=0;
				var hzbigimgArray=new Array();
				var hzbigLinkArray=new Array();
				var hzbigTitleArray=new Array();
				<#if dataMap.get("合资新车大图")??>
		    		<#list dataMap.get("合资新车大图") as data>
		    			<#if data_index lt 5>
		    				hzbigimgArray[${data_index}]="${data.pic!}";
							hzbigLinkArray[${data_index}]="${data.link!}";
							hzbigTitleArray[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				hzbigpicount=hzbigimgArray.length;
				
				var hzpiccount1=0;
				var hzimgArray1=new Array();
				var hzlinkArray1=new Array();
				var hztitleArray1=new Array();
				<#if dataMap.get("合资新车小图")??>
		    		<#list dataMap.get("合资新车小图") as data>
		    			<#if data_index lt 24>
		    				hzimgArray1[${data_index}]="${data.pic!}";
							hzlinkArray1[${data_index}]="${data.link!}";
							hztitleArray1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				hzpiccount1=parseInt(hzimgArray1.length/6);
				
				var hzpiccount=hzbigpicount;
				hzpiccount=hzpiccount>hzpiccount1?hzpiccount1:hzpiccount;
				
				
				var zzhzcarhtml="";
				var zzinnerhtml=''
				var zzcarpage='<div class="listbtn mt10 clearfix" id="carbbgzpage2">';
				for(var ti=0;ti<hzpiccount;ti++)
				{
					zzhzcarhtml+='<div class="box clearfix" '+(ti==0?'':'style="display:none;"')+'><div class="fl bigimg clearfix"><div><a href="'+hzbigLinkArray[ti]+'" target="_blank" title="'+hzbigTitleArray[ti]+'"><img src="${img_che_url!}'+hzbigimgArray[ti]+'" alt="'+hzbigTitleArray[ti]+'" width="397" height="258"/></a></div> <div class="txt"><a href="'+hzbigLinkArray[ti]+'" target="_blank" title="'+hzbigTitleArray[ti]+'">'+hzbigTitleArray[ti]+'</a></div></div><div class="fl smallimg clearfix">'
					for(j=6*ti;j<6*(ti+1);j++){
						zzinnerhtml+='<div class="imglist"><div><a href="'+hzlinkArray1[j]+'" target="_blank" title="'+hztitleArray1[j]+'"><img src="${img_che_url!}'+hzimgArray1[j]+'" alt="'+hztitleArray1[j]+'" width="168" height="125"></a></div><div class="txt"><a href="'+hzlinkArray1[j]+'" target="_blank" title="'+hztitleArray1[j]+'">'+hztitleArray1[j]+'</a></div></div>'
					}
					zzhzcarhtml=zzhzcarhtml+zzinnerhtml+'</div></div>';
					zzinnerhtml=''
				}
				for(var ti=0;ti<hzpiccount;ti++){
					zzcarpage+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				zzhzcarhtml+=zzcarpage+'</div>'
				document.getElementById('carbbgz2').innerHTML=zzhzcarhtml;
		</script>
</div>
<div class="btmtilte">
  <h1 class="titleHead pos5"></h1>
</div>
<a name="jkxc"></a>
<div class="picbox" id='carbbgz3'>
  <SCRIPT LANGUAGE="JavaScript">
				var jkbigpicount=0;
				var jkbigimgArray=new Array();
				var jkbigLinkArray=new Array();
				var jkbigTitleArray=new Array();
				<#if dataMap.get("进口新车大图")??>
		    		<#list dataMap.get("进口新车大图") as data>
		    			<#if data_index lt 5>
		    				jkbigimgArray[${data_index}]="${data.pic!}";
							jkbigLinkArray[${data_index}]="${data.link!}";
							jkbigTitleArray[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				jkbigpicount=jkbigimgArray.length;
				
				var jkpiccount1=0;
				var jkimgArray1=new Array();
				var jklinkArray1=new Array();
				var jktitleArray1=new Array();
				<#if dataMap.get("进口新车小图")??>
		    		<#list dataMap.get("进口新车小图") as data>
		    			<#if data_index lt 24>
		    				jkimgArray1[${data_index}]="${data.pic!}";
							jklinkArray1[${data_index}]="${data.link!}";
							jktitleArray1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				jkpiccount1=parseInt(jkimgArray1.length/6);
				
				var jkpiccount=jkbigpicount;
				jkpiccount=jkpiccount>jkpiccount1?jkpiccount1:jkpiccount;
				
				
				var jkcarhtml="";
				var jkinnerhtml=''
				var jkcarpage='<div class="listbtn mt10 clearfix" id="carbbgzpage3">';
				for(var ti=0;ti<jkpiccount;ti++)
				{
					jkcarhtml+='<div class="box clearfix" '+(ti==0?'':'style="display:none;"')+'><div class="fl bigimg clearfix"><div><a href="'+jkbigLinkArray[ti]+'" target="_blank" title="'+jkbigTitleArray[ti]+'"><img src="${img_che_url!}'+jkbigimgArray[ti]+'" alt="'+jkbigTitleArray[ti]+'" width="397" height="258"/></a></div> <div class="txt"><a href="'+jkbigLinkArray[ti]+'" target="_blank" title="'+jkbigTitleArray[ti]+'">'+jkbigTitleArray[ti]+'</a></div></div><div class="fl smallimg clearfix">'
					for(j=6*ti;j<6*(ti+1);j++){
						jkinnerhtml+='<div class="imglist"><div><a href="'+jklinkArray1[j]+'" target="_blank" title="'+jktitleArray1[j]+'"><img src="${img_che_url!}'+jkimgArray1[j]+'" alt="'+jktitleArray1[j]+'" width="168" height="125"></a></div><div class="txt"><a href="'+jklinkArray1[j]+'" target="_blank" title="'+jktitleArray1[j]+'">'+jktitleArray1[j]+'</a></div></div>'
					}
					jkcarhtml+=jkinnerhtml+'</div></div>';
					jkinnerhtml='';
				}
				for(var ti=0;ti<jkpiccount;ti++){
					jkcarpage+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				jkcarhtml+=jkcarpage+'</div>'
				document.getElementById('carbbgz3').innerHTML=jkcarhtml;
		</script>
</div>
<div class="btmtilte"><a name="m3"></a>
  <h1 class="titleHead pos6"></h1>
</div>
<a name="gnxc"></a>
<div class="picbox" id="carbbgz4">
  <script LANGUAGE="JavaScript">
				var knCbigpicount=0;
				var knCbigimgArray=new Array();
				var knCbigLinkArray=new Array();
				var knCbigTitleArray=new Array();
				<#if dataMap.get("概念新车大图")??>
		    		<#list dataMap.get("概念新车大图") as data>
		    			<#if data_index lt 5>
		    				knCbigimgArray[${data_index}]="${data.pic!}";
							knCbigLinkArray[${data_index}]="${data.link!}";
							knCbigTitleArray[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				knCbigpicount=knCbigimgArray.length;
				
				var knCpiccount1=0;
				var knCimgArray1=new Array();
				var knClinkArray1=new Array();
				var knCtitleArray1=new Array();
				<#if dataMap.get("概念新车小图")??>
		    		<#list dataMap.get("概念新车小图") as data>
		    			<#if data_index lt 24>
		    				knCimgArray1[${data_index}]="${data.pic!}";
							knClinkArray1[${data_index}]="${data.link!}";
							knCtitleArray1[${data_index}]="${data.title!}";
		    			</#if>
		    		</#list>
		    	</#if>
				knCpiccount1=parseInt(knCimgArray1.length/6);
				
				var knCpiccount=knCbigpicount;
				knCpiccount=knCpiccount>knCpiccount1?knCpiccount1:knCpiccount;
				
				
				var knCcarhtml="";
				var knCinnerhtml=''
				var knCcarpage='<div class="listbtn mt10 clearfix" id="carbbgzpage4">';
				for(var ti=0;ti<knCpiccount;ti++)
				{
					knCcarhtml+='<div class="box clearfix" '+(ti==0?'':'style="display:none;"')+'><div class="fl bigimg clearfix"><div><a href="'+knCbigLinkArray[ti]+'" target="_blank" title="'+knCbigTitleArray[ti]+'"><img src="${img_che_url!}'+knCbigimgArray[ti]+'" alt="'+knCbigTitleArray[ti]+'" width="397" height="258"/></a></div> <div class="txt"><a href="'+knCbigLinkArray[ti]+'" target="_blank" title="'+knCbigTitleArray[ti]+'">'+knCbigTitleArray[ti]+'</a></div></div><div class="fl smallimg clearfix">'
					for(j=6*ti;j<6*(ti+1);j++){
						knCinnerhtml+='<div class="imglist"><div><a href="'+knClinkArray1[j]+'" target="_blank" title="'+knCtitleArray1[j]+'"><img src="${img_che_url!}'+knCimgArray1[j]+'" alt="'+knCtitleArray1[j]+'" width="168" height="125"></a></div><div class="txt"><a href="'+knClinkArray1[j]+'" target="_blank" title="'+knCtitleArray1[j]+'">'+knCtitleArray1[j]+'</a></div></div>'
					}
					knCcarhtml+=knCinnerhtml+'</div></div>';
					knCinnerhtml='';
				}
				for(var ti=0;ti<knCpiccount;ti++){
					knCcarpage+="<a "+(ti==0?'class="active"':'')+"></a>"
				}
				knCcarhtml+=knCcarpage+'</div>'
				document.getElementById('carbbgz4').innerHTML=knCcarhtml;
		</script>
</div>
<a name="newzx"></a>
<div class="vedor clearfix">
  <ul id="ul4">
    <li class="active">最新资讯</li>
    <li>新车快讯</li>
    <li>厂商要闻</li>
  </ul>
  <div class="vedorbox">
    <ul id="ul5">
      <li style="display:block">
        <div class="dllist" id="newsList">
        	<#if dataMap.get("最新资讯")??>
	    		<#list dataMap.get("最新资讯") as data>
	    			<#if data_index lt 5>
						<dl>
				            <dt><a  target="_blank" href="${data.link!}"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="203" height="118"/></a></dt>
				            <dd>
				              <h4><a target="_blank" href="${data.link!}">
				                ${data.title!}
				                </a></h4>
				              <span>
				              ${data.ctitle!}
				              ${data.adddate?string("yyyy-MM-dd")}
				              </span>
				              <p>
				                 <#if data.content?length gt 100>${data.content.substring(0.100)}<#else>${data.content!}</#if>
				                <a target="_blank" href="${data.link!}">[详情]</a></p>
				            </dd>
				          </dl>
	    			</#if>
	    		</#list>
		    </#if>
        </div>
      </li>
      <li style="display:none">
        <div class="dllist" id="newsList">
        <#if dataMap.get("新车快讯")??>
	    		<#list dataMap.get("新车快讯") as data>
	    			<#if data_index lt 5>
						<dl>
				            <dt><a  target="_blank" href="${data.link!}"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="203" height="118"/></a></dt>
				            <dd>
				              <h4><a target="_blank" href="${data.link!}">
				                ${data.title!}
				                </a></h4>
				              <span>
				              ${data.ctitle!}
				              ${data.adddate?string("yyyy-MM-dd")}
				              </span>
				              <p>
				                 <#if data.content?length gt 100>${data.content.substring(0.100)}<#else>${data.content!}</#if>
				                <a target="_blank" href="${data.link!}">[详情]</a></p>
				            </dd>
				          </dl>
	    			</#if>
	    		</#list>
		    </#if>	
        </div>
      </li>
      <li style="display:none">
        <div class="dllist" id="newsList">
         <#if dataMap.get("厂商要问")??>
	    		<#list dataMap.get("厂商要问") as data>
	    			<#if data_index lt 5>
						<dl>
				            <dt><a  target="_blank" href="${data.link!}"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="203" height="118"/></a></dt>
				            <dd>
				              <h4><a target="_blank" href="${data.link!}">
				                ${data.title!}
				                </a></h4>
				              <span>
				              ${data.ctitle!}
				              ${data.adddate?string("yyyy-MM-dd")}
				              </span>
				              <p>
				                 <#if data.content?length gt 100>${data.content.substring(0.100)}<#else>${data.content!}</#if>
				                <a target="_blank" href="${data.link!}">[详情]</a></p>
				            </dd>
				          </dl>
	    			</#if>
	    		</#list>
		    </#if>	
        </div>
      </li>
    </ul>
  </div>
</div>
<div class="title">
  <div class="footBan pos7">
    <ul>
    <#if dataMap.get("厂商要问")??>
	    <#list dataMap.get("厂商要问") as data>
	    	<#if data_index lt 24>
	    		<li>
	    			<a href="${data.link!}" target="_blank" id="imglink_${data_index}">
	    				<img src="<#if data.pic.substring(0,7) == "http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" id="img_${data_index}" alt="${data.title!}" width="150" height="80">
	    			</a>
	    		</li>
			</#if>
	    </#list>
	</#if>
    </ul>
  </div>
</div>
<div id="footer">
	  <ul>
		<li><a href="http://www.315che.com/help/0.htm" target="_blank">关于我们</a> | <a href="http://www.315che.com/help/1.htm" target="_blank">联系我们</a> | <a href="http://www.315che.com/help/2.htm" target="_blank">广告服务</a> | <a href="http://www.315che.com/help/3.htm" target="_blank">友情链接</a> | <a href="http://www.315che.com/help/4.htm" target="_blank">网站地图</a> | <a href="http://www.315che.com/help/5.htm" target="_blank">招聘信息</a> | <a href="http://www.315che.com/help/6.htm" target="_blank">法律声明</a> | <a href="http://www.315che.com/help/7.htm" target="_blank">车友会</a> | <a href="http://img.315che.com/hd/jiameng.html" target="_blank">加盟我们</a></li>
	  </ul>
  	  <p>Copyright ? 2005-2020 <a href="mailto:admin@315che.com">中国汽车消费网</a> 备案号:<a href="http://www.miibeian.gov.cn" target="_blank">沪ICP 备 05053107 号</a></p>
      <p><a href="http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&amp;entyId=20120516165658434"><img src="http://img.315che.com/hd/gsicon.gif" border="0"></a>
<a href="http://www.zx110.org/"><img src="http://img.315che.com/hd/2012Imgs/images/zx110.png" border="0"></a>
<a href="http://www.cyberpolice.cn/wfjb/"><img src="http://img.315che.com/hd/2012Imgs/images/police.png" border="0"></a>
</p>
</div>
  <map name="Map">
    <area shape="rect" coords="143,326,229,358" href="#newzx">
    <area shape="rect" coords="248,326,332,358" href="#xcjx">
    <area shape="rect" coords="365,326,449,358" href="#zzxc">
    <area shape="rect" coords="465,326,550,358" href="#hzxc">
    <area shape="rect" coords="153,373,249,402" href="#gnxc">
    <area shape="rect" coords="266,373,350,402" href="#mnmt">
    <area shape="rect" coords="382,373,468,402" href="http://www.315che.com/chengdu/" target="_blank">
    <area shape="rect" coords="491,373,662,402" href="http://www.315che.com/" target="_blank">
  </map>
		<div class="footer">
			<p>
				<a href="http://www.315che.com/help/0.htm">关于我们</a> |
				<a href="http://www.315che.com/help/1.htm">联系我们</a> |
				<a href="http://www.315che.com/help/2.htm">广告服务</a> |
				<a href="http://www.315che.com/help/3.htm">友情链接</a> |
				<a href="http://www.315che.com/help/4.htm">网站地图</a> |
				<a href="http://www.315che.com/help/5.htm">招聘信息</a> |
				<a href="http://www.315che.com/help/6.htm">法律声明</a> |
				<a href="http://www.315che.com/help/7.htm">车友会</a> |
				<a href="#">加盟我们</a>
			</p>
			<p class="copyright">Copyright © 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号</p>
			<p>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/sh_gongshang.jpg" alt=""></a>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/zx110.jpg" alt=""></a>
				<a href="javascript:void(0);"><img src="http://www.315che.com/images/sh_110.jpg" alt=""></a>
				<a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1792781713"><img src="http://www.315che.com/images/itrust_315che.jpg" alt=""></a>
			</p>
		</div>
	</div>
	<script src="http://zt.315che.com/common/js/jquery-1.11.2.min.js"></script>
	<script src="http://zt.315che.com/common/js/jquery.bxslider.min.js"></script>

	<script>
	$(document).ready(function() {
		// 焦点图
		$('#focus-slider').bxSlider({
			mode: 'horizontal',
			controls: false,
			captions: true,
			auto: true
		});
		$('#g-slider-01, #g-slider-02').bxSlider({
			mode: 'horizontal',
			controls: false,
			captions: true
		});
	});
	</script>
</body>
</html>