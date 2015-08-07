<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>广州小胖购车节</title>
    <link rel="stylesheet" type="text/css" href="http://zt.315che.com/common/css/315che-base.css">
    <link rel="stylesheet" type="text/css" href="http://zt.315che.com/guangzhou/chezhan/150703/css/main.css">
</head>
<body>

    <!-- 头部 -->
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

    <!-- 内容 -->
    <div class="wrapper">
        <div class="clearfix bgs">
            <div class="imgarea1 bg banner1"></div>
            <div class="imgarea1 bg banner2"></div>
            <div class="imgarea1 bg banner3"></div>
            <div class="imgarea1 bg banner4"></div>
            <div class="imgarea2 bg main1"></div>
            <div class="imgarea2 bg main2"></div>
            <div class="imgarea2 bg main3"></div>
            <div class="imgarea2 bg main4"></div>
            <div class="imgarea2 bg main5"></div>
            <div class="imgarea2 bg main6"></div>
            <div class="imgarea2 bg main7"></div>
            <div class="imgarea2 bg main8"></div>
            <div class="imgarea2 bg main9"></div>
            <div class="imgarea2 bg main10"></div>
        </div>
        <div class="main">
            <h2 class="time-tit">距离活动结束还有：</h2>
            <div class="count-box">
	                <#if dataMap.get("倒计时")??>
						<#list dataMap.get("倒计时") as data>
							<#if data_index lt 1>
								<p class="lxftime" endtime="${data.title!}"></p>
							</#if>
						</#list>
					</#if>	
                <div class="count-time">
                 <span id="day">12</span>天<span id="hours">4</span>时<span id="minutes">8</span>分<span id="seconds">27</span>秒
                </div>
            </div>
            <div class="row infos">
                <div class="info-left">
                    <h2 class="w1">时间：2015年7月25-26日</h2>
                    <h2 class="w1">地点：天河体育中心西南广场</h2>
                    <h2 class="w1 w2">交通：</h2>
                    <p>地铁：体育西路站、体育中心站，体育中心南站（APM）。</p>
                    <p>公交：体育中心BRT站，维多利广场站。</p>
                     <#if dataMap.get("地图w665h384")??>
						<#list dataMap.get("地图w665h384") as data>
							<#if data_index lt 1>
							  <img class="zg-map" src="${data.pic!}" alt="">
							</#if>
						</#list>
					 </#if>	
                </div>
                <div id="baomingCon" class="info-right clearfix">
                    <div class="bm-con">
                        <form action="javascript:void(0);">
                            <ul class="clearfix">		
		                        <#if dataMap.get("报名提醒w240h45")??>
									<#list dataMap.get("报名提醒w240h45") as data>
										<#if data_index lt 1>
										  <li class="bm-tit"><img src="${data.pic!}" alt=""></li>
										</#if>
									</#list>
						       </#if>	 
                                <li class="mb">
                                    <p><span>*</span>姓名：</p>
                                    <input type="text" class="text1" id="username">
                                </li>
                                <li class="mb">
                                    <p><span>*</span>手机：</p>
                                    <input type="text" class="text1" id="userphone">
                                </li>
                                <li>
                                    <p><span>*</span>选择品牌：</p>
                                    <select id="brand" class="sel1">
                                        <option value="">请选择品牌</option>
                                    </select>
                                </li>
                                <li>
                                    <p><span>*</span>选择车型：</p>
                                    <select id="cartype" class="sel1">
                                        <option value="">请选择车型</option>
                                    </select>
                                </li>
                                <li class="btn-area">
                                    <input type="button" class="btn1" onclick="javascript:saveuserinfo();" value="我要预约">
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="map-position">
                        <#if dataMap.get("引进地图w316h270")??>
							<#list dataMap.get("引进地图w316h270") as data>
								<#if data_index lt 1>
								    <iframe src="${data.title!}" width="403" height="347"></iframe>
								</#if>
							</#list>
					    </#if>
                    </div>
                </div>
            </div>
            <div class="banner5">
	              <#if dataMap.get("地图下面的图片w1000h88")??>
					<#list dataMap.get("地图下面的图片w1000h88") as data>
						<#if data_index lt 1>
						   <img src="${data.pic!}" alt="">
						</#if>
	                </#list>
			      </#if>
            </div>
            <div class="tips">
               <#if dataMap.get("礼品头图w1000h54")??>
					<#list dataMap.get("礼品头图w1000h54") as data>
						<#if data_index lt 1>
						   <img src="${data.pic!}" alt="">
						</#if>
	                </#list>
                </#if>             
            </div>
            <div class="liping">
                <#if dataMap.get("礼品图w1000h279")??>
					<#list dataMap.get("礼品图w1000h279") as data>
						<#if data_index lt 1>
						   <img src="${data.pic!}" alt="">
						</#if>
	                </#list>
                </#if>
            </div>
            <div class="row brand-box mab10">
                <div class="brand-column">
                  <#if dataMap.get("参展品牌标题w242h87")??>
					<#list dataMap.get("参展品牌标题w242h87") as data>
						<#if data_index lt 1>
						   <img src="${data.pic!}" alt="">
						</#if>
	                </#list>
                  </#if>
                </div>
                <div class="brand-con">
                    <div class="brand-con-top"></div>
                    <div class="clearfix brand-list">
                        <ul class="slider">
                            <li>
                                <ul>
                                   
	                                 <#if dataMap.get("参展品牌")??>
										<#list dataMap.get("参展品牌") as data>
											<#if data_index lt 16>
											 <li>
											    <div class="brand-img-box">
			                                        <img src="http://img.315che.com/hd/ssss/logo/logo${data.link!}.png" alt="${data.title!}">
			                                    </div>
											        <h3>${data.title!}</h3>
		                                        <p>已有<em>${data.ctitle!}</em>人报名</p>
		                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(${data.link!});">团购报名</a></label>
											 </li>
											</#if>
						                </#list>
					                  </#if>
                                        <!--<div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo105.png" alt="凯迪拉克">
                                        </div>
                                        <h3>凯迪拉克</h3>
                                        <p>已有<em>120</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(105);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo45.png" alt="陆风">
                                        </div>
                                        <h3>陆风</h3>
                                        <p>已有<em>235</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(45);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>113</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(83);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo20.png" alt="东风日产">
                                        </div>
                                        <h3>东风日产</h3>
                                        <p>已有<em>162</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(20);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo93.png" alt="上海大众">
                                        </div>
                                        <h3>上海大众</h3>
                                        <p>已有<em>143</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(93);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo23961.png" alt="北汽幻速">
                                        </div>
                                        <h3>北汽幻速</h3>
                                        <p>已有<em>301</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(23961);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo98.png" alt="福特">
                                        </div>
                                        <h3>福特</h3>
                                        <p>已有<em>161</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(98);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo55.png" alt="别克">
                                        </div>
                                        <h3>别克</h3>
                                        <p>已有<em>170</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(55);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo56.png" alt="雪佛兰">
                                        </div>
                                        <h3>雪佛兰</h3>
                                        <p>已有<em>123</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(56);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo99.png" alt="沃尔沃">
                                        </div>
                                        <h3>沃尔沃</h3>
                                        <p>已有<em>310</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(99);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo109.png" alt="雷克萨斯">
                                        </div>
                                        <h3>雷克萨斯</h3>
                                        <p>已有<em>115</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(109);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo9.png" alt="比亚迪">
                                        </div>
                                        <h3>比亚迪</h3>
                                        <p>已有<em>149</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(9);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo50.png" alt="奇瑞">
                                        </div>
                                        <h3>奇瑞</h3>
                                        <p>已有<em>136</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(50);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo6266.png" alt="马自达">
                                        </div>
                                        <h3>马自达</h3>
                                        <p>已有<em>179</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(6266);">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo70.png" alt="丰田">
                                        </div>
                                        <h3>丰田</h3>
                                        <p>已有<em>103</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn" onclick="javascript:showCarList(70);">团购报名</a></label>
                                    </li>-->
                                </ul>
                            </li>
                           <!-- <li>
                                <ul>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪3</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <ul>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪3</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                    <li>
                                        <div class="brand-img-box">
                                            <img src="http://img.315che.com/hd/ssss/logo/logo83.png" alt="奥迪">
                                        </div>
                                        <h3>奥迪</h3>
                                        <p>已有<em>100</em>人报名</p>
                                        <label><a href="javascript:void(0);" class="baoming-btn">团购报名</a></label>
                                    </li>
                                </ul>
                            </li>-->
                        </ul>
                    </div>
                    <div class="brand-con-bottom"></div>
                </div>
            </div>
            <div class="row">
                 <#if dataMap.get("购车攻略w551h244")??>
					<#list dataMap.get("购车攻略w551h244") as data>
						<#if data_index lt 1>
						   <img src="${data.pic!}" alt="">
						</#if>
					</#list>
			     </#if>
            </div>
            <div class="left-float">
                <ul> 
	                 <#if dataMap.get("微信扫一扫w102h99")??>
						<#list dataMap.get("微信扫一扫w102h99") as data>
							<#if data_index lt 2>
							 <li><img src="${data.pic!}" alt=""></li>
							</#if>
						</#list>
				     </#if>
                    <li><p>扫一扫<br>了解更多车展<br>信息</p></li>
                </ul>
            </div>
            <div class="right-float">
                <a href="#baomingCon">
                     <#if dataMap.get("报名锚链接w103h187")??>
						<#list dataMap.get("报名锚链接w103h187") as data>
							<#if data_index lt 1>
							  <img src="${data.pic!}" alt="">
                            </#if>
					    </#list>
				     </#if>
                </a>
            </div>
        </div>
        <div class="contact-us">
            <div class="con">
                <h1>客服热线：</h1>
                <h2>020-2807 9667 周一 - 周五（9:00-17:00）</h2>
            </div>
        </div>
        <div class="info2">
            <div class="con">
                <p>活动时间：2015年07月25日—26日　　活动地点：天河体育中心西南广场　　主办单位：中国汽车消费网，车团</p>
            </div>
        </div>
    </div>

    <!-- 底部 -->
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

    <!-- 弹出层 开始 -->
    <div id="mask" class="shade"></div>
    <div id="popupLayerOne" class="popup-box">
        <div class="pop-column">
            <h1>报名申请</h1><a id="colse-popup" href="javascript:void(0);">×</a>
        </div>
        <div class="popup-con">
            <form action="#">
            <ul>
                <li class="tips">您好，请输入手机号，立即<span class="red">参团</span>，赢取好礼</li>
                <li>
                    <label><span class="red">*</span>您的姓名：</label>
                    <input type="text" class="text1" id="name">
                </li>
                <li>
                    <label><span class="red">*</span>您的手机：</label>
                    <input type="text" class="text1" id="phone">
                    <input type="radio" name="sex" value="1" /> 先生
                    <input type="radio" name="sex" value="2" /> 女士
                </li>
                <li>
                    <label><span class="red">*</span>所在地区：</label>
                    <select>
					   <#if dataMap.get("城市")??>
							<#list dataMap.get("城市") as data>
								<#if data_index lt 1>
								   <option value="${data.ctitle!}">${data.title!}</option>
								</#if>
							</#list>
					   </#if>
                    </select>
                    <select id="city">
                    </select>
                </li>
                <li>
                    <label>意向车型：</label>
                    <select name="" id="modelid">
                        <option value="">选择车型</option>
                    </select>
                </li>
                <li>
                    <label>&nbsp;</label>
                    <input type="button" class="btn3" value="提交报名" id="bottom_submit" onclick="javascript:savebottomuserinfo();"/>
                </li>
                <input type="hidden" id="carid" value=""/>
            </ul>
            </form>
        </div>
    </div>

    
    <script src="http://zt.315che.com/guangzhou/chezhan/150703/js/jquery-1.11.1.min.js"></script>
    <script src="http://zt.315che.com/guangzhou/chezhan/150703/js/jquery.bxslider.min.js"></script>
    <script src="http://zt.315che.com/guangzhou/chezhan/150703/js/global.js"></script>
	<script src="http://zt.315che.com/common/js/brand.js"></script>
    <script src="http://zt.315che.com/common/js/cartype.js"></script>
	<script src="http://zt.315che.com/common/js/car.js"></script>

