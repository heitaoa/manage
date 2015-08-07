package car_beans;
import java.util.*;

public class  TbCarProp  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int catalogid;//
	private String catalogname;//
	private String iway;//
	private int isdelete;//
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
	public void setIway(String iway)
	{
		this.iway=iway;
		COLUMN_FLAG[2] = true;
	}
	public String getIway()
	{
		return iway;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[3] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setPathlevel(int pathlevel)
	{
		this.pathlevel=pathlevel;
		COLUMN_FLAG[4] = true;
	}
	public int getPathlevel()
	{
		return pathlevel;
	}
}
