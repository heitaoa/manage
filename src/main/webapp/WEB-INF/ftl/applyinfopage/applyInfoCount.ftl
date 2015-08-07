<#import "../common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>
<div class="row" style="margin-left:30px;">
<font size="3" color="red">*注:按报名手机归属地去重后的统计结果</font>
</div>

<div class="row" style="margin-left:15px;margin-top:15px;">
				<div class="portlet box blue" style="margin-left:15px;margin-top:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>统计概况
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 今日${provName!}报名
									</th>
									<th>
										 昨日${provName!}报名
									</th>
									<th>
										昨日全国报名
									</th>
								</tr>
								</thead>
								<tbody>
						          <tr>
						          <td><font size="8">${nowCount!}</font></td>
						          <td><font size="8">${yesCount!}</td>
						          <td><font size="8">${totalCount!}</font></td>
						          </tr>
								</tbody>
								</table>
							</div>
						</div>
					</div>
</div>

<div class="row" style="margin-left:15px;margin-top:15px;padding-left:15px;margin-right:25px;">
<div class="portlet box blue" >
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>趋势分析
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
							</div>
						</div>
						<div style="display: block;" class="portlet-body">
							<div style="padding: 0px; position: relative;" id="chart_2" class="chart">
							</div>
						</div>
</div>						
</div>


<div class="row" style="margin-left:15px;margin-top:15px;">
					<div class="portlet box blue" style="margin-left:15px;margin-top:15px;">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>详细数据
							</div>
							<div class="tools">
								<a class="collapse" href="javascript:;">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										时间
									</th>
									<th>
										${provName!}报名人数
									</th>
									<th>
										全国报名人数
									</th>
								</tr>
								</thead>
								<tbody>
						         <#list cusCount as count>
						        <tr>
						        <td>${count.date!}</td>
						        <td>${count.provCount!}</td>
						        <td>${count.chinaCount!}</td>
						        </tr>
						        </#list>
								</tbody>
								</table>
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



<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.min.js"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.stack.min.js"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.crosshair.min.js"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.time.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/flot/jquery.flot.time.min.js" type="text/javascript"></script>

<script src="${admin_che_url}assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="${admin_che_url}assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<script type="text/javascript">
var chinaviews = [];
var provviews  = [];
var timearray  = [];
<#list desCount as  count>timearray.push(${count.date2});</#list>

var provdata = "<#list desCount as count>${count.provCount!},</#list>";
var provdataarray = provdata.split(",");

var chinadata = "<#list desCount as count>${count.chinaCount!},</#list>";
var chinadataarray = chinadata.split(",");

for(var i = 0;i<timearray.length;i++){
	chinaviews.push([new Date(timearray[i]),chinadataarray[i]]);
	provviews.push([new Date(timearray[i]),provdataarray[i]]);
}
//provviews = [['2015-01-01',20],['2015-01-02',30],['2015-01-03',20],['2015-01-04',40],['2015-01-05',30]];
//chinaviews = [['2015-01-01',120],['2015-01-02',130],['2015-01-03',120],['2015-01-04',140],['2015-01-05',130]];

//provviews = [[new Date('2015-01-01'),20],[new Date('2015-01-02'),30],[new Date('2015-01-03'),40],[new Date('2015-01-04'),50],[new Date('2015-01-05'),60]];
//chinaviews = [[new Date('2015-01-01'),30],[new Date('2015-01-02'),40],[new Date('2015-01-03'),50],[new Date('2015-01-04'),60],[new Date('2015-01-05'),70]];

var plot = $.plot($("#chart_2"), [{
            data: chinaviews,
            label: "全国报名",
            lines: {
                lineWidth: 2
            },
            shadowSize: 0

        }, {
            data: provviews,
            label: "${provName!}报名",
            lines: {
                lineWidth: 2
            },
            shadowSize: 0
        }
    ], {
        series: {
            lines: {
                show: true,
                lineWidth: 2,
                fill: true,
                fillColor: {
                    colors: [{
                            opacity: 0.05
                        }, {
                            opacity: 0.01
                        }
                    ]
                }
            },
            points: {
                show: true,
                radius: 3,
                lineWidth: 1
            },
            shadowSize: 2
        },
        grid: {
            hoverable: true,
            clickable: true,
            tickColor: "#eee",
            borderColor: "#eee",
            borderWidth: 1
        },
        colors: ["#d12610", "#37b7f3", "#52e136"],
        xaxis: {
        	mode: "time",
        	timeformat: "%Y-%m-%d"
        },
        yaxis: {
            ticks: 11,
            tickDecimals: 0,
            tickColor: "#eee",
        }
});


function showTooltip(x, y, contents) {
    $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y + 5,
                left: x + 15,
                border: '1px solid #333',
                padding: '4px',
                color: '#fff',
                'border-radius': '3px',
                'background-color': '#333',
                opacity: 0.80
            }).appendTo("body").fadeIn(200);
    }

    var previousPoint = null;
    $("#chart_2").bind("plothover", function (event, pos, item) {
        $("#x").text(pos.x.toFixed(2));
        $("#y").text(pos.y.toFixed(2));

        if (item) {
            if (previousPoint != item.dataIndex) {
                previousPoint = item.dataIndex;

                $("#tooltip").remove();
                var x = item.datapoint[0],
                    y = item.datapoint[1];

                showTooltip(item.pageX, item.pageY,item.series.label + ' '+ y + ' 人');
            }
        } else {
            $("#tooltip").remove();
            previousPoint = null;
        }
  });

</script>
</body>
</html>