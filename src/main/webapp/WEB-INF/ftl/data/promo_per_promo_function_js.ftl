<#macro jsfile>
<script>
	$(function(){
		//添加一行
		$("#btn_add_function").click(function(){
			var tr_id = $("#tbody_func").find("tr").size() + 1;
			var pro_num = $("#td_pro_num").html();
			var str_tr = "<tr tag='0'>";
			str_tr = str_tr + "<td tag='id'>"+ tr_id +"</td>";
			str_tr = str_tr + "<td tag='channel'></td>";
			str_tr = str_tr + "<td tag='url'></td>";
			str_tr = str_tr + "<td tag='pageid'></td>";
			str_tr = str_tr + "<td tag='promodate'></td>";
			str_tr = str_tr + "<td tag='remark'></td>";
			str_tr = str_tr + "<td tag='operation'><a class='func_edit' href='javascript:editFunc("+ tr_id +")' style='margin-right:20px;'>编辑</a>" 
			str_tr = str_tr + "<a class='func_delete' href='javascript:deletefunc("+ tr_id +")'>删除</a></td>";				
			str_tr = str_tr + "</tr>";
			
			$("#tbody_func").append(str_tr);
		});
		
		//提交
		$("#bt_promo_sub").click(function(){
			$("#form_function").submit();
		});
		
	});
	
	//编辑一行
	function editFunc(td_id){
		
		var pro_num = $("#td_pro_num").html();
		var tr = $("#tbody_func").find("tr").eq(parseInt(td_id)-1);
		
		if(tr.attr("tag")!="0"){
			$("#promo_channel").val(tr.find("td[tag='channel']").html());
			$("#promo_url").val(tr.find("td[tag='url']").html());
			$("#promo_pageid").val(tr.find("td[tag='pageid']").html());
			$("#promo_date").val(tr.find("td[tag='promodate']").html());
			$("#promo_remarks").val(tr.find("td[tag='remark']").html());
		}
		
		$("#hid_pro_num").val(pro_num);
		$("#hid_promo_id").val(tr.attr("tag"));
		
		$("#promo_date").datepicker({
			format: 'yyyy-mm-dd',
			autoclose: true,
			todayBtn: 'linked',
			language: 'zh-CN'
		});
		
		$("#modal_edit").modal();
		
	}
	
	
	
	
	//删除一行
	function deletefunc(td_id){
		var tbody = $("#tbody_func");
		var trs = tbody.find("tr");
		
		var tr = trs.eq(parseInt(td_id)-1);
		
		if(tr.attr("tag")=="0"){
			for(var i = parseInt(td_id); i < trs.size(); i++){
				var tds = trs.eq(i);
				tds.find("td[tag='operation']").find('.func_delete').attr("href","javascript:deletefunc("+ i +")");
				tds.find("td[tag='operation']").find('.func_edit').attr("href","javascript:editFunc("+ i +")");
				tds.find("td[tag='id']").html(i);
			}
			
			tr.remove();
		}else{
			var conf = confirm("真的要删除该组数据吗？");
			if(conf){
				$.post("./promo_per_pro_deleteFunction",
						{promo_id:tr.attr("tag")},
						function(result){
							if(result=="1"){
								alert("删除数据成功！");
								for(var i = parseInt(td_id); i < trs.size(); i++){
									var tds = trs.eq(i);
									tds.find("td[tag='operation']").find('.func_delete').attr("href","javascript:deletefunc("+ i +")");
									tds.find("td[tag='operation']").find('.func_edit').attr("href","javascript:editFunc("+ i +")");
									tds.find("td[tag='id']").html(i);
								}
								
								tr.remove();
							}else {
								alert("删除数据失败，请重试！");
							}
						});
			}
		}
	}
	
</script>
</#macro>