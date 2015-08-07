<#import "../common_wapchetuan.ftl" as c />
<@c.html>
	<div class="top-nav">
		<a href="/kanche/" id="goback" class="iconfont goback">&#xe600;</a>
		<#if (model['buy_type']=="0")>
			<h2>${model['model_name']?split(' ')[0]}团购</h2>
		<#else>
			<h2>${model['model_name']?split(' ')[0]}特卖惠</h2>
		</#if>
	</div>
	
	<script>
		//$(function(){
		//	var referrer=document.referrer;
		//	//http://m.chetuan.com/kanche/list-0--0--0--85--hot.html
		//	if(referrer!=null&&referrer.length>=20){
		//		if(referrer.substring(0,20)=="http://m.chetuan.com"){
		//			$("#goback").attr("href",referrer);
		//		}
		//	}
		//});
	</script>
	
	<div class="enroll-box">
		<div class="wrap">
			<ul class="tg-info1">
				<li><img src="${www_ct_url}${model['pic']?substring(4)}" alt=""></li>
				<li>
					<h3>${model['model_name']}</h3>
				</li>
			</ul>
			<h1 class="info-tit">您的联系方式</h1>
			<form action="/wapchetuan/apply" method="post" id="apply_form"accept-charset="UTF-8">
				<input type="hidden" name="applyInfo.carid" value="${model['brand_id']}"/>
				<input type="hidden" name="applyInfo.modelid" value="${model['carid']}"/>
				<#if (model['buy_type']=="0")>
					<input type="hidden" name="applyInfo.type" value="16"/>
				<#else>
					<input type="hidden" name="applyInfo.type" value="15"/>
				</#if>
				<ul class="info-luru">
					<li>
						<input type="text" name="applyInfo.name" id="aply_name" class="enroll-text bordb" placeholder="请输入姓名" />
						<input type="text" name="applyInfo.phone" id="apply_phone" class="enroll-text bordt" placeholder="请输入手机号码" />
					</li>
				</ul>
				<p class="btns"><input type="button" class="btn-one btn-blue" value="提交" /></p>
			</form>
		</div>
	</div>
	<script>
		$(function(){
			$(".btn-blue").click(function(){
				var name=$.trim($("#aply_name").val());
				var phone=$.trim($("#apply_phone").val());
				
				//|([\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5}))*
				var name_p=/^([a-zA-Z ]{2,20})|([\u4E00-\u9FA5]{2,5}(·[\u4E00-\u9FA5]{2,5})?)$/;
				var phone_p=/^1[0-9]{10}$/;
				
				//alert(name_p.test(name));
				if(!name_p.test(name)){
					$("#aply_name").val("");
					$("#aply_name").focus();
					return ;
				}
				
				if(!phone_p.test(phone)){
					$("#apply_phone").val("");
					$("#apply_phone").focus();
					return ;
				}
				
				$("#apply_form").submit();
			});
		});
	</script>
</@c.html>