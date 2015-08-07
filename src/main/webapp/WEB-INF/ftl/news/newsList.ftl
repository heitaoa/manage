<#import "../common.ftl" as c>
<#import "common_news.ftl" as cp>

<@c.html_head></@c.html_head>
<@c.html_body>

	<h3 class="page-title">新闻编辑</h3>
	
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li>
				<i class="fa fa-home"></i>
				<a href="index.html">首页</a>
			<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻管理</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">新闻编辑</a>
			</li>
		</ul>
	</div>
	
	<div class="row">
	
		<div class="col-md-3">
			<div class="portlet box red">
			
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>
						新闻目录
					</div>
				</div>
				
				<div class="portlet-body">
					<div class="table-scrollable">
						 <div class="zTreeBg">
	                      <ul id="news_catalog_tree" class="ztree"></ul>
	                     </div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-md-8">
			<div class="portlet box yellow">
			
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-coffee"></i>
						新闻列表
					</div>
				</div>
				
				<div class="portlet-body">
				
					<div class="clearfix">
						<button onclick="onPageEditView(0);" class="btn green" type="button">添加新闻</button>
						<button onclick="onPageEditView(1);" class="btn green" type="button">添加图片新闻</button>
						<!--
						<button onclick="onCurListGenerate();" class="btn blue" type="button">生成列表页</button>
						<button onclick="genWapListPage();" class="btn blue" type="button">生成WAP列表页</button>
						-->
						<button onclick="deleteMultiNews();" class="btn red" type="button">批量删除</button>
						<!--
						<button onclick="publishMultNews();" class="btn red" type="button">批量发布</button>
						-->
					</div>
					
					<#if err?? && err.length() gt 0>
					<div class="Metronic-alerts alert alert-danger fade in" id="prefix_174292794335">
						<button aria-hidden="true" data-dismiss="alert" class="close" type="button"></button>
						<i class="fa-lg fa fa-warning"></i>  ${err!}
					</div>
					</#if>
					
					<#if editors??>
					<div class="row">
						<div class="col-md-3">
							<input id="search_txt" type="text" name="order_customer_name" class="form-control form-filter input-sm" value="${keyWord!}">
						</div>
						<div class="col-md-3">
							<select  id="select_addadmin" class="table-group-action-input form-control input-inline input-small input-sm">
								<option value="">选择编辑</option>
								<#list editors as adm>
								<#if adm.username??>
		                      	<option <#if addadmin?? && addadmin == adm.username>selected="selected"</#if> value="${adm.username}">${adm.realname}</option>
		                      	</#if>
		                      	
		                      	</#list>
							</select>
						</div>
						<div class="col-md-3">
							<select id="select_new_delete" class="table-group-action-input form-control input-inline input-small input-sm">
								  <option <#if isdelete == -1>selected="selected"</#if> value="-1">默认</option>
								  <option <#if isdelete == 0>selected="selected"</#if> value="0">已发布</option>
			                      <option <#if isdelete == 1>selected="selected"</#if> value="1">已删除</option>
			                      <option <#if isdelete == 2>selected="selected"</#if> value="2">未发布</option>
							</select>
						</div>
						<div class="col-md-3">
							<select id="select_new_type" class="table-group-action-input form-control input-inline input-small input-sm">
								 <option <#if newType == 0>selected="selected"</#if> value="0">所有新闻</option>
			                      <option <#if newType == 1>selected="selected"</#if> value="1">原创新闻</option>
			                      <option <#if newType == 2>selected="selected"</#if> value="2">图片新闻</option>
			                      <option <#if newType == 3>selected="selected"</#if> value="3">原创图片新闻</option>
			                      <option <#if newType == 4>selected="selected"</#if> value="4">必看新闻</option>
							</select>
						</div>
						<div class="col-md-2">
							<button id="inp_start_search" class="btn btn-sm yellow table-group-action-submit"><i class="fa fa-check"></i> Submit</button>
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
								<th>操作</th>
							</tr>
							</thead>
							
							<tbody>
							<#list newsList as news>
							<tr class="gradeX odd" role="row">
								<td><input type="checkbox" name="cb_news" id="cb_news_${news.id}" class="checkboxes"></td>
								<td class="sorting_1">
								
									<a <#if news.isdelete == 0>href="${inf_che_url}n/${news.adddate?string("yyyy_MM")}/${news.id}/"<#else>href="${che_url}che/newsdetail/detail?newsid=${news.id}&preview=1&contentPage=1"</#if> target="_blank">
									${news.newstitle!}
									</a>
									
									<#if news.isdelete == 0>
										<span id="isdelete_${news.id}"  class="label label-success">已发布</span>
									<#elseif news.isdelete == 1>
										<span id="isdelete_${news.id}" class="label label-default">已删除</span>
									<#elseif news.isdelete == 2>
										<span id="isdelete_${news.id}" class="label label-info">未发布</span>
									<#elseif news.isdelete == 3>
										<span id="isdelete_${news.id}" class="label label-primary">预发布</span>
									<#else>
										<span id="isdelete_${news.id}" class="label label-danger">未知</span>
									</#if>
								</td>
								<td>${(news.catalog.catalogname)!}</td>
								<td>${(realnameMethod(news.addadmin)!)}</td>
								<td class="center">${news.savedate?string("yyyy/MM/dd HH:mm:ss")}
									<input id="news_gradeid1_${news.id}" type="hidden" value="${news.gradeid1}">
								</td>
								<td class="center">
									<#list news.contents as con>
		                            	[<a target="_blank" href="${che_url}new/${news.newscatalogid}/page_${news.id}_${con_index+1}.html">${con_index+1}</a>]
		                             </#list>
                            	</td>
                            	
								<td>
									<div class="btn-group">
									
									<#if news.isdelete == 1>
									<button type="button" class="btn btn-default" onclick="onRevertNews(${news.id})">还原</button>
									</#if>
									
									<#if news.isdelete == 2>
									<button type="button" class="btn btn-default" onclick="onPublishNews(${news.id}, '${inf_che_url}n/${news.adddate?string("yyyy_MM")}/${news.id}/')">发布</button>
									</#if>
									
									<#if news.isdelete == 0 || news.isdelete == 1 || news.isdelete == 2>
									  <button type="button" class="btn btn-default" onclick="onRefreshNews(${news.id})">刷新</button>
									  </#if>
									  
									  <#if news.isdelete == 2 || news.isdelete == 0>
									  <button type="button" class="btn btn-default" onclick="location.href='./viewNewsEdit?isModify=1&newsid=${news.id}'">修改</button>
									   </#if>
									  
									  <#if news.isdelete == 2 || news.isdelete == 0>
									  <button type="button" class="btn btn-default" onclick="onDeleteNews(${news.id})">删除</button>
									  </#if>
									</div>
								</td>
							</tr>
							</#list>
							</tbody>
						</table>
					</div>
					
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
  
