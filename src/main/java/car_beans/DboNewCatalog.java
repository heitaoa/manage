package car_beans;
import java.util.*;

public class  DboNewCatalog  implements java.io.Serializable{

	public String KEY = "catalogid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int catalogid;//
	private String catalogname;//
	private int fatherid;//
	private String byname;//
	private String navname;//
	private int havedir;//
	private int classid;//
	private int isdelete;//
	private String path;//
	private String newshtml;//
	private int sortid;//
	private String lname;//
	private int pathlevel;//
	private int sub_sites_id;//属于哪个分站
	private int areaid;//所属区域


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
	public void setNavname(String navname)
	{
		this.navname=navname;
		COLUMN_FLAG[4] = true;
	}
	public String getNavname()
	{
		return navname;
	}
	public void setHavedir(int havedir)
	{
		this.havedir=havedir;
		COLUMN_FLAG[5] = true;
	}
	public int getHavedir()
	{
		return havedir;
	}
	public void setClassid(int classid)
	{
		this.classid=classid;
		COLUMN_FLAG[6] = true;
	}
	public int getClassid()
	{
		return classid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[7] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setPath(String path)
	{
		this.path=path;
		COLUMN_FLAG[8] = true;
	}
	public String getPath()
	{
		return path;
	}
	public void setNewshtml(String newshtml)
	{
		this.newshtml=newshtml;
		COLUMN_FLAG[9] = true;
	}
	public String getNewshtml()
	{
		return newshtml;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[10] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setLname(String lname)
	{
		this.lname=lname;
		COLUMN_FLAG[11] = true;
	}
	public String getLname()
	{
		return lname;
	}
	public void setPathlevel(int pathlevel)
	{
		this.pathlevel=pathlevel;
		COLUMN_FLAG[12] = true;
	}
	public int getPathlevel()
	{
		return pathlevel;
	}
	public void setSub_sites_id(int sub_sites_id)
	{
		this.sub_sites_id=sub_sites_id;
		COLUMN_FLAG[13] = true;
	}
	public int getSub_sites_id()
	{
		return sub_sites_id;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[14] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
}
