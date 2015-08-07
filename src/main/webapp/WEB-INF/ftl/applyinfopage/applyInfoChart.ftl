<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:15px;">
<form method="post" >
<table>
<tr>
<td><span>报名日期</span></td>
<td>
<div  data-date-format="yyyy-mm-dd" class="input-group  date date-picker input-inline">
			<input type="text"  class="form-control input-small input-inline" name ="addtime" value="${addtime!}" >
			<span class="input-group-btn input-inline">
			<button type="button" class="btn default input-inline"><i class="fa fa-calendar input-inline"></i></button>
			</span>
</div>
<td>&nbsp;&nbsp;&nbsp;<button class="btn blue" type="button" id="search" onclick="submitdata();">查询</button></td>
</tr>
</table>
</form>
</div>

<div class="row" style="margin-left:15px;margin-top:15px;">
<div class="fa-item">
	<i class="fa fa-child"></i><strong>人数统计:<font color="red" size=4>${count!}</font></strong>
</div>
		<div class="portlet solid bordered ">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-bar-chart-o"></i>报名时段统计
				</div>
			</div>
			<div class="portlet-body">
				<div id="site_statistics_loading">
					<img src="${admin_che_url}assets/admin/layout/img/loading.gif" alt="loading"/>
				</div>
				<div id="site_statistics_content" class="display-none">
					<div id="site_statistics" class="chart">
				</div>
				</div>
			</div>
		</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script src="${admin_che_url}assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
var visitors = [];
var datas = '<#list chartList as chart>${chart!"0"},</#list>';
var dataarry = datas.split(",");
var timearry = ['0点','1点','2点','3点','4点','5点','6点','7点','8点','9点','10点','11点','12点','13点','14点','15点','16点','17点','18点','19点','20点','21点','22点','23点'];
for(var i = 0;i<24;i++){
	visitors.push([timearry[i],dataarry[i]]);
}

$('#site_statistics_loading').hide();
$('#site_statistics_content').show();
var plot_statistics = $.plot($("#site_statistics"),
    [{
        data: visitors,
        lines: {
            fill: 0.6,
            lineWidth: 0
        },
        color: ['#fe0000']
    }, {
        data: visitors,
        points: {	
            show: true,
            fill: true,
            radius: 5,
            fillColor: "#fe0000",
            lineWidth: 3
        },
        color: '#fff',
        shadowSize: 0
    }],

    {
        xaxis: {
            tickLength: 0,
            tickDecimals: 0,
            mode: "categories",
            min: 0,
            font: {
                lineHeight: 14,
                style: "normal",
                variant: "small-caps",
                color: "#6F7B8A"
            }
        },
        yaxis: {
            ticks: 5,
            tickDecimals: 0,
            tickColor: "#eee",
            font: {
                lineHeight: 14,
                style: "normal",
                variant: "small-caps",
                color: "#6F7B8A"
            }
        },
        grid: {
            hoverable: true,
            clickable: true,
            tickColor: "#eee",
            borderColor: "#eee",
            borderWidth: 2
        }
});

                var previousPoint = null;
                $("#site_statistics").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPoint != item.dataIndex) {
                            previousPoint = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showChartTooltip(item.pageX, item.pageY, item.datapoint[0], item.datapoint[1] + ' 人 ');
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPoint = null;
                    }
                });
});
function submitdata()
{
	document.forms[0].action = "getChart";
	document.forms[0].submit();
}
 function showChartTooltip(x, y, xValue, yValue) {
                $('<div id="tooltip" class="chart-tooltip">' + yValue + '<\/div>').css({
                    position: 'absolute',
                    display: 'none',
                    top: y - 40,
                    left: x - 40,
                    border: '0px solid #ccc',
                    padding: '2px 6px',
                    'background-color': '#fff'
                }).appendTo("body").fadeIn(200);
}
</script>
</body>
</html>