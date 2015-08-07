<#macro calcPageByJs jsfun page pages>

<div class="pages">
	<ul class="pagination" style="visibility: visible;">
		<li class="prev"><a href="javascript:void(0);" title="Prev" onclick="${jsfun}(1);"><i class="fa fa-angle-left"></i></a></li>
		<!--<a href="javascript:void(0);" onclick="${jsfun}(1);">&lt;</a>-->
		<#if page-2 gt 0 ><li><span> ... </span></li></#if>
		<#list page-2..page-1 as p>
			<#if p gt 0 ><li><a href="javascript:void(0);" onclick="${jsfun}(${p});">${p}</a></li></#if>
		</#list>
		<li class="active"><a  href="javascript:void(0);" onclick="${jsfun}(${page});">${page}</a></li>
		<#list page+1..page+2 as p>
			<#if p lte pages ><li><a href="javascript:void(0);" onclick="${jsfun}(${p});">${p}</a></li></#if>
		</#list>
		<#if page+2 lt pages ><li><span> ... </span></li></#if>
		<li class="next"><a href="javascript:void(0);" onclick="${jsfun}(${pages});"><i class="fa fa-angle-right"></i></a></li>
		<li><span>跳转到</span>
		
		<input id="turn_Page" name="" type="text" class="form-control input-inline" style=" width:50px; height:33px; float: left; border-left: 0; border-right: 0;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
		
		
		<a href="javascript:void(0);" onclick="${jsfun}($('#turn_Page').val());">GO</a></li>
	</ul>
</div>
</#macro>
<#macro calcPage action page pages>
	<a href="./${action}&page=1">首页</a>　
	<a class="blue" <#if page-1 gt 0 >href="./${action}&page=${page-1}"</#if>>上一页</a>　　
	<#list page-2..page-1 as p>
	<#if p gt 0 ><a href="./${action}&page=${p}">${p}</a>　</#if>
	</#list>
	<span>${page}</span>　
	<#list page+1..page+2 as p>
	<#if p lte pages ><a href="./${action}&page=${p}">${p}</a>　</#if>
	</#list>
	<a class="blue" <#if page+1 lte pages >href="./${action}&page=${page+1}"</#if>>下一页</a> 　
	<a href="./${action}&page=${pages}">末页</a>
</#macro>

<#macro calcPage1 action page pages>
	<a href="./${action}?page=1">首页</a>　
	<a class="blue" <#if page-1 gt 0 >href="./${action}?page=${page-1}"</#if>>上一页</a>　　
	<#list page-2..page-1 as p>
	<#if p gt 0 ><a href="./${action}?page=${p}">${p}</a>　</#if>
	</#list>
	<span>${page}</span>　
	<#list page+1..page+2 as p>
	<#if p lte pages ><a href="./${action}?page=${p}">${p}</a>　</#if>
	</#list>
	<a class="blue" <#if page+1 lte pages >href="./${action}?page=${page+1}"</#if>>下一页</a> 　
	<a href="./${action}?page=${pages}">末页</a>
</#macro>

