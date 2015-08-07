package car_beans;
import java.util.*;

public class  DboAdPopad  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int id;//弹出广告自增长id
	private int adid;//来源广告id
	private int poptotaltimes;//最大弹出次数
	private int remaintimes;//剩余弹出次数
	private String adstr;//弹出广告代码
	private int isdelete;//删除标识
	private String jsstr;//
	private Date scheduledday;//
	private int totalclick;//
	private String adtitle;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setAdid(int adid)
	{
		this.adid=adid;
		COLUMN_FLAG[1] = true;
	}
	public int getAdid()
	{
		return adid;
	}
	public void setPoptotaltimes(int poptotaltimes)
	{
		this.poptotaltimes=poptotaltimes;
		COLUMN_FLAG[2] = true;
	}
	public int getPoptotaltimes()
	{
		return poptotaltimes;
	}
	public void setRemaintimes(int remaintimes)
	{
		this.remaintimes=remaintimes;
		COLUMN_FLAG[3] = true;
	}
	public int getRemaintimes()
	{
		return remaintimes;
	}
	public void setAdstr(String adstr)
	{
		this.adstr=adstr;
		COLUMN_FLAG[4] = true;
	}
	public String getAdstr()
	{
		return adstr;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[5] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setJsstr(String jsstr)
	{
		this.jsstr=jsstr;
		COLUMN_FLAG[6] = true;
	}
	public String getJsstr()
	{
		return jsstr;
	}
	public void setScheduledday(Date scheduledday)
	{
		this.scheduledday=scheduledday;
		COLUMN_FLAG[7] = true;
	}
	public Date getScheduledday()
	{
		return scheduledday;
	}
	public void setTotalclick(int totalclick)
	{
		this.totalclick=totalclick;
		COLUMN_FLAG[8] = true;
	}
	public int getTotalclick()
	{
		return totalclick;
	}
	public void setAdtitle(String adtitle)
	{
		this.adtitle=adtitle;
		COLUMN_FLAG[9] = true;
	}
	public String getAdtitle()
	{
		return adtitle;
	}
}
