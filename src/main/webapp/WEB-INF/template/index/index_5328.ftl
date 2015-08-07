<#import "../common_chetuan.ftl" as html>

<@html.html 2>
	<!--页首-->
	<div class="clearfix">
		<div class="group-focus">
			<script type="text/javascript" src="${www_ct_url}sub/block_5332.js?v=${ver}"></script>
		</div>
		
		
		<@html.apply />
	</div>
	
	<!--查询-->
	<ul class="position">
		<a href="${www_ct_url}">车团</a>&gt;小胖看车团
	</ul>
	<div id="show">
		<script>
			function　viewList(level,price,brand,displm,sorted,area,curPage){
				$.post("/chetuan/viewList",
				{"level":level,"price":price,"brand":brand,"displm":displm,"sorted":sorted,"area":area,"curPage":curPage},
				function(data){
					$("#show").html(data);
				});
			}
			
			function toGroupbuySeries(id){
				document.location.href="${www_ct_url}chetuan/"+id+"/toGroupbuySeries.html";
			}
			
			function forCiry(prov,selectCity){
				$.ajax({
					url:"/chetuan/apply_forCity?cid="+prov,
					success:function(data){
						data=data.replace("{","");
						data=data.replace("}","");
						var kns=data.split(",");
						
						var $cityNode=$("select[name='city']");
						$cityNode.empty();
						var $option=$("<option value='0'>请选择城市</option>");
						$cityNode.append($option);
						
						for(var i=0;i<kns.length;i++){
							var kn=kns[i].split("=");
							var k=kn[0];
							var n=kn[1];
							
							var $option=$("<option value='"+k+"'>"+n+"</option>");
							
							if(selectCity==k){
								$option.attr("selected","true");
							}
							
							$cityNode.append($option);
						}
					}
				});
			}
			
			function forProv(selectProv){
				var $provNode=$("select[name='prov']");
				$.ajax({
					url:"/chetuan/apply_forProv",
					success:function(data){
						data=data.replace("{","");
						data=data.replace("}","");
						var kns=data.split(",");
						
						for(var i=0;i<kns.length;i++){
							var kn=kns[i].split("=");
							var k=kn[0];
							var n=kn[1];
							
							var $option=$("<option value='"+k+"'>"+n+"</option>");
							if(parseInt(selectProv)==k){
								$option.attr("selected","true");
							}
							$provNode.append($option);
						}
					}
				});
			}
			
			$(function(){
				<#if search_kw??>
					viewList('','','${search_kw}');
				<#else>
					viewList('${(level)!}','${(price)!}','${(brand)!}');
				</#if>
				
				var prov_ck=9;
				var city_ck=0;
				$.ajax({
    				url : '${chetuan_ct_url}/chetuan/setInitCookie',
    				dataType : 'jsonp',
    				async:false,
    				jsonp:'jsonpcallback',
    				success : function(data){
    					area = data[0];
    					
    					var cid=area.catalogid;
    					var fid=area.fatherid;
    					if(fid==0){
    						prov_ck=cid;
    						city_ck=0;
    					}else{
    						prov_ck=fid;
    						city_ck=cid;
    					}
    					forProv(prov_ck);
    					forCiry(prov_ck,city_ck);
    				},
    				error:function(){
    					forProv("");
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
						url:"/chetuan/apply_forCity?cid="+prov,
						success:function(data){
							data=data.replace("{","");
							data=data.replace("}","");
							var kns=data.split(",");
							
							$cityNode.empty();
							var $option=$("<option value='0'>请选择城市</option>");
							$cityNode.append($option);
							
							for(var i=0;i<kns.length;i++){
								var kn=kns[i].split("=");
								var k=kn[0];
								var n=kn[1];
								
								var $option=$("<option value='"+k+"'>"+n+"</option>");
								
								if(city_ck==k){
									$option.attr("selected","true");
								}
								
								$cityNode.append($option);
							}
						}
					});
				});
				
				$("#sbm").click(function(){
					var $talbe=$(this).parent().parent().parent();
					var name=$.trim($talbe.find("input[name='name']").val());
					var phone=$.trim($talbe.find("input[name='phone']").val());
					var sex=$talbe.find("input[type='radio']:checked").val();
					var prov=$talbe.find("select[name='prov']").val();
					var city=$talbe.find("select[name='city']").val();
					var mid=$talbe.find("select[name='mid']").val();
					var cid=$.trim($("input[name='cid']").val());
					
					var ptn=/^请输入.*$/;
					if(ptn.test(name)){
						name="";
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
					
					$.post(
						"/chetuan/apply_forApply",
						{"phone":phone,"name":name,"prov":prov,"city":city,"sex":sex,"cid":cid,"mid":mid},
						function(data){
							if(eval(data)){
								alert("恭喜您，报名成功！我们的服务人员会很快联系您，谢谢！\n\n凡参团订车的用户均可获得价值500-5000元不等的礼品。");
								$(".popup-carmodel").hide();
								$(".over-layer").hide();
							}else{
								alert(data);
							}
						}
					);
				});
			});
			
			function groupbuyApply(brand,model){
				$("input[name='cid']").val(brand);
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
				
				$("select[name='mid']").empty();
				$("select[name='mid']").append($("<option value='0'> -- 请选择车型 -- </option>"));
				$.ajax({
					url:"chetuan/apply_forModel?cid="+brand,
					success:function(data){
						data=data.replace("{","");
						data=data.replace("}","");
						var kns=data.split(",");
						
						var $modelNode=$("select[name='mid']");
						for(var i=0;i<kns.length;i++){
							var kn=kns[i].split("=");
							var k=kn[0];
							var n=kn[1];
							
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
			
			function bcFun(){
				
			}
		</script>
	</div>
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
					<td><input class="submit" type="button" id="sbm" value="立即报名"><span>说明：凡参团订车的用户均可获得价值500-5000元不等的礼品。</span></td>
				</tr>
			</table>
		</form>
	</div>
</@html.html>