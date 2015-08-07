package car_beans;
import java.util.*;

public class  DboDeaSccommodity  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String title;//
	private String model;//型号
	private double price;//
	private int type;//0：附件；1：配件
	private String cartype;//
	private int isinstallation;//是否提供安装
	private double discount;//折扣
	private Date starttime;//
	private String discription;//
	private Date adddate;//
	private int eid;//
	private Date endtime;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[1] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setModel(String model)
	{
		this.model=model;
		COLUMN_FLAG[2] = true;
	}
	public String getModel()
	{
		return model;
	}
	public void setPrice(double price)
	{
		this.price=price;
		COLUMN_FLAG[3] = true;
	}
	public double getPrice()
	{
		return price;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[4] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setCartype(String cartype)
	{
		this.cartype=cartype;
		COLUMN_FLAG[5] = true;
	}
	public String getCartype()
	{
		return cartype;
	}
	public void setIsinstallation(int isinstallation)
	{
		this.isinstallation=isinstallation;
		COLUMN_FLAG[6] = true;
	}
	public int getIsinstallation()
	{
		return isinstallation;
	}
	public void setDiscount(double discount)
	{
		this.discount=discount;
		COLUMN_FLAG[7] = true;
	}
	public double getDiscount()
	{
		return discount;
	}
	public void setStarttime(Date starttime)
	{
		this.starttime=starttime;
		COLUMN_FLAG[8] = true;
	}
	public Date getStarttime()
	{
		return starttime;
	}
	public void setDiscription(String discription)
	{
		this.discription=discription;
		COLUMN_FLAG[9] = true;
	}
	public String getDiscription()
	{
		return discription;
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
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[11] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setEndtime(Date endtime)
	{
		this.endtime=endtime;
		COLUMN_FLAG[12] = true;
	}
	public Date getEndtime()
	{
		return endtime;
	}
}
