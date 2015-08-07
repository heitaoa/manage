package car_beans;
import java.util.*;

public class  DboDeaWxershouche  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int eid;//
	private int modelid;//车系
	private int carid;//车型
	private String willprice;//
	private String land;//
	private int color;//
	private String sptime;//
	private String nexttime;//
	private String czname;//
	private String czphone;//
	private String czwant;//
	private Date addtime;//
	private int isdone;//是否已处理
	private String cartype;//


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
	public void setModelid(int modelid)
	{
		this.modelid=modelid;
		COLUMN_FLAG[2] = true;
	}
	public int getModelid()
	{
		return modelid;
	}
	public void setCarid(int carid)
	{
		this.carid=carid;
		COLUMN_FLAG[3] = true;
	}
	public int getCarid()
	{
		return carid;
	}
	public void setWillprice(String willprice)
	{
		this.willprice=willprice;
		COLUMN_FLAG[4] = true;
	}
	public String getWillprice()
	{
		return willprice;
	}
	public void setLand(String land)
	{
		this.land=land;
		COLUMN_FLAG[5] = true;
	}
	public String getLand()
	{
		return land;
	}
	public void setColor(int color)
	{
		this.color=color;
		COLUMN_FLAG[6] = true;
	}
	public int getColor()
	{
		return color;
	}
	public void setSptime(String sptime)
	{
		this.sptime=sptime;
		COLUMN_FLAG[7] = true;
	}
	public String getSptime()
	{
		return sptime;
	}
	public void setNexttime(String nexttime)
	{
		this.nexttime=nexttime;
		COLUMN_FLAG[8] = true;
	}
	public String getNexttime()
	{
		return nexttime;
	}
	public void setCzname(String czname)
	{
		this.czname=czname;
		COLUMN_FLAG[9] = true;
	}
	public String getCzname()
	{
		return czname;
	}
	public void setCzphone(String czphone)
	{
		this.czphone=czphone;
		COLUMN_FLAG[10] = true;
	}
	public String getCzphone()
	{
		return czphone;
	}
	public void setCzwant(String czwant)
	{
		this.czwant=czwant;
		COLUMN_FLAG[11] = true;
	}
	public String getCzwant()
	{
		return czwant;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[12] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setIsdone(int isdone)
	{
		this.isdone=isdone;
		COLUMN_FLAG[13] = true;
	}
	public int getIsdone()
	{
		return isdone;
	}
	public void setCartype(String cartype)
	{
		this.cartype=cartype;
		COLUMN_FLAG[14] = true;
	}
	public String getCartype()
	{
		return cartype;
	}
}
