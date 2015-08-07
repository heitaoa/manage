<#import "../common.ftl" as cc />
<@cc.html_head></@cc.html_head>
<@cc.html_body>
	<h3 class="page-title">
		内容编辑
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
				<a href="page_toPageBlock">页面模块编辑</a>
				<i class="fa fa-angle-right"></i>
			</li>
			<li>
				<a href="javascript:void(0);">内容编辑</a>
			</li>
		</ul>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN EXAMPLE TABLE PORTLET-->
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-globe"></i>${content.place} 
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
								 文字
							</th>
							<th>
								图片
							</th>
							<th>
								 操作
							</th>
						</tr>
					</thead>
					<tbody id="page_data">
						<#list subDatas as data>
							<tr did="${data.id}">
								<td>${data_index+1}</td>
								<td>${data.title}</td>
								<td><#if data.pic??&&data.pic!="">有图片<#else>无图片</#if></td>
								<td>
									<a href="#data_modify"><button onclick="updateById(${data.id})" class="btn green">修改</button></a>
									<button class="btn green up_move">↑</button>
									<button class="btn green down_move">↓</button>
									<button onclick="deleteById(${data.id})" class="btn yellow">删除</button>
								</td>
							</tr>
						</#list>
					</tbody>
					</table>
				</div>
			</div>
			
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
	
	<div class="row" id="data_modify">
		<div class="col-md-12">
			<div class="portlet box green ">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i><span id="oper_title">添加新内容</span><#if (content.desc)??&&(content.desc!="")><small style="color:black;">【${content.desc}】</small></#if>
					</div>
				</div>
				<div class="portlet-body form">
					<form class="form-horizontal" role="form" method="post" action="/adminche/modify_insert" id="dataMofifyForm">
						<input type="hidden" name="cid" value="${cid}">
						<input type="hidden" name="subData.id" value="0">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-3 control-label">文本</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.title" placeholder="请输入文本">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">点击链接</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.link" placeholder="请输入点击链接">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">曝光链接</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.link_back" placeholder="请输入曝光链接">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">目录</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.ctitle" placeholder="请输入目录">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">目录链接</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.clink" placeholder="请输入目录链接">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">颜色</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.color" placeholder="请输入颜色值">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">图片</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="subData.pic" placeholder="请上传图片">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputFile" class="col-md-3 control-label">上传</label>
								<div class="col-md-9">
									<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9" >
									<button type="button" class="btn green" id="tijiao">提交</button>
									<button type="button" class="btn yellow" id="quxiao">取消</button>
									<button type="button" class="btn yellow" id="quxiao" onclick="document.location.href='page_toPageBlock';">返回</button>
									<#if (content.sync_id>0)>
										<input type="checkbox" name="SYNC" value="SYNC">提交时同步WAP数据
									</#if>	
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</@cc.html_body>
<@cc.html_js></@cc.html_js>
	<script>
		
		
		function updateById(id){
			var date = new Date();
			var time = date.getTime();
			$.get("/adminche/modify_toUpdate?id="+id + "&random="+time,function(data){
				var subData=eval(data)[0];
				$("#dataMofifyForm").attr("action","/adminche/modify_update");
				//title link link_back ctitle clink color pic
				$("#dataMofifyForm input[name='subData.title']").val(subData.title);
				$("#dataMofifyForm input[name='subData.link']").val(subData.link);
				$("#dataMofifyForm input[name='subData.link_back']").val(subData.link_back);
				$("#dataMofifyForm input[name='subData.ctitle']").val(subData.ctitle);
				$("#dataMofifyForm input[name='subData.clink']").val(subData.clink);
				$("#dataMofifyForm input[name='subData.color']").val(subData.color);
				$("#dataMofifyForm input[name='subData.pic']").val(subData.pic);
				$("#dataMofifyForm input[name='subData.id']").val(subData.id);
				
				$("#oper_title").html("修改内容");
			});
		}
		function deleteById(id){
			$.get("/adminche/modify_delete?id="+id,function(data){
				if(data>0){
					document.location.href="/adminche/modify_toPageModify?cid=${content.id}&time="+new Date().toString();
				}
			});
		}
		
		$(function(){
			if($("#page_data tr").length<=0){
				$("#page_data").append($("<tr><td colspan=4 style='text-align:center;'><span style='color:red;'>!</span>还没有添加任何数据~~</td></tr>"));
			}
			
			$("#quxiao").click(function(){
				$("#dataMofifyForm").attr("action","/adminche/modify_insert");
				$("#oper_title").html("添加新内容");
				$("#dataMofifyForm input").val("");
			});
			
			$("#tijiao").click(function(){
				var title=$("#dataMofifyForm input[name='subData.title']").val();
				if(title==""){
					alert("请至少输入文本！");
					return ;
				}
				var link=$("#dataMofifyForm input[name='subData.link']").val();
				if(link.length > 1000){
					alert("点击链接字数不能超过1000");
					return ;
				}
				var link_back=$("#dataMofifyForm input[name='subData.link_back']").val();
				if(link_back.length > 1000){
					alert("曝光链接字数不能超过1000");
					return ;
				}
				
				$("#dataMofifyForm").submit();
			});
			
			
			$(".up_move").click(function(){
				var tr=$(this).parent().parent();
				var pre=tr.prev();
				
				if(pre!=null){
					$.get("/adminche/modify_changeSort?sortId_01="+tr.attr("did")+"&sortId_02="+pre.attr("did"),function(data){
						if(eval(data)){
							pre.before(tr);
							
							refreshSortNumber();
						}
					});
				}
			});
			
			$(".down_move").click(function(){
				var tr=$(this).parent().parent();
				var next=tr.next();
				
				if(next!=null){
					$.get("/adminche/modify_changeSort?sortId_01="+tr.attr("did")+"&sortId_02="+next.attr("did"),function(data){
						if(eval(data)){
							next.after(tr);
							
							refreshSortNumber();
						}
					});
				}
			});
			
			
		});
		
		function changeSort(id01,id02){
			
		}
		
		function refreshSortNumber(){
			var trs=$("#page_data tr");
			
			for(var i=0;i<trs.length;i++){
				var tr=$(trs[i]);
				$(tr.find("td")[0]).html(i+1);
			}
			
		}
		
		function callbackSucc(data){
			$("#dataMofifyForm input[name='subData.pic']").val(data[0].imgPath);
		}
	</script>
	<@cc.uploadimg></@cc.uploadimg>
</html>
