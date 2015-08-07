package car_beans;
import java.util.*;

public class  DboAdmUser  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//自动增长id
	private String username;//用户名
	private String password;//密码，md5加密
	private String realname;//真实姓名
	private Date adddate;//添加日期
	private Date udate;//更新日期
	private int areaid;//
	private String phone;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[1] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password=password;
		COLUMN_FLAG[2] = true;
	}
	public String getPassword()
	{
		return password;
	}
	public void setRealname(String realname)
	{
		this.realname=realname;
		COLUMN_FLAG[3] = true;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[4] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setUdate(Date udate)
	{
		this.udate=udate;
		COLUMN_FLAG[5] = true;
	}
	public Date getUdate()
	{
		return udate;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[6] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[7] = true;
	}
	public String getPhone()
	{
		return phone;
	}
}
