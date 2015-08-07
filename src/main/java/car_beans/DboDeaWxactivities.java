package car_beans;
import java.util.*;

public class  DboDeaWxactivities  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String name;//
	private int type;//
	private String intro;//
	private int eid;//
	private Date stime;//
	private Date etime;//
	private Date addtime;//
	private String url;//
	private String key;//
	private int state;//
	private int count;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[1] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[2] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setIntro(String intro)
	{
		this.intro=intro;
		COLUMN_FLAG[3] = true;
	}
	public String getIntro()
	{
		return intro;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[4] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setStime(Date stime)
	{
		this.stime=stime;
		COLUMN_FLAG[5] = true;
	}
	public Date getStime()
	{
		return stime;
	}
	public void setEtime(Date etime)
	{
		this.etime=etime;
		COLUMN_FLAG[6] = true;
	}
	public Date getEtime()
	{
		return etime;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[7] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setUrl(String url)
	{
		this.url=url;
		COLUMN_FLAG[8] = true;
	}
	public String getUrl()
	{
		return url;
	}
	public void setKey(String key)
	{
		this.key=key;
		COLUMN_FLAG[9] = true;
	}
	public String getKey()
	{
		return key;
	}
	public void setState(int state)
	{
		this.state=state;
		COLUMN_FLAG[10] = true;
	}
	public int getState()
	{
		return state;
	}
	public void setCount(int count)
	{
		this.count=count;
		COLUMN_FLAG[11] = true;
	}
	public int getCount()
	{
		return count;
	}
}