<#macro pager1 url currentPage totalPage currentClass="" rows=10>
	<div class="pages">
	<ul class="pagination">
		
		<li <#if currentPage = 1>class="prev disabled"</#if>><a href=${url+"page="+1}>首页</a></li>
		<#if (currentPage>1)>
			<li><a href=${url+"page="}${currentPage-1}>&lt;</a></li>
			<#else>
			<li class="prev disabled"><a href="javascript:void(0);">&lt;</a></li>
		</#if>
		<#local halfPage=(rows/2)?int/>
		<#if totalPage==0>
			<li class="prev disabled"><a>${totalPage}</a></li>
		<#elseif (currentPage<= halfPage&&rows <= totalPage)>
			<#list 1..rows as n>
				<#if n==currentPage>
					<li class="active"><a id="fyxz">${currentPage}</a></li>
					<#else>
					<li ><a href=${url+"page="+n}>${n}</a></li>
				</#if>
			</#list>
			<#elseif (currentPage<= halfPage&&rows >= totalPage)>
				<#list 1..totalPage as n>
				<#if n==currentPage>
					<li class="active"><a id="fyxz">${currentPage}</a></li>
					<#else>
					<li><a href=${url+"page="+n}>${n}</a></li>
				</#if>
				</#list>
				
			<#elseif (currentPage>= halfPage&&(currentPage+halfPage)<= totalPage)>
				<#list (currentPage-halfPage)..(currentPage+halfPage-1) as n>
				<#if n==currentPage>
					<li><a id="fyxz">${currentPage}</a></li>
					<#else>
					<li><a href=${url+"page="+n}>${n}</a></li>
				</#if>
				</#list>
			<#else>
				<#list (currentPage-rows)..totalPage as n>
				<#if n==currentPage>
					<li class="active"><a id="fyxz">${currentPage}</a></li>
					<#else>
					<li><a href=${url+"page="+n}>${n}</a></li>
				</#if>
				</#list>
		</#if>
		<#if totalPage!=0>
			<li><a>共${currentPage}/${totalPage}页</a></li>
			<#else>
			<li><a>共${totalPage}/${totalPage}页</a></li>
		</#if>
		<#if currentPage<totalPage>
		 	<li><a href=${url+"page="}${currentPage+1}>&gt;</a></li>
		 	<#else>
		 	<li class="prev disabled"><a href="javascript:void(0);">&gt;</a></li>
		</#if>
		<li <#if currentPage = totalPage>class="prev disabled"</#if>><a href=${url+"page="+totalPage}>尾页</a></li>
	</div>
</#macro>

<#macro img_url pic ="">
<#if pic=="">
<#elseif pic?substring(0, 3) == "315">
${img_che_url}${pic?substring(3)}<#--?v=${imgVer}-->
<#elseif pic?substring(0, 3) == "ct1">
${img_che_url}${pic?substring(4)}<#--?v=${imgVer}-->
<#else>
${pic!}<#--?v=${imgVer}-->
</#if>
</#macro>

<#macro imageGet>

<div id="imageGetModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片选择</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="col-md-4">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i><span id="treeName">车型目录</span>
						</div>
					</div>
					<div class="portlet-body">
						<div class="zTreeBg" style="height:500px;overflow-x:hidden;overflow-y:auto;">
		                  <ul id="imgGetMenu" class="ztree"></ul>
	                	</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i><span id="treeName" style="float:left;margin-right:10px;">车型目录</span>
							<div class="radio-list typeradiolist" style="float:left;">
								<label class="radio-inline">
								<input type="radio" name="typeradio" id="typeradio1" value="1" checked>外观</label>
								<label class="radio-inline">
								<input type="radio" name="typeradio" id="typeradio2" value="2">座椅</label>
								<label class="radio-inline">
								<input type="radio" name="typeradio" id="typeradio3" value="3">中控</label>
								<label class="radio-inline">
								<input type="radio" name="typeradio" id="typeradio4" value="4">其他</label>
								<label class="radio-inline">
								<input type="radio" name="typeradio" id="typeradio5" value="5">图解</label>
							</div>

						</div>
					</div>
					<div class="portlet-body">
						<div class="news-list">
				          <table class="tb-color-even" width="100%" border="0" cellspacing="0" cellpadding="0">
				            <thead>
				              <th><input type="checkbox" id="checkAllSelect"></th>
				              <th>标题</th>
				              <th>图片</th>
				              <th>类型</th>
				            </thead>
				            <tbody id="itemContainer">
				              
				            </tbody>
				            <tfoot>
				            	<tr>
				            		<td colspan="6">
				            			<!-- navigation holder -->
				      					<div class="holder"></div>
				            		</td>
				            	</tr>
				            </tfoot>
				          </table>
				        </div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>
	<div class="modal-footer">
		<div class="radio-list" style="display:inline-block;">
			<label class="radio-inline">
			<input type="radio" name="imgSize" id="imgSize4" value="600">600(<span style="color:red">水印</span>)</label>
			<label class="radio-inline">
			<input type="radio" name="imgSize" id="imgSize1" value="600" checked>600</label>
			<label class="radio-inline">
			<input type="radio" name="imgSize" id="imgSize2" value="290">290</label>
			<label class="radio-inline">
			<input type="radio" name="imgSize" id="imgSize3" value="0">原图</label>
		</div>
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "titleSelect" class="btn blue">确定</button>
	</div>
</div>


