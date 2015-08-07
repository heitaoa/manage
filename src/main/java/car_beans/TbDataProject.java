package car_beans;
import java.util.*;

public class  TbDataProject  implements java.io.Serializable{

	public String KEY = "pro_num";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private String pro_num;//项目编号
	private String ini_man;//发起人
	private int ini_dept;//发起部门
	private int ini_org;//发起站点
	private Date ini_date;//发起日期
	private int service_type;//业务类型(0-看车团，1-直销，2-车展，3-大客户,4-经销商,5-其他)
	private String contact_num;//关联合同号
	private String acti_name;//活动名称
	private int brand;//品牌
	private int car;//车系
	private int model;//车型
	private String promo_area;//推广区域
	private int promo_prov;//推广省份 -1 代表全国
	private int promo_city;//推广城市 -1代表该省份下所有城市
	private String promo_man;//推广人
	private Date promo_start_date;//推广开始日期
	private Date promo_end_date;//推广结束日期
	private Date contact_start_date;//合同开始日期
	private Date contact_end_date;//合同结束日期
	private Date acti_start_date;//活动开始日期
	private String cust_name;//客户名称
	private int tar_clue_num;//目标线索量
	private int tar_reach_num;//目标到达量
	private int tar_trans_num;//目标成交量
	private String custom_service;//责任客服(用逗号隔开)
	private int pro_state;//项目状态(0-未审核、1-业务通过、2-业务驳回、3-推广部通过、4-推广部驳回,5-已结束,100-品牌项目默认状态)
	private Date acti_end_date;//活动结束时间
	private String competing;//竞品(品牌-车系，品牌-车系）
	private String data_source;//经销商指定数据源（省a市a品牌a车系）用逗号隔开
	private String custom_service_name;//客服姓名(逗号隔开)
	private String competing_name;//竞品名称(品牌-车系)逗号隔开
	private String data_source_name;//数据源名称(逗号隔开)
	private String iway;//渠道


