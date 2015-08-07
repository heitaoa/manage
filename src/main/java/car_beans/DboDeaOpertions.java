package car_beans;
import java.util.*;

public class  DboDeaOpertions  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int id;//
	private int eid;//
	private int scores;//
	private int type;//得分缘由
	private Date adddate;//日期


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
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[3] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[4] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
}
