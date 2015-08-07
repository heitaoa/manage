package car_beans;
import java.util.*;

public class  DboZhtContent  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int catalogid;//
	private String name;//
	private String content;//
	private Date adddate;//
	private int isdelete;//
	private int isshow;//
	private String titlephoto;//
	private String type;//
	private String keywords;//
	private String descstr;//
	private String addadmin;//
	private String upadmin;//
	private Date lastup;//
	private String rname;//
	private int topid;//
	private int sortid;//
	private int ishead;//
	private Date lastcommentdate;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCatalogid(int catalogid)
	{
		this.catalogid=catalogid;
		COLUMN_FLAG[1] = true;
	}
	public int getCatalogid()
	{
		return catalogid;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[2] = true;
	}
	public String getName()
	{
		return name;
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
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[4] = true;
	}
	public Date getAdddate()
	{
		return adddate;
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
	public void setIsshow(int isshow)
	{
		this.isshow=isshow;
		COLUMN_FLAG[6] = true;
	}
	public int getIsshow()
	{
		return isshow;
	}
	public void setTitlephoto(String titlephoto)
	{
		this.titlephoto=titlephoto;
		COLUMN_FLAG[7] = true;
	}
	public String getTitlephoto()
	{
		return titlephoto;
	}
	public void setType(String type)
	{
		this.type=type;
		COLUMN_FLAG[8] = true;
	}
	public String getType()
	{
		return type;
	}
	public void setKeywords(String keywords)
	{
		this.keywords=keywords;
		COLUMN_FLAG[9] = true;
	}
	public String getKeywords()
	{
		return keywords;
	}
	public void setDescstr(String descstr)
	{
		this.descstr=descstr;
		COLUMN_FLAG[10] = true;
	}
	public String getDescstr()
	{
		return descstr;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[11] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpadmin(String upadmin)
	{
		this.upadmin=upadmin;
		COLUMN_FLAG[12] = true;
	}
	public String getUpadmin()
	{
		return upadmin;
	}
	public void setLastup(Date lastup)
	{
		this.lastup=lastup;
		COLUMN_FLAG[13] = true;
	}
	public Date getLastup()
	{
		return lastup;
	}
	public void setRname(String rname)
	{
		this.rname=rname;
		COLUMN_FLAG[14] = true;
	}
	public String getRname()
	{
		return rname;
	}
	public void setTopid(int topid)
	{
		this.topid=topid;
		COLUMN_FLAG[15] = true;
	}
	public int getTopid()
	{
		return topid;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[16] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setIshead(int ishead)
	{
		this.ishead=ishead;
		COLUMN_FLAG[17] = true;
	}
	public int getIshead()
	{
		return ishead;
	}
	public void setLastcommentdate(Date lastcommentdate)
	{
		this.lastcommentdate=lastcommentdate;
		COLUMN_FLAG[18] = true;
	}
	public Date getLastcommentdate()
	{
		return lastcommentdate;
	}
}
