package car_beans;
import java.util.*;

public class  DboAdPopadschedule  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//弹出广告日期安排表自增长id
	private int popaid;//弹出广告id
	private Date sdate;//起始日期
	private Date edate;//结束日期
	private int isdelete;//删除标识


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setPopaid(int popaid)
	{
		this.popaid=popaid;
		COLUMN_FLAG[1] = true;
	}
	public int getPopaid()
	{
		return popaid;
	}
	public void setSdate(Date sdate)
	{
		this.sdate=sdate;
		COLUMN_FLAG[2] = true;
	}
	public Date getSdate()
	{
		return sdate;
	}
	public void setEdate(Date edate)
	{
		this.edate=edate;
		COLUMN_FLAG[3] = true;
	}
	public Date getEdate()
	{
		return edate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
}
