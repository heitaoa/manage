package car_beans;
import java.util.*;

public class  TbApplyCount  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//1-从小胖拉取数据 2-从新315拉取数据 3-从易车拉取数据（团购） 4-从易车拉取数据（活动） 5-从老315拉取手机报名数据 9-拉取suncars数据推送至经销商 10-经销商发送信息标识位
	private int max_dbid;//
	private int max_315id;//
	private Date last_update_time;//
	private int islock;//0-未加锁  1-已加锁  


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setMax_dbid(int max_dbid)
	{
		this.max_dbid=max_dbid;
		COLUMN_FLAG[1] = true;
	}
	public int getMax_dbid()
	{
		return max_dbid;
	}
	public void setMax_315id(int max_315id)
	{
		this.max_315id=max_315id;
		COLUMN_FLAG[2] = true;
	}
	public int getMax_315id()
	{
		return max_315id;
	}
	public void setLast_update_time(Date last_update_time)
	{
		this.last_update_time=last_update_time;
		COLUMN_FLAG[3] = true;
	}
	public Date getLast_update_time()
	{
		return last_update_time;
	}
	public void setIslock(int islock)
	{
		this.islock=islock;
		COLUMN_FLAG[4] = true;
	}
	public int getIslock()
	{
		return islock;
	}
}
