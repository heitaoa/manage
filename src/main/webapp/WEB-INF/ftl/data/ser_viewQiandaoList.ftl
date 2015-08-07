<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>


<div class="row">
	<div class="col-md-10"></div><div class="col-md-2"><button type="button" class="btn blue " onclick="downLoad('${pro_num!}');">导出签到表</button></div>
	<div class="col-md-12">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" id="table_1" role="grid" aria-describedby="sample_1_info">
							<thead>
								<tr role="row">
									<td class="text-center">序号</td>
									<td class="text-center">客户名称</td>
									<td class="text-center">电话</td>
									<td class="text-center">报名信息</td>
									<td class="text-center">报名地区</td>
									<td class="text-center">客户等级</td>
									<td class="text-center">购车时间</td>
									<td class="text-center">品牌车系</td>
									<td class="text-center">购车情况</td>
									<td class="text-center">何处上牌</td>
									<td class="text-center">购车预算</td>
									<td class="text-center">操作</td>
								</tr>
							</thead>
							<tbody>
								<#list list as l>
									<tr>
										<td>${l_index+1}</td>
										<td>${l.get("name")}</td>
										<td>${l.get("phone")}</td>
										<td>${l.get("baoming_date")!}${l.get("phone_prov_name")!}${l.get("phone_city_name")!}<#if l.get("ip")??><br/>${l.get("ip")}</#if></td>
										<td>${l.get("prov_name")!}${l.get("city_name")!}</td>
										<td>
											<#switch l.get("is_key_cus")>
												<#case "0">
													普通客户
													<#break>
												<#case "1">
													重点客户
													<#break>
											</#switch>
										</td>
										<td>
											<#switch l.get("buycar_emergency")>
												<#case "0">
													未知
													<#break>
												<#case "1">
													本周
													<#break>
												<#case "2">
													2周内
													<#break>
												<#case "3">
													一个月内
													<#break>
												<#case "4">
													3个月内
													<#break>
												<#case "5">
													3个月以上
													<#break>
												<#case "6">
													随时
													<#break>
											</#switch>
										</td>
										<td>${l.get("brand_name")!}${l.get("serial_name")!}</td>
										<td>
											<#switch l.get("buy_state")>
												<#case "0">
													新车全款
													<#break>
												<#case "1">
													新车贷款
													<#break>
												<#case "2">
													置换全款
													<#break>
												<#case "3">
													增购贷款
													<#break>
											</#switch>
										</td>
										<td>${l.get("pz_city_name")!}</td>
										<td>${l.get("buy_ys")!}</td>
										<td><a href="javascript:view('${l.get("record_id")}');">查看详情</a></td>
									</tr>
								</#list>
							</tbody>
						</table>
	</div>
	<#if pages gt 0>
				<div class="row">
					<div class="col-md-5 col-sm-12">
						<div style="height:50px; line-height:50px; font-size:14px;">
							当前第${page}页，共${pages}页
						</div>
					</div>
					<!-- 分页start -->
					<div class="col-md-7 col-sm-12">
				        <ul class="pagination">
				            <#if page==1>
				            	<li class="active">
				                    <a href="#" style=" height:32px;"><i class="fa fa-angle-left"></i></a>
				                </li>
				            <#else>
				            	<li>
				                    <a href="javascript:toPage(${page-1})" style=" height:32px;"><i class="fa fa-angle-left"></i></a>
				                </li>
				            </#if>
				            
				            <#list pageList as p>
				            	<#if page==p?eval >
				                	<li class="active">
				                    	<a href="#">${p}</a>
				                    </li>
				                <#else>
				                	<li>
				                    	<a href="javascript:toPage(${p})">${p}</a>
				                    </li>
				                </#if>
				            	
				            </#list>
				            <#if page+pageList?size-1!=pages >
				            	<li>
				                    <a>...</a>
				                </li>
				            </#if>
				            <#if page==pages >
				            	<li class="active">
				                    <a href="#" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
				                </li>
				            <#else>
				            	<li>
				                    <a href="javascript:toPage(${page+1})" style=" height:32px;"><i class="fa fa-angle-right"></i></a>
				                </li>
				            </#if>
				            
				        </ul>
				    </div>
				    <!-- 分页end -->
				</div>
				</#if>
