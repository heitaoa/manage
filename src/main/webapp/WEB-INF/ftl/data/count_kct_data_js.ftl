<#macro jsfile>
<script>
	$(function(){
		
		$("#bt_close").click(function(){
			$("#modal_sign").modal('hide');
		});
		
		
		$(".btn_sign").click(function(){
			
			$.post("./count_kct_data_sign",{pro_num:$(this).attr("goal")},function(data){
				var p = eval(data);
				var tb = $("#tbody_sign");
				tb.empty();
				for(var i=0; i<p.length; i++){
					var pp = p[i];
					var str = "<tr>";
					str = str + "<td>" + (i + 1) + "</td>";
					str = str + "<td>" + pp.name + "</td>";
					str = str + "<td>" + pp.phone + "</td>";
					str = str + "<td>" + pp.baoming_date + "</td>";
					if(pp.prov==null)pp.prov='';
					if(pp.city==null)pp.city='';
					str = str + "<td>" + pp.prov + "" + pp.city + "</td>";
					str = str + "<td>" + pp.acti_name + "</td>";
					if(pp.is_trans==1){
						str = str + "<td>是</td>";
					}else{
						str = str + "<td>否</td>";
					}
					str = str + "<td></td>";
					str = str + "</tr>";
					
					
					tb.append(str);
				}
				$("#modal_sign").modal();
			});
			
		});
	});
</script>
</#macro>