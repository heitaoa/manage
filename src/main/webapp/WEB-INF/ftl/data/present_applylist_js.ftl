<#macro jsfile>
<script>
	
	var obj_vin;
	var obj_engine;
	var obj_remark;
	
	//editable提交事件
	function editable_subclick(obj_edit, obj_popover, sub_str){
		if(sub_str==""){
			obj_edit.html("Empty");
			if(!obj_edit.hasClass(editable-empty)){
				obj_edit.addClass(editable-empty);
			}
		}else {
			obj_edit.html(sub_str);
			if(obj_edit.hasClass(editable-empty)){
				obj_edit.removeClass(editable-empty);
			}
		}
		obj_popover.hide();
		return true;
	}
	
	$(function(){
		$("#select_state").find("option[value='${state!}']").attr("selected",true);
		$("#prov").find("option[value='${prov!}']").attr("selected",true);
		
		//初始化弹出图片功能
		$(".carbill_img_a").fancybox({
			'titlePosition':'inside',
			'transitionIn':'none',
			'transitionOut':'none'
		});
		
		//初始化edit功能
		$('.editable_a').editable();
		$('.editable_a').click(function(){
			$(".editable-input .input-medium").addClass("form-control");
		});
		
		//绑定editable-submit的提交事件
		$(".editable-submit").live('click', function() {
			var popover = $(this).parents(".popover");
			var td = $(this).parents("td");
			var click_a = popover.prev();
			var a_text = click_a.html();
			if(a_text=="Empty") a_text="";
			var input_text = $(this).parents("form").find(".input-medium").val();
			var tagit_id = click_a.attr("targit_id");
			
			//提交发动机编号
			if(click_a.hasClass("engine_edit")){
				var transid = click_a.attr("target_transid");
				
				$.post("./present_apply_updateCarMsg",
						{engine_num:input_text,
						trans_id:transid,
						carmsg_type:'engine'},
						function(data){
							if(data=='1'){
								editable_subclick(click_a, popover, input_text); //自定义函数，实现提交
								popover.hide();
							}else{
								alert("提交信息失败，请重试！");
							}
						});
				return;
			}
			//提交VIN车架号
			if(click_a.hasClass("vin_edit")){
				var transid = click_a.attr("target_transid");
				$.post("./present_apply_updateCarMsg",
						{vin_num:input_text,
						trans_id:transid,
						carmsg_type:'vin'},
						function(data){
							if(data=='1'){
								editable_subclick(click_a, popover, input_text); //自定义函数，实现提交
								popover.hide();
							}else{
								alert("提交信息失败，请重试！");
							}
						});
				return;
			}
			//提交备注
			if(click_a.hasClass("remark_edit")){
				
				$.post("./present_apply_updateRemark",
					{remark:input_text,
					apply_id:tagit_id},
					function(data){
						if(data=='1'){
							editable_subclick(click_a, popover, input_text); //自定义函数，实现提交
						}else{
							alert("提交信息失败，请重试！");
						}
						
					});
				return;
			}
			//提交快递单号
			if(click_a.hasClass("postbill_code_edit")){
				$.post("./present_apply_updatePostBill",
					{postbill_code:input_text,
					apply_id:tagit_id},
					function(data){
						if(data=='1'){
							editable_subclick(click_a, popover, input_text); //自定义函数，实现提交
						}else{
							alert("提交信息失败，请重试！");
						}
						
					});
				return;
			}
			
		});
		
		$(".btn_subCarMsg").click(function(){
			var targit_id = $(this).attr("targit_id");
			var transid = $(this).attr("target_transid");
			if(transid=="-1"){
				alert("该用户没有相对应的成交信息！");
				return;
			}
			var engin_str = $("#img_engine_"+targit_id).val();
			var vin_str = $("#img_vin_"+targit_id).val();
			$.post("./present_apply_updateCarMsg",
					{vin_num:vin_str,
					engine_num:engin_str,
					trans_id:transid,
					carmsg_type:'all'},
					function(data){
						if(data=='1'){
							alert("提交信息成功！");
							$("#engine_edit_"+targit_id).html(engin_str).editable();
							$("#vin_edit_"+targit_id).html(vin_str).editable();
						}else{
							alert(data);
						}
					});
		});
		
		//实现 省--市 联动
//		$("#prov").change(function(){
//			$("#city").empty();
//			$("#city").append("<option></option>");
//			
//			if($(this).val()!=""){
//				$.post("./present_apply_getcity",{prov:$(this).val()},function(data){
//					if(data!=""){
//						var arr = data.split("|");
//						for(var i=0; i<arr.length/2; i++){
//							$("#city").append("<option value='"+ arr[i*2] +"'>"+ arr[i*2+1] +"</option>");
//						}
//					}
//				});
//			}
//		});
		
		//弹出车辆信息编辑框
		$(".edit_carMsg").click(function(){
			if($(this).attr("goal")=="0"){
				alert("该车主没有购车信息，请核查！");
				return;
			}else{
				$("#trans_id").val($(this).attr("goal"));
				obj_vin = $(this).parent().children("div").eq(3);
				$("#modal_vin_num").val(obj_vin.html());
				obj_engine = $(this).parent().children("div").eq(1);
				$("#modal_engine_num").val(obj_engine.html());
				$("#modal_trans_id").val($(this).attr("goal"));
				$("#modal_carMsg").modal();
			}
		});
		
		//弹出操作人员备注编辑框
		$(".edit_remark").click(function(){
			$("#apply_id").val($(this).attr("goal"));
			obj_remark = $(this).prev();
			$("#textarea_remark").val(obj_remark.html());
			$("#modal_apply_id").val($(this).attr("goal"));
			$("#modal_remark").modal();
		});
		
		//提交车辆信息编辑
		$("#bt_sub_carMsg").click(function(){
			$.post("./present_apply_updateCarMsg",
					{engine_num:$("#modal_engine_num").val(),
					vin_num:$("#modal_vin_num").val(),
					trans_id:$("#modal_trans_id").val()},
					function(data){
						if(data=='1'){
							obj_engine.html($("#modal_engine_num").val());
							obj_vin.html($("#modal_vin_num").val());
							$("#modal_carMsg").modal('hide');
						}else{
							alert("该信息已经存在，" + data);
							$("#modal_carMsg").modal('hide');
						}
					});
		});
		
		//提交工作人员备注
		$("#bt_sub_remark").click(function(){
			$.post("./present_apply_updateRemark",
					{remark:$("#textarea_remark").val(),
					apply_id:$("#modal_apply_id").val()},
					function(data){
						if(data=='1'){
							obj_remark.html($("#textarea_remark").val());
							$("#modal_remark").modal('hide');
						}
					});
		});
		
		//操作：通过
		$(".btn_yes").click(function(){
			if(confirm("确定通过审核吗？")){
				var obj = $(this);
				$.post("./present_apply_updateState",
						{apply_state:'1',
						apply_id:obj.attr("goal"),
						trans_id:obj.parents("tr").attr("tag")},
						function(data){
							if(data=="1"){
								//改变状态
								var obj_state = obj.parent().parent().find("td[tag='state']");
								var str = "<label style='color:#090; font-weight:bold;'>已通过</label>";
								obj_state.empty();
								obj_state.append(str);
								//改变按钮
								obj.css("display","none");
								obj.parent().find(".btn_no").css("display","none");
								obj.parent().find(".btn_send").css("display","block");
							}
						});
			}else{
				return;
			}
			
		});
		
		//操作：拒绝
		$(".btn_no").click(function(){
			if(confirm("确定拒绝请求吗？")){
				var obj = $(this);
				$.post("./present_apply_updateState",
						{apply_state:'2',
						apply_id:obj.attr("goal")},
						function(data){
							if(data=="1"){
								//改变状态
								var obj_state = obj.parent().parent().find("td[tag='state']");
								var str = "<label style='color:#F00; font-weight:bold;'>已拒绝</label>";
								obj_state.empty();
								obj_state.append(str);
								//改变按钮
								obj.css("display","none");
								obj.parent().find(".btn_send").css("display","none");
								obj.parent().find(".btn_yes").css("display","block");
							}
						});
			}else{
				return;
			}
			
		});
		
		//操作：礼品发放
		$(".btn_send").click(function(){
			if(confirm("确定发放礼品吗？")){
				var obj = $(this);
				$.post("./present_apply_updateState",
						{apply_state:'3',
						apply_id:obj.attr("goal")},
						function(data){
							if(data="1"){
								//改变状态
								var obj_state = obj.parent().parent().find("td[tag='state']");
								var str = "<label style='color:#666; font-weight:bold;'>已发放</label>";
								obj_state.empty();
								obj_state.append(str);
								//改变按钮
								obj.css("display","none");
								obj.parent().find(".btn_no").css("display","none");
								obj.parent().find(".btn_yes").css("display","none");
							}
						});
			}else{
				return;
			}
		});
		
		//操作：选择礼品
		$(".btn_present").click(function(){
			var obj = $(this);
			$("#modal_present_id").val(obj.attr("goal"));
			$.post("./present_apply_getPresent",
					{apply_id:obj.attr("goal")},
					function(data){
						$("#div_present").empty();
						var arr = eval(data);
						for(var i=0; i<arr.length; i++){
							var pp=arr[i];
							var str = "<label class='col-md-12 control-label'><input type='radio' name='present' value='"+ pp.trans_id +"' />"+ pp.giving_name +"</label><br />";
							$("#div_present").prepend(str);
						}
						$("#modal_present").modal();
					});
		})
		
		//操作：指定礼品
		$("#bt_sub_present").click(function(){
			var radio = $("#div_present").find("input[type='radio']:checked");
			$.post("./present_apply_setPresent",
					{apply_id:$("#modal_present_id").val(),
					trans_id:radio.val()},
					function(data){
						if(data=="1"){
							$("#modal_present").modal("hide");
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
		$("#page").val(page);
		$("#form1").submit();
	}

</script>
</#macro>