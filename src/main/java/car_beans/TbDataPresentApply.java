package car_beans;
import java.util.*;

public class  TbDataPresentApply  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//��Ʒ����id
	private String owner_name;//��������
	private String owner_phone;//�����ֻ�
	private String owner_carcode;//���ƺ�
	private String owner_address;//������ַ
	private String owner_idcode;//�������֤����
	private Date travelcard_date;//��ʻ֤��������
	private Date carbill_date;//������Ʊ����
	private String giftverify_img;//��Ʒȷ�ϵ�ͼƬ
	private String carbill_img;//������ƱͼƬ
	private String travelcard_img;//��ʻ֤ͼƬ
	private String idcard_img;//���֤ͼƬ
	private String car_img;//����ͼƬ
	private String engine_num;//���ܺ�
	private String vin_num;//vin���ܺ�
	private String owner_remark;//��������
	private String remark;//����������
	private int apply_state;//״̬ 0-δ��ˣ�1-���ͨ����2-���δͨ����3-��Ʒ�ѷ���
	private Date apply_date;//��������
	private int city_buy;//��������
	private int transid;//ȷ�ϵĳɽ���id
	private String postbill_code;//��ݵ���
	private int entry_type;//0-pc���������� 1-app����������
	private String order_number;//�������-Ŀǰapp��ʹ��
	private String comment;//��Ʒ��ע
	private int is_del;//�Ƿ��ѱ�ɾ��


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setOwner_name(String owner_name)
	{
		this.owner_name=owner_name;
		COLUMN_FLAG[1] = true;
	}
	public String getOwner_name()
	{
		return owner_name;
	}
	public void setOwner_phone(String owner_phone)
	{
		this.owner_phone=owner_phone;
		COLUMN_FLAG[2] = true;
	}
	public String getOwner_phone()
	{
		return owner_phone;
	}
	public void setOwner_carcode(String owner_carcode)
	{
		this.owner_carcode=owner_carcode;
		COLUMN_FLAG[3] = true;
	}
	public String getOwner_carcode()
	{
		return owner_carcode;
	}
	public void setOwner_address(String owner_address)
	{
		this.owner_address=owner_address;
		COLUMN_FLAG[4] = true;
	}
	public String getOwner_address()
	{
		return owner_address;
	}
	public void setOwner_idcode(String owner_idcode)
	{
		this.owner_idcode=owner_idcode;
		COLUMN_FLAG[5] = true;
	}
	public String getOwner_idcode()
	{
		return owner_idcode;
	}
	public void setTravelcard_date(Date travelcard_date)
	{
		this.travelcard_date=travelcard_date;
		COLUMN_FLAG[6] = true;
	}
	public Date getTravelcard_date()
	{
		return travelcard_date;
	}
	public void setCarbill_date(Date carbill_date)
	{
		this.carbill_date=carbill_date;
		COLUMN_FLAG[7] = true;
	}
	public Date getCarbill_date()
	{
		return carbill_date;
	}
	public void setGiftverify_img(String giftverify_img)
	{
		this.giftverify_img=giftverify_img;
		COLUMN_FLAG[8] = true;
	}
	public String getGiftverify_img()
	{
		return giftverify_img;
	}
	public void setCarbill_img(String carbill_img)
	{
		this.carbill_img=carbill_img;
		COLUMN_FLAG[9] = true;
	}
	public String getCarbill_img()
	{
		return carbill_img;
	}
	public void setTravelcard_img(String travelcard_img)
	{
		this.travelcard_img=travelcard_img;
		COLUMN_FLAG[10] = true;
	}
	public String getTravelcard_img()
	{
		return travelcard_img;
	}
	public void setIdcard_img(String idcard_img)
	{
		this.idcard_img=idcard_img;
		COLUMN_FLAG[11] = true;
	}
	public String getIdcard_img()
	{
		return idcard_img;
	}
	public void setCar_img(String car_img)
	{
		this.car_img=car_img;
		COLUMN_FLAG[12] = true;
	}
	public String getCar_img()
	{
		return car_img;
	}
	public void setEngine_num(String engine_num)
	{
		this.engine_num=engine_num;
		COLUMN_FLAG[13] = true;
	}
	public String getEngine_num()
	{
		return engine_num;
	}
	public void setVin_num(String vin_num)
	{
		this.vin_num=vin_num;
		COLUMN_FLAG[14] = true;
	}
	public String getVin_num()
	{
		return vin_num;
	}
	public void setOwner_remark(String owner_remark)
	{
		this.owner_remark=owner_remark;
		COLUMN_FLAG[15] = true;
	}
	public String getOwner_remark()
	{
		return owner_remark;
	}
	public void setRemark(String remark)
	{
		this.remark=remark;
		COLUMN_FLAG[16] = true;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setApply_state(int apply_state)
	{
		this.apply_state=apply_state;
		COLUMN_FLAG[17] = true;
	}
	public int getApply_state()
	{
		return apply_state;
	}
	public void setApply_date(Date apply_date)
	{
		this.apply_date=apply_date;
		COLUMN_FLAG[18] = true;
	}
	public Date getApply_date()
	{
		return apply_date;
	}
	public void setCity_buy(int city_buy)
	{
		this.city_buy=city_buy;
		COLUMN_FLAG[19] = true;
	}
	public int getCity_buy()
	{
		return city_buy;
	}
	public void setTransid(int transid)
	{
		this.transid=transid;
		COLUMN_FLAG[20] = true;
	}
	public int getTransid()
	{
		return transid;
	}
	public void setPostbill_code(String postbill_code)
	{
		this.postbill_code=postbill_code;
		COLUMN_FLAG[21] = true;
	}
	public String getPostbill_code()
	{
		return postbill_code;
	}
	public void setEntry_type(int entry_type)
	{
		this.entry_type=entry_type;
		COLUMN_FLAG[22] = true;
	}
	public int getEntry_type()
	{
		return entry_type;
	}
	public void setOrder_number(String order_number)
	{
		this.order_number=order_number;
		COLUMN_FLAG[23] = true;
	}
	public String getOrder_number()
	{
		return order_number;
	}
	public void setComment(String comment)
	{
		this.comment=comment;
		COLUMN_FLAG[24] = true;
	}
	public String getComment()
	{
		return comment;
	}
	public void setIs_del(int is_del)
	{
		this.is_del=is_del;
		COLUMN_FLAG[25] = true;
	}
	public int getIs_del()
	{
		return is_del;
	}
}
