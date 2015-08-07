<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
	<div style="height:30px;"></div>
	<form class="form-horizontal" action="#"  role="form">
    	<div class="form-group">
        	<label class="col-md-1 control-label">推广编号</label>
        	<div class="col-md-2">
        		<input type="text" class="form-control input-medium" value="${pro_num!}"disabled="disabled" id="pro_num"/>
            </div>
            <label class="col-md-1 control-label">活动名称</label>
        	<div class="col-md-2">
        		<input type="text" class="form-control input-medium" value="${acti_name!1}" disabled="disabled"/>
            </div>   
        	<div class="col-md-4">
        		<button type="button" class="btn btn-circle blue " onclick="end('${pro_num!}');">提交</button>
        		<#-- <button type="button" class="btn btn-circle blue " onclick="editBaseInfo('${pro_num!}');">填写活动信息</button> -->
        		<#-- <button type="button" class="btn btn-circle blue " onclick="viewData('${pro_num!}');">查看活动数据</button> -->
            </div>   
			
        </div>
   </form>
</div>
<div class="row" style="margin-left:15px;margin-top:10px;">
	 <div class="col-md-12">
    	<div class="tabbable tabbable-custom">
            <ul class="nav nav-tabs">
            	<li class="active">
                    <a href="#tab_1_1" data-toggle="tab">填写活动成交数据</a>
                </li>
                <li>
                    <a href="#tab_1_2" data-toggle="tab" id="base">填写活动基本数据</a>
                </li>
            </ul>
            
            <div class="tab-content">
            	<div class="tab-pane active fontawesome-demo" id="tab_1_1">
                	<div class="row">
						<div class="col-md-8">
						</div>
						<div class="col-md-4">
							<a  class="btn btn-default btn-sm pull-right" href="javascript:addNotInvite();">添加一行</a>
							<a  class="btn btn-default btn-sm pull-right" href="javascript:deleteNotInvite();">删除</a>
						</div>
    					<div class="col-md-12">
        					<table class="table table-condensed table-bordered table-hover">
            					<thead>
                					<tr role="row" class="heading">
                    					<th><input type="checkbox" id="all"/></th>
                    					<th>姓名</th>
                    					<th>手机号</th>
                    					<th>是否到店</th>
                    					<th>是否成交</th>
                    					<th>成交车型</th>
                    					<th>成交日期</th>
                    					<th>签单销售</th>
                    					<th>礼品</th>
                    					<th>快递地址</th>
                    					<th>是否邀约</th>
                					</tr>
             					</thead>
             					<tbody id="tbody">
             						<#list list as bm>
             							<tr id="${bm.get("qiandao_id")!}">
                    						<td><input  type="checkbox" name="sub" value="${bm.get("qiandao_id")!}"/></td>
                    						<td tag="name"><input name="name" class="form-control input-small" value="${bm.get("name")!}" disabled /></td>
                    						<td tag="phone"><input name="phone" class="form-control input-small" value="${bm.get("phone")!}" disabled /></td>
                    						<td>
                        						<select class="layout-option form-control" tag="is_reach">
                            	 					<option value="0" <#if "0"==bm.get("is_reach")>selected</#if>>否</option>
                                					<option value="1" <#if "1"==bm.get("is_reach")>selected</#if>>是</option>
                            					</select>
                        					</td>
                        					<td>
                        						<select class="layout-option form-control" tag="is_trans" >
                            	 					<option value="0" <#if "0"==bm.get("is_trans")>selected</#if>>否</option>
                                 					<option value="1" <#if "1"==bm.get("is_trans")>selected</#if>>是</option>
                            					</select>
                        					</td>
                        					<td>
                        						<select class="layout-option form-control input-small" tag="model">
                        							<#list models as m>
                        								<option value="${m.get("code")!}" <#if m.get("code")==bm.get("model")>selected</#if>>${m.get("name")!}</option>
                        							</#list>
                            					</select>
                        					</td> 
                        					<td>
                        						<div class="input-group input-small date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            						<input type="text" class="form-control" name="trans_date" value="<#if bm.get("trans_date")??>${bm.get("trans_date")}<#else>${project.acti_start_date?string("yyyy-MM-dd")}</#if>">
                       							 </div> 
                        					</td>           
                        					<td><input name="sale_man" class="form-control input-small" value="${bm.get("sale_man")!}"/></td>
                        					<td>
                        						<label class="form-control"><label name="giving_name">${bm.get("giving_name")!}</label><input type="hidden" name="giving_code" value="${bm.get("giving_code")!}"><a href="javascript:choseGift('${bm.get("qiandao_id")!}');" class="btn btn-circle btn-xs blue">修改<i class="fa fa-edit"></i></a></label>
                        					</td>
                        					<td><input name="addr" class="form-control" value="${bm.get("addr")!}"/></td>
                        					<td>
                        						<select class="layout-option form-control" tag="is_invite">
                                					<option value="0" <#if "0"==bm.get("is_invite")>selected</#if>>否</option>
                                					<option value="1" <#if "1"==bm.get("is_invite")>selected</#if>>是</option>
                            					</select>
                       					</td>
                						</tr>
            						</#list>
        						</tbody>
							</table>
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
    					<div class="col-dm-12" style="height:30px;">
						</div>
						<div class="col-md-12" style="text-align:right">
    						<button type="button" class="btn btn-circle blue " style="width:80px;" onclick="submit()">保存</button>
    					</div>                     
                           
					</div>
                </div>
                
                <div class="tab-pane" id="tab_1_2">
                	<div class="row">
                        <div class="col-md-12">
                            <form class="form-horizontal" action="#"  role="form">
                            	<div class="form-group">
                                    <label class="col-md-2 control-label">活动名称</label>
                                    <div class="col-md-2">
                                        <input type="text" class="form-control input-medium" id="base_acti_name" value="${acti_name!}"/>
                                    </div>
                                </div>
                            	<div class="form-group">
                                	<label class="col-md-2 control-label">执行人</label>
                                    <div class="col-md-2">
                                        <select class="layout-option form-control input-small" id="base_zx">
                                            <#list deptPerson as p>
                                            	<#if info.get("detail_executor")??>
                                            		<option value="${p.id}" <#if info.get("detail_executor")==p.id>selected</#if> >${p.name}</option>
                                            	<#else>
                                            		<option value="${p.id}" <#if project.ini_man==p.id>selected</#if> >${p.name}</option>
                                            	</#if>
                                            </#list>
                                        </select>
                                    </div>
                                    <label class="col-md-2 control-label">辅助参与人员</label>
                                    <div class="col-md-2">
                                        <input type="text" class="form-control input-medium" id="base_fz" value="${info.get("detail_assist_person")!}"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                	<label class="col-md-2 control-label">活动日期</label>
                                    <div class="col-md-2">
                                        <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                                            <input type="text" class="form-control" id="base_hdrq" value="${info.get("detail_acti_date")!}"/>
                                            <span class="input-group-btn">
                                            <button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                                            </span>
                                        </div>
                                    </div>
                                    
                                    <label class="col-md-2 control-label">时段</label>
                                    <div class="col-md-2">
                                        <select class="layout-option form-control input-medium" id="base_sd" value="${info.get("detail_time_interval")!}">
                                            <option value="0" <#if info.get("detail_time_interval")??&&info.get("detail_time_interval")=="0">selected</#if>>上午</option>
                                            <option value="1" <#if info.get("detail_time_interval")??&&info.get("detail_time_interval")=="1">selected</#if>>下午</option>
                                            <option value="2" <#if info.get("detail_time_interval")??&&info.get("detail_time_interval")=="2">selected</#if>>全天</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                	<label class="col-md-2 control-label">公司地址</label>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control input-large" id="base_addr" value="${info.get("detail_acti_addr")!}"/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                	<label class="col-md-2 control-label">大巴/交通费</label>
                                    <div class="col-md-2">
                                        <input type="text" class="form-control input-inline input-small" id="base_jtf" value="${info.get("detail_traffic_expense")!}"/>
                                        <span>元</span>
                                    </div>
                                    
                                    <label class="col-md-2 control-label">活动人员补助</label>
                                    <div class="col-md-2">
                                        <input type="text" class="form-control input-inline input-small" id="base_hdrybz" value="${info.get("detail_acti_sub")!}" />
                                        <span>元</span>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                	<label class="col-md-2 control-label">活动总结</label>
                                    <div class="col-md-4">
                                        <textarea class="form-control input-large" rows="4" id="base_hdzj" value="${info.get("detail_acti_report")!}"></textarea>
                                    </div>
                                    
                                </div>
                                <div class="form-group">
                                	<div class="col-md-8">
                                    </div>
                                	<div class="col-md-4">
                                    	 <button id="base_save" type="button" class="btn blue" onclick="saveEditBaseInfo('${pro_num!}')">保存</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- tab-content -->
        </div>
    </div>
