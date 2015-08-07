var str='';
str+='		<div class="lh-sns">	';
str+='			<h2 class="title"><i></i>乐活社区<span class="ora-line"></span><span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-4.aspx">更多 &rsaquo;&rsaquo;</a></span></h2>	';
str+='			<div class="con">	';
str+='				<dl>	';
<#list param[0] as sub_data>
<#if (sub_data_index==0)>
str+='					<dt>	';
str+='						<div class="pic"><a href="${sub_data.link}" target="_blank"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt=""></a></div>	';
str+='						<div class="article">	<a href="${sub_data.link}" target="_blank">';
str+='							<h5>${sub_data.title}</h5>	';
str+='							<p>${(sub_data.content)!}<a class="more" target="_blank" href="${sub_data.link}">[详细]</a></p>	';
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
str+='			<h2 class="title"><i></i>会员登录<span class="ora-line"></span></h2>	';
str+='			<div class="con">	';
str+='				<div class="login">	';
str+='					<form action="http://bbs.chetuan.com/api/postlogin.aspx" id="bbs_login" method="post">	';
str+='						<div><input type="text" class="input" name="loginStr" value="邮箱/手机/用户名"></div>	';
str+='						<div><input type="password" class="input" name="pwdStr"></div>	';
str+='						<div><input type="buttom" class="input-submit" style="text-align:center;" value="登录"></div>	';
str+='					</form>	';
str+='					<div class="reg"><a href="http://bbs.chetuan.com/register.aspx" target="_blank">注册新用户</a>|<a href="http://bbs.chetuan.com/getpassword.aspx" target="_blank">忘记密码？</a></div>	';
str+='				</div>	';
str+='				<div class="bbs">	';
str+='					<a class="lhsq" title="乐活社区" href="http://bbs.chetuan.com/showforum-4.aspx" target="_blank">乐活社区</a>	';
str+='					<a class="tczy" title="提车作业" href="http://bbs.chetuan.com/showforum-5.aspx" target="_blank">提车作业</a>	';
str+='					<a class="zjy" title="自驾游" href="http://bbs.chetuan.com/showforum-6.aspx" target="_blank">自驾游</a>	';
str+='					<a class="wqts" title="维权投诉" href="http://bbs.chetuan.com/showforum-7.aspx" target="_blank">维权投诉</a>	';
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
					$(".login").html("<p class='weclome-user'>亲爱的<font color='red'>"+unescape(un)+"</font>，</p><p>欢迎您登陆车团！</p>");
				}
			}			
		}
	}	
		
	$("#bbs_login input[name='loginStr']").click(function(){
		var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
		if(loginStr=="邮箱/手机/用户名"){
			$(this).val("");
		}
	});
	
	$("#bbs_login input[name='loginStr']").on("blur",function(){
		var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
		if(loginStr==""){
			$(this).val("邮箱/手机/用户名");
		}
	});
	
	$("#bbs_login .input-submit").click(function(){
		login();
	});	
});

function login(){
	var loginStr=$("#bbs_login input[name='loginStr']").val().trim();
	var pwdStr=$("#bbs_login input[name='pwdStr']").val().trim();
	
	if(loginStr==""||loginStr=="邮箱/手机/用户名"){
		alert("请输入[邮箱/手机/用户名]作为登陆名");
		return;
	}
	
	if(pwdStr==""){
		alert("请输入密码");
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
	$(".login").html("<p class='weclome-user'>亲爱的<font color='red'>"+data+"</font>，</p><p>欢迎您登陆车团！</p>");
}

