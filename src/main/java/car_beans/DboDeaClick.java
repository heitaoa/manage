package car_beans;
import java.util.*;

public class  DboDeaClick  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//
	private int clicktype;//
	private int deaid;//
	private Date adddate;//
	private int clickcount;//


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
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[3] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setClickcount(int clickcount)
	{
		this.clickcount=clickcount;
		COLUMN_FLAG[4] = true;
	}
	public int getClickcount()
	{
		return clickcount;
	}
}
