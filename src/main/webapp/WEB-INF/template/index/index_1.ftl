<#import "../common_chetuan.ftl" as cc>
<@cc.html 1, "车团网_汽车团购_汽车电商服务第一品牌","车团网为您提供免费专业的汽车团购服务、最便宜的汽车团购价格、最靠谱的汽车团购优惠。车团网,中国汽车电商服务第一品牌。","车团网,汽车团购,汽车团购网,汽车电商">
<div class="clearfix">
			<div class="popular-nav">
				<h5>按品牌团购报名</h5>
				<div class="box brand-box brd-b">
					<#list dataMap['pptg'] as sub_data>
						<#if sub_data_index == (dataMap['pptg'])?size -1>
							<a href="${sub_data.link}" class="more">${sub_data.title}&rsaquo;&rsaquo;</a>
						<#else>
							<a href="${sub_data.link}">${sub_data.title}</a>
						</#if>
					</#list>
				</div>
				<h5>按价格团购报名</h5>
				<div class="box price-box sel-price brd-b">
					<#list dataMap['jgtg'] as sub_data>
						<a href="${sub_data.link}">${sub_data.title}</a>
					</#list>
				</div>
				<h5>按车型团购报名</h5>
				<div class="box type-box">
					<#list dataMap['cxtg'] as sub_data>
						<#if (sub_data_index == (dataMap['cxtg'])?size -1)>
							<a href="${sub_data.link}" class="more">${sub_data.title}&rsaquo;&rsaquo;</a>
						<#else>
							<a href="${sub_data.link}">${sub_data.title}</a>
						</#if>
					</#list>
				</div>
			</div>
			<div class="home-focus">
							<ul class="home-focus-slider">	
				<#list dataMap['jdt'] as sub_data>
				<#if sub_data_index lt 4>
								<li><a target="_blank" href="${sub_data.link}"><img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></li>	
				</#if>
				</#list>
							</ul>	
			</div>
		</div>
		<div class="process-pic"><img src="${www_ct_url}images/process_pic.gif" alt=""></div>
		<div class="banner-ad-01"><a target="_blank" href="http://www.315che.com"><img src="${www_ct_url}images/chetuan_banner_01.jpg" alt="" ></a></div>
		<div class="celarfix">
			<div class="on-sale">
				<h2 class="title arr-title"><i></i>特卖惠<b class="ora-line"></b><span class="more"><a href="${www_ct_url}chetuan/salefavoredsearch">更多报价 &rsaquo;&rsaquo;</a></span></h2>
				<div class="left-sale">
					
				<ul>
				<#list dataMap['tmh'] as sub_data>
				<#if (sub_data_index lt 6)>
				<li class="item">                                                                           
					<div class="pic-wrapper">                                                                 
						<a href="${kan_ct_url}chetuan/${sub_data.color}/" target="_blank">                                                                             
							<div class="pic-inner">                                                              
								<img src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt="${sub_data.title}">                    
								<span class="glass"></span>                                                                 
									<div class="logo"><img width="35px" src="${sub_data.clink}" alt=""></div>          
									<p class="title">【${sub_data.link_back}】</p>                                    
							</div>                                                                               
						</a>                                                                                    
					</div>                                                                                    
					<div class="info">                                                                        
						<h3><a href="${kan_ct_url}chetuan/${sub_data.color}/" target="_blank">${sub_data.title}</a></h3>
				${sub_data.content}
						<div class="sign">                                                                      
							仅剩<b>${sub_data.ctitle}</b>台<a class="go" href="${sub_data.link}">去抢购</a>                                    
						</div>                                                                                  
					</div>                                                                                    
				</li>             																			
				</#if>
				</#list>
				</ul>

				</div>
			</div>
			<div class="side">
				<div class="qr-code">
					<h3>扫描二维码，赢取3000元购车礼金</h3>
					<div class="con">
						<div class="qr"><img src="${www_ct_url}images/qr_code_img.gif" alt=""></div>
						<p>关注小胖看车团，掌握最新团购动态</p>
					</div>
				</div>
				<div class="gp-promise">
					<h2 class="title"><i></i>团购承诺<span class="ora-line"></span></h2>
					<div class="con">
						<ul class="clearfix">
							<li><i class="mf"></i>免费接送</li>
							<li><i class="dj"></i>低价保证</li>
							<li><i class="yl"></i>到店有礼</li>
							<li><i class="yj"></i>订车有奖</li>
							<li class="last"><i class="sh"></i>售后保证</li>
							<li class="last"><i class="wq"></i>消费维权</li>
						</ul>
					</div>
				</div>
				<div class="buycar-tools">
										
