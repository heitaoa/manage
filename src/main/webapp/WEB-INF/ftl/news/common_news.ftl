<!---->
<#macro news_control_bar>
<div class="news-control-bar">
	<a href="javascript:void(0);" onclick="onPageEditView();">添加新闻主题</a>
	<a href="javascript:void(0);" onclick="onCurListGenerate();">生成列表页</a>
	<a href="javascript:void(0);" onclick="genWapListPage();">生成WAP列表页</a>
	<!--
	<a href="javascript:void(0);" onclick="onListGenerate();">一键生成列表页</a>
	<a href="javascript:void(0);" onclick="onCityGenerate();">一键生成城市站页面</a>
	-->
	<!--
	<a id="" href="./urlEditV">添加链接新闻</a>
	<a id="" href="./imgEditV">添加图片主题</a>
	<a id="" class="moveNews" href="movePage();">移动到</a>
	<a href="">导出无链文件</a> 
	-->
	<a class="del-btn btn-radius" href="javascript:void(0);" onclick="delMultiPage();">删除</a>
	<a class="del-btn btn-radius" href="javascript:void(0);" onclick="genMultiPage();">更新</a>
</div>
</#macro>


<#macro overlayer_cav>
<div class="overlayer-cav"></div>
<div class="pop-cav">
  <div class="select-news-box">
    <b class="close">X</b>
    <div class="page-title"><h1>选择新闻内容</h1></div>
    <div class="main">
      <div class="left">
      <h2>选择新闻目录</h2>
        <div class="zTreeBg">
          <ul id="newsMenu" class="ztree"></ul>
        </div>
      </div>
      <div class="right">
        <div class="news-search"><label for="">标题或关键字：</label><input class="inp-news-search" type="text"><input class="inp-news-search-btn" type="button" value="开始查找"></div>
        <div class="news-list">
          <table class="tb-color-even" width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
              <th>主题</th>
              <th>标题</th>
              <th>目录</th>
              <th>添加时间</th>
              <th>确认选择</th>
            </thead>
            <tbody>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>不再大打价格战 上半年车市关键词盘点</td>
                <td>南京优惠</td>
                <td>2014/06/14<br>21:49:00</td>
                <td><a class="btn_orange-a" href="">确认选择</a></td>
              </tr>
              <tr>
                <td colspan="6">
                  <div class="pages">
                    <a href="javascript:void(0);">&lt; </a>
                    <a class="active" href="javascript:void(0);">1</a>
                    <a href="javascript:void(0);">2</a>
                    <a href="javascript:void(0);">3</a>
                    <a href="javascript:void(0);">4</a>
                    <a href="javascript:void(0);">5</a>
                    <a href="javascript:void(0);">6</a>
                    <a href="javascript:void(0);">7</a>
                    <a href="javascript:void(0);">8</a>
                    <a href="javascript:void(0);">9</a>
                    <a href="javascript:void(0);">10</a>
                    <a href="javascript:void(0);">&gt;</a>
                    <span>调到转到</span><span>
                  <input name="" type="text" style=" width:36px; height:26px;">
                  </span><a href="javascript:void(0);">GO</a></div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
</#macro>

<!--分页  通过js请求方式-->
<#macro calcPageByJs jsfun page pages>
	<ul class="pagination" style="visibility: visible;">
		<li <#if page lt 2>class="prev disabled"<#else>class="prev"</#if>><a title="First" onclick="${jsfun}(1);" href="javascript:void(0);"><i class="fa fa-angle-double-left"></i></a></li>
		<li <#if page lt 2>class="prev disabled"<#else>class="prev"</#if>><a title="Prev" onclick="${jsfun}(${page-1});"href="javascript:void(0);"><i class="fa fa-angle-left"></i></a></li>
		
		<#list page-3..page-1 as p>
			<#if p gt 0 ><li><a onclick="${jsfun}(${p});" href="javascript:void(0);">${p}</a></li></#if>
		</#list>
		<li class="active"><a onclick="${jsfun}(${page});" href="javascript:void(0);">${page}</a></li>
		<#list page+1..page+3 as p>
			<#if p lte pages ><li><a onclick="${jsfun}(${p});" href="javascript:void(0);">${p}</a></li></#if>
		</#list>
		
		<li <#if page gt pages-1>class="next disabled"<#else>class="next"</#if>><a title="Next" onclick="${jsfun}(${page+1});" href="javascript:void(0);"><i class="fa fa-angle-right"></i></a></li>
		<li <#if page gt pages-1>class="next disabled"<#else>class="next"</#if>><a title="Last" onclick="${jsfun}(${pages});" href="javascript:void(0);"><i class="fa fa-angle-double-right"></i></a></li>
	</ul>
</#macro>
