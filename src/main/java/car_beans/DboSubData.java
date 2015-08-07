package car_beans;
import java.util.*;

public class  DboSubData  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int sid;//
	private String title;//
	private String content;//
	private String pic;//
	private String link;//
	private String ctitle;//目录名
	private String clink;//目录连接
	private String color;//控制标题颜色
	private int bold;//标题是否加粗
	private Date adddate;//
	private int isdelete;//
	private int sortid;//
	private String link_back;//
	private String clink_back;//
	private int isad;//是否是广告
	private int sync_id;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setSid(int sid)
	{
		this.sid=sid;
		COLUMN_FLAG[1] = true;
	}
	public int getSid()
	{
		return sid;
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
	public void setContent(String content)
	{
		this.content=content;
		COLUMN_FLAG[3] = true;
	}
	public String getContent()
	{
		return content;
	}
	public void setPic(String pic)
	{
		this.pic=pic;
		COLUMN_FLAG[4] = true;
	}
	public String getPic()
	{
		return pic;
	}
	public void setLink(String link)
	{
		this.link=link;
		COLUMN_FLAG[5] = true;
	}
	public String getLink()
	{
		return link;
	}
	public void setCtitle(String ctitle)
	{
		this.ctitle=ctitle;
		COLUMN_FLAG[6] = true;
	}
	public String getCtitle()
	{
		return ctitle;
	}
	public void setClink(String clink)
	{
		this.clink=clink;
		COLUMN_FLAG[7] = true;
	}
	public String getClink()
	{
		return clink;
	}
	public void setColor(String color)
	{
		this.color=color;
		COLUMN_FLAG[8] = true;
	}
	public String getColor()
	{
		return color;
	}
	public void setBold(int bold)
	{
		this.bold=bold;
		COLUMN_FLAG[9] = true;
	}
	public int getBold()
	{
		return bold;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[10] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[11] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[12] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setLink_back(String link_back)
	{
		this.link_back=link_back;
		COLUMN_FLAG[13] = true;
	}
	public String getLink_back()
	{
		return link_back;
	}
	public void setClink_back(String clink_back)
	{
		this.clink_back=clink_back;
		COLUMN_FLAG[14] = true;
	}
	public String getClink_back()
	{
		return clink_back;
	}
	public void setIsad(int isad)
	{
		this.isad=isad;
		COLUMN_FLAG[15] = true;
	}
	public int getIsad()
	{
		return isad;
	}
	public void setSync_id(int sync_id)
	{
		this.sync_id=sync_id;
		COLUMN_FLAG[16] = true;
	}
	public int getSync_id()
	{
		return sync_id;
	}
}
