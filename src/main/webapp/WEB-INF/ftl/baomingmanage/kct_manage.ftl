<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<style>
.data-table1 {border-collapse:collapse; margin-left:15px;}
.data-table1 td {padding:5px;}
</style>
<script src="${admin_che_url}js/qnvfunc.js" type="text/javascript"></script>
<script src="${admin_che_url}js/qnviccub.js" type="text/javascript"></script>
<script type="text/javascript">
window.onunload=function(){TV_Disable();};
window.onload=function(){
TV_Initialize();
//alert(22);
};

</script>
<@c.html_body>
<!--查询选项-->
<div class="row">
<textarea id="StatusArea" rows="13" name="S1" cols="86" style="display: none;"></textarea>
<object classid="clsid:F44CFA19-6B43-45EE-90A3-29AA08000510" id="qnviccub" data="DATA:application/x-oleobject;BASE64,GfpM9ENr7kWQoymqCAAFEAADAAD7FAAADhEAAA==
" width="33" height="33"></object>
<input type="hidden" id="toPhone">
<form method="POST" action = "kctmanage">
<input id="page" name="page" type="hidden" value="${page!"1"}" />
<input id="promo_start_date" name="promo_start_date" type="hidden" value="${promo_start_date!}" />
<input id="promo_end_date" name="promo_end_date" type="hidden" value="${promo_end_date!}" />
<input id="provId" name="provId" type="hidden" value="${provId!}" />
<input id="cityId" name="cityId" type="hidden" value="${cityId!}" />
<input id="brandId" name="brandId" type="hidden" value="${brandId!}" />
<input id="chexiId" name="chexiId" type="hidden" value="${chexiId!}" />
<input id="chexingId" name="chexingId" type="hidden" value="${chexingId!}" />
<input id="competing" name="competing" type="hidden" value="${competing!}" />
<input id="iway2" name="iway2" type="hidden" value="${iway2!}" />
<input id="baomingid" name="baomingid" type="hidden" value="" />
<input id="switchid" type="hidden" value="${switchRadio }" />
<input id="flag" name="flag" type="hidden" value="1" />
 <table class="data-table1">
 	<tr>
 		<td><span id="changetg1">推广编号:</span><span id="changetg2" >推广渠道:</span></td>
 		<td colspan=3><span id="changetgv1">
 			<select class="form-control input-medium input-inline" name="pro_num" id="tuiguang">
 				<#list tuiguangList as tuiguang>
		     	 <option value="${tuiguang.pro_num}"  <#if pro_num == tuiguang.pro_num >selected=true</#if>>${tuiguang.pro_num}</option>
		       </#list>
		     </select>
		     
		     <span id="tgbrandInfo">推广品牌:</span>&nbsp;
		     <span id="tgareaInfo">推广地区:</span>&nbsp;
		     <span id="tgcompetInfo">推广竞品:</span>
		     </span>
		     <span id="changetgv2" > 
		     		<select class="form-control input-medium input-inline" name="iway" id="iway">
		     		<#if iwayList??>
 				<#list iwayList as v_iway>
		     	 <option value="${v_iway.iway}"  <#if iway == v_iway.iway >selected=true</#if>>${v_iway.wayname}&nbsp;${v_iway.iway}</option>
		       </#list>
		       </#if>
		     </select>
		     
		     <select class="form-control input-medium input-inline" name="iserial" id="iserial">
 				
		     </select>
		     	
		      </span>
 		</td>
 		<td><span style="display:none">渠道编号切换:</span></td>
 		<td><span style="display:none">
 		<label  for="changeRaido1"><input type="radio" id="changeRaido1" name="switchRadio" <#if switchRadio == 0>checked="true"</#if> class="checkboxes" value="0">编号查询</label>
		<label  for="changeRaido2"><input type="radio" id="changeRaido2" name="switchRadio" <#if switchRadio == 1>checked="true"</#if> class="checkboxes" value="1">渠道查询</label>
 		<span>
 		</td>
 	</tr>
 	
 	<tr>
 		<td><span>报名时间:</span></td>
 		<td>
 			<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
				<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
				<span class="input-group-btn input-inline">
				<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
				</span>
			</div>
			至
			<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
				<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
				<span class="input-group-btn input-inline">
				<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
				</span>
			</div>
 		</td>
 		
 		<td><span>姓名:</span></td>
 		<td> <input type="text"  class="form-control input-inline input-small " name="name"  value="${name!}"> </td>
 		
 		<td><span>手机:</span></td>
 		<td><input type="text"  class="form-control input-inline input-small " name="phone"  value="${phone!}"></td>
 		
 	</tr>
 	
 	<tr>
 		<td><span>回访状态:</span></td>
 		<td>
 			<label  for="checkboxt1"><input type="radio" id="checkboxt1" name="return_visit_state" class="checkboxes" <#if return_visit_state == 0>checked="true"</#if> value="0" >未回访</label>
 			<label  for="checkboxt2"><input type="radio" id="checkboxt2" name="return_visit_state" class="checkboxes" <#if return_visit_state == 1>checked="true"</#if> value="1">一呼</label>
 			<label  for="checkboxt3"><input type="radio" id="checkboxt3" name="return_visit_state" class="checkboxes" <#if return_visit_state == 2>checked="true"</#if> value="2">二呼</label>
 		</td>
 		
 		<td><span>购车紧急度:</span></td>
 		<td>
 			<select class="form-control input-small" name="buycar_emergency" id="buycar_emergency">
		      	<option value="-1" <#if buycar_emergency==-1>selected=true</#if>>全部</option>
		      	<option value="1" <#if buycar_emergency==1>selected=true</#if>>本周</option>
		      	<option value="2" <#if buycar_emergency==2>selected=true</#if>>两周内</option>
		      	<option value="3" <#if buycar_emergency==3>selected=true</#if>>三个月内</option>
		      	<option value="4" <#if buycar_emergency==4>selected=true</#if>>三个以上</option>
		      	<option value="5" <#if buycar_emergency==5>selected=true</#if>>随时</option>
		     </select>
 		</td>
 		
 	</tr>
 	
 	<tr>
 		<td><span>客户类型:</span></td>
 		<td>
 			<label  for="checkboxt11"><input type="radio" id="checkboxt11" name="is_key_cus" class="checkboxes" <#if is_key_cus ==-1>checked="true"</#if>  value="-1">全部</label>
 			<label  for="checkboxt22"><input type="radio" id="checkboxt22" name="is_key_cus" class="checkboxes" <#if is_key_cus == 1>checked="true"</#if>  value="1">重点客户</label>
 			<label  for="checkboxt33"><input type="radio" id="checkboxt33" name="is_key_cus" class="checkboxes" <#if is_key_cus == 0>checked="true"</#if>  value="0">普通客户</label>
 		</td>
 		
 		<td><span>电话状态:</span></td>
 		<td>
 			<label  for="checkboxt55"><input type="radio" id="checkboxt55" name="phoneerror" class="checkboxes" <#if phoneerror ==0>checked="true"</#if> value="0">全部</label>
 			<label  for="checkboxt44"><input type="radio" id="checkboxt44" name="phoneerror" class="checkboxes" <#if phoneerror ==1>checked="true"</#if> value="1">未接通</label>
 		</td>
 		
 		<td >
 			<button class="btn blue" type="button" id="search" onclick="searchFun()">查询</button>
 		</td>
 	</tr>
 	
 </table>
</form>

</div>
<!--中部水平线-->
<div class="row">
<hr size="30" style="border-bottom: 1px solid #999;"/>
</div>

<!--人数统计-->
<div class="row">
<i class="fa fa-child"></i><strong>&nbsp;&nbsp;&nbsp;人数统计:<font color="red">${count!}</font></strong>&nbsp;&nbsp;&nbsp;
<button class="btn blue" type="button" id="fresh">刷新</button>
<a class="btn blue" data-toggle="modal" href="#showdiv3" onclick="showDiv3()">添加</a>
</div>

