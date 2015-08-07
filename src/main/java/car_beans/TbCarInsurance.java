package car_beans;
import java.util.*;

public class  TbCarInsurance  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private String city;//所在城市
	private String car_type;//品牌车型
	private String car_num;//车牌号码
	private Date insure_end_date;//保险到期时间
	private String name;//姓名
	private String tel;//联系电话
	private int status;//是否上牌  0 未上牌  1 已上牌
	private int company;//保险公司 0:中国平安 1:中国人保财险 2:太平洋保险


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCity(String city)
	{
		this.city=city;
		COLUMN_FLAG[1] = true;
	}
	public String getCity()
	{
		return city;
	}
	public void setCar_type(String car_type)
	{
		this.car_type=car_type;
		COLUMN_FLAG[2] = true;
	}
	public String getCar_type()
	{
		return car_type;
	}
	public void setCar_num(String car_num)
	{
		this.car_num=car_num;
		COLUMN_FLAG[3] = true;
	}
	public String getCar_num()
	{
		return car_num;
	}
	public void setInsure_end_date(Date insure_end_date)
	{
		this.insure_end_date=insure_end_date;
		COLUMN_FLAG[4] = true;
	}
	public Date getInsure_end_date()
	{
		return insure_end_date;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[5] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setTel(String tel)
	{
		this.tel=tel;
		COLUMN_FLAG[6] = true;
	}
	public String getTel()
	{
		return tel;
	}
	public void setStatus(int status)
	{
		this.status=status;
		COLUMN_FLAG[7] = true;
	}
	public int getStatus()
	{
		return status;
	}
	public void setCompany(int company)
	{
		this.company=company;
		COLUMN_FLAG[8] = true;
	}
	public int getCompany()
	{
		return company;
	}
}
