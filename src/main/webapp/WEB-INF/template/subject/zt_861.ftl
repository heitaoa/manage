<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2014浦东国际汽车展览会</title>
	<link rel="stylesheet" href="http://zt.315che.com/wuhan/150420/css/cqcz.css">
	<link rel="stylesheet" href="http://zt.315che.com/cz/141031/css/main.css">
	<link rel="stylesheet" href="http://zt.315che.com/common/css/315che-base.css">
	<script src="http://zt.315che.com/common/js/jquery-1.11.1.min.js"></script>
    <script src="http://www.315che.com/js/jquery.bxslider.min.js"></script>
</head>
<body>
	 <!-- 头部 -->
    <div class="mihead-bg">
        <div id="goto-top" class="mihead">
            <div class="milogo">
                <a href="http://www.315che.com/" onfocus="this.blur();"><strong>中国汽车消费网</strong></a>
            </div>
            <div class="midaohang">
                <a href="http://www.315che.com/">首页</a>
                <a href="http://www.315che.com/newcar/">新车</a>
                <a href="http://inf.315che.com/">新闻</a>
                <a href="http://www.315che.com/buy/">导购</a>
                <a href="http://www.315che.com/pingce/">试驾评测</a>
                <a href="http://www.315che.com/pic/">图库</a>
                <a href="http://www.315che.com/hq/">行情</a>
                <a href="http://auto.315che.com/">报价</a>
                <a href="http://4s.315che.com/">经销商</a>
                <a href="http://www.315che.com/tools/">工具</a>
                <a href="http://bbs.315che.com/">论坛</a>
                <a href="http://tousu.315che.com/">汽车投诉</a>
                <a href="http://www.315che.com/kanche/" class="highlight">小胖看车团</a>
            </div>
            <div class="micity">
                <span style="font-weight:bold; color:#FFFFFF;">城市站：</span>
                <a title="上海站" href="http://www.315che.com/sh/">上海</a>
                <a title="北京站" href="http://www.315che.com/bj/">北京</a>
                <a title="广州站" href="http://www.315che.com/gz/">广州</a>
                <a title="成都站" href="http://www.315che.com/chengdu/">成都</a>
                <a title="武汉站" href="http://www.315che.com/wuhan/">武汉</a>
                <a title="南京站" href="http://www.315che.com/nanjing/">南京</a>
                <a title="合肥站" href="http://www.315che.com/hefei/">合肥</a>
                <a title="大连站" href="http://www.315che.com/dalian/">大连</a>
            </div>
        </div>
    </div>
<div class="cqcz_top">
  <div class="back315"><a href="http://www.315che.com/">浏览中国汽车消费网首页</a></div>
