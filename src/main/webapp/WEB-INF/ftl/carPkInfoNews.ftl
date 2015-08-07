<#import "common.ftl" as c>
<@c.html_head></@c.html_head>
<@c.html_body>

<div class="row">
	<div class="col-md-4">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>选择车型目录
				</div>
			</div>
			
			<div class="portlet-body">
	            	<!--<div class="scroller zTreeBg" style="height:650px;" data-always-visible="1" data-rail-visible="0">
	              		<ul id="treeMenu" class="ztree"></ul>
	            	</div> -->
	            	<div class="zTreeBg" style="height:650px; overflow-x:hidden; overflow-y:auto;">
                          <ul id="treeMenu" class="ztree"></ul>
                        </div> 
	    	</div>
	    </div>
	</div>
	<div class="col-md-8">
		<table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample_1" role="grid" aria-describedby="sample_1_info" style="width:100%;">
			<tbody>
				<tr>
					<td  class="col-md-12 sorting_1" colspan="2">
						<input id="car1" class="form-control input-inline input-medium" readonly='readonly' type="text"><input id="car1id" class="form-control input-inline input-medium" type="hidden">
						<input id="car2" class="form-control input-inline input-medium" readonly='readonly' type="text"><input id="car2id" class="form-control input-inline input-medium" type="hidden">
						<input id="car3" class="form-control input-inline input-medium" readonly='readonly' type="text"><input id="car3id" class="form-control input-inline input-medium" type="hidden">
						<input id="car4" class="form-control input-inline input-medium" readonly='readonly' type="text"><input id="car4id" class="form-control input-inline input-medium" type="hidden">
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">基本参数 <input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.jbcs')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.jbcs')">反选</td>
					<td  class="col-md-10 sorting_1" id="jbcs">
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p2">厂商指导价(元) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p16">整车质保
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p3"> 品牌
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p4"> 级别 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p8">车体结构
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p59"> 底盘结构 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p26">车门数(个) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p27">座位数(个) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p7">长×宽×高(mm) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p20">轴距(mm) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p21">前轮距(mm) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p22">后轮距(mm) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p23">最小离地间隙(mm) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p29">行李箱容积(L) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p24">车重(Kg) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p12">官方综合路况油耗(L) 
						<input class="jbcs group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p28">油箱容积(L) 
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">动力系统(发动机|变速器|性能) <input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.dlxt')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.dlxt')">反选</td>
					<td  class="col-md-10 sorting_1">
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p5">发动机
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p31"> 排量(L) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p30"> 容积(cc) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p45">发动机特有技术 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p51">环保标准
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p46"> 燃料形式 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p48">供油方式 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p34">汽缸数(个) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p35">每缸气门数(个) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p37">气门结构 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p36">压缩比 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p38">缸径
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p39"> 冲程 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p49">缸盖
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p50">缸体材质 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p52">变速箱简称
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p54"> 变速箱类型 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p53">挡位个数
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p41"> 发动机最大功率(Kw/rpm) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p43">发动机最大扭矩(N·m/rpm) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p9">最高车速(km/h) 
						<input class="dlxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p10">官方0-100加速(s) 
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">操控系统(悬架系|转向系|行驶系) <input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.ckxt')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.ckxt')">反选</td>
					<td  class="col-md-10 sorting_1">
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p85">可调悬挂 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p56">前悬挂类型 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p57">后悬挂类型 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p58">助力类型 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p63">前轮胎规格 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p64">后轮胎规格 
						<input class="ckxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p65">备胎规格 
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">安全系统(主动安全|被动安全|防盗安全)<input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.aqxt')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.aqxt')">反选</td>
					<td  class="col-md-10 sorting_1">
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p60">前制动器类型 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p61">后制动器类型 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p62">驻车制动类型 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p78">ABS防抱死 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p79">制动力分配(EBD/CBC等) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p80">刹车辅助(EBA/BAS/BA等) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p81">牵引力控制(ASR/TCS/TRC等) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p82">车身稳定控制(ESP/DSC/VSC等) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p83">自动驻车/上坡辅助 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p145">氙气大灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p147">自动头灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p148">转向头灯(辅助灯) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p151">大灯高度可调 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p152">大灯清洗装置 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p186">车内氛围灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p149">前雾灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p150">后雾灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p146">日间行车灯 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p73">安全带未系提示 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p87">胎压监测装置 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p88">零胎压继续行驶 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p190">主动转向系统 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p158">后视镜自动防眩目 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p66">驾驶座安全气囊
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p67"> 副驾驶安全气囊 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p68">前排侧气囊 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p69">后排侧气囊 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p70">前排头部气囊(气帘) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p71">后排头部气囊(气帘) 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p72">膝部气囊 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p74">发动机电子防盗 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p75">车内中控锁 
						<input class="aqxt group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p76">遥控钥匙 
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">外部配置(外部配置|座椅配置|储物装置|空调装置|多媒体配置|行车配置|内部其它配置)<input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.wbpz')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.wbpz')">反选</td>
					<td  class="col-md-10 sorting_1">
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p153">前电动车窗 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p154">后电动车窗 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p155">车窗防夹手功能 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p187">防紫外线/隔热玻璃 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p156">后视镜电动调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p157">后视镜加热 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p159">后视镜电动折叠 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p90">电动天窗 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p91">全景天窗
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p95"> 铝合金轮毂 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p180">电动吸合门 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p93">同色防擦条 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p188">后雨刷
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p163">感应雨刷
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p107">真皮座椅
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p108">运动座椅
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p117">座椅通风
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p118"> 座椅按摩 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p109">座椅高低调节
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p110">腰部支撑调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p182">肩部支撑调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p114">电动座椅记忆 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p111">前排座椅电动调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p115">前排座椅加热 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p116">后排座椅加热 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p113">后排座椅电动调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p112">后排座椅手动调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p119">后排座椅整体放倒 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p120">后排座椅比例放倒 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p121">第三排座椅 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p122">前座中央扶手 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p123">后座中央扶手 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p124">前排杯架 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p125">后排杯架 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p126">电动后备箱 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p170">车载冰箱 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p164">手动空调 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p165">自动空调 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p168">温度分区控制 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p169">空气调节/花粉过滤 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p167">后座出风口 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p166">后排独立空调
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p137"> 单碟CD  
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p185">虚拟多碟CD 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p136">CD支持MP3/WMA 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p135">外接音源接口(AUX/USB/iPod等) 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p139">单碟DVD  
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p140">多碟DVD系统 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p128">中控台彩色大屏 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p134">后排液晶屏 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p130">内置硬盘 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p184">蓝牙/车载电话 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p132">车载电视 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p141">2-3喇叭扬声器系统
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p142"> 4-5喇叭扬声器系统 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p143">6-7喇叭扬声器系统 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p144">≥8喇叭扬声器系统 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p104">行车电脑显示屏 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p101">定速巡航 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p102">泊车辅助 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p103">倒车视频影像 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p127">GPS导航系统  
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p183">定位互动服务 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p96">真皮方向盘 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p97">方向盘上下调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p98">方向盘前后调节 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p48">方向盘电动调节  
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p181">多功能方向盘 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p100">方向盘换挡 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p106">左脚休息踏板 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p162">遮阳板化妆镜 
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p161">后排侧遮阳帘  
						<input class="wbpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p160">后风挡遮阳帘 
					</td>
				</tr>
				<tr>
					<td  class="col-md-2 sorting_1">个性化配置 <input class="" type="checkbox" id="qx" data-set="#sample_1 .checkboxes" onchange="unselectParam('.gxhpz')">全选<input class="" type="checkbox" id="fx" data-set="#sample_1 .checkboxes" onchange="selectParam('.gxhpz')">反选</td>
					<td  class="col-md-10 sorting_1">
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p77">无钥匙启动系统 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p105">HUD抬头数字显示 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p171">自动泊车入位 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p172">并线辅助 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p189">主动刹车/主动安全系统 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p190">整体主动转向系统 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p173">夜视系统 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p191">中控液晶屏分屏显示 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p174">自适应巡航 
						<input class="gxhpz group-checkable" type="checkbox" data-set="#sample_1 .checkboxes" value="p94">运动外观套件 
					</td>
				</tr>
				<tr><td  class="col-md-12 sorting_1" colspan="2">
					<form action="SaveCarPkInfoNews" method="post" id="postInfo">
					<input id='carid11' name='carid1' type='hidden' readonly='readonly' value="">
					<input id='carid22' name='carid2' type='hidden' readonly='readonly' value="">
					<input id='carid33' name='carid3' type='hidden' readonly='readonly' value="">
					<input id='carid44' name='carid4' type='hidden' readonly='readonly' value="">
					<input id='params' name='params' type='hidden' readonly='readonly' value="">
					<button class="btn green" onclick="SaveA()" type="button" >更新</button>
					</form>
				</td></tr>
			</tbody>
		</table>
	</div>
