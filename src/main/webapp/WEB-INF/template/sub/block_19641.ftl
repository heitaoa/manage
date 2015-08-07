var str='';
str+='<h2><i class="gift-icon"></i>报名小胖看车团赢取千元购车大奖</h2>                                 ';
str+='   <div class="choujiang-contents">                                                              ';
str+='       <div class="row-a">                                                                       ';
str+='           <em class="draw-txt-a">*姓名:</em>                                                    ';
str+='           <input class="draw-text-a" type="text" />                                             ';
str+='           <em class="draw-txt-a">*手机:</em>                                                    ';
str+='           <input class="draw-text-b" type="text" />                                             ';
str+='           <em class="draw-txt-a">*省市:</em>                                                    ';
str+='           <div class="draw-select-a">                                                           ';
str+='               <select name="searchtype" id="citys" style="display:none;">                       ';
str+='                   <option value="0">请选择</option>                                             ';
str+='                   <option value="1">上海</option>                                               ';
str+='                   <option value="2">北京</option>                                               ';
str+='                   <option value="3">深圳</option>                                               ';
str+='                   <option value="4">南京</option>                                               ';
str+='                   <option value="5">杭州</option>                                               ';
str+='               </select>                                                                         ';
str+='               <script src="${www_ct_url}js/jQselect.js" type="text/javascript"></script>        ';
str+='               <script>                                                                          ';
str+='                   $(document).ready(function() {                                                ';
str+='                       $("#citys").selectbox();                                                  ';
str+='                   });                                                                           ';
str+='               </script>                                                                         ';
str+='           </div>                                                                                ';
str+='           <em class="draw-txt-a">*城市:</em>                                                    ';
str+='           <div class="draw-select-a">                                                           ';
str+='               <select name="searchtype" id="city" style="display:none;">                        ';
str+='                   <option value="0">请选择</option>                                             ';
str+='                   <option value="1">上海</option>                                               ';
str+='                   <option value="2">北京</option>                                               ';
str+='                   <option value="3">深圳</option>                                               ';
str+='                   <option value="4">南京</option>                                               ';
str+='                   <option value="5">杭州</option>                                               ';
str+='               </select>                                                                         ';
str+='               <script src="${www_ct_url}js/jQselect.js" type="text/javascript"></script>        ';
str+='               <script>                                                                          ';
str+='                   $(document).ready(function() {                                                ';
str+='                       $("#city").selectbox();                                                   ';
str+='                   });                                                                           ';
str+='               </script>                                                                         ';
str+='           </div>                                                                                ';
str+='       </div>                                                                                    ';
str+='       <div class="row-a">                                                                       ';
str+='           <em class="draw-txt-b">报名车型:</em>                                                 ';
str+='           <div class="draw-select-b">                                                           ';
str+='               <select name="searchtype" id="cartype1" style="display:none;">                    ';
str+='                   <option value="0">请选择</option>                                             ';
str+='               </select>                                                                         ';
str+='               <script src="${www_ct_url}js/jQselect.js" type="text/javascript"></script>        ';
str+='               <script>                                                                          ';
str+='                   $(document).ready(function() {                                                ';
str+='                       $("#cartype1").selectbox();                                               ';
str+='                   });                                                                           ';
str+='               </script>                                                                         ';
str+='           </div>                                                                                ';
str+='           <div class="draw-select-b">                                                           ';
str+='               <select name="searchtype" id="cartype2" style="display:none;">                    ';
str+='                   <option value="0">请选择</option>                                             ';
str+='               </select>                                                                         ';
str+='               <script src="${www_ct_url}js/jQselect.js" type="text/javascript"></script>        ';
str+='               <script>                                                                          ';
str+='                   $(document).ready(function() {                                                ';
str+='                       $("#cartype2").selectbox();                                               ';
str+='                   });                                                                           ';
str+='               </script>                                                                         ';
str+='           </div>                                                                                ';
str+='       </div>                                                                                    ';
str+='   </div>																																													;'	
document.write(str);
            
$(function(){
	$.get("http://tuan.315che.com/xp/service_forBrand",{}, function(data){
		var brand=eval(data);
		$("#cartype1").append($("<option value='0'>请选择</option>"));
		for(var i=0;i<brand.length;i++){
			var $option=$("<option value='"+brand[i].carId+"'>"+brand[i].name+"</option>");
			$("#cartype1").append($option);
		}
	})
	
	$("#cartype1").on("change",function(){
		var brand=$("#cartype1").val();
		var carId=parseInt(brand);
		if(carId>0){
			$.get("http://tuan.315che.com/xp/service_forModel?carId="+carId, function(data){
    			var brand=eval(data);
    			$("#cartype2").append($("<option value='0'>请选择</option>"));
    			for(var i=0;i<brand.length;i++){
    				var $option=$("<option value='"+brand[i].carId+"'>"+brand[i].name+"</option>");
    				$("#cartype1").append($option);
    			}
    		})
		}
	});
		
});