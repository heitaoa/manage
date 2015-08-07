package car_beans;
import java.util.*;

public class  DboPubSubjectmould  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false};
	private int id;//关联id
	private int sid;//专题id
	private int mid;//模板id


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setSid(int sid)
	{
		this.sid=sid;
		COLUMN_FLAG[1] = true;
	}
	public int getSid()
	{
		return sid;
	}
	public void setMid(int mid)
	{
		this.mid=mid;
		COLUMN_FLAG[2] = true;
	}
	public int getMid()
	{
		return mid;
	}
}
