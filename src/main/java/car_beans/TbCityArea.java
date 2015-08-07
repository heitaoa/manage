package car_beans;
import java.util.*;

public class  TbCityArea  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//自增id
	private int city;//cityid
	private String area;//城市下面所属区域


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[1] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setArea(String area)
	{
		this.area=area;
		COLUMN_FLAG[2] = true;
	}
	public String getArea()
	{
		return area;
	}
}
