<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>


<h3 class="page-title">
	车型参数维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车型参数维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-4">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>选择车型目录
				</div>
			</div>
			
			<div class="portlet-body">
	            	<!--<div class="scroller zTreeBg" style="height:650px;" data-always-visible="1" data-rail-visible="0">
	              		<ul id="treeMenu" class="ztree"></ul>
	            	</div> -->
	            	<div class="zTreeBg" style="height:650px; overflow-x:hidden; overflow-y:auto;">
                          <ul id="treeMenu" class="ztree"></ul>
                        </div> 
	    	</div>
	    </div>
	</div>
	<div class="col-md-8">
		<div class="portlet box grey-cascade" id="carBrand" style="display:none">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>品牌信息管理
				</div>
			</div>
			<div class="portlet-body form">
			<from class="form-horizontal form-row-sepe">
				<div class="form-group">
					<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='pic1' src='${admin_che_url}image/car_pic.jpg'></label>
					<a class="col-md-1 btn green" href="#imgUploadModal" data-toggle="modal" onclick="checkedNum(1)">上传图片</a>
					<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='mainphoto' src='${admin_che_url}image/car_pic.jpg'></label>
					<a class="col-md-1 btn green" href="#imgUploadModal" data-toggle="modal" onclick="checkedNum(2)">上传图片</a>
					<input id='imagePath1' class='imagePath' type='hidden' readonly='readonly' >
					<input id='mainphoto1' class='imagePath' type='hidden' readonly='readonly' >
					<input id='checkedNum' class='imagePath' type='hidden' readonly='readonly'>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">生产状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='selA1'>
							<option value="0">停产</option>
							<option value="1">在产</option>
							<option value="2">未生产</option>
						</select>
					</div>
					<label class="control-label col-md-2">在售状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="selB1">
							<option value="0">停售</option>
			            	<option value="1">在售</option>
			            	<option value="2">未销售</option>
			            	<option value="3">未上市</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">英文名：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='Englishname1'>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-offset-5 col-md-8">
							<button type="button" class="btn green" onClick='SaveA()'>保存品牌信息</button>
						</div>
					</div>
				</div>
			</from>
			</div>
		</div>
		<div class="portlet box grey-cascade" id="carSeries" style="display:none" >
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>车系信息管理
				</div>
			</div>
			<div class="portlet-body form" >
			<from class="form-horizontal form-row-sepe">
				<div class="form-group">
					<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='pic2' src='${admin_che_url}image/car_pic.jpg'></label>
					<a class="col-md-1 btn green" href="#imgUploadModal" onclick="checkedNum(1)" data-toggle="modal">上传图片</a>
					<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='mainphoto2' src='${admin_che_url}image/car_pic.jpg'></label>
					<a class="col-md-1 btn green" href="#imgUploadModal" data-toggle="modal" onclick="checkedNum(2)">上传图片</a>
					<input id='imagePath2' class='imagePath' type='hidden' readonly='readonly' >
					<input id='mainphoto12' class='imagePath' type='hidden' readonly='readonly' >
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">生产状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='selA2'>
							<option value="0">停产</option>
							<option value="1">在产</option>
							<option value="2">未生产</option>
						</select>
					</div>
					<label class="control-label col-md-2">在售状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="selB2">
							<option value="0">停售</option>
			            	<option value="1">在售</option>
			            	<option value="2">未销售</option>
			            	<option value="3">未上市</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">级别：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="jibie2">
							<option value='0'>无</option>
							<option value='1'>微型</option>
							<option value='2'>小型</option>
							<option value='3'>紧凑型</option>
							<option value='4'>轻型</option>
							<option value='5'>中型</option>
							<option value='6'>中大型</option>
							<option value='7'>大型</option>
							<option value='8'>豪华</option>
							<option value='9'>超级</option>
						</select>
					</div>
					<label class="control-label col-md-2">类型：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="leixing2">
							<option value='0'>无</option>
							<option value='1'>轿车</option>
							<option value='2'>跨界车</option>
							<option value='3'>SUV</option>
							<option value='4'>旅行车</option>
							<option value='5'>MPV</option>
							<option value='6'>跑车</option>
							<option value='7'>概念车</option>
							<option value='8'>皮卡</option>
							<option value='9'>客车</option>
							<option value='10'>卡车</option>
							<option value='11'>电动车</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">英文名：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='Englishname2'>
					</div>
					<label class="control-label col-md-2">关键词：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='carkey'>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">优点：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='good'>
					</div>
					<label class="control-label col-md-2">缺点：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='bad'>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">安全碰撞：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control input-inline" id='anquan'>&nbsp;星级
					</div>
					<label class="control-label col-md-2">保养费用：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control input-inline" id='baoyan'>&nbsp;元/次
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">渠道：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='qudao1'>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-offset-5 col-md-8">
							<button type="button" class="btn green" onClick='SaveB()'>保存车系信息</button>
						</div>
					</div>
				</div>
			</from>
			</div>
		</div>
		<div class="portlet box grey-cascade" id="carType" style="display:none">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>车型信息管理
				</div>
			</div>
			<div class="portlet-body form" >
			<from class="form-horizontal form-row-sepe">  
				<div class="form-group">
					<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='pic3' src='${admin_che_url}image/car_pic.jpg'></label>
					<a class="btn green" href="#imgUploadModal" data-toggle="modal">上传图片</a>
					<input id='imagePath3' class='imagePath' type='hidden' readonly='readonly' >
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">生产状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='selA3'>
							<option value="0">停产</option>
							<option value="1">在产</option>
							<option value="2">未生产</option>
						</select>
					</div>
					<label class="control-label col-md-2">在售状态：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="selB3">
							<option value="0">停售</option>
			            	<option value="1">在售</option>
			            	<option value="2">未销售</option>
			            	<option value="3">未上市</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">年份：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='iyear'>
							<option value='0'>无</option>
							<option value='1994'>1994</option>
							<option value='1995'>1995</option>
							<option value='1996'>1996</option>
							<option value='1997'>1997</option>
							<option value='1998'>1998</option>
							<option value='1999'>1999</option>
							<option value='2000'>2000</option>
							<option value='2001'>2001</option>
							<option value='2002'>2002</option>
							<option value='2003'>2003</option>
							<option value='2004'>2004</option>
							<option value='2005'>2005</option>
							<option value='2006'>2006</option>
							<option value='2007'>2007</option>
							<option value='2008'>2008</option>
							<option value='2009'>2009</option>
							<option value='2010'>2010</option>
							<option value='2011'>2011</option>
							<option value='2012'>2012</option>
							<option value='2013'>2013</option>
							<option value='2014'>2014</option>
							<option value='2015'>2015</option>
							<option value='2016'>2016</option>
							<option value='2017'>2017</option>
							<option value='2018'>2018</option>
							<option value='2019'>2019</option>
						</select>
					</div>
					<label class="control-label col-md-2">箱体：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="xiangti">
							<option value='0'>无</option>
							<option value='1'>单厢</option>
							<option value='2'>两厢</option>
							<option value='3'>三厢</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">变速器：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='bsq'>
							<option value='0'>无</option>
							<option value='1'>手动</option>
							<option value='2'>自动</option>
							<option value='3'>双离合</option>
							<option value='4'>无级变速</option>
							<option value='5'>手自一体(AMT)</option>
							<option value='6'>单级变速箱</option>
						</select>
					</div>
					<label class="control-label col-md-2">级别：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="jibie">
							<option value='0'>无</option>
							<option value='1'>微型</option>
							<option value='2'>小型</option>
							<option value='3'>紧凑型</option>
							<option value='4'>轻型</option>
							<option value='5'>中型</option>
							<option value='6'>中大型</option>
							<option value='7'>大型</option>
							<option value='8'>豪华</option>
							<option value='9'>超级</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">产地：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='madein'>
							<option value='0'>海外</option>
							<option value='1'>国产</option>
							<option value='2'>进口</option>
						</select>
					</div>
					<label class="control-label col-md-2">类型：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="leixing">
							<option value='0'>无</option>
							<option value='1'>轿车</option>
							<option value='2'>跨界车</option>
							<option value='3'>SUV</option>
							<option value='4'>旅行车</option>
							<option value='5'>MPV</option>
							<option value='6'>跑车</option>
							<option value='7'>概念车</option>
							<option value='8'>皮卡</option>
							<option value='9'>客车</option>
							<option value='10'>卡车</option>
							<option value='11'>电动车</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">发动机：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id='fadongji'>
							<option value='0'>请选择</option>
							<option value='1'>汽油</option>
							<option value='2'>柴油</option>
							<option value='3'>混合动力</option>
							<option value='4'>纯电动</option>
							<option value='5'>天然气</option>
						</select>
					</div>
					<label class="control-label col-md-2">汽车类型：</label>
					<div class="col-md-3">
						<select class="form-control" name="select" id="car_type">
							<option value='0'>普通车型</option>
							<option value='1'>面包车型等</option>
							<option value='2'>油电混动车型</option>
							<option value='3'>纯电动车型</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">英文名：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='Englishname3'>
					</div>
					<label class="control-label col-md-2">排量：</label>
					<div class="col-md-2">
						
						<input type="text" name='textfield2' data-required="1" class="form-control input-inline input-medium" id='pailiang'></div><div class="col-md-2"><select name='' id='p209'>
        <option value='0'>请选择</option>