<form id="form_page_list" action="viewNewsList" method="post" >
	<input id="newsCatalogid" name="newsCatalogid" type="hidden" value="${newsCatalogid!}" />
	
	<input id="node_id" name="node_id" type="hidden" value="${node_id!}" />
	
	<input id="page" name="page" type="hidden" value="${page!"1"}" />
	
	<!--
	<input id="catalog_catalogid" name="catalog.catalogid" type="hidden" value="${(catalog.catalogid)!}" />
	<input id="catalog_catalogname" name="catalog.catalogname" type="hidden" value="${(catalog.catalogname)!}" />
	-->
	<input id="addadmin" name="addadmin" type="hidden" value="${addadmin!}" />
	<input id="isdelete" name="isdelete" type="hidden" value="${isdelete!"-1"}" />
	<input id="newType" name="newType" type="hidden" value="${newType!}" />
	<input id="keyWord" name="keyWord" type="hidden" value="${keyWord!}" />
	
	<!--
	<input id="news_id" name="news.id" type="hidden" value="${(news.id)!"0"}" />
	-->
	<!---批量删除--->
	<input id="news_ids" name="news_ids" type="hidden" value="" />
	<!--分页大小-->
	<input id="pageSize" name="pageSize" type="hidden" value="10" />

</form>
</@c.html_body>
<@c.html_js></@c.html_js>
<script>
$(document).ready(function() {
	//
	createTree("新闻目录",'news_catalog_tree', $("#node_id").val());
	
});

