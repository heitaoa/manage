
<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<h3 class="page-title">
	经销商信息维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">经销商信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
			<a href="#">经销商信息维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet-body">
				<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i><#if updateType==1>更新经销商信息<#else>添加经销商信息</#if> 
							</div>
						</div>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<#if updateType!=1>
								<div class="row">
									<div class="col-md-2">
										用户名：
									</div>
									<div class="col-md-10">
										<input id="username" name="updateUsername" type="text" class="form-control input-inline input-medium"><span class="help-inline">必须为英文字母开头,只能由英文(a-z)和数字(0-9)组成，不区分大小写,长度为4-15个字符；建议与公司名称相关，简单、易记。如:上海中欧 的登录名是 shcei </span>
									</div>
								</div>
							
								<div class="row">
									<div class="col-md-2">
										登陆密码：
									</div>
									<div class="col-md-10">
										<input id="password" name="updatepassword" type="text" class="form-control input-inline input-medium" ><span class="help-inline">建议用数字(0-9)和英文(a-z),不区分大小写；建议为字母和数字结合，便于记忆，但不易被猜出 </span>
									</div>
									</div>
									<div class="row">
									<div class="col-md-2">
										确认密码：
									</div>
									<div class="col-md-10">
										<input id="repassword" name="updatepassword" type="text" class="form-control input-inline input-medium" ><span class="help-inline">重复输入密码 </span>
									</div>
								</div>
							</#if>
							<div class="row">
								<div class="col-md-2">
									企业名称：
								</div>
								<div class="col-md-10">
									<input id="ename" name="updateename" type="text" class="form-control input-inline input-medium" <#if updateType==1>value="${updealer.ename}"<#else>value=""</#if>>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									企业名称缩写：
								</div>
								<div class="col-md-10">
									<input id="shortename" name="updateshortename" type="text" class="form-control input-inline input-medium" <#if updateType==1>value="${updealer.shortename}"<#else>value=""</#if>>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									品牌：
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-2">
											<select id="updatemainBrandid" class="form-control input-small" onchange="OnChangeBrand()">
												<option value="0">--选择品牌--</option>
												<#list brandMap?keys as key>
													<#list brandMap.get(key) as brand>
														<option value="${brand.catalogid}" id="brand_${brand.catalogid}">${key} ${brand.catalogname}</option>
													</#list>
												</#list>
											</select>
										</div>
										<div class="col-md-10">
											<span id="mianBrands">
												<#if updateType==1>
												<#list mainbrand as brand>
														<span id="d_${brand.catalogid}">
														<a id="a_${brand.catalogid}">${brand.catalogname}</a>
														<img id="i_${brand.catalogid}" onclick="clearThis1(${brand.catalogid})" src="http://img.315che.com/hd/10img/web_close.gif">
														</span>
												</#list>
												</#if>
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									渠道：
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-2">
											<select id="updateiway" class="form-control input-small" onchange="saveIway()">
												<option value="0">--选择渠道--</option>
											</select>
										</div>
										<div class="col-md-10">
											<span id="iways">
											<#if updateType==1>
												<#list diways as brand>
														<span id="diway_${brand_index}">
														<a id="aiway_${brand_index}">${brand}</a>
														<img id="iiway_${brand_index}" onclick="clearThis2(${brand_index})" src="http://img.315che.com/hd/10img/web_close.gif">
														</span>
												</#list>
											</#if>
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									企业类型：
								</div>
								<div class="col-md-10">
									<select id="update_is4s" class="form-control input-small">
										<option value="0" <#if updateType==1><#if updealer.is4s==0>selected</#if></#if>>综合店</option>
										<option value="1" <#if updateType==1><#if updealer.is4s==1>selected</#if></#if>>4s店</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									企业地域：
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-2">
											<select id="update_area" class="form-control input-small" onchange="OnChangeArea();">
												<option value="0">--选择省份--</option>
												<#list zimuStr as key>
													<#if areaMap.get(key)??>
														<#list areaMap.get(key) as area>
															<option value="${area.catalogid}" <#if updateType==1><#if updealer.areaid==area.catalogid>selected<#else><#if cityFatherid==area.catalogid>selected</#if></#if></#if>>${key} ${area.catalogname}</option>
														</#list>
													</#if>
												</#list>
											</select>
										</div>
										<div class="col-md-2">
											<select id="update_city" class="form-control input-small">
												<option value="0">--选择城市--</option>
												<#if updateType==1>
													<#list zimuStr as key>
														<#if cityMap.get(key)??>
															<#list cityMap.get(key) as area>
																<option value="${area.catalogid}" <#if updealer.areaid==area.catalogid>selected</#if>>${key} ${area.catalogname}</option>
															</#list>
														</#if>
													</#list>
												</#if>
											</select>
										</div>
										<div class="col-md-8">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									联系电话：
								</div>
								<div class="col-md-10">
									<input id="telephone" name="updatepassword" type="text" class="form-control input-inline input-medium" <#if updateType==1>value="${updealer.telephone}"<#else>value=""</#if>>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									是否是好途邦：
								</div>
								<div class="col-md-10">
									<select id="ishaotuban" class="form-control input-small">	
										<option value="0">不是</option>
										<option value="1" <#if updateType==1><#if updealer.ishaotuban==1>selected</#if></#if>>是</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									企业级别：
								</div>
								<div class="col-md-10">
									<select id="update_userType" class="form-control input-small">	
										<option value="0">--企业级别--</option>
										<option value="1" <#if updateType==1><#if updealer.paylevel!=5>selected</#if></#if>>普通会员</option>
										<option value="2" <#if updateType==1><#if updealer.paylevel==5&&updealer.istmp==1>selected</#if></#if>>试用会员</option>
										<option value="3" <#if updateType==1><#if updealer.paylevel==5&&updealer.istmp==0>selected</#if></#if>>短期会员</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									是否是超级VIP：
								</div>
								<div class="col-md-10">
									<select id="update_issupervip" class="form-control input-small">	
										<option value="0">不是</option>
										<option value="1" <#if updateType==1><#if updealer.issupervip==1>selected</#if></#if>>是</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									到期时间：
								</div>
								<div class="col-md-2">
									<div class="input-group date date-picker margin-bottom-5" data-date-format="yyyy-mm-dd" >
										<input id="expirationdate" type="text" class="form-control input-inline input-medium" readonly name="product_created_from" <#if updateType==1>value="${updealer.expirationdate?string('yyyy-MM-dd')}"<#else>value=""</#if>>
										<span class="input-group-btn">
										<button class="btn btn-sm default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn blue" onClick="saveUpdateDealerInfo(${updateType},${eidStr})">保存</button>
					</div>
				</div>
			</div> 
	</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">