<option value='1'>T</option>
<option value='2'>L</option></select></em>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">品牌：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='pinpai'>
					</div>
					<label class="control-label col-md-2">渠道：</label>
					<div class="col-md-3">
						<input type="text" name='textfield2' data-required="1" class="form-control" id='qudao2'>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-offset-4 col-md-8">
							<input name='catalogId2' id='catalogId2' value='33' style='display:none;'>
							<button type="button" class="btn green" onClick='SaveC()'>保存车型信息</button>
							<button type="button" class="btn green" onClick='SubmitC()'>详细信息管理</button>
						</div>
					</div>
				</div>
			</from>
			</div>
		</div>
		<div id="carData" style="display:none;">
			<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption" id="cname">
					<i class="fa fa-globe"></i>Managed Table
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
						<tbody>
							<tr class="gradeX odd" role="row">
								<td class="col-md-5 sorting_1"> 源码：<textarea id="autohomeData" class="form-control input-inline input-medium" rows="3"></textarea></td>
								<td class="col-md-5 sorting_1">车型名称： <input id="carname" class="form-control input-inline input-medium" type="text"  name="textfield2" width="50%"></td>
								<td class="col-md-4 sorting_1"><button onclick="getCarData()" class="btn blue" type="button">获取</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="portlet-body">
			<ul class="nav nav-tabs" id="sTabNav">
				<li class="active">
					<a href="#tab_1_1" id="d1" data-toggle="tab">普通车型</a>
				</li>
				<li class="">
					<a href="#tab_1_2" id="d2" data-toggle="tab">面包皮卡车型</a>
				</li>
				<li class="">
					<a href="#tab_1_3" id="d3" data-toggle="tab">混合动力车型</a>
				</li>
				<li class="">
					<a href="#tab_1_4" id="d4" data-toggle="tab">纯动力车型</a>
				</li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade active in" id="tab_1_1">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tr>
								<tr>
                              		<td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
                            	</tr>
                             	<tr>
                              		<td class="col-md-2 control-label">车型名称</td>
                              		<td class="col-md-4 control-label"><input type="text"  class="jbcs1 form-control input-inline input-medium" id="car1_p1" >
                              		<td class="col-md-2 control-label">厂商指导价</td>
                             		<td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p2"></td>
                            	</tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p192"></td>
	                              <td class="col-md-2 control-label">级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p4"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p5"></td>
	                              <td class="col-md-2 control-label">变速箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p6"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长*宽*高</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p7"></td>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p8"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最高车速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p9"><em><span class="help-inline">(km/h)</span></em></td>
	                              <td class="col-md-2 control-label">官方0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p10"><em><span class="help-inline">(s)</span></em></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p13"><em><span class="help-inline">(s)</span></em> </td>
	                              <td class="col-md-2 control-label">实测100-0km/h制动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p14"><em><span class="help-inline">(s)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p15"><em><span class="help-inline">(L/100km)</span></em></td>
	                              <td class="col-md-2 control-label">工信部综合油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p193"><em><span class="help-inline">(L/100km)</span></em></td>
	                            </tr>
	                            <tr>
	                               <td class="col-md-2 control-label">实测离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">整车质保</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p16"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p17"><em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">宽度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p18"> <em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">高度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p19"> <em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">轴距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p20"> <em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p21"> <em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">后轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p22"> <em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最小离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p23"> <em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">整备质量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p24"> <em><span class="help-inline">(Kg)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p25"></td>
	                              <td class="col-md-2 control-label">车门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p26"> <em><span class="help-inline">(个)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座位数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p27"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">油箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p28"> <em><span class="help-inline">(L)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">行李箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs1 form-control input-inline input-medium" id="car1_p29"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">发动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机型号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p194"></td>
	                              <td class="col-md-2 control-label">排量(mL)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p30"><em><span class="help-inline">(cc)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">排量级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p31"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label">进气形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p32"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">气缸排列形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p33"></td>
	                              <td class="col-md-2 control-label">气缸数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p34"> <em><span class="help-inline">(个)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">每缸气门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p35"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">压缩比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p36"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">配气机构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p37"></td>
	                              <td class="col-md-2 control-label">缸径</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p38"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">冲程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p39"></td>
	                              <td class="col-md-2 control-label">最大马力</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p40"><em><span class="help-inline">(Ps)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p41"> <em><span class="help-inline">(kw)</span></em> </td>
	                              <td class="col-md-2 control-label">最大功率转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p42"> <em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p43"><em><span class="help-inline">(N·m)</span></em> </td>
	                              <td class="col-md-2 control-label">最大扭矩转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p44"> <em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机特有技术</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="fdj1 form-control input-inline input-medium" id="car1_p45"></td>
	                              <td class="col-md-2 control-label">燃料形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p46"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">燃油标号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium"  id="car1_p47"></td>
	                              <td class="col-md-2 control-label">供油方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p48"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">缸盖材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p49"></td>
	                              <td class="col-md-2 control-label">缸体材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p50"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">环保标准</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj1 form-control input-inline input-medium" id="car1_p51"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">变速箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">简称</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx1 form-control input-inline input-medium" id="car1_p52"></td>
	                              <td class="col-md-2 control-label">挡位个数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx1 form-control input-inline input-medium" id="car1_p53"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">变速箱类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx1 form-control input-inline input-medium" id="car1_p54"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">底盘转向参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驱动方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p55"></td>
	                              <td class="col-md-2 control-label">四驱形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" ></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">后悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">前悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p57"></td>
	                              <td class="col-md-2 control-label">助力类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p58"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">地盘结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p59"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车轮制动参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p60"></td>
	                              <td class="col-md-2 control-label">后制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p61"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驻车制动类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p62"></td>
	                              <td class="col-md-2 control-label">前轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p63"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p64"></td>
	                              <td class="col-md-2 control-label">备胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd1 form-control input-inline input-medium" id="car1_p65"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">安全装备参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主/副驾驶座安全气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p66_p67"></td>
	                              <td class="col-md-2 control-label">前/后排侧气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p68_p69"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排头部气囊(气帘)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p70_p71"></td>
	                              <td class="col-md-2 control-label">膝部气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p72"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">胎压监测装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p87"></td> 	
	                              <td class="col-md-2 control-label">零胎压继续行驶</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p88"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">安全带未系提示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p73"></td>
	                              <td class="col-md-2 control-label">ISO FIX儿童座椅接口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p198"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机电子防盗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p74"></td>
	                              <td class="col-md-2 control-label">车内中控锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p75"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">遥控钥匙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p76"></td>
	                              
	                              <td class="col-md-2 control-label">无钥匙启动系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb1 form-control input-inline input-medium" id="car1_p77"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">无钥匙进入系统</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="aqzb1 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">操控配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">ABS防抱死</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p78"></td>
	                              <td class="col-md-2 control-label">制动力分配</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p79"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">刹车辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p80"></td>
	                              <td class="col-md-2 control-label">牵引力控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p81"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身稳定控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p82"></td>
	                              <td class="col-md-2 control-label">自动驻车_上坡辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p83"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动驻车</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">陡坡缓降</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p84"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="czpz1 form-control input-inline input-medium" id="car1_p85"></td>
	                              <td class="col-md-2 control-label">空气悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p86"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变转向比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium" id="car1_p89"></td>
	                              <td class="col-md-2 control-label"> 前桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器锁止功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">后桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz1 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">外部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium" id="car1_p90"></td>
	                              <td class="col-md-2 control-label">全景天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium" id="car1_p91"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">运动外观套件</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium" id="car1_p94"></td>
	                              <td class="col-md-2 control-label">铝合金轮毂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium" id="car1_p95"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动吸合门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium" id="car1_p180"></td>
	                              <td class="col-md-2 control-label">侧滑门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动后备厢</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz1 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">内部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p96"></td>
	                              <td class="col-md-2 control-label">方向盘调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p97_p98"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p181"></td>
	                              <td class="col-md-2 control-label">多功能方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p99"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘换挡</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p100"></td>
	                              <td class="col-md-2 control-label">方向盘加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">定速巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p101"></td>
	                              <td class="col-md-2 control-label">前/后驻车雷达</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">倒车视频影像</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p103"></td>
	                              <td class="col-md-2 control-label">行车电脑显示屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p104"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">HUD抬头数字显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz1 form-control input-inline input-medium" id="car1_p105"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">座椅配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p107"></td>
	                              <td class="col-md-2 control-label">运动座椅</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="zypz1 form-control input-inline input-medium" id="car1_p108"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座椅高低调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p109"></td>
	                              <td class="col-md-2 control-label">腰部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p110"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">肩部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p182"></td>
	                              <td class="col-md-2 control-label">主/副驾驶座电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p111"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第二排靠背角度调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p195"></td>
	                              <td class="col-md-2 control-label">第二排座椅移动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p196"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排座椅电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p113"></td>
	                              <td class="col-md-2 control-label">电动座椅记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p114"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p115_p116"></td>
	                              <td class="col-md-2 control-label">前/后排座椅通风</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p117"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅按摩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p118"></td>
	                              <td class="col-md-2 control-label">后排座椅放倒方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p119_p120"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第三排座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p121"></td>
	                              <td class="col-md-2 control-label">前/后中央扶手</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p122_p123"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排杯架</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz1 form-control input-inline input-medium" id="car1_p125"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">多媒体配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">GPS导航系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p127"></td>
	                              <td class="col-md-2 control-label">定位互动服务</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p183"></td>
	                  
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中控台彩色大屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p128"></td>
	                              <td class="col-md-2 control-label">内置硬盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p130"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">蓝牙/车载电话</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p133"></td>
	                              <td class="col-md-2 control-label">车载电视</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p132"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排液晶屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p134"></td>
	                              <td class="col-md-2 control-label">外接音源接口</td> 
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p135"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">CD支持MP3/WMA</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p136"></td>
	                              <td class="col-md-2 control-label">多媒体系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p137_p140"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">扬声器品牌</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">扬声器数量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz1 form-control input-inline input-medium" id="car1_p141_p144"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">灯光配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">氙气大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p145"></td>
	                              <td class="col-md-2 control-label">LED大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">日间行车灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p146"></td>
	                              <td class="col-md-2 control-label">自动头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p147"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">转向辅助灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p148"></td>
	                              <td class="col-md-2 control-label">转向头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前雾灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p149"></td>
	                              <td class="col-md-2 control-label">大灯高度可调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p151"></td>
	                              
	                            </tr>
	                            <tr>
	                            <td class="col-md-2 control-label">大灯清洗装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p152"></td>
	                              <td class="col-md-2 control-label">车内氛围灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz1 form-control input-inline input-medium" id="car1_p186"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">玻璃_后视镜参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后电动车窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p153_p154"></td>
	                              <td class="col-md-2 control-label">车窗防夹手功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p155"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">防紫外线/隔热玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p187"></td>
	                              <td class="col-md-2 control-label">后视镜电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p156"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p157"></td>
	                              <td class="col-md-2 control-label">内/外后视镜自动防眩目</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p158"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜电动折叠</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p159"></td>
	                              <td class="col-md-2 control-label">后视镜记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p197"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后风挡遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p160"></td>
	                              <td class="col-md-2 control-label">后排侧遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p161"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排侧隐私玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="plpz1 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">遮阳板化妆镜</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p162"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">后雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz1 form-control input-inline input-medium" id="car1_p188"></td>
	                              <td class="col-md-2 control-label">感应雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" id="car1_p163" class="plpz1 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">空调_冰箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">手动空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p164"></td>
	                              <td class="col-md-2 control-label">后排独立空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p166"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后座出风口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p167"></td>
	                              <td class="col-md-2 control-label">温度分区控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p168"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">空气调节_花粉过滤</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p169"></td>
	                              <td class="col-md-2 control-label">车载冰箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz1 form-control input-inline input-medium" id="car1_p170"></td>
	                            </tr>
	                           
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">高科技配置</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动泊车入位</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p171"></td>
	                              <td class="col-md-2 control-label">发动机启停技术</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">并线辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p172"></td>
	                               <td class="col-md-2 control-label">车道偏离预警系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" ></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主动刹车/主动安全系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p189"></td>
	                              <td class="col-md-2 control-label">整体主动转向系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p190"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">夜视系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p173"></td>
	                              <td class="col-md-2 control-label">中控液晶屏分屏显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p191"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自适应巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p174"></td>
	                              
	                              <td class="col-md-2 control-label">全景摄像头</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz1 form-control input-inline input-medium" id="car1_p175"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身颜色</td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="car1_p200"></textarea></td>
	                            </tr>
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_2">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tr>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs2 form-control input-inline input-medium" id="car2_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p192"></td>
	                              <td class="col-md-2 control-label">级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p4"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p5"></td>
	                              <td class="col-md-2 control-label">变速箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p6"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长宽高</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p7"></td>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p8"></td>
	                              
	                            </tr>
	                            
	                            <tr>
	                              <td class="col-md-2 control-label">工信部综合油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p193"><em><span class="help-inline">(L/100km)</span></em></td>
	                              <td class="col-md-2 control-label">整车质保</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p16"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p17"><em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">宽度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p18"><em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">高度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p19"><em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">轴距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p20"><em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p21"><em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">后轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p22"><em><span class="help-inline">(mm)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最小离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p23"><em><span class="help-inline">(mm)</span></em> </td>
	                              <td class="col-md-2 control-label">整备质量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p24"><em><span class="help-inline">(Kg)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p25"></td>
	                              <td class="col-md-2 control-label">车门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p26"><em><span class="help-inline">(个)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座位数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p27"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">后排车门开启方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p201"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">货箱尺寸</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p202"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">最大载重质量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs2 form-control input-inline input-medium" id="car2_p203"> <em><span class="help-inline">(kg)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">变速箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">简称</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx2 form-control input-inline input-medium" id="car2_p52"></td>
	                              <td class="col-md-2 control-label">挡位个数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx2 form-control input-inline input-medium" id="car2_p53"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">变速箱类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx2 form-control input-inline input-medium" id="car2_p54"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">底盘转向参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驱动方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p55"></td>
	                               <td class="col-md-2 control-label">四驱形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" ></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">后悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">前悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p57"></td>
	                              <td class="col-md-2 control-label">助力类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p58"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">地盘结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p59"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车轮制动参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd2 form-control input-inline input-medium" id="car2_p60"></td>
	                              <td class="col-md-2 control-label">后制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd2 form-control input-inline input-medium" id="car2_p61"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">前轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd2 form-control input-inline input-medium" id="car2_p63"></td>
	                              <td class="col-md-2 control-label">后轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd2 form-control input-inline input-medium" id="car2_p64"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">发动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机型号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p194"></td>
	                              <td class="col-md-2 control-label">排量(mL)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p30"> <em><span class="help-inline">(cc)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">排量级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p31"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label">进气形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p32"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">气缸排列形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p33"></td>
	                              <td class="col-md-2 control-label">气缸数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p34"><em><span class="help-inline">(个)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">每缸气门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p35"> <em><span class="help-inline">(个)</span></em> </td>
	                              <td class="col-md-2 control-label">压缩比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p36"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">配气机构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p37"></td>
	                              <td class="col-md-2 control-label">缸径</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p38"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">冲程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p39"></td>
	                              <td class="col-md-2 control-label">最大马力</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p40"><em><span class="help-inline">(Ps)</span></em>  </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p41"> <em><span class="help-inline">(kw)</span></em></td>
	                              <td class="col-md-2 control-label">最大功率转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p42"> <em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p43"><em><span class="help-inline">(N·m)</span></em> </td>
	                              <td class="col-md-2 control-label">最大扭矩转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p44"><em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">燃料形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p46"></td>
	                              <td class="col-md-2 control-label">燃油标号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium"  id="car2_p47"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">供油方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p48"></td>
	                              <td class="col-md-2 control-label">缸盖材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p49"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">缸体材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p50"></td>
	                              <td class="col-md-2 control-label">环保标准</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj2 form-control input-inline input-medium" id="car2_p51"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">安全装备参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主/副驾驶座安全气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb2 form-control input-inline input-medium" id="car2_p66_p67"></td>
	                              <td class="col-md-2 control-label">前/后排侧气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb2 form-control input-inline input-medium" id="car2_p68_p69"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机电子防盗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb2 form-control input-inline input-medium" id="car2_p74"></td>
	                              <td class="col-md-2 control-label">车内中控锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb2 form-control input-inline input-medium" id="car2_p75"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">遥控钥匙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb2 form-control input-inline input-medium" id="car2_p76"></td>
	                              
	                            </tr>
	                           
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">操控配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">ABS防抱死</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz2 form-control input-inline input-medium" id="car2_p78"></td>
	                              <td class="col-md-2 control-label">制动力分配</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz2 form-control input-inline input-medium" id="car2_p79"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">刹车辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz2 form-control input-inline input-medium" id="car2_p80"></td>
	                              <td class="col-md-2 control-label">牵引力控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz2 form-control input-inline input-medium" id="car2_p81"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身稳定控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz2 form-control input-inline input-medium" id="car2_p82"></td>
	                             
	                              
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">外部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz2 form-control input-inline input-medium" id="car2_p90"></td>
	                              <td class="col-md-2 control-label">全景天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz2 form-control input-inline input-medium" id="car2_p91"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              
	                              <td class="col-md-2 control-label">铝合金轮毂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz2 form-control input-inline input-medium" id="car2_p95"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">内部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p96"></td>
	                              <td class="col-md-2 control-label">多功能方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p99"></td>
	                              
	                              
	                            </tr>
	                            
	                            <tr>
	                              <td class="col-md-2 control-label">定速巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p101"></td>
	                              <td class="col-md-2 control-label">后倒车雷达</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p204"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">倒车视频影像</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p103"></td>
	                              <td class="col-md-2 control-label">行车电脑显示屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz2 form-control input-inline input-medium" id="car2_p104"></td>
	                              
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">座椅配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p107"></td>
	                              <td class="col-md-2 control-label">座椅高低调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p109"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">腰部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p110"></td>
	                              <td class="col-md-2 control-label">驾驶座电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p111"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td class="col-md-2 control-label">第二排靠背角度调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p195"></td>
	                              <td class="col-md-2 control-label">第二排座椅移动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p196"></td>
	                              
	                            </tr>
	                           
	                            <tr>
	                              <td class="col-md-2 control-label">前排座椅加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p115"></td>
	                              <td class="col-md-2 control-label">后排座椅放倒方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p119_p120"></td>
	                            </tr>
	                            
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">前中央扶手</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz2 form-control input-inline input-medium" id="car2_p122"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">多媒体配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">GPS导航系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p127"></td>
	                              
	                              <td class="col-md-2 control-label">中控台彩色大屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p128"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                             
	                              <td class="col-md-2 control-label">车载电视</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p132"></td>
	                              <td class="col-md-2 control-label">后排液晶屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p134"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">外接音源接口</td> 
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p135"></td>
	                              <td class="col-md-2 control-label">多媒体系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz2 form-control input-inline input-medium" id="car2_p137_p140"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">灯光配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">氙气大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz2 form-control input-inline input-medium" id="car2_p145"></td>
	                              <td class="col-md-2 control-label">前雾灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz2 form-control input-inline input-medium" id="car2_p149"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">大灯高度可调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz2 form-control input-inline input-medium" id="car2_p151"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">玻璃_后视镜参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后电动车窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p153_p154"></td>
	                              <td class="col-md-2 control-label">后视镜电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p156"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p157"></td>
	                              <td class="col-md-2 control-label">后风挡遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p160"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排侧遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p161"></td>
	                              <td class="col-md-2 control-label">后雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz2 form-control input-inline input-medium" id="car2_p188"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">空调_冰箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">手动空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz2 form-control input-inline input-medium" id="car2_p164"></td>
	                              <td class="col-md-2 control-label">后排独立空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz2 form-control input-inline input-medium" id="car2_p166"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后座出风口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz2 form-control input-inline input-medium" id="car2_p167"></td>
	                              <td class="col-md-2 control-label">温度分区控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz2 form-control input-inline input-medium" id="car2_p168"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身颜色</td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="car2_p200"></textarea></td>
	                            </tr>
	                            
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_3">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tr>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs3 form-control input-inline input-medium" id="car3_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p192"></td>
	                              <td class="col-md-2 control-label">级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p4"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p5"></td>
	                              <td class="col-md-2 control-label">变速箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p6"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长宽高</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p7"></td>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p8"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最高车速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p9"><em><span class="help-inline">(km/h)</span></em></td>
	                              <td class="col-md-2 control-label">官方0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p10"><em><span class="help-inline">(s)</span></em></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p13"> <em><span class="help-inline">(s)</span></em></td>
	                              <td class="col-md-2 control-label">实测100-0km/h制动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p14"><em><span class="help-inline">(s)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p15"><em><span class="help-inline">(L/100km)</span></em></td>
	                              <td class="col-md-2 control-label">工信部综合油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p193"><em><span class="help-inline">(L/100km)</span></em></td>
	                            </tr>
	                            <tr>
	                               <td class="col-md-2 control-label">实测离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">整车质保</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p16"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p17"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">宽度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p18"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">高度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p19"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">轴距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p20"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p21"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">后轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p22"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最小离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p23"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">整备质量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p24"> <em><span class="help-inline">(Kg)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p25"></td>
	                              <td class="col-md-2 control-label">车门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p26"><em><span class="help-inline">(个)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座位数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p27"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">油箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p28"> <em><span class="help-inline">(L)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">行李箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs3 form-control input-inline input-medium" id="car3_p29"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">发动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机型号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p194"></td>
	                              <td class="col-md-2 control-label">排量(mL)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p30"> <em><span class="help-inline">(cc)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">排量级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p31"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label">进气形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p32"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">气缸排列形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p33"></td>
	                              <td class="col-md-2 control-label">气缸数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p34"> <em><span class="help-inline">(个)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">每缸气门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p35"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">压缩比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p36"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">配气机构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p37"></td>
	                              <td class="col-md-2 control-label">缸径</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p38"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">冲程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p39"></td>
	                              <td class="col-md-2 control-label">最大马力</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p40"> <em><span class="help-inline">(Ps)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p41"> <em><span class="help-inline">(kw)</span></em> </td>
	                              <td class="col-md-2 control-label">最大功率转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p42"><em><span class="help-inline">(rpm)</span></em>  </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p43"> <em><span class="help-inline">(N·m)</span></em> </td>
	                              <td class="col-md-2 control-label">最大扭矩转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p44"> <em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机特有技术</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="fdj3 form-control input-inline input-medium" id="car3_p45"></td>
	                              <td class="col-md-2 control-label">燃料形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p46"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">燃油标号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium"  id="car3_p47"></td>
	                              <td class="col-md-2 control-label">供油方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p48"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">缸盖材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p49"></td>
	                              <td class="col-md-2 control-label">缸体材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p50"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">环保标准</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj3 form-control input-inline input-medium" id="car3_p51"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">电动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动机最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj3 form-control input-inline input-medium" id="car3_p205"></td>
	                              <td class="col-md-2 control-label">电动机最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj3 form-control input-inline input-medium" id="car3_p206"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电池支持最高续航里程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj3 form-control input-inline input-medium" id="car3_p207"></td>
	                              <td class="col-md-2 control-label">电池容量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj3 form-control input-inline input-medium" id="car3_p208"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">变速箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">简称</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx3 form-control input-inline input-medium" id="car3_p52"></td>
	                              <td class="col-md-2 control-label">挡位个数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx3 form-control input-inline input-medium" id="car3_p53"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">变速箱类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx3 form-control input-inline input-medium" id="car3_p54"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">底盘转向参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驱动方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p55"></td>
	                              <td class="col-md-2 control-label">四驱形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" ></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">后悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">前悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p57"></td>
	                              <td class="col-md-2 control-label">助力类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p58"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">地盘结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p59"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车轮制动参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p60"></td>
	                              <td class="col-md-2 control-label">后制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p61"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驻车制动类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p62"></td>
	                              <td class="col-md-2 control-label">前轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p63"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p64"></td>
	                              <td class="col-md-2 control-label">备胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd3 form-control input-inline input-medium" id="car3_p65"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">安全装备参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主/副驾驶座安全气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p66_p67"></td>
	                              <td class="col-md-2 control-label">前/后排侧气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p68_p69"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排头部气囊(气帘)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p70_p71"></td>
	                              <td class="col-md-2 control-label">膝部气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p72"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">胎压监测装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p87"></td> 	
	                              <td class="col-md-2 control-label">零胎压继续行驶</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p88"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">安全带未系提示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p73"></td>
	                              <td class="col-md-2 control-label">ISO FIX儿童座椅接口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p198"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机电子防盗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p74"></td>
	                              <td class="col-md-2 control-label">车内中控锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p75"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">遥控钥匙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p76"></td>
	                              
	                              <td class="col-md-2 control-label">无钥匙启动系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb3 form-control input-inline input-medium" id="car3_p77"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">无钥匙进入系统</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="aqzb3 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">操控配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">ABS防抱死</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p78"></td>
	                              <td class="col-md-2 control-label">制动力分配</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p79"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">刹车辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p80"></td>
	                              <td class="col-md-2 control-label">牵引力控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p81"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身稳定控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p82"></td>
	                              <td class="col-md-2 control-label">自动驻车_上坡辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p83"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动驻车</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">陡坡缓降</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p84"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="czpz3 form-control input-inline input-medium" id="car3_p85"></td>
	                              <td class="col-md-2 control-label">空气悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p86"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变转向比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium" id="car3_p89"></td>
	                              <td class="col-md-2 control-label"> 前桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器锁止功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">后桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz3 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">外部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium" id="car3_p90"></td>
	                              <td class="col-md-2 control-label">全景天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium" id="car3_p91"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">运动外观套件</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium" id="car3_p94"></td>
	                              <td class="col-md-2 control-label">铝合金轮毂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium" id="car3_p95"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动吸合门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium" id="car3_p180"></td>
	                              <td class="col-md-2 control-label">侧滑门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动后备厢</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz3 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">内部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p96"></td>
	                              <td class="col-md-2 control-label">方向盘调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p97_p98"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p181"></td>
	                              <td class="col-md-2 control-label">多功能方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p99"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘换挡</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p100"></td>
	                              <td class="col-md-2 control-label">方向盘加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">定速巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p101"></td>
	                              <td class="col-md-2 control-label">前/后驻车雷达</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">倒车视频影像</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p103"></td>
	                              <td class="col-md-2 control-label">行车电脑显示屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p104"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">HUD抬头数字显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz3 form-control input-inline input-medium" id="car3_p105"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">座椅配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p107"></td>
	                              <td class="col-md-2 control-label">运动座椅</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="zypz3 form-control input-inline input-medium" id="car3_p108"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座椅高低调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p109"></td>
	                              <td class="col-md-2 control-label">腰部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p110"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">肩部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p182"></td>
	                              <td class="col-md-2 control-label">主/副驾驶座电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p111"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第二排靠背角度调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p195"></td>
	                              <td class="col-md-2 control-label">第二排座椅移动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p196"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排座椅电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p113"></td>
	                              <td class="col-md-2 control-label">电动座椅记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p114"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p115_p116"></td>
	                              <td class="col-md-2 control-label">前/后排座椅通风</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p117"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅按摩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p118"></td>
	                              <td class="col-md-2 control-label">后排座椅放倒方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p119_p120"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第三排座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p121"></td>
	                              <td class="col-md-2 control-label">前/后中央扶手</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p122_p123"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排杯架</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz3 form-control input-inline input-medium" id="car3_p125"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">多媒体配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">GPS导航系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p127"></td>
	                              <td class="col-md-2 control-label">定位互动服务</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p183"></td>
	                  
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中控台彩色大屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p128"></td>
	                              <td class="col-md-2 control-label">内置硬盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p130"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">蓝牙/车载电话</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p133"></td>
	                              <td class="col-md-2 control-label">车载电视</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p132"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排液晶屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p134"></td>
	                              <td class="col-md-2 control-label">外接音源接口</td> 
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p135"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">CD支持MP3/WMA</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p136"></td>
	                              <td class="col-md-2 control-label">多媒体系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p137_p140"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">扬声器品牌</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">扬声器数量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz3 form-control input-inline input-medium" id="car3_p141_p144"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">灯光配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">氙气大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p145"></td>
	                              <td class="col-md-2 control-label">LED大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">日间行车灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p146"></td>
	                              <td class="col-md-2 control-label">自动头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p147"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">转向辅助灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p148"></td>
	                              <td class="col-md-2 control-label">转向头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前雾灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p149"></td>
	                              <td class="col-md-2 control-label">大灯高度可调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3  form-control input-inline input-medium" id="car3_p151"></td>
	                              
	                            </tr>
	                            <tr>
	                            <td class="col-md-2 control-label">大灯清洗装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p152"></td>
	                              <td class="col-md-2 control-label">车内氛围灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz3 form-control input-inline input-medium" id="car3_p186"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">玻璃_后视镜参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后电动车窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p153_p154"></td>
	                              <td class="col-md-2 control-label">车窗防夹手功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p155"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">防紫外线/隔热玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p187"></td>
	                              <td class="col-md-2 control-label">后视镜电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p156"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p157"></td>
	                              <td class="col-md-2 control-label">内/外后视镜自动防眩目</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p158"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜电动折叠</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p159"></td>
	                              <td class="col-md-2 control-label">后视镜记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p197"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后风挡遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p160"></td>
	                              <td class="col-md-2 control-label">后排侧遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p161"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排侧隐私玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="plpz3 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">遮阳板化妆镜</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p162"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">后雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz3 form-control input-inline input-medium" id="car3_p188"></td>
	                              <td class="col-md-2 control-label">感应雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" id="car3_p163" class="plpz3 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">空调_冰箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">手动空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p164"></td>
	                              <td class="col-md-2 control-label">后排独立空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p166"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后座出风口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p167"></td>
	                              <td class="col-md-2 control-label">温度分区控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p168"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">空气调节_花粉过滤</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p169"></td>
	                              <td class="col-md-2 control-label">车载冰箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz3 form-control input-inline input-medium" id="car3_p170"></td>
	                            </tr>
	                           
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">高科技配置</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动泊车入位</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p171"></td>
	                              <td class="col-md-2 control-label">发动机启停技术</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">并线辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p172"></td>
	                               <td class="col-md-2 control-label">车道偏离预警系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" ></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主动刹车/主动安全系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p189"></td>
	                              <td class="col-md-2 control-label">整体主动转向系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p190"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">夜视系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p173"></td>
	                              <td class="col-md-2 control-label">中控液晶屏分屏显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p191"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自适应巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p174"></td>
	                              
	                              <td class="col-md-2 control-label">全景摄像头</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz3 form-control input-inline input-medium" id="car3_p175"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身颜色</td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"><textarea name=""  cols="20" rows="2" id="car3_p200" class="form-control input-inline input-medium"></textarea></td>
	                            </tr>
	                            
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_4">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tr>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs4 form-control input-inline input-medium" id="car4_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p192"></td>
	                              <td class="col-md-2 control-label">级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p4"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p5"></td>
	                              <td class="col-md-2 control-label">变速箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p6"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长宽高</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p7"></td>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p8"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最高车速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p9"><em><span class="help-inline">(km/h)</span></em></td>
	                              <td class="col-md-2 control-label">官方0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p10"><em><span class="help-inline">(s)</span></em></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测0-100km/h加速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p13"> <em><span class="help-inline">(s)</span></em></td>
	                              <td class="col-md-2 control-label">实测100-0km/h制动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p14"><em><span class="help-inline">(s)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">实测油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p15"><em><span class="help-inline">(L/100km)</span></em></td>
	                              <td class="col-md-2 control-label">工信部综合油耗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p193"><em><span class="help-inline">(L/100km)</span></em></td>
	                            </tr>
	                            <tr>
	                               <td class="col-md-2 control-label">实测离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">整车质保</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p16"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p17"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">宽度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p18"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">高度</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p19"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">轴距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p20"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p21"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">后轮距</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p22"> <em><span class="help-inline">(mm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最小离地间隙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p23"> <em><span class="help-inline">(mm)</span></em></td>
	                              <td class="col-md-2 control-label">整备质量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p24"> <em><span class="help-inline">(Kg)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p25"></td>
	                              <td class="col-md-2 control-label">车门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p26"><em><span class="help-inline">(个)</span></em> </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座位数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p27"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">油箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p28"> <em><span class="help-inline">(L)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">行李箱容积</td>
	                              <td class="col-md-4 control-label"><input type="text" class="cs4 form-control input-inline input-medium" id="car4_p29"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">发动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机型号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p194"></td>
	                              <td class="col-md-2 control-label">排量(mL)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p30"> <em><span class="help-inline">(cc)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">排量级别</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p31"> <em><span class="help-inline">(L)</span></em></td>
	                              <td class="col-md-2 control-label">进气形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p32"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">气缸排列形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p33"></td>
	                              <td class="col-md-2 control-label">气缸数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p34"> <em><span class="help-inline">(个)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">每缸气门数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p35"> <em><span class="help-inline">(个)</span></em></td>
	                              <td class="col-md-2 control-label">压缩比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p36"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">配气机构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p37"></td>
	                              <td class="col-md-2 control-label">缸径</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p38"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">冲程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p39"></td>
	                              <td class="col-md-2 control-label">最大马力</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p40"> <em><span class="help-inline">(Ps)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p41"> <em><span class="help-inline">(kw)</span></em> </td>
	                              <td class="col-md-2 control-label">最大功率转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p42"><em><span class="help-inline">(rpm)</span></em>  </td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p43"> <em><span class="help-inline">(N·m)</span></em> </td>
	                              <td class="col-md-2 control-label">最大扭矩转速</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p44"> <em><span class="help-inline">(rpm)</span></em></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机特有技术</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="fdj4 form-control input-inline input-medium" id="car4_p45"></td>
	                              <td class="col-md-2 control-label">燃料形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p46"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">燃油标号</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium"  id="car4_p47"></td>
	                              <td class="col-md-2 control-label">供油方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p48"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">缸盖材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p49"></td>
	                              <td class="col-md-2 control-label">缸体材料</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p50"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">环保标准</td>
	                              <td class="col-md-4 control-label"><input type="text" class="fdj4 form-control input-inline input-medium" id="car4_p51"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">电动机</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动机最大功率</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj4 form-control input-inline input-medium" id="car4_p205"></td>
	                              <td class="col-md-2 control-label">电动机最大扭矩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj4 form-control input-inline input-medium" id="car4_p206"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电池支持最高续航里程</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj4 form-control input-inline input-medium" id="car4_p207"></td>
	                              <td class="col-md-2 control-label">电池容量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ddj4 form-control input-inline input-medium" id="car4_p208"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">变速箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">简称</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx4 form-control input-inline input-medium" id="car4_p52"></td>
	                              <td class="col-md-2 control-label">挡位个数</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx4 form-control input-inline input-medium" id="car4_p53"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">变速箱类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="bsx4 form-control input-inline input-medium" id="car4_p54"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">底盘转向参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驱动方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p55"></td>
	                              <td class="col-md-2 control-label">四驱形式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" ></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">后悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">前悬架类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p57"></td>
	                              <td class="col-md-2 control-label">助力类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p58"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">地盘结构</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p59"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车轮制动参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p60"></td>
	                              <td class="col-md-2 control-label">后制动器类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p61"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">驻车制动类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p62"></td>
	                              <td class="col-md-2 control-label">前轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p63"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后轮胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p64"></td>
	                              <td class="col-md-2 control-label">备胎规格</td>
	                              <td class="col-md-4 control-label"><input type="text" class="clzd4 form-control input-inline input-medium" id="car4_p65"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">安全装备参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主/副驾驶座安全气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p66_p67"></td>
	                              <td class="col-md-2 control-label">前/后排侧气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p68_p69"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排头部气囊(气帘)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p70_p71"></td>
	                              <td class="col-md-2 control-label">膝部气囊</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p72"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">胎压监测装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p87"></td> 	
	                              <td class="col-md-2 control-label">零胎压继续行驶</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p88"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">安全带未系提示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p73"></td>
	                              <td class="col-md-2 control-label">ISO FIX儿童座椅接口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p198"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机电子防盗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p74"></td>
	                              <td class="col-md-2 control-label">车内中控锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p75"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">遥控钥匙</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p76"></td>
	                              
	                              <td class="col-md-2 control-label">无钥匙启动系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="aqzb4 form-control input-inline input-medium" id="car4_p77"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">无钥匙进入系统</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="aqzb4 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">操控配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">ABS防抱死</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p78"></td>
	                              <td class="col-md-2 control-label">制动力分配</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p79"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">刹车辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p80"></td>
	                              <td class="col-md-2 control-label">牵引力控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p81"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">车身稳定控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p82"></td>
	                              <td class="col-md-2 control-label">自动驻车_上坡辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p83"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动驻车</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" ></td>
	                              <td class="col-md-2 control-label">陡坡缓降</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p84"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="czpz4 form-control input-inline input-medium" id="car4_p85"></td>
	                              <td class="col-md-2 control-label">空气悬挂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p86"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">可变转向比</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium" id="car4_p89"></td>
	                              <td class="col-md-2 control-label"> 前桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中央差速器锁止功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">后桥限滑差速器/差速锁</td>
	                              <td class="col-md-4 control-label"><input type="text" class="czpz4 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">外部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium" id="car4_p90"></td>
	                              <td class="col-md-2 control-label">全景天窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium" id="car4_p91"></td>
	                              
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">运动外观套件</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium" id="car4_p94"></td>
	                              <td class="col-md-2 control-label">铝合金轮毂</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium" id="car4_p95"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动吸合门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium" id="car4_p180"></td>
	                              <td class="col-md-2 control-label">侧滑门</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">电动后备厢</td>
	                              <td class="col-md-4 control-label"><input type="text" class="wbpz4 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">内部配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p96"></td>
	                              <td class="col-md-2 control-label">方向盘调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p97_p98"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p181"></td>
	                              <td class="col-md-2 control-label">多功能方向盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p99"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">方向盘换挡</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p100"></td>
	                              <td class="col-md-2 control-label">方向盘加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">定速巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p101"></td>
	                              <td class="col-md-2 control-label">前/后驻车雷达</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">倒车视频影像</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p103"></td>
	                              <td class="col-md-2 control-label">行车电脑显示屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p104"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">HUD抬头数字显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="nbpz4 form-control input-inline input-medium" id="car4_p105"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">座椅配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">真皮座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p107"></td>
	                              <td class="col-md-2 control-label">运动座椅</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="zypz4 form-control input-inline input-medium" id="car4_p108"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">座椅高低调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p109"></td>
	                              <td class="col-md-2 control-label">腰部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p110"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">肩部支撑调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p182"></td>
	                              <td class="col-md-2 control-label">主/副驾驶座电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p111"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第二排靠背角度调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p195"></td>
	                              <td class="col-md-2 control-label">第二排座椅移动</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p196"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排座椅电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p113"></td>
	                              <td class="col-md-2 control-label">电动座椅记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p114"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p115_p116"></td>
	                              <td class="col-md-2 control-label">前/后排座椅通风</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p117"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后排座椅按摩</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p118"></td>
	                              <td class="col-md-2 control-label">后排座椅放倒方式</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p119_p120"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">第三排座椅</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p121"></td>
	                              <td class="col-md-2 control-label">前/后中央扶手</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p122_p123"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排杯架</td>
	                              <td class="col-md-4 control-label"><input type="text" class="zypz4 form-control input-inline input-medium" id="car4_p125"></td>
	                              <td class="col-md-2 control-label"></td>
	                              <td class="col-md-4 control-label"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">多媒体配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">GPS导航系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p127"></td>
	                              <td class="col-md-2 control-label">定位互动服务</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p183"></td>
	                  
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">中控台彩色大屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p128"></td>
	                              <td class="col-md-2 control-label">内置硬盘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p130"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">蓝牙/车载电话</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p133"></td>
	                              <td class="col-md-2 control-label">车载电视</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p132"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排液晶屏</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p134"></td>
	                              <td class="col-md-2 control-label">外接音源接口</td> 
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p135"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">CD支持MP3/WMA</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p136"></td>
	                              <td class="col-md-2 control-label">多媒体系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p137_p140"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">扬声器品牌</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">扬声器数量</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dmtpz4 form-control input-inline input-medium" id="car4_p141_p144"></td>
	                            </tr>
	                            
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">灯光配置参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">氙气大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p145"></td>
	                              <td class="col-md-2 control-label">LED大灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">日间行车灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p146"></td>
	                              <td class="col-md-2 control-label">自动头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p147"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">转向辅助灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p148"></td>
	                              <td class="col-md-2 control-label">转向头灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前雾灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p149"></td>
	                              <td class="col-md-2 control-label">大灯高度可调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4  form-control input-inline input-medium" id="car4_p151"></td>
	                              
	                            </tr>
	                            <tr>
	                            <td class="col-md-2 control-label">大灯清洗装置</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p152"></td>
	                              <td class="col-md-2 control-label">车内氛围灯</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dgpz4 form-control input-inline input-medium" id="car4_p186"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">玻璃_后视镜参数</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">前/后电动车窗</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p153_p154"></td>
	                              <td class="col-md-2 control-label">车窗防夹手功能</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p155"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">防紫外线/隔热玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p187"></td>
	                              <td class="col-md-2 control-label">后视镜电动调节</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p156"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜加热</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p157"></td>
	                              <td class="col-md-2 control-label">内/外后视镜自动防眩目</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p158"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后视镜电动折叠</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p159"></td>
	                              <td class="col-md-2 control-label">后视镜记忆</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p197"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后风挡遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p160"></td>
	                              <td class="col-md-2 control-label">后排侧遮阳帘</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p161"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后排侧隐私玻璃</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="plpz4 form-control input-inline input-medium"></td>
	                              <td class="col-md-2 control-label">遮阳板化妆镜</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p162"></td>
	                            </tr>
	                            <tr>
	                              
	                              <td class="col-md-2 control-label">后雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" class="plpz4 form-control input-inline input-medium" id="car4_p188"></td>
	                              <td class="col-md-2 control-label">感应雨刷</td>
	                              <td class="col-md-4 control-label"><input type="text" id="car4_p163" class="plpz4 form-control input-inline input-medium"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">空调_冰箱</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">空调控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p164"></td>
	                              <td class="col-md-2 control-label">后排独立空调</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p166"></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">后座出风口</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p167"></td>
	                              <td class="col-md-2 control-label">温度分区控制</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p168"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">空气调节_花粉过滤</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p169"></td>
	                              <td class="col-md-2 control-label">车载冰箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="ktpz4 form-control input-inline input-medium" id="car4_p170"></td>
	                            </tr>
	                           
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">高科技配置</td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自动泊车入位</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p171"></td>
	                              <td class="col-md-2 control-label">发动机启停技术</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">并线辅助</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p172"></td>
	                               <td class="col-md-2 control-label">车道偏离预警系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" ></td>
	                             
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">主动刹车/主动安全系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p189"></td>
	                              <td class="col-md-2 control-label">整体主动转向系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p190"></td>
	                              
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">夜视系统</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p173"></td>
	                              <td class="col-md-2 control-label">中控液晶屏分屏显示</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p191"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">自适应巡航</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p174"></td>
	                              
	                              <td class="col-md-2 control-label">全景摄像头</td>
	                              <td class="col-md-4 control-label"><input type="text" class="gkjpz4 form-control input-inline input-medium" id="car4_p175"></td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"class="bg_04" style="background-color: #95a5a6;">车身颜色</td>
	                            </tr>
	                            <tr>
	                              <td colspan="4"><textarea name=""  cols="20" rows="2" id="car4_p200" class="form-control input-inline input-medium"></textarea></td>
	                            </tr>
	                            
							</tbady>
						</table>
					</div>
				</div>
			</div>	
		</div>
		</div>
	</div>
</div>
<input name="catalogId" id="catalogId" value="" style="display:none;">

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function() {
	createTree("车型目录",'treeMenu');
});

