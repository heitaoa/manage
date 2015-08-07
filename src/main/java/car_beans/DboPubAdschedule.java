package car_beans;
import java.util.*;

public class  DboPubAdschedule  implements java.io.Serializable{

	public String KEY = "sid";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int sid;//广告排期id
	private int adinfoid;//广告位id
	private Date sdate;//广告开始时间
	private Date edate;//广告结束时间


	public void setSid(int sid)
	{
		this.sid=sid;
		COLUMN_FLAG[0] = true;
	}
	public int getSid()
	{
		return sid;
	}
	public void setAdinfoid(int adinfoid)
	{
		this.adinfoid=adinfoid;
		COLUMN_FLAG[1] = true;
	}
	public int getAdinfoid()
	{
		return adinfoid;
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
}
