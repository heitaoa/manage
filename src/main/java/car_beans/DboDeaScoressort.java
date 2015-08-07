package car_beans;
import java.util.*;

public class  DboDeaScoressort  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private int scores;//活跃度值
	private String datestr;//
	private Date sdate;//
	private Date edate;//
	private int brandsort;//同品牌排名
	private int areasort;//同地区排名
	private int brandandareasort;//本地区同品牌排名
	private int sortid;//


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
	public void setScores(int scores)
	{
		this.scores=scores;
		COLUMN_FLAG[2] = true;
	}
	public int getScores()
	{
		return scores;
	}
	public void setDatestr(String datestr)
	{
		this.datestr=datestr;
		COLUMN_FLAG[3] = true;
	}
	public String getDatestr()
	{
		return datestr;
	}
	public void setSdate(Date sdate)
	{
		this.sdate=sdate;
		COLUMN_FLAG[4] = true;
	}
	public Date getSdate()
	{
		return sdate;
	}
	public void setEdate(Date edate)
	{
		this.edate=edate;
		COLUMN_FLAG[5] = true;
	}
	public Date getEdate()
	{
		return edate;
	}
	public void setBrandsort(int brandsort)
	{
		this.brandsort=brandsort;
		COLUMN_FLAG[6] = true;
	}
	public int getBrandsort()
	{
		return brandsort;
	}
	public void setAreasort(int areasort)
	{
		this.areasort=areasort;
		COLUMN_FLAG[7] = true;
	}
	public int getAreasort()
	{
		return areasort;
	}
	public void setBrandandareasort(int brandandareasort)
	{
		this.brandandareasort=brandandareasort;
		COLUMN_FLAG[8] = true;
	}
	public int getBrandandareasort()
	{
		return brandandareasort;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[9] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
}
