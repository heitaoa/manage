package car_beans;
import java.util.*;

public class  DboDeaSmsnotice  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//
	private String name;//
	private int eid;//
	private Date adddate;//
	private int isdelete;//
	private String number;//
	private int type;//1�ֻ����� 2qq�� 3������ 4���䣨typeΪ1�Ķ��Ǿ��������õĶ������Ѻ��룩
	private int yewu;//1������ܵ������߶���ԤԼ�Լݡ��Ķ��ŵ�֪ͨ��2����ԤԼ�������Ķ���֪ͨ


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
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[2] = true;
	}
	public int getEid()
	{
		return eid;
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
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setNumber(String number)
	{
		this.number=number;
		COLUMN_FLAG[5] = true;
	}
	public String getNumber()
	{
		return number;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[6] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setYewu(int yewu)
	{
		this.yewu=yewu;
		COLUMN_FLAG[7] = true;
	}
	public int getYewu()
	{
		return yewu;
	}
}