function onClick(event, treeId, treeNode, clickFlag){
	
	var pId = 0;
	if(clickFlag.pId != null){
		pId = clickFlag.pId;
	}
	
	$("#newsCatalogid").val(treeNode.id);
	//保存当前节点，方便同步请求后该节点依然选择
	$("#node_id").val(treeNode.tId);
	$("#form_page_list").submit();
	
	//window.location.href="./viewNewsList?newsCatalogid="+newsCatalogid;
}


//错误提示
var err="${err!}";
if(err && err.length>0)
{
	//alert(err);
}
  

//操作
function onModifyNews(news_id){
	$("#form_page_list").attr("action", "pageEditModify");
	$("#news_id").val(news_id);
	$("#form_page_list").submit();
}


//删除
function onDeleteNews(news_id){
 var boo=confirm("确认要删除该条新闻么？");
 if(boo){
	$.get("deleteNews", {"newsid": news_id},
	  function(data){
	    alert(data);
	    if(data == "删除成功")
	    {
	    	$("#form_page_list").submit();
	    }
	  });
	}
}


//刷新
function onRefreshNews(newsid){
	$.get("refreshNews", {"newsid": newsid}, function(data){
	    alert(data);
	  });
}

//生成城市主页
function onCityGenerate(){
	$.get("cityPage_generator", {},
	  function(data){
	    alert("Data Loaded: " + data);
	  });
}

//生成列表页
function onCurListGenerate(){
	//alert("-->"+$("#newsCatalogid").val());
	$.get("curPageListGen", {catalog_id:$("#newsCatalogid").val()},
	  function(data){
	    alert("Data Loaded: " + data);
	  });
}

//生成列表页
function onListGenerate(){
	$.get("pageListGen", {},
	  function(data){
	    alert("Data Loaded: " + data);
	  });
}

//生成wap列表页
function genWapListPage()
{
   $.get("genWapListPage", {catalog_id:$("#newsCatalogid").val()},
		  function(data){
		    alert("Data Loaded: " + data);
		  });
}
  


//
$(function(){

	//全选/全不选
	$('#check-all').on("click",function(){
		var boo = $(this).is(":checked");
		var cboxs = $("input[name='cb_news']");
		boo?cboxs.prop("checked",true).uniform():cboxs.prop('checked',false).uniform();
	});

	//关键字
	$("#search_txt").on("change keyup", function(){
		//alert($(this).val());
		$("#keyWord").val($("#search_txt").val());
	});
	
	//所有添加者
	$("#select_addadmin").on("change", function(){
		//alert($("#select_addadmin option:selected").val());
		$("#addadmin").val($("#select_addadmin option:selected").val());
	});
	
	//发布状态
	$("#select_new_delete").on("change", function(){
		$("#isdelete").val($("#select_new_delete option:selected").val());
	});
	
	//所有新闻
	$("#select_new_type").on("change", function(){
		$("#newType").val($("#select_new_type option:selected").val());
	});
	
	//所有发布
	$("#inp_all_news").on("click", function(){
		$("#search_txt").val("");
		$("#keyWord").val($("#search_txt").val());
		//
		$("#select_addadmin").val("");
		$("#addadmin").val("");
		//
		$("#select_new_delete").val(-1);
		$("#isdelete").val(-1);
		//
		$("#select_new_type").val(0);
		$("#newType").val(0);
		//
		$("#form_page_list").submit();
	});
	
	//开始查找
	$("#inp_serach").on("click", function(){
		//alert($("#newType").val());
		$("#form_page_list").submit();
	});
	
	//开始查找
	$("#inp_start_search").on("click", function(){
		//alert($("#newType").val());
		$("#form_page_list").submit();
	});
	
});


