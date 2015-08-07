<#import "../common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<style>
ul,li {margin:0; padding:0;}
ul,li {list-style:none;}
.data-table1 {border-collapse:collapse; margin-left:15px;}
.data-table1 td {padding:5px;}
.xwbg1 th {
	color:#fcf1dd;
	font-size:16px;
	height:32px;
	line-height:32px;
	background:#303d4d;
}
.xwbg1 td {
	/*height:40px;*/
	color:#303d4d;
	font-size:14px;
	line-height:40px;
}
.customer_info_table th { background-color: #4b8df8; }
.customer_info_table .list li { border: 1px solid #ccc; border-top: 0; padding: 0; border-bottom: 1px solid #ccc; line-height: 2.2em; }
.customer_info_table .list li.current { background: #A1BBDB; }
.customer_info_table .list .color-odd { background: #d6e2f1; }
.callback_num { width: 100%; border-top: 2px solid #ff7f66; }
.callback_num strong { color: red; }
.customer_info_table .list li a {padding-left:5px;}
.customer_info_table .list li a:hover {text-decoration:none;}
</style>
<!--顶部title-->
<!--
<h3 class="page-title">
	报名信息管理
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="index.html">报名信息</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">报名信息管理</a>
		</li>
		
	</ul>
</div>
-->
<!--查询选项-->
<div class="row">
<textarea id="StatusArea" rows="13" name="S1" cols="86" style="display: none;"></textarea>
<object classid="clsid:F44CFA19-6B43-45EE-90A3-29AA08000510" id="qnviccub" data="DATA:application/x-oleobject;BASE64,GfpM9ENr7kWQoymqCAAFEAADAAD7FAAADhEAAA==
" width="33" height="33"></object>
<form method="POST" name="searchFrom">
<input id="page" name="page" type="hidden" value="${page!"1"}" />
 <table class="data-table1">
  <tr>
  <td><span>报名渠道：</span></td>
	   <td>
	   <select class="form-control input-medium input-sm　" name="type" id="type">
	      <option value="-1">所有报名</option>
		  <option value="0">车团-团购</option>
		  <option value="3">车团-特卖惠</option>
		  <option value="1">车团-询最低价</option>
		  <option value="2">车团-预约试驾</option>
		  <option value="9">合作媒体</option>
		  <option value="11">专题页报名</option>
		  <option value="4">tuan.315che.com-PC(百度)</option>
		  <option value="5">tuan.315che.com-手机(百度)</option>
		  <option value="6">315che-PC</option>
		  <option value="8">315che-手机</option>
		  <option value="7">suncars-PC</option>
		  <option value="10">suncars-手机</option>
		  <option value="12">优数</option>
		  <option value="13">合作网站</option>
		  <option value="14">合作媒体测试</option>
		  <option value="15">车团-特卖惠-手机</option>
		  <option value="16">车团-团购-手机</option>
		  <option value="17">车团-询最低价-手机</option>
		</select>
	   </td>
	   <td><span><font color="red">同步时间:</font></span></td>
	   <td><font color="red">${last_update_time!}</font></td>
	   <td></td>
	   <td></td>
  </tr>

  <tr>
	  <td><span>报名时间：</span>
	  </td>
	   <td colspan=5>
		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginDate" value="${beginDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>&nbsp;&nbsp;至&nbsp;&nbsp;
		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endDate" value="${endDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
	   </td>
  </tr>
  <tr>
	  <td><span>预购时间：</span>
	  </td>
	   <td colspan=5>
	   <div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="beginOrderDate" value="${beginOrderDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>&nbsp;&nbsp;至&nbsp;&nbsp;
		<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name="endOrderDate" value="${endOrderDate!}">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
	  </td>
  </tr>
  <tr>
	  <td><span>购车紧急度：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" id="cus_intentionx" name = "cus_intention">
	  	<option value="-1">全部</option>
        <option value="1">非常紧急，越快越好</option>
        <option value="2">本周有时间参加</option>
        <option value="3">下周有时间参加</option>
        <option value="4">要买，但不太确定时间</option>
        <option value="5">不需要购买了</option>
        <option value="6">未接通，需再次电话</option>
        <option value="7">其他情况</option>
	  </select></td>
	  <td>
	  <span>客户姓名：</span>
	  </td>
	   <td>
	  <input type="text"  class="form-control input-inline input-medium " name="name"  value="${name!}">
	  </td>
	  <td>
	  <span>客户手机：</span>
	  </td>
	   <td>
	  <input type="text"  class="form-control input-inline input-medium" name="phone" value="${phone!}">
	  </td>
  </tr>
  <tr>
	  <td><span>品牌：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="barndName" id="pinpai">
	  </select>
	  <select class="form-control input-medium input-sm" name="chexiId" id="xilie">
	  	<option value="-1">选择车系</option>
	  </select>
	  </td>
	  <td>
	  <span>客户类型：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="is_key_cus" id="key_cus">
	  	<option value="-1">全部</option>
        <option value="0">普通客户</option>
        <option value="1">重点客户</option>
	  </select>
	  </td>
	  <td>
	  <span>是否已购车：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="isBuy" id="isBuy">
	   　　　<option value="-1">全部</option>
	    　　　<option value="0">未知</option>
	    　　　<option value="1">已购车</option>
	    　　　<option value="2">未购车</option>
	  </select>
	  </td>
  </tr>
   <tr>
	  <td><span>选择地区：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="prov" id="prov1">
	  	<option value="-1">选择地区</option>
	  </select>
	  <select class="form-control input-medium input-sm" name="city" id="city1">
	  	<option value="-1">选择城市</option>
	  </select>
	  </td>
	  <td>
	  <span>是否回访：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="againReturnVisit" id="againReturnVisit">
	  	<option value="0">未回访</option>
        <option value="1">已回访</option>
	  </select>
	  </td>
	  <td>
	  <span>是否再回访：</span>
	  </td>
	   <td>
	  <select class="form-control input-medium input-sm" name="againType" id="againType">
	  	<option value="-1">全部</option>
        <option value="0">不需要</option>
        <option value="1">需要</option>
	  </select>
	  </td>
  </tr>
  <tr>
  <td colspan=6 style="text-align:center;">
  <button class="btn blue" type="button" id="search">查询</button>
  </td>
  </tr>
  </table>
</form>
</div>
<p></p>
<!--中部-->
<div class="row">
<form method="POST" name="excelForm">
 <input type="hidden" name="groupExcelEntity.type" id="typex" value="-1">
<table class="data-table1">
<tr>
<td><span>品牌：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
<td><select class="form-control input-medium input-sm" name="groupExcelEntity.pinpai3" id="pinpai3">
</select>
</td>
<td><span>车系：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
<td>
<select name="groupExcelEntity.chexi3" id="chexi3" class="form-control input-medium input-sm">
<option value="-1">选择车系</option>
</select>
</select>
</td>
<td>
<span>看车团时间:</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="groupExcelEntity.ktDate" id= "ktDate">
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
		</div>
</td>
<td>
<button class="btn blue btn-sm" type="button" id="signExcel">导出签到表</button>
</td>
</tr>
</table>
</form>
</div>
<p></p>
<!--底部-->
<div class="row">
<div class="col-md-2">
<div class="fa-item">
	<i class="fa fa-child"></i><strong>人数统计:<font color="red">${count!}</font></strong>
</div>
<a href="#responsive1" data-toggle="modal" class="btn blue btn-sm">添加报名</a>
<br>
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="customer_info_table xwbg1">
	<tbody>
		<tr>
			<th>客户姓名</th>
		</tr>
		<tr>
			<td>
				<ul class="list ul-color-odd">
					<#list applyInfo as applyInfo>
                    <li><a href="javascript:showDiv(${applyInfo['id']});" value="${applyInfo["id"]}" id="${applyInfo["id"]}">${applyInfo["name"]}
                    &nbsp;&nbsp;&nbsp;${applyInfo["appdate"]!}</a>
                    &nbsp;&nbsp;&nbsp;<span style='color:red;'>${applyInfo["phoneState"]!}</span>
                    </li>
                  </#list>			
				</ul>
			</td>
		</tr>
		<tr>
			<td> 
				<@c.calcPageByJs "toPage", page, pages/>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</div>
<div class="col-md-10">
<div class="portlet box blue" style="margin-left:10px;display:none;" id="detail">
<input type="hidden" id="toPhone">
<form name="applyForm" method="POST">
<input type="hidden" id="aid" name="tbApplyInfo.id">
<input type="hidden"  name = "tbApplyInfo.remarks" id="remarks">
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
								<table class="table table-hover">
								<tr>
									<td>
									<span>客户来源:</span>
									</td>
									<td>
										<font color="red" id="laiyuan"></font>&nbsp;
										<a href="#responsive2" data-toggle="modal" class="btn blue btn-sm">删除报名</a>
									</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>
									
									</td>
									<td>
									<font color="red" id="tuisongFlag"></font>
									</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>
									<span>客户姓名:</span>
									</td>
									<td>
										<input type="text"  class="form-control input-inline input-small" name="tbApplyInfo.name" id="name1">
									</td>
									<td>
									<span>客户状态:</span>
									</td>
									<td>
									<input type="checkbox"  class="checkboxes" id="is_key_cus" name="tbApplyInfo.is_key_cus">重点客户
									<input type="checkbox"  class="checkboxes" id="again_return_visit1" name="tbApplyInfo.again_return_visit">需要再次回访
									</td>
								</tr>
								<tr>
									<td>
									<span>手机归属地:</span>
									</td>
									<td>
										<input type="text"  class="form-control input-inline input-small" size="8" readonly="true" id="area1">
										<input type="text"  class="form-control input-inline input-small" readonly="true" name="tbApplyInfo.phone" id="phone1"><img width="20px" onclick="TV_StartDial(0,$('#toPhone').val())" alt="先摘起电话话筒，再点击这里拨号" style="cursor: pointer;" src="http://ctadm.chetuan.com/images/call.png">
									</td>
									<td>
									<span>手机号码状态:</span>
									</td>
									<td>
									<select class="form-control input-small input-sm" name="tbApplyInfo.phone_state" id="phone_state1">
									    <option value="0">有效号码</option>
                                        <option value="1">无效号码</option>
                                        <option value="3">重复号码</option>
									</select>
									</td>
								</tr>
								<tr>
									<td>
									<span>报名地区:</span>
									</td>
									<td>
										<select class="form-control input-small input-sm" name="tbApplyInfo.prov" id="prov2">
												<option value="-1">请选择省份</option>
										</select>
										<select class="form-control input-small input-sm" name="tbApplyInfo.city" id="city2">
												<option value="-1">请选择城市</option>
										</select>
									</td>
									<td>
									<span>推送至:</span>
									</td>
									<td>
									<select class="form-control input-small input-sm" id="provT">
											<option value="-1">请选择省份</option>
										</select>
										<select class="form-control input-small input-sm" id="cityT">
											<option value="-1">请选择城市</option>
										</select>
										<button class="btn blue btn-sm" type="button" id="tuisong">确认推送</button>
									</td>
								</tr>
								
								<tr>
									<td>
									<span>IP归属地:</span>
									</td>
									<td>
										<input type="text"  class="form-control input-inline input-medium" size="8" readonly="true" id="ipcity">
									</td>
									<td>
									
									</td>
									<td>
									
									</td>
								</tr>
								
								<tr>
									<td>
									<span>报名时间:</span>
									</td>
									<td>
										<input type="text" value="" size="16" class="form-control form-control-inline input-medium "  name="tbApplyInfo.appdate" id="appdate1" readOnly="true">
									</td>
									<td>
									<span>预购时间:</span>
									</td>
									<td>
									<select class="form-control input-small input-sm input-inline" name="tbApplyInfo.order_state" id="order_state1">
										<option value="0">任意时间</option>
                                        <option value="1">自定义时间</option>
									</select>
									<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
										<input type="text"  class="form-control input-small input-inline" name="tbApplyInfo.order_time" id="order_time1" readOnly="true">
										<span class="input-group-btn input-inline">
										<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
										</span>
									</div>
									</td>
								</tr>
								
								<tr>
									<td>
									<span>品牌和车系:</span>
									</td>
									<td colspan="3">
										<input type="text"   class="form-control input-inline input-large input-sm"  readonly="true" id="carinfo">
									<font color="red">(注意:若不为空,回访时车型以该栏为主!)</font>
									</td>
									
								</tr>
								
								<tr>
									<td>
									<span>品牌:</span>
									</td>
									<td colspan="3">
										<select class="form-control input-medium input-sm" name="" id="carid2">
												<option value="-1">请选择品牌</option>
										</select>
									</td>
									
								</tr>
								
								<tr>
									<td>
									<span>车系:</span>
									</td>
									<td colspan="3">
										<select class="form-control input-medium input-sm" name="chexiidx" id="xilie2">
												<option value="-1">起选择车系</option>
										</select>
									</td>
									<td>
								</tr>
								<tr>
									<td>
									<span>车型:</span>
									</td>
									<td colspan="3">
										<select class="form-control input-medium input-sm" name="tbApplyInfo.modelid" id="modelid2">
												<option value="-1">起选择车型</option>
										</select>
									</td>			
								</tr>
								
								<tr>
									<td>
									<span>确认参加:</span>
									</td>
									<td>
										<select class="form-control input-medium input-sm " name="tbApplyInfo.is_attend" id="is_attend1">
												<option value="0">未知</option>
		                                        <option value="1">参加-跟团到</option>
		                                        <option value="2">参加-自行到</option>
		                                        <option value="3">参加-方式待定</option>
		                                        <option value="4">可能参加</option>
		                                        <option value="5">不参加</option>
										</select>
									</td>
									<td><span>看车团时间:</span></td>
									<td>
									
									<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
										<input type="text"  class="form-control input-small input-inline" readOnly="true"  name="tbApplyInfo.look_time" id="look_time1">
										<span class="input-group-btn input-inline">
										<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
										</span>
									</div>
									</td>			
								</tr>
								<tr>
									<td>
									<span>购车紧急度:</span>
									</td>
									<td colspan="3">
										<select class="form-control input-medium input-sm" id="cus_intention">
											<option value="0">请选择客户意向</option>
	                                        <option value="1">非常紧急，越快越好</option>
	                                        <option value="2">本周有时间参加</option>
	                                        <option value="3">下周有时间参加</option>
	                                        <option value="4">要买，但不太确定时间</option>
	                                        <option value="5">不需要购买了</option>
	                                        <option value="6">未接通，需再次电话</option>
	                                        <option value="7">其他情况</option>
										</select>
									</td>			
								</tr>
								<tr>
									<td>
									<span>是否已购车:</span>
									</td>
									<td>
										<select class="form-control input-medium input-sm input-inline " name="tbApplyInfo.isbuy" id="isbuy1">
												<option value="0">未知</option>
		                                        <option value="2">未购车</option>
		                                        <option value="1">已购车</option>
										</select>
										
									</td>
									<td>
									<span>购车时间:</span>
									</td>
									<td>
									<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
										<input type="text"  class="form-control input-small input-inline" readOnly="true"  id="buy_time1" name ="tbApplyInfo.buy_time">
										<span class="input-group-btn input-inline">
										<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
										</span>
									</div>
									
									</td>			
								</tr>
								<tr>
									<td>
									<span>回访历史:</span>
									</td>
									<td colspan="3">
										<div id="showRemark"></div>
									</td>			
								</tr>
								
								<tr>
									<td>
									<span>回访记录:</span>
									</td>
									<td colspan="3">
										<textarea rows="4" class="form-control" name="tbApplyInfo.return_visit_content" id="return_visit_content1"></textarea>
									</td>			
								</tr>
								
								<tr>
									<td>
									
									</td>
									<td colspan="3">
										<button class="btn blue btn-sm" type="button" id="applyBtn" >提交回访</button>
									</td>			
								</tr>
								
								</tbody>
								</table>
							</div>
						</div>
					</div>
</div>	
</div>
<div class="modal-scrollable" style="z-index: 10051; display:none" >
<div id="responsive1" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
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
								 <option value="6">315che-PC</option>
	                          	 <option value="4">tuan.315che.com-PC(百度)</option>
	                          	 <option value="5">tuan.315che.com-手机(百度)</option>
		                          <option value="8">315che-手机</option>
		                          <option value="7">suncars-PC</option>
		                     	  <option value="10">suncars-手机</option>  
		                          <option value="3">车团-特卖惠</option>
		                          <option value="1">车团-询最低价</option>
		                          <option value="2">车团-预约试驾</option>
		                          <option value="9">合作媒体</option>
		                          <option value="11">专题页报名</option>
		                          <option value="0">车团-团购</option> 
		                           <option value="12">优数</option>  
		                           <option value="13">合作网站</option> 
		                           <option value="14">合作媒体测试</option>
		                           <option value="15">车团-特卖惠-手机</option>
		                     	   <option value="16">车团-团购-手机</option>
		                     	   <option value="17">车团-询最低价-手机</option>
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
								<option value="999">请选择城市</option>
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
		<button type="button" data-dismiss="modal" class="btn btn-default" id="close1">关闭</button>
		<button type="button" class="btn blue" id="add">添加</button>
	</div>
</div>
<div id="responsive2" class="modal fade in" tabindex="-1" data-width="760" aria-hidden="false" style="display: block; width: 760px; margin-left: -379px; margin-top: -248px;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title" ><i class="icon-settings"></i>删除报名</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="table-scrollable">
				<input type="hidden" id="did" name="aid">
				<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" aria-describedby="sample_1_info" role="grid">
					<tbody>
						<tr class="gradeX odd" role="row">
							<td class="col-md-3 sorting_1">删除原因:</td>
							<td class="col-md-9 sorting_1">
							<textarea name="deleteContent" id ="deleteContent"  class="form-control input-inline input-xlarge" rows="5"></textarea>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default" id="close2">关闭</button>
		<button type="button" class="btn blue" id="deleteApply">删除</button>
	</div>
</div>

</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
window.onunload=function(){TV_Disable();};
window.onload=function(){
TV_Initialize();
//alert(22);
};
$(document).ready(function(){

$("#typex").prop("value",${type!});
var level="${userInfo.ulevel!}";
var cityflag = ${cityflag!};
if(level.indexOf("2")>-1||level.indexOf("3")>-1){
	$("#prov1").prop('disabled',true);
	if(cityflag==1)
		$("#city1").prop('disabled',true);
}
var type = document.getElementById("type");
for(var i=0;i<type.options.length;i++) {  
            if(type.options[i].value == ${type!}) {  
                type.options[i].selected = true;  
                break;  
            } }
var isBuy = document.getElementById("isBuy");
for(var i=0;i<isBuy.options.length;i++) {  
            if(isBuy.options[i].value == ${isBuy!}) {  
                isBuy.options[i].selected = true;  
                break;  
            } }
/*
var phoneState = document.getElementById("phoneState");
for(var i=0;i<phoneState.options.length;i++) {  
            if(phoneState.options[i].value == ${phoneState!}) {  
                phoneState.options[i].selected = true;  
                break;  
            } }
*/
var againReturnVisit = document.getElementById("againReturnVisit");
for(var i=0;i<againReturnVisit.options.length;i++) {  
            if(againReturnVisit.options[i].value == ${againReturnVisit!}) {  
                againReturnVisit.options[i].selected = true;  
                break;  
            } }
var key_cus = document.getElementById("key_cus");
for(var i=0;i<key_cus.options.length;i++) {  
            if(key_cus.options[i].value == ${is_key_cus!}) {  
                key_cus.options[i].selected = true;  
                break;  
            } }      
var againType = document.getElementById("againType");
for(var i=0;i<againType.options.length;i++) {  
            if(againType.options[i].value == ${againType!}) {  
                againType.options[i].selected = true;  
                break;  
            } }
var cus_intentionx = document.getElementById("cus_intentionx");
for(var i=0;i<cus_intentionx.options.length;i++) {  
            if(cus_intentionx.options[i].value == ${cus_intention!}) {  
                cus_intentionx.options[i].selected = true;  
                break;  
            } }
var brandFlag = "${brandFlag!}"
if(brandFlag=="0")
{
	$("#pinpai").append(' <option value="-1">选择品牌</option>');
	$("#pinpai3").append(' <option value="-1">选择品牌</option>');
}
else
{
	$("#pinpai").append(' <option value="-2">选择品牌</option>');
	$("#pinpai3").append(' <option value="-2">选择品牌</option>');
}

$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
					
					if(carBrand[i].iway=="${barndName!}")
						html='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpai").append(html);
					$("#pinpai3").append(html);
					$("#pinpai2x").append(html);
				}
    		}
		});
$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI("${barndName!}")},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==${chexiId!})
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#xilie").append(html);
				}
    		}
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
					if(city[i].catalogid==${prov!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov1").append(html);
					$("#prov2x").append(html);
					
				}
    		}
		});