function clearThis1(id){
 $("#d_"+id).html("");
}

function clearThis2(id){
 $("#diway_"+id).html("");
}

function saveUpdateDealerInfo(updateType,eid){
	if(updateType!=1){
		var username=$("#username").val();
		if(username=='' || username==undefined || username==null){
			alert("用户名不能为空");
			return;
		}
		var regex=/^[A-Za-z0-9]{4,15}$/
		if(!regex.test(username)){
			alert("请正确输入用户名");
			return;
		}
		var password=$("#password").val();
		if(password=='' || password==undefined || password==null){
			alert("密码不能为空");
			return;
		}
		if(!regex.test(password)){
			alert("请正确输入密码");
			return;
		}
		var repassword=$("#repassword").val();
		if(repassword=='' || repassword==undefined || repassword==null){
			alert("请重复输入密码");
			return;
		}
		if(!regex.test(repassword)){
			alert("请正确输入密码");
			return;
		}
		if(repassword!=password){
			alert("两次密码不一致");
			return;
		}
		
	}
	var ename=$("#ename").val();
	if(ename=='' || ename==undefined || ename==null){
		alert("公司名不能为空");
		return;
	}
	var shortename=$("#shortename").val();
	if(shortename=='' || shortename==undefined || shortename==null){
		alert("公司简称不能为空");
		return;
	}
	var mainbrand=$("#mianBrands").find("span").find("a");
	var mainBrandStr="";
	var bNum=0;
	for(var i=0;i<mainbrand.length;i++){
		var id=$($("#mianBrands").find("span").find("a")[i]).prop("id");
		bNum++;
		mainBrandStr=mainBrandStr+id.substring(2,id.length)+",";
	}
	if(bNum==0){
		alert("请选择主营品牌");
		return;
	}
	var iway=$("#iways").find("span").find("a");
	var iwayStr="";
	var iNum=0;
	for(var i=0;i<iway.length;i++){
		var name=$($("#iways").find("span").find("a")[i]).html();
		iNum++;
		iwayStr=iwayStr+name+",";
	}
	if(iNum==0){
		alert("请选择渠道");
		return;
	}
	var is4s=$("#update_is4s").val();
	var areaid=0;
	if($("#update_city").val()==0){
		areaid=$("#update_area").val();
	}else{
		areaid=$("#update_city").val();
	}
	if(areaid==0){
		alert("请选择地区");
		return;
	}
	var telephone=$("#telephone").val();
	var userType=$("#update_userType").val();
	var expirationdate=$("#expirationdate").val();
	var ishaotuban=$("#ishaotuban").val();
	var issuppervip=$("#update_issupervip").val();
	if(userType==0){
		alert("请选择企业级别");
		return;
	}
	if(userType!=1){
		if(expirationdate==""||expirationdate==null||expirationdate==undefined){
			alert("请选择结束时间");
			return;
		}
	}
	
	if(updateType!=1){
		$.ajax({
			type : "POST",
			cache : false,
    		url : 'AddDealerInfo1',
    		dataType : 'jsonp',
    		data:{eid:eid,username:username,passWord:password,issuppervip:issuppervip,updateType:updateType,ename:encodeURI(ename),shortename:encodeURI(shortename),mainBrandStr:mainBrandStr,iwayStr:encodeURI(iwayStr),is4s:is4s,areaid:areaid,telephone:telephone,userType:userType,expirationdate:expirationdate,ishaotuban:ishaotuban},
    		jsonp:'jsonpcallback',
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		success : function(data){
    			if(data[0]){
					alert("更新成功");
					window.location.href="${admin_che_url}adminche/DealerInfoManager";
				}else{
					alert(data[1]);
				}
    		}
		});
	}else{
		$.ajax({
			type : "POST",
			cache : false,
    		url : 'AddDealerInfo1',
    		dataType : 'jsonp',
    		data:{eid:eid,issuppervip:issuppervip,updateType:updateType,ename:encodeURI(ename),shortename:encodeURI(shortename),mainBrandStr:mainBrandStr,iwayStr:encodeURI(iwayStr),is4s:is4s,areaid:areaid,telephone:telephone,userType:userType,expirationdate:expirationdate,ishaotuban:ishaotuban},
			jsonp:'jsonpcallback',
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		success : function(data){
    			if(data[0]){
					alert("更新成功");
					window.location.href="${admin_che_url}adminche/DealerInfoManager";
				}else{
					alert(data[1]);
				}
    		}
		});
	}
	
	
	
	/*
	$.post(
		'GetIwayListByBrandId',
		{eid:eid,updateType:updateType,ename:encodeURI(ename),shortename:encodeURI(shortename),mainBrandStr:mainBrandStr,iwayStr:encodeURI(iwayStr),is4s:is4s,areaid:areaid,telephone:telephone,userType:userType,expirationdate:expirationdate},
		function(data){
					if(data[0]){
						alert("更新成功！");
						window.location.href="${admin_che_url}adminche/DealerInfoManager";
					}else{
						alert("更新失败！");
					}
				}
	);
	*/
}

