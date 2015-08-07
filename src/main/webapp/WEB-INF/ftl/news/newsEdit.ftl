<#import "../common.ftl" as c>
<#import "common_news.ftl" as cp>

<script type="text/javascript">
	window.UEDITOR_HOME_URL = "${admin_che_url}ueditor/";
</script>


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
		<div class="col-md-6">
			<a id="edit_by_other_news" class="btn green" data-toggle="modal">从其他新闻复制</a>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">新闻目录：</label>
		<div class="col-md-5">
			<div class="input-group">
				<div class="input-icon">
					<input id="news_catalog_name" class="form-control" type="text" disabled="" placeholder="${(newsCatalog.catalogname)!}">
				</div>
				<span class="input-group-btn">
					<button id="selectNewsTree" type="button" class="btn btn-success" id="genpassword"><i class="fa fa-arrow-left fa-fw"></i> 选择目录</button>
				</span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label"></label>
		<div class="col-md-5">
			<p class="form-control-static"><div id="news_catalog_tree" class="zTreeBg"><ul id="treeMenu_news" class="ztree"></ul></div></p>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">新闻标题：</label>
		<div class="col-md-5">
			<div class="input-group">
				<span id="title_num" class="input-group-addon">0</span>
				<input id="inp_title" type="text" placeholder="${(news.newstitle)!}" value="${(news.newstitle)!}" onchange="testInputLength(this.value, 'title_num')" onkeyup="testInputLength(this.value, 'title_num')" class="form-control">
			</div>
			<span class="help-block"> 标题18字，少于或超出部分会变红色。 </span>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label"></label>
		<div class="checkbox-list">
			<label class="col-md-3">
			<input id="news-tag-bk" type="checkbox">  必看(重点推荐) </label>
			<label class="col-md-2">
			<input id="public_wap_page" <#if news.iswap == 1>checked="true"</#if> type="checkbox">  同步wap版  </label>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">分页标题：</label>
		<div class="col-md-5">
			<input id="sub_page_title" class="form-control" type="text" placeholder="${(newContent.newstitle)!}">
		</div>
	</div>
	
	<#if contentPages gt 1>
	<div class="row">
		<label class="col-md-1 control-label">选择分页：</label>
		<div class="col-md-5">
			<ul class="pagination bootpag">
			<#list 1..contentPages as cont>
            	<li <#if contentPage == cont>class="disabled"</#if> ><a href="./viewNewsEdit?isModify=1&newsid=${news.id}&contentPage=${cont}">${cont}</a></li>
            </#list>
            </ui>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label"></label>
		<div class="col-md-5">
			<input id="insert_fen_ye" type="checkbox">分页导航 </label>
		</div>
	</div>
	</#if>
	
	<!-- -->	 
	<div class="row">
		<label class="col-md-2 control-label"></label>
		<div class="form-group col-md-5">
			<div class="radio-list">
				<label><input type="checkbox" name="" id="news-tag-yc"  value="checkbox1" <#if news?? && news["isoriginal"]?eval == 1 >checked="true"</#if> >原创</label>
				<!--
				<label><input type="checkbox" name="" id="news-tag-yh"  value="checkbox1">优惠</label>
				<label><input type="checkbox" name="" id="news-tag-qt"  value="checkbox1">其他</label>
				-->
			</div>
		</div>
	</div>
	
	
	<div class="row">
		<label class="col-md-1 control-label">新闻出处</label>
		<div class="col-md-5">
		
			<div class="input-group">
				<div class="input-icon">
					<input id="ipt_news_source" class="form-control" type="text" placeholder="中国汽车消费网">
				</div>
			</div>
		
			<select id="sel_news_source" class="form-control col-md-4">
			<#if newSourceList ??>
				<#list newSourceList as newSource>
					<option <#if news?? && news.newseditor?? && newSource.newseditor == news.newseditor>checked</#if> value="${newSource.newseditor}">${newSource.newseditor}</option>
				</#list>
			</#if>
			</select>
			
			<span class="help-block"> 优先选择手动输入的新闻出处。 </span>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">关联车系：</label>
		<div class="col-md-5">
			<div class="input-group">
				<div class="input-icon">
					<input id="ipt_view_car_catalog" class="form-control" type="text" disabled="" placeholder="${(carCatalognew.catalogname)!}">
				</div>
				<span class="input-group-btn">
					<button id="btn_sel_car_catalog" type="button" class="btn btn-success"><i class="fa fa-arrow-left fa-fw"></i> 选择车系</button>
				</span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label"></label>
		<div class="col-md-5">
			<p class="form-control-static"><div id="car_catalog_tree" class="zTreeBg"><ul id="treeMenu" class="ztree"></ul></div></p>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">关键词：</label>
		<div class="col-md-5">
			<input id="inp_keywords" class="form-control" type="text" placeholder="${(news.newskeywords)!}" value="${(news.newskeywords)!}">
		</div>
	</div>
	
	<div class="row">
		<div class="btn-group-vertical btn-group-solid" style="position: fixed; z-index: 1000; top: 60px; right: 5px;">
			<button id="edit_choice_pic" type="button" class="btn btn-success"><i class="fa fa-arrow-left fa-fw"></i> 选择图片</button>
			<button id="edit_tuku_pic" type="button" class="btn red"><i class="fa fa-arrow-left fa-fw"></i> 图库</button>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-9">
			<!-- 加载编辑器的容器  -->
			<script id="container" name="content" type="text/plain">${(newsContentStr)!}</script>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">发布时间：</label>
		<div class="col-md-5">
			<div class="input-group">
				<input id="inp_publish_time" type="text" value="<#if news?? && news.adddate??>${news.adddate?string("yyyy-MM-dd HH:mm:ss")}<#else>${today?string("yyyy-MM-dd HH:mm:ss")}</#if>" class="form-control">
			</div>
			<span class="help-block"> eg:<#if today??>${today?string("yyyy-MM-dd HH:mm:ss")}<#else>2015-01-01 08:00:00</#if> </span>
		</div>
	</div>
	
	<div class="row">
		<label class="col-md-1 control-label">主题图片：</label>
		<div class="col-md-5">
			<div id="zhuti_img">
				${(news.titlephoto)!"..."}
				<a href='#' onclick='onDelTitleImg()'>清除</a>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<button id="title_pic_btn" type="button" class="btn btn-success"><i class="fa fa-arrow-left fa-fw"></i> 选择图片</button>
		</div>
	</div>
	
	<div class="row"><div class="col-md-7"></div></div>
	
	<div class="row">
		<div class="col-md-7">
			<!-- <button id="btn_preview" class="btn blue" type="button">预览</button> -->
			<button id="btn_save" class="btn blue" type="button">保存</button>
			<button id="btn_save_newp" class="btn blue" type="button">保存并添加新页</button>
			<#if isModify != 1>
			<button id="btn_pre_publish" class="btn blue" type="button">预发布</button>
			</#if>
			<button id="btn_back" class="btn blue" type="button">返回新闻列表页</button>
			
			<#if contentPages gt 1 && isModify ==1>
			<button id="btn_del_content" class="btn blue" type="button">删除该分页</button>
			</#if>
		</div>
	</div>

	<form id="form_page_edit" action="saveNews" method="post" >
		<input id="newsCatalogid" name="newsCatalogid" type="hidden" value="${(newsCatalogid)!}" />
	
		<input id="catalog_catalogid" name="newsCatalog.catalogid" type="hidden" value="${(newsCatalog.catalogid)!0}" />
		<input id="catalog_catalogname" name="newsCatalog.catalogname" type="hidden" value="${(newsCatalog.catalogname)!}" />
		<input id="catalog_areaid" name="newsCatalog.areaid" type="hidden" value="${(newsCatalog.areaid)!0}" />
		
		<input id="news_id" name="news.id" type="hidden" value="${(news.id)!}" />
		<input id="news_newscatalogid" name="news.newscatalogid" type="hidden" value="${(news.newscatalogid)!0}" />
		<input id="news_areaid" name="news.areaid" type="hidden" value="${(news.areaid)!}" />
		<input id="news_carcatalogid" name="news.carcatalogid" type="hidden" value="${(news.carcatalogid)!}" />
		<input id="news_newstitle" name="news.newstitle" type="hidden" value="${(news.newstitle)!}" />
		<input id="news_newskeywords" name="news.newskeywords" type="hidden" value="${(news.newskeywords)!}" />
		<input id="news_titlephoto" name="news.titlephoto" type="hidden" value="${(news.titlephoto)!}" />
		<input id="news_newseditor" name="news.newseditor" type="hidden" value="${(news.newseditor)!}" />
		<input id="news_addadmin" name="news.addadmin" type="hidden" value="${(news.addadmin)!}" />
		<input id="news_updateadmin" name="news.updateadmin" type="hidden" value="${(news.updateadmin)!}" />
		<input id="news_deladmin" name="news.deladmin" type="hidden" value="${(news.deladmin)!}" />
		<input id="news_totop" name="news.totop" type="hidden" value="${(news.totop)!}" />
		<input id="news_tosink" name="news.tosink" type="hidden" value="${(news.tosink)!}" />
		<input id="news_gradeid1" name="news.gradeid1" type="hidden" value="${(news.gradeid1)!}" />
		<input id="news_gradeid2" name="news.gradeid2" type="hidden" value="${(news.gradeid2)!}" />
		<input id="news_gradeid3" name="news.gradeid3" type="hidden" value="${(news.gradeid3)!}" />
		<input id="news_gradeid4" name="news.gradeid4" type="hidden" value="${(news.gradeid4)!}" />
		<input id="news_gradeid5" name="news.gradeid5" type="hidden" value="${(news.gradeid5)!}" />
		<input id="news_adddate" name="news.adddate" type="hidden" value="<#if news.adddate?has_content>${(news.adddate)?string("yyyy-MM-dd")}</#if>" />
		<input id="news_isdelete" name="news.isdelete" type="hidden" value="${(news.isdelete)!}" />
		<input id="news_sortid" name="news.sortid" type="hidden" value="${(news.sortid)!}" />
		<input id="news_isphoto" name="news.isphoto" type="hidden" value="${(news.isphoto)!}" />
		<input id="news_description" name="news.description" type="hidden" value="${(news.description)!}" />
		<input id="news_isoriginal" name="news.isoriginal" type="hidden" value="${(news.isoriginal)!"0"}" />
		<input id="news_isimgnews" name="news.isimgnews" type="hidden" value="${(news.isimgnews)!}" />
		<input id="news_pricedown" name="news.pricedown" type="hidden" value="${(news.pricedown)!}" />
		<input id="news_carslevel" name="news.carslevel" type="hidden" value="${(news.carslevel)!}" />
		<input id="news_serialid" name="news.serialid" type="hidden" value="${(news.serialid)!}" />
		<input id="news_shorttitle" name="news.shorttitle" type="hidden" value="${(news.shorttitle)!}" />
		<input id="news_chktitlephoto" name="news.chktitlephoto" type="hidden" value="${(news.chktitlephoto)!}" />
		<input id="news_chkdescription" name="news.chkdescription" type="hidden" value="${(news.chkdescription)!}" />
		<input id="news_islook" name="news.islook" type="hidden" value="${(news.islook)!}" />
		<input id="news_ismultpagelink" name="news.ismultpagelink" type="hidden" value="${(news.ismultpagelink)!}" />
		<input id="news_iswap" name="news.iswap" type="hidden" value="${(news.iswap)!}" />
	
		<input id="content_id" name="newContent.id" type="hidden" value="${(newContent.id)!"0"}" />
		<input id="content_newsid" name="newContent.newsid" type="hidden" value="${(newContent.newsid)!"0"}" />
		<input id="content_areaid" name="newContent.areaid" type="hidden" value="${(newContent.areaid)!"0"}" />
		<input id="content_carcatalogid" name="newContent.carcatalogid" type="hidden" value="${(newContent.carcatalogid)!"0"}" />
		<input id="content_newstitle" name="newContent.newstitle" type="hidden" value="${(newContent.newstitle)!}" />
		<input id="content_newskeywords" name="newContent.newskeywords" type="hidden" value="${(newContent.newskeywords)!}" />
		<input id="content_newscontent" name="newContent.newscontent" type="hidden" value="" />
		<input id="content_sortid" name="newContent.sortid" type="hidden" value="${(newContent.sortid)!"0"}" />
		<input id="content_isdelete" name="newContent.isdelete" type="hidden" value="${(newContent.isdelete)!"2"}" />
		<input id="content_titleimgpath" name="newContent.titleimgpath" type="hidden" value="${(newContent.titleimgpath)!}" />
		<input id="content_serialid" name="newContent.serialid" type="hidden" value="${(newContent.serialid)!"0"}" />
		
		<input id="newsContentStr" name="newsContentStr" type="hidden" value="" />
		
		
		<input id="contentbak_id" name="contentbak.id" type="hidden" value="${(contentbak.id)!"0"}" />
		<input id="contentbak_cid" name="contentbak.cid" type="hidden" value="${(contentbak.cid)!"0"}" />
		<input id="contentbak_contentstr" name="contentbak.contentstr" type="hidden" value="" />
				
		<input id="next_sortid" name="next_sortid" type="hidden" value="${(next_sortid)!"1"}" />
		
		<!-- 内容 页码 -->
		<input id="contentPage" name="contentPage" type="hidden" value="${contentPage!"1"}" />
		
		<!-- 发布时间 -->
		<input id="newPublishtimeStr" name="newPublishtimeStr" type="hidden" value="${newPublishtimeStr!}" />
		
		<!-- 是否是修改 -->
		<input id="isModify" name="isModify" type="hidden" value="${(isModify)!"0"}" />
		
		<!-- 返回新闻列表页 定位新闻目录 -->
		<input id="node_id" name="node_id" type="hidden" value="${node_id!}" />
		
		<input id="saveType" name="saveType" type="hidden" value="${saveType!0}" />
		
		<!-- 车链-->
		<input id="insert_car_link" name="insert_car_link" type="hidden" value="" />
		
		<!-- 相关新闻 
		<input id="relation_news_1" name="relation_news" type="hidden" value="" />
		-->
		
	</form>
	</div>
	
	<!--弹出框-->
	<div id="pop_up_box_modal" class="modal fade" tabindex="-1" data-width="960">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			<h4 id="pop_up_title" class="modal-title">图片选择</h4>
		</div>
		<div id="pop_up_body" class="modal-body">
		<!-- content -->
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
			<button id = "pop_up_sure_btn"  type="button" data-dismiss="modal" class="btn blue">确定</button>
		</div>
	</div>
		


