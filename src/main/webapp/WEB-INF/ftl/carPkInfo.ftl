<#import "common.ftl" as c>

<@c.html_head></@c.html_head>
<@c.html_body>


<h3 class="page-title">
	车型PK数据维护
</h3>
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="#">品牌车型信息管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">车型PK数据维护</a>
		</li>
		
	</ul>
	
</div>
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>车型PK数据维护
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info">
						<thead>
							<tr role="row">
								<th class="col-md-2 table-checkbox sorting_disabled" rowspan="1" colspan="1" aria-label="" style="text-align:center;">
									
								</th><th class="col-md-5 sorting_asc" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="车系1: activate to sort column ascending" style="text-align:center;">
									 车系1
								</th><th class="col-md-5 sorting_disabled" rowspan="1" colspan="1" aria-label=" 	车系2" style="text-align:center;">
									  	车系2
								</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row">
							<td  class="col-md-2 sorting_1">车系</td>
							<td  class="col-md-5 sorting_1">
								<div class="col-md-6">
									<select class="form-control form-filter input-sm" name="sel_make" id="sel_carBrand1" onchange="addCarSeries(1)">
										<option value="0">请选择</option>
										<#list brandList as brand>
										<option value="${brand.catalogid}">${brand.catalogname}</option>
										</#list>
									</select>
								</div>
								<div class="col-md-6">
									<select name="sel_maker" class="col-md-4 col-sm-6 form-control form-filter input-sm" id="carSeries1" onchange="addCarPkInfo(1)">
											<option value="0">请选择</option>
										</select>
								</div>
							</td>
							<td  class="col-md-5 sorting_1">
								<div class="col-md-6">
									<select class="form-control form-filter input-sm" name="sel_make" id="sel_carBrand2" onchange="addCarSeries(2)">
										<option value="0">请选择</option>
										<#list brandList as brand>
										<option value="${brand.catalogid}">${brand.catalogname}</option>
										</#list>
									</select>
								</div>
								<div class="col-md-6">
									<select name="sel_maker" class="col-md-4 col-sm-6 form-control form-filter input-sm" id="carSeries2" onchange="addCarPkInfo(1)">
											<option value="0">请选择</option>
										</select>
								</div>
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">车系图片上传</td>
							<td  class="col-md-5 sorting_1">
								<a class="btn green" href="#imgUploadModal" data-toggle="modal" onclick="changeflag(1)">上传图片</a>
								<input id='car1flag' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<a class="btn green" href="#imgUploadModal" data-toggle="modal" onclick="changeflag(2)">上传图片</a>
								<input id='car2flag' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">头部图片</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic1' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img1' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic1' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img1' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">前言标题</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t1"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">前言内容</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t2"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">外观标题</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t3"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">外观内容</td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t4"></textarea></td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t5"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">外观图片1</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic2' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img2' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic2' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img2' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">外观图片2</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic3' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img3' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic3' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img3' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">外观图片3</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic4' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img4' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic4' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img4' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">内饰标题</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t6"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">内饰内容</td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t7"></textarea></td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t8"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">内饰图片1</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic5' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img5' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic5' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img5' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">内饰图片2</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic6' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img6' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic6' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img6' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">内饰图片3</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic7' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img7' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic7' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img7' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">操控标题</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t9"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">操控内容</td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t10"></textarea></td>
							<td  class="col-md-5 sorting_1"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t11"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">操控图片1</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic8' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img8' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic8' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img8' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">操控图片2</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic9' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img9' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic9' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img9' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">操控图片3</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car1_pic10' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car1_img10' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							<td  class="col-md-5 sorting_1">
								<label for="exampleInputFile" class="col-md-3 control-label"><img  width='130' heigth='130' name='imageField' id='car2_pic10' src='${admin_che_url}image/car_pic.jpg'></label>
								
								<input id='car2_img10' class='imagePath' type='hidden' readonly='readonly' >
							</td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">总结标题</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t12"></textarea></td>
							</tr>
							<tr role="row">
							<td  class="col-md-2 sorting_1">总结内容</td>
							<td  class="col-md-10 sorting_1" colspan="2"><textarea name="" class="form-control input-inline input-medium" cols="20" rows="2" id="t13"></textarea></td>
							</tr>
							</tr>
							<tr role="row">
							<td  class="col-md-12 sorting_1" colspan="3"  style="text-align:center;">
							<form action="UpDatePkInfo" method="post" id="postInfo">
							<input id='seriesId11' name='seriesId1' type='hidden' readonly='readonly' value="">
							<input id='seriesId22' name='seriesId2' type='hidden' readonly='readonly' value="">
							<input id='carimg11' name='carimg1' type='hidden' readonly='readonly' value="">
							<input id='carimg22' name='carimg2' type='hidden' readonly='readonly' value="">
							<input id='tt1' name="t1" type='hidden' readonly='readonly' value="">
							<input id='tt2' name="t2"  type='hidden' readonly='readonly' value="">
							<input id='tt3' name="t3"  type='hidden' readonly='readonly' value="">
							<input id='tt4' name="t4" type='hidden' readonly='readonly' value="">
							<input id='tt5' name="t5" type='hidden' readonly='readonly' value="">
							<input id='tt6' name="t6" type='hidden' readonly='readonly' value="">
							<input id='tt7' name="t7"  type='hidden' readonly='readonly' value="">
							<input id='tt8' name="t8" type='hidden' readonly='readonly' value="">
							<input id='tt9' name="t9" type='hidden' readonly='readonly' value="">
							<input id='tt10' name="t10" type='hidden' readonly='readonly' value="">
							<input id='tt11' name="t11" type='hidden' readonly='readonly' value="">
							<input id='tt12' name="t12" type='hidden' readonly='readonly' value="">
							<input id='tt13' name="t13" type='hidden' readonly='readonly' value="">
							
							<button class="btn green" onclick="SaveA()" type="button" >更新</button>
							</form>
							
							</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
	function addCarSeries(id){
		var brandid=$("#sel_carBrand"+id).val();
		if(brandid!=0){
			$.getJSON("GetCarPkSeries",{brandId:brandid},function(data){
				var Shtml="<option value='0'>请选择</option>";
				for(var i=0;i<data.length;i++){
					Shtml+="<option value='"+data[i].catalogid+"'>"+data[i].catalogname+"</option>";
				}
				document.getElementById("carSeries"+id).innerHTML=Shtml;
			});
		}
	}
	
	function addCarPkInfo(){
		var seriesId1=$("#carSeries1").val();
		var seriesId2=$("#carSeries2").val();
		if(parseInt(seriesId1)!=0&&parseInt(seriesId2)!=0){
			$.getJSON("GetCarPkInfo",{seriesId1:seriesId1,
			seriesId2:seriesId2},function(data){
				tcinfo(data);
			});
		}
	}
	
	function tcinfo(data){
		var pkinfo=data[0].data;
				if(pkinfo.length>0){
					$("#t1").val(pkinfo[0].prefacetitle);
					$("#t2").val(pkinfo[0].prefacecontent);
					$("#t3").val(pkinfo[0].apptitle);
					$("#t6").val(pkinfo[0].seattitle);
					$("#t9").val(pkinfo[0].ctrltitle);
					$("#t12").val(pkinfo[0].summarytitle);
					$("#t13").val(pkinfo[0].summarycontent);
					if(data[0].flag==0){
						$("#t4").val(pkinfo[0].appcontent1);
						$("#t5").val(pkinfo[0].appcontent2);
						$("#t7").val(pkinfo[0].seatcontent1);
						$("#t8").val(pkinfo[0].seatcontent2);
						$("#t10").val(pkinfo[0].ctrlcontent1);
						$("#t11").val(pkinfo[0].ctrlcontent2);
						var path1=pkinfo[0].appimgpath11;
						if(path1.substr(0,3)=="315"){
							path1 = path1.replace(/315/,"http://img.315che.com");
						}
						if(path1.substr(0,3)=="ct1"){
							path1 = path1.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic1").attr("src",path1);
						var path2=pkinfo[0].appimgpath12;
						if(path2.substr(0,3)=="315"){
							path2 = path2.replace(/315/,"http://img.315che.com");
						}
						if(path2.substr(0,3)=="ct1"){
							path2 = path2.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic2").attr("src",path2);
						var path3=pkinfo[0].appimgpath13;
						if(path3.substr(0,3)=="315"){
							path3 = path3.replace(/315/,"http://img.315che.com");
						}
						if(path3.substr(0,3)=="ct1"){
							path3 = path3.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic3").attr("src",path3);
						var path4=pkinfo[0].appimgpath14;
						if(path4.substr(0,3)=="315"){
							path4 = path4.replace(/315/,"http://img.315che.com");
						}
						if(path4.substr(0,3)=="ct1"){
							path4 = path4.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic4").attr("src",path4);
						var path5=pkinfo[0].seatimgpath11;
						if(path5.substr(0,3)=="315"){
							path5 = path5.replace(/315/,"http://img.315che.com");
						}
						if(path5.substr(0,3)=="ct1"){
							path5 = path5.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic5").attr("src",path5);
						var path6=pkinfo[0].seatimgpath12;
						if(path6.substr(0,3)=="315"){
							path6 = path6.replace(/315/,"http://img.315che.com");
						}
						if(path6.substr(0,3)=="ct1"){
							path6 = path6.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic6").attr("src",path6);
						var path7=pkinfo[0].seatimgpath13;
						if(path7.substr(0,3)=="315"){
							path7 = path7.replace(/315/,"http://img.315che.com");
						}
						if(path7.substr(0,3)=="ct1"){
							path7 = path7.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic7").attr("src",path7);
						var path8=pkinfo[0].ctrlimgpath11;
						if(path8.substr(0,3)=="315"){
							path8 = path8.replace(/315/,"http://img.315che.com");
						}
						if(path8.substr(0,3)=="ct1"){
							path8 = path8.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic8").attr("src",path8);
						var path9=pkinfo[0].ctrlimgpath12;
						if(path9.substr(0,3)=="315"){
							path9 = path9.replace(/315/,"http://img.315che.com");
						}
						if(path9.substr(0,3)=="ct1"){
							path9 = path9.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic9").attr("src",path9);
						var path10=pkinfo[0].seatimgpath15;
						if(path10.substr(0,3)=="315"){
							path10 = path10.replace(/315/,"http://img.315che.com");
						}
						if(path10.substr(0,3)=="ct1"){
							path10 = path10.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic10").attr("src",path10);
						var path21=pkinfo[0].appimgpath21;
						if(path21.substr(0,3)=="315"){
							path21 = path21.replace(/315/,"http://img.315che.com");
						}
						if(path21.substr(0,3)=="ct1"){
							path21 = path21.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic1").attr("src",path21);
						var path22=pkinfo[0].appimgpath22;
						if(path22.substr(0,3)=="315"){
							path22 = path22.replace(/315/,"http://img.315che.com");
						}
						if(path22.substr(0,3)=="ct1"){
							path22 = path22.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic2").attr("src",path22);
						var path23=pkinfo[0].appimgpath23;
						if(path23.substr(0,3)=="315"){
							path23 = path23.replace(/315/,"http://img.315che.com");
						}
						if(path23.substr(0,3)=="ct1"){
							path23 = path23.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic3").attr("src",path23);
						var path24=pkinfo[0].appimgpath24;
						if(path24.substr(0,3)=="315"){
							path24 = path24.replace(/315/,"http://img.315che.com");
						}
						if(path24.substr(0,3)=="ct1"){
							path24 = path24.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic4").attr("src",path24);
						var path25=pkinfo[0].seatimgpath21;
						if(path25.substr(0,3)=="315"){
							path25 = path25.replace(/315/,"http://img.315che.com");
						}
						if(path25.substr(0,3)=="ct1"){
							path25 = path25.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic5").attr("src",path25);
						var path26=pkinfo[0].seatimgpath12;
						if(path26.substr(0,3)=="315"){
							path26 = path26.replace(/315/,"http://img.315che.com");
						}
						if(path26.substr(0,3)=="ct1"){
							path26 = path26.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic6").attr("src",path26);
						var path27=pkinfo[0].seatimgpath13;
						if(path27.substr(0,3)=="315"){
							path27 = path27.replace(/315/,"http://img.315che.com");
						}
						if(path27.substr(0,3)=="ct1"){
							path27 = path27.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic7").attr("src",path27);
						var path28=pkinfo[0].ctrlimgpath11;
						if(path28.substr(0,3)=="315"){
							path28 = path28.replace(/315/,"http://img.315che.com");
						}
						if(path28.substr(0,3)=="ct1"){
							path28 = path28.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic8").attr("src",path28);
						var path29=pkinfo[0].ctrlimgpath12;
						if(path29.substr(0,3)=="315"){
							path29 = path29.replace(/315/,"http://img.315che.com");
						}
						if(path29.substr(0,3)=="ct1"){
							path29 = path29.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic9").attr("src",path29);
						var path30=pkinfo[0].seatimgpath25;
						if(path30.substr(0,3)=="315"){
							path30 = path30.replace(/315/,"http://img.315che.com");
						}
						if(path30.substr(0,3)=="ct1"){
							path30 = path30.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic10").attr("src",path30);
					}else{
						$("#t4").val(pkinfo[0].appcontent2);
						$("#t5").val(pkinfo[0].appcontent1);
						$("#t7").val(pkinfo[0].seatcontent2);
						$("#t8").val(pkinfo[0].seatcontent1);
						$("#t10").val(pkinfo[0].ctrlcontent2);
						$("#t11").val(pkinfo[0].ctrlcontent1);
						var path1=pkinfo[0].appimgpath11;
						if(path1.substr(0,3)=="315"){
							path1 = path1.replace(/315/,"http://img.315che.com");
						}
						if(path1.substr(0,3)=="ct1"){
							path1 = path1.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic1").attr("src",path1);
						var path2=pkinfo[0].appimgpath12;
						if(path2.substr(0,3)=="315"){
							path2 = path2.replace(/315/,"http://img.315che.com");
						}
						if(path2.substr(0,3)=="ct1"){
							path2 = path2.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic2").attr("src",path2);
						var path3=pkinfo[0].appimgpath13;
						if(path3.substr(0,3)=="315"){
							path3 = path3.replace(/315/,"http://img.315che.com");
						}
						if(path3.substr(0,3)=="ct1"){
							path3 = path3.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic3").attr("src",path3);
						var path4=pkinfo[0].appimgpath14;
						if(path4.substr(0,3)=="315"){
							path4 = path4.replace(/315/,"http://img.315che.com");
						}
						if(path4.substr(0,3)=="ct1"){
							path4 = path4.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic4").attr("src",path4);
						var path5=pkinfo[0].seatimgpath11;
						if(path5.substr(0,3)=="315"){
							path5 = path5.replace(/315/,"http://img.315che.com");
						}
						if(path5.substr(0,3)=="ct1"){
							path5 = path5.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic5").attr("src",path5);
						var path6=pkinfo[0].seatimgpath12;
						if(path6.substr(0,3)=="315"){
							path6 = path6.replace(/315/,"http://img.315che.com");
						}
						if(path6.substr(0,3)=="ct1"){
							path6 = path6.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic6").attr("src",path6);
						var path7=pkinfo[0].seatimgpath13;
						if(path7.substr(0,3)=="315"){
							path7 = path7.replace(/315/,"http://img.315che.com");
						}
						if(path7.substr(0,3)=="ct1"){
							path7 = path7.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic7").attr("src",path7);
						var path8=pkinfo[0].ctrlimgpath11;
						if(path8.substr(0,3)=="315"){
							path8 = path8.replace(/315/,"http://img.315che.com");
						}
						if(path8.substr(0,3)=="ct1"){
							path8 = path8.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic8").attr("src",path8);
						var path9=pkinfo[0].ctrlimgpath12;
						if(path9.substr(0,3)=="315"){
							path9 = path9.replace(/315/,"http://img.315che.com");
						}
						if(path9.substr(0,3)=="ct1"){
							path9 = path9.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic9").attr("src",path9);
						var path10=pkinfo[0].seatimgpath15;
						if(path10.substr(0,3)=="315"){
							path10 = path10.replace(/315/,"http://img.315che.com");
						}
						if(path10.substr(0,3)=="ct1"){
							path10 = path10.replace(/ct1/,'${admin_che_url}');
						}
						$("#car2_pic10").attr("src",path10);
						var path21=pkinfo[0].appimgpath21;
						if(path21.substr(0,3)=="315"){
							path21 = path21.replace(/315/,"http://img.315che.com");
						}
						if(path21.substr(0,3)=="ct1"){
							path21 = path21.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic1").attr("src",path21);
						var path22=pkinfo[0].appimgpath22;
						if(path22.substr(0,3)=="315"){
							path22 = path22.replace(/315/,"http://img.315che.com");
						}
						if(path22.substr(0,3)=="ct1"){
							path22 = path22.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic2").attr("src",path22);
						var path23=pkinfo[0].appimgpath23;
						if(path23.substr(0,3)=="315"){
							path23 = path23.replace(/315/,"http://img.315che.com");
						}
						if(path23.substr(0,3)=="ct1"){
							path23 = path23.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic3").attr("src",path23);
						var path24=pkinfo[0].appimgpath24;
						if(path24.substr(0,3)=="315"){
							path24 = path24.replace(/315/,"http://img.315che.com");
						}
						if(path24.substr(0,3)=="ct1"){
							path24 = path24.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic4").attr("src",path24);
						var path25=pkinfo[0].seatimgpath21;
						if(path25.substr(0,3)=="315"){
							path25 = path25.replace(/315/,"http://img.315che.com");
						}
						if(path25.substr(0,3)=="ct1"){
							path25 = path25.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic5").attr("src",path25);
						var path26=pkinfo[0].seatimgpath12;
						if(path26.substr(0,3)=="315"){
							path26 = path26.replace(/315/,"http://img.315che.com");
						}
						if(path26.substr(0,3)=="ct1"){
							path26 = path26.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic6").attr("src",path26);
						var path27=pkinfo[0].seatimgpath13;
						if(path27.substr(0,3)=="315"){
							path27 = path27.replace(/315/,"http://img.315che.com");
						}
						if(path27.substr(0,3)=="ct1"){
							path27 = path27.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic7").attr("src",path27);
						var path28=pkinfo[0].ctrlimgpath11;
						if(path28.substr(0,3)=="315"){
							path28 = path28.replace(/315/,"http://img.315che.com");
						}
						if(path28.substr(0,3)=="ct1"){
							path28 = path28.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic8").attr("src",path28);
						var path29=pkinfo[0].ctrlimgpath12;
						if(path29.substr(0,3)=="315"){
							path29 = path29.replace(/315/,"http://img.315che.com");
						}
						if(path29.substr(0,3)=="ct1"){
							path29 = path29.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic9").attr("src",path29);
						var path30=pkinfo[0].seatimgpath25;
						if(path30.substr(0,3)=="315"){
							path30 = path30.replace(/315/,"http://img.315che.com");
						}
						if(path30.substr(0,3)=="ct1"){
							path30 = path30.replace(/ct1/,'${admin_che_url}');
						}
						$("#car1_pic10").attr("src",path30);
					}
				}else{
					$("#t1").val("");
					$("#t2").val("");
					$("#t3").val("");
					$("#t6").val("");
					$("#t9").val("");
					$("#t12").val("");
					$("#t13").val("");
					$("#t4").val("");
					$("#t5").val("");
					$("#t7").val("");
					$("#t8").val("");
					$("#t10").val("");
					$("#t11").val("");
					for(var i=1;i<11;i++){
						$("#car1_pic"+i).attr("src","${admin_che_url}image/car_pic.jpg");
						$("#car2_pic"+i).attr("src","${admin_che_url}image/car_pic.jpg");
					}
				}
	}
	
	function changeflag(id){
		$("#car"+id+"flag").val("1");
	}
	
	function callbackSucc(data)
	{	
		var id1=$("#car1flag").val();
		var id2=$("#car2flag").val();
		var num=0;
		if(parseInt(id1)==1){
			num=1
		}else if(parseInt(id2)==1){
			num=2;
		}
		if(data[0].imgPath!=""){
			for(var i=0;i<data.length;i++){
				var a=i+1
				$("#car"+num+"_img"+a).val(data[i].imgPath);
				$("#car"+num+"_pic"+a).attr("src",data[i].uploadPath);
				
			}
			
		}
		$("#car"+num+"flag").val("");
	}
	
	function SaveA(){
		var seriesId1=$("#carSeries1").val();
		var seriesId2=$("#carSeries2").val();
		$("#seriesId11").val($("#carSeries1").val());
		$("#seriesId22").val($("#carSeries2").val());
		if(parseInt(seriesId1)!=0&&parseInt(seriesId2)!=0){
			var carimg1="@";
			for(var i=1;i<11;i++){
				var path=$("#car1_img"+i).val();
				carimg1=carimg1+path+"@";
			}
			var carimg2="@";
			for(var i=1;i<11;i++){
				var path=$("#car2_img"+i).val();
				carimg2=carimg2+path+"@";
			}
			$("#carimg22").val(carimg2);
			$("#carimg11").val(carimg1);
			$("#tt1").val($("#t1").val());
			$("#tt2").val($("#t2").val());
			$("#tt3").val($("#t3").val());
			$("#tt4").val($("#t4").val());
			$("#tt5").val($("#t5").val());
			$("#tt6").val($("#t6").val());
			$("#tt7").val($("#t7").val());
			$("#tt8").val($("#t8").val());
			$("#tt9").val($("#t9").val());
			$("#tt10").val($("#t10").val());
			$("#tt11").val($("#t11").val());
			$("#tt12").val($("#t12").val());
			$("#tt13").val($("#t13").val());
			alert("更新成功");
			$("#postInfo").submit();
		}else{
			alert("请选择车系!");
		}
	}
	
</script>
<@c.uploadimg></@c.uploadimg>
</body>
</html>