<!--人数统计-->
<div class="row">
<div class="portlet box blue" style="margin-left:15px;">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-cogs"></i>报名信息
		</div>
		<div class="tools">
			<a class="collapse" href="javascript:;">
			</a>
		</div>
	</div>
	<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-hover">
				<thead>
				<tr>
					<th>姓名</th>
					<th>电话</th>
					<th>报名时间</th>
					<th>报名地区</th>
					<th>报名车系</th>
					<th>回访记录</th>
					<th>查看详情</th>
				</tr>
				</thead>
				<tbody>
				<#if kctList??>
					<#list kctList as kct>
						<tr id="tr${kct.id! }">
							<td>${kct.name!}</td>
							<td>${kct.phone!}<#if kct.phoneerror_count != '0'>（未接通<span style="color:red;">${kct.phoneerror_count}</span>次）<#else><#if kct.constacterror_count != '0'>（未沟通<span style="color:red;">${kct.constacterror_count}</span>次）</#if></#if></td>
							<td>${kct.baoming_date!}</td>
							<td><span id="td1${kct.id! }">${kct.provName!}</span>&nbsp;<span id="td2${kct.id! }">${kct.cityName!}</span></td>
							<td>${kct.brandName!}&nbsp;${kct.chexiName!}</td>
							<td>${kct.remarks!}</td>
							<td><a class="btn green"  data-toggle="modal" href="#showdiv"  onclick="showDiv(${kct.id!})">查看详情</a></td>
						</tr>
					</#list>
				</#if>
				<tr>
		          <td colspan=7 style="text-align:center;"><@c.calcPageByJs "toPage", page, pages/></td>
		         </tr>
				</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal-scrollable" style="z-index: 10051; display:none" >