<script>
var treeType = 0;
function imageGet(type){
	if(type == 0){
		treeType = type;
		createTree3("车型目录","imgGetMenu",imgGetClick);
	}
	if(type == 1){
		treeType = type;
		createTree3("非车型图库目录","imgGetMenu",imgGetClick);
	}
	if(type==2){
		treeType = type;
		createTree4("车型目录","imgGetMenu",imgGetClick);
	}
	$("#imageGetModal").modal("show");
}
$("#titleSelect").click(function(){
	var dinput = $('input[name="checkSelect"]');
	var imgSize =  $("input[name='imgSize']:checked").val();
	var flag = false;
	var idArr = new Array;
	for(var i =0;i<dinput.length;i++){
		if(dinput[i].checked){
			idArr.push(dinput[i].value);
		}
	}
	var dataArr = new Array;
	for(var i = 0;i<idArr.length;i++){
		dataArr.push(tempData[parseInt(idArr[i])]);
	}
	
	successImagesBack(dataArr,imgSize);
	$("#imageGetModal").modal("hide");
});

var carTypeArr = new Array;

$(".typeradiolist :radio").click(function(){
	var htm = "<img src='${admin_che_url}image/loader.gif'/>";
	$("#itemContainer").html(htm);
	$(this)[0].checked = true;
	var titleKey =  $("input[name='typeradio']:checked").val();
	$.getJSON("getImageInfo", { catalogid: encodeURI(carTypeArr),titleKey:encodeURI(titleKey)}, function(data){
		createList(data);
	});
});

function imgGetClick(treeId, treeNode, clickFlag){
	$("#typeradio5").Checked=true;
	$("#itemContainer").empty();
	var htm ="<tr><td colspan='3'><img src='${admin_che_url}image/loader.gif'/></td></tr>";
	$("#itemContainer").html(htm);
	
	$("div.holder").jPages({
		containerID: "itemContainer",
		perPage: 9
	});
	
	if(treeType == 0 && clickFlag.level ==0){
		return;
	}
	carTypeArr = new Array;
	if(clickFlag.isParent){
		for(var i =0 ;i<clickFlag.children.length;i++){
			if(clickFlag.children[i].isParent){
				for(var j = 0 ;j<clickFlag.children[i].children.length;j++){
					if(clickFlag.children[i].children[j].isParent){
					
					}else{
						carTypeArr.push(clickFlag.children[i].children[j].id)
					}
				}
			}else{
				carTypeArr.push(clickFlag.children[i].id);
			}
		}
	}else{
		carTypeArr.push(clickFlag.id);
	}
	if(treeType == 0 || treeType == 2){
		var titleKey =  $("input[name='typeradio']:checked").val();
		$.getJSON("getImageInfo", { catalogid: encodeURI(carTypeArr),titleKey:encodeURI(titleKey)}, function(data){
			createList(data);
		});
	}
	if(treeType == 1){
		$.getJSON("getImageNotInfo", { catalogid: encodeURI(carTypeArr)}, function(data){
			createList(data);
		});
		$("#titleSearch").click(function(){
			var titleKey = $("#titleKey").val();
			$.getJSON("getImageNotInfo", { catalogid: encodeURI(carTypeArr),titleKey:encodeURI(titleKey)}, function(data){
				createList(data);
			});
		});
	}
	
	$("#checkAllSelect").click(function(){
		if($(this)[0].checked){
			var page = parseInt($(".jp-current")[0].innerHTML);
			var dinput = $('input[name="checkSelect"]');
			for(var i =0 ;i<9;i++){
				dinput[i+((page-1)*9)].checked = true;
			}
		}else{
			var page = parseInt($(".jp-current")[0].innerHTML);
			var dinput = $('input[name="checkSelect"]');
			for(var i =0 ;i<9;i++){
				dinput[i+((page-1)*9)].checked = false;
			}
		}
		
	});
			
	
}
var tempData;
function createList(data){
	var html = "";
	tempData = data;
	for(var i = 0;i<data.length;i++){
		html = html+'<tr>';
		html = html+'<td><input type="checkbox" name="checkSelect" value="'+i+'"></td>';
		html = html+'<td>'+data[i].title+'</td>';
		html = html+'<td><img width="75" height="50" src="'+data[i].newPath+'"/></td>';
		html = html+'<td>'+data[i].typeName+'</td>';
		
		html = html+'</tr>';
	}
	if(html==""){
		html="<tr><td colspan='3'><span style='color:red;'>温馨提示:此分类暂无数据,请查看其它分类.</span></td></tr>";
	}
	$("#itemContainer").html(html);
	$("div.holder").jPages({
		containerID: "itemContainer",
		perPage: 9
	});
	$(".getImageBtn").click(function(){
		var value2 = $(this).attr("value2");
		var value3 = $(this).attr("value3");
		var imgdata = '{"path":"'+value2.substring(3,value2.length)+'","cturl":"'+value3+'"}';
		eval("imgdata="+imgdata)
		$(".pop-cav").attr("style","display:none;");
		$(".overlayer-cav").hide();
		getPathBack(imgdata);
	});
}

