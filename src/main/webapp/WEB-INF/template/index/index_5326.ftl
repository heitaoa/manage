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
	<title>Ͷ�ߵǼ� - ������ - ��������O2O�����һƷ��</title>
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
	<!-- �����˵��� start -->
	<div class="topbar">
		<div class="mini-bg">
			<div class="mini-main">
				<div class="mini-left">�����ѯ���ߣ�400 88 16315��09:00~18:00��</div>
				<div class="mini-brand">��������O2O�����һƷ��</div>
				<div class="mini-right">
					<span class="qq">QQ��ѯ��400 88 16315</span>
					<span class="login"><a href="">��¼</a>|<a href="">ע��</a></span>
				</div>
			</div>
		</div>
		<div class="header-bg">
			<div class="header-main">
				<div class="logo"><a href=""><img src="images/logo.png" alt=""></a></div>
				<div class="c-city">
					<em>�Ϻ�</em>
					<a href="">[�л�����]</a>
					<div style="display:none;" class="citypop"></div>
				</div>
				<div class="search">
					<form action="">
						<input type="text" class="search-text" value="������Ҫ�Ź�������Ʒ�ƻ���">
						<input type="submit" class="search-submit" value="����">
					</form>
				</div>
				<ul class="slogan">
					<li><i class="sq"></i>ʡǮ</li>
					<li><i class="sl"></i>ʡ��</li>
					<li><i class="sx"></i>ʡ��</li>
					<li><i class="sq"></i>ʡʱ</li>
				</ul>
			</div>
		</div>
		<div class="nav-bg">
			<div class="nav-main">
				<ul class="nav-link">
					<li><a class="active" href="">����</a></li>
					<li><a href="">�Ź���ȫ</a></li>
					<li><a href="">������</a></li>
					<li><a href="">�����Ź�</a></li>
					<li><a href="">άȨͶ��</a></li>
					<li><a href="">������</a></li>
					<li><a href="">�ֻ�����</a></li>
					<li><a href="">С�ֿ�����</a></li>
					<li class="last"><a href="">ͼ��</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- �����˵��� end -->
	<!-- ������ start -->
	<div class="content-top-warpper">
		<div class="content-main">
			<h1>����֣�س�ŵ<em>����������ƽ��������</em>�Ĵ���ÿ���ͻ�Ͷ��</h1>
			<h3>����ӵ�н�300��רҵ��ʦά��������Ȩ�棬�ṩ���ɱ���</h3>
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
						<h2 class="title">��һ�����ֻ���֤</h2>
						<i id="tri-tr" class="triangle-a"></i>
						<i id="tl3" class="triangle-b"></i>
						<p class="fix-p1">Ϊȷ��������ݣ���Ҫ�ֻ���֤��<a href="">��¼</a></p>
					</div>
					<div class="mobile-check">
						<ul class="state-a " id="st1">
							<li>
								<dd class="dd-left">* �ֻ��ţ�</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:25px;" />
									<a class="get-vcode fl" href="javascript:void(0)" title="��ȡ��֤��" id="getMsg">��ȡ��֤��</a>
								</dd>
							</li>
							<li class="tips">(��ʵ����д�������޷�����Э����)</li>
						</ul>
						<ul class="state-a hide" id="st2">
							<li>
								<dd class="dd-left">* �ֻ��ţ�</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:5px;"/>
									<em class="gray-b">60�������»�ȡ</em>
								</dd>
							</li>
							<li><em class="gray-a">(��ʵ����д�������޷�����Э��)</em></li>
							<li>
								<dd class="dd-left">* ��֤�룺</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" style="margin-right:25px;" />
									<a class="ok-btn fl" href="javascript:void(0)" title="" id="checkMsg">ȷ��</a>
								</dd>
							</li>
						</ul>
						<ul class="state-a hide" id="st3">
							<li class="fix-center">
								<h2>�ֻ��ţ�<em>13568653389</em></h2>
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
								<dd class="dd-left">* �ֻ��ţ�</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a" style="margin-right:25px;" />
								</dd>
							</li>
							<li class="tips">�������ֻ��źͶ�Ӧ��Ͷ�ߺ�</li>
						</ul>
						<ul class="state-a">
							<li>
								<dd class="dd-left">* �ֻ��ţ�</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" />
									<em class="red">�ѽ��<a href="" title="�鿴��ϸ">���鿴��ϸ��</a></em>
								</dd>
							</li>
							<li>
								<dd class="dd-left">* ��֤�룺</dd>
								<dd class="dd-right">
									<input type="text" class="register-text-a fl" />
									<em class="tip-txt-box fl">��̬��֤��</em>
									<a class="ok-btn fl" href="" title="">��ѯ</a>
								</dd>
							</li>
							<li><em class="gray-a">�������ֻ��źͶ�Ӧ��Ͷ�ߺ�</em></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="iinfo-box">
				<div class="column-title2">
					<h2 class="title">�ڶ�����������Ϣ</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
					<p class="fix-p2">Ϊ���ܹ����ٴ�������Ͷ�ߣ���������д���ĸ�����Ϣ�� ����Ϊ������Ϣ�����ṫ�����������д��</p>
				</div>
				<div class="iinfo-main">
					<table class="table">
						<tr>
							<td class="twa">*����������</td>
							<td class="twb">
								<input type="text" class="register-text-b" />
								<em>(ʵ����д�������޷�����Э����)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*����������</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>�ǳ���Ҫ��������վ��Ա����ȡ����ϵ������Ͷ�ߴ�����</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*���֤�ţ�</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>������18λ���֤�ţ����ں�ʵ������ݣ����򳧼��ṩ!</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*���ڵ�����</td>
							<td class="twb">
								<div class="select-box1">
									<select name="searchtype" id="big-citys" style="display:none;">
										<option value="0">ʡ��</option>
										<option value="1">�Ϻ�</option>
										<option value="2">����</option>
										<option value="3">�㽭</option>
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
										<option value="0">���ڳ���</option>
										<option value="1">�Ϻ�</option>
										<option value="2">����</option>
										<option value="3">�㽭</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#cur-city").selectbox();
										});
									</script>
								</div>
								<em>(������ѡ�������ڵ���ý��ĸ�����)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*��ϸ��ַ��</td>
							<td class="twb">
								<input type="text" class="register-text-d" />
								<em> ��ϸ��д�������ó���Э������4S���ṩ����!</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp">
						<a href="" class="save-btn">����</a>
					</div>
				</div>
			</div>
			<div class="carinfo-box">
				<div class="column-title2">
					<h2 class="title">��������������Ϣ</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
					<p class="fix-p2">Ϊ���ܹ����ٴ�������Ͷ�ߣ���������д���ĸ�����Ϣ�� ����Ϊ������Ϣ�����ṫ�����������д��</p>
				</div>
				<div class="carinfo-main">
					<table class="table">
						<tr>
							<td class="twa">*���ͷ��ࣺ</td>
							<td class="twb">
								<div class="select-box1">
									<select name="searchtype" id="car-brand" style="display:none;">
										<option value="0">C����</option>
										<option value="1">B����</option>
										<option value="2">xѩ����</option>
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
										<option value="0">��ѡ��ϵ��</option>
										<option value="1">Aϵ��</option>
										<option value="2">Bϵ��</option>
									</select>
									<script src="js/jQselect.js" type="text/javascript"></script>
									<script>
										$(document).ready(function() {
										    $("#car-xl").selectbox();
										});
									</script>
								</div>
								<em>(׼ȷѡ����ȷ��Ͷ�ߵõ������ǰ������!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">*�� �� �ţ�</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>�義A12345�����޳�������д"�޳���"</em>
							</td>
						</tr>
						<tr>
							<td class="twa">��ǰ��̣�</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>��ʵ��д�Գ����˽�������а�����</em>
							</td>
						</tr>
						<tr>
							<td class="twa">�������ţ�</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>���ֳ�����Ҫ�з������Ų�������Ͷ�ߣ�</em>
							</td>
						</tr>
						<tr>
							<td class="twa">�� �� �ţ�</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>��ʵ��д�Գ����˽�������а��������ֳ�����Ҫ�г��ܺŲ�������Ͷ�ߣ�</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* ����ʱ�䣺</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(׼ȷѡ�������ڳ���׼ȷ�жϣ��ṩ����ݵĴ������!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">����4S�꣺</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(��Ͷ���漰��4S�꣬���ֳ����޴������ݾܾ���������������д!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">4S��绰��</td>
							<td class="twb">
								<input type="text" class="register-text-c" />
								<em>(����ϸ��д4S����ϵ��ʽ!)</em>
							</td>
						</tr>
						<tr>
							<td class="twa">����״̬��</td>
							<td class="twb">
								<label for="aaa">
									<input type="radio" name="carState" id="aaa" />
									һ������
								</label>
								<label for="bbb">
									<input type="radio" name="carState" id="bbb" />
									ĥ������
								</label>
								<label for="ccc">
									<input type="radio" name="carState" id="ccc" />
									��������
								</label>
								<label for="ddd">
									<input type="radio" name="carState" id="ddd" />
									��������
								</label>
								<em>(��ȷ��״̬�����ڳ���׼ȷ�˽�������ṩ�������!)</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp">
						<a href="" class="save-btn">����</a>
					</div>
				</div>
			</div>
			<div class="complaints-content">
				<div class="column-title2">
					<h2 class="title">���Ĳ���Ͷ������</h2>
					<i id="tri-tr" class="triangle-a"></i>
					<i id="tl3" class="triangle-b"></i>
				</div>
				<div class="ccontent-main">
					<table class="table">
						<tr>
							<td class="twa">* Ͷ�߶���</td>
							<td class="twb">
								<label for="a1"><input name="a" id="a1" type="checkbox" value="1" /><em class="checkbox-txt">������</em></label>
								<label for="a2"><input name="a" id="a2" type="checkbox" value="2" /><em class="checkbox-txt">������</em></label>
								<label for="a3"><input name="a" id="a3" type="checkbox" value="3" /><em class="checkbox-txt">�����봫��ϵͳ</em></label>
								<label for="a4"><input name="a" id="a4" type="checkbox" value="4" /><em class="checkbox-txt">�ƶ���ת��ϵͳ</em></label>
								<label for="a5"><input name="a" id="a5" type="checkbox" value="5" /><em class="checkbox-txt">�����豸</em></label>
								<label for="a6"><input name="a" id="a6" type="checkbox" value="6" /><em class="checkbox-txt">��̥</em></label>
								<label for="a7"><input name="a" id="a7" type="checkbox" value="7" /><em class="checkbox-txt">�����벣��</em></label>
								<label for="a8"><input name="a" id="a8" type="checkbox" value="8" /><em class="checkbox-txt">��������</em></label>
								<label for="a9"><input name="a" id="a9" type="checkbox" value="9" /><em class="checkbox-txt">��ǰ</em></label>
								<label for="a10"><input name="a" id="a10" type="checkbox" value="10" /><em class="checkbox-txt">�ۺ�</em></label>
								<em class="f12-gray">����ѡ�������д��</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* Ͷ������</td>
							<td class="twb">
								<label for="b1"><input name="b" id="b1" type="checkbox" value="1" /><em class="checkbox-txt">ά��</em></label>
								<label for="b2"><input name="b" id="b2" type="checkbox" value="2" /><em class="checkbox-txt">�⳥</em></label>
								<label for="b3"><input name="b" id="b3" type="checkbox" value="3" /><em class="checkbox-txt">�ٻ�</em></label>
								<label for="b4"><input name="b" id="b4" type="checkbox" value="4" /><em class="checkbox-txt">�˻���</em></label>
								<label for="b5"><input name="b" id="b5" type="checkbox" value="5" /><em class="checkbox-txt">����/�Ĵ�</em></label>
								<label for="b6"><input name="b" id="b6" type="checkbox" value="6" /><em class="checkbox-txt">����</em></label>
								<em>����ѡ�������д��</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* Ͷ�����⣺</td>
							<td class="twb">
								<input type="text" class="register-text-e" />
								<em>��ע����Ͷ����ҵ��Ʒ������</em>
							</td>
						</tr>
						<tr>
							<td class="twa">* Ͷ�����ݣ�</td>
							<td class="twb">
								<em>����Ͷ�ߵ����Ի��������ڴ����롣 ��͹�����Ͷ�����ݣ���������50�����֡�</em>
							</td>
						</tr>
						<tr>
							<td class="twa" style="padding-top:0;">&nbsp;</td>
							<td class="twb" style="padding-top:0;">
								<em class="orange">Ϊ����������Ϣ��ȫ,������Ͷ�������������������ĸ���������Ϣ����绰���룬������סַ��</em>
								<textarea class="textarea-a" name="" id="" cols="30" rows="10"></textarea>
							</td>
						</tr>
						<tr>
							<td class="twa" style="padding-top:0;">&nbsp;</td>
							<td class="twb" style="padding-top:0;">
								<input class="file-btn" type="file" />
								<input class="upload-btn" type="button" value="�ϴ�ͼƬ" />
								<em class="pic-format-tips">֧��jpg,gif,png��ʽ</em>
							</td>
						</tr>
					</table>
					<div class="btn-warp2">
						<input type="submit" class="submit-btn" value="�ύͶ��" />
						<em class="orange">(���뱣���һ���͵ڶ��������ύͶ��)</em>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ������ end -->
	<div class="footer">
		<div class="footer-bar">
			<a href="">��������</a>|<a href="">��ϵ����</a>|<a href="">������</a>|<a href="">��������</a>|<a href="">��վ��ͼ</a>|<a href="">��Ƹ��Ϣ</a>|<a href="">��������</a>|<a href="">���ѻ�</a>|<a href="">��������</a>
		</div>
		<p>Copyright &copy; 2005-2020 <a href="">�й�����������</a> �����ţ���ICP �� 05053107 ��</p>
		<p>
			<a href=""><img src="images/sh_icbc.jpg" alt=""></a>
			<a href=""><img src="images/zx110.jpg" alt=""></a>
			<a href=""><img src="images/sh_cyberpolice.jpg" alt=""></a>
		</p>
	</div>
</body>
</html>