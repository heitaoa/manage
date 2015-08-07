package car_beans;
import java.util.*;

public class  DboImgTitle  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//自动增长id
	private int catalogid;//目录id
	private int qqcatalogid;//腾讯车型目录id
	private int type;//车型类别（0表示非车型）
	private String title;//标题
	private String keywords;//关键字
	private String addadmin;//添加操作管理员用户名
	private String updateadmin;//修改操作管理员用户名
	private String deladmin;//删除操作管理员用户名
	private Date adddate;//添加时间
	private Date lastupdate;//最后修改时间
	private int isdelete;//0正常
	private int backcatalogid;//
	private int niankuan;//
	private int pailiang;//
	private int xiangti;//
	private int biansu;//
	private String color;//


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
	public void setQqcatalogid(int qqcatalogid)
	{
		this.qqcatalogid=qqcatalogid;
		COLUMN_FLAG[2] = true;
	}
	public int getQqcatalogid()
	{
		return qqcatalogid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[3] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[4] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setKeywords(String keywords)
	{
		this.keywords=keywords;
		COLUMN_FLAG[5] = true;
	}
	public String getKeywords()
	{
		return keywords;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[6] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpdateadmin(String updateadmin)
	{
		this.updateadmin=updateadmin;
		COLUMN_FLAG[7] = true;
	}
	public String getUpdateadmin()
	{
		return updateadmin;
	}
	public void setDeladmin(String deladmin)
	{
		this.deladmin=deladmin;
		COLUMN_FLAG[8] = true;
	}
	public String getDeladmin()
	{
		return deladmin;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[9] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[10] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
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
	public void setBackcatalogid(int backcatalogid)
	{
		this.backcatalogid=backcatalogid;
		COLUMN_FLAG[12] = true;
	}
	public int getBackcatalogid()
	{
		return backcatalogid;
	}
	public void setNiankuan(int niankuan)
	{
		this.niankuan=niankuan;
		COLUMN_FLAG[13] = true;
	}
	public int getNiankuan()
	{
		return niankuan;
	}
	public void setPailiang(int pailiang)
	{
		this.pailiang=pailiang;
		COLUMN_FLAG[14] = true;
	}
	public int getPailiang()
	{
		return pailiang;
	}
	public void setXiangti(int xiangti)
	{
		this.xiangti=xiangti;
		COLUMN_FLAG[15] = true;
	}
	public int getXiangti()
	{
		return xiangti;
	}
	public void setBiansu(int biansu)
	{
		this.biansu=biansu;
		COLUMN_FLAG[16] = true;
	}
	public int getBiansu()
	{
		return biansu;
	}
	public void setColor(String color)
	{
		this.color=color;
		COLUMN_FLAG[17] = true;
	}
	public String getColor()
	{
		return color;
	}
}