<div id="showdiv" class="modal fade in" tabindex="-1" data-width="1250" aria-hidden="false" style="display: block; width: 860px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-body">
		<div class="row" >
			<table class="data-table1"  border="8">
				<tr>
					<td><span style="color:red;">*</span>姓名:</td>
					<td colspan = 3>
						<input type="text"  class="form-control input-inline input-small " name="name" id="tname">&nbsp;
						报名时间:<span id="tdate"></span>&nbsp;
						电话:<span id="tphone"></span> <img src="${admin_che_url}image/call.png" style="cursor: pointer;" alt="先摘起电话话筒，再点击这里拨号" width="20px" onclick="TV_StartDial(0,$('#toPhone').val())"/> <span id="pprov"></span> <span id="pcity"></span>&nbsp;
						IP:<span id="ip"></span>&nbsp;
						<span id="tuisong_flag" style="color:red;"></span><span style="color:red;">经销商</span>
						<a class="btn red" data-toggle="modal" href="#showdiv2" onclick="">删除</a>
					</td>
				</tr>
				
				<tr>
					<td><span style="color:red;">*</span>报名车系:</td>
					<td style="white-space:nowrap;">
						<select class="form-control input-small input-inline" name="brandId" id="pinpai" >
					      <option value="-1">选择品牌</option>
					     </select>
					     
					     <select class="form-control input-medium input-inline" name="chexiId" id="chexi" >
					     <option value="-1">选择车系</option>
					     </select>
						
						<select class="form-control input-medium input-inline" name="chexing" id="chexing" >
					     <option value="-1">选择车型</option>
					     </select>
					     
						
						
					</td>
					
					<td>查看指导价:</td>
					<td>
						<select class="form-control input-medium input-inline" name="baojia" id="baojia" >
					      <option value="">查看指导价</option>
					     </select>
					</td>
					
				</tr>
				
				<tr>
					<td><span style="color:red;">*</span>报名城市:</td>
					<td>
						<select class="form-control input-small input-inline" name="prov" id="prov">
					     <option value="-1">选择地区</option>
					     </select>
					     
					     <select class="form-control input-small input-inline" name="city" id="city" >
					    <option value="-1">选择城市</option>
					     </select>
					     
					     <select class="form-control input-small input-inline" name="area" id="area" >
					       <option value="-1">选择区域</option>
					     </select>
					     <button class="btn green input-inline" type="button" onclick="tuisongjxs();">推送经销商</button>
					</td>
					<td>推送至:</td>
					<td>
						<select class="form-control input-small input-inline" name="tprov" id="tprov" >
					      <option value="-1">选择地区</option>
					     </select>
					     <select class="form-control input-small input-inline" name="tcity" id="tcity" >
					       <option value="-1">选择城市</option>
					     </select>
					     <button class="btn green input-inline" type="button" id="" onclick="tuisongCity();">推送</button>
					</td>
				</tr>
				
				
				<tr>
					<td><span style="color:red;">*</span>电话能否接通:</td>
					<td>
					<label  for="phoneerrorRaido1"><input type="radio" id="phoneerrorRaido1" name="phoneerror1" class="checkboxes" value="0">已接通</label>
					<label  for="phoneerrorRaido2"><input type="radio" id="phoneerrorRaido2" name="phoneerror1" class="checkboxes" value="1">未接通</label>
					</td>
					
					<td>未接通次数</td>
					<td>
					<input id="phoneerror_count" type="hidden" name="phoneerror_count" ></input>
					<input id="ttdate" type="hidden" name="ttdate" ></input>
					<span id="phoneerror_count1" style="color:red;"></span>次
					</td>
					
			   </tr>
			   
			   <tr>
					<td><span style="color:red;">*</span>沟通情况:</td>
					<td>
					<label  for="constacterrorRaido1"><input type="radio" id="constacterrorRaido1" name="constacterror1" class="checkboxes" value="0">已沟通</label>
					<label  for="constacterrorRaido2"><input type="radio" id="constacterrorRaido2" name="constacterror1" class="checkboxes" value="1">未沟通</label>
					<label  for="constacterrorRaido3"><input type="radio" id="constacterrorRaido3" name="constacterror1" class="checkboxes" value="2">需要再次回访</label>
					</td>
					
					<td>未沟通次数</td>
					<td>
					<input id="constacterror_count" type="hidden" name="constacterror_count" ></input>
					<span id="constacterror_count1" style="color:red;"></span>次
					</td>
					
			   </tr>
				
				<tr>
					<td><span id="bianse1" style="color:red;">*</span>手机状态:</td>
					<td>
					<label  for="phoneRaido1"><input type="radio" id="phoneRaido1" name="phoneState" class="checkboxes" value="0">有效</label>
					<label  for="phoneRaido2"><input type="radio" id="phoneRaido2" name="phoneState" class="checkboxes" value="1">无效</label>
					</td>
					
					<td><span id="bianse2" style="color:red;">*</span>客户类型:</td>
					<td>
					<label  for="cusRaido1"><input type="radio" id="cusRaido1" name="is_key_cus1" class="checkboxes" value="0">普通客户</label>
					<label  for="cusRaido2"><input type="radio" id="cusRaido2" name="is_key_cus1" class="checkboxes" value="1">重点客户</label>
					</td>
					
			   </tr>
			   
			   <tr>
					<td><span id="bianse3" style="color:red;">*</span>购车紧急度:</td>
					<td>
						<label  for="buycarRadio1"><input type="radio" id="buycarRadio1" name="buycar_emergency1" class="checkboxes" value="1">本周</label>
						<label  for="buycarRadio2"><input type="radio" id="buycarRadio2" name="buycar_emergency1" class="checkboxes" value="2">两周内</label>
						<label  for="buycarRadio3"><input type="radio" id="buycarRadio3" name="buycar_emergency1" class="checkboxes" value="3">一个月内</label>
						<label  for="buycarRadio4"><input type="radio" id="buycarRadio4" name="buycar_emergency1" class="checkboxes" value="4">三个月内</label>
						<label  for="buycarRadio5"><input type="radio" id="buycarRadio5" name="buycar_emergency1" class="checkboxes" value="5">三个以上</label>
						<label  for="buycarRadio6"><input type="radio" id="buycarRadio6" name="buycar_emergency1" class="checkboxes" value="6">随时</label>
					</td>
					
					<td style="white-space:nowrap;"><span id="bianse4" style="color:red;">*</span>确认参加:</td>
					
					<td style="white-space:nowrap;">
						<select class="form-control input-medium input-inline" name="attend_type" id="attend_type" >
						<option value="0">请选择</option>
					      <option value="1">参加-跟团到</option>
					      <option value="2">参加，自行到</option>
					       <option value="3">参加，不确定</option>
					       <option value="4">可能参加</option>
					        <option value="5">不参加</option>
					     </select>
					     <div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
							<input type="text"  class="form-control input-small input-inline" name="attend_date" id="attend_date" value="">
							<span class="input-group-btn input-inline">
							<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
							</span>
						</div>
					</td>
					
					
			   </tr>
			   
			   <tr>
					
					<td>切换拍牌城市:</td>
					
					<td>
						<select class="form-control input-small input-inline" name="pz_city" id="pz_city" >
							<option value="">请选择</option>
					        <option value="上海">上海</option>
					        <option value="北京">北京</option>
					        <option value="杭州">杭州</option>
					        <option value="广州">广州</option>
					        <option value="深圳">深圳</option>
					        <option value="其他">其他</option>
					     </select>
					     
					</td>
					<td>拍牌状态:</td>
					<td>
						<select class="form-control input-small input-inline" name="pp_state" id="pp_state" >
						  <option value="">请选择</option>
					     
					     </select>
					</td>

			   </tr>
			   
			    <tr>
					<td>是否有竞品:</td>
					<td>
						<label  for="jpradio1"><input type="radio" id="jpradio1" name="jpstate" class="checkboxes" value="0">否</label>
						<label  for="jpradio2"><input type="radio" id="jpradio2" name="jpstate" class="checkboxes" value="1">是</label>
						&nbsp;&nbsp;
						竞品车系:<input type="text"  class="form-control input-inline" name="jpchexi" id="jpchexi">&nbsp;
					</td>
					
					<td><span id="bianse5" style="color:red;">*</span>回访状态:</td>
					<td>
			 			<label  for="hfradio1"><input type="radio" id="hfradio1" name="hfstate" class="checkboxes" value = "1">一呼</label>
			 			<label  for="hfradio2"><input type="radio" id="hfradio2" name="hfstate" class="checkboxes" value = "2">二呼</label>
			 			
					</td>
					
				</tr>
				
				<tr>
					<td><span id="bianse6" style="color:red;">*</span>购车信息:</td>
					<td >
						<label  for="gcradio1"><input type="radio" id="gcradio1" name="gcxinxi" class="checkboxes" value="0">未购车</label>
						<label  for="gcradio2"><input type="radio" id="gcradio2" name="gcxinxi" class="checkboxes" value="1">已购车</label>
						
					</td>
					
					<td>购车情况:</td>
					<td>
						<label  for="gcqkradio1"><input type="radio" id="gcqkradio1" name="gcstate" class="checkboxes" value="0">新车全款</label>
						<label  for="gcqkradio2"><input type="radio" id="gcqkradio2" name="gcstate" class="checkboxes" value="1">新车贷款</label>
						<label  for="gcqkradio3"><input type="radio" id="gcqkradio3" name="gcstate" class="checkboxes" value="2">置换全款</label>
						<label  for="gcqkradio4"><input type="radio" id="gcqkradio4" name="gcstate" class="checkboxes" value="3">增购贷款</label>
					</td>
					
				</tr>
				
				<tr>
					<td>购车预算:</td>
					<td colspan=3>
						<input type="text"  class="form-control input-inline input-small " name="buy_ys" id="buy_ys">
						&nbsp;&nbsp;变速箱:&nbsp;&nbsp;
						<label  for="bsxradio1"><input type="radio" id="bsxradio1" name="bsxtype" class="checkboxes" value="0">自动</label>
						<label  for="bsxradio2"><input type="radio" id="bsxradio2" name="bsxtype" class="checkboxes" value="1">手动</label>
						<label  for="bsxradio3"><input type="radio" id="bsxradio3" name="bsxtype" class="checkboxes" value="2">不限</label>
						&nbsp;&nbsp;排量:&nbsp;&nbsp;
						<input type="text"  class="form-control input-inline input-small " name="buy_pl" id="buy_pl">
						&nbsp;&nbsp;颜色:&nbsp;&nbsp;
						<input type="text"  class="form-control input-inline input-small " name="buy_color" id="buy_color">
					</td>
					
					
					
				</tr>
				
				
			   
			   	<tr>
					<td>4S了解优惠:</td>
					<td >
						<textarea rows="2" class="form-control" id="know_yh" name="know_yh"></textarea>
					</td>
					
					<td>个人信息:</td>
					<td>
						职业:
						&nbsp;&nbsp;
						<label  for="zyradio1"><input type="radio" id="zyradio1" name="zyxinxi" class="checkboxes" value="0">国企</label>
						<label  for="zyradio2"><input type="radio" id="zyradio2" name="zyxinxi" class="checkboxes" value="1">私企</label>
						<label  for="zyradio3"><input type="radio" id="zyradio3" name="zyxinxi" class="checkboxes" value="2">个体</label>
						<br>
						微信:
						&nbsp;&nbsp;
						<input type="text"  class="form-control input-inline input-small " name="p_weixin" id="p_weixin">
						&nbsp;&nbsp;
						QQ:
						&nbsp;&nbsp;
						<input type="text"  class="form-control input-inline input-small " name="p_qq" id="p_qq">
						
					</td>
					
				</tr>	
				
				
				
					
				
				<tr>
					<td>回访历史:</td>
					<td colspan = 3>
						<input type="hidden" name="tusong" id="tusong"></input>
						<input type="hidden" name="ttphone" id="ttphone"></input>
						<input type="hidden" name="remarks" id="remarks"></input>
						
						<div id="remarkss" name="remarkss" style="height:80px; overflow-y: auto; overflow-x: hidden;"></div>
						
					</td>
				</tr>
				
				<tr>
					<td><span id="bianse7" style="color:red;">*</span>回访记录:</td>
					<td colspan = 3>
						<textarea rows="3" class="form-control" id="content" name="content"></textarea>
					</td>
				</tr>	
				
				<tr>
					<td colspan = 4 style="text-align:center;">
						<button class="btn green btn-lg" type="button" id="saveyifang">提交 </button>
						<button class="btn green btn-lg" type="button" data-dismiss="modal" id="close1">取消 </button>
					</td>
				</tr>				
			   
			   
			</table>
		</div>
		
		<div class="modal-scrollable" style="z-index: 10051; display:none" >
		<div id="showdiv2" class="modal fade in" tabindex="-1" data-width="520" aria-hidden="false" style="display: block; width: 460px; margin-left: -379px; margin-top: -248px;">
		<div class="modal-body">
			<div class="row" >
				<table class="data-table1"  border="8" width = "500px">
					<tr>
						<td>请填写删除理由:</td>
						<td><textarea rows="4" class="form-control" id="shanchucontent"></textarea></td>
					</tr>
					
					<tr>
						<td colspan=2 style="text-align:center;">
						<button class="btn red btn-lg" type="button" id="shachu">删除 </button>
						&nbsp;&nbsp;
						<button class="btn green btn-lg" type="button" data-dismiss="modal" id="close2">取消 </button>
						</td>
					</tr>
					
				</table>
			</div>
		
		</div>
	</div>
	
	
	<div class="modal-scrollable" style="z-index: 10051; display:none" >
	<div id="showdiv3" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>添加报名</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<input type="text" value="Test" id="carid2" style="display:none">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">报名渠道:</td>
							<td class="col-md-9 sorting_1">
							<select class="form-control input-medium input-sm" name="type" id="type2x">
								
		                          <option value="0">看车团</option> 
		                          <option value="1">直销</option>
		                          <option value="2">车展</option>
		                          <option value="3">大客户</option>
		                       
		                      
							</select>
							</td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">客户姓名:</td>
							<td class="col-md-9 sorting_1">
							<input type="text" id = "name2x" class="form-control input-inline input-medium" >
							</td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">客户电话:</td>
							<td class="col-md-9 sorting_1">
							<input type="text" id = "phone2x" class="form-control input-inline input-medium" >
							</td>
						</tr>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">地区</td>
							<td class="col-md-9 sorting_1">
							<select class="form-control input-medium input-sm" id="prov2x">
								<option value="-1">请选择省份</option>
							</select>
							<select class="form-control input-medium input-sm" id="city2x">
								<option value="-1">请选择城市</option>
							</select>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">品牌:</td>
							<td class="col-md-9 sorting_1">
							<select class="form-control input-medium input-sm" id="pinpai2x">
								<option value="-1">请选择品牌</option>
							</select>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">车系:</td>
							<td class="col-md-9 sorting_1">
							<select class="form-control input-medium input-sm" id="xilie2x">
								<option value="-1">起选择车系</option>
							</select>
							</td>
						</tr>
						
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">车型:</td>
							<td class="col-md-9 sorting_1">
							<select class="form-control input-medium input-sm" id="modelid2x">
								<option value="-1">起选择车型</option>
							</select>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default" id="close3">关闭</button>
		<button type="button" class="btn blue" id="add">添加</button>
	</div>
</div>
	
</div>


</@c.html_body>

<@c.html_js></@c.html_js>
<script type="text/javascript">
/*
$(function(){
	var winH = $(window).height();
	$(".modal-body").css({
		"height":winH+"px",
		"overflow-y":"auto"
	});
});
*/
$(document).ready(function(){ 

var tid = $("#tuiguang").children('option:selected').val();
choseTuiguang(tid);
$("#tuiguang").change(function(){	
	var tuiguangId = $(this).children('option:selected').val();
	choseTuiguang(tuiguangId);
});




}); 


$("#fresh").on("click", function() {
	searchFun();

});


