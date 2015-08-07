package car_beans;
import java.util.*;

public class  TbDataVisitRecord  implements java.io.Serializable{

	public String KEY = "record_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int record_id;//����id
	private String pro_num;//��Ŀ���
	private String phone;//�ֻ���
	private String name;//����
	private int baoming_id;//����id
	private int return_visit_state;//�ط�״̬ 0-δ�ط� 1-һ�� 2-���� 3-���� 4- ����
	private int is_key_cus;//�ͻ����� 0-��ͨ�ͻ� 1-�ص�ͻ�
	private int phoneerror;//�绰�ܷ��ͨ  0-�ѽ�ͨ 1-δ��ͨ
	private Date return_visit_time;//�ط�ʱ��
	private String return_visit_content;//�ط�����
	private String return_visit_man;//�ط�������
	private int tuisong_flag;//�Ƿ����� 0- δ���� 1- ������
	private int attend_type;//���ŷ�ʽ 0-�޲�����1-�μӣ����ŵ� 2-�μӣ����е� 3-�μӣ���ȷ�� 4-���ܲμ� 5-���μ�
	private String attend_date;//��������
	private int phone_state;//�ֻ�״̬ 0-��Ч 1-��Ч 2-�ظ�����
	private int is_jp;//�Ƿ��о�Ʒ  0-�� 1-��
	private String jp_car;//��Ʒ��ϵ
	private int is_buycar;//�Ƿ񹺳� 0-�� 1-��
	private int buy_state;//������� 0-�³�ȫ�� 1-�³����� 2-�û�ȫ�� 3-��������
	private int phoneerror_count;//�绰δ��������
	private int is_reach;//�Ƿ񵽵�
	private int is_trans;//�Ƿ�ɽ�
	private int is_invite;//�Ƿ���Լ
	private int brand;//Ʒ��id
	private int serial;//������ϵid
	private int model;//����id
	private int phone_prov;//�ֻ�ʡ
	private int phone_city;//�ֻ���
	private String ip;//ip��ַ
	private int prov;//����ʡ��
	private int city;//��������
	private int buycar_emergency;//0-δ֪ 1-���� 2-2���� 3-һ������ 4-3������ 5-3�������� 6 -��ʱ
	private String pp_state;//����״̬
	private String pz_city;//���ճ���
	private String buy_ys;//����Ԥ��
	private int buy_bsx;//������ 0-�Զ� 1-�ֶ� 2-����
	private String buy_pl;//����
	private String buy_color;//��ɫ
	private String know_yh;//4s�˽��Ż�
	private int p_job;//ְҵ 0-���� 1-˽�� 2-����
	private String p_weixin;//΢��
	private String p_qq;//qq
	private Date baoming_date;//����ʱ��
	private String bz;//��ע
	private int require;//�������(0-����,2-���գ�3-����)
	private int research;//�Ƿ���ܵ��� 0-��ѡ�� 1-�� 2-��
	private String not_store_reason;//δ����ԭ��
	private int lose_reason;//ʧ��ԭ�� 0-��ѡ�� 1-�۸񲻵�λ 2-4s����� 3-û���ֳ� 4-�ͻ���Ʒ�Ƚ��� 5-4s������Զ 6-����û���� 7-����û�ĵ� 8-����ղ����� 9-С�ַ����ܵ�
	private int satisfy;//��������� 0-δѡ�� 1-���� 2-һ�� 3-������
	private String advise;//���������
	private Date satisfy_date;//���������ʱ��
	private int satisfy_state;//���� 0-δ���� 1-������


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