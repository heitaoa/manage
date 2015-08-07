<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>
<input id="carCatalogId" style="display:none;" value="${catalogId}"></input>

<h3 class="page-title">
	车型详细参数维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="index.html">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车型参数维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption" id="catalogname">
					${carCatalog.p1}属性设置
				</div>
			</div>
			<div class="portlet-body">
					<div class="tabbable tabs-left">
							<ul class="nav nav-tabs">
								<li class="active">
									<a href="#tab_6_1" data-toggle="tab">
									基本参数</a>
								</li>
								<li class="">
									<a href="#tab_6_2" data-toggle="tab">
									车身</a>
								</li>
								<li class="">
									<a href="#tab_6_3" data-toggle="tab">
									发动机</a>
								</li>
								<li class="">
									<a href="#tab_6_4" data-toggle="tab">
									变速箱</a>
								</li>
								<li class="">
									<a href="#tab_6_5" data-toggle="tab">
									底盘转向</a>
								</li>
								<li class="">
									<a href="#tab_6_6" data-toggle="tab">
									车轮制动</a>
								</li>
								<li class="">
									<a href="#tab_6_7" data-toggle="tab">
									安全装备</a>
								</li>
								<li class="">
									<a href="#tab_6_8" data-toggle="tab">
									操控配置</a>
								</li>
								<li class="">
									<a href="#tab_6_9" data-toggle="tab">
									外部配置</a>
								</li>
								<li class="">
									<a href="#tab_7_0" data-toggle="tab">
									内部配置</a>
								</li>
								<li class="">
									<a href="#tab_7_1" data-toggle="tab">
									座椅配置</a>
								</li>
								<li class="">
									<a href="#tab_7_2" data-toggle="tab">
									多媒体配置</a>
								</li>
								<li class="">
									<a href="#tab_7_3" data-toggle="tab">
									灯光配置</a>
								</li>
								<li class="">
									<a href="#tab_7_4" data-toggle="tab">
									玻璃/后视镜</a>
								</li>
								<li class="">
									<a href="#tab_7_5" data-toggle="tab">
									空调/冰箱</a>
								</li>
								<li class="">
									<a href="#tab_7_6" data-toggle="tab">
									高科技配置</a>
								</li>
								<li class="">
									<a href="#tab_7_7" data-toggle="tab">
									车身颜色</a>
								</li>
							</ul>

							<div class="tab-content">
								<div class="tab-pane active" id="tab_6_1">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">车型名称 </td>
														<td class="sorting_1"><input name="EditcarNProp$CarName" id="EditcarNProp_CarName" type="text" value="<#if carCatalog??>${carCatalog.p1}</#if>"></td>
														<td class="sorting_1">最高车速 </td>
														<td class="sorting_1"><input name="EditcarNProp$maxspeed" id="EditcarNProp_maxspeed"  type="text" value="${carCatalog.p9?default("")}">(km/h)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">厂商指导价  </td>
														<td class="sorting_1"><input name="EditcarNProp$priceTB" id="EditcarNProp_priceTB" onblur="javascript:return  checktxt(this)" type="text" value="${carCatalog.p2?default("")}"></td>
														<td class="sorting_1">官方加速 </td>
														<td class="sorting_1"><input name="EditcarNProp$Officialacceleration" id="EditcarNProp_Officialacceleration" onblur="javascript: return checktxt(this)" type="text" value="${carCatalog.p10?default("")}">(km/h)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">厂商</td>
														<td class="sorting_1"><input name="EditcarNProp$CompanyName" id="EditcarNProp_CompanyName" type="text" value="${carCatalog.p192?default("")}"></td>
														<td class="sorting_1">官方制动</td>
														<td class="sorting_1"><input name="EditcarNProp$OfficialBrake" id="EditcarNProp_OfficialBrake" onblur="javascript:return checktxt(this)" type="text" value="${carCatalog.p11?default("")}">(m)</td>
													</tr>
													<tr class="gradeX odd" role="row">
						                            	<td class="sorting_1"> 级别(车型所属车系的级别) </td>
						                                <td class="sorting_1"><input name="EditcarNProp$serialGrade" id="EditcarNProp_serialGrade" type="text" value="${carCatalog.p4?default("")}"></td>
						                                <td class="sorting_1"> 工信部综合油耗 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$TXT_GXBZHYH" id="EditcarNProp_TXT_GXBZHYH" type="text" value="${carCatalog.p193?default("")}"></td>
						                            </tr>
					                              	<tr class="gradeX odd" role="row">
						                                <td class="sorting_1"> 发动机 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$fadongji" id="EditcarNProp_fadongji" type="text" value="${carCatalog.p5?default("")}"></td>
						                                <td class="sorting_1"> 实测加速(单位：s) </td>
						                                <td class="sorting_1"><input name="EditcarNProp$MeasuredAcceleration" id="EditcarNProp_MeasuredAcceleration" type="text" value="${carCatalog.p13?default("")}">(s) </td>
					                              	</tr>
					                              	<tr class="gradeX odd" role="row">
						                                <td class="sorting_1"> 变速箱 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$biansuxiang" id="EditcarNProp_biansuxiang" type="text" value="${carCatalog.p6?default("")}"></td>
						                                <td class="sorting_1"> 实测制动(单位：m) </td>
						                                <td class="sorting_1"><input name="EditcarNProp$MeasuredBrake" id="EditcarNProp_MeasuredBrake" type="text" value="${carCatalog.p14?default("")}">(m) </td>
					                             	</tr>
					                               <tr class="gradeX odd" role="row">
						                                <td class="sorting_1"> 长宽高 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$long_width_height" id="EditcarNProp_long_width_height" type="text" value="${carCatalog.p7?default("")}">(mm) </td>
						                                <td class="sorting_1"> 实测油耗(单位：L) </td>
						                                <td class="sorting_1"><input name="EditcarNProp$MeasuredFuel" id="EditcarNProp_MeasuredFuel" type="text" value="${carCatalog.p15?default("")}">(L) </td>
					                               </tr>
					                               <tr class="gradeX odd" role="row">
					                                <td class="sorting_1"> 车体结构 </td>
					                                <td class="sorting_1"><input name="EditcarNProp$carstructure" id="EditcarNProp_carstructure" type="text" value="${carCatalog.p8?default("")}"></td>
					                                <td class="sorting_1"> 整车质保 </td>
					                                <td class="sorting_1"><input name="EditcarNProp$carweightTB" id="EditcarNProp_carweightTB" type="text" value="${carCatalog.p16?default("")}"></td>
					                              </tr>
					                              <tr class="gradeX odd" role="row">
					                                <td class="sorting_1"> 生产年份 </td>
					                                <td class="sorting_1"><input name="EditcarNProp$BirthYear" id="EditcarNProp_BirthYear" type="text"  value="${carCatalog.p177?default("")}"></td>
					                                <td class="sorting_1">品牌</td>
					                                <td class="sorting_1"><input name="EditcarNProp$BirthYear" id="EditcarNProp_pp" type="text"  value="${carCatalog.p3?default("")}"></td>
					                              </tr>
					                              <tr class="gradeX odd" role="row">
					                                <td height="10" align="center" colspan="4"><button onclick="SaveA()" class="btn green" type="button">更  新</button></td>
					                              </tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="tab_6_2">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">长度  </td>
														<td class="sorting_1"><input name="EditcarNProp$carlong" id="EditcarNProp_carlong"  type="text" value="${carCatalog.p17?default("")}">(mm)</td>
														<td class="sorting_1">整备质量 </td>
														<td class="sorting_1"><input name="EditcarNProp$carwight" id="EditcarNProp_carwight"  type="text" value="${carCatalog.p24?default("")}">(Kg)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">宽度 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$carwidth" id="EditcarNProp_carwidth"  type="text" value="${carCatalog.p18?default("")}"">(mm)</td>
						                                <td class="sorting_1"> 车身结构 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$cheshenjiegou" id="EditcarNProp_cheshenjiegou" type="text" value="2" value="${carCatalog.p25?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">高度 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$carheight" id="EditcarNProp_carheight"  type="text" value="${carCatalog.p19?default("")}">(mm)</td>
						                                <td class="sorting_1"> 车门数  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$doornum" id="EditcarNProp_doornum"  type="text" value="${carCatalog.p26?default("")}">(个)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">轴距 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$carzhouju" id="EditcarNProp_carzhouju"  type="text" value="${carCatalog.p20?default("")}">(mm)</td>
						                                <td class="sorting_1"> 座位数  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$sitenum" id="EditcarNProp_sitenum" type="text" value="${carCatalog.p27?default("")}">(个)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前轮距 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$qianlunju" id="EditcarNProp_qianlunju"  type="text" value="${carCatalog.p21?default("")}">(mm)</td>
						                                <td class="sorting_1"> 油箱容积   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$fuelvolume" id="EditcarNProp_fuelvolume"  type="text" value="${carCatalog.p28?default("")}">(L)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后轮距  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$houlunju" id="EditcarNProp_houlunju"  type="text" value="${carCatalog.p22?default("")}">(mm)</td>
						                                <td class="sorting_1"> 行李箱容积   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$xinglixiangvolume" id="EditcarNProp_xinglixiangvolume" type="text" value="${carCatalog.p29?default("")}">(L)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">最小离地间隙   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$minlidijianxi" id="EditcarNProp_minlidijianxi"  type="text" value="${carCatalog.p23?default("")}">(mm)</td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveB()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_3">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">排量  </td>
														<td class="sorting_1"><input name="EditcarNProp$qgrj" id="EditcarNProp_qgrj"  type="text" value="${carCatalog.p30?default(" ")}">(cc)</td>
														<td class="sorting_1">最大功率 </td>
														<td class="sorting_1"><input name="EditcarNProp$maxPower" id="EditcarNProp_maxPower"  type="text" value="${carCatalog.p41?default("")}">(kW)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">排量级别 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$Pailiang" id="EditcarNProp_Pailiang"  type="text" value="${carCatalog.p31?default("")}">(L)</td>
						                                <td class="sorting_1"> 最大功率转速 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$maxPowerSpeed" id="EditcarNProp_maxPowerSpeed"  type="text" value="${carCatalog.p42?default("")}">(rpm)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">进气形式  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$workway" id="EditcarNProp_workway" type="text" value="${carCatalog.p32?default("")}"></td>
						                                <td class="sorting_1"> 最大扭矩 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$maxniuju" id="EditcarNProp_maxniuju" onblur="javascript:return checktxt(this)" type="text" value="${carCatalog.p43?default("")}">(N·m)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">气缸排列形式 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$qgplxs" id="EditcarNProp_qgplxs" type="text" value="${carCatalog.p33?default("")}"></td>
						                                <td class="sorting_1"> 最大扭矩转速</td>
						                                <td class="sorting_1"><input name="EditcarNProp$maxniujuspeed" id="EditcarNProp_maxniujuspeed" type="text" value="${carCatalog.p44?default("")}">(rpm)</td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">气缸数</td>
						                                <td class="sorting_1"><input name="EditcarNProp$qgnum" id="EditcarNProp_qgnum"  type="text" value="${carCatalog.p34?default("")}">(个)</td>
						                                <td class="sorting_1"> 发动机特有技术  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$specifictechnology" id="EditcarNProp_specifictechnology" type="text" value="${carCatalog.p45?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">每缸气门数 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$mgqmnum" id="EditcarNProp_mgqmnum"  type="text" value="${carCatalog.p35?default("")}">(个)</td>
						                                <td class="sorting_1"> 燃料形式   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$fuel" id="EditcarNProp_fuel" type="text" value="${carCatalog.p46?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">压缩比    </td>
						                                <td class="sorting_1"><input name="EditcarNProp$Compression" id="EditcarNProp_Compression" onblur="javascript:return checktxt(this)" type="text" value="${carCatalog.p36?default("")}"></td>
						                                <td class="sorting_1"> 燃油标号</td>
						                                <td class="sorting_1"><input name="EditcarNProp$fuelfalg" id="EditcarNProp_fuelfalg" type="text" value="${carCatalog.p47?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">配气机构</td>
						                                <td class="sorting_1"><input name="EditcarNProp$qimennum" id="EditcarNProp_qimennum" type="text" value="${carCatalog.p37?default("")}"></td>
						                                <td class="sorting_1"> 供油方式</td>
						                                <td class="sorting_1"><input name="EditcarNProp$OilMethod" id="EditcarNProp_OilMethod" type="text" value="${carCatalog.p48?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">缸径   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$gangjing" id="EditcarNProp_gangjing" type="text" value="${carCatalog.p38?default("")}"></td>
						                                <td class="sorting_1">缸盖材料 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$ganggaicailiao" id="EditcarNProp_ganggaicailiao" type="text" value="${carCatalog.p49?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">行程 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$chongcheng" id="EditcarNProp_chongcheng" type="text" value="${carCatalog.p39?default("")}"></td>
						                                <td class="sorting_1">缸体材料 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$gangticailiao" id="EditcarNProp_gangticailiao" type="text" value="${carCatalog.p50?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">最大马力 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$maxlali" id="EditcarNProp_maxlali" type="text" value="${carCatalog.p40?default("")}">(Ps)</td>
						                                <td class="sorting_1">环保标准</td>
						                                <td class="sorting_1"><input name="EditcarNProp$huanbaobiaozhun" id="EditcarNProp_huanbaobiaozhun" type="text" value="${carCatalog.p51?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">发动机型号</td>
						                                <td class="sorting_1"><input name="EditcarNProp$TxtEngineModel" id="EditcarNProp_TxtEngineModel" type="text" value="${carCatalog.p194?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveC()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_4">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">简称  </td>
														<td class="sorting_1"><input name="EditcarNProp$bsxname" id="EditcarNProp_bsxname" type="text" value="${carCatalog.p52?default("")}"></td>
														<td class="sorting_1">变速箱类型 </td>
														<td class="sorting_1"><input name="EditcarNProp$bsxtype" id="EditcarNProp_bsxtype" type="text" value="${carCatalog.p54?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">档位个数</td>
						                                <td class="sorting_1"><input name="EditcarNProp$bsxdangweinum" id="EditcarNProp_bsxdangweinum"  type="text" value="${carCatalog.p53?default("")}"></td>
						                                <td class="sorting_1"> </td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveD()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_5">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 驱动方式</td>
														<td class="sorting_1"><input name="EditcarNProp$dipanqudongway" id="EditcarNProp_dipanqudongway" type="text" value="${carCatalog.p55?default("")}"></td>
														<td class="sorting_1">助力类型 </td>
														<td class="sorting_1"><input name="EditcarNProp$dipanzhulitype" id="EditcarNProp_dipanzhulitype" type="text" value="${carCatalog.p58?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前悬挂类型</td>
						                                <td class="sorting_1"><input name="EditcarNProp$pipanqianxuanguatype" id="EditcarNProp_pipanqianxuanguatype" type="text" value="${carCatalog.p56?default("")}"></td>
						                                <td class="sorting_1"> 后悬挂类型</td>
						                                <td class="sorting_1"><input name="EditcarNProp$dipanhouxuanguatype" id="EditcarNProp_dipanhouxuanguatype" type="text" value="${carCatalog.p57?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveE()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_6">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 前制动器类型 </td>
														<td class="sorting_1"><input name="EditcarNProp$clzd_qzdtype" id="EditcarNProp_clzd_qzdtype" type="text" value="${carCatalog.p60?default("")}"></td>
														<td class="sorting_1">前轮胎规格 </td>
														<td class="sorting_1"><input name="EditcarNProp$clzd_qltgg" id="EditcarNProp_clzd_qltgg" type="text" value="${carCatalog.p63?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后制动器类型 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$clzd_hlzdtype" id="EditcarNProp_clzd_hlzdtype" type="text" value="${carCatalog.p61?default("")}"></td>
						                                <td class="sorting_1"> 后轮胎规格</td>
						                                <td class="sorting_1"><input name="EditcarNProp$clzd_hltgg" id="EditcarNProp_clzd_hltgg" type="text" value="${carCatalog.p64?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">驻车制动类型 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$clzd_zczdtype" id="EditcarNProp_clzd_zczdtype" type="text" value="${carCatalog.p62?default("")}"></td>
						                                <td class="sorting_1"> 备胎规格</td>
						                                <td class="sorting_1"><input name="EditcarNProp$clzd_bt" id="EditcarNProp_clzd_bt" type="text" value="${carCatalog.p65?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveF()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_7">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 驾驶座安全气囊 </td>
														<td class="sorting_1"><input name="EditcarNProp$anquan_anquanqinang" id="EditcarNProp_anquan_anquanqinang" type="text" value="${carCatalog.p66?default("")}"></td>
														<td class="sorting_1">膝部气囊 </td>
														<td class="sorting_1"><input name="EditcarNProp$anquan_xibuqimang" id="EditcarNProp_anquan_xibuqimang" type="text" value="${carCatalog.p72?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">副驾驶安全气囊 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_fujiashiqinaing" id="EditcarNProp_anquan_fujiashiqinaing" type="text" value="${carCatalog.p67?default("")}"></td>
						                                <td class="sorting_1"> 安全带未系提示</td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_anquandaiweidai" id="EditcarNProp_anquan_anquandaiweidai" type="text" value="${carCatalog.p73?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前排侧气囊  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_qianpaiceqinang" id="EditcarNProp_anquan_qianpaiceqinang" type="text" value="${carCatalog.p68?default("")}"></td>
						                                <td class="sorting_1"> 发动机电子防盗</td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_fadongjidianzifangdao" id="EditcarNProp_anquan_fadongjidianzifangdao" type="text" value="${carCatalog.p74?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排侧气囊   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_houpaiceqinang" id="EditcarNProp_anquan_houpaiceqinang" type="text" value="${carCatalog.p69?default("")}"></td>
						                                <td class="sorting_1"> 车内中控锁</td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_cheneizhongkong" id="EditcarNProp_anquan_cheneizhongkong" type="text" value="${carCatalog.p75?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前排头部气囊  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_qianpaitoubuqinang" id="EditcarNProp_anquan_qianpaitoubuqinang" type="text" value="${carCatalog.p70?default("")}"></td>
						                                <td class="sorting_1">遥控钥匙</td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_yaoshizhongkong" id="EditcarNProp_anquan_yaoshizhongkong" type="text" value="${carCatalog.p76?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排头部气囊  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_houpaitoubuqinang" id="EditcarNProp_anquan_houpaitoubuqinang" type="text" value="${carCatalog.p71?default("")}"></td>
						                                <td class="sorting_1">无钥匙启动系统</td>
						                                <td class="sorting_1"><input name="EditcarNProp$anquan_wuyaoshiqidong" id="EditcarNProp_anquan_wuyaoshiqidong" type="text" value="${carCatalog.p77?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">ISO FIX儿童座椅接口  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$txtISOFIXZY" id="EditcarNProp_txtISOFIXZY" type="text" value="${carCatalog.p198?default("")}"></td>
						                                <td class="sorting_1">LATCH儿童座椅接口 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$txtLATCH" id="EditcarNProp_txtLATCH" type="text" value="${carCatalog.p199?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveG()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_8">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> ABS防抱死  </td>
														<td class="sorting_1"><input name="EditcarNProp$caokong_ABS" id="EditcarNProp_caokong_ABS" type="text" value="${carCatalog.p78?default("")}"></td>
														<td class="sorting_1">陡坡缓降  </td>
														<td class="sorting_1"><input name="EditcarNProp$caokong_doupohuanjiang" id="EditcarNProp_caokong_doupohuanjiang" type="text" value="${carCatalog.p84?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 制动力分配</td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_zhidinglifenpei" id="EditcarNProp_caokong_zhidinglifenpei" type="text" value="${carCatalog.p79?default("")}"></td>
						                                <td class="sorting_1"> 可变悬挂</td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_ketiaoxuanguan" id="EditcarNProp_caokong_ketiaoxuanguan" type="text" value="${carCatalog.p85?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">刹车辅助   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_shache" id="EditcarNProp_caokong_shache" type="text" value="${carCatalog.p80?default("")}"></td>
						                                <td class="sorting_1"> 空气悬挂</td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_kongqixuangua" id="EditcarNProp_caokong_kongqixuangua" type="text" value="${carCatalog.p86?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">牵引力控制 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_qianyinlikongzhi" id="EditcarNProp_caokong_qianyinlikongzhi" type="text" value="${carCatalog.p81?default("")}"></td>
						                                <td class="sorting_1"> 胎压监测装置</td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_taiyajiance" id="EditcarNProp_caokong_taiyajiance" type="text" value="${carCatalog.p87?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">车身稳定控制  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_cheshenwending" id="EditcarNProp_caokong_cheshenwending" type="text" value="${carCatalog.p82?default("")}"></td>
						                                <td class="sorting_1">零胎压继续行驶 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_lingtaiyajixuxingshi" id="EditcarNProp_caokong_lingtaiyajixuxingshi" type="text" value="${carCatalog.p88?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 自动驻车_上坡辅助 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_shangpofuzhu" id="EditcarNProp_caokong_shangpofuzhu" type="text" value="${carCatalog.p83?default("")}"></td>
						                                <td class="sorting_1">可变转向比</td>
						                                <td class="sorting_1"><input name="EditcarNProp$caokong_zhudongzhuanxiang" id="EditcarNProp_caokong_zhudongzhuanxiang" type="text" value="${carCatalog.p89?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveH()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_6_9">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 电动天窗 </td>
														<td class="sorting_1"><input name="EditcarNProp$waibupeizhi_diangongtianchuang" id="EditcarNProp_waibupeizhi_diangongtianchuang" type="text" value="${carCatalog.p90?default("")}"></td>
														<td class="sorting_1">同色防擦条 </td>
														<td class="sorting_1"><input name="EditcarNProp$waibupeizhi_tongsefangchatiao" id="EditcarNProp_waibupeizhi_tongsefangchatiao" type="text" value="${carCatalog.p93?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 全景天窗</td>
						                                <td class="sorting_1"><input name="EditcarNProp$waibupeizhi_quanjingtianchuang" id="EditcarNProp_waibupeizhi_quanjingtianchuang" type="text" value="${carCatalog.p91?default("")}"></td>
						                                <td class="sorting_1"> 运动外观套件 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$waibupeizhi_yundongtaojian" id="EditcarNProp_waibupeizhi_yundongtaojian" type="text" value="${carCatalog.p94?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">同色后视镜  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$waibupeizhi_tongsehoushijing" id="EditcarNProp_waibupeizhi_tongsehoushijing" type="text" value="${carCatalog.p92?default("")}"></td>
						                                <td class="sorting_1">  铝合金轮毂</td>
						                                <td class="sorting_1"><input name="EditcarNProp$waibupeizhi_lvhejinlunnian" id="EditcarNProp_waibupeizhi_lvhejinlunnian" type="text" value="${carCatalog.p95?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">电动吸合门  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$waiguanpeizhi_xihemen" id="EditcarNProp_waiguanpeizhi_xihemen" type="text" value="${carCatalog.p180?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveI()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_0">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 真皮方向盘 </td>
														<td class="sorting_1"><input name="EditcarNProp$neibupeizhi_zhenpifangxiangpan" id="EditcarNProp_neibupeizhi_zhenpifangxiangpan" type="text" value="${carCatalog.p96?default("")}"></td>
														<td class="sorting_1">泊车辅助 </td>
														<td class="sorting_1"><input name="EditcarNProp$neibupeizhi_pochefuzhu" id="EditcarNProp_neibupeizhi_pochefuzhu" type="text" value="${carCatalog.p102?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 方向盘上下调节</td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_fangxiangpanshangxiatiaojie" id="EditcarNProp_neibupeizhi_fangxiangpanshangxiatiaojie" type="text" value="${carCatalog.p97?default("")}"></td>
						                                <td class="sorting_1"> 倒车视频影像  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_daocheshipinyingxiang" id="EditcarNProp_neibupeizhi_daocheshipinyingxiang" type="text" value="${carCatalog.p103?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">方向盘前后调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_fangxiangpanqianhoutiaojie" id="EditcarNProp_neibupeizhi_fangxiangpanqianhoutiaojie" type="text" value="${carCatalog.p98?default("")}"></td>
						                                <td class="sorting_1">行车电脑显示屏 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_xingchendiannaoxianshiping" id="EditcarNProp_neibupeizhi_xingchendiannaoxianshiping" type="text" value="${carCatalog.p104?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">多功能方向盘 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_duogongnengfangxiangpan" id="EditcarNProp_neibupeizhi_duogongnengfangxiangpan" type="text" value="${carCatalog.p99?default("")}"></td>
						                                <td class="sorting_1">HUD抬头数字显示</td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_HUD" id="EditcarNProp_neibupeizhi_HUD" type="text" value="${carCatalog.p105?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">方向盘换挡 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_fangxiangpanhuandang" id="EditcarNProp_neibupeizhi_fangxiangpanhuandang" type="text" value="${carCatalog.p100?default("")}"></td>
						                                <td class="sorting_1">左脚休息踏板 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_zuojiaoxiuxitaban" id="EditcarNProp_neibupeizhi_zuojiaoxiuxitaban" type="text" value="${carCatalog.p106?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">定速巡航</td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_dingsuxunhang" id="EditcarNProp_neibupeizhi_dingsuxunhang" type="text" value="${carCatalog.p101?default("")}"></td>
						                                <td class="sorting_1">方向盘电动调节</td>
						                                <td class="sorting_1"><input name="EditcarNProp$neibupeizhi_diandongtiaojie" id="EditcarNProp_neibupeizhi_diandongtiaojie" type="text" value="${carCatalog.p181?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveJ()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_1">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 真皮座椅 </td>
														<td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_zhenpizuoyi" id="EditcarNProp_zuiyipeizhi_zhenpizuoyi" type="text" value="${carCatalog.p107?default("")}"></td>
														<td class="sorting_1">座椅通风 </td>
														<td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_zuoyitongfeng" id="EditcarNProp_zuiyipeizhi_zuoyitongfeng" type="text" value="${carCatalog.p117?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 运动座椅 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_yundongzuoyi" id="EditcarNProp_zuiyipeizhi_yundongzuoyi" type="text" value="${carCatalog.p108?default("")}"></td>
						                                <td class="sorting_1"> 座椅按摩  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_zuoyianmo" id="EditcarNProp_zuiyipeizhi_zuoyianmo" type="text" value="${carCatalog.p118?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">座椅高低调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_zuoyigaoditiaojie" id="EditcarNProp_zuiyipeizhi_zuoyigaoditiaojie" type="text" value="${carCatalog.p109?default("")}"></td>
						                                <td class="sorting_1">后排座椅整体放倒 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houpaizuoyifangzhi" id="EditcarNProp_zuiyipeizhi_houpaizuoyifangzhi" type="text" value="${carCatalog.p119?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">腰部支撑调节  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_yaobuzhicheng" id="EditcarNProp_zuiyipeizhi_yaobuzhicheng" type="text" value="${carCatalog.p110?default("")}"></td>
						                                <td class="sorting_1">后排座椅比例放倒 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houpaizuoyibilifangdao" id="EditcarNProp_zuiyipeizhi_houpaizuoyibilifangdao" type="text" value="${carCatalog.p120?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前排座椅电动调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_qianpaizuoyidiandongtiaojie" id="EditcarNProp_zuiyipeizhi_qianpaizuoyidiandongtiaojie" type="text" value="${carCatalog.p111?default("")}"></td>
						                                <td class="sorting_1">第三排座椅  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_disanpaizuoyi" id="EditcarNProp_zuiyipeizhi_disanpaizuoyi" type="text" value="${carCatalog.p121?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排座椅手动调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houpaizuoyishoudong" id="EditcarNProp_zuiyipeizhi_houpaizuoyishoudong" type="text" value="${carCatalog.p112?default("")}"></td>
						                                <td class="sorting_1">前座中央扶手</td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_qianzuozhongyangfushou" id="EditcarNProp_zuiyipeizhi_qianzuozhongyangfushou" type="text" value="${carCatalog.p122?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 后排座椅电动调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houpaizuoyidiandongtiaojie" id="EditcarNProp_zuiyipeizhi_houpaizuoyidiandongtiaojie" type="text" value="${carCatalog.p113?default("")}"></td>
						                                <td class="sorting_1">后座中央扶手 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houzuozhongyangfushou" id="EditcarNProp_zuiyipeizhi_houzuozhongyangfushou" type="text" value="${carCatalog.p123?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">电动座椅记忆 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_diandongzuoyijiyi" id="EditcarNProp_zuiyipeizhi_diandongzuoyijiyi" type="text" value="${carCatalog.p114?default("")}"></td>
						                                <td class="sorting_1">前排杯架 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_qianpaihuanjia" id="EditcarNProp_zuiyipeizhi_qianpaihuanjia" type="text" value="${carCatalog.p124?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">前排座椅加热  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_qianpaizuoyijiare" id="EditcarNProp_zuiyipeizhi_qianpaizuoyijiare" type="text" value="${carCatalog.p115?default("")}"></td>
						                                <td class="sorting_1">后排杯架</td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houpaibeijia" id="EditcarNProp_zuiyipeizhi_houpaibeijia" type="text" value="${carCatalog.p125?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排座椅加热 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_houtaizuoyijiare" id="EditcarNProp_zuiyipeizhi_houtaizuoyijiare" type="text" value="${carCatalog.p116?default("")}"></td>
						                                <td class="sorting_1">电动后备箱</td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_diangonghoubeixiang" id="EditcarNProp_zuiyipeizhi_diangonghoubeixiang" type="text" value="${carCatalog.p126?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">肩部支撑调节   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$zuiyipeizhi_jianbuzhicheng" id="EditcarNProp_zuiyipeizhi_jianbuzhicheng" type="text" value="${carCatalog.p182?default("")}"></td>
						                                <td class="sorting_1">第二排靠背角度调节</td>
						                                <td class="sorting_1"><input name="EditcarNProp$TxtSecondSeatDegree" id="EditcarNProp_TxtSecondSeatDegree" type="text" value="${carCatalog.p195?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">第二排座椅移动  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$TxtSecondSeatAMove" id="EditcarNProp_TxtSecondSeatAMove" type="text" value="${carCatalog.p196?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveK()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_2">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> GPS导航系统 </td>
														<td class="sorting_1"><input name="EditcarNProp$duomeiti_GPS" id="EditcarNProp_duomeiti_GPS" type="text" value="${carCatalog.p127?default("")}"></td>
														<td class="sorting_1">CD支持MP3_WMA </td>
														<td class="sorting_1"><input name="EditcarNProp$duomeiti__CD" id="EditcarNProp_duomeiti__CD" type="text" value="${carCatalog.p136?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 中控台彩色大屏 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_zhongkongcaisedaping" id="EditcarNProp_duomeiti_zhongkongcaisedaping" type="text" value="${carCatalog.p128?default("")}"></td>
						                                <td class="sorting_1"> 单碟CD  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_dandieCD" id="EditcarNProp_duomeiti_dandieCD" type="text" value="${carCatalog.p137?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">人机交互系统</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_renjijiaohu" id="EditcarNProp_duomeiti_renjijiaohu" type="text" value="${carCatalog.p129?default("")}"></td>
						                                <td class="sorting_1">多碟CD系统 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_duodieCD" id="EditcarNProp_duomeiti_duodieCD" type="text" value="${carCatalog.p138?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">内置硬盘</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_neizhiyingpan" id="EditcarNProp_duomeiti_neizhiyingpan" type="text" value="${carCatalog.p130?default("")}"></td>
						                                <td class="sorting_1">单碟DVD </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_dandieDVD" id="EditcarNProp_duomeiti_dandieDVD" type="text" value="${carCatalog.p139?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">蓝牙系统  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_lanyaxitong" id="EditcarNProp_duomeiti_lanyaxitong" type="text" value="${carCatalog.p131?default("")}"></td>
						                                <td class="sorting_1">多碟DVD系统 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_duojieDVD" id="EditcarNProp_duomeiti_duojieDVD" type="text" value="${carCatalog.p140?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">车载电视</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_chezaidianshi" id="EditcarNProp_duomeiti_chezaidianshi" type="text" value="${carCatalog.p132?default("")}"></td>
						                                <td class="sorting_1">喇叭扬声器系统23</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_laba23" id="EditcarNProp_duomeiti_laba23" type="text" value="${carCatalog.p141?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 车载电话  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_chezaidianhua" id="EditcarNProp_duomeiti_chezaidianhua" type="text" value="${carCatalog.p133?default("")}"></td>
						                                <td class="sorting_1"> 喇叭扬声器系统45 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_laba45" id="EditcarNProp_duomeiti_laba45" type="text" value="${carCatalog.p142?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排液晶屏</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_houpaiyejingping" id="EditcarNProp_duomeiti_houpaiyejingping" type="text" value="${carCatalog.p134?default("")}"></td>
						                                <td class="sorting_1">喇叭扬声器系统67</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_laba67" id="EditcarNProp_duomeiti_laba67" type="text" value="${carCatalog.p143?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">外接音源接口  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_waijieyinyuan" id="EditcarNProp_duomeiti_waijieyinyuan" type="text" value="${carCatalog.p135?default("")}"></td>
						                                <td class="sorting_1">喇叭扬声器系统8</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_laba8" id="EditcarNProp_duomeiti_laba8" type="text" value="${carCatalog.p144?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">定位互动服务 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_dingwei" id="EditcarNProp_duomeiti_dingwei" type="text" value="${carCatalog.p183?default("")}"></td>
						                                <td class="sorting_1"> 蓝牙/车载电话</td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_lanyadianhua" id="EditcarNProp_duomeiti_lanyadianhua" type="text" value="${carCatalog.p184?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">虚拟多碟CD  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$duomeiti_xuniduodie" id="EditcarNProp_duomeiti_xuniduodie" type="text" value="${carCatalog.p185?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveL()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_3">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 氙气大灯 </td>
														<td class="sorting_1"><input name="EditcarNProp$dengguang_shanqidadeng" id="EditcarNProp_dengguang_shanqidadeng" type="text" value="${carCatalog.p145?default("")}"></td>
														<td class="sorting_1">前雾灯</td>
														<td class="sorting_1"><input name="EditcarNProp$dengguang_qianwudeng" id="EditcarNProp_dengguang_qianwudeng" type="text" value="${carCatalog.p149?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 日间行车灯</td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_rijianxingchedeng" id="EditcarNProp_dengguang_rijianxingchedeng" type="text" value="${carCatalog.p146?default("")}"></td>
						                                <td class="sorting_1"> 后雾灯</td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_houwudeng" id="EditcarNProp_dengguang_houwudeng" type="text" value="${carCatalog.p150?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">自动头灯  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_zidongtoudeng" id="EditcarNProp_dengguang_zidongtoudeng" type="text" value="${carCatalog.p147?default("")}"></td>
						                                <td class="sorting_1">大灯高度可调</td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_dadengketiao" id="EditcarNProp_dengguang_dadengketiao" type="text" value="${carCatalog.p151?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">转向头灯_辅助灯   </td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_fuzhudeng" id="EditcarNProp_dengguang_fuzhudeng" type="text" value="${carCatalog.p148?default("")}"></td>
						                                <td class="sorting_1">大灯清洗装置 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_dadengqingxizhuangzhi" id="EditcarNProp_dengguang_dadengqingxizhuangzhi" type="text" value="${carCatalog.p152?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">车内氛围灯</td>
						                                <td class="sorting_1"><input name="EditcarNProp$dengguang_fenweideng" id="EditcarNProp_dengguang_fenweideng" type="text" value="${carCatalog.p186?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveM()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_4">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 前电动车窗</td>
														<td class="sorting_1"><input name="EditcarNProp$houjingdeng_qianchechuang" id="EditcarNProp_houjingdeng_qianchechuang" type="text" value="${carCatalog.p153?default("")}"></td>
														<td class="sorting_1">后视镜电动折叠 </td>
														<td class="sorting_1"><input name="EditcarNProp$houjingdeng_houshijingzhedie" id="EditcarNProp_houjingdeng_houshijingzhedie" type="text" value="${carCatalog.p159?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 后电动车窗</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houdiangongchenchuang" id="EditcarNProp_houjingdeng_houdiangongchenchuang" type="text" value="${carCatalog.p154?default("")}"></td>
						                                <td class="sorting_1"> 后风挡遮阳帘 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houfengfangzheyanglian" id="EditcarNProp_houjingdeng_houfengfangzheyanglian" type="text" value="${carCatalog.p160?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">车窗防夹手功能</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_chechuangfangjiashou" id="EditcarNProp_houjingdeng_chechuangfangjiashou" type="text" value="${carCatalog.p155?default("")}"></td>
						                                <td class="sorting_1">后排侧遮阳帘</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houoaicezheyanglian" id="EditcarNProp_houjingdeng_houoaicezheyanglian" type="text" value="${carCatalog.p161?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后视镜电动调节 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houshijingdiandongtiaojie" id="EditcarNProp_houjingdeng_houshijingdiandongtiaojie" type="text" value="${carCatalog.p156?default("")}"></td>
						                                <td class="sorting_1">遮阳板化妆镜</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_zheyangbanhuazhuangjing" id="EditcarNProp_houjingdeng_zheyangbanhuazhuangjing" type="text" value="${carCatalog.p162?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 后视镜加热</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houshijingjiare" id="EditcarNProp_houjingdeng_houshijingjiare" type="text" value="${carCatalog.p157?default("")}"></td>
						                                <td class="sorting_1">感应雨刷</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_ganyingyushua" id="EditcarNProp_houjingdeng_ganyingyushua" type="text" value="${carCatalog.p163?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后视镜自动防眩目</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houshijingfangxuanmu" id="EditcarNProp_houjingdeng_houshijingfangxuanmu" type="text" value="${carCatalog.p158?default("")}"></td>
						                                <td class="sorting_1">后视镜记忆 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houshijingiyi" id="EditcarNProp_houjingdeng_houshijingiyi" type="text" value="${carCatalog.p197?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">防紫外线/隔热玻璃 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_fangziwaixian" id="EditcarNProp_houjingdeng_fangziwaixian" type="text" value="${carCatalog.p187?default("")}"></td>
						                                <td class="sorting_1">后雨刷</td>
						                                <td class="sorting_1"><input name="EditcarNProp$houjingdeng_houyusha" id="EditcarNProp_houjingdeng_houyusha" type="text" value="${carCatalog.p188?default("")}"></td>
						                            </tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveN()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_5">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 手动空调 </td>
														<td class="sorting_1"><input name="EditcarNProp$kongtiao_shoudongkongtiao" id="EditcarNProp_kongtiao_shoudongkongtiao" type="text" value="${carCatalog.p164?default("")}"></td>
														<td class="sorting_1">温度分区控制  </td>
														<td class="sorting_1"><input name="EditcarNProp$kongtiao_weidufenqukongzhi" id="EditcarNProp_kongtiao_weidufenqukongzhi" type="text" value="${carCatalog.p168?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 自动空调</td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_zidongkongtiao" id="EditcarNProp_kongtiao_zidongkongtiao" type="text" value="${carCatalog.p165?default("")}"></td>
						                                <td class="sorting_1"> 空气调节_花粉过滤 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_kongqitiaojie" id="EditcarNProp_kongtiao_kongqitiaojie" type="text" value="${carCatalog.p169?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排独立空调 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_houpaidulikongtiao" id="EditcarNProp_kongtiao_houpaidulikongtiao" type="text" value="${carCatalog.p166?default("")}"></td>
						                                <td class="sorting_1">车载冰箱 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_chezaibingxiang" id="EditcarNProp_kongtiao_chezaibingxiang" type="text" value="${carCatalog.p170?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 后座出风口</td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_houzuochufengkou" id="EditcarNProp_kongtiao_houzuochufengkou" type="text" value="${carCatalog.p167?default("")}"></td>
						                                <td class="sorting_1"></td>
						                                <td class="sorting_1"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveO()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_6">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 自动泊车入位</td>
														<td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_zidongpocheruwei" id="EditcarNProp_gaokejipeizhi_zidongpocheruwei" type="text" value="${carCatalog.p171?default("")}"></td>
														<td class="sorting_1">自适应巡航  </td>
														<td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_zishiyingxunhang" id="EditcarNProp_gaokejipeizhi_zishiyingxunhang" type="text" value="${carCatalog.p174?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 并线辅助</td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_bingxianfuzhu" id="EditcarNProp_gaokejipeizhi_bingxianfuzhu" type="text" value="${carCatalog.p172?default("")}"></td>
						                                <td class="sorting_1"> 全景摄像头  </td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_quanjingshexiangtou" id="EditcarNProp_gaokejipeizhi_quanjingshexiangtou" type="text" value="${carCatalog.p175?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1">后排独立空调 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_houpaidulikongtiao" id="EditcarNProp_kongtiao_houpaidulikongtiao" type="text" value="${carCatalog.p166?default("")}"></td>
						                                <td class="sorting_1">车载冰箱 </td>
						                                <td class="sorting_1"><input name="EditcarNProp$kongtiao_chezaibingxiang" id="EditcarNProp_kongtiao_chezaibingxiang" type="text" value="${carCatalog.p170?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 夜视系统</td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_yeshixitong" id="EditcarNProp_gaokejipeizhi_yeshixitong" type="text" value="${carCatalog.p173?default("")}"></td>
						                                <td class="sorting_1"> 中控液晶屏分屏显示</td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_yejingpingfenbian" id="EditcarNProp_gaokejipeizhi_yejingpingfenbian" type="text" value="${carCatalog.p191?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 主动刹车/主动安全系统</td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_zhudongshache" id="EditcarNProp_gaokejipeizhi_zhudongshache" type="text" value="${carCatalog.p189?default("")}"></td>
						                                <td class="sorting_1"> 整体主动转向系统</td>
						                                <td class="sorting_1"><input name="EditcarNProp$gaokejipeizhi_zhudongzhuanxiang" id="EditcarNProp_gaokejipeizhi_zhudongzhuanxiang" type="text" value="${carCatalog.p190?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveP()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab_7_7">
									<div class="row">
										<div class="col-md-10">
											<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
												<tbody>
													<tr class="gradeX odd" role="row">
														<td class="sorting_1"> 车身颜色 </td>
														<td class="sorting_1"><input name="00" id="00"   value="${carCatalog.p200?default("")}"></td>
													</tr>
													<tr class="gradeX odd" role="row">
					                                	<td height="10" align="center" colspan="4"><button onclick="SaveQ()" class="btn green" type="button">更  新</button></td>
					                              	</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>						

					</div>
			</div>
		</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
 function SaveA(){
 	var catalogId=document.getElementById("carCatalogId").value;
 	var p1=document.getElementById("EditcarNProp_CarName").value;
 	var p9=document.getElementById("EditcarNProp_maxspeed").value;
 	var p2=document.getElementById("EditcarNProp_priceTB").value;
 	var p10=document.getElementById("EditcarNProp_Officialacceleration").value;
 	var p192=document.getElementById("EditcarNProp_CompanyName").value;
 	var p11=document.getElementById("EditcarNProp_OfficialBrake").value;
 	var p4=document.getElementById("EditcarNProp_serialGrade").value;
 	var p193=document.getElementById("EditcarNProp_TXT_GXBZHYH").value;
 	var p5=document.getElementById("EditcarNProp_fadongji").value;
 	var p13=document.getElementById("EditcarNProp_MeasuredAcceleration").value;
 	var p6=document.getElementById("EditcarNProp_biansuxiang").value;
 	var p14=document.getElementById("EditcarNProp_MeasuredBrake").value;
 	var p7=document.getElementById("EditcarNProp_long_width_height").value;
 	var p15=document.getElementById("EditcarNProp_MeasuredFuel").value;
 	var p8=document.getElementById("EditcarNProp_carstructure").value;
 	var p16=document.getElementById("EditcarNProp_carweightTB").value;
 	var p177=document.getElementById("EditcarNProp_BirthYear").value;
 	var p3=document.getElementById("EditcarNProp_pp").value;
 	var saveA=catalogId+"@"+p1+"@"+p9+"@"+p2+"@"+p10+"@"+p192+"@"+p11+"@"+p4+"@"+p193+"@"+p5+"@"+p13+"@"+p6+"@"+p14+"@"+p7+"@"+p15+"@"+p8+"@"+p16+"@"+p177+"@"+p3;
 	$.post("SaveCatalogManageA",{saveA:saveA},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
 }
 
function SaveB(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p17=document.getElementById("EditcarNProp_carlong").value;
	var p24=document.getElementById("EditcarNProp_carwight").value;
	var p18=document.getElementById("EditcarNProp_carwidth").value;
	var p25=document.getElementById("EditcarNProp_cheshenjiegou").value;
	var p19=document.getElementById("EditcarNProp_carheight").value;
	var p26=document.getElementById("EditcarNProp_doornum").value;
	var p20=document.getElementById("EditcarNProp_carzhouju").value;
	var p27=document.getElementById("EditcarNProp_sitenum").value;
	var p21=document.getElementById("EditcarNProp_qianlunju").value;
	var p28=document.getElementById("EditcarNProp_fuelvolume").value;
	var p22=document.getElementById("EditcarNProp_houlunju").value;
	var p29=document.getElementById("EditcarNProp_xinglixiangvolume").value;
	var p23=document.getElementById("EditcarNProp_minlidijianxi").value;
	var saveB=catalogId+"@"+p17+"@"+p24+"@"+p18+"@"+p25+"@"+p19+"@"+p26+"@"+p20+"@"+p27+"@"+p21+"@"+p28+"@"+p22+"@"+p29+"@"+p23;
	$.post("SaveCatalogManageB",{saveB:saveB},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
} 

function SaveC(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p30=document.getElementById("EditcarNProp_qgrj").value;
	var p41=document.getElementById("EditcarNProp_maxPower").value;
	var p31=document.getElementById("EditcarNProp_Pailiang").value;
	var p42=document.getElementById("EditcarNProp_maxPowerSpeed").value;
	var p32=document.getElementById("EditcarNProp_workway").value;
	var p43=document.getElementById("EditcarNProp_maxniuju").value;
	var p33=document.getElementById("EditcarNProp_qgplxs").value;
	var p44=document.getElementById("EditcarNProp_maxniujuspeed").value;
	var p34=document.getElementById("EditcarNProp_qgnum").value;
	var p45=document.getElementById("EditcarNProp_specifictechnology").value;
	var p35=document.getElementById("EditcarNProp_mgqmnum").value;
	var p46=document.getElementById("EditcarNProp_fuel").value;
	var p36=document.getElementById("EditcarNProp_Compression").value;
	var p47=document.getElementById("EditcarNProp_fuelfalg").value;
	var p37=document.getElementById("EditcarNProp_qimennum").value;
	var p48=document.getElementById("EditcarNProp_OilMethod").value;
	var p38=document.getElementById("EditcarNProp_gangjing").value;
	var p49=document.getElementById("EditcarNProp_ganggaicailiao").value;
	var p39=document.getElementById("EditcarNProp_chongcheng").value;
	var p50=document.getElementById("EditcarNProp_gangticailiao").value;
	var p40=document.getElementById("EditcarNProp_maxlali").value;
	var p51=document.getElementById("EditcarNProp_huanbaobiaozhun").value;
	var p194=document.getElementById("EditcarNProp_TxtEngineModel").value;
	var saveC=catalogId+"@"+p30+"@"+p41+"@"+p31+"@"+p42+"@"+p32+"@"+p43+"@"+p33+"@"+p44+"@"+p34+"@"+p45+"@"+p35+"@"+p46+"@"+p36+"@"+p47+"@"+p37+"@"+p48+"@"+p38+"@"+p49+"@"+p39+"@"+p50+"@"+p40+"@"+p51+"@"+p194;
	$.post("SaveCatalogManageC",{saveC:saveC},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveD(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p52=document.getElementById("EditcarNProp_bsxname").value;
	var p54=document.getElementById("EditcarNProp_bsxtype").value;
	var p53=document.getElementById("EditcarNProp_bsxdangweinum").value;
	var saveD=catalogId+"@"+p52+"@"+p54+"@"+p53;
	$.post("SaveCatalogManageD",{saveD:saveD},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveE(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p55=document.getElementById("EditcarNProp_dipanqudongway").value;
	var p58=document.getElementById("EditcarNProp_dipanzhulitype").value;
	var p56=document.getElementById("EditcarNProp_pipanqianxuanguatype").value;
	var p57=document.getElementById("EditcarNProp_dipanhouxuanguatype").value;
	var saveE=catalogId+"@"+p55+"@"+p58+"@"+p56+"@"+p57;
	$.post("SaveCatalogManageE",{saveE:saveE},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveF(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p60=document.getElementById("EditcarNProp_clzd_qzdtype").value;
	var p63=document.getElementById("EditcarNProp_clzd_qltgg").value;
	var p61=document.getElementById("EditcarNProp_clzd_hlzdtype").value;
	var p64=document.getElementById("EditcarNProp_clzd_hltgg").value;
	var p62=document.getElementById("EditcarNProp_clzd_zczdtype").value;
	var p65=document.getElementById("EditcarNProp_clzd_bt").value;
	var saveF=catalogId+"@"+p60+"@"+p63+"@"+p61+"@"+p64+"@"+p62+"@"+p65;
	$.post("SaveCatalogManageF",{saveF:saveF},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveG(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p66=document.getElementById("EditcarNProp_anquan_anquanqinang").value;
	var p72=document.getElementById("EditcarNProp_anquan_xibuqimang").value;
	var p67=document.getElementById("EditcarNProp_anquan_fujiashiqinaing").value;
	var p73=document.getElementById("EditcarNProp_anquan_anquandaiweidai").value;
	var p68=document.getElementById("EditcarNProp_anquan_qianpaiceqinang").value;
	var p74=document.getElementById("EditcarNProp_anquan_fadongjidianzifangdao").value;
	var p69=document.getElementById("EditcarNProp_anquan_houpaiceqinang").value;
	var p75=document.getElementById("EditcarNProp_anquan_cheneizhongkong").value;
	var p70=document.getElementById("EditcarNProp_anquan_qianpaitoubuqinang").value;
	var p76=document.getElementById("EditcarNProp_anquan_yaoshizhongkong").value;
	var p71=document.getElementById("EditcarNProp_anquan_houpaitoubuqinang").value;
	var p77=document.getElementById("EditcarNProp_anquan_wuyaoshiqidong").value;
	var p198=document.getElementById("EditcarNProp_txtISOFIXZY").value;
	var p199=document.getElementById("EditcarNProp_txtLATCH").value;
	var saveG=catalogId+"@"+p66+"@"+p72+"@"+p67+"@"+p73+"@"+p68+"@"+p74+"@"+p69+"@"+p75+"@"+p70+"@"+p76+"@"+p71+"@"+p77+"@"+p198+"@"+p199;
	$.post("SaveCatalogManageG",{saveG:saveG},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveH(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p78=document.getElementById("EditcarNProp_anquan_anquanqinang").value;
	var p84=document.getElementById("EditcarNProp_caokong_doupohuanjiang").value;
	var p79=document.getElementById("EditcarNProp_caokong_zhidinglifenpei").value;
	var p85=document.getElementById("EditcarNProp_caokong_ketiaoxuanguan").value;
	var p80=document.getElementById("EditcarNProp_caokong_shache").value;
	var p86=document.getElementById("EditcarNProp_caokong_kongqixuangua").value;
	var p81=document.getElementById("EditcarNProp_caokong_qianyinlikongzhi").value;
	var p87=document.getElementById("EditcarNProp_caokong_taiyajiance").value;
	var p82=document.getElementById("EditcarNProp_caokong_cheshenwending").value;
	var p88=document.getElementById("EditcarNProp_caokong_lingtaiyajixuxingshi").value;
	var p83=document.getElementById("EditcarNProp_caokong_shangpofuzhu").value;
	var p89=document.getElementById("EditcarNProp_caokong_zhudongzhuanxiang").value;
	var saveH=catalogId+"@"+p78+"@"+p84+"@"+p79+"@"+p85+"@"+p80+"@"+p86+"@"+p81+"@"+p87+"@"+p82+"@"+p88+"@"+p83+"@"+p89;
	$.post("SaveCatalogManageH",{saveH:saveH},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveI(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p90=document.getElementById("EditcarNProp_waibupeizhi_diangongtianchuang").value;
	var p93=document.getElementById("EditcarNProp_waibupeizhi_tongsefangchatiao").value;
	var p91=document.getElementById("EditcarNProp_waibupeizhi_quanjingtianchuang").value;
	var p94=document.getElementById("EditcarNProp_waibupeizhi_yundongtaojian").value;
	var p92=document.getElementById("EditcarNProp_waibupeizhi_tongsehoushijing").value;
	var p95=document.getElementById("EditcarNProp_waibupeizhi_lvhejinlunnian").value;
	var p180=document.getElementById("EditcarNProp_waiguanpeizhi_xihemen").value;
	var saveI=catalogId+"@"+p90+"@"+p93+"@"+p91+"@"+p94+"@"+p92+"@"+p95+"@"+p180;
	$.post("SaveCatalogManageI",{saveI:saveI},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveJ(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p96=document.getElementById("EditcarNProp_neibupeizhi_zhenpifangxiangpan").value;
	var p102=document.getElementById("EditcarNProp_neibupeizhi_pochefuzhu").value;
	var p97=document.getElementById("EditcarNProp_neibupeizhi_fangxiangpanshangxiatiaojie").value;
	var p103=document.getElementById("EditcarNProp_neibupeizhi_daocheshipinyingxiang").value;
	var p98=document.getElementById("EditcarNProp_neibupeizhi_fangxiangpanqianhoutiaojie").value;
	var p104=document.getElementById("EditcarNProp_neibupeizhi_xingchendiannaoxianshiping").value;
	var p99=document.getElementById("EditcarNProp_neibupeizhi_duogongnengfangxiangpan").value;
	var p105=document.getElementById("EditcarNProp_neibupeizhi_HUD").value;
	var p100=document.getElementById("EditcarNProp_neibupeizhi_fangxiangpanhuandang").value;
	var p106=document.getElementById("EditcarNProp_neibupeizhi_zuojiaoxiuxitaban").value;
	var p101=document.getElementById("EditcarNProp_neibupeizhi_dingsuxunhang").value;
	var p181=document.getElementById("EditcarNProp_neibupeizhi_diandongtiaojie").value;
	var saveJ=catalogId+"@"+p96+"@"+p102+"@"+p97+"@"+p103+"@"+p98+"@"+p104+"@"+p99+"@"+p105+"@"+p100+"@"+p106+"@"+p101+"@"+p181;
	$.post("SaveCatalogManageJ",{saveJ:saveJ},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveK(){
	
	var catalogId=document.getElementById("carCatalogId").value;
	var p107=document.getElementById("EditcarNProp_zuiyipeizhi_zhenpizuoyi").value;
	var p117=document.getElementById("EditcarNProp_zuiyipeizhi_zuoyitongfeng").value;
	var p108=document.getElementById("EditcarNProp_zuiyipeizhi_yundongzuoyi").value;
	var p118=document.getElementById("EditcarNProp_zuiyipeizhi_zuoyianmo").value;
	var p109=document.getElementById("EditcarNProp_zuiyipeizhi_zuoyigaoditiaojie").value;
	var p119=document.getElementById("EditcarNProp_zuiyipeizhi_houpaizuoyifangzhi").value;
	var p110=document.getElementById("EditcarNProp_zuiyipeizhi_yaobuzhicheng").value;
	var p120=document.getElementById("EditcarNProp_zuiyipeizhi_houpaizuoyibilifangdao").value;
	var p111=document.getElementById("EditcarNProp_zuiyipeizhi_qianpaizuoyidiandongtiaojie").value;
	var p121=document.getElementById("EditcarNProp_zuiyipeizhi_disanpaizuoyi").value;
	var p112=document.getElementById("EditcarNProp_zuiyipeizhi_houpaizuoyishoudong").value;
	var p122=document.getElementById("EditcarNProp_zuiyipeizhi_qianzuozhongyangfushou").value;
	var P113=document.getElementById("EditcarNProp_zuiyipeizhi_houpaizuoyidiandongtiaojie").value;
	var p123=document.getElementById("EditcarNProp_zuiyipeizhi_houzuozhongyangfushou").value;
	var p114=document.getElementById("EditcarNProp_zuiyipeizhi_diandongzuoyijiyi").value;
	var p124=document.getElementById("EditcarNProp_zuiyipeizhi_qianpaihuanjia").value;
	var p115=document.getElementById("EditcarNProp_zuiyipeizhi_qianpaizuoyijiare").value;
	var p125=document.getElementById("EditcarNProp_zuiyipeizhi_houpaibeijia").value;
	var p116=document.getElementById("EditcarNProp_zuiyipeizhi_houtaizuoyijiare").value;
	var p126=document.getElementById("EditcarNProp_zuiyipeizhi_diangonghoubeixiang").value;
	var p182=document.getElementById("EditcarNProp_zuiyipeizhi_jianbuzhicheng").value;
	var p195=document.getElementById("EditcarNProp_TxtSecondSeatDegree").value;
	var p196=document.getElementById("EditcarNProp_TxtSecondSeatAMove").value;
	var saveK=catalogId+"@"+p107+"@"+p117+"@"+p108+"@"+p118+"@"+p109+"@"+p119+"@"+p110+"@"+p120+"@"+p111+"@"+p121+"@"+p112+"@"+p122+"@"+P113+"@"+p123+"@"+p114+"@"+p124+"@"+p115+"@"+p125+"@"+p116+"@"+p126+"@"+p182+"@"+p195+"@"+p196;
	$.post("SaveCatalogManageK",{saveK:saveK},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveL(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p127=document.getElementById("EditcarNProp_duomeiti_GPS").value;
	var p136=document.getElementById("EditcarNProp_duomeiti__CD").value;
	var p128=document.getElementById("EditcarNProp_duomeiti_zhongkongcaisedaping").value;
	var p137=document.getElementById("EditcarNProp_duomeiti_dandieCD").value;
	var p129=document.getElementById("EditcarNProp_duomeiti_renjijiaohu").value;
	var p138=document.getElementById("EditcarNProp_duomeiti_duodieCD").value;
	var p130=document.getElementById("EditcarNProp_duomeiti_neizhiyingpan").value;
	var p139=document.getElementById("EditcarNProp_duomeiti_dandieDVD").value;
	var p131=document.getElementById("EditcarNProp_duomeiti_lanyaxitong").value;
	var p140=document.getElementById("EditcarNProp_duomeiti_duojieDVD").value;
	var p132=document.getElementById("EditcarNProp_duomeiti_chezaidianshi").value;
	var p141=document.getElementById("EditcarNProp_duomeiti_laba23").value;
	var p133=document.getElementById("EditcarNProp_duomeiti_chezaidianhua").value;
	var p142=document.getElementById("EditcarNProp_duomeiti_laba45").value;
	var p134=document.getElementById("EditcarNProp_duomeiti_houpaiyejingping").value;
	var p143=document.getElementById("EditcarNProp_duomeiti_laba67").value;
	var p135=document.getElementById("EditcarNProp_duomeiti_waijieyinyuan").value;
	var p144=document.getElementById("EditcarNProp_duomeiti_laba8").value;
	var p183=document.getElementById("EditcarNProp_duomeiti_dingwei").value;
	var p184=document.getElementById("EditcarNProp_duomeiti_lanyadianhua").value;
	var p185=document.getElementById("EditcarNProp_duomeiti_xuniduodie").value;
	var saveL=catalogId+"@"+p127+"@"+p136+"@"+p128+"@"+p137+"@"+p129+"@"+p138+"@"+p130+"@"+p139+"@"+p131+"@"+p140+"@"+p132+"@"+p141+"@"+p133+"@"+p142+"@"+p134+"@"+p143+"@"+p135+"@"+p144+"@"+p183+"@"+p184+"@"+p185;
	$.post("SaveCatalogManageL",{saveL:saveL},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveM(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p145=document.getElementById("EditcarNProp_dengguang_shanqidadeng").value;
	var p149=document.getElementById("EditcarNProp_dengguang_qianwudeng").value;
	var p146=document.getElementById("EditcarNProp_dengguang_rijianxingchedeng").value;
	var p150=document.getElementById("EditcarNProp_dengguang_houwudeng").value;
	var p147=document.getElementById("EditcarNProp_dengguang_zidongtoudeng").value;
	var p151=document.getElementById("EditcarNProp_dengguang_dadengketiao").value;
	var p148=document.getElementById("EditcarNProp_dengguang_fuzhudeng").value;
	var p152=document.getElementById("EditcarNProp_dengguang_dadengqingxizhuangzhi").value;
	var p186=document.getElementById("EditcarNProp_dengguang_fenweideng").value;
	var saveM=catalogId+"@"+p145+"@"+p149+"@"+p146+"@"+p150+"@"+p147+"@"+p151+"@"+p148+"@"+p152+"@"+p186;
	$.post("SaveCatalogManageM",{saveM:saveM},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveN(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p153=document.getElementById("EditcarNProp_houjingdeng_qianchechuang").value;
	var p159=document.getElementById("EditcarNProp_houjingdeng_houshijingzhedie").value;
	var p154=document.getElementById("EditcarNProp_houjingdeng_houdiangongchenchuang").value;
	var p160=document.getElementById("EditcarNProp_houjingdeng_houfengfangzheyanglian").value;
	var p155=document.getElementById("EditcarNProp_houjingdeng_chechuangfangjiashou").value;
	var p161=document.getElementById("EditcarNProp_houjingdeng_houoaicezheyanglian").value;
	var p156=document.getElementById("EditcarNProp_houjingdeng_houshijingdiandongtiaojie").value;
	var p162=document.getElementById("EditcarNProp_houjingdeng_zheyangbanhuazhuangjing").value;
	var p157=document.getElementById("EditcarNProp_houjingdeng_houshijingjiare").value;
	var p163=document.getElementById("EditcarNProp_houjingdeng_ganyingyushua").value;
	var p158=document.getElementById("EditcarNProp_houjingdeng_houshijingfangxuanmu").value;
	var p197=document.getElementById("EditcarNProp_houjingdeng_houshijingiyi").value;
	var p187=document.getElementById("EditcarNProp_houjingdeng_fangziwaixian").value;
	var p188=document.getElementById("EditcarNProp_houjingdeng_houyusha").value;
	var saveN=catalogId+"@"+p153+"@"+p159+"@"+p154+"@"+p160+"@"+p155+"@"+p161+"@"+p156+"@"+p162+"@"+p157+"@"+p163+"@"+p158+"@"+p197+"@"+p187+"@"+p188;
	$.post("SaveCatalogManageN",{saveN:saveN},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveO(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p164=document.getElementById("EditcarNProp_kongtiao_shoudongkongtiao").value;
	var p168=document.getElementById("EditcarNProp_kongtiao_weidufenqukongzhi").value;
	var p165=document.getElementById("EditcarNProp_kongtiao_zidongkongtiao").value;
	var p169=document.getElementById("EditcarNProp_kongtiao_kongqitiaojie").value;
	var p166=document.getElementById("EditcarNProp_kongtiao_houpaidulikongtiao").value;
	var p170=document.getElementById("EditcarNProp_kongtiao_chezaibingxiang").value;
	var p167=document.getElementById("EditcarNProp_kongtiao_houzuochufengkou").value;
	var saveO=catalogId+"@"+p164+"@"+p168+"@"+p165+"@"+p169+"@"+p166+"@"+p170+"@"+p167;
	$.post("SaveCatalogManageO",{saveO:saveO},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveP(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p171=document.getElementById("EditcarNProp_gaokejipeizhi_zidongpocheruwei").value;
	var p174=document.getElementById("EditcarNProp_gaokejipeizhi_zishiyingxunhang").value;
	var p172=document.getElementById("EditcarNProp_gaokejipeizhi_bingxianfuzhu").value;
	var p175=document.getElementById("EditcarNProp_gaokejipeizhi_quanjingshexiangtou").value;
	var p173=document.getElementById("EditcarNProp_gaokejipeizhi_yeshixitong").value;
	var p191=document.getElementById("EditcarNProp_gaokejipeizhi_yejingpingfenbian").value;
	var p189=document.getElementById("EditcarNProp_gaokejipeizhi_zhudongshache").value;
	var p190=document.getElementById("EditcarNProp_gaokejipeizhi_zhudongzhuanxiang").value;
	var saveP=catalogId+"@"+p171+"@"+p174+"@"+p172+"@"+p175+"@"+p173+"@"+p191+"@"+p189+"@"+p190;
	$.post("SaveCatalogManageP",{saveP:saveP},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

function SaveQ(){
	var catalogId=document.getElementById("carCatalogId").value;
	var p200=document.getElementById("00").value;
	var saveQ=catalogId+"@"+p200;
	$.post("SaveCatalogManageQ",{saveQ:saveQ},function(data){
 		if(data==1){
 		 	alert("更新成功！");
 		}else{
 			alert("更新失败，请再次尝试");
 		}
 	});
}

</script>
</body>
</html>