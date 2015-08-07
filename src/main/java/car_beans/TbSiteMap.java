package car_beans;
import java.util.*;

public class  TbSiteMap  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private String loc;//
	private Date lastmod;//
	private String priority;//
	private String changefreq;//
	private int domain;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setLoc(String loc)
	{
		this.loc=loc;
		COLUMN_FLAG[1] = true;
	}
	public String getLoc()
	{
		return loc;
	}
	public void setLastmod(Date lastmod)
	{
		this.lastmod=lastmod;
		COLUMN_FLAG[2] = true;
	}
	public Date getLastmod()
	{
		return lastmod;
	}
	public void setPriority(String priority)
	{
		this.priority=priority;
		COLUMN_FLAG[3] = true;
	}
	public String getPriority()
	{
		return priority;
	}
	public void setChangefreq(String changefreq)
	{
		this.changefreq=changefreq;
		COLUMN_FLAG[4] = true;
	}
	public String getChangefreq()
	{
		return changefreq;
	}
	public void setDomain(int domain)
	{
		this.domain=domain;
		COLUMN_FLAG[5] = true;
	}
	public int getDomain()
	{
		return domain;
	}
}