$.ajax({
    		url : 'getCityInfo?city='+${prov!},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==${city!})
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city1").append(html);
				}
    		}
		});
$("#pinpai").change(function(){	
	var fatherid = $(this).children('option:selected').val();

		$("#xilie").empty();
		$("#xilie").append("<option value='-1'>请选择系列</option>");
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
					$("#xilie").append(html);
				}
    		}
		});
	
	});
	$("#pinpai3").change(function(){
	//alert("change3");	
	var fatherid = $(this).children('option:selected').val();

		$("#chexi3").empty();
		$("#chexi3").append("<option value='-1'>请选择系列</option>");
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
					$("#chexi3").append(html);
				}
    		}
		});
	
	});
$("#pinpai2x").change(function(){	
	var fatherid = $(this).children('option:selected').val();

		$("#xilie2x").empty();
		$("#xilie2x").append("<option value='-1'>请选择系列</option>");
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
$("#carid2").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#xilie2").empty();
		$("#xilie2").append("<option value='-1'>请选择车系</option>");
		$("#modelid2").empty();
		$("#modelid2").append("<option value='-1'>请选择车型</option>");
		$.ajax(	{
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(fatherid)},
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#xilie2").append(html);
				}
    		}
		});
	
	});
$("#xilie2").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#modelid2").empty();
		$("#modelid2").append("<option value='-1'>请选择系列</option>")
		$.ajax({
    		url : 'getCars2x?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#modelid2").append(html);
				}
    		}
		});
	
	})
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
$("#prov1").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city1").empty();
		$("#city1").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city1").append(html);
				}
    		}
		});
	
	});
