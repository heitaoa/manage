package car_beans;
import java.util.*;

public class  DboCarAutohomeprop  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int carid;//
	private int autohomecarid;//
	private int bid;//
	private String p1;//车型名称
	private String p2;//厂商指导价(元)
	private String p3;//品牌
	private String p4;//级别
	private String p5;//发动机
	private String p6;//变速箱
	private String p7;//长×宽×高(mm)
	private String p8;//车体结构
	private String p9;//最高车速(km/h)
	private String p10;//官方0-100km/h加速(s)
	private String p11;//官方100-0制动(m)
	private String p12;//官方综合路况油耗(l)
	private String p13;//实测0-100km/h加速(s)
	private String p14;//实测100-0km/h制动(m)
	private String p15;//实测油耗(l)
	private String p16;//整车质保
	private String p17;//长度(mm)
	private String p18;//宽度(mm)
	private String p19;//高度(mm)
	private String p20;//轴距(mm)
	private String p21;//前轮距(mm)
	private String p22;//后轮距(mm)
	private String p23;//最小离地间隙(mm)
	private String p24;//整备质量(kg)
	private String p25;//车身结构
	private String p26;//车门数(个)
	private String p27;//座位数(个)
	private String p28;//油箱容积(l)
	private String p29;//行李厢容积(l)
	private String p30;//排量(ml)
	private String p31;//排量级别
	private String p32;//进气形式
	private String p33;//气缸排列形式
	private String p34;//气缸数(个)
	private String p35;//每缸气门数(个)
	private String p36;//压缩比
	private String p37;//配气机构
	private String p38;//缸径
	private String p39;//行程
	private String p40;//最大马力(ps)
	private String p41;//最大功率(kw)
	private String p42;//最大功率转速(rpm)
	private String p43;//最大扭矩(n·m)
	private String p44;//最大扭矩转速(rpm)
	private String p45;//发动机特有技术
	private String p46;//燃料形式
	private String p47;//燃油标号
	private String p48;//供油方式
	private String p49;//缸盖材料
	private String p50;//缸体材料
	private String p51;//环保标准
	private String p52;//简称
	private String p53;//挡位个数
	private String p54;//变速箱类型
	private String p55;//驱动方式
	private String p56;//前悬架类型
	private String p57;//后悬架类型
	private String p58;//助力类型
	private String p59;//地盘结构
	private String p60;//前制动器类型
	private String p61;//后制动器类型
	private String p62;//驻车制动类型
	private String p63;//前轮胎规格
	private String p64;//后轮胎规格
	private String p65;//备胎规格
	private String p66;//驾驶座安全气囊
	private String p67;//副驾驶安全气囊
	private String p68;//前排侧气囊
	private String p69;//后排侧气囊
	private String p70;//前排头部气囊(气帘)
	private String p71;//后排头部气囊(气帘)
	private String p72;//膝部气囊
	private String p73;//安全带未系提示
	private String p74;//发动机电子防盗
	private String p75;//车内中控锁
	private String p76;//遥控钥匙
	private String p77;//无钥匙启动系统
	private String p78;//abs防抱死
	private String p79;//制动力分配(ebd/cbc等)
	private String p80;//刹车辅助(eba/bas/ba等)
	private String p81;//牵引力控制(asr/tcs/trc等)
	private String p82;//车身稳定控制(esc/esp/dsc等)
	private String p83;//自动驻车/上坡辅助
	private String p84;//陡坡缓降
	private String p85;//可变悬架
	private String p86;//空气悬架
	private String p87;//胎压监测装置
	private String p88;//零胎压继续行驶
	private String p89;//可变转向比
	private String p90;//电动天窗
	private String p91;//全景天窗
	private String p92;//同色后视镜
	private String p93;//同色防擦条
	private String p94;//运动外观套件
	private String p95;//铝合金轮毂
	private String p96;//真皮方向盘
	private String p97;//方向盘上下调节
	private String p98;//方向盘前后调节
	private String p99;//多功能方向盘
	private String p100;//方向盘换挡
	private String p101;//定速巡航
	private String p102;//泊车辅助
	private String p103;//倒车视频影像
	private String p104;//行车电脑显示屏
	private String p105;//hud抬头数字显示
	private String p106;//左脚休息踏板
	private String p107;//真皮/仿皮座椅
	private String p108;//运动风格座椅
	private String p109;//座椅高低调节
	private String p110;//腰部支撑调节
	private String p111;//前排座椅电动调节
	private String p112;//后排座椅手动调节
	private String p113;//后排座椅电动调节
	private String p114;//电动座椅记忆
	private String p115;//前排座椅加热
	private String p116;//后排座椅加热
	private String p117;//座椅通风
	private String p118;//座椅按摩
	private String p119;//后排座椅整体放倒
	private String p120;//后排座椅比例放倒
	private String p121;//第三排座椅
	private String p122;//前座中央扶手
	private String p123;//后座中央扶手
	private String p124;//前排杯架
	private String p125;//后排杯架
	private String p126;//电动后备厢
	private String p127;//gps导航系统
	private String p128;//中控台彩色大屏
	private String p129;//人机交互系统
	private String p130;//内置硬盘
	private String p131;//蓝牙系统
	private String p132;//车载电视
	private String p133;//车载电话
	private String p134;//后排液晶屏
	private String p135;//外接音源接口(aux/usb/ipod等)
	private String p136;//cd支持mp3/wma
	private String p137;//单碟cd
	private String p138;//多碟cd系统
	private String p139;//单碟dvd
	private String p140;//多碟dvd系统
	private String p141;//2-3喇叭扬声器系统
	private String p142;//4-5喇叭扬声器系统
	private String p143;//6-7喇叭扬声器系统
	private String p144;//≥8喇叭扬声器系统
	private String p145;//氙气大灯
	private String p146;//日间行车灯
	private String p147;//自动头灯
	private String p148;//转向头灯(辅助灯)
	private String p149;//前雾灯
	private String p150;//后雾灯
	private String p151;//大灯高度可调
	private String p152;//大灯清洗装置
	private String p153;//前电动车窗
	private String p154;//后电动车窗
	private String p155;//车窗防夹手功能
	private String p156;//后视镜电动调节
	private String p157;//后视镜加热
	private String p158;//内/外后视镜自动防眩目
	private String p159;//后视镜电动折叠
	private String p160;//后风挡遮阳帘
	private String p161;//后排侧遮阳帘
	private String p162;//遮阳板化妆镜
	private String p163;//感应雨刷
	private String p164;//手动空调
	private String p165;//自动空调
	private String p166;//后排独立空调
	private String p167;//后座出风口
	private String p168;//温度分区控制
	private String p169;//空气调节/花粉过滤
	private String p170;//车载冰箱
	private String p171;//自动泊车入位
	private String p172;//并线辅助
	private String p173;//夜视系统
	private String p174;//自适应巡航
	private String p175;//全景摄像头
	private String p176;//旧排量级别
	private String p177;//生产年份
	private String p178;//添加日期
	private String p179;//更新日期
	private String p180;//电动吸合门
	private String p181;//方向盘电动调节
	private String p182;//肩部支撑调节
	private String p183;//定位互动服务
	private String p184;//蓝牙/车载电话
	private String p185;//虚拟多碟cd
	private String p186;//车内氛围灯
	private String p187;//防紫外线/隔热玻璃
	private String p188;//后雨刷
	private String p189;//主动刹车/主动安全系统
	private String p190;//整体主动转向系统
	private String p191;//中控液晶屏分屏显示
	private String p192;//厂商
	private String p193;//工信部综合油耗(l)
	private String p194;//发动机型号
	private String p195;//第二排靠背角度调节
	private String p196;//第二排座椅移动
	private String p197;//后视镜记忆
	private String p198;//iso fix儿童座椅接口
	private String p199;//latch儿童座椅接口
	private String p200;//车身颜色
	private String p201;//
	private String p202;//
	private String p203;//
	private String p204;//
	private String p205;//
	private String p206;//
	private String p207;//
	private String p208;//
	private String p209;//
	private String p210;//
	private String p211;//
	private String p212;//
	private String p213;//
	private String p214;//
	private String p215;//
	private String p216;//
	private String p217;//
	private String p218;//
	private String p219;//
	private String p220;//
	private String p221;//
	private String p222;//
	private String p223;//
	private String p224;//
	private String p225;//
	private String p226;//
	private String p227;//
	private String p228;//
	private String p229;//
	private String p230;//
	private String p231;//
	private String p232;//
	private String p233;//
	private String p234;//
	private String p235;//
	private String p236;//
	private String p237;//
	private String p238;//
	private String p239;//
	private String p240;//
	private String p241;//
	private String p242;//
	private String p243;//
	private String p244;//
	private String p245;//
	private String p246;//
	private String p247;//
	private String p248;//
	private String p249;//
	private String p250;//
	private String p251;//
	private String p252;//
	private String p253;//
	private String p254;//
	private String p255;//
	private String p256;//
	private String p257;//
	private String p258;//
	private String p259;//
	private String p260;//
	private String p261;//
	private String p262;//
	private String p263;//
	private String p264;//
	private String p265;//
	private String p266;//
	private String p267;//
	private String p268;//
	private String p269;//
	private String p270;//
	private String p271;//
	private String p272;//
	private String p273;//
	private String p274;//
	private String p275;//
	private String p276;//
	private String p277;//
	private String p278;//
	private String p279;//
	private String p280;//
	private String p281;//
	private String p282;//
	private String p283;//
	private String p284;//
	private String p285;//
	private String p286;//
	private String p287;//
	private String p288;//
	private String p289;//
	private String p290;//
	private String p291;//
	private String p292;//
	private String p293;//
	private String p294;//
	private String p295;//
	private String p296;//
	private String p297;//
	private String p298;//
	private String p299;//
	private String p300;//
	private int isupdate;//
	private String iway;//渠道
	private int car_type;//车型分类 1普通车型，2面包车型等，3油电混动车型，4纯电动车型


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCarid(int carid)
	{
		this.carid=carid;
		COLUMN_FLAG[1] = true;
	}
	public int getCarid()
	{
		return carid;
	}
	public void setAutohomecarid(int autohomecarid)
	{
		this.autohomecarid=autohomecarid;
		COLUMN_FLAG[2] = true;
	}
	public int getAutohomecarid()
	{
		return autohomecarid;
	}
	public void setBid(int bid)
	{
		this.bid=bid;
		COLUMN_FLAG[3] = true;
	}
	public int getBid()
	{
		return bid;
	}
	public void setP1(String p1)
	{
		this.p1=p1;
		COLUMN_FLAG[4] = true;
	}
	public String getP1()
	{
		return p1;
	}
	public void setP2(String p2)
	{
		this.p2=p2;
		COLUMN_FLAG[5] = true;
	}
	public String getP2()
	{
		return p2;
	}
	public void setP3(String p3)
	{
		this.p3=p3;
		COLUMN_FLAG[6] = true;
	}
	public String getP3()
	{
		return p3;
	}
	public void setP4(String p4)
	{
		this.p4=p4;
		COLUMN_FLAG[7] = true;
	}
	public String getP4()
	{
		return p4;
	}
	public void setP5(String p5)
	{
		this.p5=p5;
		COLUMN_FLAG[8] = true;
	}
	public String getP5()
	{
		return p5;
	}
	public void setP6(String p6)
	{
		this.p6=p6;
		COLUMN_FLAG[9] = true;
	}
	public String getP6()
	{
		return p6;
	}
	public void setP7(String p7)
	{
		this.p7=p7;
		COLUMN_FLAG[10] = true;
	}
	public String getP7()
	{
		return p7;
	}
	public void setP8(String p8)
	{
		this.p8=p8;
		COLUMN_FLAG[11] = true;
	}
	public String getP8()
	{
		return p8;
	}
	public void setP9(String p9)
	{
		this.p9=p9;
		COLUMN_FLAG[12] = true;
	}
	public String getP9()
	{
		return p9;
	}
	public void setP10(String p10)
	{
		this.p10=p10;
		COLUMN_FLAG[13] = true;
	}
	public String getP10()
	{
		return p10;
	}
	public void setP11(String p11)
	{
		this.p11=p11;
		COLUMN_FLAG[14] = true;
	}
	public String getP11()
	{
		return p11;
	}
	public void setP12(String p12)
	{
		this.p12=p12;
		COLUMN_FLAG[15] = true;
	}
	public String getP12()
	{
		return p12;
	}
	public void setP13(String p13)
	{
		this.p13=p13;
		COLUMN_FLAG[16] = true;
	}
	public String getP13()
	{
		return p13;
	}
	public void setP14(String p14)
	{
		this.p14=p14;
		COLUMN_FLAG[17] = true;
	}
	public String getP14()
	{
		return p14;
	}
	public void setP15(String p15)
	{
		this.p15=p15;
		COLUMN_FLAG[18] = true;
	}
	public String getP15()
	{
		return p15;
	}
	public void setP16(String p16)
	{
		this.p16=p16;
		COLUMN_FLAG[19] = true;
	}
	public String getP16()
	{
		return p16;
	}
	public void setP17(String p17)
	{
		this.p17=p17;
		COLUMN_FLAG[20] = true;
	}
	public String getP17()
	{
		return p17;
	}
	public void setP18(String p18)
	{
		this.p18=p18;
		COLUMN_FLAG[21] = true;
	}
	public String getP18()
	{
		return p18;
	}
	public void setP19(String p19)
	{
		this.p19=p19;
		COLUMN_FLAG[22] = true;
	}
	public String getP19()
	{
		return p19;
	}
	public void setP20(String p20)
	{
		this.p20=p20;
		COLUMN_FLAG[23] = true;
	}
	public String getP20()
	{
		return p20;
	}
	public void setP21(String p21)
	{
		this.p21=p21;
		COLUMN_FLAG[24] = true;
	}
	public String getP21()
	{
		return p21;
	}
	public void setP22(String p22)
	{
		this.p22=p22;
		COLUMN_FLAG[25] = true;
	}
	public String getP22()
	{
		return p22;
	}
	public void setP23(String p23)
	{
		this.p23=p23;
		COLUMN_FLAG[26] = true;
	}
	public String getP23()
	{
		return p23;
	}
	public void setP24(String p24)
	{
		this.p24=p24;
		COLUMN_FLAG[27] = true;
	}
	public String getP24()
	{
		return p24;
	}
	public void setP25(String p25)
	{
		this.p25=p25;
		COLUMN_FLAG[28] = true;
	}
	public String getP25()
	{
		return p25;
	}
	public void setP26(String p26)
	{
		this.p26=p26;
		COLUMN_FLAG[29] = true;
	}
	public String getP26()
	{
		return p26;
	}
	public void setP27(String p27)
	{
		this.p27=p27;
		COLUMN_FLAG[30] = true;
	}
	public String getP27()
	{
		return p27;
	}
	public void setP28(String p28)
	{
		this.p28=p28;
		COLUMN_FLAG[31] = true;
	}
	public String getP28()
	{
		return p28;
	}
	public void setP29(String p29)
	{
		this.p29=p29;
		COLUMN_FLAG[32] = true;
	}
	public String getP29()
	{
		return p29;
	}
	public void setP30(String p30)
	{
		this.p30=p30;
		COLUMN_FLAG[33] = true;
	}
	public String getP30()
	{
		return p30;
	}
	public void setP31(String p31)
	{
		this.p31=p31;
		COLUMN_FLAG[34] = true;
	}
	public String getP31()
	{
		return p31;
	}
	public void setP32(String p32)
	{
		this.p32=p32;
		COLUMN_FLAG[35] = true;
	}
	public String getP32()
	{
		return p32;
	}
	public void setP33(String p33)
	{
		this.p33=p33;
		COLUMN_FLAG[36] = true;
	}
	public String getP33()
	{
		return p33;
	}
	public void setP34(String p34)
	{
		this.p34=p34;
		COLUMN_FLAG[37] = true;
	}
	public String getP34()
	{
		return p34;
	}
	public void setP35(String p35)
	{
		this.p35=p35;
		COLUMN_FLAG[38] = true;
	}
	public String getP35()
	{
		return p35;
	}
	public void setP36(String p36)
	{
		this.p36=p36;
		COLUMN_FLAG[39] = true;
	}
	public String getP36()
	{
		return p36;
	}
	public void setP37(String p37)
	{
		this.p37=p37;
		COLUMN_FLAG[40] = true;
	}
	public String getP37()
	{
		return p37;
	}
	public void setP38(String p38)
	{
		this.p38=p38;
		COLUMN_FLAG[41] = true;
	}
	public String getP38()
	{
		return p38;
	}
	public void setP39(String p39)
	{
		this.p39=p39;
		COLUMN_FLAG[42] = true;
	}
	public String getP39()
	{
		return p39;
	}
	public void setP40(String p40)
	{
		this.p40=p40;
		COLUMN_FLAG[43] = true;
	}
	public String getP40()
	{
		return p40;
	}
	public void setP41(String p41)
	{
		this.p41=p41;
		COLUMN_FLAG[44] = true;
	}
	public String getP41()
	{
		return p41;
	}
	public void setP42(String p42)
	{
		this.p42=p42;
		COLUMN_FLAG[45] = true;
	}
	public String getP42()
	{
		return p42;
	}
	public void setP43(String p43)
	{
		this.p43=p43;
		COLUMN_FLAG[46] = true;
	}
	public String getP43()
	{
		return p43;
	}
	public void setP44(String p44)
	{
		this.p44=p44;
		COLUMN_FLAG[47] = true;
	}
	public String getP44()
	{
		return p44;
	}
	public void setP45(String p45)
	{
		this.p45=p45;
		COLUMN_FLAG[48] = true;
	}
	public String getP45()
	{
		return p45;
	}
	public void setP46(String p46)
	{
		this.p46=p46;
		COLUMN_FLAG[49] = true;
	}
	public String getP46()
	{
		return p46;
	}
	public void setP47(String p47)
	{
		this.p47=p47;
		COLUMN_FLAG[50] = true;
	}
	public String getP47()
	{
		return p47;
	}
	public void setP48(String p48)
	{
		this.p48=p48;
		COLUMN_FLAG[51] = true;
	}
	public String getP48()
	{
		return p48;
	}
	public void setP49(String p49)
	{
		this.p49=p49;
		COLUMN_FLAG[52] = true;
	}
	public String getP49()
	{
		return p49;
	}
	public void setP50(String p50)
	{
		this.p50=p50;
		COLUMN_FLAG[53] = true;
	}
	public String getP50()
	{
		return p50;
	}
	public void setP51(String p51)
	{
		this.p51=p51;
		COLUMN_FLAG[54] = true;
	}
	public String getP51()
	{
		return p51;
	}
	public void setP52(String p52)
	{
		this.p52=p52;
		COLUMN_FLAG[55] = true;
	}
	public String getP52()
	{
		return p52;
	}
	public void setP53(String p53)
	{
		this.p53=p53;
		COLUMN_FLAG[56] = true;
	}
	public String getP53()
	{
		return p53;
	}
	public void setP54(String p54)
	{
		this.p54=p54;
		COLUMN_FLAG[57] = true;
	}
	public String getP54()
	{
		return p54;
	}
	public void setP55(String p55)
	{
		this.p55=p55;
		COLUMN_FLAG[58] = true;
	}
	public String getP55()
	{
		return p55;
	}
	public void setP56(String p56)
	{
		this.p56=p56;
		COLUMN_FLAG[59] = true;
	}
	public String getP56()
	{
		return p56;
	}
	public void setP57(String p57)
	{
		this.p57=p57;
		COLUMN_FLAG[60] = true;
	}
	public String getP57()
	{
		return p57;
	}
	public void setP58(String p58)
	{
		this.p58=p58;
		COLUMN_FLAG[61] = true;
	}
	public String getP58()
	{
		return p58;
	}
	public void setP59(String p59)
	{
		this.p59=p59;
		COLUMN_FLAG[62] = true;
	}
	public String getP59()
	{
		return p59;
	}
	public void setP60(String p60)
	{
		this.p60=p60;
		COLUMN_FLAG[63] = true;
	}
	public String getP60()
	{
		return p60;
	}
	public void setP61(String p61)
	{
		this.p61=p61;
		COLUMN_FLAG[64] = true;
	}
	public String getP61()
	{
		return p61;
	}
	public void setP62(String p62)
	{
		this.p62=p62;
		COLUMN_FLAG[65] = true;
	}
	public String getP62()
	{
		return p62;
	}
	public void setP63(String p63)
	{
		this.p63=p63;
		COLUMN_FLAG[66] = true;
	}
	public String getP63()
	{
		return p63;
	}
	public void setP64(String p64)
	{
		this.p64=p64;
		COLUMN_FLAG[67] = true;
	}
	public String getP64()
	{
		return p64;
	}
	public void setP65(String p65)
	{
		this.p65=p65;
		COLUMN_FLAG[68] = true;
	}
	public String getP65()
	{
		return p65;
	}
	public void setP66(String p66)
	{
		this.p66=p66;
		COLUMN_FLAG[69] = true;
	}
	public String getP66()
	{
		return p66;
	}
	public void setP67(String p67)
	{
		this.p67=p67;
		COLUMN_FLAG[70] = true;
	}
	public String getP67()
	{
		return p67;
	}
	public void setP68(String p68)
	{
		this.p68=p68;
		COLUMN_FLAG[71] = true;
	}
	public String getP68()
	{
		return p68;
	}
	public void setP69(String p69)
	{
		this.p69=p69;
		COLUMN_FLAG[72] = true;
	}
	public String getP69()
	{
		return p69;
	}
	public void setP70(String p70)
	{
		this.p70=p70;
		COLUMN_FLAG[73] = true;
	}
	public String getP70()
	{
		return p70;
	}
	public void setP71(String p71)
	{
		this.p71=p71;
		COLUMN_FLAG[74] = true;
	}
	public String getP71()
	{
		return p71;
	}
	public void setP72(String p72)
	{
		this.p72=p72;
		COLUMN_FLAG[75] = true;
	}
	public String getP72()
	{
		return p72;
	}
	public void setP73(String p73)
	{
		this.p73=p73;
		COLUMN_FLAG[76] = true;
	}
	public String getP73()
	{
		return p73;
	}
	public void setP74(String p74)
	{
		this.p74=p74;
		COLUMN_FLAG[77] = true;
	}
	public String getP74()
	{
		return p74;
	}
	public void setP75(String p75)
	{
		this.p75=p75;
		COLUMN_FLAG[78] = true;
	}
	public String getP75()
	{
		return p75;
	}
	public void setP76(String p76)
	{
		this.p76=p76;
		COLUMN_FLAG[79] = true;
	}
	public String getP76()
	{
		return p76;
	}
	public void setP77(String p77)
	{
		this.p77=p77;
		COLUMN_FLAG[80] = true;
	}
	public String getP77()
	{
		return p77;
	}
	public void setP78(String p78)
	{
		this.p78=p78;
		COLUMN_FLAG[81] = true;
	}
	public String getP78()
	{
		return p78;
	}
	public void setP79(String p79)
	{
		this.p79=p79;
		COLUMN_FLAG[82] = true;
	}
	public String getP79()
	{
		return p79;
	}
	public void setP80(String p80)
	{
		this.p80=p80;
		COLUMN_FLAG[83] = true;
	}
	public String getP80()
	{
		return p80;
	}
	public void setP81(String p81)
	{
		this.p81=p81;
		COLUMN_FLAG[84] = true;
	}
	public String getP81()
	{
		return p81;
	}
	public void setP82(String p82)
	{
		this.p82=p82;
		COLUMN_FLAG[85] = true;
	}
	public String getP82()
	{
		return p82;
	}
	public void setP83(String p83)
	{
		this.p83=p83;
		COLUMN_FLAG[86] = true;
	}
	public String getP83()
	{
		return p83;
	}
	public void setP84(String p84)
	{
		this.p84=p84;
		COLUMN_FLAG[87] = true;
	}
	public String getP84()
	{
		return p84;
	}
	public void setP85(String p85)
	{
		this.p85=p85;
		COLUMN_FLAG[88] = true;
	}
	public String getP85()
	{
		return p85;
	}
	public void setP86(String p86)
	{
		this.p86=p86;
		COLUMN_FLAG[89] = true;
	}
	public String getP86()
	{
		return p86;
	}
	public void setP87(String p87)
	{
		this.p87=p87;
		COLUMN_FLAG[90] = true;
	}
	public String getP87()
	{
		return p87;
	}
	public void setP88(String p88)
	{
		this.p88=p88;
		COLUMN_FLAG[91] = true;
	}
	public String getP88()
	{
		return p88;
	}
	public void setP89(String p89)
	{
		this.p89=p89;
		COLUMN_FLAG[92] = true;
	}
	public String getP89()
	{
		return p89;
	}
	public void setP90(String p90)
	{
		this.p90=p90;
		COLUMN_FLAG[93] = true;
	}
	public String getP90()
	{
		return p90;
	}
	public void setP91(String p91)
	{
		this.p91=p91;
		COLUMN_FLAG[94] = true;
	}
	public String getP91()
	{
		return p91;
	}
	public void setP92(String p92)
	{
		this.p92=p92;
		COLUMN_FLAG[95] = true;
	}
	public String getP92()
	{
		return p92;
	}
	public void setP93(String p93)
	{
		this.p93=p93;
		COLUMN_FLAG[96] = true;
	}
	public String getP93()
	{
		return p93;
	}
	public void setP94(String p94)
	{
		this.p94=p94;
		COLUMN_FLAG[97] = true;
	}
	public String getP94()
	{
		return p94;
	}
	public void setP95(String p95)
	{
		this.p95=p95;
		COLUMN_FLAG[98] = true;
	}
	public String getP95()
	{
		return p95;
	}
	public void setP96(String p96)
	{
		this.p96=p96;
		COLUMN_FLAG[99] = true;
	}
	public String getP96()
	{
		return p96;
	}
	public void setP97(String p97)
	{
		this.p97=p97;
		COLUMN_FLAG[100] = true;
	}
	public String getP97()
	{
		return p97;
	}
	public void setP98(String p98)
	{
		this.p98=p98;
		COLUMN_FLAG[101] = true;
	}
	public String getP98()
	{
		return p98;
	}
	public void setP99(String p99)
	{
		this.p99=p99;
		COLUMN_FLAG[102] = true;
	}
	public String getP99()
	{
		return p99;
	}
	public void setP100(String p100)
	{
		this.p100=p100;
		COLUMN_FLAG[103] = true;
	}
	public String getP100()
	{
		return p100;
	}
	public void setP101(String p101)
	{
		this.p101=p101;
		COLUMN_FLAG[104] = true;
	}
	public String getP101()
	{
		return p101;
	}
	public void setP102(String p102)
	{
		this.p102=p102;
		COLUMN_FLAG[105] = true;
	}
	public String getP102()
	{
		return p102;
	}
	public void setP103(String p103)
	{
		this.p103=p103;
		COLUMN_FLAG[106] = true;
	}
	public String getP103()
	{
		return p103;
	}
	public void setP104(String p104)
	{
		this.p104=p104;
		COLUMN_FLAG[107] = true;
	}
	public String getP104()
	{
		return p104;
	}
	public void setP105(String p105)
	{
		this.p105=p105;
		COLUMN_FLAG[108] = true;
	}
	public String getP105()
	{
		return p105;
	}
	public void setP106(String p106)
	{
		this.p106=p106;
		COLUMN_FLAG[109] = true;
	}
	public String getP106()
	{
		return p106;
	}
	public void setP107(String p107)
	{
		this.p107=p107;
		COLUMN_FLAG[110] = true;
	}
	public String getP107()
	{
		return p107;
	}
	public void setP108(String p108)
	{
		this.p108=p108;
		COLUMN_FLAG[111] = true;
	}
	public String getP108()
	{
		return p108;
	}
	public void setP109(String p109)
	{
		this.p109=p109;
		COLUMN_FLAG[112] = true;
	}
	public String getP109()
	{
		return p109;
	}
	public void setP110(String p110)
	{
		this.p110=p110;
		COLUMN_FLAG[113] = true;
	}
	public String getP110()
	{
		return p110;
	}
	public void setP111(String p111)
	{
		this.p111=p111;
		COLUMN_FLAG[114] = true;
	}
	public String getP111()
	{
		return p111;
	}
	public void setP112(String p112)
	{
		this.p112=p112;
		COLUMN_FLAG[115] = true;
	}
	public String getP112()
	{
		return p112;
	}
	public void setP113(String p113)
	{
		this.p113=p113;
		COLUMN_FLAG[116] = true;
	}
	public String getP113()
	{
		return p113;
	}
	public void setP114(String p114)
	{
		this.p114=p114;
		COLUMN_FLAG[117] = true;
	}
	public String getP114()
	{
		return p114;
	}
	public void setP115(String p115)
	{
		this.p115=p115;
		COLUMN_FLAG[118] = true;
	}
	public String getP115()
	{
		return p115;
	}
	public void setP116(String p116)
	{
		this.p116=p116;
		COLUMN_FLAG[119] = true;
	}
	public String getP116()
	{
		return p116;
	}
	public void setP117(String p117)
	{
		this.p117=p117;
		COLUMN_FLAG[120] = true;
	}
	public String getP117()
	{
		return p117;
	}
	public void setP118(String p118)
	{
		this.p118=p118;
		COLUMN_FLAG[121] = true;
	}
	public String getP118()
	{
		return p118;
	}
	public void setP119(String p119)
	{
		this.p119=p119;
		COLUMN_FLAG[122] = true;
	}
	public String getP119()
	{
		return p119;
	}
	public void setP120(String p120)
	{
		this.p120=p120;
		COLUMN_FLAG[123] = true;
	}
	public String getP120()
	{
		return p120;
	}
	public void setP121(String p121)
	{
		this.p121=p121;
		COLUMN_FLAG[124] = true;
	}
	public String getP121()
	{
		return p121;
	}
	public void setP122(String p122)
	{
		this.p122=p122;
		COLUMN_FLAG[125] = true;
	}
	public String getP122()
	{
		return p122;
	}
	public void setP123(String p123)
	{
		this.p123=p123;
		COLUMN_FLAG[126] = true;
	}
	public String getP123()
	{
		return p123;
	}
	public void setP124(String p124)
	{
		this.p124=p124;
		COLUMN_FLAG[127] = true;
	}
	public String getP124()
	{
		return p124;
	}
	public void setP125(String p125)
	{
		this.p125=p125;
		COLUMN_FLAG[128] = true;
	}
	public String getP125()
	{
		return p125;
	}
	public void setP126(String p126)
	{
		this.p126=p126;
		COLUMN_FLAG[129] = true;
	}
	public String getP126()
	{
		return p126;
	}
	public void setP127(String p127)
	{
		this.p127=p127;
		COLUMN_FLAG[130] = true;
	}
	public String getP127()
	{
		return p127;
	}
	public void setP128(String p128)
	{
		this.p128=p128;
		COLUMN_FLAG[131] = true;
	}
	public String getP128()
	{
		return p128;
	}
	public void setP129(String p129)
	{
		this.p129=p129;
		COLUMN_FLAG[132] = true;
	}
	public String getP129()
	{
		return p129;
	}
	public void setP130(String p130)
	{
		this.p130=p130;
		COLUMN_FLAG[133] = true;
	}
	public String getP130()
	{
		return p130;
	}
	public void setP131(String p131)
	{
		this.p131=p131;
		COLUMN_FLAG[134] = true;
	}
	public String getP131()
	{
		return p131;
	}
	public void setP132(String p132)
	{
		this.p132=p132;
		COLUMN_FLAG[135] = true;
	}
	public String getP132()
	{
		return p132;
	}
	public void setP133(String p133)
	{
		this.p133=p133;
		COLUMN_FLAG[136] = true;
	}
	public String getP133()
	{
		return p133;
	}
	public void setP134(String p134)
	{
		this.p134=p134;
		COLUMN_FLAG[137] = true;
	}
	public String getP134()
	{
		return p134;
	}
	public void setP135(String p135)
	{
		this.p135=p135;
		COLUMN_FLAG[138] = true;
	}
	public String getP135()
	{
		return p135;
	}
	public void setP136(String p136)
	{
		this.p136=p136;
		COLUMN_FLAG[139] = true;
	}
	public String getP136()
	{
		return p136;
	}
	public void setP137(String p137)
	{
		this.p137=p137;
		COLUMN_FLAG[140] = true;
	}
	public String getP137()
	{
		return p137;
	}
	public void setP138(String p138)
	{
		this.p138=p138;
		COLUMN_FLAG[141] = true;
	}
	public String getP138()
	{
		return p138;
	}
	public void setP139(String p139)
	{
		this.p139=p139;
		COLUMN_FLAG[142] = true;
	}
	public String getP139()
	{
		return p139;
	}
	public void setP140(String p140)
	{
		this.p140=p140;
		COLUMN_FLAG[143] = true;
	}
	public String getP140()
	{
		return p140;
	}
	public void setP141(String p141)
	{
		this.p141=p141;
		COLUMN_FLAG[144] = true;
	}
	public String getP141()
	{
		return p141;
	}
	public void setP142(String p142)
	{
		this.p142=p142;
		COLUMN_FLAG[145] = true;
	}
	public String getP142()
	{
		return p142;
	}
	public void setP143(String p143)
	{
		this.p143=p143;
		COLUMN_FLAG[146] = true;
	}
	public String getP143()
	{
		return p143;
	}
	public void setP144(String p144)
	{
		this.p144=p144;
		COLUMN_FLAG[147] = true;
	}
	public String getP144()
	{
		return p144;
	}
	public void setP145(String p145)
	{
		this.p145=p145;
		COLUMN_FLAG[148] = true;
	}
	public String getP145()
	{
		return p145;
	}
	public void setP146(String p146)
	{
		this.p146=p146;
		COLUMN_FLAG[149] = true;
	}
	public String getP146()
	{
		return p146;
	}
	public void setP147(String p147)
	{
		this.p147=p147;
		COLUMN_FLAG[150] = true;
	}
	public String getP147()
	{
		return p147;
	}
	public void setP148(String p148)
	{
		this.p148=p148;
		COLUMN_FLAG[151] = true;
	}
	public String getP148()
	{
		return p148;
	}
	public void setP149(String p149)
	{
		this.p149=p149;
		COLUMN_FLAG[152] = true;
	}
	public String getP149()
	{
		return p149;
	}
	public void setP150(String p150)
	{
		this.p150=p150;
		COLUMN_FLAG[153] = true;
	}
	public String getP150()
	{
		return p150;
	}
	public void setP151(String p151)
	{
		this.p151=p151;
		COLUMN_FLAG[154] = true;
	}
	public String getP151()
	{
		return p151;
	}
	public void setP152(String p152)
	{
		this.p152=p152;
		COLUMN_FLAG[155] = true;
	}
	public String getP152()
	{
		return p152;
	}
	public void setP153(String p153)
	{
		this.p153=p153;
		COLUMN_FLAG[156] = true;
	}
	public String getP153()
	{
		return p153;
	}
	public void setP154(String p154)
	{
		this.p154=p154;
		COLUMN_FLAG[157] = true;
	}
	public String getP154()
	{
		return p154;
	}
	public void setP155(String p155)
	{
		this.p155=p155;
		COLUMN_FLAG[158] = true;
	}
	public String getP155()
	{
		return p155;
	}
	public void setP156(String p156)
	{
		this.p156=p156;
		COLUMN_FLAG[159] = true;
	}
	public String getP156()
	{
		return p156;
	}
	public void setP157(String p157)
	{
		this.p157=p157;
		COLUMN_FLAG[160] = true;
	}
	public String getP157()
	{
		return p157;
	}
	public void setP158(String p158)
	{
		this.p158=p158;
		COLUMN_FLAG[161] = true;
	}
	public String getP158()
	{
		return p158;
	}
	public void setP159(String p159)
	{
		this.p159=p159;
		COLUMN_FLAG[162] = true;
	}
	public String getP159()
	{
		return p159;
	}
	public void setP160(String p160)
	{
		this.p160=p160;
		COLUMN_FLAG[163] = true;
	}
	public String getP160()
	{
		return p160;
	}
	public void setP161(String p161)
	{
		this.p161=p161;
		COLUMN_FLAG[164] = true;
	}
	public String getP161()
	{
		return p161;
	}
	public void setP162(String p162)
	{
		this.p162=p162;
		COLUMN_FLAG[165] = true;
	}
	public String getP162()
	{
		return p162;
	}
	public void setP163(String p163)
	{
		this.p163=p163;
		COLUMN_FLAG[166] = true;
	}
	public String getP163()
	{
		return p163;
	}
	public void setP164(String p164)
	{
		this.p164=p164;
		COLUMN_FLAG[167] = true;
	}
	public String getP164()
	{
		return p164;
	}
	public void setP165(String p165)
	{
		this.p165=p165;
		COLUMN_FLAG[168] = true;
	}
	public String getP165()
	{
		return p165;
	}
	public void setP166(String p166)
	{
		this.p166=p166;
		COLUMN_FLAG[169] = true;
	}
	public String getP166()
	{
		return p166;
	}
	public void setP167(String p167)
	{
		this.p167=p167;
		COLUMN_FLAG[170] = true;
	}
	public String getP167()
	{
		return p167;
	}
	public void setP168(String p168)
	{
		this.p168=p168;
		COLUMN_FLAG[171] = true;
	}
	public String getP168()
	{
		return p168;
	}
	public void setP169(String p169)
	{
		this.p169=p169;
		COLUMN_FLAG[172] = true;
	}
	public String getP169()
	{
		return p169;
	}
	public void setP170(String p170)
	{
		this.p170=p170;
		COLUMN_FLAG[173] = true;
	}
	public String getP170()
	{
		return p170;
	}
	public void setP171(String p171)
	{
		this.p171=p171;
		COLUMN_FLAG[174] = true;
	}
	public String getP171()
	{
		return p171;
	}
	public void setP172(String p172)
	{
		this.p172=p172;
		COLUMN_FLAG[175] = true;
	}
	public String getP172()
	{
		return p172;
	}
	public void setP173(String p173)
	{
		this.p173=p173;
		COLUMN_FLAG[176] = true;
	}
	public String getP173()
	{
		return p173;
	}
	public void setP174(String p174)
	{
		this.p174=p174;
		COLUMN_FLAG[177] = true;
	}
	public String getP174()
	{
		return p174;
	}
	public void setP175(String p175)
	{
		this.p175=p175;
		COLUMN_FLAG[178] = true;
	}
	public String getP175()
	{
		return p175;
	}
	public void setP176(String p176)
	{
		this.p176=p176;
		COLUMN_FLAG[179] = true;
	}
	public String getP176()
	{
		return p176;
	}
	public void setP177(String p177)
	{
		this.p177=p177;
		COLUMN_FLAG[180] = true;
	}
	public String getP177()
	{
		return p177;
	}
	public void setP178(String p178)
	{
		this.p178=p178;
		COLUMN_FLAG[181] = true;
	}
	public String getP178()
	{
		return p178;
	}
	public void setP179(String p179)
	{
		this.p179=p179;
		COLUMN_FLAG[182] = true;
	}
	public String getP179()
	{
		return p179;
	}
	public void setP180(String p180)
	{
		this.p180=p180;
		COLUMN_FLAG[183] = true;
	}
	public String getP180()
	{
		return p180;
	}
	public void setP181(String p181)
	{
		this.p181=p181;
		COLUMN_FLAG[184] = true;
	}
	public String getP181()
	{
		return p181;
	}
	public void setP182(String p182)
	{
		this.p182=p182;
		COLUMN_FLAG[185] = true;
	}
	public String getP182()
	{
		return p182;
	}
	public void setP183(String p183)
	{
		this.p183=p183;
		COLUMN_FLAG[186] = true;
	}
	public String getP183()
	{
		return p183;
	}
	public void setP184(String p184)
	{
		this.p184=p184;
		COLUMN_FLAG[187] = true;
	}
	public String getP184()
	{
		return p184;
	}
	public void setP185(String p185)
	{
		this.p185=p185;
		COLUMN_FLAG[188] = true;
	}
	public String getP185()
	{
		return p185;
	}
	public void setP186(String p186)
	{
		this.p186=p186;
		COLUMN_FLAG[189] = true;
	}
	public String getP186()
	{
		return p186;
	}
	public void setP187(String p187)
	{
		this.p187=p187;
		COLUMN_FLAG[190] = true;
	}
	public String getP187()
	{
		return p187;
	}
	public void setP188(String p188)
	{
		this.p188=p188;
		COLUMN_FLAG[191] = true;
	}
	public String getP188()
	{
		return p188;
	}
	public void setP189(String p189)
	{
		this.p189=p189;
		COLUMN_FLAG[192] = true;
	}
	public String getP189()
	{
		return p189;
	}
	public void setP190(String p190)
	{
		this.p190=p190;
		COLUMN_FLAG[193] = true;
	}
	public String getP190()
	{
		return p190;
	}
	public void setP191(String p191)
	{
		this.p191=p191;
		COLUMN_FLAG[194] = true;
	}
	public String getP191()
	{
		return p191;
	}
	public void setP192(String p192)
	{
		this.p192=p192;
		COLUMN_FLAG[195] = true;
	}
	public String getP192()
	{
		return p192;
	}
	public void setP193(String p193)
	{
		this.p193=p193;
		COLUMN_FLAG[196] = true;
	}
	public String getP193()
	{
		return p193;
	}
	public void setP194(String p194)
	{
		this.p194=p194;
		COLUMN_FLAG[197] = true;
	}
	public String getP194()
	{
		return p194;
	}
	public void setP195(String p195)
	{
		this.p195=p195;
		COLUMN_FLAG[198] = true;
	}
	public String getP195()
	{
		return p195;
	}
	public void setP196(String p196)
	{
		this.p196=p196;
		COLUMN_FLAG[199] = true;
	}
	public String getP196()
	{
		return p196;
	}
	public void setP197(String p197)
	{
		this.p197=p197;
		COLUMN_FLAG[200] = true;
	}
	public String getP197()
	{
		return p197;
	}
	public void setP198(String p198)
	{
		this.p198=p198;
		COLUMN_FLAG[201] = true;
	}
	public String getP198()
	{
		return p198;
	}
	public void setP199(String p199)
	{
		this.p199=p199;
		COLUMN_FLAG[202] = true;
	}
	public String getP199()
	{
		return p199;
	}
	public void setP200(String p200)
	{
		this.p200=p200;
		COLUMN_FLAG[203] = true;
	}
	public String getP200()
	{
		return p200;
	}
	public void setP201(String p201)
	{
		this.p201=p201;
		COLUMN_FLAG[204] = true;
	}
	public String getP201()
	{
		return p201;
	}
	public void setP202(String p202)
	{
		this.p202=p202;
		COLUMN_FLAG[205] = true;
	}
	public String getP202()
	{
		return p202;
	}
	public void setP203(String p203)
	{
		this.p203=p203;
		COLUMN_FLAG[206] = true;
	}
	public String getP203()
	{
		return p203;
	}
	public void setP204(String p204)
	{
		this.p204=p204;
		COLUMN_FLAG[207] = true;
	}
	public String getP204()
	{
		return p204;
	}
	public void setP205(String p205)
	{
		this.p205=p205;
		COLUMN_FLAG[208] = true;
	}
	public String getP205()
	{
		return p205;
	}
	public void setP206(String p206)
	{
		this.p206=p206;
		COLUMN_FLAG[209] = true;
	}
	public String getP206()
	{
		return p206;
	}
	public void setP207(String p207)
	{
		this.p207=p207;
		COLUMN_FLAG[210] = true;
	}
	public String getP207()
	{
		return p207;
	}
	public void setP208(String p208)
	{
		this.p208=p208;
		COLUMN_FLAG[211] = true;
	}
	public String getP208()
	{
		return p208;
	}
	public void setP209(String p209)
	{
		this.p209=p209;
		COLUMN_FLAG[212] = true;
	}
	public String getP209()
	{
		return p209;
	}
	public void setP210(String p210)
	{
		this.p210=p210;
		COLUMN_FLAG[213] = true;
	}
	public String getP210()
	{
		return p210;
	}
	public void setP211(String p211)
	{
		this.p211=p211;
		COLUMN_FLAG[214] = true;
	}
	public String getP211()
	{
		return p211;
	}
	public void setP212(String p212)
	{
		this.p212=p212;
		COLUMN_FLAG[215] = true;
	}
	public String getP212()
	{
		return p212;
	}
	public void setP213(String p213)
	{
		this.p213=p213;
		COLUMN_FLAG[216] = true;
	}
	public String getP213()
	{
		return p213;
	}
	public void setP214(String p214)
	{
		this.p214=p214;
		COLUMN_FLAG[217] = true;
	}
	public String getP214()
	{
		return p214;
	}
	public void setP215(String p215)
	{
		this.p215=p215;
		COLUMN_FLAG[218] = true;
	}
	public String getP215()
	{
		return p215;
	}
	public void setP216(String p216)
	{
		this.p216=p216;
		COLUMN_FLAG[219] = true;
	}
	public String getP216()
	{
		return p216;
	}
	public void setP217(String p217)
	{
		this.p217=p217;
		COLUMN_FLAG[220] = true;
	}
	public String getP217()
	{
		return p217;
	}
	public void setP218(String p218)
	{
		this.p218=p218;
		COLUMN_FLAG[221] = true;
	}
	public String getP218()
	{
		return p218;
	}
	public void setP219(String p219)
	{
		this.p219=p219;
		COLUMN_FLAG[222] = true;
	}
	public String getP219()
	{
		return p219;
	}
	public void setP220(String p220)
	{
		this.p220=p220;
		COLUMN_FLAG[223] = true;
	}
	public String getP220()
	{
		return p220;
	}
	public void setP221(String p221)
	{
		this.p221=p221;
		COLUMN_FLAG[224] = true;
	}
	public String getP221()
	{
		return p221;
	}
	public void setP222(String p222)
	{
		this.p222=p222;
		COLUMN_FLAG[225] = true;
	}
	public String getP222()
	{
		return p222;
	}
	public void setP223(String p223)
	{
		this.p223=p223;
		COLUMN_FLAG[226] = true;
	}
	public String getP223()
	{
		return p223;
	}
	public void setP224(String p224)
	{
		this.p224=p224;
		COLUMN_FLAG[227] = true;
	}
	public String getP224()
	{
		return p224;
	}
	public void setP225(String p225)
	{
		this.p225=p225;
		COLUMN_FLAG[228] = true;
	}
	public String getP225()
	{
		return p225;
	}
	public void setP226(String p226)
	{
		this.p226=p226;
		COLUMN_FLAG[229] = true;
	}
	public String getP226()
	{
		return p226;
	}
	public void setP227(String p227)
	{
		this.p227=p227;
		COLUMN_FLAG[230] = true;
	}
	public String getP227()
	{
		return p227;
	}
	public void setP228(String p228)
	{
		this.p228=p228;
		COLUMN_FLAG[231] = true;
	}
	public String getP228()
	{
		return p228;
	}
	public void setP229(String p229)
	{
		this.p229=p229;
		COLUMN_FLAG[232] = true;
	}
	public String getP229()
	{
		return p229;
	}
	public void setP230(String p230)
	{
		this.p230=p230;
		COLUMN_FLAG[233] = true;
	}
	public String getP230()
	{
		return p230;
	}
	public void setP231(String p231)
	{
		this.p231=p231;
		COLUMN_FLAG[234] = true;
	}
	public String getP231()
	{
		return p231;
	}
	public void setP232(String p232)
	{
		this.p232=p232;
		COLUMN_FLAG[235] = true;
	}
	public String getP232()
	{
		return p232;
	}
	public void setP233(String p233)
	{
		this.p233=p233;
		COLUMN_FLAG[236] = true;
	}
	public String getP233()
	{
		return p233;
	}
	public void setP234(String p234)
	{
		this.p234=p234;
		COLUMN_FLAG[237] = true;
	}
	public String getP234()
	{
		return p234;
	}
	public void setP235(String p235)
	{
		this.p235=p235;
		COLUMN_FLAG[238] = true;
	}
	public String getP235()
	{
		return p235;
	}
	public void setP236(String p236)
	{
		this.p236=p236;
		COLUMN_FLAG[239] = true;
	}
	public String getP236()
	{
		return p236;
	}
	public void setP237(String p237)
	{
		this.p237=p237;
		COLUMN_FLAG[240] = true;
	}
	public String getP237()
	{
		return p237;
	}
	public void setP238(String p238)
	{
		this.p238=p238;
		COLUMN_FLAG[241] = true;
	}
	public String getP238()
	{
		return p238;
	}
	public void setP239(String p239)
	{
		this.p239=p239;
		COLUMN_FLAG[242] = true;
	}
	public String getP239()
	{
		return p239;
	}
	public void setP240(String p240)
	{
		this.p240=p240;
		COLUMN_FLAG[243] = true;
	}
	public String getP240()
	{
		return p240;
	}
	public void setP241(String p241)
	{
		this.p241=p241;
		COLUMN_FLAG[244] = true;
	}
	public String getP241()
	{
		return p241;
	}
	public void setP242(String p242)
	{
		this.p242=p242;
		COLUMN_FLAG[245] = true;
	}
	public String getP242()
	{
		return p242;
	}
	public void setP243(String p243)
	{
		this.p243=p243;
		COLUMN_FLAG[246] = true;
	}
	public String getP243()
	{
		return p243;
	}
	public void setP244(String p244)
	{
		this.p244=p244;
		COLUMN_FLAG[247] = true;
	}
	public String getP244()
	{
		return p244;
	}
	public void setP245(String p245)
	{
		this.p245=p245;
		COLUMN_FLAG[248] = true;
	}
	public String getP245()
	{
		return p245;
	}
	public void setP246(String p246)
	{
		this.p246=p246;
		COLUMN_FLAG[249] = true;
	}
	public String getP246()
	{
		return p246;
	}
	public void setP247(String p247)
	{
		this.p247=p247;
		COLUMN_FLAG[250] = true;
	}
	public String getP247()
	{
		return p247;
	}
	public void setP248(String p248)
	{
		this.p248=p248;
		COLUMN_FLAG[251] = true;
	}
	public String getP248()
	{
		return p248;
	}
	public void setP249(String p249)
	{
		this.p249=p249;
		COLUMN_FLAG[252] = true;
	}
	public String getP249()
	{
		return p249;
	}
	public void setP250(String p250)
	{
		this.p250=p250;
		COLUMN_FLAG[253] = true;
	}
	public String getP250()
	{
		return p250;
	}
	public void setP251(String p251)
	{
		this.p251=p251;
		COLUMN_FLAG[254] = true;
	}
	public String getP251()
	{
		return p251;
	}
	public void setP252(String p252)
	{
		this.p252=p252;
		COLUMN_FLAG[255] = true;
	}
	public String getP252()
	{
		return p252;
	}
	public void setP253(String p253)
	{
		this.p253=p253;
		COLUMN_FLAG[256] = true;
	}
	public String getP253()
	{
		return p253;
	}
	public void setP254(String p254)
	{
		this.p254=p254;
		COLUMN_FLAG[257] = true;
	}
	public String getP254()
	{
		return p254;
	}
	public void setP255(String p255)
	{
		this.p255=p255;
		COLUMN_FLAG[258] = true;
	}
	public String getP255()
	{
		return p255;
	}
	public void setP256(String p256)
	{
		this.p256=p256;
		COLUMN_FLAG[259] = true;
	}
	public String getP256()
	{
		return p256;
	}
	public void setP257(String p257)
	{
		this.p257=p257;
		COLUMN_FLAG[260] = true;
	}
	public String getP257()
	{
		return p257;
	}
	public void setP258(String p258)
	{
		this.p258=p258;
		COLUMN_FLAG[261] = true;
	}
	public String getP258()
	{
		return p258;
	}
	public void setP259(String p259)
	{
		this.p259=p259;
		COLUMN_FLAG[262] = true;
	}
	public String getP259()
	{
		return p259;
	}
	public void setP260(String p260)
	{
		this.p260=p260;
		COLUMN_FLAG[263] = true;
	}
	public String getP260()
	{
		return p260;
	}
	public void setP261(String p261)
	{
		this.p261=p261;
		COLUMN_FLAG[264] = true;
	}
	public String getP261()
	{
		return p261;
	}
	public void setP262(String p262)
	{
		this.p262=p262;
		COLUMN_FLAG[265] = true;
	}
	public String getP262()
	{
		return p262;
	}
	public void setP263(String p263)
	{
		this.p263=p263;
		COLUMN_FLAG[266] = true;
	}
	public String getP263()
	{
		return p263;
	}
	public void setP264(String p264)
	{
		this.p264=p264;
		COLUMN_FLAG[267] = true;
	}
	public String getP264()
	{
		return p264;
	}
	public void setP265(String p265)
	{
		this.p265=p265;
		COLUMN_FLAG[268] = true;
	}
	public String getP265()
	{
		return p265;
	}
	public void setP266(String p266)
	{
		this.p266=p266;
		COLUMN_FLAG[269] = true;
	}
	public String getP266()
	{
		return p266;
	}
	public void setP267(String p267)
	{
		this.p267=p267;
		COLUMN_FLAG[270] = true;
	}
	public String getP267()
	{
		return p267;
	}
	public void setP268(String p268)
	{
		this.p268=p268;
		COLUMN_FLAG[271] = true;
	}
	public String getP268()
	{
		return p268;
	}
	public void setP269(String p269)
	{
		this.p269=p269;
		COLUMN_FLAG[272] = true;
	}
	public String getP269()
	{
		return p269;
	}
	public void setP270(String p270)
	{
		this.p270=p270;
		COLUMN_FLAG[273] = true;
	}
	public String getP270()
	{
		return p270;
	}
	public void setP271(String p271)
	{
		this.p271=p271;
		COLUMN_FLAG[274] = true;
	}
	public String getP271()
	{
		return p271;
	}
	public void setP272(String p272)
	{
		this.p272=p272;
		COLUMN_FLAG[275] = true;
	}
	public String getP272()
	{
		return p272;
	}
	public void setP273(String p273)
	{
		this.p273=p273;
		COLUMN_FLAG[276] = true;
	}
	public String getP273()
	{
		return p273;
	}
	public void setP274(String p274)
	{
		this.p274=p274;
		COLUMN_FLAG[277] = true;
	}
	public String getP274()
	{
		return p274;
	}
	public void setP275(String p275)
	{
		this.p275=p275;
		COLUMN_FLAG[278] = true;
	}
	public String getP275()
	{
		return p275;
	}
	public void setP276(String p276)
	{
		this.p276=p276;
		COLUMN_FLAG[279] = true;
	}
	public String getP276()
	{
		return p276;
	}
	public void setP277(String p277)
	{
		this.p277=p277;
		COLUMN_FLAG[280] = true;
	}
	public String getP277()
	{
		return p277;
	}
	public void setP278(String p278)
	{
		this.p278=p278;
		COLUMN_FLAG[281] = true;
	}
	public String getP278()
	{
		return p278;
	}
	public void setP279(String p279)
	{
		this.p279=p279;
		COLUMN_FLAG[282] = true;
	}
	public String getP279()
	{
		return p279;
	}
	public void setP280(String p280)
	{
		this.p280=p280;
		COLUMN_FLAG[283] = true;
	}
	public String getP280()
	{
		return p280;
	}
	public void setP281(String p281)
	{
		this.p281=p281;
		COLUMN_FLAG[284] = true;
	}
	public String getP281()
	{
		return p281;
	}
	public void setP282(String p282)
	{
		this.p282=p282;
		COLUMN_FLAG[285] = true;
	}
	public String getP282()
	{
		return p282;
	}
	public void setP283(String p283)
	{
		this.p283=p283;
		COLUMN_FLAG[286] = true;
	}
	public String getP283()
	{
		return p283;
	}
	public void setP284(String p284)
	{
		this.p284=p284;
		COLUMN_FLAG[287] = true;
	}
	public String getP284()
	{
		return p284;
	}
	public void setP285(String p285)
	{
		this.p285=p285;
		COLUMN_FLAG[288] = true;
	}
	public String getP285()
	{
		return p285;
	}
	public void setP286(String p286)
	{
		this.p286=p286;
		COLUMN_FLAG[289] = true;
	}
	public String getP286()
	{
		return p286;
	}
	public void setP287(String p287)
	{
		this.p287=p287;
		COLUMN_FLAG[290] = true;
	}
	public String getP287()
	{
		return p287;
	}
	public void setP288(String p288)
	{
		this.p288=p288;
		COLUMN_FLAG[291] = true;
	}
	public String getP288()
	{
		return p288;
	}
	public void setP289(String p289)
	{
		this.p289=p289;
		COLUMN_FLAG[292] = true;
	}
	public String getP289()
	{
		return p289;
	}
	public void setP290(String p290)
	{
		this.p290=p290;
		COLUMN_FLAG[293] = true;
	}
	public String getP290()
	{
		return p290;
	}
	public void setP291(String p291)
	{
		this.p291=p291;
		COLUMN_FLAG[294] = true;
	}
	public String getP291()
	{
		return p291;
	}
	public void setP292(String p292)
	{
		this.p292=p292;
		COLUMN_FLAG[295] = true;
	}
	public String getP292()
	{
		return p292;
	}
	public void setP293(String p293)
	{
		this.p293=p293;
		COLUMN_FLAG[296] = true;
	}
	public String getP293()
	{
		return p293;
	}
	public void setP294(String p294)
	{
		this.p294=p294;
		COLUMN_FLAG[297] = true;
	}
	public String getP294()
	{
		return p294;
	}
	public void setP295(String p295)
	{
		this.p295=p295;
		COLUMN_FLAG[298] = true;
	}
	public String getP295()
	{
		return p295;
	}
	public void setP296(String p296)
	{
		this.p296=p296;
		COLUMN_FLAG[299] = true;
	}
	public String getP296()
	{
		return p296;
	}
	public void setP297(String p297)
	{
		this.p297=p297;
		COLUMN_FLAG[300] = true;
	}
	public String getP297()
	{
		return p297;
	}
	public void setP298(String p298)
	{
		this.p298=p298;
		COLUMN_FLAG[301] = true;
	}
	public String getP298()
	{
		return p298;
	}
	public void setP299(String p299)
	{
		this.p299=p299;
		COLUMN_FLAG[302] = true;
	}
	public String getP299()
	{
		return p299;
	}
	public void setP300(String p300)
	{
		this.p300=p300;
		COLUMN_FLAG[303] = true;
	}
	public String getP300()
	{
		return p300;
	}
	public void setIsupdate(int isupdate)
	{
		this.isupdate=isupdate;
		COLUMN_FLAG[304] = true;
	}
	public int getIsupdate()
	{
		return isupdate;
	}
	public void setIway(String iway)
	{
		this.iway=iway;
		COLUMN_FLAG[305] = true;
	}
	public String getIway()
	{
		return iway;
	}
	public void setCar_type(int car_type)
	{
		this.car_type=car_type;
		COLUMN_FLAG[306] = true;
	}
	public int getCar_type()
	{
		return car_type;
	}
}
