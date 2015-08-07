package car_beans;
import java.util.*;

public class  TbCarInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private String name;//姓名
	private String tel;//电话
	private String phone;//手机
	private String address;//家庭住址
	private String car_type;//车型
	private String car_num;//车牌
	private Date buy_date;//购车时间
	private String area;//区域
	private int status;//是否购车 0  1购车


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
	public void setTel(String tel)
	{
		this.tel=tel;
		COLUMN_FLAG[2] = true;
	}
	public String getTel()
	{
		return tel;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[3] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[4] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setCar_type(String car_type)
	{
		this.car_type=car_type;
		COLUMN_FLAG[5] = true;
	}
	public String getCar_type()
	{
		return car_type;
	}
	public void setCar_num(String car_num)
	{
		this.car_num=car_num;
		COLUMN_FLAG[6] = true;
	}
	public String getCar_num()
	{
		return car_num;
	}
	public void setBuy_date(Date buy_date)
	{
		this.buy_date=buy_date;
		COLUMN_FLAG[7] = true;
	}
	public Date getBuy_date()
	{
		return buy_date;
	}
	public void setArea(String area)
	{
		this.area=area;
		COLUMN_FLAG[8] = true;
	}
	public String getArea()
	{
		return area;
	}
	public void setStatus(int status)
	{
		this.status=status;
		COLUMN_FLAG[9] = true;
	}
	public int getStatus()
	{
		return status;
	}
}
