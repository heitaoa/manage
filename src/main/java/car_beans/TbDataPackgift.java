package car_beans;
import java.util.*;

public class  TbDataPackgift  implements java.io.Serializable{

	public String KEY = "packgift_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int packgift_id;//礼包id
	private int package_id;//礼包id
	private int gift_id;//礼品id
	private int gift_num;//礼品数量


	public void setPackgift_id(int packgift_id)
	{
		this.packgift_id=packgift_id;
		COLUMN_FLAG[0] = true;
	}
	public int getPackgift_id()
	{
		return packgift_id;
	}
	public void setPackage_id(int package_id)
	{
		this.package_id=package_id;
		COLUMN_FLAG[1] = true;
	}
	public int getPackage_id()
	{
		return package_id;
	}
	public void setGift_id(int gift_id)
	{
		this.gift_id=gift_id;
		COLUMN_FLAG[2] = true;
	}
	public int getGift_id()
	{
		return gift_id;
	}
	public void setGift_num(int gift_num)
	{
		this.gift_num=gift_num;
		COLUMN_FLAG[3] = true;
	}
	public int getGift_num()
	{
		return gift_num;
	}
}