</script>


</#macro>


<#macro uploadimg news_width=0>
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload.css">
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload-ui.css">
<div id="imgUploadModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片上传</h4>
	</div>
	<div class="modal-body">
		<iframe name="uploadfrm" id="uploadfrm" width="100%" border="0" height="400px" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "confirmImg" class="btn blue">确定</button>
	</div>
</div>
<script>
	$("#confirmImg").click(function(){
		var imgarr = window.frames["uploadfrm"].imgarr;
		if(imgarr.length != 0){
			resultArr = new Array;
			var sort = $("#files span",window.frames["uploadfrm"].document);
			for(var i = 0;i<sort.length;i++){
				if(sort[i].className==""){
					var oname = sort[i].innerHTML;
					for(var j=0;j<imgarr.length;j++){
						if(imgarr[j].oldImageName == oname ){
							resultArr.push(imgarr[j]);
						}
					}
				}
			}
			callbackSucc(resultArr);
		}
		$("#imgUploadModal").modal("hide");
	})
	
	$("#imgUploadModal").on("show",function(){
		document.domain="315che.com";
		$("#uploadfrm")[0].src = "${imgupload_che_url}imgupload/index<#if news_width != 0>?width=${news_width}</#if>";
		
	});
</script>
</#macro>


<#macro uploadimg3 news_width=0>
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload.css">
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload-ui.css">
<div id="imgUploadModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片上传</h4>
	</div>
	<div class="modal-body">
		<iframe name="uploadfrm" id="uploadfrm" width="100%" border="0" height="400px" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "confirmImg" class="btn blue">确定</button>
	</div>
</div>
<script>
	$("#confirmImg").click(function(){
		var imgarr = window.frames["uploadfrm"].imgarr;
		if(imgarr.length != 0){
			resultArr = new Array;
			var sort = $("#files span",window.frames["uploadfrm"].document);
			for(var i = 0;i<sort.length;i++){
				if(sort[i].className==""){
					var oname = sort[i].innerHTML;
					for(var j=0;j<imgarr.length;j++){
						if(imgarr[j].oldImageName == oname ){
							resultArr.push(imgarr[j]);
						}
					}
				}
			}
			callbackSucc(resultArr);
		}
		$("#imgUploadModal").modal("hide");
	})
	
	$("#imgUploadModal").on("show",function(){
		document.domain="315che.com";
		$("#uploadfrm")[0].src = "${imgupload_che_url}imgupload/imgWaterUploadPage<#if news_width != 0>?width=${news_width}</#if>";
		
	});
</script>
</#macro>


<#macro uploadimg2>
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload.css">
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload-ui.css">
<div id="imgUploadModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片上传</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<form id="fileupload" action="http://upload.adminche.chetuan.com/imgupload/imageUpload" target="uploadfrm" enctype="multipart/form-data" method="post">
			<div class="col-md-12">
				<span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>上传图片...</span>
                    	<input type="file" name="file" multiple="multiple">
                </span>
                <div id="progress" class="progress">
			        <div class="progress-bar progress-bar-success"></div>
			    </div>
			    <input  type="submit" id="uploadbtn" value="上传">
				<div id="files" class="files row"></div>
			</div>
			</form>
			<iframe name="uploadfrm" ></iframe>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "confirmImg" class="btn blue">确定</button>
	</div>
