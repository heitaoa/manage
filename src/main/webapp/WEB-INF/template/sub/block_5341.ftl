var str='';
str+='		<div class="lh-sns">	';
str+='			<h2 class="title"><i></i>�ֻ�����<span class="ora-line"></span><span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-4.aspx">���� &rsaquo;&rsaquo;</a></span></h2>	';
str+='			<div class="con">	';
str+='				<dl>	';
<#list param[0] as sub_data>
<#if (sub_data_index==0)>
str+='					<dt>	';
str+='						<div class="pic"><a href="${sub_data.link}" target="_blank"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt=""></a></div>	';
str+='						<div class="article">	<a href="${sub_data.link}" target="_blank">';
str+='							<h5>${sub_data.title}</h5>	';
str+='							<p>${(sub_data.content)!}<a class="more" target="_blank" href="${sub_data.link}">[��ϸ]</a></p>	';
str+='						</a></div>	';
str+='					</dt>	';
<#else>
	<#if (sub_data_index<5)>
	str+='					<dd class="car-pic-txt">	';
	str+='						<a href="${sub_data.link}" target="_blank">	';
	str+='							<img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="">	';
	str+='							<span></span>	';
	str+='							<p>${sub_data.title}</p>	';
	str+='						</a>	';
	str+='					</dd>	';
	</#if>
</#if>
</#list>
str+='				</dl>	';
str+='			</div>	';
str+='		</div>	';
str+='		<div class="lh-login">	';
str+='			<h2 class="title"><i></i>��Ա��¼<span class="ora-line"></span></h2>	';
str+='			<div class="con">	';
str+='				<div class="login">	';
str+='					<form action="http://bbs.chetuan.com/api/postlogin.aspx" id="bbs_login" method="post">	';
str+='						<div><input type="text" class="input" name="loginStr" value="����/�ֻ�/�û���"></div>	';
str+='						<div><input type="password" class="input" name="pwdStr"></div>	';
str+='						<div><input type="buttom" class="input-submit" style="text-align:center;" value="��¼"></div>	';
str+='					</form>	';
str+='					<div class="reg"><a href="http://bbs.chetuan.com/register.aspx" target="_blank">ע�����û�</a>|<a href="http://bbs.chetuan.com/getpassword.aspx" target="_blank">�������룿</a></div>	';
str+='				</div>	';
str+='				<div class="bbs">	';
str+='					<a class="lhsq" title="�ֻ�����" href="http://bbs.chetuan.com/showforum-4.aspx" target="_blank">�ֻ�����</a>	';
str+='					<a class="tczy" title="�ᳵ��ҵ" href="http://bbs.chetuan.com/showforum-5.aspx" target="_blank">�ᳵ��ҵ</a>	';
str+='					<a class="zjy" title="�Լ���" href="http://bbs.chetuan.com/showforum-6.aspx" target="_blank">�Լ���</a>	';
str+='					<a class="wqts" title="άȨͶ��" href="http://bbs.chetuan.com/showforum-7.aspx" target="_blank">άȨͶ��</a>	';
str+='				</div>	';
str+='			</div>	';
str+='		</div>	';

document.write(str);


$(function(){
	var ck=document.cookie;
	var cks=ck.split(";");
	for(var i=0;i<cks.length;i++){
		if(cks[i].indexOf("dnt")!=-1){
			var pms =cks[i].split("&");
			for(var j=0;j<pms.length;j++){
				if(pms[j].indexOf("username")!=-1){
					var un=pms[j].split("=")[1];
					$(".login").html("<p class='weclome-user'>�װ���<font color='red'>"+unescape(un)+"</font>��</p><p>��ӭ����½���ţ�</p>");
				}
			}			
		}
	}	
		
	$("#bbs_login input[name='loginStr']").click(function(){
		var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
		if(loginStr=="����/�ֻ�/�û���"){
			$(this).val("");
		}
	});
	
	$("#bbs_login input[name='loginStr']").on("blur",function(){
		var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
		if(loginStr==""){
			$(this).val("����/�ֻ�/�û���");
		}
	});
	
	$("#bbs_login .input-submit").click(function(){
		login();
	});	
});

function login(){
	var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
	var pwdStr=$("#bbs_login input[name='pwdStr']").val().trim();
	
	if(loginStr==""||loginStr=="����/�ֻ�/�û���"){
		alert("������[����/�ֻ�/�û���]��Ϊ��½��");
		return;
	}
	
	if(pwdStr==""){
		alert("����������");
		return;
	}
	
	$.ajax({
		type : "get",
		async:false,
		url : "http://bbs.chetuan.com/api/postlogin.aspx",
		data: {"loginStr":loginStr,"pwdStr":pwdStr,"postType":2},
		dataType : "jsonp",
		jsonp: "callbackLogin",
		jsonpCallback:"success_callbackLogin",
		success : function(json){
		
		},
		error:function(data){
		
		}
	});
}

function success_callbackLogin(data){
	if(data.substring(0,1)=="|"){
		alert(data.substring(1));
		return ;
	}
	$(".login").html("<p class='weclome-user'>�װ���<font color='red'>"+data+"</font>��</p><p>��ӭ����½���ţ�</p>");
}

