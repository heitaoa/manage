package car_beans;
import java.util.*;

public class  DboPubAdinfo  implements java.io.Serializable{

	public String KEY = "adinfoid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int adinfoid;//广告元素id
	private int adid;//广告位id
	private String adimg;//广告图片
	private long adexposure;//广告曝光
	private long adclick;//广告点击
	private String adurl;//广告链接地址
	private int isdelete;//是否删除“0”：未删除，“1”：删除
	private int isshow;//是否显示，“0”：显示，“1”：不显示
	private int isdefault;//是否是默认广告“0”：是，“1”：否
	private String adftl;//广告位模板


	public void setAdinfoid(int adinfoid)
	{
		this.adinfoid=adinfoid;
		COLUMN_FLAG[0] = true;
	}
	public int getAdinfoid()
	{
		return adinfoid;
	}
	public void setAdid(int adid)
	{
		this.adid=adid;
		COLUMN_FLAG[1] = true;
	}
	public int getAdid()
	{
		return adid;
	}
	public void setAdimg(String adimg)
	{
		this.adimg=adimg;
		COLUMN_FLAG[2] = true;
	}
	public String getAdimg()
	{
		return adimg;
	}
	public void setAdexposure(long adexposure)
	{
		this.adexposure=adexposure;
		COLUMN_FLAG[3] = true;
	}
	public long getAdexposure()
	{
		return adexposure;
	}
	public void setAdclick(long adclick)
	{
		this.adclick=adclick;
		COLUMN_FLAG[4] = true;
	}
	public long getAdclick()
	{
		return adclick;
	}
	public void setAdurl(String adurl)
	{
		this.adurl=adurl;
		COLUMN_FLAG[5] = true;
	}
	public String getAdurl()
	{
		return adurl;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[6] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setIsshow(int isshow)
	{
		this.isshow=isshow;
		COLUMN_FLAG[7] = true;
	}
	public int getIsshow()
	{
		return isshow;
	}
	public void setIsdefault(int isdefault)
	{
		this.isdefault=isdefault;
		COLUMN_FLAG[8] = true;
	}
	public int getIsdefault()
	{
		return isdefault;
	}
	public void setAdftl(String adftl)
	{
		this.adftl=adftl;
		COLUMN_FLAG[9] = true;
	}
	public String getAdftl()
	{
		return adftl;
	}
}
