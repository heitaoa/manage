<!--车险团购-->
<#import "../common_chetuan.ftl" as cc>
<@cc.html 4>
<ul class="position">
	<a href="">车团</a>&gt;<a class="active" href="">车险团购</a>
</ul>
<div class="cardx-box1 clearfix">
	<div class="cardx-maps"><img src="images/cardx-nav1.gif" alt="填写车型资料"></div>
    <div class="cardx-main">
    	<h2>请填写资料报名车险团购</h2>
        <ul>
            <li class="li-left1">您所在城市：</li>
            <li class="li-right1">
            	<div class="select-box">
                    <select name="searchtype" id="city" style="display:none;">
                      <option value="0">上海</option>
                      <option value="1">浙江</option>
                      <option value="2">江苏</option>
                      <option value="3">北京</option>
                      <option value="4">深圳</option>
                      <option value="5">香港</option>
                      <option value="6">澳门</option>
                      <option value="7">重庆</option>
                      <option value="8">天津</option>
                      <option value="9">广西</option>
                    </select>
                    <script src="js/jQselect.js" type="text/javascript"></script>
                    <script>
                        $(document).ready(function() {
                            $("#city").selectbox();
                        });
                    </script>
                </div>
            </li>
            <li class="normal"><input name="" type="checkbox" value=""> 新车未上牌</li>
            <li class="li-left">品牌车型：</li>
            <li class="li-right">
                <input  class="text1" name="" type="text" maxlength="20" />
                <em>例如：帕萨特1.8T</em>
            </li>
            <li class="li-left">车牌号码：</li>
            <li class="li-right">
                <input  class="text1" name="" type="text" maxlength="20" />
                <em>例如：沪-A88888</em>
            </li>
            <li class="li-left">车险到期时间：</li>
            <li class="li-right">
                <input  class="text1" name="" type="text" maxlength="20" />
                <em>例如：2014年8月10日</em>
            </li>
            <li class="li-left">您的姓名：</li>
            <li class="li-right">
                <input  class="text1" name="" type="text" maxlength="20" />
            </li>
            <li class="li-left">您的电话：</li>
            <li class="li-right">
                <input  class="text1" name="" type="text" maxlength="20" />
            </li>
            <li class="li-left2">首选保险公司：</li>
            <li class="li-right2">
                <label for="aaa" title="中国平安保险"><input id="aaa" name="payment" type="radio" value="2" /><span class="cx_company pa"></span></label>
                <label for="bbb" title="中国人寿保险"><input id="bbb" name="payment" type="radio" value="2" /><span class="cx_company rs"></span></label>
                <label for="ccc" title="太平洋保险"><input id="ccc" name="payment" type="radio" value="2" /><span class="cx_company tpy"></span></label>
            </li>
            <li class="normal2"><input class="infolr-btn" name=""  type="button" value="" /></li>
        </ul>
    </div>
    <div class="cardx-info">
    	<ul>
        	<li>
            	<i class="cx-icon cx-icon1"></i>
                <h2>总价省更多</h2>
                <em>车险团购最高可为您省30%车险费用</em>
            </li>
            <li>
            	<i class="cx-icon cx-icon2"></i>
                <h2>支付方便速度快</h2>
                <em>接收报价后，保单会24小时内送达</em>
            </li>
            <li>
            	<i class="cx-icon cx-icon3"></i>
                <h2>各项增值服务</h2>
                <em>保险公司给车团用户提供更多增值服务</em>
            </li>
        </ul>
    </div>
</div>
<div class="cardx-box2 clearfix">
	<h2>车险团购问答</h2>
    <dl class="cx-list">
    	<dt>在不同的保险公司买车险有区别吗？</dt>
        <dd>本质上没有区别。但有些区别在于各保险公司的服务有差异，例如：有的保险公司理赔快，有的保险公司增值服务多等。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>经常购买的险种有哪些？</dt>
        <dd>大家经常购买的险种包含：交强险、车辆损失险、商业第三者责任险、不计免赔率特约条款、玻全车盗抢险、车身划痕险、玻璃单独破碎险、自然险等。	</dd>
    </dl>
    <dl class="cx-list">
    	<dt>车辆损失险保什么？</dt>
        <dd>发生保险事故时，补偿您自己车辆的损失。例如：您车辆撞到护栏或与他人相撞，保险公司可以按照条款赔偿您的车辆维修费用。</dd>
        <dd class="grey">购买建议：一般情况下，车团建议您必须购买。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>商业第三者责任险保什么？</dt>
        <dd>若发生保险事故，保险公司可按条款赔偿您对第三方（人或者是物）造成的损失。例如您不小心撞到车或人，造成他人车辆损失、人员伤亡，并且您负有责任，保险公司按照条款赔偿。</dd>
        <dd class="grey">购买建议：一般情况下，车团建议您必须购买，且购买额度要在20-50万元。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>不计免赔率特约条款保什么？</dt>
        <dd>保险事故发生后，按照投保人选择投保险种的事故责任免赔率和绝对免赔率计算的，应当由被保险人自行承担的 金额部分，保险公司负责赔偿。例如您开车撞到柱子，根据条款须自行承担15%的损失，如果买了这个险种，应当由您承担的免赔金额部分，保险公司也是赔偿的。</dd>
        <dd class="grey">购买建议：该险种价格便宜，一般情况下，车团建议您购买。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>玻璃单独破碎险保什么？</dt>
        <dd>如果发生车窗、挡风玻璃的单独破碎，即非事故引起的玻璃破碎，保险公司按实际损失赔偿。 例如高速上行驶被飞石击碎车窗、挡风玻璃；车辆停放被高空坠物砸坏车窗、挡风玻璃。</dd>
        <dd class="grey">购买建议：非必买险种，车辆但如果您的车辆经常停在露天停车场，或经常跑高速，还是建议您购买。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>自燃损失险保什么？</dt>
        <dd>因本车电器、线路、油路、供油系统、供气系统、货物自身发生问题，机动车运转摩擦起火引起火灾，造成车辆自身的损失，保险公司按条款规定赔偿。</dd>
        <dd class="grey">购买建议：非必买险种，但夏季高温，车辆自燃概率较高，有必要购买，另外有自燃先例的车型也建议购买。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>全车盗抢险保什么？</dt>
        <dd>如果整车发生被偷被盗，保险公司按条款进行赔偿。</dd>
        <dd class="grey">购买建议：非必买险种，但经常出入偏远地区，或当地治安不是太好的情况下，建议购买。</dd>
    </dl>
    <dl class="cx-list">
    	<dt>车身划痕险保什么？</dt>
        <dd>在没有发生事故的前提下，无比明显碰撞痕迹的车身表面油漆单独划伤，保险公司负责赔偿。</dd>
        <dd class="grey">购买建议：非必买险种，但如果无固定车位，停车环境较鱼龙混杂的情况下，也可以购买。</dd>
    </dl>
</div>	
</@cc.html>
