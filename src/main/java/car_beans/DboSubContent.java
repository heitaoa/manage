package car_beans;
import java.util.*;

public class  DboSubContent  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String pname;//
	private String place;//
	private int stype;//#类型：1|页面模块；2|专题模块；3|wap；4|315；5|315wap
	private int htmltype;//生成文件类型：1|html；2|js；
	private String htmlname;//
	private int isdelete;//
	private Date lastvisittime;//
	private String desc;//给编辑看的注释
	private int parent_id;//父id（0|首页）
	private String templatename;//
	private int sub_sites_id;//属于哪个分站
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
	public void setPname(String pname)
	{
		this.pname=pname;
		COLUMN_FLAG[1] = true;
	}
	public String getPname()
	{
		return pname;
	}
	public void setPlace(String place)
	{
		this.place=place;
		COLUMN_FLAG[2] = true;
	}
	public String getPlace()
	{
		return place;
	}
	public void setStype(int stype)
	{
		this.stype=stype;
		COLUMN_FLAG[3] = true;
	}
	public int getStype()
	{
		return stype;
	}
	public void setHtmltype(int htmltype)
	{
		this.htmltype=htmltype;
		COLUMN_FLAG[4] = true;
	}
	public int getHtmltype()
	{
		return htmltype;
	}
	public void setHtmlname(String htmlname)
	{
		this.htmlname=htmlname;
		COLUMN_FLAG[5] = true;
	}
	public String getHtmlname()
	{
		return htmlname;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[6] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setLastvisittime(Date lastvisittime)
	{
		this.lastvisittime=lastvisittime;
		COLUMN_FLAG[7] = true;
	}
	public Date getLastvisittime()
	{
		return lastvisittime;
	}
	public void setDesc(String desc)
	{
		this.desc=desc;
		COLUMN_FLAG[8] = true;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setParent_id(int parent_id)
	{
		this.parent_id=parent_id;
		COLUMN_FLAG[9] = true;
	}
	public int getParent_id()
	{
		return parent_id;
	}
	public void setTemplatename(String templatename)
	{
		this.templatename=templatename;
		COLUMN_FLAG[10] = true;
	}
	public String getTemplatename()
	{
		return templatename;
	}
	public void setSub_sites_id(int sub_sites_id)
	{
		this.sub_sites_id=sub_sites_id;
		COLUMN_FLAG[11] = true;
	}
	public int getSub_sites_id()
	{
		return sub_sites_id;
	}
	public void setSync_id(int sync_id)
	{
		this.sync_id=sync_id;
		COLUMN_FLAG[12] = true;
	}
	public int getSync_id()
	{
		return sync_id;
	}
}
