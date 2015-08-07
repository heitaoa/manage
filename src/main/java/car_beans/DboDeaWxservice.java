package car_beans;
import java.util.*;

public class  DboDeaWxservice  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private String openid;//
	private int stars;//
	private String comment;//
	private Date adddate;//
	private int comtype;//
	private int placeid;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
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
	public void setOpenid(String openid)
	{
		this.openid=openid;
		COLUMN_FLAG[2] = true;
	}
	public String getOpenid()
	{
		return openid;
	}
	public void setStars(int stars)
	{
		this.stars=stars;
		COLUMN_FLAG[3] = true;
	}
	public int getStars()
	{
		return stars;
	}
	public void setComment(String comment)
	{
		this.comment=comment;
		COLUMN_FLAG[4] = true;
	}
	public String getComment()
	{
		return comment;
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
	public void setComtype(int comtype)
	{
		this.comtype=comtype;
		COLUMN_FLAG[6] = true;
	}
	public int getComtype()
	{
		return comtype;
	}
	public void setPlaceid(int placeid)
	{
		this.placeid=placeid;
		COLUMN_FLAG[7] = true;
	}
	public int getPlaceid()
	{
		return placeid;
	}
}