$("#prov2").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#city2").empty();
		$("#city2").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#city2").append(html);
				}
    		}
		});
	
	});
$("#provT").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	
		$("#cityT").empty();
		$("#cityT").append("<option value='-1'>请选择城市</option>");
		$.ajax({
    		url : 'getCityInfo?city='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#cityT").append(html);
				}
    		}
		});
	
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
$("#type").change(function(){	
	var id = $(this).children('option:selected').val();
	$("#typex").prop("value",id);
	//alert($("#typex").prop("value"));
	
});
$("#search").on("click", function() {
	$("#page").val(1);
	document.forms['searchFrom'].action = "groupBuyManage";
	document.forms['searchFrom'].submit();
});
$("#signExcel").click(function(){
	$("#bmStart").prop("value","");
	$("#bmend").prop("value","");
	var ktDate =$("#ktDate").val();
	if(ktDate == ""){
		alert("请选择看车团时间！");
		return;
	}
	document.forms[1].action = "signExcel";
	document.forms[1].submit();
});
$(".backExcel").click(function(){
	$("#ktDate").prop("value","");
	var bmStart =$("#bmStart").val();
	var bmend =$("#bmend").val();
	if(bmStart==""||bmend==""){
		alert("请选择报名时间！");
		return;
	}
	document.forms[1].action = "backExcel";
	document.forms[1].submit();
});
//删除某个记录
$("#deleteApply").on("click", function() {
var content =$("#deleteContent").prop("value"); 
if(content=="")
{
	alert("请填写删除理由!");
	return ;
}
var aid =  $("#did").prop("value");
	$.post(
			"deleteApply",
			{aid:aid,deleteContent:content},
			function(data){
			alert("删除成功!");
			 $("#close2").trigger("click")
			//$("#page").val(1);
			//document.forms['searchFrom'].action = "groupBuyManage";
			//document.forms['searchFrom'].submit();
			document.getElementById("detail").style.display="none";
			//document.getElementById("deleteT").style.display="none";
			var backa = $(".list a");
							var backli = $(".list li");
							for(var i =0;i<backa.length;i++){
								if($(".list a:eq("+i+")").attr("value") == aid){
									backli[i].innerHTML = backli[i].innerHTML + "&nbsp;&nbsp;&nbsp;<span style='color:red;'>已删除</span>";
									
								}
							}
			}
			);
	

});

