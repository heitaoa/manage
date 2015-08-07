<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title!}</title>
<link rel="stylesheet" type="text/css" href="http://zt.315che.com/common/css/315che-base.css">
<link href="http://zt.315che.com/wuhan/150416/style/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="mihead-bg">
	<div id="goto-top" class="mihead">
		<div class="milogo">
			<a href="http://www.315che.com/" onfocus="this.blur();">中国汽车消费网</a>
		</div>
		<div class="midaohang">
			<a href="http://www.315che.com/">首页</a>
			<a href="http://www.315che.com/newcar/">新车</a>
			<a href="http://inf.315che.com/">新闻</a>
			<a href="http://www.315che.com/buy/">导购</a>
			<a href="http://www.315che.com/pingce/">试驾评测</a>
			<a href="http://www.315che.com/pic/">图库</a>
			<a href="http://www.315che.com/hq/">行情</a>
			<a href="http://auto.315che.com/">报价</a>
			<a href="http://4s.315che.com/">经销商</a>
			<a href="http://www.315che.com/tools/">工具</a>
			<a href="http://bbs.315che.com/">论坛</a>
			<a href="http://tousu.315che.com/">汽车投诉</a>
			<a href="http://www.315che.com/kanche/" class="highlight">小胖看车团</a>
		</div>
		<div class="micity">
			<span style="font-weight:bold; color:#FFFFFF;">城市站：</span>
			<a title="上海站" href="http://www.315che.com/sh/">上海</a>
			<a title="北京站" href="http://www.315che.com/bj/">北京</a>
			<a title="广州站" href="http://www.315che.com/gz/">广州</a>
			<a title="成都站" href="http://www.315che.com/chengdu/">成都</a>
			<a title="武汉站" href="http://www.315che.com/wuhan/">武汉</a>
			<a title="南京站" href="http://www.315che.com/nanjing/">南京</a>
			<a title="合肥站" href="http://www.315che.com/hefei/">合肥</a>
			<a title="大连站" href="http://www.315che.com/dalian/">大连</a>
		</div>
	</div>
</div>

<div class="banner">
	<#if dataMap.get("顶部背景图片w1440_h552")??>
		<#list dataMap.get("顶部背景图片w1440_h552") as data>
			<#if data_index lt 1>
				<img src="${data.pic!}"/>
			</#if>
		</#list>
	</#if>
</div>

<div id="box">
	<div style="padding-top:66px; height:375px">
		<ul>
			<li style="float:left;padding-left:30px;border:1px solid #333">
				<#if dataMap.get("地理位置左侧图片w442_h304")??>
					<#list dataMap.get("地理位置左侧图片w442_h304") as data>
						<#if data_index lt 1>
							<img src="${data.pic!}"/>
						</#if>
					</#list>
				</#if>
			</li>
			<li style="float:left;padding-left:70px">
				<#if dataMap.get("地理位置图片w451_h282")??>
					<#list dataMap.get("地理位置图片w451_h282") as data>
						<#if data_index lt 1>
							<img src="${data.pic!}"/>
						</#if>
					</#list>
				</#if>
			</li>
		</ul>
	</div>
	<div class="news">
		<img src="http://zt.315che.com/wuhan/150416/imgs/tit01.png">
		<ul>
			<#if dataMap.get("访谈实录w174_h122")??>
				<#list dataMap.get("访谈实录w174_h122") as data>
					<#if data_index lt 4>
						<li>
							<span><img src="${data.pic!}"></span>
							<p><strong>${data.title!}</strong><br>${data.content!}<a href="${data.link!}" target="_blank">[详细]</a></p>
						</li>		
					</#if>
				</#list>
			</#if>
		</ul>
	</div>

	<div class="intro">
		<img src="http://zt.315che.com/wuhan/150416/imgs/tit02.png">
		<ul>
			<#if dataMap.get("企业介绍w291_h191")??>
				<#list dataMap.get("企业介绍w291_h191") as data>
					<#if data_index lt 1>
						<li>
							<span><img src="${data.pic!}"></span>
							<p>${data.content!}</p>
						</li>
					</#if>
				</#list>
			</#if>
		</ul>
	</div>

	<hr size="5" color="#0d3669">

	<div id="bottom">
		<ul>
			<li><a href="">About US</a></li>
			<li>|</li>
			<li><a href="">网站介绍</a></li>
			<li>|</li>
			<li><a href="">隐私政策</a></li>
			<li>|</li>
			<li><a href="">广告服务</a></li>
			<li>|</li>
			<li><a href="">合作媒体</a></li>
			<li>|</li>
			<li><a href="">投稿指南</a></li>
			<li>|</li>
			<li><a href="">使用条款</a></li>
			<li>|</li>
			<li><a href="">联系我们</a></li>
			<li>|</li>
			<li><a href="">招聘精英</a></li>
			<li>|</li>
			<li><a href="">网站地图</a></li>
			<li>|</li>
			<li><a href="">用户体验升级计划</a></li>
		</ul>
	</div>
</div>

<div id="footer">
	<p>
		<a target="_blank" href="http://www.315che.com/help/0.htm">关于我们</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/1.htm">联系我们</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/2.htm">广告服务</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/3.htm">友情链接</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/4.htm">网站地图</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/5.htm">招聘信息</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/6.htm">法律声明</a>
		    |    
		<a target="_blank" href="http://www.315che.com/help/7.htm">车友会</a>
	</p>
	<p>
		Copyright © 2005-2010
		<a href="mailto:admin@315che.com">中国汽车消费网</a>
		备案号:
		<a target="_blank" href="http://www.miibeian.gov.cn">沪ICP 备 05053107 号</a>
	</p>
</div>

</body>
</html>