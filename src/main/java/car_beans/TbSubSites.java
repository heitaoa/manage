package car_beans;
import java.util.*;

public class  TbSubSites  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private String name;//��վ����
	private int areaid;//��վ���ڵĵ��򣬹���dbo_are_catalog.catalogid
	private String ename;

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
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[2] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
		COLUMN_FLAG[3] = true;
	}
}
