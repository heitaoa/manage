<#import "../common_chetuan.ftl" as html>

<@html.html 2>
	<!--ҳ��-->
	<div class="clearfix">
		<div class="group-focus">
			<script type="text/javascript" src="${www_ct_url}sub/block_5332.js?v=${ver}"></script>
		</div>
		
		
		<@html.apply />
	</div>
	
	<!--��ѯ-->
	<ul class="position">
		<a href="${www_ct_url}">����</a>&gt;С�ֿ�����
	</ul>
	<div id="show">
		<script>
			function��viewList(level,price,brand,displm,sorted,area,curPage){
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
						var $option=$("<option value='0'>��ѡ�����</option>");
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
						var $option=$("<option value='0'>��ѡ�����</option>");
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
							var $option=$("<option value='0'>��ѡ�����</option>");
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
					
					var ptn=/^������.*$/;
					if(ptn.test(name)){
						name="";
					}
					
					if(name==null||name==""){
						alert("����������!");
						return ;
					}else{
						var name_pattern=/^[A-Za-z ��]{2,20}|([\u4E00-\u9FA5]{2,5}(?:��[\u4E00-\u9FA5]{2,5})*)$/;
						if(!name_pattern.test(name)){
							alert("��������ȷ������!");
							return ;
						}
					}
					if(phone==null||phone==""){
						alert("�������ֻ���!");
						return ;
					}else{
						var phone_pattern=/^1[0-9]{10}$/;
						if(!phone_pattern.test(phone)){
							alert("��������ȷ���ֻ���!");
							return ;
						}
					}
					
					if(prov<=0){
						alert("��ѡ��ʡ�ݣ�");
						return ;
					}
					
					if(city<=0){
						alert("��ѡ����У�");
						return ;
					}
					
					if(mid<=0){
						alert("��ѡ����");
						return;
					}
					
					$.post(
						"/chetuan/apply_forApply",
						{"phone":phone,"name":name,"prov":prov,"city":city,"sex":sex,"cid":cid,"mid":mid},
						function(data){
							if(eval(data)){
								alert("��ϲ���������ɹ������ǵķ�����Ա��ܿ���ϵ����лл��\n\n�����Ŷ������û����ɻ�ü�ֵ500-5000Ԫ���ȵ���Ʒ��");
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
				$("select[name='mid']").append($("<option value='0'> -- ��ѡ���� -- </option>"));
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
					if(value=="����������"){
						$(this).val("");
					}
				});
				
				$("input[name='phone']").click(function(){
					var value=$.trim($(this).val());
					if(value=="�������ֻ���"){
						$(this).val("");
					}
				});
				
				
				$("input[name='name']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("����������");
					}
				});
				
				$("input[name='phone']").blur(function(){
					var value=$.trim($(this).val());
					if(value==""){
						$(this).val("�������ֻ���");
					}
				});
			})
			
			function bcFun(){
				
			}
		</script>
	</div>
	<div class="popup-carmodel popup-lowprice">
		
		<h2>��������
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
		
		<p class="desc">���ã��������ֻ��ţ����� <em>����</em>,Ӯȡ����</p>
		<form id="price">
			<table class="form-table">
				<tr>
					<th><b>*</b>�����ֻ���</th>
					<td><div><input class="text" name="phone" type="text" value="�������ֻ���"></div></td>
				</tr>
				<tr>
					<th><b>*</b>����������</th>
					<td>
						<input class="text" name="name" type="text" value="����������">
						<label><input name="sex" type="radio" value="1" checked>����</label>
						<label><input name="sex" type="radio" value="2">Ůʿ</label>
					</td>
				</tr>
				<tr>
					<th><b>*</b>���ڵ�����</th>
					<td>
						<select name="prov" id="">
							<option value="0">ѡ��ʡ��</option>
						</select>
						<select name="city" id="">
							<option value="0">ѡ�����</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>�����ͣ�</th>
					<td>
						<input type="hidden" name="cid"/>
						<select name="mid" id="">
							<option value="0"> -- ��ѡ���� -- </option>
						</select>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input class="submit" type="button" id="sbm" value="��������"><span>˵���������Ŷ������û����ɻ�ü�ֵ500-5000Ԫ���ȵ���Ʒ��</span></td>
				</tr>
			</table>
		</form>
	</div>
</@html.html>