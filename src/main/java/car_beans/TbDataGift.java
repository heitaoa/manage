package car_beans;
import java.util.*;

public class  TbDataGift  implements java.io.Serializable{

	public String KEY = "gift_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int gift_id;//��Ʒid
	private String gift_name;//��Ʒ����
	private String gift_price;//��Ʒ����
	private Date gift_addtime;//���ʱ��
	private int isdel;//�Ƿ�ɾ��


	public void setGift_id(int gift_id)
	{
		this.gift_id=gift_id;
		COLUMN_FLAG[0] = true;
	}
	public int getGift_id()
	{
		return gift_id;
	}
	public void setGift_name(String gift_name)
	{
		this.gift_name=gift_name;
		COLUMN_FLAG[1] = true;
	}
	public String getGift_name()
	{
		return gift_name;
	}
	public void setGift_price(String gift_price)
	{
		this.gift_price=gift_price;
		COLUMN_FLAG[2] = true;
	}
	public String getGift_price()
	{
		return gift_price;
	}
	public void setGift_addtime(Date gift_addtime)
	{
		this.gift_addtime=gift_addtime;
		COLUMN_FLAG[3] = true;
	}
	public Date getGift_addtime()
	{
		return gift_addtime;
	}
	public void setIsdel(int isdel)
	{
		this.isdel=isdel;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdel()
	{
		return isdel;
	}
}
