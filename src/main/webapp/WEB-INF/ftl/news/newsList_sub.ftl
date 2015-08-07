<div class="row">
	<div class="col-md-2">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i><span id="treeName">新闻目录</span>
				</div>
			</div>
			
			<div class="portlet-body">
				<div class="zTreeBg" style="height:500px;overflow-x:hidden;overflow-y:auto;">
                  <ul id="sub_news_catalog_tree" class="ztree"></ul>
            	</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-10">
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i><span id="treeName">新闻列表</span>
				</div>
			</div>
			<div class="portlet-body">
				<div class="news-list">
		          
					<#if err?? && err.length() gt 0>
					<div class="Metronic-alerts alert alert-danger fade in" id="prefix_174292794335">
						<button aria-hidden="true" data-dismiss="alert" class="close" type="button"></button>
						<i class="fa-lg fa fa-warning"></i>  ${err!}
					</div>
					</#if>
					
					<#if editors??>
					<div class="row">
						<div class="col-md-2">
							<input id="sub_search_txt" type="text" name="order_customer_name" class="form-control form-filter input-sm">
						</div>
						<div class="col-md-3">
							<select  id="select_addadmin" class="table-group-action-input form-control input-inline input-small input-sm">
								<option value="">选择编辑</option>
								<#list editors as adm>
		                      	<option <#if addadmin?? && addadmin == adm.username>selected="selected"</#if> value="${adm.username}">${adm.username}</option>
		                      	</#list>
							</select>
						</div>
						<div class="col-md-3">
							<select id="select_new_delete" class="table-group-action-input form-control input-inline input-small input-sm">
								  <option <#if isdelete == 0>selected="selected"</#if> value="0">已发布</option>
			                      <option <#if isdelete == 1>selected="selected"</#if> value="1">已删除</option>
			                      <option <#if isdelete == 2>selected="selected"</#if> value="2">未发布</option>
							</select>
						</div>
						<div class="col-md-2">
							<select id="select_new_type" class="table-group-action-input form-control input-inline input-small input-sm">
								 <option <#if newType == 0>selected="selected"</#if> value="0">所有新闻</option>
			                      <option <#if newType == 1>selected="selected"</#if> value="1">原创新闻</option>
			                      <option <#if newType == 2>selected="selected"</#if> value="2">图片新闻</option>
			                      <option <#if newType == 3>selected="selected"</#if> value="3">原创图片新闻</option>
			                      <option <#if newType == 4>selected="selected"</#if> value="4">必看新闻</option>
							</select>
						</div>
						<div class="col-md-2">
							<button id="sub_inp_start_search" class="btn btn-sm yellow table-group-action-submit"><i class="fa fa-check"></i> Submit</button>
						</div>
					</div>
					</#if>
					
					<#if newsList??>
					<div class="table-scrollable">
						<table id="sample_1" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="sample_1_info">
							<thead>
							<tr>
								<th class="table-checkbox"><input id="check-all" type="checkbox" name="checkbox" class="checkboxes" /></th>
								<th>标题</th>
								<th>目录</th>
								<th>编辑</th>
								<th>日期</th>
								<th>分页</th>
								<th>wap</th>
							</tr>
							</thead>
							
							<tbody>
							<#list newsList as news>
							<tr class="gradeX odd" role="row">
								<td><input type="checkbox" name="cb_news" id="cb_news_${news.id}" value="${news.id}" class="checkboxes"></td>
								<td class="sorting_1"><a href="${che_url}new/${news.newscatalogid}/page_${news.id}_1.html" target="_blank">${news.newstitle!}</a></td>
								<td>${(news.catalog.catalogname)!}</td>
								<td>${news.addadmin!}</td>
								<td class="center">${news.adddate?string("yyyy/MM/dd HH:mm:ss")}</td>
								<td class="center">
									<#list news.contents as con>
		                            	[<a target="_blank" href="${che_url}new/${news.newscatalogid}/page_${news.id}_${con_index+1}.html">${con_index+1}</a>]
		                             </#list>
                            	</td>
								<td>
									<#if news.iswap == 1>
		                            <#list news.contents as con>
		                            	[<a target="_blank" href="${wap_ct_url}wapnews/${news.newscatalogid}/page_${news.id}_${con_index+1}.html">${con_index+1}</a>]
		                            </#list>
		                            </#if>
								</td>
							</tr>
							</#list>
							</tbody>
						</table>
		          	</div>
		          	
		          	<#import "common_news.ftl" as cp>
		          	<div class="row">
						<div class="col-md-5 col-sm-12">
							<div class="dataTables_info" id="sample_1_info" role="status" aria-live="polite">
								 第${page}页，共${pages}页，跳转到
								<input id="turn_Page" name="" type="text" style=" width:36px; height:26px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
								<a href="javascript:void(0);" onclick="toPage($('#turn_Page').val());">GO</a>
							</div>
						</div>
						<div class="col-md-7 col-sm-12">
							<div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">
								 <@cp.calcPageByJs "toPage", page, pages/>
							</div>
						</div>
					</div>
					</#if>
		          
		          
		        </div>
			</div>
		</div>
	</div>
