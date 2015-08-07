<html lang="zh">
<head>
	<meta charset="gb2312">
	<link rel="stylesheet" href="${www_ct_url}css/style.css">
	<link rel="stylesheet" href="${www_ct_url}css/carx.css">
	<script type="text/javascript" src="${www_ct_url}js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${www_ct_url}js/jquery.bxslider.min.js"></script>
	<!--[if lt IE 7]>
        <script type="text/javascript" src="js/unitpngfix.js"></script>
	<![endif]-->
	<title>投诉登记 - 车团网 - 汽车电商O2O服务第一品牌</title>
	<script type="text/javascript">
$(document).ready(function() {
$("#getMsg").click(function(){
			var phone = "18652499337";
			$("#st1").addClass("hide");
			$("#st2").removeClass("hide");
			$.ajax({
    		url : '${www_ct_url}chetuan/createMsg?phone='+phone,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
    		}
		});
});
$("#checkMsg").click(function(){
alert(${msg!});
$("#st2").addClass("hide");
$("#st3").removeClass("hide");
});
	});
	</script>
</head>
<body>
	<!-- 顶部菜单栏 start -->
	<div class="topbar">
		<div class="mini-bg">
			<div class="mini-main">
				<div class="mini-left">免费咨询热线：400 88 16315（09:00~18:00）</div>
				<div class="mini-brand">汽车电商O2O服务第一品牌</div>
				<div class="mini-right">
					<span class="qq">QQ咨询：400 88 16315</span>
					<span class="login"><a href="">登录</a>|<a href="">注册</a></span>
				</div>
			</div>
		</div>
		<div class="header-bg">
			<div class="header-main">
				<div class="logo"><a href=""><img src="images/logo.png" alt=""></a></div>
				<div class="c-city">
					<em>上海</em>
					<a href="">[切换城市]</a>
					<div style="display:none;" class="citypop"></div>
				</div>
				<div class="search">
					<form action="">
						<input type="text" class="search-text" value="输入您要团购的汽车品牌或车型">
						<input type="submit" class="search-submit" value="搜索">
					</form>
				</div>
				<ul class="slogan">
					<li><i class="sq"></i>省钱</li>
					<li><i class="sl"></i>省力</li>
					<li><i class="sx"></i>省心</li>
					<li><i class="sq"></i>省时</li>
				</ul>
			</div>
		</div>
		<div class="nav-bg">
			<div class="nav-main">
				<ul class="nav-link">
					<li><a class="active" href="">车团</a></li>
					<li><a href="">团购大全</a></li>
					<li><a href="">特卖惠</a></li>
					<li><a href="">车险团购</a></li>
					<li><a href="">维权投诉</a></li>
					<li><a href="">经销商</a></li>
					<li><a href="">乐活社区</a></li>
					<li><a href="">小胖看车团</a></li>
					<li class="last"><a href="">图库</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 顶部菜单栏 end -->
	<!-- 主内容 start -->
	<div class="content-top-warpper">
		<div class="content-main">
			<h1>车团郑重承诺<em>“公正、公平、公开”</em>的处理每件客户投诉</h1>
			<h3>我们拥有近300名专业律师维护消费者权益，提供法律保护</h3>
			<div class="complain-procedure">
				<img src="images/tusuliucheng.gif" alt="">
			</div>
		</div>
	</div>	
	<div class="content">
		<div class="rregister-warpper clearfix">
			<div class="verify-box">
				<div class="mobile-box">
					<div class="column-title">
						<h2 class="title">第一步：手机验证</h2>
						<i id="tri-tr" class="triangle-a"></i>
						<i id="tl3" class="triangle-b"></i>
						<p class="fix-p1">为确认您的身份，需要手机验证或<a href="">登录</a></p>
					</div>
					<div class="mobile-check">
						<ul class="state-a " id="st1">
							<li>
								<dd class="dd-left">* 手机号：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:25px;" />
									<a class="get-vcode fl" href="javascript:void(0)" title="获取验证码" id="getMsg">获取验证码</a>
								</dd>
							</li>
							<li class="tips">(请实名填写，否则无法跟进协调。)</li>
						</ul>
						<ul class="state-a hide" id="st2">
							<li>
								<dd class="dd-left">* 手机号：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:5px;"/>
									<em class="gray-b">60秒后可重新获取</em>
								</dd>
							</li>
							<li><em class="gray-a">(请实名填写，否则无法跟进协调)</em></li>
							<li>
								<dd class="dd-left">* 验证码：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:25px;" />
									<a class="ok-btn fl" href="javascript:void(0)" title="" id="checkMsg">确定</a>
								</dd>
							</li>
						</ul>
						<ul class="state-a hide" id="st3">
							<li class="fix-center">
								<h2>手机号：<em>13568653389</em></h2>
							</li>
						</ul>
					</div>
				</div>
				<div class="mobile-inquiries">
					<div class="inq-column">
						<i class="inq-icon"></i>
					</div>
					<div class="mobile-check">
						<ul class="state-a hide">
							<li>
								<dd class="dd-left">* 手机号：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a" style="margin-right:25px;" />
								</dd>
							</li>
							<li class="tips">请输入手机号和对应的投诉号</li>
						</ul>
						<ul class="state-a">
							<li>
								<dd class="dd-left">* 手机号：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" />
									<em class="red">已解决<a href="" title="查看详细">（查看详细）</a></em>
								</dd>
							</li>
							<li>
								<dd class="dd-left">* 验证码：</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" />
									<em class="tip-txt-box fl">动态验证码</em>
									<a class="ok-btn fl" href="" title="">查询</a>
								</dd>
							</li>
							<li><em class="gray-a">请输入手机号和对应的投诉号</em></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="iinfo-box">
				<div class="column-title2">
					<h2 class="title">第二步：个人信息</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
					<p class="fix-p2">为了能够快速处理您的投诉，请认真填写您的个人信息。 以下为隐藏信息，不会公开，请放心填写。</p>
				</div>
				<div class="iinfo-main">
					<table class="table">
						<tr>
							<td class="twa">*车主姓名：</td>
							<td class="twb">
								<input type="text" class="register-text-b" />
								<em>(实名填写，否则无法跟进协调。)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*车主姓名：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>非常重要，便于网站人员与您取得联系，接收投诉处理结果</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*身份证号：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>请输入18位身份证号，用于核实车主身份，仅向厂家提供!</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*所在地区：</td>
							<td class="twb">
								<div class="select-box1">
									<select name="searchtype" id="big-citys" style="display:none;">
										<option value="0">省份</option>
										<option value="1">上海</option>
										<option value="2">江苏</option>
										<option value="3">浙江</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#big-citys").selectbox();
										});
									</script>
								</div>
								<div class="select-box1">
									<select name="searchtype" id="cur-city" style="display:none;">
										<option value="0">所在城市</option>
										<option value="1">上海</option>
										<option value="2">江苏</option>
										<option value="3">浙江</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#cur-city").selectbox();
										});
									</script>
								</div>
								<em>(请认真选择！以利于当地媒体的跟进！)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*详细地址：</td>
							<td class="twb">
								<input type="text" class="register-text-d" />
								<em> 详细填写有助于让厂家协调附近4S店提供服务!</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp">
						<a href="" class="save-btn">保存</a>
					</div>
				</div>
			</div>
			<div class="carinfo-box">
				<div class="column-title2">
					<h2 class="title">第三步：车辆信息</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
					<p class="fix-p2">为了能够快速处理您的投诉，请认真填写您的个人信息。 以下为隐藏信息，不会公开，请放心填写。</p>
				</div>
				<div class="carinfo-main">
					<table class="table">
						<tr>
							<td class="twa">*车型分类：</td>
							<td class="twb">
								<div class="select-box1">
									<select name="searchtype" id="car-brand" style="display:none;">
										<option value="0">C长城</option>
										<option value="1">B宝马</option>
										<option value="2">x雪佛兰</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#car-brand").selectbox();
										});
									</script>
								</div>
								<div class="select-box2">
									<select name="searchtype" id="car-xl" style="display:none;">
										<option value="0">请选择系列</option>
										<option value="1">A系列</option>
										<option value="2">B系列</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#car-xl").selectbox();
										});
									</script>
								</div>
								<em>(准确选择是确保投诉得到处理的前提条件!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*车 牌 号：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>如京A12345，如无车牌请填写"无车牌"</em>
							</td>
						</tr>
						<tr>
							<td class="twa">当前里程：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>如实填写对厂家了解情况更有帮助！</em>
							</td>
						</tr>
						<tr>
							<td class="twa">发动机号：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>部分厂家需要有发动机号才能受理投诉！</em>
							</td>
						</tr>
						<tr>
							<td class="twa">车 架 号：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>如实填写对厂家了解情况更有帮助！部分厂家需要有车架号才能受理投诉！</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* 购买时间：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(准确选择有利于厂家准确判断，提供更快捷的处理意见!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">所在4S店：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(如投诉涉及到4S店，部分厂家无此项内容拒绝受理，敬请认真填写!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">4S店电话：</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(请详细填写4S店联系方式!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">车辆状态：</td>
							<td class="twb">
								<label for="aaa">
									<input type="radio" name="carState" id="aaa" />
									一个月内
								</label>
								<label for="bbb">
									<input type="radio" name="carState" id="bbb" />
									磨合期内
								</label>
								<label for="ccc">
									<input type="radio" name="carState" id="ccc" />
									保修期内
								</label>
								<label for="ddd">
									<input type="radio" name="carState" id="ddd" />
									保修期外
								</label>
								<em>(正确的状态有助于厂家准确了解情况并提供解决方案!)</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp">
						<a href="" class="save-btn">保存</a>
					</div>
				</div>
			</div>
			<div class="complaints-content">
				<div class="column-title2">
					<h2 class="title">第四步：投诉正文</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
				</div>
				<div class="ccontent-main">
					<table class="table">
						<tr>
							<td class="twa">* 投诉对象：</td>
							<td class="twb">
								<label for="a1"><input name="a" id="a1" type="checkbox" value="1" /><em class="checkbox-txt">发动机</em></label>
								<label for="a2"><input name="a" id="a2" type="checkbox" value="2" /><em class="checkbox-txt">变速箱</em></label>
								<label for="a3"><input name="a" id="a3" type="checkbox" value="3" /><em class="checkbox-txt">悬架与传动系统</em></label>
								<label for="a4"><input name="a" id="a4" type="checkbox" value="4" /><em class="checkbox-txt">制动与转向系统</em></label>
								<label for="a5"><input name="a" id="a5" type="checkbox" value="5" /><em class="checkbox-txt">电器设备</em></label>
								<label for="a6"><input name="a" id="a6" type="checkbox" value="6" /><em class="checkbox-txt">轮胎</em></label>
								<label for="a7"><input name="a" id="a7" type="checkbox" value="7" /><em class="checkbox-txt">漆面与玻璃</em></label>
								<label for="a8"><input name="a" id="a8" type="checkbox" value="8" /><em class="checkbox-txt">其它附件</em></label>
								<label for="a9"><input name="a" id="a9" type="checkbox" value="9" /><em class="checkbox-txt">售前</em></label>
								<label for="a10"><input name="a" id="a10" type="checkbox" value="10" /><em class="checkbox-txt">售后</em></label>
								<em class="f12-gray">（多选，务必填写）</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* 投诉诉求：</td>
							<td class="twb">
								<label for="b1"><input name="b" id="b1" type="checkbox" value="1" /><em class="checkbox-txt">维修</em></label>
								<label for="b2"><input name="b" id="b2" type="checkbox" value="2" /><em class="checkbox-txt">赔偿</em></label>
								<label for="b3"><input name="b" id="b3" type="checkbox" value="3" /><em class="checkbox-txt">召回</em></label>
								<label for="b4"><input name="b" id="b4" type="checkbox" value="4" /><em class="checkbox-txt">退换车</em></label>
								<label for="b5"><input name="b" id="b5" type="checkbox" value="5" /><em class="checkbox-txt">赔礼/改错</em></label>
								<label for="b6"><input name="b" id="b6" type="checkbox" value="6" /><em class="checkbox-txt">其它</em></label>
								<em>（多选，务必填写）</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* 投诉主题：</td>
							<td class="twb">
								<input type="text" class="register-text-e" />
								<em>请注明被投诉企业或品牌名称</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* 投诉内容：</td>
							<td class="twb">
								<em>其他投诉的属性或描述请在此输入。 请客观描述投诉内容，不能少于50个汉字。</em>
							</td>
						</tr>
						<tr>
							<td class="twa" style="padding-top:0;">&nbsp;</td>
							<td class="twb" style="padding-top:0;">
								<em class="orange">为保护您的信息安全,请勿在投诉内容正文里输入您的个人敏感信息，如电话号码，姓名和住址等</em>
								<textarea class="textarea-a" name="" id="" cols="30" rows="10"></textarea>
							</td>
						</tr>
						<tr>
							<td class="twa" style="padding-top:0;">&nbsp;</td>
							<td class="twb" style="padding-top:0;">
								<input class="file-btn" type="file" />
								<input class="upload-btn" type="button" value="上传图片" />
								<em class="pic-format-tips">支持jpg,gif,png格式</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp2">
						<input type="submit" class="submit-btn" value="提交投诉" />
						<em class="orange">(必须保存第一步和第二步才能提交投诉)</em>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 主内容 end -->
	<div class="footer">
		<div class="footer-bar">
			<a href="">关于我们</a>|<a href="">联系我们</a>|<a href="">广告服务</a>|<a href="">友情链接</a>|<a href="">网站地图</a>|<a href="">招聘信息</a>|<a href="">法律声明</a>|<a href="">车友会</a>|<a href="">加盟我们</a>
		</div>
		<p>Copyright &copy; 2005-2020 <a href="">中国汽车消费网</a> 备案号：沪ICP 备 05053107 号</p>
		<p>
			<a href=""><img src="images/sh_icbc.jpg" alt=""></a>
			<a href=""><img src="images/zx110.jpg" alt=""></a>
			<a href=""><img src="images/sh_cyberpolice.jpg" alt=""></a>
		</p>
	</div>
</body>
</html>