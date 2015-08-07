package car_beans;
import java.util.*;

public class  DboImgNewcatalog  implements java.io.Serializable{

	public String KEY = "catalogid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int catalogid;//
	private String catalogname;//
	private int fatherid;//
	private String byname;//
	private String path;//
	private int isdelete;//
	private Date adddate;//
	private int sortid;//
	private String lname;//
	private int pathlevel;//


	public void setCatalogid(int catalogid)
	{
		this.catalogid=catalogid;
		COLUMN_FLAG[0] = true;
	}
	public int getCatalogid()
	{
		return catalogid;
	}
	public void setCatalogname(String catalogname)
	{
		this.catalogname=catalogname;
		COLUMN_FLAG[1] = true;
	}
	public String getCatalogname()
	{
		return catalogname;
	}
	public void setFatherid(int fatherid)
	{
		this.fatherid=fatherid;
		COLUMN_FLAG[2] = true;
	}
	public int getFatherid()
	{
		return fatherid;
	}
	public void setByname(String byname)
	{
		this.byname=byname;
		COLUMN_FLAG[3] = true;
	}
	public String getByname()
	{
		return byname;
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
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[5] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[6] = true;
	}
	public Date getAdddate()
	{
		return adddate;
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
	public void setLname(String lname)
	{
		this.lname=lname;
		COLUMN_FLAG[8] = true;
	}
	public String getLname()
	{
		return lname;
	}
	public void setPathlevel(int pathlevel)
	{
		this.pathlevel=pathlevel;
		COLUMN_FLAG[9] = true;
	}
	public int getPathlevel()
	{
		return pathlevel;
	}
}
