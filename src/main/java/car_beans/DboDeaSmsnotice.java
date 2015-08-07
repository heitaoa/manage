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
	private int type;//1手机号码 2qq号 3旺旺号 4邮箱（type为1的都是经销商设置的短信提醒号码）
	private int yewu;//1：会接受到‘在线订单预约试驾’的短信的通知；2：‘预约保养’的短信通知


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