<script>
      
	  $(function(){
		$.ajax({
			url:'http://www.315che.com/che/getTousuCity',
			data:{prov:19},
			dataType:'jsonp',
			jsonp:'jsonpcallback',
			success:function(data){
				var data = eval(data)
				var html = '<option value="">请选择城市</option>';
				for(var i =0 ;i<data.length;i++)
				{
					html+='<option value='+data[i].catalogid+'>'+data[i].catalogname+'</option>';
				}
				$("#city").html(html);
			}
		});
	});

        $(function(){
			var brandMap = brandstr[0];
			var html = '<option value="">选择品牌</option>';
			for(var key in brandMap){
				html +='<option value="'+key+'">'+brandMap[key]+'</option>';  
			}  				
			$("#brand").html(html);
		});
		
		
		/*$("#brand").change(function(){
			var carid = $(this).val();
			var carMap = carjson[0];
			for(var key in carMap){
				if(carid==key){
					var carTypeMap = carMap[key];
					var html = '<option value="">选择车型</option>';
					for(var key1 in carTypeMap){
						html +='<option value="'+key1+'">'+carTypeMap[key1]+'</option>';  
					}
					$("#cartype").html(html);
					break;
				}
				
			}
		
		});*/
		
	$("#brand").change(function(){
		var brand = $(this).val();
		var carMap = carstr[0][brand];
		var html = '<option value="">选择车型</option>';
		for(var iwaykey in carMap){
			var carTypeMap = eval(carMap[iwaykey]);
			html += '<option style="font-size:18px;color:#F4A460" disabled="true">'+iwaykey+'</option>';
			for(var carkey in carTypeMap){
				html +='<option value="'+carkey+'">'+carTypeMap[carkey]+'</option>';
			}
		}
		$("#cartype").html(html);
	});