var switchvar = ${switchRadio };
if(switchvar == 0){
	$("#changetg1").show();
	$("#changetgv1").show();
	$("#changetg2").hide();
	$("#changetgv2").hide();
	getCarsx();
}else{
$("#changetg1").hide();
	$("#changetgv1").hide();
	$("#changetg2").show();
	$("#changetgv2").show();
	getCarsx();
}

function getCarsx(){

var iway = $("#iway").val();

$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(iway)},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==${iserial!})
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#iserial").append(html);
				}
    		}
		});
}

$("#iway").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#iserial").empty();
		
		$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#iserial").append(html);
				}
    		}
		});
	
	});

$("#changeRaido1").click(function(){
	$("#changetg1").show();
	$("#changetgv1").show();
	$("#changetg2").hide();
	$("#changetgv2").hide();

});

$("#changeRaido2").click(function(){
	$("#changetg1").hide();
	$("#changetgv1").hide();
	$("#changetg2").show();
	$("#changetgv2").show();

});


function yinc(){
	$("#bianse1").hide();
	$("#bianse2").hide();
	$("#bianse3").hide();
	$("#bianse4").hide();
	$("#bianse5").hide();
	$("#bianse6").hide();
	$("#bianse7").hide();


}


function xians(){

	$("#bianse1").show();
	$("#bianse2").show();
	$("#bianse3").show();
	$("#bianse4").show();
	$("#bianse5").show();
	$("#bianse6").show();
	$("#bianse7").show();

}

$("#phoneerrorRaido1").click(function(){
	xians();

});

$("#phoneerrorRaido2").click(function(){
	yinc();

});


function searchFun(){
	$("#page").val(1);
	//document.forms[0].action = "kctmanage";
	document.forms[0].submit();
}
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	//document.forms[0].action = "kctmanage";
	document.forms[0].submit();
}
//
function  choseTuiguang(tuiguangId){
	var tuiguangList = eval('${tuiguangListStr!}');
	for(var i = 0 ;i<tuiguangList.length;i++){
		var tgid = tuiguangList[i].pro_num;
		if(tuiguangId == tgid){
			$("#tgbrandInfo").html("推广品牌:"+tuiguangList[i].brandName+" "+tuiguangList[i].chexiName+" "+tuiguangList[i].chexingName);
			$("#tgareaInfo").html("推广地区:"+tuiguangList[i].provName+" "+tuiguangList[i].cityName);
			$("#tgcompetInfo").html("推广竞品:"+tuiguangList[i].competing_name);
			$("#provId").attr("value",tuiguangList[i].provId);
			$("#cityId").attr("value",tuiguangList[i].cityId);
			$("#brandId").attr("value",tuiguangList[i].brandId);
			$("#chexiId").attr("value",tuiguangList[i].chexiId);
			$("#chexingId").attr("value",tuiguangList[i].chexingId);
			$("#promo_start_date").attr("value",tuiguangList[i].promo_start_date);
			$("#promo_end_date").attr("value",tuiguangList[i].promo_end_date);
			$("#competing").attr("value",tuiguangList[i].competing);
			$("#iway2").attr("value",tuiguangList[i].iway);
	}
}
}


function showDiv3(){

	$("#type2x").val('0');
	$("#name2x").val('');
	$("#phone2x").val('');
	$("#prov2x").val('-1');
	$("#city2x").val('-1');
	$("#pinpai2x").val('-1');
	$("#xilie2x").val('-1');
	$("#modelid2x").val('-1');
	

}

$("#add").click(function(){
var type = $("#type2x option:selected").val();
var name = $("#name2x").val();
var phone = $("#phone2x").val();
var prov = $("#prov2x option:selected").val();
var city = $("#city2x option:selected").val();
var brand = $("#pinpai2x option:selected").val();
var chexi = $("#xilie2x option:selected").val();
var chexing = $("#modelid2x option:selected").val();
if($.trim(name)=="")
{
	alert("请输入姓名!");
	return ;
}
if($.trim(phone)=="")
{
	alert("请输入电话!");
	return ;
}
var reg=/^(13[0-9]|14[0|1|2|3|4|5|6|7|8|9]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|4|5|6|7|8|9]|17[0-9])\d{8}$/;
			if(!reg.test(phone)){
				alert("电话号码输入错误！");
				return;
			}
if(prov==-1)
{
	alert("请选择地区!");
	return ;
}
if(brand==-1)
{
	alert("请选择品牌!");
	return ;
}
if(chexi==-1)
{
	alert("请选择车系!");
	return ;
}

$.post(
	"addBaoming",
	{type:type,name:name,phone:phone,pinpai:brand,chexi:chexi,prov:prov,city:city,model:chexing},
	function(data){
			if(data==1)
			{
				alert("添加成功!");
				$("#close3").trigger("click")
			}
			else
			{
				alert("添加失败!");
			}
	}
);
});