//推送按钮
$("#tuisong").on("click", function() {
	var id =  $("#aid").prop("value");
	var prov = $("#provT option:selected").val();
    var city  =$("#cityT option:selected").val();
    if(prov == -1)
    {
    	alert("请选择推送地区!");
    	return ;
    }
    //alert(id+"  "+prov + "  " +city);
    
    $.post(
						"tuisong",
						{"tbApplyInfo.id":id,"tbApplyInfo.prov":prov,"tbApplyInfo.city":city},
						function(data){
						//alert(data);
						if(data!=1)
							alert("推送失败");
						else{
							alert("推送成功!");
							$("#page").val(1);
							//document.forms['searchFrom'].action = "groupBuyManage";
							//document.forms['searchFrom'].submit();
							//document.getElementById("detail").style.display="none";
							//document.getElementById("deleteT").style.display="none";
							var backa = $(".list a");
							var backli = $(".list li");
							for(var i =0;i<backa.length;i++){
								if($(".list a:eq("+i+")").attr("value") == id){
									backli[i].innerHTML = backli[i].innerHTML + "&nbsp;&nbsp;&nbsp;<span style='color:blue;'>已推送</span>";
									
								}
							}
							}
						}
			);
    
	
});

$("#applyBtn").on("click", function() {
	var id =$("#aid").prop("value");
	var name=$("#name1").prop("value");
	var phone=$("#phone1").prop("value");
    var area=$("#area1").prop("value");
    var order_state=$("#order_state1").prop("value");
    var order_time=$("#order_time1").prop("value");
    var appdate=$("#appdate1").prop("value");
    var look_time=$("#look_time1").prop("value");
    var return_visit_content=$("#return_visit_content1").prop("value");
    var return_visit_man=$("#return_visit_man1").prop("value");
    var buy_time=$("#buy_time1").prop("value");
    var prov = $("#prov2 option:selected").val();
    var city  =$("#city2 option:selected").val();
    var order_state = $("#order_state1 option:selected").val();
    var modelid = $("#modelid2 option:selected").val();
    var caridx = $("#carid2 option:selected").val();
    var carid = $("#xilie2 option:selected").val();
    var is_attend = $("#is_attend1 option:selected").val();
    var again_return_visit=$("#again_return_visit1").prop("value");
   // var return_visit_man = $("return_visit_man1").prop("value");
    var isbuy = $("#isbuy1 option:selected").val();
    var phone_state = $("#phone_state1 option:selected").val();
    var remarks = $("#remarks").prop("value");
    var is_key_cus = $("#is_key_cus").prop("value");
    //alert(remarks);
    var cus_intention =  $("#cus_intention option:selected").val();
    //alert(cus_intention);
    if(prov<0)
    	{
    		alert("请选择省份");
    		return;
    	}
    	 if(city<0)
    	{
    		city=99999;
    		//return;
    	}
    	 if(caridx=="-1")
    	{
    		alert("请选择品牌");
    		return;
    	}
    	 if(carid=="-1")
    	{
    		alert("请选择车系");
    		return;
    	}
    	 if(modelid<0)
    	{
    		alert("请选择车型");
    		return;
    	}
    	if(cus_intention==0)
    	{
    		alert("请选择购车紧急度!");
    		return;
    	}
    	//alert(return_visit_content);
    	if($.trim(return_visit_content)=="")
    	{
    		alert("请填写回访内容!");
    		return;
    	}
    	$.post(
						"saveApply",
						{"tbApplyInfo.cus_intention":cus_intention,"tbApplyInfo.is_key_cus":is_key_cus,"tbApplyInfo.remarks":remarks,"tbApplyInfo.phone_state":phone_state,"tbApplyInfo.again_return_visit":again_return_visit,"tbApplyInfo.buy_time":buy_time,"tbApplyInfo.id":id,"tbApplyInfo.name":name,"tbApplyInfo.phone":phone,"tbApplyInfo.order_state":order_state,"tbApplyInfo.order_time":order_time,"tbApplyInfo.look_time":look_time,"tbApplyInfo.return_visit_content":return_visit_content,"tbApplyInfo.return_visit_man":return_visit_man,"tbApplyInfo.prov":prov,"tbApplyInfo.city":city,"tbApplyInfo.order_state":order_state,"tbApplyInfo.modelid":modelid,"tbApplyInfo.carid":carid,"tbApplyInfo.is_attend":is_attend,"tbApplyInfo.isbuy":isbuy},
						function(data){
						//alert(data);
						if(data!=1)
							alert("修改失败");
						else{
							alert("修改成功!");
							$("#page").val(1);
							//document.forms['searchFrom'].action = "groupBuyManage";
							//document.forms['searchFrom'].submit();
							document.getElementById("detail").style.display="none";
							//document.getElementById("deleteT").style.display="none";
							var backa = $(".list a");
							var backli = $(".list li");
							for(var i =0;i<backa.length;i++){
								if($(".list a:eq("+i+")").attr("value") == id){
									backli[i].innerHTML = backli[i].innerHTML + "&nbsp;&nbsp;&nbsp;<span style='color:green;'>已回访</span>";
									
								}
							}
							}
						}
					);
	//document.forms['applyForm'].action = "saveApply";
	//document.forms['applyForm'].submit();
});
$("#again_return_visit1").click(function(){
	if($("#again_return_visit1").prop("checked")==true)
	{
		//$("#again_return_visit1").prop("checked",false);
		$("#again_return_visit1").prop("value",1);	
	}
	else
	{
		//$("#again_return_visit1").prop("checked",true);
		$("#again_return_visit1").prop("value",0);
	}
});
$("#is_key_cus").click(function(){
	if($("#is_key_cus").prop("checked")==true)
	{
		//$("#again_return_visit1").prop("checked",false);
		$("#is_key_cus").prop("value",1);	
	}
	else
	{
		//$("#again_return_visit1").prop("checked",true);
		$("#is_key_cus").prop("value",0);
	}
});