function saveIway(){
	var iwayname=$("#updateiway").val();
	var length11=$("#iways").find("div").length;
	if(iwayname=="0"){
	
	}else{
		var aname=$("#iways").find("a");
		var num=0;
		for(var i=0;i<aname.length;i++){
			if($("#iways").find("a:eq("+i+")").html()==iwayname){
				num++;
			}
		}
		if(num==0){
		
		var iwayStr="<span id='diway_"+length11+"'><a id='aiway_"+length11+"'>"+iwayname+"</a><img id='iiway_"+length11+"' onclick='clearThis2("+length11+")' src='http://img.315che.com/hd/10img/web_close.gif'></span>";
		$("#iways").append(iwayStr);
		}
	}
}

function OnChangeBrand(){
	var brandId=$("#updatemainBrandid").val();
	if(brandId==0){
		$("#updateiway").html("<option value='0'>--选择城市--</option>");
	}else{
		$.ajax({
			type : "POST",
			cache : false,
    		url : 'GetIwayListByBrandId',
    		dataType : 'jsonp',
    		data:{brandId:brandId},
    		jsonp:'jsonpcallback',
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		success : function(data){
    			//var alist=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    			var brandname=$("#brand_"+brandId).html();
    			var brandStr="<span id='d_"+brandId+"'><a id='a_"+brandId+"'>"+brandname.substring(2,brandname.length)+"</a><img id='i_"+brandId+"' onclick='clearThis1("+brandId+")' src='http://img.315che.com/hd/10img/web_close.gif'></span>";
    			$("#mianBrands").append(brandStr);
    			var htmlStr="<option value='0'>--选择渠道--</option>";
    				
    				for(var key in data[0]){
						htmlStr=htmlStr+"<option value='"+key+"'>"+key+"</option>"
					}
    			$("#updateiway").html(htmlStr);
    		}
		});
	}
}