</div>


<form id="sub_news_list_from" action="viewNewsList" method="post" >

	<input id="sub_newsCatalogid" name="newsCatalogid" type="hidden" value="${newsCatalogid!}" />
	
	<input id="sub_node_id" name="node_id" type="hidden" value="${node_id!}" />
	
	<input id="sub_resFlag" name="resFlag" type="hidden" value="${resFlag!"1"}" />
	
	<input id="sub_page" name="page" type="hidden" value="${page!"1"}" />
	<input id="pageSize" name="pageSize" type="hidden" value="${pageSize!"8"}" />
	
	<input id="sub_addadmin" name="addadmin" type="hidden" value="${addadmin!}" />
	<input id="sub_isdelete" name="isdelete" type="hidden" value="${isdelete!"0"}" />
	<input id="sub_newType" name="newType" type="hidden" value="${newType!}" />
	<input id="sub_keyWord" name="keyWord" type="hidden" value="${keyWord!}" />
	
</form>


<script src="${admin_che_url}js/jquery.form.js" type="text/javascript"></script>

<script>
$(document).ready(function() {
	
	createTree3("新闻目录",'sub_news_catalog_tree', onclickSubAlertNode,  $("#sub_node_id").val());
	
	//弹出框的确认按钮
	$("#pop_up_sure_btn").on("click",function(){
		
		var newsArr = $("input[name='cb_news']:checked");
		if(!newsArr){
			alert("没有选择新闻");
			return;
		}
		var check_news = newsArr.get(0);
		if(!check_news){
			alert("没有选择新闻");
			return;
		}
		var newsid = check_news.value;
		//alert(""+newsid);
		
		//var newsCatalogid =	$("#sub_newsCatalogid").val();
		//window.location.href="./viewNewsList?newsCatalogid="+newsCatalogid;
		//原新闻catalogid
		var newsCatalogid = $("#news_newscatalogid").val();
		//alert("-->"+newsCatalogid);
		window.location.href="./viewNewsEdit?template=1&newsid="+newsid+"&newsCatalogid="+newsCatalogid;
	});
	
	//关键字
	$("#sub_search_txt").on("change keyup", function(){
		//alert($(this).val());
		$("#sub_keyWord").val($("#sub_search_txt").val());
	});
	
	//开始查找
	$("#sub_inp_start_search").on("click", function(){
		$("#sub_news_list_from").ajaxSubmit({ 
			success: succSubNewsListFrom,	
			error: errSubNewsListFrom
		});
	});

});
	


function onclickSubAlertNode(event, treeId, treeNode, clickFlag){
	var pId = 0;
	if(clickFlag.pId != null){
		pId = clickFlag.pId
	}
	//保存当前节点，方便同步请求后该节点依然选择
	$("#sub_node_id").val(treeNode.tId);
	$("#sub_newsCatalogid").val(treeNode.id);
	
	$("#sub_news_list_from").ajaxSubmit({ 
		success: succSubNewsListFrom,	
		error: errSubNewsListFrom
	});
	
}

function succSubNewsListFrom(data){
	$("#pop_up_body").html(data);
}

function errSubNewsListFrom(data){
	alert(data);
}


//跳转到
  function toPage(page){
  	$("#sub_page").val(page);
  	
  	$("#sub_news_list_from").ajaxSubmit({ 
		success: succSubNewsListFrom,	
		error: errSubNewsListFrom
	});
  }
  
  	

</script>
