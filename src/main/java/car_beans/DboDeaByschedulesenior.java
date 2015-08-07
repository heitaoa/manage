package car_beans;
import java.util.*;

public class  DboDeaByschedulesenior  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private String time;//
	private Date bydate;//
	private int places;//¹¤Î»Êý
	private String zhekou;//
	private Date adddate;//
	private String note;//
	private int isdelete;//


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
	public void setTime(String time)
	{
		this.time=time;
		COLUMN_FLAG[2] = true;
	}
	public String getTime()
	{
		return time;
	}
	public void setBydate(Date bydate)
	{
		this.bydate=bydate;
		COLUMN_FLAG[3] = true;
	}
	public Date getBydate()
	{
		return bydate;
	}
	public void setPlaces(int places)
	{
		this.places=places;
		COLUMN_FLAG[4] = true;
	}
	public int getPlaces()
	{
		return places;
	}
	public void setZhekou(String zhekou)
	{
		this.zhekou=zhekou;
		COLUMN_FLAG[5] = true;
	}
	public String getZhekou()
	{
		return zhekou;
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
	public void setNote(String note)
	{
		this.note=note;
		COLUMN_FLAG[7] = true;
	}
	public String getNote()
	{
		return note;
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
