package car_beans;
import java.util.*;

public class  TbDataBaoming  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String name;//用户姓名
	private String phone;//用户手机
	private int type;//报名类型 0-看车团 1-直销 2-车展 3-大客户
	private int brand;//品牌id
	private int serial;//报名车系id
	private int model;//车型id
	private int prov;//报名省份
	private int city;//报名城市
	private int is_reach;//是否到店
	private int is_trans;//是否成交
	private int is_invite;// 是否小胖邀约
	private Date baoming_date;//报名时间
	private String car_info;//报名备注信息
	private int phone_prov;//手机省
	private int phone_city;//手机市
	private String ip;//ip地址
	private int return_visit_state;//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4- 其他
	private int buycar_emergency;//0-未知 1-本周 2-2周内 3-一个月内 4-3个月内 5-3个月以上 6 -随时
	private int is_key_cus;//客户类型 0-普通客户 1-重点客户
	private int phoneerror;//电话能否接通  0-已接通 1-未接通
	private Date return_visit_time;//回访时间
	private String return_visit_content;//回访内容
	private String remarks;//回访历史
	private String return_visit_man;//回访人姓名
	private String return_visit_id;//回访人工号
	private int tuisong_flag;//是否推送 0- 未推送 1- 已推送
	private int isdelete;//是否删除 0-未删除 1-已删除
	private int attend_type;//参团方式 1-参加，跟团到 2-参加，自行到 3-参加，不确定 4-可能参加 5-不参加
	private String attend_date;//参团日期
	private String pp_state;//拍牌状态
	private String pz_city;//拍照城市
	private int phone_state;//手机状态 0-有效 1-无效 2-重复报名
	private int is_jp;//是否有竞品  0-否 1-是
	private String jp_car;//竞品车系
	private int is_buycar;//是否购车 0-否 1-是
	private int buy_state;//购车情况 0-新车全款 1-新车贷款 2-置换全款 3-增购贷款
	private String buy_ys;//购车预算
	private int buy_bsx;//变速箱 0-自动 1-手动 2-不限
	private String buy_pl;//排量
	private String buy_color;//颜色
	private String know_yh;//4s了解优惠
	private int p_job;//职业 0-国企 1-私企 2-个体
	private String p_weixin;//微信
	private String p_qq;//qq
	private int phoneerror_count;//电话未接听次数
	private int area;//区域
	private int real_type;//报名真正渠道 0-车团pc，1-车团手机，4-tuan.315che.com-pc（百度）,5-taun.315che.com-mobile(百度)，6-315chepc,8-315che手机，7-suncarspc,10-suncars手机，11-专题页报名，9-合作媒体，11-专题页报名,13-合作网站，14-合作app，18-购车节专题，19-车展自行访客',20-合作渠道
	private int constacterror;//0-已沟通 1-未沟通
	private int constacterror_count;//未沟通次数
	private int oldid;//
	private int sub_site;//所属分站
	private int is_sample;//抽查标志
	private String sample_man_id;//抽查人工号
	private String sample_man_name;//抽查人姓名
	private Date sample_time;//抽查时间
	private String sample_content;//抽查内容
	private String type_remark;//渠道类型备注
	private String czname;//车展活动名称


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[1] = true;
	}
	public String getName()
	{
		return name;
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
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[3] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setBrand(int brand)
	{
		this.brand=brand;
		COLUMN_FLAG[4] = true;
	}
	public int getBrand()
	{
		return brand;
	}
	public void setSerial(int serial)
	{
		this.serial=serial;
		COLUMN_FLAG[5] = true;
	}
	public int getSerial()
	{
		return serial;
	}
	public void setModel(int model)
	{
		this.model=model;
		COLUMN_FLAG[6] = true;
	}
	public int getModel()
	{
		return model;
	}
	public void setProv(int prov)
	{
		this.prov=prov;
		COLUMN_FLAG[7] = true;
	}
	public int getProv()
	{
		return prov;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[8] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setIs_reach(int is_reach)
	{
		this.is_reach=is_reach;
		COLUMN_FLAG[9] = true;
	}
	public int getIs_reach()
	{
		return is_reach;
	}
	public void setIs_trans(int is_trans)
	{
		this.is_trans=is_trans;
		COLUMN_FLAG[10] = true;
	}
	public int getIs_trans()
	{
		return is_trans;
	}
	public void setIs_invite(int is_invite)
	{
		this.is_invite=is_invite;
		COLUMN_FLAG[11] = true;
	}
	public int getIs_invite()
	{
		return is_invite;
	}
	public void setBaoming_date(Date baoming_date)
	{
		this.baoming_date=baoming_date;
		COLUMN_FLAG[12] = true;
	}
	public Date getBaoming_date()
	{
		return baoming_date;
	}
	public void setCar_info(String car_info)
	{
		this.car_info=car_info;
		COLUMN_FLAG[13] = true;
	}
	public String getCar_info()
	{
		return car_info;
	}
	public void setPhone_prov(int phone_prov)
	{
		this.phone_prov=phone_prov;
		COLUMN_FLAG[14] = true;
	}
	public int getPhone_prov()
	{
		return phone_prov;
	}
	public void setPhone_city(int phone_city)
	{
		this.phone_city=phone_city;
		COLUMN_FLAG[15] = true;
	}
	public int getPhone_city()
	{
		return phone_city;
	}
	public void setIp(String ip)
	{
		this.ip=ip;
		COLUMN_FLAG[16] = true;
	}
	public String getIp()
	{
		return ip;
	}
	public void setReturn_visit_state(int return_visit_state)
	{
		this.return_visit_state=return_visit_state;
		COLUMN_FLAG[17] = true;
	}
	public int getReturn_visit_state()
	{
		return return_visit_state;
	}
	public void setBuycar_emergency(int buycar_emergency)
	{
		this.buycar_emergency=buycar_emergency;
		COLUMN_FLAG[18] = true;
	}
	public int getBuycar_emergency()
	{
		return buycar_emergency;
	}
	public void setIs_key_cus(int is_key_cus)
	{
		this.is_key_cus=is_key_cus;
		COLUMN_FLAG[19] = true;
	}
	public int getIs_key_cus()
	{
		return is_key_cus;
	}
	public void setPhoneerror(int phoneerror)
	{
		this.phoneerror=phoneerror;
		COLUMN_FLAG[20] = true;
	}
	public int getPhoneerror()
	{
		return phoneerror;
	}
	public void setReturn_visit_time(Date return_visit_time)
	{
		this.return_visit_time=return_visit_time;
		COLUMN_FLAG[21] = true;
	}
	public Date getReturn_visit_time()
	{
		return return_visit_time;
	}
	public void setReturn_visit_content(String return_visit_content)
	{
		this.return_visit_content=return_visit_content;
		COLUMN_FLAG[22] = true;
	}
	public String getReturn_visit_content()
	{
		return return_visit_content;
	}
	public void setRemarks(String remarks)
	{
		this.remarks=remarks;
		COLUMN_FLAG[23] = true;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setReturn_visit_man(String return_visit_man)
	{
		this.return_visit_man=return_visit_man;
		COLUMN_FLAG[24] = true;
	}
	public String getReturn_visit_man()
	{
		return return_visit_man;
	}
	public void setReturn_visit_id(String return_visit_id)
	{
		this.return_visit_id=return_visit_id;
		COLUMN_FLAG[25] = true;
	}
	public String getReturn_visit_id()
	{
		return return_visit_id;
	}
	public void setTuisong_flag(int tuisong_flag)
	{
		this.tuisong_flag=tuisong_flag;
		COLUMN_FLAG[26] = true;
	}
	public int getTuisong_flag()
	{
		return tuisong_flag;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[27] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAttend_type(int attend_type)
	{
		this.attend_type=attend_type;
		COLUMN_FLAG[28] = true;
	}
	public int getAttend_type()
	{
		return attend_type;
	}
	public void setAttend_date(String attend_date)
	{
		this.attend_date=attend_date;
		COLUMN_FLAG[29] = true;
	}
	public String getAttend_date()
	{
		return attend_date;
	}
	public void setPp_state(String pp_state)
	{
		this.pp_state=pp_state;
		COLUMN_FLAG[30] = true;
	}
	public String getPp_state()
	{
		return pp_state;
	}
	public void setPz_city(String pz_city)
	{
		this.pz_city=pz_city;
		COLUMN_FLAG[31] = true;
	}
	public String getPz_city()
	{
		return pz_city;
	}
	public void setPhone_state(int phone_state)
	{
		this.phone_state=phone_state;
		COLUMN_FLAG[32] = true;
	}
	public int getPhone_state()
	{
		return phone_state;
	}
	public void setIs_jp(int is_jp)
	{
		this.is_jp=is_jp;
		COLUMN_FLAG[33] = true;
	}
	public int getIs_jp()
	{
		return is_jp;
	}
	public void setJp_car(String jp_car)
	{
		this.jp_car=jp_car;
		COLUMN_FLAG[34] = true;
	}
	public String getJp_car()
	{
		return jp_car;
	}
	public void setIs_buycar(int is_buycar)
	{
		this.is_buycar=is_buycar;
		COLUMN_FLAG[35] = true;
	}
	public int getIs_buycar()
	{
		return is_buycar;
	}
	public void setBuy_state(int buy_state)
	{
		this.buy_state=buy_state;
		COLUMN_FLAG[36] = true;
	}
	public int getBuy_state()
	{
		return buy_state;
	}
	public void setBuy_ys(String buy_ys)
	{
		this.buy_ys=buy_ys;
		COLUMN_FLAG[37] = true;
	}
	public String getBuy_ys()
	{
		return buy_ys;
	}
	public void setBuy_bsx(int buy_bsx)
	{
		this.buy_bsx=buy_bsx;
		COLUMN_FLAG[38] = true;
	}
	public int getBuy_bsx()
	{
		return buy_bsx;
	}
	public void setBuy_pl(String buy_pl)
	{
		this.buy_pl=buy_pl;
		COLUMN_FLAG[39] = true;
	}
	public String getBuy_pl()
	{
		return buy_pl;
	}
	public void setBuy_color(String buy_color)
	{
		this.buy_color=buy_color;
		COLUMN_FLAG[40] = true;
	}
	public String getBuy_color()
	{
		return buy_color;
	}
	public void setKnow_yh(String know_yh)
	{
		this.know_yh=know_yh;
		COLUMN_FLAG[41] = true;
	}
	public String getKnow_yh()
	{
		return know_yh;
	}
	public void setP_job(int p_job)
	{
		this.p_job=p_job;
		COLUMN_FLAG[42] = true;
	}
	public int getP_job()
	{
		return p_job;
	}
	public void setP_weixin(String p_weixin)
	{
		this.p_weixin=p_weixin;
		COLUMN_FLAG[43] = true;
	}
	public String getP_weixin()
	{
		return p_weixin;
	}
	public void setP_qq(String p_qq)
	{
		this.p_qq=p_qq;
		COLUMN_FLAG[44] = true;
	}
	public String getP_qq()
	{
		return p_qq;
	}
	public void setPhoneerror_count(int phoneerror_count)
	{
		this.phoneerror_count=phoneerror_count;
		COLUMN_FLAG[45] = true;
	}
	public int getPhoneerror_count()
	{
		return phoneerror_count;
	}
	public void setArea(int area)
	{
		this.area=area;
		COLUMN_FLAG[46] = true;
	}
	public int getArea()
	{
		return area;
	}
	public void setReal_type(int real_type)
	{
		this.real_type=real_type;
		COLUMN_FLAG[47] = true;
	}
	public int getReal_type()
	{
		return real_type;
	}
	public void setConstacterror(int constacterror)
	{
		this.constacterror=constacterror;
		COLUMN_FLAG[48] = true;
	}
	public int getConstacterror()
	{
		return constacterror;
	}
	public void setConstacterror_count(int constacterror_count)
	{
		this.constacterror_count=constacterror_count;
		COLUMN_FLAG[49] = true;
	}
	public int getConstacterror_count()
	{
		return constacterror_count;
	}
	public void setOldid(int oldid)
	{
		this.oldid=oldid;
		COLUMN_FLAG[50] = true;
	}
	public int getOldid()
	{
		return oldid;
	}
	public void setSub_site(int sub_site)
	{
		this.sub_site=sub_site;
		COLUMN_FLAG[51] = true;
	}
	public int getSub_site()
	{
		return sub_site;
	}
	public void setIs_sample(int is_sample)
	{
		this.is_sample=is_sample;
		COLUMN_FLAG[52] = true;
	}
	public int getIs_sample()
	{
		return is_sample;
	}
	public void setSample_man_id(String sample_man_id)
	{
		this.sample_man_id=sample_man_id;
		COLUMN_FLAG[53] = true;
	}
	public String getSample_man_id()
	{
		return sample_man_id;
	}
	public void setSample_man_name(String sample_man_name)
	{
		this.sample_man_name=sample_man_name;
		COLUMN_FLAG[54] = true;
	}
	public String getSample_man_name()
	{
		return sample_man_name;
	}
	public void setSample_time(Date sample_time)
	{
		this.sample_time=sample_time;
		COLUMN_FLAG[55] = true;
	}
	public Date getSample_time()
	{
		return sample_time;
	}
	public void setSample_content(String sample_content)
	{
		this.sample_content=sample_content;
		COLUMN_FLAG[56] = true;
	}
	public String getSample_content()
	{
		return sample_content;
	}
	public void setType_remark(String type_remark)
	{
		this.type_remark=type_remark;
		COLUMN_FLAG[57] = true;
	}
	public String getType_remark()
	{
		return type_remark;
	}
	public void setCzname(String czname)
	{
		this.czname=czname;
		COLUMN_FLAG[58] = true;
	}
	public String getCzname()
	{
		return czname;
	}
}
