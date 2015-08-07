package car_beans;
import java.util.*;

public class  TbDataBaominglog  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int baomingid;//报名id
	private String userid;//工号
	private String username;//姓名
	private String operate_content;//操作内容
	private Date operate_time;//操作时间
	private String operate_state;//操作步骤
	private int return_visit_state;//回访状态 0-未回访 1-一呼 2-二呼 3-三呼 4- 其他
	private int phoneerror;//电话能否接通  0-已接通 1-未接通
	private int constacterror;//0-已沟通 1-未沟通


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setBaomingid(int baomingid)
	{
		this.baomingid=baomingid;
		COLUMN_FLAG[1] = true;
	}
	public int getBaomingid()
	{
		return baomingid;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[2] = true;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[3] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setOperate_content(String operate_content)
	{
		this.operate_content=operate_content;
		COLUMN_FLAG[4] = true;
	}
	public String getOperate_content()
	{
		return operate_content;
	}
	public void setOperate_time(Date operate_time)
	{
		this.operate_time=operate_time;
		COLUMN_FLAG[5] = true;
	}
	public Date getOperate_time()
	{
		return operate_time;
	}
	public void setOperate_state(String operate_state)
	{
		this.operate_state=operate_state;
		COLUMN_FLAG[6] = true;
	}
	public String getOperate_state()
	{
		return operate_state;
	}
	public void setReturn_visit_state(int return_visit_state)
	{
		this.return_visit_state=return_visit_state;
		COLUMN_FLAG[7] = true;
	}
	public int getReturn_visit_state()
	{
		return return_visit_state;
	}
	public void setPhoneerror(int phoneerror)
	{
		this.phoneerror=phoneerror;
		COLUMN_FLAG[8] = true;
	}
	public int getPhoneerror()
	{
		return phoneerror;
	}
	public void setConstacterror(int constacterror)
	{
		this.constacterror=constacterror;
		COLUMN_FLAG[9] = true;
	}
	public int getConstacterror()
	{
		return constacterror;
	}
}
