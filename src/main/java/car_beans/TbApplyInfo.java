package car_beans;
import java.util.*;

public class  TbApplyInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int carid;//
	private int modelid;//
	private String name;//
	private String phone;//
	private int sex;//1-男；2-女；0-保密
	private String prov;//
	private String city;//
	private Date appdate;//
	private int type;//0-报名申请；1-询问最低价；2-预约试驾;3-特卖惠 ；  4-小胖看车团315-pc ；5- 小胖看车团315-手机 ;6-老315网页端报名;8-老315 手机端报名；7-老suncars-pc  10suncars-手机 9-车轮微信 11-车团-双十一活动
	private int issendsms;//
	private int left_num;//
	private int is_attend;//参加方式 0 -未知 1-参加-跟团到 2-参加-自行到 3-参加-方式待定  4可能参加 5-不参加
	private Date look_time;//看车车团时间
	private int isbuy;//是否已购车 int 0-未知 1-已购车 2-未购车
	private Date buy_time;//购车时间
	private int is_key_cus;//重点客户 int 0-非重点客户 1-重点客户
	private int phone_state;//手机状态 int 0-有效号码  1-无效号码 2-重复号码
	private Date order_time;//预约时间
	private int order_state;//预约状态 int 0-任意时间 1-自定义时间
	private int return_visit_state;//回访状态 int 0-未回访  1-已回访
	private Date return_visit_time;//回访时间
	private String return_visit_man;//回访人
	private String return_visit_content;//回访记录
	private int again_return_visit;//再次回访 int 0-不需要  1-需要
	private String remarks;//备注
	private String car_info;//车名信息
	private String ip;//ip地址
	private int isdelete;//是否删除
	private int phone_prov;//手机归属地-省
	private int phone_city;//手机归属地-市
	private int tuisong_flag;//0 未推送 1- 已推送
	private int cus_intention;//客户意向  0 非常紧急，越快越好1 本周有时间参加2 下周有时间参加3 要买，但不太确定时间4 不需要购买了5 未接通，需再次电话 6 其他情况


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
	public void setModelid(int modelid)
	{
		this.modelid=modelid;
		COLUMN_FLAG[2] = true;
	}
	public int getModelid()
	{
		return modelid;
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
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[4] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setSex(int sex)
	{
		this.sex=sex;
		COLUMN_FLAG[5] = true;
	}
	public int getSex()
	{
		return sex;
	}
	public void setProv(String prov)
	{
		this.prov=prov;
		COLUMN_FLAG[6] = true;
	}
	public String getProv()
	{
		return prov;
	}
	public void setCity(String city)
	{
		this.city=city;
		COLUMN_FLAG[7] = true;
	}
	public String getCity()
	{
		return city;
	}
	public void setAppdate(Date appdate)
	{
		this.appdate=appdate;
		COLUMN_FLAG[8] = true;
	}
	public Date getAppdate()
	{
		return appdate;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[9] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setIssendsms(int issendsms)
	{
		this.issendsms=issendsms;
		COLUMN_FLAG[10] = true;
	}
	public int getIssendsms()
	{
		return issendsms;
	}
	public void setLeft_num(int left_num)
	{
		this.left_num=left_num;
		COLUMN_FLAG[11] = true;
	}
	public int getLeft_num()
	{
		return left_num;
	}
	public void setIs_attend(int is_attend)
	{
		this.is_attend=is_attend;
		COLUMN_FLAG[12] = true;
	}
	public int getIs_attend()
	{
		return is_attend;
	}
	public void setLook_time(Date look_time)
	{
		this.look_time=look_time;
		COLUMN_FLAG[13] = true;
	}
	public Date getLook_time()
	{
		return look_time;
	}
	public void setIsbuy(int isbuy)
	{
		this.isbuy=isbuy;
		COLUMN_FLAG[14] = true;
	}
	public int getIsbuy()
	{
		return isbuy;
	}
	public void setBuy_time(Date buy_time)
	{
		this.buy_time=buy_time;
		COLUMN_FLAG[15] = true;
	}
	public Date getBuy_time()
	{
		return buy_time;
	}
	public void setIs_key_cus(int is_key_cus)
	{
		this.is_key_cus=is_key_cus;
		COLUMN_FLAG[16] = true;
	}
	public int getIs_key_cus()
	{
		return is_key_cus;
	}
	public void setPhone_state(int phone_state)
	{
		this.phone_state=phone_state;
		COLUMN_FLAG[17] = true;
	}
	public int getPhone_state()
	{
		return phone_state;
	}
	public void setOrder_time(Date order_time)
	{
		this.order_time=order_time;
		COLUMN_FLAG[18] = true;
	}
	public Date getOrder_time()
	{
		return order_time;
	}
	public void setOrder_state(int order_state)
	{
		this.order_state=order_state;
		COLUMN_FLAG[19] = true;
	}
	public int getOrder_state()
	{
		return order_state;
	}
	public void setReturn_visit_state(int return_visit_state)
	{
		this.return_visit_state=return_visit_state;
		COLUMN_FLAG[20] = true;
	}
	public int getReturn_visit_state()
	{
		return return_visit_state;
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
	public void setReturn_visit_man(String return_visit_man)
	{
		this.return_visit_man=return_visit_man;
		COLUMN_FLAG[22] = true;
	}
	public String getReturn_visit_man()
	{
		return return_visit_man;
	}
	public void setReturn_visit_content(String return_visit_content)
	{
		this.return_visit_content=return_visit_content;
		COLUMN_FLAG[23] = true;
	}
	public String getReturn_visit_content()
	{
		return return_visit_content;
	}
	public void setAgain_return_visit(int again_return_visit)
	{
		this.again_return_visit=again_return_visit;
		COLUMN_FLAG[24] = true;
	}
	public int getAgain_return_visit()
	{
		return again_return_visit;
	}
	public void setRemarks(String remarks)
	{
		this.remarks=remarks;
		COLUMN_FLAG[25] = true;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setCar_info(String car_info)
	{
		this.car_info=car_info;
		COLUMN_FLAG[26] = true;
	}
	public String getCar_info()
	{
		return car_info;
	}
	public void setIp(String ip)
	{
		this.ip=ip;
		COLUMN_FLAG[27] = true;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[28] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setPhone_prov(int phone_prov)
	{
		this.phone_prov=phone_prov;
		COLUMN_FLAG[29] = true;
	}
	public int getPhone_prov()
	{
		return phone_prov;
	}
	public void setPhone_city(int phone_city)
	{
		this.phone_city=phone_city;
		COLUMN_FLAG[30] = true;
	}
	public int getPhone_city()
	{
		return phone_city;
	}
	public void setTuisong_flag(int tuisong_flag)
	{
		this.tuisong_flag=tuisong_flag;
		COLUMN_FLAG[31] = true;
	}
	public int getTuisong_flag()
	{
		return tuisong_flag;
	}
	public void setCus_intention(int cus_intention)
	{
		this.cus_intention=cus_intention;
		COLUMN_FLAG[32] = true;
	}
	public int getCus_intention()
	{
		return cus_intention;
	}
}
