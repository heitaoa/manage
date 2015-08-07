<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理系统</title>
</head>
 <body>
 
 
 <table border=2>
 <tr>
 <td><h3>PC版</h3></td>
 <td></td>
 <tr>
 <tr>
 <td>文本：</td>
 <td><input style = "width:600px" type="text" name="subData.title" value="<strong>【${groupInfo.fatherName!}】</strong>${groupInfo.title!}" id="title" class="text"></td>
 <tr>
 <tr>
 <td>点击链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.link" id="link" value="javascript:groupbuyApply('${groupInfo.rootId!}','${groupInfo.carid!}','${groupInfo.surplus_num!}')"></td>
 <tr>
 <tr>
 <td>曝光链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.link_back" id="link_back" value="${groupInfo.fatherName!}"></td>
 <tr>
 <tr>
 <td>目录：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.ctitle" id="ctitle" value="${groupInfo.surplus_num!}"></td>
 <tr>
 <tr>
 <td>目录链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.clink" id="clink" value="${groupInfo.photo!}"></td>
 <tr>
 <tr>
 <td>颜色：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.color" id="color" value="${groupInfo.fatherid!}"></td>
 <tr>
 <tr>
 <td>图片：</td>
 <td><h1>请编辑自己上传!</h1></td>
 <tr>
 <tr>
 <td>内容：</td>
 <td><textarea  name="subData.content" id="content_area" cols="60" rows="10">
<ul>
<li><span>时间：</span><#if groupInfo.time_info=="">${groupInfo.begdate!}-${groupInfo.enddate!}<#else>${groupInfo.time_info!}</#if>
</li>
<li><span>地点：</span>${groupInfo.address!}</li>
<li><span>车型：</span><#if groupInfo.car_info=="">${groupInfo.catalogname!}<#else>${groupInfo.car_info!}</#if>
</li>
<li><span>优惠：</span>${groupInfo.info!}</li>
</ul>
 </textarea></td>
 <tr>
 </table>
<br><br><br>
 <table border=2>
 <tr>
 <td><h3>WAP版</h3></td>
 <td></td>
 <tr>
 <tr>
 <td>文本：</td>
 <td><input style = "width:600px" type="text" name="subData.title" value="${groupInfo.fatherName!}" id="title" class="text"></td>
 <tr>
 <tr>
 <td>点击链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.link" id="link" value="http://m.chetuan.com/kanche/series/series_${groupInfo.fatherid!}.html"></td>
 <tr>
 <tr>
 <td>曝光链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.link_back" id="link_back" value="<#if groupInfo.car_info=="">${groupInfo.catalogname!}<#else>${groupInfo.car_info!}</#if>"></td>
 <tr>
 <tr>
 <td>目录：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.ctitle" id="ctitle" value="${groupInfo.surplus_num!}"></td>
 <tr>
 <tr>
 <td>目录链接：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.clink" id="clink" value="${groupInfo.photo!}"></td>
 <tr>
 <tr>
 <td>颜色：</td>
 <td><input style = "width:600px" type="text" class="text" name="subData.color" id="color" value="${groupInfo.carid!}"></td>
 <tr>
 <tr>
 <td>图片：</td>
 <td><h1>请编辑自己上传!</h1></td>
 <tr>
 <tr>
 <td>内容：</td>
 <td><textarea  name="subData.content" id="content_area" cols="60" rows="10">
 </textarea></td>
 <tr>
 </table>
 </body>
</html>
