<#import "../common_chetuan.ftl" as cc>
<@cc.html 8 "��������ֵ��������������_2014����������ֵ����-������"  "���������������ṩ2014����������ֵ��������������������������������O2O�����һƷ�ơ�" "������ֵ����,��������">
<head>
	<link rel="stylesheet" href="${www_ct_url}css/tools.css">
<link rel="stylesheet" href="${www_ct_url}css/style.css">
	<script type="text/javascript">
		var a=25;
		var b=30;
		var c=15;
		var d=15;
		var e=15;
		//������
		var a1=40;
		var a2=30;
		var a3=10;
		var a4=20;
		//�ٿ���
		var b1=30;
		var b2=15;
		var b3=10;
		var b4=10;
		var b5=35;
		//��ȫ��
		var c1=40;
		var c2=40;
		var c3=20;
		//������
		var d1=30;
		var d2=20;
		var d3=30;
		var d4=20;
		//������
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
				alert("����Ϊ������Ȩ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������е�����Ȩ�أ�");
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
				alert("����Ϊ�Ķ������е���ĿȨ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������еĶ������е���ĿȨ�رȣ�");
			return;		
		}
		
		//////////////////////�ٿ���
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
				alert("����Ϊ�Ĳٿ����е���ĿȨ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������еĲٿ����е���ĿȨ�رȣ�");
			return;	
		}
		//////////////////////��ȫ��
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
				alert("����Ϊ�İ�ȫ���е���ĿȨ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������еİ�ȫ���е���ĿȨ�رȣ�");
			return;	
		}
		//////////////////////������
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
				alert("����Ϊ�ľ������е���ĿȨ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������еľ������е���ĿȨ�رȣ�");
			return;		
		}
		
		
		//////////////////////������
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
				alert("����Ϊ���������е���ĿȨ�ر��ۼƲ�����100%,����������!");
				return;
			}
		}else{
			alert("���������е��������е���ĿȨ�رȣ�");
			return;		
		}
		
		
		var Total=0;
		var as = 0;
		var AN1=0;
		if(document.getElementById("AN1").value.length<1)
		{	alert("��Զ����Ե�'��ֹ��'����!");return;}
		if(isnumber1(document.getElementById("AN1").value))
		AN1 = a*document.getElementById("AN1").value*a1*0.0001;
		as += AN1;
		var AN2=0;
		//document.getElementById("AS1").innerHTML = AN1.toFixed(2);
		if(document.getElementById("AN2").value.length<1)
		{	alert("��Զ����Ե�'��������ʱ��'����!");return;}
		if(isnumber1(document.getElementById("AN2").value))
			 AN2= a*document.getElementById("AN2").value*a2*0.0001;
			 
		as += AN2;
		//document.getElementById("AS2").innerHTML = AN2.toFixed(2);
		var AN3=0;
		if(document.getElementById("AN3").value.length<1)
		{	alert("��Զ����Ե�'��߳���'����!");return;}
		if(isnumber1(document.getElementById("AN3").value))
			 AN3 = a*document.getElementById("AN3").value*a3*0.0001;
			 
		as += AN3;
		//document.getElementById("AS3").innerHTML = AN3.toFixed(2);
		var AN4=0;
		if(document.getElementById("AN4").value.length<1)
		{	alert("��Զ����Ե�'�����ܳ�Ӧ�ü���'����!");return;}
		if(isnumber1(document.getElementById("AN4").value))
		 AN4 = a*document.getElementById("AN4").value*a4*0.0001;
		as += AN4;
		//document.getElementById("AS4").innerHTML = AN4.toFixed(2);
		Total += as;
		
		var bs = 0;
		var BN1=0;
		if(document.getElementById("BN1").value.length<1)
		{	alert("��Բٿ��Ե�'�������'����!");return;}
		if(isnumber1(document.getElementById("BN1").value))
			 BN1 = b*document.getElementById("BN1").value*b1*0.0001;
			 
		bs += BN1;
		//document.getElementById("BS1").innerHTML = BN1.toFixed(2);
		var BN2=0;
		if(document.getElementById("BN2").value.length<1)
		{	alert("��Բٿ��Ե�'�����ȶ���'����!");return;}		
		if(isnumber1(document.getElementById("BN2").value))
		 BN2 = b*document.getElementById("BN2").value*b2*0.0001;
		 
		bs += BN2;
		//document.getElementById("BS2").innerHTML = BN2.toFixed(2);
		var BN3=0 ;
		if(document.getElementById("BN3").value.length<1)
		{	alert("��Բٿ��Ե�'ת����Ӧ��'����!");return;}
		if(isnumber1(document.getElementById("BN3").value))
		BN3 = b*document.getElementById("BN3").value*b3*0.0001;
		
		bs += BN3;
		//document.getElementById("BS3").innerHTML = BN3.toFixed(2);
		var BN4=0 ;
		if(document.getElementById("BN4").value.length<1)
		{	alert("��Բٿ��Ե�'����װ��'����!");return;}
		if(isnumber1(document.getElementById("BN4").value))
		 BN4 = b*document.getElementById("BN4").value*b4*0.0001;
		 
		bs += BN4;
		//document.getElementById("BS4").innerHTML = BN4.toFixed(2);
		var BN5=0;
		if(document.getElementById("BN5").value.length<1)
		{	alert("��Բٿ��Ե�'�ƶ�����'����!");return;}
		if(isnumber1(document.getElementById("BN5").value))
		 BN5 = b*document.getElementById("BN5").value*b5*0.0001;
		bs += BN5;
		//document.getElementById("BS5").innerHTML = BN5.toFixed(2);
		Total += bs;
		
		var cs = 0;
		var CN1=0;
		if(document.getElementById("CN1").value.length<1)
		{	alert("��԰�ȫ�Ե�'����ṹ'����!");return;}
		if(isnumber1(document.getElementById("CN1").value))
		 CN1 = c*document.getElementById("CN1").value*c1*0.0001;
		 
		cs += CN1;
		//document.getElementById("CS1").innerHTML = CN1.toFixed(2);
		var CN2=0;
		if(document.getElementById("CN2").value.length<1)
		{	alert("��԰�ȫ�Ե�'���ҵȰ�ȫϵͳ'����!");return;}
		if(isnumber1(document.getElementById("CN2").value))
			CN2 = c*document.getElementById("CN2").value*c2*0.0001;
			
		cs += CN2;
		//document.getElementById("CS2").innerHTML = CN2.toFixed(2);
		var CN3 =0;
		if(document.getElementById("CN3").value.length<1)
		{	alert("��԰�ȫ�Ե�'ŷ����ײ��׼'����!");return;}
		if(isnumber1(document.getElementById("CN3").value))
		CN3 = c*document.getElementById("CN3").value*c3*0.0001;
		cs += CN3;
		//document.getElementById("CS3").innerHTML = CN3.toFixed(2);
		Total += cs;
		
		var ds = 0;
		var DN1=0;
		if(document.getElementById("DN1").value.length<1)
		{	alert("��Ծ����Ե�'�ͺ�ָ��'����!");return;}
		if(isnumber1(document.getElementById("DN1").value))
		DN1 = d*document.getElementById("DN1").value*d1*0.0001;
		ds += DN1;
		//document.getElementById("DS1").innerHTML = DN1.toFixed(2);
		var DN2=0;
		if(document.getElementById("DN2").value.length<1)
		{	alert("��Ծ����Ե�'��������'����!");return;}
		if(isnumber(document.getElementById("DN2").value))
		 DN2 = d*document.getElementById("DN2").value*d2*0.0001;
		ds += DN2;
		//document.getElementById("DS2").innerHTML = DN2.toFixed(2);
		var DN3=0;
		if(document.getElementById("DN3").value.length<1)
		{	alert("��Ծ����Ե�'��������ϵͳ����'����!");return;}
		if(isnumber1(document.getElementById("DN3").value))
		 DN3 = d*document.getElementById("DN3").value*d3*0.0001;
		ds += DN3;
		//document.getElementById("DS3").innerHTML = DN3.toFixed(2);
		var DN4=0;
		if(document.getElementById("DN4").value.length<1)
		{	alert("��Ծ����Ե�'��������'����!");return;}
		if(isnumber1(document.getElementById("DN4").value))
		 DN4 = d*document.getElementById("DN4").value*d4*0.0001;
		ds += DN4;
		//document.getElementById("DS4").innerHTML = DN4.toFixed(2);
		Total += ds;
		
		var es = 0;
		var EN1=0; 
		if(document.getElementById("EN1").value.length<1)
		{	alert("��������Ե�'���ڿռ�'����!");return;}
		if(isnumber1(document.getElementById("EN1").value))
		 EN1 = e*document.getElementById("EN1").value*e1*0.0001;
		es = EN1;
		//document.getElementById("ES1").innerHTML = EN1.toFixed(2);
		var EN2=0;
		if(document.getElementById("EN2").value.length<1)
		{	alert("��������Ե�'��������'����!");return;}
		if(isnumber1(document.getElementById("EN2").value))
		 EN2 = e*document.getElementById("EN2").value*e2*0.0001;
		es += EN2;
		//document.getElementById("ES2").innerHTML = EN2.toFixed(2);
		var EN3=0;
		if(document.getElementById("EN3").value.length<1)
		{	alert("��������Ե�'���Ի����'����!");return;}
		if(isnumber1(document.getElementById("EN3").value))
		 EN3 = e*document.getElementById("EN3").value*e3*0.0001;
		es += EN3;
		//document.getElementById("ES3").innerHTML = EN3.toFixed(2);
		var EN4=0;
		if(document.getElementById("EN4").value.length<1)
		{	alert("��������Ե�'�񶯸о�'����!");return;}
		if(isnumber1(document.getElementById("EN4").value))
		 EN4 = e*document.getElementById("EN4").value*e4*0.0001;
		es += EN4;
		//document.getElementById("ES4").innerHTML = EN4.toFixed(2);
		var EN5=0;
		if(document.getElementById("EN5").value.length<1)
		{	alert("��������Ե�'���ι���'����!");return;}
		if(isnumber1(document.getElementById("EN5").value))
		 EN5 = e*document.getElementById("EN5").value*e5*0.0001;
		es += EN5;
		//document.getElementById("ES5").innerHTML = EN5.toFixed(2);
		var EN6=0;
		if(document.getElementById("EN6").value.length<1)
		{	alert("��������Ե�'�յ�Ч��'����!");return;}
		if(isnumber1(document.getElementById("EN6").value))
		 EN6 = e*document.getElementById("EN6").value*e6*0.0001;
		es += EN6;
		//document.getElementById("ES6").innerHTML = EN6.toFixed(2);
		Total += es;
		document.getElementById("Total").value = Total.toFixed(2);	
	}
	
	/* ����ַ����Ƿ�ȫΪ���� */
	function isnumber(str)
	{
		var number_chars = "1234567890";
		var i;
		
		for (i=0;i<str.length;i++)
		{
			if (number_chars.indexOf(str.charAt(i))==-1) 
			{
				alert("����������!");return;}
		}
		if(str*1>100 || str*1<0)
		{
			alert("������0 - 100֮�������!");return;
		}
		return true;
	}
	/* ����ַ����Ƿ�ȫΪ���� */
	function isnumber1(str)
	{
		var number_chars = "1234567890";
		var i;
		
		for (i=0;i<str.length;i++)
		{
			if (number_chars.indexOf(str.charAt(i))==-1) 
			{
				alert("����������!");return;}
		}
		if(str*1>10 || str*1<=0)
		{
			alert("������1 - 10֮�������!");return;
		}
		return true;
	}
