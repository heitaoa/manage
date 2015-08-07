package car_beans;
import java.util.*;

public class  DboDeaPhonemanage  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private String phone;//
	private String password;//
	private String temppassword;//
	private String realname;//
	private Date adddate;//
	private int wxcode;//
	private String wxopenid;//
	private int startwork;//工作状态：1：值班；0:休息
	private int job;//工作性质：1:售前；2：售后


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[1] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[2] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPassword(String password)
	{
		this.password=password;
		COLUMN_FLAG[3] = true;
	}
	public String getPassword()
	{
		return password;
	}
	public void setTemppassword(String temppassword)
	{
		this.temppassword=temppassword;
		COLUMN_FLAG[4] = true;
	}
	public String getTemppassword()
	{
		return temppassword;
	}
	public void setRealname(String realname)
	{
		this.realname=realname;
		COLUMN_FLAG[5] = true;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[6] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setWxcode(int wxcode)
	{
		this.wxcode=wxcode;
		COLUMN_FLAG[7] = true;
	}
	public int getWxcode()
	{
		return wxcode;
	}
	public void setWxopenid(String wxopenid)
	{
		this.wxopenid=wxopenid;
		COLUMN_FLAG[8] = true;
	}
	public String getWxopenid()
	{
		return wxopenid;
	}
	public void setStartwork(int startwork)
	{
		this.startwork=startwork;
		COLUMN_FLAG[9] = true;
	}
	public int getStartwork()
	{
		return startwork;
	}
	public void setJob(int job)
	{
		this.job=job;
		COLUMN_FLAG[10] = true;
	}
	public int getJob()
	{
		return job;
	}
}