<h2 class="title"><i></i>购车工具<span class="ora-line"></span></h2>
        <div class="con">    
            <ul class="clearfix">    
            	<li><a href="${www_ct_url}gongju/gouchejisuanqi.html"><i class="gc"></i>购车计算</a></li>
            	<li><a href="${www_ct_url}gongju/chedaijisuanqi.html"><i class="hd"></i>贷款购车</a></li>
            	<li><a href="${www_ct_url}gongju/chexianjisuanqi.html"><i class="bx"></i>保险计算</a></li>
            	<li><a href="${www_ct_url}gongju/canshuduibi.html"><i class="cs"></i>参数对比</a></li>
            	<li><a href="${www_ct_url}gongju/tupianduibi.html"><i class="tp"></i>图片对比</a></li>
            	<li><a href="${www_ct_url}gongju/jiagepinggu.html"><i class="pg"></i>价值评估</a></li>
            	<li><a href="${www_ct_url}gongju/baojia.html"><i class="bj"></i>车型报价</a></li>
            	<li><a href="${dealer_ct_url}a9-1.html"><i class="jxs"></i>经销商咨询</a></li>
            </ul>    
        </div>    

				</div>
				
	<div class="events">	
	<h2 class="title"><i></i>精彩活动<span class="ora-line"></span>
  <span class="more"><a target="_blank" href="${www_ct_url}list/728/list_1.html">更多 &rsaquo;&rsaquo;</a></span>
</h2>	
	<div class="con">	
	<ul class="clearfix">	
<#list dataMap['jchd'] as sub_data>
<#if sub_data_index lt 4>
			<li>	
				<a target="_blank" href="${sub_data.link}">	
					<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="" href="${sub_data.link}" style="height: 117px; width: 190px;"></div>
					<p href="${sub_data.link}">${sub_data.title}</p>	
				</a>	
			</li>	
</#if>
</#list>
	</ul>	
	</div>	
	</div>	

			</div>
			<div class="clearfix"></div>
		</div>
		<div class="banner-ad-02"><a target="_blank" href="http://www.chevrolet.com.cn/brandsite/car_camaro.html"><img src="${www_ct_url}images/chetuan_banner_02.jpg" alt="" ></a></div>
		<div class="article-tab">
			<div class="title-nav">
				<div class="title-subcnt">
					<ul>
						<li class="frist selected"><span><a href="${www_ct_url}list/${(wqhg.catalogid)!729}/list_1.html" target="_blank">往期回顾</a></span></li>
						<li><span><a href="${www_ct_url}list/${(zdyh.catalogid)!730}/list_1.html" target="_blank">${(zdyh.catalogname)!"最新优惠"}</a></span></li>
						<li><span><a href="${www_ct_url}list/${(sjhd.catalogid)!731}/list_1.html" target="_blank">商家活动</span></a></li>
						<li><span><a href="${www_ct_url}list/${(xcdd.catalogid)!733}/list_1.html" target="_blank">新车到店</span></a></li>
						<li class="last"><span><a href="${www_ct_url}list/${(wqts.catalogid)!734}/list_1.html" target="_blank">维权投诉</a></span></li>
					</ul>
				</div>
			</div>
			<div class="title-content">
				
				<div style="display:block;" class="content-item">
				
							<ul class="article-list" id="ui_wqhg">	
				<#list dataMap['wqhg'] as sub_data>
				<#if sub_data_index lt 3>
								<li>
									<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	
									<div class="body">	
										<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	
				<#if sub_data.content?length lt 100>
										<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a class="more" target="_blank" href="${sub_data.link}">【详细】</a></p>	
				<#else>
										<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a class="more" target="_blank" href="${sub_data.link}">【详细】</a></p>	
				</#if>
				<!--						<span class="keyword">关键词：	-->
				<!--							<a href="${sub_data.link}">英伦范</a>	-->
				<!--							<a href="${sub_data.link}">荣威750</a>	-->
				<!--						</span>	-->
						<div class="share">
							<!-- Baidu Button BEGIN -->
							<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'url':'${sub_data.link}', 'text':'${sub_data.title}'}">
							    <a class="bds_qzone">QQ </a>
							    <a class="bds_tsina">新浪</a>
							    <a class="bds_tqq">腾讯</a>
							    <a class="bds_renren">人人</a>
							    <span class="bds_more">更多</span>
							</div>
							<!-- Baidu Button END -->	
						</div>
				
									</div>	
								</li <#if sub_data_index == 2>class="last"</#if> >	
				</#if>
				</#list>
							</ul>	
						<div class="article-more"><a  onclick="getWqhgAdd(5335)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	
									

				</div>
				<div class="content-item">
					
			<ul class="article-list" id="ui_zxyh">	
