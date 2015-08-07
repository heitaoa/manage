package car_beans;
import java.util.*;

public class  TbCarGroupbuy  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int carid;//车型id
	private int deaid;//发布该信息的经销商id
	private String pic;//团购页面图片
	private String title;//标题
	private Date adddate;//
	private Date begdate;//
	private Date enddate;//
	private String address;//地址
	private String info;//附加信息
	private int register_num;//报名人数
	private double price;//售价
	private int active_type;//类型 0全部 1降价 2置换
	private int buy_type;//0 团购大全 1 特卖惠
	private int fatherid;//车系id
	private int isdelete;//是否被删除 0 未删除 1  已删除
	private int surplus_num;//剩余台数
	private String time_info;//时间描述信息,有则直接显示
	private String car_info;//车型描述信息，有则直接显示
	private int sites_id;//城市站id


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCarid(int carid)
	{
		this.carid=carid;
		COLUMN_FLAG[1] = true;
	}
	public int getCarid()
	{
		return carid;
	}
	public void setDeaid(int deaid)
	{
		this.deaid=deaid;
		COLUMN_FLAG[2] = true;
	}
	public int getDeaid()
	{
		return deaid;
	}
	public void setPic(String pic)
	{
		this.pic=pic;
		COLUMN_FLAG[3] = true;
	}
	public String getPic()
	{
		return pic;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[4] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[5] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setBegdate(Date begdate)
	{
		this.begdate=begdate;
		COLUMN_FLAG[6] = true;
	}
	public Date getBegdate()
	{
		return begdate;
	}
	public void setEnddate(Date enddate)
	{
		this.enddate=enddate;
		COLUMN_FLAG[7] = true;
	}
	public Date getEnddate()
	{
		return enddate;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[8] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setInfo(String info)
	{
		this.info=info;
		COLUMN_FLAG[9] = true;
	}
	public String getInfo()
	{
		return info;
	}
	public void setRegister_num(int register_num)
	{
		this.register_num=register_num;
		COLUMN_FLAG[10] = true;
	}
	public int getRegister_num()
	{
		return register_num;
	}
	public void setPrice(double price)
	{
		this.price=price;
		COLUMN_FLAG[11] = true;
	}
	public double getPrice()
	{
		return price;
	}
	public void setActive_type(int active_type)
	{
		this.active_type=active_type;
		COLUMN_FLAG[12] = true;
	}
	public int getActive_type()
	{
		return active_type;
	}
	public void setBuy_type(int buy_type)
	{
		this.buy_type=buy_type;
		COLUMN_FLAG[13] = true;
	}
	public int getBuy_type()
	{
		return buy_type;
	}
	public void setFatherid(int fatherid)
	{
		this.fatherid=fatherid;
		COLUMN_FLAG[14] = true;
	}
	public int getFatherid()
	{
		return fatherid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[15] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setSurplus_num(int surplus_num)
	{
		this.surplus_num=surplus_num;
		COLUMN_FLAG[16] = true;
	}
	public int getSurplus_num()
	{
		return surplus_num;
	}
	public void setTime_info(String time_info)
	{
		this.time_info=time_info;
		COLUMN_FLAG[17] = true;
	}
	public String getTime_info()
	{
		return time_info;
	}
	public void setCar_info(String car_info)
	{
		this.car_info=car_info;
		COLUMN_FLAG[18] = true;
	}
	public String getCar_info()
	{
		return car_info;
	}
	public void setSites_id(int sites_id)
	{
		this.sites_id=sites_id;
		COLUMN_FLAG[19] = true;
	}
	public int getSites_id()
	{
		return sites_id;
	}
}
