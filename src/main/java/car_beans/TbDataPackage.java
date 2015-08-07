package car_beans;
import java.util.*;

public class  TbDataPackage  implements java.io.Serializable{

	public String KEY = "package_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false};
	private int package_id;//礼包id
	private String package_name;//礼包名称
	private String package_detail;//礼包明细
	private String package_price;//礼包价值
	private Date addtime;//添加时间
	private int isdel;//是否被删除


	public void setPackage_id(int package_id)
	{
		this.package_id=package_id;
		COLUMN_FLAG[0] = true;
	}
	public int getPackage_id()
	{
		return package_id;
	}
	public void setPackage_name(String package_name)
	{
		this.package_name=package_name;
		COLUMN_FLAG[1] = true;
	}
	public String getPackage_name()
	{
		return package_name;
	}
	public void setPackage_detail(String package_detail)
	{
		this.package_detail=package_detail;
		COLUMN_FLAG[2] = true;
	}
	public String getPackage_detail()
	{
		return package_detail;
	}
	public void setPackage_price(String package_price)
	{
		this.package_price=package_price;
		COLUMN_FLAG[3] = true;
	}
	public String getPackage_price()
	{
		return package_price;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[4] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setIsdel(int isdel)
	{
		this.isdel=isdel;
		COLUMN_FLAG[5] = true;
	}
	public int getIsdel()
	{
		return isdel;
	}
}
