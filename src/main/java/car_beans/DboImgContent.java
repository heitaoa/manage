package car_beans;
import java.util.*;

public class  DboImgContent  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//自动增长id
	private int titleid;//图片主题id
	private String title;//小标题
	private String keywords;//关键字
	private String path;//保存路径
	private Date adddate;//添加时间
	private Date lastupdate;//最后修改时间
	private int sortid;//排序
	private int isdelete;//0正常
	private int contentpage;//
	private long serialtype;//
	private long totopdate;//
	private int catalogid;//
	private int type;//
	private int backcatalogid;//
	private String comefrom;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setTitleid(int titleid)
	{
		this.titleid=titleid;
		COLUMN_FLAG[1] = true;
	}
	public int getTitleid()
	{
		return titleid;
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
	public void setKeywords(String keywords)
	{
		this.keywords=keywords;
		COLUMN_FLAG[3] = true;
	}
	public String getKeywords()
	{
		return keywords;
	}
	public void setPath(String path)
	{
		this.path=path;
		COLUMN_FLAG[4] = true;
	}
	public String getPath()
	{
		return path;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[5] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[6] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[7] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[8] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setContentpage(int contentpage)
	{
		this.contentpage=contentpage;
		COLUMN_FLAG[9] = true;
	}
	public int getContentpage()
	{
		return contentpage;
	}
	public void setSerialtype(long serialtype)
	{
		this.serialtype=serialtype;
		COLUMN_FLAG[10] = true;
	}
	public long getSerialtype()
	{
		return serialtype;
	}
	public void setTotopdate(long totopdate)
	{
		this.totopdate=totopdate;
		COLUMN_FLAG[11] = true;
	}
	public long getTotopdate()
	{
		return totopdate;
	}
	public void setCatalogid(int catalogid)
	{
		this.catalogid=catalogid;
		COLUMN_FLAG[12] = true;
	}
	public int getCatalogid()
	{
		return catalogid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[13] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setBackcatalogid(int backcatalogid)
	{
		this.backcatalogid=backcatalogid;
		COLUMN_FLAG[14] = true;
	}
	public int getBackcatalogid()
	{
		return backcatalogid;
	}
	public void setComefrom(String comefrom)
	{
		this.comefrom=comefrom;
		COLUMN_FLAG[15] = true;
	}
	public String getComefrom()
	{
		return comefrom;
	}
}
