package car_beans;
import java.util.*;

public class  TbDataVisitRecord  implements java.io.Serializable{

	public String KEY = "record_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int record_id;//主键id
	private String pro_num;//项目编号
	private String phone;//手机号
	private String name;//姓名
	private int baoming_id;//报名id
	private int return_visit_state;//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4- 其他
	private int is_key_cus;//客户类型 0-普通客户 1-重点客户
	private int phoneerror;//电话能否接通  0-已接通 1-未接通
	private Date return_visit_time;//回访时间
	private String return_visit_content;//回访内容
	private String return_visit_man;//回访人姓名
	private int tuisong_flag;//是否推送 0- 未推送 1- 已推送
	private int attend_type;//参团方式 0-无操作，1-参加，跟团到 2-参加，自行到 3-参加，不确定 4-可能参加 5-不参加
	private String attend_date;//参团日期
	private int phone_state;//手机状态 0-有效 1-无效 2-重复报名
	private int is_jp;//是否有竞品  0-否 1-是
	private String jp_car;//竞品车系
	private int is_buycar;//是否购车 0-否 1-是
	private int buy_state;//购车情况 0-新车全款 1-新车贷款 2-置换全款 3-增购贷款
	private int phoneerror_count;//电话未接听次数
	private int is_reach;//是否到店
	private int is_trans;//是否成交
	private int is_invite;//是否邀约
	private int brand;//品牌id
	private int serial;//报名车系id
	private int model;//车型id
	private int phone_prov;//手机省
	private int phone_city;//手机市
	private String ip;//ip地址
	private int prov;//报名省份
	private int city;//报名城市
	private int buycar_emergency;//0-未知 1-本周 2-2周内 3-一个月内 4-3个月内 5-3个月以上 6 -随时
	private String pp_state;//拍牌状态
	private String pz_city;//拍照城市
	private String buy_ys;//购车预算
	private int buy_bsx;//变速箱 0-自动 1-手动 2-不限
	private String buy_pl;//排量
	private String buy_color;//颜色
	private String know_yh;//4s了解优惠
	private int p_job;//职业 0-国企 1-私企 2-个体
	private String p_weixin;//微信
	private String p_qq;//qq
	private Date baoming_date;//报名时间
	private String bz;//备注
	private int require;//需求服务(0-上牌,2-保险，3-贷款)
	private int research;//是否接受调查 0-请选择 1-是 2-否
	private String not_store_reason;//未到店原因
	private int lose_reason;//失销原因 0-请选择 1-价格不到位 2-4s店服务 3-没有现车 4-客户竞品比较中 5-4s店距离较远 6-驾照没到手 7-牌照没拍到 8-活动气氛不热烈 9-小胖服务不周到
	private int satisfy;//服务满意度 0-未选择 1-满意 2-一般 3-不满意
	private String advise;//建议与意见
	private Date satisfy_date;//满意度评价时间
	private int satisfy_state;//评价 0-未评价 1-已评价


