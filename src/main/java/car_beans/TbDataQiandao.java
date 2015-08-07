package car_beans;
import java.util.*;

public class  TbDataQiandao  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//id
	private String pro_num;//项目编号
	private int baoming_id;//报名id
	private String name;//姓名
	private String phone;//电话
	private int is_reach;//是否到店
	private int is_trans;//是否成交
	private int is_invite;//是否邀约


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
	public void setBaoming_id(int baoming_id)
	{
		this.baoming_id=baoming_id;
		COLUMN_FLAG[2] = true;
	}
	public int getBaoming_id()
	{
		return baoming_id;
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
	public void setIs_reach(int is_reach)
	{
		this.is_reach=is_reach;
		COLUMN_FLAG[5] = true;
	}
	public int getIs_reach()
	{
		return is_reach;
	}
	public void setIs_trans(int is_trans)
	{
		this.is_trans=is_trans;
		COLUMN_FLAG[6] = true;
	}
	public int getIs_trans()
	{
		return is_trans;
	}
	public void setIs_invite(int is_invite)
	{
		this.is_invite=is_invite;
		COLUMN_FLAG[7] = true;
	}
	public int getIs_invite()
	{
		return is_invite;
	}
}
