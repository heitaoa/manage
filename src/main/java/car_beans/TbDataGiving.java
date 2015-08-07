package car_beans;
import java.util.*;

public class  TbDataGiving  implements java.io.Serializable{

	public String KEY = "giving_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int giving_id;//赠品id
	private int trans_id;//购车id
	private int give_type;//赠品类型
	private int give_id;//赠品编号
	private int giving_num;//数量


	public void setGiving_id(int giving_id)
	{
		this.giving_id=giving_id;
		COLUMN_FLAG[0] = true;
	}
	public int getGiving_id()
	{
		return giving_id;
	}
	public void setTrans_id(int trans_id)
	{
		this.trans_id=trans_id;
		COLUMN_FLAG[1] = true;
	}
	public int getTrans_id()
	{
		return trans_id;
	}
	public void setGive_type(int give_type)
	{
		this.give_type=give_type;
		COLUMN_FLAG[2] = true;
	}
	public int getGive_type()
	{
		return give_type;
	}
	public void setGive_id(int give_id)
	{
		this.give_id=give_id;
		COLUMN_FLAG[3] = true;
	}
	public int getGive_id()
	{
		return give_id;
	}
	public void setGiving_num(int giving_num)
	{
		this.giving_num=giving_num;
		COLUMN_FLAG[4] = true;
	}
	public int getGiving_num()
	{
		return giving_num;
	}
}