<#list dataMap['zxyh'] as sub_data>
<#if sub_data_index lt 3>
				<li>	
					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	
					<div class="body">	
						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	
<#if sub_data.content?length lt 100>
						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
<#else>
						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
</#if>
<!--						<span class="keyword">关键词：	-->
<!--							<a href="${sub_data.link}">英伦范</a>	-->
<!--							<a href="${sub_data.link}">荣威750</a>	-->
<!--						</span>	-->
						<div class="share">
							<!-- Baidu Button BEGIN -->
							<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'url':'${sub_data.link}', 'text':'${sub_data.title}'}">
							    <a class="bds_qzone">QQ </a>
							    <a class="bds_tsina">新浪</a>
							    <a class="bds_tqq">腾讯</a>
							    <a class="bds_renren">人人</a>
							    <span class="bds_more">更多</span>
							</div>
							<!-- Baidu Button END -->	
						</div>	
					</div>	
				</li <#if sub_data_index == 2>class="last"</#if> >	
</#if>
</#list>
			</ul>	
		<div class="article-more"><a onclick="getWqhgAdd(5331)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	

				</div>
				<div class="content-item">

			<ul class="article-list" id="ui_sjhd">	
<#list dataMap['sjhd'] as sub_data>
<#if sub_data_index lt 3>
				<li>	
					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	
					<div class="body">	
						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	
<#if sub_data.content?length lt 100>
						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
<#else>
						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
</#if>
<!--						<span class="keyword">关键词：	-->
<!--							<a href="${sub_data.link}">英伦范</a>	-->
<!--							<a href="${sub_data.link}">荣威750</a>	-->
<!--						</span>	-->
						<div class="share">
							<!-- Baidu Button BEGIN -->
							<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'url':'${sub_data.link}', 'text':'${sub_data.title}'}">
							    <a class="bds_qzone">QQ </a>
							    <a class="bds_tsina">新浪</a>
							    <a class="bds_tqq">腾讯</a>
							    <a class="bds_renren">人人</a>
							    <span class="bds_more">更多</span>
							</div>
							<!-- Baidu Button END -->	
						</div>	
					</div>	
				</li <#if sub_data_index == 2>class="last"</#if> >	
</#if>
</#list>
			</ul>	
		<div class="article-more"><a onclick="getWqhgAdd(5324)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	

				</div>
				<div class="content-item">

			<ul class="article-list" id="ui_xcdd">	
<#list dataMap['xcdd'] as sub_data>
<#if sub_data_index lt 3>
				<li>	
					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	
					<div class="body">	
						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	
<#if sub_data.content?length lt 100>
						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
<#else>
						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
</#if>
<!--						<span class="keyword">关键词：	-->
<!--							<a href="${sub_data.link}">英伦范</a>	-->
<!--							<a href="${sub_data.link}">荣威750</a>	-->
<!--						</span>	-->
						<div class="share">
							<!-- Baidu Button BEGIN -->
							<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'url':'${sub_data.link}', 'text':'${sub_data.title}'}">
							    <a class="bds_qzone">QQ </a>
							    <a class="bds_tsina">新浪</a>
							    <a class="bds_tqq">腾讯</a>
							    <a class="bds_renren">人人</a>
							    <span class="bds_more">更多</span>
							</div>
							<!-- Baidu Button END -->	
						</div>	
					</div>	
				</li <#if sub_data_index == 2>class="last"</#if> >	
