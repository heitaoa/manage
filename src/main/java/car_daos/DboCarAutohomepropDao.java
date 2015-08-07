package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboCarAutohomeprop;

public class  DboCarAutohomepropDao  extends BaseDao {

	public static void fill(ResultSet rs, DboCarAutohomeprop dbocarautohomeprop) throws SQLException {
		dbocarautohomeprop.setId(rs.getInt("id"));//
		dbocarautohomeprop.setCarid(rs.getInt("carid"));//
		dbocarautohomeprop.setAutohomecarid(rs.getInt("autohomecarid"));//
		dbocarautohomeprop.setBid(rs.getInt("bid"));//
		dbocarautohomeprop.setP1(rs.getString("p1"));//车型名称
		dbocarautohomeprop.setP2(rs.getString("p2"));//厂商指导价(元)
		dbocarautohomeprop.setP3(rs.getString("p3"));//品牌
		dbocarautohomeprop.setP4(rs.getString("p4"));//级别
		dbocarautohomeprop.setP5(rs.getString("p5"));//发动机
		dbocarautohomeprop.setP6(rs.getString("p6"));//变速箱
		dbocarautohomeprop.setP7(rs.getString("p7"));//长×宽×高(mm)
		dbocarautohomeprop.setP8(rs.getString("p8"));//车体结构
		dbocarautohomeprop.setP9(rs.getString("p9"));//最高车速(km/h)
		dbocarautohomeprop.setP10(rs.getString("p10"));//官方0-100km/h加速(s)
		dbocarautohomeprop.setP11(rs.getString("p11"));//官方100-0制动(m)
		dbocarautohomeprop.setP12(rs.getString("p12"));//官方综合路况油耗(l)
		dbocarautohomeprop.setP13(rs.getString("p13"));//实测0-100km/h加速(s)
		dbocarautohomeprop.setP14(rs.getString("p14"));//实测100-0km/h制动(m)
		dbocarautohomeprop.setP15(rs.getString("p15"));//实测油耗(l)
		dbocarautohomeprop.setP16(rs.getString("p16"));//整车质保
		dbocarautohomeprop.setP17(rs.getString("p17"));//长度(mm)
		dbocarautohomeprop.setP18(rs.getString("p18"));//宽度(mm)
		dbocarautohomeprop.setP19(rs.getString("p19"));//高度(mm)
		dbocarautohomeprop.setP20(rs.getString("p20"));//轴距(mm)
		dbocarautohomeprop.setP21(rs.getString("p21"));//前轮距(mm)
		dbocarautohomeprop.setP22(rs.getString("p22"));//后轮距(mm)
		dbocarautohomeprop.setP23(rs.getString("p23"));//最小离地间隙(mm)
		dbocarautohomeprop.setP24(rs.getString("p24"));//整备质量(kg)
		dbocarautohomeprop.setP25(rs.getString("p25"));//车身结构
		dbocarautohomeprop.setP26(rs.getString("p26"));//车门数(个)
		dbocarautohomeprop.setP27(rs.getString("p27"));//座位数(个)
		dbocarautohomeprop.setP28(rs.getString("p28"));//油箱容积(l)
		dbocarautohomeprop.setP29(rs.getString("p29"));//行李厢容积(l)
		dbocarautohomeprop.setP30(rs.getString("p30"));//排量(ml)
		dbocarautohomeprop.setP31(rs.getString("p31"));//排量级别
		dbocarautohomeprop.setP32(rs.getString("p32"));//进气形式
		dbocarautohomeprop.setP33(rs.getString("p33"));//气缸排列形式
		dbocarautohomeprop.setP34(rs.getString("p34"));//气缸数(个)
		dbocarautohomeprop.setP35(rs.getString("p35"));//每缸气门数(个)
		dbocarautohomeprop.setP36(rs.getString("p36"));//压缩比
		dbocarautohomeprop.setP37(rs.getString("p37"));//配气机构
		dbocarautohomeprop.setP38(rs.getString("p38"));//缸径
		dbocarautohomeprop.setP39(rs.getString("p39"));//行程
		dbocarautohomeprop.setP40(rs.getString("p40"));//最大马力(ps)
		dbocarautohomeprop.setP41(rs.getString("p41"));//最大功率(kw)
		dbocarautohomeprop.setP42(rs.getString("p42"));//最大功率转速(rpm)
		dbocarautohomeprop.setP43(rs.getString("p43"));//最大扭矩(n·m)
		dbocarautohomeprop.setP44(rs.getString("p44"));//最大扭矩转速(rpm)
		dbocarautohomeprop.setP45(rs.getString("p45"));//发动机特有技术
		dbocarautohomeprop.setP46(rs.getString("p46"));//燃料形式
		dbocarautohomeprop.setP47(rs.getString("p47"));//燃油标号
		dbocarautohomeprop.setP48(rs.getString("p48"));//供油方式
		dbocarautohomeprop.setP49(rs.getString("p49"));//缸盖材料
		dbocarautohomeprop.setP50(rs.getString("p50"));//缸体材料
		dbocarautohomeprop.setP51(rs.getString("p51"));//环保标准
		dbocarautohomeprop.setP52(rs.getString("p52"));//简称
		dbocarautohomeprop.setP53(rs.getString("p53"));//挡位个数
		dbocarautohomeprop.setP54(rs.getString("p54"));//变速箱类型
		dbocarautohomeprop.setP55(rs.getString("p55"));//驱动方式
		dbocarautohomeprop.setP56(rs.getString("p56"));//前悬架类型
		dbocarautohomeprop.setP57(rs.getString("p57"));//后悬架类型
		dbocarautohomeprop.setP58(rs.getString("p58"));//助力类型
		dbocarautohomeprop.setP59(rs.getString("p59"));//地盘结构
		dbocarautohomeprop.setP60(rs.getString("p60"));//前制动器类型
		dbocarautohomeprop.setP61(rs.getString("p61"));//后制动器类型
		dbocarautohomeprop.setP62(rs.getString("p62"));//驻车制动类型
		dbocarautohomeprop.setP63(rs.getString("p63"));//前轮胎规格
		dbocarautohomeprop.setP64(rs.getString("p64"));//后轮胎规格
		dbocarautohomeprop.setP65(rs.getString("p65"));//备胎规格
		dbocarautohomeprop.setP66(rs.getString("p66"));//驾驶座安全气囊
		dbocarautohomeprop.setP67(rs.getString("p67"));//副驾驶安全气囊
		dbocarautohomeprop.setP68(rs.getString("p68"));//前排侧气囊
		dbocarautohomeprop.setP69(rs.getString("p69"));//后排侧气囊
		dbocarautohomeprop.setP70(rs.getString("p70"));//前排头部气囊(气帘)
		dbocarautohomeprop.setP71(rs.getString("p71"));//后排头部气囊(气帘)
		dbocarautohomeprop.setP72(rs.getString("p72"));//膝部气囊
		dbocarautohomeprop.setP73(rs.getString("p73"));//安全带未系提示
		dbocarautohomeprop.setP74(rs.getString("p74"));//发动机电子防盗
		dbocarautohomeprop.setP75(rs.getString("p75"));//车内中控锁
		dbocarautohomeprop.setP76(rs.getString("p76"));//遥控钥匙
		dbocarautohomeprop.setP77(rs.getString("p77"));//无钥匙启动系统
		dbocarautohomeprop.setP78(rs.getString("p78"));//abs防抱死
		dbocarautohomeprop.setP79(rs.getString("p79"));//制动力分配(ebd/cbc等)
		dbocarautohomeprop.setP80(rs.getString("p80"));//刹车辅助(eba/bas/ba等)
		dbocarautohomeprop.setP81(rs.getString("p81"));//牵引力控制(asr/tcs/trc等)
		dbocarautohomeprop.setP82(rs.getString("p82"));//车身稳定控制(esc/esp/dsc等)
		dbocarautohomeprop.setP83(rs.getString("p83"));//自动驻车/上坡辅助
		dbocarautohomeprop.setP84(rs.getString("p84"));//陡坡缓降
		dbocarautohomeprop.setP85(rs.getString("p85"));//可变悬架
		dbocarautohomeprop.setP86(rs.getString("p86"));//空气悬架
		dbocarautohomeprop.setP87(rs.getString("p87"));//胎压监测装置
		dbocarautohomeprop.setP88(rs.getString("p88"));//零胎压继续行驶
		dbocarautohomeprop.setP89(rs.getString("p89"));//可变转向比
		dbocarautohomeprop.setP90(rs.getString("p90"));//电动天窗
		dbocarautohomeprop.setP91(rs.getString("p91"));//全景天窗
		dbocarautohomeprop.setP92(rs.getString("p92"));//同色后视镜
		dbocarautohomeprop.setP93(rs.getString("p93"));//同色防擦条
		dbocarautohomeprop.setP94(rs.getString("p94"));//运动外观套件
		dbocarautohomeprop.setP95(rs.getString("p95"));//铝合金轮毂
		dbocarautohomeprop.setP96(rs.getString("p96"));//真皮方向盘
		dbocarautohomeprop.setP97(rs.getString("p97"));//方向盘上下调节
		dbocarautohomeprop.setP98(rs.getString("p98"));//方向盘前后调节
		dbocarautohomeprop.setP99(rs.getString("p99"));//多功能方向盘
		dbocarautohomeprop.setP100(rs.getString("p100"));//方向盘换挡
		dbocarautohomeprop.setP101(rs.getString("p101"));//定速巡航
		dbocarautohomeprop.setP102(rs.getString("p102"));//泊车辅助
		dbocarautohomeprop.setP103(rs.getString("p103"));//倒车视频影像
		dbocarautohomeprop.setP104(rs.getString("p104"));//行车电脑显示屏
		dbocarautohomeprop.setP105(rs.getString("p105"));//hud抬头数字显示
		dbocarautohomeprop.setP106(rs.getString("p106"));//左脚休息踏板
		dbocarautohomeprop.setP107(rs.getString("p107"));//真皮/仿皮座椅
		dbocarautohomeprop.setP108(rs.getString("p108"));//运动风格座椅
		dbocarautohomeprop.setP109(rs.getString("p109"));//座椅高低调节
		dbocarautohomeprop.setP110(rs.getString("p110"));//腰部支撑调节
		dbocarautohomeprop.setP111(rs.getString("p111"));//前排座椅电动调节
		dbocarautohomeprop.setP112(rs.getString("p112"));//后排座椅手动调节
		dbocarautohomeprop.setP113(rs.getString("p113"));//后排座椅电动调节
		dbocarautohomeprop.setP114(rs.getString("p114"));//电动座椅记忆
		dbocarautohomeprop.setP115(rs.getString("p115"));//前排座椅加热
		dbocarautohomeprop.setP116(rs.getString("p116"));//后排座椅加热
		dbocarautohomeprop.setP117(rs.getString("p117"));//座椅通风
		dbocarautohomeprop.setP118(rs.getString("p118"));//座椅按摩
		dbocarautohomeprop.setP119(rs.getString("p119"));//后排座椅整体放倒
		dbocarautohomeprop.setP120(rs.getString("p120"));//后排座椅比例放倒
		dbocarautohomeprop.setP121(rs.getString("p121"));//第三排座椅
		dbocarautohomeprop.setP122(rs.getString("p122"));//前座中央扶手
		dbocarautohomeprop.setP123(rs.getString("p123"));//后座中央扶手
		dbocarautohomeprop.setP124(rs.getString("p124"));//前排杯架
		dbocarautohomeprop.setP125(rs.getString("p125"));//后排杯架
		dbocarautohomeprop.setP126(rs.getString("p126"));//电动后备厢
		dbocarautohomeprop.setP127(rs.getString("p127"));//gps导航系统
		dbocarautohomeprop.setP128(rs.getString("p128"));//中控台彩色大屏
		dbocarautohomeprop.setP129(rs.getString("p129"));//人机交互系统
		dbocarautohomeprop.setP130(rs.getString("p130"));//内置硬盘
		dbocarautohomeprop.setP131(rs.getString("p131"));//蓝牙系统
		dbocarautohomeprop.setP132(rs.getString("p132"));//车载电视
		dbocarautohomeprop.setP133(rs.getString("p133"));//车载电话
		dbocarautohomeprop.setP134(rs.getString("p134"));//后排液晶屏
		dbocarautohomeprop.setP135(rs.getString("p135"));//外接音源接口(aux/usb/ipod等)
		dbocarautohomeprop.setP136(rs.getString("p136"));//cd支持mp3/wma
		dbocarautohomeprop.setP137(rs.getString("p137"));//单碟cd
		dbocarautohomeprop.setP138(rs.getString("p138"));//多碟cd系统
		dbocarautohomeprop.setP139(rs.getString("p139"));//单碟dvd
		dbocarautohomeprop.setP140(rs.getString("p140"));//多碟dvd系统
		dbocarautohomeprop.setP141(rs.getString("p141"));//2-3喇叭扬声器系统
		dbocarautohomeprop.setP142(rs.getString("p142"));//4-5喇叭扬声器系统
		dbocarautohomeprop.setP143(rs.getString("p143"));//6-7喇叭扬声器系统
		dbocarautohomeprop.setP144(rs.getString("p144"));//≥8喇叭扬声器系统
		dbocarautohomeprop.setP145(rs.getString("p145"));//氙气大灯
		dbocarautohomeprop.setP146(rs.getString("p146"));//日间行车灯
		dbocarautohomeprop.setP147(rs.getString("p147"));//自动头灯
		dbocarautohomeprop.setP148(rs.getString("p148"));//转向头灯(辅助灯)
		dbocarautohomeprop.setP149(rs.getString("p149"));//前雾灯
		dbocarautohomeprop.setP150(rs.getString("p150"));//后雾灯
		dbocarautohomeprop.setP151(rs.getString("p151"));//大灯高度可调
		dbocarautohomeprop.setP152(rs.getString("p152"));//大灯清洗装置
		dbocarautohomeprop.setP153(rs.getString("p153"));//前电动车窗
		dbocarautohomeprop.setP154(rs.getString("p154"));//后电动车窗
		dbocarautohomeprop.setP155(rs.getString("p155"));//车窗防夹手功能
		dbocarautohomeprop.setP156(rs.getString("p156"));//后视镜电动调节
		dbocarautohomeprop.setP157(rs.getString("p157"));//后视镜加热
		dbocarautohomeprop.setP158(rs.getString("p158"));//内/外后视镜自动防眩目
		dbocarautohomeprop.setP159(rs.getString("p159"));//后视镜电动折叠
		dbocarautohomeprop.setP160(rs.getString("p160"));//后风挡遮阳帘
		dbocarautohomeprop.setP161(rs.getString("p161"));//后排侧遮阳帘
		dbocarautohomeprop.setP162(rs.getString("p162"));//遮阳板化妆镜
		dbocarautohomeprop.setP163(rs.getString("p163"));//感应雨刷
		dbocarautohomeprop.setP164(rs.getString("p164"));//手动空调
		dbocarautohomeprop.setP165(rs.getString("p165"));//自动空调
		dbocarautohomeprop.setP166(rs.getString("p166"));//后排独立空调
		dbocarautohomeprop.setP167(rs.getString("p167"));//后座出风口
		dbocarautohomeprop.setP168(rs.getString("p168"));//温度分区控制
		dbocarautohomeprop.setP169(rs.getString("p169"));//空气调节/花粉过滤
		dbocarautohomeprop.setP170(rs.getString("p170"));//车载冰箱
		dbocarautohomeprop.setP171(rs.getString("p171"));//自动泊车入位
		dbocarautohomeprop.setP172(rs.getString("p172"));//并线辅助
		dbocarautohomeprop.setP173(rs.getString("p173"));//夜视系统
		dbocarautohomeprop.setP174(rs.getString("p174"));//自适应巡航
		dbocarautohomeprop.setP175(rs.getString("p175"));//全景摄像头
		dbocarautohomeprop.setP176(rs.getString("p176"));//旧排量级别
		dbocarautohomeprop.setP177(rs.getString("p177"));//生产年份
		dbocarautohomeprop.setP178(rs.getString("p178"));//添加日期
		dbocarautohomeprop.setP179(rs.getString("p179"));//更新日期
		dbocarautohomeprop.setP180(rs.getString("p180"));//电动吸合门
		dbocarautohomeprop.setP181(rs.getString("p181"));//方向盘电动调节
		dbocarautohomeprop.setP182(rs.getString("p182"));//肩部支撑调节
		dbocarautohomeprop.setP183(rs.getString("p183"));//定位互动服务
		dbocarautohomeprop.setP184(rs.getString("p184"));//蓝牙/车载电话
		dbocarautohomeprop.setP185(rs.getString("p185"));//虚拟多碟cd
		dbocarautohomeprop.setP186(rs.getString("p186"));//车内氛围灯
		dbocarautohomeprop.setP187(rs.getString("p187"));//防紫外线/隔热玻璃
		dbocarautohomeprop.setP188(rs.getString("p188"));//后雨刷
		dbocarautohomeprop.setP189(rs.getString("p189"));//主动刹车/主动安全系统
		dbocarautohomeprop.setP190(rs.getString("p190"));//整体主动转向系统
		dbocarautohomeprop.setP191(rs.getString("p191"));//中控液晶屏分屏显示
		dbocarautohomeprop.setP192(rs.getString("p192"));//厂商
		dbocarautohomeprop.setP193(rs.getString("p193"));//工信部综合油耗(l)
		dbocarautohomeprop.setP194(rs.getString("p194"));//发动机型号
		dbocarautohomeprop.setP195(rs.getString("p195"));//第二排靠背角度调节
		dbocarautohomeprop.setP196(rs.getString("p196"));//第二排座椅移动
		dbocarautohomeprop.setP197(rs.getString("p197"));//后视镜记忆
		dbocarautohomeprop.setP198(rs.getString("p198"));//iso fix儿童座椅接口
		dbocarautohomeprop.setP199(rs.getString("p199"));//latch儿童座椅接口
		dbocarautohomeprop.setP200(rs.getString("p200"));//车身颜色
		dbocarautohomeprop.setP201(rs.getString("p201"));//
		dbocarautohomeprop.setP202(rs.getString("p202"));//
		dbocarautohomeprop.setP203(rs.getString("p203"));//
		dbocarautohomeprop.setP204(rs.getString("p204"));//
		dbocarautohomeprop.setP205(rs.getString("p205"));//
		dbocarautohomeprop.setP206(rs.getString("p206"));//
		dbocarautohomeprop.setP207(rs.getString("p207"));//
		dbocarautohomeprop.setP208(rs.getString("p208"));//
		dbocarautohomeprop.setP209(rs.getString("p209"));//
		dbocarautohomeprop.setP210(rs.getString("p210"));//
		dbocarautohomeprop.setP211(rs.getString("p211"));//
		dbocarautohomeprop.setP212(rs.getString("p212"));//
		dbocarautohomeprop.setP213(rs.getString("p213"));//
		dbocarautohomeprop.setP214(rs.getString("p214"));//
		dbocarautohomeprop.setP215(rs.getString("p215"));//
		dbocarautohomeprop.setP216(rs.getString("p216"));//
		dbocarautohomeprop.setP217(rs.getString("p217"));//
		dbocarautohomeprop.setP218(rs.getString("p218"));//
		dbocarautohomeprop.setP219(rs.getString("p219"));//
		dbocarautohomeprop.setP220(rs.getString("p220"));//
		dbocarautohomeprop.setP221(rs.getString("p221"));//
		dbocarautohomeprop.setP222(rs.getString("p222"));//
		dbocarautohomeprop.setP223(rs.getString("p223"));//
		dbocarautohomeprop.setP224(rs.getString("p224"));//
		dbocarautohomeprop.setP225(rs.getString("p225"));//
		dbocarautohomeprop.setP226(rs.getString("p226"));//
		dbocarautohomeprop.setP227(rs.getString("p227"));//
		dbocarautohomeprop.setP228(rs.getString("p228"));//
		dbocarautohomeprop.setP229(rs.getString("p229"));//
		dbocarautohomeprop.setP230(rs.getString("p230"));//
		dbocarautohomeprop.setP231(rs.getString("p231"));//
		dbocarautohomeprop.setP232(rs.getString("p232"));//
		dbocarautohomeprop.setP233(rs.getString("p233"));//
		dbocarautohomeprop.setP234(rs.getString("p234"));//
		dbocarautohomeprop.setP235(rs.getString("p235"));//
		dbocarautohomeprop.setP236(rs.getString("p236"));//
		dbocarautohomeprop.setP237(rs.getString("p237"));//
		dbocarautohomeprop.setP238(rs.getString("p238"));//
		dbocarautohomeprop.setP239(rs.getString("p239"));//
		dbocarautohomeprop.setP240(rs.getString("p240"));//
		dbocarautohomeprop.setP241(rs.getString("p241"));//
		dbocarautohomeprop.setP242(rs.getString("p242"));//
		dbocarautohomeprop.setP243(rs.getString("p243"));//
		dbocarautohomeprop.setP244(rs.getString("p244"));//
		dbocarautohomeprop.setP245(rs.getString("p245"));//
		dbocarautohomeprop.setP246(rs.getString("p246"));//
		dbocarautohomeprop.setP247(rs.getString("p247"));//
		dbocarautohomeprop.setP248(rs.getString("p248"));//
		dbocarautohomeprop.setP249(rs.getString("p249"));//
		dbocarautohomeprop.setP250(rs.getString("p250"));//
		dbocarautohomeprop.setP251(rs.getString("p251"));//
		dbocarautohomeprop.setP252(rs.getString("p252"));//
		dbocarautohomeprop.setP253(rs.getString("p253"));//
		dbocarautohomeprop.setP254(rs.getString("p254"));//
		dbocarautohomeprop.setP255(rs.getString("p255"));//
		dbocarautohomeprop.setP256(rs.getString("p256"));//
		dbocarautohomeprop.setP257(rs.getString("p257"));//
		dbocarautohomeprop.setP258(rs.getString("p258"));//
		dbocarautohomeprop.setP259(rs.getString("p259"));//
		dbocarautohomeprop.setP260(rs.getString("p260"));//
		dbocarautohomeprop.setP261(rs.getString("p261"));//
		dbocarautohomeprop.setP262(rs.getString("p262"));//
		dbocarautohomeprop.setP263(rs.getString("p263"));//
		dbocarautohomeprop.setP264(rs.getString("p264"));//
		dbocarautohomeprop.setP265(rs.getString("p265"));//
		dbocarautohomeprop.setP266(rs.getString("p266"));//
		dbocarautohomeprop.setP267(rs.getString("p267"));//
		dbocarautohomeprop.setP268(rs.getString("p268"));//
		dbocarautohomeprop.setP269(rs.getString("p269"));//
		dbocarautohomeprop.setP270(rs.getString("p270"));//
		dbocarautohomeprop.setP271(rs.getString("p271"));//
		dbocarautohomeprop.setP272(rs.getString("p272"));//
		dbocarautohomeprop.setP273(rs.getString("p273"));//
		dbocarautohomeprop.setP274(rs.getString("p274"));//
		dbocarautohomeprop.setP275(rs.getString("p275"));//
		dbocarautohomeprop.setP276(rs.getString("p276"));//
		dbocarautohomeprop.setP277(rs.getString("p277"));//
		dbocarautohomeprop.setP278(rs.getString("p278"));//
		dbocarautohomeprop.setP279(rs.getString("p279"));//
		dbocarautohomeprop.setP280(rs.getString("p280"));//
		dbocarautohomeprop.setP281(rs.getString("p281"));//
		dbocarautohomeprop.setP282(rs.getString("p282"));//
		dbocarautohomeprop.setP283(rs.getString("p283"));//
		dbocarautohomeprop.setP284(rs.getString("p284"));//
		dbocarautohomeprop.setP285(rs.getString("p285"));//
		dbocarautohomeprop.setP286(rs.getString("p286"));//
		dbocarautohomeprop.setP287(rs.getString("p287"));//
		dbocarautohomeprop.setP288(rs.getString("p288"));//
		dbocarautohomeprop.setP289(rs.getString("p289"));//
		dbocarautohomeprop.setP290(rs.getString("p290"));//
		dbocarautohomeprop.setP291(rs.getString("p291"));//
		dbocarautohomeprop.setP292(rs.getString("p292"));//
		dbocarautohomeprop.setP293(rs.getString("p293"));//
		dbocarautohomeprop.setP294(rs.getString("p294"));//
		dbocarautohomeprop.setP295(rs.getString("p295"));//
		dbocarautohomeprop.setP296(rs.getString("p296"));//
		dbocarautohomeprop.setP297(rs.getString("p297"));//
		dbocarautohomeprop.setP298(rs.getString("p298"));//
		dbocarautohomeprop.setP299(rs.getString("p299"));//
		dbocarautohomeprop.setP300(rs.getString("p300"));//
		dbocarautohomeprop.setIsupdate(rs.getInt("isupdate"));//
		dbocarautohomeprop.setIway(rs.getString("iway"));//渠道
		dbocarautohomeprop.setCar_type(rs.getInt("car_type"));//车型分类 1普通车型，2面包车型等，3油电混动车型，4纯电动车型
	}

