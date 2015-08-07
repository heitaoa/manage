<#import "common.ftl" as c>

<@c.html_top select="380">


<h3 class="page-title">
	车型数据录入
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车型数据录入</a>
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
	<div id="carData" style="display:none;">
	<div class="col-md-8">
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
			<ul class="nav nav-tabs" id="carTypesTabNav">
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
                              		<td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
                            	</tr>
                             	<tr>
                              		<td class="col-md-2 control-label">车型名称</td>
                              		<td class="col-md-4 control-label"><input type="text"  class="jbcs1 form-control input-inline input-medium" id="car1_p1" >
                              		<td class="col-md-2 control-label">厂商指导价(万)</td>
                             		<td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p2"></td>
                            	</tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p192"></td>
	                              <td class="col-md-2 control-label">级别(车型所属车系的级别)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p4"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">发动机</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p5"></td>
	                              <td class="col-md-2 control-label">变速箱</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs1 form-control input-inline input-medium" id="car1_p6"></td>
	                              
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">长宽高</td>
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
	                              <td class="col-md-2 control-label">排量</td>
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
	                              <td class="col-md-2 control-label">档位个数</td>
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
	                              <td class="col-md-2 control-label">前悬挂类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx1 form-control input-inline input-medium" id="car1_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">后悬挂类型</td>
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
	                            <tfoot>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tfoot>
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_2">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs2 form-control input-inline input-medium" id="car2_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价(万)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs2 form-control input-inline input-medium" id="car2_p192"></td>
	                              <td class="col-md-2 control-label">级别(车型所属车系的级别)</td>
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
	                              <td class="col-md-2 control-label">档位个数</td>
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
	                              <td class="col-md-2 control-label">前悬挂类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx2 form-control input-inline input-medium" id="car2_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">后悬挂类型</td>
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
	                              <td class="col-md-2 control-label">排量</td>
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
	                            <tfoot>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tfoot>
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_3">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs3 form-control input-inline input-medium" id="car3_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价(万)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs3 form-control input-inline input-medium" id="car3_p192"></td>
	                              <td class="col-md-2 control-label">级别(车型所属车系的级别)</td>
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
	                              <td class="col-md-2 control-label">排量</td>
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
	                              <td class="col-md-2 control-label">档位个数</td>
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
	                              <td class="col-md-2 control-label">前悬挂类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx3 form-control input-inline input-medium" id="car3_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">后悬挂类型</td>
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
	                            <tfoot>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tfoot>
							</tbady>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="tab_1_4">
					<div class="row">
						<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
							<tbody>
								<tr>
	                              <td colspan="4" class="bg_04" style="background-color: #95a5a6;">基本参数</td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">车型名称</td>
	                              <td class="col-md-4 control-label"><input type="text"  class="jbcs4 form-control input-inline input-medium" id="car4_p1"></td>
	                              <td class="col-md-2 control-label">厂商指导价(万)</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p2"></td>
	                            </tr>
	                            <tr>
	                              <td class="col-md-2 control-label">厂商</td>
	                              <td class="col-md-4 control-label"><input type="text" class="jbcs4 form-control input-inline input-medium" id="car4_p192"></td>
	                              <td class="col-md-2 control-label">级别(车型所属车系的级别)</td>
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
	                              <td class="col-md-2 control-label">排量</td>
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
	                              <td class="col-md-2 control-label">档位个数</td>
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
	                              <td class="col-md-2 control-label">前悬挂类型</td>
	                              <td class="col-md-4 control-label"><input type="text" class="dfzx4 form-control input-inline input-medium" id="car4_p56"></td>
	                            </tr>
	                             <tr>
	                              <td class="col-md-2 control-label">后悬挂类型</td>
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
	                              <td class="col-md-2 control-label">空调控制方式</td>
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
	                            <tfoot>
	                              <td align="center" colspan="4"><button class="btn blue" onClick="update()">更&nbsp;&nbsp;&nbsp;&nbsp;新</button></td>
	                            </tfoot>
							</tbady>
						</table>
					</div>
				</div>
			</div>	
		</div>
			<input id="catalogid" style="display:none;" value="">		
	</div>
	</div>