	public void setPro_num(String pro_num)
	{
		this.pro_num=pro_num;
		COLUMN_FLAG[0] = true;
	}
	public String getPro_num()
	{
		return pro_num;
	}
	public void setIni_man(String ini_man)
	{
		this.ini_man=ini_man;
		COLUMN_FLAG[1] = true;
	}
	public String getIni_man()
	{
		return ini_man;
	}
	public void setIni_dept(int ini_dept)
	{
		this.ini_dept=ini_dept;
		COLUMN_FLAG[2] = true;
	}
	public int getIni_dept()
	{
		return ini_dept;
	}
	public void setIni_org(int ini_org)
	{
		this.ini_org=ini_org;
		COLUMN_FLAG[3] = true;
	}
	public int getIni_org()
	{
		return ini_org;
	}
	public void setIni_date(Date ini_date)
	{
		this.ini_date=ini_date;
		COLUMN_FLAG[4] = true;
	}
	public Date getIni_date()
	{
		return ini_date;
	}
	public void setService_type(int service_type)
	{
		this.service_type=service_type;
		COLUMN_FLAG[5] = true;
	}
	public int getService_type()
	{
		return service_type;
	}
	public void setContact_num(String contact_num)
	{
		this.contact_num=contact_num;
		COLUMN_FLAG[6] = true;
	}
	public String getContact_num()
	{
		return contact_num;
	}
	public void setActi_name(String acti_name)
	{
		this.acti_name=acti_name;
		COLUMN_FLAG[7] = true;
	}
	public String getActi_name()
	{
		return acti_name;
	}
	public void setBrand(int brand)
	{
		this.brand=brand;
		COLUMN_FLAG[8] = true;
	}
	public int getBrand()
	{
		return brand;
	}
	public void setCar(int car)
	{
		this.car=car;
		COLUMN_FLAG[9] = true;
	}
	public int getCar()
	{
		return car;
	}
	public void setModel(int model)
	{
		this.model=model;
		COLUMN_FLAG[10] = true;
	}
	public int getModel()
	{
		return model;
	}
	public void setPromo_area(String promo_area)
	{
		this.promo_area=promo_area;
		COLUMN_FLAG[11] = true;
	}
	public String getPromo_area()
	{
		return promo_area;
	}
	public void setPromo_prov(int promo_prov)
	{
		this.promo_prov=promo_prov;
		COLUMN_FLAG[12] = true;
	}
	public int getPromo_prov()
	{
		return promo_prov;
	}
	public void setPromo_city(int promo_city)
	{
		this.promo_city=promo_city;
		COLUMN_FLAG[13] = true;
	}
	public int getPromo_city()
	{
		return promo_city;
	}
	public void setPromo_man(String promo_man)
	{
		this.promo_man=promo_man;
		COLUMN_FLAG[14] = true;
	}
	public String getPromo_man()
	{
		return promo_man;
	}
	public void setPromo_start_date(Date promo_start_date)
	{
		this.promo_start_date=promo_start_date;
		COLUMN_FLAG[15] = true;
	}
	public Date getPromo_start_date()
	{
		return promo_start_date;
	}
	public void setPromo_end_date(Date promo_end_date)
	{
		this.promo_end_date=promo_end_date;
		COLUMN_FLAG[16] = true;
	}
	public Date getPromo_end_date()
	{
		return promo_end_date;
	}
	public void setContact_start_date(Date contact_start_date)
	{
		this.contact_start_date=contact_start_date;
		COLUMN_FLAG[17] = true;
	}
	public Date getContact_start_date()
	{
		return contact_start_date;
	}
	public void setContact_end_date(Date contact_end_date)
	{
		this.contact_end_date=contact_end_date;
		COLUMN_FLAG[18] = true;
	}
	public Date getContact_end_date()
	{
		return contact_end_date;
	}
	public void setActi_start_date(Date acti_start_date)
	{
		this.acti_start_date=acti_start_date;
		COLUMN_FLAG[19] = true;
	}
	public Date getActi_start_date()
	{
		return acti_start_date;
	}
	public void setCust_name(String cust_name)
	{
		this.cust_name=cust_name;
		COLUMN_FLAG[20] = true;
	}
	public String getCust_name()
	{
		return cust_name;
	}
	public void setTar_clue_num(int tar_clue_num)
	{
		this.tar_clue_num=tar_clue_num;
		COLUMN_FLAG[21] = true;
	}
	public int getTar_clue_num()
	{
		return tar_clue_num;
	}
	public void setTar_reach_num(int tar_reach_num)
	{
		this.tar_reach_num=tar_reach_num;
		COLUMN_FLAG[22] = true;
	}
	public int getTar_reach_num()
	{
		return tar_reach_num;
	}
	public void setTar_trans_num(int tar_trans_num)
	{
		this.tar_trans_num=tar_trans_num;
		COLUMN_FLAG[23] = true;
	}
	public int getTar_trans_num()
	{
		return tar_trans_num;
	}
	public void setCustom_service(String custom_service)
	{
		this.custom_service=custom_service;
		COLUMN_FLAG[24] = true;
	}
	public String getCustom_service()
	{
		return custom_service;
	}
	public void setPro_state(int pro_state)
	{
		this.pro_state=pro_state;
		COLUMN_FLAG[25] = true;
	}
	public int getPro_state()
	{
		return pro_state;
	}
	public void setActi_end_date(Date acti_end_date)
	{
		this.acti_end_date=acti_end_date;
		COLUMN_FLAG[26] = true;
	}
	public Date getActi_end_date()
	{
		return acti_end_date;
	}
	public void setCompeting(String competing)
	{
		this.competing=competing;
		COLUMN_FLAG[27] = true;
	}
	public String getCompeting()
	{
		return competing;
	}
	public void setData_source(String data_source)
	{
		this.data_source=data_source;
		COLUMN_FLAG[28] = true;
	}
	public String getData_source()
	{
		return data_source;
	}
	public void setCustom_service_name(String custom_service_name)
	{
		this.custom_service_name=custom_service_name;
		COLUMN_FLAG[29] = true;
	}
	public String getCustom_service_name()
	{
		return custom_service_name;
	}
	public void setCompeting_name(String competing_name)
	{
		this.competing_name=competing_name;
		COLUMN_FLAG[30] = true;
	}
	public String getCompeting_name()
	{
		return competing_name;
	}
	public void setData_source_name(String data_source_name)
	{
		this.data_source_name=data_source_name;
		COLUMN_FLAG[31] = true;
	}
	public String getData_source_name()
	{
		return data_source_name;
	}
	public void setIway(String iway)
	{
		this.iway=iway;
		COLUMN_FLAG[32] = true;
	}
	public String getIway()
	{
		return iway;
	}
}
