<#macro jsfile>
<script>
	$(function(){
		$(".btn_pro_in").click(function(){
			var src = "./promo_per_pro_in?pro_num="+$(this).attr("goal");
			window.parent.openNew("项目详情-"+$(this).attr("goal"),src);
		});
	});
	
	function state_search(str_state){
		$("#search_state").attr("value",str_state);
		toPage(1);
	}
	
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