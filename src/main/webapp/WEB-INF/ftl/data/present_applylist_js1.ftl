<#macro jsfile>
<script>
	
	var obj_vin;
	var obj_engine;
	var obj_remark;
	
	$(function(){
		$("#select_state").find("option[value='${state!}']").attr("selected",true);
		
		//初始化弹出图片功能
		$(".carbill_img_a").fancybox({
			'titlePosition':'inside',
			'transitionIn':'none',
			'transitionOut':'none'
		});
		
		//编辑车架号和vin号
		$(".btn_subCarMsg").click(function(){
			var targit_id = $(this).attr("targit_id");
			//var transid = $(this).attr("target_transid");
			//if(transid=="-1"){
			//	alert("该用户没有相对应的成交信息！");
			//	return;
			//}
			var engin_str = $("#img_engine_"+targit_id).val();
			var vin_str = $("#img_vin_"+targit_id).val();
			$.post("./present_apply_updateCarMsg",
					{vin_num:vin_str,
					engine_num:engin_str,
					apply_id:targit_id,
					carmsg_type:'all'},
					function(data){
						if(data=='1'){
							alert("提交信息成功！");
							$("#engine_edit_"+targit_id).html(engin_str).editable();
							$("#vin_edit_"+targit_id).html(vin_str).editable();
							$.fancybox.close()
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
								var str = "<label style='color:#090; font-weight:bold;'>已通过</label>";
								obj.parents('tr').find("td[tag='state']").empty().append(str);
								//改变按钮
								obj.attr('disabled','disabled').removeClass('blue').addClass('grey-cascade');
								obj.parent().find(".btn_no").attr('disabled','disabled').removeClass('purple').addClass('grey-cascade');
								obj.parent().find(".btn_send").removeAttr('disabled').removeClass('grey-cascade').addClass('green');
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
								var str = "<label style='color:#F00; font-weight:bold;'>已拒绝</label>";
								obj.parents('tr').find("td[tag='state']").empty().append(str);
								//改变按钮
								obj.parent().find(".btn_yes").removeAttr('disabled').removeClass('grey-cascade').addClass('blue');
								obj.attr('disabled','disabled').removeClass('purple').addClass('grey-cascade');
								obj.parent().find(".btn_send").attr('disabled','disabled').removeClass('green').addClass('grey-cascade');
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
								var str = "<label style='color:#666; font-weight:bold;'>已发放</label>";
								obj.parents('tr').find("td[tag='state']").empty().append(str);
								//改变按钮
								obj.attr('disabled','disabled').removeClass('green').addClass('grey-cascade');
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
		
		//提交车主身份证号
		$(".btn_subIdCode").click(function(){
			var targit_id = $(this).attr("targit_id");
			var reg = /^(\d{15})$|^(\d{17}[\d,x,X])$/g;
			var idcode = $("#img_idcard_"+targit_id).val();
			if(!reg.test(idcode)){
				alert("请输入正确的身份证号码！");
				return;
			}
			
			$.post("./present_apply_updateIdCord",
					{owner_idcode:idcode,
					apply_id:targit_id},
					function(data){
						if(data=='1'){
							alert("提交信息成功！");
							$("#owner_idcode_"+targit_id).html(idcode);
							$.fancybox.close()
						}else{
							alert(data);
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