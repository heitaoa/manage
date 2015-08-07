package car_beans;
import java.util.*;

public class  DboPubIpdata  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//
	private long ipnumstart;//
	private long ipnumend;//
	private int areaid;//
	private String startip;//
	private String endip;//
	private String areainfo;//
	private int haschecked;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setIpnumstart(long ipnumstart)
	{
		this.ipnumstart=ipnumstart;
		COLUMN_FLAG[1] = true;
	}
	public long getIpnumstart()
	{
		return ipnumstart;
	}
	public void setIpnumend(long ipnumend)
	{
		this.ipnumend=ipnumend;
		COLUMN_FLAG[2] = true;
	}
	public long getIpnumend()
	{
		return ipnumend;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[3] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setStartip(String startip)
	{
		this.startip=startip;
		COLUMN_FLAG[4] = true;
	}
	public String getStartip()
	{
		return startip;
	}
	public void setEndip(String endip)
	{
		this.endip=endip;
		COLUMN_FLAG[5] = true;
	}
	public String getEndip()
	{
		return endip;
	}
	public void setAreainfo(String areainfo)
	{
		this.areainfo=areainfo;
		COLUMN_FLAG[6] = true;
	}
	public String getAreainfo()
	{
		return areainfo;
	}
	public void setHaschecked(int haschecked)
	{
		this.haschecked=haschecked;
		COLUMN_FLAG[7] = true;
	}
	public int getHaschecked()
	{
		return haschecked;
	}
}
