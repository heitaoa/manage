package car_beans;
import java.util.*;

public class  DboPubAdschedule  implements java.io.Serializable{

	public String KEY = "sid";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int sid;//�������id
	private int adinfoid;//���λid
	private Date sdate;//��濪ʼʱ��
	private Date edate;//������ʱ��


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
