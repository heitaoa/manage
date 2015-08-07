package car_beans;
import java.util.*;

public class  DboDeaBackdayclick  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//
	private int clicktype;//
	private int deaid;//
	private int clickcount;//
	private String adddate;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setClicktype(int clicktype)
	{
		this.clicktype=clicktype;
		COLUMN_FLAG[1] = true;
	}
	public int getClicktype()
	{
		return clicktype;
	}
	public void setDeaid(int deaid)
	{
		this.deaid=deaid;
		COLUMN_FLAG[2] = true;
	}
	public int getDeaid()
	{
		return deaid;
	}
	public void setClickcount(int clickcount)
	{
		this.clickcount=clickcount;
		COLUMN_FLAG[3] = true;
	}
	public int getClickcount()
	{
		return clickcount;
	}
	public void setAdddate(String adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[4] = true;
	}
	public String getAdddate()
	{
		return adddate;
	}
}
