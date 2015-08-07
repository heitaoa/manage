package car_beans;
import java.util.*;

public class  DboDeaByyuyue  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private int placeid;//
	private int isdelete;//
	private int dealstate;//
	private int userid;//
	private String zhekou;//
	private String realname;//姓名
	private String phone;//
	private String carcode;//车牌号
	private Date adddate;//
	private String dealmessage;//
	private int qujian;//
	private String openid;//
	private int fromsource;//
	private String licheng;//
	private int issenior;// 默认为0，不为空


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
	public void setPlaceid(int placeid)
	{
		this.placeid=placeid;
		COLUMN_FLAG[2] = true;
	}
	public int getPlaceid()
	{
		return placeid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[3] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setDealstate(int dealstate)
	{
		this.dealstate=dealstate;
		COLUMN_FLAG[4] = true;
	}
	public int getDealstate()
	{
		return dealstate;
	}
	public void setUserid(int userid)
	{
		this.userid=userid;
		COLUMN_FLAG[5] = true;
	}
	public int getUserid()
	{
		return userid;
	}
	public void setZhekou(String zhekou)
	{
		this.zhekou=zhekou;
		COLUMN_FLAG[6] = true;
	}
	public String getZhekou()
	{
		return zhekou;
	}
	public void setRealname(String realname)
	{
		this.realname=realname;
		COLUMN_FLAG[7] = true;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[8] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setCarcode(String carcode)
	{
		this.carcode=carcode;
		COLUMN_FLAG[9] = true;
	}
	public String getCarcode()
	{
		return carcode;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[10] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setDealmessage(String dealmessage)
	{
		this.dealmessage=dealmessage;
		COLUMN_FLAG[11] = true;
	}
	public String getDealmessage()
	{
		return dealmessage;
	}
	public void setQujian(int qujian)
	{
		this.qujian=qujian;
		COLUMN_FLAG[12] = true;
	}
	public int getQujian()
	{
		return qujian;
	}
	public void setOpenid(String openid)
	{
		this.openid=openid;
		COLUMN_FLAG[13] = true;
	}
	public String getOpenid()
	{
		return openid;
	}
	public void setFromsource(int fromsource)
	{
		this.fromsource=fromsource;
		COLUMN_FLAG[14] = true;
	}
	public int getFromsource()
	{
		return fromsource;
	}
	public void setLicheng(String licheng)
	{
		this.licheng=licheng;
		COLUMN_FLAG[15] = true;
	}
	public String getLicheng()
	{
		return licheng;
	}
	public void setIssenior(int issenior)
	{
		this.issenior=issenior;
		COLUMN_FLAG[16] = true;
	}
	public int getIssenior()
	{
		return issenior;
	}
}