</#if>
</#list>
			</ul>	
		<div class="article-more"><a onclick="getWqhgAdd(5327)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	

				</div>
				<div class="content-item">
					
			<ul class="article-list" id="ui_wqts">	
<#list dataMap['wqts'] as sub_data>
<#if sub_data_index lt 3>
				<li>	
					<div class="pic"><a target="_blank" href="${sub_data.link}"><img width="340" src="${www_ct_url}upload/pageblock/${sub_data.pic}" alt=""></a></div>	
					<div class="body">	
						<h3 class="title"><a target="_blank" href="${sub_data.link}">${sub_data.title}</a></h3>	
<#if sub_data.content?length lt 100>
						<p class="desc"><#if sub_data.content??>${sub_data.content}<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
<#else>
						<p class="desc"><#if sub_data.content??>${sub_data.content[0..99]}...<#else>优秀的你就需要如此高端的车与之相配。</#if><a target="_blank" class="more" href="${sub_data.link}">【详细】</a></p>	
</#if>
<!--						<span class="keyword">关键词：	-->
<!--							<a href="${sub_data.link}">英伦范</a>	-->
<!--							<a href="${sub_data.link}">荣威750</a>	-->
<!--						</span>	-->
						<div class="share">
							<!-- Baidu Button BEGIN -->
							<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'url':'${sub_data.link}', 'text':'${sub_data.title}'}">
							    <a class="bds_qzone">QQ </a>
							    <a class="bds_tsina">新浪</a>
							    <a class="bds_tqq">腾讯</a>
							    <a class="bds_renren">人人</a>
							    <span class="bds_more">更多</span>
							</div>
							<!-- Baidu Button END -->	
						</div>	
					</div>	
				</li <#if sub_data_index == 2>class="last"</#if> >	
</#if>
</#list>
			</ul>	
		<div class="article-more"><a onclick="getWqhgAdd(5329)">查看更多新闻 &rsaquo;&rsaquo;</a></div>	

				</div>
			</div>
		</div>
		<div class="clearfix lehuo-sns">

		<div class="lh-sns">	
			<h2 class="title"><i></i>乐活社区<span class="ora-line"></span><span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-4.aspx">更多 &rsaquo;&rsaquo;</a></span></h2>	
			<div class="con">	
				<dl>	
<#list dataMap['lhsq'] as sub_data>
<#if (sub_data_index==0)>
					<dt>	
						<div class="pic"><a href="${sub_data.link}" target="_blank"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="${sub_data.title}"></a></div>	
						<div class="article">	<a href="${sub_data.link}" target="_blank">
							<h5>${sub_data.title}</h5>	
							<p>${(sub_data.content)!}<a class="more" target="_blank" href="${sub_data.link}">[详细]</a></p>	
						</a></div>	
					</dt>	
<#else>
	<#if (sub_data_index<5)>
						<dd class="car-pic-txt">	
							<a href="${sub_data.link}" target="_blank">	
								<img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="${sub_data.title}">	
								<span></span>	
								<p>${sub_data.title}</p>	
							</a>	
						</dd>	
	</#if>
</#if>
</#list>
				</dl>	
			</div>	
		</div>	
		<div class="lh-login">	
			<h2 class="title"><i></i>会员登录<span class="ora-line"></span></h2>	
			<div class="con">	
				<div class="login">	
					<form action="http://bbs.chetuan.com/api/postlogin.aspx" id="bbs_login" method="post">	
						<div><input type="text" class="input" name="loginStr" value="邮箱/手机/用户名"></div>	
						<div><input type="password" class="input" name="pwdStr"></div>	
						<div><input type="button" class="input-submit" style="text-align:center;" value="登录"></div>	
					</form>	
					<div class="reg"><a href="http://bbs.chetuan.com/register.aspx" target="_blank">注册新用户</a>|<a href="http://bbs.chetuan.com/getpassword.aspx" target="_blank">忘记密码？</a></div>	
				</div>	
				<div class="bbs">	
					<a class="lhsq" title="乐活社区" href="http://bbs.chetuan.com/showforum-4.aspx" target="_blank">乐活社区</a>	
					<a class="tczy" title="提车作业" href="http://bbs.chetuan.com/showforum-5.aspx" target="_blank">提车作业</a>	
					<a class="zjy" title="自驾游" href="http://bbs.chetuan.com/showforum-6.aspx" target="_blank">自驾游</a>	
					<a class="wqts" title="维权投诉" href="http://bbs.chetuan.com/showforum-7.aspx" target="_blank">维权投诉</a>	
				</div>	
			</div>	
		</div>	


