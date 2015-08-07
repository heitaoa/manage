package car_beans;
import java.util.*;

public class  DboDeaOrdercar  implements java.io.Serializable{

	public String KEY = "orderid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int orderid;//订单自增长id
	private int eid;//企业id
	private int carid;//车型id
	private Date orderdate;//预订日期
	private String phone;//客户手机
	private String customername;//客户姓名
	private String email;//客户联系邮箱
	private String supplement;//补充说明
	private int state;//订单状态
	private int ordertype;//订单类型，0--非法类型，1--在线订单，2--预约试驾
	private int isdelete;//删除标识
	private int areaid;//
	private String presices;//
	private int userid;//
	private int fromsource;//

	private DboCarCatalognew car;//
	public void setCar(DboCarCatalognew car)
	{
		this.car=car;
	}
	public DboCarCatalognew getCar()
	{
		return car;
	}
	private DboAreCatalog address;//
	public void setAddress(DboAreCatalog address)
	{
		this.address=address;
	}
	public DboAreCatalog getAddress()
	{
		return address;
	}

	public void setOrderid(int orderid)
	{
		this.orderid=orderid;
		COLUMN_FLAG[0] = true;
	}
	public int getOrderid()
	{
		return orderid;
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
	public void setCarid(int carid)
	{
		this.carid=carid;
		COLUMN_FLAG[2] = true;
	}
	public int getCarid()
	{
		return carid;
	}
	public void setOrderdate(Date orderdate)
	{
		this.orderdate=orderdate;
		COLUMN_FLAG[3] = true;
	}
	public Date getOrderdate()
	{
		return orderdate;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[4] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setCustomername(String customername)
	{
		this.customername=customername;
		COLUMN_FLAG[5] = true;
	}
	public String getCustomername()
	{
		return customername;
	}
	public void setEmail(String email)
	{
		this.email=email;
		COLUMN_FLAG[6] = true;
	}
	public String getEmail()
	{
		return email;
	}
	public void setSupplement(String supplement)
	{
		this.supplement=supplement;
		COLUMN_FLAG[7] = true;
	}
	public String getSupplement()
	{
		return supplement;
	}
	public void setState(int state)
	{
		this.state=state;
		COLUMN_FLAG[8] = true;
	}
	public int getState()
	{
		return state;
	}
	public void setOrdertype(int ordertype)
	{
		this.ordertype=ordertype;
		COLUMN_FLAG[9] = true;
	}
	public int getOrdertype()
	{
		return ordertype;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[10] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[11] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setPresices(String presices)
	{
		this.presices=presices;
		COLUMN_FLAG[12] = true;
	}
	public String getPresices()
	{
		return presices;
	}
	public void setUserid(int userid)
	{
		this.userid=userid;
		COLUMN_FLAG[13] = true;
	}
	public int getUserid()
	{
		return userid;
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
}