</div>
	<div id="modal_gift" class="modal fade" tabindex="-1" data-backdrop="static" data-width="500">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h5 class="modal-title">礼品选择</h5>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-md-12">
                	
					<div class="checkbox-list" style="display:inline" id="givings" >
						<#list givings as g>
							<label class="checkbox-inline">
								<input type="checkbox" value="${g.get("code")}" tag="${g.get("name")}"/>
								<label class="giving_name">${g.get("name")}</label>
							</label>
						</#list>
						
					</div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button id="bt_pro_yes" type="button" class="btn blue" data-dismiss="modal" onclick="chosed();">确定</button>
        </div>
    </div>
    <div id="view_data" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">查看数据</h4>
        </div>
        <div class="modal-body">
            <div class="row">
        		<div class="portlet box">
					<div class="portlet-title">
						<div class="caption" style="color:#3d3d3d;">
							礼品合计
						</div>
					</div>
            		<div class="portlet-body">
            			<table class="table table-condensed table-bordered table-hover">
                    		<thead>
                        		<tr role="row" class="heading">
                            		<th>序号</th>
                            		<th>礼品</th>
                            		<th>数量</th>
                            		<th>金额</th>
                        		</tr>
                    		</thead>
                    		<tbody id="gift_tbody">
                        		
                    		</tbody>
                		</table>
            		</div>
            	</div>
            	<div class="portlet box">
					<div class="portlet-title">
						<div class="caption" style="color:#3d3d3d;">
							客户数据转化
						</div>
					</div>
            		<div class="portlet-body">
            			<table class="table table-condensed table-bordered table-hover">
                    		<thead>
                        		<tr role="row" class="heading">
                            		<th></th>
                            		<th>数量</th>
                            		<th>转化率</th>
                        		</tr>
                    		</thead>
                    		<tbody>
                        		<tr>
                            		<td>邀约数</td>
                            		<td>50</td>
                            		<td></td>
                        		</tr>
                    		</tbody>
                		</table>
            		</div>
            	</div>
        	</div>
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

	$("#all").click(function(){
		if($(this).attr("checked")){
			$("input[name='sub']").prop("checked",true).uniform();
		}else{
			$("input[name='sub']").prop("checked",false).uniform();
		}
	});

	if(location.hash) {

		$('a[href=' + location.hash + ']').tab('show');

	}

	$(document.body).on("click", "a[data-toggle]", function(event) {

		location.hash = this.getAttribute("href");

	});


});