//添加新闻主题
function onPageEditView(newsType){
	var newsCatalogid = $("#newsCatalogid").val();
	var node_id = $("#node_id").val();
	if(newsType == 1)
		document.location.href="./viewNewsEdit?newsCatalogid="+newsCatalogid +"&node_id="+node_id+"&isimgnews=1";
	else
		document.location.href="./viewNewsEdit?newsCatalogid="+newsCatalogid +"&node_id="+node_id;
}

  //跳转到
  function toPage(page){
  	$("#page").val(page);
  	$("#form_page_list").submit();
  }




  function movePage()
  {
  	alert("movePage");
  }
  
  function deleteMultiNews()
  {
  	var boo=confirm("确认要批量删除这些新闻么？");
	if(!boo)
		return;
 
  	//var cboxs = $("input[name='cb_news']");
  	var ids = "";
  	$("input[name='cb_news']:checked").each(function(i){
  		ids += ","+this.id.substring(8);
  	})
  	//alert(ids.substring(1));
  	ids = ids.substring(1);
  	$.get("deleteNews",{newsidStr:ids},function(data){
  		alert(data);
  		if(data == "删除成功")
  			$("#form_page_list").submit();
  	});
  	
  	//$("#news_ids").val(news_ids);
  	//$("#form_page_list").attr("action", "pageListDelete");
	//$("#form_page_list").submit();
  }
  
  
  //还原
  function onRevertNews(newsid, url)
  {
  	$.get("revertNews",{newsid:newsid},function(data){
  		alert(data);
  		$("#form_page_list").submit();
  	});
  }
  
  
  
  function onPublishNews(newsid, url)
  {
  	var gradeid1 =$("#news_gradeid1_"+newsid).val();
  	//alert("----->"+gradeid1);
  	$.get("publishNews",{newsid:newsid, firstPublish:gradeid1},function(data){
  		alert(data);
  		
  		if(data == "发布成功")
  		{
	  		//alert("#isdelete_"+newsid);
		  	$("#isdelete_"+newsid).attr({class:"label label-success"});
		  	$("#isdelete_"+newsid).text("已发布");
		  	window.open(url);
	  	}
  		
  	});
  }
  
  //批量发布内容页
  function publishMultNews()
  {
  	var ids = "";
  	$("input[name='cb_news']:checked").each(function(i){
  		ids += ","+this.id.substring(8);
  	})
  	if(ids.length<1){
  		alert("请选择需要发布的新闻");
  		return false;
  	}
  	//alert(ids.substring(1));
  	ids = ids.substring(1);
  	$.get("publishNews",{newsidStr:ids},function(data){
  		alert(data);
  		
  		if(data == "发布成功")
  		{
	  		$("input[name='cb_news']:checked").each(function(i){
		  		var id = this.id.substring(8);
		  		$("#isdelete_"+id).attr({class:"label label-success"});
		  	})
	  	}
  		
  		
  	});
  }
  
   
function checkAll(name)
{
    var el = document.getElementsByTagName('input');
    var len = el.length;
    for(var i=0; i<len; i++)
    {
        if((el[i].type=="checkbox") && (el[i].name==name))
        {
            el[i].checked = true;
        }
    }
}

function clearAll(name)
{
    var el = document.getElementsByTagName('input');
    var len = el.length;
    for(var i=0; i<len; i++)
    {
        if((el[i].type=="checkbox") && (el[i].name==name))
        {
            el[i].checked = false;
        }
    }
}

</script>
</body>
</html>