function showDiv(baomingid){
			$("#shanchucontent").val('');
    		$("#content").val('');
    		$("#cusRaido1").attr("checked",false).uniform(); 
    		$("#cusRaido2").attr("checked",false).uniform(); 
    		$("#buycarRadio1").attr("checked",false).uniform(); 
    		$("#buycarRadio2").attr("checked",false).uniform(); 
    		$("#buycarRadio3").attr("checked",false).uniform(); 
    		$("#buycarRadio4").attr("checked",false).uniform(); 
    		$("#buycarRadio5").attr("checked",false).uniform(); 
    		$("#buycarRadio6").attr("checked",false).uniform(); 
    		$("#phoneRaido1").attr("checked",false).uniform();
    		$("#phoneRaido2").attr("checked",false).uniform();
    		
    		$("#hfradio1").attr("checked",false).uniform(); 
    		$("#hfradio2").attr("checked",false).uniform(); 
    		$("#jpradio1").attr("checked",false).uniform(); 
    		$("#jpradio2").attr("checked",false).uniform(); 
    		$("#gcradio1").attr("checked",false).uniform(); 
    		$("#gcradio2").attr("checked",false).uniform(); 
    		$("#gcqkradio1").attr("checked",false).uniform();
    		$("#gcqkradio2").attr("checked",false).uniform();
    		$("#gcqkradio3").attr("checked",false).uniform();
    		$("#gcqkradio4").attr("checked",false).uniform();
    		$("#bsxradio1").attr("checked",false).uniform(); 
    		$("#bsxradio2").attr("checked",false).uniform(); 
    		$("#bsxradio3").attr("checked",false).uniform(); 
    		$("#zyradio1").attr("checked",false).uniform(); 
    		$("#zyradio2").attr("checked",false).uniform(); 
    		$("#zyradio3").attr("checked",false).uniform(); 
    		$("#phoneerrorRaido1").attr("checked",false).uniform(); 
    		$("#phoneerrorRaido2").attr("checked",false).uniform(); 
    		$("#constacterrorRaido1").attr("checked",false).uniform(); 
    		$("#constacterrorRaido2").attr("checked",false).uniform(); 
    		$("#constacterrorRaido3").attr("checked",false).uniform(); 
    		
    		$("#tprov").val('-1');
    		$("#tcity").empty();
			$("#tcity").append("<option value='-1'>请选择城市</option>");
    		
    		
    		
    		
	$.ajax({
		url : 'kctmanageDetail?baomingid='+baomingid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		var res = data[0];
    		
    		var phonex = res.phone;
    		var areax = res.pprov;
    		var headx = areax.indexOf("上海")?"17909":"";
    		var toPhone ="0"+headx+phonex;
    		$("#toPhone").prop("value",toPhone);
    		
    		if('0' == res.tuisong_flag){
    			$("#tuisong_flag").text("未推送");
    			
    		}else{
    			$("#tuisong_flag").text("已推送");
    		}
    		$("#tusong").val(res.tuisong_flag);
    		
    		$("#baomingid").val(res.id);
    		$("#tname").val(res.name);
    		$("#ttphone").val(res.phone);
    		$("#tdate").text(res.tdate);
    		$("#ttdate").val(res.tdate);
    		
    		var ycphone = res.phone;
    		var mphone =ycphone.substr(3,4);
    		var lphone = ycphone.replace(mphone,"****");
    		
    		$("#tphone").text(lphone);
    		$("#pprov").text(res.pprov);
    		$("#pcity").text(res.pcity);
    		
    		$("#pinpai").empty();
			$("#pinpai").append("<option value='-1'>请选择品牌</option>");
			$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){	
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
					if(carBrand[i].iway==res.iway)
						html='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
				}
    		}
			});
    		
    		$("#chexi").empty();
			$("#chexi").append("<option value='-1'>请选择车系</option>");
			$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(res.iway)},
    		jsonp:'jsonpcallback',
    		success : function(data1){
    			//alert("success");
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==res.serial)
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexi").append(html);
				}
    		}
		});
    		
    		//getBrand(res.brand);
    		//getChexi(res.brand,res.serial);
    		getChexing(res.serial,res.model);
    		getProv(res.prov);
    		getCity(res.prov,res.city);
    		getArea(res.city,res.area);
    		getBaojia(res.serial);
    		$("#ip").text(res.ip);
    		if(res.is_key_cus == '0'){
    			$("#cusRaido1").attr("checked",true).uniform(); 
    		}
    		if(res.is_key_cus == '1'){
    			$("#cusRaido2").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '1'){
    			$("#buycarRadio1").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '2'){
    			$("#buycarRadio2").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '3'){
    			$("#buycarRadio3").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '4'){
    			$("#buycarRadio4").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '5'){
    			$("#buycarRadio5").attr("checked",true).uniform(); 
    		}
    		if(res.buycar_emergency == '6'){
    			$("#buycarRadio6").attr("checked",true).uniform(); 
    		}
    		
    		if(res.phone_state == '0' || res.phone_state == '2'){
    			$("#phoneRaido1").attr("checked",true).uniform(); 
    		}
    		if(res.phone_state == '1'){
    			$("#phoneRaido2").attr("checked",true).uniform(); 
    		}
    		
    		
    		if(res.attend_type == '0'){
    			$("#attend_type").val(3); 
    		}else{
    			$("#attend_type").val(res.attend_type); 
    		}
    		
    		$("#attend_date").val(res.attend_date); 
    		
    		
    		if(res.return_visit_state == '1'){
				$("#hfradio1").attr("checked",true).uniform(); 
			}
    		
    		if(res.return_visit_state == '2'){
				$("#hfradio2").attr("checked",true).uniform(); 
			}
    		
    		if(res.is_jp == '0'){
				$("#jpradio1").attr("checked",true).uniform(); 
			}
    		
    		if(res.is_jp == '1'){
				$("#jpradio2").attr("checked",true).uniform(); 
			}
    		
    		$("#jpchexi").val(res.jp_car); 
    		
    		if(res.is_buycar == '0'){
    			$("#gcradio1").attr("checked",true).uniform(); 
    		}
    		if(res.is_buycar == '1'){
    			$("#gcradio2").attr("checked",true).uniform(); 
    		}
    		
    		
    		
    		if(res.buy_state == '0'){
    			$("#gcqkradio1").attr("checked",true).uniform(); 
    		}
    		if(res.buy_state == '1'){
    			$("#gcqkradio2").attr("checked",true).uniform(); 
    		}
    		if(res.buy_state == '2'){
    			$("#gcqkradio3").attr("checked",true).uniform(); 
    		}
    		if(res.buy_state == '3'){
    			$("#gcqkradio4").attr("checked",true).uniform(); 
    		}
    		
    		$("#buy_ys").val(res.buy_ys); 
    		
    		if(res.buy_bsx == '0'){
    			$("#bsxradio1").attr("checked",true).uniform(); 
    		}
    		if(res.buy_bsx == '1'){
    			$("#bsxradio2").attr("checked",true).uniform(); 
    		}
    		if(res.buy_bsx == '2'){
    			$("#bsxradio3").attr("checked",true).uniform(); 
    		}
    		
    		$("#buy_pl").val(res.buy_pl); 
    		$("#buy_color").val(res.buy_color); 
    		$("#know_yh").val(res.know_yh); 
    		
    		if(res.p_job == '0'){
    			$("#zyradio1").attr("checked",true).uniform(); 
    		}
    		if(res.p_job == '1'){
    			$("#zyradio2").attr("checked",true).uniform(); 
    		}
    		if(res.p_job == '2'){
    			$("#zyradio3").attr("checked",true).uniform(); 
    		}
    		
    		$("#p_weixin").val(res.p_weixin); 
    		$("#p_qq").val(res.p_qq); 
    		$("#remarks").val(res.remarks);
    		$("#remarkss").html(res.remarksNew);
    		$("#phoneerror_count").val(res.phoneerror_count);
    		$("#phoneerror_count1").text(res.phoneerror_count);
    		$("#constacterror_count").val(res.constacterror_count);
    		$("#constacterror_count1").text(res.constacterror_count);
    		
    		if(res.phoneerror == '0'){
    			//$("#phoneerrorRaido1").attr("checked",true).uniform(); 
    			xians();
    			
    		}
    		if(res.phoneerror == '1'){
    			//$("#phoneerrorRaido2").attr("checked",true).uniform(); 
    			yinc();
    		}
    		
    		if(res.constacterror == '0'){
    			//$("#constacterrorRaido1").attr("checked",true).uniform(); 
    		}
    		if(res.constacterror == '1'){
    			$("#constacterrorRaido2").attr("checked",true).uniform(); 
    		}
    		if(res.constacterror == '2'){
    			$("#constacterrorRaido3").attr("checked",true).uniform(); 
    		}
    		
    		
    		if(res.pz_city != ''  ){
	    		getPzcity(res.pz_city);
	    		getPstate(res.pz_city,res.pp_state);
    		}else{
    			if(res.prov == 1){
    				getPzcity('北京');
	    			getPstate('北京','');
    			} else if(res.prov == 9){
    				getPzcity('上海');
	    			getPstate('上海','');
    			}else if(res.city == 299){
    				getPzcity('广州');
	    			getPstate('广州','');
    			}else if(res.prov == 175){
    				getPzcity('杭州');
	    			getPstate('杭州','');
    			}else if(res.prov == 300){
    				getPzcity('深圳');
	    			getPstate('深圳','');
    			}else{
    				getPzcity('其他');
	    			getPstate('其他','');
    			}
    		}
    	}
	});

}

function getPzcity(pzcity){
	var html ='';
	$("#pz_city").empty();
	$("#pz_city").append("<option value=''>请选择</option>");
	if(pzcity == '上海'){
		html = '<option value="上海"  selected = "true" >上海</option><option value="北京" >北京</option><option value="杭州" >杭州</option><option value="广州" >广州</option><option value="深圳" >深圳</option><option value="其他" >其他</option>';
	}else if(pzcity == '北京'){
		html = '<option value="上海"   >上海</option><option value="北京" selected = "true">北京</option><option value="杭州" >杭州</option><option value="广州" >广州</option><option value="深圳" >深圳</option><option value="其他" >其他</option>';
	}else if(pzcity == '杭州'){
		html = '<option value="上海"   >上海</option><option value="北京">北京</option><option value="杭州" selected = "true">杭州</option><option value="广州" >广州</option><option value="深圳" >深圳</option><option value="其他" >其他</option>';
	}else if(pzcity == '广州'){
		html = '<option value="上海"   >上海</option><option value="北京">北京</option><option value="杭州" >杭州</option><option value="广州" selected = "true">广州</option><option value="深圳" >深圳</option><option value="其他" >其他</option>';
	}else if(pzcity == '深圳'){
		html = '<option value="上海"   >上海</option><option value="北京">北京</option><option value="杭州" >杭州</option><option value="广州" >广州</option><option value="深圳" selected = "true">深圳</option><option value="其他" >其他</option>';
	}else if(pzcity == '其他'){
		html = '<option value="上海"   >上海</option><option value="北京">北京</option><option value="杭州" >杭州</option><option value="广州" >广州</option><option value="深圳" >深圳</option><option value="其他" selected = "true">其他</option>';
	}
	$("#pz_city").append(html);
}