$(window).on('popstate', function() {

	var anchor = location.hash || $("a[data-toggle=tab]").first().attr("href");

	$('a[href=' + anchor + ']').tab('show');

});
function choseGift(qiandao_id){
	$("#givings").attr("tag",qiandao_id);
	var checkbox = $("#givings input[type='checkbox']");
	$.each(checkbox,function (){
		 	$(this).prop("checked",false).uniform();
	});
 	var code = $("#"+qiandao_id+" input[name='giving_code']").val();
 	var codes = code.split(",");
 	for(var i=0;i<codes.length;i++){
 		var b = $("#givings input[type='checkbox'][value='"+codes[i]+"']");
 		 $.each(b,function (){
		 $(this).prop("checked",true).uniform();

		});
 	}
 	$("#modal_gift").modal();
 	
 }
function chosed(){
	var codeArray = new Array();
	var nameArray=new Array();
	var checked = $("#givings input[type='checkbox']:checked");
	$.each(checked,function (){
		var code = $(this).val();
		var name = $(this).attr("tag");
		nameArray.push(name);
		codeArray.push(code);	
	});
	var names = nameArray.join(',');
	var codes = codeArray.join(',');
	var id = $("#givings").attr("tag");
	$("#"+id+" label[name='giving_name']").text(names);
	$("#"+id+" input[name='giving_code']").val(codes);
	
	
}