	public void setRecord_id(int record_id)
	{
		this.record_id=record_id;
		COLUMN_FLAG[0] = true;
	}
	public int getRecord_id()
	{
		return record_id;
	}
	public void setPro_num(String pro_num)
	{
		this.pro_num=pro_num;
		COLUMN_FLAG[1] = true;
	}
	public String getPro_num()
	{
		return pro_num;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[2] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[3] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setBaoming_id(int baoming_id)
	{
		this.baoming_id=baoming_id;
		COLUMN_FLAG[4] = true;
	}
	public int getBaoming_id()
	{
		return baoming_id;
	}
	public void setReturn_visit_state(int return_visit_state)
	{
		this.return_visit_state=return_visit_state;
		COLUMN_FLAG[5] = true;
	}
	public int getReturn_visit_state()
	{
		return return_visit_state;
	}
	public void setIs_key_cus(int is_key_cus)
	{
		this.is_key_cus=is_key_cus;
		COLUMN_FLAG[6] = true;
	}
	public int getIs_key_cus()
	{
		return is_key_cus;
	}
	public void setPhoneerror(int phoneerror)
	{
		this.phoneerror=phoneerror;
		COLUMN_FLAG[7] = true;
	}
	public int getPhoneerror()
	{
		return phoneerror;
	}
	public void setReturn_visit_time(Date return_visit_time)
	{
		this.return_visit_time=return_visit_time;
		COLUMN_FLAG[8] = true;
	}
	public Date getReturn_visit_time()
	{
		return return_visit_time;
	}
	public void setReturn_visit_content(String return_visit_content)
	{
		this.return_visit_content=return_visit_content;
		COLUMN_FLAG[9] = true;
	}
	public String getReturn_visit_content()
	{
		return return_visit_content;
	}
	public void setReturn_visit_man(String return_visit_man)
	{
		this.return_visit_man=return_visit_man;
		COLUMN_FLAG[10] = true;
	}
	public String getReturn_visit_man()
	{
		return return_visit_man;
	}
	public void setTuisong_flag(int tuisong_flag)
	{
		this.tuisong_flag=tuisong_flag;
		COLUMN_FLAG[11] = true;
	}
	public int getTuisong_flag()
	{
		return tuisong_flag;
	}
	public void setAttend_type(int attend_type)
	{
		this.attend_type=attend_type;
		COLUMN_FLAG[12] = true;
	}
	public int getAttend_type()
	{
		return attend_type;
	}
	public void setAttend_date(String attend_date)
	{
		this.attend_date=attend_date;
		COLUMN_FLAG[13] = true;
	}
	public String getAttend_date()
	{
		return attend_date;
	}
	public void setPhone_state(int phone_state)
	{
		this.phone_state=phone_state;
		COLUMN_FLAG[14] = true;
	}
	public int getPhone_state()
	{
		return phone_state;
	}
	public void setIs_jp(int is_jp)
	{
		this.is_jp=is_jp;
		COLUMN_FLAG[15] = true;
	}
	public int getIs_jp()
	{
		return is_jp;
	}
	public void setJp_car(String jp_car)
	{
		this.jp_car=jp_car;
		COLUMN_FLAG[16] = true;
	}
	public String getJp_car()
	{
		return jp_car;
	}
	public void setIs_buycar(int is_buycar)
	{
		this.is_buycar=is_buycar;
		COLUMN_FLAG[17] = true;
	}
	public int getIs_buycar()
	{
		return is_buycar;
	}
	public void setBuy_state(int buy_state)
	{
		this.buy_state=buy_state;
		COLUMN_FLAG[18] = true;
	}
	public int getBuy_state()
	{
		return buy_state;
	}
	public void setPhoneerror_count(int phoneerror_count)
	{
		this.phoneerror_count=phoneerror_count;
		COLUMN_FLAG[19] = true;
	}
	public int getPhoneerror_count()
	{
		return phoneerror_count;
	}
	public void setIs_reach(int is_reach)
	{
		this.is_reach=is_reach;
		COLUMN_FLAG[20] = true;
	}
	public int getIs_reach()
	{
		return is_reach;
	}
	public void setIs_trans(int is_trans)
	{
		this.is_trans=is_trans;
		COLUMN_FLAG[21] = true;
	}
	public int getIs_trans()
	{
		return is_trans;
	}
	public void setIs_invite(int is_invite)
	{
		this.is_invite=is_invite;
		COLUMN_FLAG[22] = true;
	}
	public int getIs_invite()
	{
		return is_invite;
	}
	public void setBrand(int brand)
	{
		this.brand=brand;
		COLUMN_FLAG[23] = true;
	}
	public int getBrand()
	{
		return brand;
	}
	public void setSerial(int serial)
	{
		this.serial=serial;
		COLUMN_FLAG[24] = true;
	}
	public int getSerial()
	{
		return serial;
	}
	public void setModel(int model)
	{
		this.model=model;
		COLUMN_FLAG[25] = true;
	}
	public int getModel()
	{
		return model;
	}
	public void setPhone_prov(int phone_prov)
	{
		this.phone_prov=phone_prov;
		COLUMN_FLAG[26] = true;
	}
	public int getPhone_prov()
	{
		return phone_prov;
	}
	public void setPhone_city(int phone_city)
	{
		this.phone_city=phone_city;
		COLUMN_FLAG[27] = true;
	}
	public int getPhone_city()
	{
		return phone_city;
	}
	public void setIp(String ip)
	{
		this.ip=ip;
		COLUMN_FLAG[28] = true;
	}
	public String getIp()
	{
		return ip;
	}
	public void setProv(int prov)
	{
		this.prov=prov;
		COLUMN_FLAG[29] = true;
	}
	public int getProv()
	{
		return prov;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[30] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setBuycar_emergency(int buycar_emergency)
	{
		this.buycar_emergency=buycar_emergency;
		COLUMN_FLAG[31] = true;
	}
	public int getBuycar_emergency()
	{
		return buycar_emergency;
	}
	public void setPp_state(String pp_state)
	{
		this.pp_state=pp_state;
		COLUMN_FLAG[32] = true;
	}
	public String getPp_state()
	{
		return pp_state;
	}
	public void setPz_city(String pz_city)
	{
		this.pz_city=pz_city;
		COLUMN_FLAG[33] = true;
	}
	public String getPz_city()
	{
		return pz_city;
	}
	public void setBuy_ys(String buy_ys)
	{
		this.buy_ys=buy_ys;
		COLUMN_FLAG[34] = true;
	}
	public String getBuy_ys()
	{
		return buy_ys;
	}
	public void setBuy_bsx(int buy_bsx)
	{
		this.buy_bsx=buy_bsx;
		COLUMN_FLAG[35] = true;
	}
	public int getBuy_bsx()
	{
		return buy_bsx;
	}
	public void setBuy_pl(String buy_pl)
	{
		this.buy_pl=buy_pl;
		COLUMN_FLAG[36] = true;
	}
	public String getBuy_pl()
	{
		return buy_pl;
	}
	public void setBuy_color(String buy_color)
	{
		this.buy_color=buy_color;
		COLUMN_FLAG[37] = true;
	}
	public String getBuy_color()
	{
		return buy_color;
	}
	public void setKnow_yh(String know_yh)
	{
		this.know_yh=know_yh;
		COLUMN_FLAG[38] = true;
	}
	public String getKnow_yh()
	{
		return know_yh;
	}
	public void setP_job(int p_job)
	{
		this.p_job=p_job;
		COLUMN_FLAG[39] = true;
	}
	public int getP_job()
	{
		return p_job;
	}
	public void setP_weixin(String p_weixin)
	{
		this.p_weixin=p_weixin;
		COLUMN_FLAG[40] = true;
	}
	public String getP_weixin()
	{
		return p_weixin;
	}
	public void setP_qq(String p_qq)
	{
		this.p_qq=p_qq;
		COLUMN_FLAG[41] = true;
	}
	public String getP_qq()
	{
		return p_qq;
	}
	public void setBaoming_date(Date baoming_date)
	{
		this.baoming_date=baoming_date;
		COLUMN_FLAG[42] = true;
	}
	public Date getBaoming_date()
	{
		return baoming_date;
	}
	public void setBz(String bz)
	{
		this.bz=bz;
		COLUMN_FLAG[43] = true;
	}
	public String getBz()
	{
		return bz;
	}
	public void setRequire(int require)
	{
		this.require=require;
		COLUMN_FLAG[44] = true;
	}
	public int getRequire()
	{
		return require;
	}
	public void setResearch(int research)
	{
		this.research=research;
		COLUMN_FLAG[45] = true;
	}
	public int getResearch()
	{
		return research;
	}
	public void setNot_store_reason(String not_store_reason)
	{
		this.not_store_reason=not_store_reason;
		COLUMN_FLAG[46] = true;
	}
	public String getNot_store_reason()
	{
		return not_store_reason;
	}
	public void setLose_reason(int lose_reason)
	{
		this.lose_reason=lose_reason;
		COLUMN_FLAG[47] = true;
	}
	public int getLose_reason()
	{
		return lose_reason;
	}
	public void setSatisfy(int satisfy)
	{
		this.satisfy=satisfy;
		COLUMN_FLAG[48] = true;
	}
	public int getSatisfy()
	{
		return satisfy;
	}
	public void setAdvise(String advise)
	{
		this.advise=advise;
		COLUMN_FLAG[49] = true;
	}
	public String getAdvise()
	{
		return advise;
	}
	public void setSatisfy_date(Date satisfy_date)
	{
		this.satisfy_date=satisfy_date;
		COLUMN_FLAG[50] = true;
	}
	public Date getSatisfy_date()
	{
		return satisfy_date;
	}
	public void setSatisfy_state(int satisfy_state)
	{
		this.satisfy_state=satisfy_state;
		COLUMN_FLAG[51] = true;
	}
	public int getSatisfy_state()
	{
		return satisfy_state;
	}
}