function getPstate(pzcity,ppstate){
	var html ='';
	$("#pp_state").empty();
	$("#pp_state").append("<option value=''>请选择</option>");
	if(pzcity == '上海'){
		
		if(ppstate == '已拍'){
			html = ' <option value="已拍"  selected = "true" >已拍</option><option value="在拍" >在拍</option><option value="沪C">沪C</option><option value="外牌">外牌</option><option value="随时" >随时</option>';
		}else if(ppstate == '在拍'){
		html = ' <option value="已拍"  >已拍</option><option value="在拍" selected = "true" >在拍</option><option value="沪C">沪C</option><option value="外牌">外牌</option><option value="随时" >随时</option>';
		
		}else if(ppstate == '沪C'){
		html = ' <option value="已拍"  >已拍</option><option value="在拍" >在拍</option><option value="沪C" selected = "true" >沪C</option><option value="外牌">外牌</option><option value="随时" >随时</option>';
		}else if(ppstate == '外牌'){
		html = ' <option value="已拍"  >已拍</option><option value="在拍" >在拍</option><option value="沪C">沪C</option><option value="外牌" selected = "true" >外牌</option><option value="随时" >随时</option>';
		}else if(ppstate == '随时'){
		html = ' <option value="已拍"   >已拍</option><option value="在拍" >在拍</option><option value="沪C">沪C</option><option value="外牌">外牌</option><option value="随时" selected = "true">随时</option>';
		}else{
		html = ' <option value="已拍" >已拍</option><option value="在拍" >在拍</option><option value="沪C">沪C</option><option value="外牌">外牌</option><option value="随时" >随时</option>';
		}
		$("#pp_state").append(html);
	}
	
	if(pzcity == '北京'){
		
		if(ppstate == '已摇到'){
			html = ' <option value="已摇到 "  selected = "true" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '在摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" selected = "true" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		
		}else if(ppstate == '未摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇" selected = "true" >未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '外牌'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌" selected = "true" >外牌</option>';
		}else{
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}
		$("#pp_state").append(html);
	}
	
	if(pzcity == '广州'){
		
		if(ppstate == '已摇到'){
			html = ' <option value="已摇到 "  selected = "true" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '在摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" selected = "true" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		
		}else if(ppstate == '未摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇" selected = "true" >未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '外牌'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌" selected = "true" >外牌</option>';
		}else{
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}
		$("#pp_state").append(html);
	}
	
	if(pzcity == '杭州'){
		
		if(ppstate == '已摇到'){
			html = ' <option value="已摇到 "  selected = "true" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '在摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" selected = "true" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		
		}else if(ppstate == '未摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇" selected = "true" >未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '外牌'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌" selected = "true" >外牌</option>';
		}else{
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}
		$("#pp_state").append(html);
	}
	
	if(pzcity == '深圳'){
		
		if(ppstate == '已摇到'){
			html = ' <option value="已摇到 "  selected = "true" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '在摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" selected = "true" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		
		}else if(ppstate == '未摇'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇" selected = "true" >未摇</option><option value="外牌">外牌</option>';
		}else if(ppstate == '外牌'){
		html = ' <option value="已摇到"  >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌" selected = "true" >外牌</option>';
		}else{
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
		}
		$("#pp_state").append(html);
	}
	
	if(pzcity == '其他'){
		
		if(ppstate == '外牌'){
		html = ' <option value="本地" >本地</option><option value="外牌" selected = "true" >外牌</option>';
		}else if(ppstate == '本地'){
		html = ' <option value="本地" selected = "true">本地</option><option value="外牌">外牌</option>';
		}else{
		html = ' <option value="本地" >本地</option><option value="外牌">外牌</option>';
		}
		$("#pp_state").append(html);
	}

}


$("#pz_city").change(function(){	
	var html ='';
	var fatherid = $(this).children('option:selected').val();
	$("#pp_state").empty();
	$("#pp_state").append("<option value=''>请选择</option>");
	if(fatherid == '上海'){
		html = ' <option value="已拍" >已拍</option><option value="在拍" >在拍</option><option value="沪C">沪C</option><option value="外牌">外牌</option><option value="随时" >随时</option>';
	}
	if(fatherid == '北京'){
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
	}
	if(fatherid == '广州'){
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
	}
	if(fatherid == '杭州'){
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
	}
	if(fatherid == '深圳'){
		html = ' <option value="已摇到" >已摇到</option><option value="在摇" >在摇</option><option value="未摇">未摇</option><option value="外牌">外牌</option>';
	}
	if(fatherid == '其他'){
		html = ' <option value="本地" >本地</option><option value="外牌">外牌</option>';
	}
	
	$("#pp_state").append(html);
});



function getProv(provId){

$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==provId)
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov").append(html);
					
				}
    		}
		});
}

function getCity(provId,cityId){


	$("#city").empty();
	$("#city").append("<option value='-1'>请选择城市</option>");

		
$.ajax({
    		url : 'getCityInfo?city='+provId,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==cityId){
					//alert(city[i].catalogid);
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
						}
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city").append(html);
				}
    		}
		});
		
}




function getProv2(provId,id){
	
$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==provId){
						var str = "";
						str = city[i].catalogname;
						$("#td1"+id).html(str);
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
						}else{
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
						}
					$("#prov").append(html);
					
				}
    		}
		});
		
		
}

function getCity2(provId,cityId,id){
	
if(cityId == '-1'){
	$("#city").empty();
		$("#city").append("<option value='-1'>请选择城市</option>");
		$("#td2"+id).html('');
}
		
$.ajax({
    		url : 'getCityInfo?city='+provId,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==cityId){
						var str = "";
						str = city[i].catalogname;
						$("#td2"+id).html(str);
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
						}
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city").append(html);
				}
    		}
		});
		
		
}



		
$("#prov").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city").empty();
		$("#city").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city").append(html);
				}
    		}
		});
	
	});


function getArea(cityid ,areaid){
$("#area").empty();
$("#area").append("<option value='-1'>请选择区域</option>");
$.ajax({
    		url : 'getAreaByCityId?city='+cityid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
				    var html ='';
					if(carBrand[i].city==areaid){
						html ='<option selected="true" value='+carBrand[i].city+'>'+carBrand[i].area+'</option>';
					}else{
						html ='<option value='+carBrand[i].city+'>'+carBrand[i].area+'</option>';
					}
					$("#area").append(html);
				}
    		}
		});

}

$("#city").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#area").empty();
		$("#area").append("<option value='-1'>请选择区域</option>");
		$.ajax({
    		url : 'getAreaByCityId?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].city+'>'+carBrand[i].area+'</option>';
					$("#area").append(html);
				}
    		}
		});
	
	});





$.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#tprov").append(html);
					$("#prov2x").append(html);
					
				}
    		}
		});

$("#prov2x").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city2x").empty();
		$("#city2x").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city2x").append(html);
				}
    		}
		});
	
	});


$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){	
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai2x").append(html);
				}
    		}
});

$("#pinpai2x").change(function(){	
	var fatherid = $(this).children('option:selected').val();

		$("#xilie2x").empty();
		$("#xilie2x").append("<option value='-1'>请选择系列</option>");
		$("#modelid2x").empty();
		$("#modelid2x").append("<option value='-1'>请选择车型</option>")
		$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#xilie2x").append(html);
				}
    		}
		});
	
	});

$("#xilie2x").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#modelid2x").empty();
		$("#modelid2x").append("<option value='-1'>请选择系列</option>")
		$.ajax({
    		url : 'getCars2x?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#modelid2x").append(html);
				}
    		}
		});
	
	})


$("#tprov").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#tcity").empty();
		$("#tcity").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#tcity").append(html);
				}
    		}
		});
	
	});


function getBrand(brandId){
$.ajax({
		url : 'queryCarInfo?fatherid=0',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==brandId)
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#pinpai").append(html);
				
			}
		}
});
}

function getChexi(brandId,chexiId){
		$("#chexi").empty();
		$("#chexi").append("<option value='-1'>请选择系列</option>");
$.ajax({
		url : 'queryCarInfo?fatherid='+brandId,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==chexiId)
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#chexi").append(html);
				
			}
		}
});
}

function getChexing(chexiId,chexingId){
		$("#chexing").empty();
		$("#chexing").append("<option value='-1'>请选择车型</option>");
$.ajax({
		url : 'queryCarInfo?fatherid='+chexiId,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				if(city[i].catalogid==chexingId)
					html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				else
					html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#chexing").append(html);
				
			}
		}
});
}


	
	
	$("#pinpai").change(function(){	
	var fatherid = $(this).children('option:selected').val();

		$("#chexi").empty();
		$("#chexi").append("<option value='-1'>请选择系列</option>");
		
		$("#chexing").empty();
		$("#chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexi").append(html);
				}
    		}
		});
	
	});
	
function getBaojia(chexiid){

$("#baojia").empty();
		$("#baojia").append("<option value=''>查看指导价</option>");
	
	$.ajax({
		url : 'getBaojiaBySerialId?chexiid='+chexiid,
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				if(city[i].p2 != null && city[i].p2 != undefined && city[i].p2 != '' && city[i].p2 != 'NULL'){
				var html ='';
				html ='<option value='+city[i].p2+'>'+city[i].pkg+'---'+city[i].p2+'万</option>';
				$("#baojia").append(html);
				}
				
			}
		}
});

}	