</div>
</@c.html_top >
<@c.html_bottom>
<script type="text/javascript">
var cartype;
$(document).ready(function() {
	createTree("车型目录",'treeMenu');
});

function onClick(treeId, treeNode, clickFlag){
	var pId = 0;
	if(clickFlag.pId != null){
		pId = clickFlag.id
	}
	var tname =clickFlag.name;
	$("#catalogid").val(pId);
	if(clickFlag.level==2){
		
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
				var jbcstd=$(".jbcs1");
				for(var i=0;i<jbcstd.length;i++){
					if(i<carData.result.paramtypeitems[0].paramitems.length){
						var csData=carData.result.paramtypeitems[0].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[0].paramitems[i].valueitems[j].specid==carid){
								jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[i].valueitems[j].value;
							}
						}
					}
				}
				var cstd=$(".cs1");
				for(var i=0;i<cstd.length;i++){
					if(i<carData.result.paramtypeitems[1].paramitems.length){
						var csData=carData.result.paramtypeitems[1].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[1].paramitems[i].valueitems[j].specid==carid){
								cstd[i].value=carData.result.paramtypeitems[1].paramitems[i].valueitems[j].value;
							}
						}
					}
				}
				var fdjtd=$(".fdj1");
				for(var i=0;i<fdjtd.length;i++){
					if(i<carData.result.paramtypeitems[2].paramitems.length){
						var csData=carData.result.paramtypeitems[2].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[2].paramitems[i].valueitems[j].specid==carid){
								fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[i].valueitems[j].value;
							}
						}
					}
				}
				var bsxtd=$(".bsx1");
				for(var i=0;i<bsxtd.length;i++){
					if(i<carData.result.paramtypeitems[3].paramitems.length){
						var csData=carData.result.paramtypeitems[3].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[3].paramitems[i].valueitems[j].specid==carid){
								bsxtd[i].value=carData.result.paramtypeitems[3].paramitems[i].valueitems[j].value;
							}
						}
					}
				}
				var dfzxtd=$(".dfzx1");
				for(var i=0;i<dfzxtd.length;i++){
					if(i<carData.result.paramtypeitems[4].paramitems.length){
						var csData=carData.result.paramtypeitems[4].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[4].paramitems[i].valueitems[j].specid==carid){
								dfzxtd[i].value=carData.result.paramtypeitems[4].paramitems[i].valueitems[j].value;
							}
						}
					}
				}
				var clzdtd=$(".clzd1");
				for(var i=0;i<clzdtd.length;i++){
					if(i<carData.result.paramtypeitems[5].paramitems.length){
						var csData=carData.result.paramtypeitems[5].paramitems[i].valueitems;
						for(var j=0;j<csData.length;j++){
							if(carData.result.paramtypeitems[5].paramitems[i].valueitems[j].specid==carid){
								clzdtd[i].value=carData.result.paramtypeitems[5].paramitems[i].valueitems[j].value;
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
		var aqzbtd=$(".aqzb1");
		for(var i=0;i<aqzbtd.length;i++){
			if(i<carData1.result.configtypeitems[0].configitems.length){
				var csData=carData1.result.configtypeitems[0].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[0].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[0].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[0].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[0].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[0].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[0].configitems[i].valueitems[j].value.length);
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
							aqzbtd[i].value=carData1.result.configtypeitems[0].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var czpztd=$(".czpz1");
		for(var i=0;i<czpztd.length;i++){
			if(i<carData1.result.configtypeitems[1].configitems.length){
				var csData=carData1.result.configtypeitems[1].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[1].configitems[i].valueitems[j].specid==carid){
						czpztd[i].value=carData1.result.configtypeitems[1].configitems[i].valueitems[j].value;
					}
				}
			}
		}
		var wbpztd=$(".wbpz1");
		for(var i=0;i<wbpztd.length;i++){
			if(i<carData1.result.configtypeitems[2].configitems.length){
				var csData=carData1.result.configtypeitems[2].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[2].configitems[i].valueitems[j].specid==carid){
						wbpztd[i].value=carData1.result.configtypeitems[2].configitems[i].valueitems[j].value;
					}
				}
			}
		}
		var nbpztd=$(".nbpz1");
		for(var i=0;i<aqzbtd.length;i++){
			if(i<carData1.result.configtypeitems[3].configitems.length){
				var csData=carData1.result.configtypeitems[3].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[3].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[3].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[3].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[3].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[3].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[3].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							nbpztd[i].value=Str1+Str2;
						}else{
							nbpztd[i].value=carData1.result.configtypeitems[3].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var zypztd=$(".zypz1");
		for(var i=0;i<zypztd.length;i++){
			if(i<carData1.result.configtypeitems[4].configitems.length){
				var csData=carData1.result.configtypeitems[4].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[4].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[4].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[4].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[4].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[4].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[4].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							zypztd[i].value=Str1+Str2;
						}else{
							zypztd[i].value=carData1.result.configtypeitems[4].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var dmtpztd=$(".dmtpz1");
		for(var i=0;i<dmtpztd.length;i++){
			if(i<carData1.result.configtypeitems[5].configitems.length){
				var csData=carData1.result.configtypeitems[5].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[5].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[5].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[5].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[5].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[5].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[5].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							dmtpztd[i].value=Str1+Str2;
						}else{
							dmtpztd[i].value=carData1.result.configtypeitems[5].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var dgpztd=$(".dgpz1");
		for(var i=0;i<dgpztd.length;i++){
			if(i<carData1.result.configtypeitems[6].configitems.length){
				var csData=carData1.result.configtypeitems[6].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[6].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[6].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[6].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[6].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[6].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[6].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							dgpztd[i].value=Str1+Str2;
						}else{
							dgpztd[i].value=carData1.result.configtypeitems[6].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var plpztd=$(".plpz1");
		for(var i=0;i<plpztd.length;i++){
			if(i<carData1.result.configtypeitems[7].configitems.length){
				var csData=carData1.result.configtypeitems[7].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[7].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[7].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[7].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[7].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[7].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[7].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							plpztd[i].value=Str1+Str2;
						}else{
							plpztd[i].value=carData1.result.configtypeitems[7].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var ktpztd=$(".ktpz1");
		for(var i=0;i<ktpztd.length;i++){
			if(i<carData1.result.configtypeitems[8].configitems.length){
				var csData=carData1.result.configtypeitems[8].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[8].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[8].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[8].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[8].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[8].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[8].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							ktpztd[i].value=Str1+Str2;
						}else{
							ktpztd[i].value=carData1.result.configtypeitems[8].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var gkjpztd=$(".gkjpz1");
		for(var i=0;i<gkjpztd.length;i++){
			if(i<carData1.result.configtypeitems[9].configitems.length){
				var csData=carData1.result.configtypeitems[9].configitems[i].valueitems;
				for(var j=0;j<csData.length;j++){
					if(carData1.result.configtypeitems[9].configitems[i].valueitems[j].specid==carid){
						if(carData1.result.configtypeitems[9].configitems[i].valueitems[j].value.indexOf("&nbsp;")!=-1){
							var a1=carData1.result.configtypeitems[9].configitems[i].valueitems[j].value.indexOf("&nbsp;");
							var Str1=carData1.result.configtypeitems[9].configitems[i].valueitems[j].value.substring(0,a1);
							var Str2=carData1.result.configtypeitems[9].configitems[i].valueitems[j].value.substring(a1+6,carData1.result.configtypeitems[9].configitems[i].valueitems[j].value.length);
							if(Str2.indexOf("&nbsp;")!=-1){
								var stra=Str2.substring(0,Str2.indexOf("&nbsp;"));
								var strb=Str2.substring(Str2.indexOf("&nbsp;")+6,Str2.length);
								if(strb.indexOf("&nbsp;")!=-1){
									strb=strb.substring(0,strb.indexOf("&nbsp;"))+strb.substring(strb.indexOf("&nbsp;")+6,strb.length);
								}
								Str2=stra+strb;
							}
							gkjpztd[i].value=Str1+Str2;
						}else{
							gkjpztd[i].value=carData1.result.configtypeitems[9].configitems[i].valueitems[j].value;
						}
					}
				}
			}
		}
		var start =  data.indexOf("var color")+12;
		var end =  data.indexOf("var dealerPrices");
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
			
			var jbcstd=$(".jbcs2");
			for(var i=0;i<jbcstd.length;i++){
				if(i<carData.result.paramtypeitems[0].paramitems.length){
					var csData=carData.result.paramtypeitems[0].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[i].valueitems[j].specid==carid){
							jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var cstd=$(".cs2");
			for(var i=0;i<cstd.length;i++){
				if(i<carData.result.paramtypeitems[1].paramitems.length){
					var csData=carData.result.paramtypeitems[1].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[i].valueitems[j].specid==carid){
							cstd[i].value=carData.result.paramtypeitems[1].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var bsxtd=$(".bsx2");
			for(var i=0;i<bsxtd.length;i++){
				if(i<carData.result.paramtypeitems[2].paramitems.length){
					var csData=carData.result.paramtypeitems[2].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[i].valueitems[j].specid==carid){
							bsxtd[i].value=carData.result.paramtypeitems[2].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var dfzxtd=$(".dfzx2");
			for(var i=0;i<dfzxtd.length;i++){
				if(i<carData.result.paramtypeitems[3].paramitems.length){
					var csData=carData.result.paramtypeitems[3].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[i].valueitems[j].specid==carid){
							dfzxtd[i].value=carData.result.paramtypeitems[3].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var clzdtd=$(".clzd2");
			for(var i=0;i<clzdtd.length;i++){
				if(i<carData.result.paramtypeitems[4].paramitems.length){
					var csData=carData.result.paramtypeitems[4].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[i].valueitems[j].specid==carid){
							clzdtd[i].value=carData.result.paramtypeitems[4].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var fdjtd=$(".fdj2");
			for(var i=0;i<fdjtd.length;i++){
				if(i<carData.result.paramtypeitems[5].paramitems.length){
					var csData=carData.result.paramtypeitems[5].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[i].valueitems[j].specid==carid){
							fdjtd[i].value=carData.result.paramtypeitems[5].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			
			var start =  data.indexOf("var option")+13;
			var end =  data.indexOf("var color");
			data2 = data.substring(start,end);
			data2=$.trim(data2);
			data2=data2.substring(0,data2.length-1);
			var carData1=jQuery.parseJSON(data2);
			
			var aqzb=$(".aqzb2");
			for(var i=0;i<aqzb.length;i++){
				if(i<carData1.result.configtypeitems[0].configitems.length){
					var aqzbData=carData1.result.configtypeitems[0].configitems[i].valueitems;
					for(var j=0;j<aqzbData.length;j++){
						if(aqzbData[j].specid==carid){
							aqzb[i].value=aqzbData[j].value;
						}
					}
				}
			}
			var czpz=$(".czpz2");
			for(var i=0;i<czpz.length;i++){
				if(i<carData1.result.configtypeitems[1].configitems.length){
					var czpzData=carData1.result.configtypeitems[1].configitems[i].valueitems;
					for(var j=0;j<czpzData.length;j++){
						if(czpzData[j].specid==carid){
							czpz[i].value=czpzData[j].value;
						}
					}
				}
			}
			var wbpz=$(".wbpz2");
			for(var i=0;i<wbpz.length;i++){
				if(i<carData1.result.configtypeitems[2].configitems.length){
					var wbpzData=carData1.result.configtypeitems[2].configitems[i].valueitems;
					for(var j=0;j<wbpzData.length;j++){
						if(wbpzData[j].specid==carid){
							wbpz[i].value=wbpzData[j].value;
						}
					}
				}
			}
			var nbpz=$(".nbpz2");
			for(var i=0;i<nbpz.length;i++){
				if(i<carData1.result.configtypeitems[3].configitems.length){
					var nbpzData=carData1.result.configtypeitems[3].configitems[i].valueitems;
					for(var j=0;j<nbpzData.length;j++){
						if(nbpzData[j].specid==carid){
							nbpz[i].value=nbpzData[j].value;
						}
					}
				}
			}
			var zypz=$(".zypz2");
			for(var i=0;i<zypz.length;i++){
				if(i<carData1.result.configtypeitems[4].configitems.length){
					var zypzData=carData1.result.configtypeitems[4].configitems[i].valueitems;
					for(var j=0;j<zypzData.length;j++){
						if(zypzData[j].specid==carid){
							zypz[i].value=zypzData[j].value;
						}
					}
				}
			}
			var dmtpz=$(".dmtpz2");
			for(var i=0;i<dmtpz.length;i++){
				if(i<carData1.result.configtypeitems[5].configitems.length){
					var dmtpzData=carData1.result.configtypeitems[5].configitems[i].valueitems;
					for(var j=0;j<dmtpzData.length;j++){
						if(dmtpzData[j].specid==carid){
							dmtpz[i].value=dmtpzData[j].value;
						}
					}
				}
			}
			var dgpz=$(".dgpz2");
			for(var i=0;i<dgpz.length;i++){
				if(i<carData1.result.configtypeitems[6].configitems.length){
					var dgpzData=carData1.result.configtypeitems[6].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(dgpzData[j].specid==carid){
							dgpz[i].value=dgpzData[j].value;
						}
					}
				}
			}
			var plpz=$(".plpz2");
			for(var i=0;i<plpz.length;i++){
				if(i<carData1.result.configtypeitems[7].configitems.length){
					var plpzData=carData1.result.configtypeitems[7].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(plpzData[j].specid==carid){
							plpz[i].value=plpzData[j].value;
						}
					}
				}
			}
			var ktpz=$(".ktpz2");
			for(var i=0;i<ktpz.length;i++){
				if(i<carData1.result.configtypeitems[8].configitems.length){
					var ktpzData=carData1.result.configtypeitems[8].configitems[i].valueitems;
					for(var j=0;j<ktpzData.length;j++){
						if(ktpzData[j].specid==carid){
							ktpz[i].value=ktpzData[j].value;
						}
					}
				}
			}
			var start =  data.indexOf("var color")+12;
			var end =  data.indexOf("var dealerPrices");
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
		}else{
			alert("请正确输入车型名称");
		}
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
			
			var jbcstd=$(".jbcs3");
			for(var i=0;i<jbcstd.length;i++){
				if(i<carData.result.paramtypeitems[0].paramitems.length){
					var csData=carData.result.paramtypeitems[0].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[i].valueitems[j].specid==carid){
							jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var cstd=$(".cs3");
			for(var i=0;i<cstd.length;i++){
				if(i<carData.result.paramtypeitems[1].paramitems.length){
					var csData=carData.result.paramtypeitems[1].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[i].valueitems[j].specid==carid){
							cstd[i].value=carData.result.paramtypeitems[1].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var fdjtd=$(".fdj3");
			for(var i=0;i<fdjtd.length;i++){
				if(i<carData.result.paramtypeitems[2].paramitems.length){
					var csData=carData.result.paramtypeitems[2].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[i].valueitems[j].specid==carid){
							fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var ddjtd=$(".ddj3");
			for(var i=0;i<ddjtd.length;i++){
				if(i<carData.result.paramtypeitems[3].paramitems.length){
					var ddjData=carData.result.paramtypeitems[3].paramitems[i].valueitems;
					for(var j=0;j<ddjData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[i].valueitems[j].specid==carid){
							ddjtd[i].value=carData.result.paramtypeitems[3].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var bsxtd=$(".bsx3");
			for(var i=0;i<bsxtd.length;i++){
				if(i<carData.result.paramtypeitems[4].paramitems.length){
					var csData=carData.result.paramtypeitems[4].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[i].valueitems[j].specid==carid){
							bsxtd[i].value=carData.result.paramtypeitems[4].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var dfzxtd=$(".dfzx3");
			for(var i=0;i<dfzxtd.length;i++){
				if(i<carData.result.paramtypeitems[5].paramitems.length){
					var csData=carData.result.paramtypeitems[5].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[i].valueitems[j].specid==carid){
							dfzxtd[i].value=carData.result.paramtypeitems[5].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var clzdtd=$(".clzd3");
			for(var i=0;i<clzdtd.length;i++){
				if(i<carData.result.paramtypeitems[6].paramitems.length){
					var csData=carData.result.paramtypeitems[6].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[6].paramitems[i].valueitems[j].specid==carid){
							clzdtd[i].value=carData.result.paramtypeitems[6].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			
			
			var start =  data.indexOf("var option")+13;
			var end =  data.indexOf("var color");
			data2 = data.substring(start,end);
			data2=$.trim(data2);
			data2=data2.substring(0,data2.length-1);
			var carData1=jQuery.parseJSON(data2);
			
			var aqzb=$(".aqzb3");
			for(var i=0;i<aqzb.length;i++){
				if(i<carData1.result.configtypeitems[0].configitems.length){
					var aqzbData=carData1.result.configtypeitems[0].configitems[i].valueitems;
					for(var j=0;j<aqzbData.length;j++){
						if(aqzbData[j].specid==carid){
							aqzb[i].value=aqzbData[j].value;
						}
					}
				}
			}
			var czpz=$(".czpz3");
			for(var i=0;i<czpz.length;i++){
				if(i<carData1.result.configtypeitems[1].configitems.length){
					var czpzData=carData1.result.configtypeitems[1].configitems[i].valueitems;
					for(var j=0;j<czpzData.length;j++){
						if(czpzData[j].specid==carid){
							czpz[i].value=czpzData[j].value;
						}
					}
				}
			}
			var wbpz=$(".wbpz3");
			for(var i=0;i<wbpz.length;i++){
				if(i<carData1.result.configtypeitems[2].configitems.length){
					var wbpzData=carData1.result.configtypeitems[2].configitems[i].valueitems;
					for(var j=0;j<wbpzData.length;j++){
						if(wbpzData[j].specid==carid){
							wbpz[i].value=wbpzData[j].value;
						}
					}
				}
			}
			var nbpz=$(".nbpz3");
			for(var i=0;i<nbpz.length;i++){
				if(i<carData1.result.configtypeitems[3].configitems.length){
					var nbpzData=carData1.result.configtypeitems[3].configitems[i].valueitems;
					for(var j=0;j<nbpzData.length;j++){
						if(nbpzData[j].specid==carid){
							nbpz[i].value=nbpzData[j].value;
						}
					}
				}
			}
			var zypz=$(".zypz3");
			for(var i=0;i<zypz.length;i++){
				if(i<carData1.result.configtypeitems[4].configitems.length){
					var zypzData=carData1.result.configtypeitems[4].configitems[i].valueitems;
					for(var j=0;j<zypzData.length;j++){
						if(zypzData[j].specid==carid){
							zypz[i].value=zypzData[j].value;
						}
					}
				}
			}
			var dmtpz=$(".dmtpz3");
			for(var i=0;i<dmtpz.length;i++){
				if(i<carData1.result.configtypeitems[5].configitems.length){
					var dmtpzData=carData1.result.configtypeitems[5].configitems[i].valueitems;
					for(var j=0;j<dmtpzData.length;j++){
						if(dmtpzData[j].specid==carid){
							dmtpz[i].value=dmtpzData[j].value;
						}
					}
				}
			}
			var dgpz=$(".dgpz3");
			for(var i=0;i<dgpz.length;i++){
				if(i<carData1.result.configtypeitems[6].configitems.length){
					var dgpzData=carData1.result.configtypeitems[6].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(dgpzData[j].specid==carid){
							dgpz[i].value=dgpzData[j].value;
						}
					}
				}
			}
			var plpz=$(".plpz3");
			for(var i=0;i<plpz.length;i++){
				if(i<carData1.result.configtypeitems[7].configitems.length){
					var plpzData=carData1.result.configtypeitems[7].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(plpzData[j].specid==carid){
							plpz[i].value=plpzData[j].value;
						}
					}
				}
			}
			var ktpz=$(".ktpz3");
			for(var i=0;i<ktpz.length;i++){
				if(i<carData1.result.configtypeitems[8].configitems.length){
					var ktpzData=carData1.result.configtypeitems[8].configitems[i].valueitems;
					for(var j=0;j<ktpzData.length;j++){
						if(ktpzData[j].specid==carid){
							ktpz[i].value=ktpzData[j].value;
						}
					}
				}
			}
			var gkjpz=$(".gkjpz3");
			for(var i=0;i<gkjpz.length;i++){
				if(i<carData1.result.configtypeitems[9].configitems.length){
					var gkjpzData=carData1.result.configtypeitems[9].configitems[i].valueitems;
					for(var j=0;j<gkjpzData.length;j++){
						if(gkjpzData[j].specid==carid){
							gkjpz[i].value=gkjpzData[j].value;
						}
					}
				}
			}
			var start =  data.indexOf("var color")+12;
			var end =  data.indexOf("var dealerPrices");
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
		}else{
			alert("请正确输入车型名称");
		}
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
			
			var jbcstd=$(".jbcs4");
			for(var i=0;i<jbcstd.length;i++){
				if(i<carData.result.paramtypeitems[0].paramitems.length){
					var csData=carData.result.paramtypeitems[0].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[0].paramitems[i].valueitems[j].specid==carid){
							jbcstd[i].value=carData.result.paramtypeitems[0].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var cstd=$(".cs4");
			for(var i=0;i<cstd.length;i++){
				if(i<carData.result.paramtypeitems[1].paramitems.length){
					var csData=carData.result.paramtypeitems[1].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[1].paramitems[i].valueitems[j].specid==carid){
							cstd[i].value=carData.result.paramtypeitems[1].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var fdjtd=$(".fdj4");
			for(var i=0;i<fdjtd.length;i++){
				if(i<carData.result.paramtypeitems[2].paramitems.length){
					var csData=carData.result.paramtypeitems[2].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[2].paramitems[i].valueitems[j].specid==carid){
							fdjtd[i].value=carData.result.paramtypeitems[2].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var ddjtd=$(".ddj4");
			for(var i=0;i<ddjtd.length;i++){
				if(i<carData.result.paramtypeitems[3].paramitems.length){
					var ddjData=carData.result.paramtypeitems[3].paramitems[i].valueitems;
					for(var j=0;j<ddjData.length;j++){
						if(carData.result.paramtypeitems[3].paramitems[i].valueitems[j].specid==carid){
							ddjtd[i].value=carData.result.paramtypeitems[3].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var bsxtd=$(".bsx4");
			for(var i=0;i<bsxtd.length;i++){
				if(i<carData.result.paramtypeitems[4].paramitems.length){
					var csData=carData.result.paramtypeitems[4].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[4].paramitems[i].valueitems[j].specid==carid){
							bsxtd[i].value=carData.result.paramtypeitems[4].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var dfzxtd=$(".dfzx4");
			for(var i=0;i<dfzxtd.length;i++){
				if(i<carData.result.paramtypeitems[5].paramitems.length){
					var csData=carData.result.paramtypeitems[5].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[5].paramitems[i].valueitems[j].specid==carid){
							dfzxtd[i].value=carData.result.paramtypeitems[5].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			var clzdtd=$(".clzd4");
			for(var i=0;i<clzdtd.length;i++){
				if(i<carData.result.paramtypeitems[6].paramitems.length){
					var csData=carData.result.paramtypeitems[6].paramitems[i].valueitems;
					for(var j=0;j<csData.length;j++){
						if(carData.result.paramtypeitems[6].paramitems[i].valueitems[j].specid==carid){
							clzdtd[i].value=carData.result.paramtypeitems[6].paramitems[i].valueitems[j].value;
						}
					}
				}
			}
			
			
			var start =  data.indexOf("var option")+13;
			var end =  data.indexOf("var color");
			data2 = data.substring(start,end);
			data2=$.trim(data2);
			data2=data2.substring(0,data2.length-1);
			var carData1=jQuery.parseJSON(data2);
			
			var aqzb=$(".aqzb4");
			for(var i=0;i<aqzb.length;i++){
				if(i<carData1.result.configtypeitems[0].configitems.length){
					var aqzbData=carData1.result.configtypeitems[0].configitems[i].valueitems;
					for(var j=0;j<aqzbData.length;j++){
						if(aqzbData[j].specid==carid){
							aqzb[i].value=aqzbData[j].value;
						}
					}
				}
			}
			var czpz=$(".czpz4");
			for(var i=0;i<czpz.length;i++){
				if(i<carData1.result.configtypeitems[1].configitems.length){
					var czpzData=carData1.result.configtypeitems[1].configitems[i].valueitems;
					for(var j=0;j<czpzData.length;j++){
						if(czpzData[j].specid==carid){
							czpz[i].value=czpzData[j].value;
						}
					}
				}
			}
			var wbpz=$(".wbpz4");
			for(var i=0;i<wbpz.length;i++){
				if(i<carData1.result.configtypeitems[2].configitems.length){
					var wbpzData=carData1.result.configtypeitems[2].configitems[i].valueitems;
					for(var j=0;j<wbpzData.length;j++){
						if(wbpzData[j].specid==carid){
							wbpz[i].value=wbpzData[j].value;
						}
					}
				}
			}
			var nbpz=$(".nbpz4");
			for(var i=0;i<nbpz.length;i++){
				if(i<carData1.result.configtypeitems[3].configitems.length){
					var nbpzData=carData1.result.configtypeitems[3].configitems[i].valueitems;
					for(var j=0;j<nbpzData.length;j++){
						if(nbpzData[j].specid==carid){
							nbpz[i].value=nbpzData[j].value;
						}
					}
				}
			}
			var zypz=$(".zypz4");
			for(var i=0;i<zypz.length;i++){
				if(i<carData1.result.configtypeitems[4].configitems.length){
					var zypzData=carData1.result.configtypeitems[4].configitems[i].valueitems;
					for(var j=0;j<zypzData.length;j++){
						if(zypzData[j].specid==carid){
							zypz[i].value=zypzData[j].value;
						}
					}
				}
			}
			var dmtpz=$(".dmtpz4");
			for(var i=0;i<dmtpz.length;i++){
				if(i<carData1.result.configtypeitems[5].configitems.length){
					var dmtpzData=carData1.result.configtypeitems[5].configitems[i].valueitems;
					for(var j=0;j<dmtpzData.length;j++){
						if(dmtpzData[j].specid==carid){
							dmtpz[i].value=dmtpzData[j].value;
						}
					}
				}
			}
			var dgpz=$(".dgpz4");
			for(var i=0;i<dgpz.length;i++){
				if(i<carData1.result.configtypeitems[6].configitems.length){
					var dgpzData=carData1.result.configtypeitems[6].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(dgpzData[j].specid==carid){
							dgpz[i].value=dgpzData[j].value;
						}
					}
				}
			}
			var plpz=$(".plpz4");
			for(var i=0;i<plpz.length;i++){
				if(i<carData1.result.configtypeitems[7].configitems.length){
					var plpzData=carData1.result.configtypeitems[7].configitems[i].valueitems;
					for(var j=0;j<dgpzData.length;j++){
						if(plpzData[j].specid==carid){
							plpz[i].value=plpzData[j].value;
						}
					}
				}
			}
			var ktpz=$(".ktpz4");
			for(var i=0;i<ktpz.length;i++){
				if(i<carData1.result.configtypeitems[8].configitems.length){
					var ktpzData=carData1.result.configtypeitems[8].configitems[i].valueitems;
					for(var j=0;j<ktpzData.length;j++){
						if(ktpzData[j].specid==carid){
							ktpz[i].value=ktpzData[j].value;
						}
					}
				}
			}
			var gkjpz=$(".gkjpz4");
			for(var i=0;i<gkjpz.length;i++){
				if(i<carData1.result.configtypeitems[9].configitems.length){
					var gkjpzData=carData1.result.configtypeitems[9].configitems[i].valueitems;
					for(var j=0;j<gkjpzData.length;j++){
						if(gkjpzData[j].specid==carid){
							gkjpz[i].value=gkjpzData[j].value;
						}
					}
				}
			}
			var start =  data.indexOf("var color")+12;
			var end =  data.indexOf("var dealerPrices");
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
		}else{
			alert("请正确输入车型名称");
		}
	}
	
}


function update(){
	var cid=document.getElementById("catalogid").value; 
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
</script>
</@c.html_bottom>