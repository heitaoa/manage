package car_beans;
import java.util.*;

public class  DboDeaEmployee  implements java.io.Serializable{

	public String KEY = "empid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false};
	private int empid;//企业员工自增长id
	private int eid;//所属企业id
	private int sortid;//排序id
	private String empname;//员工姓名
	private String plane;//座机号
	private String phone;//手机号
	private String duty;//职务
	private String avatar;//头像图片路径
	private Date adddate;//添加日期
	private int isdelete;//删除标识
	private int servicetype;//类型：1：售前，2：售后


	public void setEmpid(int empid)
	{
		this.empid=empid;
		COLUMN_FLAG[0] = true;
	}
	public int getEmpid()
	{
		return empid;
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
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[2] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setEmpname(String empname)
	{
		this.empname=empname;
		COLUMN_FLAG[3] = true;
	}
	public String getEmpname()
	{
		return empname;
	}
	public void setPlane(String plane)
	{
		this.plane=plane;
		COLUMN_FLAG[4] = true;
	}
	public String getPlane()
	{
		return plane;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[5] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setDuty(String duty)
	{
		this.duty=duty;
		COLUMN_FLAG[6] = true;
	}
	public String getDuty()
	{
		return duty;
	}
	public void setAvatar(String avatar)
	{
		this.avatar=avatar;
		COLUMN_FLAG[7] = true;
	}
	public String getAvatar()
	{
		return avatar;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[8] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[9] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setServicetype(int servicetype)
	{
		this.servicetype=servicetype;
		COLUMN_FLAG[10] = true;
	}
	public int getServicetype()
	{
		return servicetype;
	}
}
