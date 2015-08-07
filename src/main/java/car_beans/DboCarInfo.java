package car_beans;
import java.util.*;

public class  DboCarInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private int catalogid;//
	private String introduction;//
	private String advantage;//
	private String disadvantage;//
	private int old_catalogid;//老315车型数据


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
	public void setIntroduction(String introduction)
	{
		this.introduction=introduction;
		COLUMN_FLAG[2] = true;
	}
	public String getIntroduction()
	{
		return introduction;
	}
	public void setAdvantage(String advantage)
	{
		this.advantage=advantage;
		COLUMN_FLAG[3] = true;
	}
	public String getAdvantage()
	{
		return advantage;
	}
	public void setDisadvantage(String disadvantage)
	{
		this.disadvantage=disadvantage;
		COLUMN_FLAG[4] = true;
	}
	public String getDisadvantage()
	{
		return disadvantage;
	}
	public void setOld_catalogid(int old_catalogid)
	{
		this.old_catalogid=old_catalogid;
		COLUMN_FLAG[5] = true;
	}
	public int getOld_catalogid()
	{
		return old_catalogid;
	}
}
