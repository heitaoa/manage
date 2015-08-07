package car_beans;
import java.util.*;

public class  TbDataTransInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//id
	private String pro_num;//��Ŀ���
	private String name;//����
	private String phone;//�绰
	private String plate;//���ƺ�
	private String addr;//��ַ
	private int model;//�ɽ�����
	private Date trans_date;//��������
	private String trans_price;//�ɽ��۸�
	private String engine_num;//���������
	private String vin_num;//vin���ܺ�
	private String giving_code;//��Ʒcode(0-1,0-2,1-1,1-2)���Ÿ�������-����֮ǰ��ʾ��Ʒ���ͣ�0��ʾ�����1��ʾ��Ʒ����-����֮���ʾ��Ʒid
	private String giving_name;//��Ʒ����
	private int is_giving_send;//��Ʒ�Ƿ��ͳ�(0-δ�ͳ���1-���ͳ�)
	private int qiandao_id;//ǩ��id
	private String sale_man;//ǩ������
	private String giving_total_price;//��Ʒ�ܼ�
	private int gift_examine_state;//��Ʒ���״̬(0-δ��ˣ�1-���ͨ����2-���أ�


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
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
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[2] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[3] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPlate(String plate)
	{
		this.plate=plate;
		COLUMN_FLAG[4] = true;
	}
	public String getPlate()
	{
		return plate;
	}
	public void setAddr(String addr)
	{
		this.addr=addr;
		COLUMN_FLAG[5] = true;
	}
	public String getAddr()
	{
		return addr;
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
	public void setTrans_date(Date trans_date)
	{
		this.trans_date=trans_date;
		COLUMN_FLAG[7] = true;
	}
	public Date getTrans_date()
	{
		return trans_date;
	}
	public void setTrans_price(String trans_price)
	{
		this.trans_price=trans_price;
		COLUMN_FLAG[8] = true;
	}
	public String getTrans_price()
	{
		return trans_price;
	}
	public void setEngine_num(String engine_num)
	{
		this.engine_num=engine_num;
		COLUMN_FLAG[9] = true;
	}
	public String getEngine_num()
	{
		return engine_num;
	}
	public void setVin_num(String vin_num)
	{
		this.vin_num=vin_num;
		COLUMN_FLAG[10] = true;
	}
	public String getVin_num()
	{
		return vin_num;
	}
	public void setGiving_code(String giving_code)
	{
		this.giving_code=giving_code;
		COLUMN_FLAG[11] = true;
	}
	public String getGiving_code()
	{
		return giving_code;
	}
	public void setGiving_name(String giving_name)
	{
		this.giving_name=giving_name;
		COLUMN_FLAG[12] = true;
	}
	public String getGiving_name()
	{
		return giving_name;
	}
	public void setIs_giving_send(int is_giving_send)
	{
		this.is_giving_send=is_giving_send;
		COLUMN_FLAG[13] = true;
	}
	public int getIs_giving_send()
	{
		return is_giving_send;
	}
	public void setQiandao_id(int qiandao_id)
	{
		this.qiandao_id=qiandao_id;
		COLUMN_FLAG[14] = true;
	}
	public int getQiandao_id()
	{
		return qiandao_id;
	}
	public void setSale_man(String sale_man)
	{
		this.sale_man=sale_man;
		COLUMN_FLAG[15] = true;
	}
	public String getSale_man()
	{
		return sale_man;
	}
	public void setGiving_total_price(String giving_total_price)
	{
		this.giving_total_price=giving_total_price;
		COLUMN_FLAG[16] = true;
	}
	public String getGiving_total_price()
	{
		return giving_total_price;
	}
	public void setGift_examine_state(int gift_examine_state)
	{
		this.gift_examine_state=gift_examine_state;
		COLUMN_FLAG[17] = true;
	}
	public int getGift_examine_state()
	{
		return gift_examine_state;
	}
}