</script>
    <script>
  		function saveuserinfo(){
			var cartype= $("#cartype").val();
			var name=$("#username").val();
			var phone=$("#userphone").val();
			var brand=$("#brand").val();
           // var city=$("#city").val;
			if(name == "" ){
				alert("请输入姓名！");
				return;
			}
			if(phone == "" ){
				alert("请输入手机号！");
				return;
			}
			if(name.length>15){
				alert("输入的名称太长");
				return;
			}
			var regTel=l=/^1[3|5|7|8|][0-9]{9}$/;
			if(!regTel.test(phone)){
				alert("请正确输入手机号");
				return;
			}
			if(brand==""){
				alert("请选择品牌！");
				return;
			}
			if(cartype==""){
				alert("请选择车型！");
				return;
			}
			
			var carinfo="品牌："+$("#brand").children("option:selected").text()+"车系："+$("#cartype").children("option:selected").text();
			$.ajax({
				url : 'http://182.254.147.194:8180/chetuan/saveApplyInf',
				dataType : 'jsonp',
				data :{name:encodeURI(name),carid:brand,modelid:cartype,phone:phone,sex:1,city:0,prov:19,carinfo:encodeURI(carinfo),isSendSms:1},
				jsonp:'jsonpcallback',
				success : function(data){
						/*$.ajax({
							url:'http://182.254.147.194:8180/chetuan/saveMsg',
							dataType : 'jsonp',
							data :{msg:encodeURI('恭喜您报名成功！小胖购车节本月20、21日盛大开启，五十个品牌百多款车一站尽览，签到订车购车都有礼，万元油卡更有半价车。地点：浦东新区国展路189号博大汽车公园内。交通：地铁七号线后滩站4号口出。凭报名手机号码或短信领签到礼进场，欢迎您的莅临！微信：shxpkct。详询400-88-16315'),phone:phone},
							jsonp:'jsonpcallback',
							success : function(data){
								alert("报名成功！！！");
							}
						});*/
						alert("报名成功！！！");
					}
				});
			}	
     </script>

	 <script>
     function savebottomuserinfo(){
			var pro = '19';
			var modelid= $("#modelid").val();
			var name=$("#name").val();
			var phone=$("#phone").val();
			var carid=$("#carid").val();
			var city = $("#city").val();

			if(name == "" ){
				alert("请输入姓名！");
				return;
			}
			if(phone == "" ){
				alert("请输入手机号！");
				return;
			}
			if(name.length>15){
				alert("输入的名称太长");
				return;
			}
			var regTel=l=/^1[3|5|7|8|][0-9]{9}$/;
			if(!regTel.test(phone)){
				alert("请正确输入手机号");
				return;
			}
			if(city==""){
				alert("请选择城市！");
				return;
			}
			if(modelid==""){
				alert("请选择车型！");
				return;
			}
			var brandname = "暂无";
			var brandMap = brandstr[0];
			for(var key in brandMap){
				if(key==carid){
					brandname = brandMap[key];
					break;
				}
			} 
			
			var carinfo="品牌："+brandname+" 车系："+$("#modelid").children("option:selected").text();
			$.ajax({
				url : 'http://182.254.147.194:8180/chetuan/saveApplyInf',
				dataType : 'jsonp',
				data :{name:encodeURI(name),carid:carid,modelid:modelid,phone:phone,sex:1,city:city,prov:pro,carinfo:encodeURI(carinfo),isSendSms:1},
				jsonp:'jsonpcallback',
				success : function(data){
								/*$.ajax({
									url:'http://182.254.147.194:8180/chetuan/saveMsg',
									dataType : 'jsonp',
									data :{msg:encodeURI('恭喜您报名成功！小胖购车节本月20、21日盛大开启，五十个品牌百多款车一站尽览，签到订车购车都有礼，万元油卡更有半价车。地点：浦东新区国展路189号博大汽车公园内。交通：地铁七号线后滩站4号口出。凭报名手机号码或短信领签到礼进场，欢迎您的莅临！微信：shxpkct。详询400-88-16315'),phone:phone},
									jsonp:'jsonpcallback',
									success : function(data){
										alert("报名成功！！！");
									}
								});*/
					alert("报名成功！！！");
					$('#mask').hide();
					$('#popupLayerOne').hide();
				}
			});
		}	
		
		
		function showCarList(carid){
			$("#carid").val(carid);
			var carMap = carstr[0][carid];
			var html = '<option value="">选择车型</option>';
			for(var iwaykey in carMap){
				var carTypeMap = eval(carMap[iwaykey]);
				html += '<option style="font-size:18px;color:#F4A460" disabled="true">'+iwaykey+'</option>';
				for(var carkey in carTypeMap){
					html +='<option value="'+carkey+'">'+carTypeMap[carkey]+'</option>';
				}
			}
			$("#modelid").html(html);



			/*var carMap = carjson[0];
			for(var key in carMap){
				if(carid==key){
					var carTypeMap = carMap[key];
					var html = '<option value="">选择车型</option>';
					for(var key1 in carTypeMap){
						html +='<option value="'+key1+'">'+carTypeMap[key1]+'</option>';  
					}
					$("#modelid").html(html);
					break;
				}
			}*/
		
		}


</script>





</body>
</html>