</@c.html_body>
<@c.html_js></@c.html_js>
	<script src="${admin_che_url}js/tqutil.js" type="text/javascript"></script>
	<script src="${admin_che_url}js/jquery.form.js" type="text/javascript"></script>
	<!-- 配置文件 -->
	<script type="text/javascript" src="${admin_che_url}ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="${admin_che_url}ueditor/ueditor.all.js?v=20150316"></script>
	<script type="text/javascript" src="${admin_che_url}ueditor/lang/zh-cn/zh-cn.js"></script>

	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('container');
	    
	    function callback_getEditImg(jsonStr)
	    {
	    	//alert("callback_getEditImg: "+jsonStr);
	    	
	    	var arr = jQuery.parseJSON(jsonStr);
	    	
	    	var html = "";
			for(var i = 0;i<arr.length;i++){
				html = html + "<p>";
				html = html + "<img src='"+arr[i]+"'/>"
				html = html + "</p>";
			}
	    	
	    	ue.execCommand('insertHtml', html);
	    }
	    
	    
	    var upload_img_type=0;//0|文章内容；1|主题新闻
	    
	    function onDelTitleImg(){
	   		
	   		$("#content_titleimgpath").val("");
				
			if($("#contentPage").val() == 1){
				$("#news_titlephoto").val("");
			}
			
			$("#zhuti_img").html("已清除");
	    }
	   
	    //上传图片成功后调用
	    function callbackSucc(data)
		{	
			//alert("--------------");
		
			var names= data;
			
			if(upload_img_type == 0){
				var html = "";
				for(var i = 0;i<names.length;i++){
					html = html + "<p style='text-align: center;'>";
					//html = html + "<a href='"+names[i].BigImgPath+"' target='_blank'><img src='"+names[i].FormatImgPath+"'/></a>"
					html = html + "<img src='"+names[i].FormatImgPath+"'/>"
					html = html + "</p>";
				}
				ue.execCommand('insertHtml', html);
			}
			
			//标题图片
			if(upload_img_type == 1){
				//var title_photo = names[0].uploadPath;
				var format_photo = names[0].FormatImgPath;
				var html = "<img src='"+format_photo+"'/>";
				html = html+ "<a href='#' onclick='onDelTitleImg()'>删除</a>";
				$("#zhuti_img").html(html);
				
				$("#content_titleimgpath").val(format_photo);
				
				if($("#contentPage").val() == 1){
					$("#news_titlephoto").val(format_photo);
				}
			}
		}
		
		//图库选择后，确认
		function successImagesBack(data,size){
			    	
			//alert(data);
			var html = "";
			for(var i = 0;i<data.length;i++){
				html = html + "<p style='text-align: center;'><a href='"+data[i].BigImgPath+"' target='_blank'>";
				if(size == 600){
					var formatImgPath = data[i].newsimgPath1;
					var idVal = $("input[name='imgSize']:checked").attr("id");
					//判断是否选择的是需要水印的图片
					if(idVal=="imgSize4"){
						var body = formatImgPath.substring(0,formatImgPath.lastIndexOf("."));
						var foot = formatImgPath.substring(formatImgPath.lastIndexOf("."));
						formatImgPath = body+"water8"+foot;
					}
					html = html + "<img src='"+formatImgPath+"'/>";
				}
				if(size == 290){
					html = html + "<img src='"+data[i].newsimgPath2+"'/>";
				}
				if(size == 0){
					html = html + "<img src='"+data[i].newsimgPath3+"'/>";
				}
				html = html + "</a></p>";
			}
			ue.execCommand('insertHtml', html);
		}
	 
	 //车链
	 $(document).ready(function(){
	 
	 	//上传图片
		$("#edit_choice_pic").on("click", function(){
			upload_img_type=0;
			$("#imgUploadModal").modal("show");	
		});
		
		//图库
		$("#edit_tuku_pic").on("click", function(){
			upload_img_type=0;
			imageGet(2);
		});
		
		
		//主题图片
		$("#title_pic_btn").on("click", function(){
			upload_img_type=1;
			$("#imgUploadModal").modal("show");	
		});
	 	
		//从其他新闻复制
		$("#edit_by_other_news").on("click", function(){
			var newsCatalogid = $("#news_newscatalogid").val();
			var node_id = $("#node_id").val();
			$.get("viewNewsList", {resFlag:1, newsCatalogid:newsCatalogid, node_id:node_id, pageSize:6}, function(data){
				$("#pop_up_title").html("请选择一片新闻作为模板");
				$("#pop_up_body").html(data);
				$("#pop_up_box_modal").modal("show");	
			});
		});
	 	
	 	//车链
		$("#insert_che_lian").on("click", function(){
			var catalogid = $("#news_carcatalogid").val();
			//alert("catalogid:"+catalogid);
			
			if(catalogid == 0 ){
				alert("请选择车系");
				return;
			}		
			
			$.get("newsCarLink", {catalogid:catalogid}, function(data){
				if(data.substring(0, 1) != "1"){
					alert(data);
				}
				else
				{
					var str = data.substring(1);
					$("#insert_car_link").val(str)
					
					//alert("-->"+str);
					ue.execCommand('insertHtml', "##车链##");
				}
			});
		
		});
		
	 	
		//$("#insert_che_lian").prop({checked:true});
		
		//分页导航
		function refCalcPageTip(){
			var show = $("#insert_fen_ye").prop("checked");
			//alert("-----"+show);
			if(show)
			{
				$("#news_ismultpagelink").val(1);
			}
			else
			{
				$("#news_ismultpagelink").val(0);
			}
		}
		
		refCalcPageTip();
		$("#insert_fen_ye").on("click", function(){
			refCalcPageTip();
		});
		
		
		//wap版
		function refWapPge(){
			var iswap = $("#public_wap_page").prop("checked");
			//alert("-----"+iswap);
			if(iswap)
			{
				$("#news_iswap").val(1);
			}
			else
			{
				$("#news_iswap").val(0);
			}
		}
		
		//wap版首页的往期回顾、上海优惠和新车实拍
		//var dirName = $("#news_catalog_name").val();
		var dirName = $("#news_catalog_name").attr("placeholder");
		
		//alert(dirName);
		if(dirName == "往期回顾" || dirName == "上海优惠" || dirName == "新车实拍")
		{
			$("#public_wap_page").prop({checked:true});
		}
		refWapPge();
		$("#public_wap_page").on("click", function(){
			refWapPge();
		});
		
		
	 });
	 
	
	//点击"添加相关新闻" 树节点
	function onClickNewsRelation(event, treeId, treeNode, clickFlag){
		//alert(treeNode.name+"==="+treeId);
		
		$("#news_relation_container").append('<span id="sp_relation_'+ treeNode.id +'" class="sub_news_block">'+treeNode.name+'<b id="relation_'+treeNode.id+'" onclick="onCleanRelation('+treeNode.id+')">x</b></span>');
		//$("#news_newscatalogid").val(treeNode.id);
	}
	
	//相关新闻初始化
	<#if newRelatedList??>
	<#list newRelatedList as related>
	addRelationNews(${related.id}, "${related.contentid}|${related.title}|${related.url}");
	</#list>
	</#if>
	
	//添加相关新闻
	function addRelationNews(id, value){
		//alert(treeNode.name+"==="+treeId);
		//alert(title.split("|")[1]);
		var title = value.split("|")[1];
		var url = value.split("|")[2];
		$("#news_relation_container").append('<span id="sp_relation_'+ id +'" class="sub_news_block">'+title+'<b id="relation_'+id+'" onclick="delRelationNews('+id+')">x</b></span>');
		//
		$("#form_page_edit").append('<input id="relation_news_'+id+'" name="relation_news" type="hidden" value="'+value+'" />');
		//$("#news_newscatalogid").val(id);
	}
	
	//移除相关新闻
	function delRelationNews(id){
		$("#sp_relation_"+id).remove();
		$("#relation_news_"+id).remove();
	}
	
	
	
	function alertRelationCallBakSucc(data){
		//alert(456);
		$("#relation_body").html(data);
	}
	
	
	$(function (){
	
	
		//新闻目录
		createTree3("新闻目录",'treeMenu_news', onclickNewsCatalog);
		$("#news_catalog_tree").hide();
		$("#selectNewsTree").on("click", function(){
			$("#news_catalog_tree").toggle();
		})
		
		//点击新闻目录树节点
		function onclickNewsCatalog(event, treeId, treeNode, clickFlag){
			//alert(treeNode.name+"==="+treeId);
			$("#news_catalog_name").attr({"placeholder":treeNode.name});
			$("#news_newscatalogid").val(treeNode.id);
			$("#news_areaid").val(treeNode.areaid);
			alert("treeNode.areaid:"+treeNode.areaid);
			$("#news_catalog_tree").hide();//选择目录后隐藏树
			
			$("#public_wap_page").prop({checked:false});
			var dirName = treeNode.name;
			if(dirName == "往期回顾" || dirName == "上海优惠" || dirName == "新车实拍")
			{
				$("#public_wap_page").prop({checked:true});
			}
		}
		
		//复选框：是否原创	默认选中
		//$("#news-tag-yc").prop({checked:true});
		//$("#news_newseditor").val("车团#http://www.chetuan.com/");
		
		//news-tag-yc
		$("#news-tag-yc").on("click", function(){
			if($(this).is(":checked"))
					$("#news_isoriginal").val(1);
			else
					$("#news_isoriginal").val(0);
			//alert($("#news_isoriginal").val());
		})
		
		//news-tag-yh
		$("#news-tag-yh").on("click", function(){
			
		})
		
		//news-tag-qt
		$("#news-tag-qt").on("click", function(){
			
		})
		
		//news-tag-bk
		$("#news-tag-bk").on("click", function(){
			if($(this).is(":checked"))
				$("#news_islook").val(1);
			else
				$("#news_islook").val(0);
		})
		
		//sel_news_source
		$("#sel_news_source").on("change", function(){
			$("#news_newseditor").val($(this).val());
		})
		
		//关联车系
		//$("#btn_sel_car_catalog").show();
		$("#car_catalog_tree").hide();
		createTree3("车型目录",'treeMenu', onclickCarSeries);
		$("#btn_sel_car_catalog").on("click", function(){
			$("#car_catalog_tree").toggle();
		})
		
		//点击车系录树节点
		function onclickCarSeries(event, treeId, treeNode, clickFlag){
			//alert(treeNode.name+"==123="+treeNode);
			$("#ipt_view_car_catalog").attr({"placeholder":treeNode.name});
			$("#news_carcatalogid").val(Number(treeNode.id));
			$("#car_catalog_tree").hide();//选择后隐藏树
			
			//显示车链
			$("#insert_che_lian").attr("style","");
		}
		
		//相关新闻
		$("#news_relation_tree").hide();
		//createTree3("新闻目录",'newsRelationtreeMenu', onClickNewsRelation);
		$("#a_news_relation").on("click", function(){
			//$("#news_relation_tree").toggle();
			$.post("pageListView", { subFlag: "1","catalog.catalogid":"${news.newscatalogid}", node_id:"${node_id!"0"}"},
			   function(data){
			     //alert("Data Loaded: " + data);
					
					$("#relation_view_bg").css({display:"block",height:$(document).height()});
					$("#relation_float_container").css("top","150px");
					$("#relation_float_container").css("display","block");
					document.documentElement.scrollTop = 0;
					
					$("#relation_body").html(data);
			   });
		})
		
		$("#relation_alert_close").on("click", function(){
			$("#relation_view_bg").css("display","none");
			$("#relation_float_container").css("display","none");
		});
		
		//关键字
		$("#inp_keywords").on("change keyup", function(){
			$("#news_newskeywords").val($(this).val());
		})
		
		
		
	    $("#btn_save_pic").on("click", function(){
	    	newsVerify(0);
	    });
	    
	    $("#btn_save").on("click", function(){
	    	newsVerify(2);
	    });
	    
	    $("#btn_save_newp").on("click", function(){
	    	newsVerify(3);
	    });
	    //预发布
	    $("#btn_pre_publish").on("click", function(){
	    	newsVerify(4);
	    });
	    
	    $("#btn_back").on("click", function(){
	    	//history.go(-1);
	    	document.location.href = "viewNewsList?newsCatalogid=${news.newscatalogid}&node_id=${node_id!}";
	    });
	    
	    //预览
		$("#btn_preview").on("click", function(){
			newsVerify(1);
		});
		
	    //1|预览;2|保存;
		function newsVerify(postType)
		{
			//alert($("#news_newscatalogid").val());
			if($("#news_newscatalogid").val()< 2)
			{
				alert("请选择新闻目录 ");
				return;
			}
		
			if($("#inp_title").val().length < 1)
			{
				alert("请输入新闻标题 ");
				return;
			}
			
			if($("#inp_keywords").val().length < 1)
			{
				alert("请输入关键词");
				return;
			}
			
			$("#news_newstitle").val($("#inp_title").val());
			//分页标题
			$("#content_newstitle").val($("#sub_page_title").val());
			
			if($("#news_newscatalogid").val().length < 1)
			{
				alert("请选择目录 ");
				return;
			}
			//
			if(!ue.hasContents())
			{
				alert("请输入新闻内容 ");
				return;
			}
			if(ue.getContent() =="新闻内容")
			{
				alert("请输入新闻内容 ");
				return;
			}
			
			var conStr = ue.getContent();
			
			var clStr = $("#insert_car_link").val();
			
			conStr = conStr.replace("##车链##", clStr);
			$("#newsContentStr").val(conStr);
			
			//年月日
			var publishStr = $("#inp_publish_time").val();
			
			if(!publishStr)
			{
				alert("请输入发布日期");
				return false;
			}
			if(publishStr.length < 19)
			{
				alert("日期格式不对");
				return false;
			}
			var boo = CheckDT(publishStr.split(" ")[0]);
			if(!boo)
			{
				alert("日期格式不对");
				return false;
			}
			boo = CheckTime(publishStr.split(" ")[1]);
			if(!boo)
			{
				alert("时间格式不对");
				return false;
			}
			
			//预发布
			if(postType == 4){
				$("#newPublishtimeStr").val(publishStr);
			}
			
			//只在修改操作是才赋值	
			if( $('#isModify').val()== 1 && $('#news_gradeid1').val()== 0 )
				{
					$("#news_adddate").val(publishStr);
					//alert("改");
				}
				else
				{
					//alert("不改");
				}
			
			//新闻出处		ipt_news_source
			var news_source = $('#ipt_news_source').val();
			//alert(news_source);
			if(news_source.length)
				{
					$("#news_newseditor").val(news_source);
					//alert($("#news_newseditor").val());
				}
			
			//预览
			if(postType ==1)
			{
				$("#form_page_edit").attr({action:"previewNews", target:"_blank"});
				$("#form_page_edit").submit();
				return true;
			}
			//保存
			if(postType ==2)
			{
				//提交
				$("#saveType").val(2);
				$("#form_page_edit").attr({action:"saveNews", target:""});
				$("#form_page_edit").submit();
				return true;
			}
			//保存并添加分页
			if(postType ==3)
			{
				$("#saveType").val(3);
				$("#form_page_edit").attr({action:"saveNews", target:""});
				$("#form_page_edit").submit();
				return true;
			}
			
			//保存并添加分页
			if(postType ==4)
			{
				$("#saveType").val(4);
				$("#form_page_edit").attr({action:"saveNews", target:""});
				$("#form_page_edit").submit();
				return true;
			}
		}
		
		//上传图片
		$("#btn_upload_news_pic").on("change",function(){
			$("#form_upload_news_pic").ajaxSubmit({ 
				success: callUpPic
				});
		});
		
		function callUpPic(html, status) {
			//alert(html);
			$("#img_news_pic").attr('src', html); 
			$("#news_titlephoto").val(html);
		}
		
		//err
		var err = '${err!}';
		if(err.length >0)
		{
			alert(err);
		}
		
		
		 //删除分页
	    $("#btn_del_content").on("click", function(){
	    	var contentid = ${(newContent.id)!"0"};
	    	var boo=confirm("确认要删除该分页么？");
			 if(boo){
				$.get("deleteContent", {"contentid": contentid},
				  function(data){
				    alert(data);
				    if(data == "删除成功")
				    {
				    	//$("#form_page_list").submit();
				    	location.href='./viewNewsEdit?isModify=1&newsid=${(news.id)!}';
				    }
				  });
				}
	    }); 
	
	});
	
	
	function testInputLength(str, dis)
	{
	     var len = countCharacters(str)/2;
	     $("#title_num").html(len);
	     if(len == 18)
	     {
	      	$("#inp_title").removeAttr("style");
	     }
	     else
	     {
	     	$("#inp_title").attr("style","color:#FF0000");
	     }
	}
	
function CheckDT(str)     
{     
    var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
    if(r==null)
    {
        return false;     
    }
    else
    {
        var d= new Date(r[1], r[3]-1, r[4]);     
        return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]); 
    }    
}

function CheckTime(str)     
{     
  var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);     
  if (a==null)
     {
        alert('时间格式不正确');   
        return false;
      }     
  if (a[1]>24 || a[3]>60 || a[4]>60)     
  {     
      alert("无效时间");     
      return false     
  }     
  return true;     
}  


</script>
<@c.uploadimg3 news_width=600/>
<@c.imageGet/>
</body>
</html>