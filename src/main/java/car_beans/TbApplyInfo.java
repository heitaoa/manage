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
	private int sex;//1-�У�2-Ů��0-����
	private String prov;//
	private String city;//
	private Date appdate;//
	private int type;//0-�������룻1-ѯ����ͼۣ�2-ԤԼ�Լ�;3-������ ��  4-С�ֿ�����315-pc ��5- С�ֿ�����315-�ֻ� ;6-��315��ҳ�˱���;8-��315 �ֻ��˱�����7-��suncars-pc  10suncars-�ֻ� 9-����΢�� 11-����-˫ʮһ�
	private int issendsms;//
	private int left_num;//
	private int is_attend;//�μӷ�ʽ 0 -δ֪ 1-�μ�-���ŵ� 2-�μ�-���е� 3-�μ�-��ʽ����  4���ܲμ� 5-���μ�
	private Date look_time;//��������ʱ��
	private int isbuy;//�Ƿ��ѹ��� int 0-δ֪ 1-�ѹ��� 2-δ����
	private Date buy_time;//����ʱ��
	private int is_key_cus;//�ص�ͻ� int 0-���ص�ͻ� 1-�ص�ͻ�
	private int phone_state;//�ֻ�״̬ int 0-��Ч����  1-��Ч���� 2-�ظ�����
	private Date order_time;//ԤԼʱ��
	private int order_state;//ԤԼ״̬ int 0-����ʱ�� 1-�Զ���ʱ��
	private int return_visit_state;//�ط�״̬ int 0-δ�ط�  1-�ѻط�
	private Date return_visit_time;//�ط�ʱ��
	private String return_visit_man;//�ط���
	private String return_visit_content;//�طü�¼
	private int again_return_visit;//�ٴλط� int 0-����Ҫ  1-��Ҫ
	private String remarks;//��ע
	private String car_info;//������Ϣ
	private String ip;//ip��ַ
	private int isdelete;//�Ƿ�ɾ��
	private int phone_prov;//�ֻ�������-ʡ
	private int phone_city;//�ֻ�������-��
	private int tuisong_flag;//0 δ���� 1- ������
	private int cus_intention;//�ͻ�����  0 �ǳ�������Խ��Խ��1 ������ʱ��μ�2 ������ʱ��μ�3 Ҫ�򣬵���̫ȷ��ʱ��4 ����Ҫ������5 δ��ͨ�����ٴε绰 6 �������


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