$("#chexi").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#baojia").empty();
		$("#baojia").append("<option value=''>查看指导价</option>");
		$.ajax({
    		url : 'getBaojiaBySerialId?chexiid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    		city = data;
	    		for(var i =0 ;i<city.length;i++)
			{
				if(city[i].p2 != null && city[i].p2 != undefined && city[i].p2 != '' && city[i].p2 != 'NULL'){
				var html ='';
				html ='<option value='+city[i].p2+'>'+city[i].pkg+'---'+city[i].p2+'万</option>';
				$("#baojia").append(html);
				}
				
			}
    		}
		});
		
		$("#chexing").empty();
		$("#chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : 'queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#chexing").append(html);
				}
    		}
		});
	
	});
	
	function tuisongCity(){
	
	
		
	
		var tprov = $("#tprov").val();
		if($.trim(tprov)=="-1"){
			alert("请选择地区!");
			return;
		}
		
		var tcity = $("#tcity").val();
		
		if($.trim(tcity)=="-1"){
			ttcity = '';
		}
		
		var id = $("#baomingid").val();
		$.post(
			"tuisongCity",
			{id:id,provid:tprov,cityid:tcity},
			function(data){
				if(data==1){
					alert("推送成功!");
					$("#close1").trigger("click");
					$("#tr"+id).hide();
					getProv2(tprov,id);
					getCity2(tprov,tcity,id);
					getArea(tcity,'-1');
					if(tprov == '1'){
						getPzcity('北京');
	    				getPstate('北京','');
					}else if(tprov == '9'){
						getPzcity('上海');
	    				getPstate('上海','');
					}else{
						getPzcity('');
	    				getPstate('','');
					}
					
					
					
				}
				else
					alert("推送失败");
			});
	
	}
	
	
	function tuisongjxs(){
		var id = $("#baomingid").val();
		var prov = $("#prov").val();
		var city = $("#city").val();
		var name = $("#tname").val();
    	var phone =  $("#ttphone").prop("value");
		var pinpai = $("#pinpai option:selected").val();
    	var chexi  =$("#chexi option:selected").val();
    	var tusong = $("#tusong").val();
    	
    	 if($.trim(name)==""){
	     	alert("请填写姓名!");
	    	return;
	     }
	    
	     if(pinpai=="-1")
	    	{
	    		alert("请选择品牌");
	    		return;
	    	}
	    if(chexi=="-1")
	    	{
	    		alert("请选择车系");
	    		return;
	    	}
	    
	    if(prov == '-1'){
	    	alert("请选择省份");
	    	return;
	    
	    }
    	
    	if(tusong == '1'){
    		if(confirm("这条数据已经推送给经销商，你确认再次推送吗?")){
    			 $.post(
							"publishDateTo4S",
							{id:id,name:name,phone:phone,brandId:pinpai,chexiId:chexi,prov:prov,city:city},
							function(result){
								
								var result=eval("("+result+")");
								
								if(result.status ==0){
									alert("推送数据有误");
								}
								
								if(result.status == 1){
									alert("未找到匹配的经销商");
								}
								
								if(result.status == 2){
									alert('推送经销商成功 \n推送经销商：'+result.enameList);
									$("#tuisong_flag").text("已推送");
									$("#tusong").val('1');
								}
								
							}
			);
    		}
    	}else{
    	
	    	 $.post(
							"publishDateTo4S",
							{id:id,name:name,phone:phone,brandId:pinpai,chexiId:chexi,prov:prov,city:city},
							function(result){
								
								var result=eval("("+result+")");
								
								if(result.status ==0){
									alert("推送数据有误");
								}
								
								if(result.status == 1){
									alert("未找到匹配的经销商");
								}
								
								if(result.status == 2){
									alert('推送经销商成功 \n推送经销商：'+result.enameList);
									$("#tuisong_flag").text("已推送");
									$("#tusong").val('1');
								}
								
							}
			);
		}
    	
	}

$("#saveyifang").on("click", function() {
	var tusong = $("#tusong").val();
	var id = $("#baomingid").val();
	var name = $("#tname").val();
    var phone =  $("#ttphone").prop("value");
	var pinpai = $("#pinpai option:selected").val();
    var chexi  =$("#chexi option:selected").val();
    var chexing  =$("#chexing option:selected").val();
    var prov = $("#prov option:selected").val();
    var city = $("#city option:selected").val();
    var area = $("#area option:selected").val();
    var phoneerror = $("input[name='phoneerror1']:checked").val();
    var phoneerror_count =  $("#phoneerror_count").prop("value");
    var constacterror = $("input[name='constacterror1']:checked").val();
    var constacterror_count =  $("#constacterror_count").prop("value");
	var phone_state = $("input[name='phoneState']:checked").val();
    var is_key_cus = $("input[name='is_key_cus1']:checked").val();
    var buycar_emergency = $("input[name='buycar_emergency1']:checked").val();
    var attend_type = $("#attend_type option:selected").val();
    var attend_date = $("#attend_date").val();
    var pz_city = $("#pz_city option:selected").val();
    var pp_state = $("#pp_state option:selected").val();
    var jpstate = $("input[name='jpstate']:checked").val();
    var jpchexi = $("#jpchexi").val();
    var hfstate = $("input[name='hfstate']:checked").val();
    var isbuy = $("input[name='gcxinxi']:checked").val();
    var gcstate = $("input[name='gcstate']:checked").val();
    var buy_ys = $("#buy_ys").val();
    var bsxtype = $("input[name='bsxtype']:checked").val();
    var buy_pl = $("#buy_pl").val();
    var buy_color = $("#buy_color").val();
    var know_yh = $("#know_yh").val();
    var zyxinxi = $("input[name='zyxinxi']:checked").val();
    var weixin = $("#p_weixin").val();
    var qq = $("#p_qq").val();
    var remarks = $("#remarks").prop("value");
    var content =  $("#content").prop("value");
    var tuiguang = $("#tuiguang").val();
    var switchid = $("#switchid").val();
    var ttdate = $("#ttdate").val();
    
    if(phoneerror == undefined){
    	alert("请选择电话接通情况!");
    	return;
    }
    
    if(constacterror == undefined){
    	alert("请选择沟通情况!");
    	return;
    }
    
     if($.trim(name)==""){
     	alert("请填写姓名!");
    	return;
     }
    
     if(pinpai=="-1")
    	{
    		alert("请选择品牌");
    		return;
    	}
    if(chexi=="-1")
    	{
    		alert("请选择车系");
    		return;
    	}
    
    if(prov == '-1'){
    	alert("请选择省份");
    	return;
    
    }
    
    if( phoneerror == '0'){
    
    
        if(buycar_emergency == null || buycar_emergency == ''){
    	 alert("请选择购车紧急度!");

         return false;
    	}
	    if($.trim(content)=="")
	    	{
	    		alert("请填写回访内容!");
	    		return;
	    	}
	     if(hfstate==null || hfstate == ''){

                alert("请选择回访状态!");

                return false;

            }
            if(attend_type == '0'){
            	 alert("请选择参团方式!");

                	return false;
            }
    }
    	
    if(phoneerror == '1'){
    	phoneerror_count = parseInt(phoneerror_count)+1;
    	if(buycar_emergency == null || buycar_emergency == ''){
    		buycar_emergency = 0;
    	}
    	 if(hfstate==null || hfstate == ''){

               hfstate = 0;

            }
    }
    
    if(constacterror == '1'){
    	constacterror_count = parseInt(constacterror_count)+1;
    	
    }
    
   
    
    
    $.post(
						"addyifang",
						{id:id,tusong:tusong,tuiguang:tuiguang,name:name,phone:phone,pinpai:pinpai,chexi:chexi,chexing:chexing,prov:prov,city:city,area:area,phoneerror:phoneerror,phoneerror_count:phoneerror_count,constacterror:constacterror,constacterror_count:constacterror_count,phone_state:phone_state,is_key_cus:is_key_cus,buycar_emergency:buycar_emergency,attend_type:attend_type,attend_date:attend_date,pz_city:pz_city,pp_state:pp_state,jpstate:jpstate,jpchexi:jpchexi,hfstate:hfstate,isbuy:isbuy,gcstate:gcstate,buy_ys:buy_ys,bsxtype:bsxtype,buy_pl:buy_pl,buy_color:buy_color,know_yh:know_yh,zyxinxi:zyxinxi,weixin:weixin,qq:qq,remarks:remarks,content:content,switchid:switchid,ttdate:ttdate},
						function(data){
							
							alert("提交成功");
							$("#close1").trigger("click");
							$("#tr"+id).hide();
							
						}
	);
   	
    
});	


