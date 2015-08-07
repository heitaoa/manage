<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "【汽车价值评估】车价评估_2014最新汽车价值评估-车团网"  "车团网购车工具提供2014最新汽车价值评估，车价评估，车团网，汽车电商O2O服务第一品牌。" "汽车价值评估,车价评估">
<head>
	<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
	<script type="text/javascript">
		var a=25;
		var b=30;
		var c=15;
		var d=15;
		var e=15;
		//动力性
		var a1=40;
		var a2=30;
		var a3=10;
		var a4=20;
		//操控性
		var b1=30;
		var b2=15;
		var b3=10;
		var b4=10;
		var b5=35;
		//安全性
		var c1=40;
		var c2=40;
		var c3=20;
		//经济性
		var d1=30;
		var d2=20;
		var d3=30;
		var d4=20;
		//舒适性
		var e1=20;
		var e2=20;
		var e3=10;
		var e4=10;
		var e5=20;
		var e6=20;
	
	function onChange()
	{
		var A = document.getElementById("A").value;
		var B = document.getElementById("B").value;
		var C = document.getElementById("C").value;
		var D = document.getElementById("D").value;
		var E = document.getElementById("E").value;
	
		if(A.length>0)	{	isnumber(A);a = A; }
		if(B.length>0)	{	isnumber(B);b = B; }
		if(C.length>0)	{	isnumber(C);c = C; }
		if(D.length>0)	{	isnumber(D);d = D; }
		if(E.length>0)	{	isnumber(E);e = E; }
		
		if(A.length>0 && B.length>0 && C.length>0 && D.length>0 && E.length>0 )
		{
			if((1*A+1*B+1*C+1*D+1*E)!=100)
			{
				alert("您认为的性能权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的性能权重！");
			return;		
		}
		
		var A1 = document.getElementById("A1").value;
		var A2 = document.getElementById("A2").value;
		var A3 = document.getElementById("A3").value;
		var A4 = document.getElementById("A4").value;
		
		if(A1.length>0)	{	isnumber(A1);a1 = A1; }
		if(A2.length>0)	{	isnumber(A2);a2 = A2; }
		if(A3.length>0)	{	isnumber(A3);a3 = A3; }
		if(A4.length>0)	{	isnumber(A4);a4 = A4; }
		
		if(A1.length>0 && A2.length>0 && A3.length>0 && A4.length>0 )
		{
			if((1*A1+1*A2+1*A3+1*A4)!=100)
			{
				alert("您认为的动力性中的项目权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的动力性中的项目权重比！");
			return;		
		}
		
		//////////////////////操控性
		var B1 = document.getElementById("B1").value;
		var B2 = document.getElementById("B2").value;
		var B3 = document.getElementById("B3").value;
		var B4 = document.getElementById("B4").value;
		var B5 = document.getElementById("B5").value;
		
		if(B1.length>0)	{	if(isnumber(B1))b1 = B1; }
		if(B2.length>0)	{	if(isnumber(B2))b2 = B2; }
		if(B3.length>0)	{	if(isnumber(B3))b3 = B3; }
		if(B4.length>0)	{	if(isnumber(B4))b4 = B4; }
		if(B5.length>0)	{	if(isnumber(B5))b5 = B5; }
		
		if(B1.length>0 && B2.length>0 && B3.length>0 && B4.length>0 && B5.length>0 )
		{
			if((1*B1+1*B2+1*B3+1*B4+1*B5)!=100)
			{
				alert("您认为的操控性中的项目权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的操控性中的项目权重比！");
			return;	
		}
		//////////////////////安全性
		var C1 = document.getElementById("C1").value;
		var C2 = document.getElementById("C2").value;
		var C3 = document.getElementById("C3").value;
		
		if(C1.length>0)	{	if(isnumber(C1))c1 = C1; }
		if(C2.length>0)	{	if(isnumber(C2))c2 = C2; }
		if(C3.length>0)	{	if(isnumber(C3))c3 = C3; }
		
		if(C1.length>0 && C2.length>0 && C3.length>0)
		{
			if((1*C1+1*C2+1*C3)!=100)
			{
				alert("您认为的安全性中的项目权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的安全性中的项目权重比！");
			return;	
		}
		//////////////////////经济性
		var D1 = document.getElementById("D1").value;
		var D2 = document.getElementById("D2").value;
		var D3 = document.getElementById("D3").value;
		var D4 = document.getElementById("D4").value;
		
		if(D1.length>0)	{	if(isnumber(D1))d1 = D1; }
		if(D2.length>0)	{	if(isnumber(D2))d2 = D2; }
		if(D3.length>0)	{	if(isnumber(D3))d3 = D3; }
		if(D4.length>0)	{	if(isnumber(D4))d4 = D4; }
		
		if(D1.length>0 && D2.length>0 && D3.length>0 && D4.length>0 )
		{
			if((1*D1+1*D2+1*D3+1*D4)!=100)
			{
				alert("您认为的经济性中的项目权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的经济性中的项目权重比！");
			return;		
		}
		
		
		//////////////////////舒适性
		var E1 = document.getElementById("E1").value;
		var E2 = document.getElementById("E2").value;
		var E3 = document.getElementById("E3").value;
		var E4 = document.getElementById("E4").value;
		var E5 = document.getElementById("E5").value;
		var E6 = document.getElementById("E6").value;
		
		if(E1.length>0)	{	if(isnumber(E1))e1 = E1; }
		if(E2.length>0)	{	if(isnumber(E2))e2 = E2; }
		if(E3.length>0)	{	if(isnumber(E3))e3 = E3; }
		if(E4.length>0)	{	if(isnumber(E4))e4 = E4; }
		if(E5.length>0)	{	if(isnumber(E5))e5 = E5; }
		if(E6.length>0)	{	if(isnumber(E6))e6 = E6; }
		
		if(E1.length>0 && E2.length>0 && E3.length>0 && E4.length>0 && E5.length>0 && E6.length>0  )
		{
			if((1*E1+1*E2+1*E3+1*E4+1*E5+1*E6)!=100)
			{
				alert("您认为的舒适性中的项目权重比累计不等于100%,请重新设置!");
				return;
			}
		}else{
			alert("请输入所有的舒适性中的项目权重比！");
			return;		
		}
		
		
		var Total=0;
		var as = 0;
		var AN1=0;
		if(document.getElementById("AN1").value.length<1)
		{	alert("请对动力性的'静止起步'评分!");return;}
		if(isnumber1(document.getElementById("AN1").value))
		AN1 = a*document.getElementById("AN1").value*a1*0.0001;
		as += AN1;
		var AN2=0;
		//document.getElementById("AS1").innerHTML = AN1.toFixed(2);
		if(document.getElementById("AN2").value.length<1)
		{	alert("请对动力性的'超车加速时间'评分!");return;}
		if(isnumber1(document.getElementById("AN2").value))
			 AN2= a*document.getElementById("AN2").value*a2*0.0001;
			 
		as += AN2;
		//document.getElementById("AS2").innerHTML = AN2.toFixed(2);
		var AN3=0;
		if(document.getElementById("AN3").value.length<1)
		{	alert("请对动力性的'最高车速'评分!");return;}
		if(isnumber1(document.getElementById("AN3").value))
			 AN3 = a*document.getElementById("AN3").value*a3*0.0001;
			 
		as += AN3;
		//document.getElementById("AS3").innerHTML = AN3.toFixed(2);
		var AN4=0;
		if(document.getElementById("AN4").value.length<1)
		{	alert("请对动力性的'动力总成应用技术'评分!");return;}
		if(isnumber1(document.getElementById("AN4").value))
		 AN4 = a*document.getElementById("AN4").value*a4*0.0001;
		as += AN4;
		//document.getElementById("AS4").innerHTML = AN4.toFixed(2);
		Total += as;
		
		var bs = 0;
		var BN1=0;
		if(document.getElementById("BN1").value.length<1)
		{	alert("请对操控性的'弯道性能'评分!");return;}
		if(isnumber1(document.getElementById("BN1").value))
			 BN1 = b*document.getElementById("BN1").value*b1*0.0001;
			 
		bs += BN1;
		//document.getElementById("BS1").innerHTML = BN1.toFixed(2);
		var BN2=0;
		if(document.getElementById("BN2").value.length<1)
		{	alert("请对操控性的'高速稳定性'评分!");return;}		
		if(isnumber1(document.getElementById("BN2").value))
		 BN2 = b*document.getElementById("BN2").value*b2*0.0001;
		 
		bs += BN2;
		//document.getElementById("BS2").innerHTML = BN2.toFixed(2);
		var BN3=0 ;
		if(document.getElementById("BN3").value.length<1)
		{	alert("请对操控性的'转向响应性'评分!");return;}
		if(isnumber1(document.getElementById("BN3").value))
		BN3 = b*document.getElementById("BN3").value*b3*0.0001;
		
		bs += BN3;
		//document.getElementById("BS3").innerHTML = BN3.toFixed(2);
		var BN4=0 ;
		if(document.getElementById("BN4").value.length<1)
		{	alert("请对操控性的'电子装备'评分!");return;}
		if(isnumber1(document.getElementById("BN4").value))
		 BN4 = b*document.getElementById("BN4").value*b4*0.0001;
		 
		bs += BN4;
		//document.getElementById("BS4").innerHTML = BN4.toFixed(2);
		var BN5=0;
		if(document.getElementById("BN5").value.length<1)
		{	alert("请对操控性的'制动距离'评分!");return;}
		if(isnumber1(document.getElementById("BN5").value))
		 BN5 = b*document.getElementById("BN5").value*b5*0.0001;
		bs += BN5;
		//document.getElementById("BS5").innerHTML = BN5.toFixed(2);
		Total += bs;
		
		var cs = 0;
		var CN1=0;
		if(document.getElementById("CN1").value.length<1)
		{	alert("请对安全性的'车身结构'评分!");return;}
		if(isnumber1(document.getElementById("CN1").value))
		 CN1 = c*document.getElementById("CN1").value*c1*0.0001;
		 
		cs += CN1;
		//document.getElementById("CS1").innerHTML = CN1.toFixed(2);
		var CN2=0;
		if(document.getElementById("CN2").value.length<1)
		{	alert("请对安全性的'气囊等安全系统'评分!");return;}
		if(isnumber1(document.getElementById("CN2").value))
			CN2 = c*document.getElementById("CN2").value*c2*0.0001;
			
		cs += CN2;
		//document.getElementById("CS2").innerHTML = CN2.toFixed(2);
		var CN3 =0;
		if(document.getElementById("CN3").value.length<1)
		{	alert("请对安全性的'欧洲碰撞标准'评分!");return;}
		if(isnumber1(document.getElementById("CN3").value))
		CN3 = c*document.getElementById("CN3").value*c3*0.0001;
		cs += CN3;
		//document.getElementById("CS3").innerHTML = CN3.toFixed(2);
		Total += cs;
		
		var ds = 0;
		var DN1=0;
		if(document.getElementById("DN1").value.length<1)
		{	alert("请对经济性的'油耗指标'评分!");return;}
		if(isnumber1(document.getElementById("DN1").value))
		DN1 = d*document.getElementById("DN1").value*d1*0.0001;
		ds += DN1;
		//document.getElementById("DS1").innerHTML = DN1.toFixed(2);
		var DN2=0;
		if(document.getElementById("DN2").value.length<1)
		{	alert("请对经济性的'车辆自重'评分!");return;}
		if(isnumber(document.getElementById("DN2").value))
		 DN2 = d*document.getElementById("DN2").value*d2*0.0001;
		ds += DN2;
		//document.getElementById("DS2").innerHTML = DN2.toFixed(2);
		var DN3=0;
		if(document.getElementById("DN3").value.length<1)
		{	alert("请对经济性的'动力传动系统技术'评分!");return;}
		if(isnumber1(document.getElementById("DN3").value))
		 DN3 = d*document.getElementById("DN3").value*d3*0.0001;
		ds += DN3;
		//document.getElementById("DS3").innerHTML = DN3.toFixed(2);
		var DN4=0;
		if(document.getElementById("DN4").value.length<1)
		{	alert("请对经济性的'质量担保'评分!");return;}
		if(isnumber1(document.getElementById("DN4").value))
		 DN4 = d*document.getElementById("DN4").value*d4*0.0001;
		ds += DN4;
		//document.getElementById("DS4").innerHTML = DN4.toFixed(2);
		Total += ds;
		
		var es = 0;
		var EN1=0; 
		if(document.getElementById("EN1").value.length<1)
		{	alert("请对舒适性的'车内空间'评分!");return;}
		if(isnumber1(document.getElementById("EN1").value))
		 EN1 = e*document.getElementById("EN1").value*e1*0.0001;
		es = EN1;
		//document.getElementById("ES1").innerHTML = EN1.toFixed(2);
		var EN2=0;
		if(document.getElementById("EN2").value.length<1)
		{	alert("请对舒适性的'车内噪音'评分!");return;}
		if(isnumber1(document.getElementById("EN2").value))
		 EN2 = e*document.getElementById("EN2").value*e2*0.0001;
		es += EN2;
		//document.getElementById("ES2").innerHTML = EN2.toFixed(2);
		var EN3=0;
		if(document.getElementById("EN3").value.length<1)
		{	alert("请对舒适性的'人性化设计'评分!");return;}
		if(isnumber1(document.getElementById("EN3").value))
		 EN3 = e*document.getElementById("EN3").value*e3*0.0001;
		es += EN3;
		//document.getElementById("ES3").innerHTML = EN3.toFixed(2);
		var EN4=0;
		if(document.getElementById("EN4").value.length<1)
		{	alert("请对舒适性的'振动感觉'评分!");return;}
		if(isnumber1(document.getElementById("EN4").value))
		 EN4 = e*document.getElementById("EN4").value*e4*0.0001;
		es += EN4;
		//document.getElementById("ES4").innerHTML = EN4.toFixed(2);
		var EN5=0;
		if(document.getElementById("EN5").value.length<1)
		{	alert("请对舒适性的'内饰工艺'评分!");return;}
		if(isnumber1(document.getElementById("EN5").value))
		 EN5 = e*document.getElementById("EN5").value*e5*0.0001;
		es += EN5;
		//document.getElementById("ES5").innerHTML = EN5.toFixed(2);
		var EN6=0;
		if(document.getElementById("EN6").value.length<1)
		{	alert("请对舒适性的'空调效果'评分!");return;}
		if(isnumber1(document.getElementById("EN6").value))
		 EN6 = e*document.getElementById("EN6").value*e6*0.0001;
		es += EN6;
		//document.getElementById("ES6").innerHTML = EN6.toFixed(2);
		Total += es;
		document.getElementById("Total").value = Total.toFixed(2);	
	}
	
	/* 检测字符串是否全为数字 */
	function isnumber(str)
	{
		var number_chars = "1234567890";
		var i;
		
		for (i=0;i<str.length;i++)
		{
			if (number_chars.indexOf(str.charAt(i))==-1) 
			{
				alert("请输入数字!");return;}
		}
		if(str*1>100 || str*1<0)
		{
			alert("请输入0 - 100之间的数字!");return;
		}
		return true;
	}
	/* 检测字符串是否全为数字 */
	function isnumber1(str)
	{
		var number_chars = "1234567890";
		var i;
		
		for (i=0;i<str.length;i++)
		{
			if (number_chars.indexOf(str.charAt(i))==-1) 
			{
				alert("请输入数字!");return;}
		}
		if(str*1>10 || str*1<=0)
		{
			alert("请输入1 - 10之间的数字!");return;
		}
		return true;
	}
</script>
	
</head>
<body>
	<!-- 主内容 start -->
	<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">车团</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">购车工具</a>&gt;<a class="active" href="javascript:void(0);">价值评估</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 7/>
			</div>
			<div class="tools-box">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table2">
                  <tr>
                    <td class="tw1 tab2-title titBg">性能指标</td>
                    <td class="tw2 tab2-title titBg">参考性</td>
                    <td class="tw3 tab2-title titBg">您认为的<br /> 性能权重<br />A</td>
                    <td class="tw4 tab2-title titBg">项目参考<br />权重</td>
                    <td class="tw5 tab2-title titBg">您认为的项目<br />权重（B）</td>
                    <td class="tw6 tab2-title titBg">评价项目</td>
                    <td class="tw7 tab2-title titBg">
                        <div class="score-box">
                            <ul>
                                <li class="li1">评价得分（C）</li>
                                <li class="li2">
                                    <dd class="good1">9/10</dd>
                                    <dd>7/8</dd>
                                    <dd>5/6</dd>
                                    <dd>3/4</dd>
                                    <dd class="borR0">1/2</dd>
                                </li>
                                <li class="li3">
                                    <dd class="good2">
                                        <span class="czCenter">很好</span>
                                    </dd>
                                    <dd>
                                        <span class="czCenter">好</span>
                                    </dd>
                                    <dd>一般</dd>
                                    <dd>
                                        <span class="czCenter">差</span>
                                    </dd>
                                    <dd class="borR0">极差</dd>
                                </li>
                            </ul>
                        </div>
                    </td>
                    <td class="tw8 tab2-title titBg"><span>综合得分</span></td>
                    <td class="tw9 tab2-title titBg"><span>说明</span></td>
                    <td class="tw10 tab2-title titBg"><span>评价方法</span></td>
                  </tr>
                  <tr>
                    <td rowspan="4" class="tab2-title">动力性</td>
                    <td rowspan="4">25%</td>
                    <td rowspan="4">
                        <p><input class="text2" type="text" value="" name="A" id="A" maxlength="2"/></p>
                        <p>%</p>
                    </td>
                    <td>40%</td>
                    <td><input class="text2 marginR1" type="text" value="" name="A1" id="A1" maxlength="2"/>%</td>
                    <td><span class="padding2">静止起步</span></td>
                    <td><input class="text2" type="text" value="" name="AN1" id="AN1" maxlength="2"/></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">汽车由一档或二档起步，以最大油门加速，感受推背感。</span></td>
                    <td>试车</td>
                  </tr>
                  <tr>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A2" id="A2" maxlength="2"/>%
                    </td>
                    <td><span class="padding2">超车加速时间</span></td>
                    <td><input class="text2" type="text" value="" name="AN2" id="AN2" maxlength="2"/></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">30～40km/h全油门加速行驶至80km/h所需时间。</span></td>
                    <td>试车</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A3" id="A3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">最高车速</span></td>
                    <td><input class="text2" type="text" value="" name="AN3" id="AN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">水平良好路面上，能达到的最高车速。可参考功率指标。</span></td>
                    <td>参考参数表（功率指标）</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A4" id="A4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">动力总成应用技术技术</span></td>
                    <td><input class="text2" type="text" value="" name="AN4" id="AN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">发动机强化技术，材料，变速器类型，档位数量。</span></td>
                    <td>参考参数表</td>
                  </tr>
                  <tr>
                    <td rowspan="5" class="tab2-title">
                        <p>操控性 <br />（主动安全）</p>
                    </td>
                    <td rowspan="5">30%</td>
                    <td rowspan="5">
                        <p><input class="text2" type="text" value="" name="B" id="B" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B1" id="B1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">弯道性能</span></td>
                    <td><input class="text2" type="text" value="" name="BN1" id="BN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">绕18米桩；计算绕桩时间，越短越好。体验极限状态下操控性能。</span></td>
                    <td>试车，配体评价</td>
                  </tr>
                  <tr>
                    <td>35%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B5" id="B5" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">制动距离</span></td>
                    <td><input class="text2" type="text" value="" name="BN5" id="BN5" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">在良好的路面上，汽车以60km/h的时速行驶，从制动到停车的距离。</span></td>
                    <td>试车或参考参数表</td>
                  </tr>
                  <tr>
                    <td>15%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B2" id="B2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">高速稳定性</span></td>
                    <td><input class="text2" type="text" value="" name="BN2" id="BN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">高速直线行驶稳定性（抵抗侧向风及路面不平的干扰能力）；或参考对比轮距、底盘技术装备。</span></td>
                    <td>试车</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B3" id="B3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">转向响应性</span></td>
                    <td><input class="text2" type="text" value="" name="BN3" id="BN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">在一定车速下转向，感受车辆的循迹性。</span></td>
                    <td>试车</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B4" id="B4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">电子装备</span></td>
                    <td><input class="text2" type="text" value="" name="BN4" id="BN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">是否配备DSC(动态稳定控制系统)、TCS、EBA(BA)、EBD、ABS等。</span></td>
                    <td>试车或参考参数表</td>
                  </tr>
                  <tr>
                    <td rowspan="3" class="tab2-title"><p>安全性<br />（被动安全）</p></td>
                    <td rowspan="3">15%</td>
                    <td rowspan="3">
                        <p><input class="text2" type="text" value="" name="C" id="C" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>40%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C1" id="C1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">车身结构</span></td>
                    <td><input class="text2" type="text" value="" name="CN1" id="CN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">吸能车身，高强度车身框架结构；焊接工艺/材料。</span></td>
                    <td>参考产品手册</td>
                  </tr>
                  <tr>
                    <td>40%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C2" id="C2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">气囊等<br />安全系统</span></td>
                    <td><input class="text2" type="text" value="" name="CN2" id="CN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">主/副安全气囊、侧面及帘式气囊、安全带、安全转向柱及踏板等。</span></td>
                    <td>参考参数表</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C3" id="C3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">欧洲碰撞标准（仅供参考）</span></td>
                    <td><input class="text2" type="text" value="" name="CN3" id="CN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">达到欧洲碰撞标准的程度(4/5星）仅供参考。</span></td>
                    <td>媒体评价</td>
                  </tr>
                  <tr>
                    <td rowspan="4" class="tab2-title">经济性</td>
                    <td rowspan="4">15%</td>
                    <td rowspan="4">
                        <p><input class="text2" type="text" value="" name="D" id="D" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D1" id="D1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">油耗指标</span></td>
                    <td><input class="text2" type="text" value="" name="DN1" id="DN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">百公里油耗：一定运行工况下，汽车行驶100公里所消耗的汽油量。也可参考等速油耗指标。</span></td>
                    <td>参见车型参数表或相关媒体信息</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D2" id="D2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">车辆自重</span></td>
                    <td><input class="text2" type="text" value="" name="DN2" id="DN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">比较车辆整备质量，越轻越有利于节油。</span></td>
                    <td>参见车型参数表</td>
                  </tr>
                  <tr>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D3" id="D3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">动力传动系统技术</span></td>
                    <td><input class="text2" type="text" value="" name="DN3" id="DN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">是否采用SVT(VVT，i-VTEC)等发动机强化技术；变速器类型及档位数。</span></td>
                    <td>参见车型参数表</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D4" id="D4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">质量担保</span></td>
                    <td><input class="text2" type="text" value="" name="DN4" id="DN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">质量担保期</span></td>
                    <td>询问4S店</td>
                  </tr>
                  <tr>
                    <td rowspan="6" class="tab2-title">舒适性</td>
                    <td rowspan="6">15%</td>
                    <td rowspan="6">
                        <p><input class="text2" type="text" value="" name="E" id="E" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E1" id="E1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">车内空间</span></td>
                    <td><input class="text2" type="text" value="" name="EN1" id="EN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">前后排头部、腿部及肩部两侧是否有足够的空间；行李箱容积大小。</span></td>
                    <td>目视</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E2" id="E2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">车内噪音</span></td>
                    <td><input class="text2" type="text" value="" name="EN2" id="EN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">一定车速行车时车内声音的分贝值或直观感受静谧性。</span></td>
                    <td>试乘</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E3" id="E3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">人性化设计</span></td>
                    <td><input class="text2" type="text" value="" name="EN3" id="EN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">各种开关操作是否方便；是否有合理的储物空间，如水杯架等。</span></td>
                    <td>目视、试乘</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E4" id="E4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">振动感觉</span></td>
                    <td><input class="text2" type="text" value="" name="EN4" id="EN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">乘员感觉车内振动情况</span></td>
                    <td>试乘</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E5" id="E5" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">内饰工艺</span></td>
                    <td><input class="text2" type="text" value="" name="EN5" id="EN5" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">工艺是否精湛,高档</span></td>
                    <td>目视</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E6" id="E6" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">空调效果</span></td>
                    <td><input class="text2" type="text" value="" name="EN6" id="EN6" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">空调系统是否能在短时间内达到乘员所设定的温度。</span></td>
                    <td>试用</td>
                  </tr>
                  <tr>
                    <td class="tab2-title">总分</td>
                    <td colspan="5"><input class="text2" type="text" value="" name="Total" id="Total" disabled/></td>
                    	<td colspan="4">
	                    	<div class="btnOuter">
	                    		<input class="scoreCountBtn" type="button" onclick="onChange();"/>
	                    	</div>
                    	</td>
                    </tr>
                </table>
			</div>
		</div>
	</div>
</body>
</@cc.html>