</div>
<div id="view" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
	<input id="record_id" type="hidden" value=""/>
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">查看详情</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
         	<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>客户姓名:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_name"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>电话:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_phone"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>职业:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_job"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>客户等级:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_is_key_cus"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>报名信息:</h5>
				</div>
				<div class="col-md-4 text-left">
					<h5><label id="view_baoming_info"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>4s店了解优惠:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_know_yh"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>品牌车系:</h5>
				</div>
				<div class="col-md-4 text-left">
					<h5><label id="view_brand_car"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>竞品车系:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_jp"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>购车时间:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_buycar_emergency"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>报名地区:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_baoming_area"></label></h5>
				</div>
				
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>购车预算:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_buy_ys"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>车型选项:</h5>
				</div>
				<div class="col-md-4 text-left">
					<h5><label id="view_model_info"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>购车情况:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_buy_state"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>何处上牌:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_pz_city"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>需求服务:</h5>
				</div>
				<div class="col-md-2 text-left">
					<select class="form-control  input-small" id="view_require">
						<option></option>
	  					<option value="0">上牌</option>
	  					<option value="1">保险</option>
	  					<option value="2">贷款</option>
	  				</select>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>微信:</h5>
				</div>
				<div class="col-md-2 text-left">
					<input class="form-control input-small" id="view_weixin"/>
				</div>
				<div class="col-md-2 text-right">
					<h5>QQ:</h5>
				</div>
				<div class="col-md-2 text-left">
					<input class="form-control input-small" id="view_qq"/>
				</div>
				<div class="col-md-2 text-right">
					<h5>参团方式:</h5>
				</div>
				<div class="col-md-2 text-left">
					<select class="form-control  input-small" id="view_attend_type">
	  					<option value="0"></option>
	  					<option value="1">参加，跟团到</option>
	  					<option value="2">参加，自行到</option>
	  					<option value="3">参加，不确定</option
	  					<option value="4">可能参加</option>
	  					<option value="5">不参加</option>
	  				</select>
				</div>
			</div>
			<div class="col-md-12"></div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>备注:</h5>
				</div>
				<div class="col-md-6 text-left">
					 <textarea class="form-control input-large" rows="4" id="view_bz"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
    	<button id="bt_pro_yes" type="button" class="btn blue" onclick="edit();">提交</button>
    	<button type="button" class="btn default" data-dismiss="modal">关闭</button>
    </div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script src="${admin_che_url}js/jPages.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("div.holder").jPages({
	containerID: "itemContainer",
	perPage: 10,
	delay : 0
});
});
function toPage(page){
	window.location="./ser_viewQiandaoList?pro_num=${pro_num}&page="+page;
}
function view(record_id){
	$.ajax({
    type: "POST",
    url:"ser_getQiandaoInfo",
    data:{
			"record_id":record_id
		},
    success: function(data) {
			var p = eval(data)
    		var view_name =p[0].name;
			$("#view_name").text(view_name);
			var view_phone =p[0].phone;
			$("#view_phone").text(view_phone);
			var view_job =p[0].p_job;
			if(view_job=="0"){
				view_job="国企";
			}else if(view_job=="1"){
				view_job="私企";
			}else if(view_job=="2"){
				view_job="个体";
			}
			$("#view_job").text(view_job);
			var view_is_key_cus =p[0].is_key_cus; 
			if(view_is_key_cus=="0"){
				view_is_key_cus="普通客户";
			}else if(view_is_key_cus=="1"){
				view_is_key_cus="重点客户";
			}
			$("#view_is_key_cus").text(view_is_key_cus);
			var prov_name =p[0].prov_name;
			if(!is_exists(prov_name)){
				prov_name="";
			} 
			var city_name = p[0].city_name;
			if(!is_exists(city_name)){
				city_name="";
			}
			var view_baoming_area =prov_name+city_name;
			$("#view_baoming_area").text(view_baoming_area);
			var phone_prov_name = p[0].phone_prov_name;
			if(!is_exists(phone_prov_name)){
				phone_prov_name="";
			} 
			var phone_city_name = p[0].phone_city_name;
			if(!is_exists(phone_city_name)){
				phone_city_name="";
			} 
			var baoming_date = p[0].baoming_date;
			if(!is_exists(baoming_date)){
				baoming_date="";
			} 
			var ip = p[0].ip;
			if(!is_exists(ip)){
				ip="";
			}
			var view_baoming_info =phone_prov_name+phone_city_name+baoming_date+ip;
			$("#view_baoming_info").text(view_baoming_info);
			var view_know_yh =p[0].know_yh;
			$("#view_know_yh").text(view_know_yh);
			var brand_name=p[0].brand_name;
			if(!is_exists(brand_name)){
				brand_name="";
			}
			var serial_name=p[0].serial_name;
			if(!is_exists(serial_name)){
				serial_name="";
			}
			var view_brand_car =brand_name+serial_name;
			$("#view_brand_car").text(view_brand_car);
			var view_jp =p[0].jp_car;
			$("#view_jp").text(view_jp);
			var view_buycar_emergency =p[0].buycar_emergency;
			$("#view_buycar_emergency").text(view_buycar_emergency);
			var view_buy_ys =p[0].buy_ys;
			if(!is_exists(view_buy_ys)){
				view_buy_ys="";
			}
			$("#view_buy_ys").text(view_buy_ys);
			var buy_pl = p[0].buy_pl;
			if(!is_exists(buy_pl)){
				buy_pl="";
			}
			var buy_bsx = p[0].buy_bsx;
			if(buy_bsx=="0"){
				buy_bsx="自动";
			}else if(buy_bsx=="1"){
				buy_bsx="手动";
			}else{
				buy_bsx="";
			}
			var buy_color = p[0].buy_color;
			if(!is_exists(buy_color)){
				buy_color="";
			}
			var view_model_info =buy_pl+buy_bsx+buy_color;
			$("#view_model_info").text(view_model_info);
			var view_buy_state =p[0].buy_state;
			if(view_buy_state=="0"){
				view_buy_state = "新车全款";
			}else if(view_buy_state=="1"){
				view_buy_state = "新车贷款";
			}else if(view_buy_state=="2"){
				view_buy_state = "置换全款";
			}else if(view_buy_state=="3"){
				view_buy_state = "增购贷款";
			}else{
				view_buy_state = "";
			}
			$("#view_buy_state").text(view_buy_state);
			var view_pz_city =p[0].pz_city_name;
			if(!is_exists(view_pz_city)){
				view_pz_city="";
			}
			$("#view_pz_city").text(view_pz_city);
			var view_require =p[0].require;
			$("#view_require").val(view_require);
			var view_qq =p[0].p_qq;
			$("#view_qq").val(view_qq);
			var view_weixin =p[0].p_weixin;
			$("#view_weixin").val(view_weixin);
			var view_attend_type =p[0].attend_type;
			$("#view_attend_type").val(view_attend_type);
			var view_bz =p[0].bz;
			$("#view_bz").val(view_bz);
			$("#record_id").val(p[0].record_id);
			$("#view").modal();
    }
  });
}
function edit(){
			var view_require =$("#view_require").val();
			var view_qq =$("#view_qq").val();
			var view_weixin =$("#view_weixin").val();
			var view_attend_type =$("#view_attend_type").val();
			var view_bz =$("#view_bz").val();
			var record_id = $("#record_id").val();
			$.ajax({
    			type: "POST",
    			url:"ser_getSaveQiandaoInfo",
    			data:{
					"record_id":record_id,
					"qq":view_qq,
					"weixin":view_weixin,
					"bz":view_bz
				},
    			success:function(data) {
						if(data==1){
							alert("修改成功！");
						}else{
							alert("eror!");
						}
				}
			 });
	
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined||obj=="null"){
		return false;
	}else{
		return true;
	}
}
function downLoad(pro_num){
	window.location="./ser_downQiandao?pro_num="+pro_num;
}
</script>
</body>
</html>