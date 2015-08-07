package car_beans;
import java.util.*;

public class  TbDictPhone  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private int phone_num;//
	private String prov;//Ê¡
	private String city;//ÊÐ
	private String source;//
	private String code;//ÇøºÅ
	private String zip;//ÓÊ±à
	private int provid;//
	private int cityid;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setPhone_num(int phone_num)
	{
		this.phone_num=phone_num;
		COLUMN_FLAG[1] = true;
	}
	public int getPhone_num()
	{
		return phone_num;
	}
	public void setProv(String prov)
	{
		this.prov=prov;
		COLUMN_FLAG[2] = true;
	}
	public String getProv()
	{
		return prov;
	}
	public void setCity(String city)
	{
		this.city=city;
		COLUMN_FLAG[3] = true;
	}
	public String getCity()
	{
		return city;
	}
	public void setSource(String source)
	{
		this.source=source;
		COLUMN_FLAG[4] = true;
	}
	public String getSource()
	{
		return source;
	}
	public void setCode(String code)
	{
		this.code=code;
		COLUMN_FLAG[5] = true;
	}
	public String getCode()
	{
		return code;
	}
	public void setZip(String zip)
	{
		this.zip=zip;
		COLUMN_FLAG[6] = true;
	}
	public String getZip()
	{
		return zip;
	}
	public void setProvid(int provid)
	{
		this.provid=provid;
		COLUMN_FLAG[7] = true;
	}
	public int getProvid()
	{
		return provid;
	}
	public void setCityid(int cityid)
	{
		this.cityid=cityid;
		COLUMN_FLAG[8] = true;
	}
	public int getCityid()
	{
		return cityid;
	}
}
