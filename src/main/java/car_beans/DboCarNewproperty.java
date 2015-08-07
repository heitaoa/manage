package car_beans;
import java.util.*;

public class  DboCarNewproperty  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int id;//
	private String type;//
	private String name;//
	private int sort;//
	private int level;//
	private String explain;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setType(String type)
	{
		this.type=type;
		COLUMN_FLAG[1] = true;
	}
	public String getType()
	{
		return type;
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
	public void setSort(int sort)
	{
		this.sort=sort;
		COLUMN_FLAG[3] = true;
	}
	public int getSort()
	{
		return sort;
	}
	public void setLevel(int level)
	{
		this.level=level;
		COLUMN_FLAG[4] = true;
	}
	public int getLevel()
	{
		return level;
	}
	public void setExplain(String explain)
	{
		this.explain=explain;
		COLUMN_FLAG[5] = true;
	}
	public String getExplain()
	{
		return explain;
	}
}