<script>
$(function(){
	var ck=document.cookie;
	var cks=ck.split(";");
	for(var i=0;i<cks.length;i++){
		if(cks[i].indexOf("dnt")!=-1){
			var pms =cks[i].split("&");
			for(var j=0;j<pms.length;j++){
				if(pms[j].indexOf("username")!=-1){
					var un=pms[j].split("=")[1];
					$(".login").html("<p class='weclome-user'>亲爱的<font color='red'>"+unescape(un)+"</font>，</p><p>欢迎您登陆车团网！</p>");
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
	$(".login").html("<p class='weclome-user'>亲爱的<font color='red'>"+data+"</font>，</p><p>欢迎您登陆车团网！</p>");
}

</script>

		</div>
		<div class="car-club">
			
	<div class="item">	
		<div class="title-bar">	
			<h2>提车作业 &rsaquo;&rsaquo;</h2>	
			<span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-5.aspx">更多 &rsaquo;&rsaquo;</a></span>	
		</div>	
		<div class="con">	
			<ul class="img-list">	
<#list dataMap['tczy'] as sub_data>
<#if sub_data_index lt 8>
				<li>	
					<a target="_blank" href="${(sub_data.link)}">	
						<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="${sub_data.title}"></div>	
						<p class="title">${sub_data.title}</p>	
					</a>	
				</li>
</#if>
</#list>
			</ul>	
		</div>	
	</div>	

			
	<div class="item">	
		<div class="title-bar">	
			<h2>自驾游 &rsaquo;&rsaquo;</h2>	
			<span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-6.aspx">更多 &rsaquo;&rsaquo;</a></span>	
		</div>	
		<div class="con">	
			<ul class="img-list">	
<#list dataMap['zjy'] as sub_data>
<#if sub_data_index lt 8>
				<li>	
					<a target="_blank" href="${sub_data.link}">	
						<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="${sub_data.title}"></div>	
						<p class="title">${sub_data.title}</p>	
					</a>	
				</li>	
</#if>
</#list>
			</ul>	
		</div>	
	</div>	

	<div class="item">	
		<div class="title-bar">	
			<h2>社区公告 &rsaquo;&rsaquo;</h2>	
			<span class="more"><a target="_blank" href="http://bbs.chetuan.com/showforum-8.aspx">更多 &rsaquo;&rsaquo;</a></span>	
		</div>	
		<div class="con">	
			<ul class="img-list">	
<#list dataMap['sqgg'] as sub_data>
<#if sub_data_index lt 8>
				<li>	
					<a target="_blank" href="${sub_data.link}">	
						<div class="pic"><img src="${www_ct_url}upload/pageblock/${(sub_data.pic)!}" alt="${sub_data.title}"></div>	
<#if (sub_data.title??&&(sub_data.title.length()>10))>
						<p class="title">${sub_data.title[0..10]}</p>	
<#else>
						<p class="title">${(sub_data.title)!}</p>	
</#if>
					</a>	
				</li>
</#if>
</#list>
			</ul>	
		</div>	
	</div>	

		</div>
	<div class="over-layer"></div>
	<div class="popup-carmodel popup-lowprice">
		<h2>报名申请
		<span style="float:right;margin-right:20px;cursor:pointer;">
				<font class="x" color='red'>x</font>
			</span>
			
			<script>
				$(function(){
					$(".x").click(function(){
						$(".popup-lowprice").hide();
						$(".over-layer").css("display", "none").animate({"opacity": "0"});
					});
				});
			</script>
		</h2>
		<p class="desc">您好！请输入手机号，立即 <em>参团</em>,赢取好礼</p>
		<form id="price">
		<input type="hidden" name="left_num" value="0">
			<table class="form-table">
				<tr>
					<th><b>*</b>您的手机：</th>
					<td><div><input class="text" name="phone" type="text" value="请输入手机号"></div></td>
				</tr>
				<tr>
					<th><b>*</b>您的姓名：</th>
					<td>
						<input class="text" name="name" type="text" value="请输入姓名">
						<label><input name="sex" type="radio" value="1" checked>先生</label>
						<label><input name="sex" type="radio" value="2">女士</label>
					</td>
				</tr>
				<tr>
					<th><b>*</b>所在地区：</th>
					<td>
						<select name="prov" id="">
							<option value="0">选择省份</option>
						</select>
						<select name="city" id="">
							<option value="0">选择城市</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>意向车型：</th>
					<td>
						<input type="hidden" name="cid"/>
						<select name="mid" id="">
							<option value="0"> -- 请选择车型 -- </option>
						</select>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input class="submit" type="button" value="提交报名"><span>说明：凡参团订车的用户均可获得价值500-5000元不等的礼品。</span></td>
				</tr>
			</table>
		</form>
	</div>	
	
	<input id="sub_sites_id" type="hidden" value="${subContent.sub_sites_id!"9"}"></input>
		
<script>
var area;
$(function() {
	// home focus
	$(".home-focus-slider").bxSlider({
		auto: true,
		mode: 'horizontal',
		controls: false
	});

	var $CarQuoteBar = $(".title-nav ul li");
	$CarQuoteBar.on("mouseenter mouseleave", function() {
		$(this).addClass("selected").siblings().removeClass("selected");
		var index = $CarQuoteBar.index(this);
		$(".title-content > div").eq(index).show().siblings().hide();
	});
});
			$(function(){
				$.ajax({
    				url : '${chetuan_ct_url}chetuan/setInitCookie',
    				dataType : 'jsonp',
    				jsonp:'jsonpcallback',
    				success : function(data){
    				area = data[0];
    				}
    			});
			
			
				var $provNode=$("select[name='prov']");
				
				
				$provNode.on("change",function(){
					var $cityNode=$("select[name='city']");
					
					var prov=$(this).val();
					
					if(eval(prov)<=0){
						$cityNode.empty();
						var $option=$("<option value='0'>请选择城市</option>");
						$cityNode.append($option);
						return ;
					}
					
					$.ajax({
						url:"${www_ct_url}chetuan/apply_forCity1?cid="+prov,
						dataType : 'jsonp',
    					jsonp:'jsonpcallback',
						success:function(data){
							$cityNode.empty();
							var $option=$("<option value='0'>请选择城市</option>");
							$cityNode.append($option);
							
							for(var i=0;i<data.length;i++){
								var k=data[i].catalogid;
								var n=data[i].catalogname;						
								var $option=$("<option value='"+k+"'>"+n+"</option>");
								$cityNode.append($option);
							}
						}
					});
				});
				
				$(".submit").click(function(){
					var $talbe=$(this).parent().parent().parent();
					var name=$.trim($talbe.find("input[name='name']").val());
					var phone=$.trim($talbe.find("input[name='phone']").val());
					var sex=$talbe.find("input[type='radio']:checked").val();
					var prov=$talbe.find("select[name='prov']").val();
					var city=$talbe.find("select[name='city']").val();
					var mid=$talbe.find("select[name='mid']").val();
					var cid=$.trim($("input[name='cid']").val());
					var left_num=$.trim($("input[name='left_num']").val());
					var ptn=/^请输入.*$/;
					if(ptn.test(name)){
						name="";
					}
					
					if(phone==null||phone==""){
						alert("请输入手机号!");
						return ;
					}else{
						var phone_pattern=/^1[0-9]{10}$/;
						if(!phone_pattern.test(phone)){
							alert("请输入正确的手机号!");
							return ;
						}
					}
					if(name==null||name==""){
						alert("请输入姓名!");
						return ;
					}else{
						var name_pattern=/^[A-Za-z ·]{2,20}|([\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*)$/;
						if(!name_pattern.test(name)){
							alert("请输入正确的姓名!");
							return ;
						}
					}
					
					
					if(prov<=0){
						alert("请选择省份！");
						return ;
					}
					
					if(city<=0){
						alert("请选择城市！");
						return ;
					}
					
					if(mid<=0){
						alert("请选择车型");
						return;
					}
					
					$.ajax({
						url:"${www_ct_url}chetuan/apply_forSaleFavored",
						type:'POST',
						dataType : 'jsonp',
						data :{"phone":phone,"name":encodeURI(name),"prov":prov,"city":city,"sex":sex,"cid":cid,"mid":mid,"left_num":left_num},
    					jsonp:'jsonpcallback',
						success:function(data){						
								alert("提交成功！");
								$(".popup-carmodel").hide();
								$(".over-layer").hide();
						}
					});
				});
			});
			function groupbuyApply(brand,model,num){
				$("input[name='cid']").val(brand);
				$("input[name='left_num']").val(num);
				if(($(".go").length > 0) && ($(".over-layer").is(":hidden")) ) {
					$(".over-layer").css("display", "block").animate({"opacity": "0.6"});
					$(".popup-lowprice").css({
						left: ($(window).width() - $(".popup-lowprice").outerWidth())/2,
						top: ($(window).height() - $(".popup-lowprice").outerHeight())/2
					}).show();
					$(".over-layer").click(function() {
						$(".popup-lowprice").hide();
						$(this).css("display", "none").animate({"opacity": "0"});
					});
				}
				
				var $provNode=$("select[name='prov']");
				$.ajax({
					url:"${www_ct_url}chetuan/apply_forProv1",
					dataType : 'jsonp',
    				jsonp:'jsonpcallback',
					success:function(data){
						for(var i=0;i<data.length;i++){
							k = data[i].catalogid;
							var $option=$("<option value='"+data[i].catalogid+"'>"+data[i].catalogname+"</option>");
							if(area.fatherid == 0)
							{
								if(k==area.catalogid)
								{
									$option.attr("selected","true");
								}
    						}
    						else
    						{
    							if(k==area.fatherid)
    							{
									$option.attr("selected","true");
								}
    						}
							$provNode.append($option);
						}
					}
				});
				var $cityNode=$("select[name='city']");
				var pro ;
							if(area.fatherid == 0)
							{
								pro = area.catalogid;
									
    						}
    						else
    						{
    							pro = area.fatherid;
    						}
				$.ajax({
						url:"${www_ct_url}chetuan/apply_forCity1?cid="+pro,
						dataType : 'jsonp',
    					jsonp:'jsonpcallback',
						success:function(data){						
							$cityNode.empty();
							var $option=$("<option value='0'>请选择城市</option>");
							$cityNode.append($option);					
							for(var i=0;i<data.length;i++){
								var k=data[i].catalogid;
								var $option=$("<option value='"+data[i].catalogid+"'>"+data[i].catalogname+"</option>");
								if(k==area.catalogid)
									$option.attr("selected","true");
								$cityNode.append($option);
							}
						}
					});
				
				$("select[name='mid']").empty();
				$("select[name='mid']").append($("<option value='0'> -- 请选择车型 -- </option>"));
				$.ajax({
					url:"${www_ct_url}chetuan/apply_forSalModel1?cid="+brand,
					dataType : 'jsonp',
    				jsonp:'jsonpcallback',
					success:function(data){			
						var $modelNode=$("select[name='mid']");
						for(var i=0;i<data.length;i++){
							var k=data[i].catalogid;
							var n=data[i].catalogname;						
							var $option=$("<option value='"+k+"'>"+n+"</option>");
							if(k==model){
								$option.attr("selected","true");
							}
							$modelNode.append($option);
						}
					}
				});
		}
		$(function(){
				$("input[name='name']").click(function(){
					var value=$.trim($(this).val());
					if(value=="请输入姓名"){
						$(this).val("");
					}
				});
				
				$("input[name='phone']").click(function(){
					var value=$.trim($(this).val());
					if(value=="请输入手机号"){
						$(this).val("");
					}
				});
				
				
				$("input[name='name']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("请输入姓名");
					}
				});
				
				$("input[name='phone']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("请输入手机号");
					}
				});
			})
	function getImagePath(path){
		if(path.substr(0,3)=="315"){
			path = path.replace(/315/,"http://img.315che.com");
		}
		return path;
	}
</script>
<script type="text/javascript" src="${www_ct_url}js/sub_more.js?v=${ver}"></script>

<!--bd share-->
<script type="text/javascript" id="bdshare_js" data="type=tools" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
    document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
</script>

</@cc.html>