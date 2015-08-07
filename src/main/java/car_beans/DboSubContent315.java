package car_beans;
import java.util.*;

public class  DboSubContent315  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false};
	private int id;//
	private String pname;//
	private String place;//
	private int stype;//
	private String htmlname;//
	private int isdelete;//
	private Date lastvisittime;//


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
	public void setHtmlname(String htmlname)
	{
		this.htmlname=htmlname;
		COLUMN_FLAG[4] = true;
	}
	public String getHtmlname()
	{
		return htmlname;
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
	public void setLastvisittime(Date lastvisittime)
	{
		this.lastvisittime=lastvisittime;
		COLUMN_FLAG[6] = true;
	}
	public Date getLastvisittime()
	{
		return lastvisittime;
	}
}