function onClick(treeId, treeNode, clickFlag){
	var pId = 0;
	if(clickFlag.pId != null){
		pId = clickFlag.pId
	}
	document.getElementById("catalogId").value=clickFlag.id;
	id=clickFlag.id;
	if(clickFlag.level==0){
		$("#carBrand").show();
		$("#carSeries").hide();
		$("#carType").hide();
		document.getElementById("carData").style.display="none";
		$.getJSON("CarCatalogParameterA",{id:id},function(data){
			var path=data[0].photo;
			
			$("#pic1").attr("src",path);
			document.getElementById("Englishname1").value=data[0].englishname;
            document.getElementById("selA1").value=data[0].islive;
            document.getElementById("selB1").value=data[0].onsale;
            var path1=data[0].carbrandphoto;
            $("#mainphoto").attr("src",path1);
		});
	}else if(clickFlag.level==1){
		$("#carBrand").hide();
		$("#carSeries").show();
		$("#carType").hide();
		document.getElementById("carData").style.display="none";
		$.getJSON("CarCatalogParameterA",{id:id},function(data){
			var path=data[0].photo;
			var path2=data[0].chetuanphoto;
			$("#pic2").attr("src",path);
			$("#mainphoto2").attr("src",path2);
			document.getElementById("Englishname2").value=data[0].englishname;
            document.getElementById("selA2").value=data[0].islive;
            document.getElementById("selB2").value=data[0].onsale;
            document.getElementById("anquan").value= data[0].pengzhuanglevel;
            document.getElementById("baoyan").value= data[0].baoyangfeiyong;
            document.getElementById("carkey").value= data[0].carkey;
            document.getElementById("bad").value= data[0].carInfo.disadvantage;
            document.getElementById("good").value= data[0].carInfo.advantage;
            document.getElementById("qudao1").value= data[0].iway;
            document.getElementById("jibie2").value=data[0].jibie;
            document.getElementById("leixing2").value=data[0].leixing;
		});
	}else if(clickFlag.level==2){
		$("#carBrand").hide();
		$("#carSeries").hide();
		$("#carType").show();
		$.getJSON("CarCatalogParameterA",{id:id},function(data){
		var tname =clickFlag.name;
			var path=data[0].photo;
			
			$("#pic3").attr("src",path);
			document.getElementById("catalogId2").value=clickFlag.id;
			document.getElementById("Englishname3").value=data[0].englishname;
	        document.getElementById("selA3").value=data[0].islive;
	        document.getElementById("selB3").value=data[0].onsale;
	        document.getElementById("iyear").value=data[0].iyear;
	        document.getElementById("xiangti").value=data[0].xiangti;
	        document.getElementById("bsq").value=data[0].bsq;
	        document.getElementById("jibie").value=data[0].jibie;
	        document.getElementById("madein").value=data[0].madein;
	        document.getElementById("leixing").value=data[0].leixing;
	        document.getElementById("fadongji").value=data[0].fadongji;
	        var pl=data[0].pailiang/10;
	        document.getElementById("pailiang").value=pl;
	        document.getElementById("pinpai").value=data[1].p3;
	        document.getElementById("qudao2").value=data[0].iway;
	        if(data[1].p209!=""&&data[1].p209.indexOf("-")==-1){
        	if(data[1].p209=="T"){
        		document.getElementById("p209").value=1;
        	}else if(data[1].p209=="L"){
        		document.getElementById("p209").value=2;
        	}
        	}
	        $("#car_type").val(data[1].car_type);
	        $.getJSON("selectLevel2CarInfo",{catalogId:id},function(data){
				$("#cname").html("<i class='fa fa-cogs'></i>"+tname);
				cartype=data[0].car_type+1;
				for(var i=0;i<$("#carTypesTabNav li ").length;i++){
					var rel=$("#carTypesTabNav li:eq("+i+")").prop("rel");
					$("#"+rel).hide();
				}
				
				$("#d"+cartype).trigger("click");
				$("#car"+cartype+"_p1").val(data[0].p1);
				document.getElementById("carData").style.display="block";
				if(cartype==1){
					$("#car"+cartype+"_p2").val(data[0].p2);
					$("#car"+cartype+"_p192").val(data[0].p192);
					$("#car"+cartype+"_p4").val(data[0].p4);
					$("#car"+cartype+"_p5").val(data[0].p5);
					$("#car"+cartype+"_p6").val(data[0].p6);
					$("#car"+cartype+"_p7").val(data[0].p7);
					$("#car"+cartype+"_p8").val(data[0].p8);
					$("#car"+cartype+"_p9").val(data[0].p9);
					$("#car"+cartype+"_p10").val(data[0].p10);
					$("#car"+cartype+"_p13").val(data[0].p13);
					$("#car"+cartype+"_p11").val(data[0].p11);
					$("#car"+cartype+"_p14").val(data[0].p14);
					$("#car"+cartype+"_p15").val(data[0].p15);
					$("#car"+cartype+"_p193").val(data[0].p193);
					$("#car"+cartype+"_p16").val(data[0].p16);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p177").val(data[0].p177);
					$("#car"+cartype+"_p17").val(data[0].p17);
					$("#car"+cartype+"_p18").val(data[0].p18);
					$("#car"+cartype+"_p19").val(data[0].p19);
					$("#car"+cartype+"_p20").val(data[0].p20);
					$("#car"+cartype+"_p21").val(data[0].p21);
					$("#car"+cartype+"_p22").val(data[0].p22);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p25").val(data[0].p25);
					$("#car"+cartype+"_p26").val(data[0].p26);
					$("#car"+cartype+"_p27").val(data[0].p27);
					$("#car"+cartype+"_p28").val(data[0].p28);
					$("#car"+cartype+"_p29").val(data[0].p29);
					$("#car"+cartype+"_p194").val(data[0].p194);
					$("#car"+cartype+"_p30").val(data[0].p30);
					$("#car"+cartype+"_p31").val(data[0].p31);
					$("#car"+cartype+"_p32").val(data[0].p32);
					$("#car"+cartype+"_p33").val(data[0].p33);
					$("#car"+cartype+"_p34").val(data[0].p34);
					$("#car"+cartype+"_p35").val(data[0].p35);
					$("#car"+cartype+"_p36").val(data[0].p36);
					$("#car"+cartype+"_p37").val(data[0].p37);
					$("#car"+cartype+"_p38").val(data[0].p38);
					$("#car"+cartype+"_p39").val(data[0].p39);
					$("#car"+cartype+"_p40").val(data[0].p40);
					$("#car"+cartype+"_p41").val(data[0].p41);
					$("#car"+cartype+"_p42").val(data[0].p42);
					$("#car"+cartype+"_p43").val(data[0].p43);
					$("#car"+cartype+"_p44").val(data[0].p44);
					$("#car"+cartype+"_p45").val(data[0].p45);
					$("#car"+cartype+"_p46").val(data[0].p46);
					$("#car"+cartype+"_p47").val(data[0].p47);
					$("#car"+cartype+"_p48").val(data[0].p48);
					$("#car"+cartype+"_p49").val(data[0].p49);
					$("#car"+cartype+"_p50").val(data[0].p50);
					$("#car"+cartype+"_p51").val(data[0].p51);
					$("#car"+cartype+"_p52").val(data[0].p52);
					$("#car"+cartype+"_p53").val(data[0].p53);
					$("#car"+cartype+"_p54").val(data[0].p54);
					$("#car"+cartype+"_p55").val(data[0].p55);
					$("#car"+cartype+"_p56").val(data[0].p56);
					$("#car"+cartype+"_p57").val(data[0].p57);
					$("#car"+cartype+"_p58").val(data[0].p58);
					$("#car"+cartype+"_p59").val(data[0].p59);
					$("#car"+cartype+"_p60").val(data[0].p60);
					$("#car"+cartype+"_p61").val(data[0].p61);
					$("#car"+cartype+"_p62").val(data[0].p62);
					$("#car"+cartype+"_p63").val(data[0].p63);
					$("#car"+cartype+"_p64").val(data[0].p64);
					$("#car"+cartype+"_p65").val(data[0].p65);
					$("#car"+cartype+"_p66_p67").val(data[0].p66+"/"+data[0].p67);
					$("#car"+cartype+"_p68_p69").val(data[0].p68+"/"+data[0].p69);
					$("#car"+cartype+"_p70_p71").val(data[0].p70+"/"+data[0].p71);
					$("#car"+cartype+"_p72").val(data[0].p72);
					$("#car"+cartype+"_p87").val(data[0].p87);
					$("#car"+cartype+"_p88").val(data[0].p88);
					$("#car"+cartype+"_p73").val(data[0].p73);
					$("#car"+cartype+"_p198").val(data[0].p198);
					$("#car"+cartype+"_p74").val(data[0].p74);
					$("#car"+cartype+"_p75").val(data[0].p75);
					$("#car"+cartype+"_p76").val(data[0].p76);
					$("#car"+cartype+"_p77").val(data[0].p77);
					$("#car"+cartype+"_p78").val(data[0].p78);
					$("#car"+cartype+"_p79").val(data[0].p79);
					$("#car"+cartype+"_p80").val(data[0].p80);
					$("#car"+cartype+"_p81").val(data[0].p81);
					$("#car"+cartype+"_p82").val(data[0].p82);
					$("#car"+cartype+"_p83").val(data[0].p83);
					$("#car"+cartype+"_p84").val(data[0].p84);
					$("#car"+cartype+"_p85").val(data[0].p85);
					$("#car"+cartype+"_p86").val(data[0].p86);
					$("#car"+cartype+"_p89").val(data[0].p89);
					$("#car"+cartype+"_p90").val(data[0].p90);
					$("#car"+cartype+"_p91").val(data[0].p91);
					$("#car"+cartype+"_p94").val(data[0].p94);
					$("#car"+cartype+"_p95").val(data[0].p95);
					$("#car"+cartype+"_p180").val(data[0].p180);
					$("#car"+cartype+"_p96").val(data[0].p96);
					if(data[0].p97=="●"){
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("上下+左右");
						}else{
							$("#car"+cartype+"_p97_p98").val("上下");
						}
					}else{
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("左右");
						}else{
							
						}
					}
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p99").val(data[0].p99);
					$("#car"+cartype+"_p100").val(data[0].p100);
					$("#car"+cartype+"_p101").val(data[0].p101);
					$("#car"+cartype+"_p103").val(data[0].p103);
					$("#car"+cartype+"_p104").val(data[0].p104);
					$("#car"+cartype+"_p105").val(data[0].p105);
					$("#car"+cartype+"_p107").val(data[0].p107);
					$("#car"+cartype+"_p108").val(data[0].p108);
					$("#car"+cartype+"_p109").val(data[0].p109);
					$("#car"+cartype+"_p110").val(data[0].p110);
					$("#car"+cartype+"_p111").val(data[0].p111);
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p182").val(data[0].p182);
					$("#car"+cartype+"_p195").val(data[0].p195);
					$("#car"+cartype+"_p196").val(data[0].p196);
					$("#car"+cartype+"_p113").val(data[0].p113);
					$("#car"+cartype+"_p114").val(data[0].p114);
					$("#car"+cartype+"_p115_p116").val(data[0].p115+"/"+data[0].p116);
					$("#car"+cartype+"_p117").val(data[0].p117);
					$("#car"+cartype+"_p118").val(data[0].p118);
					if(data[0].p119=="●"){
						$("#car"+cartype+"_p119_p120").val("整体放倒");
					}
					if(data[0].p120=="●"){
						$("#car"+cartype+"_p119_p120").val("比例放倒");
					}
					$("#car"+cartype+"_p121").val(data[0].p121);
					$("#car"+cartype+"_p122_p123").val(data[0].p122+"/"+data[0].p123);
					$("#car"+cartype+"_p125").val(data[0].p125);
					$("#car"+cartype+"_p127").val(data[0].p127);
					$("#car"+cartype+"_p183").val(data[0].p183);
					$("#car"+cartype+"_p128").val(data[0].p128);
					$("#car"+cartype+"_p130").val(data[0].p130);
					$("#car"+cartype+"_p184").val(data[0].p184);
					$("#car"+cartype+"_p132").val(data[0].p132);
					$("#car"+cartype+"_p133").val(data[0].p133);
					$("#car"+cartype+"_p134").val(data[0].p134);
					$("#car"+cartype+"_p135").val(data[0].p135);
					$("#car"+cartype+"_p136").val(data[0].p136);
					if(data[0].p137=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟CD");
					}
					if(data[0].p138=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟CD系统");
					}
					if(data[0].p139=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟DVD");
					}
					if(data[0].p140=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟DVD系统");
					}
					if(data[0].p141=="●"){
						$("#car"+cartype+"_p141_p144").val("2-3喇叭扬声器系统");
					}
					if(data[0].p142=="●"){
						$("#car"+cartype+"_p141_p144").val("4-5喇叭扬声器系统");
					}
					if(data[0].p143=="●"){
						$("#car"+cartype+"_p141_p144").val("6-7喇叭扬声器系统");
					}
					if(data[0].p144=="●"){
						$("#car"+cartype+"_p141_p144").val("≥8喇叭扬声器系统");
					}
					$("#car"+cartype+"_p145").val(data[0].p145);
					$("#car"+cartype+"_p146").val(data[0].p146);
					$("#car"+cartype+"_p147").val(data[0].p147);
					$("#car"+cartype+"_p148").val(data[0].p148);
					$("#car"+cartype+"_p149").val(data[0].p149);
					$("#car"+cartype+"_p151").val(data[0].p151);
					$("#car"+cartype+"_p152").val(data[0].p152);
					$("#car"+cartype+"_p186").val(data[0].p186);
					$("#car"+cartype+"_p153_p154").val(data[0].p153+"/"+data[0].p154);
					$("#car"+cartype+"_p155").val(data[0].p155);
					$("#car"+cartype+"_p187").val(data[0].p187);
					$("#car"+cartype+"_p156").val(data[0].p156);
					$("#car"+cartype+"_p157").val(data[0].p157);
					$("#car"+cartype+"_p158").val(data[0].p158);
					$("#car"+cartype+"_p159").val(data[0].p159);
					$("#car"+cartype+"_p197").val(data[0].p197);
					$("#car"+cartype+"_p160").val(data[0].p160);
					$("#car"+cartype+"_p161").val(data[0].p161);
					$("#car"+cartype+"_p162").val(data[0].p162);
					$("#car"+cartype+"_p188").val(data[0].p188);
					$("#car"+cartype+"_p163").val(data[0].p163);
					$("#car"+cartype+"_p164").val(data[0].p164);
					$("#car"+cartype+"_p166").val(data[0].p166);
					$("#car"+cartype+"_p167").val(data[0].p167);
					$("#car"+cartype+"_p168").val(data[0].p168);
					$("#car"+cartype+"_p169").val(data[0].p169);
					$("#car"+cartype+"_p170").val(data[0].p170);
					$("#car"+cartype+"_p171").val(data[0].p171);
					$("#car"+cartype+"_p172").val(data[0].p172);
					$("#car"+cartype+"_p189").val(data[0].p189);
					$("#car"+cartype+"_p190").val(data[0].p190);
					$("#car"+cartype+"_p173").val(data[0].p173);
					$("#car"+cartype+"_p191").val(data[0].p191);
					$("#car"+cartype+"_p174").val(data[0].p174);
					$("#car"+cartype+"_p175").val(data[0].p175);
					$("#car"+cartype+"_p200").val(data[0].p200);
				}else if(cartype==2){
					$("#car"+cartype+"_p2").val(data[0].p2);
					$("#car"+cartype+"_p192").val(data[0].p192);
					$("#car"+cartype+"_p4").val(data[0].p4);
					$("#car"+cartype+"_p5").val(data[0].p5);
					$("#car"+cartype+"_p6").val(data[0].p6);
					$("#car"+cartype+"_p7").val(data[0].p7);
					$("#car"+cartype+"_p8").val(data[0].p8);
					$("#car"+cartype+"_p193").val(data[0].p193);
					$("#car"+cartype+"_p16").val(data[0].p16);
					$("#car"+cartype+"_p17").val(data[0].p17);
					$("#car"+cartype+"_p18").val(data[0].p18);
					$("#car"+cartype+"_p19").val(data[0].p19);
					$("#car"+cartype+"_p20").val(data[0].p20);
					$("#car"+cartype+"_p21").val(data[0].p21);
					$("#car"+cartype+"_p22").val(data[0].p22);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p25").val(data[0].p25);
					$("#car"+cartype+"_p26").val(data[0].p26);
					$("#car"+cartype+"_p27").val(data[0].p27);
					$("#car"+cartype+"_p201").val(data[0].p201);
					$("#car"+cartype+"_p202").val(data[0].p202);
					$("#car"+cartype+"_p203").val(data[0].p203);
					
					$("#car"+cartype+"_p52").val(data[0].p52);
					$("#car"+cartype+"_p53").val(data[0].p53);
					$("#car"+cartype+"_p54").val(data[0].p54);
					$("#car"+cartype+"_p55").val(data[0].p55);
					$("#car"+cartype+"_p56").val(data[0].p56);
					$("#car"+cartype+"_p57").val(data[0].p57);
					$("#car"+cartype+"_p58").val(data[0].p58);
					$("#car"+cartype+"_p59").val(data[0].p59);
					$("#car"+cartype+"_p60").val(data[0].p60);
					$("#car"+cartype+"_p61").val(data[0].p61);
					$("#car"+cartype+"_p63").val(data[0].p63);
					$("#car"+cartype+"_p64").val(data[0].p64);
					$("#car"+cartype+"_p194").val(data[0].p194);
					$("#car"+cartype+"_p30").val(data[0].p30);
					$("#car"+cartype+"_p31").val(data[0].p31);
					$("#car"+cartype+"_p32").val(data[0].p32);
					$("#car"+cartype+"_p33").val(data[0].p33);
					$("#car"+cartype+"_p34").val(data[0].p34);
					$("#car"+cartype+"_p35").val(data[0].p35);
					$("#car"+cartype+"_p36").val(data[0].p36);
					$("#car"+cartype+"_p37").val(data[0].p37);
					$("#car"+cartype+"_p38").val(data[0].p38);
					$("#car"+cartype+"_p39").val(data[0].p39);
					$("#car"+cartype+"_p40").val(data[0].p40);
					$("#car"+cartype+"_p41").val(data[0].p41);
					$("#car"+cartype+"_p42").val(data[0].p42);
					$("#car"+cartype+"_p43").val(data[0].p43);
					$("#car"+cartype+"_p44").val(data[0].p44);
					$("#car"+cartype+"_p46").val(data[0].p46);
					$("#car"+cartype+"_p47").val(data[0].p47);
					$("#car"+cartype+"_p48").val(data[0].p48);
					$("#car"+cartype+"_p49").val(data[0].p49);
					$("#car"+cartype+"_p50").val(data[0].p50);
					$("#car"+cartype+"_p51").val(data[0].p51);
					$("#car"+cartype+"_p66_p67").val(data[0].p66+"/"+data[0].p67);
					$("#car"+cartype+"_p68_p69").val(data[0].p68+"/"+data[0].p69);
					$("#car"+cartype+"_p74").val(data[0].p74);
					$("#car"+cartype+"_p75").val(data[0].p75);
					$("#car"+cartype+"_p76").val(data[0].p76);
					$("#car"+cartype+"_p78").val(data[0].p78);
					$("#car"+cartype+"_p79").val(data[0].p79);
					$("#car"+cartype+"_p80").val(data[0].p80);
					$("#car"+cartype+"_p81").val(data[0].p81);
					$("#car"+cartype+"_p82").val(data[0].p82);
					$("#car"+cartype+"_p90").val(data[0].p90);
					$("#car"+cartype+"_p91").val(data[0].p91);
					$("#car"+cartype+"_p95").val(data[0].p95);
					$("#car"+cartype+"_p96").val(data[0].p96);
					$("#car"+cartype+"_p99").val(data[0].p99);
					$("#car"+cartype+"_p204").val(data[0].p204);
					$("#car"+cartype+"_p101").val(data[0].p101);
					$("#car"+cartype+"_p103").val(data[0].p103);
					$("#car"+cartype+"_p104").val(data[0].p104);
					$("#car"+cartype+"_p107").val(data[0].p107);
					$("#car"+cartype+"_p108").val(data[0].p108);
					$("#car"+cartype+"_p109").val(data[0].p109);
					$("#car"+cartype+"_p110").val(data[0].p110);
					$("#car"+cartype+"_p111").val(data[0].p111);
					$("#car"+cartype+"_p195").val(data[0].p195);
					$("#car"+cartype+"_p196").val(data[0].p196);
					$("#car"+cartype+"_p115").val(data[0].p115);
					if(data[0].p119=="●"){
						$("#car"+cartype+"_p119_p120").val("整体放倒");
					}
					if(data[0].p120=="●"){
						$("#car"+cartype+"_p119_p120").val("比例放倒");
					}
					$("#car"+cartype+"_p122").val(data[0].p122);
					$("#car"+cartype+"_p127").val(data[0].p127);
					$("#car"+cartype+"_p128").val(data[0].p128);
					$("#car"+cartype+"_p132").val(data[0].p132);
					$("#car"+cartype+"_p134").val(data[0].p134);
					$("#car"+cartype+"_p135").val(data[0].p135);
					if(data[0].p137=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟CD");
					}
					if(data[0].p138=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟CD系统");
					}
					if(data[0].p139=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟DVD");
					}
					if(data[0].p140=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟DVD系统");
					}
					if(data[0].p141=="●"){
						$("#car"+cartype+"_p141_p144").val("2-3喇叭扬声器系统");
					}
					if(data[0].p142=="●"){
						$("#car"+cartype+"_p141_p144").val("4-5喇叭扬声器系统");
					}
					if(data[0].p143=="●"){
						$("#car"+cartype+"_p141_p144").val("6-7喇叭扬声器系统");
					}
					if(data[0].p144=="●"){
						$("#car"+cartype+"_p141_p144").val("≥8喇叭扬声器系统");
					}
					$("#car"+cartype+"_p145").val(data[0].p145);
					$("#car"+cartype+"_p149").val(data[0].p149);
					$("#car"+cartype+"_p151").val(data[0].p151);
					$("#car"+cartype+"_p153_p154").val(data[0].p153+"/"+data[0].p154);
					$("#car"+cartype+"_p156").val(data[0].p156);
					$("#car"+cartype+"_p157").val(data[0].p157);
					$("#car"+cartype+"_p160").val(data[0].p160);
					$("#car"+cartype+"_p161").val(data[0].p161);
					$("#car"+cartype+"_p188").val(data[0].p188);
					$("#car"+cartype+"_p164").val(data[0].p164);
					$("#car"+cartype+"_p166").val(data[0].p166);
					$("#car"+cartype+"_p167").val(data[0].p167);
					$("#car"+cartype+"_p168").val(data[0].p168);
					$("#car"+cartype+"_p169").val(data[0].p169);
					$("#car"+cartype+"_p200").val(data[0].p200);
				}else if(cartype==3){
					$("#car"+cartype+"_p2").val(data[0].p2);
					$("#car"+cartype+"_p192").val(data[0].p192);
					$("#car"+cartype+"_p4").val(data[0].p4);
					$("#car"+cartype+"_p5").val(data[0].p5);
					$("#car"+cartype+"_p6").val(data[0].p6);
					$("#car"+cartype+"_p7").val(data[0].p7);
					$("#car"+cartype+"_p8").val(data[0].p8);
					$("#car"+cartype+"_p9").val(data[0].p9);
					$("#car"+cartype+"_p10").val(data[0].p10);
					$("#car"+cartype+"_p13").val(data[0].p13);
					$("#car"+cartype+"_p11").val(data[0].p11);
					$("#car"+cartype+"_p14").val(data[0].p14);
					$("#car"+cartype+"_p15").val(data[0].p15);
					$("#car"+cartype+"_p193").val(data[0].p193);
					$("#car"+cartype+"_p16").val(data[0].p16);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p177").val(data[0].p177);
					$("#car"+cartype+"_p17").val(data[0].p17);
					$("#car"+cartype+"_p18").val(data[0].p18);
					$("#car"+cartype+"_p19").val(data[0].p19);
					$("#car"+cartype+"_p20").val(data[0].p20);
					$("#car"+cartype+"_p21").val(data[0].p21);
					$("#car"+cartype+"_p22").val(data[0].p22);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p25").val(data[0].p25);
					$("#car"+cartype+"_p26").val(data[0].p26);
					$("#car"+cartype+"_p27").val(data[0].p27);
					$("#car"+cartype+"_p28").val(data[0].p28);
					$("#car"+cartype+"_p29").val(data[0].p29);
					$("#car"+cartype+"_p194").val(data[0].p194);
					$("#car"+cartype+"_p30").val(data[0].p30);
					$("#car"+cartype+"_p31").val(data[0].p31);
					$("#car"+cartype+"_p32").val(data[0].p32);
					$("#car"+cartype+"_p33").val(data[0].p33);
					$("#car"+cartype+"_p34").val(data[0].p34);
					$("#car"+cartype+"_p35").val(data[0].p35);
					$("#car"+cartype+"_p36").val(data[0].p36);
					$("#car"+cartype+"_p37").val(data[0].p37);
					$("#car"+cartype+"_p38").val(data[0].p38);
					$("#car"+cartype+"_p39").val(data[0].p39);
					$("#car"+cartype+"_p40").val(data[0].p40);
					$("#car"+cartype+"_p41").val(data[0].p41);
					$("#car"+cartype+"_p42").val(data[0].p42);
					$("#car"+cartype+"_p43").val(data[0].p43);
					$("#car"+cartype+"_p44").val(data[0].p44);
					$("#car"+cartype+"_p45").val(data[0].p45);
					$("#car"+cartype+"_p46").val(data[0].p46);
					$("#car"+cartype+"_p47").val(data[0].p47);
					$("#car"+cartype+"_p48").val(data[0].p48);
					$("#car"+cartype+"_p49").val(data[0].p49);
					$("#car"+cartype+"_p50").val(data[0].p50);
					$("#car"+cartype+"_p51").val(data[0].p51);
					$("#car"+cartype+"_p52").val(data[0].p52);
					$("#car"+cartype+"_p205").val(data[0].p205);
					$("#car"+cartype+"_p206").val(data[0].p206);
					$("#car"+cartype+"_p207").val(data[0].p207);
					$("#car"+cartype+"_p208").val(data[0].p208);
					$("#car"+cartype+"_p53").val(data[0].p53);
					$("#car"+cartype+"_p54").val(data[0].p54);
					$("#car"+cartype+"_p55").val(data[0].p55);
					$("#car"+cartype+"_p56").val(data[0].p56);
					$("#car"+cartype+"_p57").val(data[0].p57);
					$("#car"+cartype+"_p58").val(data[0].p58);
					$("#car"+cartype+"_p59").val(data[0].p59);
					$("#car"+cartype+"_p60").val(data[0].p60);
					$("#car"+cartype+"_p61").val(data[0].p61);
					$("#car"+cartype+"_p62").val(data[0].p62);
					$("#car"+cartype+"_p63").val(data[0].p63);
					$("#car"+cartype+"_p64").val(data[0].p64);
					$("#car"+cartype+"_p65").val(data[0].p65);
					$("#car"+cartype+"_p66_p67").val(data[0].p66+"/"+data[0].p67);
					$("#car"+cartype+"_p68_p69").val(data[0].p68+"/"+data[0].p69);
					$("#car"+cartype+"_p70_p71").val(data[0].p70+"/"+data[0].p71);
					$("#car"+cartype+"_p72").val(data[0].p72);
					$("#car"+cartype+"_p87").val(data[0].p87);
					$("#car"+cartype+"_p88").val(data[0].p88);
					$("#car"+cartype+"_p73").val(data[0].p73);
					$("#car"+cartype+"_p198").val(data[0].p198);
					$("#car"+cartype+"_p74").val(data[0].p74);
					$("#car"+cartype+"_p75").val(data[0].p75);
					$("#car"+cartype+"_p76").val(data[0].p76);
					$("#car"+cartype+"_p77").val(data[0].p77);
					$("#car"+cartype+"_p78").val(data[0].p78);
					$("#car"+cartype+"_p79").val(data[0].p79);
					$("#car"+cartype+"_p80").val(data[0].p80);
					$("#car"+cartype+"_p81").val(data[0].p81);
					$("#car"+cartype+"_p82").val(data[0].p82);
					$("#car"+cartype+"_p83").val(data[0].p83);
					$("#car"+cartype+"_p84").val(data[0].p84);
					$("#car"+cartype+"_p85").val(data[0].p85);
					$("#car"+cartype+"_p86").val(data[0].p86);
					$("#car"+cartype+"_p89").val(data[0].p89);
					$("#car"+cartype+"_p90").val(data[0].p90);
					$("#car"+cartype+"_p91").val(data[0].p91);
					$("#car"+cartype+"_p94").val(data[0].p94);
					$("#car"+cartype+"_p95").val(data[0].p95);
					$("#car"+cartype+"_p180").val(data[0].p180);
					$("#car"+cartype+"_p96").val(data[0].p96);
					if(data[0].p97=="●"){
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("上下+左右");
						}else{
							$("#car"+cartype+"_p97_p98").val("上下");
						}
					}else{
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("左右");
						}else{
							
						}
					}
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p99").val(data[0].p99);
					$("#car"+cartype+"_p100").val(data[0].p100);
					$("#car"+cartype+"_p101").val(data[0].p101);
					$("#car"+cartype+"_p103").val(data[0].p103);
					$("#car"+cartype+"_p104").val(data[0].p104);
					$("#car"+cartype+"_p105").val(data[0].p105);
					$("#car"+cartype+"_p107").val(data[0].p107);
					$("#car"+cartype+"_p108").val(data[0].p108);
					$("#car"+cartype+"_p109").val(data[0].p109);
					$("#car"+cartype+"_p110").val(data[0].p110);
					$("#car"+cartype+"_p111").val(data[0].p111);
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p182").val(data[0].p182);
					$("#car"+cartype+"_p195").val(data[0].p195);
					$("#car"+cartype+"_p196").val(data[0].p196);
					$("#car"+cartype+"_p113").val(data[0].p113);
					$("#car"+cartype+"_p114").val(data[0].p114);
					$("#car"+cartype+"_p115_p116").val(data[0].p115+"/"+data[0].p116);
					$("#car"+cartype+"_p117").val(data[0].p117);
					$("#car"+cartype+"_p118").val(data[0].p118);
					if(data[0].p119=="●"){
						$("#car"+cartype+"_p119_p120").val("整体放倒");
					}
					if(data[0].p120=="●"){
						$("#car"+cartype+"_p119_p120").val("比例放倒");
					}
					$("#car"+cartype+"_p121").val(data[0].p121);
					$("#car"+cartype+"_p122_p123").val(data[0].p122+"/"+data[0].p123);
					$("#car"+cartype+"_p125").val(data[0].p125);
					$("#car"+cartype+"_p127").val(data[0].p127);
					$("#car"+cartype+"_p183").val(data[0].p183);
					$("#car"+cartype+"_p128").val(data[0].p128);
					$("#car"+cartype+"_p130").val(data[0].p130);
					$("#car"+cartype+"_p184").val(data[0].p184);
					$("#car"+cartype+"_p132").val(data[0].p132);
					$("#car"+cartype+"_p133").val(data[0].p133);
					$("#car"+cartype+"_p134").val(data[0].p134);
					$("#car"+cartype+"_p135").val(data[0].p135);
					$("#car"+cartype+"_p136").val(data[0].p136);
					if(data[0].p137=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟CD");
					}
					if(data[0].p138=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟CD系统");
					}
					if(data[0].p139=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟DVD");
					}
					if(data[0].p140=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟DVD系统");
					}
					if(data[0].p141=="●"){
						$("#car"+cartype+"_p141_p144").val("2-3喇叭扬声器系统");
					}
					if(data[0].p142=="●"){
						$("#car"+cartype+"_p141_p144").val("4-5喇叭扬声器系统");
					}
					if(data[0].p143=="●"){
						$("#car"+cartype+"_p141_p144").val("6-7喇叭扬声器系统");
					}
					if(data[0].p144=="●"){
						$("#car"+cartype+"_p141_p144").val("≥8喇叭扬声器系统");
					}
					$("#car"+cartype+"_p145").val(data[0].p145);
					$("#car"+cartype+"_p146").val(data[0].p146);
					$("#car"+cartype+"_p147").val(data[0].p147);
					$("#car"+cartype+"_p148").val(data[0].p148);
					$("#car"+cartype+"_p149").val(data[0].p149);
					$("#car"+cartype+"_p151").val(data[0].p151);
					$("#car"+cartype+"_p152").val(data[0].p152);
					$("#car"+cartype+"_p186").val(data[0].p186);
					$("#car"+cartype+"_p153_p154").val(data[0].p153+"/"+data[0].p154);
					$("#car"+cartype+"_p155").val(data[0].p155);
					$("#car"+cartype+"_p187").val(data[0].p187);
					$("#car"+cartype+"_p156").val(data[0].p156);
					$("#car"+cartype+"_p157").val(data[0].p157);
					$("#car"+cartype+"_p158").val(data[0].p158);
					$("#car"+cartype+"_p159").val(data[0].p159);
					$("#car"+cartype+"_p197").val(data[0].p197);
					$("#car"+cartype+"_p160").val(data[0].p160);
					$("#car"+cartype+"_p161").val(data[0].p161);
					$("#car"+cartype+"_p162").val(data[0].p162);
					$("#car"+cartype+"_p188").val(data[0].p188);
					$("#car"+cartype+"_p163").val(data[0].p163);
					$("#car"+cartype+"_p164").val(data[0].p164);
					$("#car"+cartype+"_p166").val(data[0].p166);
					$("#car"+cartype+"_p167").val(data[0].p167);
					$("#car"+cartype+"_p168").val(data[0].p168);
					$("#car"+cartype+"_p169").val(data[0].p169);
					$("#car"+cartype+"_p170").val(data[0].p170);
					$("#car"+cartype+"_p171").val(data[0].p171);
					$("#car"+cartype+"_p172").val(data[0].p172);
					$("#car"+cartype+"_p189").val(data[0].p189);
					$("#car"+cartype+"_p190").val(data[0].p190);
					$("#car"+cartype+"_p173").val(data[0].p173);
					$("#car"+cartype+"_p191").val(data[0].p191);
					$("#car"+cartype+"_p174").val(data[0].p174);
					$("#car"+cartype+"_p175").val(data[0].p175);
					$("#car"+cartype+"_p200").val(data[0].p200);
				}else if(cartype==4){
					$("#car"+cartype+"_p2").val(data[0].p2);
					$("#car"+cartype+"_p192").val(data[0].p192);
					$("#car"+cartype+"_p4").val(data[0].p4);
					$("#car"+cartype+"_p5").val(data[0].p5);
					$("#car"+cartype+"_p6").val(data[0].p6);
					$("#car"+cartype+"_p7").val(data[0].p7);
					$("#car"+cartype+"_p8").val(data[0].p8);
					$("#car"+cartype+"_p9").val(data[0].p9);
					$("#car"+cartype+"_p10").val(data[0].p10);
					$("#car"+cartype+"_p13").val(data[0].p13);
					$("#car"+cartype+"_p11").val(data[0].p11);
					$("#car"+cartype+"_p14").val(data[0].p14);
					$("#car"+cartype+"_p15").val(data[0].p15);
					$("#car"+cartype+"_p193").val(data[0].p193);
					$("#car"+cartype+"_p16").val(data[0].p16);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p177").val(data[0].p177);
					$("#car"+cartype+"_p17").val(data[0].p17);
					$("#car"+cartype+"_p18").val(data[0].p18);
					$("#car"+cartype+"_p19").val(data[0].p19);
					$("#car"+cartype+"_p20").val(data[0].p20);
					$("#car"+cartype+"_p21").val(data[0].p21);
					$("#car"+cartype+"_p22").val(data[0].p22);
					$("#car"+cartype+"_p23").val(data[0].p23);
					$("#car"+cartype+"_p24").val(data[0].p24);
					$("#car"+cartype+"_p25").val(data[0].p25);
					$("#car"+cartype+"_p26").val(data[0].p26);
					$("#car"+cartype+"_p27").val(data[0].p27);
					$("#car"+cartype+"_p28").val(data[0].p28);
					$("#car"+cartype+"_p29").val(data[0].p29);
					$("#car"+cartype+"_p194").val(data[0].p194);
					$("#car"+cartype+"_p30").val(data[0].p30);
					$("#car"+cartype+"_p31").val(data[0].p31);
					$("#car"+cartype+"_p32").val(data[0].p32);
					$("#car"+cartype+"_p33").val(data[0].p33);
					$("#car"+cartype+"_p34").val(data[0].p34);
					$("#car"+cartype+"_p35").val(data[0].p35);
					$("#car"+cartype+"_p36").val(data[0].p36);
					$("#car"+cartype+"_p37").val(data[0].p37);
					$("#car"+cartype+"_p38").val(data[0].p38);
					$("#car"+cartype+"_p39").val(data[0].p39);
					$("#car"+cartype+"_p40").val(data[0].p40);
					$("#car"+cartype+"_p41").val(data[0].p41);
					$("#car"+cartype+"_p42").val(data[0].p42);
					$("#car"+cartype+"_p43").val(data[0].p43);
					$("#car"+cartype+"_p44").val(data[0].p44);
					$("#car"+cartype+"_p45").val(data[0].p45);
					$("#car"+cartype+"_p46").val(data[0].p46);
					$("#car"+cartype+"_p47").val(data[0].p47);
					$("#car"+cartype+"_p48").val(data[0].p48);
					$("#car"+cartype+"_p49").val(data[0].p49);
					$("#car"+cartype+"_p50").val(data[0].p50);
					$("#car"+cartype+"_p51").val(data[0].p51);
					$("#car"+cartype+"_p205").val(data[0].p205);
					$("#car"+cartype+"_p206").val(data[0].p206);
					$("#car"+cartype+"_p207").val(data[0].p207);
					$("#car"+cartype+"_p208").val(data[0].p208);
					$("#car"+cartype+"_p52").val(data[0].p52);
					$("#car"+cartype+"_p53").val(data[0].p53);
					$("#car"+cartype+"_p54").val(data[0].p54);
					$("#car"+cartype+"_p55").val(data[0].p55);
					$("#car"+cartype+"_p56").val(data[0].p56);
					$("#car"+cartype+"_p57").val(data[0].p57);
					$("#car"+cartype+"_p58").val(data[0].p58);
					$("#car"+cartype+"_p59").val(data[0].p59);
					$("#car"+cartype+"_p60").val(data[0].p60);
					$("#car"+cartype+"_p61").val(data[0].p61);
					$("#car"+cartype+"_p62").val(data[0].p62);
					$("#car"+cartype+"_p63").val(data[0].p63);
					$("#car"+cartype+"_p64").val(data[0].p64);
					$("#car"+cartype+"_p65").val(data[0].p65);
					$("#car"+cartype+"_p66_p67").val(data[0].p66+"/"+data[0].p67);
					$("#car"+cartype+"_p68_p69").val(data[0].p68+"/"+data[0].p69);
					$("#car"+cartype+"_p70_p71").val(data[0].p70+"/"+data[0].p71);
					$("#car"+cartype+"_p72").val(data[0].p72);
					$("#car"+cartype+"_p87").val(data[0].p87);
					$("#car"+cartype+"_p88").val(data[0].p88);
					$("#car"+cartype+"_p73").val(data[0].p73);
					$("#car"+cartype+"_p198").val(data[0].p198);
					$("#car"+cartype+"_p74").val(data[0].p74);
					$("#car"+cartype+"_p75").val(data[0].p75);
					$("#car"+cartype+"_p76").val(data[0].p76);
					$("#car"+cartype+"_p77").val(data[0].p77);
					$("#car"+cartype+"_p78").val(data[0].p78);
					$("#car"+cartype+"_p79").val(data[0].p79);
					$("#car"+cartype+"_p80").val(data[0].p80);
					$("#car"+cartype+"_p81").val(data[0].p81);
					$("#car"+cartype+"_p82").val(data[0].p82);
					$("#car"+cartype+"_p83").val(data[0].p83);
					$("#car"+cartype+"_p84").val(data[0].p84);
					$("#car"+cartype+"_p85").val(data[0].p85);
					$("#car"+cartype+"_p86").val(data[0].p86);
					$("#car"+cartype+"_p89").val(data[0].p89);
					$("#car"+cartype+"_p90").val(data[0].p90);
					$("#car"+cartype+"_p91").val(data[0].p91);
					$("#car"+cartype+"_p94").val(data[0].p94);
					$("#car"+cartype+"_p95").val(data[0].p95);
					$("#car"+cartype+"_p180").val(data[0].p180);
					$("#car"+cartype+"_p96").val(data[0].p96);
					if(data[0].p97=="●"){
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("上下+左右");
						}else{
							$("#car"+cartype+"_p97_p98").val("上下");
						}
					}else{
						if(data[0].p98=="●"){
							$("#car"+cartype+"_p97_p98").val("左右");
						}else{
							
						}
					}
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p99").val(data[0].p99);
					$("#car"+cartype+"_p100").val(data[0].p100);
					$("#car"+cartype+"_p101").val(data[0].p101);
					$("#car"+cartype+"_p103").val(data[0].p103);
					$("#car"+cartype+"_p104").val(data[0].p104);
					$("#car"+cartype+"_p105").val(data[0].p105);
					$("#car"+cartype+"_p107").val(data[0].p107);
					$("#car"+cartype+"_p108").val(data[0].p108);
					$("#car"+cartype+"_p109").val(data[0].p109);
					$("#car"+cartype+"_p110").val(data[0].p110);
					$("#car"+cartype+"_p111").val(data[0].p111);
					$("#car"+cartype+"_p181").val(data[0].p181);
					$("#car"+cartype+"_p182").val(data[0].p182);
					$("#car"+cartype+"_p195").val(data[0].p195);
					$("#car"+cartype+"_p196").val(data[0].p196);
					$("#car"+cartype+"_p113").val(data[0].p113);
					$("#car"+cartype+"_p114").val(data[0].p114);
					$("#car"+cartype+"_p115_p116").val(data[0].p115+"/"+data[0].p116);
					$("#car"+cartype+"_p117").val(data[0].p117);
					$("#car"+cartype+"_p118").val(data[0].p118);
					if(data[0].p119=="●"){
						$("#car"+cartype+"_p119_p120").val("整体放倒");
					}
					if(data[0].p120=="●"){
						$("#car"+cartype+"_p119_p120").val("比例放倒");
					}
					$("#car"+cartype+"_p121").val(data[0].p121);
					$("#car"+cartype+"_p122_p123").val(data[0].p122+"/"+data[0].p123);
					$("#car"+cartype+"_p125").val(data[0].p125);
					$("#car"+cartype+"_p127").val(data[0].p127);
					$("#car"+cartype+"_p183").val(data[0].p183);
					$("#car"+cartype+"_p128").val(data[0].p128);
					$("#car"+cartype+"_p130").val(data[0].p130);
					$("#car"+cartype+"_p184").val(data[0].p184);
					$("#car"+cartype+"_p132").val(data[0].p132);
					$("#car"+cartype+"_p133").val(data[0].p133);
					$("#car"+cartype+"_p134").val(data[0].p134);
					$("#car"+cartype+"_p135").val(data[0].p135);
					$("#car"+cartype+"_p136").val(data[0].p136);
					if(data[0].p137=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟CD");
					}
					if(data[0].p138=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟CD系统");
					}
					if(data[0].p139=="●"){
						$("#car"+cartype+"_p137_p140").val("单碟DVD");
					}
					if(data[0].p140=="●"){
						$("#car"+cartype+"_p137_p140").val("多碟DVD系统");
					}
					if(data[0].p141=="●"){
						$("#car"+cartype+"_p141_p144").val("2-3喇叭扬声器系统");
					}
					if(data[0].p142=="●"){
						$("#car"+cartype+"_p141_p144").val("4-5喇叭扬声器系统");
					}
					if(data[0].p143=="●"){
						$("#car"+cartype+"_p141_p144").val("6-7喇叭扬声器系统");
					}
					if(data[0].p144=="●"){
						$("#car"+cartype+"_p141_p144").val("≥8喇叭扬声器系统");
					}
					$("#car"+cartype+"_p145").val(data[0].p145);
					$("#car"+cartype+"_p146").val(data[0].p146);
					$("#car"+cartype+"_p147").val(data[0].p147);
					$("#car"+cartype+"_p148").val(data[0].p148);
					$("#car"+cartype+"_p149").val(data[0].p149);
					$("#car"+cartype+"_p151").val(data[0].p151);
					$("#car"+cartype+"_p152").val(data[0].p152);
					$("#car"+cartype+"_p186").val(data[0].p186);
					$("#car"+cartype+"_p153_p154").val(data[0].p153+"/"+data[0].p154);
					$("#car"+cartype+"_p155").val(data[0].p155);
					$("#car"+cartype+"_p187").val(data[0].p187);
					$("#car"+cartype+"_p156").val(data[0].p156);
					$("#car"+cartype+"_p157").val(data[0].p157);
					$("#car"+cartype+"_p158").val(data[0].p158);
					$("#car"+cartype+"_p159").val(data[0].p159);
					$("#car"+cartype+"_p197").val(data[0].p197);
					$("#car"+cartype+"_p160").val(data[0].p160);
					$("#car"+cartype+"_p161").val(data[0].p161);
					$("#car"+cartype+"_p162").val(data[0].p162);
					$("#car"+cartype+"_p188").val(data[0].p188);
					$("#car"+cartype+"_p163").val(data[0].p163);
					$("#car"+cartype+"_p164").val(data[0].p164);
					$("#car"+cartype+"_p166").val(data[0].p166);
					$("#car"+cartype+"_p167").val(data[0].p167);
					$("#car"+cartype+"_p168").val(data[0].p168);
					$("#car"+cartype+"_p169").val(data[0].p169);
					$("#car"+cartype+"_p170").val(data[0].p170);
					$("#car"+cartype+"_p171").val(data[0].p171);
					$("#car"+cartype+"_p172").val(data[0].p172);
					$("#car"+cartype+"_p189").val(data[0].p189);
					$("#car"+cartype+"_p190").val(data[0].p190);
					$("#car"+cartype+"_p173").val(data[0].p173);
					$("#car"+cartype+"_p191").val(data[0].p191);
					$("#car"+cartype+"_p174").val(data[0].p174);
					$("#car"+cartype+"_p175").val(data[0].p175);
					$("#car"+cartype+"_p200").val(data[0].p200);
				}
			
			});
		});
	}
	
}