</div>
<script src="${admin_che_url}js/jquery.form.min.js"></script>
<script>
	//$("#uploadbtn").click(function(){
	//	$("#fileupload").ajaxSubmit({
	//		success:function (responseResult) {
	//		alert(responseResult);
	//	}})
	//});
	document.domain="chetuan.com";
	$("#confirmImg").click(function(){
		var imgarr = window.frames["uploadfrm"].imgarr;
		if(imgarr.length != 0){
			resultArr = new Array;
			var sort = $("#files span",document.frames('uploadfrm').document);
			for(var i = 0;i<sort.length;i++){
				if(sort[i].className==""){
					var oname = sort[i].innerHTML;
					for(var j=0;j<imgarr.length;j++){
						if(imgarr[j].oldImageName == oname ){
							resultArr.push(imgarr[j]);
						}
					}
				}
			}
			callbackSucc(resultArr);
		}
		$("#imgUploadModal").modal("hide");
	})
</script>
</#macro>
<#macro uploadimg1>
<div id="imgUploadModal" class="modal fade" tabindex="-1" data-width="960">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		<h4 class="modal-title">图片上传</h4>
	</div>
	<div class="modal-body">
		<div class="row">
			<div class="col-md-12">
				<span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>上传图片...</span>
                    <input id="fileupload" type="file" name="file" data-url="http://upload.adminche.chetuan.com/imgupload/imageUpload" multiple>
                    
                </span>
                <div id="progress" class="progress">
			        <div class="progress-bar progress-bar-success"></div>
			    </div>
				<div id="files" class="files row"></div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		<button type="button" id = "confirmImg" class="btn blue">确定</button>
	</div>
</div>
<script src="${admin_che_url}js/vendor/jquery.ui.widget.js"></script>
<script src="${admin_che_url}js/jquery.iframe-transport.js"></script>
<script src="${admin_che_url}js/jquery.fileupload.js"></script>
<script src="${admin_che_url}js/load-image.all.min.js"></script>
<script src="${admin_che_url}js/canvas-to-blob.min.js"></script>
<!-- The File Upload processing plugin -->
<script src="${admin_che_url}js/jquery.fileupload-process.js"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="${admin_che_url}js/jquery.fileupload-image.js"></script>
<!-- The File Upload audio preview plugin -->
<script src="${admin_che_url}js/jquery.fileupload-audio.js"></script>
<!-- The File Upload video preview plugin -->
<script src="${admin_che_url}js/jquery.fileupload-video.js"></script>
<!-- The File Upload validation plugin -->
<script src="${admin_che_url}js/jquery.fileupload-validate.js"></script>
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload.css">
<link rel="stylesheet" href="${admin_che_url}css/jquery.fileupload-ui.css">
<script>
/*jslint unparam: true, regexp: true */
/*global window, $ */
var imgarr = new Array;
$(function () {
	$("#confirmImg").click(function(){
		if(imgarr.length != 0){
			resultArr = new Array;
			var sort = $("#files span");
			for(var i = 0;i<sort.length;i++){
				if(sort[i].className==""){
					var oname = sort[i].innerHTML;
					for(var j=0;j<imgarr.length;j++){
						if(imgarr[j].oldImageName == oname ){
							resultArr.push(imgarr[j]);
						}
					}
				}
			}
			callbackSucc(resultArr);
		}
		$("#imgUploadModal").modal("hide");
	})
	$("#imgUploadModal").on("show",function(){
		imgarr = new Array;
		$(".progress-bar-success").removeAttr("style");
		$("#files").html("");
	});
    'use strict';
    // Change this to the location of your server-side upload handler:
    var url = window.location.hostname === 'blueimp.github.io' ?
                '//jquery-file-upload.appspot.com/' : 'server/php/',
        uploadButton = $('<button/>')
            .addClass('btn btn-primary')
            .prop('disabled', true)
            .text('Processing...')
            .on('click', function () {
                var $this = $(this),
                    data = $this.data();
                $this
                    .off('click')
                    .text('Abort')
                    .on('click', function () {
                        $this.remove();
                        data.abort();
                    });
                data.submit().always(function () {
                    $this.remove();
                });
            });
    $('#fileupload').fileupload({
        url: url,
        dataType: 'json',
        autoUpload: true,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png|swf)$/i,
        maxFileSize: 5000000, // 5 MB
        // Enable image resizing, except for Android and Opera,
        // which actually support image resizing, but fail to
        // send Blob objects via XHR requests:
        disableImageResize: /Android(?!.*Chrome)|Opera/
            .test(window.navigator.userAgent),
        previewMaxWidth: 100,
        previewMaxHeight: 100,
        previewCrop: true
    }).on('fileuploadadd', function (e, data) {
        data.context = $('<div/>').appendTo('#files');
        $.each(data.files, function (index, file) {
            var node = $('<p/>')
                    .append($('<span/>').text(file.name));
            if (!index) {
                node
                    //.append('<br>')
                    //.append(uploadButton.clone(true).data(data));
            }
            node.appendTo(data.context.addClass("col-md-2 text-center").css("height", 170));
        });
    }).on('fileuploadprocessalways', function (e, data) {
        var index = data.index,
            file = data.files[index],
            node = $(data.context.children()[index]);
        if (file.preview) {
            node
                .prepend('<br>')
                .prepend(file.preview);
        }
        if (file.error) {
            node
                .append('<br>')
                .append($('<span class="text-danger"/>').text(file.error));
        }
        //if (index + 1 === data.files.length) {
       //     data.context.find('button')
        //        .text('Upload')
        //        .prop('disabled', !!data.files.error);
        //}
    }).on('fileuploadprogressall', function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress .progress-bar').css(
            'width',
            progress + '%'
        );
    }).on('fileuploaddone', function (e, data) {
    	imgarr.push(data.result[0]);
        $.each(data.files, function (index) {
            var success = $('<span class="text-success"/>').text('上传成功！');
            $(data.context.children()[index])
                .append('<br>')
                .append(success);
        });
    }).on('fileuploadfail', function (e, data) {
        $.each(data.files, function (index) {
            var error = $('<span class="text-danger"/>').text('File upload failed.');
            $(data.context.children()[index])
                .append('<br>')
                .append(error);
        });
    }).prop('disabled', !$.support.fileInput)
        .parent().addClass($.support.fileInput ? undefined : 'disabled');
});
</script>
</#macro>


