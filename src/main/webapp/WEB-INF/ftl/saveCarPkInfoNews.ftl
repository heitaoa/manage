<table align="center" width="500" bordercolor="#cccccc" style="border-collapse: collapse;" border="1" cellspacing="0" cellpadding="0">
    <tbody>
    	<tr bgcolor="#fcf8d1">
            <td align="center" style="color: rgb(255, 255, 255);" bgcolor="#2a7d9e" height="24" colspan="3"><strong><a  style="COLOR: black; TEXT-DECORATION: none" target="_blank">车型</a>参数</strong></td>
        </tr>
        
        <tr bgcolor="#d8e4eb" height="24">
        <td></td>
        <#list autoList as auto>
        <td align="center">${auto.p1}</td>
        </#list>
        </tr>
       
        <#if params?contains("@p2@")==true>
        <tr>
        <td>厂商指导价(元)</td>
        <#list autoList as auto>
        <td align="center">${auto.p2}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p16@")==true>
        <tr>
        <td>整车质保</td>
        <#list autoList as auto>
        <td align="center">${auto.p16}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p3@")==true>
        <tr>
        <td>品牌</td>
        <#list autoList as auto>
        <td align="center">${auto.p3}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p4@")==true>
        <tr>
        <td>级别</td>
        <#list autoList as auto>
        <td align="center">${auto.p4}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p8@")==true>
        <tr>
        <td>车体结构</td>
        <#list autoList as auto>
        <td align="center">${auto.p8}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p59@")==true>
        <tr>
        <td>底盘结构 </td>
        <#list autoList as auto>
        <td align="center">${auto.p59}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p26@")==true>
        <tr>
        <td>车门数(个)</td>
        <#list autoList as auto>
        <td align="center">${auto.p26}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p27@")==true>
        <tr>
        <td>座位数(个)</td>
        <#list autoList as auto>
        <td align="center">${auto.p27}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p7@")==true>
        <tr>
        <td>长×宽×高(mm) </td>
        <#list autoList as auto>
        <td align="center">${auto.p7}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p20@")==true>
        <tr>
        <td>轴距(mm) </td>
        <#list autoList as auto>
        <td align="center">${auto.p20}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p21@")==true>
        <tr>
        <td>前轮距(mm)</td>
        <#list autoList as auto>
        <td align="center">${auto.p21}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p22@")==true>
        <tr>
        <td>后轮距(mm) </td>
        <#list autoList as auto>
        <td align="center">${auto.p22}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p23@")==true>
        <tr>
        <td>最小离地间隙(mm) </td>
        <#list autoList as auto>
        <td align="center">${auto.p23}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p29@")==true>
        <tr>
        <td>行李箱容积(L)</td>
        <#list autoList as auto>
        <td align="center">${auto.p29}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p24@")==true>
        <tr>
        <td>车重(Kg) </td>
        <#list autoList as auto>
        <td align="center">${auto.p24}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p12@")==true>
        <tr>
        <td>官方综合路况油耗(L)</td>
        <#list autoList as auto>
        <td align="center">${auto.p12}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p28@")==true>
        <tr>
        <td>油箱容积(L)</td>
        <#list autoList as auto>
        <td align="center">${auto.p28}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p5@")==true>
        <tr>
        <td>发动机</td>
        <#list autoList as auto>
        <td align="center">${auto.p5}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p31@")==true>
        <tr>
        <td>排量(L) </td>
        <#list autoList as auto>
        <td align="center">${auto.p31}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p30@")==true>
        <tr>
        <td> 容积(cc) </td>
        <#list autoList as auto>
        <td align="center">${auto.p30}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p45@")==true>
        <tr>
        <td>发动机特有技术</td>
        <#list autoList as auto>
        <td align="center">${auto.p45}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p51@")==true>
        <tr>
        <td>环保标准</td>
        <#list autoList as auto>
        <td align="center">${auto.p51}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p46@")==true>
        <tr>
        <td>燃料形式</td>
        <#list autoList as auto>
        <td align="center">${auto.p46}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p48@")==true>
        <tr>
        <td>供油方式</td>
        <#list autoList as auto>
        <td align="center">${auto.p48}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p34@")==true>
        <tr>
        <td>汽缸数(个)</td>
        <#list autoList as auto>
        <td align="center">${auto.p34}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p35@")==true>
        <tr>
        <td>每缸气门数(个)</td>
        <#list autoList as auto>
        <td align="center">${auto.p35}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p37@")==true>
        <tr>
        <td>气门结构 </td>
        <#list autoList as auto>
        <td align="center">${auto.p37}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p36@")==true>
        <tr>
        <td>压缩比</td>
        <#list autoList as auto>
        <td align="center">${auto.p36}</td>
        </#list>
        </tr>
        </#if>
        <#if params?contains("@p38@")==true>
        <tr>
        <td>缸径</td>
        <#list autoList as auto>
        <td align="center">${auto.p38}</td>
        </#list>
        </tr>
		</#if>
		<#if params?contains("@p39@")==true>
        <tr>
        <td>冲程</td>
        <#list autoList as auto>
        <td align="center">${auto.p39}</td>
        </#list>
        </tr></#if><#if params?contains("@p49@")==true><tr>
        <td>缸盖</td>
        <#list autoList as auto>
        <td align="center">${auto.p49}</td>
        </#list>
        </tr></#if><#if params?contains("@p50@")==true>
        <tr>
        <td>缸体材质 </td>
        <#list autoList as auto>
        <td align="center">${auto.p50}</td>
        </#list>
        </tr></#if><#if params?contains("@p52@")==true>
        <tr>
        <td>变速箱简称</td>
        <#list autoList as auto>
        <td align="center">${auto.p52}</td>
        </#list>
        </tr></#if><#if params?contains("@p54@")==true>
        <tr>
        <td>变速箱类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p54}</td>
        </#list>
        </tr></#if><#if params?contains("@p53@")==true>
        <tr>
        <td>挡位个数</td>
        <#list autoList as auto>
        <td align="center">${auto.p53}</td>
        </#list>
        </tr></#if><#if params?contains("@p41@")==true><tr>
        <td>发动机最大功率(Kw/rpm)</td>
        <#list autoList as auto>
        <td align="center">${auto.p41}</td>
        </#list>
        </tr></#if><#if params?contains("@p43@")==true>
        <tr>
        <td>发动机最大扭矩(N·m/rpm)</td>
        <#list autoList as auto>
        <td align="center">${auto.p43}</td>
        </#list>
        </tr></#if><#if params?contains("@p9@")==true>
        <tr>
        <td>最高车速(km/h)</td>
        <#list autoList as auto>
        <td align="center">${auto.p9}</td>
        </#list>
        </tr></#if><#if params?contains("@p10@")==true><tr>
        <td>官方0-100加速(s)</td>
        <#list autoList as auto>
        <td align="center">${auto.p10}</td>
        </#list>
        </tr></#if><#if params?contains("@p85@")==true>
        <tr>
        <td>可调悬挂</td>
        <#list autoList as auto>
        <td align="center">${auto.p85}</td>
        </#list>
        </tr></#if><#if params?contains("@p56@")==true>
        <tr>
        <td>前悬挂类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p56}</td>
        </#list>
        </tr></#if><#if params?contains("@p57@")==true>
        <tr>
        <td>后悬挂类型 </td>
        <#list autoList as auto>
        <td align="center">${auto.p57}</td>
        </#list>
        </tr></#if><#if params?contains("@p58@")==true>
        <tr>
        <td>助力类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p58}</td>
        </#list>
        </tr></#if><#if params?contains("@p63@")==true><tr>
        <td>前轮胎规格</td>
        <#list autoList as auto>
        <td align="center">${auto.p63}</td>
        </#list>
        </tr></#if><#if params?contains("@p64@")==true>
        <tr>
        <td>后轮胎规格</td>
        <#list autoList as auto>
        <td align="center">${auto.p64}</td>
        </#list>
        </tr></#if><#if params?contains("@p65@")==true>
        <tr>
        <td>备胎规格</td>
        <#list autoList as auto>
        <td align="center">${auto.p65}</td>
        </#list>
        </tr></#if><#if params?contains("@p60@")==true>
        <tr>
        <td>前制动器类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p60}</td>
        </#list>
        </tr></#if><#if params?contains("@p61@")==true>
        <tr>
        <td>后制动器类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p61}</td>
        </#list>
        </tr></#if><#if params?contains("@p62@")==true>
        <tr>
        <td>驻车制动类型</td>
        <#list autoList as auto>
        <td align="center">${auto.p62}</td>
        </#list>
        </tr></#if><#if params?contains("@p78@")==true><tr>
        <td>ABS防抱死</td>
        <#list autoList as auto>
        <td align="center">${auto.p78}</td>
        </#list>
        </tr></#if><#if params?contains("@p79@")==true>
        <tr>
        <td>制动力分配(EBD/CBC等)</td>
        <#list autoList as auto>
        <td align="center">${auto.p79}</td>
        </#list>
        </tr></#if><#if params?contains("@p80@")==true>
        <tr>
        <td>刹车辅助(EBA/BAS/BA等)</td>
        <#list autoList as auto>
        <td align="center">${auto.p80}</td>
        </#list>
        </tr></#if><#if params?contains("@p81@")==true>
        <tr>
        <td>牵引力控制(ASR/TCS/TRC等) </td>
        <#list autoList as auto>
        <td align="center">${auto.p81}</td>
        </#list>
        </tr></#if><#if params?contains("@p82@")==true><tr>
        <td>车身稳定控制(ESP/DSC/VSC等)</td>
        <#list autoList as auto>
        <td align="center">${auto.p82}</td>
        </#list>
        </tr></#if><#if params?contains("@p83@")==true>
        <tr>
        <td>自动驻车/上坡辅助</td>
        <#list autoList as auto>
        <td align="center">${auto.p83}</td>
        </#list>
        </tr></#if><#if params?contains("@p145@")==true>
        <tr>
        <td>氙气大灯</td>
        <#list autoList as auto>
        <td align="center">${auto.p145}</td>
        </#list>
        </tr></#if><#if params?contains("@p147@")==true>
        <tr>
        <td>自动头灯</td>
        <#list autoList as auto>
        <td align="center">${auto.p147}</td>
        </#list>
        </tr></#if><#if params?contains("@p148@")==true>
        <tr>
        <td>转向头灯(辅助灯)</td>
        <#list autoList as auto>
        <td align="center">${auto.p148}</td>
        </#list>
        </tr></#if><#if params?contains("@p151@")==true>
        <tr>
        <td>大灯高度可调</td>
        <#list autoList as auto>
        <td align="center">${auto.p151}</td>
        </#list>
        </tr></#if><#if params?contains("@p152@")==true>
        <tr>
        <td>大灯清洗装置</td>
        <#list autoList as auto>
        <td align="center">${auto.p152}</td>
        </#list>
        </tr></#if><#if params?contains("@p186@")==true>
        <tr>
        <td>车内氛围灯</td>
        <#list autoList as auto>
        <td align="center">${auto.p186}</td>
        </#list>
        </tr></#if><#if params?contains("@p149@")==true>
        <tr>
        <td>前雾灯</td>
        <#list autoList as auto>
        <td align="center">${auto.p149}</td>
        </#list>
        </tr></#if><#if params?contains("@p150@")==true>
        <tr>
        <td>后雾灯</td>
        <#list autoList as auto>
        <td align="center">${auto.p150}</td>
        </#list>
        </tr></#if><#if params?contains("@p146@")==true>
        <tr>
        <td>日间行车灯 </td>
        <#list autoList as auto>
        <td align="center">${auto.p146}</td>
        </#list>
        </tr></#if><#if params?contains("@p73@")==true>
        <tr>
        <td>安全带未系提示</td>
        <#list autoList as auto>
        <td align="center">${auto.p73}</td>
        </#list>
        </tr></#if><#if params?contains("@p87@")==true><tr>
        <td>胎压监测装置</td>
        <#list autoList as auto>
        <td align="center">${auto.p87}</td>
        </#list>
        </tr></#if><#if params?contains("@p88@")==true>
        <tr>
        <td>零胎压继续行驶</td>
        <#list autoList as auto>
        <td align="center">${auto.p88}</td>
        </#list>
        </tr></#if><#if params?contains("@p190@")==true>
        <tr>
        <td>主动转向系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p190}</td>
        </#list>
        </tr></#if><#if params?contains("@p158@")==true>
        
        <tr>
        <td>后视镜自动防眩目</td>
        <#list autoList as auto>
        <td align="center">${auto.p158}</td>
        </#list>
        </tr></#if><#if params?contains("@p66@")==true>
        <tr>
        <td>驾驶座安全气囊</td>
        <#list autoList as auto>
        <td align="center">${auto.p66}</td>
        </#list>
        </tr></#if><#if params?contains("@p67@")==true><tr>
        <td>副驾驶安全气囊</td>
        <#list autoList as auto>
        <td align="center">${auto.p67}</td>
        </#list>
        </tr></#if><#if params?contains("@p68@")==true><tr>
        <td>前排侧气囊 </td>
        <#list autoList as auto>
        <td align="center">${auto.p68}</td>
        </#list>
        </tr></#if><#if params?contains("@p69@")==true>
        <tr>
        <td>后排侧气囊</td>
        <#list autoList as auto>
        <td align="center">${auto.p69}</td>
        </#list>
        </tr></#if><#if params?contains("@p70@")==true>
        <tr>
        <td>前排头部气囊(气帘) </td>
        <#list autoList as auto>
        <td align="center">${auto.p70}</td>
        </#list>
        </tr></#if><#if params?contains("@p71@")==true>
        <tr>
        <td>后排头部气囊(气帘)</td>
        <#list autoList as auto>
        <td align="center">${auto.p71}</td>
        </#list>
        </tr></#if><#if params?contains("@p72@")==true>
        <tr>
        <td>膝部气囊</td>
        <#list autoList as auto>
        <td align="center">${auto.p72}</td>
        </#list>
        </tr></#if><#if params?contains("@p74@")==true>
        <tr>
        <td>发动机电子防盗</td>
        <#list autoList as auto>
        <td align="center">${auto.p74}</td>
        </#list>
        </tr></#if><#if params?contains("@p75@")==true><tr>
        <td>车内中控锁</td>
        <#list autoList as auto>
        <td align="center">${auto.p75}</td>
        </#list>
        </tr></#if><#if params?contains("@p76@")==true>
        <tr>
        <td>遥控钥匙</td>
        <#list autoList as auto>
        <td align="center">${auto.p76}</td>
        </#list>
        </tr></#if><#if params?contains("@p153@")==true>
        <tr>
        <td>前电动车窗</td>
        <#list autoList as auto>
        <td align="center">${auto.p153}</td>
        </#list>
        </tr></#if><#if params?contains("@p154@")==true>
        <tr>
        <td>后电动车窗</td>
        <#list autoList as auto>
        <td align="center">${auto.p154}</td>
        </#list>
        </tr></#if><#if params?contains("@p155@")==true>
        
        <tr>
        <td>车窗防夹手功能</td>
        <#list autoList as auto>
        <td align="center">${auto.p155}</td>
        </#list>
        </tr></#if><#if params?contains("@p187@")==true><tr>
        <td>防紫外线/隔热玻璃</td>
        <#list autoList as auto>
        <td align="center">${auto.p187}</td>
        </#list>
        </tr></#if><#if params?contains("@p156@")==true><tr>
        <td>后视镜电动调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p156}</td>
        </#list>
        </tr></#if><#if params?contains("@p157@")==true>
        <tr>
        <td>后视镜加热</td>
        <#list autoList as auto>
        <td align="center">${auto.p157}</td>
        </#list>
        </tr></#if><#if params?contains("@p159@")==true>
        <tr>
        <td>后视镜电动折叠</td>
        <#list autoList as auto>
        <td align="center">${auto.p159}</td>
        </#list>
        </tr></#if><#if params?contains("@p90@")==true>
        <tr>
        <td>电动天窗 </td>
        <#list autoList as auto>
        <td align="center">${auto.p90}</td>
        </#list>
        </tr></#if><#if params?contains("@p91@")==true>
        
        <tr>
        <td>全景天窗 </td>
        <#list autoList as auto>
        <td align="center">${auto.p91}</td>
        </#list>
        </tr></#if><#if params?contains("@p95@")==true>
        <tr>
        <td>铝合金轮毂</td>
        <#list autoList as auto>
        <td align="center">${auto.p95}</td>
        </#list>
        </tr></#if><#if params?contains("@p180@")==true>
        
        <tr>
        <td>电动吸合门</td>
        <#list autoList as auto>
        <td align="center">${auto.p180}</td>
        </#list>
        </tr></#if><#if params?contains("@p93@")==true>
        <tr>
        <td>同色防擦条</td>
        <#list autoList as auto>
        <td align="center">${auto.p93}</td>
        </#list>
        </tr></#if><#if params?contains("@p188@")==true>
        <tr>
        <td>后雨刷 </td>
        <#list autoList as auto>
        <td align="center">${auto.p188}</td>
        </#list>
        </tr></#if><#if params?contains("@p163@")==true><tr>
        <td>感应雨刷 </td>
        <#list autoList as auto>
        <td align="center">${auto.p163}</td>
        </#list>
        </tr></#if><#if params?contains("@p107@")==true>
        <tr>
        <td>真皮座椅</td>
        <#list autoList as auto>
        <td align="center">${auto.p107}</td>
        </#list>
        </tr></#if><#if params?contains("@p108@")==true>
        
        <tr>
        <td>运动座椅</td>
        <#list autoList as auto>
        <td align="center">${auto.p108}</td>
        </#list>
        </tr></#if><#if params?contains("@p117@")==true>
        <tr>
        <td>座椅通风</td>
        <#list autoList as auto>
        <td align="center">${auto.p117}</td>
        </#list>
        </tr></#if><#if params?contains("@p118@")==true>
        <tr>
        <td>座椅按摩</td>
        <#list autoList as auto>
        <td align="center">${auto.p118}</td>
        </#list>
        </tr></#if><#if params?contains("@p109@")==true>
        <tr>
        <td>座椅高低调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p109}</td>
        </#list>
        </tr></#if><#if params?contains("@p110@")==true>
        <tr>
        <td>腰部支撑调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p110}</td>
        </#list>
        </tr></#if><#if params?contains("@p182@")==true>
        <tr>
        <td>肩部支撑调节 </td>
        <#list autoList as auto>
        <td align="center">${auto.p182}</td>
        </#list>
        </tr></#if><#if params?contains("@p114@")==true>
        <tr>
        <td>电动座椅记忆</td>
        <#list autoList as auto>
        <td align="center">${auto.p114}</td>
        </#list>
        </tr></#if><#if params?contains("@p111@")==true>
        <tr>
        <td>前排座椅电动调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p111}</td>
        </#list>
        </tr></#if><#if params?contains("@p115@")==true>
        <tr>
        <td>前排座椅加热</td>
        <#list autoList as auto>
        <td align="center">${auto.p115}</td>
        </#list>
        </tr></#if><#if params?contains("@p116@")==true>
        <tr>
        <td>后排座椅加热</td>
        <#list autoList as auto>
        <td align="center">${auto.p116}</td>
        </#list>
        </tr></#if><#if params?contains("@p113@")==true>
        <tr>
        <td>后排座椅电动调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p113}</td>
        </#list>
        </tr></#if><#if params?contains("@p112@")==true>
        <tr>
        <td>后排座椅手动调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p112}</td>
        </#list>
        </tr></#if><#if params?contains("@p119@")==true>
        <tr>
        <td>后排座椅整体放倒</td>
        <#list autoList as auto>
        <td align="center">${auto.p119}</td>
        </#list>
        </tr></#if><#if params?contains("@p120@")==true>
        <tr>
        <td>后排座椅比例放倒</td>
        <#list autoList as auto>
        <td align="center">${auto.p120}</td>
        </#list>
        </tr></#if><#if params?contains("@p121@")==true>
        <tr>
        <td>第三排座椅</td>
        <#list autoList as auto>
        <td align="center">${auto.p121}</td>
        </#list>
        </tr></#if><#if params?contains("@p122@")==true>
        <tr>
        <td>前座中央扶手</td>
        <#list autoList as auto>
        <td align="center">${auto.p122}</td>
        </#list>
        </tr></#if><#if params?contains("@p123@")==true>
        <tr>
        <td>后座中央扶手</td>
        <#list autoList as auto>
        <td align="center">${auto.p123}</td>
        </#list>
        </tr></#if><#if params?contains("@p124@")==true>
        <tr>
        <td>前排杯架</td>
        <#list autoList as auto>
        <td align="center">${auto.p124}</td>
        </#list>
        </tr></#if><#if params?contains("@p125@")==true>
        <tr>
        <td>后排杯架 </td>
        <#list autoList as auto>
        <td align="center">${auto.p125}</td>
        </#list>
        </tr></#if><#if params?contains("@p126@")==true>
        <tr>
        <td>电动后备箱</td>
        <#list autoList as auto>
        <td align="center">${auto.p126}</td>
        </#list>
        </tr></#if><#if params?contains("@p170@")==true>
        <tr>
        <td>车载冰箱</td>
        <#list autoList as auto>
        <td align="center">${auto.p170}</td>
        </#list>
        </tr></#if><#if params?contains("@p164@")==true>
        <tr>
        <td>手动空调 </td>
        <#list autoList as auto>
        <td align="center">${auto.p164}</td>
        </#list>
        </tr></#if><#if params?contains("@p165@")==true>
        <tr>
        <td>自动空调</td>
        <#list autoList as auto>
        <td align="center">${auto.p165}</td>
        </#list>
        </tr></#if><#if params?contains("@p168@")==true>
        <tr>
        <td>温度分区控制</td>
        <#list autoList as auto>
        <td align="center">${auto.p168}</td>
        </#list>
        </tr></#if><#if params?contains("@p169@")==true>
        <tr>
        <td>空气调节/花粉过滤</td>
        <#list autoList as auto>
        <td align="center">${auto.p169}</td>
        </#list>
        </tr></#if><#if params?contains("@p167@")==true>
        <tr>
        <td>后座出风口</td>
        <#list autoList as auto>
        <td align="center">${auto.p167}</td>
        </#list>
        </tr></#if><#if params?contains("@p166@")==true>
        <tr>
        <td>后排独立空调</td>
        <#list autoList as auto>
        <td align="center">${auto.p166}</td>
        </#list>
        </tr></#if><#if params?contains("@p137@")==true>
        <tr>
        <td> 单碟CD</td>
        <#list autoList as auto>
        <td align="center">${auto.p137}</td>
        </#list>
        </tr></#if><#if params?contains("@p185@")==true>
        <tr>
        <td>虚拟多碟CD</td>
        <#list autoList as auto>
        <td align="center">${auto.p185}</td>
        </#list>
        </tr></#if><#if params?contains("@p136@")==true>
        <tr>
        <td>CD支持MP3/WMA</td>
        <#list autoList as auto>
        <td align="center">${auto.p136}</td>
        </#list>
        </tr></#if><#if params?contains("@p135@")==true>
        <tr>
        <td>外接音源接口(AUX/USB/iPod等) </td>
        <#list autoList as auto>
        <td align="center">${auto.p135}</td>
        </#list>
        </tr></#if><#if params?contains("@p139@")==true>
        <tr>
        <td>单碟DVD</td>
        <#list autoList as auto>
        <td align="center">${auto.p139}</td>
        </#list>
        </tr></#if><#if params?contains("@p140@")==true><tr>
        <td>多碟DVD系统 </td>
        <#list autoList as auto>
        <td align="center">${auto.p140}</td>
        </#list>
        </tr></#if><#if params?contains("@p128@")==true>
        <tr>
        <td>中控台彩色大屏</td>
        <#list autoList as auto>
        <td align="center">${auto.p128}</td>
        </#list>
        </tr></#if><#if params?contains("@p134@")==true>
        <tr>
        <td>后排液晶屏</td>
        <#list autoList as auto>
        <td align="center">${auto.p134}</td>
        </#list>
        </tr></#if><#if params?contains("@p130@")==true>
        <tr>
        <td>内置硬盘</td>
        <#list autoList as auto>
        <td align="center">${auto.p130}</td>
        </#list>
        </tr></#if><#if params?contains("@p184@")==true><tr>
        <td>内置硬盘</td>
        <#list autoList as auto>
        <td align="center">${auto.p184}</td>
        </#list>
        </tr></#if><#if params?contains("@p132@")==true>
        <tr>
        <td>车载电视</td>
        <#list autoList as auto>
        <td align="center">${auto.p132}</td>
        </#list>
        </tr></#if><#if params?contains("@p141@")==true>
        <tr>
        <td>2-3喇叭扬声器系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p141}</td>
        </#list>
        </tr></#if><#if params?contains("@p142@")==true>
        <tr>
        <td>4-5喇叭扬声器系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p142}</td>
        </#list>
        </tr></#if><#if params?contains("@p143@")==true>
        <tr>
        <td>6-7喇叭扬声器系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p143}</td>
        </#list>
        </tr></#if><#if params?contains("@p144@")==true>
        <tr>
        <td>≥8喇叭扬声器系统 </td>
        <#list autoList as auto>
        <td align="center">${auto.p144}</td>
        </#list>
        </tr></#if><#if params?contains("@p104@")==true>
        <tr>
        <td>行车电脑显示屏</td>
        <#list autoList as auto>
        <td align="center">${auto.p104}</td>
        </#list>
        </tr></#if><#if params?contains("@p101@")==true>
        <tr>
        <td>定速巡航</td>
        <#list autoList as auto>
        <td align="center">${auto.p101}</td>
        </#list>
        </tr></#if><#if params?contains("@p102@")==true>
        <tr>
        <td>泊车辅助</td>
        <#list autoList as auto>
        <td align="center">${auto.p102}</td>
        </#list>
        </tr></#if><#if params?contains("@p103@")==true><tr>
        <td>倒车视频影像</td>
        <#list autoList as auto>
        <td align="center">${auto.p103}</td>
        </#list>
        </tr></#if><#if params?contains("@p127@")==true>
        <tr>
        <td>GPS导航系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p127}</td>
        </#list>
        </tr></#if><#if params?contains("@p183@")==true>
        <tr>
        <td>定位互动服务</td>
        <#list autoList as auto>
        <td align="center">${auto.p183}</td>
        </#list>
        </tr></#if><#if params?contains("@p96@")==true>
        <tr>
        <td>真皮方向盘</td>
        <#list autoList as auto>
        <td align="center">${auto.p96}</td>
        </#list>
        </tr></#if><#if params?contains("@p97@")==true>
        <tr>
        <td>方向盘上下调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p97}</td>
        </#list>
        </tr></#if><#if params?contains("@p98@")==true><tr>
        <td>方向盘前后调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p98}</td>
        </#list>
        </tr></#if><#if params?contains("@p48@")==true>
        <tr>
        <td>方向盘电动调节</td>
        <#list autoList as auto>
        <td align="center">${auto.p48}</td>
        </#list>
        </tr></#if><#if params?contains("@p181@")==true>
        <tr>
        <td>多功能方向盘 </td>
        <#list autoList as auto>
        <td align="center">${auto.p181}</td>
        </#list>
        </tr></#if><#if params?contains("@p100@")==true>
        <tr>
        <td>方向盘换挡</td>
        <#list autoList as auto>
        <td align="center">${auto.p100}</td>
        </#list>
        </tr></#if><#if params?contains("@p106@")==true>
        <tr>
        <td>左脚休息踏板</td>
        <#list autoList as auto>
        <td align="center">${auto.p106}</td>
        </#list>
        </tr></#if><#if params?contains("@p162@")==true><tr>
        <td>遮阳板化妆镜 </td>
        <#list autoList as auto>
        <td align="center">${auto.p162}</td>
        </#list>
        </tr></#if><#if params?contains("@p161@")==true>
        <tr>
        <td>后排侧遮阳帘</td>
        <#list autoList as auto>
        <td align="center">${auto.p161}</td>
        </#list>
        </tr></#if><#if params?contains("@p160@")==true>
        <tr>
        <td>后风挡遮阳帘</td>
        <#list autoList as auto>
        <td align="center">${auto.p160}</td>
        </#list>
        </tr></#if><#if params?contains("@p77@")==true>
        <tr>
        <td>无钥匙启动系统 </td>
        <#list autoList as auto>
        <td align="center">${auto.p77}</td>
        </#list>
        </tr></#if><#if params?contains("@p105@")==true>
        <tr>
        <td>HUD抬头数字显示</td>
        <#list autoList as auto>
        <td align="center">${auto.p105}</td>
        </#list>
        </tr></#if><#if params?contains("@p171@")==true><tr>
        <td>自动泊车入位 </td>
        <#list autoList as auto>
        <td align="center">${auto.p171}</td>
        </#list>
        </tr></#if><#if params?contains("@p172@")==true>
        <tr>
        <td>并线辅助</td>
        <#list autoList as auto>
        <td align="center">${auto.p172}</td>
        </#list>
        </tr></#if><#if params?contains("@p189@")==true>
        <tr>
        <td>主动刹车/主动安全系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p189}</td>
        </#list>
        </tr></#if><#if params?contains("@p190@")==true>
        <tr>
        <td>整体主动转向系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p190}</td>
        </#list>
        </tr></#if><#if params?contains("@p173@")==true>
        <tr>
        <td>夜视系统</td>
        <#list autoList as auto>
        <td align="center">${auto.p173}</td>
        </#list>
        </tr></#if><#if params?contains("@p191@")==true>
        <tr>
        <td>中控液晶屏分屏显示</td>
        <#list autoList as auto>
        <td align="center">${auto.p191}</td>
        </#list>
        </tr></#if><#if params?contains("@p174@")==true>
        <tr>
        <td>自适应巡航</td>
        <#list autoList as auto>
        <td align="center">${auto.p174}</td>
        </#list>
        </tr></#if><#if params?contains("@p94@")==true>
        <tr>
        <td>运动外观套件</td>
        <#list autoList as auto>
        <td align="center">${auto.p94}</td>
        </#list>
        </tr></#if>
        <tr>
			<td height="24" bgcolor="#d8e4eb" align="right" colspan="3">
				<a target="_blank" href="http://www.315che.com/">
				<strong>中国汽车消费网制表 </strong>
				</a>
			</td>
		</tr>
    </tbody>
</table>