function SaveA(){
	var id=document.getElementById("catalogId").value;
	var islive=document.getElementById("selA1");
	var onsale=document.getElementById("selB1");
	var eName=document.getElementById("Englishname1").value;
	var photo=document.getElementById("imagePath1").value;
	var mainphoto=$("#mainphoto1").val();
	var live;
	var sale;
	for(var i=0;i<islive.options.length;i++){
		if(islive.options[i].selected){
			live=islive.options[i].value;
			break;
		}
	}
	for(var i=0;i<onsale.options.length;i++){
		if(onsale.options[i].selected){
			sale=onsale.options[i].value;
			break;
		}
	}
	if(photo.length>0){
		$.post("SaveA",{id:id,
			live:live,
			sale:sale,
			photo:photo,
			mainphoto:mainphoto,
			eName:eName},function(data){
				if(data==1){
				alert("更新成功");
			}else{
				alert("更新失败，请再次尝试");
			}
		});
		
	}else{
		$.post("SaveA",{id:id,
			live:live,
			sale:sale,
			mainphoto:mainphoto,
			eName:eName},function(data){
				if(data==1){
				alert("更新成功");
			}else{
				alert("更新失败，请再次尝试");
			}
		});
	}
}

function SaveB(){
	var id=document.getElementById("catalogId").value;
	var islive=document.getElementById("selA2");
	var onsale=document.getElementById("selB2");
	var eName=document.getElementById("Englishname2").value;
	var carkey=document.getElementById("carkey").value;
	var pengzhuanglevel=document.getElementById("anquan").value;
	var baoyangfeiyong=document.getElementById("baoyan").value;
	var disadvantage=document.getElementById("bad").value;
    var advantage=document.getElementById("good").value;
    var photo=document.getElementById("imagePath2").value;
    var chetuanphoto=document.getElementById("mainphoto12").value;
	var live;
	var sale;
	for(var i=0;i<islive.options.length;i++){
		if(islive.options[i].selected){
			live=islive.options[i].value;
			break;
		}
	}
	for(var i=0;i<onsale.options.length;i++){
		if(onsale.options[i].selected){
			sale=onsale.options[i].value;
			break;
		}
	}
	var leixing=$("#leixing2").val();
	var jibie=$("#jibie2").val();
	var qudao=document.getElementById("qudao1").value;
	if(!qudao && typeof(qudao)!="undefined"){
		alert("请填写渠道！");
		return;
	}
	$.post("SaveB",{id:id,
	live:live,
	sale:sale,
	eName:eName,
	carkey:carkey,
	leixing:leixing,
	jibie:jibie,
	pengzhuanglevel:pengzhuanglevel,
	baoyangfeiyong:baoyangfeiyong,
	disadvantage:disadvantage,
	photo:photo,
	chetuanphoto:chetuanphoto,
	advantage:advantage,
	qudao:qudao},function(data){
		if(data==1){
			alert("更新成功");
		}else{
			alert("更新失败，请再次尝试");
		}
	});
}

