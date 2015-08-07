package car_beans;
import java.util.*;

public class  DboCarIway  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private int brandid;//
	private String iway;//
	private String guanurl;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setBrandid(int brandid)
	{
		this.brandid=brandid;
		COLUMN_FLAG[1] = true;
	}
	public int getBrandid()
	{
		return brandid;
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
	public void setGuanurl(String guanurl)
	{
		this.guanurl=guanurl;
		COLUMN_FLAG[3] = true;
	}
	public String getGuanurl()
	{
		return guanurl;
	}
}