$("#shachu").on("click", function() {


var id = $("#baomingid").val();

var content =  $("#shanchucontent").prop("value");

 if($.trim(content)=="")
	    	{
	    		alert("请填写删除理由!");
	    		return;
	    	}

	$.post(
						"deleteBaoming",
						{id:id,content:content},
						function(data){
							
							alert("删除成功");
							$("#close2").trigger("click");
							$("#close1").trigger("click");
							$("#tr"+id).hide();
							
						}
	);

});	
</script>
<script language="javascript" type="text/javascript">
    var isOnRecord = 0;
    function AppendStatus(szStatus) {
        try {
            qnviccub.QNV_Tool(QNV_TOOL_WRITELOG, 0, szStatus, NULL, NULL, 0); //写本地日志到控件注册目录的userlog目录下
            //G('StatusArea').value +=szStatus+"\r\n";
            //G('StatusArea').scrollTop = G('StatusArea').scrollHeight;
        }
        catch (e) { }
    }
    function AppendStatusEx(uID, szStatus) {
        try {
            uID = uID + 1;
			//alert(szStatus);
            AppendStatus("通道" + uID + ":" + szStatus);
        }
        catch (e) { }
    }

    function T_GetEvent(uID, uEventType, uHandle, uResult, szdata) {
        try {
            //var vValueArray=qnviccub.QNV_Event(0,2,0,"","",1024);
            var vValue = " type=" + uEventType + " Handle=" + uHandle + " Result=" + uResult + " szdata=" + szdata;
            switch (uEventType) {
                case BriEvent_PhoneHook: // 本地电话机摘机事件
                    AppendStatusEx(uID, "本地电话机摘机" + vValue);
                    isOnRecord = 2;
                    break;
                case BriEvent_PhoneDial: // 只有在本地话机摘机，没有调用软摘机时，检测到DTMF拨号
                    AppendStatusEx(uID, "本地话机拨号" + vValue);
                    break;
                case BriEvent_PhoneHang: // 本地电话机挂机事件
                    AppendStatusEx(uID, "本地电话机挂机" + vValue);
                    break;
                case BriEvent_CallIn: // 外线通道来电响铃事件
                    AppendStatusEx(uID, "外线通道来电响铃事件" + vValue);
                    break;
                case BriEvent_GetCallID: //得到来电号码
                    AppendStatusEx(uID, "得到来电号码" + vValue);
                    break;
                case BriEvent_StopCallIn: // 对方停止呼叫(产生一个未接电话)
                    AppendStatusEx(uID, "对方停止呼叫(产生一个未接电话)" + vValue);
                    break;
                case BriEvent_DialEnd: // 调用开始拨号后，全部号码拨号结束
                    AppendStatusEx(uID, "调用开始拨号后，全部号码拨号结束" + vValue);
                    break;
                case BriEvent_PlayFileEnd: // 播放文件结束事件
                    AppendStatusEx(uID, "播放文件结束事件" + vValue);
                    break;
                case BriEvent_PlayMultiFileEnd: // 多文件连播结束事件
                    AppendStatusEx(uID, "多文件连播结束事件" + vValue);
                    break;
                case BriEvent_PlayStringEnd: //播放字符结束
                    AppendStatusEx(uID, "播放字符结束" + vValue);
                    break
                case BriEvent_RepeatPlayFile: // 播放文件结束准备重复播放
                    AppendStatusEx(uID, "播放文件结束准备重复播放" + vValue);
                    break;
                case BriEvent_SendCallIDEnd: // 给本地设备发送震铃信号时发送号码结束
                    AppendStatusEx(uID, "给本地设备发送震铃信号时发送号码结束" + vValue);
                    break;
                case BriEvent_RingTimeOut: //给本地设备发送震铃信号时超时
                    AppendStatusEx(uID, "给本地设备发送震铃信号时超时" + vValue);
                    break;
                case BriEvent_Ringing: //正在内线震铃
                    AppendStatusEx(uID, "正在内线震铃" + vValue);
                    break;
                case BriEvent_Silence: // 通话时检测到一定时间的静音.默认为5秒
                    AppendStatusEx(uID, "通话时检测到一定时间的静音" + vValue);
                    break;
                case BriEvent_GetDTMFChar: // 线路接通时收到DTMF码事件
                    AppendStatusEx(uID, "线路接通时收到DTMF码事件" + vValue);
                    break;
                case BriEvent_RemoteHook: // 拨号后,被叫方摘机事件
                    AppendStatusEx(uID, "拨号后,被叫方摘机事件" + vValue);
                    break;
                case BriEvent_RemoteHang: //对方挂机事件
                    AppendStatusEx(uID, "对方挂机事件" + vValue);
                    break;
                case BriEvent_Busy: // 检测到忙音事件,表示PSTN线路已经被断开
                    AppendStatusEx(uID, "检测到忙音事件,表示PSTN线路已经被断开" + vValue);
                    break;
                case BriEvent_DialTone: // 本地摘机后检测到拨号音
                    AppendStatusEx(uID, "本地摘机后检测到拨号音" + vValue);
                    break;
                case BriEvent_RingBack: // 电话机拨号结束呼出事件。
                    AppendStatusEx(uID, "电话机拨号结束呼出事件" + vValue);
                    break;
                case BriEvent_MicIn: // MIC插入状态
                    AppendStatusEx(uID, "MIC插入状态" + vValue);
                    break;
                case BriEvent_MicOut: // MIC拔出状态
                    AppendStatusEx(uID, "MIC拔出状态" + vValue);
                    break;
                case BriEvent_FlashEnd: // 拍插簧(Flash)完成事件，拍插簧完成后可以检测拨号音后进行二次拨号
                    AppendStatusEx(uID, "拍插簧(Flash)完成事件，拍插簧完成后可以检测拨号音后进行二次拨号" + vValue);
                    break;
                case BriEvent_RefuseEnd: // 拒接完成
                    AppendStatusEx(uID, "拒接完成" + vValue);
                    break;
                case BriEvent_SpeechResult: // 语音识别完成 
                    AppendStatusEx(uID, "语音识别完成" + vValue);
                    break;
                case BriEvent_FaxRecvFinished: // 接收传真完成
                    AppendStatusEx(uID, "接收传真完成" + vValue);
                    break;
                case BriEvent_FaxRecvFailed: // 接收传真失败
                    AppendStatusEx(uID, "接收传真失败" + vValue);
                    break;
                case BriEvent_FaxSendFinished: // 发送传真完成
                    AppendStatusEx(uID, "发送传真完成" + vValue);
                    break;
                case BriEvent_FaxSendFailed: // 发送传真失败
                    AppendStatusEx(uID, "发送传真失败" + vValue);
                    break;
                case BriEvent_OpenSoundFailed: // 启动声卡失败
                    AppendStatusEx(uID, "启动声卡失败" + vValue);
                    break;
                case BriEvent_UploadSuccess: //远程上传成功
                    AppendStatusEx(uID, "远程上传成功" + vValue);
                    break;
                case BriEvent_UploadFailed: //远程上传失败
                    AppendStatusEx(uID, "远程上传失败" + vValue);
                    break;
                case BriEvent_EnableHook: // 应用层调用软摘机/软挂机成功事件
                    AppendStatusEx(uID, "应用层调用软摘机/软挂机成功事件" + vValue);
                    break;
                case BriEvent_EnablePlay: // 喇叭被打开或者/关闭
                    AppendStatusEx(uID, "喇叭被打开或者/关闭" + vValue);
                    break;
                case BriEvent_EnableMic: // MIC被打开或者关闭
                    AppendStatusEx(uID, "MIC被打开或者关闭" + vValue);
                    break;
                case BriEvent_EnableSpk: // 耳机被打开或者关闭
                    AppendStatusEx(uID, "耳机被打开或者关闭" + vValue);
                    break;
                case BriEvent_EnableRing: // 电话机跟电话线(PSTN)断开/接通
                    AppendStatusEx(uID, "电话机跟电话线(PSTN)断开/接通" + vValue);
                    break;
                case BriEvent_DoRecSource: // 修改录音源
                    AppendStatusEx(uID, "修改录音源" + vValue);
                    break;
                case BriEvent_DoStartDial: // 开始软件拨号
                    AppendStatusEx(uID, "开始软件拨号" + vValue);
                    if (isOnRecord == 2) isOnRecord = 3;
                    break;
                case BriEvent_RecvedFSK: // 接收到FSK信号，包括通话中FSK/来电号码的FSK
                    AppendStatusEx(uID, "接收到FSK信号，包括通话中FSK/来电号码的FSK" + vValue);
                    break;
                case BriEvent_DevErr: //设备错误
                    AppendStatusEx(uID, "设备错误" + vValue);
                    break;
                default:
                    if (uEventType < BriEvent_EndID)
                        AppendStatusEx(uID, "忽略其它事件发生:ID=" + uEventType + vValue);
                    break;
            }
        }
        catch (e) { }
    } 
</script>
<SCRIPT LANGUAGE="JavaScript" FOR="qnviccub" EVENT="OnQnvEvent(chID,type,handle,result,param,szdata,szdataex)">
	T_GetEvent(chID,type,handle,result,szdata)
</SCRIPT>