</div>
<div class="cz_con">
  <div class="czleft">
     <div class="cz_jw">
	 <script src="http://img.315che.com/chengdu/150421/js/focusImg.js" type="text/javascript"></script>
       <div class="jiao">
       <div class="focuspic">
      <div id="f_div">
        <!--图片区域-->
        <div id="f_imgDiv"> 
          <#if dataMap.get("焦点图")??>
				<#list dataMap.get("焦点图") as data>
				    <#if data_index lt 5>
						<a target="_blank" href="${data.link!}">
							<img <#if data_index==0>style="display: block;"<#else>style="display: none;"</#if> width="366" height="233" src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" id="img_${data_index+1}">
						</a>
					</#if>
			    </#list>
	      </#if>			
	</div>
        <div id="f_infoDiv">
          <!--数字按钮区域-->
          <div id="f_buttonDiv">
          <#if dataMap.get("焦点图")??>
				<#list dataMap.get("焦点图") as data>
				    <#if data_index lt 5>
						<div class="bg"><a normalclass="" focusclass="on" id="imga_${data_index+1}" class="" href="javascript:void(0)" target="_self"></a></div>
					</#if>
			    </#list>
	      </#if>	
          </div>
        </div>
      </div>
      <!--焦点文字区域-->
      <div class="f12b" id="f_text">
      
  		   <#if dataMap.get("焦点图")??>
			<#list dataMap.get("焦点图") as data>
			    <#if data_index lt 5>
					<label <#if data_index==0>style="display: block;"<#else>style="display: none;"</#if> id="imgt_${data_index+1}" >
						<a target="_blank" href="${data.link!}">
							${data.title!}
						</a>
					</label>
				</#if>
		    </#list>
	      </#if>
      </div>
		       <script>	
		
					if(document.getElementById('img_1')!=null)
					{
					document.getElementById('img_1').style.display='block';
					}
					if(document.getElementById('imga_1')!=null)
					{
					document.getElementById('imga_1').className='on';
					}
					if(document.getElementById('imgt_1')!=null)
					{
					document.getElementById('imgt_1').style.display='block';
					}
		
					var a=new PicFocus("f_imgDiv","f_text","f_buttonDiv","5000");
					a.init();
					a.play();
		
		        </script>
    </div></div>
    <div class="dabiao">
       <div class="tet">
          <dl>
			<dt>
				<#if dataMap.get("焦点新闻大标题")??>
					<#list dataMap.get("焦点新闻大标题") as data>
					    <#if data_index == 0>
							<a target="_blank" href="${data.link!}">${data.title!}</a>
					    </#if>
				    </#list>
			     </#if>
			</dt>
				<dd>
				  <#if dataMap.get("焦点新闻小标题")??>
					<#list dataMap.get("焦点新闻小标题") as data>
					    <#if data_index == 0>
							<a target="_blank" href="${data.link!}">${data.title!}</a>|
					    </#if>
				    </#list>
			     </#if>
			      <#if dataMap.get("焦点新闻小标题")??>
					<#list dataMap.get("焦点新闻小标题") as data>
					    <#if data_index == 1>
							<a target="_blank" href="${data.link!}">${data.title!}</a>|
					    </#if>
				    </#list>
			     </#if>
			      <#if dataMap.get("焦点新闻小标题")??>
					<#list dataMap.get("焦点新闻小标题") as data>
					    <#if data_index == 2>
							<a target="_blank" href="${data.link!}">${data.title!}</a>
					    </#if>
				    </#list>
			     </#if>
				 
	           </dd>
	      </dl>
	          <dl>
	             <dt>
	                <#if dataMap.get("焦点新闻大标题")??>
					  <#list dataMap.get("焦点新闻大标题") as data>
					    <#if data_index == 1>
							<a target="_blank" href="${data.link!}">${data.title!}</a>
					    </#if>
				       </#list>
			        </#if>
			     </dt>
	              
    		     <dd>
    		          <#if dataMap.get("焦点新闻小标题")??>
					   	 <#list dataMap.get("焦点新闻小标题") as data>
					    	<#if data_index == 3>
							    <a target="_blank" href="${data.link!}">${data.title!}</a>
					   		</#if>
				      	 </#list>
			          </#if>
			          
			            <#if dataMap.get("焦点新闻小标题")??>
					      <#list dataMap.get("焦点新闻小标题") as data>
					        <#if data_index == 4>
							<a target="_blank" href="${data.link!}">${data.title!}</a>
					        </#if>
				          </#list>
			            </#if>
			            
			          <#if dataMap.get("焦点新闻小标题")??>
					    <#list dataMap.get("焦点新闻小标题") as data>
					      <#if data_index == 5>
							<a target="_blank" href="${data.link!}">${data.title!}</a>
					      </#if>
				       </#list>
			         </#if>
    		     </dd>
               
                 
              </dl>
       </div>
       <ul>
	   <li>
	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 0>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 1>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   
	   
	   </li>
	   
	   
	   <li>
	   
	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 2>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 3>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   
	   
	   </li>
	   
	   <li>
	       	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 4>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 5>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   </li>
	
	   
	  
	   <li>
	       	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 6>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 7>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   </li>
	  
	   
	  
	   <li> 
	      	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 8>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 9>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   </li>
	   	  <li>
	          	    <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 10>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	     
	      <#if dataMap.get("焦点新闻列表")??>
			<#list dataMap.get("焦点新闻列表") as data>
			    <#if data_index == 11>
					<a target="_blank" href="${data.link!}">${data.title!}</a>
			    </#if>
		    </#list>
	     </#if>
	   </li>
          </ul> 
    </div>
     </div>
     <div class="newzx">
       <h3>最新资讯</h3>
       <div class="dllist" id="newsList">
              <#if dataMap.get("最新资讯")??>
				<#list dataMap.get("最新资讯") as data>
				    <#if data_index lt 5>
						 <dl>
					         <dt><a  target="_blank" href="${data.link!}"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="203" height="118"/></a></dt>
					         <dd>
					           <h4><a target="_blank" href="${data.link!}">${data.title!}</a></h4>
					           <span>${data.ctitle!}  ${data.adddate?string("yyyy-MM-dd")!''}</span>
					           <p>${data.content!}<a target="_blank" href="${data.link!}">[详情]</a></p>
					         </dd>
				         </dl>
				    </#if>
			    </#list>
		     </#if>
	     </li>     
       </div>
     <p class="morez"><a href="javascript:void(0);" onClick="getlNewsByPage()">显示更早的文章</a></p>
	 <input type="hidden" id="txtpage" name="txtpage" value="1">
	  <input type="hidden" id="txtmaxpage" name="txtmaxpage" value="0">
     </div>
	 <SCRIPT LANGUAGE="JavaScript">
	function getlNewsByPage()
	{
		if(G('txtmaxpage').value!=G('txtpage').value)
		{
		var cp=parseInt(G('txtpage').value)+1;
		NAjax.getChongQingNewsByPage("zt_861","最新资讯",2,cp,5,203,118,getnewsHtml);
		}
		else
		{
		alert("已经是最后一页了");
		}
	}
	function getnewsHtml(r)
	{
		if(r!=null&&r.value!=null&&r.value.length>0)
		{
			G('txtpage').value=parseInt(G('txtpage').value)+1;
			G('newsList').innerHTML+=r.value;
		}
		else
		{
			G('txtmaxpage').value=G('txtpage').value;
			alert("已经是最后一页了")
		}
	}
	 </SCRIPT>
     <div class="czfoot">
       <p><a href="http://www.315che.com/help/0.htm">关于我们</a> | <a href="http://www.315che.com/help/1.htm">联系我们</a> |<a href="http://www.315che.com/help/2.htm"> 广告服务</a> | <a href="http://www.315che.com/help/3.htm">友情链接</a> |<a href="http://www.315che.com/help/4.htm"> 网站地图</a> |<a href="http://www.315che.com/help/5.htm"> 招聘信息</a> | <a href="http://www.315che.com/help/6.htm">法律声明</a> | <a href="http://www.315che.com/help/7.htm">车友会</a></p>
       <p>Copyright ? 2005-2020 中国汽车消费网 备案号:沪ICP 备 05053107 号</p>
     </div>
  </div>
  <div class="cz_right">
    <h3>今日推荐</h3>
    <div class="jian">
        <ul> 
               <#if dataMap.get("今日推荐")??>
				<#list dataMap.get("今日推荐") as data>
				    <#if data_index == 1 >
				        <li>
				         	<a  target="_blank" href="${data.link!}">
				         		<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="98" height="58"/>
				         	</a>
        					<a class="buyp"  target="_blank"  href="${data.Link!}">${data.title!}</a>
        				</li>
				    </#if>
			    </#list>
		       </#if>
	 
     
              <#if dataMap.get("今日推荐")??>
				<#list dataMap.get("今日推荐") as data>
				    <#if data_index == 2 >

				         <li>
				         	<a  target="_blank" href="${data.Link!}">
				         		<img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title}" width="98" height="58"/>
				         	</a>
        					<a class="buyp"  target="_blank"  href="${data.Link}>${data.title}</a>
        				</li>
				  	</#if>
				  </#list>
		      </#if>
      </ul>
    </div>
     <h3><a target="_blank" href="http://www.315che.com/news/163/" style="color:#2AA7F5; font-size:12px; padding-right:5px; font-weight:normal; float:right; display:inline;">更多>></a>上海优惠</h3>
     <div class="yyhh">
             <#if dataMap.get("上海优惠")??>
				<#list dataMap.get("上海优惠") as data>
				    <#if data_index lt 11>
					
						 <dl>
					         <dt><a  target="_blank" href="${data.link!}"><img src="<#if data.pic.substring(0,7)=="http://">${data.pic!}<#else>${img_che_url!}${data.pic!}</#if>" alt="${data.title!}" width="78" height="49"/></a></dt>
					         <dd>
					          <span><a target="_blank"  href="${data.Link!}">${data.title!}</a></span>
					          <p>${data.content!}<a target="_blank"  href="${data.Link!}">[详情]</a></p>
					         </dd>
				         </dl>
				    </#if>
			    </#list>
		      </#if>

     </div>
  </div>
  <div id="footer">
		<p>
			<a target="_blank" href="http://www.315che.com/help/0.htm">关于我们</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/1.htm">联系我们</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/2.htm">广告服务</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/3.htm">友情链接</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/4.htm">网站地图</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/5.htm">招聘信息</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/6.htm">法律声明</a>
			    |    
			<a target="_blank" href="http://www.315che.com/help/7.htm">车友会</a>
		</p>
		<p>
			Copyright ? 2005-2010
			<a href="mailto:admin@315che.com">中国汽车消费网</a>
			备案号:
			<a target="_blank" href="http://www.miibeian.gov.cn">沪ICP 备 05053107 号</a>
		</p>
	</div>
	<div style="display:none;"><script src="http://w.cnzz.com/c.php?id=30010794" language="JavaScript" charset="gb2312"></script></div>
</body>
</html>