	public static List<DboCarAutohomeprop> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_autohomeprop";
		List<DboCarAutohomeprop> list = new ArrayList<DboCarAutohomeprop>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarAutohomeprop dbocarautohomeprop = new DboCarAutohomeprop();
				fill(rs, dbocarautohomeprop);
				list.add(dbocarautohomeprop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}


	public static List<DboCarAutohomeprop> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_car_autohomeprop where "+subsql+"";
		List<DboCarAutohomeprop> list = new ArrayList<DboCarAutohomeprop>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboCarAutohomeprop dbocarautohomeprop = new DboCarAutohomeprop();
				fill(rs, dbocarautohomeprop);
				list.add(dbocarautohomeprop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}

	public static int whereCount(String subsql) {
		DBConnect dbc = null;
		int result = EXECUTE_FAIL;
		String sql = "select count(*) from dbo_car_autohomeprop where "+subsql+"";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return EXECUTE_FAIL;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}


	public static int delete(String subsql) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "delete from dbo_car_autohomeprop where "+subsql+"";
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public static int delete(DBConnect dbc,String subsql) {
		int result = EXECUTE_FAIL;
		String sql = "delete from dbo_car_autohomeprop where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboCarAutohomeprop dbocarautohomeprop) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_car_autohomeprop(`id`,`carid`,`autohomecarid`,`bid`,`p1`,`p2`,`p3`,`p4`,`p5`,`p6`,`p7`,`p8`,`p9`,`p10`,`p11`,`p12`,`p13`,`p14`,`p15`,`p16`,`p17`,`p18`,`p19`,`p20`,`p21`,`p22`,`p23`,`p24`,`p25`,`p26`,`p27`,`p28`,`p29`,`p30`,`p31`,`p32`,`p33`,`p34`,`p35`,`p36`,`p37`,`p38`,`p39`,`p40`,`p41`,`p42`,`p43`,`p44`,`p45`,`p46`,`p47`,`p48`,`p49`,`p50`,`p51`,`p52`,`p53`,`p54`,`p55`,`p56`,`p57`,`p58`,`p59`,`p60`,`p61`,`p62`,`p63`,`p64`,`p65`,`p66`,`p67`,`p68`,`p69`,`p70`,`p71`,`p72`,`p73`,`p74`,`p75`,`p76`,`p77`,`p78`,`p79`,`p80`,`p81`,`p82`,`p83`,`p84`,`p85`,`p86`,`p87`,`p88`,`p89`,`p90`,`p91`,`p92`,`p93`,`p94`,`p95`,`p96`,`p97`,`p98`,`p99`,`p100`,`p101`,`p102`,`p103`,`p104`,`p105`,`p106`,`p107`,`p108`,`p109`,`p110`,`p111`,`p112`,`p113`,`p114`,`p115`,`p116`,`p117`,`p118`,`p119`,`p120`,`p121`,`p122`,`p123`,`p124`,`p125`,`p126`,`p127`,`p128`,`p129`,`p130`,`p131`,`p132`,`p133`,`p134`,`p135`,`p136`,`p137`,`p138`,`p139`,`p140`,`p141`,`p142`,`p143`,`p144`,`p145`,`p146`,`p147`,`p148`,`p149`,`p150`,`p151`,`p152`,`p153`,`p154`,`p155`,`p156`,`p157`,`p158`,`p159`,`p160`,`p161`,`p162`,`p163`,`p164`,`p165`,`p166`,`p167`,`p168`,`p169`,`p170`,`p171`,`p172`,`p173`,`p174`,`p175`,`p176`,`p177`,`p178`,`p179`,`p180`,`p181`,`p182`,`p183`,`p184`,`p185`,`p186`,`p187`,`p188`,`p189`,`p190`,`p191`,`p192`,`p193`,`p194`,`p195`,`p196`,`p197`,`p198`,`p199`,`p200`,`p201`,`p202`,`p203`,`p204`,`p205`,`p206`,`p207`,`p208`,`p209`,`p210`,`p211`,`p212`,`p213`,`p214`,`p215`,`p216`,`p217`,`p218`,`p219`,`p220`,`p221`,`p222`,`p223`,`p224`,`p225`,`p226`,`p227`,`p228`,`p229`,`p230`,`p231`,`p232`,`p233`,`p234`,`p235`,`p236`,`p237`,`p238`,`p239`,`p240`,`p241`,`p242`,`p243`,`p244`,`p245`,`p246`,`p247`,`p248`,`p249`,`p250`,`p251`,`p252`,`p253`,`p254`,`p255`,`p256`,`p257`,`p258`,`p259`,`p260`,`p261`,`p262`,`p263`,`p264`,`p265`,`p266`,`p267`,`p268`,`p269`,`p270`,`p271`,`p272`,`p273`,`p274`,`p275`,`p276`,`p277`,`p278`,`p279`,`p280`,`p281`,`p282`,`p283`,`p284`,`p285`,`p286`,`p287`,`p288`,`p289`,`p290`,`p291`,`p292`,`p293`,`p294`,`p295`,`p296`,`p297`,`p298`,`p299`,`p300`,`isupdate`,`iway`,`car_type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarautohomeprop.getId());
		dbc.setInt(2, dbocarautohomeprop.getCarid());
		dbc.setInt(3, dbocarautohomeprop.getAutohomecarid());
		dbc.setInt(4, dbocarautohomeprop.getBid());
		dbc.setString(5, dbocarautohomeprop.getP1());
		dbc.setString(6, dbocarautohomeprop.getP2());
		dbc.setString(7, dbocarautohomeprop.getP3());
		dbc.setString(8, dbocarautohomeprop.getP4());
		dbc.setString(9, dbocarautohomeprop.getP5());
		dbc.setString(10, dbocarautohomeprop.getP6());
		dbc.setString(11, dbocarautohomeprop.getP7());
		dbc.setString(12, dbocarautohomeprop.getP8());
		dbc.setString(13, dbocarautohomeprop.getP9());
		dbc.setString(14, dbocarautohomeprop.getP10());
		dbc.setString(15, dbocarautohomeprop.getP11());
		dbc.setString(16, dbocarautohomeprop.getP12());
		dbc.setString(17, dbocarautohomeprop.getP13());
		dbc.setString(18, dbocarautohomeprop.getP14());
		dbc.setString(19, dbocarautohomeprop.getP15());
		dbc.setString(20, dbocarautohomeprop.getP16());
		dbc.setString(21, dbocarautohomeprop.getP17());
		dbc.setString(22, dbocarautohomeprop.getP18());
		dbc.setString(23, dbocarautohomeprop.getP19());
		dbc.setString(24, dbocarautohomeprop.getP20());
		dbc.setString(25, dbocarautohomeprop.getP21());
		dbc.setString(26, dbocarautohomeprop.getP22());
		dbc.setString(27, dbocarautohomeprop.getP23());
		dbc.setString(28, dbocarautohomeprop.getP24());
		dbc.setString(29, dbocarautohomeprop.getP25());
		dbc.setString(30, dbocarautohomeprop.getP26());
		dbc.setString(31, dbocarautohomeprop.getP27());
		dbc.setString(32, dbocarautohomeprop.getP28());
		dbc.setString(33, dbocarautohomeprop.getP29());
		dbc.setString(34, dbocarautohomeprop.getP30());
		dbc.setString(35, dbocarautohomeprop.getP31());
		dbc.setString(36, dbocarautohomeprop.getP32());
		dbc.setString(37, dbocarautohomeprop.getP33());
		dbc.setString(38, dbocarautohomeprop.getP34());
		dbc.setString(39, dbocarautohomeprop.getP35());
		dbc.setString(40, dbocarautohomeprop.getP36());
		dbc.setString(41, dbocarautohomeprop.getP37());
		dbc.setString(42, dbocarautohomeprop.getP38());
		dbc.setString(43, dbocarautohomeprop.getP39());
		dbc.setString(44, dbocarautohomeprop.getP40());
		dbc.setString(45, dbocarautohomeprop.getP41());
		dbc.setString(46, dbocarautohomeprop.getP42());
		dbc.setString(47, dbocarautohomeprop.getP43());
		dbc.setString(48, dbocarautohomeprop.getP44());
		dbc.setString(49, dbocarautohomeprop.getP45());
		dbc.setString(50, dbocarautohomeprop.getP46());
		dbc.setString(51, dbocarautohomeprop.getP47());
		dbc.setString(52, dbocarautohomeprop.getP48());
		dbc.setString(53, dbocarautohomeprop.getP49());
		dbc.setString(54, dbocarautohomeprop.getP50());
		dbc.setString(55, dbocarautohomeprop.getP51());
		dbc.setString(56, dbocarautohomeprop.getP52());
		dbc.setString(57, dbocarautohomeprop.getP53());
		dbc.setString(58, dbocarautohomeprop.getP54());
		dbc.setString(59, dbocarautohomeprop.getP55());
		dbc.setString(60, dbocarautohomeprop.getP56());
		dbc.setString(61, dbocarautohomeprop.getP57());
		dbc.setString(62, dbocarautohomeprop.getP58());
		dbc.setString(63, dbocarautohomeprop.getP59());
		dbc.setString(64, dbocarautohomeprop.getP60());
		dbc.setString(65, dbocarautohomeprop.getP61());
		dbc.setString(66, dbocarautohomeprop.getP62());
		dbc.setString(67, dbocarautohomeprop.getP63());
		dbc.setString(68, dbocarautohomeprop.getP64());
		dbc.setString(69, dbocarautohomeprop.getP65());
		dbc.setString(70, dbocarautohomeprop.getP66());
		dbc.setString(71, dbocarautohomeprop.getP67());
		dbc.setString(72, dbocarautohomeprop.getP68());
		dbc.setString(73, dbocarautohomeprop.getP69());
		dbc.setString(74, dbocarautohomeprop.getP70());
		dbc.setString(75, dbocarautohomeprop.getP71());
		dbc.setString(76, dbocarautohomeprop.getP72());
		dbc.setString(77, dbocarautohomeprop.getP73());
		dbc.setString(78, dbocarautohomeprop.getP74());
		dbc.setString(79, dbocarautohomeprop.getP75());
		dbc.setString(80, dbocarautohomeprop.getP76());
		dbc.setString(81, dbocarautohomeprop.getP77());
		dbc.setString(82, dbocarautohomeprop.getP78());
		dbc.setString(83, dbocarautohomeprop.getP79());
		dbc.setString(84, dbocarautohomeprop.getP80());
		dbc.setString(85, dbocarautohomeprop.getP81());
		dbc.setString(86, dbocarautohomeprop.getP82());
		dbc.setString(87, dbocarautohomeprop.getP83());
		dbc.setString(88, dbocarautohomeprop.getP84());
		dbc.setString(89, dbocarautohomeprop.getP85());
		dbc.setString(90, dbocarautohomeprop.getP86());
		dbc.setString(91, dbocarautohomeprop.getP87());
		dbc.setString(92, dbocarautohomeprop.getP88());
		dbc.setString(93, dbocarautohomeprop.getP89());
		dbc.setString(94, dbocarautohomeprop.getP90());
		dbc.setString(95, dbocarautohomeprop.getP91());
		dbc.setString(96, dbocarautohomeprop.getP92());
		dbc.setString(97, dbocarautohomeprop.getP93());
		dbc.setString(98, dbocarautohomeprop.getP94());
		dbc.setString(99, dbocarautohomeprop.getP95());
		dbc.setString(100, dbocarautohomeprop.getP96());
		dbc.setString(101, dbocarautohomeprop.getP97());
		dbc.setString(102, dbocarautohomeprop.getP98());
		dbc.setString(103, dbocarautohomeprop.getP99());
		dbc.setString(104, dbocarautohomeprop.getP100());
		dbc.setString(105, dbocarautohomeprop.getP101());
		dbc.setString(106, dbocarautohomeprop.getP102());
		dbc.setString(107, dbocarautohomeprop.getP103());
		dbc.setString(108, dbocarautohomeprop.getP104());
		dbc.setString(109, dbocarautohomeprop.getP105());
		dbc.setString(110, dbocarautohomeprop.getP106());
		dbc.setString(111, dbocarautohomeprop.getP107());
		dbc.setString(112, dbocarautohomeprop.getP108());
		dbc.setString(113, dbocarautohomeprop.getP109());
		dbc.setString(114, dbocarautohomeprop.getP110());
		dbc.setString(115, dbocarautohomeprop.getP111());
		dbc.setString(116, dbocarautohomeprop.getP112());
		dbc.setString(117, dbocarautohomeprop.getP113());
		dbc.setString(118, dbocarautohomeprop.getP114());
		dbc.setString(119, dbocarautohomeprop.getP115());
		dbc.setString(120, dbocarautohomeprop.getP116());
		dbc.setString(121, dbocarautohomeprop.getP117());
		dbc.setString(122, dbocarautohomeprop.getP118());
		dbc.setString(123, dbocarautohomeprop.getP119());
		dbc.setString(124, dbocarautohomeprop.getP120());
		dbc.setString(125, dbocarautohomeprop.getP121());
		dbc.setString(126, dbocarautohomeprop.getP122());
		dbc.setString(127, dbocarautohomeprop.getP123());
		dbc.setString(128, dbocarautohomeprop.getP124());
		dbc.setString(129, dbocarautohomeprop.getP125());
		dbc.setString(130, dbocarautohomeprop.getP126());
		dbc.setString(131, dbocarautohomeprop.getP127());
		dbc.setString(132, dbocarautohomeprop.getP128());
		dbc.setString(133, dbocarautohomeprop.getP129());
		dbc.setString(134, dbocarautohomeprop.getP130());
		dbc.setString(135, dbocarautohomeprop.getP131());
		dbc.setString(136, dbocarautohomeprop.getP132());
		dbc.setString(137, dbocarautohomeprop.getP133());
		dbc.setString(138, dbocarautohomeprop.getP134());
		dbc.setString(139, dbocarautohomeprop.getP135());
		dbc.setString(140, dbocarautohomeprop.getP136());
		dbc.setString(141, dbocarautohomeprop.getP137());
		dbc.setString(142, dbocarautohomeprop.getP138());
		dbc.setString(143, dbocarautohomeprop.getP139());
		dbc.setString(144, dbocarautohomeprop.getP140());
		dbc.setString(145, dbocarautohomeprop.getP141());
		dbc.setString(146, dbocarautohomeprop.getP142());
		dbc.setString(147, dbocarautohomeprop.getP143());
		dbc.setString(148, dbocarautohomeprop.getP144());
		dbc.setString(149, dbocarautohomeprop.getP145());
		dbc.setString(150, dbocarautohomeprop.getP146());
		dbc.setString(151, dbocarautohomeprop.getP147());
		dbc.setString(152, dbocarautohomeprop.getP148());
		dbc.setString(153, dbocarautohomeprop.getP149());
		dbc.setString(154, dbocarautohomeprop.getP150());
		dbc.setString(155, dbocarautohomeprop.getP151());
		dbc.setString(156, dbocarautohomeprop.getP152());
		dbc.setString(157, dbocarautohomeprop.getP153());
		dbc.setString(158, dbocarautohomeprop.getP154());
		dbc.setString(159, dbocarautohomeprop.getP155());
		dbc.setString(160, dbocarautohomeprop.getP156());
		dbc.setString(161, dbocarautohomeprop.getP157());
		dbc.setString(162, dbocarautohomeprop.getP158());
		dbc.setString(163, dbocarautohomeprop.getP159());
		dbc.setString(164, dbocarautohomeprop.getP160());
		dbc.setString(165, dbocarautohomeprop.getP161());
		dbc.setString(166, dbocarautohomeprop.getP162());
		dbc.setString(167, dbocarautohomeprop.getP163());
		dbc.setString(168, dbocarautohomeprop.getP164());
		dbc.setString(169, dbocarautohomeprop.getP165());
		dbc.setString(170, dbocarautohomeprop.getP166());
		dbc.setString(171, dbocarautohomeprop.getP167());
		dbc.setString(172, dbocarautohomeprop.getP168());
		dbc.setString(173, dbocarautohomeprop.getP169());
		dbc.setString(174, dbocarautohomeprop.getP170());
		dbc.setString(175, dbocarautohomeprop.getP171());
		dbc.setString(176, dbocarautohomeprop.getP172());
		dbc.setString(177, dbocarautohomeprop.getP173());
		dbc.setString(178, dbocarautohomeprop.getP174());
		dbc.setString(179, dbocarautohomeprop.getP175());
		dbc.setString(180, dbocarautohomeprop.getP176());
		dbc.setString(181, dbocarautohomeprop.getP177());
		dbc.setString(182, dbocarautohomeprop.getP178());
		dbc.setString(183, dbocarautohomeprop.getP179());
		dbc.setString(184, dbocarautohomeprop.getP180());
		dbc.setString(185, dbocarautohomeprop.getP181());
		dbc.setString(186, dbocarautohomeprop.getP182());
		dbc.setString(187, dbocarautohomeprop.getP183());
		dbc.setString(188, dbocarautohomeprop.getP184());
		dbc.setString(189, dbocarautohomeprop.getP185());
		dbc.setString(190, dbocarautohomeprop.getP186());
		dbc.setString(191, dbocarautohomeprop.getP187());
		dbc.setString(192, dbocarautohomeprop.getP188());
		dbc.setString(193, dbocarautohomeprop.getP189());
		dbc.setString(194, dbocarautohomeprop.getP190());
		dbc.setString(195, dbocarautohomeprop.getP191());
		dbc.setString(196, dbocarautohomeprop.getP192());
		dbc.setString(197, dbocarautohomeprop.getP193());
		dbc.setString(198, dbocarautohomeprop.getP194());
		dbc.setString(199, dbocarautohomeprop.getP195());
		dbc.setString(200, dbocarautohomeprop.getP196());
		dbc.setString(201, dbocarautohomeprop.getP197());
		dbc.setString(202, dbocarautohomeprop.getP198());
		dbc.setString(203, dbocarautohomeprop.getP199());
		dbc.setString(204, dbocarautohomeprop.getP200());
		dbc.setString(205, dbocarautohomeprop.getP201());
		dbc.setString(206, dbocarautohomeprop.getP202());
		dbc.setString(207, dbocarautohomeprop.getP203());
		dbc.setString(208, dbocarautohomeprop.getP204());
		dbc.setString(209, dbocarautohomeprop.getP205());
		dbc.setString(210, dbocarautohomeprop.getP206());
		dbc.setString(211, dbocarautohomeprop.getP207());
		dbc.setString(212, dbocarautohomeprop.getP208());
		dbc.setString(213, dbocarautohomeprop.getP209());
		dbc.setString(214, dbocarautohomeprop.getP210());
		dbc.setString(215, dbocarautohomeprop.getP211());
		dbc.setString(216, dbocarautohomeprop.getP212());
		dbc.setString(217, dbocarautohomeprop.getP213());
		dbc.setString(218, dbocarautohomeprop.getP214());
		dbc.setString(219, dbocarautohomeprop.getP215());
		dbc.setString(220, dbocarautohomeprop.getP216());
		dbc.setString(221, dbocarautohomeprop.getP217());
		dbc.setString(222, dbocarautohomeprop.getP218());
		dbc.setString(223, dbocarautohomeprop.getP219());
		dbc.setString(224, dbocarautohomeprop.getP220());
		dbc.setString(225, dbocarautohomeprop.getP221());
		dbc.setString(226, dbocarautohomeprop.getP222());
		dbc.setString(227, dbocarautohomeprop.getP223());
		dbc.setString(228, dbocarautohomeprop.getP224());
		dbc.setString(229, dbocarautohomeprop.getP225());
		dbc.setString(230, dbocarautohomeprop.getP226());
		dbc.setString(231, dbocarautohomeprop.getP227());
		dbc.setString(232, dbocarautohomeprop.getP228());
		dbc.setString(233, dbocarautohomeprop.getP229());
		dbc.setString(234, dbocarautohomeprop.getP230());
		dbc.setString(235, dbocarautohomeprop.getP231());
		dbc.setString(236, dbocarautohomeprop.getP232());
		dbc.setString(237, dbocarautohomeprop.getP233());
		dbc.setString(238, dbocarautohomeprop.getP234());
		dbc.setString(239, dbocarautohomeprop.getP235());
		dbc.setString(240, dbocarautohomeprop.getP236());
		dbc.setString(241, dbocarautohomeprop.getP237());
		dbc.setString(242, dbocarautohomeprop.getP238());
		dbc.setString(243, dbocarautohomeprop.getP239());
		dbc.setString(244, dbocarautohomeprop.getP240());
		dbc.setString(245, dbocarautohomeprop.getP241());
		dbc.setString(246, dbocarautohomeprop.getP242());
		dbc.setString(247, dbocarautohomeprop.getP243());
		dbc.setString(248, dbocarautohomeprop.getP244());
		dbc.setString(249, dbocarautohomeprop.getP245());
		dbc.setString(250, dbocarautohomeprop.getP246());
		dbc.setString(251, dbocarautohomeprop.getP247());
		dbc.setString(252, dbocarautohomeprop.getP248());
		dbc.setString(253, dbocarautohomeprop.getP249());
		dbc.setString(254, dbocarautohomeprop.getP250());
		dbc.setString(255, dbocarautohomeprop.getP251());
		dbc.setString(256, dbocarautohomeprop.getP252());
		dbc.setString(257, dbocarautohomeprop.getP253());
		dbc.setString(258, dbocarautohomeprop.getP254());
		dbc.setString(259, dbocarautohomeprop.getP255());
		dbc.setString(260, dbocarautohomeprop.getP256());
		dbc.setString(261, dbocarautohomeprop.getP257());
		dbc.setString(262, dbocarautohomeprop.getP258());
		dbc.setString(263, dbocarautohomeprop.getP259());
		dbc.setString(264, dbocarautohomeprop.getP260());
		dbc.setString(265, dbocarautohomeprop.getP261());
		dbc.setString(266, dbocarautohomeprop.getP262());
		dbc.setString(267, dbocarautohomeprop.getP263());
		dbc.setString(268, dbocarautohomeprop.getP264());
		dbc.setString(269, dbocarautohomeprop.getP265());
		dbc.setString(270, dbocarautohomeprop.getP266());
		dbc.setString(271, dbocarautohomeprop.getP267());
		dbc.setString(272, dbocarautohomeprop.getP268());
		dbc.setString(273, dbocarautohomeprop.getP269());
		dbc.setString(274, dbocarautohomeprop.getP270());
		dbc.setString(275, dbocarautohomeprop.getP271());
		dbc.setString(276, dbocarautohomeprop.getP272());
		dbc.setString(277, dbocarautohomeprop.getP273());
		dbc.setString(278, dbocarautohomeprop.getP274());
		dbc.setString(279, dbocarautohomeprop.getP275());
		dbc.setString(280, dbocarautohomeprop.getP276());
		dbc.setString(281, dbocarautohomeprop.getP277());
		dbc.setString(282, dbocarautohomeprop.getP278());
		dbc.setString(283, dbocarautohomeprop.getP279());
		dbc.setString(284, dbocarautohomeprop.getP280());
		dbc.setString(285, dbocarautohomeprop.getP281());
		dbc.setString(286, dbocarautohomeprop.getP282());
		dbc.setString(287, dbocarautohomeprop.getP283());
		dbc.setString(288, dbocarautohomeprop.getP284());
		dbc.setString(289, dbocarautohomeprop.getP285());
		dbc.setString(290, dbocarautohomeprop.getP286());
		dbc.setString(291, dbocarautohomeprop.getP287());
		dbc.setString(292, dbocarautohomeprop.getP288());
		dbc.setString(293, dbocarautohomeprop.getP289());
		dbc.setString(294, dbocarautohomeprop.getP290());
		dbc.setString(295, dbocarautohomeprop.getP291());
		dbc.setString(296, dbocarautohomeprop.getP292());
		dbc.setString(297, dbocarautohomeprop.getP293());
		dbc.setString(298, dbocarautohomeprop.getP294());
		dbc.setString(299, dbocarautohomeprop.getP295());
		dbc.setString(300, dbocarautohomeprop.getP296());
		dbc.setString(301, dbocarautohomeprop.getP297());
		dbc.setString(302, dbocarautohomeprop.getP298());
		dbc.setString(303, dbocarautohomeprop.getP299());
		dbc.setString(304, dbocarautohomeprop.getP300());
		dbc.setInt(305, dbocarautohomeprop.getIsupdate());
		dbc.setString(306, dbocarautohomeprop.getIway());
		dbc.setInt(307, dbocarautohomeprop.getCar_type());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboCarAutohomeprop dbocarautohomeprop) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_car_autohomeprop(`id`,`carid`,`autohomecarid`,`bid`,`p1`,`p2`,`p3`,`p4`,`p5`,`p6`,`p7`,`p8`,`p9`,`p10`,`p11`,`p12`,`p13`,`p14`,`p15`,`p16`,`p17`,`p18`,`p19`,`p20`,`p21`,`p22`,`p23`,`p24`,`p25`,`p26`,`p27`,`p28`,`p29`,`p30`,`p31`,`p32`,`p33`,`p34`,`p35`,`p36`,`p37`,`p38`,`p39`,`p40`,`p41`,`p42`,`p43`,`p44`,`p45`,`p46`,`p47`,`p48`,`p49`,`p50`,`p51`,`p52`,`p53`,`p54`,`p55`,`p56`,`p57`,`p58`,`p59`,`p60`,`p61`,`p62`,`p63`,`p64`,`p65`,`p66`,`p67`,`p68`,`p69`,`p70`,`p71`,`p72`,`p73`,`p74`,`p75`,`p76`,`p77`,`p78`,`p79`,`p80`,`p81`,`p82`,`p83`,`p84`,`p85`,`p86`,`p87`,`p88`,`p89`,`p90`,`p91`,`p92`,`p93`,`p94`,`p95`,`p96`,`p97`,`p98`,`p99`,`p100`,`p101`,`p102`,`p103`,`p104`,`p105`,`p106`,`p107`,`p108`,`p109`,`p110`,`p111`,`p112`,`p113`,`p114`,`p115`,`p116`,`p117`,`p118`,`p119`,`p120`,`p121`,`p122`,`p123`,`p124`,`p125`,`p126`,`p127`,`p128`,`p129`,`p130`,`p131`,`p132`,`p133`,`p134`,`p135`,`p136`,`p137`,`p138`,`p139`,`p140`,`p141`,`p142`,`p143`,`p144`,`p145`,`p146`,`p147`,`p148`,`p149`,`p150`,`p151`,`p152`,`p153`,`p154`,`p155`,`p156`,`p157`,`p158`,`p159`,`p160`,`p161`,`p162`,`p163`,`p164`,`p165`,`p166`,`p167`,`p168`,`p169`,`p170`,`p171`,`p172`,`p173`,`p174`,`p175`,`p176`,`p177`,`p178`,`p179`,`p180`,`p181`,`p182`,`p183`,`p184`,`p185`,`p186`,`p187`,`p188`,`p189`,`p190`,`p191`,`p192`,`p193`,`p194`,`p195`,`p196`,`p197`,`p198`,`p199`,`p200`,`p201`,`p202`,`p203`,`p204`,`p205`,`p206`,`p207`,`p208`,`p209`,`p210`,`p211`,`p212`,`p213`,`p214`,`p215`,`p216`,`p217`,`p218`,`p219`,`p220`,`p221`,`p222`,`p223`,`p224`,`p225`,`p226`,`p227`,`p228`,`p229`,`p230`,`p231`,`p232`,`p233`,`p234`,`p235`,`p236`,`p237`,`p238`,`p239`,`p240`,`p241`,`p242`,`p243`,`p244`,`p245`,`p246`,`p247`,`p248`,`p249`,`p250`,`p251`,`p252`,`p253`,`p254`,`p255`,`p256`,`p257`,`p258`,`p259`,`p260`,`p261`,`p262`,`p263`,`p264`,`p265`,`p266`,`p267`,`p268`,`p269`,`p270`,`p271`,`p272`,`p273`,`p274`,`p275`,`p276`,`p277`,`p278`,`p279`,`p280`,`p281`,`p282`,`p283`,`p284`,`p285`,`p286`,`p287`,`p288`,`p289`,`p290`,`p291`,`p292`,`p293`,`p294`,`p295`,`p296`,`p297`,`p298`,`p299`,`p300`,`isupdate`,`iway`,`car_type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbocarautohomeprop.getId());
		dbc.setInt(2, dbocarautohomeprop.getCarid());
		dbc.setInt(3, dbocarautohomeprop.getAutohomecarid());
		dbc.setInt(4, dbocarautohomeprop.getBid());
		dbc.setString(5, dbocarautohomeprop.getP1());
		dbc.setString(6, dbocarautohomeprop.getP2());
		dbc.setString(7, dbocarautohomeprop.getP3());
		dbc.setString(8, dbocarautohomeprop.getP4());
		dbc.setString(9, dbocarautohomeprop.getP5());
		dbc.setString(10, dbocarautohomeprop.getP6());
		dbc.setString(11, dbocarautohomeprop.getP7());
		dbc.setString(12, dbocarautohomeprop.getP8());
		dbc.setString(13, dbocarautohomeprop.getP9());
		dbc.setString(14, dbocarautohomeprop.getP10());
		dbc.setString(15, dbocarautohomeprop.getP11());
		dbc.setString(16, dbocarautohomeprop.getP12());
		dbc.setString(17, dbocarautohomeprop.getP13());
		dbc.setString(18, dbocarautohomeprop.getP14());
		dbc.setString(19, dbocarautohomeprop.getP15());
		dbc.setString(20, dbocarautohomeprop.getP16());
		dbc.setString(21, dbocarautohomeprop.getP17());
		dbc.setString(22, dbocarautohomeprop.getP18());
		dbc.setString(23, dbocarautohomeprop.getP19());
		dbc.setString(24, dbocarautohomeprop.getP20());
		dbc.setString(25, dbocarautohomeprop.getP21());
		dbc.setString(26, dbocarautohomeprop.getP22());
		dbc.setString(27, dbocarautohomeprop.getP23());
		dbc.setString(28, dbocarautohomeprop.getP24());
		dbc.setString(29, dbocarautohomeprop.getP25());
		dbc.setString(30, dbocarautohomeprop.getP26());
		dbc.setString(31, dbocarautohomeprop.getP27());
		dbc.setString(32, dbocarautohomeprop.getP28());
		dbc.setString(33, dbocarautohomeprop.getP29());
		dbc.setString(34, dbocarautohomeprop.getP30());
		dbc.setString(35, dbocarautohomeprop.getP31());
		dbc.setString(36, dbocarautohomeprop.getP32());
		dbc.setString(37, dbocarautohomeprop.getP33());
		dbc.setString(38, dbocarautohomeprop.getP34());
		dbc.setString(39, dbocarautohomeprop.getP35());
		dbc.setString(40, dbocarautohomeprop.getP36());
		dbc.setString(41, dbocarautohomeprop.getP37());
		dbc.setString(42, dbocarautohomeprop.getP38());
		dbc.setString(43, dbocarautohomeprop.getP39());
		dbc.setString(44, dbocarautohomeprop.getP40());
		dbc.setString(45, dbocarautohomeprop.getP41());
		dbc.setString(46, dbocarautohomeprop.getP42());
		dbc.setString(47, dbocarautohomeprop.getP43());
		dbc.setString(48, dbocarautohomeprop.getP44());
		dbc.setString(49, dbocarautohomeprop.getP45());
		dbc.setString(50, dbocarautohomeprop.getP46());
		dbc.setString(51, dbocarautohomeprop.getP47());
		dbc.setString(52, dbocarautohomeprop.getP48());
		dbc.setString(53, dbocarautohomeprop.getP49());
		dbc.setString(54, dbocarautohomeprop.getP50());
		dbc.setString(55, dbocarautohomeprop.getP51());
		dbc.setString(56, dbocarautohomeprop.getP52());
		dbc.setString(57, dbocarautohomeprop.getP53());
		dbc.setString(58, dbocarautohomeprop.getP54());
		dbc.setString(59, dbocarautohomeprop.getP55());
		dbc.setString(60, dbocarautohomeprop.getP56());
		dbc.setString(61, dbocarautohomeprop.getP57());
		dbc.setString(62, dbocarautohomeprop.getP58());
		dbc.setString(63, dbocarautohomeprop.getP59());
		dbc.setString(64, dbocarautohomeprop.getP60());
		dbc.setString(65, dbocarautohomeprop.getP61());
		dbc.setString(66, dbocarautohomeprop.getP62());
		dbc.setString(67, dbocarautohomeprop.getP63());
		dbc.setString(68, dbocarautohomeprop.getP64());
		dbc.setString(69, dbocarautohomeprop.getP65());
		dbc.setString(70, dbocarautohomeprop.getP66());
		dbc.setString(71, dbocarautohomeprop.getP67());
		dbc.setString(72, dbocarautohomeprop.getP68());
		dbc.setString(73, dbocarautohomeprop.getP69());
		dbc.setString(74, dbocarautohomeprop.getP70());
		dbc.setString(75, dbocarautohomeprop.getP71());
		dbc.setString(76, dbocarautohomeprop.getP72());
		dbc.setString(77, dbocarautohomeprop.getP73());
		dbc.setString(78, dbocarautohomeprop.getP74());
		dbc.setString(79, dbocarautohomeprop.getP75());
		dbc.setString(80, dbocarautohomeprop.getP76());
		dbc.setString(81, dbocarautohomeprop.getP77());
		dbc.setString(82, dbocarautohomeprop.getP78());
		dbc.setString(83, dbocarautohomeprop.getP79());
		dbc.setString(84, dbocarautohomeprop.getP80());
		dbc.setString(85, dbocarautohomeprop.getP81());
		dbc.setString(86, dbocarautohomeprop.getP82());
		dbc.setString(87, dbocarautohomeprop.getP83());
		dbc.setString(88, dbocarautohomeprop.getP84());
		dbc.setString(89, dbocarautohomeprop.getP85());
		dbc.setString(90, dbocarautohomeprop.getP86());
		dbc.setString(91, dbocarautohomeprop.getP87());
		dbc.setString(92, dbocarautohomeprop.getP88());
		dbc.setString(93, dbocarautohomeprop.getP89());
		dbc.setString(94, dbocarautohomeprop.getP90());
		dbc.setString(95, dbocarautohomeprop.getP91());
		dbc.setString(96, dbocarautohomeprop.getP92());
		dbc.setString(97, dbocarautohomeprop.getP93());
		dbc.setString(98, dbocarautohomeprop.getP94());
		dbc.setString(99, dbocarautohomeprop.getP95());
		dbc.setString(100, dbocarautohomeprop.getP96());
		dbc.setString(101, dbocarautohomeprop.getP97());
		dbc.setString(102, dbocarautohomeprop.getP98());
		dbc.setString(103, dbocarautohomeprop.getP99());
		dbc.setString(104, dbocarautohomeprop.getP100());
		dbc.setString(105, dbocarautohomeprop.getP101());
		dbc.setString(106, dbocarautohomeprop.getP102());
		dbc.setString(107, dbocarautohomeprop.getP103());
		dbc.setString(108, dbocarautohomeprop.getP104());
		dbc.setString(109, dbocarautohomeprop.getP105());
		dbc.setString(110, dbocarautohomeprop.getP106());
		dbc.setString(111, dbocarautohomeprop.getP107());
		dbc.setString(112, dbocarautohomeprop.getP108());
		dbc.setString(113, dbocarautohomeprop.getP109());
		dbc.setString(114, dbocarautohomeprop.getP110());
		dbc.setString(115, dbocarautohomeprop.getP111());
		dbc.setString(116, dbocarautohomeprop.getP112());
		dbc.setString(117, dbocarautohomeprop.getP113());
		dbc.setString(118, dbocarautohomeprop.getP114());
		dbc.setString(119, dbocarautohomeprop.getP115());
		dbc.setString(120, dbocarautohomeprop.getP116());
		dbc.setString(121, dbocarautohomeprop.getP117());
		dbc.setString(122, dbocarautohomeprop.getP118());
		dbc.setString(123, dbocarautohomeprop.getP119());
		dbc.setString(124, dbocarautohomeprop.getP120());
		dbc.setString(125, dbocarautohomeprop.getP121());
		dbc.setString(126, dbocarautohomeprop.getP122());
		dbc.setString(127, dbocarautohomeprop.getP123());
		dbc.setString(128, dbocarautohomeprop.getP124());
		dbc.setString(129, dbocarautohomeprop.getP125());
		dbc.setString(130, dbocarautohomeprop.getP126());
		dbc.setString(131, dbocarautohomeprop.getP127());
		dbc.setString(132, dbocarautohomeprop.getP128());
		dbc.setString(133, dbocarautohomeprop.getP129());
		dbc.setString(134, dbocarautohomeprop.getP130());
		dbc.setString(135, dbocarautohomeprop.getP131());
		dbc.setString(136, dbocarautohomeprop.getP132());
		dbc.setString(137, dbocarautohomeprop.getP133());
		dbc.setString(138, dbocarautohomeprop.getP134());
		dbc.setString(139, dbocarautohomeprop.getP135());
		dbc.setString(140, dbocarautohomeprop.getP136());
		dbc.setString(141, dbocarautohomeprop.getP137());
		dbc.setString(142, dbocarautohomeprop.getP138());
		dbc.setString(143, dbocarautohomeprop.getP139());
		dbc.setString(144, dbocarautohomeprop.getP140());
		dbc.setString(145, dbocarautohomeprop.getP141());
		dbc.setString(146, dbocarautohomeprop.getP142());
		dbc.setString(147, dbocarautohomeprop.getP143());
		dbc.setString(148, dbocarautohomeprop.getP144());
		dbc.setString(149, dbocarautohomeprop.getP145());
		dbc.setString(150, dbocarautohomeprop.getP146());
		dbc.setString(151, dbocarautohomeprop.getP147());
		dbc.setString(152, dbocarautohomeprop.getP148());
		dbc.setString(153, dbocarautohomeprop.getP149());
		dbc.setString(154, dbocarautohomeprop.getP150());
		dbc.setString(155, dbocarautohomeprop.getP151());
		dbc.setString(156, dbocarautohomeprop.getP152());
		dbc.setString(157, dbocarautohomeprop.getP153());
		dbc.setString(158, dbocarautohomeprop.getP154());
		dbc.setString(159, dbocarautohomeprop.getP155());
		dbc.setString(160, dbocarautohomeprop.getP156());
		dbc.setString(161, dbocarautohomeprop.getP157());
		dbc.setString(162, dbocarautohomeprop.getP158());
		dbc.setString(163, dbocarautohomeprop.getP159());
		dbc.setString(164, dbocarautohomeprop.getP160());
		dbc.setString(165, dbocarautohomeprop.getP161());
		dbc.setString(166, dbocarautohomeprop.getP162());
		dbc.setString(167, dbocarautohomeprop.getP163());
		dbc.setString(168, dbocarautohomeprop.getP164());
		dbc.setString(169, dbocarautohomeprop.getP165());
		dbc.setString(170, dbocarautohomeprop.getP166());
		dbc.setString(171, dbocarautohomeprop.getP167());
		dbc.setString(172, dbocarautohomeprop.getP168());
		dbc.setString(173, dbocarautohomeprop.getP169());
		dbc.setString(174, dbocarautohomeprop.getP170());
		dbc.setString(175, dbocarautohomeprop.getP171());
		dbc.setString(176, dbocarautohomeprop.getP172());
		dbc.setString(177, dbocarautohomeprop.getP173());
		dbc.setString(178, dbocarautohomeprop.getP174());
		dbc.setString(179, dbocarautohomeprop.getP175());
		dbc.setString(180, dbocarautohomeprop.getP176());
		dbc.setString(181, dbocarautohomeprop.getP177());
		dbc.setString(182, dbocarautohomeprop.getP178());
		dbc.setString(183, dbocarautohomeprop.getP179());
		dbc.setString(184, dbocarautohomeprop.getP180());
		dbc.setString(185, dbocarautohomeprop.getP181());
		dbc.setString(186, dbocarautohomeprop.getP182());
		dbc.setString(187, dbocarautohomeprop.getP183());
		dbc.setString(188, dbocarautohomeprop.getP184());
		dbc.setString(189, dbocarautohomeprop.getP185());
		dbc.setString(190, dbocarautohomeprop.getP186());
		dbc.setString(191, dbocarautohomeprop.getP187());
		dbc.setString(192, dbocarautohomeprop.getP188());
		dbc.setString(193, dbocarautohomeprop.getP189());
		dbc.setString(194, dbocarautohomeprop.getP190());
		dbc.setString(195, dbocarautohomeprop.getP191());
		dbc.setString(196, dbocarautohomeprop.getP192());
		dbc.setString(197, dbocarautohomeprop.getP193());
		dbc.setString(198, dbocarautohomeprop.getP194());
		dbc.setString(199, dbocarautohomeprop.getP195());
		dbc.setString(200, dbocarautohomeprop.getP196());
		dbc.setString(201, dbocarautohomeprop.getP197());
		dbc.setString(202, dbocarautohomeprop.getP198());
		dbc.setString(203, dbocarautohomeprop.getP199());
		dbc.setString(204, dbocarautohomeprop.getP200());
		dbc.setString(205, dbocarautohomeprop.getP201());
		dbc.setString(206, dbocarautohomeprop.getP202());
		dbc.setString(207, dbocarautohomeprop.getP203());
		dbc.setString(208, dbocarautohomeprop.getP204());
		dbc.setString(209, dbocarautohomeprop.getP205());
		dbc.setString(210, dbocarautohomeprop.getP206());
		dbc.setString(211, dbocarautohomeprop.getP207());
		dbc.setString(212, dbocarautohomeprop.getP208());
		dbc.setString(213, dbocarautohomeprop.getP209());
		dbc.setString(214, dbocarautohomeprop.getP210());
		dbc.setString(215, dbocarautohomeprop.getP211());
		dbc.setString(216, dbocarautohomeprop.getP212());
		dbc.setString(217, dbocarautohomeprop.getP213());
		dbc.setString(218, dbocarautohomeprop.getP214());
		dbc.setString(219, dbocarautohomeprop.getP215());
		dbc.setString(220, dbocarautohomeprop.getP216());
		dbc.setString(221, dbocarautohomeprop.getP217());
		dbc.setString(222, dbocarautohomeprop.getP218());
		dbc.setString(223, dbocarautohomeprop.getP219());
		dbc.setString(224, dbocarautohomeprop.getP220());
		dbc.setString(225, dbocarautohomeprop.getP221());
		dbc.setString(226, dbocarautohomeprop.getP222());
		dbc.setString(227, dbocarautohomeprop.getP223());
		dbc.setString(228, dbocarautohomeprop.getP224());
		dbc.setString(229, dbocarautohomeprop.getP225());
		dbc.setString(230, dbocarautohomeprop.getP226());
		dbc.setString(231, dbocarautohomeprop.getP227());
		dbc.setString(232, dbocarautohomeprop.getP228());
		dbc.setString(233, dbocarautohomeprop.getP229());
		dbc.setString(234, dbocarautohomeprop.getP230());
		dbc.setString(235, dbocarautohomeprop.getP231());
		dbc.setString(236, dbocarautohomeprop.getP232());
		dbc.setString(237, dbocarautohomeprop.getP233());
		dbc.setString(238, dbocarautohomeprop.getP234());
		dbc.setString(239, dbocarautohomeprop.getP235());
		dbc.setString(240, dbocarautohomeprop.getP236());
		dbc.setString(241, dbocarautohomeprop.getP237());
		dbc.setString(242, dbocarautohomeprop.getP238());
		dbc.setString(243, dbocarautohomeprop.getP239());
		dbc.setString(244, dbocarautohomeprop.getP240());
		dbc.setString(245, dbocarautohomeprop.getP241());
		dbc.setString(246, dbocarautohomeprop.getP242());
		dbc.setString(247, dbocarautohomeprop.getP243());
		dbc.setString(248, dbocarautohomeprop.getP244());
		dbc.setString(249, dbocarautohomeprop.getP245());
		dbc.setString(250, dbocarautohomeprop.getP246());
		dbc.setString(251, dbocarautohomeprop.getP247());
		dbc.setString(252, dbocarautohomeprop.getP248());
		dbc.setString(253, dbocarautohomeprop.getP249());
		dbc.setString(254, dbocarautohomeprop.getP250());
		dbc.setString(255, dbocarautohomeprop.getP251());
		dbc.setString(256, dbocarautohomeprop.getP252());
		dbc.setString(257, dbocarautohomeprop.getP253());
		dbc.setString(258, dbocarautohomeprop.getP254());
		dbc.setString(259, dbocarautohomeprop.getP255());
		dbc.setString(260, dbocarautohomeprop.getP256());
		dbc.setString(261, dbocarautohomeprop.getP257());
		dbc.setString(262, dbocarautohomeprop.getP258());
		dbc.setString(263, dbocarautohomeprop.getP259());
		dbc.setString(264, dbocarautohomeprop.getP260());
		dbc.setString(265, dbocarautohomeprop.getP261());
		dbc.setString(266, dbocarautohomeprop.getP262());
		dbc.setString(267, dbocarautohomeprop.getP263());
		dbc.setString(268, dbocarautohomeprop.getP264());
		dbc.setString(269, dbocarautohomeprop.getP265());
		dbc.setString(270, dbocarautohomeprop.getP266());
		dbc.setString(271, dbocarautohomeprop.getP267());
		dbc.setString(272, dbocarautohomeprop.getP268());
		dbc.setString(273, dbocarautohomeprop.getP269());
		dbc.setString(274, dbocarautohomeprop.getP270());
		dbc.setString(275, dbocarautohomeprop.getP271());
		dbc.setString(276, dbocarautohomeprop.getP272());
		dbc.setString(277, dbocarautohomeprop.getP273());
		dbc.setString(278, dbocarautohomeprop.getP274());
		dbc.setString(279, dbocarautohomeprop.getP275());
		dbc.setString(280, dbocarautohomeprop.getP276());
		dbc.setString(281, dbocarautohomeprop.getP277());
		dbc.setString(282, dbocarautohomeprop.getP278());
		dbc.setString(283, dbocarautohomeprop.getP279());
		dbc.setString(284, dbocarautohomeprop.getP280());
		dbc.setString(285, dbocarautohomeprop.getP281());
		dbc.setString(286, dbocarautohomeprop.getP282());
		dbc.setString(287, dbocarautohomeprop.getP283());
		dbc.setString(288, dbocarautohomeprop.getP284());
		dbc.setString(289, dbocarautohomeprop.getP285());
		dbc.setString(290, dbocarautohomeprop.getP286());
		dbc.setString(291, dbocarautohomeprop.getP287());
		dbc.setString(292, dbocarautohomeprop.getP288());
		dbc.setString(293, dbocarautohomeprop.getP289());
		dbc.setString(294, dbocarautohomeprop.getP290());
		dbc.setString(295, dbocarautohomeprop.getP291());
		dbc.setString(296, dbocarautohomeprop.getP292());
		dbc.setString(297, dbocarautohomeprop.getP293());
		dbc.setString(298, dbocarautohomeprop.getP294());
		dbc.setString(299, dbocarautohomeprop.getP295());
		dbc.setString(300, dbocarautohomeprop.getP296());
		dbc.setString(301, dbocarautohomeprop.getP297());
		dbc.setString(302, dbocarautohomeprop.getP298());
		dbc.setString(303, dbocarautohomeprop.getP299());
		dbc.setString(304, dbocarautohomeprop.getP300());
		dbc.setInt(305, dbocarautohomeprop.getIsupdate());
		dbc.setString(306, dbocarautohomeprop.getIway());
		dbc.setInt(307, dbocarautohomeprop.getCar_type());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboCarAutohomeprop dbocarautohomeprop) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_car_autohomeprop set ");
		boolean flag = false;
		if(dbocarautohomeprop.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",carid=?");
			}else{
				sb.append("carid=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",autohomecarid=?");
			}else{
				sb.append("autohomecarid=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",bid=?");
			}else{
				sb.append("bid=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",p1=?");
			}else{
				sb.append("p1=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",p2=?");
			}else{
				sb.append("p2=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",p3=?");
			}else{
				sb.append("p3=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",p4=?");
			}else{
				sb.append("p4=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",p5=?");
			}else{
				sb.append("p5=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",p6=?");
			}else{
				sb.append("p6=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",p7=?");
			}else{
				sb.append("p7=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",p8=?");
			}else{
				sb.append("p8=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",p9=?");
			}else{
				sb.append("p9=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",p10=?");
			}else{
				sb.append("p10=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",p11=?");
			}else{
				sb.append("p11=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",p12=?");
			}else{
				sb.append("p12=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",p13=?");
			}else{
				sb.append("p13=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",p14=?");
			}else{
				sb.append("p14=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",p15=?");
			}else{
				sb.append("p15=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",p16=?");
			}else{
				sb.append("p16=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",p17=?");
			}else{
				sb.append("p17=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",p18=?");
			}else{
				sb.append("p18=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",p19=?");
			}else{
				sb.append("p19=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",p20=?");
			}else{
				sb.append("p20=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",p21=?");
			}else{
				sb.append("p21=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",p22=?");
			}else{
				sb.append("p22=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",p23=?");
			}else{
				sb.append("p23=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",p24=?");
			}else{
				sb.append("p24=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",p25=?");
			}else{
				sb.append("p25=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",p26=?");
			}else{
				sb.append("p26=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",p27=?");
			}else{
				sb.append("p27=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",p28=?");
			}else{
				sb.append("p28=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",p29=?");
			}else{
				sb.append("p29=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",p30=?");
			}else{
				sb.append("p30=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",p31=?");
			}else{
				sb.append("p31=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",p32=?");
			}else{
				sb.append("p32=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",p33=?");
			}else{
				sb.append("p33=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",p34=?");
			}else{
				sb.append("p34=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",p35=?");
			}else{
				sb.append("p35=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",p36=?");
			}else{
				sb.append("p36=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",p37=?");
			}else{
				sb.append("p37=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",p38=?");
			}else{
				sb.append("p38=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",p39=?");
			}else{
				sb.append("p39=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[43]){
			if(flag){
				sb.append(",p40=?");
			}else{
				sb.append("p40=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[44]){
			if(flag){
				sb.append(",p41=?");
			}else{
				sb.append("p41=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[45]){
			if(flag){
				sb.append(",p42=?");
			}else{
				sb.append("p42=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[46]){
			if(flag){
				sb.append(",p43=?");
			}else{
				sb.append("p43=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[47]){
			if(flag){
				sb.append(",p44=?");
			}else{
				sb.append("p44=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[48]){
			if(flag){
				sb.append(",p45=?");
			}else{
				sb.append("p45=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[49]){
			if(flag){
				sb.append(",p46=?");
			}else{
				sb.append("p46=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[50]){
			if(flag){
				sb.append(",p47=?");
			}else{
				sb.append("p47=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[51]){
			if(flag){
				sb.append(",p48=?");
			}else{
				sb.append("p48=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[52]){
			if(flag){
				sb.append(",p49=?");
			}else{
				sb.append("p49=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[53]){
			if(flag){
				sb.append(",p50=?");
			}else{
				sb.append("p50=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[54]){
			if(flag){
				sb.append(",p51=?");
			}else{
				sb.append("p51=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[55]){
			if(flag){
				sb.append(",p52=?");
			}else{
				sb.append("p52=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[56]){
			if(flag){
				sb.append(",p53=?");
			}else{
				sb.append("p53=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[57]){
			if(flag){
				sb.append(",p54=?");
			}else{
				sb.append("p54=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[58]){
			if(flag){
				sb.append(",p55=?");
			}else{
				sb.append("p55=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[59]){
			if(flag){
				sb.append(",p56=?");
			}else{
				sb.append("p56=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[60]){
			if(flag){
				sb.append(",p57=?");
			}else{
				sb.append("p57=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[61]){
			if(flag){
				sb.append(",p58=?");
			}else{
				sb.append("p58=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[62]){
			if(flag){
				sb.append(",p59=?");
			}else{
				sb.append("p59=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[63]){
			if(flag){
				sb.append(",p60=?");
			}else{
				sb.append("p60=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[64]){
			if(flag){
				sb.append(",p61=?");
			}else{
				sb.append("p61=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[65]){
			if(flag){
				sb.append(",p62=?");
			}else{
				sb.append("p62=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[66]){
			if(flag){
				sb.append(",p63=?");
			}else{
				sb.append("p63=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[67]){
			if(flag){
				sb.append(",p64=?");
			}else{
				sb.append("p64=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[68]){
			if(flag){
				sb.append(",p65=?");
			}else{
				sb.append("p65=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[69]){
			if(flag){
				sb.append(",p66=?");
			}else{
				sb.append("p66=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[70]){
			if(flag){
				sb.append(",p67=?");
			}else{
				sb.append("p67=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[71]){
			if(flag){
				sb.append(",p68=?");
			}else{
				sb.append("p68=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[72]){
			if(flag){
				sb.append(",p69=?");
			}else{
				sb.append("p69=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[73]){
			if(flag){
				sb.append(",p70=?");
			}else{
				sb.append("p70=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[74]){
			if(flag){
				sb.append(",p71=?");
			}else{
				sb.append("p71=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[75]){
			if(flag){
				sb.append(",p72=?");
			}else{
				sb.append("p72=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[76]){
			if(flag){
				sb.append(",p73=?");
			}else{
				sb.append("p73=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[77]){
			if(flag){
				sb.append(",p74=?");
			}else{
				sb.append("p74=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[78]){
			if(flag){
				sb.append(",p75=?");
			}else{
				sb.append("p75=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[79]){
			if(flag){
				sb.append(",p76=?");
			}else{
				sb.append("p76=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[80]){
			if(flag){
				sb.append(",p77=?");
			}else{
				sb.append("p77=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[81]){
			if(flag){
				sb.append(",p78=?");
			}else{
				sb.append("p78=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[82]){
			if(flag){
				sb.append(",p79=?");
			}else{
				sb.append("p79=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[83]){
			if(flag){
				sb.append(",p80=?");
			}else{
				sb.append("p80=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[84]){
			if(flag){
				sb.append(",p81=?");
			}else{
				sb.append("p81=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[85]){
			if(flag){
				sb.append(",p82=?");
			}else{
				sb.append("p82=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[86]){
			if(flag){
				sb.append(",p83=?");
			}else{
				sb.append("p83=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[87]){
			if(flag){
				sb.append(",p84=?");
			}else{
				sb.append("p84=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[88]){
			if(flag){
				sb.append(",p85=?");
			}else{
				sb.append("p85=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[89]){
			if(flag){
				sb.append(",p86=?");
			}else{
				sb.append("p86=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[90]){
			if(flag){
				sb.append(",p87=?");
			}else{
				sb.append("p87=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[91]){
			if(flag){
				sb.append(",p88=?");
			}else{
				sb.append("p88=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[92]){
			if(flag){
				sb.append(",p89=?");
			}else{
				sb.append("p89=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[93]){
			if(flag){
				sb.append(",p90=?");
			}else{
				sb.append("p90=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[94]){
			if(flag){
				sb.append(",p91=?");
			}else{
				sb.append("p91=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[95]){
			if(flag){
				sb.append(",p92=?");
			}else{
				sb.append("p92=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[96]){
			if(flag){
				sb.append(",p93=?");
			}else{
				sb.append("p93=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[97]){
			if(flag){
				sb.append(",p94=?");
			}else{
				sb.append("p94=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[98]){
			if(flag){
				sb.append(",p95=?");
			}else{
				sb.append("p95=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[99]){
			if(flag){
				sb.append(",p96=?");
			}else{
				sb.append("p96=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[100]){
			if(flag){
				sb.append(",p97=?");
			}else{
				sb.append("p97=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[101]){
			if(flag){
				sb.append(",p98=?");
			}else{
				sb.append("p98=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[102]){
			if(flag){
				sb.append(",p99=?");
			}else{
				sb.append("p99=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[103]){
			if(flag){
				sb.append(",p100=?");
			}else{
				sb.append("p100=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[104]){
			if(flag){
				sb.append(",p101=?");
			}else{
				sb.append("p101=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[105]){
			if(flag){
				sb.append(",p102=?");
			}else{
				sb.append("p102=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[106]){
			if(flag){
				sb.append(",p103=?");
			}else{
				sb.append("p103=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[107]){
			if(flag){
				sb.append(",p104=?");
			}else{
				sb.append("p104=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[108]){
			if(flag){
				sb.append(",p105=?");
			}else{
				sb.append("p105=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[109]){
			if(flag){
				sb.append(",p106=?");
			}else{
				sb.append("p106=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[110]){
			if(flag){
				sb.append(",p107=?");
			}else{
				sb.append("p107=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[111]){
			if(flag){
				sb.append(",p108=?");
			}else{
				sb.append("p108=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[112]){
			if(flag){
				sb.append(",p109=?");
			}else{
				sb.append("p109=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[113]){
			if(flag){
				sb.append(",p110=?");
			}else{
				sb.append("p110=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[114]){
			if(flag){
				sb.append(",p111=?");
			}else{
				sb.append("p111=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[115]){
			if(flag){
				sb.append(",p112=?");
			}else{
				sb.append("p112=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[116]){
			if(flag){
				sb.append(",p113=?");
			}else{
				sb.append("p113=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[117]){
			if(flag){
				sb.append(",p114=?");
			}else{
				sb.append("p114=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[118]){
			if(flag){
				sb.append(",p115=?");
			}else{
				sb.append("p115=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[119]){
			if(flag){
				sb.append(",p116=?");
			}else{
				sb.append("p116=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[120]){
			if(flag){
				sb.append(",p117=?");
			}else{
				sb.append("p117=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[121]){
			if(flag){
				sb.append(",p118=?");
			}else{
				sb.append("p118=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[122]){
			if(flag){
				sb.append(",p119=?");
			}else{
				sb.append("p119=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[123]){
			if(flag){
				sb.append(",p120=?");
			}else{
				sb.append("p120=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[124]){
			if(flag){
				sb.append(",p121=?");
			}else{
				sb.append("p121=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[125]){
			if(flag){
				sb.append(",p122=?");
			}else{
				sb.append("p122=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[126]){
			if(flag){
				sb.append(",p123=?");
			}else{
				sb.append("p123=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[127]){
			if(flag){
				sb.append(",p124=?");
			}else{
				sb.append("p124=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[128]){
			if(flag){
				sb.append(",p125=?");
			}else{
				sb.append("p125=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[129]){
			if(flag){
				sb.append(",p126=?");
			}else{
				sb.append("p126=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[130]){
			if(flag){
				sb.append(",p127=?");
			}else{
				sb.append("p127=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[131]){
			if(flag){
				sb.append(",p128=?");
			}else{
				sb.append("p128=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[132]){
			if(flag){
				sb.append(",p129=?");
			}else{
				sb.append("p129=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[133]){
			if(flag){
				sb.append(",p130=?");
			}else{
				sb.append("p130=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[134]){
			if(flag){
				sb.append(",p131=?");
			}else{
				sb.append("p131=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[135]){
			if(flag){
				sb.append(",p132=?");
			}else{
				sb.append("p132=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[136]){
			if(flag){
				sb.append(",p133=?");
			}else{
				sb.append("p133=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[137]){
			if(flag){
				sb.append(",p134=?");
			}else{
				sb.append("p134=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[138]){
			if(flag){
				sb.append(",p135=?");
			}else{
				sb.append("p135=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[139]){
			if(flag){
				sb.append(",p136=?");
			}else{
				sb.append("p136=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[140]){
			if(flag){
				sb.append(",p137=?");
			}else{
				sb.append("p137=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[141]){
			if(flag){
				sb.append(",p138=?");
			}else{
				sb.append("p138=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[142]){
			if(flag){
				sb.append(",p139=?");
			}else{
				sb.append("p139=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[143]){
			if(flag){
				sb.append(",p140=?");
			}else{
				sb.append("p140=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[144]){
			if(flag){
				sb.append(",p141=?");
			}else{
				sb.append("p141=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[145]){
			if(flag){
				sb.append(",p142=?");
			}else{
				sb.append("p142=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[146]){
			if(flag){
				sb.append(",p143=?");
			}else{
				sb.append("p143=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[147]){
			if(flag){
				sb.append(",p144=?");
			}else{
				sb.append("p144=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[148]){
			if(flag){
				sb.append(",p145=?");
			}else{
				sb.append("p145=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[149]){
			if(flag){
				sb.append(",p146=?");
			}else{
				sb.append("p146=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[150]){
			if(flag){
				sb.append(",p147=?");
			}else{
				sb.append("p147=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[151]){
			if(flag){
				sb.append(",p148=?");
			}else{
				sb.append("p148=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[152]){
			if(flag){
				sb.append(",p149=?");
			}else{
				sb.append("p149=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[153]){
			if(flag){
				sb.append(",p150=?");
			}else{
				sb.append("p150=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[154]){
			if(flag){
				sb.append(",p151=?");
			}else{
				sb.append("p151=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[155]){
			if(flag){
				sb.append(",p152=?");
			}else{
				sb.append("p152=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[156]){
			if(flag){
				sb.append(",p153=?");
			}else{
				sb.append("p153=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[157]){
			if(flag){
				sb.append(",p154=?");
			}else{
				sb.append("p154=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[158]){
			if(flag){
				sb.append(",p155=?");
			}else{
				sb.append("p155=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[159]){
			if(flag){
				sb.append(",p156=?");
			}else{
				sb.append("p156=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[160]){
			if(flag){
				sb.append(",p157=?");
			}else{
				sb.append("p157=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[161]){
			if(flag){
				sb.append(",p158=?");
			}else{
				sb.append("p158=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[162]){
			if(flag){
				sb.append(",p159=?");
			}else{
				sb.append("p159=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[163]){
			if(flag){
				sb.append(",p160=?");
			}else{
				sb.append("p160=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[164]){
			if(flag){
				sb.append(",p161=?");
			}else{
				sb.append("p161=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[165]){
			if(flag){
				sb.append(",p162=?");
			}else{
				sb.append("p162=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[166]){
			if(flag){
				sb.append(",p163=?");
			}else{
				sb.append("p163=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[167]){
			if(flag){
				sb.append(",p164=?");
			}else{
				sb.append("p164=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[168]){
			if(flag){
				sb.append(",p165=?");
			}else{
				sb.append("p165=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[169]){
			if(flag){
				sb.append(",p166=?");
			}else{
				sb.append("p166=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[170]){
			if(flag){
				sb.append(",p167=?");
			}else{
				sb.append("p167=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[171]){
			if(flag){
				sb.append(",p168=?");
			}else{
				sb.append("p168=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[172]){
			if(flag){
				sb.append(",p169=?");
			}else{
				sb.append("p169=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[173]){
			if(flag){
				sb.append(",p170=?");
			}else{
				sb.append("p170=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[174]){
			if(flag){
				sb.append(",p171=?");
			}else{
				sb.append("p171=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[175]){
			if(flag){
				sb.append(",p172=?");
			}else{
				sb.append("p172=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[176]){
			if(flag){
				sb.append(",p173=?");
			}else{
				sb.append("p173=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[177]){
			if(flag){
				sb.append(",p174=?");
			}else{
				sb.append("p174=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[178]){
			if(flag){
				sb.append(",p175=?");
			}else{
				sb.append("p175=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[179]){
			if(flag){
				sb.append(",p176=?");
			}else{
				sb.append("p176=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[180]){
			if(flag){
				sb.append(",p177=?");
			}else{
				sb.append("p177=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[181]){
			if(flag){
				sb.append(",p178=?");
			}else{
				sb.append("p178=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[182]){
			if(flag){
				sb.append(",p179=?");
			}else{
				sb.append("p179=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[183]){
			if(flag){
				sb.append(",p180=?");
			}else{
				sb.append("p180=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[184]){
			if(flag){
				sb.append(",p181=?");
			}else{
				sb.append("p181=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[185]){
			if(flag){
				sb.append(",p182=?");
			}else{
				sb.append("p182=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[186]){
			if(flag){
				sb.append(",p183=?");
			}else{
				sb.append("p183=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[187]){
			if(flag){
				sb.append(",p184=?");
			}else{
				sb.append("p184=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[188]){
			if(flag){
				sb.append(",p185=?");
			}else{
				sb.append("p185=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[189]){
			if(flag){
				sb.append(",p186=?");
			}else{
				sb.append("p186=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[190]){
			if(flag){
				sb.append(",p187=?");
			}else{
				sb.append("p187=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[191]){
			if(flag){
				sb.append(",p188=?");
			}else{
				sb.append("p188=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[192]){
			if(flag){
				sb.append(",p189=?");
			}else{
				sb.append("p189=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[193]){
			if(flag){
				sb.append(",p190=?");
			}else{
				sb.append("p190=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[194]){
			if(flag){
				sb.append(",p191=?");
			}else{
				sb.append("p191=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[195]){
			if(flag){
				sb.append(",p192=?");
			}else{
				sb.append("p192=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[196]){
			if(flag){
				sb.append(",p193=?");
			}else{
				sb.append("p193=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[197]){
			if(flag){
				sb.append(",p194=?");
			}else{
				sb.append("p194=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[198]){
			if(flag){
				sb.append(",p195=?");
			}else{
				sb.append("p195=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[199]){
			if(flag){
				sb.append(",p196=?");
			}else{
				sb.append("p196=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[200]){
			if(flag){
				sb.append(",p197=?");
			}else{
				sb.append("p197=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[201]){
			if(flag){
				sb.append(",p198=?");
			}else{
				sb.append("p198=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[202]){
			if(flag){
				sb.append(",p199=?");
			}else{
				sb.append("p199=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[203]){
			if(flag){
				sb.append(",p200=?");
			}else{
				sb.append("p200=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[204]){
			if(flag){
				sb.append(",p201=?");
			}else{
				sb.append("p201=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[205]){
			if(flag){
				sb.append(",p202=?");
			}else{
				sb.append("p202=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[206]){
			if(flag){
				sb.append(",p203=?");
			}else{
				sb.append("p203=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[207]){
			if(flag){
				sb.append(",p204=?");
			}else{
				sb.append("p204=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[208]){
			if(flag){
				sb.append(",p205=?");
			}else{
				sb.append("p205=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[209]){
			if(flag){
				sb.append(",p206=?");
			}else{
				sb.append("p206=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[210]){
			if(flag){
				sb.append(",p207=?");
			}else{
				sb.append("p207=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[211]){
			if(flag){
				sb.append(",p208=?");
			}else{
				sb.append("p208=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[212]){
			if(flag){
				sb.append(",p209=?");
			}else{
				sb.append("p209=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[213]){
			if(flag){
				sb.append(",p210=?");
			}else{
				sb.append("p210=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[214]){
			if(flag){
				sb.append(",p211=?");
			}else{
				sb.append("p211=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[215]){
			if(flag){
				sb.append(",p212=?");
			}else{
				sb.append("p212=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[216]){
			if(flag){
				sb.append(",p213=?");
			}else{
				sb.append("p213=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[217]){
			if(flag){
				sb.append(",p214=?");
			}else{
				sb.append("p214=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[218]){
			if(flag){
				sb.append(",p215=?");
			}else{
				sb.append("p215=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[219]){
			if(flag){
				sb.append(",p216=?");
			}else{
				sb.append("p216=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[220]){
			if(flag){
				sb.append(",p217=?");
			}else{
				sb.append("p217=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[221]){
			if(flag){
				sb.append(",p218=?");
			}else{
				sb.append("p218=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[222]){
			if(flag){
				sb.append(",p219=?");
			}else{
				sb.append("p219=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[223]){
			if(flag){
				sb.append(",p220=?");
			}else{
				sb.append("p220=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[224]){
			if(flag){
				sb.append(",p221=?");
			}else{
				sb.append("p221=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[225]){
			if(flag){
				sb.append(",p222=?");
			}else{
				sb.append("p222=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[226]){
			if(flag){
				sb.append(",p223=?");
			}else{
				sb.append("p223=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[227]){
			if(flag){
				sb.append(",p224=?");
			}else{
				sb.append("p224=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[228]){
			if(flag){
				sb.append(",p225=?");
			}else{
				sb.append("p225=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[229]){
			if(flag){
				sb.append(",p226=?");
			}else{
				sb.append("p226=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[230]){
			if(flag){
				sb.append(",p227=?");
			}else{
				sb.append("p227=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[231]){
			if(flag){
				sb.append(",p228=?");
			}else{
				sb.append("p228=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[232]){
			if(flag){
				sb.append(",p229=?");
			}else{
				sb.append("p229=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[233]){
			if(flag){
				sb.append(",p230=?");
			}else{
				sb.append("p230=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[234]){
			if(flag){
				sb.append(",p231=?");
			}else{
				sb.append("p231=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[235]){
			if(flag){
				sb.append(",p232=?");
			}else{
				sb.append("p232=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[236]){
			if(flag){
				sb.append(",p233=?");
			}else{
				sb.append("p233=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[237]){
			if(flag){
				sb.append(",p234=?");
			}else{
				sb.append("p234=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[238]){
			if(flag){
				sb.append(",p235=?");
			}else{
				sb.append("p235=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[239]){
			if(flag){
				sb.append(",p236=?");
			}else{
				sb.append("p236=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[240]){
			if(flag){
				sb.append(",p237=?");
			}else{
				sb.append("p237=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[241]){
			if(flag){
				sb.append(",p238=?");
			}else{
				sb.append("p238=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[242]){
			if(flag){
				sb.append(",p239=?");
			}else{
				sb.append("p239=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[243]){
			if(flag){
				sb.append(",p240=?");
			}else{
				sb.append("p240=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[244]){
			if(flag){
				sb.append(",p241=?");
			}else{
				sb.append("p241=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[245]){
			if(flag){
				sb.append(",p242=?");
			}else{
				sb.append("p242=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[246]){
			if(flag){
				sb.append(",p243=?");
			}else{
				sb.append("p243=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[247]){
			if(flag){
				sb.append(",p244=?");
			}else{
				sb.append("p244=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[248]){
			if(flag){
				sb.append(",p245=?");
			}else{
				sb.append("p245=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[249]){
			if(flag){
				sb.append(",p246=?");
			}else{
				sb.append("p246=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[250]){
			if(flag){
				sb.append(",p247=?");
			}else{
				sb.append("p247=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[251]){
			if(flag){
				sb.append(",p248=?");
			}else{
				sb.append("p248=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[252]){
			if(flag){
				sb.append(",p249=?");
			}else{
				sb.append("p249=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[253]){
			if(flag){
				sb.append(",p250=?");
			}else{
				sb.append("p250=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[254]){
			if(flag){
				sb.append(",p251=?");
			}else{
				sb.append("p251=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[255]){
			if(flag){
				sb.append(",p252=?");
			}else{
				sb.append("p252=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[256]){
			if(flag){
				sb.append(",p253=?");
			}else{
				sb.append("p253=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[257]){
			if(flag){
				sb.append(",p254=?");
			}else{
				sb.append("p254=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[258]){
			if(flag){
				sb.append(",p255=?");
			}else{
				sb.append("p255=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[259]){
			if(flag){
				sb.append(",p256=?");
			}else{
				sb.append("p256=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[260]){
			if(flag){
				sb.append(",p257=?");
			}else{
				sb.append("p257=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[261]){
			if(flag){
				sb.append(",p258=?");
			}else{
				sb.append("p258=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[262]){
			if(flag){
				sb.append(",p259=?");
			}else{
				sb.append("p259=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[263]){
			if(flag){
				sb.append(",p260=?");
			}else{
				sb.append("p260=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[264]){
			if(flag){
				sb.append(",p261=?");
			}else{
				sb.append("p261=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[265]){
			if(flag){
				sb.append(",p262=?");
			}else{
				sb.append("p262=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[266]){
			if(flag){
				sb.append(",p263=?");
			}else{
				sb.append("p263=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[267]){
			if(flag){
				sb.append(",p264=?");
			}else{
				sb.append("p264=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[268]){
			if(flag){
				sb.append(",p265=?");
			}else{
				sb.append("p265=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[269]){
			if(flag){
				sb.append(",p266=?");
			}else{
				sb.append("p266=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[270]){
			if(flag){
				sb.append(",p267=?");
			}else{
				sb.append("p267=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[271]){
			if(flag){
				sb.append(",p268=?");
			}else{
				sb.append("p268=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[272]){
			if(flag){
				sb.append(",p269=?");
			}else{
				sb.append("p269=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[273]){
			if(flag){
				sb.append(",p270=?");
			}else{
				sb.append("p270=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[274]){
			if(flag){
				sb.append(",p271=?");
			}else{
				sb.append("p271=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[275]){
			if(flag){
				sb.append(",p272=?");
			}else{
				sb.append("p272=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[276]){
			if(flag){
				sb.append(",p273=?");
			}else{
				sb.append("p273=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[277]){
			if(flag){
				sb.append(",p274=?");
			}else{
				sb.append("p274=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[278]){
			if(flag){
				sb.append(",p275=?");
			}else{
				sb.append("p275=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[279]){
			if(flag){
				sb.append(",p276=?");
			}else{
				sb.append("p276=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[280]){
			if(flag){
				sb.append(",p277=?");
			}else{
				sb.append("p277=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[281]){
			if(flag){
				sb.append(",p278=?");
			}else{
				sb.append("p278=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[282]){
			if(flag){
				sb.append(",p279=?");
			}else{
				sb.append("p279=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[283]){
			if(flag){
				sb.append(",p280=?");
			}else{
				sb.append("p280=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[284]){
			if(flag){
				sb.append(",p281=?");
			}else{
				sb.append("p281=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[285]){
			if(flag){
				sb.append(",p282=?");
			}else{
				sb.append("p282=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[286]){
			if(flag){
				sb.append(",p283=?");
			}else{
				sb.append("p283=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[287]){
			if(flag){
				sb.append(",p284=?");
			}else{
				sb.append("p284=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[288]){
			if(flag){
				sb.append(",p285=?");
			}else{
				sb.append("p285=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[289]){
			if(flag){
				sb.append(",p286=?");
			}else{
				sb.append("p286=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[290]){
			if(flag){
				sb.append(",p287=?");
			}else{
				sb.append("p287=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[291]){
			if(flag){
				sb.append(",p288=?");
			}else{
				sb.append("p288=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[292]){
			if(flag){
				sb.append(",p289=?");
			}else{
				sb.append("p289=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[293]){
			if(flag){
				sb.append(",p290=?");
			}else{
				sb.append("p290=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[294]){
			if(flag){
				sb.append(",p291=?");
			}else{
				sb.append("p291=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[295]){
			if(flag){
				sb.append(",p292=?");
			}else{
				sb.append("p292=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[296]){
			if(flag){
				sb.append(",p293=?");
			}else{
				sb.append("p293=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[297]){
			if(flag){
				sb.append(",p294=?");
			}else{
				sb.append("p294=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[298]){
			if(flag){
				sb.append(",p295=?");
			}else{
				sb.append("p295=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[299]){
			if(flag){
				sb.append(",p296=?");
			}else{
				sb.append("p296=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[300]){
			if(flag){
				sb.append(",p297=?");
			}else{
				sb.append("p297=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[301]){
			if(flag){
				sb.append(",p298=?");
			}else{
				sb.append("p298=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[302]){
			if(flag){
				sb.append(",p299=?");
			}else{
				sb.append("p299=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[303]){
			if(flag){
				sb.append(",p300=?");
			}else{
				sb.append("p300=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[304]){
			if(flag){
				sb.append(",isupdate=?");
			}else{
				sb.append("isupdate=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[305]){
			if(flag){
				sb.append(",iway=?");
			}else{
				sb.append("iway=?");
				flag=true;
			}
		}
		if(dbocarautohomeprop.COLUMN_FLAG[306]){
			if(flag){
				sb.append(",car_type=?");
			}else{
				sb.append("car_type=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbocarautohomeprop.COLUMN_FLAG[0]){
			dbc.setInt(k, dbocarautohomeprop.getId());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[1]){
			dbc.setInt(k, dbocarautohomeprop.getCarid());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[2]){
			dbc.setInt(k, dbocarautohomeprop.getAutohomecarid());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[3]){
			dbc.setInt(k, dbocarautohomeprop.getBid());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[4]){
			dbc.setString(k, dbocarautohomeprop.getP1());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[5]){
			dbc.setString(k, dbocarautohomeprop.getP2());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[6]){
			dbc.setString(k, dbocarautohomeprop.getP3());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[7]){
			dbc.setString(k, dbocarautohomeprop.getP4());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[8]){
			dbc.setString(k, dbocarautohomeprop.getP5());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[9]){
			dbc.setString(k, dbocarautohomeprop.getP6());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[10]){
			dbc.setString(k, dbocarautohomeprop.getP7());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[11]){
			dbc.setString(k, dbocarautohomeprop.getP8());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[12]){
			dbc.setString(k, dbocarautohomeprop.getP9());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[13]){
			dbc.setString(k, dbocarautohomeprop.getP10());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[14]){
			dbc.setString(k, dbocarautohomeprop.getP11());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[15]){
			dbc.setString(k, dbocarautohomeprop.getP12());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[16]){
			dbc.setString(k, dbocarautohomeprop.getP13());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[17]){
			dbc.setString(k, dbocarautohomeprop.getP14());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[18]){
			dbc.setString(k, dbocarautohomeprop.getP15());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[19]){
			dbc.setString(k, dbocarautohomeprop.getP16());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[20]){
			dbc.setString(k, dbocarautohomeprop.getP17());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[21]){
			dbc.setString(k, dbocarautohomeprop.getP18());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[22]){
			dbc.setString(k, dbocarautohomeprop.getP19());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[23]){
			dbc.setString(k, dbocarautohomeprop.getP20());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[24]){
			dbc.setString(k, dbocarautohomeprop.getP21());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[25]){
			dbc.setString(k, dbocarautohomeprop.getP22());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[26]){
			dbc.setString(k, dbocarautohomeprop.getP23());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[27]){
			dbc.setString(k, dbocarautohomeprop.getP24());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[28]){
			dbc.setString(k, dbocarautohomeprop.getP25());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[29]){
			dbc.setString(k, dbocarautohomeprop.getP26());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[30]){
			dbc.setString(k, dbocarautohomeprop.getP27());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[31]){
			dbc.setString(k, dbocarautohomeprop.getP28());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[32]){
			dbc.setString(k, dbocarautohomeprop.getP29());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[33]){
			dbc.setString(k, dbocarautohomeprop.getP30());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[34]){
			dbc.setString(k, dbocarautohomeprop.getP31());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[35]){
			dbc.setString(k, dbocarautohomeprop.getP32());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[36]){
			dbc.setString(k, dbocarautohomeprop.getP33());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[37]){
			dbc.setString(k, dbocarautohomeprop.getP34());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[38]){
			dbc.setString(k, dbocarautohomeprop.getP35());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[39]){
			dbc.setString(k, dbocarautohomeprop.getP36());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[40]){
			dbc.setString(k, dbocarautohomeprop.getP37());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[41]){
			dbc.setString(k, dbocarautohomeprop.getP38());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[42]){
			dbc.setString(k, dbocarautohomeprop.getP39());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[43]){
			dbc.setString(k, dbocarautohomeprop.getP40());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[44]){
			dbc.setString(k, dbocarautohomeprop.getP41());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[45]){
			dbc.setString(k, dbocarautohomeprop.getP42());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[46]){
			dbc.setString(k, dbocarautohomeprop.getP43());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[47]){
			dbc.setString(k, dbocarautohomeprop.getP44());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[48]){
			dbc.setString(k, dbocarautohomeprop.getP45());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[49]){
			dbc.setString(k, dbocarautohomeprop.getP46());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[50]){
			dbc.setString(k, dbocarautohomeprop.getP47());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[51]){
			dbc.setString(k, dbocarautohomeprop.getP48());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[52]){
			dbc.setString(k, dbocarautohomeprop.getP49());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[53]){
			dbc.setString(k, dbocarautohomeprop.getP50());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[54]){
			dbc.setString(k, dbocarautohomeprop.getP51());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[55]){
			dbc.setString(k, dbocarautohomeprop.getP52());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[56]){
			dbc.setString(k, dbocarautohomeprop.getP53());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[57]){
			dbc.setString(k, dbocarautohomeprop.getP54());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[58]){
			dbc.setString(k, dbocarautohomeprop.getP55());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[59]){
			dbc.setString(k, dbocarautohomeprop.getP56());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[60]){
			dbc.setString(k, dbocarautohomeprop.getP57());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[61]){
			dbc.setString(k, dbocarautohomeprop.getP58());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[62]){
			dbc.setString(k, dbocarautohomeprop.getP59());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[63]){
			dbc.setString(k, dbocarautohomeprop.getP60());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[64]){
			dbc.setString(k, dbocarautohomeprop.getP61());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[65]){
			dbc.setString(k, dbocarautohomeprop.getP62());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[66]){
			dbc.setString(k, dbocarautohomeprop.getP63());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[67]){
			dbc.setString(k, dbocarautohomeprop.getP64());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[68]){
			dbc.setString(k, dbocarautohomeprop.getP65());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[69]){
			dbc.setString(k, dbocarautohomeprop.getP66());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[70]){
			dbc.setString(k, dbocarautohomeprop.getP67());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[71]){
			dbc.setString(k, dbocarautohomeprop.getP68());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[72]){
			dbc.setString(k, dbocarautohomeprop.getP69());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[73]){
			dbc.setString(k, dbocarautohomeprop.getP70());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[74]){
			dbc.setString(k, dbocarautohomeprop.getP71());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[75]){
			dbc.setString(k, dbocarautohomeprop.getP72());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[76]){
			dbc.setString(k, dbocarautohomeprop.getP73());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[77]){
			dbc.setString(k, dbocarautohomeprop.getP74());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[78]){
			dbc.setString(k, dbocarautohomeprop.getP75());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[79]){
			dbc.setString(k, dbocarautohomeprop.getP76());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[80]){
			dbc.setString(k, dbocarautohomeprop.getP77());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[81]){
			dbc.setString(k, dbocarautohomeprop.getP78());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[82]){
			dbc.setString(k, dbocarautohomeprop.getP79());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[83]){
			dbc.setString(k, dbocarautohomeprop.getP80());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[84]){
			dbc.setString(k, dbocarautohomeprop.getP81());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[85]){
			dbc.setString(k, dbocarautohomeprop.getP82());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[86]){
			dbc.setString(k, dbocarautohomeprop.getP83());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[87]){
			dbc.setString(k, dbocarautohomeprop.getP84());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[88]){
			dbc.setString(k, dbocarautohomeprop.getP85());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[89]){
			dbc.setString(k, dbocarautohomeprop.getP86());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[90]){
			dbc.setString(k, dbocarautohomeprop.getP87());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[91]){
			dbc.setString(k, dbocarautohomeprop.getP88());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[92]){
			dbc.setString(k, dbocarautohomeprop.getP89());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[93]){
			dbc.setString(k, dbocarautohomeprop.getP90());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[94]){
			dbc.setString(k, dbocarautohomeprop.getP91());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[95]){
			dbc.setString(k, dbocarautohomeprop.getP92());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[96]){
			dbc.setString(k, dbocarautohomeprop.getP93());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[97]){
			dbc.setString(k, dbocarautohomeprop.getP94());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[98]){
			dbc.setString(k, dbocarautohomeprop.getP95());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[99]){
			dbc.setString(k, dbocarautohomeprop.getP96());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[100]){
			dbc.setString(k, dbocarautohomeprop.getP97());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[101]){
			dbc.setString(k, dbocarautohomeprop.getP98());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[102]){
			dbc.setString(k, dbocarautohomeprop.getP99());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[103]){
			dbc.setString(k, dbocarautohomeprop.getP100());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[104]){
			dbc.setString(k, dbocarautohomeprop.getP101());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[105]){
			dbc.setString(k, dbocarautohomeprop.getP102());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[106]){
			dbc.setString(k, dbocarautohomeprop.getP103());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[107]){
			dbc.setString(k, dbocarautohomeprop.getP104());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[108]){
			dbc.setString(k, dbocarautohomeprop.getP105());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[109]){
			dbc.setString(k, dbocarautohomeprop.getP106());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[110]){
			dbc.setString(k, dbocarautohomeprop.getP107());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[111]){
			dbc.setString(k, dbocarautohomeprop.getP108());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[112]){
			dbc.setString(k, dbocarautohomeprop.getP109());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[113]){
			dbc.setString(k, dbocarautohomeprop.getP110());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[114]){
			dbc.setString(k, dbocarautohomeprop.getP111());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[115]){
			dbc.setString(k, dbocarautohomeprop.getP112());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[116]){
			dbc.setString(k, dbocarautohomeprop.getP113());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[117]){
			dbc.setString(k, dbocarautohomeprop.getP114());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[118]){
			dbc.setString(k, dbocarautohomeprop.getP115());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[119]){
			dbc.setString(k, dbocarautohomeprop.getP116());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[120]){
			dbc.setString(k, dbocarautohomeprop.getP117());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[121]){
			dbc.setString(k, dbocarautohomeprop.getP118());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[122]){
			dbc.setString(k, dbocarautohomeprop.getP119());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[123]){
			dbc.setString(k, dbocarautohomeprop.getP120());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[124]){
			dbc.setString(k, dbocarautohomeprop.getP121());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[125]){
			dbc.setString(k, dbocarautohomeprop.getP122());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[126]){
			dbc.setString(k, dbocarautohomeprop.getP123());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[127]){
			dbc.setString(k, dbocarautohomeprop.getP124());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[128]){
			dbc.setString(k, dbocarautohomeprop.getP125());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[129]){
			dbc.setString(k, dbocarautohomeprop.getP126());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[130]){
			dbc.setString(k, dbocarautohomeprop.getP127());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[131]){
			dbc.setString(k, dbocarautohomeprop.getP128());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[132]){
			dbc.setString(k, dbocarautohomeprop.getP129());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[133]){
			dbc.setString(k, dbocarautohomeprop.getP130());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[134]){
			dbc.setString(k, dbocarautohomeprop.getP131());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[135]){
			dbc.setString(k, dbocarautohomeprop.getP132());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[136]){
			dbc.setString(k, dbocarautohomeprop.getP133());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[137]){
			dbc.setString(k, dbocarautohomeprop.getP134());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[138]){
			dbc.setString(k, dbocarautohomeprop.getP135());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[139]){
			dbc.setString(k, dbocarautohomeprop.getP136());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[140]){
			dbc.setString(k, dbocarautohomeprop.getP137());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[141]){
			dbc.setString(k, dbocarautohomeprop.getP138());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[142]){
			dbc.setString(k, dbocarautohomeprop.getP139());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[143]){
			dbc.setString(k, dbocarautohomeprop.getP140());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[144]){
			dbc.setString(k, dbocarautohomeprop.getP141());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[145]){
			dbc.setString(k, dbocarautohomeprop.getP142());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[146]){
			dbc.setString(k, dbocarautohomeprop.getP143());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[147]){
			dbc.setString(k, dbocarautohomeprop.getP144());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[148]){
			dbc.setString(k, dbocarautohomeprop.getP145());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[149]){
			dbc.setString(k, dbocarautohomeprop.getP146());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[150]){
			dbc.setString(k, dbocarautohomeprop.getP147());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[151]){
			dbc.setString(k, dbocarautohomeprop.getP148());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[152]){
			dbc.setString(k, dbocarautohomeprop.getP149());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[153]){
			dbc.setString(k, dbocarautohomeprop.getP150());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[154]){
			dbc.setString(k, dbocarautohomeprop.getP151());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[155]){
			dbc.setString(k, dbocarautohomeprop.getP152());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[156]){
			dbc.setString(k, dbocarautohomeprop.getP153());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[157]){
			dbc.setString(k, dbocarautohomeprop.getP154());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[158]){
			dbc.setString(k, dbocarautohomeprop.getP155());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[159]){
			dbc.setString(k, dbocarautohomeprop.getP156());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[160]){
			dbc.setString(k, dbocarautohomeprop.getP157());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[161]){
			dbc.setString(k, dbocarautohomeprop.getP158());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[162]){
			dbc.setString(k, dbocarautohomeprop.getP159());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[163]){
			dbc.setString(k, dbocarautohomeprop.getP160());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[164]){
			dbc.setString(k, dbocarautohomeprop.getP161());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[165]){
			dbc.setString(k, dbocarautohomeprop.getP162());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[166]){
			dbc.setString(k, dbocarautohomeprop.getP163());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[167]){
			dbc.setString(k, dbocarautohomeprop.getP164());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[168]){
			dbc.setString(k, dbocarautohomeprop.getP165());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[169]){
			dbc.setString(k, dbocarautohomeprop.getP166());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[170]){
			dbc.setString(k, dbocarautohomeprop.getP167());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[171]){
			dbc.setString(k, dbocarautohomeprop.getP168());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[172]){
			dbc.setString(k, dbocarautohomeprop.getP169());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[173]){
			dbc.setString(k, dbocarautohomeprop.getP170());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[174]){
			dbc.setString(k, dbocarautohomeprop.getP171());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[175]){
			dbc.setString(k, dbocarautohomeprop.getP172());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[176]){
			dbc.setString(k, dbocarautohomeprop.getP173());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[177]){
			dbc.setString(k, dbocarautohomeprop.getP174());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[178]){
			dbc.setString(k, dbocarautohomeprop.getP175());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[179]){
			dbc.setString(k, dbocarautohomeprop.getP176());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[180]){
			dbc.setString(k, dbocarautohomeprop.getP177());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[181]){
			dbc.setString(k, dbocarautohomeprop.getP178());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[182]){
			dbc.setString(k, dbocarautohomeprop.getP179());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[183]){
			dbc.setString(k, dbocarautohomeprop.getP180());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[184]){
			dbc.setString(k, dbocarautohomeprop.getP181());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[185]){
			dbc.setString(k, dbocarautohomeprop.getP182());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[186]){
			dbc.setString(k, dbocarautohomeprop.getP183());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[187]){
			dbc.setString(k, dbocarautohomeprop.getP184());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[188]){
			dbc.setString(k, dbocarautohomeprop.getP185());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[189]){
			dbc.setString(k, dbocarautohomeprop.getP186());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[190]){
			dbc.setString(k, dbocarautohomeprop.getP187());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[191]){
			dbc.setString(k, dbocarautohomeprop.getP188());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[192]){
			dbc.setString(k, dbocarautohomeprop.getP189());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[193]){
			dbc.setString(k, dbocarautohomeprop.getP190());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[194]){
			dbc.setString(k, dbocarautohomeprop.getP191());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[195]){
			dbc.setString(k, dbocarautohomeprop.getP192());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[196]){
			dbc.setString(k, dbocarautohomeprop.getP193());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[197]){
			dbc.setString(k, dbocarautohomeprop.getP194());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[198]){
			dbc.setString(k, dbocarautohomeprop.getP195());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[199]){
			dbc.setString(k, dbocarautohomeprop.getP196());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[200]){
			dbc.setString(k, dbocarautohomeprop.getP197());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[201]){
			dbc.setString(k, dbocarautohomeprop.getP198());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[202]){
			dbc.setString(k, dbocarautohomeprop.getP199());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[203]){
			dbc.setString(k, dbocarautohomeprop.getP200());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[204]){
			dbc.setString(k, dbocarautohomeprop.getP201());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[205]){
			dbc.setString(k, dbocarautohomeprop.getP202());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[206]){
			dbc.setString(k, dbocarautohomeprop.getP203());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[207]){
			dbc.setString(k, dbocarautohomeprop.getP204());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[208]){
			dbc.setString(k, dbocarautohomeprop.getP205());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[209]){
			dbc.setString(k, dbocarautohomeprop.getP206());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[210]){
			dbc.setString(k, dbocarautohomeprop.getP207());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[211]){
			dbc.setString(k, dbocarautohomeprop.getP208());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[212]){
			dbc.setString(k, dbocarautohomeprop.getP209());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[213]){
			dbc.setString(k, dbocarautohomeprop.getP210());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[214]){
			dbc.setString(k, dbocarautohomeprop.getP211());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[215]){
			dbc.setString(k, dbocarautohomeprop.getP212());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[216]){
			dbc.setString(k, dbocarautohomeprop.getP213());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[217]){
			dbc.setString(k, dbocarautohomeprop.getP214());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[218]){
			dbc.setString(k, dbocarautohomeprop.getP215());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[219]){
			dbc.setString(k, dbocarautohomeprop.getP216());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[220]){
			dbc.setString(k, dbocarautohomeprop.getP217());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[221]){
			dbc.setString(k, dbocarautohomeprop.getP218());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[222]){
			dbc.setString(k, dbocarautohomeprop.getP219());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[223]){
			dbc.setString(k, dbocarautohomeprop.getP220());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[224]){
			dbc.setString(k, dbocarautohomeprop.getP221());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[225]){
			dbc.setString(k, dbocarautohomeprop.getP222());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[226]){
			dbc.setString(k, dbocarautohomeprop.getP223());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[227]){
			dbc.setString(k, dbocarautohomeprop.getP224());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[228]){
			dbc.setString(k, dbocarautohomeprop.getP225());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[229]){
			dbc.setString(k, dbocarautohomeprop.getP226());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[230]){
			dbc.setString(k, dbocarautohomeprop.getP227());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[231]){
			dbc.setString(k, dbocarautohomeprop.getP228());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[232]){
			dbc.setString(k, dbocarautohomeprop.getP229());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[233]){
			dbc.setString(k, dbocarautohomeprop.getP230());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[234]){
			dbc.setString(k, dbocarautohomeprop.getP231());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[235]){
			dbc.setString(k, dbocarautohomeprop.getP232());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[236]){
			dbc.setString(k, dbocarautohomeprop.getP233());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[237]){
			dbc.setString(k, dbocarautohomeprop.getP234());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[238]){
			dbc.setString(k, dbocarautohomeprop.getP235());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[239]){
			dbc.setString(k, dbocarautohomeprop.getP236());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[240]){
			dbc.setString(k, dbocarautohomeprop.getP237());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[241]){
			dbc.setString(k, dbocarautohomeprop.getP238());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[242]){
			dbc.setString(k, dbocarautohomeprop.getP239());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[243]){
			dbc.setString(k, dbocarautohomeprop.getP240());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[244]){
			dbc.setString(k, dbocarautohomeprop.getP241());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[245]){
			dbc.setString(k, dbocarautohomeprop.getP242());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[246]){
			dbc.setString(k, dbocarautohomeprop.getP243());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[247]){
			dbc.setString(k, dbocarautohomeprop.getP244());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[248]){
			dbc.setString(k, dbocarautohomeprop.getP245());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[249]){
			dbc.setString(k, dbocarautohomeprop.getP246());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[250]){
			dbc.setString(k, dbocarautohomeprop.getP247());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[251]){
			dbc.setString(k, dbocarautohomeprop.getP248());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[252]){
			dbc.setString(k, dbocarautohomeprop.getP249());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[253]){
			dbc.setString(k, dbocarautohomeprop.getP250());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[254]){
			dbc.setString(k, dbocarautohomeprop.getP251());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[255]){
			dbc.setString(k, dbocarautohomeprop.getP252());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[256]){
			dbc.setString(k, dbocarautohomeprop.getP253());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[257]){
			dbc.setString(k, dbocarautohomeprop.getP254());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[258]){
			dbc.setString(k, dbocarautohomeprop.getP255());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[259]){
			dbc.setString(k, dbocarautohomeprop.getP256());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[260]){
			dbc.setString(k, dbocarautohomeprop.getP257());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[261]){
			dbc.setString(k, dbocarautohomeprop.getP258());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[262]){
			dbc.setString(k, dbocarautohomeprop.getP259());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[263]){
			dbc.setString(k, dbocarautohomeprop.getP260());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[264]){
			dbc.setString(k, dbocarautohomeprop.getP261());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[265]){
			dbc.setString(k, dbocarautohomeprop.getP262());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[266]){
			dbc.setString(k, dbocarautohomeprop.getP263());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[267]){
			dbc.setString(k, dbocarautohomeprop.getP264());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[268]){
			dbc.setString(k, dbocarautohomeprop.getP265());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[269]){
			dbc.setString(k, dbocarautohomeprop.getP266());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[270]){
			dbc.setString(k, dbocarautohomeprop.getP267());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[271]){
			dbc.setString(k, dbocarautohomeprop.getP268());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[272]){
			dbc.setString(k, dbocarautohomeprop.getP269());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[273]){
			dbc.setString(k, dbocarautohomeprop.getP270());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[274]){
			dbc.setString(k, dbocarautohomeprop.getP271());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[275]){
			dbc.setString(k, dbocarautohomeprop.getP272());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[276]){
			dbc.setString(k, dbocarautohomeprop.getP273());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[277]){
			dbc.setString(k, dbocarautohomeprop.getP274());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[278]){
			dbc.setString(k, dbocarautohomeprop.getP275());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[279]){
			dbc.setString(k, dbocarautohomeprop.getP276());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[280]){
			dbc.setString(k, dbocarautohomeprop.getP277());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[281]){
			dbc.setString(k, dbocarautohomeprop.getP278());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[282]){
			dbc.setString(k, dbocarautohomeprop.getP279());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[283]){
			dbc.setString(k, dbocarautohomeprop.getP280());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[284]){
			dbc.setString(k, dbocarautohomeprop.getP281());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[285]){
			dbc.setString(k, dbocarautohomeprop.getP282());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[286]){
			dbc.setString(k, dbocarautohomeprop.getP283());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[287]){
			dbc.setString(k, dbocarautohomeprop.getP284());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[288]){
			dbc.setString(k, dbocarautohomeprop.getP285());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[289]){
			dbc.setString(k, dbocarautohomeprop.getP286());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[290]){
			dbc.setString(k, dbocarautohomeprop.getP287());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[291]){
			dbc.setString(k, dbocarautohomeprop.getP288());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[292]){
			dbc.setString(k, dbocarautohomeprop.getP289());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[293]){
			dbc.setString(k, dbocarautohomeprop.getP290());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[294]){
			dbc.setString(k, dbocarautohomeprop.getP291());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[295]){
			dbc.setString(k, dbocarautohomeprop.getP292());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[296]){
			dbc.setString(k, dbocarautohomeprop.getP293());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[297]){
			dbc.setString(k, dbocarautohomeprop.getP294());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[298]){
			dbc.setString(k, dbocarautohomeprop.getP295());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[299]){
			dbc.setString(k, dbocarautohomeprop.getP296());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[300]){
			dbc.setString(k, dbocarautohomeprop.getP297());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[301]){
			dbc.setString(k, dbocarautohomeprop.getP298());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[302]){
			dbc.setString(k, dbocarautohomeprop.getP299());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[303]){
			dbc.setString(k, dbocarautohomeprop.getP300());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[304]){
			dbc.setInt(k, dbocarautohomeprop.getIsupdate());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[305]){
			dbc.setString(k, dbocarautohomeprop.getIway());k++;
		}
		if(dbocarautohomeprop.COLUMN_FLAG[306]){
			dbc.setInt(k, dbocarautohomeprop.getCar_type());k++;
		}
		dbc.setInt(k, dbocarautohomeprop.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboCarAutohomeprop dbocarautohomeprop) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbocarautohomeprop);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}