function toPage(page){
	var total = ${pages};
	if(page<1){
		alert("第一页");
	}else if(page>total){
		alert("最后一页");
	}else{
		window.location="./ser_enterKctEditQiandao?pro_num=${pro_num}&page="+page;
	}
	
}
function submit(){
	var str = "[";
	var pro_num = $("#pro_num").val();
	$("input[name='sub']:checked").each(function(){
		var qiandao_id=$(this).val();
		var name=$("tr#"+qiandao_id+" input[name='name']").val();
		var phone = $("tr#"+qiandao_id+" input[name='phone']").val();
		var is_reach = $("tr#"+qiandao_id+" select[tag='is_reach']").val();
		var is_trans = $("tr#"+qiandao_id+" select[tag='is_trans']").val();
		var is_invite = $("tr#"+qiandao_id+" select[tag='is_invite']").val();
		var model = $("tr#"+qiandao_id+" select[tag='model']").val();
		var sale_man = $("tr#"+qiandao_id+" input[name='sale_man']").val();
		var trans_date = $("tr#"+qiandao_id+" input[name='trans_date']").val();
		var addr = $("tr#"+qiandao_id+" input[name='addr']").val();
		var giving_name = $("tr#"+qiandao_id+" label[name='giving_name']").text();
		var giving_code = $("tr#"+qiandao_id+" input[name='giving_code']").val();
		if(isNaN(qiandao_id)){
			qiandao_id="";
		}
		var j = '{"qiandao_id":"'+qiandao_id+'","name":"'+name+'","phone":"'+phone+'","is_reach":"'+is_reach+'","is_trans":"'+is_trans+'","is_invite":"'+is_invite+'","model":"'+model+'","trans_date":"'+trans_date+'","sale_man":"'+sale_man+'","addr":"'+addr+'","giving_name":"'+giving_name+'","giving_code":"'+giving_code+'","pro_num":"'+pro_num+'"},';
		str=str+j;
	});
	if(str.length>1){
		str=str.substring(0,str.length-1);
	}
	str=str+"]";
	$.ajax({
    type: "POST",
    url:"ser_saveEditQiandao",
    data:{
			"data":str
		},
    success: function(data) {
			if(data=="1"){
				alert("提交成功");
				$("input[name='sub']").prop("checked",false).uniform();
				window.location.reload() ;
				
			}else{
				alert("error");
			}
    }
  });
}
function editBaseInfo(pro_num){
				$("#base_zx").val("");
				$("#base_fz").val("");
				$("#base_hdrq").val("");
				$("#base_sd").val("");
				$("#base_jtf").val("");
				$("#base_hdrybz").val("");
				$("#base_hdzj").val("");
				$("#base_addr").val("");
	$.ajax({
    type: "POST",
    url:"./ser_getActDetail",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
				var info = eval(data);
				var base_zx = info[0].detail_executor;
				$("#base_zx").val(base_zx);
				var base_fz = info[0].detail_assist_person;
				$("#base_fz").val(base_fz);
				var base_hdrq = info[0].detail_acti_date;
				$("#base_hdrq").val(base_hdrq);
				var base_sd = info[0].detail_time_interval;
				$("#base_sd").val(base_sd);
				var base_jtf = info[0].detail_traffic_expense;
				$("#base_jtf").val(base_jtf);
				var base_hdrybz = info[0].detail_acti_sub;
				$("#base_hdrybz").val(base_hdrybz);
				var base_hdzj = info[0].detail_acti_report;
				$("#base_hdzj").val(base_hdzj);
				var base_addr = info[0].detail_acti_addr;
				$("#base_addr").val(base_addr);
				var base_acti_name = info[0].acti_name;
				$("#base_acti_name").val(base_acti_name);
				$("#baseInfo").modal();
    }
  });
	
}
function saveEditBaseInfo(pro_num){
	var base_zx = $("#base_zx").val();
	var base_fz = $("#base_fz").val();
	var base_hdrq = $("#base_hdrq").val();
	var base_sd = $("#base_sd").val();
	var base_jtf = $("#base_jtf").val();
	var base_hdrybz = $("#base_hdrybz").val();
	var base_hdzj = $("#base_hdzj").val();
	var base_addr = $("#base_addr").val();
	var acti_name = $("#base_acti_name").val();
	if(!is_exists(base_hdrq)){
		alert("请输入活动日期");
		return;
	}
	if(!is_exists(base_jtf)){
		alert("请输入交通费用");
		return;
	}
	if(!is_exists(base_hdrybz)){
		alert("请输入活动人员补助");
		return;
	}
	if(!is_exists(base_addr)){
		alert("请输入公司地址");
		return;
	}
	if(!is_exists(acti_name)){
		alert("请输入活动名称");
		return;
	}
	if(!is_exists(base_hdzj)){
		alert("请输入活动总结");
		return;
	}
	$.ajax({
    type: "POST",
    url:"./ser_saveActDetail",
    data:{
			"base_zx":base_zx,
			"base_fz":base_fz,
			"base_hdrq":base_hdrq,
			"base_sd":base_sd,
			"base_jtf":base_jtf,
			"base_hdrybz":base_hdrybz,
			"base_hdzj":base_hdzj,
			"base_addr":base_addr,
			"pro_num":pro_num,
			"acti_name":acti_name
		},
    success: function(data) {
			if(data=="1"){
				alert("修改成功");
				window.location.reload();
				$("#base").tab('show');
			}else{
				alert("error");
			}
    }
  });			
}
function addNotInvite(){
	var models = "";
	<#list models as m>
		models +='<option value="${m.get("code")!}">${m.get("name")!}</option>';
	</#list>
	
	var sysdate = new Date();
	var id = "Not"+sysdate.getTime();
	var str = "";
	str +='<tr id="'+id+'"><td><input type="checkbox" name="sub" value="'+id+'"/></td><td tag="name"><input name="name" class="form-control input-small"/></td><td tag="phone"><input name="phone" class="form-control input-small"/></td>';
	str += '<td><select class="layout-option form-control" tag="is_reach"><option value="0" >否</option><option value="1">是</option></select></td>';
	str += '<td><select class="layout-option form-control" tag="is_trans"><option value="0">否</option><option value="1" >是</option></select></td>';
	str += '<td><select class="layout-option form-control input-small" tag="model">'+models+'</select></td>';
	str += '<td><div class="input-group input-small date-picker input-daterange" data-date-format="yyyy-mm-dd"><input type="text" class="form-control" name="trans_date" value="${project.acti_start_date?string("yyyy-MM-dd")}"></div></td>';
	str += '<td><input name="sale_man" class="form-control input-small"/></td>';
	str += '<td><label class="form-control"><label name="giving_name"></label><input type="hidden" name="giving_code" "><a href="javascript:choseGift(\''+id+'\');" class="btn btn-circle btn-xs blue">修改<i class="fa fa-edit"></i></a></label></td>';
	str += '<td><input name="addr" class="form-control"/></td><td><select class="layout-option form-control" tag="is_invite"><option value="0" >否</option><option value="1" >是</option></select></td></tr>';
	$("#tbody").append(str);
	$(".date-picker input").datepicker({
		format: 'yyyy-mm-dd',
		autoclose: true,
		language: 'zh-CN'
	});
}
function deleteNotInvite(){
	$("input[name='sub']:checked").each(function(){
		var id = $(this).val();
		if(isNaN(id)){
			$("#"+id).remove();
		}
	});
}
function viewData(pro_num){
	$.ajax({
    type: "POST",
    url:"./getGiftData",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			$("#gift_tbody").children().remove();
			var info = eval(data);
			for(var i=0;i<info.length;i++){
				var name = info[i].name;
				var sum = info[i].sum;
				var num = info[i].num;
				var seq = i+1;
				html="<tr><td>"+seq+"</td><td>"+name+"</td><td>"+num+"</td><td>"+sum+"</td></tr>";
				$("#gift_tbody").append(html);
			}
    }
   });		
	$("#view_data").modal();
}
function end(pro_num){
	if(confirm('项目提交之后所有信息将无法修改，请确定基本数据和成交数据都已保存，确定要提交吗?')){
		$.ajax({
    		type: "POST",
    		url:"./ser_endProject",
    		data:{
				"pro_num":pro_num
			},
    		success: function(data) {
				if(data==1){
					alert("提交成功");
					window.parent.removeActiveAndOpenNew("我的活动","./ser_showMyActivity");
				}else{
					alert("error");
				}
			
    		}
   		});	
	}
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined||obj=="null"){
		return false;
	}else{
		return true;
	}
}	
</script>


</body>
</html>