<#import "../common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<@cc.html_body>
		<h3 class="page-title">
		页面模块编辑
		</h3>
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
				<a href="javascript:void(0);">页面模块编辑</a>
			</li>
		</ul>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box">
				<div class="input-group input-medium" style="margin:0 auto;">
					<input type="text" class="form-control" value="${(keywords)!}" id="search" placeholder="请输入关键字">
					<span class="input-group-btn">
					<button class="btn blue" type="button" id="search_bnt">搜索</button>
					</span>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="portlet box">
				<div class="input-group" id="pingtai">
					<label style="font-size:16px;">平台选择：</label>
					
					<#list stypeMap?keys as  key>
						<input type="checkbox" <#if (pingtai==key)>checked="checked"</#if> class="group-checkable" pid="${key}">${stypeMap[key]}
					</#list>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="portlet box">
				<div class="input-group" id="sites_id">
					<label style="font-size:16px;">城市站：</label>
					<input type="radio" class="group-checkable" name="sites_id" style="margin-left:-10px;" <#if (sub_sites_id<=0)>checked="checked"</#if> sites_id="-1">所有
					<#list allSites as site>
						<input type="radio" <#if (site.id==sub_sites_id)>checked="checked"</#if> style="margin-left:-10px;" class="group-checkable" name="sites_id" sites_id="${site.id}">${site.name}
					</#list>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="portlet box">
				<div class="input-group" id="search_kws">
					<label style="font-size:16px;">关键字（快捷搜索）：</label>
					<#list search_kws as kw>
						<label class="list" style="cursor:pointer;margin-left:10px;font-size:15px;">${kw}</label>	
					</#list>
				</div>
			</div>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-globe"></i>编辑模块
					</div>
				</div>
				<div class="portlet-body">
					<table class="table table-striped table-bordered table-hover" id="sample_1">
					<thead>
						<tr>
							<th class="table-checkbox">
								序号
							</th>
							<th>
								 位置
							</th>
							<th>
								 平台
							</th>
							<th>
								 城市站
							</th>
							<th>
								 页面
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<tbody id="page_data">
						
					</tbody>
					</table>
				</div>
			</div>
			
			<div class="row" id="pager">
				
			</div>
			
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
	<script>
		function syncData(cid){
			$.ajax({
				url:"page_syncData?cid="+cid,
				async:false,
				success:function(data){
					alert("刷新成功！");
				}
			});
		}
		
		function refreshPage(cid){
			$.get("/adminche/page_refreshPage?cid="+cid,function(data){
				if(data){
					alert("刷新成功！");
				}else{
					alert("刷新失败！");
				}
			})
		}
		
		function listData(keyword,pingtai,page,sites_id){
			// 分页查询参数获取
			keyword = $("#search").val();
			var pingtaiArr = [];
			$("input[type='checkbox']").parent(".checked").each(function(i){
				pingtaiArr.push($(this).find("input").attr("pid"));
			});
			pingtai = pingtaiArr.join(",");
			$("input[type='radio']").parent("checked").each(function(){
				sites_id = $(this).find("input").attr("sites_id")
			}) 
			
			$.ajax({url:"/adminche/page_listData?"+new Date().toString(),
			async:false,
			type:"post",
			data:{"keywords":keyword,"pingtai":pingtai,"page":page,"sites_id":sites_id},
			success:function(data){
				var jsonMap=eval(data);
				var obj=jsonMap[0].dataList;
				
				$("#page_data").empty();
				if(obj.length>0){
					for(var i=0;i<obj.length;i++){
						var row=obj[i];
						
						var data='<tr class="odd gradeX">'+
								'<td>'+
									''+(i+1)+''+
								'</td>'+
								'<td>'+
									 ''+row.place+''+
								'</td>'+
								'<td>'+
									''+row.tname+''+
								'</td>'+
								
								'<td>'+
									''+row.area+''+
								'</td>'+
								
								'<td>'+
									 ''+row.pname+''+
								'</td>'+
								'<td class="center">'+
									 '<button class="btn green" onclick="refreshPage('+row.cid+')">刷新</button>'+
									'<button class="btn green" onclick="document.location.href=\'/adminche/modify_toPageModify?cid='+row.cid+'\';">修改</button>';
									
									if(row.sync_id>0){
										data+='<button class="btn yellow" onclick="syncData(\''+row.cid+'\')">同步WAP数据</button>';
									}else{
										data+='<button class="btn disabled">同步WAP数据</button>';
									}
								data+='</td>'+
							'</tr>';
						$("#page_data").append($(data));	
					}
				}else{
					var nodata=$('<tr><td colspan="7" style="text-align:center;"><span style="color:red;">!</span>没有查询到数据~~</td></tr>');
					$("#page_data").append(nodata);	
				}
				
				var len=obj.length;
				var allPage=1;
				var curPage=1;
				
				var keywords=jsonMap[0].keywords;
				var pingtai=jsonMap[0].pingtai;
				var sites_id=jsonMap[0].sites_id;
				
				if(len>0){
					allPage=obj[0].allPage;
					curPage=obj[0].curPage;
				}
				
				$("#pager").empty();
				var pager='<div class="col-md-5 col-sm-12">'+
					'<div class="dataTables_info" id="sample_1_info" role="status" aria-live="polite">第'+curPage+'页/共'+allPage+'页</div>'+
				'</div>'+
				'<div class="col-md-7 col-sm-12"><div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">'+
					'<ul class="pagination" style="visibility: visible;">';
						
						if(curPage>1){
							pager+='<li class="prev"><a href="javascript:void(0);" onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(curPage-5)+','+sites_id+')" title="First"><i class="fa fa-angle-double-left"></i></a></li>'+
							'<li class="prev"><a href="javascript:void(0);" onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(curPage-1)+','+sites_id+')" title="Prev"><i class="fa fa-angle-left"></i></a></li>';
						}else{
							pager+='<li class="prev disabled"><a href="javascript:void(0);" title="First"><i class="fa fa-angle-double-left"></i></a></li>'+
						'<li class="prev disabled"><a href="javascript:void(0);" title="Prev"><i class="fa fa-angle-left"></i></a></li>';
						}
						
						if(allPage<=5){
							if(allPage<=0){
								allPage=1;
							}
							for(var i=0;i<allPage;i++){
								if(i+1==curPage){
									pager+='<li class="active"><a href="javascript:void(0);">'+(i+1)+'</a></li>';
								}else{
									pager+='<li><a onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(i+1)+','+sites_id+')" href="javascript:void(0);">'+(i+1)+'</a></li>';
								}
							}
						}else{
							
							if(curPage-2<=1){
								for(var i=0;i<5;i++){
									if(i+1==curPage){
										pager+='<li class="active"><a href="javascript:void(0);">'+(i+1)+'</a></li>';
									}else{
										pager+='<li><a onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(i+1)+','+sites_id+')" href="javascript:void(0);">'+(i+1)+'</a></li>';
									}
								}
							}else if(curPage+2<=allPage){
								for(var i=(curPage-3);i<(curPage+2);i++){
									if(i+1==curPage){
										pager+='<li class="active"><a href="javascript:void(0);">'+(i+1)+'</a></li>';
									}else{
										pager+='<li><a onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(i+1)+','+sites_id+')" href="javascript:void(0);">'+(i+1)+'</a></li>';
									}
								}
							}else{
								for(var i=allPage-5;i<allPage;i++){
									if(i+1==curPage){
										pager+='<li class="active"><a href="javascript:void(0);">'+(i+1)+'</a></li>';
									}else{
										pager+='<li><a onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(i+1)+','+sites_id+')" href="javascript:void(0);">'+(i+1)+'</a></li>';
									}
								}
							}
							
						}
						
						if(curPage>=allPage){
							pager+='<li class="next disabled"><a href="javascript:void(0);" title="Next"><i class="fa fa-angle-right"></i></a></li>'+
						'<li class="next disabled"><a href="javascript:void(0);" title="Last"><i class="fa fa-angle-double-right"></i></a></li>';
						}else{
							pager+='<li class="next"><a href="javascript:void(0);" onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(curPage+1)+','+sites_id+')" title="Next"><i class="fa fa-angle-right"></i></a></li>'+
						'<li class="next"><a href="javascript:void(0);" onclick="listData(\''+keywords+'\',\''+pingtai+'\','+(curPage+5)+','+sites_id+')" title="Last"><i class="fa fa-angle-double-right"></i></a></li>';
						}
						
					pager+='</ul>'+
				'</div>';
				
				$("#pager").append($(pager));
				
			}});
		}
	
		$(function(){
			var pt=$("#pingtai input");
			var pingtai="";
			for(var i=0;i<pt.length;i++){
				if($(pt[i]).attr("checked")=="checked"){
					if(pingtai==""){
						pingtai=$(pt[i]).attr("pid");
					}else{
						pingtai+=","+$(pt[i]).attr("pid");
					}
				}
			}
			
			$("#search_kws .list").click(function(){
				$("#search_kws .list").css("background","white");
				
				var kw=$.trim($(this).html());
				$("#search").val(kw);
				
				var pt=$("#pingtai input");
				var pingtai="";
				for(var i=0;i<pt.length;i++){
					if($(pt[i]).attr("checked")=="checked"){
						if(pingtai==""){
							pingtai=$(pt[i]).attr("pid");
						}else{
							pingtai+=","+$(pt[i]).attr("pid");
						}
					}
				}
				
				var sites_id=$("input[name='sites_id']:checked").attr("sites_id");
				
				listData(kw,pingtai,1,sites_id);
				
				
				$(this).css("background","green");
			});
			
			listData("",pingtai,1,-1);
			$("#pingtai input").click(function(){
				//$("#search_kws .list").css("background","white");
				var pt=$("#pingtai input");
				
				var pingtai="";
				for(var i=0;i<pt.length;i++){
					if($(pt[i]).attr("checked")=="checked"){
						if(pingtai==""){
							pingtai=$(pt[i]).attr("pid");
						}else{
							pingtai+=","+$(pt[i]).attr("pid");
						}
					}
				}
				
				var sites_id=$("input[name='sites_id']:checked").attr("sites_id");
				//alert(sites_id);
				
				var keywords=$.trim($("#search").val());
				listData(keywords,pingtai,1,sites_id);
			});
			
			$("#search_bnt").click(function(){
				$("#search_kws .list").css("background","white");
			
				var keywords=$.trim($("#search").val());
				if(keywords==""){
					return ;
				}
				
				var pt=$("#pingtai input");
				var pingtai="";
				for(var i=0;i<pt.length;i++){
					if($(pt[i]).attr("checked")=="checked"){
						if(pingtai==""){
							pingtai=$(pt[i]).attr("pid");
						}else{
							pingtai+=","+$(pt[i]).attr("pid");
						}
					}
				}
				
				var sites_id=$("input[name='sites_id']:checked").attr("sites_id");
				
				listData(keywords,pingtai,1,sites_id);
			});
			
			$("input[type='radio']").click(function(){
				$("#search_kws .list").css("background","white");
			
				var sites_id=$(this).attr("sites_id");
				
				var keywords=$.trim($("#search").val());
				var pingtai="";
				for(var i=0;i<pt.length;i++){
					if($(pt[i]).attr("checked")=="checked"){
						if(pingtai==""){
							pingtai=$(pt[i]).attr("pid");
						}else{
							pingtai+=","+$(pt[i]).attr("pid");
						}
					}
				}
				
				listData(keywords,pingtai,1,sites_id);
			});
		});
	</script>
</body>
</html>