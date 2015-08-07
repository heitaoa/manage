package car_beans;
import java.util.*;

public class  DboAreMobile  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private long mobstart;//
	private long mobend;//
	private String area1;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setMobstart(long mobstart)
	{
		this.mobstart=mobstart;
		COLUMN_FLAG[1] = true;
	}
	public long getMobstart()
	{
		return mobstart;
	}
	public void setMobend(long mobend)
	{
		this.mobend=mobend;
		COLUMN_FLAG[2] = true;
	}
	public long getMobend()
	{
		return mobend;
	}
	public void setArea1(String area1)
	{
		this.area1=area1;
		COLUMN_FLAG[3] = true;
	}
	public String getArea1()
	{
		return area1;
	}
}
