<!DOCTYPE html>
<html lang="zh-hans">
<head>
<meta charset="GBK">
<script src="${wap_ct_url}js/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function() {
$.ajax({
    		url : '${www_ct_url}chetuan/setInitCookie',
    		dataType : 'jsonp',
    		jsonp:'jsonpcallback',
    		success : function(data){
    			var cityId = 0;
    			if(data[0].fatherid == 0)
    				cityId = data[0].catalogid;
    			else
    				cityId = data[0].fatherid;
    		 var url = "temaihui/salelist_"+cityId+"_0_0_0.html";
	    	window.location.href = '${wap_ct_url}'+url;
    		}
});
});

</script>	
</head>
<body>
</body>
</html>