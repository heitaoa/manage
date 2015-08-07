package car_beans;
import java.util.*;

public class  DboCarSerialpeizhides  implements java.io.Serializable{

	public String KEY = "serialid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int serialid;//
	private String link1;//
	private String link2;//
	private String link3;//
	private String link4;//
	private String link5;//
	private Date adddate;//
	private Date updatetime;//
	private int isdelete;//


	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[0] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
	public void setLink1(String link1)
	{
		this.link1=link1;
		COLUMN_FLAG[1] = true;
	}
	public String getLink1()
	{
		return link1;
	}
	public void setLink2(String link2)
	{
		this.link2=link2;
		COLUMN_FLAG[2] = true;
	}
	public String getLink2()
	{
		return link2;
	}
	public void setLink3(String link3)
	{
		this.link3=link3;
		COLUMN_FLAG[3] = true;
	}
	public String getLink3()
	{
		return link3;
	}
	public void setLink4(String link4)
	{
		this.link4=link4;
		COLUMN_FLAG[4] = true;
	}
	public String getLink4()
	{
		return link4;
	}
	public void setLink5(String link5)
	{
		this.link5=link5;
		COLUMN_FLAG[5] = true;
	}
	public String getLink5()
	{
		return link5;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[6] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setUpdatetime(Date updatetime)
	{
		this.updatetime=updatetime;
		COLUMN_FLAG[7] = true;
	}
	public Date getUpdatetime()
	{
		return updatetime;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[8] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
}
