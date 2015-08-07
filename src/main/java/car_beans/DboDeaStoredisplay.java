package car_beans;
import java.util.*;

public class  DboDeaStoredisplay  implements java.io.Serializable{

	public String KEY = "picid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false};
	private int picid;//店面展示图片自增长id
	private int sortid;//排序id
	private String title;//描述
	private String path;//图片路径
	private int isdelete;//删除标识
	private int eid;//
	private String link;//


	public void setPicid(int picid)
	{
		this.picid=picid;
		COLUMN_FLAG[0] = true;
	}
	public int getPicid()
	{
		return picid;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[1] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[2] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setPath(String path)
	{
		this.path=path;
		COLUMN_FLAG[3] = true;
	}
	public String getPath()
	{
		return path;
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
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[5] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setLink(String link)
	{
		this.link=link;
		COLUMN_FLAG[6] = true;
	}
	public String getLink()
	{
		return link;
	}
}
