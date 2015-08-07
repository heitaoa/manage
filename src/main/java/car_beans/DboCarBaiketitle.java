package car_beans;
import java.util.*;

public class  DboCarBaiketitle  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private int hascontent;//
	private int isdelete;//
	private Date addtime;//
	private Date uptime;//
	private String title;//
	private String photourl;//
	private String baikecontent;//
	private int hotlevel;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setHascontent(int hascontent)
	{
		this.hascontent=hascontent;
		COLUMN_FLAG[1] = true;
	}
	public int getHascontent()
	{
		return hascontent;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[2] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[3] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setUptime(Date uptime)
	{
		this.uptime=uptime;
		COLUMN_FLAG[4] = true;
	}
	public Date getUptime()
	{
		return uptime;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[5] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setPhotourl(String photourl)
	{
		this.photourl=photourl;
		COLUMN_FLAG[6] = true;
	}
	public String getPhotourl()
	{
		return photourl;
	}
	public void setBaikecontent(String baikecontent)
	{
		this.baikecontent=baikecontent;
		COLUMN_FLAG[7] = true;
	}
	public String getBaikecontent()
	{
		return baikecontent;
	}
	public void setHotlevel(int hotlevel)
	{
		this.hotlevel=hotlevel;
		COLUMN_FLAG[8] = true;
	}
	public int getHotlevel()
	{
		return hotlevel;
	}
}
