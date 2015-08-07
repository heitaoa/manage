package car_beans;
import java.util.*;

public class  DboDeaWxactjoin  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private String openid;//微信用户对当前公众号唯一id
	private int pid;//奖品
	private int aid;//活动
	private Date adddate;//
	private int count;//数量


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setOpenid(String openid)
	{
		this.openid=openid;
		COLUMN_FLAG[1] = true;
	}
	public String getOpenid()
	{
		return openid;
	}
	public void setPid(int pid)
	{
		this.pid=pid;
		COLUMN_FLAG[2] = true;
	}
	public int getPid()
	{
		return pid;
	}
	public void setAid(int aid)
	{
		this.aid=aid;
		COLUMN_FLAG[3] = true;
	}
	public int getAid()
	{
		return aid;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[4] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setCount(int count)
	{
		this.count=count;
		COLUMN_FLAG[5] = true;
	}
	public int getCount()
	{
		return count;
	}
}