function OnChangeArea(){
	var areaId=$("#update_area").val();
	if(areaId==0){
		$("#update_city").html("<option value='0'>--选择城市--</option>");
	}else{
		$.ajax({
			type : "POST",
			cache : false,
    		url : 'GetCityListByAreaId',
    		dataType : 'jsonp',
    		data:{areaId:areaId},
    		jsonp:'jsonpcallback',
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    		success : function(data){
    			var area=data[0];
    			var alist=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    			var htmlStr="<option value='0'>--选择城市--</option>";
    			for(var i=0;i<alist.length;i++){
    				for(var key in area){
						if(alist[i]==key){
							for(var j=0;j<area[key].length;j++){
								htmlStr=htmlStr+"<option value='"+area[key][j].catalogid+"'>"+key+" "+area[key][j].catalogname+"</option>"
							}
						}	
					}
    			}
    			$("#update_city").html(htmlStr);
    		}
		});
	}
	
}





function ChangeDealersByinfos(){
	var username=$("#username").val();
	var userSpan=$('#usernameType').find("span")
	var usernameType=0;
	for(var i=0;i<userSpan.length;i++){
		var classname=$('#usernameType').find("span:eq("+i+")").prop("class");
		if(classname=="checked"){
			usernameType=$($('#usernameType').find('span').children()[i]).val()
		}
	}
	var cityid=0;
	if($("#main_city").val()==0){
		cityid=$("#main_area").val();
	}else{
		cityid=$("#main_city").val();
	}
	var userType=$("#userType").val();
	var mainBrandid=$("#mainBrandid").val();
	var islast=0;
	if($("#islast").parent().prop("class")=="checked"){
		islast=1;
	}
	
	window.location.href="${admin_che_url}adminche/DealerInfoManager?username="+encodeURI(username)+"&usernameType="+usernameType+"&cityid="+cityid+"&userType="+userType+"&mainBrandid="+mainBrandid+"&islast="+islast;
}


</script>
</body>
</html>