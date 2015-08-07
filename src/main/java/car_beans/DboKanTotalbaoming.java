package car_beans;
import java.util.*;

public class  DboKanTotalbaoming  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String activetype;//
	private String sex;//
	private String hasbuy;//
	private String paymonth;//
	private String phonearea;//
	private String area;//
	private String buytimeinmind;//
	private String birthday;//
	private String phone;//
	private String username;//
	private String carinmind;//
	private String comefrominfo;//
	private String address;//
	private String followlog;//
	private Date baomingdate;//
	private int isdelete;//
	private int state;//
	private int areaid;//
	private int brandid;//
	private String buymodel;//
	private int serialid;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setActivetype(String activetype)
	{
		this.activetype=activetype;
		COLUMN_FLAG[1] = true;
	}
	public String getActivetype()
	{
		return activetype;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
		COLUMN_FLAG[2] = true;
	}
	public String getSex()
	{
		return sex;
	}
	public void setHasbuy(String hasbuy)
	{
		this.hasbuy=hasbuy;
		COLUMN_FLAG[3] = true;
	}
	public String getHasbuy()
	{
		return hasbuy;
	}
	public void setPaymonth(String paymonth)
	{
		this.paymonth=paymonth;
		COLUMN_FLAG[4] = true;
	}
	public String getPaymonth()
	{
		return paymonth;
	}
	public void setPhonearea(String phonearea)
	{
		this.phonearea=phonearea;
		COLUMN_FLAG[5] = true;
	}
	public String getPhonearea()
	{
		return phonearea;
	}
	public void setArea(String area)
	{
		this.area=area;
		COLUMN_FLAG[6] = true;
	}
	public String getArea()
	{
		return area;
	}
	public void setBuytimeinmind(String buytimeinmind)
	{
		this.buytimeinmind=buytimeinmind;
		COLUMN_FLAG[7] = true;
	}
	public String getBuytimeinmind()
	{
		return buytimeinmind;
	}
	public void setBirthday(String birthday)
	{
		this.birthday=birthday;
		COLUMN_FLAG[8] = true;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[9] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setUsername(String username)
	{
		this.username=username;
		COLUMN_FLAG[10] = true;
	}
	public String getUsername()
	{
		return username;
	}
	public void setCarinmind(String carinmind)
	{
		this.carinmind=carinmind;
		COLUMN_FLAG[11] = true;
	}
	public String getCarinmind()
	{
		return carinmind;
	}
	public void setComefrominfo(String comefrominfo)
	{
		this.comefrominfo=comefrominfo;
		COLUMN_FLAG[12] = true;
	}
	public String getComefrominfo()
	{
		return comefrominfo;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[13] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setFollowlog(String followlog)
	{
		this.followlog=followlog;
		COLUMN_FLAG[14] = true;
	}
	public String getFollowlog()
	{
		return followlog;
	}
	public void setBaomingdate(Date baomingdate)
	{
		this.baomingdate=baomingdate;
		COLUMN_FLAG[15] = true;
	}
	public Date getBaomingdate()
	{
		return baomingdate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[16] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setState(int state)
	{
		this.state=state;
		COLUMN_FLAG[17] = true;
	}
	public int getState()
	{
		return state;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[18] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setBrandid(int brandid)
	{
		this.brandid=brandid;
		COLUMN_FLAG[19] = true;
	}
	public int getBrandid()
	{
		return brandid;
	}
	public void setBuymodel(String buymodel)
	{
		this.buymodel=buymodel;
		COLUMN_FLAG[20] = true;
	}
	public String getBuymodel()
	{
		return buymodel;
	}
	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[21] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
}
