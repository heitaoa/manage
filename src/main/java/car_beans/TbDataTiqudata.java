package car_beans;
import java.util.*;

public class  TbDataTiqudata  implements java.io.Serializable{

	public String KEY = "tiqu_num";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private String tiqu_num;//��Ŀ���
	private String ini_man;//������
	private int ini_dept;//������
	private int ini_org;//����վ��
	private Date ini_date;//����ʱ��
	private String contact_num;//������ͬ��
	private String contact_money;//��ͬ���
	private Date contact_start_date;//��ͬ��ʼ����
	private Date contact_end_date;//��ͬ��������
	private String cust_name;//�ͻ�����
	private int brand;//Ʒ��
	private int car;//��ϵ
	private int prov;//�ƹ�ʡ�� -1 ����ȫ��
	private int city;//�ƹ���� -1�����ʡ�������г���
	private int data_count;//����������
	private Date data_start_date;//�������ڿ�ʼ����
	private Date data_end_date;//�������ڽ�������
	private int is_agree_deduct;//�Ƿ�ͬ��۳�ִ�н��
	private String apply_cause;//����ԭ��
	private int is_deduct;//�Ƿ�۳�ִ�н��--�߲���˽��
	private int examine_state;//���״̬(0-δ��ˡ�1-����ͨ����2-���ܲ��ء�3-�߲�ͨ����4-�߲㲵��)
	private String deny_cause;//
	private int tiqu_state;//��ȡ״̬(0-δ������1-ͬ��ִ�С�2-ȡ��ִ�С�3-��ִ��)
	private int export_count;//���ݵ�������


	public void setTiqu_num(String tiqu_num)
	{
		this.tiqu_num=tiqu_num;
		COLUMN_FLAG[0] = true;
	}
	public String getTiqu_num()
	{
		return tiqu_num;
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
	public void setContact_num(String contact_num)
	{
		this.contact_num=contact_num;
		COLUMN_FLAG[5] = true;
	}
	public String getContact_num()
	{
		return contact_num;
	}
	public void setContact_money(String contact_money)
	{
		this.contact_money=contact_money;
		COLUMN_FLAG[6] = true;
	}
	public String getContact_money()
	{
		return contact_money;
	}
	public void setContact_start_date(Date contact_start_date)
	{
		this.contact_start_date=contact_start_date;
		COLUMN_FLAG[7] = true;
	}
	public Date getContact_start_date()
	{
		return contact_start_date;
	}
	public void setContact_end_date(Date contact_end_date)
	{
		this.contact_end_date=contact_end_date;
		COLUMN_FLAG[8] = true;
	}
	public Date getContact_end_date()
	{
		return contact_end_date;
	}
	public void setCust_name(String cust_name)
	{
		this.cust_name=cust_name;
		COLUMN_FLAG[9] = true;
	}
	public String getCust_name()
	{
		return cust_name;
	}
	public void setBrand(int brand)
	{
		this.brand=brand;
		COLUMN_FLAG[10] = true;
	}
	public int getBrand()
	{
		return brand;
	}
	public void setCar(int car)
	{
		this.car=car;
		COLUMN_FLAG[11] = true;
	}
	public int getCar()
	{
		return car;
	}
	public void setProv(int prov)
	{
		this.prov=prov;
		COLUMN_FLAG[12] = true;
	}
	public int getProv()
	{
		return prov;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[13] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setData_count(int data_count)
	{
		this.data_count=data_count;
		COLUMN_FLAG[14] = true;
	}
	public int getData_count()
	{
		return data_count;
	}
	public void setData_start_date(Date data_start_date)
	{
		this.data_start_date=data_start_date;
		COLUMN_FLAG[15] = true;
	}
	public Date getData_start_date()
	{
		return data_start_date;
	}
	public void setData_end_date(Date data_end_date)
	{
		this.data_end_date=data_end_date;
		COLUMN_FLAG[16] = true;
	}
	public Date getData_end_date()
	{
		return data_end_date;
	}
	public void setIs_agree_deduct(int is_agree_deduct)
	{
		this.is_agree_deduct=is_agree_deduct;
		COLUMN_FLAG[17] = true;
	}
	public int getIs_agree_deduct()
	{
		return is_agree_deduct;
	}
	public void setApply_cause(String apply_cause)
	{
		this.apply_cause=apply_cause;
		COLUMN_FLAG[18] = true;
	}
	public String getApply_cause()
	{
		return apply_cause;
	}
	public void setIs_deduct(int is_deduct)
	{
		this.is_deduct=is_deduct;
		COLUMN_FLAG[19] = true;
	}
	public int getIs_deduct()
	{
		return is_deduct;
	}
	public void setExamine_state(int examine_state)
	{
		this.examine_state=examine_state;
		COLUMN_FLAG[20] = true;
	}
	public int getExamine_state()
	{
		return examine_state;
	}
	public void setDeny_cause(String deny_cause)
	{
		this.deny_cause=deny_cause;
		COLUMN_FLAG[21] = true;
	}
	public String getDeny_cause()
	{
		return deny_cause;
	}
	public void setTiqu_state(int tiqu_state)
	{
		this.tiqu_state=tiqu_state;
		COLUMN_FLAG[22] = true;
	}
	public int getTiqu_state()
	{
		return tiqu_state;
	}
	public void setExport_count(int export_count)
	{
		this.export_count=export_count;
		COLUMN_FLAG[23] = true;
	}
	public int getExport_count()
	{
		return export_count;
	}
}