</div>

</@c.html_body>
<@c.html_js></@c.html_js>
<script type="text/javascript">
$(document).ready(function() {
	createTree("车型目录",'treeMenu');
});

function onClick(treeId, treeNode, clickFlag){
	id=clickFlag.id;
	var num=0;
	if(clickFlag.level==2){
		for(var i=1;i<5;i++){
			var aa=$("#car"+i).val();
			if(aa==""){
				num++;
			}
		}
		if(num==0){
			alert("最多添加4个车型");
		}else{
			var num1=4-num+1;
			$("#car"+num1).val(clickFlag.name);
			$("#car"+num1+"id").val(id);
		}
	}
}

function SaveA(){
	var checks=$(".group-checkable");
	var params="@p1";
	for(var i=0;i<checks.length;i++){
		if(checks[i].checked){
		params=params+"@"+checks[i].value;
		}
	}
	params=params+"@";
	$("#params").val(params);
	var carid1=$("#car1id").val();
	var carid2=$("#car2id").val();
	var carid3=$("#car3id").val();
	var carid4=$("#car4id").val();
	if(carid1!=""||carid2!=""||carid3!=""||carid4!=""){
		if(carid2==""){
			carid2=0;
		}
		if(carid3==""){
			carid3=0;
		}
		if(carid4==""){
			carid4=0;
		}
		$("#carid11").val(carid1);
		$("#carid22").val(carid2);
		$("#carid33").val(carid3);
		$("#carid44").val(carid4);
		if(params.length>2){
			$("#postInfo").submit();
		}else{
			alert("请选择对比项");
		}
		
	}else{
		alert("请选择车型");
	}
	
}

function unselectParam(id){
	var ids=$(id);
	if($(id)[0].checked){
		for(var i=0;i<ids.length;i++){
			$($(id)[i]).prop("checked",false).uniform();
		}
	}else{
		for(var i=0;i<ids.length;i++){
			$($(id)[i]).prop("checked",true).uniform();
		}
	}
	
}

function selectParam(id){
	var ids=$(id);
	for(var i=0;i<ids.length;i++){
		if($(id)[i].checked){
			$($(id)[i]).prop("checked",false).uniform();
		}else{
			$($(id)[i]).prop("checked",true).uniform();
		}
		
	}
}

</script>
</body>
</html>