<#macro jsfile>
<script>
	$(function(){
		//实现 省--市 联动
		$("#promo_prov").change(function(){
			$("#promo_city").empty();
			$("#promo_city").append("<option></option>");
			
			if($(this).val()!=""){
				$.post("./present_apply_getcity",{prov:$(this).val()},function(data){
					if(data!=""){
						var arr = data.split("|");
						for(var i=0; i<arr.length/2; i++){
							$("#promo_city").append("<option value='"+ arr[i*2] +"'>"+ arr[i*2+1] +"</option>");
						}
					}
				});
			}
		});
		
		//提交查询
		$("#btn_search").click(function(){
			$("#pro_searchType").val("");
			$("#form1").submit();
		});
		
		//为“审查”按钮添加弹框事件
		$('.btn_examine').click(function(){
			var proInf = $(this).parents("tr");
			var pro_num = proInf.find("td[tag='pro_num']").html();
			
			$.post("./ser_getProjectInfo",{pro_num:pro_num},function(result){
				var p = eval(result)[0];
				
				if(p.pro_state==1){
					$("#modal_contact_num").html(p.contact_num);  //合同号
					$("#modal_cust_name").html(p.cust_name);      //客户名称
					$("#modal_contact_date").html(p.contact_start_date+"至"+p.contact_end_date);//合同日期
					$("#modal_active_date").html(p.acti_start_date+"至"+p.acti_end_date);  //活动日期
					$("#modal_clue_num").html(p.tar_clue_num);        //目标线索量
					$("#modal_reach_num").html(p.tar_reach_num);      //目标到达量
					$("#modal_trans_num").html(p.tar_trans_num);      //目标成交量
					
					if(p.brand=="-1") p.brand_name="";
					if(p.car=="-1" || p.car=="0") p.car_name="";
					if(p.model=="-1" || p.model=="0") p.model_name="";
					
					$("#modal_brand").html(p.brand_name + " " + p.car_name + " " + p.model_name); //品牌车系和车型
					
					$("#modal_competing").html(p.competing_name);  //竞品车系
					
					$("#modal_pro_num").html(p.pro_num);          //项目编号     
					$("#modal_dept_name").html(p.dep_name);      //部门
					
					var service_type_name="看车团";
					if(p.service_type=="1")service_type_name="直销";
					if(p.service_type=="2")service_type_name="车展";
					if(p.service_type=="3")service_type_name="大客户";
					
					$("#modal_service_type").html(service_type_name);//业务类型
					$("#modal_promo_area").html(p.promo_area);    //推广地区
					$("#modal_promo_date").html(p.promo_start_date+"至"+p.promo_end_date);    //推广日期
					$("#modal_custom_service").html(p.custom_service_name);  //责任客服
					$("#modal_ini_date").html(p.ini_date);        //发起日期
					
					$('#modal_examine').modal();
				}else{
					alert("项目状态已经发生变化，需更新界面！");
					window.location.href='./promo_director_pro';
				}
				
			});
			
			
		});
		
		//为“审查”按钮添加弹框事件----补量部分
		$('.btn_bl_examine').click(function(){
			var proInf = $(this).parents("tr");
			var pro_num = proInf.find("td[tag='pro_num']").html();
			
			$.post("./promo_director_pro_getBlProjectInfo",{pro_num:pro_num},function(result){
				var p = eval(result)[0];
				var p1 = p.info1;
				var p2 = p.info2;
				if(p2.pro_state==1){
					var table_obj = $("#bl_examine_table");
					if(vl_add_data(table_obj, p1, p2)){
						$('#modal_bl_examine').modal();
					}
				}else{
					alert("项目状态已经发生变化，需更新界面！");
					window.location.href='./promo_director_pro';
				}
				
			});
		});
		
		//查看事件---补量部分
		$(".btn_bl_lookPro").click(function(){
			var proInf = $(this).parents("tr");
			var pro_num = proInf.find("td[tag='pro_num']").html();
			
			$.post("./promo_director_pro_getBlProjectInfo",{pro_num:pro_num},function(result){
				var p = eval(result)[0];
				var p1 = p.info1;
				var p2 = p.info2;
				if(p2.pro_state==4){
					var table_obj = $("#bl_look_table");
					if(vl_add_data(table_obj, p1, p2)){
						$('#modal_bl_look').modal();
					}
				}else{
					alert("项目状态已经发生变化，需更新界面！");
					window.location.href='./promo_director_pro';
				}
				
			});
		});
		
		//为“查看”按钮添加弹框事件
		$('.btn_lookPro').click(function(){
			
			var proInf = $(this).parents("tr");
			var pro_num = proInf.find("td[tag='pro_num']").html();
			
			
			$.post("./promo_per_pro_getProInfo",{pro_num:pro_num},function(result){
				var p = eval(result)[0];
				
				if(p.pro_state==0||p.pro_state==2){
					alert("该项目已经进行修改，业务主管正在审核！");
					window.location.href='./promo_director_pro';
					return;
				}
				
				
				var obj_tb = $("#tb_proinfo");     
				obj_tb.find("td[tag='pro_num']").html(p.pro_num);
				obj_tb.find("td[tag='acti_name']").html(p.acti_name);
				obj_tb.find("td[tag='dept_name']").html(p.dept_name);
				obj_tb.find("td[tag='ini_date']").html(p.ini_date);
				obj_tb.find("td[tag='service_type']").html(p.service_type);
				obj_tb.find("td[tag='contact_num']").html(p.contact_num);
				obj_tb.find("td[tag='cust_name']").html(p.cust_name);
				
				var pro_area = ""
				if(p.promo_prov=="-1"){
					pro_area = "全国";
				}else {
					pro_area = p.prov_name;
					if(p.promo_city!="-1"){
						pro_area = pro_area + p.city_name;
					}
				}
				obj_tb.find("td[tag='promo_area']").html(pro_area);
				
				if(p.brand=="-1") p.brand_name="";
				if(p.car=="-1" || p.car=="0") p.car_name="";
				if(p.model=="-1" || p.model=="0") p.model_name="";
				
				obj_tb.find("td[tag='brand']").html(p.brand_name + " " + p.car_name+ " " + p.model_name);
				
				if(!!p.competing_name){
					obj_tb.find("td[tag='competing']").html((p.competing_name).replace(/[A-Z]\?/g, ""));
				}
				
				obj_tb.find("td[tag='contact_date']").html(p.contact_start_date + "至" + p.contact_end_date);
				obj_tb.find("td[tag='promo_date']").html(p.promo_start_date + "至" + p.promo_end_date);
				obj_tb.find("td[tag='active_date']").html(p.acti_start_date + "至" + p.acti_end_date);
				obj_tb.find("td[tag='clue_num']").html(p.tar_clue_num);
				obj_tb.find("td[tag='reach_num']").html(p.tar_reach_num);
				obj_tb.find("td[tag='trans_num']").html(p.tar_trans_num);
				
				if(!!p.custom_service_name){
					obj_tb.find("td[tag='custom_service']").html(p.custom_service_name);
				}
				
				var obj_tb2 = $("#tb_prodata");
				obj_tb2.find("td[tag='baoming']").html(p.baoming_count);
				obj_tb2.find("td[tag='huifang']").html(p.visit_count);
				
				var d1 = parseInt(p.baoming_count);
				var d2 = parseInt(p.visit_count);
				var d3 = 0;
				if(d1!=0){
					d3 = Math.round(d2/d1*10000)/100.00 + "%";
				}
				
				
				obj_tb2.find("td[tag='huifang_rate']").html(d3);
				
				if(p.pro_state==3 || p.pro_state==5){
					$("#modal_ProInfo_jinzhan").show();
				}else{
					$("#modal_ProInfo_jinzhan").hide();
				}
				
				$('#modal_ProInfo').modal();
			});
			
			
			
			
//			$.post("./ser_getProjectInfo",{pro_num:pro_num},function(result){
//				var p = eval(result)[0];
//				
//				if(p.pro_state==0||p.pro_state==2){
//					alert("该项目已经进行修改，业务主管正在审核！");
//					window.location.href='./promo_director_pro';
//				}else{
//					if(p.pro_state==3||p.pro_state==4){
//						$("#look_contact_num").html(p.contact_num);  //合同号
//						$("#look_cust_name").html(p.cust_name);      //客户名称
//						$("#look_contact_date").html(p.contact_start_date+"至"+p.contact_end_date);//合同日期
//						$("#look_active_date").html(p.acti_exec_date);  //活动日期
//						$("#look_clue_num").html(p.tar_clue_num);        //目标线索量
//						$("#look_reach_num").html(p.tar_reach_num);      //目标到达量
//						$("#look_trans_num").html(p.tar_trans_num);      //目标成交量
//						
//						if(p.brand!="-1"){
//							$("#look_brand").html(p.brand_name);              //品牌
//						}
//						if(p.car!="-1" && p.car!="0"){
//							$("#look_car").html(p.car_name);  //车型
//						}
//						if(p.model!="-1" && p.model!="0"){
//							$("#look_car").html($("#look_car").html()+p.model_name);                  //车型
//						}
//						
//						$("#look_pro_num").html(p.pro_num);          //项目编号     
//						$("#look_dept_name").html(p.dep_name);      //部门
//						
//						var service_type_name="看车团";
//
//						if(p.service_type=="1")service_type_name="直销";
//						if(p.service_type=="2")service_type_name="车展";
//						if(p.service_type=="3")service_type_name="大客户";
//						
//						$("#look_service_type").html(service_type_name);//业务类型
//						$("#look_promo_area").html(p.promo_area);    //推广地区
//						$("#look_promo_date").html(p.promo_start_date+"至"+p.promo_end_date);    //推广日期
//						$("#look_custom_service").html(p.custom_service_name);  //责任客服
//						$("#look_ini_date").html(p.ini_date);        //发起日期
//						
//						$("#modal_lookPro").modal();
//						
//					}else{
//					if(p.pro_state==1){
//							alert("该项目已被修改，且业务主管已经审核通过，需您再次进行审核！");
//							window.location.href='./promo_director_pro';
//						}else{
//							alert("该项目已被删除！");
//							window.location.href='./promo_director_pro';
//						}
//					}
//					
//				}
//				
//			});
			
		});
		
		
		
		//审查通过
		$("#bt_pro_yes").click(function(){
			if($("#select_promo_man").val()==""){
				alert("请选择责任推广人员！");
				return false;
			}
			
			//alert($("#modal_pro_num").html() + "-------" + $("#select_promo_man").val());
			
			$.post("./promo_director_pro_examineYes",
					{pro_num:$("#modal_pro_num").html(),
					promo_man:$("#select_promo_man").val()},
					function(result){
						if(result=="1"){
							window.location.href='./promo_director_pro';
						}else {
							alert(result);
						}
					});
			
		});
		
		//驳回
		$("#bt_pro_no").click(function(){
			$.post("./promo_director_pro_examineNo",
					{pro_num:$("#modal_pro_num").html(),},
					function(result){
						if(result=="1"){
							window.location.href='./promo_director_pro';
						}else {
							alert(result);
						}
					});
		});
		
		//补量审查通过---------补量
		$("#bl_pro_yes").click(function(){
			$.post("./promo_director_pro_examineYesForBl",
					{pro_num:$("#bl_examine_table").find("td[tag='pro_num']").html()},
					function(result){
						if(result=="1"){
							alert("审查成功！");
							window.location.href='./promo_director_pro';
						}else {
							alert("信息提交失败，请稍后重试！");
						}
					});
		});
		
		//驳回---------补量
		$("#bl_pro_no").click(function(){
			$.post("./promo_director_pro_examineNoForBl",
					{pro_num:$("#bl_examine_table").find("td[tag='pro_num']").html()},
					function(result){
						if(result=="1"){
							alert("项目已经驳回！");
							window.location.href='./promo_director_pro';
						}else {
							alert("信息提交失败，请稍后重试！");
						}
					});
		});
	});
	
	//分页功能
	function toPage(page){
		if(page==-1){
			page=$("#topage_num").val();
			var pattern=/^[0-9]*[1-9][0-9]*$/;
			var flag = pattern.test(page);
			page = parseInt(page);
			if(flag==false || page<0 || page>$("#pages").val()){
				alert("输入页码不正确，请重新输入！");
				$("#topage_num").val("");
				return;
			}
		}
		type_num = $("#pro_searchType").val();
		if(type_num!=""){
			$("#form1").find("select").val("");
			$("#form1").find("input").val("");
		}
		$("#pro_searchType").val(type_num);
		$("#page").val(page);
		$("#form1").submit();
	}
	
	//分类查询的功能
	function searchTypeClick(type_num){
		$("#form1").find("select").val("");
		$("#form1").find("input").val("");
		$("#page").val(1);
		$("#pro_searchType").val(type_num);
		$("#form1").submit();
	}
	
	//为补量审查和查看弹框加数据
	function vl_add_data(table_obj, p1, p2){
		td_compare(table_obj, "pro_num", p1.pro_num, p2.pro_num);  //项目编号
					
		td_compare(table_obj, "contact_num", p1.contact_num, p2.contact_num);
		td_compare(table_obj, "cust_name", p1.cust_name, p2.cust_name);
		td_compare(table_obj, "contact_date", p1.contact_start_date+"至"+p1.contact_end_date, p2.contact_start_date+"至"+p2.contact_end_date);
		td_compare(table_obj, "active_date", p1.acti_start_date+"至"+p1.acti_end_date, p2.acti_start_date+"至"+p2.acti_end_date);
		td_compare(table_obj, "clue_num", p1.tar_clue_num, p2.tar_clue_num);
		td_compare(table_obj, "reach_num", p1.tar_reach_num, p2.tar_reach_num);
		td_compare(table_obj, "trans_num", p1.tar_trans_num, p2.tar_trans_num);
		
		if(p1.brand=="-1") p1.brand_name="";
		if(p1.car=="-1" || p1.car=="0") p1.car_name="";
		if(p1.model=="-1" || p1.model=="0") p1.model_name="";
		
		if(p2.brand=="-1") p2.brand_name="";
		if(p2.car=="-1" || p2.car=="0") p2.car_name="";
		if(p2.model=="-1" || p2.model=="0") p2.model_name="";
		
		td_compare(table_obj, "brand", p1.brand_name + " " + p1.car_name + " " + p1.model_name, p2.brand_name + " " + p2.car_name + " " + p2.model_name);
		td_compare(table_obj, "competing", p1.competing_name, p2.competing_name);
		
		td_compare(table_obj, "dept_name", p1.dep_name, p2.dep_name);
		
		var service_type_name1="看车团";
		if(p1.service_type=="1")service_type_name1="直销";
		if(p1.service_type=="2")service_type_name1="车展";
		if(p1.service_type=="3")service_type_name1="大客户";
		
		var service_type_name2="看车团";
		if(p2.service_type=="1")service_type_name2="直销";
		if(p2.service_type=="2")service_type_name2="车展";
		if(p2.service_type=="3")service_type_name2="大客户";
		
		td_compare(table_obj, "service_type", service_type_name1, service_type_name2);
		td_compare(table_obj, "promo_area", p1.promo_area, p2.promo_area);
		td_compare(table_obj, "promo_date", p1.promo_start_date+"至"+p1.promo_end_date, p2.promo_start_date+"至"+p2.promo_end_date);
		td_compare(table_obj, "custom_service", p1.custom_service_name, p2.custom_service_name);
		td_compare(table_obj, "ini_date", p1.ini_date, p2.ini_date);
		
		return true;
	}
	
	//对比并赋值
	function td_compare(obj, tag, val1, val2){
		if(val1==val2){
			obj.find("td[tag='"+ tag +"']").html(val1);
		}else {
			obj.find("td[tag='"+ tag +"']").html(val2).css("color","red");
		}
	}
</script>
</#macro>