<#macro html_head select="100" title="中国汽车消费网 -- 后台">
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8"/>
	<title>${title}</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1" name="viewport"/>
	<meta content="" name="description"/>
	<meta content="" name="author"/>
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${admin_che_url}assets/global/fonts/fonts.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN THEME STYLES -->
	<link href="${admin_che_url}assets/global/css/components.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
	<link id="style_color" href="${admin_che_url}assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
	<link href="${admin_che_url}assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
	<!-- END THEME STYLES -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<link href="${admin_che_url}assets/global/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" type="text/css" />
	<link href="${admin_che_url}assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"/>
	<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-datetimepicker/css/datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="${admin_che_url}assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css"/>
	<link rel="stylesheet" type="text/css" href="${admin_che_url}css/zTreeStyle.css"/>
	<!-- END PAGE LEVEL PLUGINS -->
	<link href="${admin_che_url}css/jPages.css" rel="stylesheet">
	<link rel="shortcut icon" href="${admin_che_url}favicon.ico"/>
</head>
</#macro>
<#macro html_body>
<body class="page-header-fixed page-quick-sidebar-over-content" style="width:99%;margin:0;padding:0;background:#fff;">
<div class="page-content">
<#nested>
</div>
</#macro>
<#macro html_js >
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
	<script src="${admin_che_url}assets/global/plugins/respond.min.js"></script>
	<script src="${admin_che_url}assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${admin_che_url}assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${admin_che_url}assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${admin_che_url}assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${admin_che_url}assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/pages/scripts/components-pickers.js"></script>
<script type="text/javascript" src="${admin_che_url}js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${admin_che_url}js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${admin_che_url}js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="${admin_che_url}js/createTree.js"></script>
<script type="text/javascript" src="${admin_che_url}js/url.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${admin_che_url}assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${admin_che_url}assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/admin/pages/scripts/ui-extended-modals.js"></script>
<script src="${admin_che_url}js/jPages.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
	// initiate layout and plugins
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	ComponentsPickers.init();
});
</script>
</#macro>
