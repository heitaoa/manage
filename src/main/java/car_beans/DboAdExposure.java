package car_beans;
import java.util.*;

public class  DboAdExposure  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false};
	private int id;//曝光id
	private String url;//广告曝光链接
	private Date sdate;//曝光开始时间
	private Date edate;//
	private int count;//生成iframe个数
	private int isdelete;//状态，0表示未删除，1表示删除
	private String title;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUrl(String url)
	{
		this.url=url;
		COLUMN_FLAG[1] = true;
	}
	public String getUrl()
	{
		return url;
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
	public void setCount(int count)
	{
		this.count=count;
		COLUMN_FLAG[4] = true;
	}
	public int getCount()
	{
		return count;
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
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[6] = true;
	}
	public String getTitle()
	{
		return title;
	}
}
