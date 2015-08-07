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
								<i class="fa fa-cogs"></i>经销商信息维护
							</div>
						</div>
						<div class="portlet-body flip-scroll">
							<form id="aaaa" method="post" action="SiteDealerManager">
							<div class="col-md-1">
								<div id="usernameType1" name="usernameType1" class="radio-list">
									<label>
									<input type="radio" name="optionsRadios" id="optionsRadios1" value="0" <#if usernameType==0>checked</#if>>用户名</label>
									<label>
									<input type="radio" name="optionsRadios" id="optionsRadios2" value="1" <#if usernameType==1>checked</#if>>企业名</label>
								</div>
							</div>
							<div class="col-md-1">
								<input name="username" id="username" type="text" class="form-control" <#if username??> value="${username}"</#if>>
							</div>
							<div class="col-md-1">
								<select name="userType" id="userType" class="form-control input-small">
									<option value="0" <#if userType==0>selected</#if>>--企业级别--</option>
									<option value="1" <#if userType==1>selected</#if>>普通会员</option>
									<option value="2" <#if userType==2>selected</#if>>试用会员</option>
									<option value="3" <#if userType==3>selected</#if>>短期会员</option>
								</select>
							</div>
							<div class="col-md-1">
								<select name="mainBrandid" id="mainBrandid" class="form-control input-small">
									<option value="0">--选择品牌--</option>
									<#list brandMap?keys as key>
										<#list brandMap.get(key) as brand>
											<option value="${brand.catalogid}" <#if brand.catalogid?eval==mainBrandid>selected</#if>>${key} ${brand.catalogname}</option>
										</#list>
									</#list>
								</select>
								
							</div>
							<input type="hidden" id="page" name="page" value="${page}">
							<input type="hidden" id="usernameType" name="usernameType" value="${usernameType}">
							<input name="islast" id="islast" type="checkbox" class="group-checkable" <#if islast==1>checked</#if>>已过试用期
							<button type="button" class="btn default" onClick="ChangeDealersByinfos()">搜索</button>
							
							</form>
							
							<table class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
							<tr>
								<th width="6%">
									 用户名
								</th>
								<th width="12%">
									 企业名称
								</th>
								<th class="numeric" width="13%">
									 企业信息
								</th>
								<th class="numeric" width="25%">
									 主营品牌
								</th>
								<th class="numeric" width="25%">
									 品牌渠道
								</th>
								<th class="numeric" width="15%">
									 操作
								</th>
							</tr>
							</thead>
							<tbody>
							<#list dealers as dealer>
								<tr>
									<td>
										 ${dealer.username}
									</td>
									<td>
										 ${dealer.ename}
									</td>
									<td class="numeric">
										公司简称： ${dealer.shortename}；
										企业地域：${dealer.areaName} ； 联系电话： ${dealer.telephone}；企业类型：<#if dealer.is4s=="1">4s店<#else>综合店</#if> ；企业级别： <#if dealer.paylevel=="5"><#if dealer.istmp=="0">短期会员<#else>试用会员</#if><#else>普通会员</#if>；到期时间：${dealer.expirationdate} ；
									</td>
									<td class="numeric">
										 ${dealer.mainBrandName}
									</td>
									<td class="numeric">
										 ${dealer.iway}
									</td>
									<td class="numeric">
										 <button type="button" style="font-size: 12px;" onclick="loginDealer('${dealer.username}',${dealer.paylevel},'${dealer.expirationdate}','${dealer.eid}')" class="btn default">进入后台</button>
									</td>
								</tr>
							</#list>
							</tbody>
							</table>
							<div class="margin-top-20" style="text-align: center;">
								<ul class="pagination"> 
									<li><a href="javascript:void(0);" class="first-btn" title="首页" onclick="toPage(1)">首页</a></li>
									<li><a <#if page-1 gt 0>href="javascript:void(0);" onclick="toPage(${page-1})"</#if> class="prev-btn" title="上一页">上一页</a></li>
									<#list page-2..page-1 as p>
										<#if p gt 0>
											<li><a href="javascript:void(0);" onclick="toPage(${p})">${p}</a></li>
										</#if>
									</#list>
									<li class="active"><a href="javascript:void(0);">${page}</a></li>
									<#list page+1..page+2 as p>
										<#if p lte pages >
											<li><a href="javascript:void(0);" onclick="toPage(${p})">${p}</a></li>
										</#if>
									</#list>
									<li><a <#if page+1 lte pages>href="javascript:void(0);" onclick="toPage(${page+1})"</#if> class="next-btn" title="下一页">下一页</a></li>
									<li><a href="javascript:void(0);" onclick="toPage(${pages})" class="last-btn" title="末页">末页</a></li>
								</ul>
							</div>
						</div>
						</div>
						<input type="hidden" id="hideusername" value="${username?default(' ')}">
		</div>
	</div> 
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
function toPage(id){
	var userSpan=$('#usernameType1').find("span")
	var usernameType=0;
	for(var i=0;i<userSpan.length;i++){
		var classname=$('#usernameType1').find("span:eq("+i+")").prop("class");
		if(classname=="checked"){
			usernameType=$($('#usernameType1').find('span').children()[i]).val()
		}
	}
	$("#usernameType").val(usernameType);
	$("#page").val(id);
	$("#aaaa").submit();
}



function loginDealer(username,paylevel,date,id){
	if(paylevel!=5){
		alert("该用户不是付费用户！");
		return;
	}
	var now=new Date();
	var newstr = date.replace(/-/g,'/'); 
    var enddate =  new Date(newstr); 
	var a = (Date.parse(now) - Date.parse(enddate)) / 3600 / 1000;
    if (a > 0) {
        alert("该用户已过期！");
		return;
    }
	gotodealer(username,id);
}

function gotodealer(name,id){
	var date=new Date(); 
	date.setTime(date.getTime+24*3600*1000); 
	document.cookie="userName="+encodeURI(name)+";path=/;domain=.315che.com;expires="+date.toGMTString();	
	document.cookie="deal_login="+encodeURI(name)+";path=/;domain=.315che.com;expires="+date.toGMTString();	
	document.cookie="viceUserName="+encodeURI(name)+";path=/;domain=.315che.com;expires="+date.toGMTString();
	document.cookie="eid="+id+";path=/;domain=.315che.com;expires="+date.toGMTString();	
	window.open("http://4s.315che.com/admindealer/index");
}

function ChangeDealersByinfos(){
	var userSpan=$('#usernameType1').find("span")
	var usernameType=0;
	for(var i=0;i<userSpan.length;i++){
		var classname=$('#usernameType1').find("span:eq("+i+")").prop("class");
		if(classname=="checked"){
			usernameType=$($('#usernameType1').find('span').children()[i]).val()
		}
	}
	$("#usernameType").val(usernameType);
	$("#aaaa").submit();
	/*var username=$("#username").val();
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
	$.post(
		"DealerInfoManager",
		{username:username,usernameType:usernameType,cityid:cityid,userType:userType,mainBrandid:mainBrandid,islast:islast}
	);*/
}


</script>
</body>
</html>