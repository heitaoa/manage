package car_beans;
import java.util.*;

public class  DboDeaPrizeinfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private int aid;//
	private String name;//奖品名称
	private int count;//数量
	private String url;//
	private double chance;//概率


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setAid(int aid)
	{
		this.aid=aid;
		COLUMN_FLAG[1] = true;
	}
	public int getAid()
	{
		return aid;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[2] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setCount(int count)
	{
		this.count=count;
		COLUMN_FLAG[3] = true;
	}
	public int getCount()
	{
		return count;
	}
	public void setUrl(String url)
	{
		this.url=url;
		COLUMN_FLAG[4] = true;
	}
	public String getUrl()
	{
		return url;
	}
	public void setChance(double chance)
	{
		this.chance=chance;
		COLUMN_FLAG[5] = true;
	}
	public double getChance()
	{
		return chance;
	}
}
