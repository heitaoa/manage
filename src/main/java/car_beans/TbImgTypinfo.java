package car_beans;
import java.util.*;

public class  TbImgTypinfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//
	private String name;//
	private int type;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[1] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[2] = true;
	}
	public int getType()
	{
		return type;
	}
}
