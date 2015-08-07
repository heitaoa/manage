package car_beans;
import java.util.*;

public class  DboImgNewtitle  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//自动增长id
	private int catalogid;//目录id
	private int totop;//被顶次数
	private int tosink;//被踩次数
	private Date toptime;//最后被顶时间
	private Date sinktime;//最后被踩时间
	private int contentid;//默认的图片内容id
	private int qqcatalogid;//腾讯车型目录id
	private int type;//车型类别（0表示非车型）
	private int isdelete;//0正常
	private String title;//标题
	private String keywords;//关键字
	private String addadmin;//添加操作管理员用户名
	private String updateadmin;//修改操作管理员用户名
	private String deladmin;//删除操作管理员用户名
	private Date adddate;//添加时间
	private Date lastupdate;//最后修改时间


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
	public void setTotop(int totop)
	{
		this.totop=totop;
		COLUMN_FLAG[2] = true;
	}
	public int getTotop()
	{
		return totop;
	}
	public void setTosink(int tosink)
	{
		this.tosink=tosink;
		COLUMN_FLAG[3] = true;
	}
	public int getTosink()
	{
		return tosink;
	}
	public void setToptime(Date toptime)
	{
		this.toptime=toptime;
		COLUMN_FLAG[4] = true;
	}
	public Date getToptime()
	{
		return toptime;
	}
	public void setSinktime(Date sinktime)
	{
		this.sinktime=sinktime;
		COLUMN_FLAG[5] = true;
	}
	public Date getSinktime()
	{
		return sinktime;
	}
	public void setContentid(int contentid)
	{
		this.contentid=contentid;
		COLUMN_FLAG[6] = true;
	}
	public int getContentid()
	{
		return contentid;
	}
	public void setQqcatalogid(int qqcatalogid)
	{
		this.qqcatalogid=qqcatalogid;
		COLUMN_FLAG[7] = true;
	}
	public int getQqcatalogid()
	{
		return qqcatalogid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[8] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[9] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[10] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setKeywords(String keywords)
	{
		this.keywords=keywords;
		COLUMN_FLAG[11] = true;
	}
	public String getKeywords()
	{
		return keywords;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[12] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpdateadmin(String updateadmin)
	{
		this.updateadmin=updateadmin;
		COLUMN_FLAG[13] = true;
	}
	public String getUpdateadmin()
	{
		return updateadmin;
	}
	public void setDeladmin(String deladmin)
	{
		this.deladmin=deladmin;
		COLUMN_FLAG[14] = true;
	}
	public String getDeladmin()
	{
		return deladmin;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[15] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[16] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
}