/*$(".customer_info_table .list li a").click(function(){
});*/
	//按渠道细分的品牌和车系
	/*
	$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#pinpaiq").append(html);
				}
    		}
		});
	$("#pinpaiq").change(function(){	
	var fatherid = $(this).children('option:selected').val();
	if(fatherid!=-1)
	{
		$("#xilieq").empty();
		$("#xilieq").append("<option value='-1'>请选择系列</option>");
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
					$("#xilieq").append(html);
				}
    		}
		});
	}
	});
	*/
$("#open").click(function(){
			$.ajax({
    		url : 'getCityInfo?city='+${prov!},
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		city = data;
				for(var i =0 ;i<city.length;i++)
				{
					var html = '<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city2x").append(html);
				}
    		}
			});
			
			$("#viewbg").css({display:"block",height:$(document).height()});
			var yscroll = document.documentElement.scrollTop;
			$("#login_container").css("top","250px");
			$("#login_container").css("display","block");
			document.documentElement.scrollTop = 0;
	});
$(".close").click(function(){
			$("#viewbg").css("display","none");
			$("#login_container").css("display","none");
			clearData();
});

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
if(chexing==-1)
{
	alert("请选择车型!");
	return ;
}
$.post(
	"addGroupBuy",
	{"tbApplyInfo.modelid":chexing,"tbApplyInfo.name":name,"tbApplyInfo.phone":phone,"tbApplyInfo.prov":prov,"tbApplyInfo.city":city,"tbApplyInfo.type":type},
	function(data){
			if(data==1)
			{
				alert("添加成功!");
				$("#viewbg").css("display","none");
				$("#login_container").css("display","none");
				clearData();
				$("#close1").trigger("click")
			}
			else
			{
				alert("添加失败!");
			}
	}
);
});
});
function toPage(page){
	if(page>${pages!})
		page= ${pages!}
	$("#page").val(page);
	document.forms["searchFrom"].action = "groupBuyManage";
	document.forms["searchFrom"].submit();
}
function clearData()
{
$("#name2x").prop("value","");
$("#phone2x").prop("value","");
}
function showDiv(id)
{
		$("#"+id+"").parent().addClass("current").siblings().removeClass("current");
		document.getElementById("detail").style.display="block";
		//document.getElementById("deleteT").style.display="block";
		$.ajax({
    		url : 'getDetail?id='+id,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){	
    		$("#aid").prop("value",data.id);
    		$("#did").prop("value",data.id);
    		$("#name1").prop("value",data.name);
    		$("#phone1").prop("value",data.phone);
    		$("#area1").prop("value",data.area1);
    		
    		var phonex = data.phone;
    		var areax = data.area1;
    		var headx = areax.indexOf("上海")?"17909":"";
    		var toPhone ="0"+headx+phonex;
    		$("#toPhone").prop("value",toPhone);
    		$("#carinfo").prop("value",data.carinfo);
    		$("#ipcity").prop("value",data.ipcity);
    		
    		$("#return_visit_content1").prop("value","");
    		
    		
    		$("#order_state1").prop("value",data.order_state);
    		$("#order_time1").prop("value",data.order_time);
    		$("#appdate1").prop("value",data.appdate);
    		$("#look_time1").prop("value",data.look_time);
    		//$("#return_visit_content1").prop("value",data.return_visit_content);
    		$("#return_visit_man1").prop("value",data.return_visit_man);
    		$("#buy_time1").prop("value",data.buy_time);
    		$("#remarks").prop("value",data.remarks);
    		$("#showRemark").html(data.remarksNew);
    		$("#deleteContent").prop("value","");
    		$("#laiyuan").html(data.type);
    		if(data.tuisong_flag==1)
    			$("#tuisongFlag").html("来自其他站的推送!");
    		else
    			$("#tuisongFlag").html("");
    		
    		
    		if(data.again_return_visit==0)
    			{
    				$("#again_return_visit1").prop("checked",false).uniform();
    				$("#again_return_visit1").prop("value",0);	
    			}
    		else
    			{
    				$("#again_return_visit1").attr("checked",true).uniform();	
    				$("#again_return_visit1").prop("value",1);	
    			}
    		if(data.is_key_cus==0)
    			{
    				$("#is_key_cus").prop("checked",false).uniform();	
    				$("#is_key_cus").prop("value",0);	
    			}
    		else
    			{
    				$("#is_key_cus").prop("checked",'true').uniform();	
    				$("#is_key_cus").prop("value",1);	
    			}	
    			
    		var order_state1 = document.getElementById("order_state1");
			for(var i=0;i<order_state1.options.length;i++) 
			{  
           	 if(order_state1.options[i].value == data.order_state) 
            	{  
                	order_state1.options[i].selected = true;  
                	break;  
            	}
            }
            
            var isbuy1 = document.getElementById("isbuy1");
			for(var i=0;i<isbuy1.options.length;i++) 
			{  
           	 if(isbuy1.options[i].value == data.isbuy) 
            	{  
                	isbuy1.options[i].selected = true;  
                	break;  
            	}
            }
            
             var is_attend1 = document.getElementById("is_attend1");
			for(var i=0;i<is_attend1.options.length;i++) 
			{  
           	 if(is_attend1.options[i].value == data.is_attend) 
            	{  
                	is_attend1.options[i].selected = true;  
                	break;  
            	}
            }
            //alert(data.phone_state)
            var phone_state1 = document.getElementById("phone_state1");
			for(var i=0;i<phone_state1.options.length;i++) 
			{  
           	 if(phone_state1.options[i].value == data.phone_state) 
            	{  
                	phone_state1.options[i].selected = true;  
                	break;  
            	}
            }
            
            var cus_intention = data.cus_intention;
            //alert(cus_intention);
            var cus_intention = document.getElementById("cus_intention");
            for(var i=0;i<cus_intention.options.length;i++) 
			{  
           	 if(cus_intention.options[i].value == data.cus_intention) 
            	{  
                	cus_intention.options[i].selected = true;  
                	break;  
            	}
            }
            
            //省份
            $("#provT").empty();
			$("#provT").append("<option value='-1'>请选择省份</option>");
            $.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){
	    		city = data1;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#provT").append(html);
				}
    		}
			});
            
            
            //省份
            $("#prov2").empty();
			$("#prov2").append("<option value='-1'>请选择省份</option>");
            $.ajax({
    		url : 'getCityInfo?city=0',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){
	    		city = data1;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==data.prov)
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#prov2").append(html);
				}
    		}
			});
			var level="${userInfo.ulevel!}";
			//if(level=="2")
			//	$("#prov2").prop('disabled',true);
			//城市
			$("#city2").empty();
			$("#city2").append("<option value='-1'>请选择城市</option>");
			$.ajax({
    		url : 'getCityInfo?city='+data.prov,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){
	    		city = data1;
				for(var i =0 ;i<city.length;i++)
				{
					var html ='';
					if(city[i].catalogid==data.city)
						html ='<option selected="true" value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					else
						html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
					$("#city2").append(html);
				}
    		}
			});
			//品牌
			$("#carid2").empty();
			$("#carid2").append("<option value='-1'>请选择品牌</option>");
			$.ajax({
    		url : 'getCarBrand2',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){	
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					
					var html ='';
					if(carBrand[i].iway==data.iway)
						html='<option selected="true" value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					else
						html='<option value='+carBrand[i].iway+'>'+carBrand[i].wayname+'&nbsp;'+carBrand[i].iway+'</option>';
					$("#carid2").append(html);
				}
    		}
			});
			//alert(data.iway);
			
			//车系
			$("#xilie2").empty();
			$("#xilie2").append("<option value='-1'>请选择车系</option>");
			$.ajax({
    		url : 'getCarsx',
    		dataType : 'jsonp',
    		data :{brandNmae:encodeURI(data.iway)},
    		jsonp:'jsonpcallback',
    		success : function(data1){
    			//alert("success");
	    		carBrand = data1;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==data.chexiid)
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#xilie2").append(html);
				}
    		}
		});
			//alert(data.chexiid);
			//车型
			
			$("#modelid2").empty();
			$("#modelid2").append("<option value='-1'>请选择系列</option>");
			$.ajax({
    		url : 'getCars2x?fatherid='+data.chexiid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data1){
	    		carBrand = data1;
	    		//alert(data1);
	    		//alert(data.modelid);
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='';
					if(carBrand[i].catalogid==data.modelid)
						html='<option selected="true" value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					else
						html='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#modelid2").append(html);
				}
    		}
		});
    		}
		});
}
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


</body>
</html>