function SaveC(){
	var id=document.getElementById("catalogId").value;
	var eName=document.getElementById("Englishname3").value;
    var islive=document.getElementById("selA3");
    var onsale= document.getElementById("selB3");
    var photo=document.getElementById("imagePath3").value;
    var live;
	var sale;
	var iyear;
	var xiangti;
	var bsq;
	var jibie;
	var madein;
	var leixing;
	var fadongji;
	var p209;
	for(var i=0;i<islive.options.length;i++){
		if(islive.options[i].selected){
			live=islive.options[i].value;
			break;
		}
	}
	for(var i=0;i<onsale.options.length;i++){
		if(onsale.options[i].selected){
			sale=onsale.options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("iyear").options.length;i++){
		if(document.getElementById("iyear").options[i].selected){
			iyear=document.getElementById("iyear").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("xiangti").options.length;i++){
		if(document.getElementById("xiangti").options[i].selected){
			xiangti=document.getElementById("xiangti").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("bsq").options.length;i++){
		if(document.getElementById("bsq").options[i].selected){
			bsq=document.getElementById("bsq").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("jibie").options.length;i++){
		if(document.getElementById("jibie").options[i].selected){
			jibie=document.getElementById("jibie").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("madein").options.length;i++){
		if(document.getElementById("madein").options[i].selected){
			madein=document.getElementById("madein").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("leixing").options.length;i++){
		if(document.getElementById("leixing").options[i].selected){
			leixing=document.getElementById("leixing").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("fadongji").options.length;i++){
		if(document.getElementById("fadongji").options[i].selected){
			fadongji=document.getElementById("fadongji").options[i].value;
			break;
		}
	}
	for(var i=0;i<document.getElementById("p209").options.length;i++){
		if(document.getElementById("p209").options[i].selected){
			p209=document.getElementById("p209").options[i].value;
			break;
		}
	}
    var pailiang=document.getElementById("pailiang").value*10;
    var pinpai=document.getElementById("pinpai").value;
    var qudao=document.getElementById("qudao2").value;
    var car_type=$("#car_type").val();
    if(!qudao && typeof(qudao)!="undefined"){
		alert("请填写渠道！");
		return;
	}
    $.post("SaveC",{id:id,
	live:live,
	sale:sale,
	eName:eName,
	iyear:iyear,
	xiangti:xiangti,
	bsq:bsq,
	jibie:jibie,
	madein:madein,
	leixing:leixing,
	fadongji:fadongji,
	photo:photo,
	pailiang:pailiang,
	pinpai:pinpai,
	danwei:p209,
	qudao:qudao,
	car_type:car_type},function(data){
    	if(data==1){
			alert("更新成功");
		}else{
			alert("更新失败，请再次尝试");
		}
    });
}

function SubmitC(){
	var id=document.getElementById("catalogId2").value; 
	$.post("CatalogManageA",{catalogId:id},function(data){
		window.location.href ="CatalogManage?catalogId="+id;
	});
}

function uploadPic(id){
	$("#upload_pic_view_bg").css({display:"block",height:$(document).height()});
	var yscroll = document.documentElement.scrollTop;
	$("#upload_pic_float_container").css("top","150px");
	$("#upload_pic_float_container").css("display","block");
	document.documentElement.scrollTop = 0;
}

function callbackSucc(data)
{	
	var id=0;
	if(document.getElementById("carType").style.display==""){
		id=3
	}
	if(document.getElementById("carSeries").style.display==""){
		id=2
	}
	if(document.getElementById("carBrand").style.display==""){
		id=1
	}
	var checkedNum=$("#checkedNum").val();
	if(id==1){
		if(data.length>1){
			$("#imagePath"+id).val(data[0].imgPath);
			document.getElementById("pic"+id).src = data[0].uploadPath;
			$("#mainphoto"+id).val(data[1].imgPath); 
			document.getElementById("mainphoto").src = data[1].uploadPath;
		}else{
			if(checkedNum==1){
				$("#imagePath"+id).val(data[0].imgPath);
				document.getElementById("pic"+id).src = data[0].uploadPath;
			}else{
				$("#mainphoto"+id).val(data[0].imgPath); 
				document.getElementById("mainphoto").src = data[0].uploadPath;
			}
		}
	}else if(id==2){
		if(data.length>1){
			$("#imagePath"+id).val(data[0].imgPath);
			document.getElementById("pic"+id).src = data[0].uploadPath;
			$("#mainphoto"+id).val(data[1].imgPath); 
			document.getElementById("mainphoto2").src = data[1].uploadPath;
		}else{
			if(checkedNum==1){
				$("#imagePath"+id).val(data[0].imgPath);
				document.getElementById("pic"+id).src = data[0].uploadPath;
			}else{
				$("#mainphoto1"+id).val(data[0].imgPath); 
				document.getElementById("mainphoto2").src = data[0].uploadPath;
			}
		}
	}else{
		if(data[0].imgPath!=""){
			$("#imagePath"+id).val(data[0].imgPath);
			document.getElementById("pic"+id).src = data[0].uploadPath;
		}
	}
	
}

function getCarData(){
	var data=$("#autohomeData").val();
	var name=document.getElementById("carname").value;
	if(cartype==1){
		var start =  data.indexOf("var config")+13;
		var end =  data.indexOf("var option");
		data1 = data.substring(start,end);
		var i = data1.indexOf(";")
		data1 = data1.substring(0,i);
		var carData=jQuery.parseJSON(data1);
		if(name.length>0){
			var carxName=carData.result.paramtypeitems[0].paramitems[0].valueitems;
			var carid=0;
			for(var i=0;i<carxName.length;i++){
				if(carxName[i].value==name){
					carid=carxName[i].specid;
				}
			}
			if(carid>0){
				var jbcstd=$(".jbcs"+cartype);
				for(var i=0;i<jbcstd.length;i++){
					var tdname=$(".jbcs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[0].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[0].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[0].paramitems[j].valueitems[h].specid==carid){
									jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var cstd=$(".cs"+cartype);
				for(var i=0;i<cstd.length;i++){
					var tdname=$(".cs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[1].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[1].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[1].paramitems[j].valueitems[h].specid==carid){
									cstd[i].value=carData.result.paramtypeitems[1].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var fdjtd=$(".fdj"+cartype);
				for(var i=0;i<fdjtd.length;i++){
					var tdname=$(".fdj"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[2].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[j].name.indexOf(tdname)>-1){
							var csDate1=carData.result.paramtypeitems[2].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[2].paramitems[j].valueitems[h].specid==carid){
									fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var bsxtd=$(".bsx"+cartype);
				for(var i=0;i<bsxtd.length;i++){
					var tdname=$(".bsx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[3].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[3].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[3].paramitems[j].valueitems[h].specid==carid){
									bsxtd[i].value=carData.result.paramtypeitems[3].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var dfzxtd=$(".dfzx"+cartype);
				for(var i=0;i<dfzxtd.length;i++){
					var tdname=$(".dfzx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[4].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[4].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[4].paramitems[j].valueitems[h].specid==carid){
									dfzxtd[i].value=carData.result.paramtypeitems[4].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var clzdtd=$(".clzd"+cartype);
				for(var i=0;i<clzdtd.length;i++){
					var tdname=$(".clzd"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[5].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[5].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[5].paramitems[j].valueitems[h].specid==carid){
									clzdtd[i].value=carData.result.paramtypeitems[5].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
			}else{
				alert("未找到该车型数据！")
				return;
			}
		}
		var start =  data.indexOf("var option")+13;
		var end =  data.indexOf("var color");
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var aqzbtd=$(".aqzb"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".aqzb"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[0].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[0].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[0].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								aqzbtd[i].value=Str1+Str2;
							}else{
								aqzbtd[i].value=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var czpztd=$(".czpz"+cartype);
		for(var i=0;i<czpztd.length;i++){
			var tdname=$(".czpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[1].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[1].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[1].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[1].configitems[j].valueitems[h].specid==carid){
							czpztd[i].value=carData1.result.configtypeitems[1].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var wbpztd=$(".wbpz"+cartype);
		for(var i=0;i<wbpztd.length;i++){
			var tdname=$(".wbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[2].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[2].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[2].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[2].configitems[j].valueitems[h].specid==carid){
							wbpztd[i].value=carData1.result.configtypeitems[2].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var nbpztd=$(".nbpz"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".nbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[3].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[3].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[3].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								nbpztd[i].value=Str1+Str2;
							}else{
								nbpztd[i].value=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var zypztd=$(".zypz"+cartype);
		for(var i=0;i<zypztd.length;i++){
			var tdname=$(".zypz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[4].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[4].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[4].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								zypztd[i].value=Str1+Str2;
							}else{
								zypztd[i].value=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dmtpztd=$(".dmtpz"+cartype);
		for(var i=0;i<dmtpztd.length;i++){
			var tdname=$(".dmtpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[5].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[5].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[5].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dmtpztd[i].value=Str1+Str2;
							}else{
								dmtpztd[i].value=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dgpztd=$(".dgpz"+cartype);
		for(var i=0;i<dgpztd.length;i++){
			var tdname=$(".dgpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[6].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[6].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[6].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dgpztd[i].value=Str1+Str2;
							}else{
								dgpztd[i].value=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var plpztd=$(".plpz"+cartype);
		for(var i=0;i<plpztd.length;i++){
			var tdname=$(".plpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[7].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[7].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[7].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								plpztd[i].value=Str1+Str2;
							}else{
								plpztd[i].value=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var ktpztd=$(".ktpz"+cartype);
		for(var i=0;i<ktpztd.length;i++){
			var tdname=$(".ktpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[8].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[8].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[8].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								ktpztd[i].value=Str1+Str2;
							}else{
								ktpztd[i].value=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var gkjpztd=$(".gkjpz"+cartype);
		for(var i=0;i<gkjpztd.length;i++){
			var tdname=$(".gkjpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[9].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[9].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[9].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								gkjpztd[i].value=Str1+Str2;
							}else{
								gkjpztd[i].value=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var start =  data.indexOf("var color")+12;
		var end=0;
		if(data.indexOf("var innerColor")>-1){
			end=data.indexOf("var innerColor");
		}else{
			end =  data.indexOf("var dealerPrices");
		}
		
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var ysData=carData1.result.specitems;
		var ysStr="";
		for(var j=0;j<ysData.length;j++){
			if(ysData[j].specid==carid){
				for(var i=0;i<ysData[j].coloritems.length;i++){
					ysStr=ysStr+";"+ysData[j].coloritems[i].name+":"+ysData[j].coloritems[i].value;
				}
			}
		}
		$("#car"+cartype+"_p200").val(ysStr);
	}else if(cartype==2){
		var start =  data.indexOf("var config")+13;
		var end =  data.indexOf("var option");
		data1 = data.substring(start,end);
		var i = data1.indexOf(";")
		data1 = data1.substring(0,i);
		var carData=jQuery.parseJSON(data1);
		if(name.length>0){
			var carxName=carData.result.paramtypeitems[0].paramitems[0].valueitems;
			var carid=0;
			for(var i=0;i<carxName.length;i++){
				if(carxName[i].value==name){
					carid=carxName[i].specid;
				}
			}
			if(carid>0){
				var jbcstd=$(".jbcs"+cartype);
				for(var i=0;i<jbcstd.length;i++){
					var tdname=$(".jbcs"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="基本参数"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[0].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[0].paramitems[j].valueitems[h].specid==carid){
									jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var cstd=$(".cs"+cartype);
				for(var i=0;i<cstd.length;i++){
					var tdname=$(".cs"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="车身"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)!=-1){
							var csDate1=csData[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(csData[j].valueitems[h].specid==carid){
									cstd[i].value=csData[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var fdjtd=$(".fdj"+cartype);
				for(var i=0;i<fdjtd.length;i++){
					var tdname=$(".fdj"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="发动机"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)>-1){
							var csDate1=csData[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(csData[j].valueitems[h].specid==carid){
									fdjtd[i].value=csData[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var bsxtd=$(".bsx"+cartype);
				for(var i=0;i<bsxtd.length;i++){
					var tdname=$(".bsx"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="变速箱"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)!=-1){
							var csDate1=csData[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(csData[j].valueitems[h].specid==carid){
									bsxtd[i].value=csData[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var dfzxtd=$(".dfzx"+cartype);
				for(var i=0;i<dfzxtd.length;i++){
					var tdname=$(".dfzx"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="底盘转向"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)!=-1){
							var csDate1=csData[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(csData[j].valueitems[h].specid==carid){
									dfzxtd[i].value=csData[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var clzdtd=$(".clzd"+cartype);
				for(var i=0;i<clzdtd.length;i++){
					var tdname=$(".clzd"+cartype+":eq("+i+")").parent().prev().html();
					var paramTypes=carData.result.paramtypeitems;
					var csData;
					for(var j=0;j<paramTypes.length;j++){
						if(paramTypes[j].name=="车轮制动"){
							csData=carData.result.paramtypeitems[j].paramitems;
						}
					}
					for(var j=0;j<csData.length;j++){
						if(csData[j].name.indexOf(tdname)!=-1){
							var csDate1=csData[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(csData[j].valueitems[h].specid==carid){
									clzdtd[i].value=csData[j].valueitems[h].value;
								}
							}
						}
					}
				}
			}else{
				alert("未找到该车型数据！")
				return;
			}
		}
		var start =  data.indexOf("var option")+13;
		var end =  data.indexOf("var color");
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var aqzbtd=$(".aqzb"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".aqzb"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[0].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[0].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[0].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								aqzbtd[i].value=Str1+Str2;
							}else{
								aqzbtd[i].value=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var czpztd=$(".czpz"+cartype);
		for(var i=0;i<czpztd.length;i++){
			var tdname=$(".czpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[1].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[1].configitems[j].name==tdname){
					var csDate1=carData1.result.configtypeitems[1].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[1].configitems[j].valueitems[h].specid==carid){
							czpztd[i].value=carData1.result.configtypeitems[1].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var wbpztd=$(".wbpz"+cartype);
		for(var i=0;i<wbpztd.length;i++){
			var tdname=$(".wbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[2].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[2].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[2].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[2].configitems[j].valueitems[h].specid==carid){
							wbpztd[i].value=carData1.result.configtypeitems[2].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var nbpztd=$(".nbpz"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".nbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[3].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[3].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[3].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								nbpztd[i].value=Str1+Str2;
							}else{
								nbpztd[i].value=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var zypztd=$(".zypz"+cartype);
		for(var i=0;i<zypztd.length;i++){
			var tdname=$(".zypz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[4].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[4].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[4].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								zypztd[i].value=Str1+Str2;
							}else{
								zypztd[i].value=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dmtpztd=$(".dmtpz"+cartype);
		for(var i=0;i<dmtpztd.length;i++){
			var tdname=$(".dmtpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[5].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[5].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[5].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dmtpztd[i].value=Str1+Str2;
							}else{
								dmtpztd[i].value=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dgpztd=$(".dgpz"+cartype);
		for(var i=0;i<dgpztd.length;i++){
			var tdname=$(".dgpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[6].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[6].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[6].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dgpztd[i].value=Str1+Str2;
							}else{
								dgpztd[i].value=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var plpztd=$(".plpz"+cartype);
		for(var i=0;i<plpztd.length;i++){
			var tdname=$(".plpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[7].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[7].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[7].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								plpztd[i].value=Str1+Str2;
							}else{
								plpztd[i].value=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var ktpztd=$(".ktpz"+cartype);
		for(var i=0;i<ktpztd.length;i++){
			var tdname=$(".ktpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[8].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[8].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[8].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								ktpztd[i].value=Str1+Str2;
							}else{
								ktpztd[i].value=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var gkjpztd=$(".gkjpz"+cartype);
		for(var i=0;i<gkjpztd.length;i++){
			var tdname=$(".gkjpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[9].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[9].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[9].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								gkjpztd[i].value=Str1+Str2;
							}else{
								gkjpztd[i].value=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var start =  data.indexOf("var color")+12;
		var end=0;
		if(data.indexOf("var innerColor")>-1){
			end=data.indexOf("var innerColor");
		}else{
			end =  data.indexOf("var dealerPrices");
		}
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var ysData=carData1.result.specitems;
		var ysStr="";
		for(var j=0;j<ysData.length;j++){
			if(ysData[j].specid==carid){
				for(var i=0;i<ysData[j].coloritems.length;i++){
					ysStr=ysStr+";"+ysData[j].coloritems[i].name+":"+ysData[j].coloritems[i].value;
				}
			}
		}
		$("#car"+cartype+"_p200").val(ysStr);
	}else if(cartype==3){
		var start =  data.indexOf("var config")+13;
		var end =  data.indexOf("var option");
		data1 = data.substring(start,end);
		var i = data1.indexOf(";")
		data1 = data1.substring(0,i);
		var carData=jQuery.parseJSON(data1);
		if(name.length>0){
			var carxName=carData.result.paramtypeitems[0].paramitems[0].valueitems;
			var carid=0;
			for(var i=0;i<carxName.length;i++){
				if(carxName[i].value==name){
					carid=carxName[i].specid;
				}
			}
			if(carid>0){
				var jbcstd=$(".jbcs"+cartype);
				for(var i=0;i<jbcstd.length;i++){
					var tdname=$(".jbcs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[0].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[0].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[0].paramitems[j].valueitems[h].specid==carid){
									jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var cstd=$(".cs"+cartype);
				for(var i=0;i<cstd.length;i++){
					var tdname=$(".cs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[1].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[1].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[1].paramitems[j].valueitems[h].specid==carid){
									cstd[i].value=carData.result.paramtypeitems[1].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var fdjtd=$(".fdj"+cartype);
				for(var i=0;i<fdjtd.length;i++){
					var tdname=$(".fdj"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[2].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[j].name.indexOf(tdname)>-1){
							var csDate1=carData.result.paramtypeitems[2].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[2].paramitems[j].valueitems[h].specid==carid){
									fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var ddjtd=$(".ddj"+cartype);
				for(var i=0;i<ddjtd.length;i++){
					var tdname=$(".ddj"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[3].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[3].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[3].paramitems[j].valueitems[h].specid==carid){
									ddjtd[i].value=carData.result.paramtypeitems[3].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var bsxtd=$(".bsx"+cartype);
				for(var i=0;i<bsxtd.length;i++){
					var tdname=$(".bsx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[4].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[4].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[4].paramitems[j].valueitems[h].specid==carid){
									bsxtd[i].value=carData.result.paramtypeitems[4].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var dfzxtd=$(".dfzx"+cartype);
				for(var i=0;i<dfzxtd.length;i++){
					var tdname=$(".dfzx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[5].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[5].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[5].paramitems[j].valueitems[h].specid==carid){
									dfzxtd[i].value=carData.result.paramtypeitems[5].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var clzdtd=$(".clzd"+cartype);
				for(var i=0;i<clzdtd.length;i++){
					var tdname=$(".clzd"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[6].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[6].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[6].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[6].paramitems[j].valueitems[h].specid==carid){
									clzdtd[i].value=carData.result.paramtypeitems[6].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
			}else{
				alert("未找到该车型数据！")
				return;
			}
		}
		var start =  data.indexOf("var option")+13;
		var end =  data.indexOf("var color");
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var aqzbtd=$(".aqzb"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".aqzb"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[0].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[0].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[0].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								aqzbtd[i].value=Str1+Str2;
							}else{
								aqzbtd[i].value=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var czpztd=$(".czpz"+cartype);
		for(var i=0;i<czpztd.length;i++){
			var tdname=$(".czpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[1].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[1].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[1].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[1].configitems[j].valueitems[h].specid==carid){
							czpztd[i].value=carData1.result.configtypeitems[1].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var wbpztd=$(".wbpz"+cartype);
		for(var i=0;i<wbpztd.length;i++){
			var tdname=$(".wbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[2].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[2].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[2].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[2].configitems[j].valueitems[h].specid==carid){
							wbpztd[i].value=carData1.result.configtypeitems[2].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var nbpztd=$(".nbpz"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".nbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[3].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[3].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[3].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								nbpztd[i].value=Str1+Str2;
							}else{
								nbpztd[i].value=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var zypztd=$(".zypz"+cartype);
		for(var i=0;i<zypztd.length;i++){
			var tdname=$(".zypz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[4].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[4].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[4].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								zypztd[i].value=Str1+Str2;
							}else{
								zypztd[i].value=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dmtpztd=$(".dmtpz"+cartype);
		for(var i=0;i<dmtpztd.length;i++){
			var tdname=$(".dmtpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[5].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[5].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[5].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dmtpztd[i].value=Str1+Str2;
							}else{
								dmtpztd[i].value=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dgpztd=$(".dgpz"+cartype);
		for(var i=0;i<dgpztd.length;i++){
			var tdname=$(".dgpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[6].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[6].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[6].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dgpztd[i].value=Str1+Str2;
							}else{
								dgpztd[i].value=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var plpztd=$(".plpz"+cartype);
		for(var i=0;i<plpztd.length;i++){
			var tdname=$(".plpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[7].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[7].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[7].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								plpztd[i].value=Str1+Str2;
							}else{
								plpztd[i].value=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var ktpztd=$(".ktpz"+cartype);
		for(var i=0;i<ktpztd.length;i++){
			var tdname=$(".ktpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[8].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[8].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[8].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								ktpztd[i].value=Str1+Str2;
							}else{
								ktpztd[i].value=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var gkjpztd=$(".gkjpz"+cartype);
		for(var i=0;i<gkjpztd.length;i++){
			var tdname=$(".gkjpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[9].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[9].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[9].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								gkjpztd[i].value=Str1+Str2;
							}else{
								gkjpztd[i].value=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var start =  data.indexOf("var color")+12;
		var end=0;
		if(data.indexOf("var innerColor")>-1){
			end=data.indexOf("var innerColor");
		}else{
			end =  data.indexOf("var dealerPrices");
		}
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var ysData=carData1.result.specitems;
		var ysStr="";
		for(var j=0;j<ysData.length;j++){
			if(ysData[j].specid==carid){
				for(var i=0;i<ysData[j].coloritems.length;i++){
					ysStr=ysStr+";"+ysData[j].coloritems[i].name+":"+ysData[j].coloritems[i].value;
				}
			}
		}
		$("#car"+cartype+"_p200").val(ysStr);
	}else if(cartype==4){
		var start =  data.indexOf("var config")+13;
		var end =  data.indexOf("var option");
		data1 = data.substring(start,end);
		var i = data1.indexOf(";")
		data1 = data1.substring(0,i);
		var carData=jQuery.parseJSON(data1);
		if(name.length>0){
			var carxName=carData.result.paramtypeitems[0].paramitems[0].valueitems;
			var carid=0;
			for(var i=0;i<carxName.length;i++){
				if(carxName[i].value==name){
					carid=carxName[i].specid;
				}
			}
			if(carid>0){
				var jbcstd=$(".jbcs"+cartype);
				for(var i=0;i<jbcstd.length;i++){
					var tdname=$(".jbcs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[0].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[0].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[0].paramitems[j].valueitems[h].specid==carid){
									jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var cstd=$(".cs"+cartype);
				for(var i=0;i<cstd.length;i++){
					var tdname=$(".cs"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[1].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[1].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[1].paramitems[j].valueitems[h].specid==carid){
									cstd[i].value=carData.result.paramtypeitems[1].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var fdjtd=$(".fdj"+cartype);
				for(var i=0;i<fdjtd.length;i++){
					var tdname=$(".fdj"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[2].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[j].name.indexOf(tdname)>-1){
							var csDate1=carData.result.paramtypeitems[2].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[2].paramitems[j].valueitems[h].specid==carid){
									fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var ddjtd=$(".ddj"+cartype);
				for(var i=0;i<ddjtd.length;i++){
					var tdname=$(".ddj"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[3].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[3].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[3].paramitems[j].valueitems[h].specid==carid){
									ddjtd[i].value=carData.result.paramtypeitems[3].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var bsxtd=$(".bsx"+cartype);
				for(var i=0;i<bsxtd.length;i++){
					var tdname=$(".bsx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[4].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[4].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[4].paramitems[j].valueitems[h].specid==carid){
									bsxtd[i].value=carData.result.paramtypeitems[4].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var dfzxtd=$(".dfzx"+cartype);
				for(var i=0;i<dfzxtd.length;i++){
					var tdname=$(".dfzx"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[5].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[5].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[5].paramitems[j].valueitems[h].specid==carid){
									dfzxtd[i].value=carData.result.paramtypeitems[5].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
				var clzdtd=$(".clzd"+cartype);
				for(var i=0;i<clzdtd.length;i++){
					var tdname=$(".clzd"+cartype+":eq("+i+")").parent().prev().html();
					var csData=carData.result.paramtypeitems[6].paramitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[6].paramitems[j].name.indexOf(tdname)!=-1){
							var csDate1=carData.result.paramtypeitems[6].paramitems[j].valueitems;
							for(var h=0;h<csDate1.length;h++){
								if(carData.result.paramtypeitems[6].paramitems[j].valueitems[h].specid==carid){
									clzdtd[i].value=carData.result.paramtypeitems[6].paramitems[j].valueitems[h].value;
								}
							}
						}
					}
				}
			}else{
				alert("未找到该车型数据！")
				return;
			}
		}
		var start =  data.indexOf("var option")+13;
		var end =  data.indexOf("var color");
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var aqzbtd=$(".aqzb"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".aqzb"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[0].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[0].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[0].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[0].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								aqzbtd[i].value=Str1+Str2;
							}else{
								aqzbtd[i].value=carData1.result.configtypeitems[0].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var czpztd=$(".czpz"+cartype);
		for(var i=0;i<czpztd.length;i++){
			var tdname=$(".czpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[1].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[1].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[1].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[1].configitems[j].valueitems[h].specid==carid){
							czpztd[i].value=carData1.result.configtypeitems[1].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var wbpztd=$(".wbpz"+cartype);
		for(var i=0;i<wbpztd.length;i++){
			var tdname=$(".wbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[2].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[2].configitems[j].name=tdname){
					var csDate1=carData1.result.configtypeitems[2].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[2].configitems[j].valueitems[h].specid==carid){
							wbpztd[i].value=carData1.result.configtypeitems[2].configitems[j].valueitems[h].value;
						}
					}
				}
			}
		}
		var nbpztd=$(".nbpz"+cartype);
		for(var i=0;i<aqzbtd.length;i++){
			var tdname=$(".nbpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[3].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[3].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[3].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[3].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								nbpztd[i].value=Str1+Str2;
							}else{
								nbpztd[i].value=carData1.result.configtypeitems[3].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var zypztd=$(".zypz"+cartype);
		for(var i=0;i<zypztd.length;i++){
			var tdname=$(".zypz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[4].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[4].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[4].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[4].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								zypztd[i].value=Str1+Str2;
							}else{
								zypztd[i].value=carData1.result.configtypeitems[4].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dmtpztd=$(".dmtpz"+cartype);
		for(var i=0;i<dmtpztd.length;i++){
			var tdname=$(".dmtpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[5].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[5].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[5].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[5].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dmtpztd[i].value=Str1+Str2;
							}else{
								dmtpztd[i].value=carData1.result.configtypeitems[5].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var dgpztd=$(".dgpz"+cartype);
		for(var i=0;i<dgpztd.length;i++){
			var tdname=$(".dgpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[6].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[6].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[6].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[6].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								dgpztd[i].value=Str1+Str2;
							}else{
								dgpztd[i].value=carData1.result.configtypeitems[6].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var plpztd=$(".plpz"+cartype);
		for(var i=0;i<plpztd.length;i++){
			var tdname=$(".plpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[7].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[7].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[7].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[7].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								plpztd[i].value=Str1+Str2;
							}else{
								plpztd[i].value=carData1.result.configtypeitems[7].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var ktpztd=$(".ktpz"+cartype);
		for(var i=0;i<ktpztd.length;i++){
			var tdname=$(".ktpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[8].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[8].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[8].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[8].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								ktpztd[i].value=Str1+Str2;
							}else{
								ktpztd[i].value=carData1.result.configtypeitems[8].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var gkjpztd=$(".gkjpz"+cartype);
		for(var i=0;i<gkjpztd.length;i++){
			var tdname=$(".gkjpz"+cartype+":eq("+i+")").parent().prev().html();
			var csData=carData1.result.configtypeitems[9].configitems;
			for(var j=0;j<csData.length;j++){
				if(carData1.result.configtypeitems[9].configitems[j].name.indexOf(tdname)!=-1){
					var csDate1=carData1.result.configtypeitems[9].configitems[j].valueitems;
					for(var h=0;h<csDate1.length;h++){
						if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].specid==carid){
							if(carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;")!=-1){
								var a1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.indexOf("&nbsp;");
								var Str1=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(0,a1);
								var Str2=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.substring(a1+6,carData1.result.configtypeitems[9].configitems[j].valueitems[h].value.length);
								if(Str2.indexOf("&nbsp;")!=-1){
									var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
									var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
									if(strb.indexOf("&nbsp;")!=-1){
										strb=strb.substring(0,strb.indexOf("&nbsp;"));
									}
									Str2=stra+strb;
								}
								gkjpztd[i].value=Str1+Str2;
							}else{
								gkjpztd[i].value=carData1.result.configtypeitems[9].configitems[j].valueitems[h].value;
							}
						}
					}
				}
			}
		}
		var start =  data.indexOf("var color")+12;
		var end=0;
		if(data.indexOf("var innerColor")>-1){
			end=data.indexOf("var innerColor");
		}else{
			end =  data.indexOf("var dealerPrices");
		}
		data2 = data.substring(start,end);
		data2=$.trim(data2);
		data2=data2.substring(0,data2.length-1);
		var carData1=jQuery.parseJSON(data2);
		var ysData=carData1.result.specitems;
		var ysStr="";
		for(var j=0;j<ysData.length;j++){
			if(ysData[j].specid==carid){
				for(var i=0;i<ysData[j].coloritems.length;i++){
					ysStr=ysStr+";"+ysData[j].coloritems[i].name+":"+ysData[j].coloritems[i].value;
				}
			}
		}
		$("#car"+cartype+"_p200").val(ysStr);
	}
	
}


function update(){
	var cid=document.getElementById("catalogId").value; 
	if(cartype==1){
		var jbcs=$(".jbcs1");
	 	var cs=$(".cs1");
	 	var fdj=$(".fdj1");
	 	var bsx=$(".bsx1");
	 	var gkjpz=$(".gkjpz1");
	 	var dfzx=$(".dfzx1");
	 	var clzd=$(".clzd1");
	 	var aqzb=$(".aqzb1");
	 	var czpz=$(".czpz1");
	 	var wbpz=$(".wbpz1");
	 	var nbpz=$(".nbpz1");
	 	var zypz=$(".zypz1");
	 	var dmtpz=$(".dmtpz1");
	 	var dgpz=$(".dgpz1");
	 	var plpz=$(".plpz1");
	 	var ktpz=$(".ktpz1");
	 	var jbcsData="@";
	 	for(var i=0;i<jbcs.length;i++){
	 		jbcsData=jbcsData+jbcs[i].value+"@";
	 	}
	 	
	 	var csData="@";
	 	for(var i=0;i<cs.length;i++){
	 		csData=csData+cs[i].value+"@";
	 	}
	 	
	 	var fdjData="@";
	 	for(var i=0;i<fdj.length;i++){
	 		fdjData=fdjData+fdj[i].value+"@";
	 	}
	 	
	 	var bsxData="@";
	 	for(var i=0;i<bsx.length;i++){
	 		bsxData=bsxData+bsx[i].value+"@";
	 	}
	 	
	 	var dfzxData="@";
	 	for(var i=0;i<dfzx.length;i++){
	 		dfzxData=dfzxData+dfzx[i].value+"@";
	 	}
	 	
	 	var clzdData="@";
	 	for(var i=0;i<clzd.length;i++){
	 		clzdData=clzdData+clzd[i].value+"@";
	 	}
	 	
	 	var aqzbData="@";
	 	for(var i=0;i<aqzb.length;i++){
	 		aqzbData=aqzbData+aqzb[i].value+"@";
	 	}
	 	
	 	var czpzData="@";
	 	for(var i=0;i<czpz.length;i++){
	 		czpzData=czpzData+czpz[i].value+"@";
	 	}
	 	
	 	var wbpzData="@";
	 	for(var i=0;i<wbpz.length;i++){
	 		wbpzData=wbpzData+wbpz[i].value+"@";
	 	}
	 	
	 	var nbpzData="@";
	 	for(var i=0;i<nbpz.length;i++){
	 		nbpzData=nbpzData+nbpz[i].value+"@";
	 	}
	 	
	 	var zypzData="@";
	 	for(var i=0;i<zypz.length;i++){
	 		zypzData=zypzData+zypz[i].value+"@";
	 	}
	 	
	 	var dmtpzData="@";
	 	for(var i=0;i<dmtpz.length;i++){
	 		dmtpzData=dmtpzData+dmtpz[i].value+"@";
	 	}
	 	
	 	var dgpzData="@";
	 	for(var i=0;i<dgpz.length;i++){
	 		dgpzData=dgpzData+dgpz[i].value+"@";
	 	}
	 	
	 	var plpzData="@";
	 	for(var i=0;i<plpz.length;i++){
	 		plpzData=plpzData+plpz[i].value+"@";
	 	}
	 	
	 	var ktpzData="@";
	 	for(var i=0;i<ktpz.length;i++){
	 		ktpzData=ktpzData+ktpz[i].value+"@";
	 	}
	 	
	 	var gkjpzData="@";
	 	for(var i=0;i<gkjpz.length;i++){
	 		gkjpzData=gkjpzData+gkjpz[i].value+"@";
	 	}
	 	var ysData=$("#car"+cartype+"_p200").val();
	 	$.post("UpDateCarDate",{catalogId:cid,
	 	jbcsData:jbcsData,
	 	csData:csData,
	 	fdjData:fdjData,
	 	bsxData:bsxData,
	 	dfzxData:dfzxData,
	 	clzdData:clzdData,
	 	aqzbData:aqzbData,
	 	czpzData:czpzData,
	 	wbpzData:wbpzData,
	 	nbpzData:nbpzData,
	 	zypzData:zypzData,
	 	dmtpzData:dmtpzData,
	 	dgpzData:dgpzData,
	 	plpzData:plpzData,
	 	ktpzData:ktpzData,
	 	gkjpzData:gkjpzData,
	 	ysData:ysData},function(data){
	 		if(data==1){
	 		 	alert("更新成功！");
	 		}else{
	 			alert("更新失败，请再次尝试");
	 		}
	 	});
	}else if(cartype==2){
		var jbcs=$(".jbcs2");
	 	var cs=$(".cs2");
	 	var fdj=$(".fdj2");
	 	var bsx=$(".bsx2");
	 	var dfzx=$(".dfzx2");
	 	var clzd=$(".clzd2");
	 	var aqzb=$(".aqzb2");
	 	var czpz=$(".czpz2");
	 	var wbpz=$(".wbpz2");
	 	var nbpz=$(".nbpz2");
	 	var zypz=$(".zypz2");
	 	var dmtpz=$(".dmtpz2");
	 	var dgpz=$(".dgpz2");
	 	var plpz=$(".plpz2");
	 	var ktpz=$(".ktpz2");
	 	var jbcsData="@";
	 	for(var i=0;i<jbcs.length;i++){
	 		jbcsData=jbcsData+jbcs[i].value+"@";
	 	}
	 	
	 	var csData="@";
	 	for(var i=0;i<cs.length;i++){
	 		csData=csData+cs[i].value+"@";
	 	}
	 	
	 	var fdjData="@";
	 	for(var i=0;i<fdj.length;i++){
	 		fdjData=fdjData+fdj[i].value+"@";
	 	}
	 	
	 	var bsxData="@";
	 	for(var i=0;i<bsx.length;i++){
	 		bsxData=bsxData+bsx[i].value+"@";
	 	}
	 	
	 	var dfzxData="@";
	 	for(var i=0;i<dfzx.length;i++){
	 		dfzxData=dfzxData+dfzx[i].value+"@";
	 	}
	 	
	 	var clzdData="@";
	 	for(var i=0;i<clzd.length;i++){
	 		clzdData=clzdData+clzd[i].value+"@";
	 	}
	 	
	 	var aqzbData="@";
	 	for(var i=0;i<aqzb.length;i++){
	 		aqzbData=aqzbData+aqzb[i].value+"@";
	 	}
	 	
	 	var czpzData="@";
	 	for(var i=0;i<czpz.length;i++){
	 		czpzData=czpzData+czpz[i].value+"@";
	 	}
	 	
	 	var wbpzData="@";
	 	for(var i=0;i<wbpz.length;i++){
	 		wbpzData=wbpzData+wbpz[i].value+"@";
	 	}
	 	
	 	var nbpzData="@";
	 	for(var i=0;i<nbpz.length;i++){
	 		nbpzData=nbpzData+nbpz[i].value+"@";
	 	}
	 	
	 	var zypzData="@";
	 	for(var i=0;i<zypz.length;i++){
	 		zypzData=zypzData+zypz[i].value+"@";
	 	}
	 	
	 	var dmtpzData="@";
	 	for(var i=0;i<dmtpz.length;i++){
	 		dmtpzData=dmtpzData+dmtpz[i].value+"@";
	 	}
	 	
	 	var dgpzData="@";
	 	for(var i=0;i<dgpz.length;i++){
	 		dgpzData=dgpzData+dgpz[i].value+"@";
	 	}
	 	
	 	var plpzData="@";
	 	for(var i=0;i<plpz.length;i++){
	 		plpzData=plpzData+plpz[i].value+"@";
	 	}
	 	
	 	var ktpzData="@";
	 	for(var i=0;i<ktpz.length;i++){
	 		ktpzData=ktpzData+ktpz[i].value+"@";
	 	}
	 	var ysData=$("#car"+cartype+"_p200").val();
	 	$.post("UpDateCarDateTwo",{catalogId:cid,
	 	jbcsData:jbcsData,
	 	csData:csData,
	 	fdjData:fdjData,
	 	bsxData:bsxData,
	 	dfzxData:dfzxData,
	 	clzdData:clzdData,
	 	aqzbData:aqzbData,
	 	czpzData:czpzData,
	 	wbpzData:wbpzData,
	 	nbpzData:nbpzData,
	 	zypzData:zypzData,
	 	dmtpzData:dmtpzData,
	 	dgpzData:dgpzData,
	 	plpzData:plpzData,
	 	ktpzData:ktpzData,
	 	ysData:ysData},function(data){
	 		if(data==1){
	 		 	alert("更新成功！");
	 		}else{
	 			alert("更新失败，请再次尝试");
	 		}
	 	});
	}else if(cartype==3){
		var jbcs=$(".jbcs3");
	 	var cs=$(".cs3");
	 	var fdj=$(".fdj3");
	 	var ddj=$(".ddj3");
	 	var bsx=$(".bsx3");
	 	var gkjpz=$(".gkjpz3");
	 	var dfzx=$(".dfzx3");
	 	var clzd=$(".clzd3");
	 	var aqzb=$(".aqzb3");
	 	var czpz=$(".czpz3");
	 	var wbpz=$(".wbpz3");
	 	var nbpz=$(".nbpz3");
	 	var zypz=$(".zypz3");
	 	var dmtpz=$(".dmtpz3");
	 	var dgpz=$(".dgpz3");
	 	var plpz=$(".plpz3");
	 	var ktpz=$(".ktpz3");
	 	var jbcsData="@";
	 	for(var i=0;i<jbcs.length;i++){
	 		jbcsData=jbcsData+jbcs[i].value+"@";
	 	}
	 	
	 	var csData="@";
	 	for(var i=0;i<cs.length;i++){
	 		csData=csData+cs[i].value+"@";
	 	}
	 	
	 	var fdjData="@";
	 	for(var i=0;i<fdj.length;i++){
	 		fdjData=fdjData+fdj[i].value+"@";
	 	}
	 	var ddjData="@";
	 	for(var i=0;i<ddj.length;i++){
	 		ddjData=ddjData+ddj[i].value+"@";
	 	}
	 	
	 	var bsxData="@";
	 	for(var i=0;i<bsx.length;i++){
	 		bsxData=bsxData+bsx[i].value+"@";
	 	}
	 	
	 	var dfzxData="@";
	 	for(var i=0;i<dfzx.length;i++){
	 		dfzxData=dfzxData+dfzx[i].value+"@";
	 	}
	 	
	 	var clzdData="@";
	 	for(var i=0;i<clzd.length;i++){
	 		clzdData=clzdData+clzd[i].value+"@";
	 	}
	 	
	 	var aqzbData="@";
	 	for(var i=0;i<aqzb.length;i++){
	 		aqzbData=aqzbData+aqzb[i].value+"@";
	 	}
	 	
	 	var czpzData="@";
	 	for(var i=0;i<czpz.length;i++){
	 		czpzData=czpzData+czpz[i].value+"@";
	 	}
	 	
	 	var wbpzData="@";
	 	for(var i=0;i<wbpz.length;i++){
	 		wbpzData=wbpzData+wbpz[i].value+"@";
	 	}
	 	
	 	var nbpzData="@";
	 	for(var i=0;i<nbpz.length;i++){
	 		nbpzData=nbpzData+nbpz[i].value+"@";
	 	}
	 	
	 	var zypzData="@";
	 	for(var i=0;i<zypz.length;i++){
	 		zypzData=zypzData+zypz[i].value+"@";
	 	}
	 	
	 	var dmtpzData="@";
	 	for(var i=0;i<dmtpz.length;i++){
	 		dmtpzData=dmtpzData+dmtpz[i].value+"@";
	 	}
	 	
	 	var dgpzData="@";
	 	for(var i=0;i<dgpz.length;i++){
	 		dgpzData=dgpzData+dgpz[i].value+"@";
	 	}
	 	
	 	var plpzData="@";
	 	for(var i=0;i<plpz.length;i++){
	 		plpzData=plpzData+plpz[i].value+"@";
	 	}
	 	
	 	var ktpzData="@";
	 	for(var i=0;i<ktpz.length;i++){
	 		ktpzData=ktpzData+ktpz[i].value+"@";
	 	}
	 	
	 	var gkjpzData="@";
	 	for(var i=0;i<gkjpz.length;i++){
	 		gkjpzData=gkjpzData+gkjpz[i].value+"@";
	 	}
	 	var ysData=$("#car"+cartype+"_p200").val();
	 	$.post("UpDateCarDateThree",{catalogId:cid,
	 	jbcsData:jbcsData,
	 	csData:csData,
	 	fdjData:fdjData,
	 	ddjData:ddjData,
	 	bsxData:bsxData,
	 	dfzxData:dfzxData,
	 	clzdData:clzdData,
	 	aqzbData:aqzbData,
	 	czpzData:czpzData,
	 	wbpzData:wbpzData,
	 	nbpzData:nbpzData,
	 	zypzData:zypzData,
	 	dmtpzData:dmtpzData,
	 	dgpzData:dgpzData,
	 	plpzData:plpzData,
	 	ktpzData:ktpzData,
	 	gkjpzData:gkjpzData,
	 	ysData:ysData},function(data){
	 		if(data==1){
	 		 	alert("更新成功！");
	 		}else{
	 			alert("更新失败，请再次尝试");
	 		}
	 	});
	}else if(cartype==4){
		var jbcs=$(".jbcs4");
	 	var cs=$(".cs4");
	 	var fdj=$(".fdj4");
	 	var ddj=$(".ddj4");
	 	var bsx=$(".bsx4");
	 	var gkjpz=$(".gkjpz4");
	 	var dfzx=$(".dfzx4");
	 	var clzd=$(".clzd4");
	 	var aqzb=$(".aqzb4");
	 	var czpz=$(".czpz4");
	 	var wbpz=$(".wbpz4");
	 	var nbpz=$(".nbpz4");
	 	var zypz=$(".zypz4");
	 	var dmtpz=$(".dmtpz4");
	 	var dgpz=$(".dgpz4");
	 	var plpz=$(".plpz4");
	 	var ktpz=$(".ktpz4");
	 	var jbcsData="@";
	 	for(var i=0;i<jbcs.length;i++){
	 		jbcsData=jbcsData+jbcs[i].value+"@";
	 	}
	 	
	 	var csData="@";
	 	for(var i=0;i<cs.length;i++){
	 		csData=csData+cs[i].value+"@";
	 	}
	 	
	 	var fdjData="@";
	 	for(var i=0;i<fdj.length;i++){
	 		fdjData=fdjData+fdj[i].value+"@";
	 	}
	 	var ddjData="@";
	 	for(var i=0;i<ddj.length;i++){
	 		ddjData=ddjData+ddj[i].value+"@";
	 	}
	 	
	 	var bsxData="@";
	 	for(var i=0;i<bsx.length;i++){
	 		bsxData=bsxData+bsx[i].value+"@";
	 	}
	 	
	 	var dfzxData="@";
	 	for(var i=0;i<dfzx.length;i++){
	 		dfzxData=dfzxData+dfzx[i].value+"@";
	 	}
	 	
	 	var clzdData="@";
	 	for(var i=0;i<clzd.length;i++){
	 		clzdData=clzdData+clzd[i].value+"@";
	 	}
	 	
	 	var aqzbData="@";
	 	for(var i=0;i<aqzb.length;i++){
	 		aqzbData=aqzbData+aqzb[i].value+"@";
	 	}
	 	
	 	var czpzData="@";
	 	for(var i=0;i<czpz.length;i++){
	 		czpzData=czpzData+czpz[i].value+"@";
	 	}
	 	
	 	var wbpzData="@";
	 	for(var i=0;i<wbpz.length;i++){
	 		wbpzData=wbpzData+wbpz[i].value+"@";
	 	}
	 	
	 	var nbpzData="@";
	 	for(var i=0;i<nbpz.length;i++){
	 		nbpzData=nbpzData+nbpz[i].value+"@";
	 	}
	 	
	 	var zypzData="@";
	 	for(var i=0;i<zypz.length;i++){
	 		zypzData=zypzData+zypz[i].value+"@";
	 	}
	 	
	 	var dmtpzData="@";
	 	for(var i=0;i<dmtpz.length;i++){
	 		dmtpzData=dmtpzData+dmtpz[i].value+"@";
	 	}
	 	
	 	var dgpzData="@";
	 	for(var i=0;i<dgpz.length;i++){
	 		dgpzData=dgpzData+dgpz[i].value+"@";
	 	}
	 	
	 	var plpzData="@";
	 	for(var i=0;i<plpz.length;i++){
	 		plpzData=plpzData+plpz[i].value+"@";
	 	}
	 	
	 	var ktpzData="@";
	 	for(var i=0;i<ktpz.length;i++){
	 		ktpzData=ktpzData+ktpz[i].value+"@";
	 	}
	 	
	 	var gkjpzData="@";
	 	for(var i=0;i<gkjpz.length;i++){
	 		gkjpzData=gkjpzData+gkjpz[i].value+"@";
	 	}
	 	var ysData=$("#car"+cartype+"_p200").val();
	 	$.post("UpDateCarDateFour",{catalogId:cid,
	 	jbcsData:jbcsData,
	 	csData:csData,
	 	fdjData:fdjData,
	 	ddjData:ddjData,
	 	bsxData:bsxData,
	 	dfzxData:dfzxData,
	 	clzdData:clzdData,
	 	aqzbData:aqzbData,
	 	czpzData:czpzData,
	 	wbpzData:wbpzData,
	 	nbpzData:nbpzData,
	 	zypzData:zypzData,
	 	dmtpzData:dmtpzData,
	 	dgpzData:dgpzData,
	 	plpzData:plpzData,
	 	ktpzData:ktpzData,
	 	gkjpzData:gkjpzData,
	 	ysData:ysData},function(data){
	 		if(data==1){
	 		 	alert("更新成功！");
	 		}else{
	 			alert("更新失败，请再次尝试");
	 		}
	 	});
	}
 	
}

function checkedNum(i){
$("#checkedNum").val(i);
}

</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>