</script>
	
</head>
<body>
	<!-- ������ start -->
	<div class="content car-tools">
		<ul class="position">
			<a href="${www_ct_url}">����</a>&gt;<a href="${www_ct_url}gongju/gouchejisuanqi.html">��������</a>&gt;<a class="active" href="javascript:void(0);">��ֵ����</a>
		</ul>		
		<div class="mod-con">
			<div class="nav tools-nav">
				<@cc.buyCartools 7/>
			</div>
			<div class="tools-box">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table2">
                  <tr>
                    <td class="tw1 tab2-title titBg">����ָ��</td>
                    <td class="tw2 tab2-title titBg">�ο���</td>
                    <td class="tw3 tab2-title titBg">����Ϊ��<br /> ����Ȩ��<br />A</td>
                    <td class="tw4 tab2-title titBg">��Ŀ�ο�<br />Ȩ��</td>
                    <td class="tw5 tab2-title titBg">����Ϊ����Ŀ<br />Ȩ�أ�B��</td>
                    <td class="tw6 tab2-title titBg">������Ŀ</td>
                    <td class="tw7 tab2-title titBg">
                        <div class="score-box">
                            <ul>
                                <li class="li1">���۵÷֣�C��</li>
                                <li class="li2">
                                    <dd class="good1">9/10</dd>
                                    <dd>7/8</dd>
                                    <dd>5/6</dd>
                                    <dd>3/4</dd>
                                    <dd class="borR0">1/2</dd>
                                </li>
                                <li class="li3">
                                    <dd class="good2">
                                        <span class="czCenter">�ܺ�</span>
                                    </dd>
                                    <dd>
                                        <span class="czCenter">��</span>
                                    </dd>
                                    <dd>һ��</dd>
                                    <dd>
                                        <span class="czCenter">��</span>
                                    </dd>
                                    <dd class="borR0">����</dd>
                                </li>
                            </ul>
                        </div>
                    </td>
                    <td class="tw8 tab2-title titBg"><span>�ۺϵ÷�</span></td>
                    <td class="tw9 tab2-title titBg"><span>˵��</span></td>
                    <td class="tw10 tab2-title titBg"><span>���۷���</span></td>
                  </tr>
                  <tr>
                    <td rowspan="4" class="tab2-title">������</td>
                    <td rowspan="4">25%</td>
                    <td rowspan="4">
                        <p><input class="text2" type="text" value="" name="A" id="A" maxlength="2"/></p>
                        <p>%</p>
                    </td>
                    <td>40%</td>
                    <td><input class="text2 marginR1" type="text" value="" name="A1" id="A1" maxlength="2"/>%</td>
                    <td><span class="padding2">��ֹ��</span></td>
                    <td><input class="text2" type="text" value="" name="AN1" id="AN1" maxlength="2"/></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">������һ��������𲽣���������ż��٣������Ʊ��С�</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A2" id="A2" maxlength="2"/>%
                    </td>
                    <td><span class="padding2">��������ʱ��</span></td>
                    <td><input class="text2" type="text" value="" name="AN2" id="AN2" maxlength="2"/></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">30��40km/hȫ���ż�����ʻ��80km/h����ʱ�䡣</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A3" id="A3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">��߳���</span></td>
                    <td><input class="text2" type="text" value="" name="AN3" id="AN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">ˮƽ����·���ϣ��ܴﵽ����߳��١��ɲο�����ָ�ꡣ</span></td>
                    <td>�ο�����������ָ�꣩</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="A4" id="A4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�����ܳ�Ӧ�ü�������</span></td>
                    <td><input class="text2" type="text" value="" name="AN4" id="AN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">������ǿ�����������ϣ����������ͣ���λ������</span></td>
                    <td>�ο�������</td>
                  </tr>
                  <tr>
                    <td rowspan="5" class="tab2-title">
                        <p>�ٿ��� <br />��������ȫ��</p>
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
                    <td><span class="padding2">�������</span></td>
                    <td><input class="text2" type="text" value="" name="BN1" id="BN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">��18��׮��������׮ʱ�䣬Խ��Խ�á����鼫��״̬�²ٿ����ܡ�</span></td>
                    <td>�Գ�����������</td>
                  </tr>
                  <tr>
                    <td>35%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B5" id="B5" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�ƶ�����</span></td>
                    <td><input class="text2" type="text" value="" name="BN5" id="BN5" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�����õ�·���ϣ�������60km/h��ʱ����ʻ�����ƶ���ͣ���ľ��롣</span></td>
                    <td>�Գ���ο�������</td>
                  </tr>
                  <tr>
                    <td>15%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B2" id="B2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�����ȶ���</span></td>
                    <td><input class="text2" type="text" value="" name="BN2" id="BN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">����ֱ����ʻ�ȶ��ԣ��ֿ�����缰·�治ƽ�ĸ�������������ο��Ա��־ࡢ���̼���װ����</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B3" id="B3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">ת����Ӧ��</span></td>
                    <td><input class="text2" type="text" value="" name="BN3" id="BN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">��һ��������ת�򣬸��ܳ�����ѭ���ԡ�</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="B4" id="B4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">����װ��</span></td>
                    <td><input class="text2" type="text" value="" name="BN4" id="BN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�Ƿ��䱸DSC(��̬�ȶ�����ϵͳ)��TCS��EBA(BA)��EBD��ABS�ȡ�</span></td>
                    <td>�Գ���ο�������</td>
                  </tr>
                  <tr>
                    <td rowspan="3" class="tab2-title"><p>��ȫ��<br />��������ȫ��</p></td>
                    <td rowspan="3">15%</td>
                    <td rowspan="3">
                        <p><input class="text2" type="text" value="" name="C" id="C" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>40%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C1" id="C1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">����ṹ</span></td>
                    <td><input class="text2" type="text" value="" name="CN1" id="CN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">���ܳ�����ǿ�ȳ����ܽṹ�����ӹ���/���ϡ�</span></td>
                    <td>�ο���Ʒ�ֲ�</td>
                  </tr>
                  <tr>
                    <td>40%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C2" id="C2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">���ҵ�<br />��ȫϵͳ</span></td>
                    <td><input class="text2" type="text" value="" name="CN2" id="CN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">��/����ȫ���ҡ����漰��ʽ���ҡ���ȫ������ȫת������̤��ȡ�</span></td>
                    <td>�ο�������</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="C3" id="C3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">ŷ����ײ��׼�������ο���</span></td>
                    <td><input class="text2" type="text" value="" name="CN3" id="CN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�ﵽŷ����ײ��׼�ĳ̶�(4/5�ǣ������ο���</span></td>
                    <td>ý������</td>
                  </tr>
                  <tr>
                    <td rowspan="4" class="tab2-title">������</td>
                    <td rowspan="4">15%</td>
                    <td rowspan="4">
                        <p><input class="text2" type="text" value="" name="D" id="D" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D1" id="D1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�ͺ�ָ��</span></td>
                    <td><input class="text2" type="text" value="" name="DN1" id="DN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�ٹ����ͺģ�һ�����й����£�������ʻ100���������ĵ���������Ҳ�ɲο������ͺ�ָ�ꡣ</span></td>
                    <td>�μ����Ͳ���������ý����Ϣ</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D2" id="D2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">��������</span></td>
                    <td><input class="text2" type="text" value="" name="DN2" id="DN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�Ƚϳ�������������Խ��Խ�����ڽ��͡�</span></td>
                    <td>�μ����Ͳ�����</td>
                  </tr>
                  <tr>
                    <td>30%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D3" id="D3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">��������ϵͳ����</span></td>
                    <td><input class="text2" type="text" value="" name="DN3" id="DN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�Ƿ����SVT(VVT��i-VTEC)�ȷ�����ǿ�����������������ͼ���λ����</span></td>
                    <td>�μ����Ͳ�����</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="D4" id="D4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">��������</span></td>
                    <td><input class="text2" type="text" value="" name="DN4" id="DN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">����������</span></td>
                    <td>ѯ��4S��</td>
                  </tr>
                  <tr>
                    <td rowspan="6" class="tab2-title">������</td>
                    <td rowspan="6">15%</td>
                    <td rowspan="6">
                        <p><input class="text2" type="text" value="" name="E" id="E" maxlength="2"  /></p>
                        <p>%</p>
                    </td>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E1" id="E1" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">���ڿռ�</span></td>
                    <td><input class="text2" type="text" value="" name="EN1" id="EN1" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">ǰ����ͷ�����Ȳ����粿�����Ƿ����㹻�Ŀռ䣻�������ݻ���С��</span></td>
                    <td>Ŀ��</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E2" id="E2" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">��������</span></td>
                    <td><input class="text2" type="text" value="" name="EN2" id="EN2" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">һ�������г�ʱ���������ķֱ�ֵ��ֱ�۸��ܾ����ԡ�</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E3" id="E3" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">���Ի����</span></td>
                    <td><input class="text2" type="text" value="" name="EN3" id="EN3" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">���ֿ��ز����Ƿ񷽱㣻�Ƿ��к���Ĵ���ռ䣬��ˮ���ܵȡ�</span></td>
                    <td>Ŀ�ӡ��Գ�</td>
                  </tr>
                  <tr>
                    <td>10%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E4" id="E4" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�񶯸о�</span></td>
                    <td><input class="text2" type="text" value="" name="EN4" id="EN4" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">��Ա�о����������</span></td>
                    <td>�Գ�</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E5" id="E5" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">���ι���</span></td>
                    <td><input class="text2" type="text" value="" name="EN5" id="EN5" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�����Ƿ�տ,�ߵ�</span></td>
                    <td>Ŀ��</td>
                  </tr>
                  <tr>
                    <td>20%</td>
                    <td>
                        <input class="text2 marginR1" type="text" value="" name="E6" id="E6" maxlength="2"  />%
                    </td>
                    <td><span class="padding2">�յ�Ч��</span></td>
                    <td><input class="text2" type="text" value="" name="EN6" id="EN6" maxlength="2"  /></td>
                    <td>&nbsp;</td>
                    <td><span class="padding1">�յ�ϵͳ�Ƿ����ڶ�ʱ���ڴﵽ��Ա���趨���¶ȡ�</span></td>
                    <td>����</td>
                  </tr>
                  <tr>
                    <td class="tab2-title">�ܷ�</td>
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