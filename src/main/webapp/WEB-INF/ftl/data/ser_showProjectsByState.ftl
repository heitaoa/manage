<#import "../common.ftl" as c>
<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row">
							<#if state==1>
                        		<a  class="btn blue pull-right" style=" float:right; position:relative; right:50px;" onclick="addProject();">+发起新推广需求</a>
                        	</#if>
                        <div class="col-md-12">
                            <table class="table table-condensed table-bordered table-hover">
                                <thead>
                                <tr role="row" class="heading">
                                    <th>序号</th>
                                    <th>推广编号</th>
                                    <th>申请日期</th>
                                    <th>业务类型</th>
                                    <th>品牌</th>
                                    <th>车系</th>
                                    <th>推广区域</th>
                                    <th>客户名称</th>
                                    <th>关联合同号</th>
                                    <th>责任客服</th>
                                    <th>责任推广</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list list as p>
                                			<tr>
                                    			<td>${p_index+1}</td>
                                    			<td class="pro_num">
                                    				<#if p.get("pro_num")??>
                                    					${p.get("pro_num")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("ini_date")??>
                                    					${p.get("ini_date")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("service_type")??>
                                    					<#switch p.get("service_type") >
															<#case "0">
																看车团
															<#break>
															<#case "1">
																直销
															<#break>
															<#case "2">
																车展
															<#break>
															<#case "3">
																大客户
															<#break>
														</#switch>
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("brand_name")??>
                                    					${p.get("brand_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("car_name")??>
                                    					${p.get("car_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("promo_area")??>
                                    					${p.get("promo_area")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("cust_name")??>
                                    					${p.get("cust_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("contact_num")??>
                                    					${p.get("contact_num")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("custom_service_name")??>
                                    					${p.get("custom_service_name")}
                                    				</#if>
                                    			</td>
                                    			<td>
                                    				<#if p.get("promo_man_name")??>
                                    					${p.get("promo_man_name")}
                                    				</#if>
                                    			</td>
                                    				<#if state==1>
                                    					<td>待审核</td>
                                    					<td>
                                    						<a href="javascript:view('${p.get("pro_num")}');">查看</a>
                                    						<a href="javascript:editProject('${p.get("pro_num")}');">编辑</a>
                                    						<a href="javascript:deleteProject('${p.get("pro_num")}');">删除</a>
                                    					</td>
                                    				<#elseif state==2>
                                    					<#if p.get("pro_state")=="1">
                                    						<td>业务部通过</td>
                                    					<#elseif p.get("pro_state")=="2">
                                    						<td>业务部驳回</td>
                                    					<#elseif p.get("pro_state")=="4">
                                    						<td>推广部驳回</td>
                                    					</#if>
                                    					<td>
                                    						<a href="javascript:view('${p.get("pro_num")}');">查看</a>
                                    					</td>
                                    				<#elseif state==3>
                                    					<td>推广中</td>
                                    					<td>
                                    						<a href="javascript:view('${p.get("pro_num")}');">查看</a>
                                    					</td>
                                    				<#elseif state==4>
                                    					<td>已结束</td>
                                    					<td>
                                    						<a href="javascript:view('${p.get("pro_num")}');">查看</a>
                                    						<a href="javascript:hdxq('${p.get("service_type")!}','${p.get("pro_num")!}');">填写活动详情详情</a>
                                    					</td>
                                    				</#if>
                                			</tr>
                                		</#list>
                                </tbody>
                             </table>
                        </div>
                        
                    </div>
<div id="add" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">新项目</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-12">
    		<form class="form-horizontal" action="ser_addProject"  role="form" id="newProject">
        		<div class="form-body">
            		<div class="form-group">
                		<label class="col-md-2 control-label">发起人</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_man" value="${info.get("id")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("name")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">日期</label>
                    	<div class="col-md-4">
                        	<input type="text" id="sysdate" class="form-control input-medium" value="" disabled="disabled" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">站点</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_org" value="${info.get("orgCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("orgName")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">部门</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_dept" value="${info.get("depCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("depName")}" disabled="disabled" />
                    	</div>
                	</div>
                
                	<div class="form-group">
                		<label class="col-md-2 control-label">业务类型</label>
                    	<div class="col-md-4">
                        	<select class="layout-option form-control input-medium" name="service_type" id="add_service_type">
								<option value="0" selected="selected">看车团</option>
								<option value="1">直销</option>
                            	<option value="2">车展</option>
                            	<option value="3">大客户</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">关联合同号</label>
                    	<div class="col-md-4">
                        <input type="text" class="form-control input-medium" value="" name="contact_num" id="add_contact_num"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">活动名称</label>
                    	<div class="col-md-4">
                       		<input type="text" class="form-control input-medium" name="acti_name" id="add_acti_name"/>
                    	</div>
                    	<label class="col-md-2 control-label">活动执行时间</label>
                    	<div class="col-md-4">
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="acti_exec_date" id="add_acti_exec_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广区域</label>
                    	<div class="col-md-4">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="add_promo_prov">
								<option  value="-1">全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="add_promo_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">客户名称</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" name="cust_name" id="add_cust_name"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">品牌</label>
                    	<div class="col-md-4">
                    		<select class="form-control input-medium" name="brand" id="add_pinpai">
	     						<option value="-1">请选择品牌</option>
	  	 					</select>
                    	</div>
                    	<label class="col-md-2 control-label">车系</label>
                    	<div class="col-md-4">
                    		<select class="form-control  input-medium" name="car" id="add_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  					</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">车型</label>
                    	<div class="col-md-4">
                    		<select class="form-control  input-medium" name="model" id="add_chexing">
	  							<option value="-1">请选择车型</option>
	  						</select>
                    	</div>
                    </div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">合同开始时间</label>
                   		<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_start_date" id="add_contact_start_date">
                            	<span class="input-group-btn">
                            	<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">合同结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_end_date" id="add_contact_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广开始时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_start_date" id="add_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">推广结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_end_date" id="add_promo_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div> 
                	<div class="form-group">
                    	<label class="col-md-2 control-label">目标线索量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')"  onpaste="return false;"  class="form-control input-medium" name="tar_clue_num" id="add_tar_clue_num"/>
                    	</div>
                    
                    	<label class="col-md-2 control-label">目标到达量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-medium" name="tar_reach_num" id="add_tar_reach_num"/>
                    	</div>
               	   </div>
                
                   <div class="form-group">
                    	<label class="col-md-2 control-label">目标成交量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-medium" name="tar_trans_num" id="add_tar_trans_num"/>
                    	</div>
                	</div>
                
                	<div class="form-group">
                    	<label class="col-md-2 control-label">责任客服</label>
                    	<div class="col-md-4">
                       		<select class="layout-option form-control input-medium" name="custom_service" id="add_custom_service">
                        		<#list customServices as c>
                        			<option value="${c.get("id")}">${c.get("name")}</option>
                        		</#list>
                        	</select>
                    	</div>
                	</div>
        	</form>
    	</div>

	</div>           
    </div>
    <div class="modal-footer">
    	<button id="bt_pro_yes" type="button" class="btn blue" onclick="add();">提交</button>
    </div>
</div>
<div id="edit" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">编辑项目</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
			<div class="col-md-12">
    		<form class="form-horizontal" action="ser_editProject"  role="form" id="editProject">
        		<div class="form-body">
        			<div class="form-group">
                		<label class="col-md-2 control-label">推广编号</label>
                		<input type="hidden" id="edit_pro_num_text" name="pro_num"/>
                    	<label class="col-md-4 control-label" style="text-align:left;" id="edit_pro_num"></label>
                	</div>
            		<div class="form-group">
                		<label class="col-md-2 control-label">发起人</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_man" value="${info.get("id")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("name")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">日期</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" value="" disabled="disabled" id="edit_ini_date" />
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">站点</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_org" value="${info.get("orgCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("orgName")}" disabled="disabled" />
                    	</div>
                    	<label class="col-md-2 control-label">部门</label>
                    	<div class="col-md-4">
                    		<input type="hidden" name="ini_dept" value="${info.get("depCode")}"/>
                        	<input type="text" class="form-control input-medium" value="${info.get("depName")}" disabled="disabled" />
                    	</div>
                	</div>

                	<div class="form-group">
                		<label class="col-md-2 control-label">业务类型</label>
                    	<div class="col-md-4">
                        	<select class="layout-option form-control input-medium" name="service_type" id="edit_service_type">
								<option value="0">看车团</option>
								<option value="1">直销</option>
                            	<option value="2">车展</option>
                            	<option value="3">大客户</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">关联合同号</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" value="" name="contact_num" id="edit_contact_num"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">活动名称</label>
                    	<div class="col-md-4">
                       		<input type="text" class="form-control input-medium" name="acti_name" id="edit_acti_name"/>
                    	</div>
                    	<label class="col-md-2 control-label">活动执行时间</label>
                    	<div class="col-md-4">
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="acti_exec_date" id="edit_acti_exec_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广区域</label>
                    	<div class="col-md-4">
                       		<select name="promo_prov" class="form-control input-inline input-small" id="edit_promo_prov">
								<option  value="-1">全国</option>
							</select>
                        	<select name="promo_city" class="form-control input-inline input-small" id="edit_promo_city"> 
								<option  value="-1">请选择城市</option>
							</select>
                    	</div>
                    	<label class="col-md-2 control-label">客户名称</label>
                    	<div class="col-md-4">
                        	<input type="text" class="form-control input-medium" name="cust_name" id="edit_cust_name"/>
                    	</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">品牌</label>
                    	<div class="col-md-4">
                    		<select class="form-control input-medium" name="brand" id="edit_pinpai">
	     						<option value="-1">请选择品牌</option>
	  	 					</select>
                    	</div>
                    	<label class="col-md-2 control-label">车系</label>
                    	<div class="col-md-4">
                    		<select class="form-control  input-medium" name="car" id="edit_chexi">
	  							<option value="-1">请选择车系</option>
	  						</select>
	  					</div>
                	</div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">车型</label>
                    	<div class="col-md-4">
                    		<select class="form-control  input-medium" name="model" id="edit_chexing">
	  							<option value="-1">请选择车型</option>
	  						</select>
                    	</div>
                    </div>
                	<div class="form-group">
                		<label class="col-md-2 control-label">合同开始时间</label>
                   		<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_start_date" id="edit_contact_start_date">
                            	<span class="input-group-btn">
                            	<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">合同结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="contact_end_date" id="edit_contact_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                
                	<div class="form-group">
                		<label class="col-md-2 control-label">推广开始时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_start_date" id="edit_promo_start_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                    	<label class="col-md-2 control-label">推广结束时间</label>
                    	<div class="col-md-4">
                    	
                        	<div class="input-group input-medium date date-picker input-daterange" data-date-format="yyyy-mm-dd">
                            	<input type="text" class="form-control" name="promo_end_date" id="edit_promo_end_date">
                            	<span class="input-group-btn">
                            		<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
                            	</span>
                        	</div>
                    	</div>
                	</div>
                	<div class="form-group">
                    	<label class="col-md-2 control-label">目标线索量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-medium" name="tar_clue_num" id="edit_tar_clue_num"/>
                    	</div>
                    
                    	<label class="col-md-2 control-label">目标到达量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-medium" name="tar_reach_num" id="edit_tar_reach_num"/>
                    	</div>
               	   </div>
                
                   <div class="form-group">
                    	<label class="col-md-2 control-label">目标成交量</label>
                    	<div class="col-md-4">
                        	<input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onpaste="return false;"  class="form-control input-medium" name="tar_trans_num" id="edit_tar_trans_num"/>
                    	</div>
                	</div>
                
                	<div class="form-group">
                    	<label class="col-md-2 control-label">责任客服</label>
                    	<div class="col-md-4">
                       		<select class="layout-option form-control input-medium" name="custom_service" id="edit_custom_service">
                        		<#list customServices as c>
                        			<option value="${c.get("id")}">${c.get("name")}</option>
                        		</#list>
                        	</select>
                    	</div>
                	</div>
        	</form>
    	</div>

	</div>           
    </div>
    <div class="modal-footer">
    	<button id="bt_pro_yes" type="button" class="btn blue" onclick="edit();">提交</button>
    </div>
</div>
<div id="view" class="modal fade" tabindex="-1" data-backdrop="static" data-width="1000">
   	<div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
       <h4 class="modal-title">查看详情</h4>
    </div>
    <div class="modal-body">
         <div class="row" style="margin-left:15px;margin-top:10px;">
         	<div class="col-md-12">
			<div class="col-md-2 text-right">
				<h5>推广编号:</h5>
			</div>
			<div class="col-md-2 text-left">
				<h5><label id="view_pro_num"></label></h5>
			</div>
			<div class="col-md-2 text-right">
				<h5>状态:</h5>
			</div>
			<div class="col-md-2 text-left">
				<h5><label id="view_pro_state"></label></h5>
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-2 text-right">
				<h5>发起人:</h5>
			</div>
			<div class="col-md-2 text-left">
				<h5><label id="view_ini_man_name"></label></h5>
			</div>
			<div class="col-md-2 text-right">
				<h5>部门:</h5>
			</div>
			<div class="col-md-2 text-left">
				<h5><label id="view_dept_name"></label></h5>
			</div>
			<div class="col-md-2 text-right">
				<h5>发起日期:</h5>
			</div>
			<div class="col-md-2 text-left">
				<h5><label id="view_ini_date"></label></h5>
			</div>
		</div>
	</div>
	<hr/>
	<div  class="row">
		<div class="col-md-12">
			<h4>推广需求</h4>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>业务类型:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_service_type"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>关联合同号:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_contact_num"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>客户名称:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_cust_name"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>推广地区:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_promo_area"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>品牌:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_brand_name"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>车型:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_car_name"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>合同起止时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_contact_start_date"></label>至<label id="view_contact_end_date"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>推广起止时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_promo_start_date">2015-04-17</label>至<label id="view_promo_start_date">2015-04-17</label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>活动执行时间:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_acti_exec_date"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>目标线索量:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_tar_clue_num"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>目标到达量:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_tar_reach_num"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>目标成交量:</h5>
				</div>
				<div class="col-md-10 text-left">
					<h5><label id="view_tar_trans_num"></label></h5>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2 text-right">
					<h5>责任客服:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_custom_service_name"></label></h5>
				</div>
				<div class="col-md-2 text-right">
					<h5>责任推广:</h5>
				</div>
				<div class="col-md-2 text-left">
					<h5><label id="view_promo_man_name"></label></h5>
				</div>
			</div>
		</div>		
	</div>
	<#if state==3||state==4>
	<hr>
	<div class="row">
		<div class="col-md-12 col-sm-12">
					<div class="portlet box">
						<div class="portlet-title">
							<div class="caption" style="color:#3d3d3d;">
								推广计划
							</div>
						</div>
						<div class="portlet-body">
							<table class="table table-condensed table-bordered table-hover text-center">
							<thead>
							<tr role="row" class="heading">
								<th class="text-center">
									 渠道
								</th>
								<th class="text-center">
									 URL
								</th>
								<th class="text-center">
									 页面标识
								</th>
								<th class="text-center">
									 推广日期
								</th>
								<th class="text-center">
									 备注
								</th>
							</tr>
							
							</thead>
							<tbody id="promo_methods_tb">
							
							</tbody>
							</table>
						</div>
					</div>
				</div>
		 </div>           
    </div>
    </#if>
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
$.ajax({
		url : './queryCarInfo?fatherid=0',
		dataType : 'jsonp',
		jsonp:'jsonpcallback',
		success : function(data){
    		city = data;
			for(var i =0 ;i<city.length;i++)
			{
				var html ='';
				html ='<option value='+city[i].catalogid+'>'+city[i].lname+'&nbsp;'+city[i].catalogname+'</option>';
				$("#add_pinpai").append(html);
				$("#edit_pinpai").append(html);
				
			}
		}
});
	$("#add_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#add_chexi").empty();
		$("#add_chexing").empty();
		$("#add_chexi").append("<option value='-1'>请选择车系</option>");
		$("#add_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#add_chexi").append(html);
				}
    		}
		});
	
	});
	$("#edit_pinpai").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#edit_chexi").empty();
		$("#edit_chexing").empty();
		$("#edit_chexi").append("<option value='-1'>请选择车系</option>");
		$("#edit_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#edit_chexi").append(html);
				}
    		}
		});
	
	});
	$("#add_chexi").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#add_chexing").empty();
		$("#add_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#add_chexing").append(html);
				}
    		}
		});
	
	});
	$("#edit_chexi").change(function(){	
		 var fatherid = $(this).children('option:selected').val();

		$("#edit_chexing").empty();
		$("#edit_chexing").append("<option value='-1'>请选择车型</option>");
		$.ajax({
    		url : './queryCarInfo?fatherid='+fatherid,
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
	    		carBrand = data;
				for(var i =0 ;i<carBrand.length;i++)
				{
					var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
					$("#edit_chexing").append(html);
				}
    		}
		});
	
	});
	$("#add_service_type").change(function(){
		$("#add_pinpai").val("-1");
		$("#add_chexi").val("-1");
		$("#add_chexing").val("-1");
		
		$("#add_pinpai").removeAttr("disabled");
		$("#add_chexi").removeAttr("disabled");
		$("#add_chexing").removeAttr("disabled");
		
		var type = $(this).children('option:selected').val();
		if(type==0){
			$("#add_chexing").attr("disabled","disabled");
			$("#add_chexi").attr("disabled","disabled");
		}else if(type==2){
			$("#add_pinpai").attr("disabled","disabled");
			$("#add_chexi").attr("disabled","disabled");
			$("#add_chexing").attr("disabled","disabled");
		}
		
	});
	$("#edit_service_type").change(function(){
		$("#edit_pinpai").val("-1");
		$("#edit_chexi").val("-1");
		$("#edit_chexing").val("-1");
		
		$("#edit_pinpai").removeAttr("disabled");
		$("#edit_chexi").removeAttr("disabled");
		$("#edit_chexing").removeAttr("disabled");
		
		var type = $(this).children('option:selected').val();
		if(type==0){
			$("#edit_chexing").attr("disabled","disabled");
			$("#edit_chexi").attr("disabled","disabled");
		}else if(type==2){
			$("#edit_pinpai").attr("disabled","disabled");
			$("#edit_chexi").attr("disabled","disabled");
			$("#edit_chexing").attr("disabled","disabled");
		}
		
	});
	$("#edit_service_type").change(function(){
		$("#edit_pinpai").val("-1");
		$("#edit_chexi").val("-1");
		$("#edit_chexing").val("-1");
		var type = $(this).children('option:selected').val();
		
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
					$("#add_promo_prov").append(html);
					$("#edit_promo_prov").append(html);
				}
    		}
	});
	$("#add_promo_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#add_promo_city").empty();
		$("#add_promo_city").append("<option value='-1'>请选择城市</option>");
		if(fatherid!=-1){
			$.ajax({
    			url : 'getCityInfo?city='+fatherid,
    			dataType : 'jsonp',
    			jsonp:'jsonpcallback',
    			success : function(data){
	    			carBrand = data;
					for(var i =0 ;i<carBrand.length;i++)
					{
						var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
						$("#add_promo_city").append(html);
					}
    			}
			});
		}
	
	});
	$("#edit_promo_prov").change(function(){	
		var fatherid = $(this).children('option:selected').val();
		$("#edit_promo_city").empty();
		$("#edit_promo_city").append("<option value='-1'>请选择城市</option>");
		if(fatherid!=-1){
			$.ajax({
    			url : 'getCityInfo?city='+fatherid,
    			dataType : 'jsonp',
    			jsonp:'jsonpcallback',
    			success : function(data){
	    			carBrand = data;
					for(var i =0 ;i<carBrand.length;i++)
					{
						var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
						$("#edit_promo_city").append(html);
					}
    			}
			});
		}
	
	});
});
function hdxq(type,pro_num){
	if(type=="0"){
		window.parent.openNew('看车团活动详情填写','./ser_enterKctEditQiandao?pro_num='+pro_num);
	}
}
function add(){
	var add_service_type = $("#add_service_type").val();
	var add_contact_num = $("#add_contact_num").val();
	var	add_acti_name = $("#add_acti_name").val();
	var	add_acti_exec_date = $("#add_acti_exec_date").val();
	var	add_promo_prov = $("#add_promo_prov").val();
	var	add_promo_city = $("#add_promo_city").val();
	var	add_cust_name = $("#add_cust_name").val();
	var	add_pinpai = $("#add_pinpai").val();
	var	add_chexi = $("#add_chexi").val();
	var	add_chexing = $("#add_chexing").val();
	var	add_contact_start_date = $("#add_contact_start_date").val();
	var	add_contact_end_date = $("#add_contact_end_date").val();
	var	add_promo_start_date = $("#add_promo_start_date").val();
	var	add_promo_end_date = $("#add_promo_end_date").val();
	var	add_tar_clue_num = $("#add_tar_clue_num").val();
	var	add_tar_reach_num = $("#add_tar_reach_num").val();
	var	add_tar_trans_num = $("#add_tar_trans_num").val();
	var	add_custom_service = $("#add_custom_service").val();
	if("0"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
	}else if("1"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
		if(add_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		if(add_chexing=="-1"){
			alert("请选择车型");
			return;
		}
	}else if("3"==add_service_type){
		if(add_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
		if(add_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		
	}
	if(!is_exists(add_contact_num)){
		alert("请输入关联合同号");
		return;
	}
	if(!is_exists(add_acti_name)){
		alert("请输入活动名称");
		return;
	}
	if(!is_exists(add_acti_exec_date)){
		alert("请输入活动执行时间");
		return;
	}
	if(!is_exists(add_cust_name)){
		alert("请输入客户名称");
		return;
	}
	if(!is_exists(add_contact_start_date)){
		alert("请输入合同开始日期");
		return;
	}
	if(!is_exists(add_contact_end_date)){
		alert("请输入合同终止日期");
		return;
	}
	if(!is_exists(add_promo_start_date)){
		alert("请输入推广开始日期");
		return;
	}
	if(!is_exists(add_promo_end_date)){
		alert("请输入推广终止日期");
		return;
	}
	if(!is_exists(add_tar_clue_num)){
		alert("请输入目标线索量");
		return;
	}
	if(!is_exists(add_tar_trans_num)){
		alert("请输入目标到达量");
		return;
	}
	if(!is_exists(add_tar_reach_num)){
		alert("请输入目标成交量");
		return;
	}
	if(!is_exists(add_custom_service)){
		alert("请选择责任客服");
		return;
	}
	$.ajax({
    type: "POST",
    url:"ser_addProject",
    data:$('#newProject').serialize(),
    success: function(data) {
    		if(data==1){
				window.location.reload();
			}else{
				alert("error");
			}
    }
  });
}
function addProject(){
	var sysdate = new Date();
	var str = ""; 
	var y = sysdate.getFullYear();    //获取完整的年份(4位,1970-????)
	var m = sysdate.getMonth();       //获取当前月份(0-11,0代表1月)
	var d = sysdate.getDate(); 
	var str = y+"-"+m+"-"+d; 
	$("#sysdate").val(str);
	$("#add_chexi").attr("disabled","disabled");
	$("#add_chexing").attr("disabled","disabled");
	$("#add").modal();
}
function edit(){
	var edit_service_type = $("#edit_service_type").val();
	var edit_contact_num = $("#edit_contact_num").val();
	var	edit_acti_name = $("#edit_acti_name").val();
	var	edit_acti_exec_date = $("#edit_acti_exec_date").val();
	var	edit_promo_prov = $("#edit_promo_prov").val();
	var	edit_promo_city = $("#edit_promo_city").val();
	var	edit_cust_name = $("#edit_cust_name").val();
	var	edit_pinpai = $("#edit_pinpai").val();
	var	edit_chexi = $("#edit_chexi").val();
	var	edit_chexing = $("#edit_chexing").val();
	var	edit_contact_start_date = $("#edit_contact_start_date").val();
	var	edit_contact_end_date = $("#edit_contact_end_date").val();
	var	edit_promo_start_date = $("#edit_promo_start_date").val();
	var	edit_promo_end_date = $("#edit_promo_end_date").val();
	var	edit_tar_clue_num = $("#edit_tar_clue_num").val();
	var	edit_tar_reach_num = $("#edit_tar_reach_num").val();
	var	edit_tar_trans_num = $("#edit_tar_trans_num").val();
	var	edit_custom_service = $("#edit_custom_service").val();
	if("0"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
	}else if("1"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
		if(edit_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		if(edit_chexing=="-1"){
			alert("请选择车型");
			return;
		}
	}else if("3"==edit_service_type){
		if(edit_pinpai=="-1"){
			alert("请选择品牌");
			return;
		}
		if(edit_chexi=="-1"){
			alert("请选择车系");
			return;
		}
		
	}
	if(!is_exists(edit_contact_num)){
		alert("请输入关联合同号");
		return;
	}
	if(!is_exists(edit_acti_name)){
		alert("请输入活动名称");
		return;
	}
	if(!is_exists(edit_acti_exec_date)){
		alert("请输入活动执行时间");
		return;
	}
	if(!is_exists(edit_cust_name)){
		alert("请输入客户名称");
		return;
	}
	if(!is_exists(edit_contact_start_date)){
		alert("请输入合同开始日期");
		return;
	}
	if(!is_exists(edit_contact_end_date)){
		alert("请输入合同终止日期");
		return;
	}
	if(!is_exists(edit_promo_start_date)){
		alert("请输入推广开始日期");
		return;
	}
	if(!is_exists(edit_promo_end_date)){
		alert("请输入推广终止日期");
		return;
	}
	if(!is_exists(edit_tar_clue_num)){
		alert("请输入目标线索量");
		return;
	}
	if(!is_exists(edit_tar_trans_num)){
		alert("请输入目标到达量");
		return;
	}
	if(!is_exists(edit_tar_reach_num)){
		alert("请输入目标成交量");
		return;
	}
	if(!is_exists(edit_custom_service)){
		alert("请选择责任客服");
		return;
	}
	$.ajax({
    type: "POST",
    url:"ser_editProject",
    data:$('#editProject').serialize(),
    success: function(data) {
    		if(data==1){
				window.location.reload();
			}else{
				alert("error");
			}
    }
  });
}
function deleteProject(pro_num){
	if(confirm('确定删除项目吗?')){
	$.ajax({
    type: "POST",
    url:"ser_deleteProject",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			if(data==1){
				window.location.reload();
			}else{
				alert("error");
			}
    }
  	});
	}
}
function editProject(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data);
			var edit_pro_num = p[0].pro_num;
			$("#edit_pro_num").text(edit_pro_num);
			$("#edit_pro_num_text").val(edit_pro_num);
			var edit_service_type = p[0].service_type;
			$("#edit_service_type").val(edit_service_type);
			var edit_contact_num = p[0].contact_num;
			$("#edit_contact_num").val(edit_contact_num);
			var edit_cust_name = p[0].cust_name;
			$("#edit_cust_name").val(edit_cust_name);
			var	edit_acti_name = p[0].acti_name;
			$("#edit_acti_name").val(edit_acti_name);
			var edit_promo_prov = p[0].promo_prov;
			$("#edit_promo_prov").val(edit_promo_prov);
			var edit_promo_city = p[0].promo_city;
			if(edit_promo_prov!=-1){
				$.ajax({
    				url : 'getCityInfo?city='+edit_promo_prov,
    				dataType : 'jsonp',
    				jsonp:'jsonpcallback',
    				success : function(data){
	    				carBrand = data;
						for(var i =0 ;i<carBrand.length;i++)
						{
							var html ='<option value='+carBrand[i].catalogid+'>'+carBrand[i].lname+'&nbsp;'+carBrand[i].catalogname+'</option>';
							$("#edit_promo_city").append(html);
						}
    				}
				});
			}
			$("#edit_promo_city").val(edit_promo_city);
			var edit_contact_start_date = p[0].contact_start_date;
			$("#edit_contact_start_date").val(edit_contact_start_date);
			var edit_contact_end_date = p[0].contact_end_date;
			$("#edit_contact_end_date").val(edit_contact_end_date);
			var edit_promo_start_date = p[0].promo_start_date;
			$("#edit_promo_start_date").val(edit_promo_start_date);
			var edit_promo_end_date = p[0].promo_end_date;
			$("#edit_promo_end_date").val(edit_promo_end_date);
			var edit_acti_exec_date = p[0].acti_exec_date;
			$("#edit_acti_exec_date").val(edit_acti_exec_date);
			var edit_tar_clue_num = p[0].tar_clue_num;
			$("#edit_tar_clue_num").val(edit_tar_clue_num);
			var edit_tar_reach_num = p[0].tar_reach_num;
			$("#edit_tar_reach_num").val(edit_tar_reach_num);
			var edit_tar_trans_num = p[0].tar_trans_num;
			$("#edit_tar_trans_num").val(edit_tar_trans_num);
			var edit_custom_service = p[0].custom_service;
			$("#edit_custom_service").val(edit_custom_service);
			var edit_ini_date = p[0].ini_date;
			$("#edit_ini_date").val(edit_ini_date);
			var edit_brand_name = p[0].brand_name;
			var edit_brand = p[0].brand;
			var edit_car_name = p[0].car_name;
			var edit_car = p[0].car;
			var edit_model_name = p[0].model_name;
			var edit_model = p[0].model;
			$("#edit_pinpai").val(edit_brand);
			if(edit_car!="-1"){
				var html_car ='<option value='+edit_car+'>'+edit_car_name+'</option>';
				$("#edit_chexi").append(html_car);
			}
			$("#edit_chexi").val(edit_car);
			if(edit_model!=-1){
				var html_model ='<option value='+edit_model+'>'+edit_model_name+'</option>';
				$("#edit_chexing").append(html_model);
			}
			$("#edit_chexing").val(edit_model);
			
			$("#edit_pinpai").removeAttr("disabled");
			$("#edit_chexi").removeAttr("disabled");
			$("#edit_chexing").removeAttr("disabled");
		
			var type = edit_service_type;
			if(type==0){
				$("#edit_chexing").attr("disabled","disabled");
				$("#edit_chexi").attr("disabled","disabled");
			}else if(type==2){
				$("#edit_pinpai").attr("disabled","disabled");
				$("#edit_chexi").attr("disabled","disabled");
				$("#edit_chexing").attr("disabled","disabled");
			}
			$("#edit").modal();
    }
  });
}
function view(pro_num){
	$.ajax({
    type: "POST",
    url:"ser_getProjectInfo",
    data:{
			"pro_num":pro_num
		},
    success: function(data) {
			var p = eval(data)
    		var view_pro_num = p[0].pro_num;
			$("#view_pro_num").text(view_pro_num);
			var view_pro_state = p[0].pro_state;
			var state = "";
			if(view_pro_state=="0"){
				state="待审核";
			}else if(view_pro_state=="1"){
				state="业务部通过";
			}else if(view_pro_state=="2"){
				state="业务部驳回";
			}else if(view_pro_state=="3"){
				state="推广部通过";
			}else if(view_pro_state=="4"){
				state="推广部驳回";
			}
			$("#view_pro_state").text(state);
			var view_ini_man_name = p[0].ini_man_name;
			$("#view_ini_man_name").text(view_ini_man_name);
			var view_dept_name = p[0].org_name+p[0].dep_name;
			$("#view_dept_name").text(view_dept_name);
			var view_ini_date = p[0].ini_date;
			$("#view_ini_date").text(view_ini_date);
			var view_service_type = p[0].service_type;
			$("#view_service_type").text(view_service_type);
			var view_contact_num = p[0].contact_num;
			$("#view_contact_num").text(view_contact_num);
			var view_cust_name = p[0].cust_name;
			$("#view_cust_name").text(view_cust_name);
			var view_promo_area = p[0].promo_area;
			$("#view_promo_area").text(view_promo_area);
			var view_brand_name = p[0].brand_name;
			$("#view_brand_name").text(view_brand_name);
			var view_car_name = p[0].car_name;
			$("#view_car_name").text(view_car_name);
			var view_contact_start_date = p[0].contact_start_date;
			$("#view_contact_start_date").text(view_contact_start_date);
			var view_contact_end_date = p[0].contact_end_date;
			$("#view_contact_end_date").text(view_contact_end_date);
			var view_promo_start_date = p[0].promo_start_date;
			$("#view_promo_start_date").text(view_promo_start_date);
			var view_promo_end_date = p[0].promo_end_date;
			$("#view_promo_end_date").text(view_promo_end_date);
			var view_acti_exec_date = p[0].acti_exec_date;
			$("#view_acti_exec_date").text(view_acti_exec_date);
			var view_tar_clue_num = p[0].tar_clue_num;
			$("#view_tar_clue_num").text(view_tar_clue_num);
			var view_tar_reach_num = p[0].tar_reach_num;
			$("#view_tar_reach_num").text(view_tar_reach_num);
			var view_tar_trans_num = p[0].tar_trans_num;
			$("#view_tar_trans_num").text(view_tar_trans_num);
			var view_custom_service_name = p[0].custom_service_name;
			$("#view_custom_service_name").text(view_custom_service_name);
			var view_promo_man_name = p[0].promo_man_name;
			$("#view_promo_man_name").text(view_promo_man_name);
			var promoMethods = p[0].promoMethods;
			var html="";
			for(p in promoMethods){
				html = html+'<tr class="odd gradeX"><td>'+p.promo_channel+'</td><td>'+p.promo_url+'</td><td>'+p.promo_pageid+'</td><td>'+p.promo_date+'</td><td>'+p.promo_remarks+'</td></tr>';
			}
			$("promo_methods_tb").html(html);
			$("#view").modal();
    }
  });
	
}
function is_exists(obj){
	obj = $.trim(obj);
	if(obj==""||obj==null||obj==undefined){
		return false;
	}else{
		return true;
	}
}
</script>
</body>
</html>